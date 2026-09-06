package com.ubix.ssp.ad.e.b0.h.s;

import android.text.TextUtils;
import com.ubix.ssp.ad.e.b0.h.o;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class f implements c {
    private String b(String str) {
        int iLastIndexOf = str.lastIndexOf(46);
        return (iLastIndexOf == -1 || iLastIndexOf <= str.lastIndexOf(47) || iLastIndexOf + 6 <= str.length()) ? "" : str.substring(iLastIndexOf + 1, str.length());
    }

    @Override // com.ubix.ssp.ad.e.b0.h.s.c
    public String a(String str) {
        String strB = b(str);
        String strA = o.a(str);
        return TextUtils.isEmpty(strB) ? strA : strA + "." + strB;
    }
}
