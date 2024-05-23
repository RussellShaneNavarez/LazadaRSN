package com.example.lazada.data;

import com.android.volley.Request;
import com.android.volley.toolbox.JsonObjectRequest;
import com.example.lazada.controller.LazadaController;
import com.example.lazada.model.Product;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Repository {
    String url = "https://dummyjson.com/products";

    public void getProducts(final PostAsyncResponse callback) {
        ArrayList<Product> products = new ArrayList<>();

        JsonObjectRequest requestObj = new JsonObjectRequest(Request.Method.GET, url, null, response -> {
            try {
                for (int i = 0; i < response.getJSONArray("products").length(); i++) {
                    JSONObject currentProduct = (JSONObject) response.getJSONArray("products").get(i);
                    int id = currentProduct.getInt("id");
                    String title = currentProduct.getString("title");
                    String description = currentProduct.getString("description");
                    int price = currentProduct.getInt("price");
                    String thumbnail = currentProduct.getString("thumbnail");
                    ArrayList<String> images = new ArrayList<>();
                    for (int j = 0 ; j < currentProduct.getJSONArray("images").length() ; j++) {
                        images.add(String.valueOf(currentProduct.getJSONArray("images").get(j)));
                    }
                    Product product = new Product(id, title, description, price, thumbnail, images);
                    products.add(product);
                }

                callback.processoTerminato(products);

            } catch (JSONException e) {
                throw new RuntimeException(e);
            }
        }, error -> {
        });

        LazadaController.getInstance().addToRequestQueue(requestObj);
    }
}
