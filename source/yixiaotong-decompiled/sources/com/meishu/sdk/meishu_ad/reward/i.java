package com.meishu.sdk.meishu_ad.reward;

import com.meishu.sdk.activity.MeishuRewardH5Activity;
import com.meishu.sdk.core.exception.ErrorCodeUtil;
import com.meishu.sdk.core.safe.l;
import com.meishu.sdk.core.safe.n;
import com.meishu.sdk.core.utils.LogUtil;
import com.meishu.sdk.core.utils.SdkHandler;
import com.meishu.sdk.meishu_ad.f0;
import com.meishu.sdk.meishu_ad.v;
import java.util.Timer;

/* JADX INFO: compiled from: RewardH5.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class i {
    public c c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile boolean f5074a = false;
    public final Object b = new Object();
    public volatile Boolean d = null;
    public volatile Boolean e = null;
    public final com.meishu.sdk.core.webview.h f = new com.meishu.sdk.core.webview.h(new com.meishu.sdk.core.webview.h.a() { // from class: com.meishu.sdk.meishu_ad.reward.i$$ExternalSyntheticLambda0
        @Override // com.meishu.sdk.core.webview.h.a
        public final void a(boolean z) {
            this.f$0.a(z);
        }
    });

    /* JADX INFO: compiled from: RewardH5.java */
    public class a extends n {

        /* JADX INFO: renamed from: com.meishu.sdk.meishu_ad.reward.i$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: RewardH5.java */
        public class C0826a extends l {
            public C0826a() {
            }

            @Override // com.meishu.sdk.core.safe.l
            public void safeRun() {
                LogUtil.dev("RewardH5", "timeoutCheck");
                i.a(i.this);
            }
        }

        public a() {
        }

        @Override // com.meishu.sdk.core.safe.n
        public void a() {
            cancel();
            SdkHandler.getInstance().runOnUiThread(new C0826a());
        }
    }

    /* JADX INFO: compiled from: RewardH5.java */
    public class b extends n {

        /* JADX INFO: compiled from: RewardH5.java */
        public class a extends l {
            public a() {
            }

            @Override // com.meishu.sdk.core.safe.l
            public void safeRun() {
                i.a(i.this);
            }
        }

        public b() {
        }

        @Override // com.meishu.sdk.core.safe.n
        public void a() {
            cancel();
            SdkHandler.getInstance().runOnUiThread(new a());
        }
    }

    /* JADX INFO: compiled from: RewardH5.java */
    public interface c {
    }

    public i(c cVar) {
        this.c = cVar;
        try {
            new Timer().schedule(new a(), 5000L);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final void c(boolean z) {
        synchronized (this.b) {
            if (this.c != null) {
                LogUtil.dev("RewardH5", "final reward notifySuccess:" + z);
                v.c cVar = (v.c) this.c;
                cVar.getClass();
                if (z && !cVar.f5101a.l) {
                    MeishuRewardH5Activity.setRewardH5Data(cVar.b[0], cVar.f5101a);
                }
                SdkHandler.getInstance().runOnUiThread(new f0(cVar));
                this.c = null;
            }
        }
    }

    public void d(boolean z) {
        com.meishu.sdk.core.webview.h hVar = this.f;
        if (hVar.c != null) {
            return;
        }
        hVar.c = Boolean.valueOf(z);
        LogUtil.dev("RewardH5", "h5LoadedRes:" + z);
        if (hVar.c.booleanValue()) {
            synchronized (hVar.f4981a) {
                com.meishu.sdk.core.webview.h.a aVar = hVar.b;
                if (aVar != null) {
                    aVar.a(true);
                    hVar.b = null;
                }
            }
            return;
        }
        synchronized (hVar.f4981a) {
            com.meishu.sdk.core.webview.h.a aVar2 = hVar.b;
            if (aVar2 != null) {
                aVar2.a(false);
                hVar.b = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z) {
        if (this.e != null) {
            return;
        }
        this.e = Boolean.valueOf(z);
        if (this.e.booleanValue()) {
            LogUtil.dev("RewardH5", "onH5ReadyRes 2");
            c(true);
        } else if (this.d != null) {
            LogUtil.dev("RewardH5", "onH5ReadyRes 3");
            if (this.d.booleanValue()) {
                LogUtil.dev("RewardH5", "onH5ReadyRes 4");
                c(false);
            } else {
                LogUtil.dev("RewardH5", "onH5ReadyRes 5");
                a();
            }
        }
    }

    public void b(boolean z) {
        if (this.d != null) {
            return;
        }
        this.d = Boolean.valueOf(z);
        LogUtil.dev("RewardH5", "nativeReadyRes:" + z);
        if (this.d.booleanValue()) {
            if (this.e == null) {
                LogUtil.dev("RewardH5", "nativeReadyRes2");
                b();
                return;
            } else {
                LogUtil.dev("RewardH5", "nativeReadyRes3");
                c(this.e.booleanValue());
                return;
            }
        }
        if (this.e == null) {
            LogUtil.dev("RewardH5", "nativeReadyRes4");
            b();
            return;
        }
        LogUtil.dev("RewardH5", "nativeReadyRes5");
        if (this.e.booleanValue()) {
            LogUtil.dev("RewardH5", "nativeReadyRes6");
            c(true);
        } else {
            LogUtil.dev("RewardH5", "nativeReadyRes7");
            a();
        }
    }

    public static void a(i iVar) {
        if (iVar.e == null) {
            iVar.e = Boolean.valueOf(Boolean.TRUE.equals(iVar.f.c));
        }
        Boolean bool = Boolean.TRUE;
        if (!bool.equals(iVar.e) && !bool.equals(iVar.d)) {
            iVar.a();
        } else {
            iVar.c(bool.equals(iVar.e));
        }
    }

    public final void a() {
        synchronized (this.b) {
            if (this.c != null) {
                LogUtil.dev("RewardH5", "final reward notifyFail");
                v.c cVar = (v.c) this.c;
                if (cVar.d != 1) {
                    v.this.a(cVar.c, "video load error", ErrorCodeUtil.AD_LOAD_ERROR);
                }
                this.c = null;
            }
        }
    }

    public final void b() {
        try {
            if (this.f5074a) {
                return;
            }
            this.f5074a = true;
            new Timer().schedule(new b(), 5000L);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
