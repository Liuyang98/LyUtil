package com.shunwang.mylibrary;

/**
 * Created by yangl.liu on 2017/5/19.
 */

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;


/**
 * 选项设置，可以设置和获取的数据类型有：String、int、boolean
 */
public class SharePrefUtil {

    private SharedPreferences mPref;
    private Context mContext;
    private SharedPreferences.Editor editor;

    private static class LazyHolder {
        private static SharePrefUtil instance = new SharePrefUtil(LyUtil.getContext());
    }

    public static SharePrefUtil getInstance() {
        return LazyHolder.instance;
    }

    /**
     * PreferencesConfig构造方法
     *
     * @param context
     */
    public SharePrefUtil(Context context) {
        mContext = context;
        mPref = PreferenceManager.getDefaultSharedPreferences(mContext);
        editor = mPref.edit();
    }

    /**
     * 获得参数：String
     *
     * @param name
     * @return String
     */
    public String getString(String name) {
        return mPref.getString(name, "");
    }

    /**
     * 设置参数：String
     *
     * @param name
     * @param value
     */
    public void setString(String name, String value) {
        editor.putString(name, value);
        editor.commit();
    }

    /**
     * 获得参数：int
     *
     * @param name
     * @return int
     */
    public int getInt(String name) {
        return mPref.getInt(name, 0);

    }

    /**
     * 设置参数：int
     *
     * @param name
     * @param value
     */
    public void setInt(String name, int value) {
        editor.putInt(name, value);
        editor.commit();
        return;
    }

    /**
     * 设置参数：boolean
     *
     * @param name
     * @param value
     */
    public void setBool(String name, boolean value) {
        editor.putBoolean(name, value);
        editor.commit();
    }

    /**
     * 获得参数：boolean
     *
     * @param name
     * @return
     */
    public boolean getBool(String name) {
        return mPref.getBoolean(name, false);
    }

    /**
     * 设置参数：long
     *
     * @param name
     * @param value
     */
    public void setLong(String name, long value) {
        editor.putLong(name, value);
        editor.commit();
    }

    /**
     * 获得参数：long
     *
     * @param name
     * @return
     */
    public long getLong(String name) {
        return mPref.getLong(name, 0l);
    }

    /**
     * 清除配置文件内容
     */
    public void clear() {
        editor.clear();
        editor.commit();
    }

    /**
     * 移除某个key值已经对应的值
     *
     * @param key
     */
    public void remove(String key) {
        editor.remove(key);
        editor.commit();
    }
}
