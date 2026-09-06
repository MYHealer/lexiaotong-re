package com.huawei.openalliance.ad.views;

import android.content.Context;
import android.content.Intent;
import android.media.AudioFocusRequest;
import android.media.AudioManager;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.huawei.hms.ads.co;
import com.huawei.hms.ads.ej;
import com.huawei.hms.ads.fh;
import com.huawei.hms.ads.fu;
import com.huawei.hms.ads.fv;
import com.huawei.hms.ads.gp;
import com.huawei.hms.ads.hb;
import com.huawei.hms.ads.hl;
import com.huawei.hms.ads.hm;
import com.huawei.hms.ads.hx;
import com.huawei.hms.ads.hz;
import com.huawei.hms.ads.ia;
import com.huawei.hms.ads.il;
import com.huawei.hms.ads.iy;
import com.huawei.hms.ads.jf;
import com.huawei.hms.ads.kx;
import com.huawei.hms.ads.ky;
import com.huawei.hms.ads.ls;
import com.huawei.hms.ads.lx;
import com.huawei.hms.ads.ly;
import com.huawei.hms.ads.me;
import com.huawei.openalliance.ad.activity.ComplianceActivity;
import com.huawei.openalliance.ad.constant.bq;
import com.huawei.openalliance.ad.constant.bu;
import com.huawei.openalliance.ad.constant.cf;
import com.huawei.openalliance.ad.inter.data.AdContentData;
import com.huawei.openalliance.ad.inter.data.MaterialClickInfo;
import com.huawei.openalliance.ad.inter.data.n;
import com.huawei.openalliance.ad.inter.data.p;
import com.huawei.openalliance.ad.utils.ag;
import com.huawei.openalliance.ad.utils.bc;
import com.huawei.openalliance.ad.utils.bj;
import com.huawei.openalliance.ad.utils.bl;
import com.huawei.openalliance.ad.utils.t;
import com.huawei.openalliance.ad.utils.z;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class PPSPlacementView extends AutoScaleSizeRelativeLayout implements fu, ls, me, com.huawei.openalliance.ad.media.listener.f, com.huawei.openalliance.ad.media.listener.i {
    int B;
    protected hb Code;
    private boolean D;
    private ImageView E;
    private MaterialClickInfo F;
    private boolean G;
    private boolean H;
    protected hb I;
    private boolean J;
    private boolean K;
    private iy L;
    private MaterialClickInfo M;
    private List<View> N;
    private boolean O;
    private long P;
    private com.huawei.openalliance.ad.media.listener.e Q;
    private int R;
    private boolean T;
    private AudioManager U;
    protected hb V;
    private Object W;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private fv f4493a;
    private bu aa;
    private com.huawei.openalliance.ad.media.listener.g ab;
    private Handler ac;
    private com.huawei.openalliance.ad.media.listener.i ad;
    private View.OnTouchListener ae;
    private View.OnClickListener af;
    private AudioManager.OnAudioFocusChangeListener ag;
    private List<n> b;
    private n c;
    private n d;
    private int e;
    private a f;
    private List<View> g;
    private boolean h;
    private boolean i;
    private PlacementMediaView j;
    private PlacementMediaView k;
    private PlacementMediaView l;
    private com.huawei.openalliance.ad.media.listener.b m;
    private com.huawei.openalliance.ad.media.listener.f n;
    private com.huawei.openalliance.ad.media.listener.c o;
    private ly p;
    private lx q;
    private int[] r;
    private PlacementMediaView s;
    private boolean t;
    private boolean u;
    private int v;
    private int w;
    private boolean x;
    private boolean y;
    private int z;

    public interface a {
        void Code();
    }

    private static class b implements AudioManager.OnAudioFocusChangeListener {
        private WeakReference<PPSPlacementView> Code;

        public b(PPSPlacementView pPSPlacementView) {
            this.Code = new WeakReference<>(pPSPlacementView);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void Code(PPSPlacementView pPSPlacementView) {
            V(pPSPlacementView);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void I(PPSPlacementView pPSPlacementView) {
            fh.V("PPSPlacementView", "handleAudioFocusGain.");
            if (!pPSPlacementView.T || pPSPlacementView.s == null) {
                return;
            }
            pPSPlacementView.s.B();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void V(PPSPlacementView pPSPlacementView) {
            fh.V("PPSPlacementView", "handleAudioFocusLossTransientCanDuck soundMuted: " + pPSPlacementView.t);
            if (pPSPlacementView.t || pPSPlacementView.s == null) {
                return;
            }
            pPSPlacementView.s.I();
            pPSPlacementView.T = true;
        }

        @Override // android.media.AudioManager.OnAudioFocusChangeListener
        public void onAudioFocusChange(final int i) {
            bj.Code(new Runnable() { // from class: com.huawei.openalliance.ad.views.PPSPlacementView.b.1
                @Override // java.lang.Runnable
                public void run() {
                    PPSPlacementView pPSPlacementView = (PPSPlacementView) b.this.Code.get();
                    if (pPSPlacementView == null) {
                        return;
                    }
                    fh.V("PPSPlacementView", "onAudioFocusChange %d previous: %d", Integer.valueOf(i), Integer.valueOf(pPSPlacementView.R));
                    int i2 = i;
                    if (i2 == -3) {
                        b.this.V(pPSPlacementView);
                    } else if (i2 == -2 || i2 == -1) {
                        b.this.Code(pPSPlacementView);
                    } else if (i2 == 1 || i2 == 2) {
                        b.this.I(pPSPlacementView);
                    }
                    pPSPlacementView.R = i;
                }
            });
        }
    }

    public PPSPlacementView(Context context) {
        super(context);
        this.D = true;
        this.Code = new gp();
        this.V = new gp();
        this.I = new gp();
        this.b = new ArrayList(4);
        this.e = 0;
        this.h = false;
        this.i = false;
        this.m = null;
        this.n = null;
        this.o = null;
        this.p = null;
        this.q = null;
        this.r = null;
        this.t = false;
        this.u = false;
        this.v = -1;
        this.w = -1;
        this.x = false;
        this.y = false;
        this.z = -1;
        this.E = null;
        this.G = false;
        this.H = false;
        this.J = false;
        this.K = false;
        this.R = 0;
        this.T = false;
        this.B = -1;
        this.aa = new bu();
        this.ab = new com.huawei.openalliance.ad.media.listener.g() { // from class: com.huawei.openalliance.ad.views.PPSPlacementView.1
            @Override // com.huawei.openalliance.ad.media.listener.g
            public void Code() {
                fh.V("PPSPlacementView", "videoRenderStart");
                PPSPlacementView.this.k();
                if (!PPSPlacementView.this.H || PPSPlacementView.this.p == null) {
                    return;
                }
                PPSPlacementView.this.H = false;
                PPSPlacementView.this.J = true;
                fh.V("PPSPlacementView", "onMediaStart callback, playTime: %s", Integer.valueOf(PPSPlacementView.this.v));
                PPSPlacementView.this.p.Code(PPSPlacementView.this.v);
                PPSPlacementView.this.l();
            }
        };
        this.ac = new Handler(Looper.myLooper(), new Handler.Callback() { // from class: com.huawei.openalliance.ad.views.PPSPlacementView.12
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                int iD;
                n currentAd = PPSPlacementView.this.getCurrentAd();
                p currentMediaFile = PPSPlacementView.this.getCurrentMediaFile();
                String strZ = "";
                String strD = currentAd != null ? currentAd.d() : "";
                if (currentMediaFile != null) {
                    strZ = currentMediaFile.Z();
                    iD = (int) currentMediaFile.d();
                } else {
                    iD = 0;
                }
                fh.V("PPSPlacementView", "callback timeout: %s", strD);
                if (PPSPlacementView.this.s == null) {
                    return true;
                }
                fh.V("PPSPlacementView", "notify Error");
                PPSPlacementView.this.B(strD, strZ, iD);
                return true;
            }
        });
        this.ad = new com.huawei.openalliance.ad.media.listener.i() { // from class: com.huawei.openalliance.ad.views.PPSPlacementView.17
            @Override // com.huawei.openalliance.ad.media.listener.i
            public void Code(String str, String str2, int i) {
                PPSPlacementView pPSPlacementView;
                hb hbVar;
                hb hbVar2;
                if (fh.Code()) {
                    fh.Code("PPSPlacementView", "OM onSegmentMediaStart");
                }
                PPSPlacementView.this.O = false;
                if (PPSPlacementView.this.s instanceof PlacementVideoView) {
                    boolean zV = PPSPlacementView.this.aa.V(bu.a.SINGLE_INST);
                    if (i > 0) {
                        if (zV) {
                            hbVar2 = PPSPlacementView.this.I;
                        } else {
                            hbVar2 = PPSPlacementView.this.aa.V(bu.a.MAIN_VIEW) ? PPSPlacementView.this.Code : PPSPlacementView.this.V;
                        }
                        hbVar2.f();
                        return;
                    }
                    if (zV) {
                        pPSPlacementView = PPSPlacementView.this;
                        hbVar = pPSPlacementView.I;
                    } else if (PPSPlacementView.this.aa.V(bu.a.MAIN_VIEW)) {
                        pPSPlacementView = PPSPlacementView.this;
                        hbVar = pPSPlacementView.Code;
                    } else {
                        pPSPlacementView = PPSPlacementView.this;
                        hbVar = pPSPlacementView.V;
                    }
                    pPSPlacementView.Code(hbVar);
                }
            }

            @Override // com.huawei.openalliance.ad.media.listener.i
            public void Code(String str, String str2, int i, int i2) {
                hb hbVar;
                if ((str == null || str.equalsIgnoreCase(PPSPlacementView.this.getCurrentContentId())) && !PPSPlacementView.this.O && (PPSPlacementView.this.s instanceof PlacementVideoView)) {
                    if (PPSPlacementView.this.aa.V(bu.a.SINGLE_INST)) {
                        hbVar = PPSPlacementView.this.I;
                    } else {
                        hbVar = PPSPlacementView.this.aa.V(bu.a.MAIN_VIEW) ? PPSPlacementView.this.Code : PPSPlacementView.this.V;
                    }
                    hbVar.Code(i);
                }
            }

            @Override // com.huawei.openalliance.ad.media.listener.i
            public void Code(String str, String str2, int i, int i2, int i3) {
            }

            @Override // com.huawei.openalliance.ad.media.listener.i
            public void I(String str, String str2, int i) {
                hb hbVar;
                if (fh.Code()) {
                    fh.Code("PPSPlacementView", "OM onSegmentMediaStop");
                }
                if (str != null && !str.equalsIgnoreCase(PPSPlacementView.this.getCurrentContentId())) {
                    fh.V("PPSPlacementView", "OM onSegmentMediaStop not equals");
                    return;
                }
                if (PPSPlacementView.this.O) {
                    return;
                }
                PPSPlacementView.this.O = true;
                if (PPSPlacementView.this.s instanceof PlacementVideoView) {
                    if (PPSPlacementView.this.aa.V(bu.a.SINGLE_INST)) {
                        hbVar = PPSPlacementView.this.I;
                    } else {
                        hbVar = PPSPlacementView.this.aa.V(bu.a.MAIN_VIEW) ? PPSPlacementView.this.Code : PPSPlacementView.this.V;
                    }
                    hbVar.a();
                }
            }

            @Override // com.huawei.openalliance.ad.media.listener.i
            public void V(String str, String str2, int i) {
                hb hbVar;
                if (fh.Code()) {
                    fh.Code("PPSPlacementView", "OM onSegmentMediaPause");
                }
                if ((str == null || str.equalsIgnoreCase(PPSPlacementView.this.getCurrentContentId())) && (PPSPlacementView.this.s instanceof PlacementVideoView)) {
                    if (PPSPlacementView.this.aa.V(bu.a.SINGLE_INST)) {
                        hbVar = PPSPlacementView.this.I;
                    } else {
                        hbVar = PPSPlacementView.this.aa.V(bu.a.MAIN_VIEW) ? PPSPlacementView.this.Code : PPSPlacementView.this.V;
                    }
                    hbVar.e();
                }
            }

            @Override // com.huawei.openalliance.ad.media.listener.i
            public void Z(String str, String str2, int i) {
                hb hbVar;
                if (fh.Code()) {
                    fh.Code("PPSPlacementView", "OM onSegmentMediaCompletion");
                }
                if (str != null && !str.equalsIgnoreCase(PPSPlacementView.this.getCurrentContentId())) {
                    fh.V("PPSPlacementView", "OM onSegmentMediaCompletion not equals");
                    return;
                }
                if (PPSPlacementView.this.O) {
                    return;
                }
                PPSPlacementView.this.O = true;
                if (PPSPlacementView.this.s instanceof PlacementVideoView) {
                    if (PPSPlacementView.this.aa.V(bu.a.SINGLE_INST)) {
                        hbVar = PPSPlacementView.this.I;
                    } else {
                        hbVar = PPSPlacementView.this.aa.V(bu.a.MAIN_VIEW) ? PPSPlacementView.this.Code : PPSPlacementView.this.V;
                    }
                    hbVar.a();
                }
            }
        };
        this.ae = new View.OnTouchListener() { // from class: com.huawei.openalliance.ad.views.PPSPlacementView.22
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                fh.Code("PPSPlacementView", "clickable.OnTouchListener.ontouch");
                try {
                    int iCode = kx.Code(motionEvent);
                    if (iCode == 0) {
                        PPSPlacementView.this.F = kx.Code(view, motionEvent);
                        PPSPlacementView.this.F.Code(ky.Code(PPSPlacementView.this));
                    }
                    if (1 != iCode) {
                        return false;
                    }
                    kx.Code(view, motionEvent, null, PPSPlacementView.this.F);
                    return false;
                } catch (Throwable th) {
                    fh.I("PPSPlacementView", "clickable.OnTouchListener.ontouch exception : %s", th.getClass().getSimpleName());
                    return false;
                }
            }
        };
        this.af = new View.OnClickListener() { // from class: com.huawei.openalliance.ad.views.PPSPlacementView.23
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                bj.Code(new Runnable() { // from class: com.huawei.openalliance.ad.views.PPSPlacementView.23.1
                    @Override // java.lang.Runnable
                    public void run() {
                        PPSPlacementView.this.c();
                    }
                });
            }
        };
        this.ag = new b(this);
        Code(context);
    }

    public PPSPlacementView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.D = true;
        this.Code = new gp();
        this.V = new gp();
        this.I = new gp();
        this.b = new ArrayList(4);
        this.e = 0;
        this.h = false;
        this.i = false;
        this.m = null;
        this.n = null;
        this.o = null;
        this.p = null;
        this.q = null;
        this.r = null;
        this.t = false;
        this.u = false;
        this.v = -1;
        this.w = -1;
        this.x = false;
        this.y = false;
        this.z = -1;
        this.E = null;
        this.G = false;
        this.H = false;
        this.J = false;
        this.K = false;
        this.R = 0;
        this.T = false;
        this.B = -1;
        this.aa = new bu();
        this.ab = new com.huawei.openalliance.ad.media.listener.g() { // from class: com.huawei.openalliance.ad.views.PPSPlacementView.1
            @Override // com.huawei.openalliance.ad.media.listener.g
            public void Code() {
                fh.V("PPSPlacementView", "videoRenderStart");
                PPSPlacementView.this.k();
                if (!PPSPlacementView.this.H || PPSPlacementView.this.p == null) {
                    return;
                }
                PPSPlacementView.this.H = false;
                PPSPlacementView.this.J = true;
                fh.V("PPSPlacementView", "onMediaStart callback, playTime: %s", Integer.valueOf(PPSPlacementView.this.v));
                PPSPlacementView.this.p.Code(PPSPlacementView.this.v);
                PPSPlacementView.this.l();
            }
        };
        this.ac = new Handler(Looper.myLooper(), new Handler.Callback() { // from class: com.huawei.openalliance.ad.views.PPSPlacementView.12
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                int iD;
                n currentAd = PPSPlacementView.this.getCurrentAd();
                p currentMediaFile = PPSPlacementView.this.getCurrentMediaFile();
                String strZ = "";
                String strD = currentAd != null ? currentAd.d() : "";
                if (currentMediaFile != null) {
                    strZ = currentMediaFile.Z();
                    iD = (int) currentMediaFile.d();
                } else {
                    iD = 0;
                }
                fh.V("PPSPlacementView", "callback timeout: %s", strD);
                if (PPSPlacementView.this.s == null) {
                    return true;
                }
                fh.V("PPSPlacementView", "notify Error");
                PPSPlacementView.this.B(strD, strZ, iD);
                return true;
            }
        });
        this.ad = new com.huawei.openalliance.ad.media.listener.i() { // from class: com.huawei.openalliance.ad.views.PPSPlacementView.17
            @Override // com.huawei.openalliance.ad.media.listener.i
            public void Code(String str, String str2, int i) {
                PPSPlacementView pPSPlacementView;
                hb hbVar;
                hb hbVar2;
                if (fh.Code()) {
                    fh.Code("PPSPlacementView", "OM onSegmentMediaStart");
                }
                PPSPlacementView.this.O = false;
                if (PPSPlacementView.this.s instanceof PlacementVideoView) {
                    boolean zV = PPSPlacementView.this.aa.V(bu.a.SINGLE_INST);
                    if (i > 0) {
                        if (zV) {
                            hbVar2 = PPSPlacementView.this.I;
                        } else {
                            hbVar2 = PPSPlacementView.this.aa.V(bu.a.MAIN_VIEW) ? PPSPlacementView.this.Code : PPSPlacementView.this.V;
                        }
                        hbVar2.f();
                        return;
                    }
                    if (zV) {
                        pPSPlacementView = PPSPlacementView.this;
                        hbVar = pPSPlacementView.I;
                    } else if (PPSPlacementView.this.aa.V(bu.a.MAIN_VIEW)) {
                        pPSPlacementView = PPSPlacementView.this;
                        hbVar = pPSPlacementView.Code;
                    } else {
                        pPSPlacementView = PPSPlacementView.this;
                        hbVar = pPSPlacementView.V;
                    }
                    pPSPlacementView.Code(hbVar);
                }
            }

            @Override // com.huawei.openalliance.ad.media.listener.i
            public void Code(String str, String str2, int i, int i2) {
                hb hbVar;
                if ((str == null || str.equalsIgnoreCase(PPSPlacementView.this.getCurrentContentId())) && !PPSPlacementView.this.O && (PPSPlacementView.this.s instanceof PlacementVideoView)) {
                    if (PPSPlacementView.this.aa.V(bu.a.SINGLE_INST)) {
                        hbVar = PPSPlacementView.this.I;
                    } else {
                        hbVar = PPSPlacementView.this.aa.V(bu.a.MAIN_VIEW) ? PPSPlacementView.this.Code : PPSPlacementView.this.V;
                    }
                    hbVar.Code(i);
                }
            }

            @Override // com.huawei.openalliance.ad.media.listener.i
            public void Code(String str, String str2, int i, int i2, int i3) {
            }

            @Override // com.huawei.openalliance.ad.media.listener.i
            public void I(String str, String str2, int i) {
                hb hbVar;
                if (fh.Code()) {
                    fh.Code("PPSPlacementView", "OM onSegmentMediaStop");
                }
                if (str != null && !str.equalsIgnoreCase(PPSPlacementView.this.getCurrentContentId())) {
                    fh.V("PPSPlacementView", "OM onSegmentMediaStop not equals");
                    return;
                }
                if (PPSPlacementView.this.O) {
                    return;
                }
                PPSPlacementView.this.O = true;
                if (PPSPlacementView.this.s instanceof PlacementVideoView) {
                    if (PPSPlacementView.this.aa.V(bu.a.SINGLE_INST)) {
                        hbVar = PPSPlacementView.this.I;
                    } else {
                        hbVar = PPSPlacementView.this.aa.V(bu.a.MAIN_VIEW) ? PPSPlacementView.this.Code : PPSPlacementView.this.V;
                    }
                    hbVar.a();
                }
            }

            @Override // com.huawei.openalliance.ad.media.listener.i
            public void V(String str, String str2, int i) {
                hb hbVar;
                if (fh.Code()) {
                    fh.Code("PPSPlacementView", "OM onSegmentMediaPause");
                }
                if ((str == null || str.equalsIgnoreCase(PPSPlacementView.this.getCurrentContentId())) && (PPSPlacementView.this.s instanceof PlacementVideoView)) {
                    if (PPSPlacementView.this.aa.V(bu.a.SINGLE_INST)) {
                        hbVar = PPSPlacementView.this.I;
                    } else {
                        hbVar = PPSPlacementView.this.aa.V(bu.a.MAIN_VIEW) ? PPSPlacementView.this.Code : PPSPlacementView.this.V;
                    }
                    hbVar.e();
                }
            }

            @Override // com.huawei.openalliance.ad.media.listener.i
            public void Z(String str, String str2, int i) {
                hb hbVar;
                if (fh.Code()) {
                    fh.Code("PPSPlacementView", "OM onSegmentMediaCompletion");
                }
                if (str != null && !str.equalsIgnoreCase(PPSPlacementView.this.getCurrentContentId())) {
                    fh.V("PPSPlacementView", "OM onSegmentMediaCompletion not equals");
                    return;
                }
                if (PPSPlacementView.this.O) {
                    return;
                }
                PPSPlacementView.this.O = true;
                if (PPSPlacementView.this.s instanceof PlacementVideoView) {
                    if (PPSPlacementView.this.aa.V(bu.a.SINGLE_INST)) {
                        hbVar = PPSPlacementView.this.I;
                    } else {
                        hbVar = PPSPlacementView.this.aa.V(bu.a.MAIN_VIEW) ? PPSPlacementView.this.Code : PPSPlacementView.this.V;
                    }
                    hbVar.a();
                }
            }
        };
        this.ae = new View.OnTouchListener() { // from class: com.huawei.openalliance.ad.views.PPSPlacementView.22
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                fh.Code("PPSPlacementView", "clickable.OnTouchListener.ontouch");
                try {
                    int iCode = kx.Code(motionEvent);
                    if (iCode == 0) {
                        PPSPlacementView.this.F = kx.Code(view, motionEvent);
                        PPSPlacementView.this.F.Code(ky.Code(PPSPlacementView.this));
                    }
                    if (1 != iCode) {
                        return false;
                    }
                    kx.Code(view, motionEvent, null, PPSPlacementView.this.F);
                    return false;
                } catch (Throwable th) {
                    fh.I("PPSPlacementView", "clickable.OnTouchListener.ontouch exception : %s", th.getClass().getSimpleName());
                    return false;
                }
            }
        };
        this.af = new View.OnClickListener() { // from class: com.huawei.openalliance.ad.views.PPSPlacementView.23
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                bj.Code(new Runnable() { // from class: com.huawei.openalliance.ad.views.PPSPlacementView.23.1
                    @Override // java.lang.Runnable
                    public void run() {
                        PPSPlacementView.this.c();
                    }
                });
            }
        };
        this.ag = new b(this);
        Code(context);
    }

    public PPSPlacementView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.D = true;
        this.Code = new gp();
        this.V = new gp();
        this.I = new gp();
        this.b = new ArrayList(4);
        this.e = 0;
        this.h = false;
        this.i = false;
        this.m = null;
        this.n = null;
        this.o = null;
        this.p = null;
        this.q = null;
        this.r = null;
        this.t = false;
        this.u = false;
        this.v = -1;
        this.w = -1;
        this.x = false;
        this.y = false;
        this.z = -1;
        this.E = null;
        this.G = false;
        this.H = false;
        this.J = false;
        this.K = false;
        this.R = 0;
        this.T = false;
        this.B = -1;
        this.aa = new bu();
        this.ab = new com.huawei.openalliance.ad.media.listener.g() { // from class: com.huawei.openalliance.ad.views.PPSPlacementView.1
            @Override // com.huawei.openalliance.ad.media.listener.g
            public void Code() {
                fh.V("PPSPlacementView", "videoRenderStart");
                PPSPlacementView.this.k();
                if (!PPSPlacementView.this.H || PPSPlacementView.this.p == null) {
                    return;
                }
                PPSPlacementView.this.H = false;
                PPSPlacementView.this.J = true;
                fh.V("PPSPlacementView", "onMediaStart callback, playTime: %s", Integer.valueOf(PPSPlacementView.this.v));
                PPSPlacementView.this.p.Code(PPSPlacementView.this.v);
                PPSPlacementView.this.l();
            }
        };
        this.ac = new Handler(Looper.myLooper(), new Handler.Callback() { // from class: com.huawei.openalliance.ad.views.PPSPlacementView.12
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                int iD;
                n currentAd = PPSPlacementView.this.getCurrentAd();
                p currentMediaFile = PPSPlacementView.this.getCurrentMediaFile();
                String strZ = "";
                String strD = currentAd != null ? currentAd.d() : "";
                if (currentMediaFile != null) {
                    strZ = currentMediaFile.Z();
                    iD = (int) currentMediaFile.d();
                } else {
                    iD = 0;
                }
                fh.V("PPSPlacementView", "callback timeout: %s", strD);
                if (PPSPlacementView.this.s == null) {
                    return true;
                }
                fh.V("PPSPlacementView", "notify Error");
                PPSPlacementView.this.B(strD, strZ, iD);
                return true;
            }
        });
        this.ad = new com.huawei.openalliance.ad.media.listener.i() { // from class: com.huawei.openalliance.ad.views.PPSPlacementView.17
            @Override // com.huawei.openalliance.ad.media.listener.i
            public void Code(String str, String str2, int i2) {
                PPSPlacementView pPSPlacementView;
                hb hbVar;
                hb hbVar2;
                if (fh.Code()) {
                    fh.Code("PPSPlacementView", "OM onSegmentMediaStart");
                }
                PPSPlacementView.this.O = false;
                if (PPSPlacementView.this.s instanceof PlacementVideoView) {
                    boolean zV = PPSPlacementView.this.aa.V(bu.a.SINGLE_INST);
                    if (i2 > 0) {
                        if (zV) {
                            hbVar2 = PPSPlacementView.this.I;
                        } else {
                            hbVar2 = PPSPlacementView.this.aa.V(bu.a.MAIN_VIEW) ? PPSPlacementView.this.Code : PPSPlacementView.this.V;
                        }
                        hbVar2.f();
                        return;
                    }
                    if (zV) {
                        pPSPlacementView = PPSPlacementView.this;
                        hbVar = pPSPlacementView.I;
                    } else if (PPSPlacementView.this.aa.V(bu.a.MAIN_VIEW)) {
                        pPSPlacementView = PPSPlacementView.this;
                        hbVar = pPSPlacementView.Code;
                    } else {
                        pPSPlacementView = PPSPlacementView.this;
                        hbVar = pPSPlacementView.V;
                    }
                    pPSPlacementView.Code(hbVar);
                }
            }

            @Override // com.huawei.openalliance.ad.media.listener.i
            public void Code(String str, String str2, int i2, int i3) {
                hb hbVar;
                if ((str == null || str.equalsIgnoreCase(PPSPlacementView.this.getCurrentContentId())) && !PPSPlacementView.this.O && (PPSPlacementView.this.s instanceof PlacementVideoView)) {
                    if (PPSPlacementView.this.aa.V(bu.a.SINGLE_INST)) {
                        hbVar = PPSPlacementView.this.I;
                    } else {
                        hbVar = PPSPlacementView.this.aa.V(bu.a.MAIN_VIEW) ? PPSPlacementView.this.Code : PPSPlacementView.this.V;
                    }
                    hbVar.Code(i2);
                }
            }

            @Override // com.huawei.openalliance.ad.media.listener.i
            public void Code(String str, String str2, int i2, int i3, int i4) {
            }

            @Override // com.huawei.openalliance.ad.media.listener.i
            public void I(String str, String str2, int i2) {
                hb hbVar;
                if (fh.Code()) {
                    fh.Code("PPSPlacementView", "OM onSegmentMediaStop");
                }
                if (str != null && !str.equalsIgnoreCase(PPSPlacementView.this.getCurrentContentId())) {
                    fh.V("PPSPlacementView", "OM onSegmentMediaStop not equals");
                    return;
                }
                if (PPSPlacementView.this.O) {
                    return;
                }
                PPSPlacementView.this.O = true;
                if (PPSPlacementView.this.s instanceof PlacementVideoView) {
                    if (PPSPlacementView.this.aa.V(bu.a.SINGLE_INST)) {
                        hbVar = PPSPlacementView.this.I;
                    } else {
                        hbVar = PPSPlacementView.this.aa.V(bu.a.MAIN_VIEW) ? PPSPlacementView.this.Code : PPSPlacementView.this.V;
                    }
                    hbVar.a();
                }
            }

            @Override // com.huawei.openalliance.ad.media.listener.i
            public void V(String str, String str2, int i2) {
                hb hbVar;
                if (fh.Code()) {
                    fh.Code("PPSPlacementView", "OM onSegmentMediaPause");
                }
                if ((str == null || str.equalsIgnoreCase(PPSPlacementView.this.getCurrentContentId())) && (PPSPlacementView.this.s instanceof PlacementVideoView)) {
                    if (PPSPlacementView.this.aa.V(bu.a.SINGLE_INST)) {
                        hbVar = PPSPlacementView.this.I;
                    } else {
                        hbVar = PPSPlacementView.this.aa.V(bu.a.MAIN_VIEW) ? PPSPlacementView.this.Code : PPSPlacementView.this.V;
                    }
                    hbVar.e();
                }
            }

            @Override // com.huawei.openalliance.ad.media.listener.i
            public void Z(String str, String str2, int i2) {
                hb hbVar;
                if (fh.Code()) {
                    fh.Code("PPSPlacementView", "OM onSegmentMediaCompletion");
                }
                if (str != null && !str.equalsIgnoreCase(PPSPlacementView.this.getCurrentContentId())) {
                    fh.V("PPSPlacementView", "OM onSegmentMediaCompletion not equals");
                    return;
                }
                if (PPSPlacementView.this.O) {
                    return;
                }
                PPSPlacementView.this.O = true;
                if (PPSPlacementView.this.s instanceof PlacementVideoView) {
                    if (PPSPlacementView.this.aa.V(bu.a.SINGLE_INST)) {
                        hbVar = PPSPlacementView.this.I;
                    } else {
                        hbVar = PPSPlacementView.this.aa.V(bu.a.MAIN_VIEW) ? PPSPlacementView.this.Code : PPSPlacementView.this.V;
                    }
                    hbVar.a();
                }
            }
        };
        this.ae = new View.OnTouchListener() { // from class: com.huawei.openalliance.ad.views.PPSPlacementView.22
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                fh.Code("PPSPlacementView", "clickable.OnTouchListener.ontouch");
                try {
                    int iCode = kx.Code(motionEvent);
                    if (iCode == 0) {
                        PPSPlacementView.this.F = kx.Code(view, motionEvent);
                        PPSPlacementView.this.F.Code(ky.Code(PPSPlacementView.this));
                    }
                    if (1 != iCode) {
                        return false;
                    }
                    kx.Code(view, motionEvent, null, PPSPlacementView.this.F);
                    return false;
                } catch (Throwable th) {
                    fh.I("PPSPlacementView", "clickable.OnTouchListener.ontouch exception : %s", th.getClass().getSimpleName());
                    return false;
                }
            }
        };
        this.af = new View.OnClickListener() { // from class: com.huawei.openalliance.ad.views.PPSPlacementView.23
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                bj.Code(new Runnable() { // from class: com.huawei.openalliance.ad.views.PPSPlacementView.23.1
                    @Override // java.lang.Runnable
                    public void run() {
                        PPSPlacementView.this.c();
                    }
                });
            }
        };
        this.ag = new b(this);
        Code(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B(final String str, final String str2, final int i) {
        bj.Code(new Runnable() { // from class: com.huawei.openalliance.ad.views.PPSPlacementView.16
            @Override // java.lang.Runnable
            public void run() {
                PPSPlacementView.this.Code(str, str2, i, -1, -1);
            }
        });
    }

    private hb Code(bu buVar) {
        if (buVar.V(bu.a.SINGLE_INST)) {
            this.I.I();
            gp gpVar = new gp();
            this.I = gpVar;
            return gpVar;
        }
        if (buVar.V(bu.a.MAIN_VIEW)) {
            this.Code.I();
            gp gpVar2 = new gp();
            this.Code = gpVar2;
            return gpVar2;
        }
        this.V.I();
        gp gpVar3 = new gp();
        this.V = gpVar3;
        return gpVar3;
    }

    private PlacementMediaView Code(n nVar) {
        if (nVar == null) {
            fh.I("PPSPlacementView", "create media view with null ad");
            return null;
        }
        fh.Code("PPSPlacementView", "create media view for content:%s", nVar.d());
        if (nVar.V()) {
            fh.V("PPSPlacementView", "create video view");
            return new PlacementVideoView(getContext());
        }
        if (nVar.I()) {
            fh.V("PPSPlacementView", "create image view");
            return new PlacementImageView(getContext());
        }
        fh.V("PPSPlacementView", "return image view for default");
        return new PlacementImageView(getContext());
    }

    private void Code(int i) {
        int i2;
        if (this.u && (i2 = this.v) >= 0) {
            this.w = i - i2;
            this.u = false;
        }
        this.v = -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Code(long j) {
        if (this.K) {
            return;
        }
        this.K = true;
        fh.V("PPSPlacementView", "timeout, submit: %s", Long.valueOf(j));
        this.ac.sendEmptyMessageDelayed(1001, j);
    }

    private void Code(Context context) {
        bu buVar;
        bu.a aVar;
        setBackgroundColor(-16777216);
        setUseRatioInMatchParentMode(false);
        this.L = new il(context, this);
        this.f4493a = new fv(this, this);
        this.U = (AudioManager) context.getSystemService("audio");
        if (ej.Code(context).al()) {
            buVar = this.aa;
            aVar = bu.a.SINGLE_INST;
        } else {
            buVar = this.aa;
            aVar = bu.a.MAIN_VIEW;
        }
        buVar.Code(aVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Code(hb hbVar) {
        if (hbVar == null || getCurrentAd() == null || getCurrentAd().S() == null) {
            return;
        }
        fh.V("PPSPlacementView", "om start");
        hbVar.Code(getCurrentAd().S().d(), !"y".equals(getCurrentAd().S().S()));
    }

    private void Code(hb hbVar, PlacementMediaView placementMediaView) {
        if (placementMediaView instanceof PlacementVideoView) {
            hbVar.Code(ia.Code(0.0f, true, hz.STANDALONE));
            ((PlacementVideoView) placementMediaView).Code(hbVar);
        } else if (placementMediaView instanceof PlacementImageView) {
            hbVar.L();
        }
    }

    private void Code(bu buVar, com.huawei.openalliance.ad.inter.data.d dVar, PlacementMediaView placementMediaView) {
        if (dVar instanceof n) {
            AdContentData adContentDataQ = ((n) dVar).q();
            hb hbVarCode = Code(buVar);
            hbVarCode.Code(getContext(), adContentDataQ, placementMediaView, true);
            Z(hbVarCode);
            hbVarCode.Z();
            Code(hbVarCode, placementMediaView);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Code(PlacementMediaView placementMediaView) {
        if (placementMediaView == null) {
            fh.I("PPSPlacementView", "show ad with null media view");
            return;
        }
        this.w = -1;
        fh.Code("PPSPlacementView", "showAd:%s", Integer.valueOf(this.e));
        this.s = placementMediaView;
        placementMediaView.setAlpha(1.0f);
        placementMediaView.Code(true, this.t);
        if (!isShown()) {
            fh.I("PPSPlacementView", "view not visible, pause.");
            pauseView();
        }
        Code(placementMediaView.getDuration() * 2);
    }

    private void Code(final PlacementMediaView placementMediaView, boolean z) {
        if (placementMediaView != null) {
            com.huawei.openalliance.ad.inter.data.h placementAd = placementMediaView.getPlacementAd();
            fh.V("PPSPlacementView", "unloadMediaView, contentId: %s, remove: %s", placementAd != null ? placementAd.d() : null, Boolean.valueOf(z));
            placementMediaView.F();
            placementMediaView.setPlacementAd(null);
            final ViewParent parent = placementMediaView.getParent();
            if (parent == null || !(parent instanceof ViewGroup)) {
                return;
            }
            placementMediaView.setAlpha(0.0f);
            if (z) {
                bj.Code(new Runnable() { // from class: com.huawei.openalliance.ad.views.PPSPlacementView.20
                    @Override // java.lang.Runnable
                    public void run() {
                        ViewParent viewParent = parent;
                        if (viewParent != null) {
                            ((ViewGroup) viewParent).removeView(placementMediaView);
                        }
                    }
                });
            }
        }
    }

    private void Code(Long l, Integer num, Integer num2) {
        hb hbVar;
        n currentAd = getCurrentAd();
        if (currentAd == null) {
            return;
        }
        boolean zCode = com.huawei.openalliance.ad.utils.c.Code(currentAd.i_(), num2);
        if (!currentAd.L() || (zCode && !currentAd.ab())) {
            this.L.Code(bc.Code(Long.valueOf(this.P)));
            this.L.Code(this.P);
            this.L.Code(l.longValue(), num.intValue(), num2);
            if (zCode) {
                currentAd.C(true);
            }
            if (currentAd.L()) {
                return;
            }
            currentAd.I(true);
            if (this.aa.V(bu.a.SINGLE_INST)) {
                hbVar = this.I;
            } else {
                hbVar = this.aa.V(bu.a.MAIN_VIEW) ? this.Code : this.V;
            }
            I(hbVar);
        }
    }

    private boolean Code(PlacementMediaView placementMediaView, n nVar) {
        return ((placementMediaView instanceof PlacementVideoView) && nVar.V()) || ((placementMediaView instanceof PlacementImageView) && nVar.I());
    }

    private void I(long j, int i) {
        n currentAd = getCurrentAd();
        if (currentAd == null || this.h || j <= currentAd.x()) {
            return;
        }
        this.h = true;
        Code(Long.valueOf(j), Integer.valueOf(i), (Integer) null);
    }

    private void I(hb hbVar) {
        if (hbVar != null) {
            hbVar.D();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void I(List<com.huawei.openalliance.ad.inter.data.h> list) {
        p pVarS;
        p pVarS2;
        if (ag.Code(list)) {
            return;
        }
        ArrayList arrayList = new ArrayList(list);
        this.b.clear();
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            com.huawei.openalliance.ad.inter.data.h hVar = (com.huawei.openalliance.ad.inter.data.h) arrayList.get(i);
            if ((hVar instanceof n) && (pVarS2 = hVar.S()) != null) {
                String strZ = pVarS2.Z();
                if (2 == pVarS2.c() || (strZ != null && strZ.startsWith(cf.CONTENT.toString()))) {
                    this.b.add((n) hVar);
                } else {
                    fh.V("PPSPlacementView", "has no cache, discard " + hVar.d());
                }
            }
        }
        int size2 = this.b.size();
        this.r = new int[size2];
        if (ag.Code(this.b)) {
            return;
        }
        Collections.sort(this.b);
        for (int i2 = 0; i2 < size2; i2++) {
            n nVar = this.b.get(i2);
            int iD = (nVar == null || (pVarS = nVar.S()) == null) ? 0 : (int) pVarS.d();
            int[] iArr = this.r;
            if (i2 == 0) {
                iArr[i2] = iD;
            } else {
                iArr[i2] = iD + iArr[i2 - 1];
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L() {
        if (this.x) {
            return;
        }
        this.x = true;
        this.L.V();
    }

    private PlacementMediaView V(PlacementMediaView placementMediaView, n nVar) {
        if (nVar == null) {
            return null;
        }
        fh.Code("PPSPlacementView", "init media view for content:%s", nVar.d());
        boolean z = true;
        if (Code(placementMediaView, nVar)) {
            Code(placementMediaView, false);
        } else {
            Code(placementMediaView, true);
            placementMediaView = null;
        }
        if (placementMediaView == null) {
            placementMediaView = Code(nVar);
        } else {
            z = false;
        }
        if (placementMediaView != null) {
            fh.V("PPSPlacementView", "meida view created");
            placementMediaView.Code((com.huawei.openalliance.ad.media.listener.i) this);
            com.huawei.openalliance.ad.media.listener.b bVar = this.m;
            if (bVar != null) {
                placementMediaView.Code(bVar);
            }
            com.huawei.openalliance.ad.media.listener.g gVar = this.ab;
            if (gVar != null) {
                placementMediaView.Code(gVar);
            }
            com.huawei.openalliance.ad.media.listener.f fVar = this.n;
            if (fVar != null) {
                placementMediaView.Code(fVar);
            }
            placementMediaView.Code((com.huawei.openalliance.ad.media.listener.f) this);
            com.huawei.openalliance.ad.media.listener.c cVar = this.o;
            if (cVar != null) {
                placementMediaView.Code(cVar);
            }
            com.huawei.openalliance.ad.media.listener.i iVar = this.ad;
            if (iVar != null) {
                placementMediaView.I(iVar);
            }
            if (z) {
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
                layoutParams.addRule(13);
                addView(placementMediaView, layoutParams);
            }
            placementMediaView.setAlpha(0.0f);
            placementMediaView.setPlacementAd(nVar);
            placementMediaView.setAudioFocusType(2);
        }
        return placementMediaView;
    }

    private void V(hb hbVar) {
        if (hbVar != null) {
            hbVar.Code(hx.CLICK);
        }
    }

    private void V(boolean z) {
        if (this.e < this.b.size() - 1) {
            h();
            if (z) {
                return;
            }
            g();
        }
    }

    private void Z(hb hbVar) {
        List<View> list;
        hm hmVarV = hbVar.V();
        if (hmVarV == null || (list = this.N) == null || list.size() <= 0) {
            return;
        }
        Iterator<View> it = this.N.iterator();
        while (it.hasNext()) {
            hmVarV.Code(it.next(), hl.OTHER, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        bu buVar;
        n nVar;
        PlacementMediaView placementMediaView;
        fh.Code("PPSPlacementView", "initPlacementView, singlePlayerInst: %s", Boolean.valueOf(this.aa.V(bu.a.SINGLE_INST)));
        this.f4493a.V(this.c.x(), this.c.y());
        this.L.Code(this.c);
        if (this.aa.V(bu.a.SINGLE_INST)) {
            PlacementMediaView placementMediaViewV = V(this.l, this.c);
            this.l = placementMediaViewV;
            placementMediaViewV.setMediaPlayerReleaseListener(this.Q);
            buVar = new bu(bu.a.SINGLE_INST);
            nVar = this.c;
            placementMediaView = this.l;
        } else {
            this.j = V(this.j, this.c);
            Code(new bu(bu.a.MAIN_VIEW), this.c, this.j);
            this.k = V(this.k, this.d);
            buVar = new bu(bu.a.BACKUP_VIEW);
            nVar = this.d;
            placementMediaView = this.k;
        }
        Code(buVar, nVar, placementMediaView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        String strValueOf = String.valueOf(this.P);
        this.L.Code(strValueOf);
        this.L.Code(this.P);
        PlacementMediaView placementMediaView = this.l;
        if (placementMediaView != null) {
            placementMediaView.Code(strValueOf);
            this.l.Code(this.P);
        }
        PlacementMediaView placementMediaView2 = this.j;
        if (placementMediaView2 != null) {
            placementMediaView2.Code(strValueOf);
            this.j.Code(this.P);
        }
        PlacementMediaView placementMediaView3 = this.k;
        if (placementMediaView3 != null) {
            placementMediaView3.Code(strValueOf);
            this.k.Code(this.P);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        hb hbVar;
        if (this.D) {
            t.V();
            this.D = false;
            fh.V("PPSPlacementView", "onClick");
            Code((Integer) 1);
            if (this.M == null) {
                this.M = this.F;
            }
            this.L.Code(this.M);
            this.F = null;
            this.M = null;
            if (this.aa.V(bu.a.SINGLE_INST)) {
                hbVar = this.I;
            } else {
                hbVar = this.aa.V(bu.a.MAIN_VIEW) ? this.Code : this.V;
            }
            V(hbVar);
            a aVar = this.f;
            if (aVar != null) {
                aVar.Code();
            }
            bj.Code(new Runnable() { // from class: com.huawei.openalliance.ad.views.PPSPlacementView.2
                @Override // java.lang.Runnable
                public void run() {
                    PPSPlacementView.this.D = true;
                }
            }, 500L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(this);
        this.g = arrayList;
        V(arrayList);
    }

    private boolean f() {
        return this.e == this.b.size() - 1;
    }

    private void g() {
        bu buVar;
        n nVar;
        PlacementMediaView placementMediaView;
        this.e++;
        fh.V("PPSPlacementView", "load " + this.e + " ad");
        if (getNextAd() == null || this.aa.V(bu.a.SINGLE_INST)) {
            return;
        }
        if (Math.abs(this.j.getAlpha() - 1.0f) < 0.01f) {
            n nextAd = getNextAd();
            this.d = nextAd;
            this.k = V(this.k, nextAd);
            buVar = new bu(bu.a.BACKUP_VIEW);
            nVar = this.d;
            placementMediaView = this.k;
        } else {
            n nextAd2 = getNextAd();
            this.c = nextAd2;
            this.j = V(this.j, nextAd2);
            buVar = new bu(bu.a.MAIN_VIEW);
            nVar = this.c;
            placementMediaView = this.j;
        }
        Code(buVar, nVar, placementMediaView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public n getCurrentAd() {
        if (this.e < this.b.size()) {
            return this.b.get(this.e);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long getCurrentAdDuration() {
        p pVarS;
        n currentAd = getCurrentAd();
        if (currentAd == null || (pVarS = currentAd.S()) == null) {
            return 0L;
        }
        return pVarS.d();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getCurrentContentId() {
        n currentAd = getCurrentAd();
        if (currentAd == null) {
            return null;
        }
        return currentAd.d();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public p getCurrentMediaFile() {
        if (getCurrentAd() != null) {
            return getCurrentAd().S();
        }
        return null;
    }

    private com.huawei.openalliance.ad.media.b getCurrentMediaState() {
        PlacementMediaView placementMediaView = this.s;
        if (placementMediaView == null) {
            return null;
        }
        return placementMediaView.getMediaState();
    }

    private int getCurrentPlayTime() {
        int i = this.e;
        if (i < 1) {
            return 0;
        }
        return this.r[i - 1];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public n getNextAd() {
        if (this.e < this.b.size() - 1) {
            return this.b.get(this.e + 1);
        }
        return null;
    }

    private void h() {
        PlacementMediaView placementMediaView;
        n nextAd = getNextAd();
        if (nextAd != null) {
            this.f4493a.V(nextAd.x(), nextAd.y());
        }
        this.L.Code(nextAd);
        this.L.Z();
        if (this.aa.V(bu.a.SINGLE_INST)) {
            this.l = V(this.l, nextAd);
            Code(new bu(bu.a.SINGLE_INST), nextAd, this.l);
            Code(this.l);
        } else {
            if (Math.abs(this.j.getAlpha() - 1.0f) < 0.01f) {
                this.aa.Code(bu.a.BACKUP_VIEW);
                Code(this.k);
                placementMediaView = this.j;
            } else {
                this.aa.Code(bu.a.MAIN_VIEW);
                Code(this.j);
                placementMediaView = this.k;
            }
            Code(placementMediaView, false);
        }
        this.f4493a.b();
        fh.V("PPSPlacementView", "show " + this.e + " ad");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        this.K = false;
        fh.V("PPSPlacementView", "timeout, cancel.");
        this.ac.removeMessages(1001);
    }

    private void j() {
        if (this.E == null) {
            return;
        }
        try {
            fh.V("PPSPlacementView", "showLastFrame");
            this.G = false;
            this.E.setVisibility(0);
            this.E.setScaleType(ImageView.ScaleType.FIT_CENTER);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            layoutParams.addRule(13);
            addView(this.E, layoutParams);
        } catch (Throwable unused) {
            fh.I("PPSPlacementView", "showLastFrame error.");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        bj.Code(new Runnable() { // from class: com.huawei.openalliance.ad.views.PPSPlacementView.15
            @Override // java.lang.Runnable
            public void run() {
                if (PPSPlacementView.this.E == null) {
                    return;
                }
                try {
                    fh.V("PPSPlacementView", "hide last frame.");
                    PPSPlacementView.this.E.setVisibility(8);
                    PPSPlacementView pPSPlacementView = PPSPlacementView.this;
                    pPSPlacementView.removeView(pPSPlacementView.E);
                    PPSPlacementView.this.E = null;
                    PPSPlacementView.this.G = true;
                } catch (Throwable unused) {
                    fh.I("PPSPlacementView", "hideLastFrame error.");
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l() {
        String str;
        if (!n()) {
            fh.I("PPSPlacementView", "audio focus is not needed");
            return;
        }
        try {
            fh.V("PPSPlacementView", "requestAudioFocus");
            AudioFocusRequest audioFocusRequestBuild = new AudioFocusRequest.Builder(2).setOnAudioFocusChangeListener(this.ag).build();
            this.W = audioFocusRequestBuild;
            this.U.requestAudioFocus(audioFocusRequestBuild);
        } catch (IllegalStateException unused) {
            str = "requestAudioFocus IllegalStateException";
            fh.I("PPSPlacementView", str);
        } catch (Exception e) {
            str = "requestAudioFocus " + e.getClass().getSimpleName();
            fh.I("PPSPlacementView", str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void m() {
        String str;
        try {
            try {
                fh.V("PPSPlacementView", "abandonAudioFocus");
                Object obj = this.W;
                if (obj instanceof AudioFocusRequest) {
                    this.U.abandonAudioFocusRequest((AudioFocusRequest) obj);
                }
                this.W = null;
            } catch (IllegalStateException unused) {
                str = "abandonAudioFocus IllegalStateException";
                fh.I("PPSPlacementView", str);
            } catch (Exception e) {
                str = "abandonAudioFocus " + e.getClass().getSimpleName();
                fh.I("PPSPlacementView", str);
            }
        } finally {
            this.T = false;
            this.R = 0;
        }
    }

    private boolean n() {
        fh.V("PPSPlacementView", "isNeedAudioFocus type: %s soundMute: %s", Integer.valueOf(this.z), Boolean.valueOf(this.t));
        int i = this.z;
        if (i == 0) {
            return true;
        }
        if (i == 2) {
            return false;
        }
        return (i == 1 && this.t) ? false : true;
    }

    public void C() {
        bj.Code(new Runnable() { // from class: com.huawei.openalliance.ad.views.PPSPlacementView.7
            @Override // java.lang.Runnable
            public void run() {
                boolean z;
                fh.V("PPSPlacementView", "muteSound");
                boolean z2 = true;
                PPSPlacementView.this.t = true;
                if (PPSPlacementView.this.z == 1) {
                    PPSPlacementView.this.m();
                }
                if (PPSPlacementView.this.j != null) {
                    PPSPlacementView.this.j.I();
                    z = true;
                } else {
                    z = false;
                }
                if (PPSPlacementView.this.k != null) {
                    PPSPlacementView.this.k.I();
                } else {
                    z2 = z;
                }
                if (PPSPlacementView.this.l != null) {
                    PPSPlacementView.this.l.I();
                } else if (!z2) {
                    return;
                }
                PPSPlacementView.this.L.Code(PPSPlacementView.this.t);
            }
        });
    }

    @Override // com.huawei.openalliance.ad.media.listener.f
    public void Code() {
        fh.V("PPSPlacementView", "onMute");
        this.t = true;
    }

    @Override // com.huawei.hms.ads.fu
    public void Code(long j, int i) {
        I(this.w, i);
    }

    public void Code(lx lxVar) {
        if (lxVar == null) {
            return;
        }
        this.q = lxVar;
    }

    public void Code(ly lyVar) {
        if (lyVar == null) {
            return;
        }
        this.p = lyVar;
    }

    public void Code(com.huawei.openalliance.ad.media.listener.f fVar) {
        if (fVar == null) {
            return;
        }
        PlacementMediaView placementMediaView = this.j;
        if (placementMediaView != null) {
            placementMediaView.Code(fVar);
        } else {
            this.n = fVar;
        }
    }

    public void Code(Integer num) {
        Code(Long.valueOf(System.currentTimeMillis() - this.f4493a.Z()), Integer.valueOf(this.f4493a.I()), num);
    }

    @Override // com.huawei.openalliance.ad.media.listener.i
    public void Code(String str, String str2, int i) {
        fh.V("PPSPlacementView", "onSegmentMediaStart, contentId: %s, url: %s", str, bl.Code(str2));
        this.u = true;
        this.v = i;
        PlacementMediaView placementMediaView = this.s;
        if (placementMediaView != null) {
            placementMediaView.setAlpha(1.0f);
        }
        if (this.p != null && this.e == 0) {
            fh.V("PPSPlacementView", "need notify media start.");
            this.H = true;
        }
        if (this.q != null && this.s != null) {
            fh.V("PPSPlacementView", "mediaChange callback.");
            this.q.Code(this.s.getPlacementAd());
        }
        PlacementMediaView placementMediaView2 = this.s;
        if (placementMediaView2 instanceof PlacementVideoView) {
            placementMediaView2.C();
        }
    }

    /* JADX WARN: Code duplicated, block: B:34:0x0071  */
    /* JADX WARN: Code duplicated, block: B:36:0x0076  */
    /* JADX WARN: Code duplicated, block: B:41:0x0090  */
    /* JADX WARN: Code duplicated, block: B:53:0x00b4  */
    /* JADX WARN: Code duplicated, block: B:55:0x00c2  */
    /* JADX WARN: Code duplicated, block: B:58:? A[RETURN, SYNTHETIC] */
    @Override // com.huawei.openalliance.ad.media.listener.i
    public void Code(String str, String str2, int i, int i2) {
        int i3;
        boolean z;
        int currentPlayTime;
        int i4;
        ly lyVar;
        com.huawei.openalliance.ad.media.listener.i iVar;
        ly lyVar2;
        com.huawei.openalliance.ad.media.b currentMediaState = getCurrentMediaState();
        if (currentMediaState != null && currentMediaState.V(com.huawei.openalliance.ad.media.d.PLAYING)) {
            fh.I("PPSPlacementView", "progress callback on nonPlaying state.");
            return;
        }
        String currentContentId = getCurrentContentId();
        if (str == null || str.equalsIgnoreCase(currentContentId)) {
            long currentAdDuration = getCurrentAdDuration();
            boolean z2 = this.u;
            if (z2 || this.v >= 0) {
                if (z2 && (i3 = this.v) >= 0) {
                    int i5 = i2 - i3;
                    this.w = i5;
                    I(i5, this.f4493a.I());
                    z = ((long) this.w) >= getCurrentAdDuration();
                    iy iyVar = this.L;
                    if (iyVar != null) {
                        iyVar.Code(getContext(), i2, currentAdDuration);
                    }
                }
                if (this.p == null || this.u || i2 > 0) {
                    if (i2 > currentAdDuration && currentAdDuration > 0) {
                        i2 = (int) currentAdDuration;
                    }
                    currentPlayTime = getCurrentPlayTime() + i2;
                    this.B = currentPlayTime;
                    int[] iArr = this.r;
                    i4 = currentPlayTime / iArr[iArr.length - 1];
                    lyVar = this.p;
                    if (lyVar != null) {
                        lyVar.Code(i4, currentPlayTime);
                    }
                }
                if (i2 > 0 && !this.G) {
                    k();
                }
                if (i2 > 0 && this.H && (lyVar2 = this.p) != null) {
                    this.H = false;
                    this.J = true;
                    lyVar2.Code(this.v);
                    l();
                }
                if (z) {
                    fh.V("PPSPlacementView", "time countdown finish, manual stop.");
                    this.s.F();
                    iVar = this.ad;
                    if (iVar != null) {
                        iVar.Z(str, str2, i2);
                    }
                    Z(str, str2, i2);
                }
            }
            this.v = i2;
            this.u = true;
            z = false;
            if (this.p == null) {
                if (i2 > currentAdDuration) {
                    i2 = (int) currentAdDuration;
                }
                currentPlayTime = getCurrentPlayTime() + i2;
                this.B = currentPlayTime;
                int[] iArr2 = this.r;
                i4 = currentPlayTime / iArr2[iArr2.length - 1];
                lyVar = this.p;
                if (lyVar != null) {
                    lyVar.Code(i4, currentPlayTime);
                }
            } else {
                if (i2 > currentAdDuration) {
                    i2 = (int) currentAdDuration;
                }
                currentPlayTime = getCurrentPlayTime() + i2;
                this.B = currentPlayTime;
                int[] iArr3 = this.r;
                i4 = currentPlayTime / iArr3[iArr3.length - 1];
                lyVar = this.p;
                if (lyVar != null) {
                    lyVar.Code(i4, currentPlayTime);
                }
            }
            if (i2 > 0) {
                k();
            }
            if (i2 > 0) {
                this.H = false;
                this.J = true;
                lyVar2.Code(this.v);
                l();
            }
            if (z) {
                fh.V("PPSPlacementView", "time countdown finish, manual stop.");
                this.s.F();
                iVar = this.ad;
                if (iVar != null) {
                    iVar.Z(str, str2, i2);
                }
                Z(str, str2, i2);
            }
        }
    }

    @Override // com.huawei.openalliance.ad.media.listener.i
    public void Code(String str, String str2, int i, int i2, int i3) {
        PlacementMediaView placementMediaView;
        p pVarS;
        fh.V("PPSPlacementView", "onSegmentMediaError, contentId: %s, url: %s", str, bl.Code(str2));
        String currentContentId = getCurrentContentId();
        if (str != null && !str.equalsIgnoreCase(currentContentId)) {
            fh.V("PPSPlacementView", "onError, contentId not match, currentConentId: %s", currentContentId);
            return;
        }
        k();
        i();
        fh.I("PPSPlacementView", "onSegmentMediaError:" + bl.Code(str2) + ", playTime:" + i + ",errorCode:" + i2 + ",extra:" + i3);
        Code(i);
        if (this.p != null) {
            int currentPlayTime = getCurrentPlayTime() + i;
            fh.V("PPSPlacementView", "mediaError callback, playedTime: %s", Integer.valueOf(currentPlayTime));
            this.p.Code(currentPlayTime, i2, i3);
        }
        if (!this.J) {
            fh.V("PPSPlacementView", "error before start callback.");
            this.H = true;
        }
        this.f4493a.c();
        this.s.Code(i);
        n currentAd = getCurrentAd();
        if (currentAd != null && (pVarS = currentAd.S()) != null) {
            this.L.Code(pVarS.Z(), i2, i3, currentAd);
        }
        boolean zF = f();
        V(zF);
        if (this.p == null || !zF || this.r.length <= 0) {
            return;
        }
        fh.V("PPSPlacementView", "last ad play error");
        ly lyVar = this.p;
        int[] iArr = this.r;
        lyVar.Z(iArr[iArr.length - 1]);
        if (!this.aa.V(bu.a.SINGLE_INST) || (placementMediaView = this.l) == null) {
            return;
        }
        placementMediaView.V();
    }

    public void Code(final List<com.huawei.openalliance.ad.inter.data.h> list) {
        bj.Code(new Runnable() { // from class: com.huawei.openalliance.ad.views.PPSPlacementView.18
            @Override // java.lang.Runnable
            public void run() {
                StringBuilder sb = new StringBuilder("register:");
                List list2 = list;
                fh.V("PPSPlacementView", sb.append(list2 == null ? 0 : list2.size()).toString());
                PPSPlacementView.this.I((List<com.huawei.openalliance.ad.inter.data.h>) list);
                if (ag.Code(list) || ag.Code(PPSPlacementView.this.b)) {
                    return;
                }
                PPSPlacementView.this.e = 0;
                PPSPlacementView pPSPlacementView = PPSPlacementView.this;
                pPSPlacementView.c = pPSPlacementView.getCurrentAd();
                PPSPlacementView pPSPlacementView2 = PPSPlacementView.this;
                pPSPlacementView2.d = pPSPlacementView2.getNextAd();
                PPSPlacementView.this.a();
                PPSPlacementView.this.e();
                PlacementMediaView placementMediaView = PPSPlacementView.this.aa.V(bu.a.SINGLE_INST) ? PPSPlacementView.this.l : PPSPlacementView.this.j;
                PPSPlacementView.this.b();
                PPSPlacementView.this.Code(placementMediaView);
                if (PPSPlacementView.this.y) {
                    PPSPlacementView.this.L();
                }
            }
        });
    }

    public void D() {
        this.p = null;
    }

    public void F() {
        this.q = null;
    }

    @Override // com.huawei.hms.ads.fu
    public void I() {
        hb hbVar;
        this.y = true;
        this.h = false;
        this.i = false;
        long jCode = z.Code();
        this.P = jCode;
        fh.Code("PPSPlacementView", "onViewPhysicalShowStart: %s", Long.valueOf(jCode));
        n currentAd = getCurrentAd();
        if (currentAd != null) {
            currentAd.I(false);
            currentAd.C(false);
        }
        b();
        if (this.c != null) {
            L();
            if (this.aa.V(bu.a.SINGLE_INST)) {
                hbVar = this.I;
            } else {
                hbVar = this.aa.V(bu.a.MAIN_VIEW) ? this.Code : this.V;
            }
            hbVar.L();
        }
    }

    @Override // com.huawei.openalliance.ad.media.listener.i
    public void I(String str, String str2, int i) {
        fh.V("PPSPlacementView", "onSegmentMediaStop, contentId: %s, url: %s", str, bl.Code(str2));
        if (str != null && str.equalsIgnoreCase(getCurrentContentId())) {
            Code(i);
        }
        if (this.p == null || !str.equalsIgnoreCase(getCurrentContentId())) {
            Object[] objArr = new Object[2];
            objArr[0] = Boolean.valueOf(this.p == null);
            objArr[1] = getCurrentContentId();
            fh.V("PPSPlacementView", "skip mediaStop callback, listener null ? %s, currentContentId: %s", objArr);
            return;
        }
        int currentPlayTime = getCurrentPlayTime() + i;
        fh.V("PPSPlacementView", "mediaStop callback, playedTime: %s", Integer.valueOf(currentPlayTime));
        PlacementMediaView placementMediaView = this.s;
        if (placementMediaView instanceof PlacementVideoView) {
            placementMediaView.V(i);
        }
        this.p.I(currentPlayTime);
    }

    public void S() {
        bj.Code(new Runnable() { // from class: com.huawei.openalliance.ad.views.PPSPlacementView.9
            @Override // java.lang.Runnable
            public void run() {
                fh.V("PPSPlacementView", "unmuteSound");
                boolean z = false;
                PPSPlacementView.this.t = false;
                boolean z2 = true;
                if (PPSPlacementView.this.z == 1) {
                    PPSPlacementView.this.l();
                }
                if (PPSPlacementView.this.j != null) {
                    PPSPlacementView.this.j.B();
                    z = true;
                }
                if (PPSPlacementView.this.k != null) {
                    PPSPlacementView.this.k.B();
                } else {
                    z2 = z;
                }
                if (PPSPlacementView.this.l != null) {
                    PPSPlacementView.this.l.B();
                } else if (!z2) {
                    return;
                }
                PPSPlacementView.this.L.Code(PPSPlacementView.this.t);
            }
        });
    }

    @Override // com.huawei.openalliance.ad.media.listener.f
    public void V() {
        fh.V("PPSPlacementView", "onUnmute");
        this.t = false;
    }

    @Override // com.huawei.hms.ads.fu
    public void V(long j, int i) {
        if (!this.i) {
            this.i = true;
            this.L.Code(j, i, this.B);
        }
        this.y = false;
        this.x = false;
    }

    public void V(com.huawei.openalliance.ad.media.listener.f fVar) {
        if (fVar == null) {
            return;
        }
        PlacementMediaView placementMediaView = this.j;
        if (placementMediaView != null) {
            placementMediaView.V(fVar);
        } else {
            this.n = null;
        }
    }

    @Override // com.huawei.openalliance.ad.media.listener.i
    public void V(String str, String str2, int i) {
        fh.V("PPSPlacementView", "onSegmentMediaPause:" + bl.Code(str2));
        if (str != null && str.equalsIgnoreCase(getCurrentContentId())) {
            Code(i);
            PlacementMediaView placementMediaView = this.s;
            if (placementMediaView instanceof PlacementVideoView) {
                placementMediaView.I(i);
            }
        }
        if (this.p != null) {
            int currentPlayTime = getCurrentPlayTime() + i;
            fh.V("PPSPlacementView", "mediaPause callback, playedTime: %s", Integer.valueOf(currentPlayTime));
            this.p.V(currentPlayTime);
        }
    }

    protected void V(List<View> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        for (View view : list) {
            if (view instanceof PlacementVideoView) {
                ((PlacementVideoView) view).setOnClickListener(this.af);
            } else {
                view.setOnClickListener(this.af);
                view.setOnTouchListener(this.ae);
            }
        }
    }

    @Override // com.huawei.openalliance.ad.media.listener.i
    public void Z(String str, String str2, int i) {
        PlacementMediaView placementMediaView;
        String currentContentId = getCurrentContentId();
        if (str != null && !str.equalsIgnoreCase(currentContentId)) {
            fh.V("PPSPlacementView", "onCompletion, %s not match current contentId: %s.", str, currentContentId);
            return;
        }
        boolean zF = f();
        if (!zF) {
            PlacementMediaView placementMediaView2 = this.s;
            if (placementMediaView2 instanceof PlacementVideoView) {
                this.E = placementMediaView2.getLastFrame();
                j();
            }
        }
        PlacementMediaView placementMediaView3 = this.s;
        if (placementMediaView3 instanceof PlacementVideoView) {
            placementMediaView3.V(i);
        }
        i();
        fh.V("PPSPlacementView", "onSegmentMediaCompletion, contentId: %s, url: %s", str, bl.Code(str2));
        Code(i);
        this.f4493a.c();
        this.s.Code(i);
        V(zF);
        if (this.p != null && zF) {
            int currentPlayTime = getCurrentPlayTime() + i;
            fh.V("PPSPlacementView", "mediaCompletion callback, playedTime: %s", Integer.valueOf(currentPlayTime));
            this.p.Z(currentPlayTime);
            if (this.aa.V(bu.a.SINGLE_INST) && (placementMediaView = this.l) != null) {
                placementMediaView.V();
            }
        }
        iy iyVar = this.L;
        if (iyVar != null) {
            long j = i;
            iyVar.Code(getContext(), j, j);
        }
    }

    @Override // com.huawei.hms.ads.fu
    public void a_() {
        this.v = -1;
        this.u = false;
    }

    @Override // com.huawei.hms.ads.me
    public void destroyView() {
        bj.Code(new Runnable() { // from class: com.huawei.openalliance.ad.views.PPSPlacementView.13
            @Override // java.lang.Runnable
            public void run() {
                fh.V("PPSPlacementView", "destroyView");
                if (PPSPlacementView.this.s != null) {
                    PPSPlacementView.this.s.F();
                    PPSPlacementView.this.s.destroyView();
                }
                PPSPlacementView.this.F();
                PPSPlacementView.this.D();
                PPSPlacementView.this.i();
                PPSPlacementView.this.Code.I();
                PPSPlacementView.this.V.I();
                PPSPlacementView.this.I.I();
            }
        });
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        try {
            int iCode = kx.Code(motionEvent);
            if (iCode == 0) {
                this.M = kx.Code(this, motionEvent);
            }
            if (1 == iCode) {
                kx.Code(this, motionEvent, null, this.M);
            }
        } catch (Throwable th) {
            fh.I("PPSPlacementView", "dispatchTouchEvent exception : %s", th.getClass().getSimpleName());
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public void hideAdvertiserInfoDialog() {
        com.huawei.openalliance.ad.msgnotify.b.Code(getContext(), bq.B, new Intent(com.huawei.openalliance.ad.activity.a.I));
    }

    public void hideTransparencyDialog() {
        com.huawei.openalliance.ad.msgnotify.b.Code(getContext(), com.huawei.openalliance.ad.utils.h.I(getContext()), bq.B, new Intent(com.huawei.openalliance.ad.activity.a.I));
    }

    public boolean isPlaying() {
        PlacementMediaView placementMediaView = this.s;
        if (placementMediaView != null) {
            return placementMediaView.D();
        }
        return false;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        fh.Code("PPSPlacementView", "onAttachedToWindow");
        this.f4493a.D();
        jf.Code(getContext()).V(getContext());
    }

    public void onClose() {
        bj.Code(new Runnable() { // from class: com.huawei.openalliance.ad.views.PPSPlacementView.3
            @Override // java.lang.Runnable
            public void run() {
                hb hbVar;
                fh.V("PPSPlacementView", "onClose");
                PPSPlacementView.this.L.Code();
                if (PPSPlacementView.this.aa.V(bu.a.SINGLE_INST)) {
                    hbVar = PPSPlacementView.this.I;
                } else {
                    hbVar = PPSPlacementView.this.aa.V(bu.a.MAIN_VIEW) ? PPSPlacementView.this.Code : PPSPlacementView.this.V;
                }
                hbVar.d();
                PPSPlacementView.this.Code.I();
                PPSPlacementView.this.V.I();
                PPSPlacementView.this.I.I();
            }
        });
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        fh.V("PPSPlacementView", "onDetechedFromWindow");
        this.f4493a.L();
        this.Code.I();
        this.V.I();
        this.I.I();
    }

    @Override // android.view.View
    protected void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
        this.f4493a.a();
    }

    public void pause() {
        bj.Code(new Runnable() { // from class: com.huawei.openalliance.ad.views.PPSPlacementView.5
            @Override // java.lang.Runnable
            public void run() {
                fh.V("PPSPlacementView", "pause");
                if (PPSPlacementView.this.s != null) {
                    PPSPlacementView.this.s.S();
                }
            }
        });
    }

    @Override // com.huawei.hms.ads.me
    public void pauseView() {
        bj.Code(new Runnable() { // from class: com.huawei.openalliance.ad.views.PPSPlacementView.11
            @Override // java.lang.Runnable
            public void run() {
                fh.V("PPSPlacementView", "pauseView");
                if (PPSPlacementView.this.s != null) {
                    PPSPlacementView.this.s.pauseView();
                    PPSPlacementView.this.s.S();
                    PPSPlacementView.this.i();
                }
            }
        });
    }

    @Override // com.huawei.hms.ads.me
    public void resumeView() {
        bj.Code(new Runnable() { // from class: com.huawei.openalliance.ad.views.PPSPlacementView.10
            @Override // java.lang.Runnable
            public void run() {
                fh.V("PPSPlacementView", "resumeView");
                if (PPSPlacementView.this.s != null) {
                    PPSPlacementView.this.s.resumeView();
                    PPSPlacementView.this.s.Code(true, PPSPlacementView.this.t);
                    PPSPlacementView pPSPlacementView = PPSPlacementView.this;
                    pPSPlacementView.Code(pPSPlacementView.getCurrentAdDuration() * 2);
                }
            }
        });
    }

    public void setAudioFocusType(int i) {
        this.z = i;
    }

    public void setMediaPlayerReleaseListener(com.huawei.openalliance.ad.media.listener.e eVar) {
        if (eVar == null) {
            return;
        }
        this.Q = eVar;
    }

    public void setOnPlacementAdClickListener(a aVar) {
        this.f = aVar;
    }

    public void setOverlays(List<View> list) {
        this.N = list;
    }

    public void setSoundVolume(final float f) {
        bj.Code(new Runnable() { // from class: com.huawei.openalliance.ad.views.PPSPlacementView.8
            @Override // java.lang.Runnable
            public void run() {
                hb hbVar;
                fh.V("PPSPlacementView", "set sound volume: %s", Float.valueOf(f));
                if (PPSPlacementView.this.s != null) {
                    PPSPlacementView.this.s.setSoundVolume(f);
                    if (PPSPlacementView.this.aa.V(bu.a.SINGLE_INST)) {
                        hbVar = PPSPlacementView.this.I;
                    } else {
                        hbVar = PPSPlacementView.this.aa.V(bu.a.MAIN_VIEW) ? PPSPlacementView.this.Code : PPSPlacementView.this.V;
                    }
                    hbVar.V(f);
                }
            }
        });
    }

    public void showAdvertiserInfoDialog(View view, boolean z) {
        if (view == null) {
            fh.I("PPSPlacementView", "anchorView is null");
        }
        try {
            n currentAd = getCurrentAd();
            if (currentAd == null) {
                fh.I("PPSPlacementView", "adInfo is null");
                return;
            }
            AdContentData adContentDataQ = currentAd.q();
            if (ag.Code(adContentDataQ.aL())) {
                fh.I("PPSPlacementView", "advertiser Info is null");
            } else {
                ComplianceActivity.Code(getContext(), view, adContentDataQ, z);
            }
        } catch (Throwable th) {
            fh.I("PPSPlacementView", "showAdvertiserInfoDialog has exception %s", th.getClass().getSimpleName());
        }
    }

    public void showTransparencyDialog(View view) {
        if (view == null) {
            fh.I("PPSPlacementView", "anchorView is null");
        }
        try {
            n currentAd = getCurrentAd();
            if (currentAd == null) {
                fh.I("PPSPlacementView", "adInfo is null");
            } else {
                co.Code(getContext(), view, currentAd.q());
            }
        } catch (Throwable th) {
            fh.I("PPSPlacementView", "showTransparencyDialog has exception %s", th.getClass().getSimpleName());
        }
    }

    public void showTransparencyDialog(View view, int[] iArr) {
        if (view == null) {
            fh.I("PPSPlacementView", "anchorView is null");
        }
        try {
            n currentAd = getCurrentAd();
            if (currentAd == null) {
                fh.I("PPSPlacementView", "adInfo is null");
            } else {
                co.Code(getContext(), view, iArr, currentAd.q());
            }
        } catch (Throwable th) {
            fh.I("PPSPlacementView", "showTransparencyDialog has exception %s", th.getClass().getSimpleName());
        }
    }

    public void stop() {
        bj.Code(new Runnable() { // from class: com.huawei.openalliance.ad.views.PPSPlacementView.6
            @Override // java.lang.Runnable
            public void run() {
                fh.V("PPSPlacementView", "stop");
                if (PPSPlacementView.this.s != null) {
                    PPSPlacementView.this.s.F();
                }
            }
        });
    }
}
