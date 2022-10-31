package classes;


import java.util.Date;
import java.util.List;

public class Scoresheet {

    private Team homeTeam;
    private Team awayTeam;
    private List<Player> playerList;
    private Boolean type;
    private List<Integer> homeScore;
    private List<Integer> awayScore;
    private Team winner;
    private Date date;

    public Scoresheet(Team homeTeam, Team awayTeam, List<Player> playerList, Boolean type, List<Integer> homeScore, List<Integer> awayScore, Team winner, Date date) {
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.playerList = playerList;
        this.type = type;
        this.homeScore = homeScore;
        this.awayScore = awayScore;
        this.winner = winner;
        this.date = date;
    }

    public Team getHomeTeam() {
        return homeTeam;
    }

    public void setHomeTeam(Team homeTeam) {
        this.homeTeam = homeTeam;
    }

    public Team getAwayTeam() {
        return awayTeam;
    }

    public void setAwayTeam(Team awayTeam) {
        this.awayTeam = awayTeam;
    }

    public List<Player> getPlayerList() {
        return playerList;
    }

    public void setPlayerList(List<Player> playerList) {
        this.playerList = playerList;
    }

    public Boolean getType() {
        return type;
    }

    public void setType(Boolean type) {
        this.type = type;
    }

    public List<Integer> getHomeScore() {
        return homeScore;
    }

    public void setHomeScore(List<Integer> homeScore) {
        this.homeScore = homeScore;
    }

    public List<Integer> getAwayScore() {
        return awayScore;
    }

    public void setAwayScore(List<Integer> awayScore) {
        this.awayScore = awayScore;
    }

    public Team getWinner() {
        return winner;
    }

    public void setWinner(Team winner) {
        this.winner = winner;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
