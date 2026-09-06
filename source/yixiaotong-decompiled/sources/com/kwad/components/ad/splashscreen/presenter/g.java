package com.kwad.components.ad.splashscreen.presenter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.utils.bi;
import com.kwad.sdk.utils.by;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public final class g extends e {
    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
    }

    @Override // com.kwad.components.ad.splashscreen.presenter.e, com.kwad.sdk.mvp.Presenter
    public final void ay() {
        super.ay();
        mE();
    }

    private void mE() {
        by.postOnUiThread(new bi() { // from class: com.kwad.components.ad.splashscreen.presenter.g.1
            @Override // com.kwad.sdk.utils.bi
            public final void doTask() {
                if (g.this.getActivity() != null) {
                    try {
                        ViewGroup viewGroup = (ViewGroup) g.this.getActivity().getWindow().getDecorView();
                        if (com.kwad.sdk.c.a.a.J(viewGroup) && com.kwad.sdk.c.a.a.bA(g.this.getActivity()) == viewGroup.getHeight()) {
                            g.this.mF();
                        }
                    } catch (Throwable unused) {
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mF() {
        int i;
        if (getContext() == null) {
            return;
        }
        AdInfo adInfoEO = com.kwad.sdk.core.response.helper.e.eO(this.HC.mAdTemplate);
        if (com.kwad.components.ad.splashscreen.e.c.A(adInfoEO)) {
            i = R.id.ksad_preload_right_container;
        } else {
            i = R.id.ksad_preload_left_container;
        }
        j(findViewById(i), y(adInfoEO));
        if (com.kwad.components.ad.splashscreen.e.c.A(adInfoEO)) {
            j(findViewById(R.id.ksad_splash_logo_container), com.kwad.sdk.c.a.a.getStatusBarHeight(getActivity()) + com.kwad.sdk.c.a.a.a(getContext(), 12.0f));
            j(findViewById(R.id.ksad_splash_sound), com.kwad.sdk.c.a.a.getStatusBarHeight(getActivity()) + com.kwad.sdk.c.a.a.a(getContext(), 32.0f));
            j(findViewById(R.id.ksad_skip_view_area), com.kwad.sdk.c.a.a.getStatusBarHeight(getActivity()));
        }
    }

    private int y(AdInfo adInfo) {
        int iA;
        int statusBarHeight;
        if (com.kwad.components.ad.splashscreen.e.c.A(adInfo)) {
            iA = com.kwad.sdk.c.a.a.a(getActivity(), 32.0f);
            statusBarHeight = com.kwad.sdk.c.a.a.getStatusBarHeight(getActivity());
        } else {
            iA = com.kwad.sdk.c.a.a.a(getActivity(), 16.0f);
            statusBarHeight = com.kwad.sdk.c.a.a.getStatusBarHeight(getActivity());
        }
        return iA + statusBarHeight;
    }

    private static void j(View view, int i) {
        if (view.getLayoutParams() instanceof FrameLayout.LayoutParams) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
            layoutParams.topMargin = i;
            view.setLayoutParams(layoutParams);
        } else if (view.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) view.getLayoutParams();
            layoutParams2.topMargin = i;
            view.setLayoutParams(layoutParams2);
        }
    }
}
