package com.wlink.nettv.nettvlivetv;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.wlink.nettv.nettvchannel.data.network.model.ChannelModel;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ChannelListAdapter extends RecyclerView.Adapter<ChannelListAdapter.MyViewHolder>{

    Context context;
    List<ChannelModel> channelModels;


    public ChannelListAdapter(Context context, List<ChannelModel> channelModels) {
        this.context = context;
        this.channelModels = channelModels;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.channel_list_single,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        ChannelModel channelModel = channelModels.get(position);
        holder.channelName.setText(channelModel.getName());
        holder.channelName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(context,MediaPlayActivity.class);
                context.startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return channelModels.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{

        @BindView(R.id.tv_channel_name)
        TextView channelName;

        public MyViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
