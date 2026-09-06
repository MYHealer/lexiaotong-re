package com.huawei.hms.feature.dynamic;

import android.os.Bundle;
import com.huawei.hms.common.util.Logger;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public final class d {
    public static final String b = "d";
    public static final d c = new d();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Set<String> f4029a;

    public static d a() {
        return c;
    }

    public void a(Bundle bundle) {
        ArrayList<String> stringArrayList = bundle.getStringArrayList("installed_module_name");
        if (stringArrayList == null || stringArrayList.isEmpty()) {
            Logger.w(b, "Get installed module name failed.");
            this.f4029a = new HashSet();
        } else {
            Logger.i(b, "Installed module name:" + stringArrayList);
            this.f4029a = new HashSet(stringArrayList);
        }
    }
}
