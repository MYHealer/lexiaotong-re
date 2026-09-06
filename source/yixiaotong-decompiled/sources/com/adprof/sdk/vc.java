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
public abstract class vc extends x0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f1478a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public FrameLayout f765a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public ImageView f766a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public RelativeLayout f767a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public GifImageView2 f768a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public jc f769a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public l8 f770a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public uc f771a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public z5 f772a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f773a;
    public int b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public Context f774b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public View f775b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public FrameLayout f776b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public ImageView f777b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public LinearLayout f778b;
    public View c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public ImageView f779c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public LinearLayout f780c;
    public View d;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    public LinearLayout f781d;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    public TextView f782d;
    public LinearLayout e;

    /* JADX INFO: renamed from: e, reason: collision with other field name */
    public TextView f783e;
    public TextView f;
    public TextView g;

    public vc(Context context, d dVar) {
        super(context, dVar);
        this.f1478a = 0L;
        this.f773a = false;
        this.f774b = context;
        this.f769a = (jc) dVar.m590a();
        h8.b();
        h8.m641a();
        View viewA = a(context);
        ((x0) this).f818a = viewA;
        addView(viewA, new ViewGroup.LayoutParams(-1, -1));
        this.f766a = (ImageView) ((x0) this).f818a.findViewById(R.id.adprof_interstitial_blur_image);
        this.f777b = (ImageView) ((x0) this).f818a.findViewById(R.id.adprof_interstitial_post_image);
        this.f765a = (FrameLayout) ((x0) this).f818a.findViewById(R.id.adprof_interstitial_post_media);
        this.f776b = (FrameLayout) ((x0) this).f818a.findViewById(R.id.adprof_interstitial_post);
        this.f778b = (LinearLayout) ((x0) this).f818a.findViewById(R.id.adprof_interstitial_sound_and_skip_layout);
        this.f780c = (LinearLayout) ((x0) this).f818a.findViewById(R.id.adprof_interstitial_skip_ll);
        this.f782d = (TextView) ((x0) this).f818a.findViewById(R.id.adprof_interstitial_skip_text);
        this.f779c = (ImageView) ((x0) this).f818a.findViewById(R.id.adprof_interstitial_sound_image);
        this.f781d = (LinearLayout) ((x0) this).f818a.findViewById(R.id.adprof_interstitial_close_ll);
        this.f775b = ((x0) this).f818a.findViewById(R.id.adprof_interstitial_cta_ll);
        this.f783e = (TextView) ((x0) this).f818a.findViewById(R.id.adprof_interstitial_cta_bt);
        this.f = (TextView) ((x0) this).f818a.findViewById(R.id.adprof_interstitial_cta_bt_bottom);
        this.c = ((x0) this).f818a.findViewById(R.id.adprof_interstitial_cta_bt_gd);
        this.f769a.getClass();
        View view = this.c;
        if (view != null) {
            view.setVisibility(0);
        }
        b();
        this.f767a = (RelativeLayout) ((x0) this).f818a.findViewById(R.id.adprof_interstitial_shake_layout);
        this.d = ((x0) this).f818a.findViewById(R.id.adprof_interstitial_small_shake);
        this.e = (LinearLayout) ((x0) this).f818a.findViewById(R.id.adprof_interstitial_app_info);
        this.f768a = (GifImageView2) ((x0) this).f818a.findViewById(R.id.adprof_interstitial_app_icon);
        this.g = (TextView) ((x0) this).f818a.findViewById(R.id.adprof_interstitial_app_title);
        z0.a(context, ((x0) this).f818a, R.id.adprof_interstitial_logo_image, dVar);
        this.f780c.setOnClickListener(new View.OnClickListener() { // from class: com.adprof.sdk.vc$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.f$0.b(view2);
            }
        });
        LinearLayout linearLayout = this.f781d;
        if (linearLayout != null) {
            linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.adprof.sdk.vc$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    this.f$0.c(view2);
                }
            });
        }
        c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(View view) {
        if (getSessionManager() != null) {
            getSessionManager().a(((x0) this).f821a, com.huawei.openalliance.ad.constant.dd.F);
        }
        a(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c(View view) {
        a(this.f775b);
    }

    private int getSkipSeconds() {
        try {
            if (!vl.m724a(((x0) this).f821a)) {
                return Integer.valueOf(((x0) this).f821a.f188a.f643a.f891a.f).intValue();
            }
        } catch (Exception unused) {
        }
        return 0;
    }

    public abstract View a(Context context);

    @Override // com.adprof.sdk.x0
    public void a() {
        try {
            l8 l8Var = this.f770a;
            if (l8Var != null) {
                l8Var.a();
                this.f770a.b();
            }
            uc ucVar = this.f771a;
            if (ucVar != null) {
                ((AdActivity) ((q5) ((id) ucVar).f1228a).f662a).a();
            }
            d dVar = ((x0) this).f821a;
            if (dVar != null) {
                dVar.m596a();
            }
        } catch (Throwable th) {
            pk.b("InterstitialBase close error ", th);
        }
    }

    public abstract void a(boolean z);

    public final void c() {
        try {
            if (((x0) this).f819a == null) {
                return;
            }
            for (int i = 0; i < ((x0) this).f819a.getChildCount(); i++) {
                TextView textView = (TextView) ((x0) this).f819a.getChildAt(i);
                textView.getPaint().setFlags(9);
                textView.setTextColor(-1);
            }
            if (!((x0) this).f821a.m597a() || ((x0) this).f821a.f196a == null) {
                ((x0) this).f819a.setVisibility(8);
            } else {
                d();
            }
        } catch (Throwable th) {
            pk.b("InterstitialBase addBaseLine error: ", th);
        }
    }

    public final void d() {
        try {
            ((x0) this).f819a.setVisibility(0);
            ((x0) this).f820a.setOnTouchListener(new rc(this));
            ((x0) this).b.setOnTouchListener(new sc(this));
            ((x0) this).c.setOnTouchListener(new tc(this));
        } catch (Throwable th) {
            pk.b("InterstitialBase showPrivacy error", th);
        }
    }

    public void e() {
        l8 l8Var = this.f770a;
        if (l8Var != null) {
            l8Var.a();
            this.f770a.b();
        }
        int skipSeconds = getSkipSeconds() * 1000;
        if (skipSeconds <= 0) {
            a(true);
            return;
        }
        this.f773a = false;
        pk.d(" \n\n -----  final time left = " + skipSeconds + "  \n\n");
        l8 l8Var2 = new l8(skipSeconds, 500L);
        this.f770a = l8Var2;
        l8Var2.f439a = new qc(this);
        a(false);
        this.f770a.c();
        this.f770a.f();
    }

    public void setInteractionListener(uc ucVar) {
        this.f771a = ucVar;
    }

    public final void c(String str) {
        wd wdVar;
        AdRequest adRequest;
        try {
            a(str);
            s5.a(((x0) this).f821a.k(), "action.reward.video.click");
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
}
