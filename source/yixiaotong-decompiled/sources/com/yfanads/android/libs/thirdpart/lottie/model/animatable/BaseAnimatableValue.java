package com.yfanads.android.libs.thirdpart.lottie.model.animatable;

import com.yfanads.android.libs.thirdpart.lottie.value.Keyframe;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
abstract class BaseAnimatableValue<V, O> implements AnimatableValue<V, O> {
    final List<Keyframe<V>> keyframes;

    public BaseAnimatableValue(V v) {
        this(Collections.singletonList(new Keyframe(v)));
    }

    public BaseAnimatableValue(List<Keyframe<V>> list) {
        this.keyframes = list;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (!this.keyframes.isEmpty()) {
            sb.append("values=").append(Arrays.toString(this.keyframes.toArray()));
        }
        return sb.toString();
    }
}
