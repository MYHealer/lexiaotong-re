package com.meishu.sdk.platform.ms.recycler;

import android.content.Context;
import android.text.TextUtils;
import com.meishu.sdk.core.AdSdk;
import com.meishu.sdk.core.ad.recycler.RecyclerAdMediaListener;
import com.meishu.sdk.core.utils.LogUtil;
import com.meishu.sdk.core.utils.h0;
import com.meishu.sdk.core.utils.z;

/* JADX INFO: compiled from: MeishuAdMediaListenerAdapter.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class b implements com.meishu.sdk.meishu_ad.nativ.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public RecyclerAdMediaListener f5185a;
    public Context b = AdSdk.getContext();
    public com.meishu.sdk.meishu_ad.nativ.f c;
    public boolean d;

    public b(com.meishu.sdk.meishu_ad.nativ.f fVar, RecyclerAdMediaListener recyclerAdMediaListener) {
        this.c = fVar;
        this.f5185a = recyclerAdMediaListener;
    }

    @Override // com.meishu.sdk.meishu_ad.nativ.e
    public void onVideoComplete() {
        try {
            LogUtil.d("MeishuAdMediaListenerAdapter", "send onVideoComplete");
            String[] strArr = this.c.n;
            if (strArr != null) {
                for (String str : strArr) {
                    if (!TextUtils.isEmpty(str)) {
                        z.a(this.b, h0.a(str), new com.meishu.sdk.core.utils.i());
                    }
                }
            }
            RecyclerAdMediaListener recyclerAdMediaListener = this.f5185a;
            if (recyclerAdMediaListener != null) {
                recyclerAdMediaListener.onVideoCompleted();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.meishu.sdk.meishu_ad.nativ.e
    public void onVideoMute() {
        try {
            LogUtil.d("MeishuAdMediaListenerAdapter", "send onVideoMute");
            String[] strArr = this.c.r;
            if (strArr != null) {
                for (String str : strArr) {
                    if (!TextUtils.isEmpty(str)) {
                        z.a(this.b, h0.a(str), new com.meishu.sdk.core.utils.i());
                    }
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.meishu.sdk.meishu_ad.nativ.e
    public void onVideoOneHalf() {
        try {
            LogUtil.d("MeishuAdMediaListenerAdapter", "send onVideoOneHalf");
            String[] strArr = this.c.l;
            if (strArr != null) {
                for (String str : strArr) {
                    if (!TextUtils.isEmpty(str)) {
                        z.a(this.b, h0.a(str), new com.meishu.sdk.core.utils.i());
                    }
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.meishu.sdk.meishu_ad.nativ.e
    public void onVideoOneQuarter() {
        try {
            LogUtil.d("MeishuAdMediaListenerAdapter", "send onVideoOneQuarter");
            String[] strArr = this.c.k;
            if (strArr != null) {
                for (String str : strArr) {
                    if (!TextUtils.isEmpty(str)) {
                        z.a(this.b, h0.a(str), new com.meishu.sdk.core.utils.i());
                    }
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.meishu.sdk.meishu_ad.nativ.e
    public void onVideoPause() {
        try {
            LogUtil.d("MeishuAdMediaListenerAdapter", "send onVideoPause");
            String[] strArr = this.c.o;
            if (strArr != null) {
                for (String str : strArr) {
                    if (!TextUtils.isEmpty(str)) {
                        z.a(this.b, h0.a(str), new com.meishu.sdk.core.utils.i());
                    }
                }
            }
            RecyclerAdMediaListener recyclerAdMediaListener = this.f5185a;
            if (recyclerAdMediaListener != null) {
                recyclerAdMediaListener.onVideoPause();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.meishu.sdk.meishu_ad.nativ.e
    public void onVideoResume() {
        try {
            LogUtil.d("MeishuAdMediaListenerAdapter", "send onVideoResume");
            String[] strArr = this.c.p;
            if (strArr != null) {
                for (String str : strArr) {
                    if (!TextUtils.isEmpty(str)) {
                        z.a(this.b, h0.a(str), new com.meishu.sdk.core.utils.i());
                    }
                }
            }
            RecyclerAdMediaListener recyclerAdMediaListener = this.f5185a;
            if (recyclerAdMediaListener != null) {
                recyclerAdMediaListener.onVideoResume();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.meishu.sdk.meishu_ad.nativ.e
    public void onVideoStart() {
        try {
            if (com.meishu.sdk.core.utils.a.b(this.c)) {
                LogUtil.dev("MeishuAdMediaListenerAdapter", "has video start. return");
                return;
            }
            if (!this.d) {
                LogUtil.d("MeishuAdMediaListenerAdapter", "send onVideoStart");
                this.d = true;
                this.c.setHasVideoStart(true);
                String[] strArr = this.c.j;
                if (strArr != null) {
                    for (String str : strArr) {
                        if (!TextUtils.isEmpty(str)) {
                            z.a(this.b, h0.a(str), new com.meishu.sdk.core.utils.i());
                        }
                    }
                }
            }
            RecyclerAdMediaListener recyclerAdMediaListener = this.f5185a;
            if (recyclerAdMediaListener != null) {
                recyclerAdMediaListener.onVideoStart();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.meishu.sdk.meishu_ad.nativ.e
    public void onVideoThreeQuarter() {
        try {
            LogUtil.d("MeishuAdMediaListenerAdapter", "send onVideoThreeQuarter");
            String[] strArr = this.c.m;
            if (strArr != null) {
                for (String str : strArr) {
                    if (!TextUtils.isEmpty(str)) {
                        z.a(this.b, h0.a(str), new com.meishu.sdk.core.utils.i());
                    }
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.meishu.sdk.meishu_ad.nativ.e
    public void onVideoUnmute() {
        try {
            LogUtil.d("MeishuAdMediaListenerAdapter", "send onVideoUnmute");
            String[] strArr = this.c.s;
            if (strArr != null) {
                for (String str : strArr) {
                    if (!TextUtils.isEmpty(str)) {
                        z.a(this.b, h0.a(str), new com.meishu.sdk.core.utils.i());
                    }
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.meishu.sdk.meishu_ad.nativ.e
    public void onProgressUpdate(long j, long j2) {
        RecyclerAdMediaListener recyclerAdMediaListener = this.f5185a;
        if (recyclerAdMediaListener != null) {
            recyclerAdMediaListener.onProgressUpdate(j, j2);
        }
    }

    @Override // com.meishu.sdk.meishu_ad.nativ.e
    public void onVideoError() {
        RecyclerAdMediaListener recyclerAdMediaListener = this.f5185a;
        if (recyclerAdMediaListener != null) {
            recyclerAdMediaListener.onVideoError();
        }
    }

    @Override // com.meishu.sdk.meishu_ad.nativ.e
    public void onVideoLoaded() {
        RecyclerAdMediaListener recyclerAdMediaListener = this.f5185a;
        if (recyclerAdMediaListener != null) {
            recyclerAdMediaListener.onVideoLoaded();
        }
    }
}
