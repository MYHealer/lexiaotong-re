package com.byazt.fs;

import android.util.JsonReader;
import android.util.JsonToken;
import com.huawei.openalliance.ad.constant.ai;
import java.io.IOException;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, 720, ai.y})
public class yv {
    public static com.byazt.dg.i c(JsonReader jsonReader, com.byazt.ga.a aVar) throws IOException {
        return new com.byazt.dg.i(aVar, gt.c(jsonReader, aVar, com.byazt.kk.da.c(), p.c, jsonReader.peek() == JsonToken.BEGIN_OBJECT, false));
    }
}
