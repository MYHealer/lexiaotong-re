package com.hihonor.adsdk.reward.e;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.hihonor.adsdk.base.api.BaseAd;
import com.hihonor.adsdk.base.callback.AdListener;
import com.hihonor.adsdk.reward.e.c;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public abstract class a<VH extends c> {
    private static final String b = "BaseRewardAdapter";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final BaseAd f3562a;

    /* JADX INFO: renamed from: com.hihonor.adsdk.reward.e.a$a, reason: collision with other inner class name */
    protected enum EnumC0470a {
        LAYOUT_NORMAL,
        LAYOUT_NORMAL_DOWNLOAD,
        LAYOUT_LARGE,
        LAYOUT_LARGE_DOWNLOAD
    }

    public a(BaseAd baseAd) {
        this.f3562a = baseAd;
    }

    public abstract int a();

    public VH a(Context context) {
        View viewB = b(context);
        if (viewB == null) {
            return null;
        }
        return (VH) a(viewB, context);
    }

    protected abstract VH a(View view, Context context);

    protected View b(Context context) {
        try {
            return LayoutInflater.from(context).inflate(a(), (ViewGroup) null);
        } catch (Throwable th) {
            com.hihonor.adsdk.common.b.b.hnadsb(b, "onCreateView exception:" + th.getMessage(), new Object[0]);
            return null;
        }
    }

    public void c(VH vh) {
        vh.c();
    }

    protected boolean d() {
        return com.hihonor.adsdk.reward.c.a();
    }

    protected boolean c() {
        return this.f3562a.getPromotionPurpose() == 0 || this.f3562a.getPromotionPurpose() == 4;
    }

    public static abstract class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        protected final View f3564a;
        protected final Context b;

        public b(View view, Context context) {
            this.f3564a = view;
            this.b = context;
        }

        public View a() {
            return this.f3564a;
        }

        public void a(boolean z) {
        }

        public void b() {
        }

        public void b(boolean z) {
        }

        public void c() {
        }

        protected <T extends View> T b(int i) {
            View view = this.f3564a;
            if (view == null) {
                return null;
            }
            return (T) view.findViewById(i);
        }

        protected <T extends View> T a(int i) {
            Context context = this.b;
            if (context == null) {
                return null;
            }
            return (T) ((Activity) context).findViewById(i);
        }
    }

    public void b(VH vh) {
        vh.a(true);
    }

    protected EnumC0470a b() {
        if (c()) {
            return d() ? EnumC0470a.LAYOUT_LARGE_DOWNLOAD : EnumC0470a.LAYOUT_NORMAL_DOWNLOAD;
        }
        return d() ? EnumC0470a.LAYOUT_LARGE : EnumC0470a.LAYOUT_NORMAL;
    }

    public void a(VH vh, AdListener adListener, o oVar, x xVar) {
        vh.a(this.f3562a, adListener, oVar, xVar);
    }

    public void a(VH vh) {
        vh.b();
    }

    public void a(VH vh, boolean z) {
        vh.b(z);
    }
}
