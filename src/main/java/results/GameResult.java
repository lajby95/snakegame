package results;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class GameResult {

    int id;
    String playerName;
    int score;
    int snakeLength;
    int numOfPickups;
    int timeSurvived;

    public GameResult(String playerName, int score, int snakeLength, int numOfPickups, int timeSurvived) {
        this.playerName = playerName;
        this.score = score;
        this.snakeLength = snakeLength;
        this.numOfPickups = numOfPickups;
        this.timeSurvived = timeSurvived;
    }
}
