package com.kwad.components.ad.splashscreen.e;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.TextView;
import com.kwad.components.ad.splashscreen.e;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.helper.SlideConvertHelper;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.widget.h;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public final class b implements com.kwad.sdk.widget.d {
    private a HV;
    private ViewStub KS;
    private ViewGroup KT;
    private View KU;
    private TextView KV;
    private boolean KW;
    private e KX;
    private h KY;
    private AdInfo mAdInfo;
    private AdTemplate mAdTemplate;
    private com.kwad.components.core.e.d.d mApkDownloadHelper;
    private ViewGroup mRootContainer;

    public final void a(e eVar) {
        this.KX = eVar;
    }

    public b(ViewGroup viewGroup, ViewStub viewStub, boolean z, com.kwad.components.core.e.d.d dVar) {
        this.mRootContainer = viewGroup;
        this.KS = viewStub;
        this.mApkDownloadHelper = dVar;
        this.KW = z;
    }

    public final void ng() {
        com.kwad.sdk.core.d.c.d("SplashActionBarNativeHelper", "rollBackToNative mRootViewStub: " + this.KS);
        if (this.KT == null) {
            ViewStub viewStub = this.KS;
            if (viewStub != null && viewStub.getParent() != null) {
                this.KT = (ViewGroup) this.KS.inflate();
            } else {
                this.KT = (ViewGroup) this.mRootContainer.findViewById(R.id.ksad_splash_actionbar_native_root);
            }
            i(this.KT);
        }
        ViewGroup viewGroup = this.KT;
        if (viewGroup != null) {
            viewGroup.setVisibility(0);
        }
    }

    private void i(ViewGroup viewGroup) {
        if (viewGroup == null) {
            return;
        }
        this.KU = viewGroup.findViewById(R.id.ksad_splash_actionbar_native);
        this.KV = (TextView) viewGroup.findViewById(R.id.ksad_splash_actionbar_text);
        this.KY = new h(this.KU.getContext(), this.KU, this);
        a(com.kwad.components.ad.splashscreen.d.a(this.mAdTemplate, this.mAdInfo, this.mApkDownloadHelper, 4));
    }

    private void a(com.kwad.components.ad.splashscreen.d dVar) {
        if (dVar == null) {
            return;
        }
        af(dVar.lW());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void af(String str) {
        TextView textView = this.KV;
        if (textView == null || str == null) {
            return;
        }
        textView.setText(str);
    }

    private void j(boolean z, boolean z2) {
        e eVar = this.KX;
        if (eVar != null) {
            eVar.i(z, z2);
        }
    }

    @Override // com.kwad.sdk.widget.d
    public final void a(View view) {
        j(true, view.equals(this.KU));
    }

    @Override // com.kwad.sdk.widget.d
    public final void a(View view, float f, float f2, float f3, float f4) {
        if (SlideConvertHelper.a(this.mAdTemplate, f, f2, f3, f4)) {
            j(false, view.equals(this.KU));
        }
    }

    public final void az(AdTemplate adTemplate) {
        a aVar;
        this.mAdTemplate = adTemplate;
        a aVar2 = this.HV;
        if (aVar2 == null) {
            this.HV = new a(this.mRootContainer.getContext(), this.mAdTemplate) { // from class: com.kwad.components.ad.splashscreen.e.b.1
                {
                    super(adTemplate);
                }

                @Override // com.kwad.components.ad.splashscreen.e.a
                protected final void k(int i, String str) {
                    b.this.af(str);
                }
            };
        } else {
            aVar2.setAdTemplate(adTemplate);
        }
        if (adTemplate != null) {
            this.mAdInfo = com.kwad.sdk.core.response.helper.e.eO(adTemplate);
        }
        com.kwad.components.core.e.d.d dVar = this.mApkDownloadHelper;
        if (dVar == null || (aVar = this.HV) == null) {
            return;
        }
        dVar.b(aVar);
    }

    public final void onUnbind() {
        a aVar;
        com.kwad.components.core.e.d.d dVar = this.mApkDownloadHelper;
        if (dVar == null || (aVar = this.HV) == null) {
            return;
        }
        dVar.c(aVar);
    }
}
