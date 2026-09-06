package com.hihonor.dlinstall.ipc;

import android.os.Bundle;
import com.hihonor.dlinstall.state.DIDownloadPausedState;
import com.hihonor.dlinstall.state.DIDownloadSuccessState;
import com.hihonor.dlinstall.state.DIDownloadingState;
import com.hihonor.dlinstall.state.DIInstallingState;
import com.hihonor.dlinstall.state.DINoneState;
import com.hihonor.dlinstall.state.DIWaitingState;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
public class f implements m.a<List<String>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f3597a;
    public final /* synthetic */ m.c b;
    public final /* synthetic */ m c;

    public f(m mVar, String str, m.c cVar) {
        this.c = mVar;
        this.f3597a = str;
        this.b = cVar;
    }

    @Override // com.hihonor.dlinstall.ipc.m.a
    public void onErrorAction(List<String> list, int i, String str) {
        com.hihonor.dlinstall.page.a.b("DownloadInstallService", "getDownloadInstallStatuses: pkgList is " + list + "code is " + i + ",message is " + str);
        this.b.a(null);
    }

    @Override // com.hihonor.dlinstall.ipc.m.a
    public void onTimeoutAction(List<String> list) {
        com.hihonor.dlinstall.page.a.b("DownloadInstallService", "getDownloadInstallStatuses: timeout, pkgList=$pkgList");
        this.b.a(null);
    }

    /* JADX WARN: Type inference failed for: r5v3, types: [R, java.util.ArrayList] */
    @Override // com.hihonor.dlinstall.ipc.m.a
    public void onSuccessAction(o oVar, List<String> list) {
        Object dINoneState;
        List<String> list2 = list;
        m mVar = this.c;
        String str = this.f3597a;
        m.c cVar = this.b;
        mVar.getClass();
        com.hihonor.dlinstall.page.a.c("DownloadInstallService", "doGetDownloadInstallStatuses: pkgNameList is " + list2);
        ?? arrayList = new ArrayList();
        for (String str2 : list2) {
            Bundle bundle = new Bundle();
            mVar.a(bundle, str, "doGetDownloadInstallStatuses");
            bundle.putString("key_package_name", str2);
            try {
                oVar.a(1, bundle);
                int i = bundle.getInt("key_download_install_state", 0);
                com.hihonor.dlinstall.page.a.c("DownloadInstallService", "doGetDownloadInstallStatuses: pkgName is " + str2 + ",state is " + i);
                if (i == 0) {
                    dINoneState = new DINoneState(str2);
                } else if (i == 1) {
                    arrayList.add(new DIDownloadingState(str2, bundle.getLong("key_current_size", -1L), bundle.getLong("key_total_size", -1L), bundle.getFloat("key_speed", -1.0f), bundle.getInt("key_task_type", 0)));
                } else if (i == 2) {
                    dINoneState = new DIDownloadPausedState(str2, bundle.getLong("key_current_size", -1L), bundle.getLong("key_total_size", -1L), bundle.getInt("key_task_type", 0));
                } else if (i == 3) {
                    arrayList.add(new DIDownloadSuccessState(str2, bundle.getLong("key_total_size", -1L), bundle.getInt("key_task_type", 0)));
                } else if (i == 4) {
                    dINoneState = new DIInstallingState(str2);
                } else if (i == 5) {
                    dINoneState = new DIWaitingState(str2, bundle.getLong("key_current_size", -1L), bundle.getLong("key_total_size", -1L), bundle.getInt("key_download_waiting_state", 0), bundle.getInt("key_task_type", 0));
                }
                arrayList.add(dINoneState);
            } catch (Exception e) {
                com.hihonor.dlinstall.page.a.b("DownloadInstallService", "doGetDownloadInstallStatuses: e is " + e.getMessage());
            }
        }
        cVar.f3605a = arrayList;
        cVar.b.run();
    }
}
