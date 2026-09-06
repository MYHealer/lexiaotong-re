package com.yfanads.android.libs.thirdpart.lottie.model.layer;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.RectF;
import com.yfanads.android.libs.thirdpart.lottie.LottieDrawable;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public class NullLayer extends BaseLayer {
    public NullLayer(LottieDrawable lottieDrawable, Layer layer) {
        super(lottieDrawable, layer);
    }

    @Override // com.yfanads.android.libs.thirdpart.lottie.model.layer.BaseLayer
    public void drawLayer(Canvas canvas, Matrix matrix, int i) {
    }

    @Override // com.yfanads.android.libs.thirdpart.lottie.model.layer.BaseLayer, com.yfanads.android.libs.thirdpart.lottie.animation.content.DrawingContent
    public void getBounds(RectF rectF, Matrix matrix) {
        super.getBounds(rectF, matrix);
        rectF.set(0.0f, 0.0f, 0.0f, 0.0f);
    }
}
