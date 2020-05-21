package results;

import lombok.*;

/**
 * Class representing a Snake game result.
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class GameResult {

    /**
     * primary key.
     */
    int id;

    /**
     * player name.
     */
    String playerName;

    /**
     * points for player.
     */
    int score;

    /**
     * snake's length.
     */
    int snakeLength;

    /**
     * number of pickups eaten.
     */
    int numOfPickups;

    /**
     * time survived in seconds.
     */
    int timeSurvived;

    public GameResult(String playerName, int score, int snakeLength, int numOfPickups, int timeSurvived) {
        this.playerName = playerName;
        this.score = score;
        this.snakeLength = snakeLength;
        this.numOfPickups = numOfPickups;
        this.timeSurvived = timeSurvived;
    }
}
