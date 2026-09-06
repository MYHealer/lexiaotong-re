package com.yfanads.android.libs.thirdpart.lottie.parser;

import android.graphics.Path;
import android.util.JsonReader;
import com.kuaishou.weapon.p0.t;
import com.yfanads.android.libs.thirdpart.lottie.LottieComposition;
import com.yfanads.android.libs.thirdpart.lottie.model.animatable.AnimatableGradientColorValue;
import com.yfanads.android.libs.thirdpart.lottie.model.animatable.AnimatableIntegerValue;
import com.yfanads.android.libs.thirdpart.lottie.model.animatable.AnimatablePointValue;
import com.yfanads.android.libs.thirdpart.lottie.model.content.GradientFill;
import com.yfanads.android.libs.thirdpart.lottie.model.content.GradientType;
import java.io.IOException;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
class GradientFillParser {
    private GradientFillParser() {
    }

    public static GradientFill parse(JsonReader jsonReader, LottieComposition lottieComposition) throws IOException {
        String strNextString = null;
        GradientType gradientType = null;
        Path.FillType fillType = null;
        AnimatableGradientColorValue gradientColor = null;
        AnimatableIntegerValue integer = null;
        AnimatablePointValue point = null;
        AnimatablePointValue point2 = null;
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.getClass();
            strNextName.hashCode();
            int iNextInt = -1;
            switch (strNextName) {
                case "e":
                    point2 = AnimatableValueParser.parsePoint(jsonReader, lottieComposition);
                    break;
                case "g":
                    jsonReader.beginObject();
                    while (jsonReader.hasNext()) {
                        String strNextName2 = jsonReader.nextName();
                        strNextName2.getClass();
                        if (strNextName2.equals(t.f4727a)) {
                            gradientColor = AnimatableValueParser.parseGradientColor(jsonReader, lottieComposition, iNextInt);
                        } else if (strNextName2.equals("p")) {
                            iNextInt = jsonReader.nextInt();
                        } else {
                            jsonReader.skipValue();
                        }
                    }
                    jsonReader.endObject();
                    break;
                case "o":
                    integer = AnimatableValueParser.parseInteger(jsonReader, lottieComposition);
                    break;
                case "r":
                    if (jsonReader.nextInt() != 1) {
                        fillType = Path.FillType.EVEN_ODD;
                        break;
                    } else {
                        fillType = Path.FillType.WINDING;
                        break;
                    }
                    break;
                case "s":
                    point = AnimatableValueParser.parsePoint(jsonReader, lottieComposition);
                    break;
                case "t":
                    if (jsonReader.nextInt() != 1) {
                        gradientType = GradientType.Radial;
                        break;
                    } else {
                        gradientType = GradientType.Linear;
                        break;
                    }
                    break;
                case "nm":
                    strNextString = jsonReader.nextString();
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        return new GradientFill(strNextString, gradientType, fillType, gradientColor, integer, point, point2, null, null);
    }
}
