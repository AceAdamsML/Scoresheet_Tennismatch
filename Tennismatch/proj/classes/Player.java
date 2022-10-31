package classes;

public class Player {

    private String playerName;

    /* Constructor: initialize playerID and playerName
     */
    public Player(String playerName)
    {
      this.playerName = playerName;
    }

    public String getPlayerName(){
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

}
