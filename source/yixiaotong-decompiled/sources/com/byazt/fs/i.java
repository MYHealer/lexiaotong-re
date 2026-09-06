package com.byazt.fs;

import android.graphics.PointF;
import android.util.JsonReader;
import java.io.IOException;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, 720, 42})
public class i implements aw<com.byazt.nb.tt> {
    public static final i c = new i();

    private i() {
    }

    @Override // com.byazt.fs.aw
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public com.byazt.nb.tt tt(JsonReader jsonReader, float f) throws IOException {
        float f2;
        PointF pointF;
        com.byazt.nb.n nVar;
        com.byazt.nb.tt.c cVar = com.byazt.nb.tt.c.CENTER;
        com.byazt.nb.n nVar2 = new com.byazt.nb.n();
        jsonReader.beginObject();
        com.byazt.nb.tt.c cVar2 = cVar;
        String strNextString = null;
        PointF pointF2 = null;
        PointF pointF3 = null;
        String strNextString2 = null;
        String strNextString3 = null;
        float fNextDouble = 0.0f;
        float fNextDouble2 = 0.0f;
        float fNextDouble3 = 0.0f;
        float fNextDouble4 = 0.0f;
        int iNextInt = 0;
        int iC = 0;
        int iC2 = 0;
        boolean zNextBoolean = true;
        String strNextString4 = null;
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.hashCode();
            switch (strNextName) {
                case "f":
                    strNextString = jsonReader.nextString();
                    continue;
                    break;
                case "j":
                    f2 = fNextDouble;
                    pointF = pointF2;
                    nVar = nVar2;
                    int iNextInt2 = jsonReader.nextInt();
                    if (iNextInt2 > com.byazt.nb.tt.c.CENTER.ordinal() || iNextInt2 < 0) {
                        cVar2 = com.byazt.nb.tt.c.CENTER;
                        break;
                    } else {
                        cVar2 = com.byazt.nb.tt.c.values()[iNextInt2];
                        break;
                    }
                    break;
                case "s":
                    fNextDouble = (float) jsonReader.nextDouble();
                    continue;
                    break;
                case "t":
                    f2 = fNextDouble;
                    pointF = pointF2;
                    nVar = nVar2;
                    strNextString4 = jsonReader.nextString();
                    if (strNextString4 == null) {
                        strNextString4 = "";
                        break;
                    }
                    break;
                case "fc":
                    iC = my.c(jsonReader);
                    continue;
                    break;
                case "lh":
                    fNextDouble2 = (float) jsonReader.nextDouble();
                    continue;
                    break;
                case "ls":
                    fNextDouble3 = (float) jsonReader.nextDouble();
                    continue;
                    break;
                case "of":
                    zNextBoolean = jsonReader.nextBoolean();
                    continue;
                    break;
                case "ps":
                    jsonReader.beginArray();
                    pointF2 = new PointF(((float) jsonReader.nextDouble()) * f, ((float) jsonReader.nextDouble()) * f);
                    jsonReader.endArray();
                    fNextDouble = fNextDouble;
                    continue;
                    break;
                case "sc":
                    iC2 = my.c(jsonReader);
                    continue;
                    break;
                case "sw":
                    fNextDouble4 = (float) jsonReader.nextDouble();
                    continue;
                    break;
                case "sz":
                    jsonReader.beginArray();
                    f2 = fNextDouble;
                    pointF = pointF2;
                    nVar = nVar2;
                    PointF pointF4 = new PointF(((float) jsonReader.nextDouble()) * f, ((float) jsonReader.nextDouble()) * f);
                    jsonReader.endArray();
                    pointF3 = pointF4;
                    break;
                case "tr":
                    iNextInt = jsonReader.nextInt();
                    continue;
                    break;
                case "els":
                    strNextString3 = jsonReader.nextString();
                    continue;
                    break;
                case "elt":
                    strNextString2 = jsonReader.nextString();
                    continue;
                    break;
                case "line_cfg":
                    c(jsonReader, nVar2);
                    continue;
                    break;
                default:
                    jsonReader.skipValue();
                    f2 = fNextDouble;
                    pointF = pointF2;
                    nVar = nVar2;
                    break;
            }
            fNextDouble = f2;
            nVar2 = nVar;
            pointF2 = pointF;
        }
        jsonReader.endObject();
        return new com.byazt.nb.tt(strNextString4, strNextString, fNextDouble, cVar2, iNextInt, fNextDouble2, fNextDouble3, iC, iC2, fNextDouble4, zNextBoolean, pointF2, pointF3, nVar2, strNextString2, strNextString3);
    }

    private static void c(JsonReader jsonReader, com.byazt.nb.n nVar) throws IOException {
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.hashCode();
            if (strNextName.equals(com.kuaishou.weapon.p0.t.d)) {
                nVar.c = jsonReader.nextInt();
            } else if (strNextName.equals("m")) {
                int iNextInt = jsonReader.nextInt();
                if (iNextInt > 3 || iNextInt < 0) {
                    nVar.tt = 0;
                } else {
                    nVar.tt = iNextInt;
                }
            } else {
                jsonReader.skipValue();
            }
        }
        jsonReader.endObject();
    }
}
