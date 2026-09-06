package com.yfanads.android.libs.thirdpart.lottie.model.animatable;

import android.graphics.PointF;
import com.yfanads.android.libs.thirdpart.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.yfanads.android.libs.thirdpart.lottie.animation.keyframe.PointKeyframeAnimation;
import com.yfanads.android.libs.thirdpart.lottie.value.Keyframe;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public class AnimatablePointValue extends BaseAnimatableValue<PointF, PointF> {
    public AnimatablePointValue(List<Keyframe<PointF>> list) {
        super((List) list);
    }

    @Override // com.yfanads.android.libs.thirdpart.lottie.model.animatable.AnimatableValue
    public BaseKeyframeAnimation<PointF, PointF> createAnimation() {
        return new PointKeyframeAnimation(this.keyframes);
    }

    @Override // com.yfanads.android.libs.thirdpart.lottie.model.animatable.BaseAnimatableValue
    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }
}
