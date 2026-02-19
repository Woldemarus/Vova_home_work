package ru.otus.hwsm.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.otus.hwsm.entity.Game;
import ru.otus.hwsm.entity.GameAnswer;

@Repository
public interface GameAnswerRepository extends JpaRepository<GameAnswer, Long> {

    /**
     * Найти все ответы для игры
     */
    List<GameAnswer> findByGameOrderByAnsweredAtAsc(Game game);

    /**
     * Найти все ответы для игры по ID
     */
    @Query("SELECT ga FROM GameAnswer ga WHERE ga.game.id = :gameId ORDER BY ga.answeredAt ASC")
    List<GameAnswer> findByGameIdOrderByAnsweredAtAsc(@Param("gameId") Long gameId);

    /**
     * Подсчитать количество правильных ответов в игре
     */
    @Query("SELECT COUNT(ga) FROM GameAnswer ga WHERE ga.game.id = :gameId AND ga.isCorrect = true")
    Long countCorrectAnswersByGameId(@Param("gameId") Long gameId);

    /**
     * Подсчитать общее количество ответов в игре
     */
    @Query("SELECT COUNT(ga) FROM GameAnswer ga WHERE ga.game.id = :gameId")
    Long countAnswersByGameId(@Param("gameId") Long gameId);
}
