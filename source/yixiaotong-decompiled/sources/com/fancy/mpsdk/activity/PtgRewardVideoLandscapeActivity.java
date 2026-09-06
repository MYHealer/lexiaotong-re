package com.fancy.mpsdk.activity;

import com.fancy.adsdk.lib.R;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public class PtgRewardVideoLandscapeActivity extends PtgRewardVideoPortraitActivity {
    @Override // com.fancy.mpsdk.activity.PtgRewardVideoPortraitActivity
    public final void _a(boolean z) {
        setRequestedOrientation(0);
        setContentView(z ? R.layout.fancy_activity_reward_video_web : R.layout.fancy_activity_reward_video_landscape);
    }
}
