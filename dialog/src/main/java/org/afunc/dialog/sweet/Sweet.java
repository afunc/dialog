package org.afunc.dialog.sweet;

import android.support.annotation.IntDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import static org.afunc.dialog.SweetAlertDialog.*;

/**
 * Created by 紫紫 on 9/10/17
 * Q157596462@outlook.com
 * 描述：
 */
@Retention(RetentionPolicy.SOURCE)
@IntDef(flag = true,
        value = {
                NORMAL_TYPE, ERROR_TYPE, SUCCESS_TYPE, WARNING_TYPE, CUSTOM_IMAGE_TYPE
        })
public @interface Sweet {
}
