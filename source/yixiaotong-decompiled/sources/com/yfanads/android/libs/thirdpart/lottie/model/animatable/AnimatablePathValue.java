package com.yfanads.android.libs.thirdpart.lottie.model.animatable;

import android.graphics.PointF;
import com.yfanads.android.libs.thirdpart.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.yfanads.android.libs.thirdpart.lottie.animation.keyframe.PathKeyframeAnimation;
import com.yfanads.android.libs.thirdpart.lottie.animation.keyframe.PointKeyframeAnimation;
import com.yfanads.android.libs.thirdpart.lottie.value.Keyframe;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public class AnimatablePathValue implements AnimatableValue<PointF, PointF> {
    private final List<Keyframe<PointF>> keyframes;

    public AnimatablePathValue() {
        this.keyframes = Collections.singletonList(new Keyframe(new PointF(0.0f, 0.0f)));
    }

    public AnimatablePathValue(List<Keyframe<PointF>> list) {
        this.keyframes = list;
    }

    @Override // com.yfanads.android.libs.thirdpart.lottie.model.animatable.AnimatableValue
    public BaseKeyframeAnimation<PointF, PointF> createAnimation() {
        return this.keyframes.get(0).isStatic() ? new PointKeyframeAnimation(this.keyframes) : new PathKeyframeAnimation(this.keyframes);
    }
}
