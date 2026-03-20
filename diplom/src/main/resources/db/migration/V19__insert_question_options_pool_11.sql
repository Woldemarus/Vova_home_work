-- Вставка вариантов ответов для вопросов пула 11 (Древний мир)

-- Варианты для вопроса 1: Кто был первым фараоном Египта?
INSERT INTO question_options (question_id, option_text, is_correct, option_letter) VALUES
((SELECT id FROM questions WHERE question_text = 'Кто был первым фараоном Египта?' AND pool_id = 11), 'Нармер (Менес)', true, 'A'),
((SELECT id FROM questions WHERE question_text = 'Кто был первым фараоном Египта?' AND pool_id = 11), 'Хуфу', false, 'B'),
((SELECT id FROM questions WHERE question_text = 'Кто был первым фараоном Египта?' AND pool_id = 11), 'Рамсес II', false, 'C'),
((SELECT id FROM questions WHERE question_text = 'Кто был первым фараоном Египта?' AND pool_id = 11), 'Тутанхамон', false, 'D');

-- Варианты для вопроса 2: В каком городе проводились первые Олимпийские игры?
INSERT INTO question_options (question_id, option_text, is_correct, option_letter) VALUES
((SELECT id FROM questions WHERE question_text = 'В каком городе проводились первые Олимпийские игры?' AND pool_id = 11), 'Олимпия', true, 'A'),
((SELECT id FROM questions WHERE question_text = 'В каком городе проводились первые Олимпийские игры?' AND pool_id = 11), 'Афины', false, 'B'),
((SELECT id FROM questions WHERE question_text = 'В каком городе проводились первые Олимпийские игры?' AND pool_id = 11), 'Спарта', false, 'C'),
((SELECT id FROM questions WHERE question_text = 'В каком городе проводились первые Олимпийские игры?' AND pool_id = 11), 'Коринф', false, 'D');

-- Варианты для вопроса 3: Кто основал Рим?
INSERT INTO question_options (question_id, option_text, is_correct, option_letter) VALUES
((SELECT id FROM questions WHERE question_text = 'Кто основал Рим?' AND pool_id = 11), 'Ромул и Рем', true, 'A'),
((SELECT id FROM questions WHERE question_text = 'Кто основал Рим?' AND pool_id = 11), 'Эней', false, 'B'),
((SELECT id FROM questions WHERE question_text = 'Кто основал Рим?' AND pool_id = 11), 'Юлий Цезарь', false, 'C'),
((SELECT id FROM questions WHERE question_text = 'Кто основал Рим?' AND pool_id = 11), 'Нума Помпилий', false, 'D');

-- Варианты для вопроса 4: Как называлась письменность древних египтян?
INSERT INTO question_options (question_id, option_text, is_correct, option_letter) VALUES
((SELECT id FROM questions WHERE question_text = 'Как называлась письменность древних египтян?' AND pool_id = 11), 'Иероглифы', true, 'A'),
((SELECT id FROM questions WHERE question_text = 'Как называлась письменность древних египтян?' AND pool_id = 11), 'Клинопись', false, 'B'),
((SELECT id FROM questions WHERE question_text = 'Как называлась письменность древних египтян?' AND pool_id = 11), 'Финикийское письмо', false, 'C'),
((SELECT id FROM questions WHERE question_text = 'Как называлась письменность древних египтян?' AND pool_id = 11), 'Демотическое письмо', false, 'D');

-- Варианты для вопроса 5: Кто был учителем Александра Македонского?
INSERT INTO question_options (question_id, option_text, is_correct, option_letter) VALUES
((SELECT id FROM questions WHERE question_text = 'Кто был учителем Александра Македонского?' AND pool_id = 11), 'Аристотель', true, 'A'),
((SELECT id FROM questions WHERE question_text = 'Кто был учителем Александра Македонского?' AND pool_id = 11), 'Платон', false, 'B'),
((SELECT id FROM questions WHERE question_text = 'Кто был учителем Александра Македонского?' AND pool_id = 11), 'Сократ', false, 'C'),
((SELECT id FROM questions WHERE question_text = 'Кто был учителем Александра Македонского?' AND pool_id = 11), 'Диоген', false, 'D');

-- Варианты для вопроса 6: В каком году пал Западный Рим?
INSERT INTO question_options (question_id, option_text, is_correct, option_letter) VALUES
((SELECT id FROM questions WHERE question_text = 'В каком году пал Западный Рим?' AND pool_id = 11), '476', true, 'A'),
((SELECT id FROM questions WHERE question_text = 'В каком году пал Западный Рим?' AND pool_id = 11), '410', false, 'B'),
((SELECT id FROM questions WHERE question_text = 'В каком году пал Западный Рим?' AND pool_id = 11), '455', false, 'C'),
((SELECT id FROM questions WHERE question_text = 'В каком году пал Западный Рим?' AND pool_id = 11), '493', false, 'D');

-- Варианты для вопроса 7: Что такое зиккурат?
INSERT INTO question_options (question_id, option_text, is_correct, option_letter) VALUES
((SELECT id FROM questions WHERE question_text = 'Что такое зиккурат?' AND pool_id = 11), 'Ступенчатое сооружение в Месопотамии', true, 'A'),
((SELECT id FROM questions WHERE question_text = 'Что такое зиккурат?' AND pool_id = 11), 'Египетская пирамида', false, 'B'),
((SELECT id FROM questions WHERE question_text = 'Что такое зиккурат?' AND pool_id = 11), 'Греческий храм', false, 'C'),
((SELECT id FROM questions WHERE question_text = 'Что такое зиккурат?' AND pool_id = 11), 'Римский амфитеатр', false, 'D');

-- Варианты для вопроса 8: Кто создал первый свод законов?
INSERT INTO question_options (question_id, option_text, is_correct, option_letter) VALUES
((SELECT id FROM questions WHERE question_text = 'Кто создал первый свод законов?' AND pool_id = 11), 'Хаммурапи', true, 'A'),
((SELECT id FROM questions WHERE question_text = 'Кто создал первый свод законов?' AND pool_id = 11), 'Саргон Аккадский', false, 'B'),
((SELECT id FROM questions WHERE question_text = 'Кто создал первый свод законов?' AND pool_id = 11), 'Гильгамеш', false, 'C'),
((SELECT id FROM questions WHERE question_text = 'Кто создал первый свод законов?' AND pool_id = 11), 'Энкиду', false, 'D');

-- Варианты для вопроса 9: Что такое папирус?
INSERT INTO question_options (question_id, option_text, is_correct, option_letter) VALUES
((SELECT id FROM questions WHERE question_text = 'Что такое папирус?' AND pool_id = 11), 'Материал для письма из растения', true, 'A'),
((SELECT id FROM questions WHERE question_text = 'Что такое папирус?' AND pool_id = 11), 'Древнеегипетский бог', false, 'B'),
((SELECT id FROM questions WHERE question_text = 'Что такое папирус?' AND pool_id = 11), 'Вид папоротника', false, 'C'),
((SELECT id FROM questions WHERE question_text = 'Что такое папирус?' AND pool_id = 11), 'Египетская монета', false, 'D');

-- Варианты для вопроса 10: Кто была последней царицей Египта?
INSERT INTO question_options (question_id, option_text, is_correct, option_letter) VALUES
((SELECT id FROM questions WHERE question_text = 'Кто была последней царицей Египта?' AND pool_id = 11), 'Клеопатра', true, 'A'),
((SELECT id FROM questions WHERE question_text = 'Кто была последней царицей Египта?' AND pool_id = 11), 'Нефертити', false, 'B'),
((SELECT id FROM questions WHERE question_text = 'Кто была последней царицей Египта?' AND pool_id = 11), 'Хатшепсут', false, 'C'),
((SELECT id FROM questions WHERE question_text = 'Кто была последней царицей Египта?' AND pool_id = 11), 'Тий', false, 'D');

-- Варианты для вопроса 11: Что такое остракизм?
INSERT INTO question_options (question_id, option_text, is_correct, option_letter) VALUES
((SELECT id FROM questions WHERE question_text = 'Что такое остракизм?' AND pool_id = 11), 'Изгнание граждан в Древней Греции', true, 'A'),
((SELECT id FROM questions WHERE question_text = 'Что такое остракизм?' AND pool_id = 11), 'Вид гладиаторских боев', false, 'B'),
((SELECT id FROM questions WHERE question_text = 'Что такое остракизм?' AND pool_id = 11), 'Философская школа', false, 'C'),
((SELECT id FROM questions WHERE question_text = 'Что такое остракизм?' AND pool_id = 11), 'Музыкальный инструмент', false, 'D');

-- Варианты для вопроса 12: Кто написал "Илиаду" и "Одиссею"?
INSERT INTO question_options (question_id, option_text, is_correct, option_letter) VALUES
((SELECT id FROM questions WHERE question_text = 'Кто написал "Илиаду" и "Одиссею"?' AND pool_id = 11), 'Гомер', true, 'A'),
((SELECT id FROM questions WHERE question_text = 'Кто написал "Илиаду" и "Одиссею"?' AND pool_id = 11), 'Гесиод', false, 'B'),
((SELECT id FROM questions WHERE question_text = 'Кто написал "Илиаду" и "Одиссею"?' AND pool_id = 11), 'Сафо', false, 'C'),
((SELECT id FROM questions WHERE question_text = 'Кто написал "Илиаду" и "Одиссею"?' AND pool_id = 11), 'Пиндар', false, 'D');

-- Варианты для вопроса 13: Что такое преторианская гвардия?
INSERT INTO question_options (question_id, option_text, is_correct, option_letter) VALUES
((SELECT id FROM questions WHERE question_text = 'Что такое преторианская гвардия?' AND pool_id = 11), 'Личная охрана римских императоров', true, 'A'),
((SELECT id FROM questions WHERE question_text = 'Что такое преторианская гвардия?' AND pool_id = 11), 'Римский сенат', false, 'B'),
((SELECT id FROM questions WHERE question_text = 'Что такое преторианская гвардия?' AND pool_id = 11), 'Гладиаторская школа', false, 'C'),
((SELECT id FROM questions WHERE question_text = 'Что такое преторианская гвардия?' AND pool_id = 11), 'Римская армия', false, 'D');

-- Варианты для вопроса 14: Кто был первым императором Рима?
INSERT INTO question_options (question_id, option_text, is_correct, option_letter) VALUES
((SELECT id FROM questions WHERE question_text = 'Кто был первым императором Рима?' AND pool_id = 11), 'Октавиан Август', true, 'A'),
((SELECT id FROM questions WHERE question_text = 'Кто был первым императором Рима?' AND pool_id = 11), 'Юлий Цезарь', false, 'B'),
((SELECT id FROM questions WHERE question_text = 'Кто был первым императором Рима?' AND pool_id = 11), 'Марк Антоний', false, 'C'),
((SELECT id FROM questions WHERE question_text = 'Кто был первым императором Рима?' AND pool_id = 11), 'Брут', false, 'D');

-- Варианты для вопроса 15: Что такое Розеттский камень?
INSERT INTO question_options (question_id, option_text, is_correct, option_letter) VALUES
((SELECT id FROM questions WHERE question_text = 'Что такое Розеттский камень?' AND pool_id = 11), 'Камень с надписью на трех языках', true, 'A'),
((SELECT id FROM questions WHERE question_text = 'Что такое Розеттский камень?' AND pool_id = 11), 'Древнеегипетский обелиск', false, 'B'),
((SELECT id FROM questions WHERE question_text = 'Что такое Розеттский камень?' AND pool_id = 11), 'Римская колонна', false, 'C'),
((SELECT id FROM questions WHERE question_text = 'Что такое Розеттский камень?' AND pool_id = 11), 'Греческая стела', false, 'D');