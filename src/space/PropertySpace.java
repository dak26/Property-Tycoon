/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package space;


/**
 *
 * @author Francois
 */
import main.Player;

public class PropertySpace extends PurchasableSpace {
    
    private int houses;
    
    public PropertySpace(int cost) {
        super(cost);
        houses = 0;
    }
    
    public void changeHouseCount(int n) {
        houses += n;
    }
    
    public int getHouseCount() {
        return houses;
    }
    
    
}
