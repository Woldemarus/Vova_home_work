-- Вставка вариантов ответов для вопросов пула 4 (Медицина и здоровье)

-- Варианты для вопроса 1: Сколько костей в теле взрослого человека?
INSERT INTO question_options (question_id, option_text, is_correct, option_letter) VALUES
((SELECT id FROM questions WHERE question_text = 'Сколько костей в теле взрослого человека?' AND pool_id = 4), '206', true, 'A'),
((SELECT id FROM questions WHERE question_text = 'Сколько костей в теле взрослого человека?' AND pool_id = 4), '198', false, 'B'),
((SELECT id FROM questions WHERE question_text = 'Сколько костей в теле взрослого человека?' AND pool_id = 4), '215', false, 'C'),
((SELECT id FROM questions WHERE question_text = 'Сколько костей в теле взрослого человека?' AND pool_id = 4), '220', false, 'D');

-- Варианты для вопроса 2: Кто открыл группы крови?
INSERT INTO question_options (question_id, option_text, is_correct, option_letter) VALUES
((SELECT id FROM questions WHERE question_text = 'Кто открыл группы крови?' AND pool_id = 4), 'Карл Ландштейнер', true, 'A'),
((SELECT id FROM questions WHERE question_text = 'Кто открыл группы крови?' AND pool_id = 4), 'Ян Янский', false, 'B'),
((SELECT id FROM questions WHERE question_text = 'Кто открыл группы крови?' AND pool_id = 4), 'Вильям Харви', false, 'C'),
((SELECT id FROM questions WHERE question_text = 'Кто открыл группы крови?' AND pool_id = 4), 'Александр Флеминг', false, 'D');

-- Варианты для вопроса 3: Какой орган вырабатывает инсулин?
INSERT INTO question_options (question_id, option_text, is_correct, option_letter) VALUES
((SELECT id FROM questions WHERE question_text = 'Какой орган вырабатывает инсулин?' AND pool_id = 4), 'Поджелудочная железа', true, 'A'),
((SELECT id FROM questions WHERE question_text = 'Какой орган вырабатывает инсулин?' AND pool_id = 4), 'Печень', false, 'B'),
((SELECT id FROM questions WHERE question_text = 'Какой орган вырабатывает инсулин?' AND pool_id = 4), 'Щитовидная железа', false, 'C'),
((SELECT id FROM questions WHERE question_text = 'Какой орган вырабатывает инсулин?' AND pool_id = 4), 'Надпочечники', false, 'D');

-- Варианты для вопроса 4: В каком году была проведена первая пересадка сердца?
INSERT INTO question_options (question_id, option_text, is_correct, option_letter) VALUES
((SELECT id FROM questions WHERE question_text = 'В каком году была проведена первая пересадка сердца?' AND pool_id = 4), '1967', true, 'A'),
((SELECT id FROM questions WHERE question_text = 'В каком году была проведена первая пересадка сердца?' AND pool_id = 4), '1968', false, 'B'),
((SELECT id FROM questions WHERE question_text = 'В каком году была проведена первая пересадка сердца?' AND pool_id = 4), '1966', false, 'C'),
((SELECT id FROM questions WHERE question_text = 'В каком году была проведена первая пересадка сердца?' AND pool_id = 4), '1969', false, 'D');

-- Варианты для вопроса 5: Кто изобрел стетоскоп?
INSERT INTO question_options (question_id, option_text, is_correct, option_letter) VALUES
((SELECT id FROM questions WHERE question_text = 'Кто изобрел стетоскоп?' AND pool_id = 4), 'Рене Лаэннек', true, 'A'),
((SELECT id FROM questions WHERE question_text = 'Кто изобрел стетоскоп?' AND pool_id = 4), 'Вильям Осслер', false, 'B'),
((SELECT id FROM questions WHERE question_text = 'Кто изобрел стетоскоп?' AND pool_id = 4), 'Уильям Рентген', false, 'C'),
((SELECT id FROM questions WHERE question_text = 'Кто изобрел стетоскоп?' AND pool_id = 4), 'Зигмунд Фрейд', false, 'D');

-- Варианты для вопроса 6: Какой витамин синтезируется в коже под действием солнца?
INSERT INTO question_options (question_id, option_text, is_correct, option_letter) VALUES
((SELECT id FROM questions WHERE question_text = 'Какой витамин синтезируется в коже под действием солнца?' AND pool_id = 4), 'D', true, 'A'),
((SELECT id FROM questions WHERE question_text = 'Какой витамин синтезируется в коже под действием солнца?' AND pool_id = 4), 'A', false, 'B'),
((SELECT id FROM questions WHERE question_text = 'Какой витамин синтезируется в коже под действием солнца?' AND pool_id = 4), 'C', false, 'C'),
((SELECT id FROM questions WHERE question_text = 'Какой витамин синтезируется в коже под действием солнца?' AND pool_id = 4), 'B12', false, 'D');

-- Варианты для вопроса 7: Кто открыл возбудителя туберкулеза?
INSERT INTO question_options (question_id, option_text, is_correct, option_letter) VALUES
((SELECT id FROM questions WHERE question_text = 'Кто открыл возбудителя туберкулеза?' AND pool_id = 4), 'Роберт Кох', true, 'A'),
((SELECT id FROM questions WHERE question_text = 'Кто открыл возбудителя туберкулеза?' AND pool_id = 4), 'Луи Пастер', false, 'B'),
((SELECT id FROM questions WHERE question_text = 'Кто открыл возбудителя туберкулеза?' AND pool_id = 4), 'Александр Флеминг', false, 'C'),
((SELECT id FROM questions WHERE question_text = 'Кто открыл возбудителя туберкулеза?' AND pool_id = 4), 'Илья Мечников', false, 'D');

-- Варианты для вопроса 8: В каком году был открыт рентген?
INSERT INTO question_options (question_id, option_text, is_correct, option_letter) VALUES
((SELECT id FROM questions WHERE question_text = 'В каком году был открыт рентген?' AND pool_id = 4), '1895', true, 'A'),
((SELECT id FROM questions WHERE question_text = 'В каком году был открыт рентген?' AND pool_id = 4), '1896', false, 'B'),
((SELECT id FROM questions WHERE question_text = 'В каком году был открыт рентген?' AND pool_id = 4), '1894', false, 'C'),
((SELECT id FROM questions WHERE question_text = 'В каком году был открыт рентген?' AND pool_id = 4), '1897', false, 'D');

-- Варианты для вопроса 9: Кто разработал первую вакцину против полиомиелита?
INSERT INTO question_options (question_id, option_text, is_correct, option_letter) VALUES
((SELECT id FROM questions WHERE question_text = 'Кто разработал первую вакцину против полиомиелита?' AND pool_id = 4), 'Джонас Солк', true, 'A'),
((SELECT id FROM questions WHERE question_text = 'Кто разработал первую вакцину против полиомиелита?' AND pool_id = 4), 'Альберт Сэбин', false, 'B'),
((SELECT id FROM questions WHERE question_text = 'Кто разработал первую вакцину против полиомиелита?' AND pool_id = 4), 'Эдвард Дженнер', false, 'C'),
((SELECT id FROM questions WHERE question_text = 'Кто разработал первую вакцину против полиомиелита?' AND pool_id = 4), 'Луи Пастер', false, 'D');

-- Варианты для вопроса 10: Какой гормон регулирует уровень сахара в крови?
INSERT INTO question_options (question_id, option_text, is_correct, option_letter) VALUES
((SELECT id FROM questions WHERE question_text = 'Какой гормон регулирует уровень сахара в крови?' AND pool_id = 4), 'Инсулин', true, 'A'),
((SELECT id FROM questions WHERE question_text = 'Какой гормон регулирует уровень сахара в крови?' AND pool_id = 4), 'Адреналин', false, 'B'),
((SELECT id FROM questions WHERE question_text = 'Какой гормон регулирует уровень сахара в крови?' AND pool_id = 4), 'Тироксин', false, 'C'),
((SELECT id FROM questions WHERE question_text = 'Какой гормон регулирует уровень сахара в крови?' AND pool_id = 4), 'Глюкагон', false, 'D');

-- Варианты для вопроса 11: Кто впервые применил наркоз в хирургии?
INSERT INTO question_options (question_id, option_text, is_correct, option_letter) VALUES
((SELECT id FROM questions WHERE question_text = 'Кто впервые применил наркоз в хирургии?' AND pool_id = 4), 'Уильям Мортон', true, 'A'),
((SELECT id FROM questions WHERE question_text = 'Кто впервые применил наркоз в хирургии?' AND pool_id = 4), 'Кроуфорд Лонг', false, 'B'),
((SELECT id FROM questions WHERE question_text = 'Кто впервые применил наркоз в хирургии?' AND pool_id = 4), 'Гораций Уэллс', false, 'C'),
((SELECT id FROM questions WHERE question_text = 'Кто впервые применил наркоз в хирургии?' AND pool_id = 4), 'Чарльз Джексон', false, 'D');

-- Варианты для вопроса 12: В каком году была открыта структура гемоглобина?
INSERT INTO question_options (question_id, option_text, is_correct, option_letter) VALUES
((SELECT id FROM questions WHERE question_text = 'В каком году была открыта структура гемоглобина?' AND pool_id = 4), '1959', true, 'A'),
((SELECT id FROM questions WHERE question_text = 'В каком году была открыта структура гемоглобина?' AND pool_id = 4), '1960', false, 'B'),
((SELECT id FROM questions WHERE question_text = 'В каком году была открыта структура гемоглобина?' AND pool_id = 4), '1958', false, 'C'),
((SELECT id FROM questions WHERE question_text = 'В каком году была открыта структура гемоглобина?' AND pool_id = 4), '1961', false, 'D');

-- Варианты для вопроса 13: Кто разработал метод ПЦР?
INSERT INTO question_options (question_id, option_text, is_correct, option_letter) VALUES
((SELECT id FROM questions WHERE question_text = 'Кто разработал метод ПЦР?' AND pool_id = 4), 'Кэри Муллис', true, 'A'),
((SELECT id FROM questions WHERE question_text = 'Кто разработал метод ПЦР?' AND pool_id = 4), 'Фрэнсис Коллинз', false, 'B'),
((SELECT id FROM questions WHERE question_text = 'Кто разработал метод ПЦР?' AND pool_id = 4), 'Крейг Вентер', false, 'C'),
((SELECT id FROM questions WHERE question_text = 'Кто разработал метод ПЦР?' AND pool_id = 4), 'Джеймс Уотсон', false, 'D');

-- Варианты для вопроса 14: Какой фермент используется для репликации ДНК?
INSERT INTO question_options (question_id, option_text, is_correct, option_letter) VALUES
((SELECT id FROM questions WHERE question_text = 'Какой фермент используется для репликации ДНК?' AND pool_id = 4), 'ДНК-полимераза', true, 'A'),
((SELECT id FROM questions WHERE question_text = 'Какой фермент используется для репликации ДНК?' AND pool_id = 4), 'РНК-полимераза', false, 'B'),
((SELECT id FROM questions WHERE question_text = 'Какой фермент используется для репликации ДНК?' AND pool_id = 4), 'Ревертаза', false, 'C'),
((SELECT id FROM questions WHERE question_text = 'Какой фермент используется для репликации ДНК?' AND pool_id = 4), 'Лигазa', false, 'D');

-- Варианты для вопроса 15: Кто впервые клонировал млекопитающее?
INSERT INTO question_options (question_id, option_text, is_correct, option_letter) VALUES
((SELECT id FROM questions WHERE question_text = 'Кто впервые клонировал млекопитающее?' AND pool_id = 4), 'Иэн Уилмут', true, 'A'),
((SELECT id FROM questions WHERE question_text = 'Кто впервые клонировал млекопитающее?' AND pool_id = 4), 'Джон Гердон', false, 'B'),
((SELECT id FROM questions WHERE question_text = 'Кто впервые клонировал млекопитающее?' AND pool_id = 4), 'Кит Кэмпбелл', false, 'C'),
((SELECT id FROM questions WHERE question_text = 'Кто впервые клонировал млекопитающее?' AND pool_id = 4), 'Стивен Стёртевант', false, 'D');