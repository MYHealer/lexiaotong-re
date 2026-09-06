package com.miui.zeus.mimo.sdk.ad.template;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.ViewGroup;
import com.miui.zeus.mimo.sdk.bean.MimoAdInfo;
import com.miui.zeus.mimo.sdk.h3;
import com.miui.zeus.mimo.sdk.i3;
import com.miui.zeus.mimo.sdk.m4;
import com.miui.zeus.mimo.sdk.r3;
import com.miui.zeus.mimo.sdk.utils.error.MimoAdError;
import com.miui.zeus.mimo.sdk.view.AdImpressMonitor;
import ijiami_1011.NCall;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class TemplateUIController {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ViewGroup f5367a;
    public MimoAdInfo b;
    public String c;
    public String d;
    public Context e;
    public h3 f;
    public r3 g;
    public i3 h;
    public final Handler i;
    public AdImpressMonitor j;
    public boolean k = true;

    public interface a {
    }

    public TemplateUIController() {
        Handler handler = new Handler(Looper.getMainLooper());
        this.i = handler;
        this.j = new AdImpressMonitor(handler);
    }

    public static boolean a(TemplateUIController templateUIController, MimoAdInfo mimoAdInfo) {
        return NCall.IZ(new Object[]{119, templateUIController, mimoAdInfo});
    }

    public final void a() {
        NCall.IV(new Object[]{120, this});
    }

    public final void a(MimoAdError mimoAdError, m4 m4Var) {
        NCall.IV(new Object[]{121, this, mimoAdError, m4Var});
    }

    public void b() {
        NCall.IV(new Object[]{122, this});
    }
}
