package com.example.ecommerce.ui.main;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.ecommerce.R;
import com.example.ecommerce.domain.best.Best;

import java.util.ArrayList;
import java.util.List;

public class BestSellerAdapter extends RecyclerView.Adapter<BestSellerAdapter.BestSellerViewHolder> {

    private List<Best> bests = new ArrayList<>();

    public void setBest(List<Best> bests) {
        this.bests = bests;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public BestSellerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.best_seller_item,parent,false);
        return new BestSellerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BestSellerViewHolder holder, int position) {
        Best best = bests.get(position);
        Glide.with(holder.itemView)
                .load(best.getPicture())
                .into(holder.imageViewBest);
        holder.checkBoxLike.setChecked(best.getIs_favorites());
        holder.textViewTitle.setText(best.getTitle());
        holder.textViewDiscount.setText("$" + String.valueOf(best.getDiscount_price()));
        holder.textViewWithoutDiscount.setText("$" + String.valueOf(best.getPrice_without_discount()));
    }

    @Override
    public int getItemCount() {
        return bests.size();
    }

    static class BestSellerViewHolder extends RecyclerView.ViewHolder {

        private final CheckBox checkBoxLike;
        private final ImageView imageViewBest;
        private final TextView textViewDiscount; // перевести из int в String
        private final TextView textViewWithoutDiscount; // перевести из int в String
        private final TextView textViewTitle;

        public BestSellerViewHolder(@NonNull View itemView) {
            super(itemView);
            checkBoxLike = itemView.findViewById(R.id.is_favorite);
            imageViewBest = itemView.findViewById(R.id.picture_item_best_seller);
            textViewDiscount = itemView.findViewById(R.id.discount_pric);
            textViewWithoutDiscount = itemView.findViewById(R.id.price_without_discount);
            textViewTitle = itemView.findViewById(R.id.title_best_seller);
        }
    }
}
