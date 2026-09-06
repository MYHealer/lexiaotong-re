package com.opos.mobad.g.a.a;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class w extends a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f6948a;

    public w(String str, int i, long j) {
        super(str, j);
        this.f6948a = 3 == i ? "sdk_bidding" : "sdk_dsp";
    }

    @Override // com.opos.mobad.g.a.a.a
    protected void a(String str, long j, String str2, int i, long j2, String str3, String str4) {
        com.opos.mobad.c.b.f().a(str, str2, i, j2, str3, this.f6948a, j, str4);
    }

    @Override // com.opos.mobad.g.a.a.a
    protected void b(String str, long j, String str2, int i, long j2, String str3, String str4) {
        com.opos.mobad.c.b.f().b(str, str2, i, j2, str3, this.f6948a, j, str4);
    }
}
