/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.spbstu.telematics.expert.lab1;

/**
 *
 * @author alexandr
 */
public class Station {
    
    
    public int missionaries = 0;
    public int cannibals = 0;
    public int bank = 0; // 0 - left, 1 - right

    public Station(int Missionaries, int Cannibals, int bank) {
        this.missionaries = Missionaries;
        this.cannibals = Cannibals;
        this.bank = bank;
    }
    public Station(){}
    public Station(Station station){
        this.missionaries = station.missionaries;
        this.cannibals = station.cannibals;
        this.bank = station.bank;
    }

    @Override
    public String toString() {
        return "(" + missionaries + "," + cannibals
                + "," + bank + ")";
    }
    
    public Boolean compare (Station station){
        if (this.missionaries == station.missionaries && this.bank == station.bank 
                && this.cannibals == station.cannibals) return true;
        return false;
    }
    
    
    
}
