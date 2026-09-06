package com.yfanads.android.libs.thirdpart.lottie.animation.content;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import com.yfanads.android.libs.thirdpart.lottie.LottieDrawable;
import com.yfanads.android.libs.thirdpart.lottie.LottieProperty;
import com.yfanads.android.libs.thirdpart.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.yfanads.android.libs.thirdpart.lottie.animation.keyframe.ValueCallbackKeyframeAnimation;
import com.yfanads.android.libs.thirdpart.lottie.model.content.ShapeStroke;
import com.yfanads.android.libs.thirdpart.lottie.model.layer.BaseLayer;
import com.yfanads.android.libs.thirdpart.lottie.value.LottieValueCallback;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public class StrokeContent extends BaseStrokeContent {
    private final BaseKeyframeAnimation<Integer, Integer> colorAnimation;
    private BaseKeyframeAnimation<ColorFilter, ColorFilter> colorFilterAnimation;
    private final BaseLayer layer;
    private final String name;

    public StrokeContent(LottieDrawable lottieDrawable, BaseLayer baseLayer, ShapeStroke shapeStroke) {
        super(lottieDrawable, baseLayer, shapeStroke.getCapType().toPaintCap(), shapeStroke.getJoinType().toPaintJoin(), shapeStroke.getMiterLimit(), shapeStroke.getOpacity(), shapeStroke.getWidth(), shapeStroke.getLineDashPattern(), shapeStroke.getDashOffset());
        this.layer = baseLayer;
        this.name = shapeStroke.getName();
        BaseKeyframeAnimation<Integer, Integer> baseKeyframeAnimationCreateAnimation = shapeStroke.getColor().createAnimation();
        this.colorAnimation = baseKeyframeAnimationCreateAnimation;
        baseKeyframeAnimationCreateAnimation.addUpdateListener(this);
        baseLayer.addAnimation(baseKeyframeAnimationCreateAnimation);
    }

    @Override // com.yfanads.android.libs.thirdpart.lottie.animation.content.BaseStrokeContent, com.yfanads.android.libs.thirdpart.lottie.model.KeyPathElement
    public <T> void addValueCallback(T t, LottieValueCallback<T> lottieValueCallback) {
        super.addValueCallback(t, lottieValueCallback);
        if (t == LottieProperty.STROKE_COLOR) {
            this.colorAnimation.setValueCallback(lottieValueCallback);
            return;
        }
        if (t == LottieProperty.COLOR_FILTER) {
            if (lottieValueCallback == null) {
                this.colorFilterAnimation = null;
                return;
            }
            ValueCallbackKeyframeAnimation valueCallbackKeyframeAnimation = new ValueCallbackKeyframeAnimation(lottieValueCallback);
            this.colorFilterAnimation = valueCallbackKeyframeAnimation;
            valueCallbackKeyframeAnimation.addUpdateListener(this);
            this.layer.addAnimation(this.colorAnimation);
        }
    }

    @Override // com.yfanads.android.libs.thirdpart.lottie.animation.content.BaseStrokeContent, com.yfanads.android.libs.thirdpart.lottie.animation.content.DrawingContent
    public void draw(Canvas canvas, Matrix matrix, int i) {
        this.paint.setColor(this.colorAnimation.getValue().intValue());
        BaseKeyframeAnimation<ColorFilter, ColorFilter> baseKeyframeAnimation = this.colorFilterAnimation;
        if (baseKeyframeAnimation != null) {
            this.paint.setColorFilter(baseKeyframeAnimation.getValue());
        }
        super.draw(canvas, matrix, i);
    }

    @Override // com.yfanads.android.libs.thirdpart.lottie.animation.content.Content
    public String getName() {
        return this.name;
    }
}
