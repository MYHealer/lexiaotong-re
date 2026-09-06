package com.kwad.components.ad.interstitial.aggregate;

import android.view.View;
import android.view.ViewGroup;
import androidx.viewpager.widget.PagerAdapter;
import com.kwad.components.ad.interstitial.d;
import com.kwad.sdk.api.KsAdVideoPlayConfig;
import com.kwad.sdk.api.KsInterstitialAd;
import com.kwad.sdk.core.response.helper.e;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public final class a extends PagerAdapter {
    private final KsAdVideoPlayConfig ce;
    private b lA;
    private InterfaceC0606a lB;
    private boolean lC;
    private final KsInterstitialAd.AdInteractionListener ls;
    private final d lx;
    private final boolean ly;
    private boolean lz;
    private AdResultData mAdResultData;
    private final List<AdTemplate> mAdTemplateList;

    /* JADX INFO: renamed from: com.kwad.components.ad.interstitial.aggregate.a$a, reason: collision with other inner class name */
    public interface InterfaceC0606a {
        void dG();
    }

    public interface b {
        void a(com.kwad.components.ad.interstitial.h.c cVar, int i);
    }

    public final void a(InterfaceC0606a interfaceC0606a) {
        this.lB = interfaceC0606a;
    }

    public final void a(b bVar) {
        this.lA = bVar;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public final boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }

    public a(AdResultData adResultData, d dVar, KsAdVideoPlayConfig ksAdVideoPlayConfig, KsInterstitialAd.AdInteractionListener adInteractionListener) {
        this.mAdTemplateList = new ArrayList();
        this.mAdResultData = adResultData;
        this.lx = dVar;
        this.ce = ksAdVideoPlayConfig;
        this.ls = adInteractionListener;
        this.ly = com.kwad.sdk.core.response.helper.a.cH(e.eO(com.kwad.sdk.core.response.helper.c.r(adResultData))) == 1;
    }

    public a(AdResultData adResultData, d dVar, KsAdVideoPlayConfig ksAdVideoPlayConfig, KsInterstitialAd.AdInteractionListener adInteractionListener, boolean z) {
        this.mAdTemplateList = new ArrayList();
        this.lz = true;
        this.mAdResultData = adResultData;
        this.lC = z;
        this.lx = dVar;
        this.ce = ksAdVideoPlayConfig;
        this.ls = adInteractionListener;
        this.ly = com.kwad.sdk.core.response.helper.a.cH(e.eO(com.kwad.sdk.core.response.helper.c.r(adResultData))) == 1;
    }

    public final void d(List<AdTemplate> list) {
        if (list == null || list.size() <= 0) {
            return;
        }
        this.mAdTemplateList.clear();
        this.mAdTemplateList.addAll(list);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public final int getCount() {
        return this.mAdTemplateList.size();
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public final Object instantiateItem(ViewGroup viewGroup, final int i) {
        com.kwad.components.ad.interstitial.h.c cVar = new com.kwad.components.ad.interstitial.h.c(viewGroup.getContext());
        viewGroup.addView(cVar);
        cVar.setAggregateAdView(i > 0);
        cVar.setAdAggregateClickActionListener(new com.kwad.components.ad.interstitial.f.c.a() { // from class: com.kwad.components.ad.interstitial.aggregate.a.1
            @Override // com.kwad.components.ad.interstitial.f.c.a
            public final void a(long j, long j2, boolean z) {
                AdTemplate adTemplate = (AdTemplate) a.this.mAdTemplateList.get(i);
                if (adTemplate == null) {
                    return;
                }
                if (i == 0 && z) {
                    com.kwad.components.ad.interstitial.report.a.eV().b(adTemplate, j, j2);
                }
                if (a.this.lB != null) {
                    a.this.lB.dG();
                }
            }
        });
        if (i > 0) {
            cVar.setAggregateShowTriggerType(8);
        }
        if (this.lz) {
            cVar.a(this.mAdResultData, this.lx, this.ce, this.ls, i, this.lC);
        } else {
            cVar.a(this.mAdResultData, this.lx, this.ce, this.ls, i);
        }
        b bVar = this.lA;
        if (bVar != null) {
            bVar.a(cVar, i);
        }
        return cVar;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public final void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        if (obj instanceof View) {
            viewGroup.removeView((View) obj);
        }
    }
}
