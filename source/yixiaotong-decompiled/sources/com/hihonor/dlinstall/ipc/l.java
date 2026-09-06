package com.hihonor.dlinstall.ipc;

import android.os.Bundle;
import android.os.RemoteException;
import com.hihonor.dlinstall.clone.AppInfoList;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
public class l implements m.a<List<String>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f3603a;
    public final /* synthetic */ m.c b;
    public final /* synthetic */ m c;

    public l(m mVar, String str, m.c cVar) {
        this.c = mVar;
        this.f3603a = str;
        this.b = cVar;
    }

    /* JADX WARN: Type inference failed for: r3v8, types: [R, com.hihonor.dlinstall.clone.AppInfoList] */
    @Override // com.hihonor.dlinstall.ipc.m.a
    public void onErrorAction(List<String> list, int i, String str) {
        com.hihonor.dlinstall.page.a.b("DownloadInstallService", "getDownloadAppInfo: pkgList is " + list + ",code is " + i + ",message is " + str);
        ?? appInfoList = new AppInfoList(-1, str, new ArrayList());
        m.c cVar = this.b;
        cVar.f3605a = appInfoList;
        cVar.b.run();
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [R, com.hihonor.dlinstall.clone.AppInfoList] */
    @Override // com.hihonor.dlinstall.ipc.m.a
    public void onTimeoutAction(List<String> list) {
        String str = "getDownloadAppInfo: timeout, pkgList is " + list;
        com.hihonor.dlinstall.page.a.b("DownloadInstallService", str);
        ?? appInfoList = new AppInfoList(-1, str, new ArrayList());
        m.c cVar = this.b;
        cVar.f3605a = appInfoList;
        cVar.b.run();
    }

    @Override // com.hihonor.dlinstall.ipc.m.a
    public void onSuccessAction(o oVar, List<String> list) {
        List<String> list2 = list;
        m mVar = this.c;
        String str = this.f3603a;
        m.c cVar = this.b;
        mVar.getClass();
        com.hihonor.dlinstall.page.a.c("DownloadInstallService", "doGetDownloadAppInfo: pkgNameList is " + list2);
        Bundle bundle = new Bundle();
        mVar.a(bundle, str, "doGetDownloadAppInfo");
        bundle.putStringArrayList("key_package_name_list", new ArrayList<>(list2));
        bundle.putBinder("key_listener", new c(mVar, cVar));
        try {
            oVar.a(6, bundle);
        } catch (RemoteException e) {
            com.hihonor.dlinstall.page.a.b("DownloadInstallService", "doGetDownloadAppInfo: e is " + e.getMessage());
        }
    }
}
