package org.afunc.android.mvp;

import java.lang.annotation.*;

/**
 * MVP模型中的presenter层，通过getView()方法直接调用对应的activity（View层）
 *
 * 继承SuperPresenter 必须保留一个无参的构造方法
 *
 * Created by linlongxin on 2016/8/16.
 */
@Documented
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface RequirePresenter {
    Class<?> value();
}
