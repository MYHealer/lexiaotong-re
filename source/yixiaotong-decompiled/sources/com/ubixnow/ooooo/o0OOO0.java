package com.ubixnow.ooooo;

import android.text.TextUtils;
import com.ubixnow.core.api.UbixDefaultConstants;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class o0OOO0 {
    public static oO0O0O00 OooO00o;
    private static long OooO0O0;

    public class OooO00o implements Runnable {
        @Override // java.lang.Runnable
        public void run() {
            oO0000O.OooO0O0();
        }
    }

    private static void OooO00o() {
        ooooO000.OooO0O0(ooooO000.OooO0O0, "--sApp " + (oO00000o.o00O0O.OooOO0O != null));
        if (oO00000o.o00O0O.OooOO0O != null) {
            g1.OooO0Oo().OooO0OO(new OooO00o());
        }
    }

    public static synchronized void OooO00o(String str) {
        try {
            String strOooO0o0 = oOo00o00.OooO0o0(String.format(oO00000o.o00000O0.OooO00o, str));
            if (!TextUtils.isEmpty(strOooO0o0)) {
                OooO00o = oO0O0O00.OooO00o(oO0Oo0o0.OooO00o().OooO00o(strOooO0o0.getBytes()));
                OooO0O0();
            }
        } catch (Exception e) {
            ooooO000.OooO00o(e);
        }
    }

    public static synchronized void OooO0O0() {
        String str;
        String str2;
        String string;
        String str3;
        String str4;
        String str5;
        String str6;
        try {
            oO0O0O00 oo0o0o00 = OooO00o;
            if (oo0o0o00 != null) {
                try {
                    OooO0O0(oo0o0o00.OooOo0O);
                    oO00000o.o00O0O.OooO00o = OooO00o.Oooo00O;
                    oO0O0O00 oo0o0o01 = OooO00o;
                    if (oo0o0o01.Oooo00O != 0) {
                        ooooO000.OooO0O0(ooooO000.OooO0O0, "sdk close!");
                        return;
                    }
                    oO00000o.o00O0O.OooO0O0 = oo0o0o01.OooO0Oo.OooO0OO;
                    String[] strArr = OooO00o.OooO0Oo.OooO0o0;
                    if (strArr == null || strArr.length <= 0) {
                        str = oO00000o.o00000O0.OooO0oO;
                        str2 = oO00000o.OooO00o.OooO;
                    } else {
                        str = oO00000o.o00000O0.OooO0oO;
                        str2 = OooO00o.OooO0Oo.OooO0o0[0];
                    }
                    oOo00o00.OooO00o(str, str2);
                    UbixDefaultConstants.monitorCacheInterval = OooO00o.OooOoO0;
                    oO00000o.o00O0O.OooOOo0 = OooO00o.Oooo00o;
                    if (!TextUtils.isEmpty(OooO00o.Oooo00o)) {
                        oOo00o00.OooO00o(oO00000o.o00000O0.OooOOo0, OooO00o.Oooo00o);
                    }
                    oO00000o.o00O0O.OooO0OO = OooO00o.OooO0Oo.OooO0Oo.OooO0OO * 1000;
                    oO00000o.o00O0O.OooO0Oo = OooO00o.OooO0Oo.OooO0Oo.OooO0Oo;
                    oOo00o00.OooO0O0(oO00000o.o00000O0.OooOO0O, oO00000o.o00O0O.OooO0Oo);
                    oOo00o00.OooO0O0(oO00000o.o00000O0.OooOO0o, oO00000o.o00O0O.OooO0OO);
                    String[] strArr2 = OooO00o.OooOOO0;
                    if (strArr2 == null || strArr2.length <= 0) {
                        oOo00o00.OooO00o(oO00000o.o00000O0.OooOOOo, "none");
                        string = "none";
                    } else {
                        StringBuilder sb = new StringBuilder();
                        for (String str7 : OooO00o.OooOOO0) {
                            sb.append(str7).append("&");
                        }
                        oOo00o00.OooO00o(oO00000o.o00000O0.OooOOOo, sb.toString());
                        string = sb.toString();
                    }
                    oO00000o.o00O0O.OooO0o0 = string;
                    if (ooooO000.OooO00o) {
                        ooooO000.OooO0O0("【----ubix_埋点】", oO00000o.o00O0O.OooO0o0 + "");
                    }
                    oOo00o00.OooO00o(oO00000o.o00000O0.OooOOo, Boolean.valueOf(OooO00o.OooOOO));
                    oOo00o00.OooO00o(oO00000o.o00000O0.OooOo0, Boolean.valueOf(OooO00o.OooOOo0));
                    oOo00o00.OooO00o(oO00000o.o00000O0.OooOo0O, Boolean.valueOf(OooO00o.OooOOo));
                    oOo00o00.OooO00o(oO00000o.o00000O0.OooOo, Boolean.valueOf(OooO00o.OooOo00));
                    oOo00o00.OooO00o(oO00000o.o00000O0.OooOo00, Boolean.valueOf(OooO00o.OooOOOo));
                    oOo00o00.OooO00o(oO00000o.o00000O0.OooOo0o, Boolean.valueOf(OooO00o.OooOOoo));
                    oOo00o00.OooO00o(oO00000o.o00000O0.OooOOoo, Boolean.valueOf(OooO00o.OooOOOO));
                    int i = OooO00o.OooOo0o;
                    if (i >= 0) {
                        oOo00o00.OooO0O0(oO00000o.o00000O0.OooOoOO, OooO00o.OooOo0o);
                        UbixDefaultConstants.cacheLimitCount = OooO00o.OooOo0o;
                    } else if (i == -1) {
                        oOo00o00.OooO0O0(oO00000o.o00000O0.OooOoOO, 0);
                        UbixDefaultConstants.cacheLimitCount = 0;
                    }
                    if (OooO00o.OooOo >= 0) {
                        oOo00o00.OooO0O0(oO00000o.o00000O0.OooOoo0, OooO00o.OooOo);
                        UbixDefaultConstants.cacheLimitTime = OooO00o.OooOo;
                    }
                    if (OooO00o.OooOoO >= 0) {
                        oOo00o00.OooO0O0(oO00000o.o00000O0.OooOoo, OooO00o.OooOoO);
                        UbixDefaultConstants.strategyCacheExpireTime = OooO00o.OooOoO;
                    }
                    int i2 = OooO00o.OooOoOO;
                    if (i2 >= 0) {
                        oOo00o00.OooO0O0(oO00000o.o00000O0.OooOooO, i2);
                        UbixDefaultConstants.requestStrategyInterval = OooO00o.OooOoOO;
                    }
                    int i3 = OooO00o.OooOooo;
                    if (i3 >= 0) {
                        oOo00o00.OooO0O0(oO00000o.o00000O0.OooOooo, i3);
                        UbixDefaultConstants.s2sStrategyInterval = OooO00o.OooOooo;
                    }
                    oO00000o.o00O0O.OooO0o = OooO00o.OooO0o0;
                    oO00000o.o00O0O.OooO0oO = OooO00o.OooO0o;
                    oO00000o.o00O0O.OooOOo = OooO00o.Oooo0O0;
                    oO00000o.o00O0O.OooOOoo = OooO00o.Oooo0OO;
                    oO00000o.o00O0O.OooOo00 = OooO00o.Oooo0o0;
                    oO00000o.o00O0O.OooO0oo = OooO00o.OooO0oO;
                    int i4 = OooO00o.OooO0oo;
                    if (i4 > 0) {
                        oO00000o.o00O0O.OooO = i4;
                    }
                    int i5 = OooO00o.OooO;
                    oO00000o.o00O0O.OooOO0 = i5;
                    UbixDefaultConstants.adParamsReloadTime = i5;
                    oO00000o.o00O0O.OooOO0O = OooO00o.OooOO0;
                    oO00000o.o00O0O.OooOO0o = OooO00o.OooOO0O;
                    String[] strArr3 = OooO00o.OooOO0o;
                    if (strArr3 == null || strArr3.length <= 0) {
                        str3 = oO00000o.o00000O0.OooO0o0;
                        str4 = oO00000o.OooO00o.OooO0oO;
                    } else {
                        str3 = oO00000o.o00000O0.OooO0o0;
                        str4 = OooO00o.OooOO0o[0];
                    }
                    oOo00o00.OooO00o(str3, str4);
                    String[] strArr4 = OooO00o.Oooo000;
                    if (strArr4 == null || strArr4.length <= 0) {
                        str5 = oO00000o.o00000O0.OooO0o;
                        str6 = oO00000o.OooO00o.OooO0oo;
                    } else {
                        str5 = oO00000o.o00000O0.OooO0o;
                        str6 = OooO00o.Oooo000[0];
                    }
                    oOo00o00.OooO00o(str5, str6);
                    oO00000o.OooO00o.OooO0O0();
                    try {
                        OooO0OO();
                    } catch (Exception e) {
                        ooooO000.OooO0O0(ooooO000.OooO0O0, "---sApp---Exception " + e.getMessage());
                        ooooO000.OooO00o(e);
                    }
                } catch (Throwable th) {
                    ooooO000.OooO00o(th);
                }
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public static void OooO0O0(String str) {
        try {
            ooooO000.OooO0O0("-----parseExt", "---json: " + str);
            if (TextUtils.isEmpty(str)) {
                return;
            }
            JSONObject jSONObject = new JSONObject(str);
            String strOptString = jSONObject.optString("monitor_crash_filtration");
            if (!TextUtils.isEmpty(strOptString)) {
                try {
                    JSONObject jSONObject2 = new JSONObject(strOptString);
                    Iterator<String> itKeys = jSONObject2.keys();
                    while (itKeys.hasNext()) {
                        String next = itKeys.next();
                        oO00000o.o00O0O.OooOOO.add(next);
                        oO00000o.o00O0O.OooOOOO.put(next, jSONObject2.optString(next));
                    }
                } catch (Exception e) {
                    ooooO000.OooO00o(e);
                }
            }
            String strOptString2 = jSONObject.optString("sensor_type");
            boolean z = !"0".equals(o0O0ooO.OooO0oO);
            if (!TextUtils.isEmpty(strOptString2) && !"1".equals(strOptString2)) {
                if ("0".equals(strOptString2)) {
                    oO00000o.o00O0O.OooOOOo = false;
                    return;
                } else {
                    if ("2".equals(strOptString2)) {
                        oO00000o.o00O0O.OooOOOo = true;
                        return;
                    }
                    return;
                }
            }
            oO00000o.o00O0O.OooOOOo = z;
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static synchronized void OooO0OO() {
        oO0O0O00 oo0o0o00 = OooO00o;
        if (oo0o0o00 != null && oo0o0o00.OooO0oO) {
            if (OooO0O0 <= 0) {
                OooO0O0 = oOo00o00.OooO0Oo(oO00000o.o00000O0.OooO0Oo);
            }
            long j = oO00000o.o00O0O.OooO;
            ooooO000.OooO0O0(ooooO000.OooO0O0, ooooO000.OooO0OO("a7") + j + " ：" + OooO0O0);
            if (System.currentTimeMillis() - OooO0O0 < j * 1000) {
                List<String> list = o0O0ooO.OooO0OO;
                if (list != null && list.size() <= 0) {
                    String strOooO0o0 = oOo00o00.OooO0o0(oO00000o.o00000O0.OooO);
                    String strOooO0o1 = oOo00o00.OooO0o0(oO00000o.o00000O0.OooOO0);
                    if (!TextUtils.isEmpty(strOooO0o0) && strOooO0o0.length() > 1) {
                        ArrayList arrayList = new ArrayList(Arrays.asList(strOooO0o0.substring(1, strOooO0o0.length() - 1).split(",")));
                        if (!arrayList.isEmpty()) {
                            o0O0ooO.OooO0OO = arrayList;
                        }
                    }
                    if (!TextUtils.isEmpty(strOooO0o1) && strOooO0o1.length() > 1) {
                        ArrayList arrayList2 = new ArrayList(Arrays.asList(strOooO0o1.substring(1, strOooO0o1.length() - 1).split(",")));
                        if (!arrayList2.isEmpty()) {
                            o0O0ooO.OooO0Oo = arrayList2;
                        }
                    }
                }
            } else {
                o0O0ooO.OooO0OO.clear();
                o0O0ooO.OooO0Oo.clear();
                OooO0O0 = System.currentTimeMillis();
                oOo00o00.OooO00o(oO00000o.o00000O0.OooO0Oo, OooO0O0);
                if (OooO00o.OooOoo0 == 1) {
                    OooO00o();
                } else if (j1.OooO0oo) {
                    ooooO000.OooO0O0(ooooO000.OooO0O0, "----sApp-dp");
                    oO0000O.OooO0OO();
                } else {
                    ooooO000.OooO0O0(ooooO000.OooO0O0, ooooO000.OooO0OO("a9") + oO0O0O0o.OooO0OO(j1.OooOOOo));
                    if (j1.OooOOOo != null && oO00000o.o00O0O.OooOO0O != null) {
                        for (String str : j1.OooOOOo) {
                            if (oO00000o.o00O0O.OooOO0O.containsKey(str) && !TextUtils.isEmpty(oO00000o.o00O0O.OooOO0O.get(str))) {
                                ooooO000.OooO00o(ooooO000.OooO0O0, "匹配：" + str);
                                o0O0ooO.OooO0OO.add(oO00000o.o00O0O.OooOO0O.get(str));
                                o0O0ooO.OooO0Oo.add(str);
                            }
                        }
                        oOo00o00.OooO00o(oO00000o.o00000O0.OooO, o0O0ooO.OooO0OO.toString());
                        oOo00o00.OooO00o(oO00000o.o00000O0.OooOO0, o0O0ooO.OooO0Oo.toString());
                    }
                }
            }
            return;
        }
        ooooO000.OooO0O0(ooooO000.OooO0O0, ooooO000.OooO0OO("a8"));
    }
}
