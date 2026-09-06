package com.kwad.framework.filedownloader;

import android.content.Context;
import com.kwad.sdk.api.proxy.app.FileDownloadService;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class n implements u {
    private final u azY;

    static final class a {
        private static final n azZ = new n(0);
    }

    /* synthetic */ n(byte b) {
        this();
    }

    public static n By() {
        return a.azZ;
    }

    public static com.kwad.framework.filedownloader.services.e.a Bz() {
        if (By().azY instanceof o) {
            return (com.kwad.framework.filedownloader.services.e.a) By().azY;
        }
        return null;
    }

    private n() {
        u pVar;
        if (com.kwad.framework.filedownloader.f.e.Dz().aDv) {
            pVar = new o();
        } else {
            pVar = new p(FileDownloadService.SeparateProcessService.class);
        }
        this.azY = pVar;
    }

    @Override // com.kwad.framework.filedownloader.u
    public final boolean a(String str, String str2, boolean z, int i, int i2, int i3, boolean z2, com.kwad.framework.filedownloader.d.b bVar, boolean z3) {
        return this.azY.a(str, str2, z, i, i2, i3, z2, bVar, z3);
    }

    @Override // com.kwad.framework.filedownloader.u
    public final boolean cv(int i) {
        return this.azY.cv(i);
    }

    @Override // com.kwad.framework.filedownloader.u
    public final byte cw(int i) {
        return this.azY.cw(i);
    }

    @Override // com.kwad.framework.filedownloader.u
    public final boolean isConnected() {
        return this.azY.isConnected();
    }

    @Override // com.kwad.framework.filedownloader.u
    public final void aW(Context context) {
        this.azY.aW(context);
    }

    @Override // com.kwad.framework.filedownloader.u
    public final boolean cx(int i) {
        return this.azY.cx(i);
    }
}
