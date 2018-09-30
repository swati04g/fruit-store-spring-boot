package com.cybercom.fruitstore.web.controller;

import java.util.List;
import java.util.Optional;

import com.cybercom.fruitstore.dao.CategoryRepository;
import com.cybercom.fruitstore.dao.ItemRepository;
import com.cybercom.fruitstore.data.persistent.Category;
import com.cybercom.fruitstore.data.persistent.Item;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
public class ItemController {


    private Logger logger = LoggerFactory.getLogger(ItemController.class);

    @Autowired
    protected CategoryRepository categoryRepository;

    @Autowired
    protected ItemRepository itemRepository;

    @RequestMapping(value = "/item/{itemId}", method = RequestMethod.GET)
    public String showItem(@PathVariable long itemId, ModelMap modelMap) {
        Optional<Item> item = itemRepository.findById(itemId);
        List<Category> categoryList = categoryRepository.findAll();
        modelMap.put("item", item.get());
        modelMap.put("CategoriesList", categoryList);
        return "item";
    }




    @RequestMapping("/")
    public String start(ModelMap modelMap) {
        List<Category> categoryList = categoryRepository.findAll();
        modelMap.put("CategoriesList",categoryList);
        List<Item> items = itemRepository.findAll();
        modelMap.put("ItemList", items);
        return "index.html";
    }




}
