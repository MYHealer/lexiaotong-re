package com.ubixnow.ooooo;

import java.util.HashMap;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class f1 {
    private HashMap<String, e1> OooO00o = new HashMap<>();
    private g1.OooO0O0 OooO0O0 = g1.OooO00o(hashCode() + "");

    public void OooO00o() {
        this.OooO0O0.OooO00o();
        this.OooO00o.clear();
    }

    public synchronized void OooO00o(e1 e1Var) {
        if (e1Var.OooO00o() == e1.OooO00o.REPLACE_OLD) {
            this.OooO0O0.OooO00o(this.OooO00o.put(e1Var.getName(), e1Var));
        }
        this.OooO0O0.OooO0OO(e1Var);
    }
}
