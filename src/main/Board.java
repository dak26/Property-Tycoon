package main;

import Tile.Tile;
import Tile.Tile;
import Tile.TileFactory;
import Tile.TileFactory;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class Board {
    
    Tile[] tile;
    
    /**
     * Initialises an instance of a Board object and populates an array of tiles with their relevant information.
     * A tile instance contains the following for ALL instances: name, buyable.
     * A property instance (extends tile) contains the following: name, buyable, colour, cost, array of rent prices.
     * @throws FileNotFoundException 
     */
    public Board() throws FileNotFoundException {
        
        String[][] data = this.loadData();
        tile = new Tile[data.length];
        TileFactory tf = new TileFactory();
        for (int row = 0; row < data.length; row++){
            tile[row] = tf.createTile(data[row]);
        }
    }   
    
    /**
     * Reads in data from a CSV file and formats it as a Jagged Array.
     * @return A Jagged Array containing all the properties of every square in the CSV file.
     * @throws FileNotFoundException 
     */
    public String[][] loadData() throws FileNotFoundException {
        
        String[][] data = new String[40][];
        String path = "propertytycoondata.csv";
        File file = new File(path);
        Scanner scan = new Scanner(file);
        
        int row = 0;
        while (scan.hasNext()){
            String rowData = scan.nextLine();
            data[row] = rowData.split(",");
            row++;
        }
        return data;
    }
    
    public static void main(String[] args) throws FileNotFoundException{
        Board board = new Board();
    }
}
