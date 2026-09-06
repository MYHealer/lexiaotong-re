package com.xiaomi.onetrack.api;

import android.content.Context;
import android.text.TextUtils;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import com.xiaomi.onetrack.Configuration;
import com.xiaomi.onetrack.OneTrack;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\2263432.dex */
public class am implements j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f9412a = ijiami_1011.s.s.s.d(new byte[]{119, 13, 4, 97, 70, 86, 2, 15, 42, 13, 82, 4, 84, 42, 12, 69}, "8ca547");
    private static final int b = 102400;
    private static final int c = 512000;
    private static final int d = 2;
    private Configuration e;
    private com.xiaomi.onetrack.util.v f;

    public am(Context context, Configuration configuration, com.xiaomi.onetrack.util.v vVar) {
        com.xiaomi.onetrack.f.g.a(context);
        this.e = configuration;
        this.f = vVar;
    }

    private void a(String str, JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3, boolean z) {
        String strA = "";
        String appId = this.e.getAppId();
        if (z) {
            appId = this.e.getAdEventAppId();
        }
        if (a(appId)) {
            com.xiaomi.onetrack.util.p.a(f9412a, ijiami_1011.s.s.s.d(new byte[]{55, 14, 10, 66, Ascii.SYN, 82, 17, Ascii.DC4, 70, 6, 88, Ascii.SYN, 2, 4, 15, 84, 82, 19, Ascii.NAK, Ascii.SYN, 7, 1, 90, 12, 13, 1, 67, 85, 87, 71, 0, 72, 70, 17, 90, 12, 19, 70, 10, 69, Ascii.CAN}, "cfc163"));
            return;
        }
        try {
            String strA2 = com.xiaomi.onetrack.b.h.a().a(appId, str, ijiami_1011.s.s.s.d(new byte[]{92, 85, 83, 0, 124, 81, Ascii.DC2}, "206d55"), "");
            String strOptString = jSONObject3 == null ? "" : jSONObject3.optString(ijiami_1011.s.s.s.d(new byte[]{68, 10, 69}, "0c528e"));
            String str2 = f9412a;
            com.xiaomi.onetrack.util.p.a(str2, ijiami_1011.s.s.s.d(new byte[]{17, 92, Ascii.DC2, 12, Ascii.ETB}, "e5b672") + strOptString + ijiami_1011.s.s.s.d(new byte[]{74, Ascii.DC4, 92, 6, 92, 5, 40, 0, Ascii.NAK, 88, 17}, "f42c9a") + strA2);
            if (b(strOptString, strA2)) {
                if (c(appId, str)) {
                    com.xiaomi.onetrack.util.p.a(str2, ijiami_1011.s.s.s.d(new byte[]{68, 109, 89, 12, 65, Ascii.CAN, 4, Ascii.DC2, 3, 12, 69, 69, 0, 80, 66, 4, 80, 84, 4, 0, 70, Ascii.SYN, 67, 4, 7, 82, 88, 11, 85, Ascii.CAN, 5, 5, Ascii.DC2, 3, 17, 73, 68, 74, 90, 12, 66, Ascii.CAN, 8, 16, 72}, "d91e28"));
                    return;
                } else {
                    if (d(appId, str)) {
                        com.xiaomi.onetrack.util.p.a(str2, ijiami_1011.s.s.s.d(new byte[]{Ascii.DC4, 103, 88, 89, SignedBytes.MAX_POWER_OF_TWO, Ascii.SYN, 4, Ascii.DC2, 3, 12, 69, 69, 71, 91, 95, 69, 95, 82, 65, 10, 9, Ascii.SYN, 17, 16, 68, 95, 95, 81, 87, Ascii.SYN, 3, Ascii.GS, 70, 17, 80, 8, 68, 95, 89, 94, 84, Ascii.SYN, 77, 68, Ascii.NAK, 9, 88, Ascii.NAK, Ascii.DC4, 90, 68, Ascii.RS}, "430036"));
                        return;
                    }
                    strA = com.xiaomi.onetrack.b.h.a().a(appId, str, ijiami_1011.s.s.s.d(new byte[]{81, 5, 8, 94, 86, 84, 49, 5, Ascii.DC4, 3, 92, Ascii.SYN}, "3df030"), "");
                }
            }
            String strC = com.xiaomi.onetrack.b.h.a().c(appId);
            com.xiaomi.onetrack.util.p.a(str2, ijiami_1011.s.s.s.d(new byte[]{0, 82, 11, 94, 1, 81, 49, 5, Ascii.DC4, 3, 92, Ascii.SYN, 36, 92, Ascii.ETB, 113, Ascii.DC4, 69, 91, 68}, "b3e0d5") + strC + ijiami_1011.s.s.s.d(new byte[]{Ascii.US, Ascii.NAK, 81, 85, 92, 15, 4, 0, 54, 3, 67, 4, 94, 70, 117, 91, SignedBytes.MAX_POWER_OF_TWO, 36, Ascii.ETB, 1, 8, Ascii.SYN, 11, 69}, "35342a") + strA);
            Set<String> setA = com.xiaomi.onetrack.util.z.a(strC, strA, ijiami_1011.s.s.s.d(new byte[]{72}, "d5b520"));
            a(jSONObject2, setA);
            a(jSONObject3, setA);
            if (z) {
                com.xiaomi.onetrack.f.d.b(appId, com.xiaomi.onetrack.f.a.e(), str, jSONObject.toString());
            } else {
                com.xiaomi.onetrack.f.d.a(appId, com.xiaomi.onetrack.f.a.e(), str, jSONObject.toString());
            }
        } catch (Throwable th) {
            com.xiaomi.onetrack.util.p.b(f9412a, ijiami_1011.s.s.s.d(new byte[]{2, 91, 85, 90, 94, 118, 13, 11, 19, 6, 114, 10, 15, 71, 66, 86, 89, Ascii.NAK, 4, Ascii.SYN, Ascii.DC4, 13, 67, -118, -35, -87}, "a30955") + th.toString());
        }
    }

    private void a(JSONObject jSONObject, Set<String> set) {
        if (jSONObject == null || set == null || set.size() == 0) {
            com.xiaomi.onetrack.util.p.a(f9412a, ijiami_1011.s.s.s.d(new byte[]{12, 70, 94, 88, 119, 87, 11, 1, 5, Ascii.SYN, 17, 12, Ascii.NAK, Ascii.NAK, 95, 67, 84, 89, 65, 11, Ascii.DC4, 66, 83, 4, 8, 91, 84, 82, 104, 84, 19, 5, 11, 17, 17, 12, Ascii.NAK, Ascii.NAK, 84, 91, 72, 65, Ascii.CAN}, "f51685"));
            return;
        }
        com.xiaomi.onetrack.util.p.a(f9412a, ijiami_1011.s.s.s.d(new byte[]{11, Ascii.SYN, 95, 11, 125, 6, 11, 1, 5, Ascii.SYN, 11, 69}, "ae0e2d") + jSONObject.toString() + ijiami_1011.s.s.s.d(new byte[]{Ascii.GS, 70, 81, 0, 91, 10, 4, 0, 54, 3, 67, 4, 92, Ascii.NAK, 9, 65}, "1f3a5d") + set.toString());
        try {
            Iterator<String> itKeys = jSONObject.keys();
            while (itKeys.hasNext()) {
                if (set.contains(itKeys.next())) {
                    itKeys.remove();
                }
            }
        } catch (Exception e) {
            com.xiaomi.onetrack.util.p.b(f9412a, ijiami_1011.s.s.s.d(new byte[]{94, 89, 89, SignedBytes.MAX_POWER_OF_TWO, 0, 71, 49, 5, Ascii.DC4, 3, 92, Ascii.SYN, Ascii.CAN, 85, 71, 70, 10, 71, -114, -40, -4}, "8054e5") + e.toString());
        }
    }

    private boolean a(String str) {
        try {
            return com.xiaomi.onetrack.b.h.a().a(str, ijiami_1011.s.s.s.d(new byte[]{81, 8, 70, 83, 1, 8, 4, 59, 10, 13, 86}, "5a52cd"));
        } catch (Exception e) {
            com.xiaomi.onetrack.util.p.b(f9412a, ijiami_1011.s.s.s.d(new byte[]{80, 67, 34, 15, 66, 85, 3, 8, 3, 54, 67, 4, 90, 91, 32, 9, 67, 117, 17, Ascii.DC4, 70, 7, 67, Ascii.ETB, 86, 66, 92, 70}, "90ff14") + e.toString());
            return false;
        }
    }

    private boolean a(JSONObject jSONObject) {
        try {
            return jSONObject.optBoolean(com.xiaomi.onetrack.f.b.C1162b.F, false);
        } catch (Throwable unused) {
            com.xiaomi.onetrack.util.p.a(f9412a, "");
            return false;
        }
    }

    private boolean b(String str, String str2) {
        List<String> listA;
        if (TextUtils.isEmpty(str2)) {
            return true;
        }
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            String[] strArrSplit = str.split(ijiami_1011.s.s.s.d(new byte[]{104, Ascii.SYN}, "484984"));
            return strArrSplit != null && strArrSplit.length >= 5 && (listA = com.xiaomi.onetrack.util.z.a(str2, ijiami_1011.s.s.s.d(new byte[]{73}, "ef940f"))) != null && listA.contains(strArrSplit[4]);
        } catch (Exception e) {
            com.xiaomi.onetrack.util.p.b(f9412a, ijiami_1011.s.s.s.d(new byte[]{10, Ascii.ETB, 124, 87, 71, 90, 9, 45, 2, 66, 84, Ascii.ETB, 17, 11, 67, -39, -113, -93}, "cd1639") + e.toString());
        }
    }

    private boolean c(String str, String str2) {
        try {
            return com.xiaomi.onetrack.b.h.a().a(str, str2, ijiami_1011.s.s.s.d(new byte[]{7, 93, 69, 7, 90, 91, 4, 59, 10, 13, 86}, "c46f87"), false);
        } catch (Exception e) {
            com.xiaomi.onetrack.util.p.b(f9412a, ijiami_1011.s.s.s.d(new byte[]{88, Ascii.ETB, 114, 15, Ascii.DC2, 2, 3, 8, 3, 54, 67, 4, 82, 15, 112, 9, 19, 38, Ascii.ETB, 1, 8, Ascii.SYN, 17, 0, 67, Ascii.SYN, 89, Ascii.DC4, 91, 67}, "1d6fac") + e.toString());
            return false;
        }
    }

    private boolean d(String str, String str2) {
        long jB = com.xiaomi.onetrack.b.h.a().b(str, str2);
        long jAbs = Math.abs(com.xiaomi.onetrack.util.oaid.a.a().a(com.xiaomi.onetrack.f.a.b()).hashCode()) % 100;
        boolean z = jB > jAbs;
        com.xiaomi.onetrack.util.p.a(f9412a, ijiami_1011.s.s.s.d(new byte[]{17, 93, 14, Ascii.DC4, 93, 85, 52, Ascii.DC4, 10, 13, 80, 1, 32, 76, 50, 0, 92, 65, 13, 13, 8, 5, 17}, "b5aa11") + str2 + ijiami_1011.s.s.s.d(new byte[]{77, 66, Ascii.ETB, 16, 94, 88, Ascii.DC4, 8, 2, 55, 65, 9, 14, 3, 83, 94}, "ab7c67") + z + ijiami_1011.s.s.s.d(new byte[]{Ascii.ESC, 17, Ascii.DC2, 2, 14, 71, 13, 1, 91}, "71acc7") + jB + ijiami_1011.s.s.s.d(new byte[]{74, Ascii.SYN, 68, 89, 13, 89}, "f628ad") + jAbs);
        return !z;
    }

    @Override // com.xiaomi.onetrack.api.j
    public void a(int i) {
        com.xiaomi.onetrack.util.i.a(new an(this, i));
    }

    @Override // com.xiaomi.onetrack.api.j
    public void a(String str, String str2) {
        JSONException e;
        JSONObject jSONObject;
        JSONObject jSONObjectOptJSONObject;
        JSONObject jSONObjectOptJSONObject2 = null;
        try {
            jSONObject = new JSONObject(str2);
            try {
                jSONObjectOptJSONObject = jSONObject.optJSONObject(ijiami_1011.s.s.s.d(new byte[]{46}, "f4ad70"));
                try {
                    jSONObjectOptJSONObject2 = jSONObject.optJSONObject(ijiami_1011.s.s.s.d(new byte[]{116}, "63541c"));
                } catch (JSONException e2) {
                    e = e2;
                    com.xiaomi.onetrack.util.p.a(f9412a, ijiami_1011.s.s.s.d(new byte[]{19, 7, 83, 16, 89, Ascii.SYN, 43, 55, 41, 44, 116, Ascii.GS, 80, 6, 66, 16, 81, 89, 15, 68, 3, 88}, "3c2d86") + e.getMessage());
                }
            } catch (JSONException e3) {
                e = e3;
                jSONObjectOptJSONObject = null;
            }
        } catch (JSONException e4) {
            e = e4;
            jSONObject = null;
            jSONObjectOptJSONObject = null;
        }
        JSONObject jSONObject2 = jSONObjectOptJSONObject2;
        JSONObject jSONObject3 = jSONObject;
        JSONObject jSONObject4 = jSONObjectOptJSONObject;
        boolean zA = a(jSONObject4);
        com.xiaomi.onetrack.util.v vVar = this.f;
        if (vVar != null && !vVar.a(str) && !zA) {
            com.xiaomi.onetrack.util.p.a(f9412a, ijiami_1011.s.s.s.d(new byte[]{53, 9, 86, 67, 67, 16, 8, Ascii.DC2, 7, 1, 72, 69, 17, 14, 95, 10, 80, Ascii.ESC, 65, 13, Ascii.NAK, 66, 95, 10, Ascii.NAK, 65, 67, 6, 65, 15, 8, 16, Ascii.DC2, 7, 85, 73, 65, 0, 93, 7, 19, Ascii.SYN, 9, 1, 70, 7, 71, 0, 15, Ascii.NAK, 19, 10, SignedBytes.MAX_POWER_OF_TWO, 66, 15, 11, Ascii.DC2, 66, 83, 4, Ascii.DC2, 8, 80, 67, 92, 16, 65, Ascii.SYN, 3, 1, 94, 8, 12, 4, 93, 7, 19, 7, Ascii.ETB, 1, 8, Ascii.SYN, 17, 10, 19, 65, 80, Ascii.SYN, SignedBytes.MAX_POWER_OF_TWO, Ascii.SYN, 14, 9, 70, 6, 80, 16, 65, 4, 69, 6, 93, Ascii.SYN, 77, 68, Ascii.NAK, 9, 88, Ascii.NAK, 65, 8, 71, 77}, "aa3c3b"));
            return;
        }
        if (a(str, str2, zA)) {
            if (!com.xiaomi.onetrack.c.i.b()) {
                com.xiaomi.onetrack.c.i.a(str, str2);
                return;
            }
            com.xiaomi.onetrack.c.i.a(this);
            if (com.xiaomi.onetrack.util.p.f9551a && !str.equalsIgnoreCase(ijiami_1011.s.s.s.d(new byte[]{92, 10, 80, Ascii.DC2, 75, 0, 2, 15, 57, 0, 68, 2, 108, Ascii.SYN, 80, Ascii.SYN, 86, 19, Ascii.NAK}, "3d5f9a"))) {
                com.xiaomi.onetrack.util.p.a(f9412a, ijiami_1011.s.s.s.d(new byte[]{68, 69, 4, 83, 90, Ascii.EM, 5, 5, Ascii.DC2, 3, 11}, "07e019") + str2);
            }
            if (zA) {
                com.xiaomi.onetrack.b.a.a().b(this.e.getAdEventAppId());
            }
            com.xiaomi.onetrack.b.a.a().b(this.e.getAppId());
            a(str, jSONObject3, jSONObject4, jSONObject2, zA);
        }
    }

    @Override // com.xiaomi.onetrack.api.j
    public void a(boolean z) {
        com.xiaomi.onetrack.c.i.a(this);
    }

    public boolean a(String str, String str2, boolean z) {
        String str3;
        String strD;
        if (!OneTrack.isDisable() && !OneTrack.isUseSystemNetTrafficOnly()) {
            if (str != null && str.equals(ijiami_1011.s.s.s.d(new byte[]{92, 11, 80, 65, 19, 88, 2, 15, 57, 0, 68, 2, 108, Ascii.ETB, 80, 69, 14, 75, Ascii.NAK}, "3e55a9"))) {
                return true;
            }
            if (z) {
                if (str2 != null && str2.length() > 512000) {
                    str3 = f9412a;
                    strD = ijiami_1011.s.s.s.d(new byte[]{86, 1, Ascii.DC2, 38, 70, 80, 15, 16, 70, 17, 88, Ascii.US, 82, 69, 87, Ascii.ESC, 83, 80, 4, 0, 70, 14, 88, 8, 94, 17, 83, Ascii.ETB, 89, 90, 15, 69}, "7e2c05");
                }
                return true;
            }
            if (str2 != null && str2.length() * 2 > 102400) {
                str3 = f9412a;
                strD = ijiami_1011.s.s.s.d(new byte[]{125, 69, 82, 89, 17, 66, Ascii.DC2, 13, Ascii.FS, 7, 17, 0, SignedBytes.MAX_POWER_OF_TWO, 80, 82, 82, 1, 66, 13, 13, 11, 11, 69, 4, 76, 90, 88, 89, 68}, "8377eb");
            }
            return true;
        }
        str3 = f9412a;
        strD = ijiami_1011.s.s.s.d(new byte[]{50, 16, 2, 81, 10, 88, 15, 3, 70, 6, 80, 17, 7, 66, 10, 65, 65, 85, 8, Ascii.ETB, 7, 0, 93, 0, 2, 66, 12, SignedBytes.MAX_POWER_OF_TWO, 65, 94, 15, 1, Ascii.DC2, 16, 80, 6, 13, 66, Ascii.SYN, 65, 4, 17, Ascii.DC2, Ascii.GS, Ascii.NAK, Ascii.SYN, 84, 8, 70, 12, 6, 70, 65, 69, 19, 5, 0, 4, 88, 6, 70, 13, 13, 94, Ascii.CAN, Ascii.GS, 65, Ascii.ETB, 13, 11, 65, 69, 15, Ascii.SYN, 77}, "fbc2a1");
        com.xiaomi.onetrack.util.p.a(str3, strD);
        return false;
    }
}
