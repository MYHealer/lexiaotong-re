package com.oplus.log.core;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
final class f implements g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private g f5807a;
    private boolean b;
    private i c;

    f() {
    }

    @Override // com.oplus.log.core.g
    public final void logan_debug(boolean z) {
        g gVar = this.f5807a;
        if (gVar != null) {
            gVar.logan_debug(z);
        }
    }

    @Override // com.oplus.log.core.g
    public final void logan_flush() {
        g gVar = this.f5807a;
        if (gVar != null) {
            gVar.logan_flush();
        }
    }

    @Override // com.oplus.log.core.g
    public final void logan_init(String str, String str2, int i, String str3, String str4) {
        if (this.b) {
            return;
        }
        if (!CLoganProtocol.isCloganSuccess()) {
            this.f5807a = null;
            return;
        }
        CLoganProtocol cLoganProtocol = new CLoganProtocol();
        this.f5807a = cLoganProtocol;
        cLoganProtocol.setOnLoganProtocolStatus(this.c);
        this.f5807a.logan_init(str, str2, i, str3, str4);
        this.b = true;
    }

    @Override // com.oplus.log.core.g
    public final void logan_open(String str) {
        g gVar = this.f5807a;
        if (gVar != null) {
            gVar.logan_open(str);
        }
    }

    @Override // com.oplus.log.core.g
    public final void logan_write(int i, String str, long j, String str2, long j2) {
        g gVar = this.f5807a;
        if (gVar != null) {
            gVar.logan_write(i, str, j, str2, j2);
        }
    }

    @Override // com.oplus.log.core.g
    public final void setOnLoganProtocolStatus(i iVar) {
        this.c = iVar;
    }
}
