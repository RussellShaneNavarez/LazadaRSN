package com.example.lazada.fragment;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.lazada.Cart;
import com.example.lazada.R;
import com.example.lazada.model.Product;
import com.squareup.picasso.Picasso;

public class Detail extends AppCompatActivity {

    private void assignImage(ImageView img, String imageLink){
        Picasso.get().load(imageLink).into(img, new com.squareup.picasso.Callback(){
            @Override
            public void onSuccess(){
                Log.d("Image Added", "Image");
            }

            @Override
            public void onError(Exception e) {
                img.setImageResource(R.drawable.ic_launcher_background);
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(R.style.Theme_Lazada);
        setContentView(R.layout.activity_detail);

        Product product = (Product) getIntent().getSerializableExtra("product", Product.class);

        ImageView thumbnail = findViewById(R.id.thumbnail);
        assignImage(thumbnail, product.getThumbnail());
        TextView title = findViewById(R.id.title);
        TextView description = findViewById(R.id.description);
        TextView price = findViewById(R.id.price);

        ImageView img1 = findViewById(R.id.img1);
        assignImage(img1, product.getImages().get(0));
        ImageView img2 = findViewById(R.id.img2);
        assignImage(img2, product.getImages().get(1));
        ImageView img3 = findViewById(R.id.img3);
        assignImage(img3, product.getImages().get(2));

        title.setText(product.getTitle());
        description.setText(product.getDescription());
        price.setText("" + product.getPrice() + "€");

        Button goBackBtn = findViewById(R.id.goBackBtn);
        goBackBtn.setOnClickListener(v -> {finish();});

        Button addToCart = findViewById(R.id.addToCartBtn);
        addToCart.setOnClickListener(v -> {
            Cart.getInstance().addCart(product);
            Toast.makeText(Detail.this, "Added successfully", Toast.LENGTH_SHORT).show();
            Log.d("CartView", Cart.getInstance().toString());
        });



    }
}
