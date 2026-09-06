package com.yfanads.android.libs.thirdpart.lottie.model.content;

import com.yfanads.android.libs.thirdpart.lottie.LottieDrawable;
import com.yfanads.android.libs.thirdpart.lottie.animation.content.Content;
import com.yfanads.android.libs.thirdpart.lottie.animation.content.ContentGroup;
import com.yfanads.android.libs.thirdpart.lottie.model.layer.BaseLayer;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public class ShapeGroup implements ContentModel {
    private final List<ContentModel> items;
    private final String name;

    public ShapeGroup(String str, List<ContentModel> list) {
        this.name = str;
        this.items = list;
    }

    public List<ContentModel> getItems() {
        return this.items;
    }

    public String getName() {
        return this.name;
    }

    @Override // com.yfanads.android.libs.thirdpart.lottie.model.content.ContentModel
    public Content toContent(LottieDrawable lottieDrawable, BaseLayer baseLayer) {
        return new ContentGroup(lottieDrawable, baseLayer, this);
    }

    public String toString() {
        return "ShapeGroup{name='" + this.name + "' Shapes: " + Arrays.toString(this.items.toArray()) + '}';
    }
}
