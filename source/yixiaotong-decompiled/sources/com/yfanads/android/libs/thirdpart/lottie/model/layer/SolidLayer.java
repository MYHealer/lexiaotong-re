package com.yfanads.android.libs.thirdpart.lottie.model.layer;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import com.yfanads.android.libs.thirdpart.lottie.LottieDrawable;
import com.yfanads.android.libs.thirdpart.lottie.LottieProperty;
import com.yfanads.android.libs.thirdpart.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.yfanads.android.libs.thirdpart.lottie.animation.keyframe.ValueCallbackKeyframeAnimation;
import com.yfanads.android.libs.thirdpart.lottie.value.LottieValueCallback;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public class SolidLayer extends BaseLayer {
    private BaseKeyframeAnimation<ColorFilter, ColorFilter> colorFilterAnimation;
    private final Layer layerModel;
    private final Paint paint;
    private final Path path;
    private final float[] points;
    private final RectF rect;

    public SolidLayer(LottieDrawable lottieDrawable, Layer layer) {
        super(lottieDrawable, layer);
        this.rect = new RectF();
        Paint paint = new Paint();
        this.paint = paint;
        this.points = new float[8];
        this.path = new Path();
        this.layerModel = layer;
        paint.setAlpha(0);
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(layer.getSolidColor());
    }

    @Override // com.yfanads.android.libs.thirdpart.lottie.model.layer.BaseLayer, com.yfanads.android.libs.thirdpart.lottie.model.KeyPathElement
    public <T> void addValueCallback(T t, LottieValueCallback<T> lottieValueCallback) {
        super.addValueCallback(t, lottieValueCallback);
        if (t == LottieProperty.COLOR_FILTER) {
            this.colorFilterAnimation = lottieValueCallback == null ? null : new ValueCallbackKeyframeAnimation(lottieValueCallback);
        }
    }

    @Override // com.yfanads.android.libs.thirdpart.lottie.model.layer.BaseLayer
    public void drawLayer(Canvas canvas, Matrix matrix, int i) {
        int iAlpha = Color.alpha(this.layerModel.getSolidColor());
        if (iAlpha == 0) {
            return;
        }
        int iIntValue = (int) ((((iAlpha / 255.0f) * this.transform.getOpacity().getValue().intValue()) / 100.0f) * (i / 255.0f) * 255.0f);
        this.paint.setAlpha(iIntValue);
        BaseKeyframeAnimation<ColorFilter, ColorFilter> baseKeyframeAnimation = this.colorFilterAnimation;
        if (baseKeyframeAnimation != null) {
            this.paint.setColorFilter(baseKeyframeAnimation.getValue());
        }
        if (iIntValue > 0) {
            float[] fArr = this.points;
            fArr[0] = 0.0f;
            fArr[1] = 0.0f;
            fArr[2] = this.layerModel.getSolidWidth();
            float[] fArr2 = this.points;
            fArr2[3] = 0.0f;
            fArr2[4] = this.layerModel.getSolidWidth();
            this.points[5] = this.layerModel.getSolidHeight();
            float[] fArr3 = this.points;
            fArr3[6] = 0.0f;
            fArr3[7] = this.layerModel.getSolidHeight();
            matrix.mapPoints(this.points);
            this.path.reset();
            Path path = this.path;
            float[] fArr4 = this.points;
            path.moveTo(fArr4[0], fArr4[1]);
            Path path2 = this.path;
            float[] fArr5 = this.points;
            path2.lineTo(fArr5[2], fArr5[3]);
            Path path3 = this.path;
            float[] fArr6 = this.points;
            path3.lineTo(fArr6[4], fArr6[5]);
            Path path4 = this.path;
            float[] fArr7 = this.points;
            path4.lineTo(fArr7[6], fArr7[7]);
            Path path5 = this.path;
            float[] fArr8 = this.points;
            path5.lineTo(fArr8[0], fArr8[1]);
            this.path.close();
            canvas.drawPath(this.path, this.paint);
        }
    }

    @Override // com.yfanads.android.libs.thirdpart.lottie.model.layer.BaseLayer, com.yfanads.android.libs.thirdpart.lottie.animation.content.DrawingContent
    public void getBounds(RectF rectF, Matrix matrix) {
        super.getBounds(rectF, matrix);
        this.rect.set(0.0f, 0.0f, this.layerModel.getSolidWidth(), this.layerModel.getSolidHeight());
        this.boundsMatrix.mapRect(this.rect);
        rectF.set(this.rect);
    }
}
