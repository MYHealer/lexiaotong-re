package com.meishu.sdk.meishu_ad.nativ;

import android.media.MediaPlayer;
import com.huawei.openalliance.ad.views.PPSLabelView;
import com.meishu.sdk.core.utils.LogUtil;

/* JADX INFO: compiled from: NormalMediaView.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class n extends com.meishu.sdk.core.safe.f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ NormalMediaView f5056a;

    public n(NormalMediaView normalMediaView) {
        this.f5056a = normalMediaView;
    }

    @Override // com.meishu.sdk.core.safe.f
    public boolean a(MediaPlayer mediaPlayer, int i, int i2) {
        LogUtil.e(this.f5056a.f5040a, "MediaPlayer onError" + i + PPSLabelView.Code + i2);
        e eVar = this.f5056a.C;
        if (eVar != null) {
            eVar.onVideoError();
        }
        a aVar = this.f5056a.E;
        if (aVar != null) {
            aVar.onAdRenderFail("MediaPlayer onError", i);
        }
        this.f5056a.d();
        return true;
    }
}
