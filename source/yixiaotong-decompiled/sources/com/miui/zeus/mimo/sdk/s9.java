package com.miui.zeus.mimo.sdk;

import com.google.common.base.Ascii;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class s9 extends u9 {
    public final /* synthetic */ r9 c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public s9(r9 r9Var, String str, String str2) {
        super(str, str2);
        this.c = r9Var;
    }

    @Override // com.miui.zeus.mimo.sdk.u9
    public void a() {
        r9 r9Var = this.c;
        r9Var.f5587a.unbindService(r9Var);
        String str = ijiami_1011.s.s.s.d(new byte[]{103, 12, 90, 92, 95, 82, 65, 55, 3, 16, 71, 12, 81, 7, 99}, "2b8516") + this.c.d + ijiami_1011.s.s.s.d(new byte[]{79, Ascii.CAN}, "c80d61") + this.c.c + ijiami_1011.s.s.s.d(new byte[]{101}, "88b5de");
    }
}
