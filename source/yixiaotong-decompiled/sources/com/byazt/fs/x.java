package com.byazt.fs;

import android.util.JsonReader;
import java.io.IOException;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, 720, 71})
public class x {
    public static com.byazt.jx.ve c(JsonReader jsonReader, com.byazt.ga.a aVar) throws IOException {
        com.byazt.jx.ve veVarC;
        String strNextString;
        jsonReader.beginObject();
        byte b = 2;
        int iNextInt = 2;
        while (true) {
            veVarC = null;
            if (!jsonReader.hasNext()) {
                strNextString = null;
                break;
            }
            String strNextName = jsonReader.nextName();
            strNextName.hashCode();
            if (strNextName.equals(com.kuaishou.weapon.p0.t.t)) {
                iNextInt = jsonReader.nextInt();
            } else {
                if (strNextName.equals(com.alipay.sdk.sys.a.g)) {
                    strNextString = jsonReader.nextString();
                    break;
                }
                jsonReader.skipValue();
            }
        }
        if (strNextString == null) {
            return null;
        }
        strNextString.hashCode();
        switch (strNextString.hashCode()) {
            case 3239:
                b = !strNextString.equals(com.kuaishou.weapon.p0.t.n) ? (byte) -1 : (byte) 0;
                break;
            case 3270:
                b = !strNextString.equals("fl") ? (byte) -1 : (byte) 1;
                break;
            case 3295:
                if (!strNextString.equals("gf")) {
                    b = -1;
                }
                break;
            case 3307:
                b = !strNextString.equals("gr") ? (byte) -1 : (byte) 3;
                break;
            case 3308:
                b = !strNextString.equals("gs") ? (byte) -1 : (byte) 4;
                break;
            case 3488:
                b = !strNextString.equals("mm") ? (byte) -1 : (byte) 5;
                break;
            case 3633:
                b = !strNextString.equals("rc") ? (byte) -1 : (byte) 6;
                break;
            case 3634:
                b = !strNextString.equals("rd") ? (byte) -1 : (byte) 7;
                break;
            case 3646:
                b = !strNextString.equals("rp") ? (byte) -1 : (byte) 8;
                break;
            case 3669:
                b = !strNextString.equals("sh") ? (byte) -1 : (byte) 9;
                break;
            case 3679:
                b = !strNextString.equals("sr") ? (byte) -1 : (byte) 10;
                break;
            case 3681:
                b = !strNextString.equals("st") ? (byte) -1 : (byte) 11;
                break;
            case 3705:
                b = !strNextString.equals("tm") ? (byte) -1 : (byte) 12;
                break;
            case 3710:
                b = !strNextString.equals("tr") ? (byte) -1 : (byte) 13;
                break;
            default:
                b = -1;
                break;
        }
        switch (b) {
            case 0:
                veVarC = a.c(jsonReader, aVar, iNextInt);
                break;
            case 1:
                veVarC = qp.c(jsonReader, aVar);
                break;
            case 2:
                veVarC = m.c(jsonReader, aVar);
                break;
            case 3:
                veVarC = nb.c(jsonReader, aVar);
                break;
            case 4:
                veVarC = nu.c(jsonReader, aVar);
                break;
            case 5:
                veVarC = zm.c(jsonReader);
                aVar.c("Animation contains merge paths. Merge paths are only supported on KitKat+ and must be manually enabled by calling enableMergePathsForKitKatAndAbove().");
                break;
            case 6:
                veVarC = d.c(jsonReader, aVar);
                break;
            case 7:
                veVarC = zb.c(jsonReader, aVar);
                break;
            case 8:
                veVarC = eo.c(jsonReader, aVar);
                break;
            case 9:
                veVarC = pf.c(jsonReader, aVar);
                break;
            case 10:
                veVarC = h.c(jsonReader, aVar, iNextInt);
                break;
            case 11:
                veVarC = bx.c(jsonReader, aVar);
                break;
            case 12:
                veVarC = sv.c(jsonReader, aVar);
                break;
            case 13:
                veVarC = ve.c(jsonReader, aVar);
                break;
            default:
                com.byazt.kk.a.tt("Unknown shape type ".concat(String.valueOf(strNextString)));
                break;
        }
        while (jsonReader.hasNext()) {
            jsonReader.skipValue();
        }
        jsonReader.endObject();
        return veVarC;
    }
}
