-- Вставка вариантов ответов для вопросов пула 15 (СССР и современная Россия)

-- Варианты для вопроса 1: В каком году произошла Октябрьская революция?
INSERT INTO question_options (question_id, option_text, is_correct, option_letter) VALUES
((SELECT id FROM questions WHERE question_text = 'В каком году произошла Октябрьская революция?' AND pool_id = 15), '1917', true, 'A'),
((SELECT id FROM questions WHERE question_text = 'В каком году произошла Октябрьская революция?' AND pool_id = 15), '1918', false, 'B'),
((SELECT id FROM questions WHERE question_text = 'В каком году произошла Октябрьская революция?' AND pool_id = 15), '1916', false, 'C'),
((SELECT id FROM questions WHERE question_text = 'В каком году произошла Октябрьская революция?' AND pool_id = 15), '1919', false, 'D');

-- Варианты для вопроса 2: Кто был первым руководителем СССР?
INSERT INTO question_options (question_id, option_text, is_correct, option_letter) VALUES
((SELECT id FROM questions WHERE question_text = 'Кто был первым руководителем СССР?' AND pool_id = 15), 'Владимир Ленин', true, 'A'),
((SELECT id FROM questions WHERE question_text = 'Кто был первым руководителем СССР?' AND pool_id = 15), 'Иосиф Сталин', false, 'B'),
((SELECT id FROM questions WHERE question_text = 'Кто был первым руководителем СССР?' AND pool_id = 15), 'Лев Троцкий', false, 'C'),
((SELECT id FROM questions WHERE question_text = 'Кто был первым руководителем СССР?' AND pool_id = 15), 'Николай Бухарин', false, 'D');

-- Варианты для вопроса 3: В каком году началась Великая Отечественная война?
INSERT INTO question_options (question_id, option_text, is_correct, option_letter) VALUES
((SELECT id FROM questions WHERE question_text = 'В каком году началась Великая Отечественная война?' AND pool_id = 15), '1941', true, 'A'),
((SELECT id FROM questions WHERE question_text = 'В каком году началась Великая Отечественная война?' AND pool_id = 15), '1940', false, 'B'),
((SELECT id FROM questions WHERE question_text = 'В каком году началась Великая Отечественная война?' AND pool_id = 15), '1942', false, 'C'),
((SELECT id FROM questions WHERE question_text = 'В каком году началась Великая Отечественная война?' AND pool_id = 15), '1939', false, 'D');

-- Варианты для вопроса 4: Кто был Генеральным секретарем ЦК КПСС после Сталина?
INSERT INTO question_options (question_id, option_text, is_correct, option_letter) VALUES
((SELECT id FROM questions WHERE question_text = 'Кто был Генеральным секретарем ЦК КПСС после Сталина?' AND pool_id = 15), 'Никита Хрущев', true, 'A'),
((SELECT id FROM questions WHERE question_text = 'Кто был Генеральным секретарем ЦК КПСС после Сталина?' AND pool_id = 15), 'Леонид Брежнев', false, 'B'),
((SELECT id FROM questions WHERE question_text = 'Кто был Генеральным секретарем ЦК КПСС после Сталина?' AND pool_id = 15), 'Юрий Андропов', false, 'C'),
((SELECT id FROM questions WHERE question_text = 'Кто был Генеральным секретарем ЦК КПСС после Сталина?' AND pool_id = 15), 'Константин Черненко', false, 'D');

-- Варианты для вопроса 5: В каком году был запущен первый спутник?
INSERT INTO question_options (question_id, option_text, is_correct, option_letter) VALUES
((SELECT id FROM questions WHERE question_text = 'В каком году был запущен первый спутник?' AND pool_id = 15), '1957', true, 'A'),
((SELECT id FROM questions WHERE question_text = 'В каком году был запущен первый спутник?' AND pool_id = 15), '1958', false, 'B'),
((SELECT id FROM questions WHERE question_text = 'В каком году был запущен первый спутник?' AND pool_id = 15), '1956', false, 'C'),
((SELECT id FROM questions WHERE question_text = 'В каком году был запущен первый спутник?' AND pool_id = 15), '1959', false, 'D');

-- Варианты для вопроса 6: Кто был первым президентом России?
INSERT INTO question_options (question_id, option_text, is_correct, option_letter) VALUES
((SELECT id FROM questions WHERE question_text = 'Кто был первым президентом России?' AND pool_id = 15), 'Борис Ельцин', true, 'A'),
((SELECT id FROM questions WHERE question_text = 'Кто был первым президентом России?' AND pool_id = 15), 'Владимир Путин', false, 'B'),
((SELECT id FROM questions WHERE question_text = 'Кто был первым президентом России?' AND pool_id = 15), 'Дмитрий Медведев', false, 'C'),
((SELECT id FROM questions WHERE question_text = 'Кто был первым президентом России?' AND pool_id = 15), 'Михаил Горбачев', false, 'D');

-- Варианты для вопроса 7: В каком году распался СССР?
INSERT INTO question_options (question_id, option_text, is_correct, option_letter) VALUES
((SELECT id FROM questions WHERE question_text = 'В каком году распался СССР?' AND pool_id = 15), '1991', true, 'A'),
((SELECT id FROM questions WHERE question_text = 'В каком году распался СССР?' AND pool_id = 15), '1990', false, 'B'),
((SELECT id FROM questions WHERE question_text = 'В каком году распался СССР?' AND pool_id = 15), '1992', false, 'C'),
((SELECT id FROM questions WHERE question_text = 'В каком году распался СССР?' AND pool_id = 15), '1989', false, 'D');

-- Варианты для вопроса 8: Что такое перестройка?
INSERT INTO question_options (question_id, option_text, is_correct, option_letter) VALUES
((SELECT id FROM questions WHERE question_text = 'Что такое перестройка?' AND pool_id = 15), 'Реформы в СССР в 1980-х', true, 'A'),
((SELECT id FROM questions WHERE question_text = 'Что такое перестройка?' AND pool_id = 15), 'Военная реформа', false, 'B'),
((SELECT id FROM questions WHERE question_text = 'Что такое перестройка?' AND pool_id = 15), 'Экономическая реформа', false, 'C'),
((SELECT id FROM questions WHERE question_text = 'Что такое перестройка?' AND pool_id = 15), 'Политическая реформа', false, 'D');

-- Варианты для вопроса 9: Кто провозгласил политику гласности?
INSERT INTO question_options (question_id, option_text, is_correct, option_letter) VALUES
((SELECT id FROM questions WHERE question_text = 'Кто провозгласил политику гласности?' AND pool_id = 15), 'Михаил Горбачев', true, 'A'),
((SELECT id FROM questions WHERE question_text = 'Кто провозгласил политику гласности?' AND pool_id = 15), 'Борис Ельцин', false, 'B'),
((SELECT id FROM questions WHERE question_text = 'Кто провозгласил политику гласности?' AND pool_id = 15), 'Никита Хрущев', false, 'C'),
((SELECT id FROM questions WHERE question_text = 'Кто провозгласил политику гласности?' AND pool_id = 15), 'Леонид Брежнев', false, 'D');

-- Варианты для вопроса 10: В каком году была принята Конституция РФ?
INSERT INTO question_options (question_id, option_text, is_correct, option_letter) VALUES
((SELECT id FROM questions WHERE question_text = 'В каком году была принята Конституция РФ?' AND pool_id = 15), '1993', true, 'A'),
((SELECT id FROM questions WHERE question_text = 'В каком году была принята Конституция РФ?' AND pool_id = 15), '1994', false, 'B'),
((SELECT id FROM questions WHERE question_text = 'В каком году была принята Конституция РФ?' AND pool_id = 15), '1992', false, 'C'),
((SELECT id FROM questions WHERE question_text = 'В каком году была принята Конституция РФ?' AND pool_id = 15), '1995', false, 'D');

-- Варианты для вопроса 11: Кто был архитектором экономических реформ 1990-х?
INSERT INTO question_options (question_id, option_text, is_correct, option_letter) VALUES
((SELECT id FROM questions WHERE question_text = 'Кто был архитектором экономических реформ 1990-х?' AND pool_id = 15), 'Егор Гайдар', true, 'A'),
((SELECT id FROM questions WHERE question_text = 'Кто был архитектором экономических реформ 1990-х?' AND pool_id = 15), 'Анатолий Чубайс', false, 'B'),
((SELECT id FROM questions WHERE question_text = 'Кто был архитектором экономических реформ 1990-х?' AND pool_id = 15), 'Борис Немцов', false, 'C'),
((SELECT id FROM questions WHERE question_text = 'Кто был архитектором экономических реформ 1990-х?' AND pool_id = 15), 'Сергей Кириенко', false, 'D');

-- Варианты для вопроса 12: В каком году произошел путч ГКЧП?
INSERT INTO question_options (question_id, option_text, is_correct, option_letter) VALUES
((SELECT id FROM questions WHERE question_text = 'В каком году произошел путч ГКЧП?' AND pool_id = 15), '1991', true, 'A'),
((SELECT id FROM questions WHERE question_text = 'В каком году произошел путч ГКЧП?' AND pool_id = 15), '1990', false, 'B'),
((SELECT id FROM questions WHERE question_text = 'В каком году произошел путч ГКЧП?' AND pool_id = 15), '1992', false, 'C'),
((SELECT id FROM questions WHERE question_text = 'В каком году произошел путч ГКЧП?' AND pool_id = 15), '1989', false, 'D');

-- Варианты для вопроса 13: Кто стал президентом России в 2000 году?
INSERT INTO question_options (question_id, option_text, is_correct, option_letter) VALUES
((SELECT id FROM questions WHERE question_text = 'Кто стал президентом России в 2000 году?' AND pool_id = 15), 'Владимир Путин', true, 'A'),
((SELECT id FROM questions WHERE question_text = 'Кто стал президентом России в 2000 году?' AND pool_id = 15), 'Борис Ельцин', false, 'B'),
((SELECT id FROM questions WHERE question_text = 'Кто стал президентом России в 2000 году?' AND pool_id = 15), 'Дмитрий Медведев', false, 'C'),
((SELECT id FROM questions WHERE question_text = 'Кто стал президентом России в 2000 году?' AND pool_id = 15), 'Михаил Горбачев', false, 'D');

-- Варианты для вопроса 14: Что такое "оттепель" в СССР?
INSERT INTO question_options (question_id, option_text, is_correct, option_letter) VALUES
((SELECT id FROM questions WHERE question_text = 'Что такое "оттепель" в СССР?' AND pool_id = 15), 'Период либерализации после Сталина', true, 'A'),
((SELECT id FROM questions WHERE question_text = 'Что такое "оттепель" в СССР?' AND pool_id = 15), 'Экономический подъем', false, 'B'),
((SELECT id FROM questions WHERE question_text = 'Что такое "оттепель" в СССР?' AND pool_id = 15), 'Военная реформа', false, 'C'),
((SELECT id FROM questions WHERE question_text = 'Что такое "оттепель" в СССР?' AND pool_id = 15), 'Научный прогресс', false, 'D');

-- Варианты для вопроса 15: В каком году была создана СНГ?
INSERT INTO question_options (question_id, option_text, is_correct, option_letter) VALUES
((SELECT id FROM questions WHERE question_text = 'В каком году была создана СНГ?' AND pool_id = 15), '1991', true, 'A'),
((SELECT id FROM questions WHERE question_text = 'В каком году была создана СНГ?' AND pool_id = 15), '1992', false, 'B'),
((SELECT id FROM questions WHERE question_text = 'В каком году была создана СНГ?' AND pool_id = 15), '1990', false, 'C'),
((SELECT id FROM questions WHERE question_text = 'В каком году была создана СНГ?' AND pool_id = 15), '1993', false, 'D');