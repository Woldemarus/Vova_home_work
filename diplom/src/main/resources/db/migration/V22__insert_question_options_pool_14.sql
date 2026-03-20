-- Вставка вариантов ответов для вопросов пула 14 (Российская империя)

-- Варианты для вопроса 1: Кто основал Санкт-Петербург?
INSERT INTO question_options (question_id, option_text, is_correct, option_letter) VALUES
((SELECT id FROM questions WHERE question_text = 'Кто основал Санкт-Петербург?' AND pool_id = 14), 'Петр I', true, 'A'),
((SELECT id FROM questions WHERE question_text = 'Кто основал Санкт-Петербург?' AND pool_id = 14), 'Екатерина II', false, 'B'),
((SELECT id FROM questions WHERE question_text = 'Кто основал Санкт-Петербург?' AND pool_id = 14), 'Александр I', false, 'C'),
((SELECT id FROM questions WHERE question_text = 'Кто основал Санкт-Петербург?' AND pool_id = 14), 'Николай I', false, 'D');

-- Варианты для вопроса 2: В каком году произошла Полтавская битва?
INSERT INTO question_options (question_id, option_text, is_correct, option_letter) VALUES
((SELECT id FROM questions WHERE question_text = 'В каком году произошла Полтавская битва?' AND pool_id = 14), '1709', true, 'A'),
((SELECT id FROM questions WHERE question_text = 'В каком году произошла Полтавская битва?' AND pool_id = 14), '1708', false, 'B'),
((SELECT id FROM questions WHERE question_text = 'В каком году произошла Полтавская битва?' AND pool_id = 14), '1710', false, 'C'),
((SELECT id FROM questions WHERE question_text = 'В каком году произошла Полтавская битва?' AND pool_id = 14), '1707', false, 'D');

-- Варианты для вопроса 3: Кто была первой женщиной-императрицей России?
INSERT INTO question_options (question_id, option_text, is_correct, option_letter) VALUES
((SELECT id FROM questions WHERE question_text = 'Кто была первой женщиной-императрицей России?' AND pool_id = 14), 'Екатерина I', true, 'A'),
((SELECT id FROM questions WHERE question_text = 'Кто была первой женщиной-императрицей России?' AND pool_id = 14), 'Екатерина II', false, 'B'),
((SELECT id FROM questions WHERE question_text = 'Кто была первой женщиной-императрицей России?' AND pool_id = 14), 'Анна Иоанновна', false, 'C'),
((SELECT id FROM questions WHERE question_text = 'Кто была первой женщиной-императрицей России?' AND pool_id = 14), 'Елизавета Петровна', false, 'D');

-- Варианты для вопроса 4: В каком году было отменено крепостное право?
INSERT INTO question_options (question_id, option_text, is_correct, option_letter) VALUES
((SELECT id FROM questions WHERE question_text = 'В каком году было отменено крепостное право?' AND pool_id = 14), '1861', true, 'A'),
((SELECT id FROM questions WHERE question_text = 'В каком году было отменено крепостное право?' AND pool_id = 14), '1862', false, 'B'),
((SELECT id FROM questions WHERE question_text = 'В каком году было отменено крепостное право?' AND pool_id = 14), '1860', false, 'C'),
((SELECT id FROM questions WHERE question_text = 'В каком году было отменено крепостное право?' AND pool_id = 14), '1863', false, 'D');

-- Варианты для вопроса 5: Кто провел военные реформы в XIX веке?
INSERT INTO question_options (question_id, option_text, is_correct, option_letter) VALUES
((SELECT id FROM questions WHERE question_text = 'Кто провел военные реформы в XIX веке?' AND pool_id = 14), 'Дмитрий Милютин', true, 'A'),
((SELECT id FROM questions WHERE question_text = 'Кто провел военные реформы в XIX веке?' AND pool_id = 14), 'Михаил Лорис-Меликов', false, 'B'),
((SELECT id FROM questions WHERE question_text = 'Кто провел военные реформы в XIX веке?' AND pool_id = 14), 'Константин Победоносцев', false, 'C'),
((SELECT id FROM questions WHERE question_text = 'Кто провел военные реформы в XIX веке?' AND pool_id = 14), 'Сергей Витте', false, 'D');

-- Варианты для вопроса 6: Какая война называлась Отечественной?
INSERT INTO question_options (question_id, option_text, is_correct, option_letter) VALUES
((SELECT id FROM questions WHERE question_text = 'Какая война называлась Отечественной?' AND pool_id = 14), '1812 года', true, 'A'),
((SELECT id FROM questions WHERE question_text = 'Какая война называлась Отечественной?' AND pool_id = 14), '1853-1856 годов', false, 'B'),
((SELECT id FROM questions WHERE question_text = 'Какая война называлась Отечественной?' AND pool_id = 14), '1877-1878 годов', false, 'C'),
((SELECT id FROM questions WHERE question_text = 'Какая война называлась Отечественной?' AND pool_id = 14), '1904-1905 годов', false, 'D');

-- Варианты для вопроса 7: Кто был последним российским императором?
INSERT INTO question_options (question_id, option_text, is_correct, option_letter) VALUES
((SELECT id FROM questions WHERE question_text = 'Кто был последним российским императором?' AND pool_id = 14), 'Николай II', true, 'A'),
((SELECT id FROM questions WHERE question_text = 'Кто был последним российским императором?' AND pool_id = 14), 'Александр III', false, 'B'),
((SELECT id FROM questions WHERE question_text = 'Кто был последним российским императором?' AND pool_id = 14), 'Александр II', false, 'C'),
((SELECT id FROM questions WHERE question_text = 'Кто был последним российским императором?' AND pool_id = 14), 'Александр I', false, 'D');

-- Варианты для вопроса 8: В каком году произошло восстание декабристов?
INSERT INTO question_options (question_id, option_text, is_correct, option_letter) VALUES
((SELECT id FROM questions WHERE question_text = 'В каком году произошло восстание декабристов?' AND pool_id = 14), '1825', true, 'A'),
((SELECT id FROM questions WHERE question_text = 'В каком году произошло восстание декабристов?' AND pool_id = 14), '1826', false, 'B'),
((SELECT id FROM questions WHERE question_text = 'В каком году произошло восстание декабристов?' AND pool_id = 14), '1824', false, 'C'),
((SELECT id FROM questions WHERE question_text = 'В каком году произошло восстание декабристов?' AND pool_id = 14), '1827', false, 'D');

-- Варианты для вопроса 9: Кто написал "Историю государства Российского"?
INSERT INTO question_options (question_id, option_text, is_correct, option_letter) VALUES
((SELECT id FROM questions WHERE question_text = 'Кто написал "Историю государства Российского"?' AND pool_id = 14), 'Николай Карамзин', true, 'A'),
((SELECT id FROM questions WHERE question_text = 'Кто написал "Историю государства Российского"?' AND pool_id = 14), 'Василий Ключевский', false, 'B'),
((SELECT id FROM questions WHERE question_text = 'Кто написал "Историю государства Российского"?' AND pool_id = 14), 'Сергей Соловьев', false, 'C'),
((SELECT id FROM questions WHERE question_text = 'Кто написал "Историю государства Российского"?' AND pool_id = 14), 'Михаил Погодин', false, 'D');

-- Варианты для вопроса 10: Какая реформа была проведена Александром II?
INSERT INTO question_options (question_id, option_text, is_correct, option_letter) VALUES
((SELECT id FROM questions WHERE question_text = 'Какая реформа была проведена Александром II?' AND pool_id = 14), 'Отмена крепостного права', true, 'A'),
((SELECT id FROM questions WHERE question_text = 'Какая реформа была проведена Александром II?' AND pool_id = 14), 'Военная реформа', false, 'B'),
((SELECT id FROM questions WHERE question_text = 'Какая реформа была проведена Александром II?' AND pool_id = 14), 'Судебная реформа', false, 'C'),
((SELECT id FROM questions WHERE question_text = 'Какая реформа была проведена Александром II?' AND pool_id = 14), 'Земская реформа', false, 'D');

-- Варианты для вопроса 11: Кто был министром финансов при Николае II?
INSERT INTO question_options (question_id, option_text, is_correct, option_letter) VALUES
((SELECT id FROM questions WHERE question_text = 'Кто был министром финансов при Николае II?' AND pool_id = 14), 'Сергей Витте', true, 'A'),
((SELECT id FROM questions WHERE question_text = 'Кто был министром финансов при Николае II?' AND pool_id = 14), 'Владимир Коковцов', false, 'B'),
((SELECT id FROM questions WHERE question_text = 'Кто был министром финансов при Николае II?' AND pool_id = 14), 'Петр Столыпин', false, 'C'),
((SELECT id FROM questions WHERE question_text = 'Кто был министром финансов при Николае II?' AND pool_id = 14), 'Иван Горемыкин', false, 'D');

-- Варианты для вопроса 12: В каком году была построена Транссибирская магистраль?
INSERT INTO question_options (question_id, option_text, is_correct, option_letter) VALUES
((SELECT id FROM questions WHERE question_text = 'В каком году была построена Транссибирская магистраль?' AND pool_id = 14), '1903', true, 'A'),
((SELECT id FROM questions WHERE question_text = 'В каком году была построена Транссибирская магистраль?' AND pool_id = 14), '1904', false, 'B'),
((SELECT id FROM questions WHERE question_text = 'В каком году была построена Транссибирская магистраль?' AND pool_id = 14), '1902', false, 'C'),
((SELECT id FROM questions WHERE question_text = 'В каком году была построена Транссибирская магистраль?' AND pool_id = 14), '1905', false, 'D');

-- Варианты для вопроса 13: Кто возглавлял Первую русскую революцию?
INSERT INTO question_options (question_id, option_text, is_correct, option_letter) VALUES
((SELECT id FROM questions WHERE question_text = 'Кто возглавлял Первую русскую революцию?' AND pool_id = 14), 'Николай II', true, 'A'),
((SELECT id FROM questions WHERE question_text = 'Кто возглавлял Первую русскую революцию?' AND pool_id = 14), 'Лев Троцкий', false, 'B'),
((SELECT id FROM questions WHERE question_text = 'Кто возглавлял Первую русскую революцию?' AND pool_id = 14), 'Владимир Ленин', false, 'C'),
((SELECT id FROM questions WHERE question_text = 'Кто возглавлял Первую русскую революцию?' AND pool_id = 14), 'Георгий Плеханов', false, 'D');

-- Варианты для вопроса 14: Что такое столыпинская реформа?
INSERT INTO question_options (question_id, option_text, is_correct, option_letter) VALUES
((SELECT id FROM questions WHERE question_text = 'Что такое столыпинская реформа?' AND pool_id = 14), 'Аграрная реформа', true, 'A'),
((SELECT id FROM questions WHERE question_text = 'Что такое столыпинская реформа?' AND pool_id = 14), 'Военная реформа', false, 'B'),
((SELECT id FROM questions WHERE question_text = 'Что такое столыпинская реформа?' AND pool_id = 14), 'Судебная реформа', false, 'C'),
((SELECT id FROM questions WHERE question_text = 'Что такое столыпинская реформа?' AND pool_id = 14), 'Финансовая реформа', false, 'D');

-- Варианты для вопроса 15: Кто был председателем Совета министров в 1906-1911 гг?
INSERT INTO question_options (question_id, option_text, is_correct, option_letter) VALUES
((SELECT id FROM questions WHERE question_text = 'Кто был председателем Совета министров в 1906-1911 гг?' AND pool_id = 14), 'Петр Столыпин', true, 'A'),
((SELECT id FROM questions WHERE question_text = 'Кто был председателем Совета министров в 1906-1911 гг?' AND pool_id = 14), 'Сергей Витте', false, 'B'),
((SELECT id FROM questions WHERE question_text = 'Кто был председателем Совета министров в 1906-1911 гг?' AND pool_id = 14), 'Иван Горемыкин', false, 'C'),
((SELECT id FROM questions WHERE question_text = 'Кто был председателем Совета министров в 1906-1911 гг?' AND pool_id = 14), 'Владимир Коковцов', false, 'D');