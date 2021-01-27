package com.example.nhom7;

public class item_schedual {
    private String name;
    private String id;
    private String day;
    private String time;
    private String room;
    private String GV;

    public void setName(String name) {this.name = name;}
    public void setID(String id) {this.id = id;}
    public void setDay(String day) {this.day = day;}
    public void setTime(String time) {this.time = time;}
    public void setRoom(String room) {this.room = room;}
    public void setGV(String GV) {this.GV = GV; }

    public String getName() {return this.name;}
    public String getID() {return this.id;}
    public String getDay() {return this.day;}
    public String getTime() {return this.time;}
    public String getRoom() {return this.room;}
    public String getGV() {return this.GV;}
}
