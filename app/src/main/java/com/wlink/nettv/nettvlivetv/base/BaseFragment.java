package com.wlink.nettv.nettvlivetv.base;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.owen.tvrecyclerview.widget.SimpleOnItemListener;
import com.owen.tvrecyclerview.widget.TvRecyclerView;
import com.wlink.nettv.nettvlivetv.R;
import com.wlink.nettv.nettvlivetv.util.focus.FocusBorder;

import butterknife.ButterKnife;

import static android.support.v7.widget.RecyclerView.SCROLL_STATE_DRAGGING;
import static android.support.v7.widget.RecyclerView.SCROLL_STATE_IDLE;
import static android.support.v7.widget.RecyclerView.SCROLL_STATE_SETTLING;

public abstract class BaseFragment extends Fragment {

    public BaseActivity mActivity;
    protected FocusBorder mFocusBorder;
    private RecyclerView mRecyclerView;
    private RecyclerView.OnScrollListener mOnScrollListener = new RecyclerView.OnScrollListener() {
        @Override
        public void onScrollStateChanged(RecyclerView recyclerView, int scrollState) {
            updateState(scrollState);
        }

        @Override
        public void onScrolled(RecyclerView rv, int i, int i2) {
//            updatePosition(rv);
        }

    };

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(getLayout(),container,false);
        ButterKnife.bind(this,view);
        init();

        if(null == mFocusBorder) {
//            mFocusBorder = new FocusBorder.Builder().asDrawable().borderResId(R.drawable.focus).build(this);
            mFocusBorder = new FocusBorder.Builder()
                    .asColor()
                    .borderColor(getResources().getColor(R.color.actionbar_color))
                    .borderWidth(TypedValue.COMPLEX_UNIT_DIP, 2)
                    .shadowColor(getResources().getColor(R.color.green_bright))
                    .shadowWidth(TypedValue.COMPLEX_UNIT_DIP, 18)
                    .build(getActivity());
        }

        if(this instanceof FocusBorderHelper) {
            mFocusBorder = ((FocusBorderHelper)this).getFocusBorder();
        }
        return view;
    }

    protected abstract int getLayout();
    protected abstract void init();


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof BaseActivity) {
            BaseActivity activity = (BaseActivity) context;
            this.mActivity = activity;
            activity.onFragmentAttached();
        }
    }


    protected void onMoveFocusBorder(View focusedView, float scale, float roundRadius) {
        if(null != mFocusBorder) {
            mFocusBorder.onFocus(focusedView, FocusBorder.OptionsFactory.get(scale, scale, roundRadius));
        }
    }

    protected void setScrollListener(RecyclerView recyclerView) {
        if(mRecyclerView != recyclerView) {
            if(null != mRecyclerView) {
                mRecyclerView.removeOnScrollListener(mOnScrollListener);
            }
            recyclerView.addOnScrollListener(mOnScrollListener);
            mRecyclerView = recyclerView;
        }
    }




    private void updateState(int scrollState) {
//        if(null != mStateText) {
        String stateName = "Undefined";
        switch (scrollState) {
            case SCROLL_STATE_IDLE:
                stateName = "Idle";
                break;

            case SCROLL_STATE_DRAGGING:
                stateName = "Dragging";
                break;

            case SCROLL_STATE_SETTLING:
                stateName = "Flinging";
                break;
        }

//            mStateText.setText(stateName);
    }


    public void recyclerViewFocusListener(TvRecyclerView recyclerView,float scale,int radius){
        recyclerView.setOnItemListener(new SimpleOnItemListener() {

            @Override
            public void onItemSelected(TvRecyclerView parent, View itemView, int position) {
                onMoveFocusBorder(itemView, scale, radius);
            }

            @Override
            public void onItemClick(TvRecyclerView parent, View itemView, int position) {
//                showToast("onItemClick::"+position);
            }
        });


    }


    public interface FocusBorderHelper {
        FocusBorder getFocusBorder();
    }
}
