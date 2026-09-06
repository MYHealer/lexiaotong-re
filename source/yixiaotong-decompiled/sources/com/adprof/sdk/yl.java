package com.adprof.sdk;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import com.adprof.sdk.api.AdError;
import com.huawei.openalliance.ad.views.PPSLabelView;
import java.util.HashMap;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class yl implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ View f1541a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ d f884a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ zl f885a;

    public yl(zl zlVar, d dVar, View view) {
        this.f885a = zlVar;
        this.f884a = dVar;
        this.f1541a = view;
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean z;
        ViewGroup viewGroup = this.f885a.f921a;
        if (viewGroup == null) {
            return;
        }
        try {
            ViewGroup viewGroup2 = (ViewGroup) viewGroup.getParent();
            Rect rect = new Rect();
            int iHeight = (viewGroup2 == null || viewGroup2.getGlobalVisibleRect(rect)) ? rect.height() * rect.width() : 0;
            int iB = h8.b();
            int iM641a = h8.m641a();
            double d = iHeight;
            int i = iB * iM641a;
            double d2 = d / ((double) i);
            boolean globalVisibleRect = viewGroup2.getGlobalVisibleRect(new Rect());
            boolean z2 = ((ViewGroup) viewGroup.getParent()).getVisibility() == 0;
            pk.d("-------adViewVisibleCheck " + String.format("%s*%s = %s  ", Integer.valueOf(iB), Integer.valueOf(iM641a), Integer.valueOf(i)) + PPSLabelView.Code + d2 + PPSLabelView.Code + globalVisibleRect);
            z = d2 > 0.65d && z2;
        } catch (Throwable unused) {
        }
        pk.a("--------Splash callBackShow " + z);
        try {
            if (z) {
                this.f884a.a(this.f1541a.getWidth(), this.f1541a.getHeight());
                s5.a(this.f884a.k(), "action.splash.play");
            } else {
                HashMap map = new HashMap();
                map.put("error", AdError.ERROR_AD_CONTAINER_VISIBILITY);
                s5.a(this.f884a.k(), map, "action.splash.play.error", 0);
            }
        } catch (Throwable unused2) {
        }
    }
}
