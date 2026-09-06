package com.miui.zeus.mimo.sdk;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import com.miui.zeus.mimo.sdk.bean.MimoAdInfo;
import com.miui.zeus.mimo.sdk.click.ClickAreaType;
import com.miui.zeus.mimo.sdk.track.info.AdEvent;
import com.miui.zeus.mimo.sdk.view.DeepLinkTipsView;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class a4 extends u3 {
    public final Context b;
    public Dialog c;
    public final Activity d;
    public final w3 e;

    public a4(Context context, Activity activity, w3 w3Var) {
        this.b = context;
        this.d = activity;
        this.e = w3Var;
    }

    /* JADX WARN: Code duplicated, block: B:14:0x0033  */
    /* JADX WARN: Code duplicated, block: B:16:0x003f A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:18:0x0042  */
    /* JADX WARN: Code duplicated, block: B:28:0x0071  */
    /* JADX WARN: Code duplicated, block: B:30:0x0075  */
    /* JADX WARN: Code duplicated, block: B:35:0x00a9  */
    /* JADX WARN: Code duplicated, block: B:38:0x00b6  */
    /* JADX WARN: Code duplicated, block: B:42:0x00cf  */
    /* JADX WARN: Code duplicated, block: B:47:0x00e3  */
    /* JADX WARN: Code duplicated, block: B:48:0x00fa  */
    /* JADX WARN: Code duplicated, block: B:57:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0065, code lost:
    
        if (android.text.TextUtils.equals(ijiami_1011.s.s.s.d(new byte[]{6, 16, 14, 66, com.google.common.base.Ascii.SYN, 0, 19}, "dba5ee"), r4.D) != false) goto L25;
     */
    @Override // com.miui.zeus.mimo.sdk.u3
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(MimoAdInfo mimoAdInfo, ClickAreaType clickAreaType, v3 v3Var, boolean z) {
        Dialog dialog;
        w3 w3Var;
        int dialogThemeId;
        Activity activity;
        Window window;
        WindowManager.LayoutParams attributes;
        if (mimoAdInfo.P0) {
            if (clickAreaType == null) {
                boolean zA = w6.a(this.b, mimoAdInfo);
                if (mimoAdInfo.t()) {
                }
                if (b.b(this.b)) {
                    return;
                }
                dialog = this.c;
                if (dialog != null) {
                    this.c.dismiss();
                }
                b.a(AdEvent.CUSTOM_POPUP_WINDOW_VIEW, mimoAdInfo, (n6) null, (k6) null);
                DeepLinkTipsView deepLinkTipsView = (DeepLinkTipsView) LayoutInflater.from(this.b).inflate(a0.s5, (ViewGroup) null, false);
                deepLinkTipsView.setClickCancelBtn(new y3(this, mimoAdInfo));
                deepLinkTipsView.setClickOkBtn(new z3(this, mimoAdInfo, clickAreaType, v3Var));
                w3Var = this.e;
                if (w3Var != null) {
                    dialogThemeId = a0.c5;
                } else {
                    dialogThemeId = a0.c5;
                }
                Dialog dialog2 = new Dialog(this.d, dialogThemeId);
                this.c = dialog2;
                dialog2.setContentView(deepLinkTipsView);
                activity = this.d;
                window = this.c.getWindow();
                if (window != null) {
                    if (activity.getResources().getConfiguration().orientation == 2) {
                        int i = f9.f5428a;
                        attributes.width = Math.round(activity.getResources().getDisplayMetrics().density * 349.0f);
                    } else {
                        attributes.width = f9.d(activity) - (Math.round(activity.getResources().getDisplayMetrics().density * 21.8f) * 2);
                    }
                    attributes.height = -2;
                    window.setAttributes(attributes);
                }
                this.c.setCanceledOnTouchOutside(false);
                this.c.setCancelable(false);
                this.c.show();
                return;
            }
            String tag = clickAreaType.getTag();
            if (TextUtils.isEmpty(mimoAdInfo.c0) || mimoAdInfo.a(mimoAdInfo.c0, tag)) {
                boolean zA2 = w6.a(this.b, mimoAdInfo);
                if (mimoAdInfo.t()) {
                }
                if (b.b(this.b)) {
                    return;
                }
                dialog = this.c;
                if (dialog != null) {
                    this.c.dismiss();
                }
                b.a(AdEvent.CUSTOM_POPUP_WINDOW_VIEW, mimoAdInfo, (n6) null, (k6) null);
                DeepLinkTipsView deepLinkTipsView2 = (DeepLinkTipsView) LayoutInflater.from(this.b).inflate(a0.s5, (ViewGroup) null, false);
                deepLinkTipsView2.setClickCancelBtn(new y3(this, mimoAdInfo));
                deepLinkTipsView2.setClickOkBtn(new z3(this, mimoAdInfo, clickAreaType, v3Var));
                w3Var = this.e;
                if (w3Var != null) {
                    dialogThemeId = a0.c5;
                } else {
                    dialogThemeId = a0.c5;
                }
                Dialog dialog3 = new Dialog(this.d, dialogThemeId);
                this.c = dialog3;
                dialog3.setContentView(deepLinkTipsView2);
                activity = this.d;
                window = this.c.getWindow();
                if (window != null) {
                    if (activity.getResources().getConfiguration().orientation == 2) {
                        int i2 = f9.f5428a;
                        attributes.width = Math.round(activity.getResources().getDisplayMetrics().density * 349.0f);
                    } else {
                        attributes.width = f9.d(activity) - (Math.round(activity.getResources().getDisplayMetrics().density * 21.8f) * 2);
                    }
                    attributes.height = -2;
                    window.setAttributes(attributes);
                }
                this.c.setCanceledOnTouchOutside(false);
                this.c.setCancelable(false);
                this.c.show();
                return;
            }
            if (TextUtils.equals(ijiami_1011.s.s.s.d(new byte[]{13, 83, 67, 11, 78, 86}, "c27b83"), mimoAdInfo.W)) {
                boolean zA3 = w6.a(this.b, mimoAdInfo);
                if ((mimoAdInfo.t() || !zA3) && (mimoAdInfo.t() || !b.b(this.b, mimoAdInfo.v))) {
                }
                if (b.b(this.b)) {
                    return;
                }
                dialog = this.c;
                if (dialog != null && dialog.isShowing()) {
                    this.c.dismiss();
                }
                b.a(AdEvent.CUSTOM_POPUP_WINDOW_VIEW, mimoAdInfo, (n6) null, (k6) null);
                DeepLinkTipsView deepLinkTipsView3 = (DeepLinkTipsView) LayoutInflater.from(this.b).inflate(a0.s5, (ViewGroup) null, false);
                deepLinkTipsView3.setClickCancelBtn(new y3(this, mimoAdInfo));
                deepLinkTipsView3.setClickOkBtn(new z3(this, mimoAdInfo, clickAreaType, v3Var));
                w3Var = this.e;
                if (w3Var != null || w3Var.getDialogThemeId() == 0) {
                    dialogThemeId = a0.c5;
                } else {
                    dialogThemeId = this.e.getDialogThemeId();
                }
                Dialog dialog4 = new Dialog(this.d, dialogThemeId);
                this.c = dialog4;
                dialog4.setContentView(deepLinkTipsView3);
                activity = this.d;
                window = this.c.getWindow();
                if (window != null && (attributes = window.getAttributes()) != null) {
                    if (activity.getResources().getConfiguration().orientation == 2) {
                        int i3 = f9.f5428a;
                        attributes.width = Math.round(activity.getResources().getDisplayMetrics().density * 349.0f);
                    } else {
                        attributes.width = f9.d(activity) - (Math.round(activity.getResources().getDisplayMetrics().density * 21.8f) * 2);
                    }
                    attributes.height = -2;
                    window.setAttributes(attributes);
                }
                this.c.setCanceledOnTouchOutside(false);
                this.c.setCancelable(false);
                this.c.show();
                return;
            }
        }
        u3 u3Var = this.f5627a;
        if (u3Var != null) {
            u3Var.a(mimoAdInfo, clickAreaType, v3Var, z);
        }
    }
}
