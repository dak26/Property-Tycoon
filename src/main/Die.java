/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.util.Random;

/**
 * This is the Die class; two instances will be created to represent the
 * dice.
 * 
 * @author Francois
 */
public class Die {
    
    private final int[] values;
    private final int sides;
    
    public Die(int sides) {
        this.sides = sides;
        values = new int[sides];
        for (int i = 0; i < sides; i++) {
            values[i] = i+1;
        }
    }
    
    public int roll() {
        Random r = new Random();
        int val = values[r.nextInt(sides)];
        return val;
    }
    
}
