package com.hihonor.dlinstall.ipc;

import android.os.RemoteException;
import com.hihonor.dlinstall.DownloadInstallTask;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
public class i implements m.a<DownloadInstallTask> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ m f3600a;

    public i(m mVar) {
        this.f3600a = mVar;
    }

    @Override // com.hihonor.dlinstall.ipc.m.a
    public void onErrorAction(DownloadInstallTask downloadInstallTask, int i, String str) {
        DownloadInstallTask downloadInstallTask2 = downloadInstallTask;
        com.hihonor.dlinstall.page.a.b("DownloadInstallService", "cancelDownloadInstall: task is " + downloadInstallTask2 + "code is " + i + ",message is " + str);
        b.a().onDownloadFail(downloadInstallTask2.getChannel(), downloadInstallTask2.getPkgName(), i, str, 0);
    }

    @Override // com.hihonor.dlinstall.ipc.m.a
    public void onSuccessAction(o oVar, DownloadInstallTask downloadInstallTask) {
        try {
            oVar.a(4, m.a(this.f3600a, downloadInstallTask, "cancelDownloadInstall"));
        } catch (RemoteException e) {
            com.hihonor.dlinstall.page.a.b("DownloadInstallService", "cancelDownloadInstall: e is " + e.getMessage());
        }
    }

    @Override // com.hihonor.dlinstall.ipc.m.a
    public void onTimeoutAction(DownloadInstallTask downloadInstallTask) {
        DownloadInstallTask downloadInstallTask2 = downloadInstallTask;
        com.hihonor.dlinstall.page.a.b("DownloadInstallService", "cancelDownloadInstall: timeout, task is " + downloadInstallTask2);
        b.a().onDownloadFail(downloadInstallTask2.getChannel(), downloadInstallTask2.getPkgName(), 10001, "timeout", 0);
    }
}
