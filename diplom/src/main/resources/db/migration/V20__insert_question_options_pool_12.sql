-- Вставка вариантов ответов для вопросов пула 12 (Средневековье)

-- Варианты для вопроса 1: В каком веке началось Средневековье?
INSERT INTO question_options (question_id, option_text, is_correct, option_letter) VALUES
((SELECT id FROM questions WHERE question_text = 'В каком веке началось Средневековье?' AND pool_id = 12), 'V', true, 'A'),
((SELECT id FROM questions WHERE question_text = 'В каком веке началось Средневековье?' AND pool_id = 12), 'IV', false, 'B'),
((SELECT id FROM questions WHERE question_text = 'В каком веке началось Средневековье?' AND pool_id = 12), 'VI', false, 'C'),
((SELECT id FROM questions WHERE question_text = 'В каком веке началось Средневековье?' AND pool_id = 12), 'III', false, 'D');

-- Варианты для вопроса 2: Кто возглавлял Первый крестовый поход?
INSERT INTO question_options (question_id, option_text, is_correct, option_letter) VALUES
((SELECT id FROM questions WHERE question_text = 'Кто возглавлял Первый крестовый поход?' AND pool_id = 12), 'Готфрид Бульонский', true, 'A'),
((SELECT id FROM questions WHERE question_text = 'Кто возглавлял Первый крестовый поход?' AND pool_id = 12), 'Ричард Львиное Сердце', false, 'B'),
((SELECT id FROM questions WHERE question_text = 'Кто возглавлял Первый крестовый поход?' AND pool_id = 12), 'Саладин', false, 'C'),
((SELECT id FROM questions WHERE question_text = 'Кто возглавлял Первый крестовый поход?' AND pool_id = 12), 'Филипп II Август', false, 'D');

-- Варианты для вопроса 3: Что такое феодализм?
INSERT INTO question_options (question_id, option_text, is_correct, option_letter) VALUES
((SELECT id FROM questions WHERE question_text = 'Что такое феодализм?' AND pool_id = 12), 'Система вассальных отношений', true, 'A'),
((SELECT id FROM questions WHERE question_text = 'Что такое феодализм?' AND pool_id = 12), 'Форма правления', false, 'B'),
((SELECT id FROM questions WHERE question_text = 'Что такое феодализм?' AND pool_id = 12), 'Экономическая система', false, 'C'),
((SELECT id FROM questions WHERE question_text = 'Что такое феодализм?' AND pool_id = 12), 'Военная тактика', false, 'D');

-- Варианты для вопроса 4: В каком году произошла битва при Гастингсе?
INSERT INTO question_options (question_id, option_text, is_correct, option_letter) VALUES
((SELECT id FROM questions WHERE question_text = 'В каком году произошла битва при Гастингсе?' AND pool_id = 12), '1066', true, 'A'),
((SELECT id FROM questions WHERE question_text = 'В каком году произошла битва при Гастингсе?' AND pool_id = 12), '1067', false, 'B'),
((SELECT id FROM questions WHERE question_text = 'В каком году произошла битва при Гастингсе?' AND pool_id = 12), '1065', false, 'C'),
((SELECT id FROM questions WHERE question_text = 'В каком году произошла битва при Гастингсе?' AND pool_id = 12), '1068', false, 'D');

-- Варианты для вопроса 5: Кто написал "Божественную комедию"?
INSERT INTO question_options (question_id, option_text, is_correct, option_letter) VALUES
((SELECT id FROM questions WHERE question_text = 'Кто написал "Божественную комедию"?' AND pool_id = 12), 'Данте Алигьери', true, 'A'),
((SELECT id FROM questions WHERE question_text = 'Кто написал "Божественную комедию"?' AND pool_id = 12), 'Франческо Петрарка', false, 'B'),
((SELECT id FROM questions WHERE question_text = 'Кто написал "Божественную комедию"?' AND pool_id = 12), 'Джованни Боккаччо', false, 'C'),
((SELECT id FROM questions WHERE question_text = 'Кто написал "Божественную комедию"?' AND pool_id = 12), 'Франческо Петрарка', false, 'D');

-- Варианты для вопроса 6: Что такое инквизиция?
INSERT INTO question_options (question_id, option_text, is_correct, option_letter) VALUES
((SELECT id FROM questions WHERE question_text = 'Что такое инквизиция?' AND pool_id = 12), 'Судебное преследование еретиков', true, 'A'),
((SELECT id FROM questions WHERE question_text = 'Что такое инквизиция?' AND pool_id = 12), 'Военный орден', false, 'B'),
((SELECT id FROM questions WHERE question_text = 'Что такое инквизиция?' AND pool_id = 12), 'Философская школа', false, 'C'),
((SELECT id FROM questions WHERE question_text = 'Что такое инквизиция?' AND pool_id = 12), 'Медицинская практика', false, 'D');

-- Варианты для вопроса 7: В каком году была подписана Великая хартия вольностей?
INSERT INTO question_options (question_id, option_text, is_correct, option_letter) VALUES
((SELECT id FROM questions WHERE question_text = 'В каком году была подписана Великая хартия вольностей?' AND pool_id = 12), '1215', true, 'A'),
((SELECT id FROM questions WHERE question_text = 'В каком году была подписана Великая хартия вольностей?' AND pool_id = 12), '1216', false, 'B'),
((SELECT id FROM questions WHERE question_text = 'В каком году была подписана Великая хартия вольностей?' AND pool_id = 12), '1214', false, 'C'),
((SELECT id FROM questions WHERE question_text = 'В каком году была подписана Великая хартия вольностей?' AND pool_id = 12), '1217', false, 'D');

-- Варианты для вопроса 8: Что такое цех?
INSERT INTO question_options (question_id, option_text, is_correct, option_letter) VALUES
((SELECT id FROM questions WHERE question_text = 'Что такое цех?' AND pool_id = 12), 'Объединение ремесленников', true, 'A'),
((SELECT id FROM questions WHERE question_text = 'Что такое цех?' AND pool_id = 12), 'Военная единица', false, 'B'),
((SELECT id FROM questions WHERE question_text = 'Что такое цех?' AND pool_id = 12), 'Церковная организация', false, 'C'),
((SELECT id FROM questions WHERE question_text = 'Что такое цех?' AND pool_id = 12), 'Судебный орган', false, 'D');

-- Варианты для вопроса 9: Кто был основателем Монгольской империи?
INSERT INTO question_options (question_id, option_text, is_correct, option_letter) VALUES
((SELECT id FROM questions WHERE question_text = 'Кто был основателем Монгольской империи?' AND pool_id = 12), 'Чингисхан', true, 'A'),
((SELECT id FROM questions WHERE question_text = 'Кто был основателем Монгольской империи?' AND pool_id = 12), 'Кублай', false, 'B'),
((SELECT id FROM questions WHERE question_text = 'Кто был основателем Монгольской империи?' AND pool_id = 12), 'Батый', false, 'C'),
((SELECT id FROM questions WHERE question_text = 'Кто был основателем Монгольской империи?' AND pool_id = 12), 'Мункэ', false, 'D');

-- Варианты для вопроса 10: Что такое схоластика?
INSERT INTO question_options (question_id, option_text, is_correct, option_letter) VALUES
((SELECT id FROM questions WHERE question_text = 'Что такое схоластика?' AND pool_id = 12), 'Средневековая философия', true, 'A'),
((SELECT id FROM questions WHERE question_text = 'Что такое схоластика?' AND pool_id = 12), 'Математическая дисциплина', false, 'B'),
((SELECT id FROM questions WHERE question_text = 'Что такое схоластика?' AND pool_id = 12), 'Медицинская практика', false, 'C'),
((SELECT id FROM questions WHERE question_text = 'Что такое схоластика?' AND pool_id = 12), 'Военное искусство', false, 'D');

-- Варианты для вопроса 11: Кто был королем Франции во время Столетней войны?
INSERT INTO question_options (question_id, option_text, is_correct, option_letter) VALUES
((SELECT id FROM questions WHERE question_text = 'Кто был королем Франции во время Столетней войны?' AND pool_id = 12), 'Карл VII', true, 'A'),
((SELECT id FROM questions WHERE question_text = 'Кто был королем Франции во время Столетней войны?' AND pool_id = 12), 'Филипп VI', false, 'B'),
((SELECT id FROM questions WHERE question_text = 'Кто был королем Франции во время Столетней войны?' AND pool_id = 12), 'Карл VI', false, 'C'),
((SELECT id FROM questions WHERE question_text = 'Кто был королем Франции во время Столетней войны?' AND pool_id = 12), 'Людовик XI', false, 'D');

-- Варианты для вопроса 12: Что такое Реконкиста?
INSERT INTO question_options (question_id, option_text, is_correct, option_letter) VALUES
((SELECT id FROM questions WHERE question_text = 'Что такое Реконкиста?' AND pool_id = 12), 'Отвоевание земель у мавров', true, 'A'),
((SELECT id FROM questions WHERE question_text = 'Что такое Реконкиста?' AND pool_id = 12), 'Завоевание новых земель', false, 'B'),
((SELECT id FROM questions WHERE question_text = 'Что такое Реконкиста?' AND pool_id = 12), 'Религиозная реформа', false, 'C'),
((SELECT id FROM questions WHERE question_text = 'Что такое Реконкиста?' AND pool_id = 12), 'Экономическая политика', false, 'D');

-- Варианты для вопроса 13: Кто основал династию Каролингов?
INSERT INTO question_options (question_id, option_text, is_correct, option_letter) VALUES
((SELECT id FROM questions WHERE question_text = 'Кто основал династию Каролингов?' AND pool_id = 12), 'Пипин Короткий', true, 'A'),
((SELECT id FROM questions WHERE question_text = 'Кто основал династию Каролингов?' AND pool_id = 12), 'Карл Мартелл', false, 'B'),
((SELECT id FROM questions WHERE question_text = 'Кто основал династию Каролингов?' AND pool_id = 12), 'Карл Великий', false, 'C'),
((SELECT id FROM questions WHERE question_text = 'Кто основал династию Каролингов?' AND pool_id = 12), 'Людовик Благочестивый', false, 'D');

-- Варианты для вопроса 14: Что такое Золотая Орда?
INSERT INTO question_options (question_id, option_text, is_correct, option_letter) VALUES
((SELECT id FROM questions WHERE question_text = 'Что такое Золотая Орда?' AND pool_id = 12), 'Монгольское государство', true, 'A'),
((SELECT id FROM questions WHERE question_text = 'Что такое Золотая Орда?' AND pool_id = 12), 'Торговый союз', false, 'B'),
((SELECT id FROM questions WHERE question_text = 'Что такое Золотая Орда?' AND pool_id = 12), 'Военный орден', false, 'C'),
((SELECT id FROM questions WHERE question_text = 'Что такое Золотая Орда?' AND pool_id = 12), 'Церковная организация', false, 'D');

-- Варианты для вопроса 15: Кто был последним византийским императором?
INSERT INTO question_options (question_id, option_text, is_correct, option_letter) VALUES
((SELECT id FROM questions WHERE question_text = 'Кто был последним византийским императором?' AND pool_id = 12), 'Константин XI', true, 'A'),
((SELECT id FROM questions WHERE question_text = 'Кто был последним византийским императором?' AND pool_id = 12), 'Юстиниан I', false, 'B'),
((SELECT id FROM questions WHERE question_text = 'Кто был последним византийским императором?' AND pool_id = 12), 'Василий II', false, 'C'),
((SELECT id FROM questions WHERE question_text = 'Кто был последним византийским императором?' AND pool_id = 12), 'Алексей I Комнин', false, 'D');