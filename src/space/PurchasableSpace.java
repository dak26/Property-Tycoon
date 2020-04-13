/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package space;

import main.Player;

/**
 *
 * @author Francois
 */
public abstract class PurchasableSpace extends Space {
    
    private int cost;
    private Player propertyOwner;
    
    public PurchasableSpace(int cost) {
        this.cost = cost;
    }

    public void setNewOwner(Player newOwner) {
        propertyOwner = newOwner;
    }
    
    public Player getOwner() {
        return propertyOwner;
    }
    
    public int getCost() {
        return cost;
    }    
}
