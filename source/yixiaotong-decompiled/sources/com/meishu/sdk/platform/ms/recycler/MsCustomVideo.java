package com.meishu.sdk.platform.ms.recycler;

import android.content.Context;
import android.text.TextUtils;
import com.meishu.sdk.core.AdSdk;
import com.meishu.sdk.core.utils.LogUtil;
import com.meishu.sdk.core.utils.h0;
import com.meishu.sdk.core.utils.z;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class MsCustomVideo {
    private static final String TAG = "MsCustomVideo";
    private com.meishu.sdk.meishu_ad.nativ.f adSlot;
    private Context context;
    private boolean isStarted;

    public MsCustomVideo(com.meishu.sdk.meishu_ad.nativ.f fVar) {
        this.adSlot = fVar;
    }

    public void reportVideoClose() {
        try {
            LogUtil.d(TAG, "send onVideoClose");
            String[] strArr = this.adSlot.u;
            if (strArr != null) {
                for (String str : strArr) {
                    if (!TextUtils.isEmpty(str)) {
                        z.a(AdSdk.getContext(), h0.a(str), new com.meishu.sdk.core.utils.i());
                    }
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void reportVideoComplete() {
        try {
            LogUtil.d(TAG, "send onVideoComplete");
            String[] strArr = this.adSlot.n;
            if (strArr != null) {
                for (String str : strArr) {
                    if (!TextUtils.isEmpty(str)) {
                        z.a(AdSdk.getContext(), h0.a(str), new com.meishu.sdk.core.utils.i());
                    }
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void reportVideoMute() {
        try {
            LogUtil.d(TAG, "send onVideoMute");
            String[] strArr = this.adSlot.r;
            if (strArr != null) {
                for (String str : strArr) {
                    if (!TextUtils.isEmpty(str)) {
                        z.a(AdSdk.getContext(), h0.a(str), new com.meishu.sdk.core.utils.i());
                    }
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void reportVideoOneHalf() {
        try {
            LogUtil.d(TAG, "send onVideoOneHalf");
            String[] strArr = this.adSlot.l;
            if (strArr != null) {
                for (String str : strArr) {
                    if (!TextUtils.isEmpty(str)) {
                        z.a(AdSdk.getContext(), h0.a(str), new com.meishu.sdk.core.utils.i());
                    }
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void reportVideoOneQuarter() {
        try {
            LogUtil.d(TAG, "send onVideoOneQuarter");
            String[] strArr = this.adSlot.k;
            if (strArr != null) {
                for (String str : strArr) {
                    if (!TextUtils.isEmpty(str)) {
                        z.a(AdSdk.getContext(), h0.a(str), new com.meishu.sdk.core.utils.i());
                    }
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void reportVideoPause() {
        try {
            LogUtil.d(TAG, "send onVideoPause");
            String[] strArr = this.adSlot.o;
            if (strArr != null) {
                for (String str : strArr) {
                    if (!TextUtils.isEmpty(str)) {
                        z.a(AdSdk.getContext(), h0.a(str), new com.meishu.sdk.core.utils.i());
                    }
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void reportVideoReplay() {
        try {
            LogUtil.d(TAG, "send onVideoReplay");
            String[] strArr = this.adSlot.t;
            if (strArr != null) {
                for (String str : strArr) {
                    if (!TextUtils.isEmpty(str)) {
                        z.a(AdSdk.getContext(), h0.a(str), new com.meishu.sdk.core.utils.i());
                    }
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void reportVideoResume() {
        try {
            LogUtil.d(TAG, "send onVideoResume");
            String[] strArr = this.adSlot.p;
            if (strArr != null) {
                for (String str : strArr) {
                    if (!TextUtils.isEmpty(str)) {
                        z.a(AdSdk.getContext(), h0.a(str), new com.meishu.sdk.core.utils.i());
                    }
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void reportVideoSkip() {
        try {
            LogUtil.d(TAG, "send onVideoSkip");
            String[] strArr = this.adSlot.q;
            if (strArr != null) {
                for (String str : strArr) {
                    if (!TextUtils.isEmpty(str)) {
                        z.a(AdSdk.getContext(), h0.a(str), new com.meishu.sdk.core.utils.i());
                    }
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void reportVideoStart() {
        try {
            LogUtil.d(TAG, "send onVideoStart");
            if (this.isStarted) {
                return;
            }
            String[] strArr = this.adSlot.j;
            if (strArr != null) {
                for (String str : strArr) {
                    if (!TextUtils.isEmpty(str)) {
                        z.a(AdSdk.getContext(), h0.a(str), new com.meishu.sdk.core.utils.i());
                    }
                }
            }
            this.isStarted = true;
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void reportVideoThreeQuarter() {
        try {
            LogUtil.d(TAG, "send onVideoThreeQuarter");
            String[] strArr = this.adSlot.m;
            if (strArr != null) {
                for (String str : strArr) {
                    if (!TextUtils.isEmpty(str)) {
                        z.a(AdSdk.getContext(), h0.a(str), new com.meishu.sdk.core.utils.i());
                    }
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void reportVideoUnmute() {
        try {
            LogUtil.d(TAG, "send onVideoUnmute");
            String[] strArr = this.adSlot.s;
            if (strArr != null) {
                for (String str : strArr) {
                    if (!TextUtils.isEmpty(str)) {
                        z.a(AdSdk.getContext(), h0.a(str), new com.meishu.sdk.core.utils.i());
                    }
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
