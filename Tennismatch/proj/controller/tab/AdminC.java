package controller.tab;


import classes.Player;
import classes.Team;
import controller.MainController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.util.Arrays;
import java.util.List;

public class AdminC {

    private MainController main;
    @FXML TextField teamText;
    @FXML ComboBox homeOrAwayList;
    @FXML ComboBox cbTeamName;
    @FXML TextField playerText;

    public void addTeam(){
        String teamName=teamText.getText();

        //System.out.println(homeOrAwayList.getValue());
        List<String> teamNames=main.getSt1().getStrTeams();
        if(teamName!=null | !teamName.equals("")) {
            if (homeOrAwayList.getValue().equals("Home")) {
                if (!(teamNames.contains(teamName))) {
                    main.getTab3Controller().updateListTeam(new Team(teamName), "Home");
                } else {
                    //ain.getSt1().getTeamOfString(teamName) will not return null because we first checked if the team name is contained in the array
                    main.getTab3Controller().updateListTeam(main.getSt1().getTeamOfString(teamName), "Home");

                }
            } else {
                if (!(teamNames.contains(teamName))) {
                    main.getTab3Controller().updateListTeam(new Team(teamName), "Away");
                } else {
                    main.getTab3Controller().updateListTeam(main.getSt1().getTeamOfString(teamName), "Away");
                    System.out.println("we reach here");
                }
            }
            updateCBTeams();
            main.getTab2Controller().updateCbs();
        }
        for(Team t: main.getTab2Controller().getTeams()){
            System.out.println(t.getTeamName());
        }
    }
    public void initialize(){

        homeOrAwayList.getItems().addAll("Home",
                "Away");
        homeOrAwayList.getSelectionModel().select(0);
//        homeOrAwayList.getItems().addAll("Select");
//        cbTeamName.getSelectionModel().select


    }
    public void addPlayer(){
        System.out.println(cbTeamName.getValue());
        String playerName=playerText.getText();
        String teamName= (String) cbTeamName.getValue();
        if(main.getSt1().getTeams().isEmpty() | playerName.equals("") | playerName==null){}
        else{
            if(cbTeamName.getValue()==null){}
            else{
                if(main.getSt1().getStrPlayersNames(main.getSt1().getTeamOfString(teamName)).contains(playerName))
                {}else {
                    main.getSt1().getTeamOfString(teamName).getPlayerList().add(new Player(playerName));
                }
            }
        }
//        for(Player player : (main.getSt1().getTeamOfString(teamName).getPlayerList()))
//        {
//            System.out.println(player.getPlayerName());
//        }
    }
    public void updateCBTeams(){
        cbTeamName.getItems().clear();
        cbTeamName.getItems().addAll(main.getSt1().getStrTeams());
    }
    public void generateTeamStats(){
        main.getTab2Controller().updateAllTeamStats();
        main.getTab2Controller().updateAllTeamRankings();
    }

    public void generateFixtures() {
        main.getTab2Controller().setTeams(main.getSt1().getTeams());
        main.getTab2Controller().setMatches(main.getSt1().getMatches());
    }

    private static String flip(String match) {
        String[] components = match.split(" v ");
        return components[1] + " v " + components[0];
    }

    public void init(MainController mainController) {
        main = mainController;

    }
}
