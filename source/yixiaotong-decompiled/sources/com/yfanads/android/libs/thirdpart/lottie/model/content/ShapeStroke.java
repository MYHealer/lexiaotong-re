package com.yfanads.android.libs.thirdpart.lottie.model.content;

import android.graphics.Paint;
import com.yfanads.android.libs.thirdpart.lottie.LottieDrawable;
import com.yfanads.android.libs.thirdpart.lottie.animation.content.Content;
import com.yfanads.android.libs.thirdpart.lottie.animation.content.StrokeContent;
import com.yfanads.android.libs.thirdpart.lottie.model.animatable.AnimatableColorValue;
import com.yfanads.android.libs.thirdpart.lottie.model.animatable.AnimatableFloatValue;
import com.yfanads.android.libs.thirdpart.lottie.model.animatable.AnimatableIntegerValue;
import com.yfanads.android.libs.thirdpart.lottie.model.layer.BaseLayer;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public class ShapeStroke implements ContentModel {
    private final LineCapType capType;
    private final AnimatableColorValue color;
    private final LineJoinType joinType;
    private final List<AnimatableFloatValue> lineDashPattern;
    private final float miterLimit;
    private final String name;
    private final AnimatableFloatValue offset;
    private final AnimatableIntegerValue opacity;
    private final AnimatableFloatValue width;

    /* JADX INFO: renamed from: com.yfanads.android.libs.thirdpart.lottie.model.content.ShapeStroke$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$yfanads$android$libs$thirdpart$lottie$model$content$ShapeStroke$LineCapType;
        static final /* synthetic */ int[] $SwitchMap$com$yfanads$android$libs$thirdpart$lottie$model$content$ShapeStroke$LineJoinType;

        static {
            int[] iArr = new int[LineJoinType.values().length];
            $SwitchMap$com$yfanads$android$libs$thirdpart$lottie$model$content$ShapeStroke$LineJoinType = iArr;
            try {
                iArr[LineJoinType.Bevel.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$yfanads$android$libs$thirdpart$lottie$model$content$ShapeStroke$LineJoinType[LineJoinType.Miter.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$yfanads$android$libs$thirdpart$lottie$model$content$ShapeStroke$LineJoinType[LineJoinType.Round.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            int[] iArr2 = new int[LineCapType.values().length];
            $SwitchMap$com$yfanads$android$libs$thirdpart$lottie$model$content$ShapeStroke$LineCapType = iArr2;
            try {
                iArr2[LineCapType.Butt.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$yfanads$android$libs$thirdpart$lottie$model$content$ShapeStroke$LineCapType[LineCapType.Round.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$yfanads$android$libs$thirdpart$lottie$model$content$ShapeStroke$LineCapType[LineCapType.Unknown.ordinal()] = 3;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    public enum LineCapType {
        Butt,
        Round,
        Unknown;

        public Paint.Cap toPaintCap() {
            int i = AnonymousClass1.$SwitchMap$com$yfanads$android$libs$thirdpart$lottie$model$content$ShapeStroke$LineCapType[ordinal()];
            if (i != 1) {
                return i != 2 ? Paint.Cap.SQUARE : Paint.Cap.ROUND;
            }
            return Paint.Cap.BUTT;
        }
    }

    public enum LineJoinType {
        Miter,
        Round,
        Bevel;

        public Paint.Join toPaintJoin() {
            int i = AnonymousClass1.$SwitchMap$com$yfanads$android$libs$thirdpart$lottie$model$content$ShapeStroke$LineJoinType[ordinal()];
            if (i == 1) {
                return Paint.Join.BEVEL;
            }
            if (i == 2) {
                return Paint.Join.MITER;
            }
            if (i != 3) {
                return null;
            }
            return Paint.Join.ROUND;
        }
    }

    public ShapeStroke(String str, AnimatableFloatValue animatableFloatValue, List<AnimatableFloatValue> list, AnimatableColorValue animatableColorValue, AnimatableIntegerValue animatableIntegerValue, AnimatableFloatValue animatableFloatValue2, LineCapType lineCapType, LineJoinType lineJoinType, float f) {
        this.name = str;
        this.offset = animatableFloatValue;
        this.lineDashPattern = list;
        this.color = animatableColorValue;
        this.opacity = animatableIntegerValue;
        this.width = animatableFloatValue2;
        this.capType = lineCapType;
        this.joinType = lineJoinType;
        this.miterLimit = f;
    }

    public LineCapType getCapType() {
        return this.capType;
    }

    public AnimatableColorValue getColor() {
        return this.color;
    }

    public AnimatableFloatValue getDashOffset() {
        return this.offset;
    }

    public LineJoinType getJoinType() {
        return this.joinType;
    }

    public List<AnimatableFloatValue> getLineDashPattern() {
        return this.lineDashPattern;
    }

    public float getMiterLimit() {
        return this.miterLimit;
    }

    public String getName() {
        return this.name;
    }

    public AnimatableIntegerValue getOpacity() {
        return this.opacity;
    }

    public AnimatableFloatValue getWidth() {
        return this.width;
    }

    @Override // com.yfanads.android.libs.thirdpart.lottie.model.content.ContentModel
    public Content toContent(LottieDrawable lottieDrawable, BaseLayer baseLayer) {
        return new StrokeContent(lottieDrawable, baseLayer, this);
    }
}
