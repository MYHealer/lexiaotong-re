package com.kwad.components.ad.reward.widget.tailframe;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.kwad.components.ad.reward.g;
import com.kwad.sdk.R;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.helper.e;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.widget.KSFrameLayout;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class TailFrameView extends KSFrameLayout {
    private com.kwad.components.ad.reward.widget.tailframe.a Gg;
    private g uj;

    public void setCallerContext(g gVar) {
        this.uj = gVar;
    }

    public TailFrameView(Context context) {
        super(context);
    }

    public TailFrameView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public TailFrameView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public TailFrameView(Context context, View view) {
        super(context, view);
    }

    public final void a(com.kwad.components.ad.reward.widget.tailframe.b bVar) {
        this.Gg.setCallerContext(this.uj);
        this.Gg.a(this.uj.mAdTemplate, this.uj.mReportExtData, bVar);
    }

    public final void a(Context context, boolean z, boolean z2) {
        g(z, z2);
        this.Gg.B(context);
        this.Gg.g(z, z2);
        addView(this.Gg.lO(), -1, -1);
    }

    public final void lw() {
        this.Gg.lw();
    }

    public final void destroy() {
        com.kwad.components.ad.reward.widget.tailframe.a aVar = this.Gg;
        if (aVar != null) {
            aVar.destroy();
        }
    }

    private void g(boolean z, boolean z2) {
        if (this.Gg != null) {
            return;
        }
        if (z) {
            if (z2) {
                this.Gg = new d();
                return;
            } else {
                this.Gg = new c();
                return;
            }
        }
        if (z2) {
            this.Gg = new b();
        } else {
            this.Gg = new a();
        }
    }

    static class d extends com.kwad.components.ad.reward.widget.tailframe.a {
        public d() {
            super(R.layout.ksad_video_tf_view_portrait_vertical);
        }

        @Override // com.kwad.components.ad.reward.widget.tailframe.a
        public final void a(AdTemplate adTemplate, JSONObject jSONObject, com.kwad.components.ad.reward.widget.tailframe.b bVar) {
            super.a(adTemplate, jSONObject, bVar);
            if (e.S(this.mAdTemplate)) {
                this.FW.setBackground(null);
                this.FX.setVisibility(8);
                this.mLogoView.setVisibility(8);
            }
            KSImageLoader.loadImage(this.FX, com.kwad.sdk.core.response.helper.a.aa(this.mAdInfo), this.mAdTemplate);
        }
    }

    static class c extends com.kwad.components.ad.reward.widget.tailframe.a implements com.kwad.sdk.widget.d {
        private View Gk;

        public c() {
            super(R.layout.ksad_video_tf_view_portrait_horizontal);
        }

        @Override // com.kwad.components.ad.reward.widget.tailframe.a
        public final void B(Context context) {
            super.B(context);
            this.Gk = this.FW.findViewById(R.id.video_cover);
        }

        @Override // com.kwad.components.ad.reward.widget.tailframe.a
        public final void a(AdTemplate adTemplate, JSONObject jSONObject, com.kwad.components.ad.reward.widget.tailframe.b bVar) {
            super.a(adTemplate, jSONObject, bVar);
            if (e.S(this.mAdTemplate)) {
                this.Gk.setVisibility(8);
                this.mLogoView.setVisibility(8);
                this.FW.setBackground(null);
            }
            lS();
        }

        private void lS() {
            AdInfo.AdMaterialInfo.MaterialFeature materialFeatureBd = com.kwad.sdk.core.response.helper.a.bd(this.mAdInfo);
            int i = materialFeatureBd.width;
            int i2 = materialFeatureBd.height;
            int screenWidth = com.kwad.sdk.c.a.a.getScreenWidth(this.FW.getContext());
            int i3 = (int) (screenWidth * (i2 / i));
            ViewGroup.LayoutParams layoutParams = this.FX.getLayoutParams();
            layoutParams.width = screenWidth;
            layoutParams.height = i3;
            KSImageLoader.loadImage(this.FX, materialFeatureBd.coverUrl, this.mAdTemplate);
        }
    }

    static class b extends com.kwad.components.ad.reward.widget.tailframe.a implements com.kwad.sdk.widget.d {
        private ImageView Gh;
        private ImageView Gi;
        private ImageView Gj;

        public b() {
            super(R.layout.ksad_video_tf_view_landscape_vertical);
        }

        @Override // com.kwad.components.ad.reward.widget.tailframe.a
        public final void B(Context context) {
            super.B(context);
            this.Gh = (ImageView) this.FW.findViewById(R.id.ksad_video_thumb_left);
            this.Gi = (ImageView) this.FW.findViewById(R.id.ksad_video_thumb_mid);
            this.Gj = (ImageView) this.FW.findViewById(R.id.ksad_video_thumb_right);
        }

        @Override // com.kwad.components.ad.reward.widget.tailframe.a
        public final void a(AdTemplate adTemplate, JSONObject jSONObject, com.kwad.components.ad.reward.widget.tailframe.b bVar) {
            super.a(adTemplate, jSONObject, bVar);
            lS();
        }

        private void lS() {
            KSImageLoader.loadImage(this.Gh, com.kwad.sdk.core.response.helper.a.aa(this.mAdInfo), this.mAdTemplate);
            KSImageLoader.loadImage(this.Gi, com.kwad.sdk.core.response.helper.a.aa(this.mAdInfo), this.mAdTemplate);
            KSImageLoader.loadImage(this.Gj, com.kwad.sdk.core.response.helper.a.aa(this.mAdInfo), this.mAdTemplate);
        }
    }

    static class a extends com.kwad.components.ad.reward.widget.tailframe.a implements com.kwad.sdk.widget.d {
        public a() {
            super(R.layout.ksad_video_tf_view_landscape_horizontal);
        }

        @Override // com.kwad.components.ad.reward.widget.tailframe.a
        public final void a(AdTemplate adTemplate, JSONObject jSONObject, com.kwad.components.ad.reward.widget.tailframe.b bVar) {
            super.a(adTemplate, jSONObject, bVar);
            KSImageLoader.loadImage(this.FX, com.kwad.sdk.core.response.helper.a.aa(this.mAdInfo), this.mAdTemplate);
        }
    }
}
