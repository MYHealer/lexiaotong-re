package com.opos.videocache.a;

import android.text.TextUtils;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class e implements c {
    private String b(String str) {
        int iLastIndexOf = str.lastIndexOf(46);
        return (iLastIndexOf == -1 || iLastIndexOf <= str.lastIndexOf(47) || iLastIndexOf + 6 <= str.length()) ? "" : str.substring(iLastIndexOf + 1, str.length());
    }

    @Override // com.opos.videocache.a.c
    public String a(String str) {
        String strB = b(str);
        String strD = com.opos.videocache.h.d(str);
        return TextUtils.isEmpty(strB) ? strD : strD + "." + strB;
    }
}
