package com.kwad.components.core.offline.b.c;

import android.content.Context;
import com.kwad.components.core.video.DetailVideoView;
import com.kwad.components.offline.api.core.video.BaseKsMediaPlayerView;
import com.kwad.components.offline.api.core.video.IKsMediaPlayer;
import com.kwad.components.offline.api.core.video.IKsMediaPlayerView;
import com.kwad.components.offline.api.core.video.IVideo;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class e implements IVideo {
    @Override // com.kwad.components.offline.api.core.video.IVideo
    public final BaseKsMediaPlayerView createMediaPlayerView(Context context) {
        DetailVideoView detailVideoView = new DetailVideoView(context);
        detailVideoView.setAd(true);
        detailVideoView.setFillXY(true);
        detailVideoView.updateTextureViewGravity(17);
        detailVideoView.g(true, 1);
        return new b(context).b(detailVideoView);
    }

    @Override // com.kwad.components.offline.api.core.video.IVideo
    public final IKsMediaPlayer createMediaPlayer(IKsMediaPlayerView iKsMediaPlayerView) {
        if (!(iKsMediaPlayerView instanceof b)) {
            throw new IllegalArgumentException("playerView not instanceof KsMediaPlayerView");
        }
        return new a().a(new com.kwad.components.core.video.b(((b) iKsMediaPlayerView).tI()));
    }
}
