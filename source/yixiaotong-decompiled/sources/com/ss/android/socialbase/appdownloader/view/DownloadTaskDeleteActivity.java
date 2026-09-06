package com.ss.android.socialbase.appdownloader.view;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.Window;
import android.view.WindowManager;
import com.byazt.c.yv;
import com.byazt.nr.m;
import com.byazt.r.c;
import com.byazt.s.n;
import com.byazt.s.t;
import com.byazt.s.u;
import com.byazt.s.uj;
import com.byazt.t.DownloadInfo;
import com.byazt.w.a;
import com.byazt.zz.Downloader;
import com.byazt.zz.ve;
import com.stub.StubApp;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class DownloadTaskDeleteActivity extends Activity {
    private t c;
    private Intent tt;

    static {
        StubApp.interface11(42002);
    }

    @Override // android.app.Activity
    protected native void onCreate(Bundle bundle);

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
    }

    private void c() {
        Window window = getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.alpha = 0.0f;
        window.setAttributes(attributes);
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        this.tt = getIntent();
        tt();
        t tVar = this.c;
        if (tVar != null && !tVar.tt()) {
            this.c.c();
        } else if (this.c == null) {
            finish();
        }
    }

    private void tt() {
        Intent intent;
        if (this.c != null || (intent = this.tt) == null) {
            return;
        }
        try {
            final boolean z = false;
            final int intExtra = intent.getIntExtra("extra_click_download_ids", 0);
            final DownloadInfo downloadInfo = Downloader.getInstance(StubApp.getOrigApplicationContext(getApplicationContext())).getDownloadInfo(intExtra);
            if (downloadInfo == null) {
                return;
            }
            String title = downloadInfo.getTitle();
            if (TextUtils.isEmpty(title)) {
                m.tt("DeleteActivity", "Missing appName; skipping handle");
                return;
            }
            String str = String.format("确认要删除%1$s的下载任务吗？", title);
            uj ujVarTt = com.byazt.z.uj.sl().tt();
            u uVarC = ujVarTt != null ? ujVarTt.c(this) : null;
            if (uVarC == null) {
                uVarC = new c(this);
            }
            if (uVarC != null) {
                String str2 = "确定";
                String str3 = "取消";
                if (com.byazt.k.c.c(downloadInfo.getId()).c("cancel_with_net_opt", 0) == 1 && a.x() && downloadInfo.getCurBytes() != downloadInfo.getTotalBytes()) {
                    z = true;
                }
                if (z) {
                    str2 = "Wi-Fi下恢复";
                    str3 = "直接取消";
                    str = "您当前处于移动网络，是否需要在Wi-Fi环境下恢复下载？";
                }
                uVarC.c((CharSequence) "提示").c(str).c(str2, new DialogInterface.OnClickListener() { // from class: com.ss.android.socialbase.appdownloader.view.DownloadTaskDeleteActivity.3
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i) {
                        if (!z) {
                            DownloadTaskDeleteActivity.this.c(downloadInfo, intExtra);
                        } else {
                            downloadInfo.setOnlyWifi(true);
                            Downloader.getInstance(DownloadTaskDeleteActivity.this).pause(downloadInfo.getId());
                            new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.ss.android.socialbase.appdownloader.view.DownloadTaskDeleteActivity.3.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    Downloader.getInstance(DownloadTaskDeleteActivity.this).resume(downloadInfo.getId());
                                }
                            }, 100L);
                        }
                        DownloadTaskDeleteActivity.this.finish();
                    }
                }).tt(str3, new DialogInterface.OnClickListener() { // from class: com.ss.android.socialbase.appdownloader.view.DownloadTaskDeleteActivity.2
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i) {
                        if (z) {
                            DownloadTaskDeleteActivity.this.c(downloadInfo, intExtra);
                        }
                        DownloadTaskDeleteActivity.this.finish();
                    }
                }).c(new DialogInterface.OnCancelListener() { // from class: com.ss.android.socialbase.appdownloader.view.DownloadTaskDeleteActivity.1
                    @Override // android.content.DialogInterface.OnCancelListener
                    public void onCancel(DialogInterface dialogInterface) {
                        DownloadTaskDeleteActivity.this.finish();
                    }
                });
                this.c = uVarC.c();
            }
        } catch (Exception e) {
            m.c(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(DownloadInfo downloadInfo, int i) {
        n nVarVe = com.byazt.z.uj.sl().ve();
        if (nVarVe != null) {
            nVarVe.c(downloadInfo);
        }
        yv downloadNotificationEventListener = Downloader.getInstance(ve.ic()).getDownloadNotificationEventListener(i);
        if (downloadNotificationEventListener != null) {
            downloadNotificationEventListener.c(10, downloadInfo, "", "");
        }
        if (ve.ic() != null) {
            Downloader.getInstance(ve.ic()).cancel(i);
        }
    }
}
