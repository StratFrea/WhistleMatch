package Assignments;

import java.util.ArrayList;

public class GameDatabase {
    private final ArrayList<Game> games;
    private Integer gameIDCounter;

    public GameDatabase(ArrayList<Game> games) {
        this.games = games;
        gameIDCounter = 0;
    }

    public void addGame(Game game) {
        games.add(game);
    }

    public Game getGame(Integer gameID) {
        for (Game game : games) {
            if (game.getGameID().equals(gameID)) {
                return game;
            }
        }
        throw new IllegalArgumentException("Game not found");
    }

    /**
     * Gets all games in the database
     * @return ArrayList of all games in the database
     */
    public ArrayList<Game> getGames() {
        return games;
    }

    public Integer generateGameID() {
        return gameIDCounter++;
    }
}
