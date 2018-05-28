package com.wlink.nettv.nettvlivetv.ui.displaychannel;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.logapp.logger.Lg;
import com.wlink.nettv.nettvchannel.data.network.model.ChannelModel;
import com.wlink.nettv.nettvlivetv.R;
import com.wlink.nettv.nettvlivetv.base.BaseViewHolder;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ChannelListAdapter extends RecyclerView.Adapter<BaseViewHolder>{

    Context context;
    List<ChannelModel> channelModels;
    public static final int VIEW_TYPE_EMPTY = 0;
    public static final int VIEW_TYPE_NORMAL = 1;
    ChannelCallback channelCallback;

    public void setChannelCallback(ChannelCallback channelCallback){
        this.channelCallback = channelCallback;
    }

    public ChannelListAdapter(List<ChannelModel> channelModels) {
        this.context = context;
        this.channelModels = channelModels;
    }

    @NonNull
    @Override
    public BaseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        switch (viewType){
            case VIEW_TYPE_NORMAL:
                return new MyViewHolder(LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.channel_list_single,parent,false));
            case VIEW_TYPE_EMPTY:
            default:
                return new EmptyViewHolder(LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.item_empty_view,parent,false));
        }
    }

    @NonNull
    @Override
    public void onBindViewHolder(@NonNull BaseViewHolder holder, int position) {
        holder.onBind(position);
    }


    @Override
    public int getItemViewType(int position) {
        if(channelModels != null && channelModels.size() > 0) {
            return VIEW_TYPE_NORMAL;
        }else{
            return VIEW_TYPE_EMPTY;
        }
    }

    @Override
    public int getItemCount() {
        if(channelModels != null && channelModels.size() > 0) {
            return channelModels.size();
        }else{
            return 0;
        }
    }

    public void changeChannel(List<ChannelModel> channelList) {
        this.channelModels = channelList;
        notifyDataSetChanged();
    }

    class MyViewHolder extends BaseViewHolder{

        @BindView(R.id.tv_channel_name)
        TextView channelName;
        @BindView(R.id.ll_channel_single_item)
        LinearLayout channelClicked;
        int position;

        public MyViewHolder(View itemView) {
            super(itemView);
        }

        @Override
        public void onBind(int position) {
            super.onBind(position);
            this.position = position;
            Log.d("CheckingIdPosition","here");
            ChannelModel channelModel = channelModels.get(position);
            channelName.setText(channelModel.getName());
        }

        @Override
        protected void clear() {

        }

        @OnClick
        public void onChannelCliked(){
            Lg.d("Cliked");
            channelCallback.channelClicked(position);
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


    public interface ChannelCallback {
        void channelClicked(int position);
    }
}
