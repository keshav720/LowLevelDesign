package model;

public class Inventory {
    ItemShelf[] inventory;

    public Inventory(int size) {
        inventory = new ItemShelf[size];
        initialEmptyInventory();
    }

    public ItemShelf[] getInventory() {
        return inventory;
    }

    public void setInventory(ItemShelf[] inventory) {
        this.inventory = inventory;
    }

    public void initialEmptyInventory() {
        int startCode = 101;

        for (int i = 0; i < inventory.length; i++) {
            ItemShelf space = new ItemShelf();
            space.setCode(startCode + i);
            space.setSoldOut(true);
            inventory[i] = space;
        }

    }

    public void addItem(Item item, int codeNumber) throws Exception {
        for(ItemShelf itemShelf : inventory){
            if(itemShelf.getCode() == codeNumber){
                if(itemShelf.isSoldOut()){
                    itemShelf.setSoldOut(false);
                    itemShelf.setItem(item);
                }
                else{
                    throw new Exception("Already item is present here.");
                }
            }
        }
    }

    public Item getItem(int codeNumber) throws Exception {
        for(ItemShelf itemShelf : inventory){
            if(itemShelf.getCode() == codeNumber){
                if(itemShelf.isSoldOut()){
                    throw new Exception("Already item is sold out.");
                }
                else{
                    return itemShelf.getItem();
                }
            }
        }
        throw new Exception("Invalid item code.");
    }

    public void updateSoldOutItem(int codeNumber) throws Exception {
        for(ItemShelf itemShelf : inventory){
            if(itemShelf.getCode() == codeNumber){
                itemShelf.setSoldOut(true);
            }
        }
    }

}
