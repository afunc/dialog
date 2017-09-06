package org.afunc.android.mvp;

import android.os.Bundle;
import android.support.annotation.*;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;


/**
 * Activity 顶部可添加一个标准的 toolbar，只需在 xml 中添加一个 @+id = toolbar 的 Toolbar 即可，样式需自定义
 * <p>
 * Created by linlongxin on 2016/7/31.
 */

public abstract class ToolbarActivity<T extends SuperPresenter> extends SuperActivity<T> {

    //设置 toolbar 是否显示返回键
    private Toolbar mToolbar;
    private boolean isHomeBack = false;


    public boolean setToolbarHomeBack() {
        return false;
    }


    @SuppressWarnings("unchecked")
    public <V extends View> V $(@IdRes int id) {
        View view = super.findViewById(id);
        return (V) view;
    }

    protected void setHomeBack(boolean homeBack) {
        isHomeBack = homeBack;
    }

    @Override
    public void setContentView(@LayoutRes int layoutResID) {
        isHomeBack = setToolbarHomeBack();
        super.setContentView(layoutResID);
        mToolbar = (Toolbar) findViewById(setToolbarId());
    }

    protected abstract @IdRes
    int setToolbarId();

    /**
     * @return 默认 主题设置为 Theme_AppCompat_Light_NoActionBar
     */
    @StyleRes
    protected int setActivityTheme() {
        return android.support.v7.appcompat.R.style.Theme_AppCompat_Light_NoActionBar;
    }

    @Override
    @CallSuper
    protected void onCreateAfterSuper() {
        super.onPostCreateAfterSuper();
        if (mToolbar != null) {
            setSupportActionBar(mToolbar);
            getSupportActionBar().setDisplayHomeAsUpEnabled(isHomeBack);
        }
    }

    @Override
    protected void onCreateBeforeSuper(@Nullable Bundle savedInstanceState) {
        super.onCreateBeforeSuper(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setTheme(setActivityTheme());
    }


    public Toolbar getToolbar() {
        return mToolbar;
    }

    @Override
    @CallSuper
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home && isHomeBack) {
            finish();
            return true;
        } else {
            return super.onOptionsItemSelected(item);
        }
    }
}
