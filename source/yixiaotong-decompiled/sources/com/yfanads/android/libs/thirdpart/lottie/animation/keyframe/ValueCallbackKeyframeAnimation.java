package com.yfanads.android.libs.thirdpart.lottie.animation.keyframe;

import com.yfanads.android.libs.thirdpart.lottie.value.Keyframe;
import com.yfanads.android.libs.thirdpart.lottie.value.LottieFrameInfo;
import com.yfanads.android.libs.thirdpart.lottie.value.LottieValueCallback;
import java.util.Collections;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public class ValueCallbackKeyframeAnimation<K, A> extends BaseKeyframeAnimation<K, A> {
    private final LottieFrameInfo<A> frameInfo;

    public ValueCallbackKeyframeAnimation(LottieValueCallback<A> lottieValueCallback) {
        super(Collections.emptyList());
        this.frameInfo = new LottieFrameInfo<>();
        setValueCallback(lottieValueCallback);
    }

    @Override // com.yfanads.android.libs.thirdpart.lottie.animation.keyframe.BaseKeyframeAnimation
    public float getEndProgress() {
        return 1.0f;
    }

    @Override // com.yfanads.android.libs.thirdpart.lottie.animation.keyframe.BaseKeyframeAnimation
    public A getValue() {
        return this.valueCallback.getValueInternal(0.0f, 0.0f, null, null, getProgress(), getProgress(), getProgress());
    }

    @Override // com.yfanads.android.libs.thirdpart.lottie.animation.keyframe.BaseKeyframeAnimation
    public A getValue(Keyframe<K> keyframe, float f) {
        return getValue();
    }

    @Override // com.yfanads.android.libs.thirdpart.lottie.animation.keyframe.BaseKeyframeAnimation
    public void notifyListeners() {
        if (this.valueCallback != null) {
            super.notifyListeners();
        }
    }
}
