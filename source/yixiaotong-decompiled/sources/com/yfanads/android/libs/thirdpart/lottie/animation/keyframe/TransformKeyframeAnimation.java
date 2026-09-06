package com.yfanads.android.libs.thirdpart.lottie.animation.keyframe;

import android.graphics.Matrix;
import android.graphics.PointF;
import com.yfanads.android.libs.thirdpart.lottie.LottieProperty;
import com.yfanads.android.libs.thirdpart.lottie.model.animatable.AnimatableTransform;
import com.yfanads.android.libs.thirdpart.lottie.model.layer.BaseLayer;
import com.yfanads.android.libs.thirdpart.lottie.value.LottieValueCallback;
import com.yfanads.android.libs.thirdpart.lottie.value.ScaleXY;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public class TransformKeyframeAnimation {
    private final BaseKeyframeAnimation<PointF, PointF> anchorPoint;
    private final BaseKeyframeAnimation<?, Float> endOpacity;
    private final Matrix matrix = new Matrix();
    private final BaseKeyframeAnimation<Integer, Integer> opacity;
    private final BaseKeyframeAnimation<?, PointF> position;
    private final BaseKeyframeAnimation<Float, Float> rotation;
    private final BaseKeyframeAnimation<ScaleXY, ScaleXY> scale;
    private final BaseKeyframeAnimation<?, Float> startOpacity;

    public TransformKeyframeAnimation(AnimatableTransform animatableTransform) {
        this.anchorPoint = animatableTransform.getAnchorPoint().createAnimation();
        this.position = animatableTransform.getPosition().createAnimation();
        this.scale = animatableTransform.getScale().createAnimation();
        this.rotation = animatableTransform.getRotation().createAnimation();
        this.opacity = animatableTransform.getOpacity().createAnimation();
        if (animatableTransform.getStartOpacity() != null) {
            this.startOpacity = animatableTransform.getStartOpacity().createAnimation();
        } else {
            this.startOpacity = null;
        }
        if (animatableTransform.getEndOpacity() != null) {
            this.endOpacity = animatableTransform.getEndOpacity().createAnimation();
        } else {
            this.endOpacity = null;
        }
    }

    public void addAnimationsToLayer(BaseLayer baseLayer) {
        baseLayer.addAnimation(this.anchorPoint);
        baseLayer.addAnimation(this.position);
        baseLayer.addAnimation(this.scale);
        baseLayer.addAnimation(this.rotation);
        baseLayer.addAnimation(this.opacity);
        BaseKeyframeAnimation<?, Float> baseKeyframeAnimation = this.startOpacity;
        if (baseKeyframeAnimation != null) {
            baseLayer.addAnimation(baseKeyframeAnimation);
        }
        BaseKeyframeAnimation<?, Float> baseKeyframeAnimation2 = this.endOpacity;
        if (baseKeyframeAnimation2 != null) {
            baseLayer.addAnimation(baseKeyframeAnimation2);
        }
    }

    public void addListener(BaseKeyframeAnimation.AnimationListener animationListener) {
        this.anchorPoint.addUpdateListener(animationListener);
        this.position.addUpdateListener(animationListener);
        this.scale.addUpdateListener(animationListener);
        this.rotation.addUpdateListener(animationListener);
        this.opacity.addUpdateListener(animationListener);
        BaseKeyframeAnimation<?, Float> baseKeyframeAnimation = this.startOpacity;
        if (baseKeyframeAnimation != null) {
            baseKeyframeAnimation.addUpdateListener(animationListener);
        }
        BaseKeyframeAnimation<?, Float> baseKeyframeAnimation2 = this.endOpacity;
        if (baseKeyframeAnimation2 != null) {
            baseKeyframeAnimation2.addUpdateListener(animationListener);
        }
    }

    public <T> boolean applyValueCallback(T t, LottieValueCallback<T> lottieValueCallback) {
        BaseKeyframeAnimation baseKeyframeAnimation;
        BaseKeyframeAnimation<?, Float> baseKeyframeAnimation2;
        if (t == LottieProperty.TRANSFORM_ANCHOR_POINT) {
            baseKeyframeAnimation = this.anchorPoint;
        } else if (t == LottieProperty.TRANSFORM_POSITION) {
            baseKeyframeAnimation = this.position;
        } else if (t == LottieProperty.TRANSFORM_SCALE) {
            baseKeyframeAnimation = this.scale;
        } else if (t == LottieProperty.TRANSFORM_ROTATION) {
            baseKeyframeAnimation = this.rotation;
        } else if (t == LottieProperty.TRANSFORM_OPACITY) {
            baseKeyframeAnimation = this.opacity;
        } else {
            if (t == LottieProperty.TRANSFORM_START_OPACITY && (baseKeyframeAnimation2 = this.startOpacity) != null) {
                baseKeyframeAnimation2.setValueCallback(lottieValueCallback);
                return true;
            }
            if (t != LottieProperty.TRANSFORM_END_OPACITY || (baseKeyframeAnimation = this.endOpacity) == null) {
                return false;
            }
        }
        baseKeyframeAnimation.setValueCallback(lottieValueCallback);
        return true;
    }

    public BaseKeyframeAnimation<?, Float> getEndOpacity() {
        return this.endOpacity;
    }

    public Matrix getMatrix() {
        this.matrix.reset();
        PointF value = this.position.getValue();
        float f = value.x;
        if (f != 0.0f || value.y != 0.0f) {
            this.matrix.preTranslate(f, value.y);
        }
        float fFloatValue = this.rotation.getValue().floatValue();
        if (fFloatValue != 0.0f) {
            this.matrix.preRotate(fFloatValue);
        }
        ScaleXY value2 = this.scale.getValue();
        if (value2.getScaleX() != 1.0f || value2.getScaleY() != 1.0f) {
            this.matrix.preScale(value2.getScaleX(), value2.getScaleY());
        }
        PointF value3 = this.anchorPoint.getValue();
        float f2 = value3.x;
        if (f2 != 0.0f || value3.y != 0.0f) {
            this.matrix.preTranslate(-f2, -value3.y);
        }
        return this.matrix;
    }

    public Matrix getMatrixForRepeater(float f) {
        PointF value = this.position.getValue();
        PointF value2 = this.anchorPoint.getValue();
        ScaleXY value3 = this.scale.getValue();
        float fFloatValue = this.rotation.getValue().floatValue();
        this.matrix.reset();
        this.matrix.preTranslate(value.x * f, value.y * f);
        double d = f;
        this.matrix.preScale((float) Math.pow(value3.getScaleX(), d), (float) Math.pow(value3.getScaleY(), d));
        this.matrix.preRotate(fFloatValue * f, value2.x, value2.y);
        return this.matrix;
    }

    public BaseKeyframeAnimation<?, Integer> getOpacity() {
        return this.opacity;
    }

    public BaseKeyframeAnimation<?, Float> getStartOpacity() {
        return this.startOpacity;
    }

    public void setProgress(float f) {
        this.anchorPoint.setProgress(f);
        this.position.setProgress(f);
        this.scale.setProgress(f);
        this.rotation.setProgress(f);
        this.opacity.setProgress(f);
        BaseKeyframeAnimation<?, Float> baseKeyframeAnimation = this.startOpacity;
        if (baseKeyframeAnimation != null) {
            baseKeyframeAnimation.setProgress(f);
        }
        BaseKeyframeAnimation<?, Float> baseKeyframeAnimation2 = this.endOpacity;
        if (baseKeyframeAnimation2 != null) {
            baseKeyframeAnimation2.setProgress(f);
        }
    }
}
