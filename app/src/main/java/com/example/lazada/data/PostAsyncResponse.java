package com.example.lazada.data;

import com.example.lazada.model.Product;

import java.util.ArrayList;

public interface PostAsyncResponse {
    void processoTerminato(ArrayList<Product> products);
    void processoFallito(Exception e);
}
