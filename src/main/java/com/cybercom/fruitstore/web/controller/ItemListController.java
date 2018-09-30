package com.cybercom.fruitstore.web.controller;

import java.util.List;

import com.cybercom.fruitstore.dao.CategoryRepository;
import com.cybercom.fruitstore.dao.ItemRepository;
import com.cybercom.fruitstore.data.persistent.Category;
import com.cybercom.fruitstore.data.persistent.Item;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ItemListController {

    @SuppressWarnings("unused")
    private Logger logger = LoggerFactory.getLogger(ItemListController.class);

    @Autowired
    protected CategoryRepository  categoryRepository;

    @Autowired
    protected ItemRepository itemRepository;

    @RequestMapping(value = "/itemList/{categoryId}", method = RequestMethod.GET)
    public String showItem(Model model, @PathVariable long categoryId) {

        List<Category> categoryList = categoryRepository.findAll();
        model.addAttribute("CategoriesList", categoryList);

        List<Item> itemList = categoryRepository.findById(categoryId).get().getItems();
        model.addAttribute("ItemList", itemList);

        return "itemList";
    }

}
