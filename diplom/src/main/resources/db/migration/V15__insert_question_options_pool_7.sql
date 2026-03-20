-- Вставка вариантов ответов для вопросов пула 7 (Математика и логика)

-- Варианты для вопроса 1: Чему равно число π (пи)?
INSERT INTO question_options (question_id, option_text, is_correct, option_letter) VALUES
((SELECT id FROM questions WHERE question_text = 'Чему равно число π (пи)?' AND pool_id = 7), '3.14159...', true, 'A'),
((SELECT id FROM questions WHERE question_text = 'Чему равно число π (пи)?' AND pool_id = 7), '3.14', false, 'B'),
((SELECT id FROM questions WHERE question_text = 'Чему равно число π (пи)?' AND pool_id = 7), '3.1416', false, 'C'),
((SELECT id FROM questions WHERE question_text = 'Чему равно число π (пи)?' AND pool_id = 7), '3.1415', false, 'D');

-- Варианты для вопроса 2: Кто доказал теорему Пифагора?
INSERT INTO question_options (question_id, option_text, is_correct, option_letter) VALUES
((SELECT id FROM questions WHERE question_text = 'Кто доказал теорему Пифагора?' AND pool_id = 7), 'Пифагор', true, 'A'),
((SELECT id FROM questions WHERE question_text = 'Кто доказал теорему Пифагора?' AND pool_id = 7), 'Евклид', false, 'B'),
((SELECT id FROM questions WHERE question_text = 'Кто доказал теорему Пифагора?' AND pool_id = 7), 'Архимед', false, 'C'),
((SELECT id FROM questions WHERE question_text = 'Кто доказал теорему Пифагора?' AND pool_id = 7), 'Фалес', false, 'D');

-- Варианты для вопроса 3: Что такое число Эйлера (e)?
INSERT INTO question_options (question_id, option_text, is_correct, option_letter) VALUES
((SELECT id FROM questions WHERE question_text = 'Что такое число Эйлера (e)?' AND pool_id = 7), 'Основание натурального логарифма', true, 'A'),
((SELECT id FROM questions WHERE question_text = 'Что такое число Эйлера (e)?' AND pool_id = 7), 'Число π', false, 'B'),
((SELECT id FROM questions WHERE question_text = 'Что такое число Эйлера (e)?' AND pool_id = 7), 'Золотое сечение', false, 'C'),
((SELECT id FROM questions WHERE question_text = 'Что такое число Эйлера (e)?' AND pool_id = 7), 'Число φ', false, 'D');

-- Варианты для вопроса 4: Кто создал систему координат?
INSERT INTO question_options (question_id, option_text, is_correct, option_letter) VALUES
((SELECT id FROM questions WHERE question_text = 'Кто создал систему координат?' AND pool_id = 7), 'Рене Декарт', true, 'A'),
((SELECT id FROM questions WHERE question_text = 'Кто создал систему координат?' AND pool_id = 7), 'Исаак Ньютон', false, 'B'),
((SELECT id FROM questions WHERE question_text = 'Кто создал систему координат?' AND pool_id = 7), 'Готфрид Лейбниц', false, 'C'),
((SELECT id FROM questions WHERE question_text = 'Кто создал систему координат?' AND pool_id = 7), 'Леонард Эйлер', false, 'D');

-- Варианты для вопроса 5: Что изучает топология?
INSERT INTO question_options (question_id, option_text, is_correct, option_letter) VALUES
((SELECT id FROM questions WHERE question_text = 'Что изучает топология?' AND pool_id = 7), 'Свойства фигур при непрерывных преобразованиях', true, 'A'),
((SELECT id FROM questions WHERE question_text = 'Что изучает топология?' AND pool_id = 7), 'Геометрию плоскости', false, 'B'),
((SELECT id FROM questions WHERE question_text = 'Что изучает топология?' AND pool_id = 7), 'Алгебраические структуры', false, 'C'),
((SELECT id FROM questions WHERE question_text = 'Что изучает топология?' AND pool_id = 7), 'Теорию множеств', false, 'D');

-- Варианты для вопроса 6: Кто сформулировал великую теорему Ферма?
INSERT INTO question_options (question_id, option_text, is_correct, option_letter) VALUES
((SELECT id FROM questions WHERE question_text = 'Кто сформулировал великую теорему Ферма?' AND pool_id = 7), 'Пьер Ферма', true, 'A'),
((SELECT id FROM questions WHERE question_text = 'Кто сформулировал великую теорему Ферма?' AND pool_id = 7), 'Андрей Вейль', false, 'B'),
((SELECT id FROM questions WHERE question_text = 'Кто сформулировал великую теорему Ферма?' AND pool_id = 7), 'Эндрю Уайлс', false, 'C'),
((SELECT id FROM questions WHERE question_text = 'Кто сформулировал великую теорему Ферма?' AND pool_id = 7), 'Карл Гаусс', false, 'D');

-- Варианты для вопроса 7: Что такое золотое сечение?
INSERT INTO question_options (question_id, option_text, is_correct, option_letter) VALUES
((SELECT id FROM questions WHERE question_text = 'Что такое золотое сечение?' AND pool_id = 7), 'Отношение 1:1.618', true, 'A'),
((SELECT id FROM questions WHERE question_text = 'Что такое золотое сечение?' AND pool_id = 7), 'Отношение 1:2', false, 'B'),
((SELECT id FROM questions WHERE question_text = 'Что такое золотое сечение?' AND pool_id = 7), 'Отношение 1:√2', false, 'C'),
((SELECT id FROM questions WHERE question_text = 'Что такое золотое сечение?' AND pool_id = 7), 'Отношение 1:π', false, 'D');

-- Варианты для вопроса 8: Кто разработал дифференциальное исчисление?
INSERT INTO question_options (question_id, option_text, is_correct, option_letter) VALUES
((SELECT id FROM questions WHERE question_text = 'Кто разработал дифференциальное исчисление?' AND pool_id = 7), 'Исаак Ньютон и Готфрид Лейбниц', true, 'A'),
((SELECT id FROM questions WHERE question_text = 'Кто разработал дифференциальное исчисление?' AND pool_id = 7), 'Карл Гаусс', false, 'B'),
((SELECT id FROM questions WHERE question_text = 'Кто разработал дифференциальное исчисление?' AND pool_id = 7), 'Леонард Эйлер', false, 'C'),
((SELECT id FROM questions WHERE question_text = 'Кто разработал дифференциальное исчисление?' AND pool_id = 7), 'Жозеф Фурье', false, 'D');

-- Варианты для вопроса 9: Что изучает теория множеств?
INSERT INTO question_options (question_id, option_text, is_correct, option_letter) VALUES
((SELECT id FROM questions WHERE question_text = 'Что изучает теория множеств?' AND pool_id = 7), 'Свойства множеств и операций над ними', true, 'A'),
((SELECT id FROM questions WHERE question_text = 'Что изучает теория множеств?' AND pool_id = 7), 'Числа и их свойства', false, 'B'),
((SELECT id FROM questions WHERE question_text = 'Что изучает теория множеств?' AND pool_id = 7), 'Геометрические фигуры', false, 'C'),
((SELECT id FROM questions WHERE question_text = 'Что изучает теория множеств?' AND pool_id = 7), 'Логические операции', false, 'D');

-- Варианты для вопроса 10: Кто доказал теорему о четырех красках?
INSERT INTO question_options (question_id, option_text, is_correct, option_letter) VALUES
((SELECT id FROM questions WHERE question_text = 'Кто доказал теорему о четырех красках?' AND pool_id = 7), 'Кеннет Аппель и Вольфганг Хакен', true, 'A'),
((SELECT id FROM questions WHERE question_text = 'Кто доказал теорему о четырех красках?' AND pool_id = 7), 'Пол Эрдёш', false, 'B'),
((SELECT id FROM questions WHERE question_text = 'Кто доказал теорему о четырех красках?' AND pool_id = 7), 'Джон Нэш', false, 'C'),
((SELECT id FROM questions WHERE question_text = 'Кто доказал теорему о четырех красках?' AND pool_id = 7), 'Курт Гёдель', false, 'D');

-- Варианты для вопроса 11: Что такое гипотеза Римана?
INSERT INTO question_options (question_id, option_text, is_correct, option_letter) VALUES
((SELECT id FROM questions WHERE question_text = 'Что такое гипотеза Римана?' AND pool_id = 7), 'О нулях дзета-функции', true, 'A'),
((SELECT id FROM questions WHERE question_text = 'Что такое гипотеза Римана?' AND pool_id = 7), 'О простых числах', false, 'B'),
((SELECT id FROM questions WHERE question_text = 'Что такое гипотеза Римана?' AND pool_id = 7), 'О трансцендентных числах', false, 'C'),
((SELECT id FROM questions WHERE question_text = 'Что такое гипотеза Римана?' AND pool_id = 7), 'О континуум-гипотезе', false, 'D');

-- Варианты для вопроса 12: Кто создал теорию категорий?
INSERT INTO question_options (question_id, option_text, is_correct, option_letter) VALUES
((SELECT id FROM questions WHERE question_text = 'Кто создал теорию категорий?' AND pool_id = 7), 'Самуэль Айленберг и Сондерс Маклейн', true, 'A'),
((SELECT id FROM questions WHERE question_text = 'Кто создал теорию категорий?' AND pool_id = 7), 'Александр Гротендик', false, 'B'),
((SELECT id FROM questions WHERE question_text = 'Кто создал теорию категорий?' AND pool_id = 7), 'Уильям Ловьер', false, 'C'),
((SELECT id FROM questions WHERE question_text = 'Кто создал теорию категорий?' AND pool_id = 7), 'Жан-Пьер Серр', false, 'D');

-- Варианты для вопроса 13: Что изучает алгебраическая геометрия?
INSERT INTO question_options (question_id, option_text, is_correct, option_letter) VALUES
((SELECT id FROM questions WHERE question_text = 'Что изучает алгебраическая геометрия?' AND pool_id = 7), 'Нули многочленов', true, 'A'),
((SELECT id FROM questions WHERE question_text = 'Что изучает алгебраическая геометрия?' AND pool_id = 7), 'Дифференциальные уравнения', false, 'B'),
((SELECT id FROM questions WHERE question_text = 'Что изучает алгебраическая геометрия?' AND pool_id = 7), 'Теорию чисел', false, 'C'),
((SELECT id FROM questions WHERE question_text = 'Что изучает алгебраическая геометрия?' AND pool_id = 7), 'Топологию', false, 'D');

-- Варианты для вопроса 14: Кто решил проблему Пуанкаре?
INSERT INTO question_options (question_id, option_text, is_correct, option_letter) VALUES
((SELECT id FROM questions WHERE question_text = 'Кто решил проблему Пуанкаре?' AND pool_id = 7), 'Григорий Перельман', true, 'A'),
((SELECT id FROM questions WHERE question_text = 'Кто решил проблему Пуанкаре?' AND pool_id = 7), 'Максвелл', false, 'B'),
((SELECT id FROM questions WHERE question_text = 'Кто решил проблему Пуанкаре?' AND pool_id = 7), 'Ричард Гамильтон', false, 'C'),
((SELECT id FROM questions WHERE question_text = 'Кто решил проблему Пуанкаре?' AND pool_id = 7), 'Уильям Тёрстон', false, 'D');

-- Варианты для вопроса 15: Что такое гипотеза Ходжа?
INSERT INTO question_options (question_id, option_text, is_correct, option_letter) VALUES
((SELECT id FROM questions WHERE question_text = 'Что такое гипотеза Ходжа?' AND pool_id = 7), 'О когомологиях', true, 'A'),
((SELECT id FROM questions WHERE question_text = 'Что такое гипотеза Ходжа?' AND pool_id = 7), 'О простых числах', false, 'B'),
((SELECT id FROM questions WHERE question_text = 'Что такое гипотеза Ходжа?' AND pool_id = 7), 'О топологии', false, 'C'),
((SELECT id FROM questions WHERE question_text = 'Что такое гипотеза Ходжа?' AND pool_id = 7), 'О алгебраических числах', false, 'D');