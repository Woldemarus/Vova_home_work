-- Скрипт инициализации базы данных с тестовыми вопросами
-- Этот скрипт выполняется автоматически при первом запуске PostgreSQL контейнера

-- Вставка тестовых вопросов для разных уровней сложности
-- Уровень 1 (100₽)
INSERT INTO questions (question_text, difficulty_level, category) VALUES 
('Какой цвет получается при смешении красного и синего?', 1, 'Общие знания'),
('Сколько дней в неделе?', 1, 'Общие знания'),
('Какое животное является символом России?', 1, 'География');

-- Варианты ответов для вопроса 1
INSERT INTO question_options (question_id, option_text, is_correct, option_letter) VALUES 
(1, 'Зеленый', false, 'A'),
(1, 'Фиолетовый', true, 'B'),
(1, 'Желтый', false, 'C'),
(1, 'Оранжевый', false, 'D');

-- Варианты ответов для вопроса 2
INSERT INTO question_options (question_id, option_text, is_correct, option_letter) VALUES 
(2, '6', false, 'A'),
(2, '7', true, 'B'),
(2, '8', false, 'C'),
(2, '5', false, 'D');

-- Варианты ответов для вопроса 3
INSERT INTO question_options (question_id, option_text, is_correct, option_letter) VALUES 
(3, 'Лев', false, 'A'),
(3, 'Медведь', true, 'B'),
(3, 'Орел', false, 'C'),
(3, 'Волк', false, 'D');

-- Уровень 2 (200₽)
INSERT INTO questions (question_text, difficulty_level, category) VALUES 
('В каком году была основана Москва?', 2, 'История'),
('Какая планета ближайшая к Солнцу?', 2, 'Астрономия');

-- Варианты ответов для вопроса 4
INSERT INTO question_options (question_id, option_text, is_correct, option_letter) VALUES 
(4, '1147', true, 'A'),
(4, '1157', false, 'B'),
(4, '1137', false, 'C'),
(4, '1167', false, 'D');

-- Варианты ответов для вопроса 5
INSERT INTO question_options (question_id, option_text, is_correct, option_letter) VALUES 
(5, 'Венера', false, 'A'),
(5, 'Меркурий', true, 'B'),
(5, 'Марс', false, 'C'),
(5, 'Земля', false, 'D');

-- Уровень 3 (300₽)
INSERT INTO questions (question_text, difficulty_level, category) VALUES 
('Кто написал роман "Война и мир"?', 3, 'Литература'),
('Какой химический элемент обозначается символом Au?', 3, 'Химия');

-- Варианты ответов для вопроса 6
INSERT INTO question_options (question_id, option_text, is_correct, option_letter) VALUES 
(6, 'Достоевский', false, 'A'),
(6, 'Толстой', true, 'B'),
(6, 'Пушкин', false, 'C'),
(6, 'Чехов', false, 'D');

-- Варианты ответов для вопроса 7
INSERT INTO question_options (question_id, option_text, is_correct, option_letter) VALUES 
(7, 'Серебро', false, 'A'),
(7, 'Золото', true, 'B'),
(7, 'Алюминий', false, 'C'),
(7, 'Медь', false, 'D');

-- Уровень 4 (500₽)
INSERT INTO questions (question_text, difficulty_level, category) VALUES 
('В каком году закончилась Вторая мировая война?', 4, 'История'),
('Какая самая длинная река в мире?', 4, 'География');

-- Варианты ответов для вопроса 8
INSERT INTO question_options (question_id, option_text, is_correct, option_letter) VALUES 
(8, '1944', false, 'A'),
(8, '1945', true, 'B'),
(8, '1946', false, 'C'),
(8, '1943', false, 'D');

-- Варианты ответов для вопроса 9
INSERT INTO question_options (question_id, option_text, is_correct, option_letter) VALUES 
(9, 'Амазонка', false, 'A'),
(9, 'Нил', true, 'B'),
(9, 'Миссисипи', false, 'C'),
(9, 'Янцзы', false, 'D');

-- Уровень 5 (1000₽) - Несгораемая сумма
INSERT INTO questions (question_text, difficulty_level, category) VALUES 
('Кто изобрел телефон?', 5, 'Наука'),
('Какая столица Австралии?', 5, 'География');

-- Варианты ответов для вопроса 10
INSERT INTO question_options (question_id, option_text, is_correct, option_letter) VALUES 
(10, 'Эдисон', false, 'A'),
(10, 'Белл', true, 'B'),
(10, 'Тесла', false, 'C'),
(10, 'Маркони', false, 'D');

-- Варианты ответов для вопроса 11
INSERT INTO question_options (question_id, option_text, is_correct, option_letter) VALUES 
(11, 'Сидней', false, 'A'),
(11, 'Канберра', true, 'B'),
(11, 'Мельбурн', false, 'C'),
(11, 'Перт', false, 'D');

-- Добавляем еще несколько вопросов для более высоких уровней
-- Уровень 10 (32000₽) - Вторая несгораемая сумма
INSERT INTO questions (question_text, difficulty_level, category) VALUES 
('В каком году была открыта структура ДНК?', 10, 'Наука');

INSERT INTO question_options (question_id, option_text, is_correct, option_letter) VALUES 
(12, '1951', false, 'A'),
(12, '1953', true, 'B'),
(12, '1955', false, 'C'),
(12, '1949', false, 'D');

-- Уровень 15 (1000000₽) - Главный приз
INSERT INTO questions (question_text, difficulty_level, category) VALUES 
('Какой элемент имеет атомный номер 79?', 15, 'Химия');

INSERT INTO question_options (question_id, option_text, is_correct, option_letter) VALUES 
(13, 'Платина', false, 'A'),
(13, 'Золото', true, 'B'),
(13, 'Серебро', false, 'C'),
(13, 'Ртуть', false, 'D');

-- Создание индексов для оптимизации (если они еще не созданы миграцией)
CREATE INDEX IF NOT EXISTS idx_questions_difficulty_category ON questions(difficulty_level, category);
CREATE INDEX IF NOT EXISTS idx_question_options_correct ON question_options(question_id, is_correct);