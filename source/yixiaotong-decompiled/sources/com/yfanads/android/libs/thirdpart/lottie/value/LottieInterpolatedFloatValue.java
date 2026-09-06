package com.yfanads.android.libs.thirdpart.lottie.value;

import android.view.animation.Interpolator;
import com.yfanads.android.libs.thirdpart.lottie.utils.MiscUtils;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public class LottieInterpolatedFloatValue extends LottieInterpolatedValue<Float> {
    public LottieInterpolatedFloatValue(Float f, Float f2) {
        super(f, f2);
    }

    public LottieInterpolatedFloatValue(Float f, Float f2, Interpolator interpolator) {
        super(f, f2, interpolator);
    }

    @Override // com.yfanads.android.libs.thirdpart.lottie.value.LottieInterpolatedValue, com.yfanads.android.libs.thirdpart.lottie.value.LottieValueCallback
    public /* bridge */ /* synthetic */ Object getValue(LottieFrameInfo lottieFrameInfo) {
        return super.getValue(lottieFrameInfo);
    }

    @Override // com.yfanads.android.libs.thirdpart.lottie.value.LottieInterpolatedValue
    public Float interpolateValue(Float f, Float f2, float f3) {
        return Float.valueOf(MiscUtils.lerp(f.floatValue(), f2.floatValue(), f3));
    }
}
