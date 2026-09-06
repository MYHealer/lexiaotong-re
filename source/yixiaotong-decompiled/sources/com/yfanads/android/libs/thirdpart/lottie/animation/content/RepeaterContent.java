package com.yfanads.android.libs.thirdpart.lottie.animation.content;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.RectF;
import com.yfanads.android.libs.thirdpart.lottie.LottieDrawable;
import com.yfanads.android.libs.thirdpart.lottie.LottieProperty;
import com.yfanads.android.libs.thirdpart.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.yfanads.android.libs.thirdpart.lottie.animation.keyframe.TransformKeyframeAnimation;
import com.yfanads.android.libs.thirdpart.lottie.model.KeyPath;
import com.yfanads.android.libs.thirdpart.lottie.model.content.Repeater;
import com.yfanads.android.libs.thirdpart.lottie.model.layer.BaseLayer;
import com.yfanads.android.libs.thirdpart.lottie.utils.MiscUtils;
import com.yfanads.android.libs.thirdpart.lottie.value.LottieValueCallback;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public class RepeaterContent implements DrawingContent, PathContent, GreedyContent, BaseKeyframeAnimation.AnimationListener, KeyPathElementContent {
    private ContentGroup contentGroup;
    private final BaseKeyframeAnimation<Float, Float> copies;
    private final BaseLayer layer;
    private final LottieDrawable lottieDrawable;
    private final String name;
    private final BaseKeyframeAnimation<Float, Float> offset;
    private final TransformKeyframeAnimation transform;
    private final Matrix matrix = new Matrix();
    private final Path path = new Path();

    public RepeaterContent(LottieDrawable lottieDrawable, BaseLayer baseLayer, Repeater repeater) {
        this.lottieDrawable = lottieDrawable;
        this.layer = baseLayer;
        this.name = repeater.getName();
        BaseKeyframeAnimation<Float, Float> baseKeyframeAnimationCreateAnimation = repeater.getCopies().createAnimation();
        this.copies = baseKeyframeAnimationCreateAnimation;
        baseLayer.addAnimation(baseKeyframeAnimationCreateAnimation);
        baseKeyframeAnimationCreateAnimation.addUpdateListener(this);
        BaseKeyframeAnimation<Float, Float> baseKeyframeAnimationCreateAnimation2 = repeater.getOffset().createAnimation();
        this.offset = baseKeyframeAnimationCreateAnimation2;
        baseLayer.addAnimation(baseKeyframeAnimationCreateAnimation2);
        baseKeyframeAnimationCreateAnimation2.addUpdateListener(this);
        TransformKeyframeAnimation transformKeyframeAnimationCreateAnimation = repeater.getTransform().createAnimation();
        this.transform = transformKeyframeAnimationCreateAnimation;
        transformKeyframeAnimationCreateAnimation.addAnimationsToLayer(baseLayer);
        transformKeyframeAnimationCreateAnimation.addListener(this);
    }

    @Override // com.yfanads.android.libs.thirdpart.lottie.animation.content.GreedyContent
    public void absorbContent(ListIterator<Content> listIterator) {
        if (this.contentGroup != null) {
            return;
        }
        while (listIterator.hasPrevious() && listIterator.previous() != this) {
        }
        ArrayList arrayList = new ArrayList();
        while (listIterator.hasPrevious()) {
            arrayList.add(listIterator.previous());
            listIterator.remove();
        }
        Collections.reverse(arrayList);
        this.contentGroup = new ContentGroup(this.lottieDrawable, this.layer, "Repeater", arrayList, null);
    }

    @Override // com.yfanads.android.libs.thirdpart.lottie.model.KeyPathElement
    public <T> void addValueCallback(T t, LottieValueCallback<T> lottieValueCallback) {
        BaseKeyframeAnimation<Float, Float> baseKeyframeAnimation;
        if (this.transform.applyValueCallback(t, lottieValueCallback)) {
            return;
        }
        if (t == LottieProperty.REPEATER_COPIES) {
            baseKeyframeAnimation = this.copies;
        } else if (t != LottieProperty.REPEATER_OFFSET) {
            return;
        } else {
            baseKeyframeAnimation = this.offset;
        }
        baseKeyframeAnimation.setValueCallback(lottieValueCallback);
    }

    @Override // com.yfanads.android.libs.thirdpart.lottie.animation.content.DrawingContent
    public void draw(Canvas canvas, Matrix matrix, int i) {
        float fFloatValue = this.copies.getValue().floatValue();
        float fFloatValue2 = this.offset.getValue().floatValue();
        float fFloatValue3 = this.transform.getStartOpacity().getValue().floatValue() / 100.0f;
        float fFloatValue4 = this.transform.getEndOpacity().getValue().floatValue() / 100.0f;
        for (int i2 = ((int) fFloatValue) - 1; i2 >= 0; i2--) {
            this.matrix.set(matrix);
            float f = i2;
            this.matrix.preConcat(this.transform.getMatrixForRepeater(f + fFloatValue2));
            this.contentGroup.draw(canvas, this.matrix, (int) (MiscUtils.lerp(fFloatValue3, fFloatValue4, f / fFloatValue) * i));
        }
    }

    @Override // com.yfanads.android.libs.thirdpart.lottie.animation.content.DrawingContent
    public void getBounds(RectF rectF, Matrix matrix) {
        this.contentGroup.getBounds(rectF, matrix);
    }

    @Override // com.yfanads.android.libs.thirdpart.lottie.animation.content.Content
    public String getName() {
        return this.name;
    }

    @Override // com.yfanads.android.libs.thirdpart.lottie.animation.content.PathContent
    public Path getPath() {
        Path path = this.contentGroup.getPath();
        this.path.reset();
        float fFloatValue = this.copies.getValue().floatValue();
        float fFloatValue2 = this.offset.getValue().floatValue();
        for (int i = ((int) fFloatValue) - 1; i >= 0; i--) {
            this.matrix.set(this.transform.getMatrixForRepeater(i + fFloatValue2));
            this.path.addPath(path, this.matrix);
        }
        return this.path;
    }

    @Override // com.yfanads.android.libs.thirdpart.lottie.animation.keyframe.BaseKeyframeAnimation.AnimationListener
    public void onValueChanged() {
        this.lottieDrawable.invalidateSelf();
    }

    @Override // com.yfanads.android.libs.thirdpart.lottie.model.KeyPathElement
    public void resolveKeyPath(KeyPath keyPath, int i, List<KeyPath> list, KeyPath keyPath2) {
        MiscUtils.resolveKeyPath(keyPath, i, list, keyPath2, this);
    }

    @Override // com.yfanads.android.libs.thirdpart.lottie.animation.content.Content
    public void setContents(List<Content> list, List<Content> list2) {
        this.contentGroup.setContents(list, list2);
    }
}
