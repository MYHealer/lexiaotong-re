package com.xiaomi.onetrack.a.b;

import android.text.TextUtils;
import com.google.common.base.Ascii;
import com.xiaomi.onetrack.b.h;
import com.xiaomi.onetrack.util.p;
import ijiami_1011.s.s.s;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\2263432.dex */
public class b extends com.xiaomi.onetrack.f.b {
    private static final String d = s.d(new byte[]{120, 103, 115, 6, 125, 71, 4, 10, Ascii.DC2}, "732b81");
    private List<a> e = null;

    public b(String str, String str2, String str3, String str4) {
        try {
            a(str);
            c(str3);
            b(str2);
            b(System.currentTimeMillis());
            JSONObject jSONObject = new JSONObject(str4);
            JSONObject jSONObject2 = jSONObject.getJSONObject(s.d(new byte[]{41}, "a757ab"));
            b(jSONObject);
            a(h.a().a(str, str3, s.d(new byte[]{89, 3, Ascii.DC4, 86, 92}, "5fb30c"), 0));
            a(jSONObject2);
            c(jSONObject2);
        } catch (Exception e) {
            p.b(s.d(new byte[]{46, 99, 34, 84, 115, Ascii.DC2, 4, 10, Ascii.DC2}, "a7c06d"), s.d(new byte[]{33, 67, 69, 69, 95, 94, 36, Ascii.DC2, 3, 12, 69, 69, 7, 68, 68, 94, 66, 9}, "b66103") + e.toString());
        }
    }

    private void c(JSONObject jSONObject) {
        if (jSONObject != null && jSONObject.has(com.xiaomi.onetrack.f.b.C1162b.H)) {
            jSONObject.remove(com.xiaomi.onetrack.f.b.C1162b.H);
        }
    }

    public List<a> a() {
        return this.e;
    }

    public void a(JSONObject jSONObject) {
        StringBuilder sbAppend;
        String string;
        if (jSONObject == null) {
            return;
        }
        try {
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray(com.xiaomi.onetrack.f.b.C1162b.H);
            if (jSONArrayOptJSONArray == null || jSONArrayOptJSONArray.length() <= 0) {
                return;
            }
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                String strOptString = jSONArrayOptJSONArray.optString(i);
                if (!TextUtils.isEmpty(strOptString)) {
                    if (strOptString.contains(s.d(new byte[]{5, 66, 8, Ascii.RS, 5, 85, 79, Ascii.FS, 15, 3, 94, 8, 13, Ascii.FS, 2, 95, 9}, "d2a0d1")) && !strOptString.contains(s.d(new byte[]{62, 71, 12, 102}, "a4b929"))) {
                        if (strOptString.contains(s.d(new byte[]{9}, "6c573a"))) {
                            sbAppend = new StringBuilder().append(strOptString).append(s.d(new byte[]{67, 105, Ascii.DC2, 94, 108, 10}, "e6a037"));
                            string = UUID.randomUUID().toString();
                        } else {
                            sbAppend = new StringBuilder().append(strOptString).append(s.d(new byte[]{6, 107, 71, 95, 108, 95}, "94413b"));
                            string = UUID.randomUUID().toString();
                        }
                        strOptString = sbAppend.append(string).toString();
                    }
                    a aVar = new a();
                    aVar.c(c());
                    aVar.a(e());
                    aVar.a(h());
                    aVar.d(d());
                    aVar.b(strOptString);
                    arrayList.add(aVar);
                }
            }
            this.e = arrayList;
        } catch (Throwable th) {
            p.a(d, s.d(new byte[]{72, 3, 67, 66, 7, 121, 5, 41, 9, 12, 88, 17, 87, 16, 17, 101, 10, 74, 14, 19, 7, 0, 93, 0, 2}, "8b11b8") + th.getMessage());
        }
    }
}
