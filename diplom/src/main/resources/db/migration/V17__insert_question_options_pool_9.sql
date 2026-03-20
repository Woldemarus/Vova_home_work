-- Вставка вариантов ответов для вопросов пула 9 (Энергетика и транспорт)

-- Варианты для вопроса 1: Кто изобрел паровую машину?
INSERT INTO question_options (question_id, option_text, is_correct, option_letter) VALUES
((SELECT id FROM questions WHERE question_text = 'Кто изобрел паровую машину?' AND pool_id = 9), 'Джеймс Уатт', true, 'A'),
((SELECT id FROM questions WHERE question_text = 'Кто изобрел паровую машину?' AND pool_id = 9), 'Томас Ньюкомен', false, 'B'),
((SELECT id FROM questions WHERE question_text = 'Кто изобрел паровую машину?' AND pool_id = 9), 'Дени Папен', false, 'C'),
((SELECT id FROM questions WHERE question_text = 'Кто изобрел паровую машину?' AND pool_id = 9), 'Джордж Стефенсон', false, 'D');

-- Варианты для вопроса 2: В каком году был создан первый автомобиль?
INSERT INTO question_options (question_id, option_text, is_correct, option_letter) VALUES
((SELECT id FROM questions WHERE question_text = 'В каком году был создан первый автомобиль?' AND pool_id = 9), '1886', true, 'A'),
((SELECT id FROM questions WHERE question_text = 'В каком году был создан первый автомобиль?' AND pool_id = 9), '1895', false, 'B'),
((SELECT id FROM questions WHERE question_text = 'В каком году был создан первый автомобиль?' AND pool_id = 9), '1870', false, 'C'),
((SELECT id FROM questions WHERE question_text = 'В каком году был создан первый автомобиль?' AND pool_id = 9), '1900', false, 'D');

-- Варианты для вопроса 3: Что такое возобновляемая энергия?
INSERT INTO question_options (question_id, option_text, is_correct, option_letter) VALUES
((SELECT id FROM questions WHERE question_text = 'Что такое возобновляемая энергия?' AND pool_id = 9), 'Энергия из неисчерпаемых источников', true, 'A'),
((SELECT id FROM questions WHERE question_text = 'Что такое возобновляемая энергия?' AND pool_id = 9), 'Энергия из нефти', false, 'B'),
((SELECT id FROM questions WHERE question_text = 'Что такое возобновляемая энергия?' AND pool_id = 9), 'Энергия из угля', false, 'C'),
((SELECT id FROM questions WHERE question_text = 'Что такое возобновляемая энергия?' AND pool_id = 9), 'Энергия из газа', false, 'D');

-- Варианты для вопроса 4: Кто изобрел двигатель внутреннего сгорания?
INSERT INTO question_options (question_id, option_text, is_correct, option_letter) VALUES
((SELECT id FROM questions WHERE question_text = 'Кто изобрел двигатель внутреннего сгорания?' AND pool_id = 9), 'Карл Бенц', true, 'A'),
((SELECT id FROM questions WHERE question_text = 'Кто изобрел двигатель внутреннего сгорания?' AND pool_id = 9), 'Готтлиб Даймлер', false, 'B'),
((SELECT id FROM questions WHERE question_text = 'Кто изобрел двигатель внутреннего сгорания?' AND pool_id = 9), 'Николаус Отто', false, 'C'),
((SELECT id FROM questions WHERE question_text = 'Кто изобрел двигатель внутреннего сгорания?' AND pool_id = 9), 'Рудольф Дизель', false, 'D');

-- Варианты для вопроса 5: В каком году была построена первая АЭС?
INSERT INTO question_options (question_id, option_text, is_correct, option_letter) VALUES
((SELECT id FROM questions WHERE question_text = 'В каком году была построена первая АЭС?' AND pool_id = 9), '1954', true, 'A'),
((SELECT id FROM questions WHERE question_text = 'В каком году была построена первая АЭС?' AND pool_id = 9), '1950', false, 'B'),
((SELECT id FROM questions WHERE question_text = 'В каком году была построена первая АЭС?' AND pool_id = 9), '1960', false, 'C'),
((SELECT id FROM questions WHERE question_text = 'В каком году была построена первая АЭС?' AND pool_id = 9), '1945', false, 'D');

-- Варианты для вопроса 6: Кто создал первый самолет?
INSERT INTO question_options (question_id, option_text, is_correct, option_letter) VALUES
((SELECT id FROM questions WHERE question_text = 'Кто создал первый самолет?' AND pool_id = 9), 'Братья Райт', true, 'A'),
((SELECT id FROM questions WHERE question_text = 'Кто создал первый самолет?' AND pool_id = 9), 'Отто Лилиенталь', false, 'B'),
((SELECT id FROM questions WHERE question_text = 'Кто создал первый самолет?' AND pool_id = 9), 'Клеман Адер', false, 'C'),
((SELECT id FROM questions WHERE question_text = 'Кто создал первый самолет?' AND pool_id = 9), 'Сэмюэл Лэнгли', false, 'D');

-- Варианты для вопроса 7: Что такое гибридный автомобиль?
INSERT INTO question_options (question_id, option_text, is_correct, option_letter) VALUES
((SELECT id FROM questions WHERE question_text = 'Что такое гибридный автомобиль?' AND pool_id = 9), 'Автомобиль с двумя типами двигателей', true, 'A'),
((SELECT id FROM questions WHERE question_text = 'Что такое гибридный автомобиль?' AND pool_id = 9), 'Автомобиль только на электричестве', false, 'B'),
((SELECT id FROM questions WHERE question_text = 'Что такое гибридный автомобиль?' AND pool_id = 9), 'Автомобиль только на бензине', false, 'C'),
((SELECT id FROM questions WHERE question_text = 'Что такое гибридный автомобиль?' AND pool_id = 9), 'Автомобиль на водороде', false, 'D');

-- Варианты для вопроса 8: Кто изобрел реактивный двигатель?
INSERT INTO question_options (question_id, option_text, is_correct, option_letter) VALUES
((SELECT id FROM questions WHERE question_text = 'Кто изобрел реактивный двигатель?' AND pool_id = 9), 'Фрэнк Уиттл', true, 'A'),
((SELECT id FROM questions WHERE question_text = 'Кто изобрел реактивный двигатель?' AND pool_id = 9), 'Ханс фон Охайн', false, 'B'),
((SELECT id FROM questions WHERE question_text = 'Кто изобрел реактивный двигатель?' AND pool_id = 9), 'Павел Сухой', false, 'C'),
((SELECT id FROM questions WHERE question_text = 'Кто изобрел реактивный двигатель?' AND pool_id = 9), 'Андрей Туполев', false, 'D');

-- Варианты для вопроса 9: В каком году был запущен первый спутник?
INSERT INTO question_options (question_id, option_text, is_correct, option_letter) VALUES
((SELECT id FROM questions WHERE question_text = 'В каком году был запущен первый спутник?' AND pool_id = 9), '1957', true, 'A'),
((SELECT id FROM questions WHERE question_text = 'В каком году был запущен первый спутник?' AND pool_id = 9), '1958', false, 'B'),
((SELECT id FROM questions WHERE question_text = 'В каком году был запущен первый спутник?' AND pool_id = 9), '1956', false, 'C'),
((SELECT id FROM questions WHERE question_text = 'В каком году был запущен первый спутник?' AND pool_id = 9), '1959', false, 'D');

-- Варианты для вопроса 10: Что такое водородная энергетика?
INSERT INTO question_options (question_id, option_text, is_correct, option_letter) VALUES
((SELECT id FROM questions WHERE question_text = 'Что такое водородная энергетика?' AND pool_id = 9), 'Использование водорода как топлива', true, 'A'),
((SELECT id FROM questions WHERE question_text = 'Что такое водородная энергетика?' AND pool_id = 9), 'Использование воды для генерации энергии', false, 'B'),
((SELECT id FROM questions WHERE question_text = 'Что такое водородная энергетика?' AND pool_id = 9), 'Производство кислорода', false, 'C'),
((SELECT id FROM questions WHERE question_text = 'Что такое водородная энергетика?' AND pool_id = 9), 'Хранение солнечной энергии', false, 'D');

-- Варианты для вопроса 11: Кто создал первую подводную лодку?
INSERT INTO question_options (question_id, option_text, is_correct, option_letter) VALUES
((SELECT id FROM questions WHERE question_text = 'Кто создал первую подводную лодку?' AND pool_id = 9), 'Корнелиус Дреббель', true, 'A'),
((SELECT id FROM questions WHERE question_text = 'Кто создал первую подводную лодку?' AND pool_id = 9), 'Дэвид Бушнелл', false, 'B'),
((SELECT id FROM questions WHERE question_text = 'Кто создал первую подводную лодку?' AND pool_id = 9), 'Саймон Лейк', false, 'C'),
((SELECT id FROM questions WHERE question_text = 'Кто создал первую подводную лодку?' AND pool_id = 9), 'Жюль Верн', false, 'D');

-- Варианты для вопроса 12: Что такое термоядерная энергия?
INSERT INTO question_options (question_id, option_text, is_correct, option_letter) VALUES
((SELECT id FROM questions WHERE question_text = 'Что такое термоядерная энергия?' AND pool_id = 9), 'Энергия от слияния ядер', true, 'A'),
((SELECT id FROM questions WHERE question_text = 'Что такое термоядерная энергия?' AND pool_id = 9), 'Энергия от деления ядер', false, 'B'),
((SELECT id FROM questions WHERE question_text = 'Что такое термоядерная энергия?' AND pool_id = 9), 'Энергия от химических реакций', false, 'C'),
((SELECT id FROM questions WHERE question_text = 'Что такое термоядерная энергия?' AND pool_id = 9), 'Энергия от ветра', false, 'D');

-- Варианты для вопроса 13: Кто разработал концепцию Hyperloop?
INSERT INTO question_options (question_id, option_text, is_correct, option_letter) VALUES
((SELECT id FROM questions WHERE question_text = 'Кто разработал концепцию Hyperloop?' AND pool_id = 9), 'Илон Маск', true, 'A'),
((SELECT id FROM questions WHERE question_text = 'Кто разработал концепцию Hyperloop?' AND pool_id = 9), 'Джефф Безос', false, 'B'),
((SELECT id FROM questions WHERE question_text = 'Кто разработал концепцию Hyperloop?' AND pool_id = 9), 'Марк Цукерберг', false, 'C'),
((SELECT id FROM questions WHERE question_text = 'Кто разработал концепцию Hyperloop?' AND pool_id = 9), 'Ларри Эллисон', false, 'D');

-- Варианты для вопроса 14: Что такое сверхпроводящие магниты в транспорте?
INSERT INTO question_options (question_id, option_text, is_correct, option_letter) VALUES
((SELECT id FROM questions WHERE question_text = 'Что такое сверхпроводящие магниты в транспорте?' AND pool_id = 9), 'Магниты для маглев поездов', true, 'A'),
((SELECT id FROM questions WHERE question_text = 'Что такое сверхпроводящие магниты в транспорте?' AND pool_id = 9), 'Магниты для электромобилей', false, 'B'),
((SELECT id FROM questions WHERE question_text = 'Что такое сверхпроводящие магниты в транспорте?' AND pool_id = 9), 'Магниты для самолетов', false, 'C'),
((SELECT id FROM questions WHERE question_text = 'Что такое сверхпроводящие магниты в транспорте?' AND pool_id = 9), 'Магниты для кораблей', false, 'D');

-- Варианты для вопроса 15: Кто предложил концепцию космического лифта?
INSERT INTO question_options (question_id, option_text, is_correct, option_letter) VALUES
((SELECT id FROM questions WHERE question_text = 'Кто предложил концепцию космического лифта?' AND pool_id = 9), 'Константин Циолковский', true, 'A'),
((SELECT id FROM questions WHERE question_text = 'Кто предложил концепцию космического лифта?' AND pool_id = 9), 'Артур Кларк', false, 'B'),
((SELECT id FROM questions WHERE question_text = 'Кто предложил концепцию космического лифта?' AND pool_id = 9), 'Юрий Арцутанов', false, 'C'),
((SELECT id FROM questions WHERE question_text = 'Кто предложил концепцию космического лифта?' AND pool_id = 9), 'Исаак Азимов', false, 'D');