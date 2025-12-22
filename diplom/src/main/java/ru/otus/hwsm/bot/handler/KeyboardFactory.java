package ru.otus.hwsm.bot.handler;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardRow; // ✅ Добавляем этот импорт
import ru.otus.hwsm.entity.GameLifeline;
import ru.otus.hwsm.entity.Question;
import ru.otus.hwsm.entity.QuestionOption;

@Component
public class KeyboardFactory {

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
            Question question, List<GameLifeline.LifelineType> usedLifelines) {
        List<InlineKeyboardRow> rows = new ArrayList<>();

        // Варианты ответов (по 2 в ряд)
        List<QuestionOption> options = question.getOptions();
        for (int i = 0; i < options.size(); i += 2) {
            InlineKeyboardRow row = new InlineKeyboardRow();

            // Первая кнопка в ряду
            QuestionOption option1 = options.get(i);
            row.add(InlineKeyboardButton.builder()
                    .text(option1.getOptionLetter() + ": " + truncateText(option1.getOptionText(), 25))
                    .callbackData("answer_" + option1.getOptionLetter())
                    .build());

            // Вторая кнопка в ряду (если есть)
            if (i + 1 < options.size()) {
                QuestionOption option2 = options.get(i + 1);
                row.add(InlineKeyboardButton.builder()
                        .text(option2.getOptionLetter() + ": " + truncateText(option2.getOptionText(), 25))
                        .callbackData("answer_" + option2.getOptionLetter())
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

    public InlineKeyboardMarkup createFiftyFiftyKeyboard(List<QuestionOption> remainingOptions) {
        List<InlineKeyboardRow> rows = new ArrayList<>();

        // Показываем только оставшиеся варианты
        for (QuestionOption option : remainingOptions) {
            InlineKeyboardRow row = new InlineKeyboardRow();
            row.add(InlineKeyboardButton.builder()
                    .text(option.getOptionLetter() + ": " + option.getOptionText())
                    .callbackData("answer_" + option.getOptionLetter())
                    .build());
            rows.add(row);
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
