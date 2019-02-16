package com.elhazent.picodiploma.myrecyleview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class HeroAdapter extends RecyclerView.Adapter<HeroAdapter.CategoryViewHolder> {
    private Context context;
    private ArrayList<HeroItems> itemHero;

    public ArrayList<HeroItems> getItemHero() {
        return itemHero;
    }

    public void setItemHero(ArrayList<HeroItems> itemHero) {
        this.itemHero = itemHero;
    }
    public HeroAdapter(Context context){
        this.context = context;
    }



    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.hero_item, viewGroup, false);
        return new CategoryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder holder, int position) {
        holder.holderName.setText(getItemHero().get(position).getName());
        holder.holderFrom.setText(getItemHero().get(position).getFrom());
        Glide.with(context).load(getItemHero().get(position).getPhoto())
                .apply(new RequestOptions().override(55,55))
                .into(holder.holderImage);
    }

    @Override
    public int getItemCount() {
        return getItemHero().size();
    }

    public class CategoryViewHolder extends RecyclerView.ViewHolder {
        TextView holderName, holderFrom;
        ImageView holderImage;
        public CategoryViewHolder(@NonNull View itemView) {
            super(itemView);
            holderName = itemView.findViewById(R.id.tv_item_name);
            holderFrom = itemView.findViewById(R.id.tv_item_description);
            holderImage = itemView.findViewById(R.id.img_item_photo);
        }
    }
}
