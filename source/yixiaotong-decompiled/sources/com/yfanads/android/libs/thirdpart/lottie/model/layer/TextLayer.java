package com.yfanads.android.libs.thirdpart.lottie.model.layer;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Typeface;
import com.yfanads.android.libs.thirdpart.lottie.LottieComposition;
import com.yfanads.android.libs.thirdpart.lottie.LottieDrawable;
import com.yfanads.android.libs.thirdpart.lottie.LottieProperty;
import com.yfanads.android.libs.thirdpart.lottie.TextDelegate;
import com.yfanads.android.libs.thirdpart.lottie.animation.content.ContentGroup;
import com.yfanads.android.libs.thirdpart.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.yfanads.android.libs.thirdpart.lottie.animation.keyframe.TextKeyframeAnimation;
import com.yfanads.android.libs.thirdpart.lottie.model.DocumentData;
import com.yfanads.android.libs.thirdpart.lottie.model.Font;
import com.yfanads.android.libs.thirdpart.lottie.model.FontCharacter;
import com.yfanads.android.libs.thirdpart.lottie.model.animatable.AnimatableColorValue;
import com.yfanads.android.libs.thirdpart.lottie.model.animatable.AnimatableFloatValue;
import com.yfanads.android.libs.thirdpart.lottie.model.animatable.AnimatableTextProperties;
import com.yfanads.android.libs.thirdpart.lottie.model.content.ShapeGroup;
import com.yfanads.android.libs.thirdpart.lottie.utils.Utils;
import com.yfanads.android.libs.thirdpart.lottie.value.LottieValueCallback;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public class TextLayer extends BaseLayer {
    private BaseKeyframeAnimation<Integer, Integer> colorAnimation;
    private final LottieComposition composition;
    private final Map<FontCharacter, List<ContentGroup>> contentsForCharacter;
    private final Paint fillPaint;
    private final LottieDrawable lottieDrawable;
    private final Matrix matrix;
    private final RectF rectF;
    private BaseKeyframeAnimation<Integer, Integer> strokeColorAnimation;
    private final Paint strokePaint;
    private BaseKeyframeAnimation<Float, Float> strokeWidthAnimation;
    private final char[] tempCharArray;
    private final TextKeyframeAnimation textAnimation;
    private BaseKeyframeAnimation<Float, Float> trackingAnimation;

    public TextLayer(LottieDrawable lottieDrawable, Layer layer) {
        AnimatableFloatValue animatableFloatValue;
        AnimatableFloatValue animatableFloatValue2;
        AnimatableColorValue animatableColorValue;
        AnimatableColorValue animatableColorValue2;
        super(lottieDrawable, layer);
        int i = 1;
        this.tempCharArray = new char[1];
        this.rectF = new RectF();
        this.matrix = new Matrix();
        this.fillPaint = new Paint(i) { // from class: com.yfanads.android.libs.thirdpart.lottie.model.layer.TextLayer.1
            {
                setStyle(Paint.Style.FILL);
            }
        };
        this.strokePaint = new Paint(i) { // from class: com.yfanads.android.libs.thirdpart.lottie.model.layer.TextLayer.2
            {
                setStyle(Paint.Style.STROKE);
            }
        };
        this.contentsForCharacter = new HashMap();
        this.lottieDrawable = lottieDrawable;
        this.composition = layer.getComposition();
        TextKeyframeAnimation textKeyframeAnimationCreateAnimation = layer.getText().createAnimation();
        this.textAnimation = textKeyframeAnimationCreateAnimation;
        textKeyframeAnimationCreateAnimation.addUpdateListener(this);
        addAnimation(textKeyframeAnimationCreateAnimation);
        AnimatableTextProperties textProperties = layer.getTextProperties();
        if (textProperties != null && (animatableColorValue2 = textProperties.color) != null) {
            BaseKeyframeAnimation<Integer, Integer> baseKeyframeAnimationCreateAnimation = animatableColorValue2.createAnimation();
            this.colorAnimation = baseKeyframeAnimationCreateAnimation;
            baseKeyframeAnimationCreateAnimation.addUpdateListener(this);
            addAnimation(this.colorAnimation);
        }
        if (textProperties != null && (animatableColorValue = textProperties.stroke) != null) {
            BaseKeyframeAnimation<Integer, Integer> baseKeyframeAnimationCreateAnimation2 = animatableColorValue.createAnimation();
            this.strokeColorAnimation = baseKeyframeAnimationCreateAnimation2;
            baseKeyframeAnimationCreateAnimation2.addUpdateListener(this);
            addAnimation(this.strokeColorAnimation);
        }
        if (textProperties != null && (animatableFloatValue2 = textProperties.strokeWidth) != null) {
            BaseKeyframeAnimation<Float, Float> baseKeyframeAnimationCreateAnimation3 = animatableFloatValue2.createAnimation();
            this.strokeWidthAnimation = baseKeyframeAnimationCreateAnimation3;
            baseKeyframeAnimationCreateAnimation3.addUpdateListener(this);
            addAnimation(this.strokeWidthAnimation);
        }
        if (textProperties == null || (animatableFloatValue = textProperties.tracking) == null) {
            return;
        }
        BaseKeyframeAnimation<Float, Float> baseKeyframeAnimationCreateAnimation4 = animatableFloatValue.createAnimation();
        this.trackingAnimation = baseKeyframeAnimationCreateAnimation4;
        baseKeyframeAnimationCreateAnimation4.addUpdateListener(this);
        addAnimation(this.trackingAnimation);
    }

    private void drawCharacter(char[] cArr, Paint paint, Canvas canvas) {
        if (paint.getColor() == 0) {
            return;
        }
        if (paint.getStyle() == Paint.Style.STROKE && paint.getStrokeWidth() == 0.0f) {
            return;
        }
        canvas.drawText(cArr, 0, 1, 0.0f, 0.0f, paint);
    }

    private void drawCharacterAsGlyph(FontCharacter fontCharacter, Matrix matrix, float f, DocumentData documentData, Canvas canvas) {
        Paint paint;
        List<ContentGroup> contentsForCharacter = getContentsForCharacter(fontCharacter);
        for (int i = 0; i < contentsForCharacter.size(); i++) {
            Path path = contentsForCharacter.get(i).getPath();
            path.computeBounds(this.rectF, false);
            this.matrix.set(matrix);
            this.matrix.preTranslate(0.0f, Utils.dpScale() * ((float) (-documentData.baselineShift)));
            this.matrix.preScale(f, f);
            path.transform(this.matrix);
            if (documentData.strokeOverFill) {
                drawGlyph(path, this.fillPaint, canvas);
                paint = this.strokePaint;
            } else {
                drawGlyph(path, this.strokePaint, canvas);
                paint = this.fillPaint;
            }
            drawGlyph(path, paint, canvas);
        }
    }

    private void drawCharacterFromFont(char c, DocumentData documentData, Canvas canvas) {
        char[] cArr = this.tempCharArray;
        cArr[0] = c;
        if (documentData.strokeOverFill) {
            drawCharacter(cArr, this.fillPaint, canvas);
            drawCharacter(this.tempCharArray, this.strokePaint, canvas);
        } else {
            drawCharacter(cArr, this.strokePaint, canvas);
            drawCharacter(this.tempCharArray, this.fillPaint, canvas);
        }
    }

    private void drawGlyph(Path path, Paint paint, Canvas canvas) {
        if (paint.getColor() == 0) {
            return;
        }
        if (paint.getStyle() == Paint.Style.STROKE && paint.getStrokeWidth() == 0.0f) {
            return;
        }
        canvas.drawPath(path, paint);
    }

    private void drawTextGlyphs(DocumentData documentData, Matrix matrix, Font font, Canvas canvas) {
        float f = ((float) documentData.size) / 100.0f;
        float scale = Utils.getScale(matrix);
        String str = documentData.text;
        for (int i = 0; i < str.length(); i++) {
            FontCharacter fontCharacter = this.composition.getCharacters().get(FontCharacter.hashFor(str.charAt(i), font.getFamily(), font.getStyle()));
            if (fontCharacter != null) {
                drawCharacterAsGlyph(fontCharacter, matrix, f, documentData, canvas);
                float fDpScale = Utils.dpScale() * ((float) fontCharacter.getWidth()) * f * scale;
                float fFloatValue = documentData.tracking / 10.0f;
                BaseKeyframeAnimation<Float, Float> baseKeyframeAnimation = this.trackingAnimation;
                if (baseKeyframeAnimation != null) {
                    fFloatValue += baseKeyframeAnimation.getValue().floatValue();
                }
                canvas.translate((fFloatValue * scale) + fDpScale, 0.0f);
            }
        }
    }

    private void drawTextWithFont(DocumentData documentData, Font font, Matrix matrix, Canvas canvas) {
        float scale = Utils.getScale(matrix);
        Typeface typeface = this.lottieDrawable.getTypeface(font.getFamily(), font.getStyle());
        if (typeface == null) {
            return;
        }
        String textInternal = documentData.text;
        TextDelegate textDelegate = this.lottieDrawable.getTextDelegate();
        if (textDelegate != null) {
            textInternal = textDelegate.getTextInternal(textInternal);
        }
        this.fillPaint.setTypeface(typeface);
        this.fillPaint.setTextSize((float) (documentData.size * ((double) Utils.dpScale())));
        this.strokePaint.setTypeface(this.fillPaint.getTypeface());
        this.strokePaint.setTextSize(this.fillPaint.getTextSize());
        for (int i = 0; i < textInternal.length(); i++) {
            char cCharAt = textInternal.charAt(i);
            drawCharacterFromFont(cCharAt, documentData, canvas);
            char[] cArr = this.tempCharArray;
            cArr[0] = cCharAt;
            float fMeasureText = this.fillPaint.measureText(cArr, 0, 1);
            float fFloatValue = documentData.tracking / 10.0f;
            BaseKeyframeAnimation<Float, Float> baseKeyframeAnimation = this.trackingAnimation;
            if (baseKeyframeAnimation != null) {
                fFloatValue += baseKeyframeAnimation.getValue().floatValue();
            }
            canvas.translate((fFloatValue * scale) + fMeasureText, 0.0f);
        }
    }

    private List<ContentGroup> getContentsForCharacter(FontCharacter fontCharacter) {
        if (this.contentsForCharacter.containsKey(fontCharacter)) {
            return this.contentsForCharacter.get(fontCharacter);
        }
        List<ShapeGroup> shapes = fontCharacter.getShapes();
        int size = shapes.size();
        ArrayList arrayList = new ArrayList(size);
        for (int i = 0; i < size; i++) {
            arrayList.add(new ContentGroup(this.lottieDrawable, this, shapes.get(i)));
        }
        this.contentsForCharacter.put(fontCharacter, arrayList);
        return arrayList;
    }

    @Override // com.yfanads.android.libs.thirdpart.lottie.model.layer.BaseLayer, com.yfanads.android.libs.thirdpart.lottie.model.KeyPathElement
    public <T> void addValueCallback(T t, LottieValueCallback<T> lottieValueCallback) {
        BaseKeyframeAnimation<Float, Float> baseKeyframeAnimation;
        BaseKeyframeAnimation baseKeyframeAnimation2;
        super.addValueCallback(t, lottieValueCallback);
        if ((t == LottieProperty.COLOR && (baseKeyframeAnimation2 = this.colorAnimation) != null) || ((t == LottieProperty.STROKE_COLOR && (baseKeyframeAnimation2 = this.strokeColorAnimation) != null) || (t == LottieProperty.STROKE_WIDTH && (baseKeyframeAnimation2 = this.strokeWidthAnimation) != null))) {
            baseKeyframeAnimation2.setValueCallback(lottieValueCallback);
        } else {
            if (t != LottieProperty.TEXT_TRACKING || (baseKeyframeAnimation = this.trackingAnimation) == null) {
                return;
            }
            baseKeyframeAnimation.setValueCallback(lottieValueCallback);
        }
    }

    @Override // com.yfanads.android.libs.thirdpart.lottie.model.layer.BaseLayer
    public void drawLayer(Canvas canvas, Matrix matrix, int i) {
        Paint paint;
        float fDpScale;
        canvas.save();
        if (!this.lottieDrawable.useTextGlyphs()) {
            canvas.setMatrix(matrix);
        }
        DocumentData value = this.textAnimation.getValue();
        Font font = this.composition.getFonts().get(value.fontName);
        if (font == null) {
            canvas.restore();
            return;
        }
        BaseKeyframeAnimation<Integer, Integer> baseKeyframeAnimation = this.colorAnimation;
        if (baseKeyframeAnimation != null) {
            this.fillPaint.setColor(baseKeyframeAnimation.getValue().intValue());
        } else {
            this.fillPaint.setColor(value.color);
        }
        BaseKeyframeAnimation<Integer, Integer> baseKeyframeAnimation2 = this.strokeColorAnimation;
        if (baseKeyframeAnimation2 != null) {
            this.strokePaint.setColor(baseKeyframeAnimation2.getValue().intValue());
        } else {
            this.strokePaint.setColor(value.strokeColor);
        }
        int iIntValue = (this.transform.getOpacity().getValue().intValue() * 255) / 100;
        this.fillPaint.setAlpha(iIntValue);
        this.strokePaint.setAlpha(iIntValue);
        BaseKeyframeAnimation<Float, Float> baseKeyframeAnimation3 = this.strokeWidthAnimation;
        if (baseKeyframeAnimation3 != null) {
            paint = this.strokePaint;
            fDpScale = baseKeyframeAnimation3.getValue().floatValue();
        } else {
            float scale = Utils.getScale(matrix);
            paint = this.strokePaint;
            fDpScale = (float) (value.strokeWidth * ((double) Utils.dpScale()) * ((double) scale));
        }
        paint.setStrokeWidth(fDpScale);
        if (this.lottieDrawable.useTextGlyphs()) {
            drawTextGlyphs(value, matrix, font, canvas);
        } else {
            drawTextWithFont(value, font, matrix, canvas);
        }
        canvas.restore();
    }
}
