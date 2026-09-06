package com.yfanads.android.libs.thirdpart.lottie.parser;

import android.graphics.PointF;
import android.util.JsonReader;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public class PathParser implements ValueParser<PointF> {
    public static final PathParser INSTANCE = new PathParser();

    private PathParser() {
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.yfanads.android.libs.thirdpart.lottie.parser.ValueParser
    public PointF parse(JsonReader jsonReader, float f) {
        return JsonUtils.jsonToPoint(jsonReader, f);
    }
}
