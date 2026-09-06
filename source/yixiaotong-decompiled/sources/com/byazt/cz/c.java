package com.byazt.cz;

import android.text.TextUtils;
import androidx.exifinterface.media.ExifInterface;
import com.baidu.mobads.sdk.api.SplashAd;
import com.byazt.ly.uj;
import com.byazt.nr.m;
import com.byazt.px.tt;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.j256.ormlite.stmt.query.SimpleComparison;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, 605, 20})
public class c {
    public static final ArrayList<C0128c> c = new ArrayList<>();
    public static final String[] tt;
    public static final ArrayList<String> uj;
    public static final ArrayList<String> ve;

    /* JADX INFO: renamed from: com.byazt.cz.c$c, reason: collision with other inner class name */
    @com.byazt.zqa.c(c = {0, 1, 605, 44})
    private static class C0128c {
        public String c;
        public int tt;
        public String ve;

        public C0128c(String str, int i, String str2) {
            this.c = str;
            this.tt = i;
            this.ve = str2;
        }
    }

    static {
        String[] strArr = {"TTTransparentActivity", "openadsdk", "com.byazt.mta", "com.qq", "com.kwad", "baidu", "mbridge", MediationConstant.ADN_SIGMOB, MediationConstant.ADN_UNITY, MediationConstant.ADN_KLEVIN};
        tt = strArr;
        ve = new ArrayList<>(Arrays.asList(strArr));
        uj = new ArrayList<>();
    }

    public static boolean c(String str, int i, int i2) {
        ArrayList<C0128c> arrayList = c;
        if (arrayList.size() <= 0) {
            return TextUtils.equals("baidu", str);
        }
        for (C0128c c0128c : arrayList) {
            if (c0128c != null && TextUtils.equals(c0128c.c, str) && i2 == c0128c.tt) {
                String str2 = c0128c.ve;
                uj ujVarC = tt.c().c(str);
                String networkSdkVersion = ujVarC != null ? ujVarC.getNetworkSdkVersion() : null;
                if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(networkSdkVersion)) {
                    if (str2.startsWith(SimpleComparison.LESS_THAN_EQUAL_TO_OPERATION)) {
                        return c(networkSdkVersion, str2);
                    }
                    if (str2.startsWith(SimpleComparison.GREATER_THAN_EQUAL_TO_OPERATION)) {
                        return tt(networkSdkVersion, str2);
                    }
                }
            }
        }
        return false;
    }

    private static boolean c(String str, String str2) {
        return ve(str, str2) <= 0;
    }

    private static boolean tt(String str, String str2) {
        return ve(str, str2) >= 0;
    }

    private static int ve(String str, String str2) {
        String strSubstring = str2.substring(2);
        if (str.startsWith("v") || str.startsWith(ExifInterface.GPS_MEASUREMENT_INTERRUPTED)) {
            str = str.substring(1);
        }
        return str.compareTo(strSubstring);
    }

    public static void c(String str) {
        ArrayList<String> arrayList;
        List listAsList;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            try {
                JSONObject jSONObject = new JSONObject(str);
                ve.clear();
                JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("act_str");
                if (jSONArrayOptJSONArray != null && jSONArrayOptJSONArray.length() > 0) {
                    for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                        String strOptString = jSONArrayOptJSONArray.optString(i);
                        if (!TextUtils.isEmpty(strOptString)) {
                            ve.add(strOptString);
                        }
                    }
                }
                uj.clear();
                JSONArray jSONArrayOptJSONArray2 = jSONObject.optJSONArray("not_act_str");
                if (jSONArrayOptJSONArray2 != null && jSONArrayOptJSONArray2.length() > 0) {
                    for (int i2 = 0; i2 < jSONArrayOptJSONArray2.length(); i2++) {
                        String strOptString2 = jSONArrayOptJSONArray2.optString(i2);
                        if (!TextUtils.isEmpty(strOptString2)) {
                            uj.add(strOptString2);
                        }
                    }
                }
                c.clear();
                JSONArray jSONArrayOptJSONArray3 = jSONObject.optJSONArray("not_support");
                if (jSONArrayOptJSONArray3 != null && jSONArrayOptJSONArray3.length() > 0) {
                    for (int i3 = 0; i3 < jSONArrayOptJSONArray3.length(); i3++) {
                        JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray3.optJSONObject(i3);
                        if (jSONObjectOptJSONObject != null) {
                            c.add(new C0128c(jSONObjectOptJSONObject.optString(SplashAd.KEY_BIDFAIL_ADN), jSONObjectOptJSONObject.optInt("subtype"), jSONObjectOptJSONObject.optString("versions")));
                        }
                    }
                }
                arrayList = ve;
                listAsList = Arrays.asList(tt);
            } catch (JSONException e) {
                m.c(e);
                arrayList = ve;
                listAsList = Arrays.asList(tt);
            }
            arrayList.addAll(listAsList);
        } catch (Throwable th) {
            ve.addAll(Arrays.asList(tt));
            throw th;
        }
    }

    public static boolean tt(String str) {
        com.byazt.eu.tt.tt("TTMediationSDK", "--==--- activityStr: ".concat(String.valueOf(str)));
        Iterator<String> it = ve.iterator();
        while (it.hasNext()) {
            if (str.contains(it.next())) {
                return ve(str);
            }
        }
        return false;
    }

    private static boolean ve(String str) {
        ArrayList<String> arrayList = uj;
        if (arrayList.size() == 0) {
            return true;
        }
        Iterator<String> it = arrayList.iterator();
        while (it.hasNext()) {
            if (str.contains(it.next())) {
                return false;
            }
        }
        return true;
    }
}
