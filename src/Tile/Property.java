package Tile;

import Tile.Colour;
import main.Player;

public class Property extends Tile {
    
    Colour colour;
    int cost;
    int rent;
    int[] rentprices;
    int houses;
    
    /**
     * Instantiates a 'Property' tile for Utility properties.
     * @param data Data associated with this Tile.
     */
    public Property(String[] data) {
        super(data);
        this.colour = Colour.valueOf(data[3]);
        this.cost = Integer.parseInt(data[4]);
        try {
            this.rentprices = getRentPrices(data);
            this.rent = rentprices[0];
        }
        catch (Exception e){
            
        }
    }
    
     /**
     * Retrieves the rent prices from a row of data
     * @param row Row of data associated with this input
     * @return An array of rent prices, e.g. [2, 10, 30, 90, 160, 250] for Property 'X'
     */
    public int[] getRentPrices(String[] row){
        int[] rentprices = new int[row.length-5];
        for (int i = 0; i < row.length - 1; i++){
            rentprices[i] = Integer.parseInt(row[i+6]);
        }
        return rentprices;
    }
    
    public void changeHouseCount(int n) {
        houses += n;
    }
    
    public int getHouseCount() {
        return houses;
    }
    
}
