package com.yfanads.android.libs.thirdpart.lottie.model.animatable;

import com.yfanads.android.libs.thirdpart.lottie.animation.keyframe.TextKeyframeAnimation;
import com.yfanads.android.libs.thirdpart.lottie.model.DocumentData;
import com.yfanads.android.libs.thirdpart.lottie.value.Keyframe;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public class AnimatableTextFrame extends BaseAnimatableValue<DocumentData, DocumentData> {
    public AnimatableTextFrame(List<Keyframe<DocumentData>> list) {
        super((List) list);
    }

    @Override // com.yfanads.android.libs.thirdpart.lottie.model.animatable.AnimatableValue
    public TextKeyframeAnimation createAnimation() {
        return new TextKeyframeAnimation(this.keyframes);
    }

    @Override // com.yfanads.android.libs.thirdpart.lottie.model.animatable.BaseAnimatableValue
    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }
}
