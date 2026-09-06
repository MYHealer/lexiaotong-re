package com.kwad.components.core.page.widget.b;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.huawei.openalliance.ad.constant.ba;
import com.kwad.components.core.page.AdWebViewActivityProxy;
import com.kwad.components.core.page.f;
import com.kwad.components.core.proxy.j;
import com.kwad.components.offline.api.core.adInnerEc.ExternalExitListener;
import com.kwad.sdk.R;
import com.kwad.sdk.core.d.c;
import com.kwad.sdk.widget.KSFrameLayout;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class a extends j {
    private ExternalExitListener adD;
    private View aid;
    private String aie;
    private KSFrameLayout aif;

    public final void setExternalExitListener(ExternalExitListener externalExitListener) {
        this.adD = externalExitListener;
    }

    public static a be(String str) {
        a aVar = new a();
        aVar.aie = str;
        Bundle bundle = new Bundle();
        bundle.putString(ba.Z, str);
        aVar.setArguments(bundle);
        return aVar;
    }

    @Override // android.app.DialogFragment, android.app.Fragment
    public final void onDestroyView() {
        try {
            super.onDestroyView();
        } catch (Throwable th) {
            c.e("KwaiYodaWebViewFragment", "destroy view failed:" + th);
        }
        KSFrameLayout kSFrameLayout = this.aif;
        if (kSFrameLayout != null && (kSFrameLayout.getParent() instanceof ViewGroup)) {
            ((ViewGroup) this.aif.getParent()).removeView(this.aif);
            this.aif = null;
        }
        this.adD = null;
    }

    @Override // com.kwad.components.core.proxy.j
    public final View a(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        if (this.aif == null) {
            this.aif = (KSFrameLayout) layoutInflater.inflate(R.layout.ksad_yoda_web_container, viewGroup, false);
        }
        this.aie = getArguments().getString(ba.Z);
        if (getContext() != null) {
            AdWebViewActivityProxy.a aVarUa = new AdWebViewActivityProxy.a.C0680a().aY("").aZ(this.aie).ua();
            f fVar = new f(getContext());
            fVar.c(getContext(), aVarUa);
            fVar.setExternalExitListener(this.adD);
            fVar.b(getActivity());
            this.aid = fVar;
            this.aif.addView(fVar);
        }
        return this.aif;
    }
}
