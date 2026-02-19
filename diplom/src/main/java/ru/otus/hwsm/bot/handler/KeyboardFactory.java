package ru.otus.hwsm.bot.handler;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardRow;
import ru.otus.hwsm.entity.GameLifeline;
import ru.otus.hwsm.entity.Question;
import ru.otus.hwsm.entity.QuestionOption;
import ru.otus.hwsm.service.QuestionService;

@Component
public class KeyboardFactory {

    private QuestionService questionService;

    @Autowired
    public KeyboardFactory(QuestionService questionService) {
        this.questionService = questionService;
    }

    public InlineKeyboardMarkup createBeginGameKeyBoard() {
        InlineKeyboardButton startButton = InlineKeyboardButton.builder()
                .text("🎮 Начать игру")
                .callbackData("start_new_game")
                .build();

        List<InlineKeyboardRow> rows = new ArrayList<>();
        InlineKeyboardRow row = new InlineKeyboardRow();
        row.add(startButton);
        rows.add(row);

        return InlineKeyboardMarkup.builder().keyboard(rows).build();
    }

    public InlineKeyboardMarkup createStartQuestionKeyboard() {
        InlineKeyboardButton startButton = InlineKeyboardButton.builder()
                .text("🎮 Начать")
                .callbackData("start_question")
                .build();

        List<InlineKeyboardRow> rows = new ArrayList<>();
        InlineKeyboardRow row = new InlineKeyboardRow();
        row.add(startButton);
        rows.add(row);

        return InlineKeyboardMarkup.builder().keyboard(rows).build();
    }

    public InlineKeyboardMarkup createActiveGameKeyboard() {
        List<InlineKeyboardRow> rows = new ArrayList<>(); // ✅ Изменяем тип на List<InlineKeyboardRow>

        // Первая строка - Продолжить игру
        InlineKeyboardRow row1 = new InlineKeyboardRow(); // ✅ Создаем InlineKeyboardRow
        row1.add(InlineKeyboardButton.builder()
                .text("🔄 Продолжить игру")
                .callbackData("continue_game")
                .build());
        rows.add(row1);

        // Вторая строка - Начать новую игру
        InlineKeyboardRow row2 = new InlineKeyboardRow();
        row2.add(InlineKeyboardButton.builder()
                .text("🆕 Начать новую игру")
                .callbackData("new_game")
                .build());
        rows.add(row2);

        return InlineKeyboardMarkup.builder().keyboard(rows).build();
    }

    public InlineKeyboardMarkup createQuestionKeyboard(
            Long gameId, Question question, List<GameLifeline.LifelineType> usedLifelines) {
        List<InlineKeyboardRow> rows = new ArrayList<>();

        // Получаем перемешанные варианты ответов
        List<QuestionOption> shuffledOptions = questionService.getShuffledQuestionOptions(gameId, question.getId());

        // Варианты ответов (по 2 в ряд)
        for (int i = 0; i < shuffledOptions.size(); i += 2) {
            InlineKeyboardRow row = new InlineKeyboardRow();

            // Первая кнопка в ряду
            QuestionOption option1 = shuffledOptions.get(i);
            row.add(InlineKeyboardButton.builder()
                    .text(option1.getOptionLetter() + ": " + truncateText(option1.getOptionText(), 25))
                    .callbackData("answer_" + question.getId() + "_" + option1.getId())
                    .build());

            // Вторая кнопка в ряду (если есть)
            if (i + 1 < shuffledOptions.size()) {
                QuestionOption option2 = shuffledOptions.get(i + 1);
                row.add(InlineKeyboardButton.builder()
                        .text(option2.getOptionLetter() + ": " + truncateText(option2.getOptionText(), 25))
                        .callbackData("answer_" + question.getId() + "_" + option2.getId())
                        .build());
            }

            rows.add(row);
        }

        // Подсказки
        InlineKeyboardRow lifelinesRow = new InlineKeyboardRow();

        if (!usedLifelines.contains(GameLifeline.LifelineType.FIFTY_FIFTY)) {
            lifelinesRow.add(InlineKeyboardButton.builder()
                    .text("🔄 50/50")
                    .callbackData("lifeline_fifty_fifty")
                    .build());
        }

        if (!usedLifelines.contains(GameLifeline.LifelineType.PHONE_FRIEND)) {
            lifelinesRow.add(InlineKeyboardButton.builder()
                    .text("📞 Звонок другу")
                    .callbackData("lifeline_phone_friend")
                    .build());
        }

        if (!usedLifelines.contains(GameLifeline.LifelineType.AUDIENCE_POLL)) {
            lifelinesRow.add(InlineKeyboardButton.builder()
                    .text("👥 Помощь зала")
                    .callbackData("lifeline_audience_poll")
                    .build());
        }

        if (!lifelinesRow.isEmpty()) {
            rows.add(lifelinesRow);
        }

        // Забрать деньги
        InlineKeyboardRow takeMoneyRow = new InlineKeyboardRow();
        takeMoneyRow.add(InlineKeyboardButton.builder()
                .text("💰 Забрать деньги")
                .callbackData("take_money")
                .build());
        rows.add(takeMoneyRow);

        return InlineKeyboardMarkup.builder().keyboard(rows).build();
    }

    public InlineKeyboardMarkup createStartGameKeyboard() {
        List<InlineKeyboardRow> rows = new ArrayList<>();

        InlineKeyboardRow row = new InlineKeyboardRow();
        row.add(InlineKeyboardButton.builder()
                .text("🎯 Начать")
                .callbackData("start_first_question")
                .build());
        rows.add(row);

        return InlineKeyboardMarkup.builder().keyboard(rows).build();
    }

    public InlineKeyboardMarkup createFiftyFiftyKeyboard(
            List<QuestionOption> remainingOptions, Long questionId, List<GameLifeline.LifelineType> usedLifelines) {
        List<InlineKeyboardRow> rows = new ArrayList<>();

        // Показываем только оставшиеся варианты
        for (QuestionOption option : remainingOptions) {
            InlineKeyboardRow row = new InlineKeyboardRow();
            row.add(InlineKeyboardButton.builder()
                    .text(option.getOptionLetter() + ": " + option.getOptionText())
                    .callbackData("answer_" + questionId + "_" + option.getId())
                    .build());
            rows.add(row);
        }

        // Добавляем оставшиеся подсказки
        InlineKeyboardRow lifelinesRow = new InlineKeyboardRow();

        if (!usedLifelines.contains(GameLifeline.LifelineType.PHONE_FRIEND)) {
            lifelinesRow.add(InlineKeyboardButton.builder()
                    .text("📞 Звонок другу")
                    .callbackData("lifeline_phone_friend")
                    .build());
        }

        if (!usedLifelines.contains(GameLifeline.LifelineType.AUDIENCE_POLL)) {
            lifelinesRow.add(InlineKeyboardButton.builder()
                    .text("👥 Помощь зала")
                    .callbackData("lifeline_audience_poll")
                    .build());
        }

        if (!lifelinesRow.isEmpty()) {
            rows.add(lifelinesRow);
        }

        // Забрать деньги
        InlineKeyboardRow takeMoneyRow = new InlineKeyboardRow();
        takeMoneyRow.add(InlineKeyboardButton.builder()
                .text("💰 Забрать деньги")
                .callbackData("take_money")
                .build());
        rows.add(takeMoneyRow);

        return InlineKeyboardMarkup.builder().keyboard(rows).build();
    }

    public InlineKeyboardMarkup createGameOverKeyboard() {
        List<InlineKeyboardRow> rows = new ArrayList<>();

        InlineKeyboardRow row = new InlineKeyboardRow();
        row.add(InlineKeyboardButton.builder()
                .text("🆕 Начать новую игру")
                .callbackData("new_game")
                .build());
        rows.add(row);

        return InlineKeyboardMarkup.builder().keyboard(rows).build();
    }

    private String truncateText(String text, int maxLength) {
        if (text.length() <= maxLength) {
            return text;
        }
        return text.substring(0, maxLength - 3) + "...";
    }
}
