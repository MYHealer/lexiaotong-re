package com.yfanads.android.libs.thirdpart.lottie.parser;

import android.util.JsonReader;
import com.yfanads.android.libs.thirdpart.lottie.LottieComposition;
import com.yfanads.android.libs.thirdpart.lottie.model.FontCharacter;
import com.yfanads.android.libs.thirdpart.lottie.model.content.ShapeGroup;
import java.util.ArrayList;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
class FontCharacterParser {
    private FontCharacterParser() {
    }

    public static FontCharacter parse(JsonReader jsonReader, LottieComposition lottieComposition) {
        ArrayList arrayList = new ArrayList();
        jsonReader.beginObject();
        double dNextDouble = 0.0d;
        String strNextString = null;
        String strNextString2 = null;
        char cCharAt = 0;
        double dNextDouble2 = 0.0d;
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.getClass();
            strNextName.hashCode();
            switch (strNextName) {
                case "fFamily":
                    strNextString2 = jsonReader.nextString();
                    break;
                case "w":
                    dNextDouble = jsonReader.nextDouble();
                    break;
                case "ch":
                    cCharAt = jsonReader.nextString().charAt(0);
                    break;
                case "data":
                    jsonReader.beginObject();
                    while (jsonReader.hasNext()) {
                        if ("shapes".equals(jsonReader.nextName())) {
                            jsonReader.beginArray();
                            while (jsonReader.hasNext()) {
                                arrayList.add((ShapeGroup) ContentModelParser.parse(jsonReader, lottieComposition));
                            }
                            jsonReader.endArray();
                        } else {
                            jsonReader.skipValue();
                        }
                    }
                    jsonReader.endObject();
                    break;
                case "size":
                    dNextDouble2 = jsonReader.nextDouble();
                    break;
                case "style":
                    strNextString = jsonReader.nextString();
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        return new FontCharacter(arrayList, cCharAt, dNextDouble2, dNextDouble, strNextString, strNextString2);
    }
}
