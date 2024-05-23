package com.example.lazada.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lazada.R;
import com.example.lazada.adapter.ProductAdapter;
import com.example.lazada.data.PostAsyncResponse;
import com.example.lazada.data.Repository;
import com.example.lazada.model.Product;

import java.util.ArrayList;

public class HomeFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.home_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        new Repository().getProducts(new PostAsyncResponse() {
            @Override
            public void processoTerminato(ArrayList<Product> products) {

                RecyclerView list = view.findViewById(R.id.main_list);
                ProductAdapter productAdapter = new ProductAdapter(products);
                list.setAdapter(productAdapter);

                productAdapter.setOnItemClickListener((view1, position) -> {
                    Intent intent = new Intent(view1.getContext(), Detail.class);
                    intent.putExtra("product", products.get(position));
                    startActivity(intent);
                });
            }
            @Override
            public void processoFallito(Exception e) {
                Log.d("Error", e.getMessage());
            }
        });
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
