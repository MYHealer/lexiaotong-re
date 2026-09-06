package com.kwad.components.ad.fullscreen.c.a;

import android.view.View;
import android.widget.ImageView;
import com.kwad.sdk.R;
import com.kwad.sdk.api.KsVideoPlayConfig;
import com.kwad.sdk.utils.bi;
import com.kwad.sdk.utils.j;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public final class c extends com.kwad.components.ad.reward.presenter.b implements View.OnClickListener {
    private ImageView kE;
    private j.a kF = new j.a() { // from class: com.kwad.components.ad.fullscreen.c.a.c.1
        @Override // com.kwad.sdk.utils.j.a
        public final void onAudioBeReleased() {
        }

        @Override // com.kwad.sdk.utils.j.a
        public final void onAudioBeOccupied() {
            if (c.this.kE == null || com.kwad.components.ad.reward.a.b.hO()) {
                return;
            }
            c.this.kE.post(new bi() { // from class: com.kwad.components.ad.fullscreen.c.a.c.1.1
                @Override // com.kwad.sdk.utils.bi
                public final void doTask() {
                    c.this.kE.setSelected(false);
                    c.this.uj.sz.setAudioEnabled(false, false);
                }
            });
        }
    };

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        ImageView imageView = (ImageView) findViewById(R.id.ksad_video_sound_switch);
        this.kE = imageView;
        imageView.setOnClickListener(this);
    }

    @Override // com.kwad.components.ad.reward.presenter.b, com.kwad.sdk.mvp.Presenter
    public final void ay() {
        super.ay();
        ds();
    }

    private void ds() {
        this.kE.setVisibility(0);
        KsVideoPlayConfig ksVideoPlayConfig = this.uj.mVideoPlayConfig;
        if (!this.uj.sx && com.kwad.components.core.t.a.aO(getContext()).wD()) {
            this.kE.setSelected(false);
            this.uj.e(false, false);
        } else if (ksVideoPlayConfig != null) {
            this.kE.setSelected(ksVideoPlayConfig.isVideoSoundEnable());
            this.uj.e(ksVideoPlayConfig.isVideoSoundEnable(), ksVideoPlayConfig.isVideoSoundEnable());
        } else {
            this.kE.setSelected(true);
            this.uj.e(true, true);
        }
        this.uj.sz.a(this.kF);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.uj.sz.b(this.kF);
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (view == this.kE) {
            this.uj.sz.setAudioEnabled(!this.kE.isSelected(), true);
            ImageView imageView = this.kE;
            imageView.setSelected(!imageView.isSelected());
        }
    }
}
