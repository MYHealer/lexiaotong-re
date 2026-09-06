package com.byazt.iyp;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import com.byazt.aas.nb;
import com.byazt.ete.ic;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.huawei.openalliance.ad.views.PPSLabelView;
import java.lang.ref.WeakReference;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_FIX_PROCESS_TIMER, 13})
public final class tt {
    /* JADX WARN: Code duplicated, block: B:15:0x0048  */
    public static void c(com.byazt.dj.tt ttVar, boolean z, final String str) {
        Boolean boolValueOf;
        String str2;
        String str3;
        String strA;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            if (x.c(ve.c(), str)) {
                Activity activityC = c();
                Boolean bool = Boolean.FALSE;
                if (activityC != null) {
                    strA = uj.a();
                    sl.c(activityC);
                    CharSequence title = activityC.getTitle();
                    String name = activityC.getClass().getName();
                    boolValueOf = Boolean.valueOf(activityC.hasWindowFocus());
                    if (title != null) {
                        String string = title.toString();
                        if (TextUtils.isEmpty(string)) {
                            str2 = null;
                        } else {
                            str2 = string;
                        }
                    } else {
                        str2 = null;
                    }
                    str3 = name;
                } else {
                    boolValueOf = bool;
                    str2 = null;
                    str3 = null;
                    strA = null;
                }
                String strU = ttVar != null ? ttVar.u() : PPSLabelView.Code;
                if (z) {
                    c.c(str, new c.C0188c(str2, str3, strA, boolValueOf, null, null, strU));
                    if (x.c(ve.n(), str)) {
                        final StackTraceElement[] stackTraceElementArrC = x.c();
                        final int iTt = ve.tt();
                        com.byazt.bzd.x.c(new com.byazt.bwm.sp("stage_feature") { // from class: com.byazt.iyp.tt.1
                            @Override // java.lang.Runnable
                            public void run() {
                                try {
                                    JSONArray jSONArrayC = x.c(stackTraceElementArrC, iTt);
                                    c.c(str, jSONArrayC, (jSONArrayC == null || jSONArrayC.length() <= 0) ? PPSLabelView.Code : x.c(jSONArrayC));
                                } catch (Throwable unused) {
                                }
                            }
                        });
                    }
                }
            }
        } catch (Throwable unused) {
        }
    }

    public static void c(ic icVar, String str) {
        if (icVar == null || TextUtils.isEmpty(icVar.c())) {
            return;
        }
        try {
            if (x.c(ve.c(), icVar.c())) {
                JSONObject jSONObject = new JSONObject();
                c.C0188c c0188cC = c.c(icVar.c());
                String strU = PPSLabelView.Code;
                if (c0188cC != null) {
                    jSONObject.put("top_page_title", c0188cC.c);
                    jSONObject.put("top_page_name", c0188cC.tt);
                    jSONObject.put("t_name", c0188cC.ve);
                    jSONObject.put("has_window_focus", c0188cC.uj.booleanValue());
                    jSONObject.put("call_chain", c0188cC.n != null ? c0188cC.n.toString() : PPSLabelView.Code);
                    if (c0188cC.f2359a != null) {
                        strU = c0188cC.f2359a;
                    }
                    jSONObject.put("stack_hash", strU);
                    jSONObject.put("media_extra", c0188cC.sp);
                    jSONObject.put("is_hit_chain", x.c(ve.n(), icVar.c()));
                } else {
                    sl.c(jSONObject, (Activity) null);
                    com.byazt.dj.tt ttVarIj = icVar.ij();
                    if (ttVarIj != null) {
                        if (!TextUtils.isEmpty(ttVarIj.u())) {
                            strU = ttVarIj.u();
                        }
                        jSONObject.put("media_extra", strU);
                    }
                }
                jSONObject.put("app_version", nb.da());
                jSONObject.put("app_no_tab", sp.ve());
                com.byazt.ddx.uj.tt(icVar, str, "load_feature", jSONObject);
            }
        } catch (Throwable unused) {
        }
    }

    public static void c(final String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            if (x.c(ve.n(), str)) {
                final StackTraceElement[] stackTraceElementArrC = x.c();
                final int iTt = ve.tt();
                com.byazt.bzd.x.c(new com.byazt.bwm.sp("stage_feature") { // from class: com.byazt.iyp.tt.2
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            c.c(str, x.c(stackTraceElementArrC, iTt));
                        } catch (Throwable unused) {
                        }
                    }
                });
            }
        } catch (Throwable unused) {
        }
    }

    public static void c(ic icVar, String str, View view, boolean z) {
        if (icVar == null || view == null) {
            return;
        }
        try {
            if (x.c(ve.c(), icVar.c())) {
                JSONObject jSONObject = new JSONObject();
                sl.c(jSONObject, (Activity) null);
                JSONArray jSONArrayVe = c.ve(icVar.c());
                if (jSONArrayVe != null) {
                    jSONObject.put("call_chain", jSONArrayVe.toString());
                    jSONObject.put("stack_hash", x.c(jSONArrayVe));
                } else {
                    jSONObject.put("call_chain", PPSLabelView.Code);
                    jSONObject.put("stack_hash", PPSLabelView.Code);
                }
                boolean zC = x.c(ve.n(), icVar.c());
                t.c(jSONObject, view, ve.tt(), zC);
                jSONObject.put("is_preload", z);
                jSONObject.put("app_version", nb.da());
                jSONObject.put("is_hit_chain", zC);
                com.byazt.ddx.uj.tt(icVar, str, "show_feature", jSONObject);
            }
        } catch (Throwable unused) {
        }
    }

    public static void c(final ic icVar, final String str, Activity activity, String str2, boolean z) {
        if (icVar == null) {
            return;
        }
        try {
            if (x.c(ve.c(), icVar.c())) {
                boolean zC = x.c(ve.n(), icVar.c());
                final StackTraceElement[] stackTraceElementArrC = zC ? x.c() : null;
                final int iTt = ve.tt();
                final JSONObject jSONObject = new JSONObject();
                sl.c(jSONObject, activity);
                if (TextUtils.isEmpty(str2)) {
                    str2 = PPSLabelView.Code;
                }
                jSONObject.put("rit_scene", str2);
                jSONObject.put("is_preload", z);
                jSONObject.put("app_version", nb.da());
                jSONObject.put("is_hit_chain", zC);
                com.byazt.bzd.x.c(new com.byazt.bwm.sp("stage_feature") { // from class: com.byazt.iyp.tt.3
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            StackTraceElement[] stackTraceElementArr = stackTraceElementArrC;
                            if (stackTraceElementArr != null) {
                                JSONArray jSONArrayC = x.c(stackTraceElementArr, iTt);
                                jSONObject.put("call_chain", jSONArrayC.toString());
                                jSONObject.put("stack_hash", x.c(jSONArrayC));
                            } else {
                                jSONObject.put("call_chain", PPSLabelView.Code);
                                jSONObject.put("stack_hash", PPSLabelView.Code);
                            }
                            com.byazt.ddx.uj.tt(icVar, str, "show_feature", jSONObject);
                        } catch (Throwable unused) {
                        }
                    }
                });
            }
        } catch (Throwable unused) {
        }
    }

    private static Activity c() {
        try {
            com.byazt.aas.c cVarVe = com.byazt.omf.x.m().ve();
            WeakReference<Activity> weakReferenceC = cVarVe != null ? cVarVe.c() : null;
            if (weakReferenceC != null) {
                return weakReferenceC.get();
            }
        } catch (Throwable unused) {
        }
        return null;
    }
}
