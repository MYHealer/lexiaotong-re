package com.meishu.sdk.meishu_ad.reward;

import android.media.MediaPlayer;
import com.huawei.openalliance.ad.views.PPSLabelView;
import com.meishu.sdk.core.utils.LogUtil;

/* JADX INFO: compiled from: FullScreenMediaView.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class f extends com.meishu.sdk.core.safe.f {
    public f(FullScreenMediaView fullScreenMediaView) {
    }

    @Override // com.meishu.sdk.core.safe.f
    public boolean a(MediaPlayer mediaPlayer, int i, int i2) {
        LogUtil.e("FullScreenMediaView", "MediaPlayer onError: " + i + PPSLabelView.Code + i2);
        return false;
    }
}
