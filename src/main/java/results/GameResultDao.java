package results;

import org.jdbi.v3.core.Handle;
import org.jdbi.v3.core.Jdbi;
import org.jdbi.v3.core.statement.Update;

import java.util.List;

/**
 * DAO class for Game Results, uses JDBI.
 */
public class GameResultDao {
    Handle handle;

    /**
     * Constructor.
     */
    public GameResultDao(){
        Jdbi jdbi = Jdbi.create("jdbc:mysql://root:@localhost:3306/snakegame?serverTimezone=Europe/Amsterdam");
        handle = jdbi.open();
    }

    /**
     * Inserts new row into results table.
     *
     * @param result GameResult object that contains data of result
     */
    public void insertGameResult(GameResult result){
        Update insert = handle.createUpdate("INSERT INTO results VALUES (NULL, :playerName, :score, :snakeLength, :numOfPickups, :timeSurvived)");
        insert.bindBean(result);
        insert.execute();
    }

    /**
     * Get game results from DB table.
     *
     * @param limit limit number of rows
     * @return List of GameResult objects
     */
    public List<GameResult> getGameResults(int limit){
        return handle.createQuery("SELECT id, playerName, score, snakeLength, numOfPickups, timeSurvived FROM results ORDER BY score DESC LIMIT :limit")
                .bind("limit", limit)
                .mapToBean(GameResult.class)
                .list();
    }
}
