package controller;

import classes.Match;
import classes.Player;
import classes.Scoresheet;
import classes.Team;

import java.util.*;

public class Storage {



    //private List<Team> homeTeams;
    //private List<Team> awayTeams;
    private List<Team> teams;
    private Map<Team,List<String>> dicTeams;
    private List<Match> matches;

    public Boolean searchForExistingMatch(Team awayTeam, Team homeTeam, Player awayPlayer1, Player awayPlayer2, Player homePlayer1, Player homePlayer2){
        for (Match match :matches){
            System.out.println("===============");
            System.out.println(match.getAwayTeam().getTeamName());
            System.out.println(awayTeam.getTeamName());
            System.out.println(match.getHomeTeam().getTeamName());System.out.println(homeTeam.getTeamName());
            System.out.println(match.getPlayers().contains(awayPlayer1) & match.getPlayers().contains(awayPlayer2) & match.getPlayers().contains(homePlayer1) &
                    match.getPlayers().contains(homePlayer2));
            System.out.println("===============");

            System.out.println("===============");
            if(match.getAwayTeam().getTeamName().equals(awayTeam.getTeamName()) & match.getHomeTeam().getTeamName().equals(homeTeam.getTeamName())){
                if(match.getPlayers().contains(awayPlayer1) & match.getPlayers().contains(awayPlayer2) & match.getPlayers().contains(homePlayer1) &
                        match.getPlayers().contains(homePlayer2)){
                    return true;
                }
            }
        }
        return false;
    }
    public void printMatches(){
        System.out.println("------------------------------");
        for (Match match :matches){
            System.out.println("---------------------#-------");
            System.out.println(match.getHomeTeam());
            System.out.println(match.getAwayTeam());
            for (Player p: match.getPlayers()){
                System.out.println(p.getPlayerName());
            }
            for (String s:match.getMatrix()){
                System.out.println(s);
            }
            System.out.println("---------------------#-------");
        }
        System.out.println("------------------------------");
    }
    public List<List> searchForMatches(Team t){
        List<List> returningList=new ArrayList<List>();
        List<Match> matches2=new ArrayList<Match>();
        List<Match> matchesWon=new ArrayList<Match>();
        List<Scoresheet> setsWon=new ArrayList<Scoresheet>();
        for (Match match :matches){
            if(match.getAwayTeam().getTeamName().equals(t.getTeamName()) | match.getHomeTeam().getTeamName().equals(t.getTeamName())){
                matches2.add(match);
            }
            if(match.getWinner().getTeamName().equals(t.getTeamName())){
                matchesWon.add(match);
            }
            for (Scoresheet s: match.getSets()){
                if(s.getWinner().getTeamName().equals(t.getTeamName())){
                    setsWon.add(s);
                }
            }
        }
        returningList.add(matches2);returningList.add(matchesWon);returningList.add(setsWon);
        return returningList;
    }
    public Match searchForMatch2(Team awayTeam, Team homeTeam){
        for (Match match :matches){
            if(match.getAwayTeam().getTeamName().equals(awayTeam.getTeamName()) & match.getHomeTeam().getTeamName().equals(homeTeam.getTeamName())){
                return match;
            }
        }
        return null;
    }
    public Match searchForMatch(Team awayTeam, Team homeTeam, Player awayPlayer1, Player awayPlayer2, Player homePlayer1, Player homePlayer2){
        for (Match match :matches){
            if(match.getAwayTeam().getTeamName().equals(awayTeam.getTeamName()) & match.getHomeTeam().getTeamName().equals(homeTeam.getTeamName())){
                if(match.getPlayers().contains(awayPlayer1) & match.getPlayers().contains(awayPlayer2) & match.getPlayers().contains(homePlayer1) &
                        match.getPlayers().contains(homePlayer2)){
                    return match;
                }
            }
        }
        return null;
    }
    public void searchForMatchAndDelete(Team awayTeam, Team homeTeam, Player awayPlayer1, Player awayPlayer2, Player homePlayer1, Player homePlayer2){
        Iterator<Match> iter=matches.iterator();
        while(iter.hasNext()){
            Match match=iter.next();
            if(match.getAwayTeam().getTeamName().equals(awayTeam.getTeamName()) & match.getHomeTeam().getTeamName().equals(homeTeam.getTeamName())){
                if(match.getPlayers().contains(awayPlayer1) & match.getPlayers().contains(awayPlayer2) & match.getPlayers().contains(homePlayer1) &
                        match.getPlayers().contains(homePlayer2)){
                    iter.remove();
                }
            }
        }
    }
    public Storage() {
        teams=new ArrayList<Team>();
        dicTeams=new HashMap<Team,List<String>>();// example team Das and is playing in both away and home
        matches=new ArrayList<Match>();
        //hence the list
    }
    public List<Team> getTeams() {
        return teams;
    }

    public Map<Team, List<String>> getDicTeams() {
        return dicTeams;
    }
    public void setListHomeORAway(Team team,List<String> homeORAway){
        dicTeams.put(team,homeORAway);
    }

    public Team getTeamOfString(String teamName){
        for(Team team : teams)
        {
            if(team.getTeamName().equals(teamName)){
                return(team);
            }
        }
        return(null);
    }

    public List<Match> getMatches() {
        return matches;
    }

    public List<String> getStrTeams(){
        List<String> strTeamNames=new ArrayList<String>();

        for(Team team : teams)
        {
            strTeamNames.add(team.getTeamName());
        }

        return strTeamNames;
    }
    public List<String> getStrTeamsAH(String awayOrHome){
        List<String> aOrHome=new ArrayList<String>();

        for(Team team : teams)
        {
            if(dicTeams.get(team).size()==2){
                aOrHome.add(team.getTeamName());
            }else if(dicTeams.get(team).get(0).equals(awayOrHome)){
                aOrHome.add(team.getTeamName());
            }else{}
        }
        return aOrHome;
    }
    public Player getPlayerOfString(String teamName,String playerName){
        Team team=getTeamOfString(teamName);
        for(Player player : team.getPlayerList())
        {
            if(player.getPlayerName().equals(playerName)){
                return(player);
            }
        }
        return null;
    }
    public List<String> getStrPlayersNames(Team t){
        List<String> playerNames=new ArrayList<String>();
        for(Player player : t.getPlayerList())
        {
            playerNames.add(player.getPlayerName());
        }
        return playerNames;

    }

}
