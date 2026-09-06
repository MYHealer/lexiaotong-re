package com.yfanads.android.libs.thirdpart.lottie.animation.content;

import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RectF;
import com.yfanads.android.libs.thirdpart.lottie.LottieDrawable;
import com.yfanads.android.libs.thirdpart.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.yfanads.android.libs.thirdpart.lottie.model.KeyPath;
import com.yfanads.android.libs.thirdpart.lottie.model.content.RectangleShape;
import com.yfanads.android.libs.thirdpart.lottie.model.content.ShapeTrimPath;
import com.yfanads.android.libs.thirdpart.lottie.model.layer.BaseLayer;
import com.yfanads.android.libs.thirdpart.lottie.utils.MiscUtils;
import com.yfanads.android.libs.thirdpart.lottie.utils.Utils;
import com.yfanads.android.libs.thirdpart.lottie.value.LottieValueCallback;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public class RectangleContent implements BaseKeyframeAnimation.AnimationListener, KeyPathElementContent, PathContent {
    private final BaseKeyframeAnimation<?, Float> cornerRadiusAnimation;
    private boolean isPathValid;
    private final LottieDrawable lottieDrawable;
    private final String name;
    private final BaseKeyframeAnimation<?, PointF> positionAnimation;
    private final BaseKeyframeAnimation<?, PointF> sizeAnimation;
    private TrimPathContent trimPath;
    private final Path path = new Path();
    private final RectF rect = new RectF();

    public RectangleContent(LottieDrawable lottieDrawable, BaseLayer baseLayer, RectangleShape rectangleShape) {
        this.name = rectangleShape.getName();
        this.lottieDrawable = lottieDrawable;
        BaseKeyframeAnimation<PointF, PointF> baseKeyframeAnimationCreateAnimation = rectangleShape.getPosition().createAnimation();
        this.positionAnimation = baseKeyframeAnimationCreateAnimation;
        BaseKeyframeAnimation<PointF, PointF> baseKeyframeAnimationCreateAnimation2 = rectangleShape.getSize().createAnimation();
        this.sizeAnimation = baseKeyframeAnimationCreateAnimation2;
        BaseKeyframeAnimation<Float, Float> baseKeyframeAnimationCreateAnimation3 = rectangleShape.getCornerRadius().createAnimation();
        this.cornerRadiusAnimation = baseKeyframeAnimationCreateAnimation3;
        baseLayer.addAnimation(baseKeyframeAnimationCreateAnimation);
        baseLayer.addAnimation(baseKeyframeAnimationCreateAnimation2);
        baseLayer.addAnimation(baseKeyframeAnimationCreateAnimation3);
        baseKeyframeAnimationCreateAnimation.addUpdateListener(this);
        baseKeyframeAnimationCreateAnimation2.addUpdateListener(this);
        baseKeyframeAnimationCreateAnimation3.addUpdateListener(this);
    }

    private void invalidate() {
        this.isPathValid = false;
        this.lottieDrawable.invalidateSelf();
    }

    @Override // com.yfanads.android.libs.thirdpart.lottie.model.KeyPathElement
    public <T> void addValueCallback(T t, LottieValueCallback<T> lottieValueCallback) {
    }

    @Override // com.yfanads.android.libs.thirdpart.lottie.animation.content.Content
    public String getName() {
        return this.name;
    }

    @Override // com.yfanads.android.libs.thirdpart.lottie.animation.content.PathContent
    public Path getPath() {
        if (this.isPathValid) {
            return this.path;
        }
        this.path.reset();
        PointF value = this.sizeAnimation.getValue();
        float f = value.x / 2.0f;
        float f2 = value.y / 2.0f;
        BaseKeyframeAnimation<?, Float> baseKeyframeAnimation = this.cornerRadiusAnimation;
        float fFloatValue = baseKeyframeAnimation == null ? 0.0f : baseKeyframeAnimation.getValue().floatValue();
        float fMin = Math.min(f, f2);
        if (fFloatValue > fMin) {
            fFloatValue = fMin;
        }
        PointF value2 = this.positionAnimation.getValue();
        this.path.moveTo(value2.x + f, (value2.y - f2) + fFloatValue);
        this.path.lineTo(value2.x + f, (value2.y + f2) - fFloatValue);
        if (fFloatValue > 0.0f) {
            RectF rectF = this.rect;
            float f3 = value2.x + f;
            float f4 = fFloatValue * 2.0f;
            float f5 = value2.y + f2;
            rectF.set(f3 - f4, f5 - f4, f3, f5);
            this.path.arcTo(this.rect, 0.0f, 90.0f, false);
        }
        this.path.lineTo((value2.x - f) + fFloatValue, value2.y + f2);
        if (fFloatValue > 0.0f) {
            RectF rectF2 = this.rect;
            float f6 = value2.x - f;
            float f7 = value2.y + f2;
            float f8 = fFloatValue * 2.0f;
            rectF2.set(f6, f7 - f8, f8 + f6, f7);
            this.path.arcTo(this.rect, 90.0f, 90.0f, false);
        }
        this.path.lineTo(value2.x - f, (value2.y - f2) + fFloatValue);
        if (fFloatValue > 0.0f) {
            RectF rectF3 = this.rect;
            float f9 = value2.x - f;
            float f10 = value2.y - f2;
            float f11 = fFloatValue * 2.0f;
            rectF3.set(f9, f10, f9 + f11, f11 + f10);
            this.path.arcTo(this.rect, 180.0f, 90.0f, false);
        }
        this.path.lineTo((value2.x + f) - fFloatValue, value2.y - f2);
        if (fFloatValue > 0.0f) {
            RectF rectF4 = this.rect;
            float f12 = value2.x + f;
            float f13 = fFloatValue * 2.0f;
            float f14 = value2.y - f2;
            rectF4.set(f12 - f13, f14, f12, f13 + f14);
            this.path.arcTo(this.rect, 270.0f, 90.0f, false);
        }
        this.path.close();
        Utils.applyTrimPathIfNeeded(this.path, this.trimPath);
        this.isPathValid = true;
        return this.path;
    }

    @Override // com.yfanads.android.libs.thirdpart.lottie.animation.keyframe.BaseKeyframeAnimation.AnimationListener
    public void onValueChanged() {
        invalidate();
    }

    @Override // com.yfanads.android.libs.thirdpart.lottie.model.KeyPathElement
    public void resolveKeyPath(KeyPath keyPath, int i, List<KeyPath> list, KeyPath keyPath2) {
        MiscUtils.resolveKeyPath(keyPath, i, list, keyPath2, this);
    }

    @Override // com.yfanads.android.libs.thirdpart.lottie.animation.content.Content
    public void setContents(List<Content> list, List<Content> list2) {
        for (int i = 0; i < list.size(); i++) {
            Content content = list.get(i);
            if (content instanceof TrimPathContent) {
                TrimPathContent trimPathContent = (TrimPathContent) content;
                if (trimPathContent.getType() == ShapeTrimPath.Type.Simultaneously) {
                    this.trimPath = trimPathContent;
                    trimPathContent.addListener(this);
                }
            }
        }
    }
}
