package com.cybercom.fruitstore.web.controller;

import java.util.List;
import java.util.Optional;

import com.cybercom.fruitstore.dao.ItemRepository;
import com.cybercom.fruitstore.data.persistent.Item;
import com.cybercom.fruitstore.web.dto.Cart;
import com.cybercom.fruitstore.web.dto.CartItem;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@RequestMapping("/cart")
@SessionAttributes(value = { "cart" })
public class CartController {

    private Logger logger = LoggerFactory.getLogger(CartController.class);

    @Autowired
    protected ItemRepository itemRepository;

    @ModelAttribute("cart")
    public Cart createCart() {
        logger.debug("#### create cart object...");
        return new Cart();
    }

    @RequestMapping(value = "/checkout", method = RequestMethod.POST)
    public String checkout(Cart cart, @RequestParam("amountArray") Integer[] amountArray) {
        logger.info("##### checkout method going...");
        List<CartItem> itemList = cart.getReadOnlyItemList();
        // amount which user input on form
        for (int i = 0; i < amountArray.length; i++) {
            CartItem cartItem = itemList.get(i);
            cart.setItem(cartItem.getItem(), amountArray[i]);
        }
        return "redirect:/checkout/shipping";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String add(Cart cart, @RequestParam("itemId") String itemId,
            @RequestParam("amount") int amount) {

        Optional<Item> item = itemRepository.findById(Long.parseLong(itemId));
        cart.setItem(item.get(), amount);
        logger.debug("### add to cart: itemId=" + itemId + " amount=" + amount);
        return "redirect:/cart/view";
    }

    @RequestMapping(value = "/view", method = RequestMethod.GET)
    public String view(Model model, Cart cart) {
        model.addAttribute("cart", cart);
        return "cart";
    }

}
