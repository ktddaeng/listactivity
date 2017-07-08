package com.example.gadau.cardinventory.data;

import java.util.ArrayList;

/**
 * Created by gadau on 7/7/2017.
 */

public class ListItem {
    private String cardID;
    private String row;
    private String column;
    private String vendor;
    private int status;
    private ArrayList<String> tagList;
    //TODO: Add more for comprehensive view

    //TODO: Update more constructors for more variables


    public ListItem(String cardID, String row, String column, String vendor, int status, ArrayList<String> tagList) {
        this.cardID = cardID;
        this.row = row;
        this.column = column;
        this.vendor = vendor;
        this.status = status;
        this.tagList = tagList;
    }

    public String getCardID() {
        return cardID;
    }

    public String getVendor() {
        return vendor;
    }

    public int getStatus() {
        return status;
    }

    public String getRow() { return row; }

    public String getColumn() {
        return column;
    }

    //TODO: Add more getters

    public void setCardID(String cardID) {
        this.cardID = cardID;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public void setTagList(ArrayList<String> tagList) {
        this.tagList = tagList;
    }

    public ArrayList<String> getTagList() {
        return tagList;
    }

    public void setRow(String row) { this.row = row; }

    public void setColumn(String column) { this.column = column; }

    //TODO: Add more setters
}