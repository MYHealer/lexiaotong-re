package com.ubix.ssp.ad.d;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import com.ubix.ssp.ad.e.a0.u;
import com.ubix.ssp.open.AdError;
import com.ubix.ssp.open.UBiXAdLossInfo;
import com.ubix.ssp.open.UBiXDownloadConfirmCallback;
import com.ubix.ssp.open.UBiXDownloadConfirmListener;
import com.ubix.ssp.open.nativee.NativeAd;
import com.ubix.ssp.open.nativee.UBiXImage;
import com.ubix.ssp.open.nativee.UBiXNativeAdDownloadListener;
import com.ubix.ssp.open.nativee.UBiXNativeInteractionListener;
import com.ubix.ssp.open.nativee.UBiXNativeVideoListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class h implements NativeAd, NativeAd.CustomizeVideo, NativeAd.CustomReporter {
    private String A;
    private boolean B;
    private String E;
    private String F;
    private String G;
    private int H;
    private int I;
    private String J;
    private boolean K;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.ubix.ssp.ad.i.c f8612a;
    private com.ubix.ssp.ad.d.a b;
    private String c;
    private String d;
    private String e;
    private ArrayList<UBiXImage> f;
    private String g;
    private String h;
    private int i;
    private String j;
    private String k;
    private boolean l;
    private String m;
    private String n;
    private String o;
    private String p;
    private String q;
    private String r;
    private String s;
    private long t;
    private String u;
    private String v;
    private Drawable w;
    private long x;
    private String y;
    private f z;
    private long C = 0;
    private int D = 0;
    private String L = "";
    private HashMap<String, Object> M = new HashMap<>();
    int N = 0;
    private boolean O = false;

    class a implements com.ubix.ssp.ad.e.s.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ UBiXNativeAdDownloadListener f8613a;

        a(UBiXNativeAdDownloadListener uBiXNativeAdDownloadListener) {
            this.f8613a = uBiXNativeAdDownloadListener;
        }

        @Override // com.ubix.ssp.ad.e.s.e
        public int a() {
            return 0;
        }

        @Override // com.ubix.ssp.ad.e.s.e
        public void a(int i) {
            UBiXNativeAdDownloadListener uBiXNativeAdDownloadListener = this.f8613a;
            if (uBiXNativeAdDownloadListener != null) {
                uBiXNativeAdDownloadListener.onDownloadStarted();
            }
        }

        @Override // com.ubix.ssp.ad.e.s.e
        public void a(int i, int i2) {
            UBiXNativeAdDownloadListener uBiXNativeAdDownloadListener = this.f8613a;
            if (uBiXNativeAdDownloadListener != null) {
                uBiXNativeAdDownloadListener.onDownloadPaused(i2);
            }
        }

        @Override // com.ubix.ssp.ad.e.s.e
        public void a(int i, AdError adError, String str) {
            UBiXNativeAdDownloadListener uBiXNativeAdDownloadListener = this.f8613a;
            if (uBiXNativeAdDownloadListener != null) {
                uBiXNativeAdDownloadListener.onDownloadFailed(adError);
            }
        }

        @Override // com.ubix.ssp.ad.e.s.e
        public void a(int i, String str) {
            UBiXNativeAdDownloadListener uBiXNativeAdDownloadListener = this.f8613a;
            if (uBiXNativeAdDownloadListener != null) {
                uBiXNativeAdDownloadListener.onDownloadFinished(str);
            }
        }

        @Override // com.ubix.ssp.ad.e.s.e
        public void b(int i, int i2) {
            UBiXNativeAdDownloadListener uBiXNativeAdDownloadListener = this.f8613a;
            if (uBiXNativeAdDownloadListener != null) {
                uBiXNativeAdDownloadListener.onDownloadResume(i2);
            }
        }

        @Override // com.ubix.ssp.ad.e.s.e
        public void c(int i, int i2) {
            UBiXNativeAdDownloadListener uBiXNativeAdDownloadListener = this.f8613a;
            if (uBiXNativeAdDownloadListener != null) {
                uBiXNativeAdDownloadListener.onDownloading(i2);
            }
        }
    }

    class b implements com.ubix.ssp.ad.g.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ UBiXDownloadConfirmListener f8614a;

        class a implements UBiXDownloadConfirmCallback {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ com.ubix.ssp.ad.g.b f8615a;

            a(com.ubix.ssp.ad.g.b bVar) {
                this.f8615a = bVar;
            }

            @Override // com.ubix.ssp.open.UBiXDownloadConfirmCallback
            public void onCancel() {
                u.e("custom download: onCancel");
                com.ubix.ssp.ad.g.b bVar = this.f8615a;
                if (bVar != null) {
                    bVar.onCancel();
                }
            }

            @Override // com.ubix.ssp.open.UBiXDownloadConfirmCallback
            public void onClose() {
                u.e("custom download: onClose");
                com.ubix.ssp.ad.g.b bVar = this.f8615a;
                if (bVar != null) {
                    bVar.onClose();
                }
            }

            @Override // com.ubix.ssp.open.UBiXDownloadConfirmCallback
            public void onConfirm() {
                u.e("custom download: onConfirm");
                com.ubix.ssp.ad.g.b bVar = this.f8615a;
                if (bVar != null) {
                    bVar.onConfirm();
                }
            }
        }

        b(UBiXDownloadConfirmListener uBiXDownloadConfirmListener) {
            this.f8614a = uBiXDownloadConfirmListener;
        }

        @Override // com.ubix.ssp.ad.g.c
        public void a(Context context, Bundle bundle, com.ubix.ssp.ad.g.b bVar) {
            this.f8614a.onDownloadConfirm(context, bundle, new a(bVar));
        }
    }

    private String getPR() {
        return this.L;
    }

    public void a(int i) {
        this.i = i;
    }

    public void a(long j) {
        this.t = j;
    }

    public void a(Drawable drawable) {
        this.w = drawable;
    }

    public void a(com.ubix.ssp.ad.d.a aVar) {
        this.b = aVar;
    }

    public void a(f fVar) {
        this.z = fVar;
    }

    public void a(com.ubix.ssp.ad.i.c cVar) {
        this.f8612a = cVar;
    }

    public void a(String str) {
        this.k = str;
    }

    public void a(ArrayList<UBiXImage> arrayList) {
        this.f = arrayList;
    }

    public void a(boolean z) {
        this.l = z;
    }

    public void b(int i) {
        this.D = i;
    }

    public void b(long j) {
        this.x = j;
    }

    public void b(String str) {
        this.j = str;
    }

    public void b(boolean z) {
        this.B = z;
    }

    public void c(int i) {
        this.I = i;
    }

    public void c(long j) {
        this.C = j;
    }

    public void c(String str) {
        this.A = str;
    }

    public void c(boolean z) {
        this.K = z;
    }

    public void d(int i) {
        this.H = i;
    }

    public void d(String str) {
        this.h = str;
    }

    @Override // com.ubix.ssp.open.nativee.NativeAd
    public void destroy() {
        com.ubix.ssp.ad.i.c cVar = this.f8612a;
        if (cVar != null) {
            cVar.m(this.b);
        }
        this.z = null;
    }

    public void e(String str) {
        this.y = str;
    }

    public void f(String str) {
        this.E = str;
    }

    public void g(String str) {
        this.d = str;
    }

    @Override // com.ubix.ssp.open.nativee.NativeAd
    public String getActionButtonText() {
        return this.k;
    }

    @Override // com.ubix.ssp.open.nativee.NativeAd
    public Drawable getAdLogo() {
        return this.w;
    }

    @Override // com.ubix.ssp.open.nativee.NativeAd
    public String getAdSource() {
        return this.j;
    }

    @Override // com.ubix.ssp.open.nativee.NativeAd
    public long getAppDownloadSize() {
        return this.t;
    }

    @Override // com.ubix.ssp.open.nativee.NativeAd
    public String getAppICPNumber() {
        return this.u;
    }

    @Override // com.ubix.ssp.open.nativee.NativeAd
    public String getAppIcon() {
        return this.m;
    }

    @Override // com.ubix.ssp.open.nativee.NativeAd
    public String getAppIntroduceLink() {
        return this.s;
    }

    @Override // com.ubix.ssp.open.nativee.NativeAd
    public String getAppLCPNumber() {
        return this.u;
    }

    @Override // com.ubix.ssp.open.nativee.NativeAd
    public String getAppName() {
        return this.n;
    }

    @Override // com.ubix.ssp.open.nativee.NativeAd
    public String getAppPackageName() {
        return this.A;
    }

    @Override // com.ubix.ssp.open.nativee.NativeAd
    public String getAppPermissionLink() {
        return this.q;
    }

    @Override // com.ubix.ssp.open.nativee.NativeAd
    public String getAppPrivacyLink() {
        return this.r;
    }

    @Override // com.ubix.ssp.open.nativee.NativeAd
    public String getAppPublisher() {
        return this.p;
    }

    @Override // com.ubix.ssp.open.nativee.NativeAd
    public String getAppSuitableAge() {
        return this.v;
    }

    @Override // com.ubix.ssp.open.nativee.NativeAd
    public String getAppVersion() {
        return this.o;
    }

    @Override // com.ubix.ssp.open.nativee.NativeAd.CustomizeVideo
    public String getCoverUrl() {
        return this.h;
    }

    @Override // com.ubix.ssp.open.nativee.NativeAd
    public String getCreativeId() {
        return this.y;
    }

    @Override // com.ubix.ssp.open.nativee.NativeAd
    public int getCreativeType() {
        return this.i;
    }

    @Override // com.ubix.ssp.open.nativee.NativeAd
    public NativeAd.CustomReporter getCustomReporter() {
        if (this.K) {
            return this;
        }
        return null;
    }

    @Override // com.ubix.ssp.open.nativee.NativeAd
    public NativeAd.CustomizeVideo getCustomizeVideo() {
        return this;
    }

    @Override // com.ubix.ssp.open.nativee.NativeAd
    public String getDeeplinkUrl() {
        return this.E;
    }

    @Override // com.ubix.ssp.open.nativee.NativeAd
    public String getDesc() {
        return this.d;
    }

    @Override // com.ubix.ssp.open.nativee.NativeAd
    public int getDownloadAppStatus() {
        return this.f8612a.n(this.b);
    }

    @Override // com.ubix.ssp.open.nativee.NativeAd
    public int getDownloadProgress() {
        return this.f8612a.e(this.b);
    }

    @Override // com.ubix.ssp.open.nativee.NativeAd
    public String getDownloadUrl() {
        return this.F;
    }

    @Override // com.ubix.ssp.open.nativee.NativeAd
    public HashMap<String, Object> getExtraInfo() {
        return this.M;
    }

    @Override // com.ubix.ssp.open.nativee.NativeAd
    public List<UBiXImage> getImageList() {
        return this.f;
    }

    @Override // com.ubix.ssp.open.nativee.NativeAd
    public String getImageUrl() {
        return this.e;
    }

    @Override // com.ubix.ssp.open.nativee.NativeAd
    public String getLandingPageUrl() {
        return this.G;
    }

    @Override // com.ubix.ssp.open.nativee.NativeAd.CustomizeVideo
    public String getMaterialId() {
        return this.J;
    }

    @Override // com.ubix.ssp.open.nativee.NativeAd
    public View getMediaView() {
        com.ubix.ssp.ad.i.c cVar = this.f8612a;
        if (cVar != null) {
            cVar.t(this.b);
        }
        return this.z;
    }

    @Override // com.ubix.ssp.open.nativee.NativeAd
    public long getPrice() {
        return this.x;
    }

    @Override // com.ubix.ssp.open.nativee.NativeAd
    public String getTitle() {
        return this.c;
    }

    @Override // com.ubix.ssp.open.nativee.NativeAd
    public long getVideoDuration() {
        return this.C;
    }

    @Override // com.ubix.ssp.open.nativee.NativeAd.CustomizeVideo
    public int getVideoHeight() {
        return this.I;
    }

    @Override // com.ubix.ssp.open.nativee.NativeAd.CustomizeVideo
    public String getVideoUrl() {
        return this.g;
    }

    @Override // com.ubix.ssp.open.nativee.NativeAd.CustomizeVideo
    public int getVideoWidth() {
        return this.H;
    }

    public void h(String str) {
        this.F = str;
    }

    public void i(String str) {
        this.m = str;
    }

    @Override // com.ubix.ssp.open.nativee.NativeAd
    public boolean isDownloadAd() {
        return this.l;
    }

    @Override // com.ubix.ssp.open.nativee.NativeAd
    public boolean isShakeAd() {
        int i = this.D;
        return i == 514 || i == 2;
    }

    @Override // com.ubix.ssp.open.nativee.NativeAd
    public boolean isSupportCustomShake() {
        return this.D == 514;
    }

    @Override // com.ubix.ssp.open.nativee.NativeAd
    public boolean isValid() {
        com.ubix.ssp.ad.i.c cVar = this.f8612a;
        if (cVar != null) {
            return cVar.s(this.b);
        }
        return false;
    }

    @Override // com.ubix.ssp.open.nativee.NativeAd
    public boolean isVideoAd() {
        return this.B;
    }

    public void j(String str) {
        this.e = str;
    }

    public void k(String str) {
        this.L = str;
    }

    public void l(String str) {
        this.G = str;
    }

    @Override // com.ubix.ssp.open.nativee.NativeAd
    public void lossNotice(UBiXAdLossInfo uBiXAdLossInfo) {
        com.ubix.ssp.ad.i.c cVar;
        if (uBiXAdLossInfo == null || (cVar = this.f8612a) == null) {
            return;
        }
        cVar.c(this.b, uBiXAdLossInfo.getInfo());
    }

    public void m(String str) {
        this.c = str;
    }

    public void n(String str) {
        this.J = str;
    }

    public void o(String str) {
        this.g = str;
    }

    public void p(String str) {
        this.u = str;
    }

    @Override // com.ubix.ssp.open.nativee.NativeAd
    public void pauseVideo() {
    }

    public void q(String str) {
        this.s = str;
    }

    public void r(String str) {
        this.n = str;
    }

    @Override // com.ubix.ssp.open.nativee.NativeAd
    public void registerViews(ViewGroup viewGroup, List<View> list, View view, UBiXNativeInteractionListener uBiXNativeInteractionListener) {
        com.ubix.ssp.ad.i.c cVar = this.f8612a;
        if (cVar != null) {
            cVar.b(this.b, viewGroup, list, view, uBiXNativeInteractionListener);
        }
    }

    @Override // com.ubix.ssp.open.nativee.NativeAd
    public void registerViews(ViewGroup viewGroup, List<View> list, List<View> list2, View view, UBiXNativeInteractionListener uBiXNativeInteractionListener) {
        com.ubix.ssp.ad.i.c cVar = this.f8612a;
        if (cVar != null) {
            cVar.a(this.b, viewGroup, list, list2, view, uBiXNativeInteractionListener);
        }
    }

    @Override // com.ubix.ssp.open.nativee.NativeAd.CustomReporter
    public void reportAdClick(NativeAd.InteractionType interactionType, View view, HashMap<String, String> map) {
        com.ubix.ssp.ad.i.c cVar = this.f8612a;
        if (cVar != null) {
            cVar.a(interactionType.getValue() + "", view, this.b, map);
        }
    }

    @Override // com.ubix.ssp.open.nativee.NativeAd.CustomizeVideo
    public void reportVideoComplete() {
        try {
            this.f8612a.a(this.b, 5100);
            this.f8612a.a(this.b, 5200);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.ubix.ssp.open.nativee.NativeAd.CustomizeVideo
    public void reportVideoError() {
    }

    @Override // com.ubix.ssp.open.nativee.NativeAd.CustomizeVideo
    public void reportVideoPause() {
    }

    @Override // com.ubix.ssp.open.nativee.NativeAd.CustomizeVideo
    public void reportVideoProgress(long j, long j2) {
        if (j2 > 0) {
            try {
                int i = (int) ((j * 100) / j2);
                int i2 = this.N;
                if (i >= i2 * 25) {
                    if (i2 == 0) {
                        this.f8612a.a(this.b, 5000);
                    } else if (i2 == 1) {
                        this.f8612a.a(this.b, 5025);
                    } else if (i2 == 2) {
                        this.f8612a.a(this.b, 5050);
                    } else if (i2 == 3) {
                        this.f8612a.a(this.b, 5075);
                    } else if (i2 == 4) {
                        this.f8612a.a(this.b, 5100);
                    }
                    this.N++;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.ubix.ssp.open.nativee.NativeAd.CustomizeVideo
    public void reportVideoResume() {
    }

    @Override // com.ubix.ssp.open.nativee.NativeAd.CustomizeVideo
    public void reportVideoStart() {
        try {
            int i = this.N;
            if (i == 0) {
                this.N = i + 1;
                this.f8612a.a(this.b, 5000);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void s(String str) {
        this.q = str;
    }

    @Override // com.ubix.ssp.open.nativee.NativeAd
    public void setAutoPlay(boolean z) {
        f fVar = this.z;
        if (fVar != null) {
            fVar.setAutoPlay(z);
        }
    }

    @Override // com.ubix.ssp.open.nativee.NativeAd
    public void setCustomDownloadConfirmListener(UBiXDownloadConfirmListener uBiXDownloadConfirmListener) {
        u.e("setCustomDownloadConfirmListener nativeAd=" + this.f8612a + ";UBiXDownloadConfirmListener=" + uBiXDownloadConfirmListener);
        com.ubix.ssp.ad.i.c cVar = this.f8612a;
        if (cVar == null || uBiXDownloadConfirmListener == null) {
            return;
        }
        cVar.a(this.b, new b(uBiXDownloadConfirmListener));
    }

    @Override // com.ubix.ssp.open.nativee.NativeAd
    public void setDownloadListener(UBiXNativeAdDownloadListener uBiXNativeAdDownloadListener) {
        if (uBiXNativeAdDownloadListener != null) {
            try {
                this.f8612a.a(this.b, new a(uBiXNativeAdDownloadListener));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.ubix.ssp.open.nativee.NativeAd
    public void setVideoListener(UBiXNativeVideoListener uBiXNativeVideoListener) {
        this.f8612a.a(this.b, uBiXNativeVideoListener);
    }

    @Override // com.ubix.ssp.open.nativee.NativeAd
    public void setVideoMute(boolean z) {
        f fVar = this.z;
        if (fVar != null) {
            fVar.setVideoMute(z);
        }
    }

    @Override // com.ubix.ssp.open.nativee.NativeAd
    public void shakeOff() {
        if (isSupportCustomShake()) {
            com.ubix.ssp.ad.i.c cVar = this.f8612a;
            com.ubix.ssp.ad.d.a aVar = this.b;
            this.O = false;
            cVar.a(aVar, false);
        }
    }

    @Override // com.ubix.ssp.open.nativee.NativeAd
    public void shakeOn() {
        if (isSupportCustomShake()) {
            com.ubix.ssp.ad.i.c cVar = this.f8612a;
            com.ubix.ssp.ad.d.a aVar = this.b;
            this.O = true;
            cVar.a(aVar, true);
        }
    }

    @Override // com.ubix.ssp.open.nativee.NativeAd
    public void startVideo() {
    }

    public void t(String str) {
        this.r = str;
    }

    public void u(String str) {
        this.p = str;
    }

    public void v(String str) {
        this.v = str;
    }

    public void w(String str) {
        this.o = str;
    }

    @Override // com.ubix.ssp.open.nativee.NativeAd
    public void winNotice(long j) {
        com.ubix.ssp.ad.i.c cVar = this.f8612a;
        if (cVar != null) {
            cVar.a(this.b, j);
        }
    }
}
