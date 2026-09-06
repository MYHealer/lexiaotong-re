package com.adprof.sdk;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowInsets;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.adprof.sdk.api.AdAppInfo;
import com.adprof.sdk.base.fb.FBView;
import com.adprof.sdk.xb.a;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class jk extends yj implements View.OnTouchListener {
    public static final /* synthetic */ int f = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public FBView f1250a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public c2 f394a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public k9 f395a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public nl f396a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public pe f397a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public x6 f398a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public yg f399a;
    public boolean b;
    public int c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public boolean f400c;
    public int d;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    public boolean f401d;
    public int e;

    public jk(Context context, d dVar) {
        super(context, dVar);
        this.c = Integer.MIN_VALUE;
        this.d = Integer.MIN_VALUE;
        int iA = 0;
        this.e = 0;
        this.b = false;
        this.f400c = true;
        try {
            g();
            n();
            k();
            d dVar2 = ((x0) this).f821a;
            if (dVar2 != null && dVar2.m592a() != null) {
                iA = ((x0) this).f821a.m592a().a();
            }
            if (iA == 4) {
                q();
            } else if (iA == 3) {
                p();
            }
            d dVar3 = ((x0) this).f821a;
            if (dVar3 != null && dVar3.m592a() != null && ((x0) this).f821a.m592a().m707a() != null && ((x0) this).f821a.m592a().m707a().a()) {
                k9 k9Var = new k9(this);
                this.f395a = k9Var;
                k9Var.a(((x0) this).f821a, new Runnable() { // from class: com.adprof.sdk.jk$$ExternalSyntheticLambda2
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.i();
                    }
                });
            }
            f();
        } catch (Throwable th) {
            if (getContext() instanceof Activity) {
                ((Activity) getContext()).finish();
            }
            oh.b(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ WindowInsets a(View view, WindowInsets windowInsets) {
        int systemWindowInsetTop;
        if (windowInsets != null) {
            try {
                systemWindowInsetTop = windowInsets.getSystemWindowInsetTop();
            } catch (Throwable unused) {
            }
        } else {
            systemWindowInsetTop = 0;
        }
        a(systemWindowInsetTop);
        return view.onApplyWindowInsets(windowInsets);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c(View view) {
        z5 z5Var;
        boolean z;
        if (view.getTag() != null) {
            if (view.getTag().equals("sound_on")) {
                ((yj) this).f871c.setImageResource(R.drawable.adprof_sound_off);
                ((yj) this).f871c.setTag("sound_off");
                z5Var = ((yj) this).f866a;
                if (z5Var == null) {
                    return;
                } else {
                    z = true;
                }
            } else {
                ((yj) this).f871c.setImageResource(R.drawable.adprof_sound_on);
                ((yj) this).f871c.setTag("sound_on");
                z5Var = ((yj) this).f866a;
                if (z5Var == null) {
                    return;
                } else {
                    z = false;
                }
            }
            z5Var.setMute(z);
        }
    }

    private z5 getVideoAdView() {
        StringBuilder sbAppend;
        if (((yj) this).f866a == null) {
            z5 z5Var = new z5(getContext());
            ((yj) this).f866a = z5Var;
            z5Var.setVideoPlayerStatusListener(new ik(this));
        }
        File fileM593a = ((x0) this).f821a.m593a();
        if (fileM593a == null || !fileM593a.exists()) {
            ((yj) this).f866a.setUp(((x0) this).f821a.m());
            sbAppend = new StringBuilder("========  video play url path = ").append(((x0) this).f821a.m());
        } else {
            ((yj) this).f866a.setUp(fileM593a.getAbsolutePath());
            sbAppend = new StringBuilder("========  video play url path = ").append(fileM593a.getAbsolutePath());
        }
        pk.a(sbAppend.append("    ======= \n").toString());
        return ((yj) this).f866a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void h() {
        pe peVar = this.f397a;
        if (peVar != null) {
            peVar.b();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void i() {
        try {
            w6.a(this, ((x0) this).f821a, new zj(this));
        } catch (Throwable th) {
            oh.b(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void j() {
        a(true);
        this.f400c = false;
        pk.a("RewardView_one", "Skip button hidden ");
    }

    @Override // com.adprof.sdk.yj
    public View a(Context context) {
        if (((x0) this).f821a == null) {
            return null;
        }
        return FrameLayout.inflate(context, R.layout.adprof_reward, null);
    }

    public final void a(int i) {
        TextView textView = this.j;
        if (textView != null && (textView.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.j.getLayoutParams();
            if (this.c == Integer.MIN_VALUE) {
                this.c = layoutParams.topMargin;
            }
            int iMax = this.c + Math.max(i, 0);
            if (layoutParams.topMargin != iMax) {
                layoutParams.topMargin = iMax;
                this.j.setLayoutParams(layoutParams);
            }
        }
        LinearLayout linearLayout = ((yj) this).f870b;
        if (linearLayout == null || !(linearLayout.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
            return;
        }
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) ((yj) this).f870b.getLayoutParams();
        if (this.d == Integer.MIN_VALUE) {
            this.d = layoutParams2.topMargin;
        }
        int iMax2 = this.d + Math.max(i, 0);
        if (layoutParams2.topMargin != iMax2) {
            layoutParams2.topMargin = iMax2;
            ((yj) this).f870b.setLayoutParams(layoutParams2);
        }
    }

    public final void a(boolean z) {
        ((yj) this).f873d.setVisibility(z ? 0 : 8);
        this.j.setVisibility(z ? 8 : 0);
    }

    @Override // com.adprof.sdk.x0
    public void b(String str) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (jCurrentTimeMillis - ((yj) this).f1539a < 1000) {
            pk.a("Click too frequently, ignored");
        } else {
            ((yj) this).f1539a = jCurrentTimeMillis;
            pk.b("---------handleClick---------portal = " + str);
            if (((x0) this).f821a == null) {
                pk.b("adUnit is null");
            } else {
                c(str);
            }
        }
        yg ygVar = this.f399a;
        if (ygVar != null) {
            ygVar.f857a = true;
            ygVar.b();
        }
    }

    @Override // com.adprof.sdk.yj
    public void d() {
        if (((((x0) this).f821a.m605f() || !((x0) this).f821a.m603d()) && !m731a()) || this.f401d) {
            return;
        }
        this.f401d = true;
        TextView textView = ((yj) this).f875d;
        if (textView != null) {
            textView.setText("您已成功获得奖励");
        }
        LinearLayout linearLayout = ((yj) this).f872c;
        if (linearLayout != null) {
            linearLayout.setVisibility(0);
        }
        ImageView imageView = ((yj) this).f873d;
        if (imageView != null) {
            imageView.setVisibility(0);
        }
        xj xjVar = ((yj) this).f865a;
        if (xjVar != null) {
            kk kkVar = (kk) xjVar;
            d dVar = kkVar.f1269a.f1290a;
            if (dVar == null || !dVar.m606g()) {
                return;
            }
            kkVar.f1269a.f451a.m();
            kkVar.a();
        }
    }

    public final void f() {
        try {
            View view = ((x0) this).f818a;
            if (view == null) {
                return;
            }
            view.setOnApplyWindowInsetsListener(new View.OnApplyWindowInsetsListener() { // from class: com.adprof.sdk.jk$$ExternalSyntheticLambda5
                @Override // android.view.View.OnApplyWindowInsetsListener
                public final WindowInsets onApplyWindowInsets(View view2, WindowInsets windowInsets) {
                    return this.f$0.a(view2, windowInsets);
                }
            });
            ((x0) this).f818a.requestApplyInsets();
        } catch (Throwable unused) {
        }
    }

    public final void g() {
        this.f399a = new yg(getContext(), ((x0) this).f821a, new ak(this));
    }

    public void k() {
        ImageView imageView;
        String str;
        try {
            ((yj) this).f863a.getClass();
            if (((yj) this).f870b.getLayoutParams() instanceof RelativeLayout.LayoutParams) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) ((yj) this).f870b.getLayoutParams();
                layoutParams.addRule(10);
                layoutParams.addRule(11);
                layoutParams.setMargins(0, h8.a(10.0f), h8.a(10.0f), 0);
                ((yj) this).f870b.setLayoutParams(layoutParams);
            }
            int i = ((x0) this).f821a.d;
            ViewGroup.LayoutParams layoutParams2 = ((yj) this).f871c.getLayoutParams();
            pk.a("-------close_style: " + i);
            if (i == 1) {
                layoutParams2.width = h8.a(28.0f);
                layoutParams2.height = h8.a(28.0f);
                ((yj) this).f871c.setLayoutParams(layoutParams2);
                ((yj) this).f875d.setTextSize(2, 12.0f);
            } else if (i != 2) {
                layoutParams2.width = h8.a(25.0f);
                layoutParams2.height = h8.a(25.0f);
                ((yj) this).f871c.setLayoutParams(layoutParams2);
                ((yj) this).f875d.setTextSize(2, 10.0f);
            } else {
                layoutParams2.width = h8.a(22.0f);
                layoutParams2.height = h8.a(22.0f);
                ((yj) this).f871c.setLayoutParams(layoutParams2);
                ((yj) this).f875d.setTextSize(2, 8.0f);
                ((yj) this).f873d.getLayoutParams().width = h8.a(20.0f);
                ((yj) this).f873d.getLayoutParams().height = h8.a(20.0f);
            }
            if (!((x0) this).f821a.m605f()) {
                ((yj) this).f871c.setVisibility(8);
                return;
            }
            int iA = ((yj) this).f863a.a();
            ((yj) this).f871c.setOnClickListener(new View.OnClickListener() { // from class: com.adprof.sdk.jk$$ExternalSyntheticLambda3
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.c(view);
                }
            });
            if (iA == 0) {
                z5 z5Var = ((yj) this).f866a;
                if (z5Var != null) {
                    z5Var.setMute(true);
                }
                ((yj) this).f871c.setImageResource(R.drawable.adprof_sound_off);
                imageView = ((yj) this).f871c;
                str = "sound_off";
            } else {
                z5 z5Var2 = ((yj) this).f866a;
                if (z5Var2 != null) {
                    z5Var2.setMute(false);
                }
                ((yj) this).f871c.setImageResource(R.drawable.adprof_sound_on);
                imageView = ((yj) this).f871c;
                str = "sound_on";
            }
            imageView.setTag(str);
        } catch (Throwable th) {
            pk.b("RewardView_one layout skip error: ", th);
            oh.b(th);
        }
    }

    public final void l() {
        if (((yj) this).f861a == null || this.b) {
            return;
        }
        this.b = true;
        if (((yj) this).d != null) {
            pk.a("RewardView_one", "Moving shakeLayout to smallShakeView position");
            this.f396a.a(((yj) this).f861a, ((yj) this).d, 0.25f, new Runnable() { // from class: com.adprof.sdk.jk$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.h();
                }
            });
        }
    }

    public void m() {
        yg ygVar = this.f399a;
        if (ygVar != null) {
            ygVar.a();
        }
        TextView textView = this.j;
        if (textView == null || ((yj) this).f873d == null || !this.f400c) {
            return;
        }
        textView.post(new Runnable() { // from class: com.adprof.sdk.jk$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.j();
            }
        });
    }

    public void n() {
        boolean zEquals;
        FBView fBView;
        String str;
        ImageView imageView;
        d dVar = ((x0) this).f821a;
        if (dVar != null) {
            f7.a(((yj) this).f876e, this.f, dVar);
            h6.a(((yj) this).f868b);
            ArrayList<View> arrayList = new ArrayList();
            arrayList.add(((yj) this).f868b);
            arrayList.add(((yj) this).f876e);
            if (z8.a(((n5) ((yj) this).f863a).f512a) && (imageView = ((yj) this).f860a) != null) {
                arrayList.add(imageView);
            }
            for (View view : arrayList) {
                if (view != null) {
                    view.setOnClickListener(null);
                    view.setOnTouchListener(null);
                    view.setOnTouchListener(this);
                }
            }
            d dVar2 = ((x0) this).f821a;
            if (dVar2 != null && ((yj) this).e != null) {
                try {
                    AdAppInfo adAppInfo = dVar2.f182a;
                    if (!dVar2.m597a() || adAppInfo == null || TextUtils.isEmpty(adAppInfo.getPackageName())) {
                        ((yj) this).e.setVisibility(8);
                        str = "No app info available, hiding app info layout";
                    } else {
                        ((yj) this).e.setVisibility(0);
                        if (this.g != null && !TextUtils.isEmpty(adAppInfo.getAppName())) {
                            this.g.setText(adAppInfo.getAppName());
                        }
                        if (this.h != null && !TextUtils.isEmpty(adAppInfo.getVersionName())) {
                            this.h.setText("v" + adAppInfo.getVersionName());
                        }
                        if (this.i != null && !TextUtils.isEmpty(adAppInfo.getDeveloper())) {
                            this.i.setText(adAppInfo.getDeveloper());
                        }
                        if (((yj) this).f862a != null) {
                            String strM598b = ((x0) this).f821a.m598b();
                            if (TextUtils.isEmpty(strM598b)) {
                                strM598b = ((x0) this).f821a.f204f;
                            }
                            ((yj) this).f862a.setBorderRadius(h8.a(16.0f));
                            if (TextUtils.isEmpty(strM598b)) {
                                ((yj) this).f862a.setImageResource(R.drawable.adprof_ad_logo);
                            } else {
                                xb xbVarA = xb.a(getContext());
                                xbVarA.getClass();
                                xbVarA.new a(strM598b).a(((yj) this).f862a);
                            }
                        }
                        str = "App info setup completed: " + adAppInfo.getAppName();
                    }
                    pk.a("RewardView_one", str);
                } catch (Exception e) {
                    pk.b("RewardView_one", "Error setting up app info: " + e.getMessage());
                    LinearLayout linearLayout = ((yj) this).e;
                    if (linearLayout != null) {
                        linearLayout.setVisibility(8);
                    }
                }
            }
            o();
            try {
                ul ulVarA = vl.a(((x0) this).f821a);
                zEquals = ulVarA != null ? "1".equals(ulVarA.m) : true;
            } catch (Exception e2) {
                pk.c("RewardView setupFeedbackView check feedbackEnable error", e2);
            }
            View view2 = ((x0) this).f818a;
            if (view2 != null) {
                this.f1250a = (FBView) view2.findViewById(R.id.adprof_reward_feedback_view);
            }
            if (zEquals && (fBView = this.f1250a) != null) {
                fBView.setVisibility(0);
                this.f1250a.setAdUnit(((x0) this).f821a);
            }
            if (((x0) this).f821a.m605f()) {
                ((yj) this).f869b.setVisibility(8);
                ((yj) this).f859a.setVisibility(0);
                if (m731a()) {
                    ((yj) this).f872c.setVisibility(0);
                    ((yj) this).f875d.setText("点击立即领取奖励");
                    this.j.setVisibility(8);
                    ((yj) this).f873d.setVisibility(0);
                }
                z5 videoAdView = getVideoAdView();
                ((yj) this).f859a.addView(videoAdView);
                videoAdView.setVideoImageDisplayType(1);
                ((yj) this).f866a.setAdUnit(((x0) this).f821a);
                ((yj) this).f866a.setTargetWidth(h8.b());
                ((yj) this).f866a.i();
            } else if (((x0) this).f821a.m603d()) {
                ((yj) this).f869b.setVisibility(0);
                ((yj) this).f859a.setVisibility(8);
                this.j.setVisibility(8);
                ((yj) this).f872c.setVisibility(0);
                ((yj) this).f875d.setText("点击立即领取奖励");
                ((yj) this).f873d.setVisibility(8);
                Bitmap bitmapDecodeFile = BitmapFactory.decodeFile(((x0) this).f821a.m594a());
                if (bitmapDecodeFile != null) {
                    ((yj) this).f869b.setImageBitmap(bitmapDecodeFile);
                    ((yj) this).f861a.bringToFront();
                } else {
                    HashMap map = new HashMap();
                    map.put("error", "bitmap is null");
                    s5.a(((x0) this).f821a.k(), map, "action.reward.video.play.fail", 0);
                }
            }
            yg ygVar = this.f399a;
            ygVar.getClass();
            fn.a(new sg(ygVar), 2000);
            d dVar3 = ((x0) this).f821a;
            String strL = dVar3.f204f;
            if (dVar3.m605f()) {
                strL = ((x0) this).f821a.l();
            } else if (((x0) this).f821a.m603d()) {
                strL = ((x0) this).f821a.f204f;
            }
            if (TextUtils.isEmpty(strL)) {
                return;
            }
            xb.a(((x0) this).f817a).a(strL, new gk(this));
        }
    }

    public final void o() {
        boolean zEquals;
        if (this.j == null || ((yj) this).f873d == null) {
            return;
        }
        try {
            zEquals = !vl.m724a(((x0) this).f821a) ? "open".equals(((x0) this).f821a.f188a.f643a.f891a.e) : false;
        } catch (Exception unused) {
        }
        a(!zEquals);
        this.j.setOnClickListener(new View.OnClickListener() { // from class: com.adprof.sdk.jk$$ExternalSyntheticLambda4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.d(view);
            }
        });
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        pe peVar = this.f397a;
        if (peVar != null) {
            if (peVar instanceof rl) {
                ((rl) peVar).setOnAnimationCompleteListener(null);
            }
            this.f397a.a();
        }
        super.onDetachedFromWindow();
        h6.b(((yj) this).f868b);
        try {
            c2 c2Var = this.f394a;
            if (c2Var != null) {
                c2Var.b();
                this.f394a = null;
            }
        } catch (Throwable unused) {
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (((x0) this).f821a == null) {
            pk.b("adUnit is null");
            return false;
        }
        try {
            if (motionEvent.getAction() == 0) {
                ((x0) this).f821a.m591a().a(MotionEvent.obtain(motionEvent));
            } else if (motionEvent.getAction() == 1) {
                ((x0) this).f821a.m591a().c(MotionEvent.obtain(motionEvent));
                b("2");
            }
        } catch (Throwable th) {
            pk.b("splash click macro set ", th);
            oh.b(th);
        }
        return true;
    }

    public final void p() {
        pk.a("----mBaseAdUnit:getVideo_url  " + ((x0) this).f821a.m());
        if (((n5) ((yj) this).f863a).f510a == 1) {
            ((yj) this).f861a.setVisibility(8);
            return;
        }
        if (this.f396a == null) {
            getContext();
            this.f396a = new nl();
        }
        if (this.f397a == null) {
            rl rlVar = new rl(getContext());
            this.f397a = rlVar;
            rlVar.setOnAnimationCompleteListener(new bk(this));
        }
        int iA = h8.a(100.0f);
        this.f397a.setLayoutParams(new ViewGroup.LayoutParams(iA, iA));
        this.f397a.setTextHint("摇一摇查看广告");
        if (z8.a(((n5) ((yj) this).f863a).f512a)) {
            this.f397a.setOnTouchListener(this);
        }
        try {
            c2 c2Var = new c2(((x0) this).f817a);
            this.f394a = c2Var;
            d dVar = ((x0) this).f821a;
            c2Var.a(ml.a(dVar), ml.b(((x0) this).f821a), ml.m687a(((x0) this).f821a), ml.m688a(((x0) this).f821a), dVar != null ? dVar.f190a.f1499a : 0);
            ml.a(this.f394a, ((x0) this).f821a);
            this.f394a.f157a = new ck(this);
        } catch (Throwable th) {
            pk.a(th);
        }
        this.f394a.d();
        ((yj) this).f861a.removeAllViews();
        ((yj) this).f861a.addView(this.f397a);
        this.f397a.b();
    }

    public final void q() {
        try {
            pk.a("RewardView_one twistStart invoked");
            boolean z = true;
            if (((n5) ((yj) this).f863a).f510a == 1) {
                z = false;
            }
            bo.a(((yj) this).f861a, getContext(), ((x0) this).f821a, z, new ek(this));
        } catch (Exception e) {
            oh.b(e);
            pk.d("RewardView_one twistStart" + Log.getStackTraceString(e));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(View view) {
        pk.a("RewardView_one", "Skip button clicked");
        x6 x6Var = this.f398a;
        if (x6Var == null || !x6Var.isShowing()) {
            Activity activityA = q1.a();
            if (activityA == null || activityA.isFinishing() || activityA.isDestroyed()) {
                pk.b("RewardView_one", "Context is not Activity type, cannot show dialog");
                return;
            }
            if (((yj) this).b <= 0) {
                return;
            }
            x6 x6Var2 = new x6(activityA, ((yj) this).b);
            this.f398a = x6Var2;
            x6Var2.f829a = new fk(this);
            z5 z5Var = ((yj) this).f866a;
            if (z5Var != null) {
                z5Var.c();
            }
            try {
                this.f398a.show();
                l8 l8Var = ((yj) this).f864a;
                if (l8Var != null) {
                    l8Var.d();
                }
                yg ygVar = this.f399a;
                if (ygVar != null) {
                    ygVar.c();
                }
            } catch (Exception e) {
                pk.b("RewardView_one", "Failed to show skip intercept dialog: " + e.getMessage());
                z5 z5Var2 = ((yj) this).f866a;
                if (z5Var2 != null) {
                    z5Var2.d();
                }
                l8 l8Var2 = ((yj) this).f864a;
                if (l8Var2 != null) {
                    l8Var2.e();
                }
                yg ygVar2 = this.f399a;
                if (ygVar2 != null) {
                    ygVar2.d();
                }
            }
        }
    }
}
