package com.kwad.components.ad.reward.l.a;

import com.kwad.sdk.core.config.e;
import com.kwad.sdk.core.d.c;
import com.kwad.sdk.utils.ac;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public final class a extends com.kwad.components.ad.reward.l.a {
    private b Cw = new b();
    private final C0627a Cx = new C0627a(e.JY());

    public final void lg() {
        c.d("LandPageOpenTask", "markWatchVideoCompleted");
        this.Cw.kY();
        li();
    }

    public final void markOpenNsCompleted() {
        c.d("LandPageOpenTask", "markOpenNsCompleted");
        this.Cx.kY();
        li();
    }

    public final boolean lh() {
        return this.Cw.isCompleted();
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
        arrayList.add(this.Cw);
        arrayList.add(this.Cx);
        return arrayList;
    }

    private void li() {
        if (this.Cx.isCompleted()) {
            kY();
        } else {
            kZ();
        }
    }

    @Override // com.kwad.components.ad.reward.l.b, com.kwad.components.ad.reward.l.c
    public final boolean isCompleted() {
        return this.Cx.isCompleted();
    }

    @Override // com.kwad.components.ad.reward.l.b, com.kwad.sdk.core.b
    public final JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        ac.a(jSONObject, "mWatchVideoTask", this.Cw);
        ac.a(jSONObject, "mOpenNsTask", this.Cx);
        return jSONObject;
    }

    @Override // com.kwad.components.ad.reward.l.b, com.kwad.sdk.core.b
    public final void parseJson(JSONObject jSONObject) {
        try {
            this.Cw.parseJson(jSONObject.optJSONObject("mWatchVideoTask"));
            this.Cx.parseJson(jSONObject.optJSONObject("mOpenNsTask"));
        } catch (Throwable unused) {
        }
    }

    static class b extends com.kwad.components.ad.reward.l.b {
        public b() {
            this.Cu = "基础奖励：观看视频";
            this.Cv = "基础奖励：需再观看%ss视频";
        }
    }

    /* JADX INFO: renamed from: com.kwad.components.ad.reward.l.a.a$a, reason: collision with other inner class name */
    static class C0627a extends com.kwad.components.ad.reward.l.b {
        public C0627a(int i) {
            this.Cu = String.format("进阶奖励：浏览详情页 %ss", new StringBuilder().append(i).toString());
            this.Cv = String.format("进阶奖励：浏览详情页 %ss", new StringBuilder().append(i).toString());
        }
    }
}
