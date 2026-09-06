package com.byazt.fs;

import android.util.JsonReader;
import java.io.IOException;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, 720, 158})
public class sl {
    public com.byazt.kd.c c;
    public com.byazt.kd.tt n;
    public com.byazt.kd.tt tt;
    public com.byazt.kd.tt uj;
    public com.byazt.kd.tt ve;

    public da c(JsonReader jsonReader, com.byazt.ga.a aVar) throws IOException {
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.hashCode();
            if (strNextName.equals("ef")) {
                jsonReader.beginArray();
                while (jsonReader.hasNext()) {
                    tt(jsonReader, aVar);
                }
                jsonReader.endArray();
            } else {
                jsonReader.skipValue();
            }
        }
        if (this.c == null || this.tt == null || this.ve == null || this.uj == null || this.n == null) {
            return null;
        }
        return new da(this.c, this.tt, this.ve, this.uj, this.n);
    }

    private void tt(JsonReader jsonReader, com.byazt.ga.a aVar) throws IOException {
        jsonReader.beginObject();
        String strNextString = "";
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.hashCode();
            if (strNextName.equals("v")) {
                strNextString.hashCode();
                switch (strNextString) {
                    case "Distance":
                        this.uj = uj.c(jsonReader, aVar);
                        break;
                    case "Opacity":
                        this.tt = uj.c(jsonReader, aVar, false);
                        break;
                    case "Direction":
                        this.ve = uj.c(jsonReader, aVar, false);
                        break;
                    case "Shadow Color":
                        this.c = uj.sp(jsonReader, aVar);
                        break;
                    case "Softness":
                        this.n = uj.c(jsonReader, aVar);
                        break;
                    default:
                        jsonReader.skipValue();
                        break;
                }
            } else if (strNextName.equals("nm")) {
                strNextString = jsonReader.nextString();
            } else {
                jsonReader.skipValue();
            }
        }
        jsonReader.endObject();
    }
}
