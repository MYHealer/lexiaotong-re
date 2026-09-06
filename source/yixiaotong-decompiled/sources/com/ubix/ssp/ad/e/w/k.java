package com.ubix.ssp.ad.e.w;

import android.content.Context;
import android.text.TextUtils;
import com.cdo.oaps.ad.wrapper.BaseWrapper;
import com.stub.StubApp;
import com.ubix.ssp.ad.e.a0.r;
import com.ubix.ssp.ad.e.a0.u;
import com.ubix.ssp.open.UBiXInitManger;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static k f8905a;
    private Context b;

    class a extends com.ubix.ssp.ad.e.x.a.c {
        final /* synthetic */ int b;
        final /* synthetic */ String c;
        final /* synthetic */ int d;

        a(int i, String str, int i2) {
            this.b = i;
            this.c = str;
            this.d = i2;
        }

        @Override // com.ubix.ssp.ad.e.x.a
        public void b(com.ubix.ssp.ad.e.x.d dVar) {
            if (this.b < 1) {
                k.this.a(this.c, this.d);
            }
        }

        @Override // com.ubix.ssp.ad.e.x.a
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public void a(com.ubix.ssp.ad.e.x.d dVar) {
        }
    }

    private k(Context context) {
        this.b = context;
    }

    private float a(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return -999.0f;
            }
            return Float.valueOf(str).floatValue();
        } catch (Exception e) {
            e.printStackTrace();
            return -999.0f;
        }
    }

    public static k a(Context context) {
        if (context == null) {
            return null;
        }
        Context origApplicationContext = StubApp.getOrigApplicationContext(context.getApplicationContext());
        if (f8905a == null) {
            synchronized (UBiXInitManger.class) {
                if (f8905a == null) {
                    f8905a = new k(origApplicationContext);
                }
            }
        }
        return f8905a;
    }

    private String a(com.ubix.ssp.ad.e.y.a.a.b.d dVar, String str) {
        HashMap<String, String> mapB = b(dVar);
        if (str == null) {
            return "0";
        }
        if (!mapB.containsKey(str)) {
            str = "default";
        }
        return mapB.get(str);
    }

    /* JADX WARN: Code duplicated, block: B:22:0x00b6  */
    private String a(String str, com.ubix.ssp.ad.e.y.a.a.b.d dVar, HashMap<String, String> map) {
        int i;
        int i2;
        int i3;
        float fA = a(map.get("__X_MAX_ACC__"));
        float fA2 = a(map.get("__Y_MAX_ACC__"));
        float fA3 = a(map.get("__Z_MAX_ACC__"));
        float f = fA + fA2 + fA3;
        int i4 = -999;
        if (f == 0.0f || f == -2997.0f) {
            i = -999;
            i2 = -999;
        } else {
            if (dVar == null || (i3 = dVar.f) <= 0) {
                i3 = 100;
            }
            boolean z = true;
            if (dVar == null || TextUtils.isEmpty(dVar.d)) {
                i = -999;
                i2 = -999;
            } else {
                String[] strArrSplit = dVar.d.split(",");
                if (strArrSplit.length != 2 || b(strArrSplit[0]) >= b(strArrSplit[1])) {
                    i = -999;
                    i2 = -999;
                } else {
                    double dRandom = (Math.random() * ((double) (b(strArrSplit[1]) - b(strArrSplit[0])))) + ((double) b(strArrSplit[0]));
                    float fAbs = Math.abs((float) Math.sqrt((fA * fA) + (fA2 * fA2) + (fA3 * fA3)));
                    if (fAbs < b(strArrSplit[0])) {
                        double d = dRandom / ((double) fAbs);
                        double d2 = i3;
                        i4 = (int) (((double) fA) * d * d2);
                        i2 = (int) (((double) fA3) * d * d2);
                        i = (int) (((double) fA2) * d * d2);
                        z = false;
                    } else {
                        i = -999;
                        i2 = -999;
                    }
                }
            }
            if (z) {
                float f2 = i3;
                i4 = (int) (fA * f2);
                i2 = (int) (fA3 * f2);
                i = (int) (fA2 * f2);
            }
        }
        return str.replace("__X_MAX_ACC__", i4 + "").replace("__Y_MAX_ACC__", i + "").replace("__Z_MAX_ACC__", i2 + "");
    }

    private String a(String str, HashMap<String, String> map, double d) {
        String strA = a(map, str);
        if (TextUtils.isEmpty(strA)) {
            return strA;
        }
        String[] strArrSplit = strA.split("_");
        int i = 0;
        String str2 = "";
        while (i < strArrSplit.length) {
            str2 = str2 + ((int) (((double) Integer.parseInt(strArrSplit[i])) / d)) + (i == strArrSplit.length + (-1) ? "" : "_");
            i++;
        }
        return str2;
    }

    private String a(String str, HashMap<String, String> map, String str2) {
        return (str.equals("3") || str.equals("6") || str.equals(BaseWrapper.ENTER_ID_AD_SDK) || str.equals(BaseWrapper.ENTER_ID_SYSTEM_SIM_SETTING)) ? str2 : str2.replace("__INT_DOWN_X__", b(a(map, com.hihonor.adsdk.base.g.j.e.c.hnadsc)) + "").replace("__INT_DOWN_Y__", b(a(map, com.hihonor.adsdk.base.g.j.e.c.hnadsd)) + "").replace("__INT_UP_X__", b(a(map, com.hihonor.adsdk.base.g.j.e.c.hnadse)) + "").replace("__INT_UP_Y__", b(a(map, com.hihonor.adsdk.base.g.j.e.c.hnadsf)) + "").replace("__RAW_INT_DOWN_X__", b(a(map, "__RAW_DOWN_X__")) + "").replace("__RAW_INT_DOWN_Y__", b(a(map, "__RAW_DOWN_Y__")) + "").replace("__RAW_INT_UP_X__", b(a(map, "__RAW_UP_X__")) + "").replace("__RAW_INT_UP_Y__", b(a(map, "__RAW_UP_Y__")) + "");
    }

    private String a(String str, HashMap<String, String> map, ArrayList<String> arrayList) {
        StringBuilder sb;
        StringBuilder sb2;
        double dA = r.a().a(this.b);
        int iH = r.a().h(this.b);
        int iC = r.a().c(this.b);
        if (arrayList.contains("__REQ_WIDTH__")) {
            sb = new StringBuilder();
            iH = (int) (((double) iH) / dA);
        } else {
            sb = new StringBuilder();
        }
        String strReplace = str.replace("__REQ_WIDTH__", sb.append(iH).append("").toString());
        if (arrayList.contains("__REQ_HEIGHT__")) {
            sb2 = new StringBuilder();
            iC = (int) (((double) iC) / dA);
        } else {
            sb2 = new StringBuilder();
        }
        String strReplace2 = strReplace.replace("__REQ_HEIGHT__", sb2.append(iC).append("").toString());
        String strA = a(map, com.hihonor.adsdk.base.g.j.e.c.hnadsb);
        String strA2 = a(map, com.hihonor.adsdk.base.g.j.e.c.hnadsa);
        if (arrayList.contains(com.hihonor.adsdk.base.g.j.e.c.hnadsb) && !TextUtils.isEmpty(strA)) {
            strA = ((int) (((double) Integer.parseInt(strA)) / dA)) + "";
        }
        String strReplace3 = strReplace2.replace(com.hihonor.adsdk.base.g.j.e.c.hnadsb, strA);
        if (arrayList.contains(com.hihonor.adsdk.base.g.j.e.c.hnadsa) && !TextUtils.isEmpty(strA2)) {
            strA2 = ((int) (((double) Integer.parseInt(strA2)) / dA)) + "";
        }
        String strReplace4 = strReplace3.replace(com.hihonor.adsdk.base.g.j.e.c.hnadsa, strA2);
        if (arrayList.contains(com.hihonor.adsdk.base.g.j.e.c.hnadsc)) {
            b(com.hihonor.adsdk.base.g.j.e.c.hnadsc, map, dA);
        }
        if (arrayList.contains(com.hihonor.adsdk.base.g.j.e.c.hnadsd)) {
            b(com.hihonor.adsdk.base.g.j.e.c.hnadsd, map, dA);
        }
        if (arrayList.contains(com.hihonor.adsdk.base.g.j.e.c.hnadse)) {
            b(com.hihonor.adsdk.base.g.j.e.c.hnadse, map, dA);
        }
        if (arrayList.contains(com.hihonor.adsdk.base.g.j.e.c.hnadsf)) {
            b(com.hihonor.adsdk.base.g.j.e.c.hnadsf, map, dA);
        }
        if (arrayList.contains("__RAW_DOWN_X__")) {
            b("__RAW_DOWN_X__", map, dA);
        }
        if (arrayList.contains("__RAW_DOWN_Y__")) {
            b("__RAW_DOWN_Y__", map, dA);
        }
        if (arrayList.contains("__RAW_UP_X__")) {
            b("__RAW_UP_X__", map, dA);
        }
        if (arrayList.contains("__RAW_UP_Y__")) {
            b("__RAW_UP_Y__", map, dA);
        }
        return strReplace4.replace("__IMP_AREA__", arrayList.contains("__IMP_AREA__") ? a("__IMP_AREA__", map, dA) : a(map, "__IMP_AREA__")).replace("__BUTTON_AREA__", arrayList.contains("__BUTTON_AREA__") ? a("__BUTTON_AREA__", map, dA) : a(map, "__BUTTON_AREA__"));
    }

    private String a(HashMap<String, String> map, String str) {
        return map.get(str) == null ? "" : map.get(str);
    }

    private ArrayList<String> a(com.ubix.ssp.ad.e.y.a.a.b.d dVar) {
        ArrayList<String> arrayList = new ArrayList<>();
        if (dVar != null && !TextUtils.isEmpty(dVar.c)) {
            if (dVar.c.contains("reqSize")) {
                arrayList.add("__REQ_WIDTH__");
                arrayList.add("__REQ_HEIGHT__");
            }
            if (dVar.c.contains("adSize")) {
                arrayList.add(com.hihonor.adsdk.base.g.j.e.c.hnadsb);
                arrayList.add(com.hihonor.adsdk.base.g.j.e.c.hnadsa);
            }
            if (dVar.c.contains("position")) {
                arrayList.add(com.hihonor.adsdk.base.g.j.e.c.hnadsc);
                arrayList.add(com.hihonor.adsdk.base.g.j.e.c.hnadsd);
                arrayList.add(com.hihonor.adsdk.base.g.j.e.c.hnadse);
                arrayList.add(com.hihonor.adsdk.base.g.j.e.c.hnadsf);
                arrayList.add("__RAW_DOWN_X__");
                arrayList.add("__RAW_DOWN_Y__");
                arrayList.add("__RAW_UP_X__");
                arrayList.add("__RAW_UP_Y__");
                arrayList.add("__INT_DOWN_X__");
                arrayList.add("__INT_DOWN_Y__");
                arrayList.add("__INT_UP_X__");
                arrayList.add("__INT_UP_Y__");
                arrayList.add("__RAW_INT_DOWN_X__");
                arrayList.add("__RAW_INT_DOWN_Y__");
                arrayList.add("__RAW_INT_UP_X__");
                arrayList.add("__RAW_INT_UP_Y__");
            }
            if (dVar.c.contains("impress")) {
                arrayList.add("__IMP_AREA__");
                arrayList.add("__BUTTON_AREA__");
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, int i) {
        int i2 = i + 1;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        com.ubix.ssp.ad.e.x.g.b().a(str, (com.ubix.ssp.ad.e.x.a.c) new a(i, str, i2));
    }

    private int b(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return -999;
            }
            return Float.valueOf(str).intValue();
        } catch (Exception e) {
            e.printStackTrace();
            return -999;
        }
    }

    private String b(String str, com.ubix.ssp.ad.e.y.a.a.b.d dVar, HashMap<String, String> map) {
        int iB = b(map.get("__TURN_X__"));
        int iB2 = b(map.get("__TURN_Y__"));
        int iB3 = b(map.get("__TURN_Z__"));
        int iB4 = b(map.get("__TURN_TIME__"));
        float f = iB + iB2 + iB3;
        if (f == 0.0f || f == -2997.0f) {
            iB = -999;
            iB2 = -999;
            iB3 = -999;
        } else {
            int iB5 = b(map.get("__UBIX_TURN_TARGET__"));
            if (dVar != null && !TextUtils.isEmpty(dVar.e)) {
                String[] strArrSplit = dVar.e.split(",");
                if (strArrSplit.length == 2 && b(strArrSplit[0]) < b(strArrSplit[1])) {
                    int iB6 = (int) (((double) b(strArrSplit[0])) + (Math.random() * ((double) (b(strArrSplit[1]) - b(strArrSplit[0])))));
                    if (iB5 != 0) {
                        if (iB5 != 1) {
                            if (iB5 == 2 && Math.abs(iB3) < b(strArrSplit[0])) {
                                iB3 = iB3 > 0 ? iB6 : iB6 * (-1);
                            }
                        } else if (Math.abs(iB2) < b(strArrSplit[0])) {
                            iB2 = iB2 > 0 ? iB6 : iB6 * (-1);
                        }
                    } else if (Math.abs(iB) < b(strArrSplit[0])) {
                        iB = iB > 0 ? iB6 : iB6 * (-1);
                    }
                }
            }
        }
        return str.replace("__TURN_X__", iB + "").replace("__TURN_Y__", iB2 + "").replace("__TURN_Z__", iB3 + "").replace("__TURN_TIME__", iB4 == 0 ? "-999" : iB4 + "");
    }

    private String b(String str, HashMap<String, String> map, String str2) {
        return (str.equals("3") || str.equals("6") || str.equals(BaseWrapper.ENTER_ID_AD_SDK) || str.equals(BaseWrapper.ENTER_ID_SYSTEM_SIM_SETTING)) ? str2 : str2.replace("__RAW_DOWN_X__", b(a(map, "__RAW_DOWN_X__")) + "").replace("__RAW_DOWN_Y__", b(a(map, "__RAW_DOWN_Y__")) + "").replace("__RAW_UP_X__", b(a(map, "__RAW_UP_X__")) + "").replace("__RAW_UP_Y__", b(a(map, "__RAW_UP_Y__")) + "").replace(com.hihonor.adsdk.base.g.j.e.c.hnadsc, b(a(map, com.hihonor.adsdk.base.g.j.e.c.hnadsc)) + "").replace(com.hihonor.adsdk.base.g.j.e.c.hnadsd, b(a(map, com.hihonor.adsdk.base.g.j.e.c.hnadsd)) + "").replace(com.hihonor.adsdk.base.g.j.e.c.hnadse, b(a(map, com.hihonor.adsdk.base.g.j.e.c.hnadse)) + "").replace(com.hihonor.adsdk.base.g.j.e.c.hnadsf, b(a(map, com.hihonor.adsdk.base.g.j.e.c.hnadsf)) + "");
    }

    private String b(HashMap<String, String> map, String str) {
        if (map == null || map.isEmpty()) {
            return str;
        }
        if (map.containsKey("__second_price__")) {
            str = str.replace("__second_price__", com.ubix.ssp.ad.e.a0.a.b(map.get("__second_price__").getBytes(Charset.forName("UTF-8"))));
        }
        if (map.containsKey("__win_price__")) {
            str = str.replace("__win_price__", com.ubix.ssp.ad.e.a0.a.b(map.get("__win_price__").getBytes(Charset.forName("UTF-8"))));
        }
        if (map.containsKey("__win_meta__")) {
            str = str.replace("__win_meta__", URLEncoder.encode(map.get("__win_meta__")));
        }
        if (map.containsKey("__loss_reason__")) {
            str = str.replace("__loss_reason__", URLEncoder.encode(map.get("__loss_reason__")));
        }
        return map.containsKey("__win_bidder__") ? str.replace("__win_bidder__", URLEncoder.encode(map.get("__win_bidder__"))) : str;
    }

    private HashMap<String, String> b(com.ubix.ssp.ad.e.y.a.a.b.d dVar) {
        com.ubix.ssp.ad.e.y.a.a.b.h hVar;
        HashMap<String, String> map = new HashMap<>();
        map.put("4", "1");
        map.put("7", "1");
        map.put("11", "1");
        map.put("12", "1");
        map.put("3", "2");
        map.put("6", "2");
        map.put("default", "0");
        if (dVar != null && (hVar = dVar.b) != null && !TextUtils.isEmpty(hVar.b)) {
            try {
                com.ubix.ssp.ad.e.y.a.a.b.h hVar2 = dVar.b;
                JSONObject jSONObject = new JSONObject(hVar2.b);
                Iterator<String> itKeys = jSONObject.keys();
                if (itKeys.hasNext()) {
                    map.clear();
                    while (itKeys.hasNext()) {
                        String next = itKeys.next();
                        for (String str : jSONObject.getString(next).split(",")) {
                            map.put(str, next);
                        }
                    }
                    if (TextUtils.isEmpty(hVar2.c)) {
                        map.put("default", "0");
                    } else {
                        map.put("default", hVar2.c);
                    }
                }
                return map;
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return map;
    }

    private void b(String str, HashMap<String, String> map, double d) {
        if (map.containsKey(str)) {
            float fA = a(map.get(str));
            if (fA != -999.0f) {
                map.put(str, ((float) (((double) fA) / d)) + "");
            }
        }
    }

    private String c(String str, HashMap<String, String> map, String str2) {
        if (str.equals("3") || str.equals("6") || str.equals(BaseWrapper.ENTER_ID_AD_SDK) || str.equals(BaseWrapper.ENTER_ID_SYSTEM_SIM_SETTING)) {
            map.put(com.hihonor.adsdk.base.g.j.e.c.hnadsc, "-999");
            map.put(com.hihonor.adsdk.base.g.j.e.c.hnadsd, "-999");
            map.put(com.hihonor.adsdk.base.g.j.e.c.hnadse, "-999");
            map.put(com.hihonor.adsdk.base.g.j.e.c.hnadsf, "-999");
            map.put("__RAW_DOWN_X__", "-999");
            map.put("__RAW_DOWN_Y__", "-999");
            map.put("__RAW_UP_X__", "-999");
            map.put("__RAW_UP_Y__", "-999");
        }
        return str2.replace("__RAW_DOWN_X__", a(map, "__RAW_DOWN_X__")).replace("__RAW_DOWN_Y__", a(map, "__RAW_DOWN_Y__")).replace("__RAW_UP_X__", a(map, "__RAW_UP_X__")).replace("__RAW_UP_Y__", a(map, "__RAW_UP_Y__")).replace(com.hihonor.adsdk.base.g.j.e.c.hnadsc, a(map, com.hihonor.adsdk.base.g.j.e.c.hnadsc)).replace(com.hihonor.adsdk.base.g.j.e.c.hnadsd, a(map, com.hihonor.adsdk.base.g.j.e.c.hnadsd)).replace(com.hihonor.adsdk.base.g.j.e.c.hnadse, a(map, com.hihonor.adsdk.base.g.j.e.c.hnadse)).replace(com.hihonor.adsdk.base.g.j.e.c.hnadsf, a(map, com.hihonor.adsdk.base.g.j.e.c.hnadsf));
    }

    public String a(int i, int i2, com.ubix.ssp.ad.e.y.a.a.b.d dVar, HashMap<String, String> map, String str) {
        HashMap<String, String> map2 = new HashMap<>(map);
        if (i == 701 || i == 702) {
            return b(map2, str);
        }
        String strA = a(map2, "__CLICK_AREA__");
        String strB = b(a(a(str.replace("__TMS__", System.currentTimeMillis() + "").replace("__TMS_END__", System.currentTimeMillis() + "").replace("__TS__", (System.currentTimeMillis() / 1000) + "").replace("__TS_END__", (System.currentTimeMillis() / 1000) + "").replace("__CLICK_XY__", a(map2, "__CLICK_XY__")).replace("__CLICK_ID__", a(map2, "__CLICK_ID__")).replace("__CLICK_AREA__", a(map2, "__CLICK_AREA__")).replace("__DISLIKE_IDS__", a(map2, "__DISLIKE_IDS__")).replace("__DURATION__", a(map2, "__DURATION__")).replace("__PLAY_TIME__", a(map2, "__PLAY_TIME__")).replace("__SKIP_TIME__", a(map2, "__SKIP_TIME__")).replace("__DOWN_ERR_ID__", a(map2, "__DOWN_ERR_ID__")).replace("__AUCTION_PRICE__", a(map2, "__AUCTION_PRICE__")).replace("__TRI_VAL__", a(map2, "__TRI_VAL__")).replace("__SLD__", a(dVar, (BaseWrapper.ENTER_ID_SYSTEM_SIM_SETTING.equals(strA) || BaseWrapper.ENTER_ID_AD_SDK.equals(strA)) ? "3" : strA)).replace("__MP_RESULT__", a(map2, "__MP_RESULT__")).replace("__U_TB_CHECK__", a(map2, "__U_TB_CHECK__")), map2, a(dVar)), dVar, map2), dVar, map2);
        if (i2 == 1) {
            return b(strA, map2, strB);
        }
        String strC = c(strA, map2, strB);
        return i2 == 2 ? a(strA, map2, strC) : strC;
    }

    public void a(com.ubix.ssp.ad.e.y.a.a.b bVar, int i) {
        a(bVar, new HashMap<>(), i);
    }

    public void a(com.ubix.ssp.ad.e.y.a.a.b bVar, HashMap<String, String> map, int i) {
        if (bVar == null) {
            return;
        }
        u.b("dealTrack getEvent", bVar.b + " actionId: " + i);
        com.ubix.ssp.ad.e.y.a.a.b.d dVar = bVar.P;
        int i2 = 0;
        while (true) {
            com.ubix.ssp.ad.e.y.a.a.b.k[] kVarArr = bVar.p;
            if (i2 >= kVarArr.length) {
                return;
            }
            if (kVarArr[i2].c == i) {
                int i3 = 0;
                while (true) {
                    com.ubix.ssp.ad.e.y.a.a.b.k[] kVarArr2 = bVar.p;
                    if (i3 < kVarArr2[i2].d.length) {
                        String strA = a(i, bVar.M, dVar, map, kVarArr2[i2].d[i3]);
                        a(strA, 0);
                        u.b("dealTrack getEvent", "Pos=" + i2 + ";Size=" + bVar.p[i2].d.length + " EVENT ID= " + i + " : " + strA);
                        i3++;
                    }
                }
            }
            i2++;
        }
    }
}
