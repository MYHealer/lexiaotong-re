package com.adprof.sdk;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.adprof.sdk.api.AdRequest;
import com.adprof.sdk.base.activity.AdActivity;
import com.adprof.sdk.base.view.gif.GifImageView2;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public abstract class yj extends x0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f1539a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public FrameLayout f859a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public ImageView f860a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public RelativeLayout f861a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public GifImageView2 f862a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public jc f863a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public l8 f864a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public xj f865a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public z5 f866a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f867a;
    public int b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public View f868b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public ImageView f869b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public LinearLayout f870b;
    public View c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public ImageView f871c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public LinearLayout f872c;
    public View d;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    public ImageView f873d;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    public LinearLayout f874d;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    public TextView f875d;
    public LinearLayout e;

    /* JADX INFO: renamed from: e, reason: collision with other field name */
    public TextView f876e;
    public TextView f;
    public TextView g;
    public TextView h;
    public TextView i;
    public TextView j;

    public yj(Context context, d dVar) {
        super(context, dVar);
        this.f1539a = 0L;
        this.f867a = false;
        this.f863a = (jc) dVar.m590a();
        View viewA = a(context);
        ((x0) this).f818a = viewA;
        addView(viewA, new ViewGroup.LayoutParams(-1, -1));
        this.f860a = (ImageView) ((x0) this).f818a.findViewById(R.id.adprof_reward_blur_image);
        this.f869b = (ImageView) ((x0) this).f818a.findViewById(R.id.adprof_reward_post_image);
        this.f859a = (FrameLayout) ((x0) this).f818a.findViewById(R.id.adprof_reward_post_media);
        this.f870b = (LinearLayout) ((x0) this).f818a.findViewById(R.id.adprof_reward_sound_and_skip_layout);
        this.f872c = (LinearLayout) ((x0) this).f818a.findViewById(R.id.adprof_reward_left_time_ll);
        this.f875d = (TextView) ((x0) this).f818a.findViewById(R.id.adprof_reward_left_time_tv);
        this.f871c = (ImageView) ((x0) this).f818a.findViewById(R.id.adprof_reward_sound_image);
        this.f873d = (ImageView) ((x0) this).f818a.findViewById(R.id.adprof_reward_close_iv);
        this.f868b = ((x0) this).f818a.findViewById(R.id.adprof_reward_cta_ll);
        this.f876e = (TextView) ((x0) this).f818a.findViewById(R.id.adprof_reward_cta_bt);
        this.f = (TextView) ((x0) this).f818a.findViewById(R.id.adprof_reward_cta_bt_bottom);
        this.c = ((x0) this).f818a.findViewById(R.id.adprof_reward_cta_bt_gd);
        this.f863a.getClass();
        View view = this.c;
        if (view != null) {
            view.setVisibility(0);
        }
        this.f874d = (LinearLayout) ((x0) this).f818a.findViewById(R.id.adprof_reward_privacy_include);
        b();
        this.f861a = (RelativeLayout) ((x0) this).f818a.findViewById(R.id.adprof_reward_shake_rl);
        this.d = ((x0) this).f818a.findViewById(R.id.adprof_reward_small_shake);
        this.j = (TextView) ((x0) this).f818a.findViewById(R.id.adprof_reward_skip_button);
        LinearLayout linearLayout = (LinearLayout) ((x0) this).f818a.findViewById(R.id.adprof_reward_app_include);
        this.e = linearLayout;
        if (linearLayout != null) {
            this.f862a = (GifImageView2) linearLayout.findViewById(R.id.adprof_reward_app_icon);
            this.g = (TextView) this.e.findViewById(R.id.adprof_reward_app_name);
            this.h = (TextView) this.e.findViewById(R.id.adprof_reward_app_version);
            this.i = (TextView) this.e.findViewById(R.id.adprof_reward_app_developer);
        }
        z0.a(context, ((x0) this).f818a, R.id.adprof_reward_logo_image, dVar);
        ImageView imageView = this.f873d;
        if (imageView != null) {
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.adprof.sdk.yj$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    this.f$0.b(view2);
                }
            });
        }
        c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(View view) {
        a(this.f868b);
    }

    public abstract View a(Context context);

    @Override // com.adprof.sdk.x0
    public void a() {
        try {
            l8 l8Var = this.f864a;
            if (l8Var != null) {
                l8Var.a();
                this.f864a.b();
            }
            if (this.f865a != null) {
                if (!((x0) this).f821a.m605f()) {
                    ((x0) this).f821a.m603d();
                }
                ((AdActivity) ((q5) ((kk) this.f865a).f1269a).f662a).a();
            }
            d dVar = ((x0) this).f821a;
            if (dVar != null) {
                dVar.m596a();
            }
        } catch (Throwable th) {
            pk.b("RewardBase close error ", th);
        }
    }

    public final void c() {
        try {
            if (this.f874d == null) {
                return;
            }
            for (int i = 0; i < this.f874d.getChildCount(); i++) {
                ((TextView) this.f874d.getChildAt(i)).getPaint().setFlags(9);
            }
            if (!((x0) this).f821a.m597a() || ((x0) this).f821a.f196a == null) {
                this.f874d.setVisibility(8);
            } else {
                e();
            }
        } catch (Throwable th) {
            pk.b("rewardBase addBaseLine error: ", th);
        }
    }

    public abstract void d();

    public final void e() {
        try {
            this.f874d.setVisibility(0);
            ((x0) this).f820a.setOnTouchListener(new uj(this));
            ((x0) this).b.setOnTouchListener(new vj(this));
            this.f874d.setOnTouchListener(new wj(this));
        } catch (Throwable th) {
            pk.b("rewardBase showPrivacy error", th);
        }
    }

    public void setInteractionListener(xj xjVar) {
        this.f865a = xjVar;
    }

    public final void c(String str) {
        wd wdVar;
        AdRequest adRequest;
        try {
            a(str);
            s5.a(((x0) this).f821a.k(), "action.reward.video.click");
            d();
            d dVar = ((x0) this).f821a;
            if (dVar == null || (wdVar = dVar.f190a) == null || (adRequest = wdVar.f794a) == null || !adRequest.isCloseAfterClick()) {
                return;
            }
            a();
        } catch (Throwable th) {
            pk.a(th);
            oh.b(th);
        }
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public boolean m731a() {
        q0 q0Var;
        z2 z2Var;
        ul ulVar;
        d dVar = ((x0) this).f821a;
        if (dVar == null || (q0Var = dVar.f188a) == null || (z2Var = q0Var.f643a) == null || (ulVar = z2Var.f891a) == null) {
            return false;
        }
        return "1".equals(ulVar.o);
    }
}
