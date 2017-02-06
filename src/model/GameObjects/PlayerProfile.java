package model.GameObjects;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ASUS on 16/12/2016.
 */

class Node{
    String MatchType;
    double record;
    Node next;
    Node(double record, String matchType){
        this.MatchType = matchType;
        this.record = record;
    }
}

class Node2{

    double record;
    double totalTime;

    Node2(double record, double totalTime){
        this.record = record;
        this.totalTime = totalTime;

    }
}

public class PlayerProfile {

    private String name;
    private double money;
    private double popularity;
    private double bestScore;
    private double preMoney;
    private List<Node2> recordsPerRound;//holds record of each round
    private List<Node> recordsPerMatch;//holds record of each match
    private List<Car> cars;



    //constructor
    public PlayerProfile(String name, double preMoney, double popularity, double bestScore){
        this.name = name;
        this.preMoney = preMoney;
        this.money = preMoney;
        this.popularity = popularity;
        this.bestScore = bestScore;
        recordsPerMatch = new ArrayList<Node>();
        recordsPerRound = new ArrayList<Node2>();
        cars = new ArrayList<>();

    }



    public double getBestScore() {
        return bestScore;
    }

    public void setBestScore(double bestScore) {
        this.bestScore = bestScore;
    }

    public double getMoney() {
        return money;
    }

    public double getPreMoney() {return preMoney; }

    public void setMoney(double money) {
        this.money = money;
    }

    public double getPopularity() {
        return popularity;
    }

    public void setPopularity(double popularity) {
        if (this.popularity < popularity)
            this.popularity = popularity;
    }


    public List<Node> getRecordsPerMatch() {
        return recordsPerMatch;
    }

    public List<Node2> getRecordsPerRound() {
        return recordsPerRound;
    }

    public List<Car> getCars() {
        return cars;
    }
}

