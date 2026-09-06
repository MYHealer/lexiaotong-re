package com.kwad.components.ad.splashscreen.presenter;

import android.view.View;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.helper.SlideConvertHelper;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public final class a extends e implements com.kwad.sdk.widget.d {
    private View Hr;
    private boolean Hs;

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.Hr = findViewById(R.id.ksad_splash_actionbar_full_screen);
    }

    @Override // com.kwad.components.ad.splashscreen.presenter.e, com.kwad.sdk.mvp.Presenter
    public final void ay() {
        super.ay();
        if (this.HC == null) {
            return;
        }
        this.Hs = com.kwad.sdk.core.response.helper.d.eD(this.HC.mAdTemplate);
        boolean zO = com.kwad.components.ad.splashscreen.h.o(com.kwad.sdk.core.response.helper.e.eO(this.HC.mAdTemplate));
        this.Hr.setVisibility(zO ? 0 : 8);
        if (zO) {
            new com.kwad.sdk.widget.h(this.Hr.getContext(), this.Hr, this);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
    }

    @Override // com.kwad.sdk.widget.d
    public final void a(View view) {
        this.HC.c(1, view.getContext(), 53, 3);
    }

    @Override // com.kwad.sdk.widget.d
    public final void a(View view, float f, float f2, float f3, float f4) {
        com.kwad.sdk.core.d.c.d("FullScreenTouchConvertPresenter", "onSlide: enableSlickClick: " + this.Hs);
        if (SlideConvertHelper.a(this.HC.mAdTemplate, f, f2, f3, f4)) {
            this.HC.c(1, view.getContext(), 153, 1);
        }
    }
}
