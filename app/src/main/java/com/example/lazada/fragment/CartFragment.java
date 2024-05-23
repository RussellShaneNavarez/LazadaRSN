package com.example.lazada.fragment;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.lazada.Cart;
import com.example.lazada.R;
import com.example.lazada.adapter.ProductAdapter;
import com.example.lazada.databinding.ActivityCartViewBinding;

import java.util.ArrayList;

public class CartFragment extends Fragment {
    protected ActivityCartViewBinding binding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.activity_cart_view, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ProductAdapter productAdapter = new ProductAdapter(Cart.getInstance().getProductsCart());
        binding.mainList.setAdapter(productAdapter);

        productAdapter.setOnItemClickListener((view1, position) -> {
            new AlertDialog.Builder(requireContext())
                    .setTitle("Continue?")
                    .setMessage("You will remove the product from the cart")
                    .setPositiveButton("Confirm", (dialog, which) -> {
                        Cart.getInstance().removeCart(Cart.getInstance().getProductsCart().get(position).getId());
                        navigateToCartFragment();
                    })
                    .setNegativeButton("Cancel", (dialog, which) -> {
                        dialog.dismiss();
                    }).show();
        });

        binding.textView.setText("" + Cart.getInstance().getCartPrice() + "€");

        binding.button.setOnClickListener(v -> {
            new AlertDialog.Builder(requireContext())
                    .setTitle("Continue?")
                    .setMessage("You will remove all the items from the cart")
                    .setPositiveButton("Confirm", (dialog, which) -> {
                        Cart.getInstance().setProductsCart(new ArrayList<>());
                        Cart.getInstance().setCartPrice(0);
                        navigateToCartFragment();
                    })
                    .setNegativeButton("Cancel", (dialog, which) -> {
                        dialog.dismiss();
                    }).show();
        });

    }
    private void navigateToCartFragment() {
        // Create a new instance of the HomeFragment
        CartFragment cartFragment = new CartFragment();
        // Get the FragmentManager
        FragmentManager fragmentManager = getParentFragmentManager();
        // Start a new FragmentTransaction
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        // Replace the current fragment with the HomeFragment
        transaction.replace(R.id.fragment_container, cartFragment);
        // Add the transaction to the back stack (optional)
        transaction.addToBackStack(null);
        // Commit the transaction
        transaction.commit();
    }
}
