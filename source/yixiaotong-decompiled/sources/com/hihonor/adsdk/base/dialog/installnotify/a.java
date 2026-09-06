package com.hihonor.adsdk.base.dialog.installnotify;

import com.hihonor.adsdk.base.bean.InstallNotifyBean;
import com.hihonor.adsdk.base.init.ActivateStyle;
import java.util.Objects;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class a implements AdInstallNotify {
    private static final String hnadsb = "AdInstallNotifyImpl";
    private final InstallNotifyBean hnadsa;

    public a(InstallNotifyBean installNotifyBean) {
        this.hnadsa = installNotifyBean;
    }

    private int hnadsa(int i) {
        if (i == 3) {
            return 1;
        }
        if (i == 1) {
            return 0;
        }
        return i;
    }

    private int hnadsa(ActivateStyle activateStyle) {
        if (activateStyle == ActivateStyle.CONFIRM_DIALOG) {
            return 2;
        }
        return activateStyle == ActivateStyle.BOTTOM_BANNER ? 3 : 0;
    }

    @Override // com.hihonor.adsdk.base.dialog.installnotify.AdInstallNotify
    public void installNotifyClick(ActivateStyle activateStyle, int i) {
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsb, "installNotifyClick", new Object[0]);
        new com.hihonor.adsdk.base.g.j.d.g1.a(String.valueOf(3), hnadsa(), com.hihonor.adsdk.base.g.j.g.b.hnadsa(this.hnadsa)).hnadsa(com.hihonor.adsdk.base.g.j.e.a.hnadsh, String.valueOf(hnadsa(activateStyle))).hnadsa(com.hihonor.adsdk.base.g.j.e.a.hnadsk, String.valueOf(hnadsa(i))).hnadse();
    }

    @Override // com.hihonor.adsdk.base.dialog.installnotify.AdInstallNotify
    public void installNotifyDismiss(ActivateStyle activateStyle, long j, int i, int i2) {
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsb, "installNotifyDismiss", new Object[0]);
        new com.hihonor.adsdk.base.g.j.d.g1.b(String.valueOf(3), hnadsa(), com.hihonor.adsdk.base.g.j.g.b.hnadsa(this.hnadsa)).hnadsa(com.hihonor.adsdk.base.g.j.e.a.hnadsh, String.valueOf(hnadsa(activateStyle))).hnadsa(com.hihonor.adsdk.base.g.j.e.a.T0, String.valueOf(i)).hnadsa(com.hihonor.adsdk.base.g.j.e.a.U0, String.valueOf(j)).hnadsa(com.hihonor.adsdk.base.g.j.e.a.V0, String.valueOf(i2)).hnadse();
    }

    @Override // com.hihonor.adsdk.base.dialog.installnotify.AdInstallNotify
    public void installNotifyShow(ActivateStyle activateStyle) {
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsb, "installNotifyShow", new Object[0]);
        new com.hihonor.adsdk.base.g.j.d.g1.c(String.valueOf(3), hnadsa(), com.hihonor.adsdk.base.g.j.g.b.hnadsa(this.hnadsa)).hnadsa(com.hihonor.adsdk.base.g.j.e.a.hnadsh, String.valueOf(hnadsa(activateStyle))).hnadse();
    }

    private String hnadsa() {
        return Objects.isNull(this.hnadsa) ? "" : this.hnadsa.getAdUnitId();
    }
}
