-- Вставка вариантов ответов для вопросов пула 16 (Мировые войны)

-- Варианты для вопроса 1: В каком году началась Первая мировая война?
INSERT INTO question_options (question_id, option_text, is_correct, option_letter) VALUES
((SELECT id FROM questions WHERE question_text = 'В каком году началась Первая мировая война?' AND pool_id = 16), '1914', true, 'A'),
((SELECT id FROM questions WHERE question_text = 'В каком году началась Первая мировая война?' AND pool_id = 16), '1913', false, 'B'),
((SELECT id FROM questions WHERE question_text = 'В каком году началась Первая мировая война?' AND pool_id = 16), '1915', false, 'C'),
((SELECT id FROM questions WHERE question_text = 'В каком году началась Первая мировая война?' AND pool_id = 16), '1912', false, 'D');

-- Варианты для вопроса 2: Что стало поводом к началу Первой мировой войны?
INSERT INTO question_options (question_id, option_text, is_correct, option_letter) VALUES
((SELECT id FROM questions WHERE question_text = 'Что стало поводом к началу Первой мировой войны?' AND pool_id = 16), 'Убийство эрцгерцога Франца Фердинанда', true, 'A'),
((SELECT id FROM questions WHERE question_text = 'Что стало поводом к началу Первой мировой войны?' AND pool_id = 16), 'Захват Саарской области', false, 'B'),
((SELECT id FROM questions WHERE question_text = 'Что стало поводом к началу Первой мировой войны?' AND pool_id = 16), 'Кризис в Боснии', false, 'C'),
((SELECT id FROM questions WHERE question_text = 'Что стало поводом к началу Первой мировой войны?' AND pool_id = 16), 'Балканские войны', false, 'D');

-- Варианты для вопроса 3: В каком году США вступили в Первую мировую войну?
INSERT INTO question_options (question_id, option_text, is_correct, option_letter) VALUES
((SELECT id FROM questions WHERE question_text = 'В каком году США вступили в Первую мировую войну?' AND pool_id = 16), '1917', true, 'A'),
((SELECT id FROM questions WHERE question_text = 'В каком году США вступили в Первую мировую войну?' AND pool_id = 16), '1916', false, 'B'),
((SELECT id FROM questions WHERE question_text = 'В каком году США вступили в Первую мировую войну?' AND pool_id = 16), '1918', false, 'C'),
((SELECT id FROM questions WHERE question_text = 'В каком году США вступили в Первую мировую войну?' AND pool_id = 16), '1915', false, 'D');

-- Варианты для вопроса 4: Кто командовал германскими войсками в Первой мировой?
INSERT INTO question_options (question_id, option_text, is_correct, option_letter) VALUES
((SELECT id FROM questions WHERE question_text = 'Кто командовал германскими войсками в Первой мировой?' AND pool_id = 16), 'Эрих Людендорф', true, 'A'),
((SELECT id FROM questions WHERE question_text = 'Кто командовал германскими войсками в Первой мировой?' AND pool_id = 16), 'Поль фон Гинденбург', false, 'B'),
((SELECT id FROM questions WHERE question_text = 'Кто командовал германскими войсками в Первой мировой?' AND pool_id = 16), 'Фридрих фон Паулюс', false, 'C'),
((SELECT id FROM questions WHERE question_text = 'Кто командовал германскими войсками в Первой мировой?' AND pool_id = 16), 'Эрвин Роммель', false, 'D');

-- Варианты для вопроса 5: В каком году закончилась Первая мировая война?
INSERT INTO question_options (question_id, option_text, is_correct, option_letter) VALUES
((SELECT id FROM questions WHERE question_text = 'В каком году закончилась Первая мировая война?' AND pool_id = 16), '1918', true, 'A'),
((SELECT id FROM questions WHERE question_text = 'В каком году закончилась Первая мировая война?' AND pool_id = 16), '1919', false, 'B'),
((SELECT id FROM questions WHERE question_text = 'В каком году закончилась Первая мировая война?' AND pool_id = 16), '1917', false, 'C'),
((SELECT id FROM questions WHERE question_text = 'В каком году закончилась Первая мировая война?' AND pool_id = 16), '1920', false, 'D');

-- Варианты для вопроса 6: Что такое план Шлиффена?
INSERT INTO question_options (question_id, option_text, is_correct, option_letter) VALUES
((SELECT id FROM questions WHERE question_text = 'Что такое план Шлиффена?' AND pool_id = 16), 'План быстрого захвата Франции', true, 'A'),
((SELECT id FROM questions WHERE question_text = 'Что такое план Шлиффена?' AND pool_id = 16), 'План морской блокады', false, 'B'),
((SELECT id FROM questions WHERE question_text = 'Что такое план Шлиффена?' AND pool_id = 16), 'План экономической войны', false, 'C'),
((SELECT id FROM questions WHERE question_text = 'Что такое план Шлиффена?' AND pool_id = 16), 'План воздушных бомбардировок', false, 'D');

-- Варианты для вопроса 7: В каком году началась Вторая мировая война?
INSERT INTO question_options (question_id, option_text, is_correct, option_letter) VALUES
((SELECT id FROM questions WHERE question_text = 'В каком году началась Вторая мировая война?' AND pool_id = 16), '1939', true, 'A'),
((SELECT id FROM questions WHERE question_text = 'В каком году началась Вторая мировая война?' AND pool_id = 16), '1938', false, 'B'),
((SELECT id FROM questions WHERE question_text = 'В каком году началась Вторая мировая война?' AND pool_id = 16), '1940', false, 'C'),
((SELECT id FROM questions WHERE question_text = 'В каком году началась Вторая мировая война?' AND pool_id = 16), '1937', false, 'D');

-- Варианты для вопроса 8: Кто был фюрером Германии во время Второй мировой?
INSERT INTO question_options (question_id, option_text, is_correct, option_letter) VALUES
((SELECT id FROM questions WHERE question_text = 'Кто был фюрером Германии во время Второй мировой?' AND pool_id = 16), 'Адольф Гитлер', true, 'A'),
((SELECT id FROM questions WHERE question_text = 'Кто был фюрером Германии во время Второй мировой?' AND pool_id = 16), 'Герман Геринг', false, 'B'),
((SELECT id FROM questions WHERE question_text = 'Кто был фюрером Германии во время Второй мировой?' AND pool_id = 16), 'Генрих Гиммлер', false, 'C'),
((SELECT id FROM questions WHERE question_text = 'Кто был фюрером Германии во время Второй мировой?' AND pool_id = 16), 'Йозеф Геббельс', false, 'D');

-- Варианты для вопроса 9: В каком году произошло нападение на Перл-Харбор?
INSERT INTO question_options (question_id, option_text, is_correct, option_letter) VALUES
((SELECT id FROM questions WHERE question_text = 'В каком году произошло нападение на Перл-Харбор?' AND pool_id = 16), '1941', true, 'A'),
((SELECT id FROM questions WHERE question_text = 'В каком году произошло нападение на Перл-Харбор?' AND pool_id = 16), '1940', false, 'B'),
((SELECT id FROM questions WHERE question_text = 'В каком году произошло нападение на Перл-Харбор?' AND pool_id = 16), '1942', false, 'C'),
((SELECT id FROM questions WHERE question_text = 'В каком году произошло нападение на Перл-Харбор?' AND pool_id = 16), '1939', false, 'D');

-- Варианты для вопроса 10: Кто командовал союзными войсками в Нормандии?
INSERT INTO question_options (question_id, option_text, is_correct, option_letter) VALUES
((SELECT id FROM questions WHERE question_text = 'Кто командовал союзными войсками в Нормандии?' AND pool_id = 16), 'Дуайт Эйзенхауэр', true, 'A'),
((SELECT id FROM questions WHERE question_text = 'Кто командовал союзными войсками в Нормандии?' AND pool_id = 16), 'Джордж Паттон', false, 'B'),
((SELECT id FROM questions WHERE question_text = 'Кто командовал союзными войсками в Нормандии?' AND pool_id = 16), 'Бернард Монтгомери', false, 'C'),
((SELECT id FROM questions WHERE question_text = 'Кто командовал союзными войсками в Нормандии?' AND pool_id = 16), 'Омар Брэдли', false, 'D');

-- Варианты для вопроса 11: В каком году капитулировала Германия?
INSERT INTO question_options (question_id, option_text, is_correct, option_letter) VALUES
((SELECT id FROM questions WHERE question_text = 'В каком году капитулировала Германия?' AND pool_id = 16), '1945', true, 'A'),
((SELECT id FROM questions WHERE question_text = 'В каком году капитулировала Германия?' AND pool_id = 16), '1944', false, 'B'),
((SELECT id FROM questions WHERE question_text = 'В каком году капитулировала Германия?' AND pool_id = 16), '1946', false, 'C'),
((SELECT id FROM questions WHERE question_text = 'В каком году капитулировала Германия?' AND pool_id = 16), '1943', false, 'D');

-- Варианты для вопроса 12: Что такое операция "Барбаросса"?
INSERT INTO question_options (question_id, option_text, is_correct, option_letter) VALUES
((SELECT id FROM questions WHERE question_text = 'Что такое операция "Барбаросса"?' AND pool_id = 16), 'Вторжение Германии в СССР', true, 'A'),
((SELECT id FROM questions WHERE question_text = 'Что такое операция "Барбаросса"?' AND pool_id = 16), 'Вторжение в Польшу', false, 'B'),
((SELECT id FROM questions WHERE question_text = 'Что такое операция "Барбаросса"?' AND pool_id = 16), 'Вторжение во Францию', false, 'C'),
((SELECT id FROM questions WHERE question_text = 'Что такое операция "Барбаросса"?' AND pool_id = 16), 'Вторжение в Норвегию', false, 'D');

-- Варианты для вопроса 13: Кто был премьер-министром Великобритании во время войны?
INSERT INTO question_options (question_id, option_text, is_correct, option_letter) VALUES
((SELECT id FROM questions WHERE question_text = 'Кто был премьер-министром Великобритании во время войны?' AND pool_id = 16), 'Уинстон Черчилль', true, 'A'),
((SELECT id FROM questions WHERE question_text = 'Кто был премьер-министром Великобритании во время войны?' AND pool_id = 16), 'Невилл Чемберлен', false, 'B'),
((SELECT id FROM questions WHERE question_text = 'Кто был премьер-министром Великобритании во время войны?' AND pool_id = 16), 'Клемент Эттли', false, 'C'),
((SELECT id FROM questions WHERE question_text = 'Кто был премьер-министром Великобритании во время войны?' AND pool_id = 16), 'Энтони Иден', false, 'D');

-- Варианты для вопроса 14: В каком году были сброшены атомные бомбы на Японию?
INSERT INTO question_options (question_id, option_text, is_correct, option_letter) VALUES
((SELECT id FROM questions WHERE question_text = 'В каком году были сброшены атомные бомбы на Японию?' AND pool_id = 16), '1945', true, 'A'),
((SELECT id FROM questions WHERE question_text = 'В каком году были сброшены атомные бомбы на Японию?' AND pool_id = 16), '1944', false, 'B'),
((SELECT id FROM questions WHERE question_text = 'В каком году были сброшены атомные бомбы на Японию?' AND pool_id = 16), '1946', false, 'C'),
((SELECT id FROM questions WHERE question_text = 'В каком году были сброшены атомные бомбы на Японию?' AND pool_id = 16), '1943', false, 'D');

-- Варианты для вопроса 15: Что такое Холокост?
INSERT INTO question_options (question_id, option_text, is_correct, option_letter) VALUES
((SELECT id FROM questions WHERE question_text = 'Что такое Холокост?' AND pool_id = 16), 'Массовое уничтожение евреев нацистами', true, 'A'),
((SELECT id FROM questions WHERE question_text = 'Что такое Холокост?' AND pool_id = 16), 'Военные потери союзников', false, 'B'),
((SELECT id FROM questions WHERE question_text = 'Что такое Холокост?' AND pool_id = 16), 'Бомбардировки городов', false, 'C'),
((SELECT id FROM questions WHERE question_text = 'Что такое Холокост?' AND pool_id = 16), 'Концентрационные лагеря', false, 'D');