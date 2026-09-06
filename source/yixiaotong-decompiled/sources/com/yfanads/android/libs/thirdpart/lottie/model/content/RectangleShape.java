package com.yfanads.android.libs.thirdpart.lottie.model.content;

import android.graphics.PointF;
import com.yfanads.android.libs.thirdpart.lottie.LottieDrawable;
import com.yfanads.android.libs.thirdpart.lottie.animation.content.Content;
import com.yfanads.android.libs.thirdpart.lottie.animation.content.RectangleContent;
import com.yfanads.android.libs.thirdpart.lottie.model.animatable.AnimatableFloatValue;
import com.yfanads.android.libs.thirdpart.lottie.model.animatable.AnimatablePointValue;
import com.yfanads.android.libs.thirdpart.lottie.model.animatable.AnimatableValue;
import com.yfanads.android.libs.thirdpart.lottie.model.layer.BaseLayer;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public class RectangleShape implements ContentModel {
    private final AnimatableFloatValue cornerRadius;
    private final String name;
    private final AnimatableValue<PointF, PointF> position;
    private final AnimatablePointValue size;

    public RectangleShape(String str, AnimatableValue<PointF, PointF> animatableValue, AnimatablePointValue animatablePointValue, AnimatableFloatValue animatableFloatValue) {
        this.name = str;
        this.position = animatableValue;
        this.size = animatablePointValue;
        this.cornerRadius = animatableFloatValue;
    }

    public AnimatableFloatValue getCornerRadius() {
        return this.cornerRadius;
    }

    public String getName() {
        return this.name;
    }

    public AnimatableValue<PointF, PointF> getPosition() {
        return this.position;
    }

    public AnimatablePointValue getSize() {
        return this.size;
    }

    @Override // com.yfanads.android.libs.thirdpart.lottie.model.content.ContentModel
    public Content toContent(LottieDrawable lottieDrawable, BaseLayer baseLayer) {
        return new RectangleContent(lottieDrawable, baseLayer, this);
    }

    public String toString() {
        return "RectangleShape{position=" + this.position + ", size=" + this.size + '}';
    }
}
