package com.yfanads.android.libs.thirdpart.lottie.parser;

import android.graphics.PointF;
import android.util.JsonReader;
import android.util.JsonToken;
import com.yfanads.android.libs.thirdpart.lottie.LottieComposition;
import com.yfanads.android.libs.thirdpart.lottie.model.animatable.AnimatableFloatValue;
import com.yfanads.android.libs.thirdpart.lottie.model.animatable.AnimatablePathValue;
import com.yfanads.android.libs.thirdpart.lottie.model.animatable.AnimatableSplitDimensionPathValue;
import com.yfanads.android.libs.thirdpart.lottie.model.animatable.AnimatableValue;
import com.yfanads.android.libs.thirdpart.lottie.utils.Utils;
import com.yfanads.android.libs.thirdpart.lottie.value.Keyframe;
import java.util.ArrayList;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public class AnimatablePathValueParser {
    private AnimatablePathValueParser() {
    }

    public static AnimatablePathValue parse(JsonReader jsonReader, LottieComposition lottieComposition) {
        ArrayList arrayList = new ArrayList();
        if (jsonReader.peek() == JsonToken.BEGIN_ARRAY) {
            jsonReader.beginArray();
            while (jsonReader.hasNext()) {
                arrayList.add(PathKeyframeParser.parse(jsonReader, lottieComposition));
            }
            jsonReader.endArray();
            KeyframesParser.setEndFrames(arrayList);
        } else {
            arrayList.add(new Keyframe(JsonUtils.jsonToPoint(jsonReader, Utils.dpScale())));
        }
        return new AnimatablePathValue(arrayList);
    }

    public static AnimatableValue<PointF, PointF> parseSplitPath(JsonReader jsonReader, LottieComposition lottieComposition) {
        jsonReader.beginObject();
        AnimatablePathValue animatablePathValue = null;
        AnimatableFloatValue animatableFloatValue = null;
        AnimatableFloatValue animatableFloatValue2 = null;
        boolean z = false;
        while (jsonReader.peek() != JsonToken.END_OBJECT) {
            String strNextName = jsonReader.nextName();
            strNextName.getClass();
            strNextName.hashCode();
            switch (strNextName) {
                case "k":
                    animatablePathValue = parse(jsonReader, lottieComposition);
                    continue;
                    break;
                case "x":
                    if (jsonReader.peek() == JsonToken.STRING) {
                        break;
                    } else {
                        animatableFloatValue = AnimatableValueParser.parseFloat(jsonReader, lottieComposition);
                    }
                    break;
                case "y":
                    if (jsonReader.peek() == JsonToken.STRING) {
                        break;
                    } else {
                        animatableFloatValue2 = AnimatableValueParser.parseFloat(jsonReader, lottieComposition);
                    }
                    break;
                default:
                    jsonReader.skipValue();
                    continue;
                    break;
            }
            jsonReader.skipValue();
            z = true;
        }
        jsonReader.endObject();
        if (z) {
            lottieComposition.addWarning("Lottie doesn't support expressions.");
        }
        return animatablePathValue != null ? animatablePathValue : new AnimatableSplitDimensionPathValue(animatableFloatValue, animatableFloatValue2);
    }
}
