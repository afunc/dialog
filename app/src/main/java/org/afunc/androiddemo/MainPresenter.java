package org.afunc.androiddemo;

/**
 * <li>Created by 紫紫 on 2017/9/7</li>
 * <li>Q157596462@outlook.com</li>
 * <li>描述：</li>
 */

public class MainPresenter extends AppPresenter<MainActivity> {

    protected int sum(int a, int b) {
        return getView().sum(a, b);
    }
}
