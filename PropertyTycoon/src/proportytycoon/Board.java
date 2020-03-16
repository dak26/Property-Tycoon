package proportytycoon;

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
    public Board() throws FileNotFoundException{
        
        String[][] data = this.loadData();
        tile = new Tile[40];
        for (int row = 0; row < data.length; row++){
            switch(data[row][0]){
                case "Go":
                    tile[row] = new Go(data[row][1], data[row][2]);
                    break;
                case "Property":
                    if (!(data[row][3].contains("UTILITY"))){
                        int[] rent = this.getRentPrices(data[row]);
                        tile[row] = new Property(data[row][1], data[row][2], 
                                    data[row][3], Integer.parseInt(data[row][4]), rent);
                    }
                    else {
                        tile[row] = new Property(data[row][1], data[row][2], data[row][3]);
                    }
                    break;
                case "PotLuck":
                    tile[row] = new PotLuck(data[row][1], data[row][2]);
                case "Tax":
                    tile[row] = new Tax(data[row][1], data[row][2]);
                    break;
                case "OppKnocks":
                    tile[row] = new OppKnocks(data[row][1], data[row][2]);
                    break;
                case "Jail":
                    tile[row] = new Jail(data[row][1], data[row][2]);
                    break;
                case "FreeParking":
                    tile[row] = new FreeParking(data[row][1], data[row][2]);
                    break;
            }
            // A way of visualising information of the tile variable. CAN DELETE
            System.out.println(tile[row].getName() +" "+ tile[row].getBuyable().toString());
        }     
    }
    
    /**
     * Reads in data from a CSV file and formats it as a Jagged Array.
     * @return A Jagged Array containing all the properties of every square in the CSV file.
     * @throws FileNotFoundException 
     */
    public String[][] loadData() throws FileNotFoundException{
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
    
    /**
     * Takes a whole row of data from a Jagged Array and stores the only relevant values into an array.
     * @param rowData A row of data from a Jagged Array
     * @return An array of rent prices, e.g. [2, 10, 30, 90, 160, 250] for Crapper Street
     */
    public int[] getRentPrices(String[] rowData){
        int[] rentprices = new int[rowData.length-5];
        for (int i = 0; i > rowData.length - 1; i++){
            rentprices[i] = Integer.parseInt(rowData[i+6]);
        }
        return rentprices;
    }
    
}
