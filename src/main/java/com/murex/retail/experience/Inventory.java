package com.murex.retail.experience;

import java.util.List;

public class Inventory {

    private final List<ComputerComponent> parsedInventory;

    public Inventory(List<ComputerComponent> parsedInventory){
        this.parsedInventory = parsedInventory;
    }
    public List<ComputerComponent> getParsedInventory() {
        return parsedInventory;
    }
}
