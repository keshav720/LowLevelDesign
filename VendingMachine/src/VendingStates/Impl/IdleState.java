package VendingStates.Impl;

import VendingStates.State;
import model.Coin;
import model.Item;
import model.VendingMachine;

import java.util.ArrayList;
import java.util.List;

public class IdleState implements State {

    public IdleState(){
        System.out.println("Machine in IdleState");
    }

    public IdleState(VendingMachine machine){
        System.out.println("Machine in IdleState");
        machine.setCoinsList(new ArrayList<Coin>());
    }
    @Override
    public void clickOnInsertCoinButton(VendingMachine machine) throws Exception {
        machine.setVendingMachineState(new HasMoneyState());
    }

    @Override
    public void clickOnStartProductSelectionButton(VendingMachine machine) throws Exception {
        throw new Exception("first you need to click insert coin button.");
    }

    @Override
    public void insertCoin(VendingMachine machine, Coin coin) throws Exception {
        throw new Exception("Can't insert coin button in Idle State.");
    }

    @Override
    public void chooseProduct(VendingMachine machine, int codeNumber) throws Exception {
        throw new Exception("can't choose a product from the machine in IdleState.");
    }

    @Override
    public int getChange(int returnChangeMoney) throws Exception {
        throw new Exception("can't get change in idle state.");
    }

    @Override
    public Item dispenseItem(VendingMachine machine, int codeNumber) throws Exception {
        throw new Exception("product can not dispense in Idle state.");
    }

    @Override
    public List<Coin> refundFullMoney(VendingMachine machine) throws Exception {
        throw new Exception("can't refund full money in Idle state.");
    }

    @Override
    public void updateInventory(VendingMachine machine, Item item, int codeNumber) throws Exception {
        machine.getInventory().addItem(item, codeNumber);
    }
}
