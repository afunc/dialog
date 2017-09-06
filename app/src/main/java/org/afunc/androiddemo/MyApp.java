package org.afunc.androiddemo;

import android.app.Application;
import android.util.Log;
import android.widget.Toast;
import butterknife.ButterKnife;
import org.afunc.android.util.ConstUtils;
import org.afunc.android.util.LogUtils;

/**
 * <li>Created by 紫紫 on 2017/9/6</li>
 * <li>Q157596462@outlook.com</li>
 * <li>描述：</li>
 */

public class MyApp extends Application {


    @Override
    public void onCreate() {
        super.onCreate();
        ConstUtils.syncIsDebug(this, getPackageName());
        Log.e("tag","测试");
        Toast.makeText(this,String.valueOf(ConstUtils.isDebug),Toast.LENGTH_LONG).show();
        LogUtils.e("测试");
        ButterKnife.setDebug(ConstUtils.isDebug);
    }
}
