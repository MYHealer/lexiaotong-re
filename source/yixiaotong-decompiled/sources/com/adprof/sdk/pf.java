package com.adprof.sdk;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.adprof.sdk.api.AFImage;
import com.adprof.sdk.api.NativeAdData;
import com.adprof.sdk.api.NativeAdEventListener;
import com.adprof.sdk.base.fb.FBView;
import com.adprof.sdk.base.view.gif.GifImageView2;
import com.adprof.sdk.xb.a;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.huawei.openalliance.ad.views.PPSLabelView;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public abstract class pf extends RelativeLayout implements View.OnClickListener {
    public static int d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f1365a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Paint f573a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Path f574a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public FrameLayout f575a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public RelativeLayout.LayoutParams f576a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public TextView f577a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public NativeAdData.NativeAdMediaListener f578a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public NativeAdEventListener f579a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public FBView f580a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public GifImageView2 f581a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public d f582a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public ef f583a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public s3 f584a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public sf f585a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public String f586a;
    public int b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public TextView f587b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public d f588b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public String f589b;
    public int c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public TextView f590c;

    public pf(Context context) {
        super(context);
        this.f576a = new RelativeLayout.LayoutParams(-2, -2);
        this.f574a = new Path();
        this.f573a = new Paint();
        this.f585a = new sf(getContext());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getImageSetMaxHeightDP() {
        return this.b - 40;
    }

    private void setParamsValue(RelativeLayout.LayoutParams layoutParams) {
        int i = this.f1365a;
        if (i > 0) {
            layoutParams.width = h8.a(i);
        }
        if (this.b > 40) {
            layoutParams.height = h8.a(getImageSetMaxHeightDP());
        }
    }

    /* JADX WARN: Code duplicated, block: B:27:0x008a  */
    public final void a(int i) {
        int id;
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, h8.a(20.0f));
        layoutParams.setMargins(0, h8.a(5.0f), 0, h8.a(5.0f));
        if (i != 0 && i != 1 && i != 5) {
            if (i == 2 || i == 6) {
                id = this.f577a.getId();
            } else if (i == 4) {
                layoutParams.addRule(1, this.f581a.getId());
                layoutParams.addRule(8, this.f581a.getId());
                layoutParams.setMargins(h8.a(5.0f), 0, 0, 0);
            } else if (i == 3) {
                layoutParams.addRule(0, this.f581a.getId());
                layoutParams.addRule(8, this.f581a.getId());
                layoutParams.setMargins(0, 0, h8.a(5.0f), 0);
            }
            sf sfVar = this.f585a;
            gf gfVar = new gf(this);
            d dVar = this.f582a;
            sfVar.a(gfVar, dVar != null ? dVar.d : 0, dVar);
            this.f585a.setId(102060002);
            addView(this.f585a, layoutParams);
        }
        FrameLayout frameLayout = this.f575a;
        id = frameLayout != null ? frameLayout.getId() : this.f581a.getId();
        layoutParams.addRule(3, id);
        sf sfVar2 = this.f585a;
        gf gfVar2 = new gf(this);
        d dVar2 = this.f582a;
        sfVar2.a(gfVar2, dVar2 != null ? dVar2.d : 0, dVar2);
        this.f585a.setId(102060002);
        addView(this.f585a, layoutParams);
    }

    public void a(int i, int i2) {
        int iA;
        int iA2;
        this.f576a.addRule(i == 3 ? 0 : 1, this.f581a.getId());
        if (i == 3) {
            iA = h8.a(5.0f);
            iA2 = h8.a(5.0f);
        } else if (i == 4) {
            iA = h8.a(5.0f);
            iA2 = 0;
        } else {
            iA = 0;
            iA2 = 0;
        }
        this.f576a.setMargins(iA, h8.a(5.0f), iA2, 0);
        addView(this.f577a, this.f576a);
        this.f577a.setMaxLines(1);
        this.f577a.setTextSize(2, i2);
        if (i2 > 10) {
            this.f577a.setLineSpacing(0.0f, 1.05f);
        }
        this.f577a.setTextColor(-13421773);
        this.f577a.setVisibility(0);
        pk.a("-------setTitleStyle:------ " + this.f589b);
        this.f577a.setText(this.f589b);
    }

    public final void a(Bundle bundle, d dVar) {
        this.f588b = dVar;
        GifImageView2 gifImageView2 = new GifImageView2(getContext());
        this.f581a = gifImageView2;
        gifImageView2.setId(10200002);
        TextView textView = new TextView(getContext());
        this.f577a = textView;
        textView.setId(10200001);
        this.f577a.setMaxLines(2);
        this.f577a.setEllipsize(TextUtils.TruncateAt.END);
        this.f577a.setTextColor(-13421773);
        this.f577a.setTextSize(2, 15.0f);
        this.f587b = new TextView(getContext());
        this.f590c = new TextView(getContext());
        b(bundle, dVar);
    }

    public void a(d dVar, int i, int i2) {
        if (dVar == null) {
            return;
        }
        String str = dVar.f203e;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f587b.setText(str);
        this.f587b.setTextSize(2, i - 1);
        this.f587b.setTextColor(-13421773);
        this.f587b.setMaxLines(2);
        this.f587b.setEllipsize(TextUtils.TruncateAt.END);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        if (i2 == 1) {
            layoutParams.addRule(1, this.f581a.getId());
        } else {
            layoutParams.addRule(0, this.f581a.getId());
        }
        layoutParams.addRule(3, this.f577a.getId());
        layoutParams.setMargins(h8.a(5.0f), h8.a(5.0f), 0, 0);
        addView(this.f587b, layoutParams);
    }

    public void b() {
        TextView textView;
        TextView textView2 = (TextView) findViewById(10200007);
        if (!TextUtils.isEmpty(this.f586a) && textView2 != null) {
            textView2.setText(this.f586a + "   ");
        }
        Typeface typefaceCreate = Typeface.create(Typeface.DEFAULT, 1);
        if (Build.VERSION.SDK_INT >= 28) {
            typefaceCreate = Typeface.create(Typeface.DEFAULT, MediaPlayer.MEDIA_PLAYER_OPTION_CMAF_MPD_SOCKET_CONNECT_TIME, false);
        }
        this.f577a.setTypeface(typefaceCreate);
        if (TextUtils.isEmpty(this.f589b) || (textView = this.f577a) == null) {
            return;
        }
        textView.setText(this.f589b);
    }

    public abstract void b(Bundle bundle, d dVar);

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        canvas.drawPath(this.f574a, this.f573a);
    }

    /* JADX WARN: Code duplicated, block: B:15:0x0036  */
    /* JADX WARN: Code duplicated, block: B:17:0x003e  */
    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            return super.dispatchTouchEvent(motionEvent);
        }
        if (action == 1) {
            if (!this.f574a.isEmpty()) {
                postDelayed(new lf(this), 100L);
            }
        } else if (action == 2) {
            if (this.f574a.isEmpty()) {
                this.f574a.moveTo(motionEvent.getX(), motionEvent.getY());
            }
            this.f574a.lineTo(motionEvent.getX(), motionEvent.getY());
            invalidate();
        } else if (action == 3) {
            if (!this.f574a.isEmpty()) {
                postDelayed(new lf(this), 100L);
            }
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public kl getSessionManager() {
        d dVar = this.f582a;
        if (dVar == null) {
            return null;
        }
        kl klVar = dVar.f185a;
        if (klVar != null) {
            return klVar;
        }
        a2 a2Var = new a2();
        a2Var.a(dVar);
        return a2Var;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        try {
            pk.a("-------isAttachedToWindow:------Native " + (this.f575a != null));
            ArrayList arrayList = new ArrayList();
            arrayList.add(this.f575a);
            arrayList.add(this);
        } catch (Exception e) {
            pk.a("-------isAttachedToWindow:------Native e " + e.getMessage());
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        view.getId();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    public void setNativeAdEventListener(NativeAdEventListener nativeAdEventListener) {
        if (this.f583a == null) {
            return;
        }
        this.f579a = nativeAdEventListener;
        ArrayList arrayList = new ArrayList();
        if (z8.a(this.f588b)) {
            arrayList.add(this);
        }
        TextView textView = this.f577a;
        if (textView != null) {
            arrayList.add(textView);
        }
        TextView textView2 = this.f587b;
        if (textView2 != null) {
            arrayList.add(textView2);
        }
        GifImageView2 gifImageView2 = this.f581a;
        if (gifImageView2 != null) {
            arrayList.add(gifImageView2);
        }
        FrameLayout frameLayout = this.f575a;
        if (frameLayout != null) {
            arrayList.add(frameLayout);
        }
        s3 s3Var = this.f584a;
        if (s3Var != null) {
            arrayList.add(s3Var);
        }
        TextView textView3 = this.f590c;
        if (textView3 != null) {
            arrayList.add(textView3);
        }
        s3 s3Var2 = this.f584a;
        if (s3Var2 != null && s3Var2.getSixDownloadView() != null) {
            arrayList.add(this.f584a.getSixDownloadView());
        }
        ef efVar = this.f583a;
        efVar.getClass();
        pk.a("NativeAdUnitObject bindViewForInteraction: " + this + PPSLabelView.Code + arrayList);
        try {
            f0 f0Var = efVar.f248a;
            if (f0Var != null) {
                f0Var.a(this, arrayList, nativeAdEventListener);
            }
        } catch (Throwable th) {
            pk.a(th);
            oh.b(th);
        }
        a();
        int i = d;
        RelativeLayout.LayoutParams layoutParams = null;
        if (i == 3 || i == 4) {
            int iB = ((h8.b() * 20) / 55) / 3;
            View widgetView = this.f583a.getWidgetView(iB, iB);
            if (widgetView != null && widgetView.getParent() == null) {
                layoutParams = new RelativeLayout.LayoutParams(iB, iB);
                layoutParams.setMargins(200, 30, 100, 0);
            }
            postDelayed(new of(this, widgetView, layoutParams), 700L);
            return;
        }
        int iA = h8.a(75.0f);
        View widgetView2 = this.f583a.getWidgetView(iA, iA);
        if (widgetView2 != null && widgetView2.getParent() == null) {
            layoutParams = new RelativeLayout.LayoutParams(iA, iA);
            layoutParams.addRule(13);
        }
        if (widgetView2 == null || widgetView2.getParent() != null) {
            return;
        }
        addView(widgetView2, layoutParams);
    }

    public void setNativeAdMediaListener(NativeAdData.NativeAdMediaListener nativeAdMediaListener) {
        this.f578a = nativeAdMediaListener;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public final void m704a(d dVar, int i) {
        if (dVar.c == 3) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.setMargins(0, h8.a(0.0f), 0, h8.a(5.0f));
            layoutParams.addRule(3, (i == 3 || i == 4) ? this.f581a.getId() : this.f585a.getId());
            s3 s3Var = new s3(getContext());
            this.f584a = s3Var;
            s3Var.setValue(dVar);
            addView(this.f584a, layoutParams);
            if (i == 4 || i == 3) {
                this.f584a.setDownloadButtonVisible(false);
            }
        }
    }

    public void a(d dVar, RelativeLayout.LayoutParams layoutParams, String str) {
        if (dVar.m605f()) {
            FrameLayout frameLayout = new FrameLayout(getContext());
            this.f575a = frameLayout;
            frameLayout.setId(10200002);
            this.f575a.setTag(str);
            if (TextUtils.isEmpty(dVar.f183a.f321a)) {
                a(dVar.f183a.f322b);
                return;
            }
            layoutParams.addRule(14);
            setParamsValue(layoutParams);
            addView(this.f575a, layoutParams);
            return;
        }
        if (TextUtils.isEmpty(str)) {
            this.f581a.setVisibility(4);
            a(dVar.f204f);
            setParamsValue(layoutParams);
        } else {
            String str2 = dVar.f204f;
            this.f581a.setScaleType(ImageView.ScaleType.FIT_CENTER);
            this.f581a.setBorderRadius(h8.a(10.0f));
            xb xbVarA = xb.a(AdprofSdk.getInstance().getContext());
            xbVarA.getClass();
            xbVarA.new a(str2).a(this.f581a);
        }
        layoutParams.addRule(14);
        addView(this.f581a, layoutParams);
    }

    public void a() {
        FrameLayout frameLayout;
        ef efVar = this.f583a;
        if (efVar == null || (frameLayout = this.f575a) == null) {
            return;
        }
        NativeAdData.NativeAdMediaListener nativeAdMediaListener = this.f578a;
        efVar.getClass();
        pk.a("NativeAdUnitObject bindMediaView: " + frameLayout + PPSLabelView.Code + nativeAdMediaListener);
        try {
            f0 f0Var = efVar.f248a;
            if (f0Var != null) {
                f0Var.a(frameLayout, efVar.getVideoWidth(), efVar.getVideoHeight(), nativeAdMediaListener);
            }
        } catch (Throwable th) {
            pk.a(th);
            oh.b(th);
        }
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public boolean m705a() {
        d dVar = this.f582a;
        return dVar != null && dVar.c == 3;
    }

    public LinearLayout a(d dVar, int i) {
        ArrayList arrayList = new ArrayList();
        if (dVar != null && dVar.f195a != null) {
            pk.a("-----initWidgetLocation size: " + dVar.f195a.size());
            List list = dVar.f195a;
            for (int i2 = 0; i2 < list.size(); i2++) {
                arrayList.add(((AFImage) list.get(i2)).imageUrl);
            }
        }
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setId(10200002);
        linearLayout.setOrientation(0);
        pk.a("-----loadMultiImage: " + arrayList.size());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        if (i == 6) {
            layoutParams.addRule(10);
        } else {
            layoutParams.addRule(3, this.f577a.getId());
        }
        layoutParams.setMargins(0, (int) (Resources.getSystem().getDisplayMetrics().xdpi * 2.0f * 0.013888889f), 0, 0);
        if (this.b > 40) {
            layoutParams.height = h8.a(getImageSetMaxHeightDP());
        }
        addView(linearLayout, layoutParams);
        post(new hf(this, this, arrayList, layoutParams, linearLayout));
        this.f576a.setMargins(h8.a(5.0f), h8.a(5.0f), 0, 0);
        if (i == 6) {
            this.f576a.addRule(3, linearLayout.getId());
        } else {
            this.f576a.addRule(10);
        }
        addView(this.f577a, this.f576a);
        if (TextUtils.isEmpty(this.f589b)) {
            this.f577a.setVisibility(8);
        }
        return linearLayout;
    }

    public void a(String str) {
        this.f581a.setScaleType(ImageView.ScaleType.FIT_CENTER);
        this.f581a.setBorderRadius(h8.a(10.0f));
        GifImageView2 gifImageView2 = this.f581a;
        pk.a("-----loadSingleImage: " + str);
        gifImageView2.setScaleType(ImageView.ScaleType.FIT_CENTER);
        xb.a(AdprofSdk.getInstance().getContext()).a(str, new kf(this, str, gifImageView2));
    }
}
