package com.example.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.dao.ItemsDao;
import com.example.model.Item;

@RestController
public class ItemController {

    private ItemsDao itemsDao;

    ItemController(ItemsDao itemsDao){
        this.itemsDao = itemsDao;
    }

    @PostMapping("/item")
    public void createItem(@RequestBody Item item) {
        itemsDao.createItem(item);
    }

    @GetMapping("/item/{id}")
    public Item getItem(@PathVariable int id) {
        return itemsDao.getItem(id);
    }

    @GetMapping("/item/item")
    public List<Item> getAll(){
        return itemsDao.getAllItems();
    }

    @PutMapping("/item/{name}")
    public void updateItem(@PathVariable String name, @RequestBody Item item) {
        itemsDao.updateItem(item);
    }

    @DeleteMapping("/item/{name}")
    public void DeleteItem(@PathVariable String  name) {
        itemsDao.deleteItem(name);
    }
}
