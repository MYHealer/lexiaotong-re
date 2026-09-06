package com.yfanads.android.libs.thirdpart.lottie.animation.content;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.DashPathEffect;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.RectF;
import com.yfanads.android.libs.thirdpart.lottie.L;
import com.yfanads.android.libs.thirdpart.lottie.LottieDrawable;
import com.yfanads.android.libs.thirdpart.lottie.LottieProperty;
import com.yfanads.android.libs.thirdpart.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.yfanads.android.libs.thirdpart.lottie.animation.keyframe.ValueCallbackKeyframeAnimation;
import com.yfanads.android.libs.thirdpart.lottie.model.KeyPath;
import com.yfanads.android.libs.thirdpart.lottie.model.animatable.AnimatableFloatValue;
import com.yfanads.android.libs.thirdpart.lottie.model.animatable.AnimatableIntegerValue;
import com.yfanads.android.libs.thirdpart.lottie.model.content.ShapeTrimPath;
import com.yfanads.android.libs.thirdpart.lottie.model.layer.BaseLayer;
import com.yfanads.android.libs.thirdpart.lottie.utils.MiscUtils;
import com.yfanads.android.libs.thirdpart.lottie.utils.Utils;
import com.yfanads.android.libs.thirdpart.lottie.value.LottieValueCallback;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public abstract class BaseStrokeContent implements BaseKeyframeAnimation.AnimationListener, KeyPathElementContent, DrawingContent {
    private BaseKeyframeAnimation<ColorFilter, ColorFilter> colorFilterAnimation;
    private final List<BaseKeyframeAnimation<?, Float>> dashPatternAnimations;
    private final BaseKeyframeAnimation<?, Float> dashPatternOffsetAnimation;
    private final float[] dashPatternValues;
    private final BaseLayer layer;
    private final LottieDrawable lottieDrawable;
    private final BaseKeyframeAnimation<?, Integer> opacityAnimation;
    final Paint paint;
    private final Path path;
    private final List<PathGroup> pathGroups;
    private final PathMeasure pm;
    private final RectF rect;
    private final Path trimPathPath;
    private final BaseKeyframeAnimation<?, Float> widthAnimation;

    /* JADX INFO: renamed from: com.yfanads.android.libs.thirdpart.lottie.animation.content.BaseStrokeContent$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static final class PathGroup {
        private final List<PathContent> paths;
        private final TrimPathContent trimPath;

        private PathGroup(TrimPathContent trimPathContent) {
            this.paths = new ArrayList();
            this.trimPath = trimPathContent;
        }

        public /* synthetic */ PathGroup(TrimPathContent trimPathContent, AnonymousClass1 anonymousClass1) {
            this(trimPathContent);
        }
    }

    public BaseStrokeContent(LottieDrawable lottieDrawable, BaseLayer baseLayer, Paint.Cap cap, Paint.Join join, float f, AnimatableIntegerValue animatableIntegerValue, AnimatableFloatValue animatableFloatValue, List<AnimatableFloatValue> list, AnimatableFloatValue animatableFloatValue2) {
        Paint paint = new Paint(1);
        this.paint = paint;
        this.pm = new PathMeasure();
        this.path = new Path();
        this.trimPathPath = new Path();
        this.rect = new RectF();
        this.pathGroups = new ArrayList();
        this.lottieDrawable = lottieDrawable;
        this.layer = baseLayer;
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeCap(cap);
        paint.setStrokeJoin(join);
        paint.setStrokeMiter(f);
        this.opacityAnimation = animatableIntegerValue.createAnimation();
        this.widthAnimation = animatableFloatValue.createAnimation();
        this.dashPatternOffsetAnimation = animatableFloatValue2 == null ? null : animatableFloatValue2.createAnimation();
        this.dashPatternAnimations = new ArrayList(list.size());
        this.dashPatternValues = new float[list.size()];
        for (int i = 0; i < list.size(); i++) {
            this.dashPatternAnimations.add(list.get(i).createAnimation());
        }
        baseLayer.addAnimation(this.opacityAnimation);
        baseLayer.addAnimation(this.widthAnimation);
        for (int i2 = 0; i2 < this.dashPatternAnimations.size(); i2++) {
            baseLayer.addAnimation(this.dashPatternAnimations.get(i2));
        }
        BaseKeyframeAnimation<?, Float> baseKeyframeAnimation = this.dashPatternOffsetAnimation;
        if (baseKeyframeAnimation != null) {
            baseLayer.addAnimation(baseKeyframeAnimation);
        }
        this.opacityAnimation.addUpdateListener(this);
        this.widthAnimation.addUpdateListener(this);
        for (int i3 = 0; i3 < list.size(); i3++) {
            this.dashPatternAnimations.get(i3).addUpdateListener(this);
        }
        BaseKeyframeAnimation<?, Float> baseKeyframeAnimation2 = this.dashPatternOffsetAnimation;
        if (baseKeyframeAnimation2 != null) {
            baseKeyframeAnimation2.addUpdateListener(this);
        }
    }

    private void applyDashPatternIfNeeded(Matrix matrix) {
        L.beginSection("StrokeContent#applyDashPattern");
        if (this.dashPatternAnimations.isEmpty()) {
            L.endSection("StrokeContent#applyDashPattern");
            return;
        }
        float scale = Utils.getScale(matrix);
        for (int i = 0; i < this.dashPatternAnimations.size(); i++) {
            this.dashPatternValues[i] = this.dashPatternAnimations.get(i).getValue().floatValue();
            if (i % 2 == 0) {
                float[] fArr = this.dashPatternValues;
                if (fArr[i] < 1.0f) {
                    fArr[i] = 1.0f;
                }
            } else {
                float[] fArr2 = this.dashPatternValues;
                if (fArr2[i] < 0.1f) {
                    fArr2[i] = 0.1f;
                }
            }
            float[] fArr3 = this.dashPatternValues;
            fArr3[i] = fArr3[i] * scale;
        }
        BaseKeyframeAnimation<?, Float> baseKeyframeAnimation = this.dashPatternOffsetAnimation;
        this.paint.setPathEffect(new DashPathEffect(this.dashPatternValues, baseKeyframeAnimation == null ? 0.0f : baseKeyframeAnimation.getValue().floatValue()));
        L.endSection("StrokeContent#applyDashPattern");
    }

    /* JADX WARN: Code duplicated, block: B:26:0x00ef  */
    private void applyTrimPath(Canvas canvas, PathGroup pathGroup, Matrix matrix) {
        float f;
        L.beginSection("StrokeContent#applyTrimPath");
        if (pathGroup.trimPath == null) {
            L.endSection("StrokeContent#applyTrimPath");
            return;
        }
        this.path.reset();
        for (int size = pathGroup.paths.size() - 1; size >= 0; size--) {
            this.path.addPath(((PathContent) pathGroup.paths.get(size)).getPath(), matrix);
        }
        this.pm.setPath(this.path, false);
        float length = this.pm.getLength();
        while (this.pm.nextContour()) {
            length += this.pm.getLength();
        }
        float fFloatValue = (pathGroup.trimPath.getOffset().getValue().floatValue() * length) / 360.0f;
        float fFloatValue2 = ((pathGroup.trimPath.getStart().getValue().floatValue() * length) / 100.0f) + fFloatValue;
        float fFloatValue3 = ((pathGroup.trimPath.getEnd().getValue().floatValue() * length) / 100.0f) + fFloatValue;
        float f2 = 0.0f;
        for (int size2 = pathGroup.paths.size() - 1; size2 >= 0; size2--) {
            this.trimPathPath.set(((PathContent) pathGroup.paths.get(size2)).getPath());
            this.trimPathPath.transform(matrix);
            this.pm.setPath(this.trimPathPath, false);
            float length2 = this.pm.getLength();
            if (fFloatValue3 > length) {
                float f3 = fFloatValue3 - length;
                if (f3 >= f2 + length2 || f2 >= f3) {
                    f = f2 + length2;
                    if (f < fFloatValue2 && f2 <= fFloatValue3) {
                        if (f > fFloatValue3 || fFloatValue2 >= f2) {
                            Utils.applyTrimPathIfNeeded(this.trimPathPath, fFloatValue2 < f2 ? 0.0f : (fFloatValue2 - f2) / length2, fFloatValue3 <= f ? (fFloatValue3 - f2) / length2 : 1.0f, 0.0f);
                        }
                    }
                } else {
                    Utils.applyTrimPathIfNeeded(this.trimPathPath, fFloatValue2 > length ? (fFloatValue2 - length) / length2 : 0.0f, Math.min(f3 / length2, 1.0f), 0.0f);
                }
                canvas.drawPath(this.trimPathPath, this.paint);
            } else {
                f = f2 + length2;
                if (f < fFloatValue2) {
                }
            }
            f2 += length2;
        }
        L.endSection("StrokeContent#applyTrimPath");
    }

    @Override // com.yfanads.android.libs.thirdpart.lottie.model.KeyPathElement
    public <T> void addValueCallback(T t, LottieValueCallback<T> lottieValueCallback) {
        BaseKeyframeAnimation baseKeyframeAnimation;
        if (t == LottieProperty.OPACITY) {
            baseKeyframeAnimation = this.opacityAnimation;
        } else {
            if (t != LottieProperty.STROKE_WIDTH) {
                if (t == LottieProperty.COLOR_FILTER) {
                    if (lottieValueCallback == null) {
                        this.colorFilterAnimation = null;
                        return;
                    }
                    ValueCallbackKeyframeAnimation valueCallbackKeyframeAnimation = new ValueCallbackKeyframeAnimation(lottieValueCallback);
                    this.colorFilterAnimation = valueCallbackKeyframeAnimation;
                    valueCallbackKeyframeAnimation.addUpdateListener(this);
                    this.layer.addAnimation(this.colorFilterAnimation);
                    return;
                }
                return;
            }
            baseKeyframeAnimation = this.widthAnimation;
        }
        baseKeyframeAnimation.setValueCallback(lottieValueCallback);
    }

    @Override // com.yfanads.android.libs.thirdpart.lottie.animation.content.DrawingContent
    public void draw(Canvas canvas, Matrix matrix, int i) {
        L.beginSection("StrokeContent#draw");
        this.paint.setAlpha(MiscUtils.clamp((int) ((((i / 255.0f) * this.opacityAnimation.getValue().intValue()) / 100.0f) * 255.0f), 0, 255));
        this.paint.setStrokeWidth(Utils.getScale(matrix) * this.widthAnimation.getValue().floatValue());
        if (this.paint.getStrokeWidth() <= 0.0f) {
            L.endSection("StrokeContent#draw");
            return;
        }
        applyDashPatternIfNeeded(matrix);
        BaseKeyframeAnimation<ColorFilter, ColorFilter> baseKeyframeAnimation = this.colorFilterAnimation;
        if (baseKeyframeAnimation != null) {
            this.paint.setColorFilter(baseKeyframeAnimation.getValue());
        }
        for (int i2 = 0; i2 < this.pathGroups.size(); i2++) {
            PathGroup pathGroup = this.pathGroups.get(i2);
            if (pathGroup.trimPath != null) {
                applyTrimPath(canvas, pathGroup, matrix);
            } else {
                L.beginSection("StrokeContent#buildPath");
                this.path.reset();
                for (int size = pathGroup.paths.size() - 1; size >= 0; size--) {
                    this.path.addPath(((PathContent) pathGroup.paths.get(size)).getPath(), matrix);
                }
                L.endSection("StrokeContent#buildPath");
                L.beginSection("StrokeContent#drawPath");
                canvas.drawPath(this.path, this.paint);
                L.endSection("StrokeContent#drawPath");
            }
        }
        L.endSection("StrokeContent#draw");
    }

    @Override // com.yfanads.android.libs.thirdpart.lottie.animation.content.DrawingContent
    public void getBounds(RectF rectF, Matrix matrix) {
        L.beginSection("StrokeContent#getBounds");
        this.path.reset();
        for (int i = 0; i < this.pathGroups.size(); i++) {
            PathGroup pathGroup = this.pathGroups.get(i);
            for (int i2 = 0; i2 < pathGroup.paths.size(); i2++) {
                this.path.addPath(((PathContent) pathGroup.paths.get(i2)).getPath(), matrix);
            }
        }
        this.path.computeBounds(this.rect, false);
        float fFloatValue = this.widthAnimation.getValue().floatValue();
        RectF rectF2 = this.rect;
        float f = fFloatValue / 2.0f;
        rectF2.set(rectF2.left - f, rectF2.top - f, rectF2.right + f, rectF2.bottom + f);
        rectF.set(this.rect);
        rectF.set(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f);
        L.endSection("StrokeContent#getBounds");
    }

    @Override // com.yfanads.android.libs.thirdpart.lottie.animation.keyframe.BaseKeyframeAnimation.AnimationListener
    public void onValueChanged() {
        this.lottieDrawable.invalidateSelf();
    }

    @Override // com.yfanads.android.libs.thirdpart.lottie.model.KeyPathElement
    public void resolveKeyPath(KeyPath keyPath, int i, List<KeyPath> list, KeyPath keyPath2) {
        MiscUtils.resolveKeyPath(keyPath, i, list, keyPath2, this);
    }

    /* JADX WARN: Code duplicated, block: B:21:0x0055  */
    /* JADX WARN: Code duplicated, block: B:23:0x0059 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:24:0x005b  */
    /* JADX WARN: Code duplicated, block: B:37:0x0069 A[SYNTHETIC] */
    @Override // com.yfanads.android.libs.thirdpart.lottie.animation.content.Content
    public void setContents(List<Content> list, List<Content> list2) {
        AnonymousClass1 anonymousClass1 = null;
        TrimPathContent trimPathContent = null;
        for (int size = list.size() - 1; size >= 0; size--) {
            Content content = list.get(size);
            if (content instanceof TrimPathContent) {
                TrimPathContent trimPathContent2 = (TrimPathContent) content;
                if (trimPathContent2.getType() == ShapeTrimPath.Type.Individually) {
                    trimPathContent = trimPathContent2;
                }
            }
        }
        if (trimPathContent != null) {
            trimPathContent.addListener(this);
        }
        PathGroup pathGroup = null;
        for (int size2 = list2.size() - 1; size2 >= 0; size2--) {
            Content content2 = list2.get(size2);
            if (content2 instanceof TrimPathContent) {
                TrimPathContent trimPathContent3 = (TrimPathContent) content2;
                if (trimPathContent3.getType() == ShapeTrimPath.Type.Individually) {
                    if (pathGroup != null) {
                        this.pathGroups.add(pathGroup);
                    }
                    pathGroup = new PathGroup(trimPathContent3, anonymousClass1);
                    trimPathContent3.addListener(this);
                } else if (!(content2 instanceof PathContent)) {
                    if (pathGroup == null) {
                        pathGroup = new PathGroup(trimPathContent, anonymousClass1);
                    }
                    pathGroup.paths.add((PathContent) content2);
                }
            } else if (!(content2 instanceof PathContent)) {
                if (pathGroup == null) {
                    pathGroup = new PathGroup(trimPathContent, anonymousClass1);
                }
                pathGroup.paths.add((PathContent) content2);
            }
        }
        if (pathGroup != null) {
            this.pathGroups.add(pathGroup);
        }
    }
}
