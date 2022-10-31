package classes;

public class Ranking {
    private String rankingType;
    private Team hometeam;
    private Team awayteam;
    private int setswon;
    private Team winner;


    public Ranking(String rankingType, Team hometeam, Team awayteam, int setswon, Team winner) {
        this.rankingType = rankingType;
        this.hometeam = hometeam;
        this.awayteam = awayteam;
        this.setswon = setswon;
        this.winner = winner;
    }

    public String getRankingType() {
        return rankingType;
    }

    public void setRankingType(String rankingType) {
        this.rankingType = rankingType;
    }

    public Team getHometeam() {
        return hometeam;
    }

    public void setHometeam(Team hometeam) {
        this.hometeam = hometeam;
    }

    public Team getAwayteam() {
        return awayteam;
    }

    public void setAwayteam(Team awayteam) {
        this.awayteam = awayteam;
    }

    public int getSetswon() {
        return setswon;
    }

    public void setSetswon(int setswon) {
        this.setswon = setswon;
    }

    public Team getWinner() {
        return winner;
    }

    public void setWinner(Team winner) {
        this.winner = winner;
    }
}
