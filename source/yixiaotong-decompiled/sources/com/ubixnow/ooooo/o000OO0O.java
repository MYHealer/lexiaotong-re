package com.ubixnow.ooooo;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.ViewGroup;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class o000OO0O extends o0O00o0 {
    private final o00OOOOo OooOOoo;

    public o000OO0O(Context context) {
        super(context);
        this.OooOOoo = new o00Oo00();
    }

    private void OooO0OO(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            o0OO0 o0oo0 = new o0OO0();
            o0oo0.OooOO0O = this.OooOOoo.OooO0OO();
            o0oo0.OooOOO = str;
            o0OO0O0.OooO oooO = o0OO0O0.OooO.LARGE;
            o0oo0.OooOO0o = oooO;
            o0oo0.OooOOO0 = 1;
            o0oo0.OooOOOo = o0OO000.OooO00o(this.OooOO0.OooOO0);
            o0oo0.OooOO0o = oooO;
            new o0OO0O0().OooO00o(o0oo0, (Activity) null);
        } catch (Exception unused) {
        }
    }

    public o00OOOOo OooO00o(ViewGroup viewGroup, String str) {
        if (viewGroup == null) {
            return null;
        }
        this.OooOOoo.OooO00o(viewGroup, null);
        if (viewGroup.getContext() != null) {
            this.OooOOoo.OooO0OO(viewGroup.getContext());
        } else {
            this.OooOOoo.OooO0OO(this.OooO0o.get());
        }
        OooO0OO(str);
        return this.OooOOoo;
    }
}
