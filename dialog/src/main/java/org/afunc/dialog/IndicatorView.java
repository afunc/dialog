package org.afunc.dialog;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import org.afunc.dialog.indicator.*;

import java.util.Random;


/**
 * Created by Jack on 2015/10/15
 * <p>
 * .BallPulse,
 * .BallGridPulse,
 * .BallClipRotate,
 * .BallClipRotatePulse,
 * .SquareSpin,
 * .BallClipRotateMultiple,
 * .BallPulseRise,
 * .BallRotate,
 * .CubeTransition,
 * .BallZigZag,
 * .BallZigZagDeflect,
 * .BallTrianglePath,
 * .BallScale,
 * .LineScale,
 * .LineScaleParty,
 * .BallScaleMultiple,
 * .BallPulseSync,
 * .BallBeat,
 * .LineScalePulseOut,
 * .LineScalePulseOutRapid,
 * .BallScaleRipple,
 * .BallScaleRippleMultiple,
 * .BallSpinFadeLoader,
 * .LineSpinFadeLoader,
 * .TriangleSkewSpin,
 * .Pacman,
 * .BallGridBeat,
 * .SemiCircleSpin
 */

public class IndicatorView extends View {


    //indicators
    public static final int BallPulse = 0;
    public static final int BallGridPulse = 1;
    public static final int BallClipRotate = 2;
    public static final int BallClipRotatePulse = 3;
    public static final int SquareSpin = 4;
    public static final int BallClipRotateMultiple = 5;
    public static final int BallPulseRise = 6;
    public static final int BallRotate = 7;
    public static final int CubeTransition = 8;
    public static final int BallZigZag = 9;
    public static final int BallZigZagDeflect = 10;
    public static final int BallTrianglePath = 11;
    public static final int BallScale = 12;
    public static final int LineScale = 13;
    public static final int LineScaleParty = 14;
    public static final int BallScaleMultiple = 15;
    public static final int BallPulseSync = 16;
    public static final int BallBeat = 17;
    public static final int LineScalePulseOut = 18;
    public static final int LineScalePulseOutRapid = 19;
    public static final int BallScaleRipple = 20;
    public static final int BallScaleRippleMultiple = 21;
    public static final int BallSpinFadeLoader = 22;
    public static final int LineSpinFadeLoader = 23;
    public static final int TriangleSkewSpin = 24;
    /**
     * 吃豆人
     */
    public static final int Pacman = 25;
    public static final int BallGridBeat = 26;
    public static final int SemiCircleSpin = 27;

    //attrs
    private int mIndicatorId;
    private int mIndicatorColor;
    private Paint mPaint;
    private BaseIndicatorController mIndicatorController;
    private boolean mHasAnimation;
    private Callback callback;
    private Random random;

    public IndicatorView(Context context) {
        this(context, null);
    }

    public IndicatorView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public IndicatorView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(attrs);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public IndicatorView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(attrs);
    }


    /**
     * @param isRandomIndicator the Indicator will be random if set true
     */
    public void setRandomIndicator(boolean isRandomIndicator) {
        if (isRandomIndicator) {
            random = new Random();
        } else {
            random = null;
        }
    }


    private void init(AttributeSet attrs) {
        TypedArray a = getContext().obtainStyledAttributes(attrs, R.styleable.IndicatorView);
        mIndicatorId = a.getInt(R.styleable.IndicatorView_indicator, BallPulse);
        mIndicatorColor = a.getColor(R.styleable.IndicatorView_indicator_color, Color.WHITE);
        a.recycle();
        mPaint = new Paint();
        mPaint.setColor(mIndicatorColor);
        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setAntiAlias(true);
        applyIndicator();
    }

    /**
     * @param mIndicatorId choose one indicator
     */
    public void setmIndicatorId(@Indicator int mIndicatorId) {
        this.mIndicatorId = mIndicatorId;
        if (null != random)
            random = null;
        applyIndicator();
    }

    /**
     * @param mIndicatorColor set indicator color
     */
    public void setmIndicatorColor(int mIndicatorColor) {
        this.mIndicatorColor = mIndicatorColor;
        mPaint.setColor(mIndicatorColor);
    }

    /**
     * @param mPaint set a paint
     */
    public void setmPaint(Paint mPaint) {
        this.mPaint = mPaint;
    }

    /**
     * @param callback callback on layout change
     */
    void setCallback(Callback callback) {
        this.callback = callback;
    }

    private void applyIndicator() {
        switch (mIndicatorId) {
            case BallPulse:
                mIndicatorController = new BallPulseIndicator();
                break;
            case BallGridPulse:
                mIndicatorController = new BallGridPulseIndicator();
                break;
            case BallClipRotate:
                mIndicatorController = new BallClipRotateIndicator();
                break;
            case BallClipRotatePulse:
                mIndicatorController = new BallClipRotatePulseIndicator();
                break;
            case SquareSpin:
                mIndicatorController = new SquareSpinIndicator();
                break;
            case BallClipRotateMultiple:
                mIndicatorController = new BallClipRotateMultipleIndicator();
                break;
            case BallPulseRise:
                mIndicatorController = new BallPulseRiseIndicator();
                break;
            case BallRotate:
                mIndicatorController = new BallRotateIndicator();
                break;
            case CubeTransition:
                mIndicatorController = new CubeTransitionIndicator();
                break;
            case BallZigZag:
                mIndicatorController = new BallZigZagIndicator();
                break;
            case BallZigZagDeflect:
                mIndicatorController = new BallZigZagDeflectIndicator();
                break;
            case BallTrianglePath:
                mIndicatorController = new BallTrianglePathIndicator();
                break;
            case BallScale:
                mIndicatorController = new BallScaleIndicator();
                break;
            case LineScale:
                mIndicatorController = new LineScaleIndicator();
                break;
            case LineScaleParty:
                mIndicatorController = new LineScalePartyIndicator();
                break;
            case BallScaleMultiple:
                mIndicatorController = new BallScaleMultipleIndicator();
                break;
            case BallPulseSync:
                mIndicatorController = new BallPulseSyncIndicator();
                break;
            case BallBeat:
                mIndicatorController = new BallBeatIndicator();
                break;
            case LineScalePulseOut:
                mIndicatorController = new LineScalePulseOutIndicator();
                break;
            case LineScalePulseOutRapid:
                mIndicatorController = new LineScalePulseOutRapidIndicator();
                break;
            case BallScaleRipple:
                mIndicatorController = new BallScaleRippleIndicator();
                break;
            case BallScaleRippleMultiple:
                mIndicatorController = new BallScaleRippleMultipleIndicator();
                break;
            case BallSpinFadeLoader:
                mIndicatorController = new BallSpinFadeLoaderIndicator();
                break;
            case LineSpinFadeLoader:
                mIndicatorController = new LineSpinFadeLoaderIndicator();
                break;
            case TriangleSkewSpin:
                mIndicatorController = new TriangleSkewSpinIndicator();
                break;
            case Pacman:
                mIndicatorController = new PacmanIndicator();
                break;
            case BallGridBeat:
                mIndicatorController = new BallGridBeatIndicator();
                break;
            case SemiCircleSpin:
                mIndicatorController = new SemiCircleSpinIndicator();
                break;
            default:
                mIndicatorController = new SemiCircleSpinIndicator();
                break;

        }
        mIndicatorController.setTarget(this);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int DEFAULT_SIZE = 50;
        int width = measureDimension(dp2px(DEFAULT_SIZE), widthMeasureSpec);
        int height = measureDimension(dp2px(DEFAULT_SIZE), heightMeasureSpec);

        width = height = Math.min(width, height);
        setMeasuredDimension(width, height);
    }

    private int measureDimension(int defaultSize, int measureSpec) {
        int result;
        int specMode = MeasureSpec.getMode(measureSpec);
        int specSize = MeasureSpec.getSize(measureSpec);
        if (specMode == MeasureSpec.EXACTLY) {
            result = specSize;
        } else if (specMode == MeasureSpec.AT_MOST) {
            result = Math.min(defaultSize, specSize);
        } else {
            result = defaultSize;
        }
        return result;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        drawIndicator(canvas);
    }

    @Override
    public void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        if (!changed) {
            if (null != callback)
                callback.onLayoutChange();
        } else {
            if (!mHasAnimation) {
                mHasAnimation = true;
                if (null != random) {
                    mIndicatorId = random.nextInt(28);
                    mIndicatorController = null;
                    applyIndicator();
                }
            }
        }
        applyAnimation();
    }

    private void drawIndicator(Canvas canvas) {
        mIndicatorController.draw(canvas, mPaint);
    }

    private void applyAnimation() {
        mIndicatorController.createAnimation();
    }

    private int dp2px(int dpValue) {
        return (int) getContext().getResources().getDisplayMetrics().density * dpValue;
    }

    protected interface Callback {
        void onLayoutChange();
    }
}
