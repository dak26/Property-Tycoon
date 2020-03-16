package proportytycoon;

public class Property extends Tile{
    
    Colour colour;
    int cost;
    int rent;
    int[] rentprices;
    
    /**
     * Instantiates a 'Property' tile for Utility properties.
     * @param name The name of this Tile.
     * @param buyable Is this tile purchasable.
     * @param colour The colour-group of this tile.
     */
    public Property(String name, String buyable, String colour) {
        super(name, buyable);
        this.colour = Colour.valueOf(colour);
    }
    
    /**
     * Instantiates a 'Property tile for all NON-Utility properties.
     * @param name The name of this tile.
     * @param buyable Is this tile purchasable.
     * @param colour The colour-group of this tile.
     * @param cost The cost to buy this tile.
     * @param rentprices The list of rent prices for this tile.
     */
    public Property(String name, String buyable, String colour, int cost, int[] rentprices){
        super(name, buyable);
        this.colour = Colour.valueOf(colour);
        this.cost = cost;
        this.rent = rentprices[0];
        this.rentprices = rentprices;
    }
}
