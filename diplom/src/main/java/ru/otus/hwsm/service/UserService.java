package ru.otus.hwsm.service;

import java.util.Optional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.otus.hwsm.entity.Game;
import ru.otus.hwsm.entity.User;
import ru.otus.hwsm.repository.GameRepository;
import ru.otus.hwsm.repository.UserRepository;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final GameRepository gameRepository;

    @Transactional
    public User findOrCreateUser(org.telegram.telegrambots.meta.api.objects.User telegramUser) {
        Optional<User> existingUser = userRepository.findByTelegramUserId(telegramUser.getId());

        if (existingUser.isPresent()) {
            log.debug("Found existing user with telegram ID: {}", telegramUser.getId());
            return existingUser.get();
        }

        User newUser = User.builder()
                .telegramUserId(telegramUser.getId())
                .username(telegramUser.getUserName())
                .firstName(telegramUser.getFirstName())
                .lastName(telegramUser.getLastName())
                .build();

        User savedUser = userRepository.save(newUser);
        log.info(
                "Created new user with telegram ID: {}, username: {}",
                telegramUser.getId(),
                telegramUser.getUserName());

        return savedUser;
    }

    @Transactional(readOnly = true)
    public Optional<Game> findActiveGame(Long telegramUserId) {
        return gameRepository.findActiveGameByTelegramUserId(telegramUserId, Game.GameStatus.ACTIVE);
    }

    @Transactional
    public Game startNewGame(User user) {
        // Завершаем активную игру, если есть
        Optional<Game> activeGame = gameRepository.findByUserAndStatus(user, Game.GameStatus.ACTIVE);
        if (activeGame.isPresent()) {
            Game game = activeGame.get();
            game.setStatus(Game.GameStatus.FAILED);
            gameRepository.save(game);
            log.info("Closed previous active game for user: {}", user.getTelegramUserId());
        }

        Game newGame = Game.builder()
                .user(user)
                .status(Game.GameStatus.ACTIVE)
                .currentQuestionNumber(1)
                .currentPrizeAmount(0)
                .guaranteedPrizeAmount(0)
                .build();

        Game savedGame = gameRepository.save(newGame);
        log.info("Started new game for user: {}, game ID: {}", user.getTelegramUserId(), savedGame.getId());

        return savedGame;
    }

    @Transactional(readOnly = true)
    public Long getCompletedGamesCount(User user) {
        return gameRepository.countCompletedGamesByUser(user);
    }

    @Transactional(readOnly = true)
    public Optional<ru.otus.hwsm.entity.User> findByTelegramId(Long telegramUserId) {
        return userRepository.findByTelegramUserId(telegramUserId);
    }
}
