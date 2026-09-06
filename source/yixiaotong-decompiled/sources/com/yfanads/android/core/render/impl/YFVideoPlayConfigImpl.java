package com.yfanads.android.core.render.impl;

import com.yfanads.android.core.render.api.YFAdVideoPlayConfig;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public class YFVideoPlayConfigImpl implements YFAdVideoPlayConfig {
    private boolean isAutoStart;
    private boolean isDataFlowAutoStart;
    private boolean isNoCache;
    private boolean isVideoSoundEnable;
    private int playType;

    @Override // com.yfanads.android.core.render.api.YFAdVideoPlayConfig
    public int getVideoAutoPlayType() {
        return this.playType;
    }

    @Override // com.yfanads.android.core.render.api.YFAdVideoPlayConfig
    public boolean isDataFlowAutoStart() {
        return this.isDataFlowAutoStart;
    }

    @Override // com.yfanads.android.core.render.api.YFAdVideoPlayConfig
    public boolean isNoCache() {
        return this.isNoCache;
    }

    @Override // com.yfanads.android.core.render.api.YFAdVideoPlayConfig
    public boolean isVideoSoundEnable() {
        return this.isVideoSoundEnable;
    }

    @Override // com.yfanads.android.core.render.api.YFAdVideoPlayConfig
    public void setDataFlowAutoStart(boolean z) {
        this.isAutoStart = z;
    }

    @Override // com.yfanads.android.core.render.api.YFAdVideoPlayConfig
    public void setNoCache() {
        this.isNoCache = true;
    }

    @Override // com.yfanads.android.core.render.api.YFAdVideoPlayConfig
    public void setVideoAutoPlayType(int i) {
        this.playType = i;
    }

    @Override // com.yfanads.android.core.render.api.YFAdVideoPlayConfig
    public void setVideoSoundEnable(boolean z) {
        this.isVideoSoundEnable = z;
    }
}
