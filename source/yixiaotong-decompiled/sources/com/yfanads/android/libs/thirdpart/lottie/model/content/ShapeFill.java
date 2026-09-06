package com.yfanads.android.libs.thirdpart.lottie.model.content;

import android.graphics.Path;
import com.yfanads.android.libs.thirdpart.lottie.LottieDrawable;
import com.yfanads.android.libs.thirdpart.lottie.animation.content.Content;
import com.yfanads.android.libs.thirdpart.lottie.animation.content.FillContent;
import com.yfanads.android.libs.thirdpart.lottie.model.animatable.AnimatableColorValue;
import com.yfanads.android.libs.thirdpart.lottie.model.animatable.AnimatableIntegerValue;
import com.yfanads.android.libs.thirdpart.lottie.model.layer.BaseLayer;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public class ShapeFill implements ContentModel {
    private final AnimatableColorValue color;
    private final boolean fillEnabled;
    private final Path.FillType fillType;
    private final String name;
    private final AnimatableIntegerValue opacity;

    public ShapeFill(String str, boolean z, Path.FillType fillType, AnimatableColorValue animatableColorValue, AnimatableIntegerValue animatableIntegerValue) {
        this.name = str;
        this.fillEnabled = z;
        this.fillType = fillType;
        this.color = animatableColorValue;
        this.opacity = animatableIntegerValue;
    }

    public AnimatableColorValue getColor() {
        return this.color;
    }

    public Path.FillType getFillType() {
        return this.fillType;
    }

    public String getName() {
        return this.name;
    }

    public AnimatableIntegerValue getOpacity() {
        return this.opacity;
    }

    @Override // com.yfanads.android.libs.thirdpart.lottie.model.content.ContentModel
    public Content toContent(LottieDrawable lottieDrawable, BaseLayer baseLayer) {
        return new FillContent(lottieDrawable, baseLayer, this);
    }

    public String toString() {
        return "ShapeFill{color=, fillEnabled=" + this.fillEnabled + '}';
    }
}
