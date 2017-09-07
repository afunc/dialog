package org.afunc.androiddemo;

import android.support.v7.widget.Toolbar;
import android.widget.TextView;
import org.afunc.android.mvp.RequirePresenter;

@RequirePresenter(MainPresenter.class)
public class MainActivity extends AppActivity<MainPresenter> {

    @Override
    protected int setContentViewId() {
        return R.layout.activity_main;
    }


    @Override
    protected int setToolbarId() {
        return R.id.toolbar;
    }


    TextView textView;

    @Override
    protected void onCreateAfterSuper() {
        super.onCreateAfterSuper();
        textView = $(R.id.title);
        textView.setText(String.valueOf(getPresenter().sum(1, 2)));
        getPresenter().sum(1, 2);
    }

    @Override
    protected void modifyToolbar(Toolbar mToolbar) {
        mToolbar.setTitle("");
        setHomeBack(true);
    }


    protected int sum(int a, int b) {
        return a + b;
    }
}
