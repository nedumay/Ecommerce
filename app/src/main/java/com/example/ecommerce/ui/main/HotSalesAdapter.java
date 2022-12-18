package com.example.ecommerce.ui.main;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.ecommerce.R;
import com.example.ecommerce.domain.home.Home;

import java.util.ArrayList;
import java.util.List;

public class HotSalesAdapter extends RecyclerView.Adapter<HotSalesAdapter.HomeStoreViewHolder> {

    private List<Home> homes = new ArrayList<>();

    public void setHomes(List<Home> homes) {
        this.homes = homes;
        notifyDataSetChanged();
    }

    private OnClickListenerHot onClickListenerHot;
    public void setOnClickListenerHot(OnClickListenerHot onClickListenerHot) {
        this.onClickListenerHot = onClickListenerHot;
    }

    @NonNull
    @Override
    public HomeStoreViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.hot_sales_item,parent,false);
        return new HomeStoreViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HomeStoreViewHolder holder, int position) {
        Home home = homes.get(position);
        Glide.with(holder.itemView)
                .load(home.getPicture())
                .into(holder.imageViewPicture);
        if(home.getIs_new() != null){
            if(home.getIs_new() == true){
                holder.imageViewisNiew.setVisibility(View.VISIBLE);
            }
            else{
                holder.imageViewisNiew.setVisibility(View.INVISIBLE);
            }
        }
        holder.textViewTitle.setText(home.getTitle());
        holder.textViewSubtitle.setText(home.getSubtitle());
        holder.buttonBuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(onClickListenerHot != null){
                    onClickListenerHot.onClick(home);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return homes.size();
    }

    static class HomeStoreViewHolder extends RecyclerView.ViewHolder {
        private final ImageView imageViewPicture;
        private final ImageView imageViewisNiew ;
        private final TextView textViewTitle;
        private final TextView textViewSubtitle;
        private final CardView buttonBuy;

        public HomeStoreViewHolder(@NonNull View itemView) {
            super(itemView);
            imageViewPicture = itemView.findViewById(R.id.picture_item_hot_sales);
            imageViewisNiew = itemView.findViewById(R.id.is_new_item);
            textViewTitle = itemView.findViewById(R.id.title_item);
            textViewSubtitle = itemView.findViewById(R.id.subtitle_item);
            buttonBuy = itemView.findViewById(R.id.btn_buy_now);
        }
    }
}
