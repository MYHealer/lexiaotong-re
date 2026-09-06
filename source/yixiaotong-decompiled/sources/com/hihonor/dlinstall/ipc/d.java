package com.hihonor.dlinstall.ipc;

import android.os.Bundle;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
public class d implements m.a<List<String>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f3595a;
    public final /* synthetic */ int b;
    public final /* synthetic */ String c;
    public final /* synthetic */ m.c d;
    public final /* synthetic */ m e;

    public d(m mVar, String str, int i, String str2, m.c cVar) {
        this.e = mVar;
        this.f3595a = str;
        this.b = i;
        this.c = str2;
        this.d = cVar;
    }

    @Override // com.hihonor.dlinstall.ipc.m.a
    public void onErrorAction(List<String> list, int i, String str) {
        com.hihonor.dlinstall.page.a.b("DownloadInstallService", "getAppShelfStatuses: pkgList is " + list + ",code is " + i + ",message is " + str);
        this.d.a(null);
    }

    @Override // com.hihonor.dlinstall.ipc.m.a
    public void onTimeoutAction(List<String> list) {
        com.hihonor.dlinstall.page.a.b("DownloadInstallService", "getAppShelfStatuses: timeout, pkgList is " + list);
        this.d.a(null);
    }

    @Override // com.hihonor.dlinstall.ipc.m.a
    public void onSuccessAction(o oVar, List<String> list) {
        List<String> list2 = list;
        m mVar = this.e;
        String str = this.f3595a;
        int i = this.b;
        String str2 = this.c;
        m.c cVar = this.d;
        mVar.getClass();
        com.hihonor.dlinstall.page.a.c("DownloadInstallService", "doGetAppShelfStatuses: channel is " + i + ",subChannel:" + str2 + ",pkgNameList is " + list2);
        Bundle bundle = new Bundle();
        mVar.a(bundle, str, "doGetAppShelfStatuses");
        bundle.putInt("key_channel", i);
        bundle.putString("key_sub_channel", str2);
        bundle.putStringArrayList("key_package_name_list", new ArrayList<>(list2));
        bundle.putBinder("key_listener", new e(mVar, cVar));
        try {
            oVar.a(5, bundle);
        } catch (Exception e) {
            com.hihonor.dlinstall.page.a.b("DownloadInstallService", "doGetAppShelfStatuses: e is " + e.getMessage());
        }
    }
}
