import javax.swing.*;
import javax.imageio.*;

import java.awt.*;
import java.awt.image.*;
import java.awt.event.*;

import java.io.*;
import java.util.*;

public class Grid
{
    Cell[][] grid;
    
    public Grid(){
        grid = new Cell[150][300];
        for(int y = 0; y<grid.length; y++){
            for(int x = 0; x<grid[y].length; x++){
                grid[y][x] = new Cell(this, x, y, null);
            }
        }
        grid[ 40][ 75].add(new Person(grid[ 40][ 75])); //on test map: Chicago
        grid[ 32][158].add(new Person(grid[ 32][158])); //on test map: Germany
        grid[ 76][180].add(new Person(grid[ 76][180])); //on test map: Kilimandscharo
        grid[100][271].add(new Person(grid[100][271])); //on test map: The mountains in Australia
    }
    
    public void tick(){
        //easy way
        int sumOfInhabitants = 0;
        for(int y = 0; y<grid.length; y++){
            for(int x = 0; x<grid[y].length; x++){
                grid[y][x].tick();
                sumOfInhabitants += grid[y][x].getSumInhabs();
            }
        }
    }
    
}







