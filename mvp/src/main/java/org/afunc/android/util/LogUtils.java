package org.afunc.android.util;

import android.util.Log;

/**
 * Created by 紫紫 on 2017/8/7
 * Q157596462@outlook.com
 * 描述：
 */
public class LogUtils {

    public static String TAG = "紫紫";

    public static void i(String msg) {
        Log.i(TAG, msg);
    }

    public static void d(String msg) {
        Log.d(TAG, msg);
    }

    public static void e(String msg) {
        Log.e(TAG, msg);
    }

    public static void v(String msg) {
        Log.v(TAG, msg);
    }

    public static void e(String msg, Throwable e) {
        Log.e(TAG, msg, e);
    }

    public static void i(String TAG, String msg) {
        Log.i(TAG + TAG, msg);
    }

    public static void d(String TAG, String msg) {
        Log.d(TAG + TAG, msg);
    }

    public static void e(String TAG, String msg) {
        Log.e(TAG + TAG, msg);
    }

    public static void v(String TAG, String msg) {
        Log.v(TAG + TAG, msg);
    }

    public static void e(String TAG, String msg, Throwable e) {
        Log.e(TAG + TAG, msg, e);
    }
}
