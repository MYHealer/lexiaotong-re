package com.adprof.sdk;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.adprof.sdk.api.AdAppInfo;
import com.adprof.sdk.base.fb.FBView;
import com.adprof.sdk.base.view.gif.GifImageView2;
import com.adprof.sdk.xb.a;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class hd extends vc implements View.OnTouchListener {
    public static final /* synthetic */ int d = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Bitmap f1210a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public FBView f338a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public c2 f339a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public k9 f340a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public nl f341a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public pe f342a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public yg f343a;
    public boolean b;
    public int c;

    public hd(Context context, d dVar) {
        super(context, dVar);
        int iA = 0;
        this.c = 0;
        this.b = false;
        try {
            f();
            l();
            j();
            o();
            d dVar2 = ((x0) this).f821a;
            if (dVar2 != null && dVar2.m592a() != null) {
                iA = ((x0) this).f821a.m592a().a();
            }
            if (iA == 4) {
                n();
            } else if (iA == 3) {
                m();
            }
            g();
        } catch (Throwable th) {
            if (getContext() instanceof Activity) {
                ((Activity) getContext()).finish();
            }
            oh.b(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void d(View view) {
        z5 z5Var;
        boolean z;
        if (view.getTag() != null) {
            if (view.getTag().equals("sound_on")) {
                ((vc) this).f779c.setImageResource(R.drawable.adprof_sound_off);
                ((vc) this).f779c.setTag("sound_off");
                z5Var = ((vc) this).f772a;
                if (z5Var == null) {
                    return;
                } else {
                    z = true;
                }
            } else {
                ((vc) this).f779c.setImageResource(R.drawable.adprof_sound_on);
                ((vc) this).f779c.setTag("sound_on");
                z5Var = ((vc) this).f772a;
                if (z5Var == null) {
                    return;
                } else {
                    z = false;
                }
            }
            z5Var.setMute(z);
        }
    }

    private String getIconUrl() {
        return ((x0) this).f821a.f204f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getMediaWidth() {
        return h8.b() - (((int) AdprofSdk.getInstance().getContext().getResources().getDimension(R.dimen.adprof_inter_margin_left)) * 2);
    }

    private z5 getVideoAdView() {
        StringBuilder sbAppend;
        if (((vc) this).f772a == null) {
            z5 z5Var = new z5(getContext());
            ((vc) this).f772a = z5Var;
            z5Var.setVideoPlayerStatusListener(new fd(this));
        }
        File fileM593a = ((x0) this).f821a.m593a();
        if (fileM593a == null || !fileM593a.exists()) {
            ((vc) this).f772a.setUp(((x0) this).f821a.m());
            sbAppend = new StringBuilder("========  video play url path = ").append(((x0) this).f821a.m());
        } else {
            ((vc) this).f772a.setUp(fileM593a.getAbsolutePath());
            sbAppend = new StringBuilder("========  video play url path = ").append(fileM593a.getAbsolutePath());
        }
        pk.a(sbAppend.append("    ======= \n").toString());
        return ((vc) this).f772a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void h() {
        try {
            w6.a(this, ((x0) this).f821a, new gd(this));
        } catch (Throwable th) {
            oh.b(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void i() {
        pe peVar = this.f342a;
        if (peVar != null) {
            peVar.b();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPostImageBitmap(Bitmap bitmap) {
        if (pk.f594a) {
            pk.d("setPostImageBitmap bitmap width = " + bitmap.getWidth() + "  height = " + bitmap.getHeight());
        }
        ViewGroup.LayoutParams layoutParams = ((vc) this).f777b.getLayoutParams();
        if (layoutParams != null) {
            int mediaWidth = getMediaWidth();
            layoutParams.width = mediaWidth;
            layoutParams.height = (mediaWidth * bitmap.getHeight()) / bitmap.getWidth();
            ((vc) this).f777b.setLayoutParams(layoutParams);
        }
        ((vc) this).f777b.setImageBitmap(bitmap);
    }

    @Override // com.adprof.sdk.vc
    public View a(Context context) {
        if (((x0) this).f821a == null) {
            return null;
        }
        return FrameLayout.inflate(context, R.layout.adprof_interstitial, null);
    }

    @Override // com.adprof.sdk.vc
    public void a(boolean z) {
        ((vc) this).f781d.setVisibility(z ? 0 : 8);
        ((vc) this).f780c.setVisibility(z ? 8 : 0);
    }

    @Override // com.adprof.sdk.x0
    public void b(String str) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (jCurrentTimeMillis - ((vc) this).f1478a < 1000) {
            pk.a("Click too frequently, ignored");
        } else {
            ((vc) this).f1478a = jCurrentTimeMillis;
            pk.b("\n -------------------handleClick----------------- portal = " + str + "  \n\n");
            if (((x0) this).f821a == null) {
                pk.b("adUnit is null");
            } else {
                c(str);
            }
        }
        yg ygVar = this.f343a;
        if (ygVar != null) {
            ygVar.f857a = true;
            ygVar.b();
        }
    }

    public final void d(String str) {
        if (((x0) this).f821a.m603d() && this.f1210a == null) {
            HashMap map = new HashMap();
            map.put("error", str);
            s5.a(((x0) this).f821a.k(), map, "action.reward.video.play.fail", 0);
        }
    }

    public final void f() {
        this.f343a = new yg(getContext(), ((x0) this).f821a, new yc(this));
    }

    public final void g() {
        q0 q0Var;
        o1 o1Var;
        try {
            d dVar = ((x0) this).f821a;
            if (dVar != null && (q0Var = dVar.f188a) != null && (o1Var = q0Var.f639a) != null && o1Var.f525b) {
                k9 k9Var = new k9(this);
                this.f340a = k9Var;
                k9Var.a(dVar, new Runnable() { // from class: com.adprof.sdk.hd$$ExternalSyntheticLambda1
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.h();
                    }
                });
            }
        } catch (Throwable th) {
            pk.a(th);
            oh.b(th);
        }
    }

    public void j() {
        ImageView imageView;
        String str;
        TextView textView;
        try {
            ((vc) this).f769a.getClass();
            float f = 10.0f;
            if (((vc) this).f778b.getLayoutParams() instanceof RelativeLayout.LayoutParams) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) ((vc) this).f778b.getLayoutParams();
                layoutParams.addRule(10);
                layoutParams.addRule(11);
                layoutParams.setMargins(0, h8.a(10.0f), h8.a(10.0f), 0);
                ((vc) this).f778b.setLayoutParams(layoutParams);
            }
            int i = ((x0) this).f821a.d;
            ViewGroup.LayoutParams layoutParams2 = ((vc) this).f779c.getLayoutParams();
            pk.a("-------close_style: Inter " + i);
            if (i != 1) {
                if (i != 2) {
                    layoutParams2.width = h8.a(25.0f);
                    layoutParams2.height = h8.a(25.0f);
                    ((vc) this).f779c.setLayoutParams(layoutParams2);
                    textView = ((vc) this).f782d;
                } else {
                    layoutParams2.width = h8.a(22.0f);
                    layoutParams2.height = h8.a(22.0f);
                    ((vc) this).f779c.setLayoutParams(layoutParams2);
                    f = 8.0f;
                    ((vc) this).f782d.setTextSize(2, 8.0f);
                    textView = (TextView) findViewById(R.id.adprof_interstitial_close_text);
                    if (textView != null) {
                    }
                }
                textView.setTextSize(2, f);
            } else {
                layoutParams2.width = h8.a(28.0f);
                layoutParams2.height = h8.a(28.0f);
                ((vc) this).f779c.setLayoutParams(layoutParams2);
                ((vc) this).f782d.setTextSize(2, 12.0f);
            }
            if (!((x0) this).f821a.m605f()) {
                ((vc) this).f779c.setVisibility(8);
                return;
            }
            int iA = ((vc) this).f769a.a();
            ((vc) this).f779c.setOnClickListener(new View.OnClickListener() { // from class: com.adprof.sdk.hd$$ExternalSyntheticLambda2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.d(view);
                }
            });
            if (iA == 0) {
                z5 z5Var = ((vc) this).f772a;
                if (z5Var != null) {
                    z5Var.setMute(true);
                }
                ((vc) this).f779c.setImageResource(R.drawable.adprof_sound_off);
                imageView = ((vc) this).f779c;
                str = "sound_off";
            } else {
                z5 z5Var2 = ((vc) this).f772a;
                if (z5Var2 != null) {
                    z5Var2.setMute(false);
                }
                ((vc) this).f779c.setImageResource(R.drawable.adprof_sound_on);
                imageView = ((vc) this).f779c;
                str = "sound_on";
            }
            imageView.setTag(str);
        } catch (Throwable th) {
            pk.b("InterstitialView_one layout skip error: ", th);
            oh.b(th);
        }
    }

    public final void k() {
        int i;
        int i2;
        if (((vc) this).f767a == null || this.b) {
            return;
        }
        this.b = true;
        if (((vc) this).d != null) {
            pk.a("InterstitialView_one", "Moving shakeLayout to smallShakeView position");
            ViewGroup.LayoutParams layoutParams = ((vc) this).d.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                i = marginLayoutParams.leftMargin;
                i2 = marginLayoutParams.bottomMargin;
            } else {
                i = 0;
                i2 = 0;
            }
            ViewGroup.LayoutParams layoutParams2 = ((vc) this).f767a.getLayoutParams();
            if (layoutParams2 instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) layoutParams2;
                marginLayoutParams2.leftMargin = i;
                marginLayoutParams2.bottomMargin = i2;
                ((vc) this).f767a.setLayoutParams(marginLayoutParams2);
            }
            this.f341a.a(((vc) this).f767a, ((vc) this).d, 0.25f, new Runnable() { // from class: com.adprof.sdk.hd$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.i();
                }
            });
        }
    }

    public void l() {
        boolean zEquals;
        FBView fBView;
        String str;
        d dVar = ((x0) this).f821a;
        if (dVar != null) {
            dVar.a(getMediaWidth(), (getMediaWidth() * 16) / 9);
            f7.a(((vc) this).f783e, this.f, ((x0) this).f821a);
            h6.a(((vc) this).f775b);
            ArrayList<View> arrayList = new ArrayList();
            arrayList.add(((vc) this).f775b);
            arrayList.add(((vc) this).f783e);
            if (z8.a(((n5) ((vc) this).f769a).f512a)) {
                FrameLayout frameLayout = ((vc) this).f765a;
                if (frameLayout != null) {
                    arrayList.add(frameLayout);
                }
                ImageView imageView = ((vc) this).f777b;
                if (imageView != null) {
                    arrayList.add(imageView);
                }
                ImageView imageView2 = ((vc) this).f766a;
                if (imageView2 != null) {
                    arrayList.add(imageView2);
                }
            }
            for (View view : arrayList) {
                if (view != null) {
                    view.setOnClickListener(null);
                    view.setOnTouchListener(null);
                    view.setOnTouchListener(this);
                }
            }
            d dVar2 = ((x0) this).f821a;
            if (dVar2 != null && ((vc) this).e != null) {
                try {
                    AdAppInfo adAppInfo = dVar2.f182a;
                    if (!dVar2.m597a() || adAppInfo == null || TextUtils.isEmpty(adAppInfo.getPackageName())) {
                        ((vc) this).e.setVisibility(8);
                        str = "No app info available, hiding app info layout";
                    } else {
                        ((vc) this).e.setVisibility(0);
                        if (this.g != null && !TextUtils.isEmpty(adAppInfo.getAppName())) {
                            this.g.setText(adAppInfo.getAppName());
                        }
                        GifImageView2 gifImageView2 = ((vc) this).f768a;
                        if (gifImageView2 != null) {
                            gifImageView2.setBorderRadius(h8.a(10.0f));
                            String strM598b = ((x0) this).f821a.m598b();
                            if (TextUtils.isEmpty(strM598b)) {
                                strM598b = ((x0) this).f821a.f204f;
                            }
                            if (TextUtils.isEmpty(strM598b)) {
                                ((vc) this).f768a.setImageResource(R.drawable.adprof_ad_logo);
                            } else {
                                xb xbVarA = xb.a(getContext());
                                xbVarA.getClass();
                                xbVarA.new a(strM598b).a(((vc) this).f768a);
                            }
                        }
                        str = "App info setup completed: " + adAppInfo.getAppName();
                    }
                    pk.a("InterstitialView_one", str);
                } catch (Exception e) {
                    pk.b("InterstitialView_one", "Error setting up app info: " + e.getMessage());
                    LinearLayout linearLayout = ((vc) this).e;
                    if (linearLayout != null) {
                        linearLayout.setVisibility(8);
                    }
                }
            }
            try {
                ul ulVarA = vl.a(((x0) this).f821a);
                zEquals = ulVarA != null ? "1".equals(ulVarA.m) : true;
            } catch (Exception e2) {
                pk.c("InterstitialView setupFeedbackView check feedbackEnable error", e2);
            }
            View view2 = ((x0) this).f818a;
            if (view2 != null) {
                this.f338a = (FBView) view2.findViewById(R.id.adprof_interstitial_feedback_view);
            }
            if (zEquals && (fBView = this.f338a) != null) {
                fBView.setVisibility(0);
                this.f338a.setAdUnit(((x0) this).f821a);
            }
            if (((x0) this).f821a.m605f()) {
                ((vc) this).f777b.setVisibility(8);
                ((vc) this).f765a.setVisibility(0);
                z5 videoAdView = getVideoAdView();
                ((vc) this).f765a.addView(videoAdView, new FrameLayout.LayoutParams(-1, -2));
                videoAdView.setVideoImageDisplayType(1);
                ((vc) this).f772a.setAdUnit(((x0) this).f821a);
                ((vc) this).f772a.setTargetWidth(getMediaWidth());
                ((vc) this).f772a.i();
            } else {
                ((vc) this).f777b.setVisibility(0);
                ((vc) this).f765a.setVisibility(8);
                Bitmap bitmapDecodeFile = BitmapFactory.decodeFile(((x0) this).f821a.m594a());
                this.f1210a = bitmapDecodeFile;
                if (bitmapDecodeFile != null) {
                    setPostImageBitmap(bitmapDecodeFile);
                }
                e();
            }
            yg ygVar = this.f343a;
            ygVar.getClass();
            fn.a(new sg(ygVar), 2000);
            d dVar3 = ((x0) this).f821a;
            String strL = dVar3.f204f;
            if (dVar3.m603d()) {
                strL = ((x0) this).f821a.f204f;
            } else if (((x0) this).f821a.m605f()) {
                strL = ((x0) this).f821a.l();
            }
            if (TextUtils.isEmpty(strL)) {
                d("image ad url empty");
            } else {
                xb.a(((vc) this).f774b).a(strL, new dd(this, strL));
            }
        }
    }

    public final void m() {
        pk.a("----mBaseAdUnit:getVideo_url  " + ((x0) this).f821a.m());
        if (((n5) ((vc) this).f769a).f510a == 1) {
            ((vc) this).f767a.setVisibility(8);
            return;
        }
        if (this.f341a == null) {
            getContext();
            this.f341a = new nl();
        }
        if (this.f342a == null) {
            rl rlVar = new rl(getContext());
            this.f342a = rlVar;
            rlVar.setOnAnimationCompleteListener(new zc(this));
        }
        int iA = h8.a(100.0f);
        this.f342a.setLayoutParams(new ViewGroup.LayoutParams(iA, iA));
        if (z8.a(((n5) ((vc) this).f769a).f512a)) {
            this.f342a.setOnTouchListener(this);
        }
        try {
            c2 c2Var = new c2(((vc) this).f774b);
            this.f339a = c2Var;
            d dVar = ((x0) this).f821a;
            c2Var.a(ml.a(dVar), ml.b(((x0) this).f821a), ml.m687a(((x0) this).f821a), ml.m688a(((x0) this).f821a), dVar != null ? dVar.f190a.f1499a : 0);
            ml.a(this.f339a, ((x0) this).f821a);
            this.f339a.f157a = new bd(this);
        } catch (Throwable th) {
            pk.a(th);
        }
        this.f339a.d();
        ((vc) this).f767a.removeAllViews();
        this.f342a.setTextHint("摇一摇查看广告");
        this.f342a.b();
        ((vc) this).f767a.addView(this.f342a);
    }

    public final void n() {
        try {
            boolean z = true;
            if (((n5) ((vc) this).f769a).f510a == 1) {
                z = false;
            }
            bo.a(((vc) this).f767a, getContext(), ((x0) this).f821a, z, new cd(this));
        } catch (Exception e) {
            pk.a("InterstitialView_one", "twistStart error", e);
        }
    }

    public final void o() {
        int mediaWidth;
        ViewGroup.LayoutParams layoutParams;
        FrameLayout frameLayout;
        RelativeLayout.LayoutParams layoutParams2;
        try {
            if (((vc) this).f776b != null && (mediaWidth = getMediaWidth()) > 0) {
                int i = (mediaWidth * 16) / 9;
                ViewGroup.LayoutParams layoutParams3 = ((vc) this).f776b.getLayoutParams();
                if (!(layoutParams3 instanceof RelativeLayout.LayoutParams)) {
                    if (layoutParams3 != null) {
                        layoutParams3.width = mediaWidth;
                        layoutParams3.height = i;
                        frameLayout = ((vc) this).f776b;
                        layoutParams = layoutParams3;
                    } else {
                        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(mediaWidth, i);
                        layoutParams4.addRule(14, -1);
                        layoutParams2 = layoutParams4;
                    }
                    frameLayout.setLayoutParams(layoutParams);
                }
                RelativeLayout.LayoutParams layoutParams5 = (RelativeLayout.LayoutParams) layoutParams3;
                layoutParams5.width = mediaWidth;
                layoutParams5.height = i;
                layoutParams5.addRule(14, -1);
                layoutParams2 = layoutParams5;
                frameLayout = ((vc) this).f776b;
                layoutParams = layoutParams2;
                frameLayout.setLayoutParams(layoutParams);
            }
        } catch (Throwable th) {
            pk.b("InterstitialView ui error", th);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        pe peVar = this.f342a;
        if (peVar != null) {
            if (peVar instanceof rl) {
                ((rl) peVar).setOnAnimationCompleteListener(null);
            }
            this.f342a.a();
        }
        super.onDetachedFromWindow();
        h6.b(((vc) this).f775b);
        try {
            c2 c2Var = this.f339a;
            if (c2Var != null) {
                c2Var.b();
                this.f339a = null;
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
}
