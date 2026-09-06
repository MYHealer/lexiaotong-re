package com.yfanads.android.libs.thirdpart.lottie.model.animatable;

import com.yfanads.android.libs.thirdpart.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.yfanads.android.libs.thirdpart.lottie.animation.keyframe.IntegerKeyframeAnimation;
import com.yfanads.android.libs.thirdpart.lottie.value.Keyframe;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public class AnimatableIntegerValue extends BaseAnimatableValue<Integer, Integer> {
    public AnimatableIntegerValue() {
        super(100);
    }

    public AnimatableIntegerValue(List<Keyframe<Integer>> list) {
        super((List) list);
    }

    @Override // com.yfanads.android.libs.thirdpart.lottie.model.animatable.AnimatableValue
    public BaseKeyframeAnimation<Integer, Integer> createAnimation() {
        return new IntegerKeyframeAnimation(this.keyframes);
    }

    @Override // com.yfanads.android.libs.thirdpart.lottie.model.animatable.BaseAnimatableValue
    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }
}
