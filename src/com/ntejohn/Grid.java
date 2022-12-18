package com.ntejohn;

public enum Grid {

    COLUMN_1 ( 0,-1,-1,GridType.COL),
    COLUMN_2 ( 1,-1,-1,GridType.COL),
    COLUMN_3 ( 2,-1,-1,GridType.COL),
    COLUMN_4 ( 3,-1,-1,GridType.COL),
    COLUMN_5 ( 4,-1,-1,GridType.COL),
    COLUMN_6 ( 5,-1,-1,GridType.COL),
    COLUMN_7 ( 6,-1,-1,GridType.COL),
    COLUMN_8 ( 7,-1,-1,GridType.COL),
    COLUMN_9 ( 8,-1,-1,GridType.COL),


    ROW_1 ( 0,-1,-1,GridType.ROW),
    ROW_2 ( 9,-1, -1,GridType.ROW),
    ROW_3 ( 18,-1,-1,GridType.ROW),
    ROW_4 ( 27,-1,-1,GridType.ROW),
    ROW_5 ( 36,-1,-1,GridType.ROW),
    ROW_6 ( 45,-1,-1,GridType.ROW),
    ROW_7 ( 54,-1,-1,GridType.ROW),
    ROW_8 ( 63,-1,-1,GridType.ROW),
    ROW_9 ( 72,-1,-1,GridType.ROW),

    GRID_1 ( 0,0,0,GridType.GRID),
    GRID_2 ( 1,0,1,GridType.GRID),
    GRID_3 ( 2,0,2,GridType.GRID),
    GRID_4 ( 0,1,3,GridType.GRID),
    GRID_5 ( 1,1,4,GridType.GRID),
    GRID_6 ( 2,1,5,GridType.GRID),
    GRID_7 ( 0,2,6,GridType.GRID),
    GRID_8 ( 1,2,7,GridType.GRID),
    GRID_9 ( 2,2,8,GridType.GRID);

    public int position;
    public int position2;
    public int position3;
    GridType type;
    static Grid[] columns = new Grid[]{COLUMN_1,COLUMN_2,COLUMN_3,COLUMN_4,COLUMN_5,COLUMN_6,COLUMN_7,COLUMN_8,COLUMN_9};
    static Grid[] rows = new Grid[]{ROW_1,ROW_2,ROW_3,ROW_4,ROW_5,ROW_6,ROW_7,ROW_8,ROW_9};
    static Grid[] areas = new Grid[]{GRID_1,GRID_2,GRID_3,GRID_4,GRID_5,GRID_6,GRID_7,GRID_8,GRID_9};

    Grid(int position,int position2, int position3,GridType type) {
        this.position = position;
        this.position2 = position2;
        this.position3 =position3;
        this.type = type;
    }

    public static Grid getColumn(int position) {
        for (Grid grid : columns) {
            if (grid.position == position) return grid;
        }
        throw new IllegalArgumentException("Position not found.");
    }
    public static Grid getRow(int position) {
        for (Grid grid : rows) {
            if (grid.position == position ) return grid;
        }
        throw new IllegalArgumentException("Position not found.");
    }
    public static Grid getArea(int column, int row) {
        for (Grid grid : areas) {
            if (grid.position == column && grid.position2 == row ) return grid;
        }
        throw new IllegalArgumentException("Position not found.");
    }
}
