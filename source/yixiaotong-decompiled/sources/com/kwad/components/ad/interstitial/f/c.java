package com.kwad.components.ad.interstitial.f;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import androidx.core.graphics.drawable.RoundedBitmapDrawable;
import androidx.core.graphics.drawable.RoundedBitmapDrawableFactory;
import com.kwad.sdk.R;
import com.kwad.sdk.api.KsAdVideoPlayConfig;
import com.kwad.sdk.api.KsInterstitialAd;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.imageloader.core.assist.FailReason;
import com.kwad.sdk.core.imageloader.core.decode.DecodedResult;
import com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener;
import com.kwad.sdk.core.imageloader.utils.BlurUtils;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.al;
import com.kwad.sdk.utils.as;
import com.kwad.sdk.utils.bi;
import com.kwad.sdk.utils.br;
import com.kwad.sdk.utils.cb;
import com.kwad.sdk.utils.i;
import com.kwad.sdk.widget.KSFrameLayout;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public final class c extends com.kwad.sdk.mvp.a {
    public com.kwad.sdk.core.video.videoview.a cB;
    public KsAdVideoPlayConfig ce;
    public KSFrameLayout gp;
    public com.kwad.components.ad.interstitial.g.b lq;
    public KsInterstitialAd.AdInteractionListener ls;
    public com.kwad.components.ad.interstitial.d lx;
    public AdResultData mAdResultData;
    public com.kwad.components.core.e.d.d mApkDownloadHelper;
    public com.kwad.components.ad.interstitial.h.d mO;
    public boolean mP;
    public boolean mQ;
    public boolean mR;
    public a mS;
    public com.kwad.components.core.webview.tachikoma.f.g mU;
    public e mV;
    public boolean mZ;
    public boolean na;
    public List<b> mT = new CopyOnWriteArrayList();
    private Handler jk = new Handler(Looper.getMainLooper());
    public volatile boolean mY = false;
    public int nb = -1;
    public List<com.kwad.components.core.video.a.c> mX = new CopyOnWriteArrayList();
    public List<d> mW = new ArrayList();

    public interface a {
        void a(long j, long j2, boolean z);
    }

    public interface b {
        void c(long j, long j2);
    }

    public interface d {
        void ei();
    }

    public interface e {
        void ej();
    }

    public final void a(AdResultData adResultData) {
        this.mAdResultData = adResultData;
        this.mAdTemplate = com.kwad.sdk.core.response.helper.c.r(adResultData);
    }

    public final void setAdTemplate(AdTemplate adTemplate) {
        this.mAdTemplate = adTemplate;
    }

    public final void a(com.kwad.components.core.video.a.c cVar) {
        if (this.mX.contains(cVar)) {
            return;
        }
        this.mX.add(cVar);
    }

    public final void b(com.kwad.components.core.video.a.c cVar) {
        this.mX.remove(cVar);
    }

    @Override // com.kwad.sdk.mvp.a
    public final void release() {
        this.jk.removeCallbacksAndMessages(null);
        this.mX.clear();
        this.mW.clear();
        com.kwad.components.ad.interstitial.g.b bVar = this.lq;
        if (bVar != null) {
            bVar.Ab();
        }
    }

    public final boolean a(final C0610c c0610c) {
        com.kwad.components.ad.interstitial.report.a.eV().a(this.mAdTemplate, 1L, c0610c.nm);
        boolean z = c0610c.ed() == 1;
        boolean z2 = com.kwad.components.ad.interstitial.b.b.dR() || z || c0610c.ef() || c0610c.nq;
        if (z2) {
            com.kwad.components.core.e.d.a.a(new com.kwad.components.core.e.d.a.C0661a(c0610c.getContext()).aJ(this.mAdTemplate).b(this.mApkDownloadHelper).as(z).aL(1).aM(c0610c.nm).D(this.cB.getCurrentPosition()).aN(c0610c.ed()).a(new com.kwad.components.core.e.d.a.b() { // from class: com.kwad.components.ad.interstitial.f.c.1
                @Override // com.kwad.components.core.e.d.a.b
                public final void onAdClicked() {
                    c.this.b(c0610c);
                    if (c.this.lx == null || !com.kwad.components.ad.interstitial.d.b.x(c.this.mAdTemplate)) {
                        return;
                    }
                    c cVar = c.this;
                    cVar.a(false, -1, cVar.cB);
                    c.this.jk.postDelayed(new bi() { // from class: com.kwad.components.ad.interstitial.f.c.1.1
                        @Override // com.kwad.sdk.utils.bi
                        public final void doTask() {
                            c.this.lx.dismiss();
                            c.this.ac();
                        }
                    }, 500L);
                }
            }));
        }
        return z2;
    }

    public final void b(C0610c c0610c) {
        com.kwad.sdk.core.adlog.c.b bVar = new com.kwad.sdk.core.adlog.c.b();
        bVar.f(c0610c.getTouchCoords());
        if (!c0610c.ee() && !c0610c.nn) {
            c0610c.X(153);
        }
        com.kwad.sdk.core.adlog.c.a(this.mAdTemplate, new com.kwad.sdk.core.adlog.c.b().ec(c0610c.eg()).f(c0610c.getTouchCoords()).eq(as.VM() ? 2 : 1).j(c0610c.eh()), (JSONObject) null);
        com.kwad.sdk.core.video.videoview.a aVar = this.cB;
        if (aVar != null) {
            long jA = a(aVar);
            int iB = b(this.cB);
            bVar.aC(jA);
            bVar.ek(iB);
        }
        this.mP = true;
        c(1L, c0610c.nm);
    }

    public final void a(final Context context, final int i, int i2, int i3) {
        com.kwad.components.ad.interstitial.report.a.eV().a(this.mAdTemplate, 6L, i);
        final int i4 = 9;
        com.kwad.components.core.e.d.a.a(new com.kwad.components.core.e.d.a.C0661a(context).aJ(this.mAdTemplate).b(this.mApkDownloadHelper).as(false).aN(2).aL(6).aM(i).a(new com.kwad.components.core.e.d.a.b() { // from class: com.kwad.components.ad.interstitial.f.c.2
            @Override // com.kwad.components.core.e.d.a.b
            public final void onAdClicked() {
                c cVar = c.this;
                int i5 = i4;
                int i6 = i;
                cVar.a(i5, i6, context, 6L, i6);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, int i2, Context context, long j, long j2) {
        com.kwad.sdk.core.adlog.c.a(this.mAdTemplate, new com.kwad.sdk.core.adlog.c.b().ej(i).ec(i2).eq(as.VM() ? 2 : 1).Jh(), (JSONObject) null);
        this.mP = true;
        c(j, j2);
    }

    public final void ac() {
        KsInterstitialAd.AdInteractionListener adInteractionListener = this.ls;
        if (adInteractionListener != null) {
            adInteractionListener.onAdClosed();
        }
    }

    public final void a(b bVar) {
        if (bVar == null) {
            return;
        }
        this.mT.add(bVar);
    }

    public final void b(b bVar) {
        if (bVar == null) {
            return;
        }
        this.mT.remove(bVar);
    }

    public final void c(long j, long j2) {
        Iterator<b> it = this.mT.iterator();
        while (it.hasNext()) {
            it.next().c(j, j2);
        }
        KsInterstitialAd.AdInteractionListener adInteractionListener = this.ls;
        if (adInteractionListener != null) {
            adInteractionListener.onAdClicked();
        }
        a aVar = this.mS;
        if (aVar != null) {
            aVar.a(j, j2, true);
        }
    }

    public final void ea() {
        e eVar = this.mV;
        if (eVar != null) {
            eVar.ej();
        }
    }

    public final void eb() {
        Iterator<d> it = this.mW.iterator();
        while (it.hasNext()) {
            it.next().ei();
        }
    }

    public static boolean a(Context context, AdInfo adInfo) {
        return com.kwad.sdk.core.response.helper.a.bc(adInfo) && !as.VM();
    }

    public final boolean M(Context context) {
        if (this.mAdTemplate == null || context == null) {
            com.kwad.sdk.core.d.c.w("InterstitialCallerContext", "isPlayable illegal params: " + this.mAdTemplate + ", context: " + context);
            return false;
        }
        return com.kwad.sdk.core.response.helper.a.bQ(com.kwad.sdk.core.response.helper.e.eO(this.mAdTemplate));
    }

    public final void a(Context context, AdInfo adInfo, AdTemplate adTemplate, View view) {
        if (view == null) {
            return;
        }
        String url = com.kwad.sdk.core.response.helper.a.bA(adInfo).getUrl();
        if (br.isNullString(url)) {
            return;
        }
        KSImageLoader.loadImage(url, adTemplate, KSImageLoader.IMGOPTION_NORMAL, new AnonymousClass3(context, view));
    }

    /* JADX INFO: renamed from: com.kwad.components.ad.interstitial.f.c$3, reason: invalid class name */
    final class AnonymousClass3 implements ImageLoadingListener {
        final /* synthetic */ Context dK;
        final /* synthetic */ View eL;

        @Override // com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
        public final boolean onDecode(String str, InputStream inputStream, DecodedResult decodedResult) {
            return false;
        }

        @Override // com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
        public final void onLoadingCancelled(String str, View view) {
        }

        @Override // com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
        public final void onLoadingFailed(String str, View view, FailReason failReason) {
        }

        @Override // com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
        public final void onLoadingStarted(String str, View view) {
        }

        AnonymousClass3(Context context, View view) {
            this.dK = context;
            this.eL = view;
        }

        @Override // com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
        public final void onLoadingComplete(String str, View view, final DecodedResult decodedResult) {
            i.execute(new bi() { // from class: com.kwad.components.ad.interstitial.f.c.3.1
                @Override // com.kwad.sdk.utils.bi
                public final void doTask() {
                    Bitmap bitmap = decodedResult.mBitmap;
                    com.kwad.sdk.core.d.c.d("InterstitialCallerContext", "onLoadingComplete before blur");
                    Bitmap bitmapStackBlur = BlurUtils.stackBlur(bitmap, 50, false);
                    com.kwad.sdk.core.d.c.d("InterstitialCallerContext", "onLoadingComplete after blur");
                    float dimension = AnonymousClass3.this.dK.getResources().getDimension(R.dimen.ksad_interstitial_icon_radius);
                    final RoundedBitmapDrawable roundedBitmapDrawableCreate = RoundedBitmapDrawableFactory.create(AnonymousClass3.this.dK.getResources(), bitmapStackBlur);
                    roundedBitmapDrawableCreate.setCornerRadius(dimension);
                    AnonymousClass3.this.eL.post(new bi() { // from class: com.kwad.components.ad.interstitial.f.c.3.1.1
                        @Override // com.kwad.sdk.utils.bi
                        public final void doTask() {
                            AnonymousClass3.this.eL.setBackground(roundedBitmapDrawableCreate);
                        }
                    });
                }
            });
        }
    }

    public final boolean ec() {
        com.kwad.components.ad.interstitial.h.d dVar = this.mO;
        boolean z = dVar == null || dVar.getParent() == null;
        com.kwad.sdk.core.d.c.d("InterstitialCallerContext", "isH5Interstitial :" + z);
        return z;
    }

    public final void c(Context context, AdTemplate adTemplate) {
        if (this.mY) {
            return;
        }
        com.kwad.components.core.page.a.launch(context, adTemplate);
        this.mY = true;
    }

    public final void a(boolean z, int i, com.kwad.sdk.core.video.videoview.a aVar) {
        long jA;
        int iA;
        com.kwad.components.ad.interstitial.report.a.eV().a(this.mAdTemplate, cb.k(this.gp, true));
        if (aVar != null) {
            jA = a(aVar);
            iA = b(aVar);
        } else {
            jA = i;
            iA = a(jA, this.mAdTemplate);
        }
        com.kwad.sdk.core.adlog.c.a(this.mAdTemplate, z ? 14 : 1, jA, iA, this.lx.getTimerHelper().getTime(), null);
    }

    private static long a(com.kwad.sdk.core.video.videoview.a aVar) {
        if (aVar == null) {
            return -1L;
        }
        return aVar.getCurrentPosition();
    }

    private static int b(com.kwad.sdk.core.video.videoview.a aVar) {
        if (aVar == null) {
            return -1;
        }
        long duration = aVar.getDuration();
        long currentPosition = aVar.getCurrentPosition();
        if (duration != 0) {
            return Math.round((currentPosition / duration) * 100.0f);
        }
        return -1;
    }

    private static int a(long j, AdTemplate adTemplate) {
        if (j == -1) {
            return -1;
        }
        float fO = com.kwad.sdk.core.response.helper.a.O(com.kwad.sdk.core.response.helper.e.eO(adTemplate)) / 1000.0f;
        if (fO != 0.0f) {
            return Math.round((j / fO) * 100.0f);
        }
        return -1;
    }

    /* JADX INFO: renamed from: com.kwad.components.ad.interstitial.f.c$c, reason: collision with other inner class name */
    public static class C0610c {
        private final Context context;
        private int nk;
        private boolean nl;
        private int nm;
        private boolean nn;
        private al.a no;
        public double np;
        public boolean nq;

        public final C0610c W(int i) {
            this.nk = i;
            return this;
        }

        public final C0610c X(int i) {
            this.nm = i;
            return this;
        }

        public final C0610c a(al.a aVar) {
            this.no = aVar;
            return this;
        }

        public final C0610c c(double d) {
            this.np = d;
            return this;
        }

        public final int ed() {
            return this.nk;
        }

        public final boolean ee() {
            return this.nl;
        }

        public final boolean ef() {
            return this.nn;
        }

        public final int eg() {
            return this.nm;
        }

        public final double eh() {
            return this.np;
        }

        public final Context getContext() {
            return this.context;
        }

        public final al.a getTouchCoords() {
            return this.no;
        }

        public final C0610c l(boolean z) {
            this.nl = z;
            return this;
        }

        public final C0610c m(boolean z) {
            this.nn = true;
            return this;
        }

        public final C0610c n(boolean z) {
            this.nq = true;
            return this;
        }

        public C0610c(Context context) {
            this.context = context;
        }
    }
}
