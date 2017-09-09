package org.afunc.weiget.loader.indicator;

import android.support.annotation.IntDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import static org.afunc.weiget.loader.IndicatorView.*;

/**
 * <li>Created by 紫紫 on 2017/9/8</li>
 * <li>Q157596462@outlook.com</li>
 * <li>描述：</li>
 */

@Retention(RetentionPolicy.SOURCE)
@IntDef(flag = true,
        value = {
                BallPulse,
                BallGridPulse,
                BallClipRotate,
                BallClipRotatePulse,
                SquareSpin,
                BallClipRotateMultiple,
                BallPulseRise,
                BallRotate,
                CubeTransition,
                BallZigZag,
                BallZigZagDeflect,
                BallTrianglePath,
                BallScale,
                LineScale,
                LineScaleParty,
                BallScaleMultiple,
                BallPulseSync,
                BallBeat,
                LineScalePulseOut,
                LineScalePulseOutRapid,
                BallScaleRipple,
                BallScaleRippleMultiple,
                BallSpinFadeLoader,
                LineSpinFadeLoader,
                TriangleSkewSpin,
                Pacman,
                BallGridBeat,
                SemiCircleSpin
        })
public @interface Indicator {

}