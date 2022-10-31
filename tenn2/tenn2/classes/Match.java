package classes;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Match {


    private java.util.Date Date;
    private Team homeTeam;
    private Team awayTeam;
    private Boolean type;
    private List<Player> players;
    private Team winner;
    private List<Scoresheet> sets;
    private List<String> matrix;

    public Match(java.util.Date date, Team homeTeam, Team awayTeam, Boolean type, List<Player> players, Team winner, List<Scoresheet> sets,List<String> matrix) {
        Date = date;
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.type = type;
        this.players = players;
        this.winner = winner;
        this.sets = sets;
        this.matrix=matrix;
    }


    public List<String> getMatrix() {
        return matrix;
    }

    public void setMatrix(List<String> matrix) {
        this.matrix = matrix;
    }

    public java.util.Date getDate() {
        return Date;
    }

    public void setDate(java.util.Date date) {
        Date = date;
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

    public Boolean getType() {
        return type;
    }

    public void setType(Boolean type) {
        this.type = type;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public Team getWinner() {
        return winner;
    }

    public void setWinner(Team winner) {
        this.winner = winner;
    }

    public List<Scoresheet> getSets() {
        return sets;
    }

    public void setSets(List<Scoresheet> sets) {
        this.sets = sets;
    }
}