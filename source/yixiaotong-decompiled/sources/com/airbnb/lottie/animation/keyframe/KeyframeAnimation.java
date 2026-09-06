package com.airbnb.lottie.animation.keyframe;

import com.airbnb.lottie.value.Keyframe;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
abstract class KeyframeAnimation<T> extends BaseKeyframeAnimation<T, T> {
    KeyframeAnimation(List<? extends Keyframe<T>> list) {
        super(list);
    }
}
