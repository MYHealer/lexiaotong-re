package com.hihonor.adsdk.base.dialog;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.PopupWindow;
import com.hihonor.adsdk.base.ErrorCode;
import com.hihonor.adsdk.base.HnAds;
import com.hihonor.adsdk.base.bean.InstallNotifyBean;
import com.hihonor.adsdk.base.bean.InstallResultBean;
import com.hihonor.adsdk.base.bean.f;
import com.hihonor.adsdk.base.callback.AppDownloadListener;
import com.hihonor.adsdk.base.dialog.installnotify.AdInstallNotify;
import com.hihonor.adsdk.base.dialog.installnotify.c;
import com.hihonor.adsdk.base.dialog.installnotify.d;
import com.hihonor.adsdk.base.download.g;
import com.hihonor.adsdk.base.g.j.d.x;
import com.hihonor.adsdk.base.init.ActivateStyle;
import com.hihonor.adsdk.base.j.h;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class a {
    public static final String hnadsk = "key_activate_type";
    private static final String hnadsl = "AppInstallNotifyControl";
    private static final int hnadsm = 5;
    private static final int hnadsn = 3;
    private static final int hnadso = 300;
    private static final String hnadsp = "com.hihonor.servicecenter";
    private ActivateStyle hnadsa;
    private int hnadsb;
    private boolean hnadsc;
    private WeakReference<View> hnadsd;
    private InstallNotifyBean hnadse;
    private com.hihonor.adsdk.base.dialog.installnotify.b hnadsf;
    private final List<AppDownloadListener> hnadsg;
    private final com.hihonor.adsdk.common.safe.a<String, InstallNotifyBean> hnadsh;
    private AdInstallNotify hnadsi;
    private String hnadsj;

    /* JADX INFO: renamed from: com.hihonor.adsdk.base.dialog.a$a, reason: collision with other inner class name */
    static /* synthetic */ class C0428a {
    }

    private static final class b {
        static final a hnadsa = new a(null);

        private b() {
        }
    }

    /* synthetic */ a(C0428a c0428a) {
        this();
    }

    public static a hnadsc() {
        return b.hnadsa;
    }

    private String hnadsd() {
        return Objects.isNull(this.hnadse) ? "" : this.hnadse.getAdUnitId();
    }

    public synchronized void hnadsa(AppDownloadListener appDownloadListener) {
        if (!this.hnadsg.contains(appDownloadListener)) {
            this.hnadsg.add(appDownloadListener);
        }
    }

    public synchronized void hnadsb(AppDownloadListener appDownloadListener) {
        try {
            if (appDownloadListener == null) {
                com.hihonor.adsdk.common.b.b.hnadse(hnadsl, "unregisterNotifyListener listener is null", new Object[0]);
            } else {
                this.hnadsg.remove(appDownloadListener);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public void hnadse() {
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsl, "onAppBackground", new Object[0]);
        this.hnadsc = false;
        this.hnadsd = null;
        hnadsb();
    }

    public void hnadsf() {
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsl, "publicDismissNotifyPopupWindow", new Object[0]);
        hnadsb(4);
    }

    private a() {
        this.hnadsa = ActivateStyle.DISMISS_DIALOG;
        this.hnadsc = false;
        this.hnadsg = Collections.synchronizedList(new ArrayList());
        this.hnadsh = new com.hihonor.adsdk.common.safe.a<>();
    }

    private void hnadsc(int i) {
        new com.hihonor.adsdk.base.g.j.d.g1.b(String.valueOf(3), hnadsd(), com.hihonor.adsdk.base.g.j.g.b.hnadsa(this.hnadse)).hnadsa(com.hihonor.adsdk.base.g.j.e.a.hnadsh, String.valueOf(hnadsa(this.hnadsa))).hnadsa(com.hihonor.adsdk.base.g.j.e.a.V0, String.valueOf(i)).hnadse();
    }

    private synchronized void hnadsa(String str) {
        try {
            if (str == null) {
                com.hihonor.adsdk.common.b.b.hnadse(hnadsl, "notifyDownloadFinish appPackage is null", new Object[0]);
                return;
            }
            InstallNotifyBean installNotifyBean = this.hnadsh.get(str);
            if (installNotifyBean == null) {
                com.hihonor.adsdk.common.b.b.hnadse(hnadsl, "notifyDownloadFinish installNotifyBean is null", new Object[0]);
                return;
            }
            for (AppDownloadListener appDownloadListener : this.hnadsg) {
                String logo = installNotifyBean.getLogo();
                if (TextUtils.isEmpty(logo) && installNotifyBean.getImgUrls() != null && installNotifyBean.getImgUrls().size() > 0) {
                    logo = installNotifyBean.getImgUrls().get(0);
                }
                appDownloadListener.installFinish(new InstallResultBean.BeanBuilder().setAdRequestId(installNotifyBean.getAdRequestId()).setAdUnitId(installNotifyBean.getAdUnitId()).setAdId(installNotifyBean.getAdId()).setTitle(installNotifyBean.getTitle()).setBrand(installNotifyBean.getBrand()).setImgUrl(logo).setAdInstallNotify(new com.hihonor.adsdk.base.dialog.installnotify.a(installNotifyBean)).build());
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public void hnadsb(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            if (this.hnadsh.isEmpty()) {
                com.hihonor.adsdk.common.b.b.hnadse(hnadsl, "removeInvalidDownloadAdInfo mInstallNotifyBeanHashMap is empty", new Object[0]);
                return;
            }
            InstallNotifyBean installNotifyBean = this.hnadsh.get(str);
            if (installNotifyBean == null) {
                com.hihonor.adsdk.common.b.b.hnadse(hnadsl, "removeInvalidDownloadAdInfo installNotifyBean is null", new Object[0]);
                return;
            }
            if (!str2.equals(installNotifyBean.getRequestId())) {
                com.hihonor.adsdk.common.b.b.hnadse(hnadsl, "removeInvalidDownloadAdInfo requestIs is no match", new Object[0]);
                return;
            }
            int status = installNotifyBean.getStatus();
            com.hihonor.adsdk.common.b.b.hnadsc(hnadsl, "removeInvalidDownloadAdInfo  status = " + status, new Object[0]);
            if (status == -1 || status == 2007 || status == 2006 || status == 2013 || status == 2008) {
                com.hihonor.adsdk.common.b.b.hnadsc(hnadsl, "removeInvalidDownloadAdInfo  packName" + str, new Object[0]);
                this.hnadsh.remove(str);
                return;
            }
            return;
        }
        com.hihonor.adsdk.common.b.b.hnadse(hnadsl, "removeInvalidDownloadAdInfo packName or requestId is empty", new Object[0]);
    }

    public void hnadsa(String str, InstallNotifyBean installNotifyBean) {
        if (TextUtils.isEmpty(str)) {
            com.hihonor.adsdk.common.b.b.hnadse(hnadsl, "putDownloadAdInfo packName is null", new Object[0]);
        } else if (installNotifyBean == null) {
            com.hihonor.adsdk.common.b.b.hnadse(hnadsl, "putDownloadAdInfo installNotifyBean is null", new Object[0]);
        } else {
            this.hnadsh.put(str, installNotifyBean);
            com.hihonor.adsdk.common.b.b.hnadsc(hnadsl, "putDownloadAdInfo packName = " + str, new Object[0]);
        }
    }

    public void hnadsb(String str) {
        if (str == null) {
            com.hihonor.adsdk.common.b.b.hnadsc(hnadsl, "removeDownloadAdInfo packName is null", new Object[0]);
        } else {
            com.hihonor.adsdk.common.b.b.hnadsc(hnadsl, "removeDownloadAdInfo packName " + str, new Object[0]);
            this.hnadsh.remove(str);
        }
    }

    private void hnadsb() {
        hnadsb(12);
    }

    private void hnadsb(int i) {
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsl, "dismissNotifyPopupWindow " + Objects.nonNull(this.hnadsf), new Object[0]);
        if (Objects.isNull(this.hnadsf)) {
            hnadsa(ErrorCode.AD_NOTIFY_POPUP_WINDOW_DIS_NULL, i);
            return;
        }
        hnadsa(ErrorCode.AD_NOTIFY_POPUP_WINDOW_DIS, i);
        this.hnadsf.hnadsa(i);
        this.hnadsf = null;
    }

    public void hnadsa(String str, g gVar) {
        if (!TextUtils.isEmpty(str) && !Objects.isNull(gVar)) {
            InstallNotifyBean installNotifyBean = this.hnadsh.get(str);
            if (installNotifyBean == null) {
                com.hihonor.adsdk.common.b.b.hnadse(hnadsl, "updateDownloadAdInfo installNotifyBean isEmpty", new Object[0]);
                return;
            } else {
                com.hihonor.adsdk.common.b.b.hnadsc(hnadsl, "updateDownloadAdInfo packName = " + str + " newStatus = " + gVar.k(), new Object[0]);
                installNotifyBean.setStatus(gVar.k());
                return;
            }
        }
        com.hihonor.adsdk.common.b.b.hnadse(hnadsl, "updateDownloadAdInfo appPackage or adDIInfo isEmpty", new Object[0]);
    }

    private void hnadsb(ActivateStyle activateStyle) {
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsl, "startInstallNotifyActivity", new Object[0]);
        Bundle bundle = new Bundle();
        bundle.putSerializable(hnadsk, activateStyle);
        f fVarHnadsa = h.hnadsa(InstallNotifyActivity.class, bundle);
        if (fVarHnadsa.hnadsa() != 0) {
            new x(hnadsd(), com.hihonor.adsdk.base.g.j.g.b.hnadsa(this.hnadse), ErrorCode.AD_CODE_START_ACTIVITY_FAILED, fVarHnadsa.hnadsb()).hnadsa("code", String.valueOf(fVarHnadsa.hnadsa())).hnadse();
        }
    }

    public void hnadsa(String str, String str2) {
        hnadsa(str);
        if (str == null) {
            com.hihonor.adsdk.common.b.b.hnadse(hnadsl, "handleInstallNotify appPackage is null", new Object[0]);
            return;
        }
        this.hnadse = this.hnadsh.get(str);
        if (this.hnadsa == ActivateStyle.DISMISS_DIALOG) {
            hnadsc(5);
            com.hihonor.adsdk.common.b.b.hnadse(hnadsl, "handleInstallNotify mActivateStyle type is DISMISS_DIALOG", new Object[0]);
            return;
        }
        if (Objects.nonNull(this.hnadsf)) {
            hnadsb();
        }
        InstallNotifyBean installNotifyBean = this.hnadse;
        if (installNotifyBean == null) {
            com.hihonor.adsdk.common.b.b.hnadse(hnadsl, "handleInstallNotify mInstallNotifyBean is null", new Object[0]);
            return;
        }
        if (installNotifyBean.getPkgType() == 0 && !hnadsp.equals(str2)) {
            com.hihonor.adsdk.common.b.b.hnadse(hnadsl, "handleInstallNotify pkgType is third app", new Object[0]);
            hnadsc(6);
            return;
        }
        WeakReference<View> weakReference = this.hnadsd;
        if (weakReference == null || weakReference.get() == null) {
            if (!com.hihonor.adsdk.base.a.hnadsa().hnadsd()) {
                com.hihonor.adsdk.common.b.b.hnadsc(hnadsl, "handleInstallNotify is in background activity", new Object[0]);
                hnadsc(8);
                return;
            }
        } else if (!this.hnadsc) {
            hnadsc(7);
            com.hihonor.adsdk.common.b.b.hnadsc(hnadsl, "handleInstallNotify is in background", new Object[0]);
            return;
        }
        hnadsa();
    }

    public void hnadsa(Activity activity) {
        if (this.hnadsf == null) {
            com.hihonor.adsdk.common.b.b.hnadse(hnadsl, "topActivityDestroy mBaseInstallNotifyPopupWindow is null", new Object[0]);
            return;
        }
        if (activity == null) {
            com.hihonor.adsdk.common.b.b.hnadse(hnadsl, "topActivityDestroy activity is null", new Object[0]);
            return;
        }
        String strValueOf = String.valueOf(activity);
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsl, "topActivityDestroy mTopActivityClassName = " + this.hnadsj + " destroyClassName = " + strValueOf, new Object[0]);
        if (strValueOf.equals(this.hnadsj)) {
            com.hihonor.adsdk.common.b.b.hnadsc(hnadsl, "topActivityDestroy match top activity", new Object[0]);
            hnadsb();
            this.hnadsj = "";
        }
    }

    private void hnadsa(int i, int i2) {
        new x(Objects.nonNull(this.hnadse) ? this.hnadse.getAdUnitId() : "", com.hihonor.adsdk.base.g.j.g.b.hnadsa(this.hnadse), i, ErrorCode.STR_AD_NOTIFY_POPUP_WINDOW_DIS).hnadsa("code", String.valueOf(i2)).hnadse();
    }

    public void hnadsa(ActivateStyle activateStyle, int i) {
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsl, "setAppActivateStrategy appActivateStrategy = " + activateStyle + " showTime = " + i, new Object[0]);
        this.hnadsa = activateStyle;
        this.hnadsb = hnadsa(i);
    }

    public void hnadsa(View view) {
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsl, "onAppForeground rootView " + view, new Object[0]);
        this.hnadsc = true;
        this.hnadsd = new WeakReference<>(view);
    }

    private int hnadsa(int i) {
        if ((i < 3 || i > 300) && i != -1) {
            i = 5;
        }
        int millis = (int) TimeUnit.SECONDS.toMillis(i);
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsl, "calWindowDisMissTime mDelayCloseTime = " + millis, new Object[0]);
        return millis;
    }

    private void hnadsa() {
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsl, "chooseInstallNotifyType mActivateStyle = " + this.hnadsa, new Object[0]);
        ActivateStyle activateStyle = this.hnadsa;
        if (activateStyle == ActivateStyle.CONFIRM_DIALOG) {
            hnadsb(activateStyle);
            return;
        }
        if (activateStyle == ActivateStyle.BOTTOM_BANNER) {
            Activity activityHnadsb = com.hihonor.adsdk.base.a.hnadsa().hnadsb();
            if (activityHnadsb == null) {
                com.hihonor.adsdk.common.b.b.hnadsc(hnadsl, "chooseInstallNotifyType topActivity is null", new Object[0]);
            }
            if (activityHnadsb == null && this.hnadsd == null) {
                hnadsb(this.hnadsa);
            } else {
                hnadsa(activityHnadsb != null ? activityHnadsb.getWindow().getDecorView().getRootView() : this.hnadsd.get(), null, activityHnadsb != null ? String.valueOf(activityHnadsb) : "");
            }
        }
    }

    public void hnadsa(View view, final PopupWindow.OnDismissListener onDismissListener, String str) {
        Context context = HnAds.get().getContext();
        if (context == null) {
            com.hihonor.adsdk.common.b.b.hnadsc(hnadsl, "showInstallNotifyWindow context is null", new Object[0]);
            hnadsa(onDismissListener, 9);
            return;
        }
        if (!com.hihonor.adsdk.common.f.h.hnadsa(view)) {
            com.hihonor.adsdk.common.b.b.hnadsc(hnadsl, "showInstallNotifyWindow rootView is null", new Object[0]);
            hnadsa(onDismissListener, 10);
            return;
        }
        InstallNotifyBean installNotifyBean = this.hnadse;
        if (installNotifyBean == null) {
            com.hihonor.adsdk.common.b.b.hnadsc(hnadsl, "showInstallNotifyWindow mInstallNotifyBean is null", new Object[0]);
            hnadsa(onDismissListener, 11);
            return;
        }
        this.hnadsj = str;
        this.hnadsi = new com.hihonor.adsdk.base.dialog.installnotify.a(installNotifyBean);
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsl, "showInstallNotifyWindow mActivateStyle = " + this.hnadsa + " mTopActivityClassName = " + this.hnadsj, new Object[0]);
        ActivateStyle activateStyle = this.hnadsa;
        if (activateStyle == ActivateStyle.BOTTOM_BANNER) {
            this.hnadsf = new c(context, this.hnadse);
        } else if (activateStyle == ActivateStyle.CONFIRM_DIALOG) {
            this.hnadsf = new d(context, this.hnadse);
        }
        this.hnadsf.hnadsa(new com.hihonor.adsdk.base.dialog.installnotify.b.d() { // from class: com.hihonor.adsdk.base.dialog.a$$ExternalSyntheticLambda0
            @Override // com.hihonor.adsdk.base.dialog.installnotify.b.d
            public final void hnadsa(int i, long j, int i2) {
                this.f$0.hnadsa(onDismissListener, i, j, i2);
            }
        });
        try {
            this.hnadsf.hnadsa(view, this.hnadsb);
            this.hnadsi.installNotifyShow(this.hnadsa);
        } catch (Exception e) {
            hnadsa(onDismissListener, e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void hnadsa(PopupWindow.OnDismissListener onDismissListener, int i, long j, int i2) {
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsl, "window dismiss", new Object[0]);
        this.hnadsf = null;
        hnadsa(onDismissListener);
        AdInstallNotify adInstallNotify = this.hnadsi;
        if (adInstallNotify == null) {
            return;
        }
        if (i == 1 || i == 3) {
            adInstallNotify.installNotifyClick(this.hnadsa, i);
        }
        this.hnadsi.installNotifyDismiss(this.hnadsa, j, i2, i);
    }

    private void hnadsa(PopupWindow.OnDismissListener onDismissListener, Exception exc) {
        String str = "notify popup window show, but there has exception:" + exc.getMessage();
        com.hihonor.adsdk.common.b.b.hnadsb(hnadsl, "showInstallNotifyWindow fail msg = " + str, new Object[0]);
        new x(hnadsd(), com.hihonor.adsdk.base.g.j.g.b.hnadsa(this.hnadse), ErrorCode.AD_NOTIFY_POPUP_WINDOW_SHOW_EXCEPTION, str).hnadse();
        hnadsa(onDismissListener);
    }

    private void hnadsa(PopupWindow.OnDismissListener onDismissListener) {
        if (Objects.isNull(onDismissListener)) {
            com.hihonor.adsdk.common.b.b.hnadsb(hnadsl, "notifyWindowDismiss listener is null", new Object[0]);
        } else {
            com.hihonor.adsdk.common.b.b.hnadsc(hnadsl, "notifyWindowDismiss", new Object[0]);
            onDismissListener.onDismiss();
        }
    }

    private void hnadsa(PopupWindow.OnDismissListener onDismissListener, int i) {
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsl, "handleWindowShowException code = " + i, new Object[0]);
        hnadsa(onDismissListener);
        hnadsc(i);
    }

    private int hnadsa(ActivateStyle activateStyle) {
        if (activateStyle == ActivateStyle.CONFIRM_DIALOG) {
            return 2;
        }
        return activateStyle == ActivateStyle.BOTTOM_BANNER ? 3 : 0;
    }
}
