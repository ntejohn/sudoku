
import com.ntejohn.Grid;
import com.ntejohn.Sudoku;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class SudokuTest {

    Sudoku sudoku = new Sudoku();

    @BeforeEach
    public void init(){
       sudoku.initArray();
    }

    @Test
    public void testFindRowStart(){
        int row = sudoku.findRowStart(5);
        assertEquals(0,row);
        row = sudoku.findRowStart(14);
        assertEquals(0,row);
        row = sudoku.findRowStart(23);
        assertEquals(0,row);
        row = sudoku.findRowStart(58);
        assertEquals(2,row);
    }

    @Test
    public void testFindColumnStart(){
        int col = sudoku.findColumnStart(4);
        assertEquals(1,col);
        col = sudoku.findColumnStart(9);
        assertEquals(0,col);
        col = sudoku.findColumnStart(8);
        assertEquals(2,col);
        col = sudoku.findColumnStart(5);
        assertEquals(1,col);
    }
   @Test
    public void testAreaMap0(){

        Grid grid = sudoku.findAreaStart(0);
        assertEquals(0,grid.position3);
        grid = sudoku.findAreaStart(1);
        assertEquals(0,grid.position3);
        grid = sudoku.findAreaStart(2);
        assertEquals(0,grid.position3);

    }

    @Test
    public void testRowStart(){
        assertEquals(0,sudoku.rowStart(5));
        assertEquals(1,sudoku.rowStart(14));
        assertEquals(2,sudoku.rowStart(23));
    }

    @Test
    public void testColumnStart(){
        assertEquals(5,sudoku.colStart(5));
        assertEquals(5,sudoku.colStart(14));
        assertEquals(5,sudoku.colStart(23));
    }
}
