package com.yfanads.android.libs.thirdpart.lottie.model.layer;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import com.yfanads.android.libs.thirdpart.lottie.L;
import com.yfanads.android.libs.thirdpart.lottie.LottieComposition;
import com.yfanads.android.libs.thirdpart.lottie.LottieDrawable;
import com.yfanads.android.libs.thirdpart.lottie.animation.content.Content;
import com.yfanads.android.libs.thirdpart.lottie.animation.content.DrawingContent;
import com.yfanads.android.libs.thirdpart.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.yfanads.android.libs.thirdpart.lottie.animation.keyframe.FloatKeyframeAnimation;
import com.yfanads.android.libs.thirdpart.lottie.animation.keyframe.MaskKeyframeAnimation;
import com.yfanads.android.libs.thirdpart.lottie.animation.keyframe.TransformKeyframeAnimation;
import com.yfanads.android.libs.thirdpart.lottie.model.KeyPath;
import com.yfanads.android.libs.thirdpart.lottie.model.KeyPathElement;
import com.yfanads.android.libs.thirdpart.lottie.model.content.Mask;
import com.yfanads.android.libs.thirdpart.lottie.model.content.ShapeData;
import com.yfanads.android.libs.thirdpart.lottie.value.LottieValueCallback;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public abstract class BaseLayer implements DrawingContent, BaseKeyframeAnimation.AnimationListener, KeyPathElement {
    private static final int SAVE_FLAGS = 31;
    private final Paint addMaskPaint;
    private final List<BaseKeyframeAnimation<?, ?>> animations;
    private final Paint clearPaint;
    private final String drawTraceName;
    final Layer layerModel;
    final LottieDrawable lottieDrawable;
    private MaskKeyframeAnimation mask;
    private final RectF maskBoundsRect;
    private final RectF matteBoundsRect;
    private BaseLayer matteLayer;
    private final Paint mattePaint;
    private BaseLayer parentLayer;
    private List<BaseLayer> parentLayers;
    private final RectF rect;
    private final Paint subtractMaskPaint;
    private final RectF tempMaskBoundsRect;
    final TransformKeyframeAnimation transform;
    private boolean visible;
    final Matrix boundsMatrix = new Matrix();
    private final Path path = new Path();
    private final Matrix matrix = new Matrix();
    private final Paint contentPaint = new Paint(1);

    /* JADX INFO: renamed from: com.yfanads.android.libs.thirdpart.lottie.model.layer.BaseLayer$2, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$com$yfanads$android$libs$thirdpart$lottie$model$content$Mask$MaskMode;
        static final /* synthetic */ int[] $SwitchMap$com$yfanads$android$libs$thirdpart$lottie$model$layer$Layer$LayerType;

        static {
            int[] iArr = new int[Mask.MaskMode.values().length];
            $SwitchMap$com$yfanads$android$libs$thirdpart$lottie$model$content$Mask$MaskMode = iArr;
            try {
                iArr[Mask.MaskMode.MaskModeSubtract.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$yfanads$android$libs$thirdpart$lottie$model$content$Mask$MaskMode[Mask.MaskMode.MaskModeIntersect.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$yfanads$android$libs$thirdpart$lottie$model$content$Mask$MaskMode[Mask.MaskMode.MaskModeAdd.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            int[] iArr2 = new int[Layer.LayerType.values().length];
            $SwitchMap$com$yfanads$android$libs$thirdpart$lottie$model$layer$Layer$LayerType = iArr2;
            try {
                iArr2[Layer.LayerType.Shape.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$yfanads$android$libs$thirdpart$lottie$model$layer$Layer$LayerType[Layer.LayerType.PreComp.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$yfanads$android$libs$thirdpart$lottie$model$layer$Layer$LayerType[Layer.LayerType.Solid.ordinal()] = 3;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$yfanads$android$libs$thirdpart$lottie$model$layer$Layer$LayerType[Layer.LayerType.Image.ordinal()] = 4;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$com$yfanads$android$libs$thirdpart$lottie$model$layer$Layer$LayerType[Layer.LayerType.Null.ordinal()] = 5;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$com$yfanads$android$libs$thirdpart$lottie$model$layer$Layer$LayerType[Layer.LayerType.Text.ordinal()] = 6;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$com$yfanads$android$libs$thirdpart$lottie$model$layer$Layer$LayerType[Layer.LayerType.Unknown.ordinal()] = 7;
            } catch (NoSuchFieldError unused10) {
            }
        }
    }

    public BaseLayer(LottieDrawable lottieDrawable, Layer layer) {
        Paint paint = new Paint(1);
        this.addMaskPaint = paint;
        Paint paint2 = new Paint(1);
        this.subtractMaskPaint = paint2;
        Paint paint3 = new Paint(1);
        this.mattePaint = paint3;
        Paint paint4 = new Paint();
        this.clearPaint = paint4;
        this.rect = new RectF();
        this.maskBoundsRect = new RectF();
        this.matteBoundsRect = new RectF();
        this.tempMaskBoundsRect = new RectF();
        this.animations = new ArrayList();
        this.visible = true;
        this.lottieDrawable = lottieDrawable;
        this.layerModel = layer;
        this.drawTraceName = layer.getName() + "#draw";
        paint4.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
        paint2.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        paint3.setXfermode(layer.getMatteType() == Layer.MatteType.Invert ? new PorterDuffXfermode(PorterDuff.Mode.DST_OUT) : new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
        TransformKeyframeAnimation transformKeyframeAnimationCreateAnimation = layer.getTransform().createAnimation();
        this.transform = transformKeyframeAnimationCreateAnimation;
        transformKeyframeAnimationCreateAnimation.addListener(this);
        if (layer.getMasks() != null && !layer.getMasks().isEmpty()) {
            MaskKeyframeAnimation maskKeyframeAnimation = new MaskKeyframeAnimation(layer.getMasks());
            this.mask = maskKeyframeAnimation;
            Iterator<BaseKeyframeAnimation<ShapeData, Path>> it = maskKeyframeAnimation.getMaskAnimations().iterator();
            while (it.hasNext()) {
                it.next().addUpdateListener(this);
            }
            for (BaseKeyframeAnimation<Integer, Integer> baseKeyframeAnimation : this.mask.getOpacityAnimations()) {
                addAnimation(baseKeyframeAnimation);
                baseKeyframeAnimation.addUpdateListener(this);
            }
        }
        setupInOutAnimations();
    }

    private void applyMasks(Canvas canvas, Matrix matrix) {
        applyMasks(canvas, matrix, Mask.MaskMode.MaskModeAdd);
        applyMasks(canvas, matrix, Mask.MaskMode.MaskModeIntersect);
        applyMasks(canvas, matrix, Mask.MaskMode.MaskModeSubtract);
    }

    private void applyMasks(Canvas canvas, Matrix matrix, Mask.MaskMode maskMode) {
        Paint paint = AnonymousClass2.$SwitchMap$com$yfanads$android$libs$thirdpart$lottie$model$content$Mask$MaskMode[maskMode.ordinal()] != 1 ? this.addMaskPaint : this.subtractMaskPaint;
        int size = this.mask.getMasks().size();
        for (int i = 0; i < size; i++) {
            if (this.mask.getMasks().get(i).getMaskMode() == maskMode) {
                L.beginSection("Layer#drawMask");
                L.beginSection("Layer#saveLayer");
                saveLayerCompat(canvas, this.rect, paint, false);
                L.endSection("Layer#saveLayer");
                clearCanvas(canvas);
                for (int i2 = 0; i2 < size; i2++) {
                    if (this.mask.getMasks().get(i2).getMaskMode() == maskMode) {
                        this.path.set(this.mask.getMaskAnimations().get(i2).getValue());
                        this.path.transform(matrix);
                        BaseKeyframeAnimation<Integer, Integer> baseKeyframeAnimation = this.mask.getOpacityAnimations().get(i2);
                        int alpha = this.contentPaint.getAlpha();
                        this.contentPaint.setAlpha((int) (baseKeyframeAnimation.getValue().intValue() * 2.55f));
                        canvas.drawPath(this.path, this.contentPaint);
                        this.contentPaint.setAlpha(alpha);
                    }
                }
                L.beginSection("Layer#restoreLayer");
                canvas.restore();
                L.endSection("Layer#restoreLayer");
                L.endSection("Layer#drawMask");
                return;
            }
        }
    }

    private void buildParentLayerListIfNeeded() {
        if (this.parentLayers != null) {
            return;
        }
        if (this.parentLayer == null) {
            this.parentLayers = Collections.emptyList();
            return;
        }
        this.parentLayers = new ArrayList();
        for (BaseLayer baseLayer = this.parentLayer; baseLayer != null; baseLayer = baseLayer.parentLayer) {
            this.parentLayers.add(baseLayer);
        }
    }

    private void clearCanvas(Canvas canvas) {
        L.beginSection("Layer#clearLayer");
        RectF rectF = this.rect;
        canvas.drawRect(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f, this.clearPaint);
        L.endSection("Layer#clearLayer");
    }

    public static BaseLayer forModel(Layer layer, LottieDrawable lottieDrawable, LottieComposition lottieComposition) {
        switch (AnonymousClass2.$SwitchMap$com$yfanads$android$libs$thirdpart$lottie$model$layer$Layer$LayerType[layer.getLayerType().ordinal()]) {
            case 1:
                return new ShapeLayer(lottieDrawable, layer);
            case 2:
                return new CompositionLayer(lottieDrawable, layer, lottieComposition.getPrecomps(layer.getRefId()), lottieComposition);
            case 3:
                return new SolidLayer(lottieDrawable, layer);
            case 4:
                return new ImageLayer(lottieDrawable, layer);
            case 5:
                return new NullLayer(lottieDrawable, layer);
            case 6:
                return new TextLayer(lottieDrawable, layer);
            default:
                L.warn("Unknown layer type " + layer.getLayerType());
                return null;
        }
    }

    private void intersectBoundsWithMask(RectF rectF, Matrix matrix) {
        this.maskBoundsRect.set(0.0f, 0.0f, 0.0f, 0.0f);
        if (hasMasksOnThisLayer()) {
            int size = this.mask.getMasks().size();
            for (int i = 0; i < size; i++) {
                Mask mask = this.mask.getMasks().get(i);
                this.path.set(this.mask.getMaskAnimations().get(i).getValue());
                this.path.transform(matrix);
                int i2 = AnonymousClass2.$SwitchMap$com$yfanads$android$libs$thirdpart$lottie$model$content$Mask$MaskMode[mask.getMaskMode().ordinal()];
                if (i2 == 1 || i2 == 2) {
                    return;
                }
                this.path.computeBounds(this.tempMaskBoundsRect, false);
                RectF rectF2 = this.maskBoundsRect;
                if (i == 0) {
                    rectF2.set(this.tempMaskBoundsRect);
                } else {
                    rectF2.set(Math.min(rectF2.left, this.tempMaskBoundsRect.left), Math.min(this.maskBoundsRect.top, this.tempMaskBoundsRect.top), Math.max(this.maskBoundsRect.right, this.tempMaskBoundsRect.right), Math.max(this.maskBoundsRect.bottom, this.tempMaskBoundsRect.bottom));
                }
            }
            rectF.set(Math.max(rectF.left, this.maskBoundsRect.left), Math.max(rectF.top, this.maskBoundsRect.top), Math.min(rectF.right, this.maskBoundsRect.right), Math.min(rectF.bottom, this.maskBoundsRect.bottom));
        }
    }

    private void intersectBoundsWithMatte(RectF rectF, Matrix matrix) {
        if (hasMatteOnThisLayer() && this.layerModel.getMatteType() != Layer.MatteType.Invert) {
            this.matteLayer.getBounds(this.matteBoundsRect, matrix);
            rectF.set(Math.max(rectF.left, this.matteBoundsRect.left), Math.max(rectF.top, this.matteBoundsRect.top), Math.min(rectF.right, this.matteBoundsRect.right), Math.min(rectF.bottom, this.matteBoundsRect.bottom));
        }
    }

    private void invalidateSelf() {
        this.lottieDrawable.invalidateSelf();
    }

    private void recordRenderTime(float f) {
        this.lottieDrawable.getComposition().getPerformanceTracker().recordRenderTime(this.layerModel.getName(), f);
    }

    private void saveLayerCompat(Canvas canvas, RectF rectF, Paint paint, boolean z) {
        canvas.saveLayer(rectF, paint);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setVisible(boolean z) {
        if (z != this.visible) {
            this.visible = z;
            invalidateSelf();
        }
    }

    private void setupInOutAnimations() {
        if (this.layerModel.getInOutKeyframes().isEmpty()) {
            setVisible(true);
            return;
        }
        final FloatKeyframeAnimation floatKeyframeAnimation = new FloatKeyframeAnimation(this.layerModel.getInOutKeyframes());
        floatKeyframeAnimation.setIsDiscrete();
        floatKeyframeAnimation.addUpdateListener(new BaseKeyframeAnimation.AnimationListener() { // from class: com.yfanads.android.libs.thirdpart.lottie.model.layer.BaseLayer.1
            @Override // com.yfanads.android.libs.thirdpart.lottie.animation.keyframe.BaseKeyframeAnimation.AnimationListener
            public void onValueChanged() {
                BaseLayer.this.setVisible(floatKeyframeAnimation.getValue().floatValue() == 1.0f);
            }
        });
        setVisible(floatKeyframeAnimation.getValue().floatValue() == 1.0f);
        addAnimation(floatKeyframeAnimation);
    }

    public void addAnimation(BaseKeyframeAnimation<?, ?> baseKeyframeAnimation) {
        this.animations.add(baseKeyframeAnimation);
    }

    @Override // com.yfanads.android.libs.thirdpart.lottie.model.KeyPathElement
    public <T> void addValueCallback(T t, LottieValueCallback<T> lottieValueCallback) {
        this.transform.applyValueCallback(t, lottieValueCallback);
    }

    @Override // com.yfanads.android.libs.thirdpart.lottie.animation.content.DrawingContent
    public void draw(Canvas canvas, Matrix matrix, int i) {
        L.beginSection(this.drawTraceName);
        if (!this.visible) {
            L.endSection(this.drawTraceName);
            return;
        }
        buildParentLayerListIfNeeded();
        L.beginSection("Layer#parentMatrix");
        this.matrix.reset();
        this.matrix.set(matrix);
        for (int size = this.parentLayers.size() - 1; size >= 0; size--) {
            this.matrix.preConcat(this.parentLayers.get(size).transform.getMatrix());
        }
        L.endSection("Layer#parentMatrix");
        int iIntValue = (int) ((((i / 255.0f) * this.transform.getOpacity().getValue().intValue()) / 100.0f) * 255.0f);
        if (!hasMatteOnThisLayer() && !hasMasksOnThisLayer()) {
            this.matrix.preConcat(this.transform.getMatrix());
            L.beginSection("Layer#drawLayer");
            drawLayer(canvas, this.matrix, iIntValue);
            L.endSection("Layer#drawLayer");
            recordRenderTime(L.endSection(this.drawTraceName));
            return;
        }
        L.beginSection("Layer#computeBounds");
        this.rect.set(0.0f, 0.0f, 0.0f, 0.0f);
        getBounds(this.rect, this.matrix);
        intersectBoundsWithMatte(this.rect, this.matrix);
        this.matrix.preConcat(this.transform.getMatrix());
        intersectBoundsWithMask(this.rect, this.matrix);
        this.rect.set(0.0f, 0.0f, canvas.getWidth(), canvas.getHeight());
        L.endSection("Layer#computeBounds");
        L.beginSection("Layer#saveLayer");
        saveLayerCompat(canvas, this.rect, this.contentPaint, true);
        L.endSection("Layer#saveLayer");
        clearCanvas(canvas);
        L.beginSection("Layer#drawLayer");
        drawLayer(canvas, this.matrix, iIntValue);
        L.endSection("Layer#drawLayer");
        if (hasMasksOnThisLayer()) {
            applyMasks(canvas, this.matrix);
        }
        if (hasMatteOnThisLayer()) {
            L.beginSection("Layer#drawMatte");
            L.beginSection("Layer#saveLayer");
            saveLayerCompat(canvas, this.rect, this.mattePaint, false);
            L.endSection("Layer#saveLayer");
            clearCanvas(canvas);
            this.matteLayer.draw(canvas, matrix, iIntValue);
            L.beginSection("Layer#restoreLayer");
            canvas.restore();
            L.endSection("Layer#restoreLayer");
            L.endSection("Layer#drawMatte");
        }
        L.beginSection("Layer#restoreLayer");
        canvas.restore();
        L.endSection("Layer#restoreLayer");
        recordRenderTime(L.endSection(this.drawTraceName));
    }

    public abstract void drawLayer(Canvas canvas, Matrix matrix, int i);

    @Override // com.yfanads.android.libs.thirdpart.lottie.animation.content.DrawingContent
    public void getBounds(RectF rectF, Matrix matrix) {
        this.boundsMatrix.set(matrix);
        this.boundsMatrix.preConcat(this.transform.getMatrix());
    }

    public Layer getLayerModel() {
        return this.layerModel;
    }

    @Override // com.yfanads.android.libs.thirdpart.lottie.animation.content.Content
    public String getName() {
        return this.layerModel.getName();
    }

    public boolean hasMasksOnThisLayer() {
        MaskKeyframeAnimation maskKeyframeAnimation = this.mask;
        return (maskKeyframeAnimation == null || maskKeyframeAnimation.getMaskAnimations().isEmpty()) ? false : true;
    }

    public boolean hasMatteOnThisLayer() {
        return this.matteLayer != null;
    }

    @Override // com.yfanads.android.libs.thirdpart.lottie.animation.keyframe.BaseKeyframeAnimation.AnimationListener
    public void onValueChanged() {
        invalidateSelf();
    }

    public void resolveChildKeyPath(KeyPath keyPath, int i, List<KeyPath> list, KeyPath keyPath2) {
    }

    @Override // com.yfanads.android.libs.thirdpart.lottie.model.KeyPathElement
    public void resolveKeyPath(KeyPath keyPath, int i, List<KeyPath> list, KeyPath keyPath2) {
        if (keyPath.matches(getName(), i)) {
            if (!"__container".equals(getName())) {
                keyPath2 = keyPath2.addKey(getName());
                if (keyPath.fullyResolvesTo(getName(), i)) {
                    list.add(keyPath2.resolve(this));
                }
            }
            if (keyPath.propagateToChildren(getName(), i)) {
                resolveChildKeyPath(keyPath, keyPath.incrementDepthBy(getName(), i) + i, list, keyPath2);
            }
        }
    }

    @Override // com.yfanads.android.libs.thirdpart.lottie.animation.content.Content
    public void setContents(List<Content> list, List<Content> list2) {
    }

    public void setMatteLayer(BaseLayer baseLayer) {
        this.matteLayer = baseLayer;
    }

    public void setParentLayer(BaseLayer baseLayer) {
        this.parentLayer = baseLayer;
    }

    public void setProgress(float f) {
        this.transform.setProgress(f);
        if (this.mask != null) {
            for (int i = 0; i < this.mask.getMaskAnimations().size(); i++) {
                this.mask.getMaskAnimations().get(i).setProgress(f);
            }
        }
        if (this.layerModel.getTimeStretch() != 0.0f) {
            f /= this.layerModel.getTimeStretch();
        }
        BaseLayer baseLayer = this.matteLayer;
        if (baseLayer != null) {
            this.matteLayer.setProgress(baseLayer.layerModel.getTimeStretch() * f);
        }
        for (int i2 = 0; i2 < this.animations.size(); i2++) {
            this.animations.get(i2).setProgress(f);
        }
    }
}
