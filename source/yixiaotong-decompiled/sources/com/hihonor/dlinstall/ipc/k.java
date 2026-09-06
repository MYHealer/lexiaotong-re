package com.hihonor.dlinstall.ipc;

import android.os.Bundle;
import android.text.TextUtils;
import com.hihonor.dlinstall.clone.WishInfo;
import com.hihonor.dlinstall.clone.WishVo;
import java.util.ArrayList;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
public class k extends p.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ m.c f3602a;
    public final /* synthetic */ m b;

    public k(m mVar, m.c cVar) {
        this.b = mVar;
        this.f3602a = cVar;
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [R, com.hihonor.dlinstall.clone.WishInfo] */
    /* JADX WARN: Type inference failed for: r2v4, types: [R, com.hihonor.dlinstall.clone.WishInfo] */
    /* JADX WARN: Type inference failed for: r3v4, types: [R, com.hihonor.dlinstall.clone.WishInfo] */
    @Override // com.hihonor.dlinstall.ipc.p
    public void onQueryResult(Bundle bundle) {
        m mVar = this.b;
        m.c cVar = this.f3602a;
        mVar.getClass();
        if (bundle == null) {
            com.hihonor.dlinstall.page.a.c("DownloadInstallService", "doAddWish: data = null");
            cVar.f3605a = new WishInfo(-1, "doAddWish: data = null", new ArrayList());
            cVar.b.run();
            return;
        }
        ArrayList<Bundle> parcelableArrayList = bundle.getParcelableArrayList("key_add_wish");
        if (parcelableArrayList == null || parcelableArrayList.size() == 0) {
            com.hihonor.dlinstall.page.a.c("DownloadInstallService", "doAddWish: statusBundleList = null");
            cVar.f3605a = new WishInfo(-1, "doAddWish: statusBundleList = null", new ArrayList());
            cVar.b.run();
            return;
        }
        ArrayList arrayList = new ArrayList();
        int i = bundle.getInt("key_wish_Interface_request_code");
        String string = bundle.getString("key_wish_add_list_msg");
        for (Bundle bundle2 : parcelableArrayList) {
            String string2 = bundle2.getString("key_wish_apk_name_list");
            if (!TextUtils.isEmpty(string2)) {
                arrayList.add(new WishVo(string2, bundle2.getInt("key_wish_code")));
            }
        }
        cVar.f3605a = new WishInfo(i, string, arrayList);
        cVar.b.run();
    }
}
