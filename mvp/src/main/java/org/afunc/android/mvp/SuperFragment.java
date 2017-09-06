package org.afunc.android.mvp;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import butterknife.ButterKnife;
import org.afunc.android.util.LogUtils;

import java.lang.annotation.Annotation;

/**
 * Fragment顶级父类 : 添加各种状态(数据错误，数据为空，数据加载中)页的展示，
 * 自定义的MaterialDialog的显示，进度条dialog显示
 * <p>
 * MVP模型中把Fragment作为view层，可通过getPresenter()调用对应的presenter实例
 * <p>
 * Created by linlongxin on 2016/8/6.
 */

public abstract class SuperFragment<T extends SuperPresenter> extends Fragment {

    private final String TAG = "SuperFragment";

    protected T mPresenter;
    protected Context mContext;

    protected SuperActivity activity;

    /**
     * @return 拥有此fragment 的 superActivity
     */
    public SuperActivity getHoldingActivity() {
        return activity;
    }

    /**
     * 绑定上下文 到 mContext 与activity中
     *
     * @param context 上下文对象
     */
    @Override
    public final void onAttach(Context context) {
        super.onAttach(context);
        mContext = context;
        activity = (SuperActivity) context;
    }

    private View mView;

    @SuppressWarnings("unchecked")
    public <V extends View> V $(@IdRes int id) {
        View view = mView.findViewById(id);
        return (V) view;
    }

    /**
     * onCreate final 避免被重写 可使用 beforeSuper 和 afterSuper
     */
    @Override
    public final void onCreate(@Nullable Bundle savedInstanceState) {
        onCreateBeforeSuper(savedInstanceState);
        super.onCreate(savedInstanceState);
        attachPresenter();
        onCreateAfterSuper();
    }

    protected void onCreateAfterSuper() {
    }

    protected void onCreateBeforeSuper(Bundle savedInstanceState) {
    }

    protected abstract @LayoutRes
    int setContentViewId();

    /**
     * onCreateView final 避免被重写 可使用 beforeSuper 和 afterSuper
     */
    @Nullable
    @Override //container ---> activity
    public final View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        onCreatedViewBeforeSuper(inflater, container, savedInstanceState);
        super.onCreateView(inflater, container, savedInstanceState);
        mView = inflater.inflate(setContentViewId(), container, false);
        ButterKnife.bind(this, mView);
        onCreatedViewAfterSuper(mView);
        return mView;
    }

    protected void onCreatedViewAfterSuper(View mView) {
    }

    protected void onCreatedViewBeforeSuper(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

    }

    /**
     * onCreateView final 避免被重写 可使用 beforeSuper 和 afterSuper
     */
    @Override
    public final void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        onViewCreatedBeforeSuper(view, savedInstanceState);
        super.onViewCreated(view, savedInstanceState);
        if (mPresenter != null)
            mPresenter.onCreate();
        onViewCreatedAfterSuper(view, savedInstanceState);
    }

    protected void onViewCreatedBeforeSuper(View view, Bundle savedInstanceState) {
    }

    protected void onViewCreatedAfterSuper(View view, Bundle savedInstanceState) {


    }

    /**
     * onResume final 避免被重写 可使用 beforeSuper 和 afterSuper
     */
    @Override
    public final void onResume() {
        onResumeBeforeSuper();
        super.onResume();
        if (mPresenter != null)
            mPresenter.onResume();

        onResumeAfterSuper();
    }


    protected void onResumeAfterSuper() {
    }

    protected void onResumeBeforeSuper() {

    }

    /**
     * 生成 P 对象
     */
    public void attachPresenter() {
        Annotation[] annotations = getClass().getAnnotations();
        if (annotations.length > 0) {
            for (Annotation annotation : annotations) {
                if (annotation instanceof RequirePresenter) {
                    RequirePresenter presenter = (RequirePresenter) annotation;
                    try {
                        mPresenter = (T) presenter.value().newInstance();
                        mPresenter.attachView(this);
                    } catch (java.lang.InstantiationException e) {
                        e.printStackTrace();
                        LogUtils.i(TAG, "SuperFragment : " + e.getMessage());
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                        LogUtils.i(TAG, "SuperFragment : " + e.getMessage());
                    }
                }
            }
        }
    }

    public T getPresenter() {
        return mPresenter;
    }

    /**
     * onDestroy final 避免被重写 可使用 beforeSuper 和 afterSuper
     */
    @Override
    public final void onDestroy() {
        onDestroyBeforeSuper();
        super.onDestroy();
        if (mPresenter != null) {
            mPresenter.onDestroy();
        }
        mPresenter = null;
        ButterKnife.unbind(this);
        onDestroyAfterSuper();
    }

    protected void onDestroyAfterSuper() {
    }

    protected void onDestroyBeforeSuper() {
    }


}
