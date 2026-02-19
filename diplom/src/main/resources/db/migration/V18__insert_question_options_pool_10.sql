-- Вставка вариантов ответов для вопросов пула 10 (Археология и палеонтология)

-- Варианты для вопроса 1: Что изучает археология?
INSERT INTO question_options (question_id, option_text, is_correct, option_letter) VALUES
((SELECT id FROM questions WHERE question_text = 'Что изучает археология?' AND pool_id = 10), 'Материальную культуру древних народов', true, 'A'),
((SELECT id FROM questions WHERE question_text = 'Что изучает археология?' AND pool_id = 10), 'Живые организмы', false, 'B'),
((SELECT id FROM questions WHERE question_text = 'Что изучает археология?' AND pool_id = 10), 'Звезды и планеты', false, 'C'),
((SELECT id FROM questions WHERE question_text = 'Что изучает археология?' AND pool_id = 10), 'Химические элементы', false, 'D');

-- Варианты для вопроса 2: Кто нашел гробницу Тутанхамона?
INSERT INTO question_options (question_id, option_text, is_correct, option_letter) VALUES
((SELECT id FROM questions WHERE question_text = 'Кто нашел гробницу Тутанхамона?' AND pool_id = 10), 'Говард Картер', true, 'A'),
((SELECT id FROM questions WHERE question_text = 'Кто нашел гробницу Тутанхамона?' AND pool_id = 10), 'Жан-Франсуа Шампольон', false, 'B'),
((SELECT id FROM questions WHERE question_text = 'Кто нашел гробницу Тутанхамона?' AND pool_id = 10), 'Гастон Масперо', false, 'C'),
((SELECT id FROM questions WHERE question_text = 'Кто нашел гробницу Тутанхамона?' AND pool_id = 10), 'Флиндерс Питри', false, 'D');

-- Варианты для вопроса 3: Сколько лет назад жили динозавры?
INSERT INTO question_options (question_id, option_text, is_correct, option_letter) VALUES
((SELECT id FROM questions WHERE question_text = 'Сколько лет назад жили динозавры?' AND pool_id = 10), '65-250 миллионов лет', true, 'A'),
((SELECT id FROM questions WHERE question_text = 'Сколько лет назад жили динозавры?' AND pool_id = 10), '1-10 миллионов лет', false, 'B'),
((SELECT id FROM questions WHERE question_text = 'Сколько лет назад жили динозавры?' AND pool_id = 10), '500-1000 лет', false, 'C'),
((SELECT id FROM questions WHERE question_text = 'Сколько лет назад жили динозавры?' AND pool_id = 10), '10-50 тысяч лет', false, 'D');

-- Варианты для вопроса 4: Где находится Стоунхендж?
INSERT INTO question_options (question_id, option_text, is_correct, option_letter) VALUES
((SELECT id FROM questions WHERE question_text = 'Где находится Стоунхендж?' AND pool_id = 10), 'Англия', true, 'A'),
((SELECT id FROM questions WHERE question_text = 'Где находится Стоунхендж?' AND pool_id = 10), 'Шотландия', false, 'B'),
((SELECT id FROM questions WHERE question_text = 'Где находится Стоунхендж?' AND pool_id = 10), 'Ирландия', false, 'C'),
((SELECT id FROM questions WHERE question_text = 'Где находится Стоунхендж?' AND pool_id = 10), 'Уэльс', false, 'D');

-- Варианты для вопроса 5: Что такое радиоуглеродное датирование?
INSERT INTO question_options (question_id, option_text, is_correct, option_letter) VALUES
((SELECT id FROM questions WHERE question_text = 'Что такое радиоуглеродное датирование?' AND pool_id = 10), 'Метод определения возраста органических материалов', true, 'A'),
((SELECT id FROM questions WHERE question_text = 'Что такое радиоуглеродное датирование?' AND pool_id = 10), 'Метод изучения ДНК', false, 'B'),
((SELECT id FROM questions WHERE question_text = 'Что такое радиоуглеродное датирование?' AND pool_id = 10), 'Метод анализа почвы', false, 'C'),
((SELECT id FROM questions WHERE question_text = 'Что такое радиоуглеродное датирование?' AND pool_id = 10), 'Метод измерения температуры', false, 'D');

-- Варианты для вопроса 6: Кто открыл Трою?
INSERT INTO question_options (question_id, option_text, is_correct, option_letter) VALUES
((SELECT id FROM questions WHERE question_text = 'Кто открыл Трою?' AND pool_id = 10), 'Генрих Шлиман', true, 'A'),
((SELECT id FROM questions WHERE question_text = 'Кто открыл Трою?' AND pool_id = 10), 'Артур Эванс', false, 'B'),
((SELECT id FROM questions WHERE question_text = 'Кто открыл Трою?' AND pool_id = 10), 'Карл Блегген', false, 'C'),
((SELECT id FROM questions WHERE question_text = 'Кто открыл Трою?' AND pool_id = 10), 'Манолис Андроникос', false, 'D');

-- Варианты для вопроса 7: Какой период называется каменным веком?
INSERT INTO question_options (question_id, option_text, is_correct, option_letter) VALUES
((SELECT id FROM questions WHERE question_text = 'Какой период называется каменным веком?' AND pool_id = 10), 'Палеолит, мезолит, неолит', true, 'A'),
((SELECT id FROM questions WHERE question_text = 'Какой период называется каменным веком?' AND pool_id = 10), 'Бронзовый век', false, 'B'),
((SELECT id FROM questions WHERE question_text = 'Какой период называется каменным веком?' AND pool_id = 10), 'Железный век', false, 'C'),
((SELECT id FROM questions WHERE question_text = 'Какой период называется каменным веком?' AND pool_id = 10), 'Средние века', false, 'D');

-- Варианты для вопроса 8: Кто нашел "Люси" - древнего гоминида?
INSERT INTO question_options (question_id, option_text, is_correct, option_letter) VALUES
((SELECT id FROM questions WHERE question_text = 'Кто нашел "Люси" - древнего гоминида?' AND pool_id = 10), 'Дональд Джохансон', true, 'A'),
((SELECT id FROM questions WHERE question_text = 'Кто нашел "Люси" - древнего гоминида?' AND pool_id = 10), 'Луис Лики', false, 'B'),
((SELECT id FROM questions WHERE question_text = 'Кто нашел "Люси" - древнего гоминида?' AND pool_id = 10), 'Мэри Лики', false, 'C'),
((SELECT id FROM questions WHERE question_text = 'Кто нашел "Люси" - древнего гоминида?' AND pool_id = 10), 'Ричард Лики', false, 'D');

-- Варианты для вопроса 9: Что такое стратиграфия?
INSERT INTO question_options (question_id, option_text, is_correct, option_letter) VALUES
((SELECT id FROM questions WHERE question_text = 'Что такое стратиграфия?' AND pool_id = 10), 'Изучение слоев почвы и отложений', true, 'A'),
((SELECT id FROM questions WHERE question_text = 'Что такое стратиграфия?' AND pool_id = 10), 'Изучение звезд', false, 'B'),
((SELECT id FROM questions WHERE question_text = 'Что такое стратиграфия?' AND pool_id = 10), 'Изучение растений', false, 'C'),
((SELECT id FROM questions WHERE question_text = 'Что такое стратиграфия?' AND pool_id = 10), 'Изучение химических реакций', false, 'D');

-- Варианты для вопроса 10: Кто открыл терракотовую армию в Китае?
INSERT INTO question_options (question_id, option_text, is_correct, option_letter) VALUES
((SELECT id FROM questions WHERE question_text = 'Кто открыл терракотовую армию в Китае?' AND pool_id = 10), 'Крестьяне из деревни Сяньян', true, 'A'),
((SELECT id FROM questions WHERE question_text = 'Кто открыл терракотовую армию в Китае?' AND pool_id = 10), 'Археологи из Пекина', false, 'B'),
((SELECT id FROM questions WHERE question_text = 'Кто открыл терракотовую армию в Китае?' AND pool_id = 10), 'Иностранные экспедиции', false, 'C'),
((SELECT id FROM questions WHERE question_text = 'Кто открыл терракотовую армию в Китае?' AND pool_id = 10), 'Военные раскопки', false, 'D');

-- Варианты для вопроса 11: Что изучает тафономия?
INSERT INTO question_options (question_id, option_text, is_correct, option_letter) VALUES
((SELECT id FROM questions WHERE question_text = 'Что изучает тафономия?' AND pool_id = 10), 'Процессы захоронения и fossilизации', true, 'A'),
((SELECT id FROM questions WHERE question_text = 'Что изучает тафономия?' AND pool_id = 10), 'Живые организмы', false, 'B'),
((SELECT id FROM questions WHERE question_text = 'Что изучает тафономия?' AND pool_id = 10), 'Климатические изменения', false, 'C'),
((SELECT id FROM questions WHERE question_text = 'Что изучает тафономия?' AND pool_id = 10), 'Генетические мутации', false, 'D');

-- Варианты для вопроса 12: Кто разработал метод дендрохронологии?
INSERT INTO question_options (question_id, option_text, is_correct, option_letter) VALUES
((SELECT id FROM questions WHERE question_text = 'Кто разработал метод дендрохронологии?' AND pool_id = 10), 'Эндрю Дуглас', true, 'A'),
((SELECT id FROM questions WHERE question_text = 'Кто разработал метод дендрохронологии?' AND pool_id = 10), 'Уиллард Либби', false, 'B'),
((SELECT id FROM questions WHERE question_text = 'Кто разработал метод дендрохронологии?' AND pool_id = 10), 'Карл Саган', false, 'C'),
((SELECT id FROM questions WHERE question_text = 'Кто разработал метод дендрохронологии?' AND pool_id = 10), 'Джон Бардин', false, 'D');

-- Варианты для вопроса 13: Что такое палеогенетика?
INSERT INTO question_options (question_id, option_text, is_correct, option_letter) VALUES
((SELECT id FROM questions WHERE question_text = 'Что такое палеогенетика?' AND pool_id = 10), 'Изучение ДНК древних организмов', true, 'A'),
((SELECT id FROM questions WHERE question_text = 'Что такое палеогенетика?' AND pool_id = 10), 'Изучение древних языков', false, 'B'),
((SELECT id FROM questions WHERE question_text = 'Что такое палеогенетика?' AND pool_id = 10), 'Изучение древних зданий', false, 'C'),
((SELECT id FROM questions WHERE question_text = 'Что такое палеогенетика?' AND pool_id = 10), 'Изучение древних инструментов', false, 'D');

-- Варианты для вопроса 14: Кто открыл ДНК неандертальцев?
INSERT INTO question_options (question_id, option_text, is_correct, option_letter) VALUES
((SELECT id FROM questions WHERE question_text = 'Кто открыл ДНК неандертальцев?' AND pool_id = 10), 'Сванте Пэабо', true, 'A'),
((SELECT id FROM questions WHERE question_text = 'Кто открыл ДНК неандертальцев?' AND pool_id = 10), 'Фрэнсис Коллинз', false, 'B'),
((SELECT id FROM questions WHERE question_text = 'Кто открыл ДНК неандертальцев?' AND pool_id = 10), 'Крейг Вентер', false, 'C'),
((SELECT id FROM questions WHERE question_text = 'Кто открыл ДНК неандертальцев?' AND pool_id = 10), 'Джеймс Уотсон', false, 'D');

-- Варианты для вопроса 15: Что такое молекулярные часы в эволюции?
INSERT INTO question_options (question_id, option_text, is_correct, option_letter) VALUES
((SELECT id FROM questions WHERE question_text = 'Что такое молекулярные часы в эволюции?' AND pool_id = 10), 'Метод датирования эволюционных событий по мутациям ДНК', true, 'A'),
((SELECT id FROM questions WHERE question_text = 'Что такое молекулярные часы в эволюции?' AND pool_id = 10), 'Измерение времени жизни клеток', false, 'B'),
((SELECT id FROM questions WHERE question_text = 'Что такое молекулярные часы в эволюции?' AND pool_id = 10), 'Счет поколений организмов', false, 'C'),
((SELECT id FROM questions WHERE question_text = 'Что такое молекулярные часы в эволюции?' AND pool_id = 10), 'Измерение скорости метаболизма', false, 'D');