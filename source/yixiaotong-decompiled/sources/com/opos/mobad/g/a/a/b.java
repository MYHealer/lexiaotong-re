package com.opos.mobad.g.a.a;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class b implements com.opos.mobad.ad.b.a, o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private p f6919a;
    private int b;

    public b(int i, p pVar) {
        this.b = i;
        this.f6919a = pVar;
    }

    @Override // com.opos.mobad.ad.b.a
    public void a() {
        this.f6919a.d(this.b);
    }

    @Override // com.opos.mobad.g.a.a.o
    public void a(int i, int i2, String str) {
        com.opos.cmn.an.f.a.b("AdDelegateListener", "onChannelFailed =" + this.b + "," + i + ",code=" + i2 + ",msg=" + str);
        this.f6919a.a(m.a(this.b, i, i2, str));
    }

    @Override // com.opos.mobad.ad.b.a
    public void a(int i, String str) {
        a(this.b, i, str);
    }

    @Override // com.opos.mobad.ad.b.a
    public void b() {
        this.f6919a.e(this.b);
    }
}
