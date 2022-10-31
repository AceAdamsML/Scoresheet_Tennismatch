package controller.tab;

import classes.Match;
import classes.Player;
import classes.Team;
import com.sun.javafx.geom.Matrix3f;
import controller.MainController;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;

import java.util.*;

public class ControllerViewerPage {

    @FXML Button getFixturesBut;
    @FXML TextArea textFieldOutput;
    @FXML ComboBox listHomeViewer;
    @FXML ComboBox listAwayViewer;

    private MainController main;

    private List<Match> matches;
    private List<Team> teams;
    private String teamStats="";
    private String teamRanking="";


    public MainController getMain() {
        return main;
    }

    public void setMain(MainController main) {
        this.main = main;
    }

    public List<Match> getMatches() {
        return matches;
    }

    public void setMatches(List<Match> matches) {
        this.matches=new ArrayList<>(matches);
    }

    public List<Team> getTeams() {
        return teams;
    }

    public void setTeams(List<Team> teams) {
        this.teams=new ArrayList<>(teams);
    }

    public String getTeamStats() {
        return teamStats;
    }

    public void setTeamStats(String teamStats) {
        this.teamStats = teamStats;
    }

    public String getTeamRanking() {
        return teamRanking;
    }

    public void setTeamRanking(String teamRanking) {
        this.teamRanking = teamRanking;
    }

    public void getFixturesAct(){
        String fixtures=toString();
        Alert a = new Alert(Alert.AlertType.INFORMATION);
        if (teams.size()==0){
            a.setContentText(String.format("No teams have been added"));
        }else{
        a.setContentText(String.format(fixtures));}
        a.setTitle("Fixtures and results");
        a.show();
    }
    public void updateAllTeamRankings(){
        if(teams!=null) {
            String s = "";
            List<String> strings = new ArrayList<String>();
            String tempStr = "";

            for (Team t : teams) {
                List<List> allStatsmatches = main.getSt1().searchForMatches(t);
                tempStr = t.getTeamName() + ": matchesPlayed=" + allStatsmatches.get(0).size() + ", matchesWon=" + allStatsmatches.get(1).size() + ", setsWon=" + allStatsmatches.get(2).size();
                strings.add(tempStr);
            }
            List<String> sortedList = bubbleSortRankings(strings);
            for (String string : sortedList) {
                s = s + string + "\n";
            }
            teamRanking = s;
        }
    }
    public void showAllTeamRankingsAct(){
        textFieldOutput.setText("");


        textFieldOutput.setText(teamRanking);
    }
    public List<String> bubbleSortRankings(List<String> arr) {
        int n = arr.size();
        List<String> returningList=arr;
        String temp = "";
        for (int i = 0; i < n-1; i++) {
            for (int j = 0; j < (n -i-1); j++) {

                if (Integer.parseInt(returningList.get(j).split("setsWon=")[1]) < Integer.parseInt(returningList.get(j+1).split("setsWon=")[1])) {
                    //swap elements
                    temp = returningList.get(j);
                    returningList.set(j,returningList.get(j+1));
                    returningList.set(j+1,temp);
                }
            }
        }
        return returningList;
    }
    public void updateAllTeamStats(){
        if(teams!=null) {
            String s = "";
            String tempStr = "";

            for (Team t : teams) {
                List<List> allStatsmatches = main.getSt1().searchForMatches(t);
                tempStr = t.getTeamName() + ": matchesPlayed=" + allStatsmatches.get(0).size() + ", matchesWon=" + allStatsmatches.get(1).size() + ", setsWon=" + allStatsmatches.get(2).size() + "\n";
                s = s + tempStr;
            }
            teamStats = s;
        }
    }
    public void showAllTeamStatsAct(){
        textFieldOutput.setText("");

        textFieldOutput.setText(teamStats);
    }
    public void viewTeamStats(){
        textFieldOutput.setText("");
        if(listHomeViewer.getValue()!=null & listAwayViewer.getValue()!=null){
            Team homeTeam=main.getSt1().getTeamOfString((String)listHomeViewer.getValue());
            Team awayTeam=main.getSt1().getTeamOfString((String)listAwayViewer.getValue());

            String s="";
            Match match=main.getSt1().searchForMatch2(awayTeam,homeTeam);
            if(match!=null) {
                List<Player> players=match.getPlayers();
                List<String> matrix=match.getMatrix();


                s = s + "Match: " + homeTeam.getTeamName() + " vs " + awayTeam.getTeamName() + "\n";
                s = s + "SingleSets\n";
                s = s + "Set(" +players.get(2).getPlayerName()+players.get(0).getPlayerName()+"=" +matrix.get(0) +","+matrix.get(1)+","+matrix.get(2)+ ")"+ "\n";//s11-s13
                s = s + "Set(" +players.get(2).getPlayerName()+players.get(1).getPlayerName()+"=" +matrix.get(3) +","+matrix.get(4)+","+matrix.get(5)+ ")"+ "\n";//s14-s16
                s = s + "Set(" +players.get(3).getPlayerName()+players.get(0).getPlayerName()+"=" +matrix.get(6) +","+matrix.get(7)+","+matrix.get(8)+ ")"+ "\n";//s21-s23
                s = s + "Set(" +players.get(3).getPlayerName()+players.get(1).getPlayerName()+"=" +matrix.get(9) +","+matrix.get(10)+","+matrix.get(11)+ ")"+ "\n";//s24-s26
                s = s + "Double set: Set(null vs null = " + matrix.get(12) +","+matrix.get(13)+","+matrix.get(14)+ ")"+ "\n";
                s = s + "Final scores:" + matrix.get(15)+ "\n";
            }else{s=s+"No matches detected for the selected teams!";}

            textFieldOutput.setText(s);
        }
    }

    public void updateCbs(){
        listHomeViewer.getItems().clear();
        listHomeViewer.getItems().addAll(main.getSt1().getStrTeamsAH("Home"));
        listAwayViewer.getItems().clear();
        listAwayViewer.getItems().addAll(main.getSt1().getStrTeamsAH("Away"));
    }
    public String[][] fixtures() {
        //     matchList.clear();
        String separator = " - ";
        String[][] grid = new String[teams.size()+1][teams.size()+1];
        grid[0][0] = separator;

        for (int i = 0; i < teams.size(); i++) {
            grid[0][i+1] = teams.get(i).getTeamName();

        }

        for (int x = 1; x < teams.size()+1; x++) {
            grid[x][0] = teams.get(x-1).getTeamName();
            grid[x][x] = separator;
        }

        for (int x = 1; x < teams.size()+1; x++) {
            for (int y = 1; y < teams.size()+1; y++) {
                if (grid[y][x] != " - " && grid[y][x] == null) {
                    String homeTeam = grid[x][0];
                    String awayTeam = grid[y][0];
                    for(int l = 0; l < matches.size(); l++){
                        if (matches.get(l).getHomeTeam().getTeamName()  == homeTeam) {
                            if (matches.get(l).getAwayTeam().getTeamName() == awayTeam) {
                                grid[y][x] = matches.get(l).getMatrix().get(15);//15 is the final score
                                break;
                            }
                        }
                        else {
                            grid[y][x] = " np ";
                        }
                    }
                }
            }
        }
        return grid;
    }

    public String toString() {
        return Arrays.deepToString(fixtures()).replace("], ", "\n").replace("[", " ").replace("]]", " ");
    }
    public void init(MainController mainController) {
        main = mainController;
        teams=new ArrayList<>();
        matches=new ArrayList<>();

        Timer timer = new Timer();
        timer.schedule(new updateStats(), 0, 100000);
    }
    class updateStats extends TimerTask {
        public void run() {
            updateAllTeamStats();
            updateAllTeamRankings();
        }
    }
}
