package com.byazt.sgn;

import android.app.Activity;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import com.byazt.omf.gt;
import com.huawei.hms.ads.ld;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
@com.byazt.zqa.c(c = {0, 1, 211, 67})
public class u extends ve {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public com.byazt.xs.x f2699a;
    public JSONObject n;
    public volatile boolean sp;
    public com.byazt.ux.sp uj;
    public Window ve;
    public boolean x;

    @Override // com.byazt.sgn.ve
    public void tt() {
    }

    public u(Activity activity, JSONObject jSONObject, com.byazt.ux.sp spVar) {
        super(activity);
        this.ve = activity == null ? null : activity.getWindow();
        this.n = jSONObject;
        this.uj = spVar;
        this.f2699a = new com.byazt.xs.x(activity);
    }

    @Override // com.byazt.sgn.ve, android.app.AlertDialog, android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // com.byazt.sgn.ve
    public void c() {
        if (this.c == null) {
            this.c = gt.getContext();
        }
        if (this.c.getResources().getConfiguration().orientation != 1) {
            this.x = true;
            super.c();
            super.tt();
            sp();
            return;
        }
        n();
        a();
    }

    private void n() {
        if (this.ve != null) {
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setColor(-1);
            this.ve.setBackgroundDrawable(gradientDrawable);
            WindowManager.LayoutParams attributes = this.ve.getAttributes();
            attributes.alpha = 1.0f;
            this.ve.setAttributes(attributes);
        }
    }

    private void a() {
        JSONObject jSONObject = this.n;
        if (jSONObject == null || this.uj == null) {
            return;
        }
        JSONObject jSONObjectC = com.byazt.xs.da.c(jSONObject.remove("ugen_url").toString(), this.n.remove("ugen_md5").toString(), (com.byazt.xs.ve) null);
        if (jSONObjectC == null) {
            this.uj.c(11, "uegnTemplate is empty");
            this.sp = true;
        } else {
            final FrameLayout frameLayout = new FrameLayout(this.c);
            frameLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            this.f2699a.c(jSONObjectC, this.n, new com.byazt.ux.sp() { // from class: com.byazt.sgn.u.1
                @Override // com.byazt.ux.sp
                public void c(int i, String str) {
                    u.this.sp = true;
                    if (u.this.uj != null) {
                        FrameLayout frameLayout2 = frameLayout;
                        if (frameLayout2 != null) {
                            frameLayout2.removeAllViews();
                        }
                        u.this.uj.c(i, str);
                    }
                }

                @Override // com.byazt.ux.sp
                public void c(com.byazt.xj.ve<View> veVar) {
                    u.this.sp = false;
                    if (u.this.uj != null) {
                        u.this.uj.c(null);
                    }
                    frameLayout.addView(veVar.i(), new FrameLayout.LayoutParams(veVar.or(), veVar.cu()));
                    u.this.setContentView(frameLayout);
                }
            });
        }
    }

    private void sp() {
        JSONObject jSONObject = this.n;
        if (jSONObject == null) {
            return;
        }
        c(jSONObject.optString("app_name"));
        n(this.n.optString("app_version"));
        a(this.n.optString("reg_number"));
        sp(this.n.optString("reg_url"));
        tt(this.n.optString("icon_url"));
        x(this.n.optString("developer_name"));
        c(this.n.optInt("score"));
        c(this.n.optJSONArray("creative_tags"));
        uj(this.n.optString(ld.L));
    }

    @Override // com.byazt.sgn.ve
    public void ve() {
        if (this.x) {
            super.ve();
        }
    }

    public void tt(ve.c cVar) {
        super.c(cVar);
        com.byazt.xs.x xVar = this.f2699a;
        if (xVar != null) {
            xVar.c(cVar);
        }
    }

    @Override // com.byazt.sgn.ve, android.app.Dialog
    public void show() {
        super.show();
        if (this.sp) {
            hide();
            dismiss();
        }
    }
}
