package com.yfanads.android.adx.core.impl;

import com.yfanads.android.adx.api.AdVideoPlayConfig;
import java.io.Serializable;

/* JADX INFO: compiled from: AdVideoPlayCofImpl.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public final class a implements AdVideoPlayConfig, Serializable {
    private static final long serialVersionUID = -154151744722615769L;
    private int videoAutoPlayType;
    private boolean videoSoundEnable;
    private int videoSoundValue = 0;

    @Override // com.yfanads.android.adx.api.AdVideoPlayConfig
    public final int getVideoAutoPlayType() {
        return this.videoAutoPlayType;
    }

    @Override // com.yfanads.android.adx.api.AdVideoPlayConfig
    public final boolean isVideoSoundEnable() {
        return this.videoSoundEnable;
    }

    @Override // com.yfanads.android.adx.api.AdVideoPlayConfig
    public final void setDataFlowAutoStart(boolean z) {
        this.videoAutoPlayType = 0;
    }

    @Override // com.yfanads.android.adx.api.AdVideoPlayConfig
    public final void setVideoAutoPlayType(int i) {
        this.videoAutoPlayType = i;
    }

    @Override // com.yfanads.android.adx.api.AdVideoPlayConfig
    public final void setVideoSoundEnable(boolean z) {
        this.videoSoundEnable = z;
        this.videoSoundValue = 1;
    }
}
