package com.yfanads.android.libs.thirdpart.lottie.parser;

import android.util.JsonReader;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public class IntegerParser implements ValueParser<Integer> {
    public static final IntegerParser INSTANCE = new IntegerParser();

    private IntegerParser() {
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.yfanads.android.libs.thirdpart.lottie.parser.ValueParser
    public Integer parse(JsonReader jsonReader, float f) {
        return Integer.valueOf(Math.round(JsonUtils.valueFromObject(jsonReader) * f));
    }
}
