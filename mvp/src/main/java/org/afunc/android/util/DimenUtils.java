package org.afunc.android.util;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.graphics.Point;
import android.os.Build;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.Display;
import android.view.WindowManager;


/**
 * Created by 紫紫 on 2017/8/7
 * Q157596462@outlook.com
 * 描述：单位转换类
 */
public class DimenUtils {

	/**
	 * dp转px
	 * 
	 * @param context
	 * @param dpVal
	 * @return
	 */
	public static int dp2px(Context context, float dpVal) {
		return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dpVal, context.getResources().getDisplayMetrics());
	}

	/**
	 * sp转px
	 * 
	 * @param context
	 * @param spVal
	 * @return
	 */
	public static int sp2px(Context context, float spVal) {
		return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, spVal, context.getResources().getDisplayMetrics());
	}

	/**
	 * px转dp
	 * 
	 * @param context
	 * @param pxVal
	 * @return
	 */
	public static float px2dp(Context context, float pxVal) {
		final float scale = context.getResources().getDisplayMetrics().density;
		return (pxVal / scale);
	}

	/**
	 * px转sp
	 * 
	 * @param context
	 * @param pxVal
	 * @return
	 */
	public static float px2sp(Context context, float pxVal) {
		return (pxVal / context.getResources().getDisplayMetrics().scaledDensity);
	}

	/**
	 * 获取屏幕尺寸
	 */
	@SuppressWarnings("deprecation")
	@TargetApi(Build.VERSION_CODES.HONEYCOMB_MR2)
	public static Point getScreenSize(Context context){
		WindowManager windowManager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
		Display display = windowManager.getDefaultDisplay();
		if(Build.VERSION.SDK_INT < Build.VERSION_CODES.HONEYCOMB_MR2){
			return new Point(display.getWidth(), display.getHeight());
		}else{
			Point point = new Point();
			display.getSize(point);
			return point;
		}
	}

	private static int[] deviceWidthHeight = new int[2];

	public static int[] getDeviceInfo(Context context) {
		if ((deviceWidthHeight[0] == 0) && (deviceWidthHeight[1] == 0)) {
			DisplayMetrics metrics = new DisplayMetrics();
			((Activity) context).getWindowManager().getDefaultDisplay()
					.getMetrics(metrics);

			deviceWidthHeight[0] = metrics.widthPixels;
			deviceWidthHeight[1] = metrics.heightPixels;
		}
		return deviceWidthHeight;
	}
}
