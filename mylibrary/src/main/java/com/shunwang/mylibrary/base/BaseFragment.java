package com.shunwang.mylibrary.base;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;


import com.shunwang.mylibrary.R;

import java.io.Serializable;

/**
 * Created by yangl.liu on 2017/4/19.
 * 基础Fragment
 */

public class BaseFragment extends Fragment {
    private static final String TYPE = "TYPE", DATA_BEAN = "DATA_BEAN";
    protected Context mContext;
    protected View mView;
    protected ImageView titleLeftTv;
    protected ImageView titleRightIv;
    protected TextView titleTv;

    protected <T extends View> T findView(int id) {
        return (T) mView.findViewById(id);
    }

    protected void initTitle(String title) {
        titleTv = findView(R.id.tv_title);
        titleTv.setText(title);
    }

    protected void initTitle(String title, int rightImg) {
        initTitle(true, title, rightImg);
    }

    protected void initTitle(boolean hasBack, String title, int rightImg) {
        titleLeftTv = findView(R.id.iv_left);
        titleRightIv = findView(R.id.iv_right);
        titleTv = findView(R.id.tv_title);

        titleTv.setText(title);
        titleRightIv.setImageResource(rightImg);
        if (hasBack) {
            titleLeftTv.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mContext = context;
    }

    protected int getType() {
        if (getArguments() != null)
            return getArguments().getInt(BaseFragment.TYPE, -1);
        else return -1;
    }

    public BaseFragment setType(int type) {
        Bundle bundle = new Bundle();
        bundle.putInt(BaseFragment.TYPE, type);
        setArguments(bundle);
        return this;
    }

    protected Object getData() {
        if (getArguments() != null)
            return getArguments().getSerializable(DATA_BEAN);
        else return null;
    }

    public BaseFragment setData(Serializable serializable) {
        Bundle bundle = new Bundle();
        bundle.putSerializable(DATA_BEAN, serializable);
        setArguments(bundle);
        return this;
    }

    protected void loadData() {
    }
}
