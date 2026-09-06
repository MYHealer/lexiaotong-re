package com.kuaishou.weapon.p0;

import android.content.Context;
import android.text.TextUtils;
import com.cdo.oaps.ad.wrapper.BaseWrapper;
import com.huawei.openalliance.ad.views.PPSLabelView;
import com.j256.ormlite.stmt.query.SimpleComparison;
import com.kuaishou.weapon.p0.jni.Engine;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import org.apache.commons.io.IOUtils;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class at {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private JSONObject f4631a;
    private boolean b;
    private boolean c;

    public boolean a() {
        return this.b;
    }

    public boolean b() {
        return this.c;
    }

    public at(Context context) {
        if (Engine.loadSuccess) {
            try {
                String strPqr = Engine.getInstance(context).pqr(Integer.valueOf(ci.h).intValue(), 0, 100, "");
                if (TextUtils.isEmpty(strPqr)) {
                    return;
                }
                this.f4631a = new JSONObject(strPqr);
            } catch (Throwable unused) {
            }
        }
    }

    public String a(String str) {
        JSONObject jSONObject = this.f4631a;
        if (jSONObject == null) {
            return null;
        }
        try {
            return jSONObject.getString(str);
        } catch (Exception unused) {
            return null;
        }
    }

    public JSONArray b(String str) {
        JSONObject jSONObject = this.f4631a;
        if (jSONObject == null) {
            return null;
        }
        try {
            String string = jSONObject.getString(str);
            if (TextUtils.isEmpty(string) || string.length() <= 3) {
                return null;
            }
            JSONArray jSONArray = new JSONArray(string);
            HashSet hashSet = new HashSet();
            for (int i = 0; i < jSONArray.length(); i++) {
                hashSet.add(jSONArray.getString(i));
            }
            JSONArray jSONArray2 = new JSONArray();
            Iterator it = hashSet.iterator();
            while (it.hasNext()) {
                jSONArray2.put(it.next());
            }
            return jSONArray2;
        } catch (Exception unused) {
            return null;
        }
    }

    public Set c(String str) {
        JSONObject jSONObject = this.f4631a;
        if (jSONObject != null) {
            try {
                String strOptString = jSONObject.optString(str, null);
                if (!TextUtils.isEmpty(strOptString) && strOptString.length() > 3) {
                    HashSet hashSet = new HashSet();
                    JSONArray jSONArray = new JSONArray(strOptString);
                    for (int i = 0; i < jSONArray.length(); i++) {
                        hashSet.add(Integer.valueOf(Integer.valueOf((String) jSONArray.get(i), 16).intValue()));
                    }
                    return hashSet;
                }
            } catch (Exception unused) {
            }
        }
        return null;
    }

    public Set a(int i) {
        HashSet hashSet = new HashSet();
        if (i == 0) {
            hashSet.add("/preas/chi");
        }
        return hashSet;
    }

    public Set a(Context context, String str, int i) {
        String strSubstring;
        JSONObject jSONObject = this.f4631a;
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
                String strReplace = jSONArray.getString(i2).replaceAll(PPSLabelView.Code, "").replace(IOUtils.LINE_SEPARATOR_UNIX, "").replace("\t", "").replace("\u200b", "");
                if (strReplace.startsWith(com.huawei.openalliance.ad.constant.x.bQ)) {
                    strSubstring = strReplace;
                    strSubstring = strReplace.substring(1);
                }
                strSubstring = strReplace;
                Object objSubstring = strSubstring.length() > 10 ? strSubstring.substring(0, 10) : strSubstring;
                String packageName = context.getPackageName();
                if (!strSubstring.contains(packageName) && !packageName.contains(strSubstring) && !setA.contains(objSubstring)) {
                    hashSet.add(strSubstring);
                }
            }
            if (hashSet.size() > 0) {
                return hashSet;
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    public JSONArray d(String str) {
        JSONObject jSONObject = this.f4631a;
        if (jSONObject == null) {
            return null;
        }
        try {
            String string = jSONObject.getString(str);
            int i = 0;
            if (TextUtils.equals(str, BaseWrapper.ENTER_ID_OAPS_HEYTAPMULTIAPP)) {
                if (TextUtils.isEmpty(string) || string.length() <= 3) {
                    return null;
                }
                JSONArray jSONArray = new JSONArray(string);
                JSONArray jSONArray2 = new JSONArray();
                while (i < jSONArray.length()) {
                    jSONArray2.put(jSONArray.getString(i).replaceAll(PPSLabelView.Code, "").replace(IOUtils.LINE_SEPARATOR_UNIX, "").replace(SimpleComparison.GREATER_THAN_OPERATION, ""));
                    i++;
                }
                return jSONArray2;
            }
            if (!TextUtils.equals(str, BaseWrapper.ENTER_ID_OAPS_RECENTS)) {
                return null;
            }
            String strA = i.a("aae31bed33c490b6613a", "0701");
            String strA2 = i.a("99e111e83fc4d0a7662b", "0701");
            if (TextUtils.isEmpty(string) || string.length() <= 3) {
                return null;
            }
            JSONArray jSONArray3 = new JSONArray(string);
            HashSet hashSet = new HashSet();
            while (i < jSONArray3.length()) {
                hashSet.add(jSONArray3.getString(i).replaceAll(PPSLabelView.Code, "").replace(IOUtils.LINE_SEPARATOR_UNIX, ""));
                i++;
            }
            JSONArray jSONArray4 = new JSONArray();
            for (Object obj : hashSet) {
                jSONArray4.put(obj);
                String str2 = (String) obj;
                if (str2.contains(strA)) {
                    this.b = true;
                }
                if (str2.contains(strA2)) {
                    this.c = true;
                }
            }
            return jSONArray4;
        } catch (Exception unused) {
            return null;
        }
    }
}
