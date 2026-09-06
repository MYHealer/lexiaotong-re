package com.yfanads.android.libs.thirdpart.lottie.model.layer;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.RectF;
import androidx.collection.LongSparseArray;
import com.yfanads.android.libs.thirdpart.lottie.L;
import com.yfanads.android.libs.thirdpart.lottie.LottieComposition;
import com.yfanads.android.libs.thirdpart.lottie.LottieDrawable;
import com.yfanads.android.libs.thirdpart.lottie.LottieProperty;
import com.yfanads.android.libs.thirdpart.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.yfanads.android.libs.thirdpart.lottie.animation.keyframe.ValueCallbackKeyframeAnimation;
import com.yfanads.android.libs.thirdpart.lottie.model.KeyPath;
import com.yfanads.android.libs.thirdpart.lottie.model.animatable.AnimatableFloatValue;
import com.yfanads.android.libs.thirdpart.lottie.value.LottieValueCallback;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public class CompositionLayer extends BaseLayer {
    private Boolean hasMasks;
    private Boolean hasMatte;
    private final List<BaseLayer> layers;
    private final RectF newClipRect;
    private final RectF rect;
    private BaseKeyframeAnimation<Float, Float> timeRemapping;

    /* JADX INFO: renamed from: com.yfanads.android.libs.thirdpart.lottie.model.layer.CompositionLayer$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$yfanads$android$libs$thirdpart$lottie$model$layer$Layer$MatteType;

        static {
            int[] iArr = new int[Layer.MatteType.values().length];
            $SwitchMap$com$yfanads$android$libs$thirdpart$lottie$model$layer$Layer$MatteType = iArr;
            try {
                iArr[Layer.MatteType.Add.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$yfanads$android$libs$thirdpart$lottie$model$layer$Layer$MatteType[Layer.MatteType.Invert.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public CompositionLayer(LottieDrawable lottieDrawable, Layer layer, List<Layer> list, LottieComposition lottieComposition) {
        int i;
        BaseLayer baseLayer;
        super(lottieDrawable, layer);
        this.layers = new ArrayList();
        this.rect = new RectF();
        this.newClipRect = new RectF();
        AnimatableFloatValue timeRemapping = layer.getTimeRemapping();
        if (timeRemapping != null) {
            BaseKeyframeAnimation<Float, Float> baseKeyframeAnimationCreateAnimation = timeRemapping.createAnimation();
            this.timeRemapping = baseKeyframeAnimationCreateAnimation;
            addAnimation(baseKeyframeAnimationCreateAnimation);
            this.timeRemapping.addUpdateListener(this);
        } else {
            this.timeRemapping = null;
        }
        LongSparseArray longSparseArray = new LongSparseArray(lottieComposition.getLayers().size());
        int size = list.size() - 1;
        BaseLayer baseLayer2 = null;
        while (true) {
            if (size < 0) {
                break;
            }
            Layer layer2 = list.get(size);
            BaseLayer baseLayerForModel = BaseLayer.forModel(layer2, lottieDrawable, lottieComposition);
            if (baseLayerForModel != null) {
                longSparseArray.put(baseLayerForModel.getLayerModel().getId(), baseLayerForModel);
                if (baseLayer2 != null) {
                    baseLayer2.setMatteLayer(baseLayerForModel);
                    baseLayer2 = null;
                } else {
                    this.layers.add(0, baseLayerForModel);
                    int i2 = AnonymousClass1.$SwitchMap$com$yfanads$android$libs$thirdpart$lottie$model$layer$Layer$MatteType[layer2.getMatteType().ordinal()];
                    if (i2 == 1 || i2 == 2) {
                        baseLayer2 = baseLayerForModel;
                    }
                }
            }
            size--;
        }
        for (i = 0; i < longSparseArray.size(); i++) {
            BaseLayer baseLayer3 = (BaseLayer) longSparseArray.get(longSparseArray.keyAt(i));
            if (baseLayer3 != null && (baseLayer = (BaseLayer) longSparseArray.get(baseLayer3.getLayerModel().getParentId())) != null) {
                baseLayer3.setParentLayer(baseLayer);
            }
        }
    }

    @Override // com.yfanads.android.libs.thirdpart.lottie.model.layer.BaseLayer, com.yfanads.android.libs.thirdpart.lottie.model.KeyPathElement
    public <T> void addValueCallback(T t, LottieValueCallback<T> lottieValueCallback) {
        super.addValueCallback(t, lottieValueCallback);
        if (t == LottieProperty.TIME_REMAP) {
            if (lottieValueCallback == null) {
                this.timeRemapping = null;
                return;
            }
            ValueCallbackKeyframeAnimation valueCallbackKeyframeAnimation = new ValueCallbackKeyframeAnimation(lottieValueCallback);
            this.timeRemapping = valueCallbackKeyframeAnimation;
            addAnimation(valueCallbackKeyframeAnimation);
        }
    }

    @Override // com.yfanads.android.libs.thirdpart.lottie.model.layer.BaseLayer
    public void drawLayer(Canvas canvas, Matrix matrix, int i) {
        L.beginSection("CompositionLayer#draw");
        canvas.save();
        this.newClipRect.set(0.0f, 0.0f, this.layerModel.getPreCompWidth(), this.layerModel.getPreCompHeight());
        matrix.mapRect(this.newClipRect);
        for (int size = this.layers.size() - 1; size >= 0; size--) {
            if (this.newClipRect.isEmpty() || canvas.clipRect(this.newClipRect)) {
                this.layers.get(size).draw(canvas, matrix, i);
            }
        }
        canvas.restore();
        L.endSection("CompositionLayer#draw");
    }

    @Override // com.yfanads.android.libs.thirdpart.lottie.model.layer.BaseLayer, com.yfanads.android.libs.thirdpart.lottie.animation.content.DrawingContent
    public void getBounds(RectF rectF, Matrix matrix) {
        super.getBounds(rectF, matrix);
        this.rect.set(0.0f, 0.0f, 0.0f, 0.0f);
        for (int size = this.layers.size() - 1; size >= 0; size--) {
            this.layers.get(size).getBounds(this.rect, this.boundsMatrix);
            if (rectF.isEmpty()) {
                rectF.set(this.rect);
            } else {
                rectF.set(Math.min(rectF.left, this.rect.left), Math.min(rectF.top, this.rect.top), Math.max(rectF.right, this.rect.right), Math.max(rectF.bottom, this.rect.bottom));
            }
        }
    }

    public boolean hasMasks() {
        if (this.hasMasks == null) {
            for (int size = this.layers.size() - 1; size >= 0; size--) {
                BaseLayer baseLayer = this.layers.get(size);
                if (baseLayer instanceof ShapeLayer) {
                    if (baseLayer.hasMasksOnThisLayer()) {
                        this.hasMasks = Boolean.TRUE;
                        return true;
                    }
                } else {
                    if ((baseLayer instanceof CompositionLayer) && ((CompositionLayer) baseLayer).hasMasks()) {
                        this.hasMasks = Boolean.TRUE;
                        return true;
                    }
                }
            }
            this.hasMasks = Boolean.FALSE;
        }
        return this.hasMasks.booleanValue();
    }

    public boolean hasMatte() {
        if (this.hasMatte == null) {
            if (!hasMatteOnThisLayer()) {
                for (int size = this.layers.size() - 1; size >= 0; size--) {
                    if (!this.layers.get(size).hasMatteOnThisLayer()) {
                    }
                }
                this.hasMatte = Boolean.FALSE;
            }
            this.hasMatte = Boolean.TRUE;
            return true;
        }
        return this.hasMatte.booleanValue();
    }

    @Override // com.yfanads.android.libs.thirdpart.lottie.model.layer.BaseLayer
    public void resolveChildKeyPath(KeyPath keyPath, int i, List<KeyPath> list, KeyPath keyPath2) {
        for (int i2 = 0; i2 < this.layers.size(); i2++) {
            this.layers.get(i2).resolveKeyPath(keyPath, i, list, keyPath2);
        }
    }

    @Override // com.yfanads.android.libs.thirdpart.lottie.model.layer.BaseLayer
    public void setProgress(float f) {
        super.setProgress(f);
        if (this.timeRemapping != null) {
            f = ((long) (this.timeRemapping.getValue().floatValue() * 1000.0f)) / this.lottieDrawable.getComposition().getDuration();
        }
        if (this.layerModel.getTimeStretch() != 0.0f) {
            f /= this.layerModel.getTimeStretch();
        }
        float startProgress = f - this.layerModel.getStartProgress();
        for (int size = this.layers.size() - 1; size >= 0; size--) {
            this.layers.get(size).setProgress(startProgress);
        }
    }
}
