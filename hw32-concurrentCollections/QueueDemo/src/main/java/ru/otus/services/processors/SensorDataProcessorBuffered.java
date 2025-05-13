package ru.otus.services.processors;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.otus.api.SensorDataProcessor;
import ru.otus.api.model.SensorData;
import ru.otus.lib.SensorDataBufferedWriter;

// Этот класс нужно реализовать
@SuppressWarnings({"java:S1068", "java:S125"})
public class SensorDataProcessorBuffered implements SensorDataProcessor {
    private static final Logger log = LoggerFactory.getLogger(SensorDataProcessorBuffered.class);

    private final int bufferSize;
    private final SensorDataBufferedWriter writer;
    private final List<SensorData> dataBuffer;
    private final ReentrantLock lock;

    public SensorDataProcessorBuffered(int bufferSize, SensorDataBufferedWriter writer) {
        this.bufferSize = bufferSize;
        this.writer = writer;
        this.dataBuffer = new ArrayList<>();
        this.lock = new ReentrantLock();
    }

    @Override
    public void process(SensorData data) {
        lock.lock();
        try {
            dataBuffer.add(data);
            if (dataBuffer.size() >= bufferSize) {
                flush();
            }
        } finally {
            lock.unlock();
        }
    }

    public void flush() {
        lock.lock();
        try {
            if (dataBuffer.isEmpty()) {
                return;
            }

            List<SensorData> dataToWrite = new ArrayList<>(dataBuffer);
            Collections.sort(dataToWrite, (a, b) -> a.getMeasurementTime().compareTo(b.getMeasurementTime()));

            writer.writeBufferedData(dataToWrite);
            dataBuffer.clear();
        } catch (Exception e) {
            log.error("Ошибка в процессе записи буфера", e);
        } finally {
            lock.unlock();
        }
    }

    @Override
    public void onProcessingEnd() {
        flush();
    }
}
