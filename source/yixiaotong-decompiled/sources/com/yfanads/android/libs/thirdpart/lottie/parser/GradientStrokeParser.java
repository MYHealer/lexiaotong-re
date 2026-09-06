package com.yfanads.android.libs.thirdpart.lottie.parser;

import android.util.JsonReader;
import com.cdo.oaps.ad.OapsKey;
import com.kuaishou.weapon.p0.t;
import com.yfanads.android.libs.thirdpart.lottie.LottieComposition;
import com.yfanads.android.libs.thirdpart.lottie.model.animatable.AnimatableFloatValue;
import com.yfanads.android.libs.thirdpart.lottie.model.animatable.AnimatableGradientColorValue;
import com.yfanads.android.libs.thirdpart.lottie.model.animatable.AnimatableIntegerValue;
import com.yfanads.android.libs.thirdpart.lottie.model.animatable.AnimatablePointValue;
import com.yfanads.android.libs.thirdpart.lottie.model.content.GradientStroke;
import com.yfanads.android.libs.thirdpart.lottie.model.content.GradientType;
import com.yfanads.android.libs.thirdpart.lottie.model.content.ShapeStroke;
import java.io.IOException;
import java.util.ArrayList;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
class GradientStrokeParser {
    private GradientStrokeParser() {
    }

    public static GradientStroke parse(JsonReader jsonReader, LottieComposition lottieComposition) throws IOException {
        ArrayList arrayList = new ArrayList();
        float fNextDouble = 0.0f;
        String strNextString = null;
        GradientType gradientType = null;
        AnimatableGradientColorValue gradientColor = null;
        AnimatableIntegerValue integer = null;
        AnimatablePointValue point = null;
        AnimatablePointValue point2 = null;
        AnimatableFloatValue animatableFloatValue = null;
        ShapeStroke.LineCapType lineCapType = null;
        ShapeStroke.LineJoinType lineJoinType = null;
        AnimatableFloatValue animatableFloatValue2 = null;
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.getClass();
            strNextName.hashCode();
            AnimatableFloatValue animatableFloatValue3 = animatableFloatValue2;
            float f = fNextDouble;
            switch (strNextName) {
                case "d":
                    jsonReader.beginArray();
                    while (jsonReader.hasNext()) {
                        jsonReader.beginObject();
                        AnimatableFloatValue animatableFloatValue4 = null;
                        String strNextString2 = null;
                        while (jsonReader.hasNext()) {
                            String strNextName2 = jsonReader.nextName();
                            strNextName2.getClass();
                            ShapeStroke.LineJoinType lineJoinType2 = lineJoinType;
                            if (strNextName2.equals("n")) {
                                strNextString2 = jsonReader.nextString();
                            } else if (strNextName2.equals("v")) {
                                animatableFloatValue4 = AnimatableValueParser.parseFloat(jsonReader, lottieComposition);
                            } else {
                                jsonReader.skipValue();
                            }
                            lineJoinType = lineJoinType2;
                        }
                        ShapeStroke.LineJoinType lineJoinType3 = lineJoinType;
                        jsonReader.endObject();
                        if (strNextString2.equals("o")) {
                            animatableFloatValue3 = animatableFloatValue4;
                        } else if (strNextString2.equals(t.t) || strNextString2.equals(OapsKey.KEY_GRADE)) {
                            arrayList.add(animatableFloatValue4);
                        }
                        lineJoinType = lineJoinType3;
                    }
                    ShapeStroke.LineJoinType lineJoinType4 = lineJoinType;
                    jsonReader.endArray();
                    if (arrayList.size() == 1) {
                        arrayList.add((AnimatableFloatValue) arrayList.get(0));
                    }
                    animatableFloatValue2 = animatableFloatValue3;
                    fNextDouble = f;
                    lineJoinType = lineJoinType4;
                    continue;
                    break;
                case "e":
                    point2 = AnimatableValueParser.parsePoint(jsonReader, lottieComposition);
                    break;
                case "g":
                    jsonReader.beginObject();
                    int iNextInt = -1;
                    while (jsonReader.hasNext()) {
                        String strNextName3 = jsonReader.nextName();
                        strNextName3.getClass();
                        if (strNextName3.equals(t.f4727a)) {
                            gradientColor = AnimatableValueParser.parseGradientColor(jsonReader, lottieComposition, iNextInt);
                        } else if (strNextName3.equals("p")) {
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
                case "w":
                    animatableFloatValue = AnimatableValueParser.parseFloat(jsonReader, lottieComposition);
                    break;
                case "lc":
                    lineCapType = ShapeStroke.LineCapType.values()[jsonReader.nextInt() - 1];
                    break;
                case "lj":
                    lineJoinType = ShapeStroke.LineJoinType.values()[jsonReader.nextInt() - 1];
                    break;
                case "ml":
                    fNextDouble = (float) jsonReader.nextDouble();
                    animatableFloatValue2 = animatableFloatValue3;
                    continue;
                    break;
                case "nm":
                    strNextString = jsonReader.nextString();
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
            animatableFloatValue2 = animatableFloatValue3;
            fNextDouble = f;
        }
        return new GradientStroke(strNextString, gradientType, gradientColor, integer, point, point2, animatableFloatValue, lineCapType, lineJoinType, fNextDouble, arrayList, animatableFloatValue2);
    }
}
