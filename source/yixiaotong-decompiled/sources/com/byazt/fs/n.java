package com.byazt.fs;

import android.util.JsonReader;
import java.io.IOException;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, 720, 46})
public class n {
    public static com.byazt.jx.c c(JsonReader jsonReader, com.byazt.ga.a aVar) throws IOException {
        com.byazt.jx.c cVar = null;
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.hashCode();
            if (strNextName.equals("ef")) {
                jsonReader.beginArray();
                while (jsonReader.hasNext()) {
                    com.byazt.jx.c cVarTt = tt(jsonReader, aVar);
                    if (cVarTt != null) {
                        cVar = cVarTt;
                    }
                }
                jsonReader.endArray();
            } else {
                jsonReader.skipValue();
            }
        }
        return cVar;
    }

    private static com.byazt.jx.c tt(JsonReader jsonReader, com.byazt.ga.a aVar) throws IOException {
        jsonReader.beginObject();
        com.byazt.jx.c cVar = null;
        while (true) {
            boolean z = false;
            while (true) {
                if (jsonReader.hasNext()) {
                    String strNextName = jsonReader.nextName();
                    strNextName.hashCode();
                    if (strNextName.equals("v")) {
                        if (z) {
                            cVar = new com.byazt.jx.c(uj.c(jsonReader, aVar));
                        } else {
                            jsonReader.skipValue();
                        }
                    } else if (strNextName.equals(com.alipay.sdk.sys.a.g)) {
                        if (jsonReader.nextInt() == 0) {
                            z = true;
                        }
                    } else {
                        jsonReader.skipValue();
                    }
                } else {
                    jsonReader.endObject();
                    return cVar;
                }
            }
        }
    }
}
