package com.meishu.sdk.core.uri;

import android.content.Context;
import android.net.Uri;
import com.meishu.sdk.core.ad.AdSlot;
import com.meishu.sdk.core.utils.LogUtil;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: compiled from: UriProcessorUtil.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class c {
    public static c c = new c();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f4861a = "c";
    public ArrayList<b> b = new ArrayList<>();

    public c() {
        a("com.meishu.sdk.core.uri.LiveProcessor");
        this.b.add(new a());
    }

    public final void a(String str) {
        try {
            this.b.add((b) Class.forName(str).newInstance());
        } catch (Exception unused) {
        }
    }

    public void a(Context context, String str, AdSlot adSlot) {
        Uri uri = Uri.parse(str);
        if (uri.getScheme() == null) {
            LogUtil.e(this.f4861a, "uri scheme error");
            return;
        }
        Iterator<b> it = this.b.iterator();
        while (it.hasNext()) {
            if (it.next().a(context, uri, adSlot)) {
                return;
            }
        }
        LogUtil.e(this.f4861a, "uri cannot process: " + str);
    }
}
