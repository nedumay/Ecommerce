package com.example.ecommerce.ui.product;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.ecommerce.R;

import java.util.ArrayList;
import java.util.List;

public class ProductImageAdapter extends RecyclerView.Adapter<ProductImageAdapter.ProductImageViewHolder>{

    List<String> imgs = new ArrayList<>();
    public void setImgs(List<String> imgs) {
        this.imgs = imgs;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ProductImageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.prod_det_item,parent,false);
        return new ProductImageViewHolder(view);
    }

    @Override
    public int getItemCount() {
        return imgs.size();
    }

    @Override
    public void onBindViewHolder(@NonNull ProductImageViewHolder holder, int position) {
        String img = imgs.get(position);
        Glide.with(holder.itemView)
                .load(img)
                .into(holder.imageViewProduct);
    }

    public final class ProductImageViewHolder extends RecyclerView.ViewHolder{

        private final ImageView imageViewProduct;

        public ProductImageViewHolder(@NonNull View itemView) {
            super(itemView);
            imageViewProduct = itemView.findViewById(R.id.image_view);
        }
    }
}
