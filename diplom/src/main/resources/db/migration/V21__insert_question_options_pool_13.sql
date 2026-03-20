-- Вставка вариантов ответов для вопросов пула 13 (Великие географические открытия)

-- Варианты для вопроса 1: Кто открыл Америку?
INSERT INTO question_options (question_id, option_text, is_correct, option_letter) VALUES
((SELECT id FROM questions WHERE question_text = 'Кто открыл Америку?' AND pool_id = 13), 'Христофор Колумб', true, 'A'),
((SELECT id FROM questions WHERE question_text = 'Кто открыл Америку?' AND pool_id = 13), 'Америго Веспуччи', false, 'B'),
((SELECT id FROM questions WHERE question_text = 'Кто открыл Америку?' AND pool_id = 13), 'Васко да Гама', false, 'C'),
((SELECT id FROM questions WHERE question_text = 'Кто открыл Америку?' AND pool_id = 13), 'Фернан Магеллан', false, 'D');

-- Варианты для вопроса 2: В каком году Васко да Гама достиг Индии?
INSERT INTO question_options (question_id, option_text, is_correct, option_letter) VALUES
((SELECT id FROM questions WHERE question_text = 'В каком году Васко да Гама достиг Индии?' AND pool_id = 13), '1498', true, 'A'),
((SELECT id FROM questions WHERE question_text = 'В каком году Васко да Гама достиг Индии?' AND pool_id = 13), '1492', false, 'B'),
((SELECT id FROM questions WHERE question_text = 'В каком году Васко да Гама достиг Индии?' AND pool_id = 13), '1500', false, 'C'),
((SELECT id FROM questions WHERE question_text = 'В каком году Васко да Гама достиг Индии?' AND pool_id = 13), '1488', false, 'D');

-- Варианты для вопроса 3: Кто первым обогнул мыс Доброй Надежды?
INSERT INTO question_options (question_id, option_text, is_correct, option_letter) VALUES
((SELECT id FROM questions WHERE question_text = 'Кто первым обогнул мыс Доброй Надежды?' AND pool_id = 13), 'Бартоломеу Диаш', true, 'A'),
((SELECT id FROM questions WHERE question_text = 'Кто первым обогнул мыс Доброй Надежды?' AND pool_id = 13), 'Васко да Гама', false, 'B'),
((SELECT id FROM questions WHERE question_text = 'Кто первым обогнул мыс Доброй Надежды?' AND pool_id = 13), 'Христофор Колумб', false, 'C'),
((SELECT id FROM questions WHERE question_text = 'Кто первым обогнул мыс Доброй Надежды?' AND pool_id = 13), 'Фернан Магеллан', false, 'D');

-- Варианты для вопроса 4: Какой мореплаватель совершил первое кругосветное путешествие?
INSERT INTO question_options (question_id, option_text, is_correct, option_letter) VALUES
((SELECT id FROM questions WHERE question_text = 'Какой мореплаватель совершил первое кругосветное путешествие?' AND pool_id = 13), 'Фернан Магеллан', true, 'A'),
((SELECT id FROM questions WHERE question_text = 'Какой мореплаватель совершил первое кругосветное путешествие?' AND pool_id = 13), 'Христофор Колумб', false, 'B'),
((SELECT id FROM questions WHERE question_text = 'Какой мореплаватель совершил первое кругосветное путешествие?' AND pool_id = 13), 'Васко да Гама', false, 'C'),
((SELECT id FROM questions WHERE question_text = 'Какой мореплаватель совершил первое кругосветное путешествие?' AND pool_id = 13), 'Америго Веспуччи', false, 'D');

-- Варианты для вопроса 5: Кто открыл морской путь в Индию?
INSERT INTO question_options (question_id, option_text, is_correct, option_letter) VALUES
((SELECT id FROM questions WHERE question_text = 'Кто открыл морской путь в Индию?' AND pool_id = 13), 'Васко да Гама', true, 'A'),
((SELECT id FROM questions WHERE question_text = 'Кто открыл морской путь в Индию?' AND pool_id = 13), 'Христофор Колумб', false, 'B'),
((SELECT id FROM questions WHERE question_text = 'Кто открыл морской путь в Индию?' AND pool_id = 13), 'Фернан Магеллан', false, 'C'),
((SELECT id FROM questions WHERE question_text = 'Кто открыл морской путь в Индию?' AND pool_id = 13), 'Бартоломеу Диаш', false, 'D');

-- Варианты для вопроса 6: В каком году был открыт Новый Свет?
INSERT INTO question_options (question_id, option_text, is_correct, option_letter) VALUES
((SELECT id FROM questions WHERE question_text = 'В каком году был открыт Новый Свет?' AND pool_id = 13), '1492', true, 'A'),
((SELECT id FROM questions WHERE question_text = 'В каком году был открыт Новый Свет?' AND pool_id = 13), '1498', false, 'B'),
((SELECT id FROM questions WHERE question_text = 'В каком году был открыт Новый Свет?' AND pool_id = 13), '1500', false, 'C'),
((SELECT id FROM questions WHERE question_text = 'В каком году был открыт Новый Свет?' AND pool_id = 13), '1488', false, 'D');

-- Варианты для вопроса 7: Кто открыл Тихий океан?
INSERT INTO question_options (question_id, option_text, is_correct, option_letter) VALUES
((SELECT id FROM questions WHERE question_text = 'Кто открыл Тихий океан?' AND pool_id = 13), 'Васко Нуньес де Бальбоа', true, 'A'),
((SELECT id FROM questions WHERE question_text = 'Кто открыл Тихий океан?' AND pool_id = 13), 'Фернан Магеллан', false, 'B'),
((SELECT id FROM questions WHERE question_text = 'Кто открыл Тихий океан?' AND pool_id = 13), 'Христофор Колумб', false, 'C'),
((SELECT id FROM questions WHERE question_text = 'Кто открыл Тихий океан?' AND pool_id = 13), 'Америго Веспуччи', false, 'D');

-- Варианты для вопроса 8: Какая страна первой начала колонизацию Америки?
INSERT INTO question_options (question_id, option_text, is_correct, option_letter) VALUES
((SELECT id FROM questions WHERE question_text = 'Какая страна первой начала колонизацию Америки?' AND pool_id = 13), 'Испания', true, 'A'),
((SELECT id FROM questions WHERE question_text = 'Какая страна первой начала колонизацию Америки?' AND pool_id = 13), 'Португалия', false, 'B'),
((SELECT id FROM questions WHERE question_text = 'Какая страна первой начала колонизацию Америки?' AND pool_id = 13), 'Англия', false, 'C'),
((SELECT id FROM questions WHERE question_text = 'Какая страна первой начала колонизацию Америки?' AND pool_id = 13), 'Франция', false, 'D');

-- Варианты для вопроса 9: Кто открыл Австралию?
INSERT INTO question_options (question_id, option_text, is_correct, option_letter) VALUES
((SELECT id FROM questions WHERE question_text = 'Кто открыл Австралию?' AND pool_id = 13), 'Джеймс Кук', true, 'A'),
((SELECT id FROM questions WHERE question_text = 'Кто открыл Австралию?' AND pool_id = 13), 'Абель Тасман', false, 'B'),
((SELECT id FROM questions WHERE question_text = 'Кто открыл Австралию?' AND pool_id = 13), 'Уильям Дампир', false, 'C'),
((SELECT id FROM questions WHERE question_text = 'Кто открыл Австралию?' AND pool_id = 13), 'Луис Ваэс де Торрес', false, 'D');

-- Варианты для вопроса 10: В каком году был открыт пролив между Азией и Америкой?
INSERT INTO question_options (question_id, option_text, is_correct, option_letter) VALUES
((SELECT id FROM questions WHERE question_text = 'В каком году был открыт пролив между Азией и Америкой?' AND pool_id = 13), '1728', true, 'A'),
((SELECT id FROM questions WHERE question_text = 'В каком году был открыт пролив между Азией и Америкой?' AND pool_id = 13), '1576', false, 'B'),
((SELECT id FROM questions WHERE question_text = 'В каком году был открыт пролив между Азией и Америкой?' AND pool_id = 13), '1648', false, 'C'),
((SELECT id FROM questions WHERE question_text = 'В каком году был открыт пролив между Азией и Америкой?' AND pool_id = 13), '1778', false, 'D');

-- Варианты для вопроса 11: Кто исследовал побережье Африки для португальцев?
INSERT INTO question_options (question_id, option_text, is_correct, option_letter) VALUES
((SELECT id FROM questions WHERE question_text = 'Кто исследовал побережье Африки для португальцев?' AND pool_id = 13), 'Генрих Мореплаватель', true, 'A'),
((SELECT id FROM questions WHERE question_text = 'Кто исследовал побережье Африки для португальцев?' AND pool_id = 13), 'Васко да Гама', false, 'B'),
((SELECT id FROM questions WHERE question_text = 'Кто исследовал побережье Африки для португальцев?' AND pool_id = 13), 'Бартоломеу Диаш', false, 'C'),
((SELECT id FROM questions WHERE question_text = 'Кто исследовал побережье Африки для португальцев?' AND pool_id = 13), 'Педру Алвариш Кабрал', false, 'D');

-- Варианты для вопроса 12: Какой мореплаватель искал Северо-Западный проход?
INSERT INTO question_options (question_id, option_text, is_correct, option_letter) VALUES
((SELECT id FROM questions WHERE question_text = 'Какой мореплаватель искал Северо-Западный проход?' AND pool_id = 13), 'Джон Кабот', true, 'A'),
((SELECT id FROM questions WHERE question_text = 'Какой мореплаватель искал Северо-Западный проход?' AND pool_id = 13), 'Мартин Фробишер', false, 'B'),
((SELECT id FROM questions WHERE question_text = 'Какой мореплаватель искал Северо-Западный проход?' AND pool_id = 13), 'Генри Гудзон', false, 'C'),
((SELECT id FROM questions WHERE question_text = 'Какой мореплаватель искал Северо-Западный проход?' AND pool_id = 13), 'Уильям Баффин', false, 'D');

-- Варианты для вопроса 13: Кто основал первую европейскую колонию в Америке?
INSERT INTO question_options (question_id, option_text, is_correct, option_letter) VALUES
((SELECT id FROM questions WHERE question_text = 'Кто основал первую европейскую колонию в Америке?' AND pool_id = 13), 'Христофор Колумб', true, 'A'),
((SELECT id FROM questions WHERE question_text = 'Кто основал первую европейскую колонию в Америке?' AND pool_id = 13), 'Америго Веспуччи', false, 'B'),
((SELECT id FROM questions WHERE question_text = 'Кто основал первую европейскую колонию в Америке?' AND pool_id = 13), 'Джон Кабот', false, 'C'),
((SELECT id FROM questions WHERE question_text = 'Кто основал первую европейскую колонию в Америке?' AND pool_id = 13), 'Понсе де Леон', false, 'D');

-- Варианты для вопроса 14: Какая экспедиция первой достигла Южного полюса?
INSERT INTO question_options (question_id, option_text, is_correct, option_letter) VALUES
((SELECT id FROM questions WHERE question_text = 'Какая экспедиция первой достигла Южного полюса?' AND pool_id = 13), 'Руал Амундсен', true, 'A'),
((SELECT id FROM questions WHERE question_text = 'Какая экспедиция первой достигла Южного полюса?' AND pool_id = 13), 'Роберт Скотт', false, 'B'),
((SELECT id FROM questions WHERE question_text = 'Какая экспедиция первой достигла Южного полюса?' AND pool_id = 13), 'Эрнест Шеклтон', false, 'C'),
((SELECT id FROM questions WHERE question_text = 'Какая экспедиция первой достигла Южного полюса?' AND pool_id = 13), 'Дуглас Моусон', false, 'D');

-- Варианты для вопроса 15: Кто открыл Антарктиду?
INSERT INTO question_options (question_id, option_text, is_correct, option_letter) VALUES
((SELECT id FROM questions WHERE question_text = 'Кто открыл Антарктиду?' AND pool_id = 13), 'Фабьян Готтлиб фон Беллинсгаузен и Михаил Лазарев', true, 'A'),
((SELECT id FROM questions WHERE question_text = 'Кто открыл Антарктиду?' AND pool_id = 13), 'Джеймс Кук', false, 'B'),
((SELECT id FROM questions WHERE question_text = 'Кто открыл Антарктиду?' AND pool_id = 13), 'Руал Амундсен', false, 'C'),
((SELECT id FROM questions WHERE question_text = 'Кто открыл Антарктиду?' AND pool_id = 13), 'Эдмунд Хиллари', false, 'D');