package com.byazt.fs;

import android.graphics.Rect;
import android.util.JsonReader;
import android.util.JsonToken;
import android.util.LongSparseArray;
import android.util.SparseArray;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.bykv.vk.component.ttvideo.LiveConfigKey;
import com.cdo.oaps.ad.Launcher;
import com.cdo.oaps.ad.OapsKey;
import com.umeng.analytics.pro.am;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlinx.coroutines.DebugKt;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, 720, 17})
public class gu {
    public static com.byazt.ga.a c(JsonReader jsonReader) throws IOException {
        float f;
        byte b;
        float fC = com.byazt.kk.da.c();
        LongSparseArray<com.byazt.zk.x> longSparseArray = new LongSparseArray<>();
        ArrayList arrayList = new ArrayList();
        HashMap map = new HashMap();
        HashMap map2 = new HashMap();
        HashMap map3 = new HashMap();
        ArrayList arrayList2 = new ArrayList();
        SparseArray<com.byazt.nb.uj> sparseArray = new SparseArray<>();
        com.byazt.ga.a.uj ujVar = new com.byazt.ga.a.uj();
        com.byazt.ga.a.tt ttVar = new com.byazt.ga.a.tt();
        com.byazt.ga.a.ve veVar = new com.byazt.ga.a.ve();
        com.byazt.ga.a.c cVar = new com.byazt.ga.a.c();
        com.byazt.ga.a aVar = new com.byazt.ga.a();
        jsonReader.beginObject();
        String strNextString = null;
        int iNextInt = 0;
        float fNextDouble = 0.0f;
        float fNextDouble2 = 0.0f;
        float fNextDouble3 = 0.0f;
        int iNextInt2 = 0;
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.hashCode();
            byte b2 = -1;
            switch (strNextName.hashCode()) {
                case -1408207997:
                    f = fC;
                    if (strNextName.equals("assets")) {
                        b2 = 0;
                    }
                    break;
                case -1109732030:
                    f = fC;
                    if (strNextName.equals("layers")) {
                        b2 = 1;
                    }
                    break;
                case -865448777:
                    f = fC;
                    if (strNextName.equals("globalEvent")) {
                        b2 = 2;
                    }
                    break;
                case 104:
                    f = fC;
                    if (strNextName.equals(IAdInterListener.AdReqParam.HEIGHT)) {
                        b = 3;
                        b2 = b;
                    }
                    break;
                case 118:
                    f = fC;
                    if (strNextName.equals("v")) {
                        b = 4;
                        b2 = b;
                    }
                    break;
                case 119:
                    f = fC;
                    if (strNextName.equals(IAdInterListener.AdReqParam.WIDTH)) {
                        b = 5;
                        b2 = b;
                    }
                    break;
                case 3208:
                    f = fC;
                    if (strNextName.equals("dl")) {
                        b = 6;
                        b2 = b;
                    }
                    break;
                case 3276:
                    f = fC;
                    if (strNextName.equals("fr")) {
                        b = 7;
                        b2 = b;
                    }
                    break;
                case 3292:
                    f = fC;
                    if (strNextName.equals(Launcher.Host.GC)) {
                        b = 8;
                        b2 = b;
                    }
                    break;
                case 3367:
                    f = fC;
                    if (strNextName.equals("ip")) {
                        b = 9;
                        b2 = b;
                    }
                    break;
                case 3553:
                    f = fC;
                    if (strNextName.equals("op")) {
                        b = 10;
                        b2 = b;
                    }
                    break;
                case 3002509:
                    f = fC;
                    if (strNextName.equals("area")) {
                        b = 11;
                        b2 = b;
                    }
                    break;
                case 94623709:
                    f = fC;
                    if (strNextName.equals("chars")) {
                        b = 12;
                        b2 = b;
                    }
                    break;
                case 97615364:
                    f = fC;
                    if (strNextName.equals("fonts")) {
                        b = 13;
                        b2 = b;
                    }
                    break;
                case 110364485:
                    f = fC;
                    if (strNextName.equals("timer")) {
                        b = 14;
                        b2 = b;
                    }
                    break;
                case 839250809:
                    f = fC;
                    if (strNextName.equals("markers")) {
                        b = 15;
                        b2 = b;
                    }
                    break;
                default:
                    f = fC;
                    break;
            }
            switch (b2) {
                case 0:
                    c(jsonReader, aVar, map, map2);
                    break;
                case 1:
                    c(jsonReader, aVar, arrayList, longSparseArray);
                    break;
                case 2:
                    c(jsonReader, veVar);
                    break;
                case 3:
                    iNextInt2 = jsonReader.nextInt();
                    break;
                case 4:
                    String[] strArrSplit = jsonReader.nextString().split("\\.");
                    if (!com.byazt.kk.da.c(Integer.parseInt(strArrSplit[0]), Integer.parseInt(strArrSplit[1]), Integer.parseInt(strArrSplit[2]), 4, 4, 0)) {
                        aVar.c("Lottie only supports bodymovin >= 4.4.0");
                    }
                    break;
                case 5:
                    iNextInt = jsonReader.nextInt();
                    break;
                case 6:
                    strNextString = jsonReader.nextString();
                    break;
                case 7:
                    fNextDouble3 = (float) jsonReader.nextDouble();
                    break;
                case 8:
                    c(jsonReader, ttVar);
                    break;
                case 9:
                    fNextDouble = (float) jsonReader.nextDouble();
                    break;
                case 10:
                    fNextDouble2 = ((float) jsonReader.nextDouble()) - 0.01f;
                    break;
                case 11:
                    c(jsonReader, cVar);
                    break;
                case 12:
                    c(jsonReader, aVar, sparseArray);
                    break;
                case 13:
                    c(jsonReader, map3);
                    break;
                case 14:
                    c(jsonReader, ujVar);
                    break;
                case 15:
                    c(jsonReader, arrayList2);
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
            fC = f;
        }
        float f2 = fC;
        jsonReader.endObject();
        aVar.c(new Rect(0, 0, (int) (iNextInt * f2), (int) (iNextInt2 * f2)), fNextDouble, fNextDouble2, fNextDouble3, arrayList, longSparseArray, map, map2, sparseArray, map3, arrayList2, ujVar, strNextString, ttVar, veVar, cVar);
        return aVar;
    }

    /* JADX WARN: Code duplicated, block: B:21:0x0044  */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    private static void c(JsonReader jsonReader, com.byazt.ga.a.c cVar) {
        byte b;
        try {
            jsonReader.beginObject();
            while (jsonReader.hasNext()) {
                String strNextName = jsonReader.nextName();
                int iHashCode = strNextName.hashCode();
                if (iHashCode != 104) {
                    switch (iHashCode) {
                        case 119:
                            if (!strNextName.equals(IAdInterListener.AdReqParam.WIDTH)) {
                                b = -1;
                            } else {
                                b = 2;
                            }
                            break;
                        case 120:
                            if (!strNextName.equals("x")) {
                                b = -1;
                            } else {
                                b = 0;
                            }
                            break;
                        case 121:
                            if (!strNextName.equals("y")) {
                                b = -1;
                            } else {
                                b = 1;
                            }
                            break;
                        default:
                            b = -1;
                            break;
                    }
                } else if (strNextName.equals(IAdInterListener.AdReqParam.HEIGHT)) {
                    b = 3;
                } else {
                    b = -1;
                }
                if (b == 0) {
                    cVar.c = jsonReader.nextString();
                } else if (b == 1) {
                    cVar.tt = jsonReader.nextString();
                } else if (b == 2) {
                    cVar.ve = jsonReader.nextString();
                } else if (b == 3) {
                    cVar.uj = jsonReader.nextString();
                } else {
                    jsonReader.skipValue();
                }
            }
            jsonReader.endObject();
        } catch (Exception e) {
            com.byazt.nr.m.c(e);
        }
    }

    /* JADX WARN: Code duplicated, block: B:26:0x0052  */
    private static void c(JsonReader jsonReader, com.byazt.ga.a.ve veVar) {
        byte b;
        try {
            jsonReader.beginObject();
            while (jsonReader.hasNext()) {
                String strNextName = jsonReader.nextName();
                int iHashCode = strNextName.hashCode();
                if (iHashCode != -1291329255) {
                    if (iHashCode != 3239) {
                        if (iHashCode != 107027) {
                            if (iHashCode == 3237004 && strNextName.equals("inel")) {
                                b = 0;
                            } else {
                                b = -1;
                            }
                        } else if (strNextName.equals("lel")) {
                            b = 2;
                        } else {
                            b = -1;
                        }
                    } else if (strNextName.equals(com.kuaishou.weapon.p0.t.n)) {
                        b = 1;
                    } else {
                        b = -1;
                    }
                } else if (strNextName.equals("events")) {
                    b = 3;
                } else {
                    b = -1;
                }
                if (b == 0) {
                    veVar.tt = new int[][]{new int[]{-1, -1}};
                    jsonReader.beginArray();
                    if (jsonReader.hasNext()) {
                        jsonReader.beginArray();
                        for (int i = 0; i < 2; i++) {
                            if (jsonReader.hasNext()) {
                                veVar.tt[0][i] = jsonReader.nextInt();
                            }
                        }
                        jsonReader.endArray();
                    }
                    jsonReader.endArray();
                } else if (b == 1) {
                    veVar.c = jsonReader.nextString();
                } else if (b == 2) {
                    veVar.ve = n(jsonReader);
                } else if (b == 3) {
                    veVar.n = a(jsonReader);
                } else {
                    jsonReader.skipValue();
                }
            }
            jsonReader.endObject();
        } catch (Exception e) {
            com.byazt.nr.m.c(e);
        }
    }

    /* JADX WARN: Code duplicated, block: B:36:0x006d  */
    private static void c(JsonReader jsonReader, com.byazt.ga.a.tt ttVar) {
        byte b;
        try {
            jsonReader.beginObject();
            while (jsonReader.hasNext()) {
                String strNextName = jsonReader.nextName();
                int iHashCode = strNextName.hashCode();
                if (iHashCode != 3139) {
                    if (iHashCode != 3232) {
                        if (iHashCode != 3571) {
                            if (iHashCode != 3666) {
                                if (iHashCode != 98713) {
                                    if (iHashCode == 120609 && strNextName.equals("zip")) {
                                        b = 5;
                                    } else {
                                        b = -1;
                                    }
                                } else if (strNextName.equals("cpf")) {
                                    b = 4;
                                } else {
                                    b = -1;
                                }
                            } else if (strNextName.equals("se")) {
                                b = 0;
                            } else {
                                b = -1;
                            }
                        } else if (strNextName.equals(com.kuaishou.weapon.p0.t.x)) {
                            b = 3;
                        } else {
                            b = -1;
                        }
                    } else if (strNextName.equals("ee")) {
                        b = 2;
                    } else {
                        b = -1;
                    }
                } else if (strNextName.equals("be")) {
                    b = 1;
                } else {
                    b = -1;
                }
                if (b == 0) {
                    ttVar.c = jsonReader.nextInt();
                } else if (b == 1) {
                    ttVar.tt = ve(jsonReader);
                } else if (b == 2) {
                    ttVar.ve = ve(jsonReader);
                } else if (b == 3) {
                    ttVar.uj = jsonReader.nextInt();
                } else if (b == 4) {
                    tt(jsonReader, ttVar);
                } else if (b == 5) {
                    ttVar.x = tt(jsonReader);
                } else {
                    jsonReader.skipValue();
                }
            }
            jsonReader.endObject();
        } catch (Exception e) {
            com.byazt.nr.m.c(e);
        }
    }

    /* JADX WARN: Code duplicated, block: B:22:0x0045  */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    private static com.byazt.rs.uj tt(JsonReader jsonReader) {
        String strNextString;
        String strNextString2;
        String strNextString3;
        String strNextString4;
        byte b;
        try {
            jsonReader.beginObject();
            strNextString = null;
            strNextString2 = null;
            strNextString3 = null;
            strNextString4 = null;
            while (jsonReader.hasNext()) {
                try {
                    String strNextName = jsonReader.nextName();
                    switch (strNextName.hashCode()) {
                        case -332625698:
                            if (!strNextName.equals("baseUrl")) {
                                b = -1;
                            } else {
                                b = 1;
                            }
                            break;
                        case 107902:
                            if (!strNextName.equals("md5")) {
                                b = -1;
                            } else {
                                b = 2;
                            }
                            break;
                        case 116079:
                            if (!strNextName.equals("url")) {
                                b = -1;
                            } else {
                                b = 0;
                            }
                            break;
                        case 374523318:
                            if (!strNextName.equals("firstImageName")) {
                                b = -1;
                            } else {
                                b = 3;
                            }
                            break;
                        default:
                            b = -1;
                            break;
                    }
                    if (b == 0) {
                        strNextString = jsonReader.nextString();
                    } else if (b == 1) {
                        strNextString2 = jsonReader.nextString();
                    } else if (b == 2) {
                        strNextString3 = jsonReader.nextString();
                    } else if (b == 3) {
                        strNextString4 = jsonReader.nextString();
                    } else {
                        jsonReader.skipValue();
                    }
                } catch (Exception e) {
                    e = e;
                    com.byazt.nr.m.c(e);
                }
            }
            jsonReader.endObject();
        } catch (Exception e2) {
            e = e2;
            strNextString = null;
            strNextString2 = null;
            strNextString3 = null;
            strNextString4 = null;
        }
        if (strNextString == null) {
            return null;
        }
        return new com.byazt.rs.uj(strNextString, strNextString2, strNextString3, strNextString4);
    }

    /* JADX WARN: Code duplicated, block: B:21:0x003f  */
    private static void tt(JsonReader jsonReader, com.byazt.ga.a.tt ttVar) {
        byte b;
        try {
            jsonReader.beginObject();
            while (jsonReader.hasNext()) {
                String strNextName = jsonReader.nextName();
                int iHashCode = strNextName.hashCode();
                if (iHashCode != 3239) {
                    if (iHashCode != 3276) {
                        if (iHashCode == 107027 && strNextName.equals("lel")) {
                            b = 2;
                        } else {
                            b = -1;
                        }
                    } else if (strNextName.equals("fr")) {
                        b = 0;
                    } else {
                        b = -1;
                    }
                } else if (strNextName.equals(com.kuaishou.weapon.p0.t.n)) {
                    b = 1;
                } else {
                    b = -1;
                }
                if (b == 0) {
                    ttVar.n = jsonReader.nextInt();
                } else if (b == 1) {
                    ttVar.f2238a = jsonReader.nextString();
                } else if (b == 2) {
                    ttVar.sp = n(jsonReader);
                } else {
                    jsonReader.skipValue();
                }
            }
            jsonReader.endObject();
        } catch (IOException e) {
            com.byazt.nr.m.c(e);
        }
    }

    private static Map<String, Object> ve(JsonReader jsonReader) throws IOException {
        HashMap map = new HashMap();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.hashCode();
            switch (strNextName) {
                case "el":
                    map.put(com.kuaishou.weapon.p0.t.n, jsonReader.nextString());
                    break;
                case "lel":
                    map.put("lel", n(jsonReader));
                    break;
                case "lottie_back":
                    JSONObject jSONObject = new JSONObject();
                    map.put("lottie_back", jSONObject);
                    jsonReader.beginObject();
                    while (jsonReader.hasNext()) {
                        String strNextName2 = jsonReader.nextName();
                        strNextName2.hashCode();
                        if (strNextName2.equals(LiveConfigKey.HIGH)) {
                            try {
                                jSONObject.putOpt(LiveConfigKey.HIGH, Integer.valueOf(jsonReader.nextInt()));
                                jSONObject.putOpt(OapsKey.KEY_VERID, "lottie_back");
                            } catch (JSONException e) {
                                com.byazt.nr.m.c(e);
                            }
                        } else {
                            jsonReader.skipValue();
                        }
                    }
                    jsonReader.endObject();
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        Object objRemove = map.remove("lottie_back");
        if (objRemove instanceof JSONObject) {
            Object obj = map.get("lel");
            if (obj instanceof JSONArray) {
                ((JSONArray) obj).put(objRemove);
            } else {
                JSONArray jSONArray = new JSONArray();
                jSONArray.put(objRemove);
                map.put("lel", jSONArray);
            }
        }
        return map;
    }

    /* JADX WARN: Code duplicated, block: B:47:0x00a4  */
    private static void c(JsonReader jsonReader, com.byazt.ga.a.uj ujVar) {
        try {
            jsonReader.beginObject();
            while (jsonReader.hasNext()) {
                switch (jsonReader.nextName()) {
                    case "ke":
                        ujVar.c = jsonReader.nextInt();
                        break;
                    case "id":
                        ujVar.tt = jsonReader.nextString();
                        break;
                    case "tl":
                        ujVar.ve = jsonReader.nextString();
                        break;
                    case "at":
                        ujVar.uj = jsonReader.nextString();
                        break;
                    case "inel":
                        ujVar.n = new int[]{-1, -1};
                        jsonReader.beginArray();
                        for (int i = 0; i < 2; i++) {
                            if (jsonReader.hasNext()) {
                                ujVar.n[i] = jsonReader.nextInt();
                            }
                        }
                        jsonReader.endArray();
                        break;
                    case "el":
                        ujVar.f2239a = jsonReader.nextString();
                        break;
                    case "lel":
                        ujVar.sp = n(jsonReader);
                        break;
                    case "begin_el":
                        ujVar.x = jsonReader.nextString();
                        break;
                    case "begin_lel":
                        ujVar.i = n(jsonReader);
                        break;
                    case "lo":
                        ujVar.da = jsonReader.nextInt();
                        break;
                    case "tp":
                        ujVar.sl = jsonReader.nextInt();
                        break;
                    case "ids":
                        ujVar.t = uj(jsonReader);
                        break;
                    case "kp":
                        ujVar.u = jsonReader.nextInt();
                        break;
                    default:
                        jsonReader.skipValue();
                        break;
                }
            }
            jsonReader.endObject();
        } catch (Exception e) {
            com.byazt.nr.m.c(e);
        }
    }

    private static String[] uj(JsonReader jsonReader) {
        String[] strArr = null;
        try {
            jsonReader.beginArray();
            strArr = new String[3];
            for (int i = 0; i < 3; i++) {
                if (jsonReader.hasNext()) {
                    strArr[i] = jsonReader.nextString();
                }
            }
            jsonReader.endArray();
        } catch (Exception e) {
            com.byazt.nr.m.c(e);
        }
        return strArr;
    }

    private static void c(JsonReader jsonReader, com.byazt.ga.a aVar, List<com.byazt.zk.x> list, LongSparseArray<com.byazt.zk.x> longSparseArray) throws IOException {
        jsonReader.beginArray();
        int i = 0;
        while (jsonReader.hasNext()) {
            com.byazt.zk.x xVarC = qy.c(jsonReader, aVar);
            if (xVarC.sl() == com.byazt.zk.x.c.IMAGE) {
                i++;
            }
            list.add(xVarC);
            longSparseArray.put(xVarC.n(), xVarC);
            if (i > 4) {
                com.byazt.kk.a.tt("You have " + i + " images. Lottie should primarily be used with shapes. If you are using Adobe Illustrator, convert the Illustrator layers to shape layers.");
            }
        }
        jsonReader.endArray();
    }

    private static void c(JsonReader jsonReader, com.byazt.ga.a aVar, Map<String, List<com.byazt.zk.x>> map, Map<String, com.byazt.ga.i> map2) throws IOException {
        jsonReader.beginArray();
        while (jsonReader.hasNext()) {
            ArrayList arrayList = new ArrayList();
            LongSparseArray longSparseArray = new LongSparseArray();
            jsonReader.beginObject();
            String strNextString = null;
            String strNextString2 = null;
            String strNextString3 = null;
            String strNextString4 = null;
            List<com.byazt.ga.i.ve> listSp = null;
            String strNextString5 = null;
            int[][] iArr = null;
            JSONArray jSONArrayN = null;
            String strNextString6 = null;
            String strNextString7 = null;
            com.byazt.ga.i.c cVar = null;
            com.byazt.ga.i.tt ttVar = null;
            String strA = null;
            int iNextInt = 0;
            int iNextInt2 = 0;
            while (jsonReader.hasNext()) {
                String strNextName = jsonReader.nextName();
                strNextName.hashCode();
                switch (strNextName) {
                    case "events":
                        strA = a(jsonReader);
                        break;
                    case "layers":
                        jsonReader.beginArray();
                        while (jsonReader.hasNext()) {
                            com.byazt.zk.x xVarC = qy.c(jsonReader, aVar);
                            longSparseArray.put(xVarC.n(), xVarC);
                            arrayList.add(xVarC);
                        }
                        jsonReader.endArray();
                        break;
                    case "rotate":
                        if (jsonReader.peek() == JsonToken.NULL) {
                            jsonReader.nextNull();
                            break;
                        } else {
                            com.byazt.ga.i.tt ttVar2 = new com.byazt.ga.i.tt();
                            jsonReader.beginObject();
                            c(jsonReader, ttVar2);
                            jsonReader.endObject();
                            ttVar = ttVar2;
                            break;
                        }
                        break;
                    case "ugen_v":
                        strNextString7 = jsonReader.nextString();
                        break;
                    case "h":
                        iNextInt2 = jsonReader.nextInt();
                        break;
                    case "p":
                        strNextString2 = jsonReader.nextString();
                        break;
                    case "u":
                        strNextString3 = jsonReader.nextString();
                        break;
                    case "w":
                        iNextInt = jsonReader.nextInt();
                        break;
                    case "el":
                        strNextString5 = jsonReader.nextString();
                        break;
                    case "id":
                        strNextString = jsonReader.nextString();
                        break;
                    case "rc":
                        if (jsonReader.peek() == JsonToken.NULL) {
                            jsonReader.nextNull();
                            break;
                        } else {
                            com.byazt.ga.i.c cVar2 = new com.byazt.ga.i.c();
                            jsonReader.beginObject();
                            c(jsonReader, cVar2);
                            jsonReader.endObject();
                            cVar = cVar2;
                            break;
                        }
                        break;
                    case "tc":
                        jsonReader.beginArray();
                        listSp = sp(jsonReader);
                        jsonReader.endArray();
                        break;
                    case "lel":
                        jSONArrayN = n(jsonReader);
                        break;
                    case "md5":
                        strNextString6 = jsonReader.nextString();
                        break;
                    case "rel":
                        strNextString4 = jsonReader.nextString();
                        break;
                    case "inel":
                        iArr = new int[][]{new int[]{-1, -1}};
                        jsonReader.beginArray();
                        if (jsonReader.hasNext()) {
                            jsonReader.beginArray();
                            for (int i = 0; i < 2; i++) {
                                if (jsonReader.hasNext()) {
                                    iArr[0][i] = jsonReader.nextInt();
                                }
                            }
                            jsonReader.endArray();
                        }
                        jsonReader.endArray();
                        break;
                    default:
                        jsonReader.skipValue();
                        break;
                }
            }
            jsonReader.endObject();
            if (strNextString2 != null) {
                com.byazt.ga.i iVar = new com.byazt.ga.i(iNextInt, iNextInt2, strNextString, strNextString2, strNextString3, strNextString4, listSp, strNextString5, iArr, jSONArrayN, strNextString6, strNextString7, cVar, ttVar, strA);
                map2.put(iVar.t(), iVar);
            } else {
                map.put(strNextString, arrayList);
            }
        }
        jsonReader.endArray();
    }

    /* JADX WARN: Code duplicated, block: B:21:0x0046  */
    private static JSONArray n(JsonReader jsonReader) {
        byte b;
        JSONArray jSONArray = new JSONArray();
        try {
            jsonReader.beginArray();
            while (jsonReader.hasNext()) {
                JSONObject jSONObject = new JSONObject();
                jSONArray.put(jSONObject);
                jsonReader.beginObject();
                while (jsonReader.hasNext()) {
                    String strNextName = jsonReader.nextName();
                    int iHashCode = strNextName.hashCode();
                    if (iHashCode != 3324) {
                        if (iHashCode == 116753 && strNextName.equals(OapsKey.KEY_VERID)) {
                            b = 0;
                        } else {
                            b = -1;
                        }
                    } else if (strNextName.equals(LiveConfigKey.HIGH)) {
                        b = 1;
                    } else {
                        b = -1;
                    }
                    if (b == 0) {
                        try {
                            jSONObject.put(OapsKey.KEY_VERID, jsonReader.nextString());
                        } catch (JSONException e) {
                            com.byazt.nr.m.c(e);
                        }
                    } else if (b == 1) {
                        try {
                            jSONObject.put(LiveConfigKey.HIGH, jsonReader.nextInt());
                        } catch (JSONException e2) {
                            com.byazt.nr.m.c(e2);
                        }
                    } else {
                        jsonReader.skipValue();
                    }
                }
                jsonReader.endObject();
            }
            jsonReader.endArray();
        } catch (Exception e3) {
            com.byazt.nr.m.c(e3);
        }
        return jSONArray;
    }

    /* JADX WARN: Code duplicated, block: B:21:0x0046  */
    private static String a(JsonReader jsonReader) {
        byte b;
        JSONArray jSONArray = new JSONArray();
        try {
            jsonReader.beginArray();
            while (jsonReader.hasNext()) {
                JSONObject jSONObject = new JSONObject();
                jSONArray.put(jSONObject);
                jsonReader.beginObject();
                while (jsonReader.hasNext()) {
                    String strNextName = jsonReader.nextName();
                    int iHashCode = strNextName.hashCode();
                    if (iHashCode != 3551) {
                        if (iHashCode == 2069097 && strNextName.equals("handlers")) {
                            b = 1;
                        } else {
                            b = -1;
                        }
                    } else if (strNextName.equals(DebugKt.DEBUG_PROPERTY_VALUE_ON)) {
                        b = 0;
                    } else {
                        b = -1;
                    }
                    if (b == 0) {
                        try {
                            jSONObject.put(DebugKt.DEBUG_PROPERTY_VALUE_ON, jsonReader.nextString());
                        } catch (JSONException e) {
                            com.byazt.nr.m.c(e);
                        }
                    } else if (b == 1) {
                        try {
                            JSONArray jSONArray2 = new JSONArray();
                            jsonReader.beginArray();
                            while (jsonReader.hasNext()) {
                                jSONArray2.put(jsonReader.nextString());
                            }
                            jsonReader.endArray();
                            jSONObject.put("handlers", jSONArray2);
                        } catch (JSONException e2) {
                            com.byazt.nr.m.c(e2);
                        }
                    } else {
                        jsonReader.skipValue();
                    }
                }
                jsonReader.endObject();
            }
            jsonReader.endArray();
        } catch (Exception e3) {
            com.byazt.nr.m.c(e3);
        }
        return jSONArray.length() > 0 ? jSONArray.toString() : "";
    }

    /* JADX WARN: Code duplicated, block: B:15:0x002d  */
    private static void c(JsonReader jsonReader, com.byazt.ga.i.c cVar) {
        byte b;
        while (jsonReader.hasNext()) {
            try {
                String strNextName = jsonReader.nextName();
                int iHashCode = strNextName.hashCode();
                if (iHashCode != -2128704353) {
                    if (iHashCode == 3308 && strNextName.equals("gs")) {
                        b = 1;
                    } else {
                        b = -1;
                    }
                } else if (strNextName.equals("is_secondary")) {
                    b = 0;
                } else {
                    b = -1;
                }
                if (b == 0) {
                    cVar.tt = jsonReader.nextBoolean();
                } else if (b == 1) {
                    if (jsonReader.peek() == JsonToken.NULL) {
                        jsonReader.nextNull();
                    } else {
                        cVar.c = new com.byazt.ga.i.c.C0157c();
                        jsonReader.beginObject();
                        while (jsonReader.hasNext()) {
                            String strNextName2 = jsonReader.nextName();
                            if (strNextName2.hashCode() == 114 && strNextName2.equals(com.kuaishou.weapon.p0.t.k)) {
                                cVar.c.c = (float) jsonReader.nextDouble();
                            } else {
                                jsonReader.skipValue();
                            }
                        }
                        jsonReader.endObject();
                    }
                } else {
                    jsonReader.skipValue();
                }
            } catch (Exception e) {
                com.byazt.nr.m.c(e);
                return;
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:16:0x0032  */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    private static void c(JsonReader jsonReader, com.byazt.ga.i.tt ttVar) {
        byte b;
        while (jsonReader.hasNext()) {
            try {
                String strNextName = jsonReader.nextName();
                switch (strNextName.hashCode()) {
                    case 120:
                        if (!strNextName.equals("x")) {
                            b = -1;
                        } else {
                            b = 0;
                        }
                        break;
                    case 121:
                        if (!strNextName.equals("y")) {
                            b = -1;
                        } else {
                            b = 1;
                        }
                        break;
                    case 122:
                        if (!strNextName.equals(am.aD)) {
                            b = -1;
                        } else {
                            b = 2;
                        }
                        break;
                    default:
                        b = -1;
                        break;
                }
                if (b == 0) {
                    ttVar.c = jsonReader.nextInt();
                } else if (b == 1) {
                    ttVar.tt = jsonReader.nextInt();
                } else if (b == 2) {
                    ttVar.ve = jsonReader.nextInt();
                } else {
                    jsonReader.skipValue();
                }
            } catch (Exception e) {
                com.byazt.nr.m.c(e);
                return;
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:68:0x00e9  */
    private static List<com.byazt.ga.i.ve> sp(JsonReader jsonReader) {
        byte b;
        try {
            ArrayList arrayList = new ArrayList();
            while (jsonReader.hasNext()) {
                com.byazt.ga.i.ve veVar = new com.byazt.ga.i.ve();
                jsonReader.beginObject();
                while (jsonReader.hasNext()) {
                    switch (jsonReader.nextName()) {
                        case "l":
                            veVar.c = jsonReader.nextInt();
                            break;
                        case "le":
                            veVar.tt = jsonReader.nextInt();
                            break;
                        case "s":
                            veVar.f2242a = jsonReader.nextInt();
                            break;
                        case "els":
                            veVar.sp = jsonReader.nextString();
                            break;
                        case "c":
                            veVar.uj = jsonReader.nextString();
                            break;
                        case "fcl":
                            veVar.ve = jsonReader.nextString();
                            break;
                        case "bold":
                            veVar.x = jsonReader.nextInt();
                            break;
                        case "f":
                            veVar.n = jsonReader.nextString();
                            break;
                        case "bs":
                            veVar.i = jsonReader.nextInt();
                            break;
                        case "ali":
                            veVar.da = jsonReader.nextString();
                            break;
                        case "ul":
                            veVar.sl = x(jsonReader);
                            break;
                        case "st":
                            veVar.t = x(jsonReader);
                            break;
                        case "ml":
                            jsonReader.beginObject();
                            while (jsonReader.hasNext()) {
                                String strNextName = jsonReader.nextName();
                                int iHashCode = strNextName.hashCode();
                                if (iHashCode != 108) {
                                    if (iHashCode == 109 && strNextName.equals("m")) {
                                        b = 0;
                                    } else {
                                        b = -1;
                                    }
                                } else if (strNextName.equals(com.kuaishou.weapon.p0.t.d)) {
                                    b = 1;
                                } else {
                                    b = -1;
                                }
                                if (b == 0) {
                                    veVar.u = jsonReader.nextInt();
                                } else if (b == 1) {
                                    veVar.yp = jsonReader.nextInt();
                                } else {
                                    jsonReader.skipValue();
                                }
                            }
                            jsonReader.endObject();
                            break;
                        default:
                            jsonReader.skipValue();
                            break;
                    }
                }
                jsonReader.endObject();
                arrayList.add(veVar);
            }
            return arrayList;
        } catch (Exception e) {
            com.byazt.nr.m.c(e);
            return null;
        }
    }

    /* JADX WARN: Code duplicated, block: B:16:0x0034  */
    private static com.byazt.ga.i.ve.c x(JsonReader jsonReader) {
        byte b;
        try {
            com.byazt.ga.i.ve.c cVar = new com.byazt.ga.i.ve.c();
            jsonReader.beginObject();
            while (jsonReader.hasNext()) {
                String strNextName = jsonReader.nextName();
                int iHashCode = strNextName.hashCode();
                if (iHashCode != 99) {
                    if (iHashCode == 3706 && strNextName.equals("tn")) {
                        b = 0;
                    } else {
                        b = -1;
                    }
                } else if (strNextName.equals("c")) {
                    b = 1;
                } else {
                    b = -1;
                }
                if (b == 0) {
                    cVar.c = jsonReader.nextInt();
                } else if (b == 1) {
                    cVar.tt = jsonReader.nextString();
                } else {
                    jsonReader.skipValue();
                }
            }
            jsonReader.endObject();
            return cVar;
        } catch (Exception e) {
            com.byazt.nr.m.c(e);
            return null;
        }
    }

    private static void c(JsonReader jsonReader, Map<String, com.byazt.nb.ve> map) throws IOException {
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.hashCode();
            if (strNextName.equals("list")) {
                jsonReader.beginArray();
                while (jsonReader.hasNext()) {
                    com.byazt.nb.ve veVarC = yp.c(jsonReader);
                    map.put(veVarC.tt(), veVarC);
                }
                jsonReader.endArray();
            } else {
                jsonReader.skipValue();
            }
        }
        jsonReader.endObject();
    }

    private static void c(JsonReader jsonReader, com.byazt.ga.a aVar, SparseArray<com.byazt.nb.uj> sparseArray) throws IOException {
        jsonReader.beginArray();
        while (jsonReader.hasNext()) {
            com.byazt.nb.uj ujVarC = u.c(jsonReader, aVar);
            sparseArray.put(ujVarC.hashCode(), ujVarC);
        }
        jsonReader.endArray();
    }

    private static void c(JsonReader jsonReader, List<com.byazt.nb.sp> list) throws IOException {
        jsonReader.beginArray();
        while (jsonReader.hasNext()) {
            jsonReader.beginObject();
            float fNextDouble = 0.0f;
            String strNextString = null;
            float fNextDouble2 = 0.0f;
            while (jsonReader.hasNext()) {
                String strNextName = jsonReader.nextName();
                strNextName.hashCode();
                switch (strNextName) {
                    case "cm":
                        strNextString = jsonReader.nextString();
                        break;
                    case "dr":
                        fNextDouble2 = (float) jsonReader.nextDouble();
                        break;
                    case "tm":
                        fNextDouble = (float) jsonReader.nextDouble();
                        break;
                    default:
                        jsonReader.skipValue();
                        break;
                }
            }
            jsonReader.endObject();
            list.add(new com.byazt.nb.sp(strNextString, fNextDouble, fNextDouble2));
        }
        jsonReader.endArray();
    }
}
