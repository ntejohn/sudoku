package com.ntejohn;

public class Main {


    public static void main(String[] args) {

        System.out.println(" args.length: " + args.length);
        int[] nums = new int[args.length];
       for(int i =0;i<args.length;i++){
           System.out.println(args[i]);
           nums[i] = Integer.parseInt(args[i]);
       }
       Sudoku sudoku = new Sudoku(nums);
       //sudoku.initArray();
       sudoku.initMaps();
       sudoku.initGrid();

        System.out.println("Initial clue grid...");
        sudoku.printGrid(sudoku.cells);
      // sudoku.printGrid();
        System.out.println("Solution grids...");
        sudoku.recurse(0);


    }

}
