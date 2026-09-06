package com.yfanads.android.libs.thirdpart.lottie.parser;

import android.util.JsonReader;
import android.util.Log;
import com.yfanads.android.libs.thirdpart.lottie.LottieComposition;
import com.yfanads.android.libs.thirdpart.lottie.model.animatable.AnimatableIntegerValue;
import com.yfanads.android.libs.thirdpart.lottie.model.animatable.AnimatableShapeValue;
import com.yfanads.android.libs.thirdpart.lottie.model.content.Mask;
import java.io.IOException;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
class MaskParser {
    private MaskParser() {
    }

    public static Mask parse(JsonReader jsonReader, LottieComposition lottieComposition) throws IOException {
        jsonReader.beginObject();
        Mask.MaskMode maskMode = null;
        AnimatableShapeValue shapeData = null;
        AnimatableIntegerValue integer = null;
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.getClass();
            strNextName.hashCode();
            switch (strNextName) {
                case "o":
                    integer = AnimatableValueParser.parseInteger(jsonReader, lottieComposition);
                    break;
                case "pt":
                    shapeData = AnimatableValueParser.parseShapeData(jsonReader, lottieComposition);
                    break;
                case "mode":
                    String strNextString = jsonReader.nextString();
                    strNextString.getClass();
                    strNextString.hashCode();
                    switch (strNextString) {
                        case "a":
                            break;
                        case "i":
                            lottieComposition.addWarning("Animation contains intersect masks. They are not supported but will be treated like add masks.");
                            maskMode = Mask.MaskMode.MaskModeIntersect;
                            continue;
                            break;
                        case "s":
                            maskMode = Mask.MaskMode.MaskModeSubtract;
                            continue;
                            break;
                        default:
                            Log.w("LOTTIE", "Unknown mask mode " + strNextName + ". Defaulting to Add.");
                            break;
                    }
                    maskMode = Mask.MaskMode.MaskModeAdd;
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        return new Mask(maskMode, shapeData, integer);
    }
}
