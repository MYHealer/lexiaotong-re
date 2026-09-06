package com.meishu.sdk.meishu_ad.nativ;

import android.media.MediaPlayer;
import com.huawei.openalliance.ad.views.PPSLabelView;
import com.meishu.sdk.R;
import com.meishu.sdk.core.ad.recycler.RecylcerAdInteractionListener;
import com.meishu.sdk.core.utils.LogUtil;
import com.meishu.sdk.core.utils.h0;
import com.meishu.sdk.meishu_ad.v;

/* JADX INFO: compiled from: NormalMediaView.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class o extends com.meishu.sdk.core.safe.h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ NormalMediaView f5057a;

    /* JADX INFO: compiled from: NormalMediaView.java */
    public class a extends com.meishu.sdk.core.safe.l {
        public a() {
        }

        @Override // com.meishu.sdk.core.safe.l
        public void safeRun() {
            com.meishu.sdk.meishu_ad.nativ.a aVar;
            NormalMediaView normalMediaView = o.this.f5057a;
            if (!normalMediaView.F && (aVar = normalMediaView.E) != null) {
                aVar.onADExposure();
            }
            RecylcerAdInteractionListener recylcerAdInteractionListener = o.this.f5057a.P;
            if (recylcerAdInteractionListener != null) {
                recylcerAdInteractionListener.onAdExposure();
            }
        }
    }

    public o(NormalMediaView normalMediaView) {
        this.f5057a = normalMediaView;
    }

    @Override // com.meishu.sdk.core.safe.h
    public void a(MediaPlayer mediaPlayer) {
        LogUtil.d(this.f5057a.f5040a, com.meishu.sdk.activity.a.a("MediaPlayer.onPrepared ").append(this.f5057a.s).append(PPSLabelView.Code).append(this.f5057a.hashCode()).toString());
        this.f5057a.s = true;
        NormalMediaView normalMediaView = this.f5057a;
        if (!normalMediaView.r && normalMediaView.n) {
            normalMediaView.r = true;
            this.f5057a.b.post(new a());
        }
        mediaPlayer.setVideoScalingMode(2);
        NormalMediaView normalMediaView2 = this.f5057a;
        if (normalMediaView2.p == 1) {
            mediaPlayer.start();
            this.f5057a.i();
            NormalMediaView normalMediaView3 = this.f5057a;
            if (normalMediaView3.C != null && !normalMediaView3.U) {
                normalMediaView3.U = true;
                this.f5057a.C.onVideoStart();
            }
        } else {
            try {
                normalMediaView2.a(normalMediaView2.d, 0);
                normalMediaView2.a(normalMediaView2.e, normalMediaView2.b.getDuration());
                normalMediaView2.f.setProgress(0);
                if (normalMediaView2.L.hasMessages(1)) {
                    normalMediaView2.L.removeMessages(1);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        this.f5057a.c.b(R.id.ms_progress_loading).d(8);
        NormalMediaView.d dVar = this.f5057a.a0;
        if (dVar != null) {
            v.f.a aVar = (v.f.a) dVar;
            v.this.p = System.currentTimeMillis();
            f fVar = v.f.this.b;
            fVar.setMonitorUrl(h0.b(fVar.getMonitorUrl(), v.this.a()));
            v.f.this.d.b(true);
        }
        e eVar = this.f5057a.C;
        if (eVar != null) {
            eVar.onVideoLoaded();
        }
        this.f5057a.c();
    }
}
