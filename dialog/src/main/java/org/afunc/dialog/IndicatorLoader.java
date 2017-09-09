package org.afunc.dialog;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.annotation.DrawableRes;
import android.support.annotation.IdRes;
import android.support.annotation.NonNull;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

/**
 * <li>Created by 紫紫 on 2017/9/8</li>
 * <li>Q157596462@outlook.com</li>
 * <li>描述：加载框</li>
 */

public class IndicatorLoader extends AlertDialog implements IndicatorView.Callback {


    private View view;
    private TextView msgTextView;
    private IndicatorView indicator;
    private Activity mActivity;

    public IndicatorLoader(@NonNull Context context) {
        this(context, 0);
    }

    public IndicatorLoader(@NonNull Context context, int themeResId) {
        super(context, R.style.indicatorTheme);
        mActivity = (Activity) context;
        view = View.inflate(context, R.layout.load_indicator, null);
        setView(view);
        indicator = $(R.id.indicator);
        indicator.setCallback(this);
        msgTextView = $(R.id.msg_textView);
        setCanceledOnTouchOutside(false);
    }


    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    public void setBackground(Drawable drawable) {
        view.setBackground(drawable);
    }

    public void setBackgroundResource(@DrawableRes int draw) {
        view.setBackgroundResource(draw);
    }

    private double proportion = 0.8;

    public void setProportion(double proportion) {
        if (0 < proportion && proportion < 1) {
            this.proportion = proportion;
        }
    }

    @Override
    public void onContentChanged() {
        super.onContentChanged();
        DisplayMetrics dm = new DisplayMetrics();
        mActivity.getWindowManager().getDefaultDisplay().getMetrics(dm);
        WindowManager.LayoutParams params = this.getWindow().getAttributes();
        params.width = (int) (dm.widthPixels * proportion);
        this.getWindow().setAttributes(params);
    }


    public IndicatorView getIndicator() {
        return indicator;
    }

    public TextView getMsgTextView() {
        return msgTextView;
    }

    @SuppressWarnings("unchecked")
    public <V extends View> V $(@IdRes int id) {
        return (V) view.findViewById(id);
    }

    /**
     * 回调 当旋转屏幕的时候  重新调用 onContentChanged 已完成屏幕的适配
     */
    @Override
    public void onLayoutChange() {
        onContentChanged();
    }
}
