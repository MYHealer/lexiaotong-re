package com.heytap.msp.mobad.api.ad;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import com.heytap.msp.mobad.api.listener.INativeTempletAdListener;
import com.heytap.msp.mobad.api.params.INativeTempletAdView;
import com.heytap.msp.mobad.api.params.NativeAdError;
import com.heytap.msp.mobad.api.params.NativeAdParams;
import com.heytap.msp.mobad.api.params.NativeAdSize;
import com.opos.mobad.ad.d.n;
import com.opos.mobad.ad.d.o;
import com.opos.mobad.ad.d.p;
import com.opos.mobad.ad.d.q;
import com.opos.mobad.ad.d.s;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class NativeTempletAd {
    private static final String TAG = "NativeTempletAd";
    private Context mContext;
    private a mListener;
    private NativeAdSize mNativeAdSize;
    private volatile n mNativeTempletAdImpl;
    private String mPosId;

    static class a implements o {
        private final INativeTempletAdListener b;

        /* JADX INFO: renamed from: com.heytap.msp.mobad.api.ad.NativeTempletAd$a$a, reason: collision with other inner class name */
        static class C0419a implements INativeTempletAdView {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final p f3447a;

            public C0419a(p pVar) {
                this.f3447a = pVar;
            }

            @Override // com.heytap.msp.mobad.api.params.INativeTempletAdView
            public void destroy() {
                this.f3447a.c();
            }

            @Override // com.heytap.msp.mobad.api.params.INativeTempletAdView
            public View getAdView() {
                return this.f3447a.a();
            }

            @Override // com.heytap.msp.mobad.api.params.INativeTempletAdView
            public String getBidId() {
                return this.f3447a.g();
            }

            @Override // com.heytap.msp.mobad.api.ad.IBidding
            public int getECPM() {
                return this.f3447a.f();
            }

            @Override // com.heytap.msp.mobad.api.ad.IBidding
            public void notifyRankLoss(int i, String str, int i2) {
                this.f3447a.a(i, str, i2);
            }

            @Override // com.heytap.msp.mobad.api.ad.IBidding
            public void notifyRankWin(int i) {
                this.f3447a.b(i);
            }

            @Override // com.heytap.msp.mobad.api.params.INativeTempletAdView
            public void render() {
                this.f3447a.b();
            }

            @Override // com.heytap.msp.mobad.api.ad.IBidding
            public void setBidECPM(int i) {
                this.f3447a.c(i);
            }
        }

        public a(INativeTempletAdListener iNativeTempletAdListener) {
            this.b = iNativeTempletAdListener;
        }

        C0419a a(p pVar) {
            return new C0419a(pVar);
        }

        @Override // com.opos.mobad.ad.d.a
        public void a(int i, String str) {
            INativeTempletAdListener iNativeTempletAdListener = this.b;
            if (iNativeTempletAdListener == null) {
                return;
            }
            iNativeTempletAdListener.onAdFailed(new NativeAdError(i, str));
        }

        @Override // com.opos.mobad.ad.d.o
        public void a(q qVar, p pVar) {
            if (this.b == null) {
                return;
            }
            this.b.onRenderFailed(qVar != null ? new NativeAdError(qVar.f6647a, qVar.b) : null, pVar != null ? (INativeTempletAdView) pVar.d() : null);
        }

        @Override // com.opos.mobad.ad.d.a
        public void a(List<p> list) {
            ArrayList arrayList;
            if (this.b == null) {
                return;
            }
            if (list != null) {
                arrayList = new ArrayList();
                for (p pVar : list) {
                    if (pVar != null) {
                        C0419a c0419aA = a(pVar);
                        pVar.a(c0419aA);
                        arrayList.add(c0419aA);
                    }
                }
            } else {
                arrayList = null;
            }
            this.b.onAdSuccess(arrayList);
        }

        @Override // com.opos.mobad.ad.d.o
        public void b(p pVar) {
            if (this.b == null) {
                return;
            }
            this.b.onAdClick(pVar != null ? (INativeTempletAdView) pVar.d() : null);
        }

        @Override // com.opos.mobad.ad.d.o
        public void c(p pVar) {
            if (this.b == null) {
                return;
            }
            this.b.onAdShow(pVar != null ? (INativeTempletAdView) pVar.d() : null);
        }

        @Override // com.opos.mobad.ad.d.o
        public void d(p pVar) {
            if (this.b == null) {
                return;
            }
            this.b.onAdClose(pVar != null ? (INativeTempletAdView) pVar.d() : null);
        }

        @Override // com.opos.mobad.ad.d.o
        public void e(p pVar) {
            if (this.b == null) {
                return;
            }
            this.b.onRenderSuccess(pVar != null ? (INativeTempletAdView) pVar.d() : null);
        }
    }

    public NativeTempletAd(Context context, String str, NativeAdSize nativeAdSize, INativeTempletAdListener iNativeTempletAdListener) {
        if (context == null || TextUtils.isEmpty(str) || iNativeTempletAdListener == null) {
            Log.e(TAG, "NativeTempletAd Constructor param context and posId and iNativeTempletAdListener can't be null.");
            return;
        }
        this.mContext = context;
        this.mPosId = str;
        this.mNativeAdSize = nativeAdSize;
        this.mListener = getListenerWrapper(iNativeTempletAdListener);
        initImplIfNeed();
    }

    private boolean initImplIfNeed() {
        int i;
        int i2;
        if (this.mNativeTempletAdImpl != null) {
            return true;
        }
        if (this.mContext == null || TextUtils.isEmpty(this.mPosId)) {
            return false;
        }
        synchronized (this) {
            if (this.mNativeTempletAdImpl != null) {
                return true;
            }
            NativeAdSize nativeAdSize = this.mNativeAdSize;
            if (nativeAdSize != null) {
                i = nativeAdSize.widthInDp;
                i2 = this.mNativeAdSize.heightInDp;
            } else {
                i = 0;
                i2 = 0;
            }
            this.mNativeTempletAdImpl = com.heytap.msp.mobad.api.a.a().a(this.mContext, this.mPosId, new s.a().a(i).b(i2).a(), this.mListener);
            return this.mNativeTempletAdImpl != null;
        }
    }

    private void loadInter(NativeAdParams nativeAdParams, List<String> list) {
        if (!initImplIfNeed()) {
            a aVar = this.mListener;
            if (aVar != null) {
                aVar.a(-1, "inter ad create fail");
                return;
            }
            return;
        }
        if (nativeAdParams != null) {
            if (list == null) {
                this.mNativeTempletAdImpl.a((int) nativeAdParams.fetchTimeout);
                return;
            } else {
                this.mNativeTempletAdImpl.a((int) nativeAdParams.fetchTimeout, list);
                return;
            }
        }
        n nVar = this.mNativeTempletAdImpl;
        if (list == null) {
            nVar.a();
        } else {
            nVar.a(list);
        }
    }

    public void destroyAd() {
        if (this.mNativeTempletAdImpl != null) {
            this.mNativeTempletAdImpl.b();
        }
        this.mContext = null;
        this.mPosId = null;
    }

    a getListenerWrapper(INativeTempletAdListener iNativeTempletAdListener) {
        return new a(iNativeTempletAdListener);
    }

    public void loadAd() {
        loadAd(null);
    }

    public void loadAd(NativeAdParams nativeAdParams) {
        loadInter(nativeAdParams, (List<String>) null);
    }

    public void loadAd(NativeAdParams nativeAdParams, List<String> list) {
        if (list != null && list.size() > 0) {
            loadInter(nativeAdParams, new ArrayList(list));
            return;
        }
        a aVar = this.mListener;
        if (aVar != null) {
            aVar.a(10701, "load error, please check you bidIds");
        }
    }

    public void loadAdWithData(NativeAdParams nativeAdParams, String str) {
        loadInter(nativeAdParams, str);
    }

    protected void loadInter(NativeAdParams nativeAdParams, String str) {
        if (initImplIfNeed()) {
            if (nativeAdParams != null) {
                this.mNativeTempletAdImpl.a((int) nativeAdParams.fetchTimeout, str);
                return;
            } else {
                this.mNativeTempletAdImpl.a(str);
                return;
            }
        }
        a aVar = this.mListener;
        if (aVar != null) {
            aVar.a(-1, "inter ad create fail");
        }
    }
}
