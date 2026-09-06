package com.hihonor.dlinstall.ipc;

import android.os.Bundle;
import android.text.TextUtils;
import com.hihonor.dlinstall.clone.AppInfo;
import com.hihonor.dlinstall.clone.AppInfoList;
import java.util.ArrayList;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
public class c extends p.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ m.c f3594a;
    public final /* synthetic */ m b;

    public c(m mVar, m.c cVar) {
        this.b = mVar;
        this.f3594a = cVar;
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [R, com.hihonor.dlinstall.clone.AppInfoList] */
    /* JADX WARN: Type inference failed for: r2v3, types: [R, com.hihonor.dlinstall.clone.AppInfoList] */
    /* JADX WARN: Type inference failed for: r2v4, types: [R, com.hihonor.dlinstall.clone.AppInfoList] */
    @Override // com.hihonor.dlinstall.ipc.p
    public void onQueryResult(Bundle bundle) {
        m mVar = this.b;
        m.c cVar = this.f3594a;
        mVar.getClass();
        if (bundle == null) {
            com.hihonor.dlinstall.page.a.c("DownloadInstallService", "handleDownloadAppInfoResult: data = null");
            cVar.f3605a = new AppInfoList(-1, "handleDownloadAppInfoResult: data = null", new ArrayList());
            cVar.b.run();
            return;
        }
        ArrayList<Bundle> parcelableArrayList = bundle.getParcelableArrayList("key_download_app_info_list");
        String string = bundle.getString("key_app_info_list_msg");
        int i = bundle.getInt("key_app_info_list_code");
        if (parcelableArrayList == null || parcelableArrayList.size() == 0) {
            com.hihonor.dlinstall.page.a.c("DownloadInstallService", "handleDownloadAppInfoResult: statusBundleList = null");
            cVar.f3605a = new AppInfoList(-1, "handleDownloadAppInfoResult: statusBundleList = null", new ArrayList());
            cVar.b.run();
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (Bundle bundle2 : parcelableArrayList) {
            String string2 = bundle2.getString("key_pkg_name");
            if (!TextUtils.isEmpty(string2)) {
                arrayList.add(new AppInfo(string2, bundle2.getString("key_app_name"), bundle2.getString("key_icon_url"), bundle2.getString("key_app_size"), bundle2.getInt("key_version_code"), bundle2.getString("key_version_name"), bundle2.getString("key_company_name")));
            }
        }
        cVar.f3605a = new AppInfoList(i, string, arrayList);
        cVar.b.run();
    }
}
