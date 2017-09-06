package org.afunc.androiddemo;

import org.afunc.android.mvp.ToolbarActivity;

public class MainActivity extends ToolbarActivity {

    @Override
    protected int setContentViewId() {
        return R.layout.activity_main;
    }

    @Override
    protected int setToolbarId() {
        return R.id.toolbar;
    }

    @Override
    public boolean setToolbarHomeBack() {
        return true;
    }

    @Override
    protected void onCreateAfterSuper() {
        super.onCreateAfterSuper();
        getToolbar().setTitle("");
    }
}
