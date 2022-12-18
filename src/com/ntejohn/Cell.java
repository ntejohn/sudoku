package com.ntejohn;

import java.util.*;

public class Cell {

    private int value;


    private int iRow;
    private int iColumn;
    private int iArea;

    public void setMapIndexes(int iRow, int iColumn, int iArea) {
        this.iRow = iRow;
        this.iColumn = iColumn;
        this.iArea = iArea;
    }

    public int getiRow() {
        return iRow;
    }

    public int getiColumn() {
        return iColumn;
    }

    public int getiArea() {
        return iArea;
    }

    public Cell(int value){
        this.value = value;
    }

    public int getValue(){
        return this.value;
    }

    public void setValue(int value){
        this.value = value;
    }

}
