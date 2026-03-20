-- Вставка вариантов ответов для вопросов пула 3 (Изобретения и технологии)

-- Варианты для вопроса 1: Кто изобрел колесо?
INSERT INTO question_options (question_id, option_text, is_correct, option_letter) VALUES
((SELECT id FROM questions WHERE question_text = 'Кто изобрел колесо?' AND pool_id = 3), 'Древние шумеры', true, 'A'),
((SELECT id FROM questions WHERE question_text = 'Кто изобрел колесо?' AND pool_id = 3), 'Древние египтяне', false, 'B'),
((SELECT id FROM questions WHERE question_text = 'Кто изобрел колесо?' AND pool_id = 3), 'Древние греки', false, 'C'),
((SELECT id FROM questions WHERE question_text = 'Кто изобрел колесо?' AND pool_id = 3), 'Древние римляне', false, 'D');

-- Варианты для вопроса 2: В каком году был создан интернет?
INSERT INTO question_options (question_id, option_text, is_correct, option_letter) VALUES
((SELECT id FROM questions WHERE question_text = 'В каком году был создан интернет?' AND pool_id = 3), '1969', true, 'A'),
((SELECT id FROM questions WHERE question_text = 'В каком году был создан интернет?' AND pool_id = 3), '1970', false, 'B'),
((SELECT id FROM questions WHERE question_text = 'В каком году был создан интернет?' AND pool_id = 3), '1968', false, 'C'),
((SELECT id FROM questions WHERE question_text = 'В каком году был создан интернет?' AND pool_id = 3), '1971', false, 'D');

-- Варианты для вопроса 3: Кто создал первый персональный компьютер?
INSERT INTO question_options (question_id, option_text, is_correct, option_letter) VALUES
((SELECT id FROM questions WHERE question_text = 'Кто создал первый персональный компьютер?' AND pool_id = 3), 'Эд Робертс', true, 'A'),
((SELECT id FROM questions WHERE question_text = 'Кто создал первый персональный компьютер?' AND pool_id = 3), 'Стив Джобс', false, 'B'),
((SELECT id FROM questions WHERE question_text = 'Кто создал первый персональный компьютер?' AND pool_id = 3), 'Билл Гейтс', false, 'C'),
((SELECT id FROM questions WHERE question_text = 'Кто создал первый персональный компьютер?' AND pool_id = 3), 'Пол Аллен', false, 'D');

-- Варианты для вопроса 4: В каком году была изобретена печатная машинка?
INSERT INTO question_options (question_id, option_text, is_correct, option_letter) VALUES
((SELECT id FROM questions WHERE question_text = 'В каком году была изобретена печатная машинка?' AND pool_id = 3), '1868', true, 'A'),
((SELECT id FROM questions WHERE question_text = 'В каком году была изобретена печатная машинка?' AND pool_id = 3), '1870', false, 'B'),
((SELECT id FROM questions WHERE question_text = 'В каком году была изобретена печатная машинка?' AND pool_id = 3), '1865', false, 'C'),
((SELECT id FROM questions WHERE question_text = 'В каком году была изобретена печатная машинка?' AND pool_id = 3), '1872', false, 'D');

-- Варианты для вопроса 5: Кто изобрел лампочку накаливания?
INSERT INTO question_options (question_id, option_text, is_correct, option_letter) VALUES
((SELECT id FROM questions WHERE question_text = 'Кто изобрел лампочку накаливания?' AND pool_id = 3), 'Томас Эдисон', true, 'A'),
((SELECT id FROM questions WHERE question_text = 'Кто изобрел лампочку накаливания?' AND pool_id = 3), 'Никола Тесла', false, 'B'),
((SELECT id FROM questions WHERE question_text = 'Кто изобрел лампочку накаливания?' AND pool_id = 3), 'Александр Белл', false, 'C'),
((SELECT id FROM questions WHERE question_text = 'Кто изобрел лампочку накаливания?' AND pool_id = 3), 'Георг Ом', false, 'D');

-- Варианты для вопроса 6: В каком году был создан первый транзистор?
INSERT INTO question_options (question_id, option_text, is_correct, option_letter) VALUES
((SELECT id FROM questions WHERE question_text = 'В каком году был создан первый транзистор?' AND pool_id = 3), '1947', true, 'A'),
((SELECT id FROM questions WHERE question_text = 'В каком году был создан первый транзистор?' AND pool_id = 3), '1948', false, 'B'),
((SELECT id FROM questions WHERE question_text = 'В каком году был создан первый транзистор?' AND pool_id = 3), '1946', false, 'C'),
((SELECT id FROM questions WHERE question_text = 'В каком году был создан первый транзистор?' AND pool_id = 3), '1949', false, 'D');

-- Варианты для вопроса 7: Кто изобрел радио?
INSERT INTO question_options (question_id, option_text, is_correct, option_letter) VALUES
((SELECT id FROM questions WHERE question_text = 'Кто изобрел радио?' AND pool_id = 3), 'Гульельмо Маркони', true, 'A'),
((SELECT id FROM questions WHERE question_text = 'Кто изобрел радио?' AND pool_id = 3), 'Александр Попов', false, 'B'),
((SELECT id FROM questions WHERE question_text = 'Кто изобрел радио?' AND pool_id = 3), 'Томас Эдисон', false, 'C'),
((SELECT id FROM questions WHERE question_text = 'Кто изобрел радио?' AND pool_id = 3), 'Никола Тесла', false, 'D');

-- Варианты для вопроса 8: В каком году была создана первая интегральная схема?
INSERT INTO question_options (question_id, option_text, is_correct, option_letter) VALUES
((SELECT id FROM questions WHERE question_text = 'В каком году была создана первая интегральная схема?' AND pool_id = 3), '1958', true, 'A'),
((SELECT id FROM questions WHERE question_text = 'В каком году была создана первая интегральная схема?' AND pool_id = 3), '1959', false, 'B'),
((SELECT id FROM questions WHERE question_text = 'В каком году была создана первая интегральная схема?' AND pool_id = 3), '1957', false, 'C'),
((SELECT id FROM questions WHERE question_text = 'В каком году была создана первая интегральная схема?' AND pool_id = 3), '1960', false, 'D');

-- Варианты для вопроса 9: Кто изобрел лазер?
INSERT INTO question_options (question_id, option_text, is_correct, option_letter) VALUES
((SELECT id FROM questions WHERE question_text = 'Кто изобрел лазер?' AND pool_id = 3), 'Теодор Мейман', true, 'A'),
((SELECT id FROM questions WHERE question_text = 'Кто изобрел лазер?' AND pool_id = 3), 'Чарльз Таунс', false, 'B'),
((SELECT id FROM questions WHERE question_text = 'Кто изобрел лазер?' AND pool_id = 3), 'Артур Шавлов', false, 'C'),
((SELECT id FROM questions WHERE question_text = 'Кто изобрел лазер?' AND pool_id = 3), 'Гордон Гулд', false, 'D');

-- Варианты для вопроса 10: В каком году был создан первый микропроцессор?
INSERT INTO question_options (question_id, option_text, is_correct, option_letter) VALUES
((SELECT id FROM questions WHERE question_text = 'В каком году был создан первый микропроцессор?' AND pool_id = 3), '1971', true, 'A'),
((SELECT id FROM questions WHERE question_text = 'В каком году был создан первый микропроцессор?' AND pool_id = 3), '1970', false, 'B'),
((SELECT id FROM questions WHERE question_text = 'В каком году был создан первый микропроцессор?' AND pool_id = 3), '1972', false, 'C'),
((SELECT id FROM questions WHERE question_text = 'В каком году был создан первый микропроцессор?' AND pool_id = 3), '1969', false, 'D');

-- Варианты для вопроса 11: Кто изобрел голографию?
INSERT INTO question_options (question_id, option_text, is_correct, option_letter) VALUES
((SELECT id FROM questions WHERE question_text = 'Кто изобрел голографию?' AND pool_id = 3), 'Деннис Габор', true, 'A'),
((SELECT id FROM questions WHERE question_text = 'Кто изобрел голографию?' AND pool_id = 3), 'Юрий Денисюк', false, 'B'),
((SELECT id FROM questions WHERE question_text = 'Кто изобрел голографию?' AND pool_id = 3), 'Эммет Лейт', false, 'C'),
((SELECT id FROM questions WHERE question_text = 'Кто изобрел голографию?' AND pool_id = 3), 'Стивен Бентон', false, 'D');

-- Варианты для вопроса 12: В каком году была создана первая оптоволоконная связь?
INSERT INTO question_options (question_id, option_text, is_correct, option_letter) VALUES
((SELECT id FROM questions WHERE question_text = 'В каком году была создана первая оптоволоконная связь?' AND pool_id = 3), '1970', true, 'A'),
((SELECT id FROM questions WHERE question_text = 'В каком году была создана первая оптоволоконная связь?' AND pool_id = 3), '1969', false, 'B'),
((SELECT id FROM questions WHERE question_text = 'В каком году была создана первая оптоволоконная связь?' AND pool_id = 3), '1971', false, 'C'),
((SELECT id FROM questions WHERE question_text = 'В каком году была создана первая оптоволоконная связь?' AND pool_id = 3), '1968', false, 'D');

-- Варианты для вопроса 13: Кто разработал технологию GPS?
INSERT INTO question_options (question_id, option_text, is_correct, option_letter) VALUES
((SELECT id FROM questions WHERE question_text = 'Кто разработал технологию GPS?' AND pool_id = 3), 'Военные США', true, 'A'),
((SELECT id FROM questions WHERE question_text = 'Кто разработал технологию GPS?' AND pool_id = 3), 'Иван Геттинг', false, 'B'),
((SELECT id FROM questions WHERE question_text = 'Кто разработал технологию GPS?' AND pool_id = 3), 'Ричард Кершнер', false, 'C'),
((SELECT id FROM questions WHERE question_text = 'Кто разработал технологию GPS?' AND pool_id = 3), 'Роджер Истон', false, 'D');

-- Варианты для вопроса 14: В каком году был создан первый квантовый компьютер?
INSERT INTO question_options (question_id, option_text, is_correct, option_letter) VALUES
((SELECT id FROM questions WHERE question_text = 'В каком году был создан первый квантовый компьютер?' AND pool_id = 3), '1994', true, 'A'),
((SELECT id FROM questions WHERE question_text = 'В каком году был создан первый квантовый компьютер?' AND pool_id = 3), '1995', false, 'B'),
((SELECT id FROM questions WHERE question_text = 'В каком году был создан первый квантовый компьютер?' AND pool_id = 3), '1993', false, 'C'),
((SELECT id FROM questions WHERE question_text = 'В каком году был создан первый квантовый компьютер?' AND pool_id = 3), '1996', false, 'D');

-- Варианты для вопроса 15: Кто разработал технологию блокчейн?
INSERT INTO question_options (question_id, option_text, is_correct, option_letter) VALUES
((SELECT id FROM questions WHERE question_text = 'Кто разработал технологию блокчейн?' AND pool_id = 3), 'Сатоши Накамото', true, 'A'),
((SELECT id FROM questions WHERE question_text = 'Кто разработал технологию блокчейн?' AND pool_id = 3), 'Виталик Бутерин', false, 'B'),
((SELECT id FROM questions WHERE question_text = 'Кто разработал технологию блокчейн?' AND pool_id = 3), 'Чарли Ли', false, 'C'),
((SELECT id FROM questions WHERE question_text = 'Кто разработал технологию блокчейн?' AND pool_id = 3), 'Крейг Райт', false, 'D');