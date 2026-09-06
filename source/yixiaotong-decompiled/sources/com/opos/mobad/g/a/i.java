package com.opos.mobad.g.a;

import android.text.TextUtils;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class i {

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f6989a;
        public final String b;

        public a(int i) {
            this.f6989a = i;
            this.b = null;
        }

        public a(String str) {
            this.f6989a = 0;
            this.b = str;
        }
    }

    public static final a a(List<String> list) {
        String strA;
        if (list != null) {
            try {
                if (list.size() > 0) {
                    String str = list.get(0);
                    if (TextUtils.isEmpty(str)) {
                        com.opos.cmn.an.f.a.b("RequestIdParser", "empty tag");
                        return new a(2);
                    }
                    try {
                        strA = com.opos.cmn.an.b.b.a(str);
                    } catch (Exception e) {
                        com.opos.cmn.an.f.a.d("RequestIdParser", "", e);
                        strA = null;
                    }
                    if (TextUtils.isEmpty(strA)) {
                        com.opos.cmn.an.f.a.b("RequestIdParser", "error decode base64 tag");
                        return new a(3);
                    }
                    int iIndexOf = strA.indexOf("_");
                    if (iIndexOf > 0 && iIndexOf < strA.length()) {
                        return new a(strA.substring(0, iIndexOf));
                    }
                    com.opos.cmn.an.f.a.b("RequestIdParser", "error decode base64 tag:" + strA);
                    return new a(4);
                }
            } catch (Exception e2) {
                com.opos.cmn.an.f.a.d("RequestIdParser", "", e2);
                return new a(1);
            }
        }
        com.opos.cmn.an.f.a.b("RequestIdParser", "empty list");
        return new a(2);
    }
}
