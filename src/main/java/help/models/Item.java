package help.models;

import help.repositories.ItemRepository;

public class Item {

    private final ItemRepository itemDao;

    public Item(ItemRepository itemDao) {
        this.itemDao = itemDao;
    }
}
