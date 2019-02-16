package com.elhazent.picodiploma.myrecyleview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class CardAdapter extends RecyclerView.Adapter<CardAdapter.CardViewHolder> {
    private ArrayList<HeroItems> heroItems;
    private Context context;

    private ArrayList<HeroItems> getListHero() {
        return heroItems;
    }
    public void setListHero(ArrayList<HeroItems> listHero) {
        this.heroItems = listHero;
    }
    public CardAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public CardAdapter.CardViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_cardview, viewGroup, false);
        return new CardViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CardViewHolder holder, int position) {
        final HeroItems p = getListHero().get(position);
        Glide.with(context).load(p.getPhoto()).apply(new RequestOptions().override(350,550)).into(holder.imgPhoto);
        holder.name.setText(p.getName());
        holder.description.setText(p.getFrom());

        holder.share.setOnClickListener(new OnItemClickListener(position, new OnItemClickListener.OnItemClickCallback() {
            @Override
            public void onItemClicked(View view, int position) {
                Toast.makeText(context,"Share "+ getListHero().get(position).getName(), Toast.LENGTH_SHORT).show();
            }
        }));

        holder.favorite.setOnClickListener(new OnItemClickListener(position, new OnItemClickListener.OnItemClickCallback() {
            @Override
            public void onItemClicked(View view, int position) {
                Toast.makeText(context,"Favorite "+ getListHero().get(position).getName(), Toast.LENGTH_SHORT).show();
            }
        }));
    }

    @Override
    public int getItemCount() {
        return getListHero().size();
    }

    public class CardViewHolder extends RecyclerView.ViewHolder {
        ImageView imgPhoto;
        TextView name, description;
        Button share, favorite;
        public CardViewHolder(@NonNull View itemView) {
            super(itemView);
            imgPhoto = itemView.findViewById(R.id.img_card);
            name = itemView.findViewById(R.id.name_card);
            description = itemView.findViewById(R.id.description_card);
            share = itemView.findViewById(R.id.btn_share);
            favorite = itemView.findViewById(R.id.btn_favorite);
        }
    }
}
