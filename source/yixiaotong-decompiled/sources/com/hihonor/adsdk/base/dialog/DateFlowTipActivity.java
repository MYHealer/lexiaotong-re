package com.hihonor.adsdk.base.dialog;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.format.Formatter;
import android.view.Window;
import android.widget.Button;
import com.hihonor.adsdk.base.ErrorCode;
import com.hihonor.adsdk.base.HnAds;
import com.hihonor.adsdk.base.R;
import com.hihonor.adsdk.base.api.BaseAd;
import com.hihonor.adsdk.base.download.f;
import com.hihonor.adsdk.base.download.g;
import com.hihonor.adsdk.base.download.p;
import com.hihonor.adsdk.base.g.j.d.x;
import com.hihonor.adsdk.base.g.j.d.x0;
import com.hihonor.adsdk.base.g.j.d.y0;
import com.hihonor.adsdk.base.g.k.c.n;
import com.hihonor.adsdk.base.g.k.c.o;
import com.hihonor.adsdk.base.j.h;
import com.hihonor.adsdk.base.j.m;
import com.hihonor.adsdk.common.f.u;
import com.hihonor.adsdk.common.f.y;
import com.hihonor.adsdk.common.safe.SafeIntent;
import com.stub.StubApp;
import java.util.Objects;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class DateFlowTipActivity extends com.hihonor.adsdk.base.widget.base.a {
    private static final String hnadsi = "DateFlowTipActivityTAG";
    private static final String hnadsj = "key_base_ad";
    private static final String hnadsk = "key_scene";
    private static final String hnadsl;
    private static final String hnadsm;
    private static b hnadsn;
    private BaseAd hnadse;
    private int hnadsf;
    private f hnadsg;
    private c hnadsh;

    static /* synthetic */ class a {
    }

    public interface b {
        void hnadsa();
    }

    private class c implements p {
        private boolean hnadsa;

        private c() {
            this.hnadsa = false;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void hnadsb() {
            this.hnadsa = true;
        }

        @Override // com.hihonor.adsdk.base.download.p
        public void hnadsc(int i, String str) {
            com.hihonor.adsdk.common.b.b.hnadsc(DateFlowTipActivity.hnadsi, "onPauseFail, code: " + i + ", msg: " + str, new Object[0]);
        }

        @Override // com.hihonor.adsdk.base.download.p
        public void hnadsd(int i, String str) {
            com.hihonor.adsdk.common.b.b.hnadsc(DateFlowTipActivity.hnadsi, "onGetAppStatusFail, code: " + i + ", msg: " + str, new Object[0]);
        }

        @Override // com.hihonor.adsdk.base.download.p
        public void hnadse(int i, String str) {
            com.hihonor.adsdk.common.b.b.hnadsc(DateFlowTipActivity.hnadsi, "onCancelFail, code: " + i + ", msg: " + str, new Object[0]);
        }

        @Override // com.hihonor.adsdk.base.download.p
        public void hnadsa(int i, String str) {
            com.hihonor.adsdk.common.b.b.hnadsc(DateFlowTipActivity.hnadsi, "onStartInstallFail, code: " + i + ", msg: " + str, new Object[0]);
        }

        @Override // com.hihonor.adsdk.base.download.p
        public void hnadsb(int i, String str) {
            com.hihonor.adsdk.common.b.b.hnadsc(DateFlowTipActivity.hnadsi, "onStartDownloadFail, code: " + i + ", msg: " + str, new Object[0]);
        }

        @Override // com.hihonor.adsdk.base.download.p
        public void hnadsa(g gVar) {
            if (gVar == null) {
                com.hihonor.adsdk.common.b.b.hnadsa(DateFlowTipActivity.hnadsi, (Object) "onStatusChange#adDiInfo is null");
                return;
            }
            if (this.hnadsa) {
                com.hihonor.adsdk.common.b.b.hnadsa(DateFlowTipActivity.hnadsi, (Object) "onStatusChange#isInterceptionReporting is true");
                return;
            }
            if (gVar.hnadsz() == 1) {
                com.hihonor.adsdk.common.b.b.hnadsa(DateFlowTipActivity.hnadsi, "onStatusChange adDiInfo from manual status:%s", Integer.valueOf(gVar.k()));
                return;
            }
            com.hihonor.adsdk.common.b.b.hnadsa(DateFlowTipActivity.hnadsi, "onStatusChange#adDiInfo.getStatus = %s ", Integer.valueOf(gVar.k()));
            if (gVar.k() == 2003) {
                new y0(DateFlowTipActivity.this.hnadsf, DateFlowTipActivity.this.hnadse.getAdUnitId(), com.hihonor.adsdk.base.g.j.g.b.hnadsa(DateFlowTipActivity.this.hnadse)).hnadse();
                new o(DateFlowTipActivity.this.hnadsf).hnadsa(DateFlowTipActivity.this.hnadse, DateFlowTipActivity.this.hnadse.getTrackUrl().getCommons());
                hnadsa();
                return;
            }
            if (gVar.k() == 2008) {
                new x0(DateFlowTipActivity.this.hnadsf, DateFlowTipActivity.this.hnadse.getAdUnitId(), com.hihonor.adsdk.base.g.j.g.b.hnadsa(DateFlowTipActivity.this.hnadse)).hnadse();
                new o(DateFlowTipActivity.this.hnadsf).hnadsa(DateFlowTipActivity.this.hnadse, DateFlowTipActivity.this.hnadse.getTrackUrl().getCommons());
                hnadsa();
            }
        }

        /* synthetic */ c(DateFlowTipActivity dateFlowTipActivity, a aVar) {
            this();
        }

        private void hnadsa() {
            if (DateFlowTipActivity.this.isFinishing()) {
                return;
            }
            DateFlowTipActivity.this.finish();
        }
    }

    static {
        StubApp.interface11(31584);
        hnadsl = "androidhwext:style/Theme." + m.hnadsc() + ".Dialog.Alert";
        hnadsm = "androidhwext:style/Theme." + m.hnadsc() + ".Dark.Emphasize.Dialog";
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        f fVar = this.hnadsg;
        if (fVar != null) {
            fVar.hnadsa(this.hnadsh);
        }
        this.hnadsh = null;
        this.hnadsg = null;
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsi, "onDestroy", new Object[0]);
    }

    public static void hnadsa(BaseAd baseAd, int i, b bVar) {
        hnadsa(baseAd, i);
        hnadsn = bVar;
    }

    @Override // android.app.Activity
    public void finish() {
        hnadsn = null;
        super.finish();
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsi, "finish", new Object[0]);
    }

    @Override // com.hihonor.adsdk.base.widget.base.a
    protected void hnadsb(Bundle bundle) {
        y.hnadsa(getWindow());
        Intent intent = getIntent();
        if (intent != null) {
            intent.setExtrasClassLoader(getClassLoader());
        }
        SafeIntent safeIntent = new SafeIntent(intent);
        BaseAd baseAd = (BaseAd) safeIntent.getParcelableExtra(hnadsj);
        this.hnadse = baseAd;
        if (baseAd == null) {
            com.hihonor.adsdk.common.b.b.hnadsc(hnadsi, "mBaseAd is null", new Object[0]);
            finish();
        } else {
            this.hnadsf = safeIntent.getIntExtra(hnadsk, 0);
            hnadsc();
        }
    }

    public void hnadsc() {
        if (this.hnadse == null) {
            com.hihonor.adsdk.common.b.b.hnadse(hnadsi, "showTitleMessageDialog mBaseAd is null", new Object[0]);
            return;
        }
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsi, "showTitleMessageDialog", new Object[0]);
        final com.hihonor.adsdk.base.g.j.d.h1.a aVarHnadsa = com.hihonor.adsdk.base.g.j.g.b.hnadsa(this.hnadse);
        hnadsc(aVarHnadsa);
        this.hnadsh = new c(this, null);
        f fVarHnadsa = f.hnadsa(this.hnadse);
        this.hnadsg = fVarHnadsa;
        fVarHnadsa.hnadsb(this.hnadsh, this.hnadsf);
        AlertDialog.Builder builder = new AlertDialog.Builder(this, hnadsb());
        builder.setTitle(getString(R.string.ads_flow_download_tip));
        builder.setMessage(getResources().getString(R.string.ads_flow_download_content, hnadsa(this.hnadse.getPkgSizeBytes())));
        builder.setPositiveButton(getString(R.string.ads_continue_download), new DialogInterface.OnClickListener() { // from class: com.hihonor.adsdk.base.dialog.DateFlowTipActivity$$ExternalSyntheticLambda0
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.f$0.hnadsa(aVarHnadsa, dialogInterface, i);
            }
        });
        builder.setNegativeButton(getString(R.string.ads_talk_later), new DialogInterface.OnClickListener() { // from class: com.hihonor.adsdk.base.dialog.DateFlowTipActivity$$ExternalSyntheticLambda1
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.f$0.hnadsb(aVarHnadsa, dialogInterface, i);
            }
        });
        builder.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.hihonor.adsdk.base.dialog.DateFlowTipActivity$$ExternalSyntheticLambda2
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                this.f$0.hnadsa(dialogInterface);
            }
        });
        AlertDialog alertDialogCreate = builder.create();
        alertDialogCreate.setCanceledOnTouchOutside(true);
        alertDialogCreate.setCancelable(true);
        hnadsa(alertDialogCreate);
        alertDialogCreate.show();
        hnadsb(alertDialogCreate);
    }

    public static void hnadsa(BaseAd baseAd, int i) {
        Bundle bundle = new Bundle();
        bundle.putParcelable(hnadsj, baseAd);
        bundle.putInt(hnadsk, i);
        com.hihonor.adsdk.base.bean.f fVarHnadsa = h.hnadsa(DateFlowTipActivity.class, bundle);
        if (Objects.isNull(fVarHnadsa)) {
            com.hihonor.adsdk.common.b.b.hnadsc(hnadsi, "startDateFlowTipActivity resultBean is null", new Object[0]);
            return;
        }
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsi, "startDateFlowTipActivity code = %s, msg = %s", Integer.valueOf(fVarHnadsa.hnadsa()), fVarHnadsa.hnadsb());
        if (fVarHnadsa.hnadsa() != 0) {
            new x(baseAd != null ? baseAd.getAdUnitId() : "", com.hihonor.adsdk.base.g.j.g.b.hnadsb(), ErrorCode.AD_CODE_START_ACTIVITY_FAILED, fVarHnadsa.hnadsb()).hnadsa("code", String.valueOf(fVarHnadsa.hnadsa())).hnadse();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void hnadsb(com.hihonor.adsdk.base.g.j.d.h1.a aVar, DialogInterface dialogInterface, int i) {
        hnadsa(aVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void hnadsa(com.hihonor.adsdk.base.g.j.d.h1.a aVar, DialogInterface dialogInterface, int i) {
        this.hnadsh.hnadsb();
        this.hnadsg.hnadsa(null, this.hnadsf, true);
        hnadsb(aVar);
        b bVar = hnadsn;
        if (bVar != null) {
            bVar.hnadsa();
        }
    }

    private void hnadsb(com.hihonor.adsdk.base.g.j.d.h1.a aVar) {
        BaseAd baseAd = this.hnadse;
        if (baseAd == null || baseAd.getTrackUrl() == null) {
            return;
        }
        new com.hihonor.adsdk.base.g.j.d.g1.a(String.valueOf(1), this.hnadse.getAdUnitId(), aVar).hnadsa(com.hihonor.adsdk.base.g.j.e.a.hnadsh, String.valueOf(this.hnadsf)).hnadsa(com.hihonor.adsdk.base.g.j.e.a.hnadsk, String.valueOf(1)).hnadse();
        o oVar = new o(this.hnadsf);
        BaseAd baseAd2 = this.hnadse;
        oVar.hnadsa(baseAd2, baseAd2.getTrackUrl().getCommons());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void hnadsa(DialogInterface dialogInterface) {
        if (isFinishing()) {
            return;
        }
        finish();
    }

    private void hnadsa(com.hihonor.adsdk.base.g.j.d.h1.a aVar) {
        BaseAd baseAd = this.hnadse;
        if (baseAd == null || baseAd.getTrackUrl() == null) {
            return;
        }
        new com.hihonor.adsdk.base.g.j.d.g1.a(String.valueOf(1), this.hnadse.getAdUnitId(), aVar).hnadsa(com.hihonor.adsdk.base.g.j.e.a.hnadsh, String.valueOf(this.hnadsf)).hnadsa(com.hihonor.adsdk.base.g.j.e.a.hnadsk, String.valueOf(0)).hnadse();
        n nVar = new n(this.hnadsf);
        BaseAd baseAd2 = this.hnadse;
        nVar.hnadsa(baseAd2, baseAd2.getTrackUrl().getCommons());
    }

    private void hnadsb(AlertDialog alertDialog) {
        Button button = alertDialog.getButton(-2);
        if (button != null) {
            button.setAllCaps(false);
        }
        Button button2 = alertDialog.getButton(-1);
        if (button2 != null) {
            button2.setAllCaps(false);
        }
    }

    private int hnadsb() {
        String str = hnadsl;
        if (u.hnadsi()) {
            str = hnadsm;
        }
        return getResources().getIdentifier(str, null, null);
    }

    private void hnadsa(AlertDialog alertDialog) {
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsi, "handleLandscapeDialog", new Object[0]);
        Context context = HnAds.get().getContext();
        if (context == null) {
            com.hihonor.adsdk.common.b.b.hnadsc(hnadsi, "handleLandscapeDialog context is null", new Object[0]);
            return;
        }
        if (u.hnadsc(context)) {
            com.hihonor.adsdk.common.b.b.hnadsc(hnadsi, "handleLandscapeDialog screen is portrait", new Object[0]);
            return;
        }
        Window window = alertDialog.getWindow();
        if (window == null) {
            com.hihonor.adsdk.common.b.b.hnadsc(hnadsi, "handleLandscapeDialog alertDialogWindow is null", new Object[0]);
        } else if (Build.VERSION.SDK_INT >= 28) {
            com.hihonor.adsdk.common.b.b.hnadsc(hnadsi, "handleLandscapeDialog SDK_INT is Greater than or equal to P", new Object[0]);
            window.getAttributes().layoutInDisplayCutoutMode = 1;
        }
    }

    private void hnadsc(com.hihonor.adsdk.base.g.j.d.h1.a aVar) {
        BaseAd baseAd = this.hnadse;
        if (baseAd == null || baseAd.getTrackUrl() == null) {
            return;
        }
        new com.hihonor.adsdk.base.g.j.d.g1.c(String.valueOf(1), this.hnadse.getAdUnitId(), aVar).hnadsa(com.hihonor.adsdk.base.g.j.e.a.hnadsh, String.valueOf(this.hnadsf)).hnadse();
        com.hihonor.adsdk.base.g.k.c.p pVar = new com.hihonor.adsdk.base.g.k.c.p(this.hnadsf);
        BaseAd baseAd2 = this.hnadse;
        pVar.hnadsa(baseAd2, baseAd2.getTrackUrl().getCommons());
    }

    private String hnadsa(long j) {
        return Formatter.formatFileSize(this, j);
    }
}
