package com.yfanads.android.libs.thirdpart.lottie.animation.content;

import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.graphics.Shader;
import androidx.collection.LongSparseArray;
import com.yfanads.android.libs.thirdpart.lottie.LottieDrawable;
import com.yfanads.android.libs.thirdpart.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.yfanads.android.libs.thirdpart.lottie.model.content.GradientColor;
import com.yfanads.android.libs.thirdpart.lottie.model.content.GradientStroke;
import com.yfanads.android.libs.thirdpart.lottie.model.content.GradientType;
import com.yfanads.android.libs.thirdpart.lottie.model.layer.BaseLayer;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public class GradientStrokeContent extends BaseStrokeContent {
    private static final int CACHE_STEPS_MS = 32;
    private final RectF boundsRect;
    private final int cacheSteps;
    private final BaseKeyframeAnimation<GradientColor, GradientColor> colorAnimation;
    private final BaseKeyframeAnimation<PointF, PointF> endPointAnimation;
    private final LongSparseArray<LinearGradient> linearGradientCache;
    private final String name;
    private final LongSparseArray<RadialGradient> radialGradientCache;
    private final BaseKeyframeAnimation<PointF, PointF> startPointAnimation;
    private final GradientType type;

    public GradientStrokeContent(LottieDrawable lottieDrawable, BaseLayer baseLayer, GradientStroke gradientStroke) {
        super(lottieDrawable, baseLayer, gradientStroke.getCapType().toPaintCap(), gradientStroke.getJoinType().toPaintJoin(), gradientStroke.getMiterLimit(), gradientStroke.getOpacity(), gradientStroke.getWidth(), gradientStroke.getLineDashPattern(), gradientStroke.getDashOffset());
        this.linearGradientCache = new LongSparseArray<>();
        this.radialGradientCache = new LongSparseArray<>();
        this.boundsRect = new RectF();
        this.name = gradientStroke.getName();
        this.type = gradientStroke.getGradientType();
        this.cacheSteps = (int) (lottieDrawable.getComposition().getDuration() / 32.0f);
        BaseKeyframeAnimation<GradientColor, GradientColor> baseKeyframeAnimationCreateAnimation = gradientStroke.getGradientColor().createAnimation();
        this.colorAnimation = baseKeyframeAnimationCreateAnimation;
        baseKeyframeAnimationCreateAnimation.addUpdateListener(this);
        baseLayer.addAnimation(baseKeyframeAnimationCreateAnimation);
        BaseKeyframeAnimation<PointF, PointF> baseKeyframeAnimationCreateAnimation2 = gradientStroke.getStartPoint().createAnimation();
        this.startPointAnimation = baseKeyframeAnimationCreateAnimation2;
        baseKeyframeAnimationCreateAnimation2.addUpdateListener(this);
        baseLayer.addAnimation(baseKeyframeAnimationCreateAnimation2);
        BaseKeyframeAnimation<PointF, PointF> baseKeyframeAnimationCreateAnimation3 = gradientStroke.getEndPoint().createAnimation();
        this.endPointAnimation = baseKeyframeAnimationCreateAnimation3;
        baseKeyframeAnimationCreateAnimation3.addUpdateListener(this);
        baseLayer.addAnimation(baseKeyframeAnimationCreateAnimation3);
    }

    private int getGradientHash() {
        int iRound = Math.round(this.startPointAnimation.getProgress() * this.cacheSteps);
        int iRound2 = Math.round(this.endPointAnimation.getProgress() * this.cacheSteps);
        int iRound3 = Math.round(this.colorAnimation.getProgress() * this.cacheSteps);
        int i = iRound != 0 ? iRound * 527 : 17;
        if (iRound2 != 0) {
            i = i * 31 * iRound2;
        }
        return iRound3 != 0 ? i * 31 * iRound3 : i;
    }

    private LinearGradient getLinearGradient() {
        long gradientHash = getGradientHash();
        LinearGradient linearGradient = this.linearGradientCache.get(gradientHash);
        if (linearGradient != null) {
            return linearGradient;
        }
        PointF value = this.startPointAnimation.getValue();
        PointF value2 = this.endPointAnimation.getValue();
        GradientColor value3 = this.colorAnimation.getValue();
        int[] colors = value3.getColors();
        float[] positions = value3.getPositions();
        RectF rectF = this.boundsRect;
        int iWidth = (int) ((rectF.width() / 2.0f) + rectF.left + value.x);
        RectF rectF2 = this.boundsRect;
        int iHeight = (int) ((rectF2.height() / 2.0f) + rectF2.top + value.y);
        RectF rectF3 = this.boundsRect;
        int iWidth2 = (int) ((rectF3.width() / 2.0f) + rectF3.left + value2.x);
        RectF rectF4 = this.boundsRect;
        LinearGradient linearGradient2 = new LinearGradient(iWidth, iHeight, iWidth2, (int) ((rectF4.height() / 2.0f) + rectF4.top + value2.y), colors, positions, Shader.TileMode.CLAMP);
        this.linearGradientCache.put(gradientHash, linearGradient2);
        return linearGradient2;
    }

    private RadialGradient getRadialGradient() {
        long gradientHash = getGradientHash();
        RadialGradient radialGradient = this.radialGradientCache.get(gradientHash);
        if (radialGradient != null) {
            return radialGradient;
        }
        PointF value = this.startPointAnimation.getValue();
        PointF value2 = this.endPointAnimation.getValue();
        GradientColor value3 = this.colorAnimation.getValue();
        int[] colors = value3.getColors();
        float[] positions = value3.getPositions();
        RectF rectF = this.boundsRect;
        int iWidth = (int) ((rectF.width() / 2.0f) + rectF.left + value.x);
        RectF rectF2 = this.boundsRect;
        int iHeight = (int) ((rectF2.height() / 2.0f) + rectF2.top + value.y);
        RectF rectF3 = this.boundsRect;
        int iWidth2 = (int) ((rectF3.width() / 2.0f) + rectF3.left + value2.x);
        RectF rectF4 = this.boundsRect;
        RadialGradient radialGradient2 = new RadialGradient(iWidth, iHeight, (float) Math.hypot(iWidth2 - iWidth, ((int) (((rectF4.height() / 2.0f) + rectF4.top) + value2.y)) - iHeight), colors, positions, Shader.TileMode.CLAMP);
        this.radialGradientCache.put(gradientHash, radialGradient2);
        return radialGradient2;
    }

    @Override // com.yfanads.android.libs.thirdpart.lottie.animation.content.BaseStrokeContent, com.yfanads.android.libs.thirdpart.lottie.animation.content.DrawingContent
    public void draw(Canvas canvas, Matrix matrix, int i) {
        Paint paint;
        Shader radialGradient;
        getBounds(this.boundsRect, matrix);
        if (this.type == GradientType.Linear) {
            paint = this.paint;
            radialGradient = getLinearGradient();
        } else {
            paint = this.paint;
            radialGradient = getRadialGradient();
        }
        paint.setShader(radialGradient);
        super.draw(canvas, matrix, i);
    }

    @Override // com.yfanads.android.libs.thirdpart.lottie.animation.content.Content
    public String getName() {
        return this.name;
    }
}
