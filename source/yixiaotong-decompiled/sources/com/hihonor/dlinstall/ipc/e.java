package com.hihonor.dlinstall.ipc;

import android.os.Bundle;
import android.text.TextUtils;
import com.hihonor.dlinstall.AppShelfStatus;
import java.util.ArrayList;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
public class e extends p.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ m.c f3596a;
    public final /* synthetic */ m b;

    public e(m mVar, m.c cVar) {
        this.b = mVar;
        this.f3596a = cVar;
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [R, java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r8v2, types: [R, java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r8v6, types: [R, java.util.ArrayList] */
    @Override // com.hihonor.dlinstall.ipc.p
    public void onQueryResult(Bundle bundle) {
        m mVar = this.b;
        m.c cVar = this.f3596a;
        mVar.getClass();
        if (bundle == null) {
            cVar.f3605a = new ArrayList();
            cVar.b.run();
            return;
        }
        ArrayList<Bundle> parcelableArrayList = bundle.getParcelableArrayList("key_app_shelf_status_list");
        if (parcelableArrayList == null || parcelableArrayList.size() == 0) {
            cVar.f3605a = new ArrayList();
            cVar.b.run();
            return;
        }
        ?? arrayList = new ArrayList();
        for (Bundle bundle2 : parcelableArrayList) {
            String string = bundle2.getString("key_package_name");
            if (!TextUtils.isEmpty(string)) {
                boolean z = bundle2.getBoolean("key_is_online");
                boolean z2 = bundle2.getBoolean("key_is_online_max_version");
                ArrayList<String> stringArrayList = bundle2.getStringArrayList("key_supported_country_list");
                if (stringArrayList == null || stringArrayList.size() == 0) {
                    stringArrayList = new ArrayList<>();
                }
                arrayList.add(new AppShelfStatus(string, z, z2, stringArrayList));
            }
        }
        cVar.f3605a = arrayList;
        cVar.b.run();
    }
}
