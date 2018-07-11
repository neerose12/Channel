package com.wlink.nettv.nettvlivetv.ui.displaychannel;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;

import com.owen.tvrecyclerview.widget.TvRecyclerView;
import com.wlink.nettv.nettvchannel.data.network.model.ChannelCategory;
import com.wlink.nettv.nettvchannel.data.network.model.ChannelModel;
import com.wlink.nettv.nettvlivetv.R;
import com.wlink.nettv.nettvlivetv.base.BaseFragment;
import com.wlink.nettv.nettvlivetv.ui.playchannel.Main;
import com.wlink.nettv.nettvlivetv.util.exception.NettvClassCastException;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class ChannelAndCategoryListFragment extends BaseFragment implements CategoryListAdapter.CategoryCallback,ChannelListAdapter.ChannelCallback {

    @BindView(R.id.rv_category_list)
    TvRecyclerView rvCategoryList;
    @BindView(R.id.rv_channel_list)
    TvRecyclerView rvChannelList;
    CategoryListAdapter categoryListAdapter;
    ChannelListAdapter channelListAdapter;
    Main main;
    FragmentCallback fragmentCallback;

    public void setCallBack(FragmentCallback fragmentCallback){
        this.fragmentCallback = fragmentCallback;
    }

    @Override
    protected int getLayout() {
        return R.layout.channel_and_category_list;
    }

    @Override
    protected void init() {
        setListener();

        rvCategoryList.setSpacingWithMargins(0, 10);
        rvChannelList.setSpacingWithMargins(10, 0);

        categoryListAdapter = new CategoryListAdapter(new ArrayList<ChannelCategory>());
        categoryListAdapter.setCallback(this);
        rvCategoryList.setAdapter(categoryListAdapter);


//        categoryListAdapter.addItems(main.channelCategories);

        LinearLayoutManager linearLayoutManager1 = new LinearLayoutManager(getActivity());
        rvChannelList.setLayoutManager(linearLayoutManager1);

//        channelListAdapter = new ChannelListAdapter(main.channelModels);
//        channelListAdapter.setChannelCallback(this);
//        rvChannelList.setAdapter(channelListAdapter);

    }



    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
//        main = (Main)getActivity();
        try{
            this.fragmentCallback = (FragmentCallback)context;
        }catch (NettvClassCastException e){
            e.printStackTrace();
        }
    }

    @Override
    public void onEmptyViewRetry() {
    }

    @Override
    public void categoryCliked(int position) {
        channelListAdapter.changeChannel(fragmentCallback.getChannelList(position));
    }

    @Override
    public void channelClicked(int position) {
        fragmentCallback.playChannel(position);
    }


    public interface FragmentCallback{

        List<ChannelModel> getChannelList(int position);
        void playChannel(int position);
    }



    private void setListener() {
        setScrollListener(rvCategoryList);
        recyclerViewFocusListener(rvCategoryList,1.1f,0);
        recyclerViewFocusListener(rvChannelList,1.1f,0);

        rvChannelList.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(rvCategoryList.hasFocus() && !hasFocus)
                    return;
                mFocusBorder.setVisible(hasFocus);
            }
        });

        rvCategoryList.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(rvChannelList.hasFocus() && !hasFocus)
                    return;
                mFocusBorder.setVisible(hasFocus);
            }
        });

    }



}
