package help.controllers;

import help.repositories.ItemRepository;

public class ItemController {
    private final ItemRepository itemDao;

    public ItemController(ItemRepository itemDao) {
        this.itemDao = itemDao;
    }
}
