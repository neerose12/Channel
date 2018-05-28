package com.wlink.nettv.nettvlivetv.ui.displaychannel;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.wlink.nettv.nettvchannel.data.network.model.ChannelCategory;
import com.wlink.nettv.nettvlivetv.R;
import com.wlink.nettv.nettvlivetv.base.BaseViewHolder;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class CategoryListAdapter extends RecyclerView.Adapter<BaseViewHolder>{

    List<ChannelCategory> channelModelResponses;
    private CategoryCallback mCategoryCallback;
    public static final int VIEW_TYPE_EMPTY = 0;
    public static final int VIEW_TYPE_NORMAL = 1;
    Context context;
    public CategoryListAdapter(List<ChannelCategory> channelModelResponses) {
        this.channelModelResponses = channelModelResponses;
    }

    public void setCallback(CategoryCallback categoryCallback) {
        mCategoryCallback = categoryCallback;
    }


    @NonNull
    @Override
    public BaseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        switch (viewType) {
            case VIEW_TYPE_NORMAL:
                return new MyViewHolder(
                        LayoutInflater.from(parent.getContext()).inflate(R.layout.category_single_item, parent, false));
            case VIEW_TYPE_EMPTY:
            default:
                return new EmptyViewHolder(
                        LayoutInflater.from(parent.getContext()).inflate(R.layout.item_empty_view, parent, false));
        }
    }

    @Override
    public void onBindViewHolder(@NonNull BaseViewHolder holder, int position) {
            holder.onBind(position);
    }

    @Override
    public int getItemViewType(int position) {
        if(channelModelResponses != null && channelModelResponses.size() > 0){
            return VIEW_TYPE_NORMAL;
        }else{
            return  VIEW_TYPE_EMPTY;
        }
    }


    @Override
    public int getItemCount() {
        if(channelModelResponses != null && channelModelResponses.size() > 0){
            return channelModelResponses.size();
        }else{
            return 0;
        }
    }

    public void addItems(List<ChannelCategory> channelCategories){
        this.channelModelResponses = channelCategories;
        notifyDataSetChanged();
    }

    public interface CategoryCallback {
        void onEmptyViewRetry();
        void categoryCliked(int position);
    }

    public class MyViewHolder extends BaseViewHolder {

        @BindView(R.id.tv_category_name)
        TextView categoryName;

        @BindView(R.id.ll_category_single_item)
        LinearLayout llCategoryItem;
        int position;

        public MyViewHolder(View itemView) {
            super(itemView);
        }

        @Override
        public void onBind(int position) {
            super.onBind(position);
            this.position = position;
            ChannelCategory channelModelResponse = channelModelResponses.get(position);
            categoryName.setText(channelModelResponse.getCategory());

        }

        @Override
        protected void clear() {
        }

        @OnClick
        public void categoryClicked(){
            mCategoryCallback.categoryCliked(position);
        }
    }

    public class EmptyViewHolder extends BaseViewHolder {

        public EmptyViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }

        @Override
        protected void clear() {

        }
    }
}
