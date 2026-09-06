package com.hihonor.dlinstall.ipc;

import android.os.Bundle;
import android.os.RemoteException;
import com.hihonor.dlinstall.clone.WishInfo;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
public class j implements m.a<List<String>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ List f3601a;
    public final /* synthetic */ Boolean b;
    public final /* synthetic */ String c;
    public final /* synthetic */ m.c d;
    public final /* synthetic */ m e;

    public j(m mVar, List list, Boolean bool, String str, m.c cVar) {
        this.e = mVar;
        this.f3601a = list;
        this.b = bool;
        this.c = str;
        this.d = cVar;
    }

    /* JADX WARN: Type inference failed for: r3v8, types: [R, com.hihonor.dlinstall.clone.WishInfo] */
    @Override // com.hihonor.dlinstall.ipc.m.a
    public void onErrorAction(List<String> list, int i, String str) {
        com.hihonor.dlinstall.page.a.b("DownloadInstallService", "addWish: pkgList is " + list + ",code is " + i + ",message is " + str);
        ?? wishInfo = new WishInfo(-1, str, new ArrayList());
        m.c cVar = this.d;
        cVar.f3605a = wishInfo;
        cVar.b.run();
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [R, com.hihonor.dlinstall.clone.WishInfo] */
    @Override // com.hihonor.dlinstall.ipc.m.a
    public void onTimeoutAction(List<String> list) {
        String str = "addWish: timeout, pkgList is " + list;
        com.hihonor.dlinstall.page.a.b("DownloadInstallService", str);
        ?? wishInfo = new WishInfo(-1, str, new ArrayList());
        m.c cVar = this.d;
        cVar.f3605a = wishInfo;
        cVar.b.run();
    }

    @Override // com.hihonor.dlinstall.ipc.m.a
    public void onSuccessAction(o oVar, List<String> list) {
        m mVar = this.e;
        List list2 = this.f3601a;
        Boolean bool = this.b;
        String str = this.c;
        m.c cVar = this.d;
        mVar.getClass();
        com.hihonor.dlinstall.page.a.c("DownloadInstallService", "doAddWish: wishApkNameList is " + list2);
        Bundle bundle = new Bundle();
        bundle.putStringArrayList("key_wish_apk_name", new ArrayList<>(list2));
        bundle.putBoolean("key_is_install", bool.booleanValue());
        mVar.a(bundle, str, "doAddWish");
        bundle.putBinder("key_listener", new k(mVar, cVar));
        try {
            oVar.a(7, bundle);
        } catch (RemoteException e) {
            com.hihonor.dlinstall.page.a.b("DownloadInstallService", "doAddWish: e is " + e.getMessage());
        }
    }
}
