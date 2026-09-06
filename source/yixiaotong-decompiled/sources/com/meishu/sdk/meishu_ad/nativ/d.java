package com.meishu.sdk.meishu_ad.nativ;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.meishu.sdk.core.ad.AdSlot;
import com.meishu.sdk.core.ad.AdType;
import com.meishu.sdk.core.utils.h0;
import com.meishu.sdk.core.utils.i0;
import com.meishu.sdk.meishu_ad.n0;
import java.io.File;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: NativeAdDataImpl.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class d extends com.meishu.sdk.core.ad.a implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f5045a;
    public int b;
    public String c;
    public String[] d;
    public String e;
    public String f;
    public boolean g;
    public n0 h;
    public f i;
    public Context j;
    public boolean k;
    public volatile boolean l;

    /* JADX INFO: compiled from: NativeAdDataImpl.java */
    public class a implements com.meishu.sdk.core.bquery.j<File> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ n0 f5046a;

        public a(n0 n0Var) {
            this.f5046a = n0Var;
        }

        @Override // com.meishu.sdk.core.bquery.j
        public void onFail(int i, String str) {
        }

        @Override // com.meishu.sdk.core.bquery.j
        public void onSuccess(String str, File file) {
            File file2 = file;
            try {
                if (file2.length() >= i0.a()) {
                    return;
                }
                d.this.i.D = System.currentTimeMillis();
                f fVar = d.this.i;
                String[] monitorUrl = fVar.getMonitorUrl();
                StringBuilder sbAppend = new StringBuilder().append(d.this.i.C).append(".0.");
                d.this.i.getClass();
                fVar.setMonitorUrl(h0.b(monitorUrl, sbAppend.append(d.this.i.D).toString()));
                this.f5046a.setVideoPath(file2.getAbsolutePath());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public d(f fVar) {
        super(null, "MS");
        this.l = false;
        this.i = fVar;
    }

    @Override // com.meishu.sdk.platform.ms.c
    public AdSlot a() {
        return this.i;
    }

    @Override // com.meishu.sdk.meishu_ad.nativ.b, com.meishu.sdk.platform.ms.c
    public f a() {
        return this.i;
    }

    @Override // com.meishu.sdk.meishu_ad.nativ.b
    public int getAdPatternType() {
        return this.b;
    }

    @Override // com.meishu.sdk.platform.ms.c
    public AdType getAdType() {
        return AdType.FEED;
    }

    @Override // com.meishu.sdk.meishu_ad.nativ.b
    public String getDesc() {
        return this.f;
    }

    @Override // com.meishu.sdk.meishu_ad.nativ.b
    public String getIconUrl() {
        return this.c;
    }

    @Override // com.meishu.sdk.meishu_ad.nativ.b
    public String[] getImgUrls() {
        return this.d;
    }

    @Override // com.meishu.sdk.meishu_ad.nativ.b, com.meishu.sdk.platform.ms.c
    public int getInteractionType() {
        return this.i.getInteractionType();
    }

    @Override // com.meishu.sdk.meishu_ad.nativ.b
    public n0 getMediaView() {
        return this.h;
    }

    @Override // com.meishu.sdk.meishu_ad.nativ.b
    public String getTitle() {
        return this.e;
    }

    @Override // com.meishu.sdk.meishu_ad.nativ.b
    public void a(Context context, ViewGroup viewGroup, List<View> list, com.meishu.sdk.platform.ms.recycler.d dVar) {
        if (context instanceof Activity) {
            this.j = context;
        } else {
            this.j = viewGroup.getContext();
        }
        if (list != null) {
            Iterator<View> it = list.iterator();
            while (it.hasNext()) {
                it.next().setOnClickListener(new c(this, viewGroup, dVar));
            }
        }
    }

    @Override // com.meishu.sdk.core.ad.a, com.meishu.sdk.core.ad.IAd
    public View getAdView() {
        return this.h.getVideoView();
    }

    @Override // com.meishu.sdk.platform.ms.c
    public Context getContext() {
        Context context = this.j;
        return context != null ? context : this.h.getVideoView().getContext();
    }

    @Override // com.meishu.sdk.meishu_ad.nativ.b
    public void a(ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams, e eVar) {
        n0 n0Var = this.h;
        com.meishu.sdk.core.bquery.i iVar = new com.meishu.sdk.core.bquery.i(viewGroup);
        iVar.a(this.i.g, 86400000, true, new com.meishu.sdk.core.bquery.d(iVar, new a(n0Var)));
        if (n0Var != null) {
            n0Var.setNativeAdMediaListener(eVar);
            ViewGroup viewGroup2 = (ViewGroup) n0Var.getParent();
            if (viewGroup2 != null) {
                viewGroup2.removeAllViews();
            }
            if (viewGroup != null) {
                if (layoutParams != null) {
                    viewGroup.addView(this.h.getVideoView(), layoutParams);
                } else {
                    viewGroup.addView(this.h.getVideoView());
                }
            }
        }
    }
}
