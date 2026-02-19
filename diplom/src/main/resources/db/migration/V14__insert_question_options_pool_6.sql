-- Вставка вариантов ответов для вопросов пула 6 (Биология и экология)

-- Варианты для вопроса 1: Сколько камер в сердце млекопитающих?
INSERT INTO question_options (question_id, option_text, is_correct, option_letter) VALUES
((SELECT id FROM questions WHERE question_text = 'Сколько камер в сердце млекопитающих?' AND pool_id = 6), '4', true, 'A'),
((SELECT id FROM questions WHERE question_text = 'Сколько камер в сердце млекопитающих?' AND pool_id = 6), '3', false, 'B'),
((SELECT id FROM questions WHERE question_text = 'Сколько камер в сердце млекопитающих?' AND pool_id = 6), '2', false, 'C'),
((SELECT id FROM questions WHERE question_text = 'Сколько камер в сердце млекопитающих?' AND pool_id = 6), '5', false, 'D');

-- Варианты для вопроса 2: Какой процесс происходит в хлоропластах?
INSERT INTO question_options (question_id, option_text, is_correct, option_letter) VALUES
((SELECT id FROM questions WHERE question_text = 'Какой процесс происходит в хлоропластах?' AND pool_id = 6), 'Фотосинтез', true, 'A'),
((SELECT id FROM questions WHERE question_text = 'Какой процесс происходит в хлоропластах?' AND pool_id = 6), 'Дыхание', false, 'B'),
((SELECT id FROM questions WHERE question_text = 'Какой процесс происходит в хлоропластах?' AND pool_id = 6), 'Гликолиз', false, 'C'),
((SELECT id FROM questions WHERE question_text = 'Какой процесс происходит в хлоропластах?' AND pool_id = 6), 'Транскрипция', false, 'D');

-- Варианты для вопроса 3: Кто ввел термин "экология"?
INSERT INTO question_options (question_id, option_text, is_correct, option_letter) VALUES
((SELECT id FROM questions WHERE question_text = 'Кто ввел термин "экология"?' AND pool_id = 6), 'Эрнст Геккель', true, 'A'),
((SELECT id FROM questions WHERE question_text = 'Кто ввел термин "экология"?' AND pool_id = 6), 'Чарльз Дарвин', false, 'B'),
((SELECT id FROM questions WHERE question_text = 'Кто ввел термин "экология"?' AND pool_id = 6), 'Александр Гумбольдт', false, 'C'),
((SELECT id FROM questions WHERE question_text = 'Кто ввел термин "экология"?' AND pool_id = 6), 'Карл Линней', false, 'D');

-- Варианты для вопроса 4: Сколько хромосом у человека?
INSERT INTO question_options (question_id, option_text, is_correct, option_letter) VALUES
((SELECT id FROM questions WHERE question_text = 'Сколько хромосом у человека?' AND pool_id = 6), '46', true, 'A'),
((SELECT id FROM questions WHERE question_text = 'Сколько хромосом у человека?' AND pool_id = 6), '48', false, 'B'),
((SELECT id FROM questions WHERE question_text = 'Сколько хромосом у человека?' AND pool_id = 6), '44', false, 'C'),
((SELECT id FROM questions WHERE question_text = 'Сколько хромосом у человека?' AND pool_id = 6), '50', false, 'D');

-- Варианты для вопроса 5: Какой газ выделяют растения при фотосинтезе?
INSERT INTO question_options (question_id, option_text, is_correct, option_letter) VALUES
((SELECT id FROM questions WHERE question_text = 'Какой газ выделяют растения при фотосинтезе?' AND pool_id = 6), 'Кислород', true, 'A'),
((SELECT id FROM questions WHERE question_text = 'Какой газ выделяют растения при фотосинтезе?' AND pool_id = 6), 'Углекислый газ', false, 'B'),
((SELECT id FROM questions WHERE question_text = 'Какой газ выделяют растения при фотосинтезе?' AND pool_id = 6), 'Азот', false, 'C'),
((SELECT id FROM questions WHERE question_text = 'Какой газ выделяют растения при фотосинтезе?' AND pool_id = 6), 'Водород', false, 'D');

-- Варианты для вопроса 6: Кто открыл законы наследственности?
INSERT INTO question_options (question_id, option_text, is_correct, option_letter) VALUES
((SELECT id FROM questions WHERE question_text = 'Кто открыл законы наследственности?' AND pool_id = 6), 'Грегор Мендель', true, 'A'),
((SELECT id FROM questions WHERE question_text = 'Кто открыл законы наследственности?' AND pool_id = 6), 'Чарльз Дарвин', false, 'B'),
((SELECT id FROM questions WHERE question_text = 'Кто открыл законы наследственности?' AND pool_id = 6), 'Фрэнсис Крик', false, 'C'),
((SELECT id FROM questions WHERE question_text = 'Кто открыл законы наследственности?' AND pool_id = 6), 'Джеймс Уотсон', false, 'D');

-- Варианты для вопроса 7: Какая самая большая экосистема на Земле?
INSERT INTO question_options (question_id, option_text, is_correct, option_letter) VALUES
((SELECT id FROM questions WHERE question_text = 'Какая самая большая экосистема на Земле?' AND pool_id = 6), 'Океан', true, 'A'),
((SELECT id FROM questions WHERE question_text = 'Какая самая большая экосистема на Земле?' AND pool_id = 6), 'Лес', false, 'B'),
((SELECT id FROM questions WHERE question_text = 'Какая самая большая экосистема на Земле?' AND pool_id = 6), 'Саванна', false, 'C'),
((SELECT id FROM questions WHERE question_text = 'Какая самая большая экосистема на Земле?' AND pool_id = 6), 'Пустыня', false, 'D');

-- Варианты для вопроса 8: Кто предложил теорию симбиогенеза?
INSERT INTO question_options (question_id, option_text, is_correct, option_letter) VALUES
((SELECT id FROM questions WHERE question_text = 'Кто предложил теорию симбиогенеза?' AND pool_id = 6), 'Константин Мережковский', true, 'A'),
((SELECT id FROM questions WHERE question_text = 'Кто предложил теорию симбиогенеза?' AND pool_id = 6), 'Линн Маргулис', false, 'B'),
((SELECT id FROM questions WHERE question_text = 'Кто предложил теорию симбиогенеза?' AND pool_id = 6), 'Андрей Беляев', false, 'C'),
((SELECT id FROM questions WHERE question_text = 'Кто предложил теорию симбиогенеза?' AND pool_id = 6), 'Илья Мечников', false, 'D');

-- Варианты для вопроса 9: Какой тип РНК переносит аминокислоты?
INSERT INTO question_options (question_id, option_text, is_correct, option_letter) VALUES
((SELECT id FROM questions WHERE question_text = 'Какой тип РНК переносит аминокислоты?' AND pool_id = 6), 'тРНК', true, 'A'),
((SELECT id FROM questions WHERE question_text = 'Какой тип РНК переносит аминокислоты?' AND pool_id = 6), 'мРНК', false, 'B'),
((SELECT id FROM questions WHERE question_text = 'Какой тип РНК переносит аминокислоты?' AND pool_id = 6), 'рРНК', false, 'C'),
((SELECT id FROM questions WHERE question_text = 'Какой тип РНК переносит аминокислоты?' AND pool_id = 6), 'нРНК', false, 'D');

-- Варианты для вопроса 10: Кто открыл митохондрии?
INSERT INTO question_options (question_id, option_text, is_correct, option_letter) VALUES
((SELECT id FROM questions WHERE question_text = 'Кто открыл митохондрии?' AND pool_id = 6), 'Карл Бенда', true, 'A'),
((SELECT id FROM questions WHERE question_text = 'Кто открыл митохондрии?' AND pool_id = 6), 'Рихард Альтман', false, 'B'),
((SELECT id FROM questions WHERE question_text = 'Кто открыл митохондрии?' AND pool_id = 6), 'Кристиан де Дюв', false, 'C'),
((SELECT id FROM questions WHERE question_text = 'Кто открыл митохондрии?' AND pool_id = 6), 'Джордж Паладе', false, 'D');

-- Варианты для вопроса 11: Какой процесс называется транскрипцией?
INSERT INTO question_options (question_id, option_text, is_correct, option_letter) VALUES
((SELECT id FROM questions WHERE question_text = 'Какой процесс называется транскрипцией?' AND pool_id = 6), 'Синтез РНК на ДНК', true, 'A'),
((SELECT id FROM questions WHERE question_text = 'Какой процесс называется транскрипцией?' AND pool_id = 6), 'Синтез белка', false, 'B'),
((SELECT id FROM questions WHERE question_text = 'Какой процесс называется транскрипцией?' AND pool_id = 6), 'Репликация ДНК', false, 'C'),
((SELECT id FROM questions WHERE question_text = 'Какой процесс называется транскрипцией?' AND pool_id = 6), 'Трансляция', false, 'D');

-- Варианты для вопроса 12: Кто разработал теорию островной биогеографии?
INSERT INTO question_options (question_id, option_text, is_correct, option_letter) VALUES
((SELECT id FROM questions WHERE question_text = 'Кто разработал теорию островной биогеографии?' AND pool_id = 6), 'Роберт МакАртур и Эдвард Уилсон', true, 'A'),
((SELECT id FROM questions WHERE question_text = 'Кто разработал теорию островной биогеографии?' AND pool_id = 6), 'Чарльз Дарвин', false, 'B'),
((SELECT id FROM questions WHERE question_text = 'Кто разработал теорию островной биогеографии?' AND pool_id = 6), 'Альфред Уоллес', false, 'C'),
((SELECT id FROM questions WHERE question_text = 'Кто разработал теорию островной биогеографии?' AND pool_id = 6), 'Дэвид Лэк', false, 'D');

-- Варианты для вопроса 13: Какой фермент катализирует синтез ДНК?
INSERT INTO question_options (question_id, option_text, is_correct, option_letter) VALUES
((SELECT id FROM questions WHERE question_text = 'Какой фермент катализирует синтез ДНК?' AND pool_id = 6), 'ДНК-полимераза', true, 'A'),
((SELECT id FROM questions WHERE question_text = 'Какой фермент катализирует синтез ДНК?' AND pool_id = 6), 'РНК-полимераза', false, 'B'),
((SELECT id FROM questions WHERE question_text = 'Какой фермент катализирует синтез ДНК?' AND pool_id = 6), 'Ревертаза', false, 'C'),
((SELECT id FROM questions WHERE question_text = 'Какой фермент катализирует синтез ДНК?' AND pool_id = 6), 'Лигазa', false, 'D');

-- Варианты для вопроса 14: Кто открыл прионы?
INSERT INTO question_options (question_id, option_text, is_correct, option_letter) VALUES
((SELECT id FROM questions WHERE question_text = 'Кто открыл прионы?' AND pool_id = 6), 'Стэнли Прузинер', true, 'A'),
((SELECT id FROM questions WHERE question_text = 'Кто открыл прионы?' AND pool_id = 6), 'Карлтон Гайдузек', false, 'B'),
((SELECT id FROM questions WHERE question_text = 'Кто открыл прионы?' AND pool_id = 6), 'Дэниел Карлтон Гайдузек', false, 'C'),
((SELECT id FROM questions WHERE question_text = 'Кто открыл прионы?' AND pool_id = 6), 'Джозеф Гиббс', false, 'D');

-- Варианты для вопроса 15: Какой механизм регулирует экспрессию генов у эукариот?
INSERT INTO question_options (question_id, option_text, is_correct, option_letter) VALUES
((SELECT id FROM questions WHERE question_text = 'Какой механизм регулирует экспрессию генов у эукариот?' AND pool_id = 6), 'Эпигенетика', true, 'A'),
((SELECT id FROM questions WHERE question_text = 'Какой механизм регулирует экспрессию генов у эукариот?' AND pool_id = 6), 'Мутации', false, 'B'),
((SELECT id FROM questions WHERE question_text = 'Какой механизм регулирует экспрессию генов у эукариот?' AND pool_id = 6), 'Репарация ДНК', false, 'C'),
((SELECT id FROM questions WHERE question_text = 'Какой механизм регулирует экспрессию генов у эукариот?' AND pool_id = 6), 'Рекомбинация', false, 'D');