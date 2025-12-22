-- Добавление вариантов ответов для примерных вопросов из каждого пула
-- Для демонстрации функциональности добавляем варианты для первых вопросов каждого пула

-- Варианты для пула 1 (Великие открытия) - вопрос 1
INSERT INTO question_options (question_id, option_text, is_correct, option_letter) VALUES
((SELECT id FROM questions WHERE question_text = 'Кто открыл закон всемирного тяготения?' AND pool_id = 1), 'Исаак Ньютон', true, 'A'),
((SELECT id FROM questions WHERE question_text = 'Кто открыл закон всемирного тяготения?' AND pool_id = 1), 'Галилео Галилей', false, 'B'),
((SELECT id FROM questions WHERE question_text = 'Кто открыл закон всемирного тяготения?' AND pool_id = 1), 'Альберт Эйнштейн', false, 'C'),
((SELECT id FROM questions WHERE question_text = 'Кто открыл закон всемирного тяготения?' AND pool_id = 1), 'Иоганн Кеплер', false, 'D');

-- Варианты для пула 2 (Космос и астрономия) - вопрос 1
INSERT INTO question_options (question_id, option_text, is_correct, option_letter) VALUES
((SELECT id FROM questions WHERE question_text = 'Какая планета ближайшая к Солнцу?' AND pool_id = 2), 'Меркурий', true, 'A'),
((SELECT id FROM questions WHERE question_text = 'Какая планета ближайшая к Солнцу?' AND pool_id = 2), 'Венера', false, 'B'),
((SELECT id FROM questions WHERE question_text = 'Какая планета ближайшая к Солнцу?' AND pool_id = 2), 'Земля', false, 'C'),
((SELECT id FROM questions WHERE question_text = 'Какая планета ближайшая к Солнцу?' AND pool_id = 2), 'Марс', false, 'D');

-- Варианты для пула 3 (Изобретения и технологии) - вопрос 1
INSERT INTO question_options (question_id, option_text, is_correct, option_letter) VALUES
((SELECT id FROM questions WHERE question_text = 'Кто изобрел колесо?' AND pool_id = 3), 'Древние шумеры', true, 'A'),
((SELECT id FROM questions WHERE question_text = 'Кто изобрел колесо?' AND pool_id = 3), 'Древние египтяне', false, 'B'),
((SELECT id FROM questions WHERE question_text = 'Кто изобрел колесо?' AND pool_id = 3), 'Древние греки', false, 'C'),
((SELECT id FROM questions WHERE question_text = 'Кто изобрел колесо?' AND pool_id = 3), 'Древние римляне', false, 'D');

-- Варианты для пула 4 (Медицина и здоровье) - вопрос 1
INSERT INTO question_options (question_id, option_text, is_correct, option_letter) VALUES
((SELECT id FROM questions WHERE question_text = 'Сколько костей в теле взрослого человека?' AND pool_id = 4), '206', true, 'A'),
((SELECT id FROM questions WHERE question_text = 'Сколько костей в теле взрослого человека?' AND pool_id = 4), '198', false, 'B'),
((SELECT id FROM questions WHERE question_text = 'Сколько костей в теле взрослого человека?' AND pool_id = 4), '215', false, 'C'),
((SELECT id FROM questions WHERE question_text = 'Сколько костей в теле взрослого человека?' AND pool_id = 4), '220', false, 'D');

-- Варианты для пула 5 (Физика и химия) - вопрос 1
INSERT INTO question_options (question_id, option_text, is_correct, option_letter) VALUES
((SELECT id FROM questions WHERE question_text = 'Какой газ составляет большую часть атмосферы Земли?' AND pool_id = 5), 'Азот', true, 'A'),
((SELECT id FROM questions WHERE question_text = 'Какой газ составляет большую часть атмосферы Земли?' AND pool_id = 5), 'Кислород', false, 'B'),
((SELECT id FROM questions WHERE question_text = 'Какой газ составляет большую часть атмосферы Земли?' AND pool_id = 5), 'Углекислый газ', false, 'C'),
((SELECT id FROM questions WHERE question_text = 'Какой газ составляет большую часть атмосферы Земли?' AND pool_id = 5), 'Аргон', false, 'D');

-- Варианты для пула 11 (Древний мир) - вопрос 1
INSERT INTO question_options (question_id, option_text, is_correct, option_letter) VALUES
((SELECT id FROM questions WHERE question_text = 'Кто был первым фараоном Египта?' AND pool_id = 11), 'Нармер (Менес)', true, 'A'),
((SELECT id FROM questions WHERE question_text = 'Кто был первым фараоном Египта?' AND pool_id = 11), 'Хуфу', false, 'B'),
((SELECT id FROM questions WHERE question_text = 'Кто был первым фараоном Египта?' AND pool_id = 11), 'Рамсес II', false, 'C'),
((SELECT id FROM questions WHERE question_text = 'Кто был первым фараоном Египта?' AND pool_id = 11), 'Тутанхамон', false, 'D');

-- Варианты для пула 21 (Живопись и скульптура) - вопрос 1
INSERT INTO question_options (question_id, option_text, is_correct, option_letter) VALUES
((SELECT id FROM questions WHERE question_text = 'Кто написал "Мону Лизу"?' AND pool_id = 21), 'Леонардо да Винчи', true, 'A'),
((SELECT id FROM questions WHERE question_text = 'Кто написал "Мону Лизу"?' AND pool_id = 21), 'Микеланджело', false, 'B'),
((SELECT id FROM questions WHERE question_text = 'Кто написал "Мону Лизу"?' AND pool_id = 21), 'Рафаэль', false, 'C'),
((SELECT id FROM questions WHERE question_text = 'Кто написал "Мону Лизу"?' AND pool_id = 21), 'Донателло', false, 'D');

-- Варианты для пула 31 (Страны и столицы) - вопрос 1
INSERT INTO question_options (question_id, option_text, is_correct, option_letter) VALUES
((SELECT id FROM questions WHERE question_text = 'Какая столица Франции?' AND pool_id = 31), 'Париж', true, 'A'),
((SELECT id FROM questions WHERE question_text = 'Какая столица Франции?' AND pool_id = 31), 'Лион', false, 'B'),
((SELECT id FROM questions WHERE question_text = 'Какая столица Франции?' AND pool_id = 31), 'Марсель', false, 'C'),
((SELECT id FROM questions WHERE question_text = 'Какая столица Франции?' AND pool_id = 31), 'Тулуза', false, 'D');

-- Варианты для пула 41 (Олимпийские игры) - вопрос 1
INSERT INTO question_options (question_id, option_text, is_correct, option_letter) VALUES
((SELECT id FROM questions WHERE question_text = 'Где проводились первые современные Олимпийские игры?' AND pool_id = 41), 'Афины', true, 'A'),
((SELECT id FROM questions WHERE question_text = 'Где проводились первые современные Олимпийские игры?' AND pool_id = 41), 'Париж', false, 'B'),
((SELECT id FROM questions WHERE question_text = 'Где проводились первые современные Олимпийские игры?' AND pool_id = 41), 'Лондон', false, 'C'),
((SELECT id FROM questions WHERE question_text = 'Где проводились первые современные Олимпийские игры?' AND pool_id = 41), 'Рим', false, 'D');

-- Варианты для пула 42 (Футбол) - вопрос 1
INSERT INTO question_options (question_id, option_text, is_correct, option_letter) VALUES
((SELECT id FROM questions WHERE question_text = 'Сколько игроков в футбольной команде?' AND pool_id = 42), '11', true, 'A'),
((SELECT id FROM questions WHERE question_text = 'Сколько игроков в футбольной команде?' AND pool_id = 42), '10', false, 'B'),
((SELECT id FROM questions WHERE question_text = 'Сколько игроков в футбольной команде?' AND pool_id = 42), '12', false, 'C'),
((SELECT id FROM questions WHERE question_text = 'Сколько игроков в футбольной команде?' AND pool_id = 42), '9', false, 'D');