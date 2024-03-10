package boottapak.jakgrit.lab11;

import java.io.Serializable;
import java.util.ArrayList;

public class Player implements Serializable {
    private static final long serialVersionUID = -3722985238703521524L;

    private String name, nationality, dob, playerType, gender;
    private ArrayList<String> hobbies, sports;
    private int year;

    public Player(String name, String nationality, String dob, String playerType, String gender,
            ArrayList<String> hobbies, ArrayList<String> sports, int year) {
        this.name = name;
        this.nationality = nationality;
        this.dob = dob;
        this.playerType = playerType;
        this.gender = gender;
        this.hobbies = hobbies;
        this.sports = sports;
        this.year = year;
    }

    // Getters
    public String getName() {
        return name;
    }

    public String getNationality() {
        return nationality;
    }

    public String getDob() {
        return dob;
    }

    public String getPlayerType() {
        return playerType;
    }

    public String getGender() {
        return gender;
    }

    public ArrayList<String> getHobbies() {
        return hobbies;
    }

    public ArrayList<String> getSports() {
        return sports;
    }

    public int getYear() {
        return year;
    }

    // Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public void setPlayerType(String playerType) {
        this.playerType = playerType;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setHobbies(ArrayList<String> hobbies) {
        this.hobbies = hobbies;
    }

    public void setSports(ArrayList<String> sports) {
        this.sports = sports;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "name:" + getName() + " nation:" + getNationality() + " dob:" + getDob() + " playerType:" + getPlayerType() + 
        " gender:" + getGender() + " hobbies:" + getHobbies() + " sport:" + getSports() + " year:" + getYear();
    }
}
