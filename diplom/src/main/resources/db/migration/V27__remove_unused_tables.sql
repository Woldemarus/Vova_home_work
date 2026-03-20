-- Удаление неиспользуемых таблиц и колонок

-- 1. Удаляем таблицу user_completed_pools (зависит от game_pools)
DROP TABLE IF EXISTS user_completed_pools;

-- 2. Удаляем таблицу game_pools (не используется в коде)
DROP TABLE IF EXISTS game_pools;

-- 3. Удаляем неиспользуемые колонки из таблицы questions
ALTER TABLE questions DROP COLUMN IF EXISTS pool_id;

-- 4. Удаляем неиспользуемые колонки из таблицы games
ALTER TABLE games DROP COLUMN IF EXISTS pool_id;

-- 5. Удаляем связанные индексы (если они существуют)
DROP INDEX IF EXISTS idx_questions_pool_id;
DROP INDEX IF EXISTS idx_questions_pool_difficulty;
DROP INDEX IF EXISTS idx_user_completed_pools_user_id;
DROP INDEX IF EXISTS idx_user_completed_pools_pool_id;
DROP INDEX IF EXISTS idx_games_pool_id;

-- Комментарий: current_question_id оставляем, так как используется в GameService