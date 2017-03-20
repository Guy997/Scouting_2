package frc.team1339.frc.team1339.utils;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;

/**
 * Created by Guy997 on 3/20/17.
 */
public class Scores {

    static Elements temp;
    static Document doc;

    public static ArrayList<String> getRedScore(){
        ArrayList<String> redScore = new ArrayList<String>();
        temp = doc.select("td.redScore");
        int i = 0;
        for(Element teamList:temp){
            if(i % 2 == 1){
                redScore.add(teamList.getElementsByTag("span").first().text().toString());
            }
            i++;
        }
        return redScore;
    }

    public static ArrayList<String> getBlueScore(){
        ArrayList<String> blueScore = new ArrayList<String>();
        temp = doc.select("td.blueScore");
        int i = 0;
        for(Element teamList:temp){
            if(i % 2 == 1){
                blueScore.add(teamList.getElementsByTag("span").first().text().toString());
            }
            i++;
        }
        return blueScore;
    }
}
