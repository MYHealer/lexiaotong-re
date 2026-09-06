package com.yfanads.android.libs.thirdpart.lottie.animation.content;

import android.graphics.Path;
import android.graphics.PointF;
import com.yfanads.android.libs.thirdpart.lottie.LottieDrawable;
import com.yfanads.android.libs.thirdpart.lottie.LottieProperty;
import com.yfanads.android.libs.thirdpart.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.yfanads.android.libs.thirdpart.lottie.model.KeyPath;
import com.yfanads.android.libs.thirdpart.lottie.model.content.PolystarShape;
import com.yfanads.android.libs.thirdpart.lottie.model.content.ShapeTrimPath;
import com.yfanads.android.libs.thirdpart.lottie.model.layer.BaseLayer;
import com.yfanads.android.libs.thirdpart.lottie.utils.MiscUtils;
import com.yfanads.android.libs.thirdpart.lottie.utils.Utils;
import com.yfanads.android.libs.thirdpart.lottie.value.LottieValueCallback;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public class PolystarContent implements PathContent, BaseKeyframeAnimation.AnimationListener, KeyPathElementContent {
    private static final float POLYGON_MAGIC_NUMBER = 0.25f;
    private static final float POLYSTAR_MAGIC_NUMBER = 0.47829f;
    private final BaseKeyframeAnimation<?, Float> innerRadiusAnimation;
    private final BaseKeyframeAnimation<?, Float> innerRoundednessAnimation;
    private boolean isPathValid;
    private final LottieDrawable lottieDrawable;
    private final String name;
    private final BaseKeyframeAnimation<?, Float> outerRadiusAnimation;
    private final BaseKeyframeAnimation<?, Float> outerRoundednessAnimation;
    private final Path path = new Path();
    private final BaseKeyframeAnimation<?, Float> pointsAnimation;
    private final BaseKeyframeAnimation<?, PointF> positionAnimation;
    private final BaseKeyframeAnimation<?, Float> rotationAnimation;
    private TrimPathContent trimPath;
    private final PolystarShape.Type type;

    /* JADX INFO: renamed from: com.yfanads.android.libs.thirdpart.lottie.animation.content.PolystarContent$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$yfanads$android$libs$thirdpart$lottie$model$content$PolystarShape$Type;

        static {
            int[] iArr = new int[PolystarShape.Type.values().length];
            $SwitchMap$com$yfanads$android$libs$thirdpart$lottie$model$content$PolystarShape$Type = iArr;
            try {
                iArr[PolystarShape.Type.Star.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$yfanads$android$libs$thirdpart$lottie$model$content$PolystarShape$Type[PolystarShape.Type.Polygon.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public PolystarContent(LottieDrawable lottieDrawable, BaseLayer baseLayer, PolystarShape polystarShape) {
        BaseKeyframeAnimation<Float, Float> baseKeyframeAnimationCreateAnimation;
        this.lottieDrawable = lottieDrawable;
        this.name = polystarShape.getName();
        PolystarShape.Type type = polystarShape.getType();
        this.type = type;
        BaseKeyframeAnimation<Float, Float> baseKeyframeAnimationCreateAnimation2 = polystarShape.getPoints().createAnimation();
        this.pointsAnimation = baseKeyframeAnimationCreateAnimation2;
        BaseKeyframeAnimation<PointF, PointF> baseKeyframeAnimationCreateAnimation3 = polystarShape.getPosition().createAnimation();
        this.positionAnimation = baseKeyframeAnimationCreateAnimation3;
        BaseKeyframeAnimation<Float, Float> baseKeyframeAnimationCreateAnimation4 = polystarShape.getRotation().createAnimation();
        this.rotationAnimation = baseKeyframeAnimationCreateAnimation4;
        BaseKeyframeAnimation<Float, Float> baseKeyframeAnimationCreateAnimation5 = polystarShape.getOuterRadius().createAnimation();
        this.outerRadiusAnimation = baseKeyframeAnimationCreateAnimation5;
        BaseKeyframeAnimation<Float, Float> baseKeyframeAnimationCreateAnimation6 = polystarShape.getOuterRoundedness().createAnimation();
        this.outerRoundednessAnimation = baseKeyframeAnimationCreateAnimation6;
        PolystarShape.Type type2 = PolystarShape.Type.Star;
        if (type == type2) {
            this.innerRadiusAnimation = polystarShape.getInnerRadius().createAnimation();
            baseKeyframeAnimationCreateAnimation = polystarShape.getInnerRoundedness().createAnimation();
        } else {
            baseKeyframeAnimationCreateAnimation = null;
            this.innerRadiusAnimation = null;
        }
        this.innerRoundednessAnimation = baseKeyframeAnimationCreateAnimation;
        baseLayer.addAnimation(baseKeyframeAnimationCreateAnimation2);
        baseLayer.addAnimation(baseKeyframeAnimationCreateAnimation3);
        baseLayer.addAnimation(baseKeyframeAnimationCreateAnimation4);
        baseLayer.addAnimation(baseKeyframeAnimationCreateAnimation5);
        baseLayer.addAnimation(baseKeyframeAnimationCreateAnimation6);
        if (type == type2) {
            baseLayer.addAnimation(this.innerRadiusAnimation);
            baseLayer.addAnimation(this.innerRoundednessAnimation);
        }
        baseKeyframeAnimationCreateAnimation2.addUpdateListener(this);
        baseKeyframeAnimationCreateAnimation3.addUpdateListener(this);
        baseKeyframeAnimationCreateAnimation4.addUpdateListener(this);
        baseKeyframeAnimationCreateAnimation5.addUpdateListener(this);
        baseKeyframeAnimationCreateAnimation6.addUpdateListener(this);
        if (type == type2) {
            this.innerRadiusAnimation.addUpdateListener(this);
            this.innerRoundednessAnimation.addUpdateListener(this);
        }
    }

    private void createPolygonPath() {
        int iFloor = (int) Math.floor(this.pointsAnimation.getValue().floatValue());
        BaseKeyframeAnimation<?, Float> baseKeyframeAnimation = this.rotationAnimation;
        double radians = Math.toRadians((baseKeyframeAnimation == null ? 0.0d : baseKeyframeAnimation.getValue().floatValue()) - 90.0d);
        double d = iFloor;
        float fFloatValue = this.outerRoundednessAnimation.getValue().floatValue() / 100.0f;
        float fFloatValue2 = this.outerRadiusAnimation.getValue().floatValue();
        double d2 = fFloatValue2;
        float fCos = (float) (Math.cos(radians) * d2);
        float fSin = (float) (Math.sin(radians) * d2);
        this.path.moveTo(fCos, fSin);
        double d3 = (float) (6.283185307179586d / d);
        double d4 = radians + d3;
        double dCeil = Math.ceil(d);
        int i = 0;
        while (i < dCeil) {
            float fCos2 = (float) (Math.cos(d4) * d2);
            double d5 = dCeil;
            float fSin2 = (float) (Math.sin(d4) * d2);
            if (fFloatValue != 0.0f) {
                double dAtan2 = (float) (Math.atan2(fSin, fCos) - 1.5707963267948966d);
                float fCos3 = (float) Math.cos(dAtan2);
                float fSin3 = (float) Math.sin(dAtan2);
                double dAtan3 = (float) (Math.atan2(fSin2, fCos2) - 1.5707963267948966d);
                float fCos4 = (float) Math.cos(dAtan3);
                float fSin4 = (float) Math.sin(dAtan3);
                float f = fFloatValue2 * fFloatValue * POLYGON_MAGIC_NUMBER;
                this.path.cubicTo(fCos - (fCos3 * f), fSin - (fSin3 * f), fCos2 + (fCos4 * f), fSin2 + (f * fSin4), fCos2, fSin2);
            } else {
                this.path.lineTo(fCos2, fSin2);
            }
            d4 += d3;
            i++;
            fSin = fSin2;
            fCos = fCos2;
            dCeil = d5;
            d2 = d2;
            d3 = d3;
        }
        PointF value = this.positionAnimation.getValue();
        this.path.offset(value.x, value.y);
        this.path.close();
    }

    private void createStarPath() {
        float f;
        float f2;
        double d;
        float fSin;
        float f3;
        float f4;
        float f5;
        float fFloatValue = this.pointsAnimation.getValue().floatValue();
        BaseKeyframeAnimation<?, Float> baseKeyframeAnimation = this.rotationAnimation;
        double radians = Math.toRadians((baseKeyframeAnimation == null ? 0.0d : baseKeyframeAnimation.getValue().floatValue()) - 90.0d);
        double d2 = fFloatValue;
        float f6 = (float) (6.283185307179586d / d2);
        float f7 = f6 / 2.0f;
        float f8 = fFloatValue - ((int) fFloatValue);
        if (f8 != 0.0f) {
            radians += (double) ((1.0f - f8) * f7);
        }
        float fFloatValue2 = this.outerRadiusAnimation.getValue().floatValue();
        float fFloatValue3 = this.innerRadiusAnimation.getValue().floatValue();
        BaseKeyframeAnimation<?, Float> baseKeyframeAnimation2 = this.innerRoundednessAnimation;
        float fFloatValue4 = baseKeyframeAnimation2 != null ? baseKeyframeAnimation2.getValue().floatValue() / 100.0f : 0.0f;
        BaseKeyframeAnimation<?, Float> baseKeyframeAnimation3 = this.outerRoundednessAnimation;
        float fFloatValue5 = baseKeyframeAnimation3 != null ? baseKeyframeAnimation3.getValue().floatValue() / 100.0f : 0.0f;
        if (f8 != 0.0f) {
            f3 = ((fFloatValue2 - fFloatValue3) * f8) + fFloatValue3;
            double d3 = f3;
            float fCos = (float) (Math.cos(radians) * d3);
            fSin = (float) (Math.sin(radians) * d3);
            this.path.moveTo(fCos, fSin);
            d = radians + ((double) ((f6 * f8) / 2.0f));
            f = fCos;
            f2 = f7;
        } else {
            double d4 = fFloatValue2;
            float fCos2 = (float) (Math.cos(radians) * d4);
            float fSin2 = (float) (d4 * Math.sin(radians));
            this.path.moveTo(fCos2, fSin2);
            f = fCos2;
            f2 = f7;
            d = radians + ((double) f2);
            fSin = fSin2;
            f3 = 0.0f;
        }
        double dCeil = Math.ceil(d2) * 2.0d;
        int i = 0;
        float f9 = f2;
        float f10 = f;
        boolean z = false;
        while (true) {
            double d5 = i;
            if (d5 >= dCeil) {
                PointF value = this.positionAnimation.getValue();
                this.path.offset(value.x, value.y);
                this.path.close();
                return;
            }
            float f11 = z ? fFloatValue2 : fFloatValue3;
            float f12 = (f3 == 0.0f || d5 != dCeil - 2.0d) ? f9 : (f6 * f8) / 2.0f;
            if (f3 == 0.0f || d5 != dCeil - 1.0d) {
                f3 = f11;
            }
            double d6 = f3;
            double d7 = dCeil;
            float fCos3 = (float) (Math.cos(d) * d6);
            float fSin3 = (float) (d6 * Math.sin(d));
            if (fFloatValue4 == 0.0f && fFloatValue5 == 0.0f) {
                this.path.lineTo(fCos3, fSin3);
                f4 = fFloatValue4;
                f5 = fFloatValue5;
            } else {
                f4 = fFloatValue4;
                double dAtan2 = (float) (Math.atan2(fSin, f10) - 1.5707963267948966d);
                float fCos4 = (float) Math.cos(dAtan2);
                float fSin4 = (float) Math.sin(dAtan2);
                f5 = fFloatValue5;
                double dAtan3 = (float) (Math.atan2(fSin3, fCos3) - 1.5707963267948966d);
                float fCos5 = (float) Math.cos(dAtan3);
                float fSin5 = (float) Math.sin(dAtan3);
                float f13 = z ? f4 : f5;
                float f14 = z ? f5 : f4;
                float f15 = z ? fFloatValue3 : fFloatValue2;
                float f16 = z ? fFloatValue2 : fFloatValue3;
                float f17 = f15 * f13 * POLYSTAR_MAGIC_NUMBER;
                float f18 = fCos4 * f17;
                float f19 = f17 * fSin4;
                float f20 = f16 * f14 * POLYSTAR_MAGIC_NUMBER;
                float f21 = fCos5 * f20;
                float f22 = f20 * fSin5;
                if (f8 != 0.0f) {
                    if (i == 0) {
                        f18 *= f8;
                        f19 *= f8;
                    } else if (d5 == d7 - 1.0d) {
                        f21 *= f8;
                        f22 *= f8;
                    }
                }
                this.path.cubicTo(f10 - f18, fSin - f19, fCos3 + f21, fSin3 + f22, fCos3, fSin3);
            }
            d += (double) f12;
            z = !z;
            i++;
            f10 = fCos3;
            fSin = fSin3;
            fFloatValue5 = f5;
            fFloatValue4 = f4;
            f3 = f3;
            f6 = f6;
            dCeil = d7;
        }
    }

    private void invalidate() {
        this.isPathValid = false;
        this.lottieDrawable.invalidateSelf();
    }

    @Override // com.yfanads.android.libs.thirdpart.lottie.model.KeyPathElement
    public <T> void addValueCallback(T t, LottieValueCallback<T> lottieValueCallback) {
        BaseKeyframeAnimation baseKeyframeAnimation;
        BaseKeyframeAnimation<?, Float> baseKeyframeAnimation2;
        if (t == LottieProperty.POLYSTAR_POINTS) {
            baseKeyframeAnimation = this.pointsAnimation;
        } else if (t == LottieProperty.POLYSTAR_ROTATION) {
            baseKeyframeAnimation = this.rotationAnimation;
        } else {
            if (t != LottieProperty.POSITION) {
                if (t != LottieProperty.POLYSTAR_INNER_RADIUS || (baseKeyframeAnimation2 = this.innerRadiusAnimation) == null) {
                    if (t == LottieProperty.POLYSTAR_OUTER_RADIUS) {
                        baseKeyframeAnimation = this.outerRadiusAnimation;
                    } else if (t != LottieProperty.POLYSTAR_INNER_ROUNDEDNESS || (baseKeyframeAnimation2 = this.innerRoundednessAnimation) == null) {
                        if (t != LottieProperty.POLYSTAR_OUTER_ROUNDEDNESS) {
                            return;
                        } else {
                            baseKeyframeAnimation = this.outerRoundednessAnimation;
                        }
                    }
                }
                baseKeyframeAnimation2.setValueCallback(lottieValueCallback);
                return;
            }
            baseKeyframeAnimation = this.positionAnimation;
        }
        baseKeyframeAnimation.setValueCallback(lottieValueCallback);
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
        int i = AnonymousClass1.$SwitchMap$com$yfanads$android$libs$thirdpart$lottie$model$content$PolystarShape$Type[this.type.ordinal()];
        if (i == 1) {
            createStarPath();
        } else if (i == 2) {
            createPolygonPath();
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
