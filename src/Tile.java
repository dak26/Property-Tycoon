package tile;

import javafx.geometry.Point2D;

public abstract class Tile {
    
    String name;
    Boolean buyable;
    Point2D[] coordinates;

    /**
     * Instantiates a Tile object.
     * @param data Data associated with this Tile
     */
    public Tile(String[] data){
        this.name = data[1];
        this.coordinates = new Point2D[6];
        this.buyable = Boolean.parseBoolean(data[2]);
        int n = 0;
        for (int i = 11; i < 22; i+=2) {
            coordinates[n] = new Point2D(Double.valueOf(data[i]),Double.valueOf(data[i+1]));
            n++;
        }
        System.out.println("Tile: " + getName() + " created. Buyable: " + String.valueOf(getBuyable()));
    }
    
    /**
     * Getter method for name.
     * @return The name of this tile.
     */
    public String getName(){
        return this.name;
    }
    
    /**
     * Getter method for buyable.
     * @return Whether the tile is purchasable.
     */
    public Boolean getBuyable(){
        return this.buyable;
    }
    
    /**
     * Getter method for coordinates.
     * @return The possible six coordinates for tokens on this tile.
     */
    
    public Point2D[] getCoordinates() {
        return coordinates;
    }
    
    
}
