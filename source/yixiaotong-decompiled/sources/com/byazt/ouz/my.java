package com.byazt.ouz;

import android.os.Looper;
import android.view.View;
import com.byazt.xv.ThemeStatusBroadcastReceiver;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, 27, 145})
public class my extends com.byazt.xl.c<BackupView> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public com.byazt.xl.u f2603a;
    public BackupView c;
    public com.byazt.xl.sp n;
    public View tt;
    public com.byazt.xl.ve uj;
    public ThemeStatusBroadcastReceiver ve;

    @Override // com.byazt.xl.uj
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public BackupView sp() {
        return this.c;
    }

    @Override // com.byazt.xl.c
    public void c(com.byazt.xl.ve veVar) {
        this.uj = veVar;
    }

    public my(View view, ThemeStatusBroadcastReceiver themeStatusBroadcastReceiver, com.byazt.xl.u uVar) {
        this.tt = view;
        this.ve = themeStatusBroadcastReceiver;
        this.f2603a = uVar;
    }

    @Override // com.byazt.xl.uj
    public void c(com.byazt.xl.sp spVar) {
        this.n = spVar;
        if (Looper.myLooper() == Looper.getMainLooper()) {
            tt();
        } else {
            com.byazt.omf.rh.a().post(new Runnable() { // from class: com.byazt.ouz.my.1
                @Override // java.lang.Runnable
                public void run() {
                    my.this.tt();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tt() {
        com.byazt.xl.ve veVar = this.uj;
        if (veVar == null || !veVar.c((NativeExpressView) this.tt, 0)) {
            this.n.c(107, (String) null);
            return;
        }
        this.f2603a.sp().da();
        BackupView backupView = (BackupView) this.tt.findViewWithTag("tt_express_backup_fl_tag_26");
        this.c = backupView;
        if (backupView != null) {
            backupView.setThemeChangeReceiver(this.ve);
            com.byazt.xl.yp ypVar = new com.byazt.xl.yp();
            BackupView backupView2 = this.c;
            float realWidth = backupView2 == null ? 0.0f : backupView2.getRealWidth();
            BackupView backupView3 = this.c;
            float realHeight = backupView3 != null ? backupView3.getRealHeight() : 0.0f;
            ypVar.c(true);
            ypVar.c(realWidth);
            ypVar.tt(realHeight);
            this.n.c(this.c, ypVar);
            return;
        }
        this.n.c(107, (String) null);
    }
}
