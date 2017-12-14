package com.shunwang.mylibrary;

import android.os.Environment;


/**
 * Created by yangl.liu on 2017/4/27.
 */

public class SDCardUtil {
    //获取存储SD卡路径
    public static String getSDPath() {
        if (isMounted()) {
            return Environment.getExternalStorageDirectory().getAbsolutePath();
        } else {
            return LyUtil.getContext().getFilesDir().getAbsolutePath();
        }
    }

    public static boolean isMounted() {
        return Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED);
    }

}
