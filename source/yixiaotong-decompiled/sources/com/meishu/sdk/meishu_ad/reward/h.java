package com.meishu.sdk.meishu_ad.reward;

import android.media.MediaPlayer;
import com.meishu.sdk.meishu_ad.n0;
import java.util.Iterator;

/* JADX INFO: compiled from: FullScreenMediaView.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class h extends com.meishu.sdk.core.safe.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ FullScreenMediaView f5073a;

    public h(FullScreenMediaView fullScreenMediaView) {
        this.f5073a = fullScreenMediaView;
    }

    @Override // com.meishu.sdk.core.safe.e
    public void a(MediaPlayer mediaPlayer) {
        n0.b bVar;
        FullScreenMediaView fullScreenMediaView = this.f5073a;
        fullScreenMediaView.p = false;
        fullScreenMediaView.c.setVisibility(8);
        fullScreenMediaView.d();
        if (fullScreenMediaView.f <= 0 && (bVar = fullScreenMediaView.e) != null) {
            bVar.onKeepTimeFinished();
        }
        Iterator<n0.a> it = fullScreenMediaView.q.iterator();
        while (it.hasNext()) {
            it.next().onCompleted();
        }
        com.meishu.sdk.meishu_ad.nativ.e eVar = fullScreenMediaView.g;
        if (eVar != null) {
            eVar.onVideoComplete();
        }
    }
}
