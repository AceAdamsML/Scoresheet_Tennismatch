package classes;

import java.util.ArrayList;
import java.util.List;

public class Team {
    private String teamName;
    private List <Player> playerList;

    public Team(String teamName) {
        this.teamName = teamName;
        this.playerList = new ArrayList<>();
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public List<Player> getPlayerList() {
        return playerList;
    }
    public void assignPlayer(Player p)
    {
        playerList.add(p);
    }
    //public Team getTeamForTeamName(String teamName){ return (new Team("sa"));}


    public void setPlayerList(List<Player> playerList) {
        this.playerList = playerList;
    }

    public Boolean teamEquals(Team team2){
        if(this.teamName.equals(team2.getTeamName())){
            return(true);
        }else{
            return(false);
        }
    }
}
