package com.example.specification_based.src.main.java;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.Test;

public class ShoppingCartTest {
    private final ShoppingCart cart = new ShoppingCart();

    @Test
    public void noItems() {
        assertThat(cart.totalPrice()).isEqualTo(0);
    }

    @Test
    public void itemsInTheCart() {
        //1
        cart.add(new CartItem("TV", 1, 120));
        assertThat(cart.totalPrice()).isEqualTo(120);

        //2
        cart.add(new CartItem("Chocolate", 2, 2.5));
        assertThat(cart.totalPrice()).isEqualTo(120 + 2.5*2);
    }

}