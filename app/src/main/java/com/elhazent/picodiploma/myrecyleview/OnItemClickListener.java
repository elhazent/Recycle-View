package com.elhazent.picodiploma.myrecyleview;

import android.view.View;

public class OnItemClickListener implements View.OnClickListener {
    private int position;
    private OnItemClickCallback onItemClickCallBack;
    OnItemClickListener(int position, OnItemClickCallback onItemClickCallBack){
        this.position = position;
        this.onItemClickCallBack = onItemClickCallBack;
    }
    @Override
    public void onClick(View view) {
        onItemClickCallBack.onItemClicked(view, position);
    }
    public interface OnItemClickCallback{
        void onItemClicked(View view,int position);
    }
}
