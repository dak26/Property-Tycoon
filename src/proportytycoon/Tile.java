package proportytycoon;

public abstract class Tile {
    
    String name;
    Boolean buyable;
    
    /**
     * Instantiates a Tile object.
     * @param data Data associated with this Tile
     */
    public Tile(String[] data){
        this.name = data[1];
        this.buyable = Boolean.parseBoolean(data[2]);
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
    
}
