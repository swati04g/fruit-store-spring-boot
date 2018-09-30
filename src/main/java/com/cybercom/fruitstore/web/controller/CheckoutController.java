package com.cybercom.fruitstore.web.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import com.cybercom.fruitstore.web.dto.Cart;
import com.cybercom.fruitstore.web.dto.Shipping;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@RequestMapping("/checkout")
@SessionAttributes(value = { "shipping", "cart" })
public class CheckoutController {

    private Logger logger = LoggerFactory.getLogger(CheckoutController.class);

/*
    @Autowired
    protected PurchaseDao purchaseDao;
*/

    @ModelAttribute("shipping")
    public Shipping createShipping() {
        logger.debug("#### create shipping object...");
        return new Shipping();
    }

    @ModelAttribute("cart")
    public Cart createCart() {
        logger.debug("#### create cart object...");
        return new Cart();
    }

    @RequestMapping(value = "/shipping")
    public String shipping(
            Model model,
            @RequestParam(value = "redirected", required = false) boolean redirected,
            @Valid Shipping shipping, Errors errors) {

        model.addAttribute("shipping", shipping);
        model.addAttribute("redirected", redirected);
        model.addAttribute("errors", errors);
        return "checkout/shipping";
    }

    @RequestMapping(value = "confirm")
    public String confirm(Model model, Cart cart, @Valid Shipping shipping,
            Errors errors) {

        // if cart is empty, redirect to cart view page.
        if (cart.getReadOnlyItemList().size() < 1) {
            return "redirect:/cart/view";
        }

        // validation
        if (errors.hasErrors()) {
            logger.debug(String.valueOf(errors));
            return "redirect:shipping?redirected=true";
        }

        model.addAttribute("cart", cart);
        model.addAttribute("shipping", shipping);
        return "checkout/confirm";
    }

    @RequestMapping(value = "complete")
    public String complete(Shipping shipping, Cart cart, HttpSession httpSession)
            throws Exception {

        // check transaction token
       /* boolean checkResult = TransactionTokenHelper.checkToken(httpSession,
                shipping.getTransactionToken());
        if (!checkResult) {
            throw new Exception("Transaction Token Unmatch !");
        }

        boolean result = purchaseHandler.execPurchase(cart, shipping);
        if (result) {
            TransactionTokenHelper.removeToken(httpSession);
            cart.removeAll();
            logger.debug("### purchase succeed!!");
        }*/

        return "redirect:thankyou";
    }

    @RequestMapping(value = "thankyou")
    public String thankyou() {
        return "checkout/thankyou";
    }

}
