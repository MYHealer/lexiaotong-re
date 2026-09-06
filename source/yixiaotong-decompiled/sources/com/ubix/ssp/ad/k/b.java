package com.ubix.ssp.ad.k;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.bykv.vk.component.ttvideo.ILivePlayer;
import com.cdo.oaps.ad.wrapper.BaseWrapper;
import com.stub.StubApp;
import com.ubix.ssp.ad.e.a0.m;
import com.ubix.ssp.ad.e.a0.u;
import com.ubix.ssp.open.AdError;
import com.ubix.ssp.open.ParamsReview;
import com.ubix.ssp.open.video.UBiXRewardVideoExtra;
import com.unionpay.tsmservice.data.Constant;
import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class b extends com.ubix.ssp.ad.a implements com.ubix.ssp.ad.g.k.h {
    private com.ubix.ssp.ad.g.j C;
    private Context D;
    private SoftReference<Activity> E;
    protected com.ubix.ssp.ad.d.a F;
    protected long G;
    protected long H;
    private com.ubix.ssp.ad.b I;
    protected boolean J;
    protected boolean K;
    private volatile boolean L;
    private boolean M;
    protected com.ubix.ssp.ad.d.l N;
    private boolean O;
    private boolean P;
    private boolean Q;
    private boolean R;
    boolean S;
    private long T;
    private long U;
    private com.ubix.ssp.ad.g.h V;
    private final AtomicBoolean W;
    private int X;
    protected SoftReference<com.ubix.ssp.ad.e.z.h> Y;

    class a implements com.ubix.ssp.ad.e.z.h.b {
        a() {
        }

        @Override // com.ubix.ssp.ad.e.z.h.b
        public void a() {
            b bVar;
            com.ubix.ssp.ad.d.a aVar;
            com.ubix.ssp.ad.e.y.a.a aVar2;
            if (b.this.E == null || b.this.E.get() == null || (aVar = (bVar = b.this).F) == null || (aVar2 = aVar.f8604a) == null || aVar2.d == null) {
                return;
            }
            Context context = (Context) bVar.E.get();
            b bVar2 = b.this;
            String str = bVar2.F.f8604a.d.B;
            int iJ0 = bVar2.N.j0();
            String str2 = ((com.ubix.ssp.ad.a) b.this).d;
            b bVar3 = b.this;
            com.ubix.ssp.ad.e.a0.f.a(context, str, 0, iJ0, str2, bVar3.F.f8604a, false, bVar3.M);
        }

        @Override // com.ubix.ssp.ad.e.z.h.b
        public void b() {
            b bVar;
            com.ubix.ssp.ad.d.a aVar;
            com.ubix.ssp.ad.e.y.a.a aVar2;
            if (b.this.E == null || b.this.E.get() == null || (aVar = (bVar = b.this).F) == null || (aVar2 = aVar.f8604a) == null || aVar2.d == null) {
                return;
            }
            Context context = (Context) bVar.E.get();
            b bVar2 = b.this;
            String str = bVar2.F.f8604a.d.F;
            int iJ0 = bVar2.N.j0();
            String str2 = ((com.ubix.ssp.ad.a) b.this).d;
            b bVar3 = b.this;
            com.ubix.ssp.ad.e.a0.f.a(context, str, 0, iJ0, str2, bVar3.F.f8604a, false, bVar3.M);
        }

        @Override // com.ubix.ssp.ad.e.z.h.b
        public void c() {
            b bVar;
            com.ubix.ssp.ad.d.a aVar;
            com.ubix.ssp.ad.e.y.a.a aVar2;
            if (b.this.E == null || b.this.E.get() == null || (aVar = (bVar = b.this).F) == null || (aVar2 = aVar.f8604a) == null || aVar2.d == null) {
                return;
            }
            Context context = (Context) bVar.E.get();
            b bVar2 = b.this;
            String str = bVar2.F.f8604a.d.C;
            int iJ0 = bVar2.N.j0();
            String str2 = ((com.ubix.ssp.ad.a) b.this).d;
            b bVar3 = b.this;
            com.ubix.ssp.ad.e.a0.f.a(context, str, 0, iJ0, str2, bVar3.F.f8604a, false, bVar3.M);
        }
    }

    /* JADX INFO: renamed from: com.ubix.ssp.ad.k.b$b, reason: collision with other inner class name */
    class C1125b implements com.ubix.ssp.ad.e.a0.e0.a.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ HashMap f9038a;
        final /* synthetic */ HashMap b;
        final /* synthetic */ long c;
        final /* synthetic */ int d;

        C1125b(HashMap map, HashMap map2, long j, int i) {
            this.f9038a = map;
            this.b = map2;
            this.c = j;
            this.d = i;
        }

        @Override // com.ubix.ssp.ad.e.a0.e0.a.c
        public void a(AdError adError, String str, String str2) {
            b bVar;
            b.this.X = 3;
            boolean z = true;
            if (b.this.N.N() == 1) {
                bVar = b.this;
            } else {
                bVar = b.this;
                z = false;
            }
            bVar.L = z;
            if (!TextUtils.isEmpty(str2)) {
                this.f9038a.put("tx_server_extra", str2);
            }
            u.e("notifyRewardDialogStatus,denied=" + adError.getErrorMessage() + ";extra=" + str2);
            this.b.put("EVENT_DURATION", Long.valueOf(SystemClock.elapsedRealtime() - this.c));
            this.b.put("EVENT_STATUS_MSG", str);
            com.ubix.ssp.ad.e.w.f.a(((com.ubix.ssp.ad.a) b.this).c).a(com.ubix.ssp.ad.e.w.j.RewardFail, this.b, b.this.o(this.d), str);
            b.this.a(adError, str2);
            b.this.P();
        }

        @Override // com.ubix.ssp.ad.e.a0.e0.a.c
        public void a(String str) {
            b.this.X = 3;
            b.this.L = true;
            if (!TextUtils.isEmpty(str)) {
                this.f9038a.put("tx_server_extra", str);
            }
            u.e("notifyRewardDialogStatus,confirmed=" + b.this.X + ";" + b.this.L);
            this.b.put("EVENT_DURATION", Long.valueOf(SystemClock.elapsedRealtime() - this.c));
            com.ubix.ssp.ad.e.w.f.a(((com.ubix.ssp.ad.a) b.this).c).a(com.ubix.ssp.ad.e.w.j.RewardSucc, this.b, b.this.o(this.d), "");
            b.this.i(str);
            b.this.P();
        }
    }

    class c implements Runnable {
        c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (b.this.I != null) {
                Bundle bundle = new Bundle();
                bundle.putString("type", "reward");
                b.this.I.a(bundle);
            }
        }
    }

    class d implements com.ubix.ssp.ad.g.h {
        d() {
        }

        @Override // com.ubix.ssp.ad.g.h
        public boolean a() {
            b.this.a(3, false);
            return false;
        }
    }

    class e implements com.ubix.ssp.ad.e.v.e.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ boolean f9041a;

        e(boolean z) {
            this.f9041a = z;
        }

        @Override // com.ubix.ssp.ad.e.v.e.b
        public void a(com.ubix.ssp.ad.e.v.e eVar, String str, String str2, boolean z) {
            if (this.f9041a) {
                b.this.q(0);
            }
        }

        @Override // com.ubix.ssp.ad.e.v.e.b
        public void a(AdError adError) {
            if (this.f9041a) {
                b.this.a(0, adError);
            }
        }
    }

    class f implements com.ubix.ssp.ad.e.v.e.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ boolean f9042a;

        f(boolean z) {
            this.f9042a = z;
        }

        @Override // com.ubix.ssp.ad.e.v.e.b
        public void a(com.ubix.ssp.ad.e.v.e eVar, String str, String str2, boolean z) {
            if (this.f9042a) {
                b.this.Q();
            }
        }

        @Override // com.ubix.ssp.ad.e.v.e.b
        public void a(AdError adError) {
            u.a("onFailure " + adError.getErrorMessage());
            if (this.f9042a) {
                b.this.f(adError);
            }
        }
    }

    class g extends com.ubix.ssp.ad.a.z {
        final /* synthetic */ HashMap f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        g(HashMap map, int i, com.ubix.ssp.ad.e.s.e eVar, HashMap map2) {
            super(map, i, eVar);
            this.f = map2;
        }

        @Override // com.ubix.ssp.ad.a.z, com.ubix.ssp.ad.e.s.e
        public void a(int i) {
            super.a(i);
            u.e(com.ubix.ssp.ad.a.b, "onStart " + i);
        }

        @Override // com.ubix.ssp.ad.a.z, com.ubix.ssp.ad.e.s.e
        public void a(int i, int i2) {
            u.e(com.ubix.ssp.ad.a.b, "onPause " + i);
            super.a(i, i2);
            SoftReference<com.ubix.ssp.ad.e.z.h> softReference = b.this.Y;
            if (softReference != null && softReference.get() != null) {
                if (b.this.Y.get() instanceof com.ubix.ssp.ad.e.z.e) {
                    ((com.ubix.ssp.ad.e.z.e) b.this.Y.get()).setText("继续下载" + i2 + "%");
                } else {
                    ((com.ubix.ssp.ad.e.z.g) b.this.Y.get()).a("继续下载" + i2 + "%", i2);
                }
            }
            com.ubix.ssp.ad.e.s.c.a().a(this, null);
        }

        @Override // com.ubix.ssp.ad.a.z, com.ubix.ssp.ad.e.s.e
        public void a(int i, AdError adError, String str) {
            u.e(com.ubix.ssp.ad.a.b, "onFail " + i);
            super.a(i, adError, str);
            SoftReference<com.ubix.ssp.ad.e.z.h> softReference = b.this.Y;
            if (softReference == null || softReference.get() == null) {
                return;
            }
            if (b.this.Y.get() instanceof com.ubix.ssp.ad.e.z.e) {
                ((com.ubix.ssp.ad.e.z.e) b.this.Y.get()).setText("重新下载");
            } else {
                ((com.ubix.ssp.ad.e.z.g) b.this.Y.get()).a("重新下载", -999);
            }
        }

        @Override // com.ubix.ssp.ad.a.z, com.ubix.ssp.ad.e.s.e
        public void a(int i, String str) {
            u.e(com.ubix.ssp.ad.a.b, "onComplete " + i);
            super.a(i, str);
            SoftReference<com.ubix.ssp.ad.e.z.h> softReference = b.this.Y;
            if (softReference != null && softReference.get() != null) {
                if (b.this.Y.get() instanceof com.ubix.ssp.ad.e.z.e) {
                    ((com.ubix.ssp.ad.e.z.e) b.this.Y.get()).setText("立即安装");
                } else {
                    ((com.ubix.ssp.ad.e.z.g) b.this.Y.get()).a("立即安装", -999);
                }
            }
            try {
                if (this.f.containsKey("__NO_CLICK_CONFIRM_KEY__")) {
                    return;
                }
                this.f.put("__NO_CLICK_CONFIRM_KEY__", "TRUE");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        @Override // com.ubix.ssp.ad.a.z, com.ubix.ssp.ad.e.s.e
        public void b(int i, int i2) {
            u.e(com.ubix.ssp.ad.a.b, "onResume " + i);
            super.b(i, i2);
            SoftReference<com.ubix.ssp.ad.e.z.h> softReference = b.this.Y;
            if (softReference == null || softReference.get() == null) {
                return;
            }
            if (b.this.Y.get() instanceof com.ubix.ssp.ad.e.z.e) {
                ((com.ubix.ssp.ad.e.z.e) b.this.Y.get()).setText("下载中" + i2 + "%");
            } else {
                ((com.ubix.ssp.ad.e.z.g) b.this.Y.get()).a("下载中" + i2 + "%", i2);
            }
        }

        @Override // com.ubix.ssp.ad.a.z, com.ubix.ssp.ad.e.s.e
        public void c(int i, int i2) {
            super.c(i, i2);
            u.e(com.ubix.ssp.ad.a.b, "onUpdate " + i2);
            SoftReference<com.ubix.ssp.ad.e.z.h> softReference = b.this.Y;
            if (softReference == null || softReference.get() == null) {
                return;
            }
            if (b.this.Y.get() instanceof com.ubix.ssp.ad.e.z.e) {
                ((com.ubix.ssp.ad.e.z.e) b.this.Y.get()).a(i2);
            } else {
                ((com.ubix.ssp.ad.e.z.g) b.this.Y.get()).b(i2);
            }
        }
    }

    class h implements com.ubix.ssp.ad.e.a0.d.c {
        h() {
        }

        @Override // com.ubix.ssp.ad.e.a0.d.c
        public void a(long j) {
        }

        @Override // com.ubix.ssp.ad.e.a0.d.c
        public void b(long j) {
            u.e("onReturned=" + j);
            int i = 2;
            if (b.this.N.S() != 2 && b.this.N.S() != 4) {
                i = 5;
                if (b.this.N.S() != 5 && b.this.N.S() != 6) {
                    return;
                }
                b.a(b.this, j);
                if (!b.this.L && b.this.U > 0) {
                    try {
                        SoftReference<com.ubix.ssp.ad.e.z.h> softReference = b.this.Y;
                        if (softReference == null || softReference.get() == null) {
                            return;
                        }
                        ((com.ubix.ssp.ad.e.z.g) b.this.Y.get()).a(b.this.c());
                        return;
                    } catch (Throwable th) {
                        th.printStackTrace();
                        return;
                    }
                }
                if (b.this.L) {
                    return;
                }
                b bVar = b.this;
                bVar.S = true;
                if (bVar.C == null) {
                    return;
                }
            } else {
                if (b.this.L) {
                    return;
                }
                b bVar2 = b.this;
                bVar2.S = true;
                if (bVar2.C == null) {
                    return;
                }
            }
            b.this.p(i);
            b.this.P();
        }
    }

    class i implements com.ubix.ssp.ad.a.a0 {
        i() {
        }

        @Override // com.ubix.ssp.ad.a.a0
        public void a(int i) {
            if (i == 3) {
                try {
                    b bVar = b.this;
                    bVar.b(StubApp.getOrigApplicationContext(((Activity) bVar.E.get()).getApplicationContext()));
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        }
    }

    class j implements com.ubix.ssp.ad.a.a0 {
        j() {
        }

        @Override // com.ubix.ssp.ad.a.a0
        public void a(int i) {
            try {
                b bVar = b.this;
                bVar.b(StubApp.getOrigApplicationContext(((Activity) bVar.E.get()).getApplicationContext()));
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    class k implements Runnable {
        k() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                b.this.a(0, false);
                b.this.P();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    class l implements com.ubix.ssp.ad.e.z.h.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f9047a;

        l(int i) {
            this.f9047a = i;
        }

        @Override // com.ubix.ssp.ad.e.z.h.c
        public void a(com.ubix.ssp.ad.e.z.h hVar) {
            try {
                int i = this.f9047a;
                if (i != 2 && i != 3) {
                    if (b.this.I != null && (com.ubix.ssp.ad.d.b.E != 1 || !b.this.I.m())) {
                        b.this.I.a((ImageView) null);
                    }
                    b.this.M = true;
                    b.this.n();
                    if (b.this.C != null) {
                        if (b.this.L() && !b.this.L && b.this.X == 2) {
                            b.this.a(com.ubix.ssp.ad.e.a0.a0.a.a(4, "关闭广告时尚未收到验证结果"), "");
                        }
                        b.this.C.onAdClosed();
                        b.this.C = null;
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }

        @Override // com.ubix.ssp.ad.e.z.h.c
        public void a(com.ubix.ssp.ad.e.z.h hVar, HashMap<String, String> map) {
            b bVar;
            com.ubix.ssp.ad.d.a aVar;
            com.ubix.ssp.ad.b bVar2;
            try {
                if (b.this.I != null) {
                    if (com.ubix.ssp.ad.d.b.E != 1 || !b.this.I.m()) {
                        b.this.I.a((ImageView) null);
                    }
                    HashMap<String, String> clickMap = b.this.I.getClickMap();
                    int i = this.f9047a;
                    if (i != 1) {
                        if (i == 0) {
                            clickMap.put("__CLICK_TRIGGER__", BaseWrapper.ENTER_ID_18);
                            clickMap.put("__CLICK_AREA__", BaseWrapper.ENTER_ID_18);
                        } else if (i == 2) {
                            clickMap.put("__CLICK_TRIGGER__", "16");
                            clickMap.put("__CLICK_AREA__", "16");
                        } else if (i == 3) {
                            clickMap.put("__CLICK_TRIGGER__", BaseWrapper.ENTER_ID_19);
                            clickMap.put("__CLICK_AREA__", BaseWrapper.ENTER_ID_19);
                        }
                        bVar = b.this;
                        aVar = bVar.F;
                        bVar2 = bVar.I;
                    } else {
                        if (b.this.N.S() == 0) {
                            SoftReference<com.ubix.ssp.ad.e.z.h> softReference = b.this.Y;
                            if (softReference == null || softReference.get() == null || b.this.Y.get().c()) {
                                return;
                            }
                            b.this.Y.get().a();
                            return;
                        }
                        clickMap.put("__CLICK_TRIGGER__", BaseWrapper.ENTER_ID_17);
                        clickMap.put("__CLICK_AREA__", BaseWrapper.ENTER_ID_17);
                        bVar = b.this;
                        aVar = bVar.F;
                        bVar2 = bVar.I;
                    }
                    bVar.b(aVar, bVar2.getClickMap());
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }

        @Override // com.ubix.ssp.ad.e.z.h.c
        public void b(com.ubix.ssp.ad.e.z.h hVar) {
            u.e("onViewInitialized onClosed onClosed");
            b bVar = b.this;
            bVar.Y = null;
            if (this.f9047a == 2) {
                bVar.Q = true;
            }
        }

        @Override // com.ubix.ssp.ad.e.z.h.c
        public void c(com.ubix.ssp.ad.e.z.h hVar) {
            u.e("onViewInitialized new showRewardPopDialog");
            b.this.Y = new SoftReference<>(hVar);
        }
    }

    public b(Context context, String str) {
        super(context, str);
        this.J = false;
        this.K = false;
        this.L = false;
        this.M = false;
        this.O = false;
        this.P = true;
        this.Q = false;
        this.R = false;
        this.S = false;
        this.T = 30000L;
        this.U = ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT;
        this.V = new d();
        this.W = new AtomicBoolean(false);
        this.X = 0;
        this.D = context;
        this.i = 9;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:30:0x0075  */
    private boolean H() {
        com.ubix.ssp.ad.d.a aVar;
        com.ubix.ssp.ad.e.y.a.a aVar2;
        com.ubix.ssp.ad.e.y.a.a.b bVar;
        try {
            Bundle bundle = new Bundle();
            if (this.D != null && (aVar = this.F) != null && (aVar2 = aVar.f8604a) != null && (bVar = aVar2.d) != null) {
                bundle.putBoolean("IS_DOWNLOAD", com.ubix.ssp.ad.e.a0.c.a(bVar));
                bundle.putInt("COUNTDOWN_STATUS", this.N.g());
                this.T = this.N.P();
                int iQ = this.N.Q();
                String strO = this.N.O();
                int iS = this.N.S();
                switch (iS) {
                    case 0:
                        this.Q = true;
                        this.S = false;
                        if (TextUtils.isEmpty(strO)) {
                            strO = "获取奖励";
                        }
                        break;
                    case 1:
                        this.S = true;
                        if (TextUtils.isEmpty(strO)) {
                            strO = "点击并跳转获取奖励";
                        }
                        break;
                    case 2:
                        this.S = true;
                        if (TextUtils.isEmpty(strO)) {
                            strO = "点击并跳转获取奖励";
                        }
                        break;
                    case 3:
                    case 4:
                    case 6:
                        this.S = false;
                        if (TextUtils.isEmpty(strO)) {
                            strO = "获取奖励";
                        }
                        break;
                    case 5:
                        this.S = true;
                        if (TextUtils.isEmpty(strO)) {
                            strO = "点击广告并停留%s秒获取奖励";
                        }
                        break;
                }
                bundle.putLong("REWARD_GUIDE_START_TIME", this.N.u());
                bundle.putLong("REWARD_GUIDE_AUTO_CLOSE_TIME", this.N.t());
                long jR = this.N.R();
                this.U = jR;
                bundle.putLong("REWARD_TASK_TIME", jR);
                bundle.putInt("REWARD_PLAY_PERCENT", iQ);
                bundle.putInt("REWARD_TYPE", iS);
                bundle.putLong("REWARD_DURATION", this.T);
                bundle.putString("REWARD_DESCRIPTION", strO);
                bundle.putInt("VIDEO_RENDER_TYPE", this.N.k0());
                bundle.putBoolean("SUPPORT_FEED_BACK", this.F.f8604a.k);
                bundle.putBoolean("IS_UNNAMED", this.N.G0());
                com.ubix.ssp.ad.b bVarA = com.ubix.ssp.ad.b.a(this.D, bundle, 9, false);
                this.I = bVarA;
                if (bVarA != null) {
                    bVarA.setInnerListener(this);
                    return true;
                }
                return false;
            }
            return false;
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean L() {
        com.ubix.ssp.ad.e.y.a.a.b bVar;
        com.ubix.ssp.ad.e.y.a.a.b.g gVar;
        com.ubix.ssp.ad.d.a aVar = this.F;
        if (aVar == null || (bVar = aVar.f8604a.d) == null || (gVar = bVar.Q) == null) {
            return false;
        }
        return gVar.e;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Q() {
        com.ubix.ssp.ad.g.j jVar = this.C;
        if (jVar != null) {
            jVar.onVideoCached();
        }
    }

    private void R() {
        com.ubix.ssp.ad.b bVar;
        SoftReference<Activity> softReference = this.E;
        if (softReference == null || softReference.get() == null) {
            return;
        }
        if (TextUtils.isEmpty(this.F.f8604a.d.m) || this.N.J0()) {
            if (this.E.get() == null || this.E.get().isFinishing() || (bVar = this.I) == null) {
                return;
            }
            bVar.postDelayed(new k(), 100L);
            return;
        }
        try {
            if (this.R) {
                n();
                if (this.C != null) {
                    if (L() && !this.L && this.X == 2) {
                        a(com.ubix.ssp.ad.e.a0.a0.a.a(4, "关闭广告时尚未收到验证结果"), "");
                    }
                    this.C.onAdClosed();
                    this.C = null;
                    return;
                }
                return;
            }
            String strA = this.F.f8604a.d.m;
            try {
                com.ubix.ssp.ad.e.w.k kVarA = com.ubix.ssp.ad.e.w.k.a(StubApp.getOrigApplicationContext(this.D.getApplicationContext()));
                com.ubix.ssp.ad.e.y.a.a.b bVar2 = this.F.f8604a.d;
                strA = kVarA.a(0, bVar2.M, bVar2.P, this.I.getClickMap(), this.F.f8604a.d.m);
            } catch (Throwable th) {
                th.printStackTrace();
            }
            com.ubix.ssp.ad.e.a0.f.a(this.E.get(), strA, 9, 0, this.d, this.F.f8604a, true, this.M || this.L);
            this.R = true;
        } catch (Exception e2) {
            e2.printStackTrace();
            n();
            if (this.C != null) {
                if (L() && !this.L && this.X == 2) {
                    a(com.ubix.ssp.ad.e.a0.a0.a.a(4, "关闭广告时尚未收到验证结果"), "");
                }
                this.C.onAdClosed();
                this.C = null;
            }
        }
    }

    private void S() {
        String str;
        try {
            com.ubix.ssp.ad.e.s.g.c cVarA = com.ubix.ssp.ad.e.s.b.c().a(this.F.o);
            if (cVarA == null || cVarA.b() == null || cVarA.b().b().b() != 46) {
                return;
            }
            u.e("download complete");
            String strA = com.ubix.ssp.ad.e.a0.c.a(this.D, cVarA.b().b().e());
            if (TextUtils.isEmpty(strA)) {
                str = "download file is not valid";
            } else {
                u.e("download file is valid");
                this.F.u = strA;
                if (com.ubix.ssp.ad.e.a0.c.g(strA)) {
                    u.e("install complete");
                    try {
                        SoftReference<com.ubix.ssp.ad.e.z.h> softReference = this.Y;
                        if (softReference == null || softReference.get() == null) {
                            return;
                        }
                        ((com.ubix.ssp.ad.e.z.g) ((this.N.S() == 5 || this.N.S() == 6) ? this.Y.get() : this.Y.get())).a("打开应用", -999);
                        return;
                    } catch (Throwable th) {
                        th.printStackTrace();
                        return;
                    }
                }
                str = "install not complete";
            }
            u.e(str);
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    static /* synthetic */ long a(b bVar, long j2) {
        long j3 = bVar.U - j2;
        bVar.U = j3;
        return j3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i2, boolean z) {
        if (this.Y != null) {
            return;
        }
        Bundle bundleN = n(1);
        bundleN.putInt("REWARD_VIDEO_DIALOG_TYPE", i2);
        bundleN.putInt("REWARD_GUIDE_AUTO_CLOSE_TIME", (int) (this.N.t() / 1000));
        bundleN.putBoolean("REWARD_VIDEO_DIALOG_AUTO_CLOSE", z);
        bundleN.putBoolean("IS_REWARDED", this.L);
        if (this.N.S() == 0 && i2 == 1 && this.r != null) {
            com.ubix.ssp.ad.e.s.c.a().a(this.r, null);
        }
        com.ubix.ssp.ad.e.a0.c.a(this.E.get(), bundleN, new l(i2), new a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AdError adError, String str) {
        int i2;
        String str2;
        com.ubix.ssp.ad.e.y.a.a aVar;
        com.ubix.ssp.ad.e.y.a.a.b bVar;
        com.ubix.ssp.ad.e.y.a.a.b.g gVar;
        com.ubix.ssp.ad.g.j jVar = this.C;
        if (jVar != null) {
            com.ubix.ssp.ad.d.a aVar2 = this.F;
            if (aVar2 == null || (aVar = aVar2.f8604a) == null || (bVar = aVar.d) == null || (gVar = bVar.Q) == null) {
                i2 = 0;
                str2 = "";
            } else {
                str2 = gVar.c;
                i2 = gVar.d;
            }
            jVar.a(false, str2, i2, str, adError);
        }
        com.ubix.ssp.ad.b bVar2 = this.I;
        if (bVar2 != null) {
            bVar2.postDelayed(new c(), 100L);
        }
    }

    private void a(String str, boolean z) {
        com.ubix.ssp.ad.e.v.e.b().a(str, new e(z));
    }

    private void b(String str, boolean z) {
        com.ubix.ssp.ad.e.v.e.c().a(str, new f(z));
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Switch 'out' block B:79:0x0161 for B:8:0x0014 already processed. Defaulting to fallback option. */
    private void c(int i2, int i3) {
        try {
            if (i2 != 22) {
                if (i2 == 23) {
                    a(this.I.getContext(), this.F, this.I.getClickMap(), this.N.q(), new j());
                    a(2, new Object[0]);
                    return;
                }
                switch (i2) {
                    case 1:
                        a(1, new Object[0]);
                        if (this.N.S() != 0 && !this.L) {
                            this.S = true;
                            if (this.C != null) {
                                p(-1);
                                P();
                            }
                        }
                        if (i3 == 1) {
                            n();
                            if (this.C != null) {
                                if (L() && !this.L && this.X == 2) {
                                    a(com.ubix.ssp.ad.e.a0.a0.a.a(4, "关闭广告时尚未收到验证结果"), "");
                                }
                                this.C.onAdClosed();
                                this.C = null;
                            }
                        }
                        break;
                    case 2:
                    case 5:
                        a(this.I.getContext(), this.F, this.I.getClickMap());
                        break;
                    case 3:
                        if (this.N.S() == 2 || this.N.S() == 4 || this.N.S() == 5 || this.N.S() == 6) {
                            try {
                                a(StubApp.getOrigApplicationContext(this.E.get().getApplicationContext()), false);
                            } catch (Throwable th) {
                                th.printStackTrace();
                            }
                            a(3, new Object[0]);
                        } else {
                            try {
                                b(StubApp.getOrigApplicationContext(this.E.get().getApplicationContext()));
                            } catch (Throwable th2) {
                                th2.printStackTrace();
                                return;
                            }
                        }
                        e.printStackTrace();
                        break;
                    case 4:
                    case 6:
                        if ("2".equals(this.I.getClickMap().get("__CLICK_AREA__")) || "16".equals(this.I.getClickMap().get("__CLICK_AREA__")) || BaseWrapper.ENTER_ID_17.equals(this.I.getClickMap().get("__CLICK_AREA__")) || BaseWrapper.ENTER_ID_18.equals(this.I.getClickMap().get("__CLICK_AREA__")) || BaseWrapper.ENTER_ID_19.equals(this.I.getClickMap().get("__CLICK_AREA__"))) {
                            a(this.F, false, this.I.getClickMap());
                        }
                        if (this.N.S() == 2 || this.N.S() == 4) {
                            if (!this.L) {
                                this.S = true;
                                if (this.C != null) {
                                    p(2);
                                    P();
                                }
                            }
                        } else if (this.N.S() == 5 || this.N.S() == 6) {
                            S();
                        }
                        a(4, new Object[0]);
                        break;
                    default:
                        switch (i2) {
                            case 31:
                                g((String) null);
                                a(this.I.getContext(), this.F, this.I.getClickMap());
                                break;
                        }
                        break;
                }
            }
            if (i2 == 33) {
                a(33, new Object[0]);
            }
            if (this.N.S() == 2 || this.N.S() == 4 || this.N.S() == 5 || this.N.S() == 6) {
                a(this.I.getContext(), "", true, (com.ubix.ssp.ad.e.a0.d.e) null, (com.ubix.ssp.ad.e.a0.d.InterfaceC1085d) null, (com.ubix.ssp.ad.e.a0.d.c) new h());
                if (i2 == 22) {
                    b(this.I.getContext(), this.F, this.I.getClickMap(), this.N.q(), new i());
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private void c(com.ubix.ssp.ad.d.a aVar, HashMap<String, String> map) {
        if (this.q) {
            return;
        }
        int iA = a(aVar, 9, map, this.N.L(), aVar.o, 0, this.N.o() == 1, null, this.V);
        if ((this.N.S() == 1 || this.N.S() == 3) && !this.L) {
            this.S = true;
            if (this.C != null) {
                p(iA == 1 ? -1 : 1);
                P();
            }
        }
        c(iA, this.M ? 1 : 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(AdError adError) {
        com.ubix.ssp.ad.g.j jVar = this.C;
        if (jVar != null) {
            jVar.onError(adError);
        }
    }

    private void g(AdError adError) {
        super.b(adError);
        super.a(adError);
        com.ubix.ssp.ad.g.j jVar = this.C;
        if (jVar != null) {
            jVar.onError(adError);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(String str) {
        String str2;
        int i2;
        com.ubix.ssp.ad.e.y.a.a aVar;
        com.ubix.ssp.ad.e.y.a.a.b bVar;
        com.ubix.ssp.ad.e.y.a.a.b.g gVar;
        com.ubix.ssp.ad.g.j jVar = this.C;
        if (jVar != null) {
            jVar.onVideoRewarded();
            com.ubix.ssp.ad.d.a aVar2 = this.F;
            if (aVar2 == null || (aVar = aVar2.f8604a) == null || (bVar = aVar.d) == null || (gVar = bVar.Q) == null) {
                str2 = "";
                i2 = 0;
            } else {
                str2 = gVar.c;
                i2 = gVar.d;
            }
            this.C.a(true, str2, i2, str, null);
        }
        if (this.I != null) {
            Bundle bundle = new Bundle();
            bundle.putString("type", "reward");
            this.I.a(bundle);
        }
    }

    private void m(com.ubix.ssp.ad.d.a aVar) {
        this.J = true;
        this.N = a(aVar.f8604a);
        n(aVar);
    }

    /* JADX WARN: Code duplicated, block: B:22:0x0117  */
    private Bundle n(int i2) {
        com.ubix.ssp.ad.e.y.a.a aVar;
        com.ubix.ssp.ad.e.y.a.a.b bVar;
        boolean z;
        boolean z2;
        int iC;
        Bundle bundle = new Bundle();
        bundle.putInt("TYPE", i2);
        com.ubix.ssp.ad.d.a aVar2 = this.F;
        if (aVar2 != null && (aVar = aVar2.f8604a) != null && (bVar = aVar.d) != null) {
            if (i2 == 1) {
                int iQ = this.N.Q();
                switch (this.N.S()) {
                    case 0:
                        bVar = bVar;
                        long jMin = Math.min(this.T, (this.G * ((long) iQ)) / 100);
                        this.T = jMin;
                        long j2 = jMin - this.H;
                        z2 = false;
                        bundle.putInt("TITLE_TEMP", 0);
                        z = true;
                        bundle.putString("ELAPSE", String.valueOf((((int) j2) / 1000) + 1));
                        break;
                    case 1:
                        bVar = bVar;
                        bundle.putInt("TITLE_TEMP", 1);
                        bundle.putString("ELAPSE", "");
                        z = true;
                        z2 = false;
                        break;
                    case 2:
                        bVar = bVar;
                        z = true;
                        bundle.putInt("TITLE_TEMP", 3);
                        bundle.putString("ELAPSE", "");
                        z2 = false;
                        break;
                    case 3:
                        bVar = bVar;
                        long jMin2 = Math.min(this.T, (this.G * ((long) iQ)) / 100);
                        this.T = jMin2;
                        long j3 = jMin2 - this.H;
                        bundle.putInt("TITLE_TEMP", 5);
                        z = true;
                        bundle.putString("ELAPSE", String.valueOf((((int) j3) / 1000) + 1));
                        z2 = false;
                        break;
                    case 4:
                        long jMin3 = Math.min(this.T, (this.G * ((long) iQ)) / 100);
                        this.T = jMin3;
                        long j4 = jMin3 - this.H;
                        bundle.putInt("TITLE_TEMP", 8);
                        iC = (((int) j4) / 1000) + 1;
                        bundle.putString("ELAPSE", String.valueOf(iC));
                        z = true;
                        z2 = false;
                        break;
                    case 5:
                        this.T = Math.min(this.T, (this.G * ((long) iQ)) / 100);
                        bundle.putInt("TITLE_TEMP", 9);
                        bundle.putString("TASK_TIME", String.valueOf(this.N.R() / 1000));
                        iC = c();
                        bundle.putString("ELAPSE", String.valueOf(iC));
                        z = true;
                        z2 = false;
                        break;
                    case 6:
                        this.T = Math.min(this.T, (this.G * ((long) iQ)) / 100);
                        bundle.putInt("TITLE_TEMP", 10);
                        bundle.putString("TASK_TIME", String.valueOf(this.N.R() / 1000));
                        bundle.putString("ELAPSE", String.valueOf(c()));
                        bVar = bVar;
                        z = true;
                        z2 = false;
                        break;
                    default:
                        bVar = bVar;
                        z = true;
                        z2 = false;
                        break;
                }
            } else {
                bVar = bVar;
                z = true;
                z2 = false;
            }
            if (i2 == 0) {
                bundle.putBoolean("HAS_INDICATE", z);
            }
            com.ubix.ssp.ad.e.y.a.a.b bVar2 = bVar;
            bundle.putString("TITLE", bVar2.e);
            bundle.putString("SUB_TITLE", bVar2.f);
            bundle.putString("ICON_URL", bVar2.i);
            bundle.putString("BUTTON_TEXT", bVar2.E);
            if (this.G == 0) {
                z = z2;
            }
            bundle.putBoolean("GOT_VIDEO_CACHE", z);
            boolean zA = com.ubix.ssp.ad.e.a0.c.a(bVar2);
            bundle.putBoolean("IS_DOWNLOAD", zA);
            if (zA) {
                bundle.putString("DOWNLOAD_APP_NAME", bVar2.g);
                bundle.putString("DOWNLOAD_APP_VERSION", bVar2.A);
                bundle.putString("DOWNLOAD_APP_PUBLISHER", bVar2.z);
                bundle.putLong("DOWNLOAD_APP_SIZE", bVar2.G);
                bundle.putString("DOWNLOAD_APP_ICP_NUMBER", bVar2.H);
                bundle.putString("DOWNLOAD_APP_SUITABLE_AGE", bVar2.I);
            }
        }
        return bundle;
    }

    private void n(com.ubix.ssp.ad.d.a aVar) {
        int i2;
        String str;
        String str2;
        super.v();
        if (H()) {
            com.ubix.ssp.ad.e.y.a.a.b bVar = aVar.f8604a.d;
            int i3 = bVar.s;
            if (i3 == 9004 || i3 == 9003) {
                str2 = bVar.j[0].c;
            } else if (i3 == 9002 || i3 == 9001) {
                str2 = bVar.k.c;
            } else {
                i2 = 16;
                str = "广告模板Id异常,或资源与模板不匹配";
            }
            a(str2, true);
            return;
        }
        i2 = 6;
        str = "创建ViewClass失败，请勿重试";
        a(0, com.ubix.ssp.ad.e.a0.a0.a.g(i2, str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String o(int i2) {
        if (i2 == -2) {
            return "01505";
        }
        if (i2 == -1) {
            return "01506";
        }
        if (i2 == 1) {
            return "01502";
        }
        if (i2 != 2) {
            return i2 != 5 ? "01501" : "01504";
        }
        return "01503";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p(int i2) {
        com.ubix.ssp.ad.e.y.a.a aVar;
        com.ubix.ssp.ad.e.y.a.a.b bVar;
        com.ubix.ssp.ad.e.y.a.a.b.g gVar;
        com.ubix.ssp.ad.e.y.a.a aVar2;
        com.ubix.ssp.ad.e.y.a.a.b bVar2;
        com.ubix.ssp.ad.e.y.a.a.b.g gVar2;
        if (this.W.getAndSet(true)) {
            return;
        }
        HashMap<String, Object> map = new HashMap<>(j());
        HashMap map2 = new HashMap();
        map.put("EVENT_ATTRS", map2);
        com.ubix.ssp.ad.d.a aVar3 = this.F;
        if (aVar3 != null && (aVar2 = aVar3.f8604a) != null && (bVar2 = aVar2.d) != null && (gVar2 = bVar2.Q) != null && !TextUtils.isEmpty(gVar2.b)) {
            map2.put("tx_trans_id", this.F.f8604a.d.Q.b);
        }
        UBiXRewardVideoExtra uBiXRewardVideoExtra = this.v;
        if (uBiXRewardVideoExtra != null) {
            if (!TextUtils.isEmpty(uBiXRewardVideoExtra.userId)) {
                map2.put("tx_user_id", this.v.userId);
            }
            if (!TextUtils.isEmpty(this.v.extra)) {
                map2.put("tx_local_extra", this.v.extra);
            }
        }
        if (!L()) {
            this.L = true;
            this.X = 3;
            com.ubix.ssp.ad.e.w.f.a(this.c).a(com.ubix.ssp.ad.e.w.j.RewardOffline, map, o(i2), "");
            i((String) null);
            P();
            return;
        }
        com.ubix.ssp.ad.d.a aVar4 = this.F;
        if (aVar4 == null || (aVar = aVar4.f8604a) == null || (bVar = aVar.d) == null || (gVar = bVar.Q) == null) {
            return;
        }
        com.ubix.ssp.ad.e.a0.e0.a aVar5 = new com.ubix.ssp.ad.e.a0.e0.a(gVar.f, 10000);
        aVar5.a(new C1125b(map2, map, SystemClock.elapsedRealtime(), i2));
        this.X = 2;
        aVar5.a();
        com.ubix.ssp.ad.e.w.f.a(this.c).a(com.ubix.ssp.ad.e.w.j.RewardStart, map, o(i2), "");
    }

    public String B() {
        return l(9);
    }

    public ParamsReview C() {
        return super.a(this.F.f8604a, this.N.x0(), this.N.H0());
    }

    public long D() {
        return super.g(this.F);
    }

    public String E() {
        return this.k;
    }

    public String F() {
        com.ubix.ssp.ad.e.y.a.a aVar;
        com.ubix.ssp.ad.e.y.a.a.b bVar;
        com.ubix.ssp.ad.e.y.a.a.b.g gVar;
        com.ubix.ssp.ad.d.a aVar2 = this.F;
        return (aVar2 == null || (aVar = aVar2.f8604a) == null || (bVar = aVar.d) == null || (gVar = bVar.Q) == null) ? "" : gVar.b;
    }

    public View G() {
        return this.I;
    }

    protected boolean I() {
        com.ubix.ssp.ad.d.l lVar;
        return this.F != null && (lVar = this.N) != null && lVar.l0() && System.currentTimeMillis() / 1000 > this.F.j;
    }

    protected boolean J() {
        return this.K;
    }

    protected boolean K() {
        return this.J;
    }

    public boolean M() {
        return (!K() || J() || I()) ? false : true;
    }

    public boolean N() {
        int i2 = this.F.f8604a.d.s;
        return i2 == 9001 || i2 == 9002;
    }

    public void O() {
        super.m(9);
    }

    public void P() {
        try {
            u.e("notifyRewardDialogStatus=" + this.X + ";" + this.L);
            SoftReference<com.ubix.ssp.ad.e.z.h> softReference = this.Y;
            if (softReference != null && softReference.get() != null) {
                int i2 = this.X;
                if (i2 == 0) {
                    ((com.ubix.ssp.ad.e.z.g) this.Y.get()).a(this.L);
                } else if (i2 == 3) {
                    ((com.ubix.ssp.ad.e.z.g) this.Y.get()).b(this.L);
                } else {
                    ((com.ubix.ssp.ad.e.z.g) this.Y.get()).f();
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.ubix.ssp.ad.a
    protected com.ubix.ssp.ad.a.z a(HashMap<String, String> map, int i2, com.ubix.ssp.ad.e.s.e eVar) {
        return this.i != 9 ? super.a(map, i2, eVar) : new g(map, i2, eVar, map);
    }

    public void a(int i2) {
        a(this.F, this.N);
    }

    @Override // com.ubix.ssp.ad.g.k.j
    public void a(int i2, int i3) {
        u.a("onVideoPlayError :" + i3);
        com.ubix.ssp.ad.g.j jVar = this.C;
        if (jVar != null) {
            jVar.onError(com.ubix.ssp.ad.e.a0.a0.a.d(3, "缓冲超时"));
        }
        if (this.L) {
            return;
        }
        p(-2);
        R();
    }

    public void a(int i2, long j2, long j3) {
        if (j3 > 0) {
            long j4 = this.i == 1 ? 5000L : 0L;
            this.G = j3;
            this.H = j2;
            a(this.F, i2, j2, j3, j4);
            com.ubix.ssp.ad.d.l lVar = this.N;
            if (lVar == null || lVar.S() != 0 || !this.S || this.L || this.C == null) {
                return;
            }
            p(0);
        }
    }

    public void a(int i2, Bundle bundle) {
        super.a(bundle);
    }

    public void a(int i2, View view) {
        com.ubix.ssp.ad.e.y.a.a aVar;
        com.ubix.ssp.ad.e.y.a.a.b bVar;
        String str;
        super.y();
        d(this.F);
        c(this.F);
        try {
            com.ubix.ssp.ad.g.j jVar = this.C;
            if (jVar != null) {
                jVar.onAdExposed();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        com.ubix.ssp.ad.d.a aVar2 = this.F;
        if (aVar2 != null && (aVar = aVar2.f8604a) != null && (bVar = aVar.d) != null && (str = bVar.i) != null) {
            f(str);
        }
        b(this.I, this.N);
    }

    @Override // com.ubix.ssp.ad.a
    protected void a(int i2, com.ubix.ssp.ad.d.a aVar) {
        super.a(i2, aVar);
        if (com.ubix.ssp.ad.d.b.v) {
            a(this.I.getContext(), this.F, this.I.getClickMap());
        }
    }

    public void a(int i2, AdError adError) {
        super.c(adError);
        this.J = false;
        com.ubix.ssp.ad.g.j jVar = this.C;
        if (jVar != null) {
            jVar.onError(adError);
        }
    }

    @Override // com.ubix.ssp.ad.a
    protected void a(int i2, Object... objArr) {
        if (this.N.n0() && i2 != 0) {
            super.a(i2, objArr);
        }
        if (this.i == 9) {
            u.e("runClickCallback " + i2 + ";canRun=" + ((!this.N.n0() && i2 == 0) || (this.N.n0() && i2 != 0)));
            if (((this.N.n0() || i2 != 0) && (!this.N.n0() || i2 == 0)) || this.C == null || this.N.m0()) {
                return;
            }
            this.C.onVideoClicked();
        }
    }

    public void a(long j2) {
        com.ubix.ssp.ad.e.y.a.a aVar;
        com.ubix.ssp.ad.d.a aVar2 = this.F;
        if (aVar2 == null || (aVar = aVar2.f8604a) == null) {
            return;
        }
        super.a(aVar, j2);
    }

    public void a(Activity activity) {
        AdError adErrorD;
        com.ubix.ssp.ad.e.y.a.a aVar;
        com.ubix.ssp.ad.e.y.a.a.b bVar;
        int i2;
        if (activity == null) {
            e(com.ubix.ssp.ad.e.a0.a0.a.d(4, "Activity/Context为空"));
            return;
        }
        this.E = new SoftReference<>(activity);
        com.ubix.ssp.ad.d.a aVar2 = this.F;
        if (aVar2 == null || (aVar = aVar2.f8604a) == null || (bVar = aVar.d) == null || bVar.k == null || this.I == null) {
            activity.finish();
            adErrorD = com.ubix.ssp.ad.e.a0.a0.a.d(9, "内容加载失败");
        } else if (J()) {
            activity.finish();
            adErrorD = com.ubix.ssp.ad.e.a0.a0.a.c(3, "广告重复展示");
        } else if (!K()) {
            activity.finish();
            adErrorD = com.ubix.ssp.ad.e.a0.a0.a.d(5, "内容加载失败");
        } else {
            if (!I()) {
                int iR = 0;
                Bundle bundleN = n(0);
                if (N()) {
                    bundleN.putStringArray("IMAGE_URL", new String[]{this.F.f8604a.d.k.c});
                    bundleN.putString("VIDEO_URL", this.F.f8604a.d.k.b);
                    bundleN.putBoolean("AUTO_MUTE", this.N.K0());
                } else {
                    bundleN.putStringArray("IMAGE_URL", new String[]{this.F.f8604a.d.j[0].c});
                }
                bundleN.putBoolean("IS_VIDEO", N());
                bundleN.putInt("TEMPLATE_ID", 99001);
                bundleN.putBoolean("IS_UNNAMED", this.N.G0());
                if (this.N.b()) {
                    bundleN.putString("AD_SOURCE", this.F.f8604a.d.t);
                }
                com.ubix.ssp.ad.e.y.a.a.b.f fVar = this.F.f8604a.d.L;
                if (fVar != null && (i2 = fVar.b) != 0) {
                    bundleN.putInt("RENDER_MODE", i2);
                    bundleN.putFloat("SCALE_IGNORE_PERCENT", (this.F.f8604a.d.L.c * 1.0f) / 100.0f);
                    bundleN.putInt("SCALE_HORIZONTAL_MARGIN", this.F.f8604a.d.L.d);
                    bundleN.putInt("SCALE_VERTICAL_MARGIN", this.F.f8604a.d.L.e);
                }
                boolean z = this.N.S() == 0 || this.N.S() == 4 || this.N.S() == 3 || this.N.S() == 6;
                if (!this.F.w && (this.N.r() != 2 || z)) {
                    iR = this.N.r();
                }
                bundleN.putInt("VIDEO_ECTR", iR);
                bundleN.putString("DOWNLOAD_APP_NAME", bVar.g);
                this.I.b(bundleN);
                this.I.setShowCloseBtnDelay(this.N.e0());
                if (com.ubix.ssp.ad.e.a0.c.a(bVar)) {
                    this.I.a(bVar.g, bVar.A, bVar.z, bVar.h, bVar.H, bVar.I, bVar.G);
                }
                this.K = true;
                return;
            }
            activity.finish();
            adErrorD = com.ubix.ssp.ad.e.a0.a0.a.d(4, "文件已经过期");
        }
        e(adErrorD);
    }

    @Override // com.ubix.ssp.ad.a
    protected void a(Context context, Intent intent, long j2, BroadcastReceiver broadcastReceiver) {
        super.a(context, intent, j2, broadcastReceiver);
        if (this.N.S() == 6 || this.N.S() == 5) {
            long jElapsedRealtime = SystemClock.elapsedRealtime() - j2;
            u.e("duration=" + this.U + ";" + jElapsedRealtime);
            this.U -= jElapsedRealtime;
            if (this.L || this.U <= 0) {
                if (this.L) {
                    return;
                }
                this.S = true;
                if (this.C != null) {
                    p(5);
                    P();
                    return;
                }
                return;
            }
            try {
                SoftReference<com.ubix.ssp.ad.e.z.h> softReference = this.Y;
                if (softReference == null || softReference.get() == null) {
                    return;
                }
                ((com.ubix.ssp.ad.e.z.g) this.Y.get()).a(c());
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    @Override // com.ubix.ssp.ad.a
    protected void a(Message message) {
        int i2 = message.what;
        if (i2 != 5) {
            if (i2 != 6) {
                if (i2 != 10) {
                    if (i2 != 11) {
                        return;
                    }
                }
            }
            g((AdError) message.obj);
            return;
        }
        com.ubix.ssp.ad.d.a aVar = (com.ubix.ssp.ad.d.a) ((List) message.obj).get(0);
        this.F = aVar;
        aVar.e = 9;
        m(aVar);
    }

    @Override // com.ubix.ssp.ad.a
    protected void a(com.ubix.ssp.ad.d.a aVar, HashMap<String, String> map) {
        super.a(aVar, map);
    }

    public void a(com.ubix.ssp.ad.g.j jVar) {
        this.C = jVar;
    }

    public void a(UBiXRewardVideoExtra uBiXRewardVideoExtra) {
        this.v = uBiXRewardVideoExtra;
    }

    @Override // com.ubix.ssp.ad.a
    public void a(HashMap<String, String> map) {
        this.z = map;
    }

    @Override // com.ubix.ssp.ad.g.k.h
    public boolean a() {
        return this.L;
    }

    @Override // com.ubix.ssp.ad.a
    protected boolean a(com.ubix.ssp.ad.d.a aVar, boolean z, HashMap<String, String> map) {
        if (this.i != 9) {
            return super.a(aVar, z, map);
        }
        try {
            int iB = com.ubix.ssp.ad.e.s.b.c().b(aVar.o);
            if (iB == 47) {
                this.r = null;
            }
            u.e("triggerGlobalDownloadWindow status=" + iB + ";" + this.s);
            if (!z && iB == 44) {
                com.ubix.ssp.ad.e.s.b.c().a(this.c, aVar.o);
                SoftReference<com.ubix.ssp.ad.e.z.h> softReference = this.Y;
                if (softReference != null && softReference.get() != null) {
                    ((com.ubix.ssp.ad.e.z.g) this.Y.get()).a("下载继续", -999);
                }
                if (this.r != null) {
                    com.ubix.ssp.ad.e.s.c.a().a(this.r, null);
                }
                return false;
            }
            if (iB == 45) {
                com.ubix.ssp.ad.e.s.b.c().b(this.c, aVar.o);
                if (this.r == null) {
                    this.r = a(map, this.e.indexOf(aVar), this.y);
                }
                com.ubix.ssp.ad.e.s.c.a().a(this.r);
                return false;
            }
            if (iB == 43 || iB == 46) {
                if (this.r == null) {
                    this.r = a(map, this.e.indexOf(aVar), this.y);
                }
                com.ubix.ssp.ad.e.s.c.a().a(this.r);
            }
            if (this.r != null) {
                return true;
            }
            com.ubix.ssp.ad.e.s.c cVarA = com.ubix.ssp.ad.e.s.c.a();
            com.ubix.ssp.ad.a.z zVarA = a(map, this.e.indexOf(aVar), this.y);
            this.r = zVarA;
            cVarA.a(zVarA);
            return true;
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }

    @Override // com.ubix.ssp.ad.g.k.h
    public void b() {
        SoftReference<Activity> softReference = this.E;
        if (softReference == null || softReference.get() == null || this.E.get().isFinishing() || this.N.S() == 0 || this.L || this.X == 3) {
            return;
        }
        a(2, false);
    }

    public void b(int i2) {
        com.ubix.ssp.ad.d.a aVar;
        com.ubix.ssp.ad.e.y.a.a aVar2;
        com.ubix.ssp.ad.e.y.a.a.b bVar;
        Context context = this.D;
        if (context == null || (aVar = this.F) == null || (aVar2 = aVar.f8604a) == null || (bVar = aVar2.d) == null) {
            return;
        }
        com.ubix.ssp.ad.e.a0.f.a(context, bVar.F, 0, this.N, this.d, null);
    }

    @Override // com.ubix.ssp.ad.g.k.j
    public void b(int i2, int i3) {
        u.e("onVideoVisibilityChange =" + i3);
        if (i3 == 0 && this.O) {
            if (this.E.get() != null) {
                this.E.get().finish();
            }
        } else if (i3 == 0) {
            S();
        }
    }

    public void b(int i2, View view, HashMap<String, String> map) {
        if (this.q) {
            return;
        }
        if (map == null) {
            map = this.I.getClickMap();
            map.put("__CLICK_TRIGGER__", "");
        }
        a(this.F, this.I, this.N, map);
    }

    @Override // com.ubix.ssp.ad.a
    protected void b(int i2, com.ubix.ssp.ad.d.a aVar) {
        super.b(i2, aVar);
        if (i2 == 3) {
            a(2, new Object[0]);
        }
    }

    @Override // com.ubix.ssp.ad.a
    protected void b(Context context, Intent intent, long j2, BroadcastReceiver broadcastReceiver) {
        super.b(context, intent, j2, broadcastReceiver);
        StringBuilder sb = new StringBuilder("landing page rewarded ? ");
        boolean booleanExtra = intent.getBooleanExtra("error", false);
        u.e(sb.append(booleanExtra).toString());
        if (this.N.S() == 0 || this.N.S() == 6 || this.N.S() == 5 || booleanExtra) {
            return;
        }
        m.a(context).a(broadcastReceiver);
        if (this.L) {
            return;
        }
        this.S = true;
        if (this.C != null) {
            p(2);
            P();
        }
    }

    public void b(HashMap<String, String> map) {
        com.ubix.ssp.ad.e.y.a.a aVar;
        com.ubix.ssp.ad.d.a aVar2 = this.F;
        if (aVar2 == null || (aVar = aVar2.f8604a) == null) {
            return;
        }
        super.a(aVar, map);
    }

    @Override // com.ubix.ssp.ad.a
    protected boolean b(com.ubix.ssp.ad.d.a aVar, HashMap<String, String> map) {
        if (this.i != 9) {
            super.b(aVar, map);
        }
        if (this.i == 9) {
            map.put("__NO_CLICK_CONFIRM_KEY__", "TRUE");
            map.put("__CAN_RUN_ACTIVE_KEY__", "TRUE");
            super.b(this.F, map);
            com.ubix.ssp.ad.b bVar = this.I;
            if (bVar != null && com.ubix.ssp.ad.d.b.E == 1 && bVar.m()) {
                this.I.a(this.N.B(), this.N.A());
            }
            com.ubix.ssp.ad.d.a aVar2 = this.F;
            if (aVar2.n) {
                map.put("__AUCTION_PRICE__", aVar2.m);
            }
            a(this.F.f8604a, map, 201);
            map.put("__MULTI_CLICK_KEY__", "TRUE");
            try {
                a(0, new Object[0]);
            } catch (Throwable th) {
                th.printStackTrace();
            }
            Bundle bundle = new Bundle();
            bundle.putString("type", Constant.CASH_LOAD_CANCEL);
            this.I.k();
            this.I.a(bundle);
            c(this.F, map);
        }
        return true;
    }

    @Override // com.ubix.ssp.ad.g.k.h
    public int c() {
        long j2 = this.U;
        if (j2 < 0 || j2 >= 1000) {
            return (int) (j2 / 1000);
        }
        return 1;
    }

    @Override // com.ubix.ssp.ad.g.k.j
    public void c(int i2) {
        com.ubix.ssp.ad.g.j jVar;
        this.M = true;
        o();
        com.ubix.ssp.ad.d.a aVar = this.F;
        com.ubix.ssp.ad.e.y.a.a aVar2 = aVar.f8604a;
        long j2 = this.H;
        long j3 = this.G;
        b(aVar2, a(aVar, j2, j3, j3));
        R();
        if (!N() || (jVar = this.C) == null) {
            return;
        }
        jVar.onVideoPlayCompleted();
    }

    @Override // com.ubix.ssp.ad.a
    protected void c(Context context, Intent intent, long j2, BroadcastReceiver broadcastReceiver) {
        super.c(context, intent, j2, broadcastReceiver);
        if (this.i == 9) {
            a(3, new Object[0]);
        }
    }

    @Override // com.ubix.ssp.ad.g.k.h
    public int d() {
        return this.X;
    }

    @Override // com.ubix.ssp.ad.g.k.h
    public void e() {
    }

    /* JADX WARN: Code duplicated, block: B:60:0x00a6  */
    public void e(int i2) {
        SoftReference<Activity> softReference;
        if (!this.N.A0() && (((!this.L && this.X != 3) || !this.S) && !this.M && (softReference = this.E) != null && softReference.get() != null && !this.E.get().isFinishing())) {
            a(1, false);
            return;
        }
        if (this.N.A0()) {
            if (this.C == null) {
                return;
            }
            if (L() && !this.L && this.X == 2) {
                a(com.ubix.ssp.ad.e.a0.a0.a.a(4, "关闭广告时尚未收到验证结果"), "");
            }
        } else {
            if (this.L || this.X == 3) {
                if (!this.g) {
                    R();
                    return;
                }
                if (this.C != null) {
                    if (L() && !this.L && this.X == 2) {
                        a(com.ubix.ssp.ad.e.a0.a0.a.a(4, "关闭广告时尚未收到验证结果"), "");
                    }
                    this.C.onAdClosed();
                    this.C = null;
                    return;
                }
                return;
            }
            if (!this.q) {
                R();
                return;
            } else {
                if (this.C == null) {
                    return;
                }
                if (L() && !this.L && this.X == 2) {
                    a(com.ubix.ssp.ad.e.a0.a0.a.a(4, "关闭广告时尚未收到验证结果"), "");
                }
            }
        }
        this.C.onAdClosed();
        this.C = null;
    }

    public void e(AdError adError) {
        super.d(adError);
        com.ubix.ssp.ad.g.j jVar = this.C;
        if (jVar != null) {
            jVar.onError(adError);
        }
    }

    @Override // com.ubix.ssp.ad.g.k.h
    public void f() {
        if (!this.S) {
            this.S = true;
        }
        if ((this.N.S() != 0 && this.N.S() != 4 && this.N.S() != 3 && this.N.S() != 6) || this.L || this.C == null) {
            return;
        }
        p(0);
    }

    public void f(int i2) {
        com.ubix.ssp.ad.d.a aVar;
        com.ubix.ssp.ad.e.y.a.a aVar2;
        com.ubix.ssp.ad.e.y.a.a.b bVar;
        Context context = this.D;
        if (context == null || (aVar = this.F) == null || (aVar2 = aVar.f8604a) == null || (bVar = aVar2.d) == null) {
            return;
        }
        com.ubix.ssp.ad.e.a0.f.a(context, bVar.C, 0, this.N, this.d, null);
    }

    @Override // com.ubix.ssp.ad.g.k.j
    public void g(int i2) {
    }

    @Override // com.ubix.ssp.ad.g.k.h
    public boolean g() {
        if (!this.P || !this.Q || this.L) {
            return false;
        }
        this.P = false;
        return true;
    }

    @Override // com.ubix.ssp.ad.a
    public void h() {
        super.h();
        try {
            try {
                u.e("onActivityCreated destroy" + this.I);
                com.ubix.ssp.ad.b bVar = this.I;
                if (bVar != null) {
                    ViewGroup viewGroup = (ViewGroup) bVar.getParent();
                    if (viewGroup != null) {
                        viewGroup.removeView(this.I);
                    }
                    this.I.j();
                    this.I = null;
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        } finally {
            this.C = null;
        }
    }

    @Override // com.ubix.ssp.ad.g.k.j
    public void h(int i2) {
        com.ubix.ssp.ad.g.j jVar;
        if (!N() || (jVar = this.C) == null) {
            return;
        }
        jVar.onVideoPlayStarted();
    }

    public void h(String str) {
        if (TextUtils.isEmpty(str)) {
            b(com.ubix.ssp.ad.e.a0.a0.a.j(10, "竞价广告体为空或解析异常，请检查传入的参数是否正确"));
        } else {
            e(str);
        }
    }

    public void i(int i2) {
        com.ubix.ssp.ad.d.a aVar;
        com.ubix.ssp.ad.e.y.a.a aVar2;
        com.ubix.ssp.ad.e.y.a.a.b bVar;
        Context context = this.D;
        if (context == null || (aVar = this.F) == null || (aVar2 = aVar.f8604a) == null || (bVar = aVar2.d) == null) {
            return;
        }
        com.ubix.ssp.ad.e.a0.f.a(context, bVar.B, 0, this.N, this.d, null);
    }

    @Override // com.ubix.ssp.ad.a
    protected AdError j(com.ubix.ssp.ad.d.a aVar) {
        int i2;
        String str;
        com.ubix.ssp.ad.e.y.a.a.b.C1109b c1109b;
        com.ubix.ssp.ad.e.y.a.a.b bVar = aVar.f8604a.d;
        int i3 = bVar.s;
        if (i3 == 9003 || i3 == 9004) {
            com.ubix.ssp.ad.e.y.a.a.b.C1109b[] c1109bArr = bVar.j;
            if (c1109bArr != null && c1109bArr.length != 0 && (c1109b = c1109bArr[0]) != null && !TextUtils.isEmpty(c1109b.c)) {
                if (TextUtils.isEmpty(aVar.f8604a.d.i)) {
                    return com.ubix.ssp.ad.e.a0.a0.a.k(14, "ICON资源链接异常");
                }
                if (TextUtils.isEmpty(aVar.f8604a.d.e)) {
                    return com.ubix.ssp.ad.e.a0.a0.a.k(15, "标题内容异常");
                }
                return null;
            }
            i2 = 10;
            str = "图片资源链接异常";
        } else if (i3 == 9001 || i3 == 9002) {
            com.ubix.ssp.ad.e.y.a.a.b.l lVar = bVar.k;
            if (lVar == null || TextUtils.isEmpty(lVar.c)) {
                i2 = 13;
                str = "封面图资源链接异常";
            } else {
                com.ubix.ssp.ad.e.y.a.a.b.l lVar2 = aVar.f8604a.d.k;
                if (lVar2 != null && !TextUtils.isEmpty(lVar2.b)) {
                    if (TextUtils.isEmpty(aVar.f8604a.d.i)) {
                        return com.ubix.ssp.ad.e.a0.a0.a.k(14, "ICON资源链接异常");
                    }
                    if (TextUtils.isEmpty(aVar.f8604a.d.e)) {
                        return com.ubix.ssp.ad.e.a0.a0.a.k(15, "标题内容异常");
                    }
                    return null;
                }
                i2 = 12;
                str = "视频资源链接异常";
            }
        } else {
            i2 = 16;
            str = "广告模板Id异常,或资源与模板不匹配";
        }
        return com.ubix.ssp.ad.e.a0.a0.a.k(i2, str);
    }

    @Override // com.ubix.ssp.ad.g.k.j
    public void j(int i2) {
    }

    protected boolean o(com.ubix.ssp.ad.d.a aVar) {
        b(aVar.f8604a.d.k.b, true);
        return true;
    }

    public void q(int i2) {
        super.w();
        super.u();
        try {
            com.ubix.ssp.ad.g.j jVar = this.C;
            if (jVar != null) {
                jVar.onAdLoadSucceed();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        if (N()) {
            o(this.F);
        } else {
            Q();
        }
    }

    @Override // com.ubix.ssp.ad.a
    public void x() {
        super.x();
    }
}
