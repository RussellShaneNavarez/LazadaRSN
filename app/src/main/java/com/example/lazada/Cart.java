package com.example.lazada;

import static com.example.lazada.BR.cartPrice;
import static com.example.lazada.BR.productsCart;

import android.util.Log;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

import com.example.lazada.model.Product;

import java.util.ArrayList;

public class Cart extends BaseObservable {
    private static Cart INSTANCE;
    public int cartPrice = 0;
    public ArrayList<Product> productsCart = new ArrayList<Product>();

    private Cart() {
    }

    public static Cart getInstance() {
        if(INSTANCE == null) {
            INSTANCE = new Cart();
        }

        return INSTANCE;
    }

    @Bindable
    public double getCartPrice() {
        return cartPrice;
    }

    public void setCartPrice(int cartPrice) {
        this.cartPrice = cartPrice;
    }

    public void updateCartPrice(){
        this.cartPrice = 0;
        for (Product p: productsCart ) {
            cartPrice += p.getPrice();
        }
    }

    @Bindable
    public ArrayList<Product> getProductsCart() {
        return productsCart;
    }

    public void addCart(Product product){
        this.productsCart.add(product);
        Log.d("Cart", toString());
        updateCartPrice();

    }

    public void removeCart(int productID) {
        for (Product product : productsCart) {
            if (product.getId() == productID) {
                productsCart.remove(product);
                updateCartPrice();
                break; // Stop after removing the first occurrence
            }
        }
    }

    public void setProductsCart(ArrayList<Product> productsCart) {
        this.productsCart = productsCart;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "CartPrice=" + cartPrice +
                ", productsCart=" + productsCart +
                '}';
    }
}
