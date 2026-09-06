package com.kwad.components.ad.feed.widget;

import android.content.Context;
import android.view.View;
import com.kwad.sdk.R;
import com.kwad.sdk.utils.al;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public final class i extends c {
    private final com.kwad.components.core.video.a.InterfaceC0691a iq;

    @Override // com.kwad.components.ad.feed.widget.c
    protected final int getDefaultClickArea() {
        return 3;
    }

    @Override // com.kwad.components.ad.feed.widget.c
    protected final com.kwad.components.core.video.a.InterfaceC0691a getVideoAdClickListener() {
        return this.iq;
    }

    public i(Context context) {
        super(context);
        this.iq = new com.kwad.components.core.video.a.InterfaceC0691a() { // from class: com.kwad.components.ad.feed.widget.i.1
            @Override // com.kwad.components.core.video.a.InterfaceC0691a
            public final void a(int i, al.a aVar) {
                int i2;
                int i3 = 3;
                boolean z = false;
                if (i == 1) {
                    i2 = 15;
                } else if (i == 2) {
                    i2 = 16;
                } else if (i != 3) {
                    i2 = 35;
                } else {
                    i2 = 39;
                    i3 = 1;
                    z = true;
                }
                i.this.cp();
                com.kwad.components.core.e.d.a.a(new com.kwad.components.core.e.d.a.C0661a(i.this.getContext()).aJ(i.this.mAdTemplate).b(i.this.mApkDownloadHelper).aN(i3).as(z).au(true).aL(5).aM(i2).d(aVar).aw(true).a(new com.kwad.components.core.e.d.a.b() { // from class: com.kwad.components.ad.feed.widget.i.1.1
                    @Override // com.kwad.components.core.e.d.a.b
                    public final void onAdClicked() {
                        i.this.zN();
                    }
                }));
            }
        };
        setRadiusDp(12);
    }

    @Override // com.kwad.components.ad.feed.widget.c, com.kwad.components.core.widget.b
    public final void bC() {
        super.bC();
        View viewFindViewById = findViewById(R.id.ksad_feed_novel_video);
        if (viewFindViewById != null) {
            viewFindViewById.setClipToOutline(true);
        }
    }

    @Override // com.kwad.components.core.widget.b
    public final int getLayoutId() {
        return R.layout.ksad_feed_novel_regular_video;
    }

    @Override // com.kwad.components.core.widget.b
    public final void setMargin(int i) {
        if (com.kwad.sdk.core.config.e.KD()) {
            return;
        }
        setBackgroundColor(-1);
    }

    @Override // com.kwad.components.ad.feed.widget.c
    protected final void cx() {
        this.ij.setRatio(1.7857143f);
    }
}
