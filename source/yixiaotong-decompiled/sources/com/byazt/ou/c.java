package com.byazt.ou;

import com.byazt.e.DownloadShortInfo;
import com.byazt.su.DownloadController;
import com.byazt.su.DownloadModel;
import com.byazt.su.DownloadStatusChangeListener;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, 883, 20})
public class c implements DownloadStatusChangeListener {
    @Override // com.byazt.su.DownloadStatusChangeListener
    public void onDownloadActive(DownloadShortInfo downloadShortInfo, int i) {
    }

    @Override // com.byazt.su.DownloadStatusChangeListener
    public void onDownloadFailed(DownloadShortInfo downloadShortInfo) {
    }

    @Override // com.byazt.su.DownloadStatusChangeListener
    public void onDownloadFinished(DownloadShortInfo downloadShortInfo) {
    }

    @Override // com.byazt.su.DownloadStatusChangeListener
    public void onDownloadPaused(DownloadShortInfo downloadShortInfo, int i) {
    }

    @Override // com.byazt.su.DownloadStatusChangeListener
    public void onDownloadStart(DownloadModel downloadModel, DownloadController downloadController) {
    }

    @Override // com.byazt.su.DownloadStatusChangeListener
    public void onIdle() {
    }

    @Override // com.byazt.su.DownloadStatusChangeListener
    public void onInstalled(DownloadShortInfo downloadShortInfo) {
    }
}
