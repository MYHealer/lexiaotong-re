package com.kwad.components.ad.reward;

import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import com.kwad.components.core.webview.jshandler.y;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public final class d extends com.kwad.components.ad.l.b {
    private List<AdTemplate> sq;
    private boolean sr;
    private List<com.kwad.components.core.e.d.d> ss;
    private y.b st;

    @Override // com.kwad.components.ad.l.b
    public final boolean gF() {
        return false;
    }

    @Override // com.kwad.components.ad.l.b
    public final String getName() {
        return "MiddlePlayEndCard";
    }

    public final void setShowLandingPage(boolean z) {
        this.sr = z;
    }

    public d(List<AdTemplate> list, JSONObject jSONObject, y.b bVar) {
        super(jSONObject, null);
        this.sr = false;
        this.ss = new ArrayList();
        this.sq = list;
        this.st = bVar;
        if (list == null || list.size() <= 0) {
            return;
        }
        Iterator<AdTemplate> it = this.sq.iterator();
        while (it.hasNext()) {
            this.ss.add(new com.kwad.components.core.e.d.d(it.next()));
        }
    }

    @Override // com.kwad.components.ad.l.b
    public final void a(FrameLayout frameLayout, AdBaseFrameLayout adBaseFrameLayout, AdTemplate adTemplate, com.kwad.components.core.e.d.d dVar, int i) {
        super.a(frameLayout, adBaseFrameLayout, this.sq, this.ss);
    }

    @Override // com.kwad.components.ad.l.b
    public final void gE() {
        super.gE();
        this.ff.setOnTouchListener(new View.OnTouchListener() { // from class: com.kwad.components.ad.reward.d.1
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return motionEvent.getAction() == 2;
            }
        });
    }

    public final void gG() {
        if (this.fk != null) {
            this.fk.yy();
        }
    }

    @Override // com.kwad.components.ad.l.b
    public final String O(AdTemplate adTemplate) {
        List<AdTemplate> list = this.sq;
        if (list == null || list.size() < 2) {
            return super.O(adTemplate);
        }
        return com.kwad.sdk.core.response.helper.b.cZ(this.sq.get(1));
    }

    @Override // com.kwad.components.ad.l.b
    public final void b(com.kwad.sdk.core.webview.b bVar) {
        bVar.setAdTemplateList(this.sq);
    }

    @Override // com.kwad.components.ad.l.b
    public final void a(com.kwad.components.core.webview.a aVar) {
        super.a(aVar);
        List<AdTemplate> list = this.sq;
        y yVar = new y(new ArrayList(list.subList(1, list.size() - 1)));
        yVar.a(this.st);
        aVar.a(yVar);
    }

    @Override // com.kwad.components.ad.l.b
    public final void gH() {
        com.kwad.components.ad.reward.monitor.d.a(this.mAdTemplate, true, "middle_play_end_card");
    }

    @Override // com.kwad.components.ad.l.b
    public final void gI() {
        com.kwad.components.ad.reward.monitor.d.a(this.mAdTemplate, true, "middle_play_end_card", O(this.mAdTemplate));
    }

    @Override // com.kwad.components.ad.l.b
    public final void gJ() {
        com.kwad.components.ad.reward.monitor.d.a(this.mAdTemplate, true, "middle_play_end_card", O(this.mAdTemplate), System.currentTimeMillis() - getLoadTime());
    }

    @Override // com.kwad.components.ad.l.b
    public final boolean cN() {
        if (this.sr) {
            return this.NR;
        }
        return super.cN();
    }
}
