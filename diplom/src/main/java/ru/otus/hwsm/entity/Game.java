package ru.otus.hwsm.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "games")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private GameStatus status;

    @Column(name = "current_question_number")
    private Integer currentQuestionNumber;

    @Column(name = "current_question_id")
    private Long currentQuestionId;

    @Column(name = "current_prize_amount")
    private Integer currentPrizeAmount;

    @Column(name = "guaranteed_prize_amount")
    private Integer guaranteedPrizeAmount;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @Column(name = "completed_at")
    private LocalDateTime completedAt;

    @OneToMany(mappedBy = "game", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<GameAnswer> gameAnswers;

    @OneToMany(mappedBy = "game", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<GameLifeline> gameLifelines;

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
        updatedAt = LocalDateTime.now();
        if (status == null) {
            status = GameStatus.ACTIVE;
        }
        if (currentQuestionNumber == null) {
            currentQuestionNumber = 1;
        }
        if (currentPrizeAmount == null) {
            currentPrizeAmount = 0;
        }
        if (guaranteedPrizeAmount == null) {
            guaranteedPrizeAmount = 0;
        }
    }

    @PreUpdate
    protected void onUpdate() {
        updatedAt = LocalDateTime.now();
    }

    public enum GameStatus {
        ACTIVE,
        COMPLETED,
        FAILED
    }
}
