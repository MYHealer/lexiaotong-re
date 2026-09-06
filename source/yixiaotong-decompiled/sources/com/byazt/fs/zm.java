package com.byazt.fs;

import android.util.JsonReader;
import java.io.IOException;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, 720, 482})
public class zm {
    public static com.byazt.jx.i c(JsonReader jsonReader) throws IOException {
        String strNextString = null;
        com.byazt.jx.i.c cVarC = null;
        boolean zNextBoolean = false;
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.hashCode();
            switch (strNextName) {
                case "hd":
                    zNextBoolean = jsonReader.nextBoolean();
                    break;
                case "mm":
                    cVarC = com.byazt.jx.i.c.c(jsonReader.nextInt());
                    break;
                case "nm":
                    strNextString = jsonReader.nextString();
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        return new com.byazt.jx.i(strNextString, cVarC, zNextBoolean);
    }
}
