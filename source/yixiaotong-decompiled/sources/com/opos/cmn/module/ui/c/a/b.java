package com.opos.cmn.module.ui.c.a;

import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.huawei.openalliance.ad.constant.x;
import com.opos.cmn.module.ui.c.d.c;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class b extends a {
    private ImageView f;
    private TextView g;
    private com.opos.cmn.module.ui.a.a h;

    public b(Context context, c cVar) {
        super(context, cVar);
    }

    private void b(String str) throws PackageManager.NameNotFoundException {
        Drawable drawableF = com.opos.cmn.an.h.d.a.f(this.f6213a, str);
        if (drawableF != null) {
            this.f.setImageDrawable(drawableF);
        }
    }

    private void c() {
        ImageView imageView = new ImageView(this.f6213a);
        this.f = imageView;
        imageView.setId(1);
        this.f.setScaleType(ImageView.ScaleType.FIT_XY);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(this.f6213a, 43.0f), com.opos.cmn.an.h.f.a.a(this.f6213a, 43.0f));
        layoutParams.addRule(15);
        layoutParams.leftMargin = com.opos.cmn.an.h.f.a.a(this.f6213a, 12.0f);
        this.c.addView(this.f, layoutParams);
    }

    private void c(String str) {
        this.g.setText("您下载的【" + d(str) + "】已经安装完成，是否立即打开？");
    }

    private String d(String str) {
        String strG = com.opos.cmn.an.h.d.a.g(this.f6213a, str);
        try {
            if (!com.opos.cmn.an.d.a.a(strG) && strG.length() > 0) {
                int iIndexOf = strG.indexOf("(");
                int iIndexOf2 = strG.indexOf(")");
                com.opos.cmn.an.f.a.b("ReminderToast", "english first=" + iIndexOf + ",english last=" + iIndexOf2);
                if (-1 == iIndexOf || -1 == iIndexOf2) {
                    iIndexOf = strG.indexOf("（");
                    iIndexOf2 = strG.indexOf("）");
                    com.opos.cmn.an.f.a.b("ReminderToast", "chinese first=" + iIndexOf + ",chinese last=" + iIndexOf2);
                }
                if (-1 != iIndexOf && -1 != iIndexOf2 && iIndexOf2 > iIndexOf) {
                    strG = strG.substring(0, iIndexOf) + strG.substring(iIndexOf2 + 1, strG.length());
                }
                int iIndexOf3 = strG.indexOf(x.A);
                com.opos.cmn.an.f.a.b("ReminderToast", "english - =" + iIndexOf3);
                if (-1 == iIndexOf3) {
                    iIndexOf3 = strG.indexOf("—");
                    com.opos.cmn.an.f.a.b("ReminderToast", "chinese — =" + iIndexOf3);
                }
                if (-1 != iIndexOf3) {
                    strG = strG.substring(0, iIndexOf3);
                }
            }
        } catch (Exception e) {
            com.opos.cmn.an.f.a.a("ReminderToast", "", (Throwable) e);
        }
        com.opos.cmn.an.f.a.b("ReminderToast", "getAppDefaultTitle=" + strG);
        return strG;
    }

    private void d() {
        TextView textView = new TextView(this.f6213a);
        this.g = textView;
        textView.setTextColor(Color.parseColor("#2f2f2f"));
        this.g.setTextSize(1, 12.0f);
        this.g.setMaxLines(2);
        this.g.setEllipsize(TextUtils.TruncateAt.END);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(1, 1);
        layoutParams.addRule(0, 2);
        layoutParams.addRule(15);
        layoutParams.leftMargin = com.opos.cmn.an.h.f.a.a(this.f6213a, 19.0f);
        layoutParams.rightMargin = com.opos.cmn.an.h.f.a.a(this.f6213a, 19.0f);
        this.c.addView(this.g, layoutParams);
    }

    private void e() {
        com.opos.cmn.module.ui.a.a aVar = new com.opos.cmn.module.ui.a.a(this.f6213a, "opos_module_biz_ui_cmn_reminder_toast_click_bn_normal_img.png", "opos_module_biz_ui_cmn_reminder_toast_click_bn_pressed_img.png");
        this.h = aVar;
        aVar.setText("立即打开");
        this.h.setId(2);
        this.h.setTextColor(-1);
        this.h.setTextSize(1, 10.0f);
        this.h.setGravity(17);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(this.f6213a, 66.0f), com.opos.cmn.an.h.f.a.a(this.f6213a, 22.0f));
        layoutParams.addRule(15);
        layoutParams.addRule(11);
        layoutParams.rightMargin = com.opos.cmn.an.h.f.a.a(this.f6213a, 12.0f);
        this.c.addView(this.h, layoutParams);
    }

    @Override // com.opos.cmn.module.ui.c.a.a
    public void a(String str, boolean z, Object... objArr) {
        com.opos.cmn.module.ui.a.a aVar;
        try {
            if (com.opos.cmn.an.d.a.a(str)) {
                return;
            }
            com.opos.cmn.an.f.a.b("ReminderToast", "setCustomViewData pkgName=" + str + ",gbClick=" + z + ",objects=" + (objArr != null ? objArr : "null"));
            b(str);
            c(str);
            a(str);
            if (z) {
                a(this.c, str);
                aVar = this.h;
            } else {
                a(this.c);
                aVar = this.h;
            }
            a(aVar, str);
        } catch (Exception e) {
            com.opos.cmn.an.f.a.a("ReminderToast", "", (Throwable) e);
        }
    }

    @Override // com.opos.cmn.module.ui.c.a.a
    public void b() {
        c();
        e();
        d();
    }
}
