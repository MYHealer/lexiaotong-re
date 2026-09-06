package com.hihonor.adsdk.reward.e;

import android.app.Activity;
import android.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.hihonor.adsdk.base.api.BaseAd;
import com.hihonor.adsdk.base.callback.AdListener;
import com.hihonor.adsdk.reward.R;
import java.util.Objects;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class d extends AlertDialog {
    private static final String i = "PlayFinishDialog";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final View f3567a;
    private final View b;
    private final Activity c;
    private final BaseAd d;
    private final a e;
    private final AdListener f;
    private final com.hihonor.adsdk.base.widget.base.e g;
    private final w h;

    public interface a {
        void a();
    }

    public d(Activity activity, BaseAd baseAd, AdListener adListener, com.hihonor.adsdk.base.widget.base.e eVar, a aVar) {
        super(activity, R.style.honor_ads_dialog_style);
        this.h = new w();
        this.c = activity;
        this.f = adListener;
        this.g = eVar;
        this.e = aVar;
        this.d = baseAd;
        View viewInflate = LayoutInflater.from(activity).inflate(a(), (ViewGroup) null);
        this.f3567a = viewInflate;
        this.b = viewInflate.findViewById(R.id.ad_reward_picture_text_view);
        n();
        i();
        setCanceledOnTouchOutside(false);
        setCancelable(false);
        c();
        com.hihonor.adsdk.reward.c.a(getWindow());
    }

    private int a() {
        int i2 = R.layout.honor_ads_reward_pt_play_finish;
        if (!Objects.nonNull(this.d) || this.d.getPromotionPurpose() != 0) {
            return i2;
        }
        com.hihonor.adsdk.common.b.b.hnadsc(i, "PlayFinishDialog,isDownload", new Object[0]);
        return R.layout.honor_ads_reward_pt_playfinish_download;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(View view) {
        com.hihonor.adsdk.reward.c.a(this.c, "c4m12g12t4-c4m12g12t8-c6m12g12t12", view.getMeasuredWidth(), view.getMeasuredHeight(), this.b);
    }

    private void c() {
        ImageView imageView = (ImageView) this.f3567a.findViewById(R.id.ad_reward_close_dialog);
        ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
        if (layoutParams instanceof FrameLayout.LayoutParams) {
            ((FrameLayout.LayoutParams) layoutParams).topMargin = com.hihonor.adsdk.common.f.u.hnadsh();
        } else {
            com.hihonor.adsdk.common.b.b.hnadse(i, "showPlayFinishDialog closeLayoutParams error!!!", new Object[0]);
        }
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.hihonor.adsdk.reward.e.d$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.a(view);
            }
        });
    }

    private void e() {
        com.hihonor.adsdk.reward.c.a(this.f3567a, this.d);
    }

    private void f() {
        com.hihonor.adsdk.reward.c.b(this.f3567a, this.d, false);
    }

    private void g() {
        Activity activity = this.c;
        View view = this.f3567a;
        BaseAd baseAd = this.d;
        com.hihonor.adsdk.base.widget.base.e eVar = this.g;
        w wVar = this.h;
        com.hihonor.adsdk.reward.c.a(activity, view, baseAd, eVar, wVar.f3578a, wVar.b, this.f, wVar.c);
    }

    private void h() {
        com.hihonor.adsdk.reward.c.c(this.f3567a, this.d, false);
    }

    private void i() {
        j();
        e();
        g();
        l();
        b();
        d();
        m();
        k();
        h();
        f();
    }

    private void j() {
        if (Objects.isNull(this.b)) {
            com.hihonor.adsdk.common.b.b.hnadse(i, "initPictureTextViewLayoutClick,pictureViewTextView is null", new Object[0]);
            return;
        }
        this.b.setOnTouchListener(this.h);
        View view = this.b;
        BaseAd baseAd = this.d;
        com.hihonor.adsdk.base.widget.base.e eVar = this.g;
        w wVar = this.h;
        com.hihonor.adsdk.reward.c.a(view, baseAd, eVar, 9, wVar.f3578a, wVar.b, this.f, wVar.c);
    }

    private void k() {
        com.hihonor.adsdk.reward.c.d(this.f3567a, this.d, false);
    }

    private void l() {
        com.hihonor.adsdk.reward.c.e(this.f3567a, this.d, false);
    }

    private void m() {
        com.hihonor.adsdk.reward.c.f(this.f3567a, this.d, false);
    }

    private void n() {
        final View viewFindViewById = findViewById(android.R.id.content);
        viewFindViewById.post(new Runnable() { // from class: com.hihonor.adsdk.reward.e.d$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.b(viewFindViewById);
            }
        });
    }

    protected void d() {
        com.hihonor.adsdk.reward.c.a(this.f3567a, this.d, false);
    }

    @Override // android.app.Dialog
    public void show() {
        if (!com.hihonor.adsdk.common.f.h.hnadsa(this.c)) {
            com.hihonor.adsdk.common.b.b.hnadse(i, "showPlayFinishDialog activity is finish", new Object[0]);
            return;
        }
        super.show();
        Window window = getWindow();
        if (window != null) {
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.width = -1;
            attributes.height = -1;
            window.setAttributes(attributes);
            window.setContentView(this.f3567a);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(View view) {
        dismiss();
        if (Objects.nonNull(this.d)) {
            new com.hihonor.adsdk.base.g.j.d.g(this.d.getAdUnitId(), com.hihonor.adsdk.base.g.j.g.b.hnadsa(this.d), "showPlayFinishDialog,finish").hnadse();
        }
        a aVar = this.e;
        if (aVar != null) {
            aVar.a();
        }
    }

    protected void b() {
        View view = this.f3567a;
        BaseAd baseAd = this.d;
        com.hihonor.adsdk.base.widget.base.e eVar = this.g;
        w wVar = this.h;
        com.hihonor.adsdk.reward.c.a(view, baseAd, eVar, wVar.f3578a, wVar.b, this.f, false, wVar.c);
    }
}
