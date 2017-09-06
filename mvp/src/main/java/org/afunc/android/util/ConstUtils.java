package org.afunc.android.util;

import android.content.Context;
import android.content.pm.ApplicationInfo;

/**
 * Created by 紫紫 on 2017/8/8
 * Q157596462@outlook.com
 * 描述：设置APP一些值
 */

public class ConstUtils {

    public static boolean isDebug = false;
    public static String TAG = "";

    public static void syncIsDebug(Context context, String tag) {
        if (!isDebug) {
            isDebug = context.getApplicationInfo() != null
                    && (context.getApplicationInfo().flags
                    & ApplicationInfo.FLAG_DEBUGGABLE) != 0;
        }
        TAG = tag;
    }
}
