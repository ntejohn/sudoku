package com.ntejohn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.BiPredicate;

public class Sudoku {

    public List<Cell> cells = new ArrayList<>();

    public int[] sud;
    List<HashMap<Integer, Boolean>> hmRow = new ArrayList<>();
    List<HashMap<Integer, Boolean>> hmColumn = new ArrayList<>();
    List<HashMap<Integer, Boolean>> hmArea = new ArrayList<>();

    public Sudoku(){}
    public Sudoku(int[] nums) {
        sud = nums;
    }

    public void initArray() {

        sud = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0,
                0, 0, 5, 0, 0, 0, 9, 4, 1,
                3, 0, 0, 9, 0, 0, 0, 8, 0,
                6, 5, 0, 0, 1, 0, 4, 2, 0,
                4, 0, 0, 0, 5, 0, 0, 0, 8,
                0, 1, 3, 0, 8, 0, 0, 9, 5,
                0, 6, 0, 0, 0, 3, 0, 0, 2,
                2, 8, 4, 0, 0, 0, 5, 0, 0,
                0, 0, 0, 0, 0, 0, 0, 0, 0};

    }

    public void initMaps() {
        initMap(hmRow);
        initMap(hmColumn);
        initMap(hmArea);
    }

    public void initMap(List<HashMap<Integer, Boolean>> list) {

        for (int i = 0; i < 9; i++) {
            list.add(new HashMap<Integer, Boolean>());
        }
    }

    public void initGrid() {
        for (int i = 0; i < 81; i++) {

            int gridRow = rowStart(i);
            int gridCol = colStart(i);
            Grid gridArea = findAreaStart(i);

            int val = sud[i];

            if (val > 0) {
                hmRow.get(gridRow).put(val, true);
                hmColumn.get(gridCol).put(val, true);
                hmArea.get(gridArea.position3).put(val, true);
            }
            Cell cell = new Cell(val);
            cells.add(cell);
            cell.setMapIndexes(gridRow,gridCol,gridArea.position3);


        }

    }

    public void recurse(int i) {


        if (i < 81) {

                int localIndex = i;
                localIndex++;

                Cell cell = cells.get(i);
                if (cell.getValue() > 0) {
                    recurse(localIndex);
                    return;
                }

                int candidate;

                for(int it = 1;it<10;it++){

                    candidate = it;

                    if (cell.getValue() == 0) {
                        if (!(hmRow.get(cell.getiRow()).containsKey(candidate))) {
                            if (!(hmColumn.get(cell.getiColumn()).containsKey(candidate))) {
                                if (!(hmArea.get(cell.getiArea()).containsKey(candidate))) {
                                    hmRow.get(cell.getiRow()).putIfAbsent(candidate, true);
                                    hmColumn.get(cell.getiColumn()).putIfAbsent(candidate, true);
                                    hmArea.get(cell.getiArea()).putIfAbsent(candidate, true);

                                    cell.setValue(candidate);

                                    recurse(localIndex);

                                    hmRow.get(cell.getiRow()).remove(candidate, true);
                                    hmColumn.get(cell.getiColumn()).remove(candidate, true);
                                    hmArea.get(cell.getiArea()).remove(candidate, true);
                                    cell.setValue(0);
                                }
                            }
                        }
                    }
                }

        }if (i == 81) printGrid(cells);

    }

    public int rowStart(int num) {
        return num / 9;
    }

    public int colStart(int num) {
        return num % 9;
    }

    public int findRowStart(int num) {
        int row = rowStart(num);
        row = row / 3;
        return row;
    }

    public int findColumnStart(int num) {
        int col = colStart(num);
        col = col / 3;
        return col;
    }

    public Grid findAreaStart(int num) {

        int row = findRowStart(num);

        int col = findColumnStart(num);

        return Grid.getArea(col, row);
    }

    public void vistRowCol(Grid grid, Boolean value, BiConsumer<Integer, Boolean> con) {
        int start = grid.position;
        int inc = grid.type.equals(GridType.ROW) ? 1 : 9;
        for (int j = 0; j < 9; j++) {
            con.accept(start, value);
            start += inc;
        }
    }


    public boolean visit9x9(int start, int value, BiPredicate<Integer, Integer> predicate) {

        int beg = start;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (predicate.test(beg++, value)) {
                    return true;
                }
            }
            beg += 6;
        }

        return false;
    }

    public void printGrid(List<Cell> cells) {

        int horizontalDashCount = 0;
        int verticalDashCount = 0;
        int current = 0;
        System.out.println("Printing grid");
        System.out.println("-------------------------");
        for (int i = 0; i < 9; i++) {
            System.out.print("| ");
            for (int j = 0; j < 9; j++) {
                if (++verticalDashCount > 2) {
                    System.out.print(cells.get(current++).getValue() + " ");
                    System.out.print("| ");
                    verticalDashCount = 0;
                } else {
                    System.out.print(cells.get(current++).getValue() + " ");
                }
            }
            if (++horizontalDashCount > 2) {
                System.out.println();
                System.out.println("-------------------------");
                horizontalDashCount = 0;
            } else {
                System.out.println();
            }
        }
    }

    public void printCells() {
        for (Cell cell : cells) {
            System.out.println(cell.getValue() + " ");
        }
    }

    public void printRow(int num) {
        for (int i = 0; i < 9; i++) {
            System.out.print(cells.get(num++).getValue() + " ");
        }
        System.out.println();
    }



}
