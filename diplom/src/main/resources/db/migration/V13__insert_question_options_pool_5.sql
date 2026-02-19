-- Вставка вариантов ответов для вопросов пула 5 (Физика и химия)

-- Варианты для вопроса 1: Какой газ составляет большую часть атмосферы Земли?
INSERT INTO question_options (question_id, option_text, is_correct, option_letter) VALUES
((SELECT id FROM questions WHERE question_text = 'Какой газ составляет большую часть атмосферы Земли?' AND pool_id = 5), 'Азот', true, 'A'),
((SELECT id FROM questions WHERE question_text = 'Какой газ составляет большую часть атмосферы Земли?' AND pool_id = 5), 'Кислород', false, 'B'),
((SELECT id FROM questions WHERE question_text = 'Какой газ составляет большую часть атмосферы Земли?' AND pool_id = 5), 'Углекислый газ', false, 'C'),
((SELECT id FROM questions WHERE question_text = 'Какой газ составляет большую часть атмосферы Земли?' AND pool_id = 5), 'Аргон', false, 'D');

-- Варианты для вопроса 2: Кто открыл закон сохранения энергии?
INSERT INTO question_options (question_id, option_text, is_correct, option_letter) VALUES
((SELECT id FROM questions WHERE question_text = 'Кто открыл закон сохранения энергии?' AND pool_id = 5), 'Юлиус Майер', true, 'A'),
((SELECT id FROM questions WHERE question_text = 'Кто открыл закон сохранения энергии?' AND pool_id = 5), 'Герман Гельмгольц', false, 'B'),
((SELECT id FROM questions WHERE question_text = 'Кто открыл закон сохранения энергии?' AND pool_id = 5), 'Джеймс Джоуль', false, 'C'),
((SELECT id FROM questions WHERE question_text = 'Кто открыл закон сохранения энергии?' AND pool_id = 5), 'Сади Карно', false, 'D');

-- Варианты для вопроса 3: Какой элемент имеет символ Au?
INSERT INTO question_options (question_id, option_text, is_correct, option_letter) VALUES
((SELECT id FROM questions WHERE question_text = 'Какой элемент имеет символ Au?' AND pool_id = 5), 'Золото', true, 'A'),
((SELECT id FROM questions WHERE question_text = 'Какой элемент имеет символ Au?' AND pool_id = 5), 'Серебро', false, 'B'),
((SELECT id FROM questions WHERE question_text = 'Какой элемент имеет символ Au?' AND pool_id = 5), 'Медь', false, 'C'),
((SELECT id FROM questions WHERE question_text = 'Какой элемент имеет символ Au?' AND pool_id = 5), 'Платина', false, 'D');

-- Варианты для вопроса 4: Чему равна скорость света в вакууме?
INSERT INTO question_options (question_id, option_text, is_correct, option_letter) VALUES
((SELECT id FROM questions WHERE question_text = 'Чему равна скорость света в вакууме?' AND pool_id = 5), '299 792 458 м/с', true, 'A'),
((SELECT id FROM questions WHERE question_text = 'Чему равна скорость света в вакууме?' AND pool_id = 5), '300 000 000 м/с', false, 'B'),
((SELECT id FROM questions WHERE question_text = 'Чему равна скорость света в вакууме?' AND pool_id = 5), '299 000 000 м/с', false, 'C'),
((SELECT id FROM questions WHERE question_text = 'Чему равна скорость света в вакууме?' AND pool_id = 5), '298 000 000 м/с', false, 'D');

-- Варианты для вопроса 5: Кто создал периодическую таблицу элементов?
INSERT INTO question_options (question_id, option_text, is_correct, option_letter) VALUES
((SELECT id FROM questions WHERE question_text = 'Кто создал периодическую таблицу элементов?' AND pool_id = 5), 'Дмитрий Менделеев', true, 'A'),
((SELECT id FROM questions WHERE question_text = 'Кто создал периодическую таблицу элементов?' AND pool_id = 5), 'Лотар Мейер', false, 'B'),
((SELECT id FROM questions WHERE question_text = 'Кто создал периодическую таблицу элементов?' AND pool_id = 5), 'Джон Ньюлендс', false, 'C'),
((SELECT id FROM questions WHERE question_text = 'Кто создал периодическую таблицу элементов?' AND pool_id = 5), 'Антуан Лавуазье', false, 'D');

-- Варианты для вопроса 6: Какая частица была открыта в 2012 году в ЦЕРН?
INSERT INTO question_options (question_id, option_text, is_correct, option_letter) VALUES
((SELECT id FROM questions WHERE question_text = 'Какая частица была открыта в 2012 году в ЦЕРН?' AND pool_id = 5), 'Бозон Хиггса', true, 'A'),
((SELECT id FROM questions WHERE question_text = 'Какая частица была открыта в 2012 году в ЦЕРН?' AND pool_id = 5), 'Топ-кварк', false, 'B'),
((SELECT id FROM questions WHERE question_text = 'Какая частица была открыта в 2012 году в ЦЕРН?' AND pool_id = 5), 'Таон', false, 'C'),
((SELECT id FROM questions WHERE question_text = 'Какая частица была открыта в 2012 году в ЦЕРН?' AND pool_id = 5), 'Нейтрино', false, 'D');

-- Варианты для вопроса 7: Кто сформулировал принцип неопределенности?
INSERT INTO question_options (question_id, option_text, is_correct, option_letter) VALUES
((SELECT id FROM questions WHERE question_text = 'Кто сформулировал принцип неопределенности?' AND pool_id = 5), 'Вернер Гейзенберг', true, 'A'),
((SELECT id FROM questions WHERE question_text = 'Кто сформулировал принцип неопределенности?' AND pool_id = 5), 'Эрвин Шрёдингер', false, 'B'),
((SELECT id FROM questions WHERE question_text = 'Кто сформулировал принцип неопределенности?' AND pool_id = 5), 'Нильс Бор', false, 'C'),
((SELECT id FROM questions WHERE question_text = 'Кто сформулировал принцип неопределенности?' AND pool_id = 5), 'Макс Планк', false, 'D');

-- Варианты для вопроса 8: Какой элемент имеет наибольшую электроотрицательность?
INSERT INTO question_options (question_id, option_text, is_correct, option_letter) VALUES
((SELECT id FROM questions WHERE question_text = 'Какой элемент имеет наибольшую электроотрицательность?' AND pool_id = 5), 'Фтор', true, 'A'),
((SELECT id FROM questions WHERE question_text = 'Какой элемент имеет наибольшую электроотрицательность?' AND pool_id = 5), 'Хлор', false, 'B'),
((SELECT id FROM questions WHERE question_text = 'Какой элемент имеет наибольшую электроотрицательность?' AND pool_id = 5), 'Кислород', false, 'C'),
((SELECT id FROM questions WHERE question_text = 'Какой элемент имеет наибольшую электроотрицательность?' AND pool_id = 5), 'Азот', false, 'D');

-- Варианты для вопроса 9: Кто открыл явление фотоэффекта?
INSERT INTO question_options (question_id, option_text, is_correct, option_letter) VALUES
((SELECT id FROM questions WHERE question_text = 'Кто открыл явление фотоэффекта?' AND pool_id = 5), 'Альберт Эйнштейн', true, 'A'),
((SELECT id FROM questions WHERE question_text = 'Кто открыл явление фотоэффекта?' AND pool_id = 5), 'Генрих Герц', false, 'B'),
((SELECT id FROM questions WHERE question_text = 'Кто открыл явление фотоэффекта?' AND pool_id = 5), 'Филипп Ленард', false, 'C'),
((SELECT id FROM questions WHERE question_text = 'Кто открыл явление фотоэффекта?' AND pool_id = 5), 'Макс Планк', false, 'D');

-- Варианты для вопроса 10: Какая константа связывает энергию и массу?
INSERT INTO question_options (question_id, option_text, is_correct, option_letter) VALUES
((SELECT id FROM questions WHERE question_text = 'Какая константа связывает энергию и массу?' AND pool_id = 5), 'E = mc²', true, 'A'),
((SELECT id FROM questions WHERE question_text = 'Какая константа связывает энергию и массу?' AND pool_id = 5), 'F = ma', false, 'B'),
((SELECT id FROM questions WHERE question_text = 'Какая константа связывает энергию и массу?' AND pool_id = 5), 'PV = nRT', false, 'C'),
((SELECT id FROM questions WHERE question_text = 'Какая константа связывает энергию и массу?' AND pool_id = 5), 'c = λν', false, 'D');

-- Варианты для вопроса 11: Кто синтезировал первый полимер?
INSERT INTO question_options (question_id, option_text, is_correct, option_letter) VALUES
((SELECT id FROM questions WHERE question_text = 'Кто синтезировал первый полимер?' AND pool_id = 5), 'Герман Штаудингер', true, 'A'),
((SELECT id FROM questions WHERE question_text = 'Кто синтезировал первый полимер?' AND pool_id = 5), 'Уоллес Карозерс', false, 'B'),
((SELECT id FROM questions WHERE question_text = 'Кто синтезировал первый полимер?' AND pool_id = 5), 'Лео Бакеланд', false, 'C'),
((SELECT id FROM questions WHERE question_text = 'Кто синтезировал первый полимер?' AND pool_id = 5), 'Джон Уэсли Хайатт', false, 'D');

-- Варианты для вопроса 12: Какой тип связи самый прочный в молекуле?
INSERT INTO question_options (question_id, option_text, is_correct, option_letter) VALUES
((SELECT id FROM questions WHERE question_text = 'Какой тип связи самый прочный в молекуле?' AND pool_id = 5), 'Ковалентная', true, 'A'),
((SELECT id FROM questions WHERE question_text = 'Какой тип связи самый прочный в молекуле?' AND pool_id = 5), 'Ионная', false, 'B'),
((SELECT id FROM questions WHERE question_text = 'Какой тип связи самый прочный в молекуле?' AND pool_id = 5), 'Водородная', false, 'C'),
((SELECT id FROM questions WHERE question_text = 'Какой тип связи самый прочный в молекуле?' AND pool_id = 5), 'Ван-дер-Ваальсова', false, 'D');

-- Варианты для вопроса 13: Кто предложил волновую механику?
INSERT INTO question_options (question_id, option_text, is_correct, option_letter) VALUES
((SELECT id FROM questions WHERE question_text = 'Кто предложил волновую механику?' AND pool_id = 5), 'Эрвин Шрёдингер', true, 'A'),
((SELECT id FROM questions WHERE question_text = 'Кто предложил волновую механику?' AND pool_id = 5), 'Вернер Гейзенберг', false, 'B'),
((SELECT id FROM questions WHERE question_text = 'Кто предложил волновую механику?' AND pool_id = 5), 'Макс Борн', false, 'C'),
((SELECT id FROM questions WHERE question_text = 'Кто предложил волновую механику?' AND pool_id = 5), 'Луи де Бройль', false, 'D');

-- Варианты для вопроса 14: Какой изотоп используется в углеродном датировании?
INSERT INTO question_options (question_id, option_text, is_correct, option_letter) VALUES
((SELECT id FROM questions WHERE question_text = 'Какой изотоп используется в углеродном датировании?' AND pool_id = 5), 'Углерод-14', true, 'A'),
((SELECT id FROM questions WHERE question_text = 'Какой изотоп используется в углеродном датировании?' AND pool_id = 5), 'Углерод-12', false, 'B'),
((SELECT id FROM questions WHERE question_text = 'Какой изотоп используется в углеродном датировании?' AND pool_id = 5), 'Углерод-13', false, 'C'),
((SELECT id FROM questions WHERE question_text = 'Какой изотоп используется в углеродном датировании?' AND pool_id = 5), 'Уран-235', false, 'D');

-- Варианты для вопроса 15: Кто открыл антивещество?
INSERT INTO question_options (question_id, option_text, is_correct, option_letter) VALUES
((SELECT id FROM questions WHERE question_text = 'Кто открыл антивещество?' AND pool_id = 5), 'Карл Андерсон', true, 'A'),
((SELECT id FROM questions WHERE question_text = 'Кто открыл антивещество?' AND pool_id = 5), 'Пол Дирак', false, 'B'),
((SELECT id FROM questions WHERE question_text = 'Кто открыл антивещество?' AND pool_id = 5), 'Энрико Ферми', false, 'C'),
((SELECT id FROM questions WHERE question_text = 'Кто открыл антивещество?' AND pool_id = 5), 'Виктор Гейзенберг', false, 'D');