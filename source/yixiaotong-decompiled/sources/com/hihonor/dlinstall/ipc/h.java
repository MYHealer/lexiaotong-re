package com.hihonor.dlinstall.ipc;

import android.os.RemoteException;
import com.hihonor.dlinstall.DownloadInstallTask;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
public class h implements m.a<DownloadInstallTask> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ m f3599a;

    public h(m mVar) {
        this.f3599a = mVar;
    }

    @Override // com.hihonor.dlinstall.ipc.m.a
    public void onErrorAction(DownloadInstallTask downloadInstallTask, int i, String str) {
        DownloadInstallTask downloadInstallTask2 = downloadInstallTask;
        com.hihonor.dlinstall.page.a.b("DownloadInstallService", "pauseDownloadInstall: task is " + downloadInstallTask2 + "code is " + i + ",message is " + str);
        b.a().onDownloadFail(downloadInstallTask2.getChannel(), downloadInstallTask2.getPkgName(), i, str, 0);
    }

    @Override // com.hihonor.dlinstall.ipc.m.a
    public void onSuccessAction(o oVar, DownloadInstallTask downloadInstallTask) {
        try {
            oVar.a(3, m.a(this.f3599a, downloadInstallTask, "pauseDownloadInstall"));
        } catch (RemoteException e) {
            com.hihonor.dlinstall.page.a.b("DownloadInstallService", "pauseDownloadInstall: e is " + e.getMessage());
        }
    }

    @Override // com.hihonor.dlinstall.ipc.m.a
    public void onTimeoutAction(DownloadInstallTask downloadInstallTask) {
        DownloadInstallTask downloadInstallTask2 = downloadInstallTask;
        com.hihonor.dlinstall.page.a.b("DownloadInstallService", "pauseDownloadInstall: timeout, task is " + downloadInstallTask2);
        b.a().onDownloadFail(downloadInstallTask2.getChannel(), downloadInstallTask2.getPkgName(), 10001, "timeout", 0);
    }
}
