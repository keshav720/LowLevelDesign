package model;

import VendingStates.Impl.IdleState;
import VendingStates.State;

import java.util.ArrayList;
import java.util.List;

public class VendingMachine {
    private State vendingMachineState;
    private Inventory inventory;
    private List<Coin> coins;

    public VendingMachine() {
        vendingMachineState = new IdleState();
        coins = new ArrayList<>();
        inventory = new Inventory(10);
    }

    public State getVendingMachineState() {
        return vendingMachineState;
    }

    public void setVendingMachineState(State VendingMachineState) {
        this.vendingMachineState = VendingMachineState;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory Inventory) {
        this.inventory = Inventory;
    }

    public List<Coin> getCoinsList() {
        return coins;
    }

    public void setCoinsList(List<Coin> Coins) {
        this.coins = Coins;
    }


}
