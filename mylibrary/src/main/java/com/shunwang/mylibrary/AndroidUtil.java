package com.shunwang.mylibrary;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.Rect;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;


import java.util.List;

import static android.content.Context.INPUT_METHOD_SERVICE;

/**
 * 与Android系统相关的工具类
 * Created by sb.wang on 2016/3/3.
 */
public class AndroidUtil {
    private static int statusHeight;

    /**
     * 获取系统版本号 android 4.4
     */
    public static String getSystemVersion() {
        return Build.VERSION.RELEASE;
    }

    /**
     * 获取手机型号
     */
    public static String getPhoneType() {
        return Build.MODEL;//
    }

    /**
     * 获取手机厂商
     *
     * @return
     */
    public static String getVendor() {
        return Build.BRAND;
    }

    /**
     * 获取SDK版本
     */
    public static int getSDKVersion() {
        return Build.VERSION.SDK_INT;
    }

    /**
     * Works for Android 2.2 and above
     * 获取设备ID
     */
    public static String getAndroidId(Context context) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.FROYO) {
            return Settings.Secure.getString(context.getContentResolver(), Settings.Secure.ANDROID_ID);
        } else {
            return "devideId works for android 2.2 and above";
        }
    }

    /**
     * 获取屏幕宽度
     */
    public static int getScreenWidth(Context context) {
        WindowManager wm = (WindowManager) context.getApplicationContext().getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics dm = new DisplayMetrics();
        wm.getDefaultDisplay().getMetrics(dm);
        if(widthPixels==0){
            widthPixels=dm.widthPixels;
        }

        return dm.widthPixels;
    }

    private  static int widthPixels;

    public static int getScreenWidth() {
        return widthPixels;
    }

    /**
     * 获取屏幕高度
     */
    public static int getScreenHeight(Context context) {
        WindowManager wm = (WindowManager) context.getApplicationContext().getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics dm = new DisplayMetrics();
        wm.getDefaultDisplay().getMetrics(dm);
        return dm.heightPixels;
    }

    /**
     * 获取状态栏高度
     *
     * @return
     */
    public static int getStatusHeight(Activity activity) {
        if (statusHeight != 0) {
            return statusHeight;
        }

        Rect localRect = new Rect();
        activity.getWindow().getDecorView().getWindowVisibleDisplayFrame(localRect);
        statusHeight = localRect.top;
        if (0 == statusHeight) {
            Class<?> localClass;
            try {
                localClass = Class.forName("com.android.internal.R$dimen");
                Object localObject = localClass.newInstance();
                int i5 = Integer.parseInt(localClass.getField("status_bar_height").get(localObject).toString());
                statusHeight = activity.getResources().getDimensionPixelSize(i5);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return statusHeight;
    }

    public static String getCurProcessName(Context context) {
        int pid = android.os.Process.myPid();
        ActivityManager activityManager = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
        List<ActivityManager.RunningAppProcessInfo> l = activityManager.getRunningAppProcesses();
        if (l != null)
            for (ActivityManager.RunningAppProcessInfo appProcess : l) {
                if (appProcess.pid == pid) {
                    return appProcess.processName;
                }
            }
        return "";
    }

    public static PackageInfo getPackageInfo() {
        Context context = LyUtil.getContext();
        PackageInfo pi = null;
        try {
            PackageManager pm = context.getPackageManager();
            pi = pm.getPackageInfo(context.getPackageName(), PackageManager.GET_CONFIGURATIONS);
            return pi;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return pi;
    }

    public static void hideKeyBorad(AppCompatActivity activity) {
            // 先隐藏键盘
            ((InputMethodManager) activity.getSystemService(INPUT_METHOD_SERVICE))
                    .hideSoftInputFromWindow(activity.getCurrentFocus().getWindowToken()
                            , InputMethodManager.HIDE_NOT_ALWAYS);
            //接下来在这里做你自己想要做的事，实现自己的业务。
    }

    public static void gpuSpeedUp(Window window) {
        try {
            if (Integer.parseInt(Build.VERSION.SDK) >= 11) {
                window.setFlags(
                        WindowManager.LayoutParams.FLAG_HARDWARE_ACCELERATED,
                        WindowManager.LayoutParams.FLAG_HARDWARE_ACCELERATED);
            }
        } catch (Exception e) {
        }
    }


    /**
     * 判断网络是否连接
     **/
    public static boolean checkNet() {
        boolean hasNet = false;
        Context context = LyUtil.getContext();
        ConnectivityManager connManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        // 获取代表联网状态的NetWorkInfo对象
        NetworkInfo networkInfo = connManager.getActiveNetworkInfo();
        // 获取当前的网络连接是否可用

        if (networkInfo != null) {
            hasNet = networkInfo.isAvailable();
        }
        return hasNet;
    }
}
