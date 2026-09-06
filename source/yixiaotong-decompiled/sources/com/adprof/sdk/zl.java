package com.adprof.sdk;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.adprof.sdk.api.AdError;
import java.util.HashMap;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public abstract class zl extends RelativeLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f1560a = 0;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public ViewGroup f921a;

    public zl(Context context, ViewGroup viewGroup) {
        super(context);
        this.f921a = viewGroup;
    }

    public abstract void a();

    public abstract void a(d dVar);

    public void a(d dVar, Bitmap bitmap) {
    }

    public void a(d dVar, View view) {
        ViewGroup viewGroup;
        if (view != null && (viewGroup = this.f921a) != null) {
            viewGroup.post(new yl(this, dVar, view));
            return;
        }
        HashMap map = new HashMap();
        map.put("error", AdError.ERROR_AD_CONTAINER_VISIBILITY);
        s5.a(dVar.k(), map, "action.splash.play.error", 0);
    }

    /* JADX INFO: renamed from: a */
    public boolean mo586a() {
        return true;
    }

    public abstract void b();

    public abstract void c();

    public void d() {
        setVisibility(0);
    }

    public void setVideoMute(boolean z) {
    }
}
