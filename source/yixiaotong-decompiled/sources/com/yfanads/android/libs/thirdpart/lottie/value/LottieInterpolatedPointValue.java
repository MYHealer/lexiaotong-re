package com.yfanads.android.libs.thirdpart.lottie.value;

import android.graphics.PointF;
import android.view.animation.Interpolator;
import com.yfanads.android.libs.thirdpart.lottie.utils.MiscUtils;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public class LottieInterpolatedPointValue extends LottieInterpolatedValue<PointF> {
    private final PointF point;

    public LottieInterpolatedPointValue(PointF pointF, PointF pointF2) {
        super(pointF, pointF2);
        this.point = new PointF();
    }

    public LottieInterpolatedPointValue(PointF pointF, PointF pointF2, Interpolator interpolator) {
        super(pointF, pointF2, interpolator);
        this.point = new PointF();
    }

    @Override // com.yfanads.android.libs.thirdpart.lottie.value.LottieInterpolatedValue, com.yfanads.android.libs.thirdpart.lottie.value.LottieValueCallback
    public /* bridge */ /* synthetic */ Object getValue(LottieFrameInfo lottieFrameInfo) {
        return super.getValue(lottieFrameInfo);
    }

    @Override // com.yfanads.android.libs.thirdpart.lottie.value.LottieInterpolatedValue
    public PointF interpolateValue(PointF pointF, PointF pointF2, float f) {
        this.point.set(MiscUtils.lerp(pointF.x, pointF2.x, f), MiscUtils.lerp(pointF.y, pointF2.y, f));
        return this.point;
    }
}
