package com.yfanads.android.libs.thirdpart.lottie.animation.keyframe;

import android.graphics.Path;
import android.graphics.PointF;
import com.yfanads.android.libs.thirdpart.lottie.LottieComposition;
import com.yfanads.android.libs.thirdpart.lottie.utils.Utils;
import com.yfanads.android.libs.thirdpart.lottie.value.Keyframe;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public class PathKeyframe extends Keyframe<PointF> {
    private Path path;

    /* JADX WARN: Code duplicated, block: B:9:0x002d  */
    /* JADX WARN: Multi-variable type inference failed */
    public PathKeyframe(LottieComposition lottieComposition, Keyframe<PointF> keyframe) {
        boolean z;
        T t;
        super(lottieComposition, keyframe.startValue, keyframe.endValue, keyframe.interpolator, keyframe.startFrame, keyframe.endFrame);
        T t2 = this.endValue;
        if (t2 == 0 || (t = this.startValue) == 0) {
            z = false;
        } else {
            PointF pointF = (PointF) t2;
            if (((PointF) t).equals(pointF.x, pointF.y)) {
                z = true;
            } else {
                z = false;
            }
        }
        T t3 = this.endValue;
        if (t3 == 0 || z) {
            return;
        }
        this.path = Utils.createPath((PointF) this.startValue, (PointF) t3, keyframe.pathCp1, keyframe.pathCp2);
    }

    public Path getPath() {
        return this.path;
    }
}
