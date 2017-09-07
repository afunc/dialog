package org.afunc.androiddemo;

import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;
import org.afunc.android.mvp.RequirePresenter;
import org.afunc.android.util.LogUtils;
import org.afunc.view.SweetAlertDialog;

@RequirePresenter(MainPresenter.class)
public class MainActivity extends AppActivity<MainPresenter> {
    TextView textView;
    TextView msg;

    @Override
    protected int setContentViewId() {
        return R.layout.activity_main;
    }


    @Override
    protected int setToolbarId() {
        return R.id.toolbar;
    }

    @Override
    protected void modifyToolbar(Toolbar mToolbar) {
        mToolbar.setTitle("");
        setHomeBack(true);
    }


    @Override
    protected void onCreateAfterSuper() {
        super.onCreateAfterSuper();
        textView = $(R.id.title);
        textView.setText("title");
        msg = $(R.id.msg);
        msg.setText(String.format("%d + %d = %d", 1, 2, getPresenter().sum(1, 2)));
        msg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LogUtils.e("点击了");
                SweetAlertDialog alertDialog = new SweetAlertDialog(MainActivity.this, SweetAlertDialog.NORMAL_TYPE);
                showDialog(alertDialog);
            }
        });
    }


    protected int sum(int a, int b) {
        return a + b;
    }
}
