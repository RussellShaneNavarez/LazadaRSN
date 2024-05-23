package com.example.lazada.adapter;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lazada.R;
import com.example.lazada.model.Product;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProjectViewHolder> {
    private final ArrayList<Product> products;



    private OnItemClickListener onItemClickListener;

    public ProductAdapter(ArrayList<Product> products) {
        this.products = products;

    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.onItemClickListener = listener;
    }

    @NonNull
    @Override
    public ProjectViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_component, parent, false);
        return new ProjectViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProjectViewHolder holder, int position) {
        holder.bind(products.get(position));

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation animation = AnimationUtils.loadAnimation(v.getContext(), R.anim.button_press_animation);
                holder.itemView.startAnimation(animation);

                if (onItemClickListener != null) {
                    onItemClickListener.onItemClick(v, position);
                }
            }
        });
    }


    @Override
    public int getItemCount() {
        return products.size();
    }

    static class ProjectViewHolder extends RecyclerView.ViewHolder {
        private final TextView name;
        private final TextView description;
        private final TextView price;
        private final ImageView icon;


        public ProjectViewHolder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.card_title);
            description = itemView.findViewById(R.id.card_description);
            price = itemView.findViewById(R.id.card_price);
            icon = itemView.findViewById(R.id.image_view_project_background);
        }

        public void bind(Product product) {
            name.setText(product.getTitle());
            description.setText(product.getDescription());
            price.setText("" + product.getPrice() +" €");

            Picasso.get().load(product.getThumbnail()).into(icon, new com.squareup.picasso.Callback(){
                @Override
                public void onSuccess(){
                    Log.d("Image Added", "Image");
                }

                @Override
                public void onError(Exception e) {
                    icon.setImageResource(R.drawable.ic_launcher_background);
                }
            });
        }


    }
}

