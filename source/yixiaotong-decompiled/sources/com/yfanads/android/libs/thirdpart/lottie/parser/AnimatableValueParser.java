package com.yfanads.android.libs.thirdpart.lottie.parser;

import android.util.JsonReader;
import com.yfanads.android.libs.thirdpart.lottie.LottieComposition;
import com.yfanads.android.libs.thirdpart.lottie.model.animatable.AnimatableColorValue;
import com.yfanads.android.libs.thirdpart.lottie.model.animatable.AnimatableFloatValue;
import com.yfanads.android.libs.thirdpart.lottie.model.animatable.AnimatableGradientColorValue;
import com.yfanads.android.libs.thirdpart.lottie.model.animatable.AnimatableIntegerValue;
import com.yfanads.android.libs.thirdpart.lottie.model.animatable.AnimatablePointValue;
import com.yfanads.android.libs.thirdpart.lottie.model.animatable.AnimatableScaleValue;
import com.yfanads.android.libs.thirdpart.lottie.model.animatable.AnimatableShapeValue;
import com.yfanads.android.libs.thirdpart.lottie.model.animatable.AnimatableTextFrame;
import com.yfanads.android.libs.thirdpart.lottie.utils.Utils;
import com.yfanads.android.libs.thirdpart.lottie.value.Keyframe;
import com.yfanads.android.libs.thirdpart.lottie.value.ScaleXY;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public class AnimatableValueParser {
    private AnimatableValueParser() {
    }

    private static <T> List<Keyframe<T>> parse(JsonReader jsonReader, float f, LottieComposition lottieComposition, ValueParser<T> valueParser) {
        return KeyframesParser.parse(jsonReader, lottieComposition, f, valueParser);
    }

    private static <T> List<Keyframe<T>> parse(JsonReader jsonReader, LottieComposition lottieComposition, ValueParser<T> valueParser) {
        return KeyframesParser.parse(jsonReader, lottieComposition, 1.0f, valueParser);
    }

    public static AnimatableColorValue parseColor(JsonReader jsonReader, LottieComposition lottieComposition) {
        return new AnimatableColorValue(parse(jsonReader, lottieComposition, ColorParser.INSTANCE));
    }

    public static AnimatableTextFrame parseDocumentData(JsonReader jsonReader, LottieComposition lottieComposition) {
        return new AnimatableTextFrame(parse(jsonReader, lottieComposition, DocumentDataParser.INSTANCE));
    }

    public static AnimatableFloatValue parseFloat(JsonReader jsonReader, LottieComposition lottieComposition) {
        return parseFloat(jsonReader, lottieComposition, true);
    }

    public static AnimatableFloatValue parseFloat(JsonReader jsonReader, LottieComposition lottieComposition, boolean z) {
        return new AnimatableFloatValue(parse(jsonReader, z ? Utils.dpScale() : 1.0f, lottieComposition, FloatParser.INSTANCE));
    }

    public static AnimatableGradientColorValue parseGradientColor(JsonReader jsonReader, LottieComposition lottieComposition, int i) {
        return new AnimatableGradientColorValue(parse(jsonReader, lottieComposition, new GradientColorParser(i)));
    }

    public static AnimatableIntegerValue parseInteger(JsonReader jsonReader, LottieComposition lottieComposition) {
        return new AnimatableIntegerValue(parse(jsonReader, lottieComposition, IntegerParser.INSTANCE));
    }

    public static AnimatablePointValue parsePoint(JsonReader jsonReader, LottieComposition lottieComposition) {
        return new AnimatablePointValue(parse(jsonReader, Utils.dpScale(), lottieComposition, PointFParser.INSTANCE));
    }

    public static AnimatableScaleValue parseScale(JsonReader jsonReader, LottieComposition lottieComposition) {
        return new AnimatableScaleValue((List<Keyframe<ScaleXY>>) parse(jsonReader, lottieComposition, ScaleXYParser.INSTANCE));
    }

    public static AnimatableShapeValue parseShapeData(JsonReader jsonReader, LottieComposition lottieComposition) {
        return new AnimatableShapeValue(parse(jsonReader, Utils.dpScale(), lottieComposition, ShapeDataParser.INSTANCE));
    }
}
