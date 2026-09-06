package androidx.constraintlayout.motion.widget;

import android.graphics.Canvas;
import android.view.View;
import java.util.HashMap;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6847780.dex */
public interface MotionHelperInterface extends Animatable, MotionLayout.TransitionListener {
    boolean isDecorator();

    boolean isUseOnHide();

    boolean isUsedOnShow();

    void onFinishedMotionScene(MotionLayout motionLayout);

    void onPostDraw(Canvas canvas);

    void onPreDraw(Canvas canvas);

    void onPreSetup(MotionLayout motionLayout, HashMap<View, MotionController> map);
}
