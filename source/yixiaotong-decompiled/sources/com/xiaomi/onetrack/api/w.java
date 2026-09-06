package com.xiaomi.onetrack.api;

import android.text.TextUtils;
import com.huawei.openalliance.ad.views.PPSLabelView;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\2263432.dex */
public class w implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Map f9443a;
    public final /* synthetic */ m b;

    public w(m mVar, Map map) {
        this.b = mVar;
        this.f9443a = map;
    }

    @Override // java.lang.Runnable
    public void run() throws Throwable {
        try {
            JSONObject jSONObjectA = com.xiaomi.onetrack.util.r.a((Map<String, Object>) this.f9443a, true);
            String strA = com.xiaomi.onetrack.util.k.a(com.xiaomi.onetrack.util.r.a(this.b.f));
            com.xiaomi.onetrack.util.k.a(com.xiaomi.onetrack.util.r.a(this.b.f), com.xiaomi.onetrack.util.r.a(jSONObjectA, !TextUtils.isEmpty(strA) ? new JSONObject(strA) : null).toString());
        } catch (Exception e) {
            com.xiaomi.onetrack.util.p.b(ijiami_1011.s.s.s.d(new byte[]{41, 91, 1, 102, 70, 88, 2, 15, 47, 15, 65}, "f5d249"), PPSLabelView.Code + e.toString());
        }
    }
}
