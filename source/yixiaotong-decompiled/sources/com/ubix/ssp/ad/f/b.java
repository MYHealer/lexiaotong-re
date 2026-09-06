package com.ubix.ssp.ad.f;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import com.ubix.ssp.ad.e.v.e;
import com.ubix.ssp.ad.g.d;
import com.ubix.ssp.ad.g.g;
import com.ubix.ssp.ad.i.c;
import com.ubix.ssp.open.AdError;
import com.ubix.ssp.open.AdSize;
import com.ubix.ssp.open.ParamsReview;
import com.ubix.ssp.open.nativee.NativeAd;
import com.ubix.ssp.open.nativee.UBiXNativeInteractionListener;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.HashMap;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class b implements g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private d f8958a;
    private c b;
    private AdSize c;
    private SoftReference<Context> d;
    private com.ubix.ssp.ad.f.a e;
    private NativeAd f;
    private boolean g;

    class a implements e.b {
        a() {
        }

        @Override // com.ubix.ssp.ad.e.v.e.b
        public void a(e eVar, String str, String str2, boolean z) {
            b.this.b(str);
        }

        @Override // com.ubix.ssp.ad.e.v.e.b
        public void a(AdError adError) {
            b.this.a(adError);
        }
    }

    /* JADX INFO: renamed from: com.ubix.ssp.ad.f.b$b, reason: collision with other inner class name */
    class C1114b implements UBiXNativeInteractionListener {
        C1114b() {
        }

        @Override // com.ubix.ssp.open.nativee.UBiXNativeInteractionListener
        public void onAdClicked(View view) {
            if (b.this.f8958a != null) {
                b.this.f8958a.onAdClicked(view);
            }
        }

        @Override // com.ubix.ssp.open.nativee.UBiXNativeInteractionListener
        public void onAdClosed() {
            if (b.this.f8958a != null) {
                b.this.f8958a.onAdClosed();
            }
        }

        @Override // com.ubix.ssp.open.nativee.UBiXNativeInteractionListener
        public void onAdExposeFailed(AdError adError) {
            if (b.this.f8958a != null) {
                b.this.f8958a.onAdExposeFailed(adError);
            }
        }

        @Override // com.ubix.ssp.open.nativee.UBiXNativeInteractionListener
        public void onAdExposed() {
            if (b.this.f8958a != null) {
                b.this.f8958a.onAdExposed();
            }
        }

        @Override // com.ubix.ssp.open.nativee.UBiXNativeInteractionListener
        public void onAdStatusChanged() {
        }
    }

    public b(Context context, String str) {
        this(context, str, new AdSize(-1, -2));
    }

    public b(Context context, String str, AdSize adSize) {
        this.g = false;
        this.d = new SoftReference<>(context);
        this.c = adSize == null ? new AdSize(-1, -2) : adSize;
        c cVar = new c(context, str, this);
        this.b = cVar;
        cVar.q(3);
    }

    private ArrayList<View> a(ViewGroup viewGroup) {
        ArrayList<View> arrayList = new ArrayList<>();
        for (int i = 0; i < viewGroup.getChildCount(); i++) {
            View childAt = viewGroup.getChildAt(i);
            if (childAt != null) {
                arrayList.add(childAt);
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AdError adError) {
        this.g = false;
        this.b.c(adError);
        this.b.e(adError);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(String str) {
        this.b.w();
        this.b.D();
        com.ubix.ssp.ad.d.a aVarN = this.b.n(0);
        Bundle bundle = new Bundle();
        bundle.putStringArray("IMAGE_URL", new String[]{str});
        bundle.putInt("AD_WIDTH", this.c.getWidth());
        bundle.putInt("AD_HEIGHT", this.c.getHeight());
        bundle.putInt("TEMPLATE_ID", aVarN.p);
        bundle.putString("AD_SOURCE", aVarN.f8604a.d.t);
        bundle.putBoolean("IS_UNNAMED", aVarN.v);
        com.ubix.ssp.ad.f.a aVar = (com.ubix.ssp.ad.f.a) com.ubix.ssp.ad.b.a(this.d.get(), bundle, 3, true);
        this.e = aVar;
        aVar.b(bundle);
        c cVar = this.b;
        com.ubix.ssp.ad.f.a aVar2 = this.e;
        cVar.b(aVarN, aVar2, a(aVar2), this.e.findViewById(600004), new C1114b());
        this.g = true;
        d dVar = this.f8958a;
        if (dVar != null) {
            dVar.onAdLoadSucceed();
        }
    }

    public void a() {
    }

    public void a(long j) {
        com.ubix.ssp.ad.d.a aVarN = this.b.n(0);
        if (aVarN != null) {
            this.b.a(aVarN, j);
        }
    }

    public void a(d dVar) {
        this.f8958a = dVar;
    }

    public void a(String str) {
        c cVar = this.b;
        if (cVar != null) {
            cVar.h(str);
        }
    }

    @Override // com.ubix.ssp.ad.g.g
    public void a(ArrayList<NativeAd> arrayList) {
        if (arrayList == null || arrayList.size() <= 0) {
            return;
        }
        NativeAd nativeAd = arrayList.get(0);
        this.f = nativeAd;
        String imageUrl = nativeAd.getImageUrl();
        this.b.v();
        e.b().a(imageUrl, new a());
    }

    public void a(HashMap<String, String> map) {
        com.ubix.ssp.ad.d.a aVarN = this.b.n(0);
        if (aVarN != null) {
            this.b.c(aVarN, map);
        }
    }

    public String b() {
        c cVar = this.b;
        if (cVar != null) {
            return cVar.B();
        }
        return null;
    }

    public View c() {
        return this.e;
    }

    public ParamsReview d() {
        try {
            c cVar = this.b;
            if (cVar == null) {
                return null;
            }
            return this.b.o(cVar.n(0));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public long e() {
        NativeAd nativeAd = this.f;
        if (nativeAd != null) {
            return nativeAd.getPrice();
        }
        return 0L;
    }

    public boolean f() {
        c cVar = this.b;
        return cVar != null && this.g && cVar.s(cVar.n(0));
    }

    public void g() {
        this.b.C();
    }

    @Override // com.ubix.ssp.ad.g.g
    public void onAdLoadFailed(AdError adError) {
        d dVar = this.f8958a;
        if (dVar != null) {
            dVar.onAdLoadFailed(adError);
        }
    }
}
