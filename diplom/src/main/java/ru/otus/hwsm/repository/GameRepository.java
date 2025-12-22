package ru.otus.hwsm.repository;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.otus.hwsm.entity.Game;
import ru.otus.hwsm.entity.User;

@Repository
public interface GameRepository extends JpaRepository<Game, Long> {

    List<Game> findByUserOrderByCreatedAtDesc(User user);

    Optional<Game> findByUserAndStatus(User user, Game.GameStatus status);

    @Query("SELECT g FROM Game g WHERE g.user.telegramUserId = :telegramUserId AND g.status = :status")
    Optional<Game> findActiveGameByTelegramUserId(
            @Param("telegramUserId") Long telegramUserId, @Param("status") Game.GameStatus status);

    @Query("SELECT COUNT(g) FROM Game g WHERE g.user = :user AND g.status = 'COMPLETED'")
    Long countCompletedGamesByUser(@Param("user") User user);
}
