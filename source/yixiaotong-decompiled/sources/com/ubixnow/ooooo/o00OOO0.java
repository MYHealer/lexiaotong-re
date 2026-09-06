package com.ubixnow.ooooo;

import android.text.TextUtils;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class o00OOO0 {
    public String OooO00o;
    public String OooO0O0;
    public Set<String> OooO0OO = new HashSet();

    public o00OOO0() {
    }

    public o00OOO0(String str, String str2) {
        this.OooO00o = str;
        this.OooO0O0 = str2;
    }

    public void OooO00o(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.OooO0OO.add(str);
    }
}
