package com.yfanads.android.libs.thirdpart.lottie.animation.keyframe;

import com.yfanads.android.libs.thirdpart.lottie.model.content.GradientColor;
import com.yfanads.android.libs.thirdpart.lottie.value.Keyframe;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public class GradientColorKeyframeAnimation extends KeyframeAnimation<GradientColor> {
    private final GradientColor gradientColor;

    public GradientColorKeyframeAnimation(List<Keyframe<GradientColor>> list) {
        super(list);
        GradientColor gradientColor = list.get(0).startValue;
        int size = gradientColor != null ? gradientColor.getSize() : 0;
        this.gradientColor = new GradientColor(new float[size], new int[size]);
    }

    @Override // com.yfanads.android.libs.thirdpart.lottie.animation.keyframe.BaseKeyframeAnimation
    public GradientColor getValue(Keyframe<GradientColor> keyframe, float f) {
        this.gradientColor.lerp(keyframe.startValue, keyframe.endValue, f);
        return this.gradientColor;
    }

    @Override // com.yfanads.android.libs.thirdpart.lottie.animation.keyframe.BaseKeyframeAnimation
    public /* bridge */ /* synthetic */ Object getValue(Keyframe keyframe, float f) {
        return getValue((Keyframe<GradientColor>) keyframe, f);
    }
}
