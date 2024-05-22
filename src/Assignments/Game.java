package Assignments;

import Person.Assignor;
import Person.Official;
import java.time.LocalDate;
import java.time.LocalTime;


public class Game extends Event{
    private Integer gameID;
    private String organizationName;
    private Assignor assignor;
    private Official official1;
    private Official official2;
    private Official official3;
    private LocalDate date;
    private LocalTime startTime;
    private LocalTime endTime;

    private String team1;
    private String team2;
    private String location;
    private String division;

    public Game(GameDatabase database) {
        this.gameID = database.generateGameID();
    }

    // Getters
    // Getter for gameID
    public Integer getGameID() {
        return gameID;
    }

    // Setter for gameID
    public void setGameID(Integer gameID) {
        this.gameID = gameID;
    }

    // Getter for organizationName
    public String getOrganizationName() {
        return organizationName;
    }

    // Setter for organizationName
    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
    }

    // Getter for assignor
    public Assignor getAssignor() {
        return assignor;
    }

    // Setter for assignor
    public void setAssignor(Assignor assignor) {
        this.assignor = assignor;
    }

    // Getter for official1
    public Official getOfficial1() {
        return official1;
    }

    // Setter for official1
    public void setOfficial1(Official official1) {
        this.official1 = official1;
    }

    // Getter for official2
    public Official getOfficial2() {
        return official2;
    }

    // Setter for official2
    public void setOfficial2(Official official2) {
        this.official2 = official2;
    }

    // Getter for official3
    public Official getOfficial3() {
        return official3;
    }

    // Setter for official3
    public void setOfficial3(Official official3) {
        this.official3 = official3;
    }

    // Getter for date
    public LocalDate getDate() {
        return date;
    }

    // Setter for date
    public void setDate(LocalDate date) {
        this.date = date;
    }

    // Getter for startTime
    public LocalTime getStartTime() {
        return startTime;
    }

    // Setter for startTime
    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    // Getter for endTime
    public LocalTime getEndTime() {
        return endTime;
    }

    // Setter for endTime
    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }

    // Getter for team1
    public String getTeam1() {
        return team1;
    }

    // Setter for team1
    public void setTeam1(String team1) {
        this.team1 = team1;
    }

    // Getter for team2
    public String getTeam2() {
        return team2;
    }

    // Setter for team2
    public void setTeam2(String team2) {
        this.team2 = team2;
    }

    // Getter for location
    public String getLocation() {
        return location;
    }

    // Setter for location
    public void setLocation(String location) {
        this.location = location;
    }

    // Getter for division
    public String getDivision() {
        return division;
    }

    // Setter for division
    public void setDivision(String division) {
        this.division = division;
    }


}
