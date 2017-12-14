package com.shunwang.mylibrary;

import android.text.TextUtils;
import android.util.Log;


/**
 * LogUtils工具说明:
 * 1 只输出等级大于等于LEVEL的日志 所以在开发和产品发布后通过修改LEVEL来选择性输出日志.
 * 当LEVEL=NOTHING则屏蔽了所有的日志.
 * 2 v,d,i,w,e均对应两个方法. 若不设置TAG或者TAG为空则为设置默认TAG
 */
public class LogUtil {
    public static final int VERBOSE = 1;
    public static final int DEBUG = 2;
    public static final int INFO = 3;
    public static final int WARN = 4;
    public static final int ERROR = 5;
    public static final int NOTHING = 6;
    public static  int LEVEL =NOTHING;
    public static final String SEPARATOR = ",";

    public static void v(String message) {
        if (LEVEL <= VERBOSE) {
            StackTraceElement stackTraceElement = Thread.currentThread()
                    .getStackTrace()[3];
            String tag = getDefaultTag(stackTraceElement);
            if (!TextUtils.isEmpty(message))
                Log.v(tag, message);
        }
    }

    public static void v(String tag, String message) {
        if (LEVEL <= VERBOSE) {
            if (TextUtils.isEmpty(tag)) {
                StackTraceElement stackTraceElement = Thread.currentThread()
                        .getStackTrace()[3];
                tag = getDefaultTag(stackTraceElement);
            }
            if (!TextUtils.isEmpty(message))
                Log.v(tag, message);
        }
    }

    public static void d(String message) {
        if (LEVEL <= DEBUG) {
            StackTraceElement stackTraceElement = Thread.currentThread()
                    .getStackTrace()[3];
            String tag = getDefaultTag(stackTraceElement);
            if (!TextUtils.isEmpty(message))
                Log.d(tag, message);
        }
    }

    public static void d(String tag, String message) {
        if (LEVEL <= DEBUG) {
            if (TextUtils.isEmpty(tag)) {
                StackTraceElement stackTraceElement = Thread.currentThread()
                        .getStackTrace()[3];
                tag = getDefaultTag(stackTraceElement);
            }
            if (!TextUtils.isEmpty(message))
                Log.d(tag, message);
        }
    }

    public static void i(String message) {
        if (LEVEL <= INFO) {
            StackTraceElement stackTraceElement = Thread.currentThread()
                    .getStackTrace()[3];
            String tag = getDefaultTag(stackTraceElement);
            if (!TextUtils.isEmpty(message))
                Log.i(tag, message);
        }
    }

    public static void i(String tag, String message) {
        if (LEVEL <= INFO) {
            if (TextUtils.isEmpty(tag)) {
                StackTraceElement stackTraceElement = Thread.currentThread()
                        .getStackTrace()[3];
                tag = getDefaultTag(stackTraceElement);
            }
            if (!TextUtils.isEmpty(message))
                Log.i(tag, message);
        }
    }

    public static void w(String message) {
        if (LEVEL <= WARN) {
            StackTraceElement stackTraceElement = Thread.currentThread()
                    .getStackTrace()[3];
            String tag = getDefaultTag(stackTraceElement);
            if (!TextUtils.isEmpty(message))
                Log.w(tag, message);
        }
    }

    public static void w(String tag, String message) {
        if (LEVEL <= WARN) {
            if (TextUtils.isEmpty(tag)) {
                StackTraceElement stackTraceElement = Thread.currentThread()
                        .getStackTrace()[3];
                tag = getDefaultTag(stackTraceElement);
            }
            if (!TextUtils.isEmpty(message))
                Log.w(tag, message);
        }
    }

    public static void e(String message) {
        if (LEVEL <= ERROR) {
            StackTraceElement stackTraceElement = Thread.currentThread()
                    .getStackTrace()[3];
            String tag = getDefaultTag(stackTraceElement);
            if (!TextUtils.isEmpty(message))
                Log.e(tag, message);
        }
    }

    public static void e(String tag, String message) {
        if (LEVEL <= ERROR) {
            if (TextUtils.isEmpty(tag)) {
                StackTraceElement stackTraceElement = Thread.currentThread()
                        .getStackTrace()[3];
                tag = getDefaultTag(stackTraceElement);
            }
            if (!TextUtils.isEmpty(message))
                Log.e(tag, message);
        }
    }

    public static void e(Throwable e) {
        if (LEVEL <= ERROR) {
            StackTraceElement stackTraceElement = Thread.currentThread()
                    .getStackTrace()[3];
            String tag = getDefaultTag(stackTraceElement);
            Log.e(tag, e.getMessage(), e);
        }
    }

    public static void e(String tag, Throwable e) {
        if (LEVEL <= ERROR) {
            if (TextUtils.isEmpty(tag)) {
                StackTraceElement stackTraceElement = Thread.currentThread()
                        .getStackTrace()[3];
                tag = getDefaultTag(stackTraceElement);
            }
            Log.e(tag, e.getMessage(), e);
        }
    }

    /**
     * 获取默认的TAG名称. 比如在MainActivity.java中调用了日志输出. 则TAG为MainActivity
     */
    public static String getDefaultTag(StackTraceElement stackTraceElement) {
        String fileName = stackTraceElement.getFileName();
        String stringArray[] = fileName.split("\\.");
        String tag = stringArray[0];
        return tag;
    }

}
