package com.shunwang.mylibrary.base;

/**
 * Created by yangl.liu on 2017/3/14.
 */

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.shunwang.mylibrary.R;

public class BaseFragmentDialog extends DialogFragment {
    protected Context mContext;
    protected View mView;

    @Override
    public void onAttach(Context context) {
        mContext = context;
        super.onAttach(context);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //背景透明
        getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        return new Dialog(mContext, R.style.base_dialog);
    }


    protected Bundle getBundle() {
        Bundle bundle = getArguments();
        if (bundle != null) return bundle;
        else return new Bundle();
    }

    protected View findViewById(@IdRes int resId) {
        return mView.findViewById(resId);
    }

    public void show(FragmentManager fragmentManager) {
        if (fragmentManager != null) {
            super.show(fragmentManager, this.getClass().getSimpleName());
        }
    }

    public void show(ContextThemeWrapper context) {
        if (context != null && context instanceof FragmentActivity) {
            show(((FragmentActivity) context).getSupportFragmentManager());
        }
    }
}
