/**
 * Created by Guy997 on 3/20/17.
 */
package frc.team1339.master;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import frc.team1339.frc.team1339.utils.Scores;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;



import frc.team1339.quals.QualsMatch;

public class Main {

    static ArrayList<String> teamNumbers = new ArrayList<String>();
    static ArrayList<String> teamNames = new ArrayList<String>();
    static ArrayList<QualsMatch> quals = new ArrayList<QualsMatch>();
    static Elements temp;
    static Document doc;

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        try {
            doc = Jsoup.connect("https://www.thebluealliance.com/event/2017utwv").userAgent("chrome/56.0.2924.87").get();
        }
        catch(IOException e){
            e.printStackTrace();
        }
		/*
		generateQual();
		for(int i = 0; i < 160; i++){
			if(i % 2 == 0){
				System.out.println("Quals Match " + ((i/2) + 1));
			}
			System.out.println(quals.get(i).toString());
			if(i % 2 == 1){
				System.out.println();
			}
		}
		*/
		//generateQual();
        //System.out.println(averageScore(2996));
        writeToText();
        //ArrayList<Integer> rip = getTeamNumbers();
        //getTeamNumbers();
        //for(int i = 0; i < rip.size(); i++){
        //    System.out.println(rip.get(i));
        //}
    }

    public static void writeToText(){
        try{
            ArrayList<Integer> rip = getTeamNumbers();
            PrintWriter writer = new PrintWriter("1339-scouting.txt", "UTF-8");
            //getTeamNames();
            for(int j = 0; j < rip.size(); j++){
                writer.println(rip.get(j));
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void generateQual(){
        ArrayList<String> one = getTeamOne();
        ArrayList<String> two = getTeamTwo();
        ArrayList<String> three = getTeamThree();
        ArrayList<String> four = getTeamFour();
        ArrayList<String> five = getTeamFive();
        ArrayList<String> six = getTeamSix();
        ArrayList<String> blueScore = Scores.getBlueScore();
        ArrayList<String> redScore = Scores.getRedScore();
        for(int i = 0; i < 80; i++){
            quals.add(new QualsMatch(true, one.get(i), two.get(i), three.get(i), redScore.get(i)));
            quals.add(new QualsMatch(false, four.get(i), five.get(i), six.get(i), blueScore.get(i)));
        }
    }

    public static void getTeamNames(){
        temp = doc.select("div.team-name");
        for(Element teamList:temp){
            teamNames.add(teamList.getElementsByTag("a").first().text().toString());
        }
    }

    public static ArrayList<Integer> getTeamNumbers(){
        temp = doc.select("div.team-name");
        ArrayList<Integer> arr = new ArrayList<Integer>();
        String str = new String();
        for(Element teamList:temp){
            str = teamList.getElementsByTag("a").first().text().toString();
            str = str.substring(0, str.indexOf(" "));
            teamNames.add(str);
        }
        for(int i = 0; i < teamNames.size(); i++){
            arr.add(Integer.parseInt(teamNames.get(i)));
        }
        return arr;
    }

    public static ArrayList<String> getTeamOne(){
        ArrayList<String> redOne = new ArrayList<String>();
        temp = doc.select("td.red");
        int i = 0;
        int j = 0;
        boolean bool = true;
        for(Element teamList:temp){
            if(i % 3 == 0) bool = !bool;
            if(bool) {
                if(j % 3 == 0){ //==1 for second, ==2 for third
                    redOne.add(teamList.getElementsByTag("a").first().text().toString());
                }
            }
            j++;
            i++;
        }
        return redOne;
    }
    public static ArrayList<String> getTeamTwo(){
        ArrayList<String> redTwo = new ArrayList<String>();
        temp = doc.select("td.red");
        int i = 0;
        int j = 0;
        boolean bool = true;
        for(Element teamList:temp){
            if(i % 3 == 0) bool = !bool;
            if(bool) {
                if(j % 3 == 1){
                    redTwo.add(teamList.getElementsByTag("a").first().text().toString());
                }
            }
            j++;
            i++;
        }
        return redTwo;
    }

    public static ArrayList<String> getTeamThree(){
        ArrayList<String> redThree = new ArrayList<String>();
        temp = doc.select("td.red");
        int i = 0;
        int j = 0;
        boolean bool = true;
        for(Element teamList:temp){
            if(i % 3 == 0) bool = !bool;
            if(bool) {
                if(j % 3 == 2){
                    redThree.add(teamList.getElementsByTag("a").first().text().toString());
                }
            }
            j++;
            i++;
        }
        return redThree;
    }

    public static ArrayList<String> getTeamFour(){
        ArrayList<String> blueOne = new ArrayList<String>();
        temp = doc.select("td.blue");
        int i = 0;
        int j = 0;
        boolean bool = true;
        for(Element teamList:temp){
            if(i % 3 == 0) bool = !bool;
            if(bool) {
                if(j % 3 == 0){
                    blueOne.add(teamList.getElementsByTag("a").first().text().toString());
                }
            }
            j++;
            i++;
        }
        return blueOne;
    }

    public static ArrayList<String> getTeamFive(){
        ArrayList<String> blueTwo = new ArrayList<String>();
        temp = doc.select("td.blue");
        int i = 0;
        int j = 0;
        boolean bool = true;
        for(Element teamList:temp){
            if(i % 3 == 0) bool = !bool;
            if(bool) {
                if(j % 3 == 1){
                    blueTwo.add(teamList.getElementsByTag("a").first().text().toString());
                }
            }
            j++;
            i++;
        }
        return blueTwo;
    }

    public static ArrayList<String> getTeamSix(){
        ArrayList<String> blueThree = new ArrayList<String>();
        temp = doc.select("td.blue");
        int i = 0;
        int j = 0;
        boolean bool = true;
        for(Element teamList:temp){
            if(i % 3 == 0) bool = !bool;
            if(bool) {
                if(j % 3 == 2){
                    blueThree.add(teamList.getElementsByTag("a").first().text().toString());
                }
            }
            j++;
            i++;
        }
        return blueThree;
    }

    public static int getRedScore(int matchNum){
        return Integer.parseInt(quals.get(matchNum + 1).getScore().toString());
    }
    public static int getBlueScore(int matchNum){
        return Integer.parseInt(quals.get(matchNum + 1).getScore().toString());
    }

    public static boolean isRed(int index){
        ArrayList<Boolean> color = new ArrayList<Boolean>();
        for(int i = 0; i < quals.size(); i++){
            if(quals.get(i).getColor()) color.add(true);
            else color.add(false);
        }
        return color.get(index);
    }

    public static ArrayList<Integer> getMatchNums(int teamNumber){
        ArrayList<Integer> num = new ArrayList<Integer>();
        Document doc2 = null;
        try {
            doc2 = Jsoup.connect("https://www.thebluealliance.com/team/" + teamNumber + "/2017").userAgent("chrome/56.0.2924.87").get();
        }
        catch(IOException e){
            e.printStackTrace();
        }
        temp = doc2.getElementsByClass("match-name");
        int i = 0;
        for(Element teamList:temp) { //Get the match numbers
            if (i % 2 == 0) {
                String match = teamList.getElementsByTag("a").first().text().toString();
                if (match.length() < 9) {
                    if (match.substring(0, 1).equalsIgnoreCase("q")) {
                        num.add(Integer.parseInt(match.substring(match.lastIndexOf(" ") + 1)));
                    }
                }
            }
            i++;
        }
        return num;
    }

    public static double averageScore(int teamNumber){
        ArrayList<Integer> scores = new ArrayList<Integer>();
        Document doc2 = null;
        //Try to connect to thebluealliance.com and search for the team number
        try {
            doc2 = Jsoup.connect("https://www.thebluealliance.com/team/" + teamNumber + "/2017").userAgent
                    ("chrome/56.0.2924.87").get();
        }
        catch(IOException e){
            e.printStackTrace();
        }
        //Defining counter
        int i = 0;
        //Defining temp to search for the specific class
        temp = doc2.getElementsByClass("redScore current-team");

        for (Element teamList : temp) {
            if (i % 2 == 0) {
                String score = teamList.getElementsByTag("span").first().text().toString();
                scores.add(Integer.parseInt(score));
            }
            i++;
        }
        //Resetting counter
        i = 0;
        //Setting temp to search for the className "blueScore"
        temp = doc2.getElementsByClass("blueScore current-team");
        //Loops through temp and finds the tag "span" and puts those values in ArrayList scores
        for (Element teamList : temp) {
            if (i % 2 == 0) {
                String score = teamList.getElementsByTag("span").first().text().toString();
                scores.add(Integer.parseInt(score));
            }
            i++;
        }
        //Average algorithm
        double sum = 0;
        for(i = 0; i < scores.size(); i++){
            sum += scores.get(i);
        }
        sum = sum/scores.size();
        return sum;
    }
}