package com.yfanads.android.libs.thirdpart.lottie.animation.keyframe;

import com.yfanads.android.libs.thirdpart.lottie.model.DocumentData;
import com.yfanads.android.libs.thirdpart.lottie.value.Keyframe;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public class TextKeyframeAnimation extends KeyframeAnimation<DocumentData> {
    public TextKeyframeAnimation(List<Keyframe<DocumentData>> list) {
        super(list);
    }

    @Override // com.yfanads.android.libs.thirdpart.lottie.animation.keyframe.BaseKeyframeAnimation
    public DocumentData getValue(Keyframe<DocumentData> keyframe, float f) {
        return keyframe.startValue;
    }

    @Override // com.yfanads.android.libs.thirdpart.lottie.animation.keyframe.BaseKeyframeAnimation
    public /* bridge */ /* synthetic */ Object getValue(Keyframe keyframe, float f) {
        return getValue((Keyframe<DocumentData>) keyframe, f);
    }
}
