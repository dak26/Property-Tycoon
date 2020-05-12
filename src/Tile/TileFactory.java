/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tile;

import Tile.Tile;
import Tile.Tax;
import Tile.Property;
import Tile.PotLuck;
import Tile.OppKnocks;
import Tile.Jail;
import Tile.Go;
import Tile.FreeParking;

/**
 *
 * @author Dan
 */
public class TileFactory {
    
    public TileFactory(){
    
    }
    
    public Tile createTile(String[] data){
        
        switch(data[0]){
            case "Go":
                return new Go(data);
            case "Property":
                return new Property(data);
            case "PotLuck":
                return new PotLuck(data);
            case "Tax":
                return new Tax(data);
            case "OppKnocks":
                return new OppKnocks(data);
            case "Jail":
                return new Jail(data);
            case "FreeParking":
                return new FreeParking(data);
            default:
                return null;
        }
    }
        

    

    
}
