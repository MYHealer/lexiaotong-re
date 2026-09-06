package com.kuaishou.weapon.p0;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.openalliance.ad.views.PPSLabelView;
import com.kuaishou.weapon.p0.jni.Engine;
import java.util.HashSet;
import java.util.Set;
import org.apache.commons.io.IOUtils;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class aw {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private JSONObject f4634a;

    public aw(Context context) {
        if (Engine.loadSuccess) {
            try {
                String strPqr = Engine.getInstance(context).pqr(Integer.valueOf(ci.h).intValue(), 1, 0, "");
                if (TextUtils.isEmpty(strPqr)) {
                    return;
                }
                this.f4634a = new JSONObject(strPqr);
            } catch (Throwable unused) {
            }
        }
    }

    public String a(String str) {
        JSONObject jSONObject = this.f4634a;
        if (jSONObject != null) {
            try {
                return jSONObject.optString(str, null);
            } catch (Exception unused) {
            }
        }
        return null;
    }

    public Set a(Context context, String str, int i) {
        JSONObject jSONObject = this.f4634a;
        if (jSONObject == null) {
            return null;
        }
        try {
            String string = jSONObject.getString(str);
            Set setA = a(i);
            if (TextUtils.isEmpty(string) || string.length() <= 3) {
                return null;
            }
            JSONArray jSONArray = new JSONArray(string);
            HashSet hashSet = new HashSet();
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                String string2 = jSONArray.getString(i2);
                if (!string2.contains("azeroth") && !string2.contains("OkHttp") && !string2.contains("retrofit")) {
                    int i3 = 0;
                    while (string2.contains(PPSLabelView.Code)) {
                        string2 = string2.replace(PPSLabelView.Code, "");
                        i3++;
                        if (i3 > 200) {
                            break;
                        }
                    }
                    String strReplace = string2.replace(IOUtils.LINE_SEPARATOR_UNIX, "").replace("\t", "").replace("\u200b", "");
                    boolean zStartsWith = strReplace.startsWith(com.huawei.openalliance.ad.constant.x.bQ);
                    String strSubstring = strReplace;
                    if (zStartsWith) {
                        strSubstring = strReplace.substring(1);
                    }
                    Object objSubstring = strSubstring.length() > 10 ? strSubstring.substring(0, 10) : strSubstring;
                    if (strSubstring.contains("ridge")) {
                        hashSet.add(strSubstring);
                    }
                    String packageName = context.getPackageName();
                    if (!strSubstring.contains(packageName) && !packageName.contains(strSubstring) && !setA.contains(objSubstring) && !b(i).contains(objSubstring)) {
                        hashSet.add(strSubstring);
                    }
                }
            }
            if (hashSet.size() > 0) {
                return hashSet;
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    public Set a(int i) {
        HashSet hashSet = new HashSet();
        if (i == 1) {
            hashSet.add("HeapTaskDa");
            hashSet.add("queued-wor");
            hashSet.add("JDWP");
            hashSet.add("dTi");
            hashSet.add("MessageHan");
            hashSet.add("MediaPrefe");
            hashSet.add("CleanupRef");
            hashSet.add("GeoLocatio");
            hashSet.add("securityai");
            hashSet.add("Connectivi");
            hashSet.add("PatchManag");
            hashSet.add("CronetInte");
            hashSet.add("AegonLogge");
            hashSet.add("Countly");
            hashSet.add("DownloadSt");
            hashSet.add("GoogleApiH");
            hashSet.add("PlatformSe");
            hashSet.add("MemoryInfr");
            hashSet.add("CronetLibr");
            hashSet.add("Dex2OatIni");
            hashSet.add("EncodeApiH");
            hashSet.add("CookieMons");
        }
        return hashSet;
    }

    public Set b(int i) {
        HashSet hashSet = new HashSet();
        if (i == 1) {
            hashSet.add("AudioTrack");
            hashSet.add("processrea");
            hashSet.add("RemitDatab");
            hashSet.add("BrowserBlo");
            hashSet.add("game_push");
            hashSet.add("Godzilla:I");
            hashSet.add("IndexedDB");
            hashSet.add("ScopeRetry");
            hashSet.add("RobustPatc");
            hashSet.add("FrescoIoBo");
            hashSet.add("key_config");
        }
        return hashSet;
    }
}
