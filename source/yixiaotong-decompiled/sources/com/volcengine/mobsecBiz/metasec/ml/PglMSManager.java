package com.volcengine.mobsecBiz.metasec.ml;

import java.util.Map;
import ms.bz.bd.c.Pgl.p0;
import ms.bz.bd.c.Pgl.q0;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\2263432.dex */
public final class PglMSManager implements q0.pgla {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final q0.pgla f9371a;

    PglMSManager(p0 p0Var) {
        this.f9371a = p0Var;
    }

    @Override // ms.bz.bd.c.Pgl.q0.pgla
    public Map<String, String> getFeatureHash(String str, byte[] bArr) {
        return this.f9371a.getFeatureHash(str, bArr);
    }

    @Override // ms.bz.bd.c.Pgl.q0.pgla
    public String getToken() {
        return this.f9371a.getToken();
    }

    @Override // ms.bz.bd.c.Pgl.q0.pgla
    public void report(String str) {
        this.f9371a.report(str);
    }

    @Override // ms.bz.bd.c.Pgl.q0.pgla
    public void setBDDeviceID(String str) {
        this.f9371a.setBDDeviceID(str);
    }

    @Override // ms.bz.bd.c.Pgl.q0.pgla
    public void setCollectMode(int i) {
        this.f9371a.setCollectMode(i);
    }

    @Override // ms.bz.bd.c.Pgl.q0.pgla
    public void setDeviceID(String str) {
        this.f9371a.setDeviceID(str);
    }

    @Override // ms.bz.bd.c.Pgl.q0.pgla
    public void setInstallID(String str) {
        this.f9371a.setInstallID(str);
    }
}
