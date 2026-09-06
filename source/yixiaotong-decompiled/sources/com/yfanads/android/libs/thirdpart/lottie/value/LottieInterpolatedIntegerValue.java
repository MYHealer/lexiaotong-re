package com.yfanads.android.libs.thirdpart.lottie.value;

import android.view.animation.Interpolator;
import com.yfanads.android.libs.thirdpart.lottie.utils.MiscUtils;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public class LottieInterpolatedIntegerValue extends LottieInterpolatedValue<Integer> {
    public LottieInterpolatedIntegerValue(Integer num, Integer num2) {
        super(num, num2);
    }

    public LottieInterpolatedIntegerValue(Integer num, Integer num2, Interpolator interpolator) {
        super(num, num2, interpolator);
    }

    @Override // com.yfanads.android.libs.thirdpart.lottie.value.LottieInterpolatedValue, com.yfanads.android.libs.thirdpart.lottie.value.LottieValueCallback
    public /* bridge */ /* synthetic */ Object getValue(LottieFrameInfo lottieFrameInfo) {
        return super.getValue(lottieFrameInfo);
    }

    @Override // com.yfanads.android.libs.thirdpart.lottie.value.LottieInterpolatedValue
    public Integer interpolateValue(Integer num, Integer num2, float f) {
        return Integer.valueOf(MiscUtils.lerp(num.intValue(), num2.intValue(), f));
    }
}
