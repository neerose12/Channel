package com.wlink.nettv.nettvlivetv.base;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import butterknife.ButterKnife;

public abstract class BaseViewHolder extends RecyclerView.ViewHolder{

    private int mCurrentPosition;

    public BaseViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this,itemView);
    }

    protected abstract void clear();

    public void onBind(int position){
        mCurrentPosition = position;
        clear();
    }

    public int getCurrentPosition(){
        return mCurrentPosition;
    }
}

