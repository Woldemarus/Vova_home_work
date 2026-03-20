-- Вставка вариантов ответов для вопросов пула 1 (Великие открытия)

-- Варианты для вопроса 1: Кто открыл закон всемирного тяготения?
INSERT INTO question_options (question_id, option_text, is_correct, option_letter) VALUES
((SELECT id FROM questions WHERE question_text = 'Кто открыл закон всемирного тяготения?' AND pool_id = 1), 'Исаак Ньютон', true, 'A'),
((SELECT id FROM questions WHERE question_text = 'Кто открыл закон всемирного тяготения?' AND pool_id = 1), 'Галилео Галилей', false, 'B'),
((SELECT id FROM questions WHERE question_text = 'Кто открыл закон всемирного тяготения?' AND pool_id = 1), 'Альберт Эйнштейн', false, 'C'),
((SELECT id FROM questions WHERE question_text = 'Кто открыл закон всемирного тяготения?' AND pool_id = 1), 'Иоганн Кеплер', false, 'D');

-- Варианты для вопроса 2: В каком году был открыт пенициллин?
INSERT INTO question_options (question_id, option_text, is_correct, option_letter) VALUES
((SELECT id FROM questions WHERE question_text = 'В каком году был открыт пенициллин?' AND pool_id = 1), '1928', true, 'A'),
((SELECT id FROM questions WHERE question_text = 'В каком году был открыт пенициллин?' AND pool_id = 1), '1925', false, 'B'),
((SELECT id FROM questions WHERE question_text = 'В каком году был открыт пенициллин?' AND pool_id = 1), '1930', false, 'C'),
((SELECT id FROM questions WHERE question_text = 'В каком году был открыт пенициллин?' AND pool_id = 1), '1918', false, 'D');

-- Варианты для вопроса 3: Кто изобрел телефон?
INSERT INTO question_options (question_id, option_text, is_correct, option_letter) VALUES
((SELECT id FROM questions WHERE question_text = 'Кто изобрел телефон?' AND pool_id = 1), 'Александр Грэхем Белл', true, 'A'),
((SELECT id FROM questions WHERE question_text = 'Кто изобрел телефон?' AND pool_id = 1), 'Томас Эдисон', false, 'B'),
((SELECT id FROM questions WHERE question_text = 'Кто изобрел телефон?' AND pool_id = 1), 'Никола Тесла', false, 'C'),
((SELECT id FROM questions WHERE question_text = 'Кто изобрел телефон?' AND pool_id = 1), 'Густав Кирхгоф', false, 'D');

-- Варианты для вопроса 4: Какой ученый сформулировал теорию эволюции?
INSERT INTO question_options (question_id, option_text, is_correct, option_letter) VALUES
((SELECT id FROM questions WHERE question_text = 'Какой ученый сформулировал теорию эволюции?' AND pool_id = 1), 'Чарльз Дарвин', true, 'A'),
((SELECT id FROM questions WHERE question_text = 'Какой ученый сформулировал теорию эволюции?' AND pool_id = 1), 'Грегор Мендель', false, 'B'),
((SELECT id FROM questions WHERE question_text = 'Какой ученый сформулировал теорию эволюции?' AND pool_id = 1), 'Жан-Батист Ламарк', false, 'C'),
((SELECT id FROM questions WHERE question_text = 'Какой ученый сформулировал теорию эволюции?' AND pool_id = 1), 'Карл Линней', false, 'D');

-- Варианты для вопроса 5: В каком году Мария Кюри получила первую Нобелевскую премию?
INSERT INTO question_options (question_id, option_text, is_correct, option_letter) VALUES
((SELECT id FROM questions WHERE question_text = 'В каком году Мария Кюри получила первую Нобелевскую премию?' AND pool_id = 1), '1903', true, 'A'),
((SELECT id FROM questions WHERE question_text = 'В каком году Мария Кюри получила первую Нобелевскую премию?' AND pool_id = 1), '1905', false, 'B'),
((SELECT id FROM questions WHERE question_text = 'В каком году Мария Кюри получила первую Нобелевскую премию?' AND pool_id = 1), '1911', false, 'C'),
((SELECT id FROM questions WHERE question_text = 'В каком году Мария Кюри получила первую Нобелевскую премию?' AND pool_id = 1), '1898', false, 'D');

-- Варианты для вопроса 6: Кто открыл структуру ДНК?
INSERT INTO question_options (question_id, option_text, is_correct, option_letter) VALUES
((SELECT id FROM questions WHERE question_text = 'Кто открыл структуру ДНК?' AND pool_id = 1), 'Джеймс Уотсон и Фрэнсис Крик', true, 'A'),
((SELECT id FROM questions WHERE question_text = 'Кто открыл структуру ДНК?' AND pool_id = 1), 'Розалинд Франклин', false, 'B'),
((SELECT id FROM questions WHERE question_text = 'Кто открыл структуру ДНК?' AND pool_id = 1), 'Морис Уилкинс', false, 'C'),
((SELECT id FROM questions WHERE question_text = 'Кто открыл структуру ДНК?' AND pool_id = 1), 'Лайнус Полинг', false, 'D');

-- Варианты для вопроса 7: В каком году была создана первая вакцина против оспы?
INSERT INTO question_options (question_id, option_text, is_correct, option_letter) VALUES
((SELECT id FROM questions WHERE question_text = 'В каком году была создана первая вакцина против оспы?' AND pool_id = 1), '1796', true, 'A'),
((SELECT id FROM questions WHERE question_text = 'В каком году была создана первая вакцина против оспы?' AND pool_id = 1), '1798', false, 'B'),
((SELECT id FROM questions WHERE question_text = 'В каком году была создана первая вакцина против оспы?' AND pool_id = 1), '1800', false, 'C'),
((SELECT id FROM questions WHERE question_text = 'В каком году была создана первая вакцина против оспы?' AND pool_id = 1), '1789', false, 'D');

-- Варианты для вопроса 8: Кто сформулировал специальную теорию относительности?
INSERT INTO question_options (question_id, option_text, is_correct, option_letter) VALUES
((SELECT id FROM questions WHERE question_text = 'Кто сформулировал специальную теорию относительности?' AND pool_id = 1), 'Альберт Эйнштейн', true, 'A'),
((SELECT id FROM questions WHERE question_text = 'Кто сформулировал специальную теорию относительности?' AND pool_id = 1), 'Исаак Ньютон', false, 'B'),
((SELECT id FROM questions WHERE question_text = 'Кто сформулировал специальную теорию относительности?' AND pool_id = 1), 'Галилео Галилей', false, 'C'),
((SELECT id FROM questions WHERE question_text = 'Кто сформулировал специальную теорию относительности?' AND pool_id = 1), 'Макс Планк', false, 'D');

-- Варианты для вопроса 9: Какой ученый открыл явление радиоактивности?
INSERT INTO question_options (question_id, option_text, is_correct, option_letter) VALUES
((SELECT id FROM questions WHERE question_text = 'Какой ученый открыл явление радиоактивности?' AND pool_id = 1), 'Антуан Анри Беккерель', true, 'A'),
((SELECT id FROM questions WHERE question_text = 'Какой ученый открыл явление радиоактивности?' AND pool_id = 1), 'Мария Кюри', false, 'B'),
((SELECT id FROM questions WHERE question_text = 'Какой ученый открыл явление радиоактивности?' AND pool_id = 1), 'Пьер Кюри', false, 'C'),
((SELECT id FROM questions WHERE question_text = 'Какой ученый открыл явление радиоактивности?' AND pool_id = 1), 'Эрнест Резерфорд', false, 'D');

-- Варианты для вопроса 10: В каком году был открыт электрон?
INSERT INTO question_options (question_id, option_text, is_correct, option_letter) VALUES
((SELECT id FROM questions WHERE question_text = 'В каком году был открыт электрон?' AND pool_id = 1), '1897', true, 'A'),
((SELECT id FROM questions WHERE question_text = 'В каком году был открыт электрон?' AND pool_id = 1), '1895', false, 'B'),
((SELECT id FROM questions WHERE question_text = 'В каком году был открыт электрон?' AND pool_id = 1), '1900', false, 'C'),
((SELECT id FROM questions WHERE question_text = 'В каком году был открыт электрон?' AND pool_id = 1), '1892', false, 'D');

-- Варианты для вопроса 11: Кто впервые синтезировал мочевину в лаборатории?
INSERT INTO question_options (question_id, option_text, is_correct, option_letter) VALUES
((SELECT id FROM questions WHERE question_text = 'Кто впервые синтезировал мочевину в лаборатории?' AND pool_id = 1), 'Фридрих Вёлер', true, 'A'),
((SELECT id FROM questions WHERE question_text = 'Кто впервые синтезировал мочевину в лаборатории?' AND pool_id = 1), 'Юстус Либих', false, 'B'),
((SELECT id FROM questions WHERE question_text = 'Кто впервые синтезировал мочевину в лаборатории?' AND pool_id = 1), 'Генрих Розе', false, 'C'),
((SELECT id FROM questions WHERE question_text = 'Кто впервые синтезировал мочевину в лаборатории?' AND pool_id = 1), 'Карл Шееле', false, 'D');

-- Варианты для вопроса 12: Какой ученый предложил модель атома с электронными орбиталями?
INSERT INTO question_options (question_id, option_text, is_correct, option_letter) VALUES
((SELECT id FROM questions WHERE question_text = 'Какой ученый предложил модель атома с электронными орбиталями?' AND pool_id = 1), 'Нильс Бор', true, 'A'),
((SELECT id FROM questions WHERE question_text = 'Какой ученый предложил модель атома с электронными орбиталями?' AND pool_id = 1), 'Эрнест Резерфорд', false, 'B'),
((SELECT id FROM questions WHERE question_text = 'Какой ученый предложил модель атома с электронными орбиталями?' AND pool_id = 1), 'Джозеф Томсон', false, 'C'),
((SELECT id FROM questions WHERE question_text = 'Какой ученый предложил модель атома с электронными орбиталями?' AND pool_id = 1), 'Макс Планк', false, 'D');

-- Варианты для вопроса 13: В каком году была расшифрована структура инсулина?
INSERT INTO question_options (question_id, option_text, is_correct, option_letter) VALUES
((SELECT id FROM questions WHERE question_text = 'В каком году была расшифрована структура инсулина?' AND pool_id = 1), '1955', true, 'A'),
((SELECT id FROM questions WHERE question_text = 'В каком году была расшифрована структура инсулина?' AND pool_id = 1), '1958', false, 'B'),
((SELECT id FROM questions WHERE question_text = 'В каком году была расшифрована структура инсулина?' AND pool_id = 1), '1960', false, 'C'),
((SELECT id FROM questions WHERE question_text = 'В каком году была расшифрована структура инсулина?' AND pool_id = 1), '1952', false, 'D');

-- Варианты для вопроса 14: Кто открыл явление сверхпроводимости?
INSERT INTO question_options (question_id, option_text, is_correct, option_letter) VALUES
((SELECT id FROM questions WHERE question_text = 'Кто открыл явление сверхпроводимости?' AND pool_id = 1), 'Хейке Камерлинг-Оннес', true, 'A'),
((SELECT id FROM questions WHERE question_text = 'Кто открыл явление сверхпроводимости?' AND pool_id = 1), 'Карл фон Линде', false, 'B'),
((SELECT id FROM questions WHERE question_text = 'Кто открыл явление сверхпроводимости?' AND pool_id = 1), 'Джеймс Дьюар', false, 'C'),
((SELECT id FROM questions WHERE question_text = 'Кто открыл явление сверхпроводимости?' AND pool_id = 1), 'Уильям Кельвин', false, 'D');

-- Варианты для вопроса 15: Какой ученый впервые получил искусственные радиоактивные изотопы?
INSERT INTO question_options (question_id, option_text, is_correct, option_letter) VALUES
((SELECT id FROM questions WHERE question_text = 'Какой ученый впервые получил искусственные радиоактивные изотопы?' AND pool_id = 1), 'Ирен и Фредерик Жолио-Кюри', true, 'A'),
((SELECT id FROM questions WHERE question_text = 'Какой ученый впервые получил искусственные радиоактивные изотопы?' AND pool_id = 1), 'Мария Кюри', false, 'B'),
((SELECT id FROM questions WHERE question_text = 'Какой ученый впервые получил искусственные радиоактивные изотопы?' AND pool_id = 1), 'Антуан Анри Беккерель', false, 'C'),
((SELECT id FROM questions WHERE question_text = 'Какой ученый впервые получил искусственные радиоактивные изотопы?' AND pool_id = 1), 'Эрнест Резерфорд', false, 'D');