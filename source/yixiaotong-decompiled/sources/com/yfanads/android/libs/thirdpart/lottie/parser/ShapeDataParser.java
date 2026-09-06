package com.yfanads.android.libs.thirdpart.lottie.parser;

import android.graphics.PointF;
import android.util.JsonReader;
import android.util.JsonToken;
import com.yfanads.android.libs.thirdpart.lottie.model.CubicCurveData;
import com.yfanads.android.libs.thirdpart.lottie.model.content.ShapeData;
import com.yfanads.android.libs.thirdpart.lottie.utils.MiscUtils;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public class ShapeDataParser implements ValueParser<ShapeData> {
    public static final ShapeDataParser INSTANCE = new ShapeDataParser();

    private ShapeDataParser() {
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.yfanads.android.libs.thirdpart.lottie.parser.ValueParser
    public ShapeData parse(JsonReader jsonReader, float f) throws IOException {
        if (jsonReader.peek() == JsonToken.BEGIN_ARRAY) {
            jsonReader.beginArray();
        }
        jsonReader.beginObject();
        List<PointF> listJsonToPoints = null;
        List<PointF> listJsonToPoints2 = null;
        List<PointF> listJsonToPoints3 = null;
        boolean zNextBoolean = false;
        while (true) {
            if (!jsonReader.hasNext()) {
                jsonReader.endObject();
                if (jsonReader.peek() == JsonToken.END_ARRAY) {
                    jsonReader.endArray();
                }
                if (listJsonToPoints == null || listJsonToPoints2 == null || listJsonToPoints3 == null) {
                    throw new IllegalArgumentException("Shape data was missing information.");
                }
                if (listJsonToPoints.isEmpty()) {
                    return new ShapeData(new PointF(), false, Collections.emptyList());
                }
                int size = listJsonToPoints.size();
                PointF pointF = listJsonToPoints.get(0);
                ArrayList arrayList = new ArrayList(size);
                for (int i = 1; i < size; i++) {
                    PointF pointF2 = listJsonToPoints.get(i);
                    int i2 = i - 1;
                    arrayList.add(new CubicCurveData(MiscUtils.addPoints(listJsonToPoints.get(i2), listJsonToPoints3.get(i2)), MiscUtils.addPoints(pointF2, listJsonToPoints2.get(i)), pointF2));
                }
                if (zNextBoolean) {
                    PointF pointF3 = listJsonToPoints.get(0);
                    int i3 = size - 1;
                    arrayList.add(new CubicCurveData(MiscUtils.addPoints(listJsonToPoints.get(i3), listJsonToPoints3.get(i3)), MiscUtils.addPoints(pointF3, listJsonToPoints2.get(0)), pointF3));
                }
                return new ShapeData(pointF, zNextBoolean, arrayList);
            }
            String strNextName = jsonReader.nextName();
            strNextName.getClass();
            strNextName.hashCode();
            switch (strNextName) {
                case "c":
                    zNextBoolean = jsonReader.nextBoolean();
                    break;
                case "i":
                    listJsonToPoints2 = JsonUtils.jsonToPoints(jsonReader, f);
                    break;
                case "o":
                    listJsonToPoints3 = JsonUtils.jsonToPoints(jsonReader, f);
                    break;
                case "v":
                    listJsonToPoints = JsonUtils.jsonToPoints(jsonReader, f);
                    break;
            }
        }
    }
}
