package com.shunwang.mylibrary;

import android.content.Context;

/**
 * Created by yangl.liu on 2017/12/13.
 */

public class LyUtil {
    private static Context mContext;

    public static void init(Context context) {
        mContext = context;
    }

    public static Context getContext() {
        return mContext;
    }
}
