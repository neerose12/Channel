package com.wlink.nettv.nettvlivetv;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.wlink.nettv.nettvchannel.data.network.model.ChannelModelResponse;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CategoryListAdapter extends RecyclerView.Adapter<CategoryListAdapter.MyViewHolder>{

    List<ChannelModelResponse> channelModelResponses;
    Context context ;

    public CategoryListAdapter(List<ChannelModelResponse> channelModelResponses, Context context) {
        this.channelModelResponses = channelModelResponses;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.category_single_item,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        ChannelModelResponse channelModelResponse = channelModelResponses.get(position);
        holder.categoryName.setText(channelModelResponse.getCategory());
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
        holder.rvChannelList.setLayoutManager(linearLayoutManager);
        ChannelListAdapter channelListAdapter = new ChannelListAdapter(context,channelModelResponse.getChannelModels());
        holder.rvChannelList.setAdapter(channelListAdapter);
    }

    @Override
    public int getItemCount() {
        return channelModelResponses.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.tv_category_name)
        TextView categoryName;
        @BindView(R.id.rv_channel_list)
        RecyclerView rvChannelList;

        public MyViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
