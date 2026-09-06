package com.yfanads.android.libs.thirdpart.lottie.parser;

import android.graphics.PointF;
import android.util.JsonReader;
import com.yfanads.android.libs.thirdpart.lottie.LottieComposition;
import com.yfanads.android.libs.thirdpart.lottie.model.animatable.AnimatableFloatValue;
import com.yfanads.android.libs.thirdpart.lottie.model.animatable.AnimatablePointValue;
import com.yfanads.android.libs.thirdpart.lottie.model.animatable.AnimatableValue;
import com.yfanads.android.libs.thirdpart.lottie.model.content.RectangleShape;
import java.io.IOException;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
class RectangleShapeParser {
    private RectangleShapeParser() {
    }

    public static RectangleShape parse(JsonReader jsonReader, LottieComposition lottieComposition) throws IOException {
        String strNextString = null;
        AnimatableValue<PointF, PointF> splitPath = null;
        AnimatablePointValue point = null;
        AnimatableFloatValue animatableFloatValue = null;
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.getClass();
            strNextName.hashCode();
            switch (strNextName) {
                case "p":
                    splitPath = AnimatablePathValueParser.parseSplitPath(jsonReader, lottieComposition);
                    break;
                case "r":
                    animatableFloatValue = AnimatableValueParser.parseFloat(jsonReader, lottieComposition);
                    break;
                case "s":
                    point = AnimatableValueParser.parsePoint(jsonReader, lottieComposition);
                    break;
                case "nm":
                    strNextString = jsonReader.nextString();
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        return new RectangleShape(strNextString, splitPath, point, animatableFloatValue);
    }
}
