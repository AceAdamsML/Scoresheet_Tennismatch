package classes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class Fixtures {

    private Team homeTeam;
    private Team awayTeam;
    private ArrayList<Match> matches;
    private java.util.Date Date;

    public Fixtures(Team homeTeam, Team awayTeam, ArrayList<Match> matches, java.util.Date date) {
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.matches = matches;
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

    public ArrayList<Match> getMatches() {
        return matches;
    }

    public void setMatches(ArrayList<Match> matches) {
        this.matches = matches;
    }

    public java.util.Date getDate() {
        return Date;
    }

    public void setDate(java.util.Date date) {
        Date = date;
    }
}
