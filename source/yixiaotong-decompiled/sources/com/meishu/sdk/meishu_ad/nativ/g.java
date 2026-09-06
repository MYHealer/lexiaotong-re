package com.meishu.sdk.meishu_ad.nativ;

import android.media.MediaPlayer;
import com.meishu.sdk.R;
import com.meishu.sdk.core.utils.LogUtil;

/* JADX INFO: compiled from: NormalMediaView.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class g extends com.meishu.sdk.core.safe.g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ NormalMediaView f5049a;

    public g(NormalMediaView normalMediaView) {
        this.f5049a = normalMediaView;
    }

    @Override // com.meishu.sdk.core.safe.g
    public boolean safeOnInfo(MediaPlayer mediaPlayer, int i, int i2) {
        NormalMediaView normalMediaView = this.f5049a;
        if (!normalMediaView.b.g) {
            return true;
        }
        if (i == 701) {
            normalMediaView.c.b(R.id.ms_progress_loading).d(0);
            LogUtil.d(this.f5049a.f5040a, "MediaPlayer.MEDIA_INFO_BUFFERING_START");
        } else if (i == 702) {
            normalMediaView.c.b(R.id.ms_progress_loading).d(8);
            LogUtil.d(this.f5049a.f5040a, "MediaPlayer.MEDIA_INFO_BUFFERING_END");
        }
        MediaPlayer.OnInfoListener onInfoListener = this.f5049a.D;
        if (onInfoListener != null) {
            onInfoListener.onInfo(mediaPlayer, i, i2);
        }
        return true;
    }
}
