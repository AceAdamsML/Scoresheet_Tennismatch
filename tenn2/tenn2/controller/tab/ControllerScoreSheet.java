package controller.tab;

import classes.Match;
import classes.Player;
import classes.Scoresheet;
import classes.Team;
import controller.MainController;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.util.ArrayList;
import java.util.Date;
import java.util.Enumeration;
import java.util.List;

public class ControllerScoreSheet {


    private MainController main;

    private Integer switcher=0;
    @FXML ComboBox listHomeTeam;
    @FXML ComboBox listAwayTeam;

    @FXML ComboBox cbPlayerAway1;
    @FXML ComboBox cbPlayerAway2;
    @FXML ComboBox cbPlayerHome1;
    @FXML ComboBox cbPlayerHome2;

    @FXML TextField s11;@FXML TextField s12;@FXML TextField s13;@FXML TextField s14;@FXML TextField s15;@FXML TextField s16;
    @FXML TextField s21;@FXML TextField s22;@FXML TextField s23;@FXML TextField s24;@FXML TextField s25;@FXML TextField s26;
    @FXML TextField ds1;@FXML TextField ds2;@FXML TextField ds3;

    //TextField[] ss={s11,s12,s13,s14,s15,s16,s21,s22,s23,s24,s25,s26,ds1,ds2,ds3};
    @FXML TextArea finalScore;


//    private ArrayList<String> homeTeam=new ArrayList<String>();
//    private ArrayList<String> awayTeam=new ArrayList<String>();

    public void updateListTeam(Team t, String awayOrHome){//adds the item and updates
        //checks for duplicate data

        if(main.getSt1().getStrTeams().contains(t.getTeamName())){}
        else{
            main.getSt1().getTeams().add(t);
            main.getSt1().setListHomeORAway(t,(new ArrayList<String>()));
        }
        List <String> homeORawayList=main.getSt1().getDicTeams().get(t);
        System.out.println("here1");

        Integer size=main.getSt1().getDicTeams().get(t).size();
        if(size==2){}
        else {
            if (homeORawayList.contains(awayOrHome)) {} else {
                main.getSt1().getDicTeams().get(t).add(awayOrHome);
            }
        }
        System.out.println(main.getSt1().getStrTeams());
        listHomeTeam.getItems().clear();
        listHomeTeam.getItems().addAll(main.getSt1().getStrTeamsAH("Home"));
        listAwayTeam.getItems().clear();
        listAwayTeam.getItems().addAll(main.getSt1().getStrTeamsAH("Away"));
    }

    public void homeCBaction(){
        System.out.println(listHomeTeam.getValue());
        if(listHomeTeam.getValue()!=null & listAwayTeam.getValue()!=null){
            cbPlayerAway1.getItems().clear();
            cbPlayerHome1.getItems().clear();
            cbPlayerHome2.getItems().clear();
            cbPlayerAway2.getItems().clear();
            System.out.println("Players:");

            for(String player : (main.getSt1().getStrPlayersNames(main.getSt1().getTeamOfString((String)listHomeTeam.getValue()))))
            {
                System.out.println(player);
            }
            cbPlayerHome1.getItems().addAll(main.getSt1().getStrPlayersNames(main.getSt1().getTeamOfString((String)listHomeTeam.getValue())));
            cbPlayerHome2.getItems().addAll(main.getSt1().getStrPlayersNames(main.getSt1().getTeamOfString((String)listHomeTeam.getValue())));

            cbPlayerAway1.getItems().addAll(main.getSt1().getStrPlayersNames(main.getSt1().getTeamOfString((String)listAwayTeam.getValue())));
            cbPlayerAway2.getItems().addAll(main.getSt1().getStrPlayersNames(main.getSt1().getTeamOfString((String)listAwayTeam.getValue())));
        }
    }
    public Boolean checkAlreadyMadeMatch(){// returns true if the match exists else it retuns false. and it alerts accordingly
        if(checkCboxees()==true) {
            Team homeTeam = main.getSt1().getTeamOfString((String) listHomeTeam.getValue());
            Team awayTeam = main.getSt1().getTeamOfString((String) listAwayTeam.getValue());
            Boolean b1 = main.getSt1().searchForExistingMatch(awayTeam, homeTeam, main.getSt1().getPlayerOfString(awayTeam.getTeamName(), (String) cbPlayerAway1.getValue()),
                    main.getSt1().getPlayerOfString(awayTeam.getTeamName(), (String) cbPlayerAway2.getValue()),
                    main.getSt1().getPlayerOfString(homeTeam.getTeamName(), (String) cbPlayerHome1.getValue()),
                    main.getSt1().getPlayerOfString(homeTeam.getTeamName(), (String) cbPlayerHome2.getValue()));
            if(b1==true){return true;
            }else{return false;}
        }
        return null;
    }
    public void cbPlayerAction(){
        try{
            if(switcher==1){
                Boolean b2=checkAlreadyMadeMatch();
            }
            if(switcher==2){
                if(checkCboxees()==true){
                    Team homeTeam=main.getSt1().getTeamOfString((String) listHomeTeam.getValue());
                    Team awayTeam=main.getSt1().getTeamOfString((String) listAwayTeam.getValue());
                    List<String> matrix= main.getSt1().searchForMatch(awayTeam,homeTeam,main.getSt1().getPlayerOfString(awayTeam.getTeamName(),(String)cbPlayerAway1.getValue()),
                            main.getSt1().getPlayerOfString(awayTeam.getTeamName(),(String)cbPlayerAway1.getValue()),
                                    main.getSt1().getPlayerOfString(homeTeam.getTeamName(),(String)cbPlayerHome1.getValue()),
                                            main.getSt1().getPlayerOfString(homeTeam.getTeamName(),(String)cbPlayerHome2.getValue())).getMatrix();
                    s11.setText(matrix.get(0));s12.setText(matrix.get(1));s13.setText(matrix.get(2));s14.setText(matrix.get(3));s15.setText(matrix.get(4));s16.setText(matrix.get(5));
                    s21.setText(matrix.get(6));s22.setText(matrix.get(7));s23.setText(matrix.get(8));s24.setText(matrix.get(9));s25.setText(matrix.get(10));s26.setText(matrix.get(11));
                    ds1.setText(matrix.get(12));ds2.setText(matrix.get(13));ds3.setText(matrix.get(14));
                    finalScore.setText(matrix.get(15));}

                }
            }catch (NullPointerException e){}
    }
    public Boolean checkCboxees(){//everything is entered, so all comboboxes have a value
        Boolean b1;
        if(cbPlayerAway1.getValue()!=null & cbPlayerAway2.getValue()!=null & cbPlayerHome1.getValue()!=null & cbPlayerHome2.getValue()!=null){
            if(!cbPlayerAway1.getValue().equals(cbPlayerAway2.getValue()) & !cbPlayerHome1.getValue().equals(cbPlayerHome2.getValue()) &
                    !cbPlayerHome1.getValue().equals(cbPlayerAway1.getValue()) & !cbPlayerAway2.getValue().equals(cbPlayerHome2.getValue()) &
                    !cbPlayerAway1.getValue().equals(cbPlayerHome2.getValue()) & !cbPlayerAway2.getValue().equals(cbPlayerHome1.getValue())){
                    b1=true;
                }else{b1=false;}
            }else{b1=false;}
        return b1;
    }
    public String calculateFinalScore(List<Integer> formatedScores){
        Integer homeTeamScore=0;
        Integer awayTeamScore=0;

        for(Integer formScore :formatedScores){
            if(formScore==1){
                homeTeamScore=homeTeamScore+1;
            }else if(formScore==0){
                awayTeamScore=awayTeamScore+1;
            }else if(formScore==2){//a set ended in tie
                return (null);
            }
        }
        return (String.format("%d:%d",homeTeamScore,awayTeamScore));
    }
    public void createMatch(){
        List<Player> players = new ArrayList<Player>();
        players.add(main.getSt1().getPlayerOfString((String) listHomeTeam.getValue(), (String) cbPlayerHome1.getValue()));
        players.add(main.getSt1().getPlayerOfString((String) listHomeTeam.getValue(), (String) cbPlayerHome2.getValue()));
        players.add(main.getSt1().getPlayerOfString((String) listAwayTeam.getValue(), (String) cbPlayerAway1.getValue()));
        players.add(main.getSt1().getPlayerOfString((String) listAwayTeam.getValue(), (String) cbPlayerAway2.getValue()));

        Boolean type1 = ((s11.getText().equals("0:0") == false | s11.getText().equals("") == false) & (s12.getText().equals("0:0") == false | s12.getText().equals("") == false) &
                (s13.getText().equals("0:0") == false | s13.getText().equals("") == false));
        Boolean type2 = ((s21.getText().equals("0:0") == false | s21.getText().equals("") == false) & (s22.getText().equals("0:0") == false | s22.getText().equals("") == false) &
                (s23.getText().equals("0:0") == false | s13.getText().equals("") == false));
        Boolean type3 = ((s14.getText().equals("0:0") == false | s14.getText().equals("") == false) & (s15.getText().equals("0:0") == false | s15.getText().equals("") == false) &
                (s16.getText().equals("0:0") == false | s16.getText().equals("") == false));
        Boolean type4 = ((s24.getText().equals("0:0") == false | s24.getText().equals("") == false) & (s25.getText().equals("0:0") == false | s25.getText().equals("") == false) &
                (s26.getText().equals("0:0") == false | s26.getText().equals("") == false));
        Boolean dStype = ((ds1.getText().equals("0:0") == false | ds1.getText().equals("") == false) & (ds2.getText().equals("0:0") == false | ds2.getText().equals("") == false) &
                (ds3.getText().equals("0:0") == false | ds3.getText().equals("") == false));

        Boolean matchType = type1 | type2 | type3 | type4 | dStype;


        List<List<Integer>> matrix = getScores();
//        System.out.println("==========================");
//        for(Integer i : matrix.get(0)){
//            System.out.println(i);
//        }
//        System.out.println("==========================");
//        for(Integer i : matrix.get(1)){
//            System.out.println(i);
//        }
//        System.out.println("==========================");
//        for(Integer i : matrix.get(2)){
//            System.out.println(i);
//        }
//        System.out.println("==========================");
//        for(Integer i : matrix.get(0).subList(6,8)){
//            System.out.println(i);
//        }
        List<Team> winners = new ArrayList<Team>();
        List<Integer> winnersScoreFormated=new ArrayList<Integer>();

        Integer winnerInt1 = calculateWinner((matrix.get(0)).subList(0, 3), (matrix.get(0)).subList(6,9));
        winnersScoreFormated.add(winnerInt1);
        if (winnerInt1 == 1) {
            winners.add(main.getSt1().getTeamOfString((String) listHomeTeam.getValue()));
        } else if(winnerInt1 == 0){
            winners.add(main.getSt1().getTeamOfString((String) listAwayTeam.getValue()));
        }
        Integer winnerInt2 = calculateWinner((matrix.get(0)).subList(3, 6), (matrix.get(0)).subList(9,12));
        winnersScoreFormated.add(winnerInt2);
        if (winnerInt2 == 1) {
            winners.add(main.getSt1().getTeamOfString((String) listHomeTeam.getValue()));
        } else if(winnerInt1 == 0){
            winners.add(main.getSt1().getTeamOfString((String) listAwayTeam.getValue()));
        }
        Integer winnerInt3 = calculateWinner((matrix.get(1)).subList(0, 3), (matrix.get(1)).subList(6,9));
        winnersScoreFormated.add(winnerInt3);
        if (winnerInt3 == 1) {
            winners.add(main.getSt1().getTeamOfString((String) listHomeTeam.getValue()));
        } else if(winnerInt1 == 0){
            winners.add(main.getSt1().getTeamOfString((String) listAwayTeam.getValue()));
        }
        Integer winnerInt4 = calculateWinner((matrix.get(1)).subList(3, 6), (matrix.get(1)).subList(9,12));
        winnersScoreFormated.add(winnerInt4);
        if (winnerInt4 == 1) {
            winners.add(main.getSt1().getTeamOfString((String) listHomeTeam.getValue()));
        } else if(winnerInt1 == 0){
            winners.add(main.getSt1().getTeamOfString((String) listAwayTeam.getValue()));
        }

        Integer winnerInt5 = calculateWinner((matrix.get(2)).subList(0, 3), (matrix.get(2)).subList(3,6));
        winnersScoreFormated.add(winnerInt5);
        if (winnerInt5 == 1) {
            winners.add(main.getSt1().getTeamOfString((String) listHomeTeam.getValue()));
        } else if(winnerInt1 == 0){
            winners.add(main.getSt1().getTeamOfString((String) listAwayTeam.getValue()));
        }


        String finalScoreText=calculateFinalScore(winnersScoreFormated);
        if (finalScoreText!=null){
        finalScore.setText(finalScoreText);
        Date date = new Date();

        List<Scoresheet> scoresheets = new ArrayList<Scoresheet>();
        Scoresheet scoresheet1 = new Scoresheet(main.getSt1().getTeamOfString((String) listHomeTeam.getValue()), main.getSt1().getTeamOfString((String) listAwayTeam.getValue()),
                players, type1, (matrix.get(0)).subList(0, 3), (matrix.get(0)).subList(6, 9), winners.get(0), date);
        scoresheets.add(scoresheet1);
        Scoresheet scoresheet2 = new Scoresheet(main.getSt1().getTeamOfString((String) listHomeTeam.getValue()), main.getSt1().getTeamOfString((String) listAwayTeam.getValue()),
                players, type1, (matrix.get(0)).subList(3, 6), (matrix.get(0)).subList(9, 12), winners.get(1), date);
        scoresheets.add(scoresheet2);
        Scoresheet scoresheet3 = new Scoresheet(main.getSt1().getTeamOfString((String) listHomeTeam.getValue()), main.getSt1().getTeamOfString((String) listAwayTeam.getValue()),
                players, type1, (matrix.get(1)).subList(0, 3), (matrix.get(1).subList(6, 9)), winners.get(2), date);
        scoresheets.add(scoresheet3);
        Scoresheet scoresheet4 = new Scoresheet(main.getSt1().getTeamOfString((String) listHomeTeam.getValue()), main.getSt1().getTeamOfString((String) listAwayTeam.getValue()),
                players, type1, (matrix.get(1)).subList(3, 6), (matrix.get(1)).subList(9, 12), winners.get(3), date);
        scoresheets.add(scoresheet4);
        Scoresheet scoresheet5 = new Scoresheet(main.getSt1().getTeamOfString((String) listHomeTeam.getValue()), main.getSt1().getTeamOfString((String) listAwayTeam.getValue()),
                players, type1, (matrix.get(2)).subList(0, 3), (matrix.get(2)).subList(3, 6), winners.get(4), date);
        scoresheets.add(scoresheet5);
        List<String> matrixFromWindow = getMatrixFromWindow();
        matrixFromWindow.add(finalScoreText);
        Match match = new Match(date, main.getSt1().getTeamOfString((String) listHomeTeam.getValue()), main.getSt1().getTeamOfString((String) listAwayTeam.getValue()), matchType, players,
                calculateMatchWinner(winners, main.getSt1().getTeamOfString((String) listHomeTeam.getValue()), main.getSt1().getTeamOfString((String) listAwayTeam.getValue())), scoresheets,
                matrixFromWindow);
        main.getSt1().getMatches().add(match);}else{Alert a = new Alert(Alert.AlertType.INFORMATION);
            a.setContentText(String.format("There is a set in the match which ended with a tie score!"));
            a.show();

        }
        main.getSt1().printMatches();
    }
    public void calculateScores(){

        if(checkCboxees()==true) {
            if(checkAlreadyMadeMatch()==false & switcher==1) {
                createMatch();
            }else if(checkAlreadyMadeMatch()==true & switcher==1){
                Alert a = new Alert(Alert.AlertType.INFORMATION);
                a.setContentText(String.format("You must modify this match because it already exists!"));
                a.show();}
            else if(checkAlreadyMadeMatch()==true & switcher==2 ){
                Team homeTeam=main.getSt1().getTeamOfString((String) listHomeTeam.getValue());
                Team awayTeam=main.getSt1().getTeamOfString((String) listAwayTeam.getValue());
                main.getSt1().searchForMatchAndDelete(awayTeam,homeTeam,main.getSt1().getPlayerOfString(awayTeam.getTeamName(),(String)cbPlayerAway1.getValue()),
                        main.getSt1().getPlayerOfString(awayTeam.getTeamName(),(String)cbPlayerAway1.getValue()),
                        main.getSt1().getPlayerOfString(homeTeam.getTeamName(),(String)cbPlayerHome1.getValue()),
                        main.getSt1().getPlayerOfString(homeTeam.getTeamName(),(String)cbPlayerHome2.getValue()));
                createMatch();
            }else if(checkAlreadyMadeMatch()==false & switcher==2){Alert a = new Alert(Alert.AlertType.INFORMATION);
                a.setContentText(String.format("You cannot modify a match that does not exist! Click new sheet button."));
                a.show();}
            else if(switcher==0){Alert a = new Alert(Alert.AlertType.INFORMATION);
                a.setContentText(String.format("Please first click new sheet or modify sheet button!!"));
                a.show();}
        }else{
            Alert a = new Alert(Alert.AlertType.INFORMATION);
            a.setContentText(String.format("Check you have no duplicate values in Coomboboxes or you have all Comboboxes completed!"));
            a.show();
        }
    }
    public Team calculateMatchWinner(List<Team> winners,Team homeTeam,Team awayTeam){
        Integer homeWins=0;
        Integer awayWins=0;
        for(Team team : winners)
        {
            if(team.teamEquals(homeTeam)){
                homeWins=homeWins+1;
            }else{awayWins=awayWins+1;}
        }
        if(homeWins>awayWins){return (homeTeam);}else{return (awayTeam);}
    }
    public void newSheetAct(){
        switcher=1;
        s11.setText("0:0");s12.setText("0:0");s13.setText("0:0");s14.setText("0:0");s15.setText("0:0");
        s16.setText("0:0");s21.setText("0:0");s22.setText("0:0");s23.setText("0:0");s24.setText("0:0");
        s25.setText("0:0");s26.setText("0:0");ds1.setText("0:0");ds2.setText("0:0");ds3.setText("0:0");
        finalScore.setText("Final score");

        listHomeTeam.getItems().clear();
        listHomeTeam.getItems().addAll(main.getSt1().getStrTeamsAH("Home"));
        listAwayTeam.getItems().clear();
        listAwayTeam.getItems().addAll(main.getSt1().getStrTeamsAH("Away"));

        cbPlayerAway1.getItems().clear();
        cbPlayerHome1.getItems().clear();
        cbPlayerHome2.getItems().clear();
        cbPlayerAway2.getItems().clear();

        cbPlayerAway2.setPromptText("away player");
        cbPlayerAway1.setPromptText("away player");
        cbPlayerHome1.setPromptText("home player");
        cbPlayerHome2.setPromptText("home player");


    }
    public void modifyAction(){
        switcher=2;
    }
    public Integer calculateWinner(List<Integer> homeScores, List<Integer> awayScores){// 1 is for home team winner and 0 for away team winner in one single set
        Integer homeScore=0;
        Integer awayScore=0;

        for (int i = 0; i < 3; i++){
            if(homeScores.get(i)>awayScores.get(i)){homeScore=homeScore+1;}else if(homeScores.get(i)<awayScores.get(i)){awayScore=awayScore+1;}
        }
        if(homeScore>awayScore){return 1;}else if(awayScore>homeScore){return 0;}else{return 2;}
    }
    public List<String> getMatrixFromWindow(){
        List<String> matrix=new ArrayList<String>();

        matrix.add(s11.getText());matrix.add(s12.getText());matrix.add(s13.getText());matrix.add(s14.getText());matrix.add(s15.getText());matrix.add(s16.getText());
        matrix.add(s21.getText());matrix.add(s22.getText());matrix.add(s23.getText());matrix.add(s24.getText());matrix.add(s25.getText());matrix.add(s26.getText());
        matrix.add(ds1.getText());matrix.add(ds2.getText());matrix.add(ds3.getText());

        return matrix;
    }
    public List<List<Integer>> getScores(){
        List<List<Integer>> matrix=new ArrayList<List<Integer>>();

        List<Integer> homeScore=new ArrayList<Integer>();matrix.add(homeScore);


        if(!s11.getText().equals("")){ matrix.get(0).add(Integer.parseInt(s11.getText().split(":")[0]));}else{matrix.get(0).add(null);}//matrix.get(0).get(0)
        if(!s12.getText().equals("")){ matrix.get(0).add(Integer.parseInt(s12.getText().split(":")[0]));}else{matrix.get(0).add(null);}
        if(!s13.getText().equals("")){ matrix.get(0).add(Integer.parseInt(s13.getText().split(":")[0]));}else{matrix.get(0).add(null);}
        if(!s14.getText().equals("")){ matrix.get(0).add(Integer.parseInt(s14.getText().split(":")[0]));}else{matrix.get(0).add(null);}
        if(!s15.getText().equals("")){ matrix.get(0).add(Integer.parseInt(s15.getText().split(":")[0]));}else{matrix.get(0).add(null);}
        if(!s16.getText().equals("")){ matrix.get(0).add(Integer.parseInt(s16.getText().split(":")[0]));}else{matrix.get(0).add(null);}

        if(!s11.getText().equals("")){ matrix.get(0).add(Integer.parseInt(s11.getText().split(":")[1]));}else{matrix.get(0).add(null);}
        if(!s12.getText().equals("")){ matrix.get(0).add(Integer.parseInt(s12.getText().split(":")[1]));}else{matrix.get(0).add(null);}
        if(!s13.getText().equals("")){ matrix.get(0).add(Integer.parseInt(s13.getText().split(":")[1]));}else{matrix.get(0).add(null);}
        if(!s14.getText().equals("")){ matrix.get(0).add(Integer.parseInt(s14.getText().split(":")[1]));}else{matrix.get(0).add(null);}
        if(!s15.getText().equals("")){ matrix.get(0).add(Integer.parseInt(s15.getText().split(":")[1]));}else{matrix.get(0).add(null);}
        if(!s16.getText().equals("")){ matrix.get(0).add(Integer.parseInt(s16.getText().split(":")[1]));}else{matrix.get(0).add(null);}



        List<Integer> awayScore=new ArrayList<Integer>();matrix.add(awayScore);
        if(!s21.getText().equals("")){ matrix.get(1).add(Integer.parseInt(s21.getText().split(":")[0]));}else{matrix.get(1).add(null);}
        if(!s22.getText().equals("")){ matrix.get(1).add(Integer.parseInt(s22.getText().split(":")[0]));}else{matrix.get(1).add(null);}
        if(!s23.getText().equals("")){ matrix.get(1).add(Integer.parseInt(s23.getText().split(":")[0]));}else{matrix.get(1).add(null);}
        if(!s24.getText().equals("")){ matrix.get(1).add(Integer.parseInt(s24.getText().split(":")[0]));}else{matrix.get(1).add(null);}
        if(!s25.getText().equals("")){ matrix.get(1).add(Integer.parseInt(s25.getText().split(":")[0]));}else{matrix.get(1).add(null);}
        if(!s26.getText().equals("")){ matrix.get(1).add(Integer.parseInt(s26.getText().split(":")[0]));}else{matrix.get(1).add(null);}

        if(!s21.getText().equals("")){ matrix.get(1).add(Integer.parseInt(s21.getText().split(":")[1]));}else{matrix.get(1).add(null);}
        if(!s22.getText().equals("")){ matrix.get(1).add(Integer.parseInt(s22.getText().split(":")[1]));}else{matrix.get(1).add(null);}
        if(!s23.getText().equals("")){ matrix.get(1).add(Integer.parseInt(s23.getText().split(":")[1]));}else{matrix.get(1).add(null);}
        if(!s24.getText().equals("")){ matrix.get(1).add(Integer.parseInt(s24.getText().split(":")[1]));}else{matrix.get(1).add(null);}
        if(!s25.getText().equals("")){ matrix.get(1).add(Integer.parseInt(s25.getText().split(":")[1]));}else{matrix.get(1).add(null);}
        if(!s26.getText().equals("")){ matrix.get(1).add(Integer.parseInt(s26.getText().split(":")[1]));}else{matrix.get(1).add(null);}


        List<Integer> dsScore=new ArrayList<Integer>();matrix.add(dsScore);

        if(!ds1.getText().equals("")){ matrix.get(2).add(Integer.parseInt(ds1.getText().split(":")[0]));}else{matrix.get(2).add(null);}
        if(!ds2.getText().equals("")){ matrix.get(2).add(Integer.parseInt(ds2.getText().split(":")[0]));}else{matrix.get(2).add(null);}
        if(!ds3.getText().equals("")){ matrix.get(2).add(Integer.parseInt(ds3.getText().split(":")[0]));}else{matrix.get(2).add(null);}

        if(!ds1.getText().equals("")){ matrix.get(2).add(Integer.parseInt(ds1.getText().split(":")[1]));}else{matrix.get(2).add(null);}
        if(!ds2.getText().equals("")){ matrix.get(2).add(Integer.parseInt(ds2.getText().split(":")[1]));}else{matrix.get(2).add(null);}
        if(!ds3.getText().equals("")){ matrix.get(2).add(Integer.parseInt(ds3.getText().split(":")[1]));}else{matrix.get(2).add(null);}


        return matrix;
    }
    public void initialize(){}
    public void init(MainController mainController) {
        main = mainController;
    }
}
