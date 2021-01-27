package com.example.nhom7;

public class item_khao_sat {
    String mamon, link;
    public item_khao_sat(String mamon, String link) {
        this.mamon = mamon;
        this.link = link;
    }

    public String getLink() {
        return link;
    }

    public String getMamon() {
        return mamon;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public void setMamon(String mamon) {
        this.mamon = mamon;
    }

    public item_khao_sat() {

    }
}