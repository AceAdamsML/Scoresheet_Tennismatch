package controller;

import controller.tab.ControllerScoreSheet;
import controller.tab.ControllerViewerPage;
import javafx.fxml.FXML;
import controller.tab.AdminC;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import classes.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;


public class MainController {
	public ControllerScoreSheet getTab3Controller() {
		return tab3Controller;
	}

	public ControllerViewerPage getTab2Controller() {
		return tab2Controller;
	}

	public AdminC getTab1Controller() {
		return tab1Controller;
	}

	public void setTab3Controller(ControllerScoreSheet tab3Controller) {
		this.tab3Controller = tab3Controller;
	}

	public void setTab2Controller(ControllerViewerPage tab2Controller) {
		this.tab2Controller = tab2Controller;
	}

	public void setTab1Controller(AdminC tab1Controller) {
		this.tab1Controller = tab1Controller;
	}

	@FXML ControllerScoreSheet tab3Controller;
	@FXML ControllerViewerPage tab2Controller;
	@FXML AdminC tab1Controller;



	private Storage st1;
	
	public void initialize() {
		System.out.println("Application started");
		st1=new Storage();
		try {
			tab1Controller.init(this);
			tab2Controller.init(this);
			tab3Controller.init(this);

		} catch(Exception e) {System.out.println("hi");}
		scoreControllerPopulateTestData();
	}
	public Storage getSt1() {
		return st1;
	}
	public void scoreControllerPopulateTestData(){
		List<Match> matches = new ArrayList<Match>();
		List<Scoresheet> set1 = new ArrayList<>();
		List<Scoresheet> set2 = new ArrayList<>();

		List<String> matrix1=new ArrayList<>(Arrays.asList("11:2","3:11","11:5","1:11","5:11","11:6",
				"11:9","11:1","11:1","11:2","3:11","11:5","0:11","1:11","2:11","3:2"));
		List<String> matrix2=new ArrayList<>(Arrays.asList("11:2","3:11","11:5","11:1","5:11","11:6",
				"11:9","11:1","11:1","11:2","3:11","11:5","0:11","1:11","2:11","4:1"));

		//for first match
		List<Integer> homeTeamScore1=new ArrayList<>(Arrays.asList(11,3,11));
		List<Integer> homeTeamScore2=new ArrayList<>(Arrays.asList(1,5,11));
		List<Integer> homeTeamScore3=new ArrayList<>(Arrays.asList(11,11,11));
		List<Integer> homeTeamScore4=new ArrayList<>(Arrays.asList(11,3,11));
		List<Integer> homeTeamScore5=new ArrayList<>(Arrays.asList(0,1,2));

		List<Integer> awayTeamScore1=new ArrayList<>(Arrays.asList(2,11,5));
		List<Integer> awayTeamScore2=new ArrayList<>(Arrays.asList(11,11,6));
		List<Integer> awayTeamScore3=new ArrayList<>(Arrays.asList(9,1,1));
		List<Integer> awayTeamScore4=new ArrayList<>(Arrays.asList(2,11,5));
		List<Integer> awayTeamScore5=new ArrayList<>(Arrays.asList(11,11,11));

		//for second match
		List<Integer> homeTeamScore11=new ArrayList<>(Arrays.asList(11,3,11));
		List<Integer> homeTeamScore22=new ArrayList<>(Arrays.asList(11,5,11));
		List<Integer> homeTeamScore33=new ArrayList<>(Arrays.asList(11,11,11));
		List<Integer> homeTeamScore44=new ArrayList<>(Arrays.asList(11,3,11));
		List<Integer> homeTeamScore55=new ArrayList<>(Arrays.asList(0,1,2));

		List<Integer> awayTeamScore11=new ArrayList<>(Arrays.asList(2,11,5));
		List<Integer> awayTeamScore22=new ArrayList<>(Arrays.asList(1,11,6));
		List<Integer> awayTeamScore33=new ArrayList<>(Arrays.asList(9,1,1));
		List<Integer> awayTeamScore44=new ArrayList<>(Arrays.asList(2,11,5));
		List<Integer> awayTeamScore55=new ArrayList<>(Arrays.asList(2,11,11));

		//list of players
		List<Player> players1=new ArrayList<>();
		//list of teams
		List<Team> teams=new ArrayList<>();

		players1.add(new Player("alex"));
		players1.add(new Player("brian"));
		players1.add(new Player("jin"));
		players1.add(new Player("julia"));
		players1.add(new Player("stewart"));
		players1.add(new Player("chris"));
		players1.add(new Player("ryan"));
		players1.add(new Player("peter"));
		players1.add(new Player("phill"));

		teams.add(new Team("filton"));teams.add(new Team("uwe"));teams.add(new Team("kcc"));teams.add(new Team("page"));

		teams.get(0).setPlayerList(players1.subList(0,2));
		teams.get(1).setPlayerList(players1.subList(2,5));
		teams.get(2).setPlayerList(players1.subList(5,7));
		teams.get(3).setPlayerList(players1.subList(7,9));


		set1.add(new Scoresheet(teams.get(0),teams.get(1),new ArrayList<Player>(Arrays.asList(players1.get(0),players1.get(2))),true,homeTeamScore1,awayTeamScore1,teams.get(0),new Date()));
		set1.add(new Scoresheet(teams.get(0),teams.get(1),new ArrayList<Player>(Arrays.asList(players1.get(0),players1.get(3))),true,homeTeamScore2,awayTeamScore2,teams.get(1),new Date()));
		set1.add(new Scoresheet(teams.get(0),teams.get(1),new ArrayList<Player>(Arrays.asList(players1.get(1),players1.get(2))),true,homeTeamScore3,awayTeamScore3,teams.get(0),new Date()));
		set1.add(new Scoresheet(teams.get(0),teams.get(1),new ArrayList<Player>(Arrays.asList(players1.get(1),players1.get(3))),true,homeTeamScore4,awayTeamScore4,teams.get(0),new Date()));
		set1.add(new Scoresheet(teams.get(0),teams.get(1),players1.subList(0,4),true,homeTeamScore5,awayTeamScore5,teams.get(1),new Date()));

		set2.add(new Scoresheet(teams.get(1),teams.get(3),new ArrayList<Player>(Arrays.asList(players1.get(0),players1.get(3))),true,homeTeamScore11,awayTeamScore11,teams.get(1),new Date()));
		set2.add(new Scoresheet(teams.get(1),teams.get(3),new ArrayList<Player>(Arrays.asList(players1.get(0),players1.get(3))),true,homeTeamScore22,awayTeamScore22,teams.get(1),new Date()));
		set2.add(new Scoresheet(teams.get(1),teams.get(3),new ArrayList<Player>(Arrays.asList(players1.get(0),players1.get(3))),true,homeTeamScore33,awayTeamScore33,teams.get(1),new Date()));
		set2.add(new Scoresheet(teams.get(1),teams.get(3),new ArrayList<Player>(Arrays.asList(players1.get(0),players1.get(3))),true,homeTeamScore44,awayTeamScore44,teams.get(1),new Date()));
		set2.add(new Scoresheet(teams.get(1),teams.get(3),new ArrayList<Player>(Arrays.asList(players1.get(2),players1.get(3),players1.get(7),players1.get(8))),true,homeTeamScore55,awayTeamScore55,teams.get(3),new Date()));

		Match match1=new Match(new Date(),teams.get(0),teams.get(1),true,players1.subList(0,4),teams.get(0),set1,matrix1);
		getSt1().getMatches().add(match1);
		Match match2=new Match(new Date(),teams.get(1),teams.get(3),true,new ArrayList<Player>(Arrays.asList(players1.get(2),players1.get(3),players1.get(7),players1.get(8))),teams.get(1),set2,matrix2);
		getSt1().getMatches().add(match2);

		getTab3Controller().updateListTeam(teams.get(0), "Home");
		getTab3Controller().updateListTeam(teams.get(1), "Home");

		getTab3Controller().updateListTeam(teams.get(1), "Away");
		getTab3Controller().updateListTeam(teams.get(3), "Away");

		getTab3Controller().updateListTeam(teams.get(2), "Away");
		getTab3Controller().updateListTeam(teams.get(2), "Home");

		getTab1Controller().updateCBTeams();
		getTab2Controller().updateCbs();

		getTab2Controller().setMatches(getSt1().getMatches());
		getTab2Controller().setTeams(getSt1().getTeams());

		getTab2Controller().updateAllTeamRankings();
		getTab2Controller().updateAllTeamStats();
	}
//	public String loadLblTextFromTab1() {
//		return tab1Controller.lbl1.getText();
//	}
//
//	public void setTab2LabelText(String text) {
//		tab2Controller.lbl2.setText(text);
//	}
}
