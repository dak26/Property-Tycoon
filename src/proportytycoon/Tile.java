package proportytycoon;

public class Tile {
    
    String name;
    Boolean buyable;
    
    /**
     * Instantiates a Tile object.
     * @param name The name of this tile.
     * @param buyable Whether this tile is purchasable.
     */
    public Tile(String name, String buyable){
        this.name = name;
        this.buyable = Boolean.parseBoolean(buyable);
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
    
}
