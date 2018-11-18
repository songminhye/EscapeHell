package com.bistsmh.escapehell;

public class Listviewitem {

    private String partStr, nameStr,scoreStr,ageStr;


    public void setPart(String part){
        partStr = part;
    }

    public void setName(String name){
        nameStr = name;
    }

    public void setScore(String score){
        scoreStr = score;
    }

    public void setAge(String age){
        ageStr = age;
    }

    public String getPart() {
        return this.partStr;

    }
    public String getName() {
        return this.nameStr;

    }

    public String getScore() {
        return this.scoreStr;

    }

    public String getAge() {
        return this.ageStr;

    }


}
