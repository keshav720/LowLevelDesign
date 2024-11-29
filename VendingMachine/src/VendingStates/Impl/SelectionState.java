package VendingStates.Impl;

import VendingStates.State;
import model.Coin;
import model.Item;
import model.VendingMachine;

import java.util.List;

public class SelectionState implements State {

    public SelectionState() {
        System.out.println("SelectionState");
    }

    @Override
    public void clickOnInsertCoinButton(VendingMachine machine) throws Exception {
        throw new Exception("you can't click insert coin button in a selection state");
    }

    @Override
    public void clickOnStartProductSelectionButton(VendingMachine machine) throws Exception {
        return;
    }

    @Override
    public void insertCoin(VendingMachine machine, Coin coin) throws Exception {
        throw new Exception("you can't insert coin into a selection state");
    }

    @Override
    public void chooseProduct(VendingMachine machine, int codeNumber) throws Exception {
        Item item = machine.getInventory().getItem(codeNumber);
        int paidByUser = 0;
        for(Coin coin : machine.getCoinsList()){
            paidByUser = paidByUser + coin.getValue();
        }
        if(paidByUser < item.getPrice())
        {
            System.out.println("You don't have enough money, Item price: " + item.getPrice());
            refundFullMoney(machine);
            throw new Exception("You don't have enough money, Item price: " + item.getPrice());
        }
        else
        {
            if(paidByUser > item.getPrice())
            {
                getChange(paidByUser - item.getPrice());
            }
            machine.setVendingMachineState(new DispenseState(machine, codeNumber));
        }
    }

    @Override
    public int getChange(int returnChangeMoney) throws Exception {
        return 0;
    }

    @Override
    public Item dispenseItem(VendingMachine machine, int codeNumber) throws Exception {
        return null;
    }

    @Override
    public List<Coin> refundFullMoney(VendingMachine machine) throws Exception {
        return List.of();
    }

    @Override
    public void updateInventory(VendingMachine machine, Item item, int codeNumber) throws Exception {

    }
}
