package com.oplus.stdid.sdk;

import android.content.Context;
import java.util.List;
import s_a.s_a.s_a.c.f;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class b extends s_a.s_a.s_a.a.b {

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f5841a = new b();
    }

    @Override // s_a.s_a.s_a.a.b
    public void a(Context context, List<String> list, boolean z) {
        a(list, "OUID", "");
        a(list, "OUID_STATUS", "FALSE");
        c.b.f5843a.a(context, list, z);
    }

    public final void a(List<String> list, String str, String str2) {
        if (list.contains(str)) {
            this.f9741a.put(str, new f(str2, System.currentTimeMillis() + s_a.s_a.s_a.c.a.b(str)));
            list.remove(str);
        }
    }
}
