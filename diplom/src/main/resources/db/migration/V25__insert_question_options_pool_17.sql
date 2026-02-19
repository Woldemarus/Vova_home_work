-- Вставка вариантов ответов для вопросов пула 17 (Революции и восстания)

-- Варианты для вопроса 1: В каком году произошла Французская революция?
INSERT INTO question_options (question_id, option_text, is_correct, option_letter) VALUES
((SELECT id FROM questions WHERE question_text = 'В каком году произошла Французская революция?' AND pool_id = 17), '1789', true, 'A'),
((SELECT id FROM questions WHERE question_text = 'В каком году произошла Французская революция?' AND pool_id = 17), '1788', false, 'B'),
((SELECT id FROM questions WHERE question_text = 'В каком году произошла Французская революция?' AND pool_id = 17), '1790', false, 'C'),
((SELECT id FROM questions WHERE question_text = 'В каком году произошла Французская революция?' AND pool_id = 17), '1787', false, 'D');

-- Варианты для вопроса 2: Кто был казнен во время Французской революции?
INSERT INTO question_options (question_id, option_text, is_correct, option_letter) VALUES
((SELECT id FROM questions WHERE question_text = 'Кто был казнен во время Французской революции?' AND pool_id = 17), 'Людовик XVI', true, 'A'),
((SELECT id FROM questions WHERE question_text = 'Кто был казнен во время Французской революции?' AND pool_id = 17), 'Наполеон Бонапарт', false, 'B'),
((SELECT id FROM questions WHERE question_text = 'Кто был казнен во время Французской революции?' AND pool_id = 17), 'Мария-Антуанетта', false, 'C'),
((SELECT id FROM questions WHERE question_text = 'Кто был казнен во время Французской революции?' AND pool_id = 17), 'Максимилиан Робеспьер', false, 'D');

-- Варианты для вопроса 3: Что такое якобинцы?
INSERT INTO question_options (question_id, option_text, is_correct, option_letter) VALUES
((SELECT id FROM questions WHERE question_text = 'Что такое якобинцы?' AND pool_id = 17), 'Радикальные революционеры', true, 'A'),
((SELECT id FROM questions WHERE question_text = 'Что такое якобинцы?' AND pool_id = 17), 'Королевские гвардейцы', false, 'B'),
((SELECT id FROM questions WHERE question_text = 'Что такое якобинцы?' AND pool_id = 17), 'Католические священники', false, 'C'),
((SELECT id FROM questions WHERE question_text = 'Что такое якобинцы?' AND pool_id = 17), 'Военные офицеры', false, 'D');

-- Варианты для вопроса 4: В каком году произошла революция в России?
INSERT INTO question_options (question_id, option_text, is_correct, option_letter) VALUES
((SELECT id FROM questions WHERE question_text = 'В каком году произошла революция в России?' AND pool_id = 17), '1917', true, 'A'),
((SELECT id FROM questions WHERE question_text = 'В каком году произошла революция в России?' AND pool_id = 17), '1916', false, 'B'),
((SELECT id FROM questions WHERE question_text = 'В каком году произошла революция в России?' AND pool_id = 17), '1918', false, 'C'),
((SELECT id FROM questions WHERE question_text = 'В каком году произошла революция в России?' AND pool_id = 17), '1915', false, 'D');

-- Варианты для вопроса 5: Кто возглавил большевиков?
INSERT INTO question_options (question_id, option_text, is_correct, option_letter) VALUES
((SELECT id FROM questions WHERE question_text = 'Кто возглавил большевиков?' AND pool_id = 17), 'Владимир Ленин', true, 'A'),
((SELECT id FROM questions WHERE question_text = 'Кто возглавил большевиков?' AND pool_id = 17), 'Лев Троцкий', false, 'B'),
((SELECT id FROM questions WHERE question_text = 'Кто возглавил большевиков?' AND pool_id = 17), 'Иосиф Сталин', false, 'C'),
((SELECT id FROM questions WHERE question_text = 'Кто возглавил большевиков?' AND pool_id = 17), 'Николай Бухарин', false, 'D');

-- Варианты для вопроса 6: Что такое Бастилия?
INSERT INTO question_options (question_id, option_text, is_correct, option_letter) VALUES
((SELECT id FROM questions WHERE question_text = 'Что такое Бастилия?' AND pool_id = 17), 'Королевская тюрьма', true, 'A'),
((SELECT id FROM questions WHERE question_text = 'Что такое Бастилия?' AND pool_id = 17), 'Дворец короля', false, 'B'),
((SELECT id FROM questions WHERE question_text = 'Что такое Бастилия?' AND pool_id = 17), 'Военная крепость', false, 'C'),
((SELECT id FROM questions WHERE question_text = 'Что такое Бастилия?' AND pool_id = 17), 'Церковь', false, 'D');

-- Варианты для вопроса 7: В каком году произошла Американская революция?
INSERT INTO question_options (question_id, option_text, is_correct, option_letter) VALUES
((SELECT id FROM questions WHERE question_text = 'В каком году произошла Американская революция?' AND pool_id = 17), '1775', true, 'A'),
((SELECT id FROM questions WHERE question_text = 'В каком году произошла Американская революция?' AND pool_id = 17), '1776', false, 'B'),
((SELECT id FROM questions WHERE question_text = 'В каком году произошла Американская революция?' AND pool_id = 17), '1774', false, 'C'),
((SELECT id FROM questions WHERE question_text = 'В каком году произошла Американская революция?' AND pool_id = 17), '1777', false, 'D');

-- Варианты для вопроса 8: Кто написал Декларацию независимости США?
INSERT INTO question_options (question_id, option_text, is_correct, option_letter) VALUES
((SELECT id FROM questions WHERE question_text = 'Кто написал Декларацию независимости США?' AND pool_id = 17), 'Томас Джефферсон', true, 'A'),
((SELECT id FROM questions WHERE question_text = 'Кто написал Декларацию независимости США?' AND pool_id = 17), 'Джон Адамс', false, 'B'),
((SELECT id FROM questions WHERE question_text = 'Кто написал Декларацию независимости США?' AND pool_id = 17), 'Бенджамин Франклин', false, 'C'),
((SELECT id FROM questions WHERE question_text = 'Кто написал Декларацию независимости США?' AND pool_id = 17), 'Джордж Вашингтон', false, 'D');

-- Варианты для вопроса 9: Что такое "Бостонское чаепитие"?
INSERT INTO question_options (question_id, option_text, is_correct, option_letter) VALUES
((SELECT id FROM questions WHERE question_text = 'Что такое "Бостонское чаепитие"?' AND pool_id = 17), 'Акция протеста против налогов', true, 'A'),
((SELECT id FROM questions WHERE question_text = 'Что такое "Бостонское чаепитие"?' AND pool_id = 17), 'Военное сражение', false, 'B'),
((SELECT id FROM questions WHERE question_text = 'Что такое "Бостонское чаепитие"?' AND pool_id = 17), 'Политическое собрание', false, 'C'),
((SELECT id FROM questions WHERE question_text = 'Что такое "Бостонское чаепитие"?' AND pool_id = 17), 'Экономическая реформа', false, 'D');

-- Варианты для вопроса 10: В каком году произошла революция в Китае?
INSERT INTO question_options (question_id, option_text, is_correct, option_letter) VALUES
((SELECT id FROM questions WHERE question_text = 'В каком году произошла революция в Китае?' AND pool_id = 17), '1949', true, 'A'),
((SELECT id FROM questions WHERE question_text = 'В каком году произошла революция в Китае?' AND pool_id = 17), '1948', false, 'B'),
((SELECT id FROM questions WHERE question_text = 'В каком году произошла революция в Китае?' AND pool_id = 17), '1950', false, 'C'),
((SELECT id FROM questions WHERE question_text = 'В каком году произошла революция в Китае?' AND pool_id = 17), '1947', false, 'D');

-- Варианты для вопроса 11: Кто возглавил китайскую революцию?
INSERT INTO question_options (question_id, option_text, is_correct, option_letter) VALUES
((SELECT id FROM questions WHERE question_text = 'Кто возглавил китайскую революцию?' AND pool_id = 17), 'Мао Цзэдун', true, 'A'),
((SELECT id FROM questions WHERE question_text = 'Кто возглавил китайскую революцию?' AND pool_id = 17), 'Чан Кайши', false, 'B'),
((SELECT id FROM questions WHERE question_text = 'Кто возглавил китайскую революцию?' AND pool_id = 17), 'Сунь Ятсен', false, 'C'),
((SELECT id FROM questions WHERE question_text = 'Кто возглавил китайскую революцию?' AND pool_id = 17), 'Чжоу Эньлай', false, 'D');

-- Варианты для вопроса 12: Что такое Парижская коммуна?
INSERT INTO question_options (question_id, option_text, is_correct, option_letter) VALUES
((SELECT id FROM questions WHERE question_text = 'Что такое Парижская коммуна?' AND pool_id = 17), 'Революционное правительство в Париже', true, 'A'),
((SELECT id FROM questions WHERE question_text = 'Что такое Парижская коммуна?' AND pool_id = 17), 'Военная крепость', false, 'B'),
((SELECT id FROM questions WHERE question_text = 'Что такое Парижская коммуна?' AND pool_id = 17), 'Церковная организация', false, 'C'),
((SELECT id FROM questions WHERE question_text = 'Что такое Парижская коммуна?' AND pool_id = 17), 'Торговый союз', false, 'D');

-- Варианты для вопроса 13: В каком году произошла революция в Иране?
INSERT INTO question_options (question_id, option_text, is_correct, option_letter) VALUES
((SELECT id FROM questions WHERE question_text = 'В каком году произошла революция в Иране?' AND pool_id = 17), '1979', true, 'A'),
((SELECT id FROM questions WHERE question_text = 'В каком году произошла революция в Иране?' AND pool_id = 17), '1978', false, 'B'),
((SELECT id FROM questions WHERE question_text = 'В каком году произошла революция в Иране?' AND pool_id = 17), '1980', false, 'C'),
((SELECT id FROM questions WHERE question_text = 'В каком году произошла революция в Иране?' AND pool_id = 17), '1977', false, 'D');

-- Варианты для вопроса 14: Кто возглавил кубинскую революцию?
INSERT INTO question_options (question_id, option_text, is_correct, option_letter) VALUES
((SELECT id FROM questions WHERE question_text = 'Кто возглавил кубинскую революцию?' AND pool_id = 17), 'Фидель Кастро', true, 'A'),
((SELECT id FROM questions WHERE question_text = 'Кто возглавил кубинскую революцию?' AND pool_id = 17), 'Че Гевара', false, 'B'),
((SELECT id FROM questions WHERE question_text = 'Кто возглавил кубинскую революцию?' AND pool_id = 17), 'Рауль Кастро', false, 'C'),
((SELECT id FROM questions WHERE question_text = 'Кто возглавил кубинскую революцию?' AND pool_id = 17), 'Камило Сьенфуэгос', false, 'D');

-- Варианты для вопроса 15: Что такое "Культурная революция" в Китае?
INSERT INTO question_options (question_id, option_text, is_correct, option_letter) VALUES
((SELECT id FROM questions WHERE question_text = 'Что такое "Культурная революция" в Китае?' AND pool_id = 17), 'Политическая кампания Мао Цзэдуна', true, 'A'),
((SELECT id FROM questions WHERE question_text = 'Что такое "Культурная революция" в Китае?' AND pool_id = 17), 'Экономическая реформа', false, 'B'),
((SELECT id FROM questions WHERE question_text = 'Что такое "Культурная революция" в Китае?' AND pool_id = 17), 'Военная кампания', false, 'C'),
((SELECT id FROM questions WHERE question_text = 'Что такое "Культурная революция" в Китае?' AND pool_id = 17), 'Культурный обмен', false, 'D');