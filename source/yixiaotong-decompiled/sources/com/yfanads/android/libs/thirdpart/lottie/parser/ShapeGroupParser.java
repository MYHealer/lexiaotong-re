package com.yfanads.android.libs.thirdpart.lottie.parser;

import android.util.JsonReader;
import com.yfanads.android.libs.thirdpart.lottie.LottieComposition;
import com.yfanads.android.libs.thirdpart.lottie.model.content.ContentModel;
import com.yfanads.android.libs.thirdpart.lottie.model.content.ShapeGroup;
import java.io.IOException;
import java.util.ArrayList;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
class ShapeGroupParser {
    private ShapeGroupParser() {
    }

    public static ShapeGroup parse(JsonReader jsonReader, LottieComposition lottieComposition) throws IOException {
        ArrayList arrayList = new ArrayList();
        String strNextString = null;
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.getClass();
            if (strNextName.equals("it")) {
                jsonReader.beginArray();
                while (jsonReader.hasNext()) {
                    ContentModel contentModel = ContentModelParser.parse(jsonReader, lottieComposition);
                    if (contentModel != null) {
                        arrayList.add(contentModel);
                    }
                }
                jsonReader.endArray();
            } else if (strNextName.equals("nm")) {
                strNextString = jsonReader.nextString();
            } else {
                jsonReader.skipValue();
            }
        }
        return new ShapeGroup(strNextString, arrayList);
    }
}
