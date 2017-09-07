package org.afunc.android.util;

import android.util.Log;

/**
 * Created by 紫紫 on 2017/8/7
 * Q157596462@outlook.com
 * 描述：日志封装
 */
public class LogUtils {

    /**
     * @param tag 在application 中 可以设置统一的 TAG
     */
    public void setTag(String tag) {
        TAG = tag;
    }

    public static String TAG = "紫紫";

    /**
     * @param msg 错误提示
     */
    public static void i(String msg) {
        Log.i(TAG, msg);
    }

    /**
     * @param msg 错误提示
     */
    public static void d(String msg) {
        Log.d(TAG, msg);
    }

    /**
     * @param msg 错误提示
     */
    public static void e(String msg) {
        Log.e(TAG, msg);
    }

    /**
     * @param msg 错误提示
     */
    public static void v(String msg) {
        Log.v(TAG, msg);
    }

    /**
     * @param msg 错误提示
     * @param e   可抛异常
     */
    public static void e(String msg, Throwable e) {
        Log.e(TAG, msg, e);
    }

    /**
     * @param TAG 标志位
     * @param msg 错误提示
     */
    public static void i(String TAG, String msg) {
        Log.i(TAG + TAG, msg);
    }

    /**
     * @param TAG 标志位
     * @param msg 错误提示
     */
    public static void d(String TAG, String msg) {
        Log.d(TAG + TAG, msg);
    }

    /**
     * @param TAG 标志位
     * @param msg 错误提示
     */
    public static void e(String TAG, String msg) {
        Log.e(TAG + TAG, msg);
    }

    /**
     * @param TAG 标志位
     * @param msg 错误提示
     */
    public static void v(String TAG, String msg) {
        Log.v(TAG + TAG, msg);
    }

    /**
     * @param TAG 标志位
     * @param msg 错误提示
     * @param e   可抛异常
     */
    public static void e(String TAG, String msg, Throwable e) {
        Log.e(TAG + TAG, msg, e);
    }
}
