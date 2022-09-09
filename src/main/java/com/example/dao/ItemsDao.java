package com.example.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Component;

import com.example.model.Item;

@Component
public class ItemsDao {

    private static int i=0;
    private static List<Item> items = new ArrayList<>();

    //Creates the item and adds it to List
    public Item createItem(Item item) {
        if(item.getId() == 0) {
            item.setId(++i);
        }

        items.add(item);
        return item;
    }

    //Returns an ID for the item
    public Item getItem(int id) {
        Predicate<? super Item> predicate = item -> item.getId()==id;
        return items.stream().filter(predicate).findFirst().orElse(null);
    }


    public List<Item> getAllItems() {
        return items;
    }

    //update
    public String updateItem(Item item) {
        boolean itemFound = false;
        for(Item currentItems : items) {
            if(currentItems.getName().equals(item.getName())) {
                itemFound = true;
                currentItems.setDesc(item.getDesc());
                currentItems.setPrice(item.getPrice());
            }
        }
        if(itemFound == false) {
            item.setId(++i);
            items.add(item);
        }
        return "Item Updated";
    }


    //Deletes Item
    public void deleteItem(String name) {
        Predicate<? super Item> predicate = item -> item.getName().equals(name);
        items.removeIf(predicate);
    }

}
