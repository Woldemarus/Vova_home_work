-- Вставка вариантов ответов для вопросов пула 8 (IT и программирование)

-- Варианты для вопроса 1: Что означает HTML?
INSERT INTO question_options (question_id, option_text, is_correct, option_letter) VALUES
((SELECT id FROM questions WHERE question_text = 'Что означает HTML?' AND pool_id = 8), 'HyperText Markup Language', true, 'A'),
((SELECT id FROM questions WHERE question_text = 'Что означает HTML?' AND pool_id = 8), 'High Tech Modern Language', false, 'B'),
((SELECT id FROM questions WHERE question_text = 'Что означает HTML?' AND pool_id = 8), 'Home Tool Management Language', false, 'C'),
((SELECT id FROM questions WHERE question_text = 'Что означает HTML?' AND pool_id = 8), 'Hyperlink Text Media Language', false, 'D');

-- Варианты для вопроса 2: Кто создал язык программирования Python?
INSERT INTO question_options (question_id, option_text, is_correct, option_letter) VALUES
((SELECT id FROM questions WHERE question_text = 'Кто создал язык программирования Python?' AND pool_id = 8), 'Гвидо ван Россум', true, 'A'),
((SELECT id FROM questions WHERE question_text = 'Кто создал язык программирования Python?' AND pool_id = 8), 'Бьёрн Страуструп', false, 'B'),
((SELECT id FROM questions WHERE question_text = 'Кто создал язык программирования Python?' AND pool_id = 8), 'Джеймс Гослинг', false, 'C'),
((SELECT id FROM questions WHERE question_text = 'Кто создал язык программирования Python?' AND pool_id = 8), 'Ларри Уолл', false, 'D');

-- Варианты для вопроса 3: Что такое алгоритм?
INSERT INTO question_options (question_id, option_text, is_correct, option_letter) VALUES
((SELECT id FROM questions WHERE question_text = 'Что такое алгоритм?' AND pool_id = 8), 'Последовательность шагов для решения задачи', true, 'A'),
((SELECT id FROM questions WHERE question_text = 'Что такое алгоритм?' AND pool_id = 8), 'Язык программирования', false, 'B'),
((SELECT id FROM questions WHERE question_text = 'Что такое алгоритм?' AND pool_id = 8), 'Компьютерная программа', false, 'C'),
((SELECT id FROM questions WHERE question_text = 'Что такое алгоритм?' AND pool_id = 8), 'База данных', false, 'D');

-- Варианты для вопроса 4: В каком году был создан язык Java?
INSERT INTO question_options (question_id, option_text, is_correct, option_letter) VALUES
((SELECT id FROM questions WHERE question_text = 'В каком году был создан язык Java?' AND pool_id = 8), '1995', true, 'A'),
((SELECT id FROM questions WHERE question_text = 'В каком году был создан язык Java?' AND pool_id = 8), '1990', false, 'B'),
((SELECT id FROM questions WHERE question_text = 'В каком году был создан язык Java?' AND pool_id = 8), '2000', false, 'C'),
((SELECT id FROM questions WHERE question_text = 'В каком году был создан язык Java?' AND pool_id = 8), '1985', false, 'D');

-- Варианты для вопроса 5: Что означает SQL?
INSERT INTO question_options (question_id, option_text, is_correct, option_letter) VALUES
((SELECT id FROM questions WHERE question_text = 'Что означает SQL?' AND pool_id = 8), 'Structured Query Language', true, 'A'),
((SELECT id FROM questions WHERE question_text = 'Что означает SQL?' AND pool_id = 8), 'Simple Query Language', false, 'B'),
((SELECT id FROM questions WHERE question_text = 'Что означает SQL?' AND pool_id = 8), 'System Query Language', false, 'C'),
((SELECT id FROM questions WHERE question_text = 'Что означает SQL?' AND pool_id = 8), 'Standard Query Language', false, 'D');

-- Варианты для вопроса 6: Кто изобрел World Wide Web?
INSERT INTO question_options (question_id, option_text, is_correct, option_letter) VALUES
((SELECT id FROM questions WHERE question_text = 'Кто изобрел World Wide Web?' AND pool_id = 8), 'Тим Бернерс-Ли', true, 'A'),
((SELECT id FROM questions WHERE question_text = 'Кто изобрел World Wide Web?' AND pool_id = 8), 'Билл Гейтс', false, 'B'),
((SELECT id FROM questions WHERE question_text = 'Кто изобрел World Wide Web?' AND pool_id = 8), 'Стив Джобс', false, 'C'),
((SELECT id FROM questions WHERE question_text = 'Кто изобрел World Wide Web?' AND pool_id = 8), 'Ларри Пейдж', false, 'D');

-- Варианты для вопроса 7: Что такое объектно-ориентированное программирование?
INSERT INTO question_options (question_id, option_text, is_correct, option_letter) VALUES
((SELECT id FROM questions WHERE question_text = 'Что такое объектно-ориентированное программирование?' AND pool_id = 8), 'Программирование с использованием объектов', true, 'A'),
((SELECT id FROM questions WHERE question_text = 'Что такое объектно-ориентированное программирование?' AND pool_id = 8), 'Программирование на ассемблере', false, 'B'),
((SELECT id FROM questions WHERE question_text = 'Что такое объектно-ориентированное программирование?' AND pool_id = 8), 'Функциональное программирование', false, 'C'),
((SELECT id FROM questions WHERE question_text = 'Что такое объектно-ориентированное программирование?' AND pool_id = 8), 'Логическое программирование', false, 'D');

-- Варианты для вопроса 8: Кто создал операционную систему Linux?
INSERT INTO question_options (question_id, option_text, is_correct, option_letter) VALUES
((SELECT id FROM questions WHERE question_text = 'Кто создал операционную систему Linux?' AND pool_id = 8), 'Линус Торвальдс', true, 'A'),
((SELECT id FROM questions WHERE question_text = 'Кто создал операционную систему Linux?' AND pool_id = 8), 'Ричард Столлман', false, 'B'),
((SELECT id FROM questions WHERE question_text = 'Кто создал операционную систему Linux?' AND pool_id = 8), 'Билл Гейтс', false, 'C'),
((SELECT id FROM questions WHERE question_text = 'Кто создал операционную систему Linux?' AND pool_id = 8), 'Стив Балмер', false, 'D');

-- Варианты для вопроса 9: Что такое машинное обучение?
INSERT INTO question_options (question_id, option_text, is_correct, option_letter) VALUES
((SELECT id FROM questions WHERE question_text = 'Что такое машинное обучение?' AND pool_id = 8), 'Метод анализа данных без явного программирования', true, 'A'),
((SELECT id FROM questions WHERE question_text = 'Что такое машинное обучение?' AND pool_id = 8), 'Программирование на машинном языке', false, 'B'),
((SELECT id FROM questions WHERE question_text = 'Что такое машинное обучение?' AND pool_id = 8), 'Создание аппаратного обеспечения', false, 'C'),
((SELECT id FROM questions WHERE question_text = 'Что такое машинное обучение?' AND pool_id = 8), 'Разработка операционных систем', false, 'D');

-- Варианты для вопроса 10: Кто разработал язык C++?
INSERT INTO question_options (question_id, option_text, is_correct, option_letter) VALUES
((SELECT id FROM questions WHERE question_text = 'Кто разработал язык C++?' AND pool_id = 8), 'Бьёрн Страуструп', true, 'A'),
((SELECT id FROM questions WHERE question_text = 'Кто разработал язык C++?' AND pool_id = 8), 'Деннис Ритчи', false, 'B'),
((SELECT id FROM questions WHERE question_text = 'Кто разработал язык C++?' AND pool_id = 8), 'Кен Томпсон', false, 'C'),
((SELECT id FROM questions WHERE question_text = 'Кто разработал язык C++?' AND pool_id = 8), 'Брайан Керниган', false, 'D');

-- Варианты для вопроса 11: Что такое блокчейн?
INSERT INTO question_options (question_id, option_text, is_correct, option_letter) VALUES
((SELECT id FROM questions WHERE question_text = 'Что такое блокчейн?' AND pool_id = 8), 'Распределенная база данных транзакций', true, 'A'),
((SELECT id FROM questions WHERE question_text = 'Что такое блокчейн?' AND pool_id = 8), 'Блокировка сетевых соединений', false, 'B'),
((SELECT id FROM questions WHERE question_text = 'Что такое блокчейн?' AND pool_id = 8), 'Цепочка команд в программе', false, 'C'),
((SELECT id FROM questions WHERE question_text = 'Что такое блокчейн?' AND pool_id = 8), 'Блокировка доступа к файлам', false, 'D');

-- Варианты для вопроса 12: Кто создал алгоритм RSA?
INSERT INTO question_options (question_id, option_text, is_correct, option_letter) VALUES
((SELECT id FROM questions WHERE question_text = 'Кто создал алгоритм RSA?' AND pool_id = 8), 'Рон Ривест, Ади Шамир, Леонард Адлеман', true, 'A'),
((SELECT id FROM questions WHERE question_text = 'Кто создал алгоритм RSA?' AND pool_id = 8), 'Уитфилд Диффи и Мартин Хеллман', false, 'B'),
((SELECT id FROM questions WHERE question_text = 'Кто создал алгоритм RSA?' AND pool_id = 8), 'Брюс Шнайер', false, 'C'),
((SELECT id FROM questions WHERE question_text = 'Кто создал алгоритм RSA?' AND pool_id = 8), 'Алан Тьюринг', false, 'D');

-- Варианты для вопроса 13: Что такое квантовые вычисления?
INSERT INTO question_options (question_id, option_text, is_correct, option_letter) VALUES
((SELECT id FROM questions WHERE question_text = 'Что такое квантовые вычисления?' AND pool_id = 8), 'Вычисления с использованием квантовой механики', true, 'A'),
((SELECT id FROM questions WHERE question_text = 'Что такое квантовые вычисления?' AND pool_id = 8), 'Вычисления с плавающей точкой', false, 'B'),
((SELECT id FROM questions WHERE question_text = 'Что такое квантовые вычисления?' AND pool_id = 8), 'Параллельные вычисления', false, 'C'),
((SELECT id FROM questions WHERE question_text = 'Что такое квантовые вычисления?' AND pool_id = 8), 'Распределенные вычисления', false, 'D');

-- Варианты для вопроса 14: Кто разработал теорию сложности вычислений?
INSERT INTO question_options (question_id, option_text, is_correct, option_letter) VALUES
((SELECT id FROM questions WHERE question_text = 'Кто разработал теорию сложности вычислений?' AND pool_id = 8), 'Алан Тьюринг', true, 'A'),
((SELECT id FROM questions WHERE question_text = 'Кто разработал теорию сложности вычислений?' AND pool_id = 8), 'Джон фон Нейман', false, 'B'),
((SELECT id FROM questions WHERE question_text = 'Кто разработал теорию сложности вычислений?' AND pool_id = 8), 'Курт Гёдель', false, 'C'),
((SELECT id FROM questions WHERE question_text = 'Кто разработал теорию сложности вычислений?' AND pool_id = 8), 'Стивен Кук', false, 'D');

-- Варианты для вопроса 15: Что такое P vs NP проблема?
INSERT INTO question_options (question_id, option_text, is_correct, option_letter) VALUES
((SELECT id FROM questions WHERE question_text = 'Что такое P vs NP проблема?' AND pool_id = 8), 'Вопрос о равенстве классов сложности', true, 'A'),
((SELECT id FROM questions WHERE question_text = 'Что такое P vs NP проблема?' AND pool_id = 8), 'Проблема производительности процессоров', false, 'B'),
((SELECT id FROM questions WHERE question_text = 'Что такое P vs NP проблема?' AND pool_id = 8), 'Вопрос о параллельных вычислениях', false, 'C'),
((SELECT id FROM questions WHERE question_text = 'Что такое P vs NP проблема?' AND pool_id = 8), 'Проблема сетевой безопасности', false, 'D');