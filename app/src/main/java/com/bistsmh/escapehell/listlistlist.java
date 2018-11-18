package com.bistsmh.escapehell;

public class listlistlist {

    private String part, name,score,age;

    public listlistlist(){}

    public listlistlist(String part, String name, String score, String age){
        this.part = part;
        this.name = name;
        this.score = score;
        this.age = age;
    }

    public void setPart(String part){
        this.part= part;
    }

    public void setName(String name){
        this.part = name;
    }

    public void setScore(String score){
        this.score= score;
    }

    public void setAge(String age){
        this.age = age;
    }

    public String getPart() {
        return part;

    }
    public String getName() {
        return name;

    }

    public String getScore() {
        return score;

    }

    public String getAge() {
        return age;

    }


}
