-- Вставка вариантов ответов для вопросов пула 2 (Космос и астрономия)

-- Варианты для вопроса 1: Какая планета ближайшая к Солнцу?
INSERT INTO question_options (question_id, option_text, is_correct, option_letter) VALUES
((SELECT id FROM questions WHERE question_text = 'Какая планета ближайшая к Солнцу?' AND pool_id = 2), 'Меркурий', true, 'A'),
((SELECT id FROM questions WHERE question_text = 'Какая планета ближайшая к Солнцу?' AND pool_id = 2), 'Венера', false, 'B'),
((SELECT id FROM questions WHERE question_text = 'Какая планета ближайшая к Солнцу?' AND pool_id = 2), 'Земля', false, 'C'),
((SELECT id FROM questions WHERE question_text = 'Какая планета ближайшая к Солнцу?' AND pool_id = 2), 'Марс', false, 'D');

-- Варианты для вопроса 2: Кто был первым человеком в космосе?
INSERT INTO question_options (question_id, option_text, is_correct, option_letter) VALUES
((SELECT id FROM questions WHERE question_text = 'Кто был первым человеком в космосе?' AND pool_id = 2), 'Юрий Гагарин', true, 'A'),
((SELECT id FROM questions WHERE question_text = 'Кто был первым человеком в космосе?' AND pool_id = 2), 'Алексей Леонов', false, 'B'),
((SELECT id FROM questions WHERE question_text = 'Кто был первым человеком в космосе?' AND pool_id = 2), 'Джон Гленн', false, 'C'),
((SELECT id FROM questions WHERE question_text = 'Кто был первым человеком в космосе?' AND pool_id = 2), 'Герман Титов', false, 'D');

-- Варианты для вопроса 3: Сколько спутников у Марса?
INSERT INTO question_options (question_id, option_text, is_correct, option_letter) VALUES
((SELECT id FROM questions WHERE question_text = 'Сколько спутников у Марса?' AND pool_id = 2), '2', true, 'A'),
((SELECT id FROM questions WHERE question_text = 'Сколько спутников у Марса?' AND pool_id = 2), '1', false, 'B'),
((SELECT id FROM questions WHERE question_text = 'Сколько спутников у Марса?' AND pool_id = 2), '3', false, 'C'),
((SELECT id FROM questions WHERE question_text = 'Сколько спутников у Марса?' AND pool_id = 2), '4', false, 'D');

-- Варианты для вопроса 4: В каком году человек впервые высадился на Луну?
INSERT INTO question_options (question_id, option_text, is_correct, option_letter) VALUES
((SELECT id FROM questions WHERE question_text = 'В каком году человек впервые высадился на Луну?' AND pool_id = 2), '1969', true, 'A'),
((SELECT id FROM questions WHERE question_text = 'В каком году человек впервые высадился на Луну?' AND pool_id = 2), '1968', false, 'B'),
((SELECT id FROM questions WHERE question_text = 'В каком году человек впервые высадился на Луну?' AND pool_id = 2), '1970', false, 'C'),
((SELECT id FROM questions WHERE question_text = 'В каком году человек впервые высадился на Луну?' AND pool_id = 2), '1967', false, 'D');

-- Варианты для вопроса 5: Как называется ближайшая к нам звезда после Солнца?
INSERT INTO question_options (question_id, option_text, is_correct, option_letter) VALUES
((SELECT id FROM questions WHERE question_text = 'Как называется ближайшая к нам звезда после Солнца?' AND pool_id = 2), 'Проксима Центавра', true, 'A'),
((SELECT id FROM questions WHERE question_text = 'Как называется ближайшая к нам звезда после Солнца?' AND pool_id = 2), 'Альфа Центавра', false, 'B'),
((SELECT id FROM questions WHERE question_text = 'Как называется ближайшая к нам звезда после Солнца?' AND pool_id = 2), 'Сириус', false, 'C'),
((SELECT id FROM questions WHERE question_text = 'Как называется ближайшая к нам звезда после Солнца?' AND pool_id = 2), 'Вега', false, 'D');

-- Варианты для вопроса 6: Какая планета имеет самые яркие кольца?
INSERT INTO question_options (question_id, option_text, is_correct, option_letter) VALUES
((SELECT id FROM questions WHERE question_text = 'Какая планета имеет самые яркие кольца?' AND pool_id = 2), 'Сатурн', true, 'A'),
((SELECT id FROM questions WHERE question_text = 'Какая планета имеет самые яркие кольца?' AND pool_id = 2), 'Юпитер', false, 'B'),
((SELECT id FROM questions WHERE question_text = 'Какая планета имеет самые яркие кольца?' AND pool_id = 2), 'Уран', false, 'C'),
((SELECT id FROM questions WHERE question_text = 'Какая планета имеет самые яркие кольца?' AND pool_id = 2), 'Нептун', false, 'D');

-- Варианты для вопроса 7: Кто открыл законы движения планет?
INSERT INTO question_options (question_id, option_text, is_correct, option_letter) VALUES
((SELECT id FROM questions WHERE question_text = 'Кто открыл законы движения планет?' AND pool_id = 2), 'Иоганн Кеплер', true, 'A'),
((SELECT id FROM questions WHERE question_text = 'Кто открыл законы движения планет?' AND pool_id = 2), 'Исаак Ньютон', false, 'B'),
((SELECT id FROM questions WHERE question_text = 'Кто открыл законы движения планет?' AND pool_id = 2), 'Галилео Галилей', false, 'C'),
((SELECT id FROM questions WHERE question_text = 'Кто открыл законы движения планет?' AND pool_id = 2), 'Коперник', false, 'D');

-- Варианты для вопроса 8: Какой космический аппарат первым достиг Плутона?
INSERT INTO question_options (question_id, option_text, is_correct, option_letter) VALUES
((SELECT id FROM questions WHERE question_text = 'Какой космический аппарат первым достиг Плутона?' AND pool_id = 2), 'New Horizons', true, 'A'),
((SELECT id FROM questions WHERE question_text = 'Какой космический аппарат первым достиг Плутона?' AND pool_id = 2), 'Voyager 1', false, 'B'),
((SELECT id FROM questions WHERE question_text = 'Какой космический аппарат первым достиг Плутона?' AND pool_id = 2), 'Pioneer 10', false, 'C'),
((SELECT id FROM questions WHERE question_text = 'Какой космический аппарат первым достиг Плутона?' AND pool_id = 2), 'Cassini', false, 'D');

-- Варианты для вопроса 9: В каком созвездии находится туманность Ориона?
INSERT INTO question_options (question_id, option_text, is_correct, option_letter) VALUES
((SELECT id FROM questions WHERE question_text = 'В каком созвездии находится туманность Ориона?' AND pool_id = 2), 'Орион', true, 'A'),
((SELECT id FROM questions WHERE question_text = 'В каком созвездии находится туманность Ориона?' AND pool_id = 2), 'Большая Медведица', false, 'B'),
((SELECT id FROM questions WHERE question_text = 'В каком созвездии находится туманность Ориона?' AND pool_id = 2), 'Кассиопея', false, 'C'),
((SELECT id FROM questions WHERE question_text = 'В каком созвездии находится туманность Ориона?' AND pool_id = 2), 'Лира', false, 'D');

-- Варианты для вопроса 10: Какая галактика ближайшая к Млечному Пути?
INSERT INTO question_options (question_id, option_text, is_correct, option_letter) VALUES
((SELECT id FROM questions WHERE question_text = 'Какая галактика ближайшая к Млечному Пути?' AND pool_id = 2), 'Андромеда', true, 'A'),
((SELECT id FROM questions WHERE question_text = 'Какая галактика ближайшая к Млечному Пути?' AND pool_id = 2), 'Треугольник', false, 'B'),
((SELECT id FROM questions WHERE question_text = 'Какая галактика ближайшая к Млечному Пути?' AND pool_id = 2), 'Большое Магелланово Облако', false, 'C'),
((SELECT id FROM questions WHERE question_text = 'Какая галактика ближайшая к Млечному Пути?' AND pool_id = 2), 'Малое Магелланово Облако', false, 'D');

-- Варианты для вопроса 11: Кто впервые измерил скорость света?
INSERT INTO question_options (question_id, option_text, is_correct, option_letter) VALUES
((SELECT id FROM questions WHERE question_text = 'Кто впервые измерил скорость света?' AND pool_id = 2), 'Оле Рёмер', true, 'A'),
((SELECT id FROM questions WHERE question_text = 'Кто впервые измерил скорость света?' AND pool_id = 2), 'Галилео Галилей', false, 'B'),
((SELECT id FROM questions WHERE question_text = 'Кто впервые измерил скорость света?' AND pool_id = 2), 'Исаак Ньютон', false, 'C'),
((SELECT id FROM questions WHERE question_text = 'Кто впервые измерил скорость света?' AND pool_id = 2), 'Христиан Гюйгенс', false, 'D');

-- Варианты для вопроса 12: Какой тип звезд является самым распространенным во Вселенной?
INSERT INTO question_options (question_id, option_text, is_correct, option_letter) VALUES
((SELECT id FROM questions WHERE question_text = 'Какой тип звезд является самым распространенным во Вселенной?' AND pool_id = 2), 'Красные карлики', true, 'A'),
((SELECT id FROM questions WHERE question_text = 'Какой тип звезд является самым распространенным во Вселенной?' AND pool_id = 2), 'Желтые карлики', false, 'B'),
((SELECT id FROM questions WHERE question_text = 'Какой тип звезд является самым распространенным во Вселенной?' AND pool_id = 2), 'Белые карлики', false, 'C'),
((SELECT id FROM questions WHERE question_text = 'Какой тип звезд является самым распространенным во Вселенной?' AND pool_id = 2), 'Гиганты', false, 'D');

-- Варианты для вопроса 13: В каком году был запущен телескоп Хаббл?
INSERT INTO question_options (question_id, option_text, is_correct, option_letter) VALUES
((SELECT id FROM questions WHERE question_text = 'В каком году был запущен телескоп Хаббл?' AND pool_id = 2), '1990', true, 'A'),
((SELECT id FROM questions WHERE question_text = 'В каком году был запущен телескоп Хаббл?' AND pool_id = 2), '1989', false, 'B'),
((SELECT id FROM questions WHERE question_text = 'В каком году был запущен телескоп Хаббл?' AND pool_id = 2), '1991', false, 'C'),
((SELECT id FROM questions WHERE question_text = 'В каком году был запущен телескоп Хаббл?' AND pool_id = 2), '1988', false, 'D');

-- Варианты для вопроса 14: Что такое квазар?
INSERT INTO question_options (question_id, option_text, is_correct, option_letter) VALUES
((SELECT id FROM questions WHERE question_text = 'Что такое квазар?' AND pool_id = 2), 'Квазизвездный радиоисточник', true, 'A'),
((SELECT id FROM questions WHERE question_text = 'Что такое квазар?' AND pool_id = 2), 'Космическая пыль', false, 'B'),
((SELECT id FROM questions WHERE question_text = 'Что такое квазар?' AND pool_id = 2), 'Черная дыра', false, 'C'),
((SELECT id FROM questions WHERE question_text = 'Что такое квазар?' AND pool_id = 2), 'Нейтронная звезда', false, 'D');

-- Варианты для вопроса 15: Какова примерная температура поверхности Солнца?
INSERT INTO question_options (question_id, option_text, is_correct, option_letter) VALUES
((SELECT id FROM questions WHERE question_text = 'Какова примерная температура поверхности Солнца?' AND pool_id = 2), '5778 K', true, 'A'),
((SELECT id FROM questions WHERE question_text = 'Какова примерная температура поверхности Солнца?' AND pool_id = 2), '6000 K', false, 'B'),
((SELECT id FROM questions WHERE question_text = 'Какова примерная температура поверхности Солнца?' AND pool_id = 2), '5500 K', false, 'C'),
((SELECT id FROM questions WHERE question_text = 'Какова примерная температура поверхности Солнца?' AND pool_id = 2), '6200 K', false, 'D');