package com.kwad.components.ad.reward.l.b;

import android.content.Context;
import com.kwad.sdk.core.response.helper.e;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.ac;
import com.kwad.sdk.utils.au;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public final class a extends com.kwad.components.ad.reward.l.a {
    private c Cy = new c();
    private C0628a Cz = new C0628a();
    private final b CA = new b(com.kwad.components.ad.reward.a.b.hN());

    public static void a(a aVar, Context context, AdTemplate adTemplate) {
        if (au.ax(context, com.kwad.sdk.core.response.helper.a.aE(e.eO(adTemplate)))) {
            aVar.lj();
        } else {
            aVar.lk();
        }
    }

    public final void lg() {
        com.kwad.sdk.core.d.c.d("LaunchAppTask", "markWatchVideoCompleted");
        this.Cy.kY();
        li();
    }

    public final void lj() {
        com.kwad.sdk.core.d.c.d("LaunchAppTask", "markInstallCompleted");
        this.Cz.kY();
        li();
    }

    private void lk() {
        com.kwad.sdk.core.d.c.d("LaunchAppTask", "markInstallUncompleted");
        this.Cz.kZ();
        li();
    }

    public final void ll() {
        com.kwad.sdk.core.d.c.d("LaunchAppTask", "markUseAppCompleted");
        this.CA.kY();
        li();
    }

    public final boolean lm() {
        com.kwad.sdk.core.d.c.d("LaunchAppTask", "isInstallCompleted");
        return this.Cz.isCompleted();
    }

    public final boolean lh() {
        return this.Cy.isCompleted();
    }

    @Override // com.kwad.components.ad.reward.l.a
    public final int kX() {
        Iterator<com.kwad.components.ad.reward.l.c> it = kW().iterator();
        int i = 0;
        while (it.hasNext()) {
            if (!it.next().isCompleted()) {
                i++;
            }
        }
        return i;
    }

    @Override // com.kwad.components.ad.reward.l.a
    public final List<com.kwad.components.ad.reward.l.c> kW() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.Cy);
        arrayList.add(this.CA);
        return arrayList;
    }

    private void li() {
        if (this.Cy.isCompleted() && this.Cz.isCompleted() && this.CA.isCompleted()) {
            kY();
        } else {
            kZ();
        }
    }

    @Override // com.kwad.components.ad.reward.l.b, com.kwad.components.ad.reward.l.c
    public final boolean isCompleted() {
        return this.Cz.isCompleted() && this.CA.isCompleted();
    }

    @Override // com.kwad.components.ad.reward.l.b, com.kwad.sdk.core.b
    public final JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        ac.a(jSONObject, "mWatchVideoTask", this.Cy);
        ac.a(jSONObject, "mInstallAppTask", this.Cz);
        ac.a(jSONObject, "mUseAppTask", this.CA);
        return jSONObject;
    }

    @Override // com.kwad.components.ad.reward.l.b, com.kwad.sdk.core.b
    public final void parseJson(JSONObject jSONObject) {
        try {
            this.Cy.parseJson(jSONObject.optJSONObject("mWatchVideoTask"));
            this.CA.parseJson(jSONObject.optJSONObject("mUseAppTask"));
        } catch (Throwable unused) {
        }
    }

    static class c extends com.kwad.components.ad.reward.l.b {
        public c() {
            this.Cu = "基础奖励：观看视频";
            this.Cv = "基础奖励：需再观看%ss视频";
        }
    }

    /* JADX INFO: renamed from: com.kwad.components.ad.reward.l.b.a$a, reason: collision with other inner class name */
    static class C0628a extends com.kwad.components.ad.reward.l.b {
        public C0628a() {
            this.Cu = "安装应用";
        }
    }

    static class b extends com.kwad.components.ad.reward.l.b {
        public b(int i) {
            this.Cu = String.format("进阶奖励：安装并激活APP %ss", new StringBuilder().append(i).toString());
            this.Cv = String.format("进阶奖励：安装并激活APP %ss", new StringBuilder().append(i).toString());
        }
    }
}
