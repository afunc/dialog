package org.afunc.androiddemo;

import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;
import org.afunc.android.mvp.RequirePresenter;
import org.afunc.android.util.DimenUtils;
import org.afunc.android.util.LogUtils;
import org.afunc.weiget.loader.IndicatorLoader;

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
            @SuppressWarnings("unchecked")
            public void onClick(View v) {
                LogUtils.e("点击了");
//                SweetAlertDialog alertDialog = new SweetAlertDialog(MainActivity.this, SweetAlertDialog.ERROR_TYPE);
//                alertDialog.showCancelButton(true);
//                showDialog(alertDialog);

                int size = DimenUtils.dp2px(MainActivity.this, 50);
//                ProgressBar progressBar = new ProgressBar(MainActivity.this);
//                progressBar.setPadding(size, size, size, size);
//                progressBar.setBackgroundResource(android.R.color.transparent);


//                IndicatorView indicator = new IndicatorView(MainActivity.this);
//                indicator.setmIndicatorColor(Color.parseColor("#FF00FF"));
//                indicator.setmIndicatorId(IndicatorView.SemiCircleSpin);
//                AlertDialog mLoadingDialog = new AlertDialog.Builder(MainActivity.this)
//                        .setView(indicator).setMessage("123").setTitle("title")
////                    .setCancelable(false)
//                        .create();
//                mLoadingDialog.setCanceledOnTouchOutside(false);
//                showLoadingDialog(mLoadingDialog);

                IndicatorLoader dialog = new IndicatorLoader(MainActivity.this);
                dialog.getIndicator().setRandomIndicator(true);
//                dialog.setTitle("asdasd3");

                dialog.setBackgroundResource(R.drawable.corners_indicator);
                showDialog(dialog);
            }
        });
    }

    // 互相调用
    int sum(int a, int b) {
        return a + b;
    }
}
