package com.ubix.ssp.ad.d;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Rect;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import client.android.yixiaotong.util.doorlock.DoorLockCommandUtil;
import com.stub.StubApp;
import com.ubix.ssp.ad.e.a0.r;
import com.ubix.ssp.ad.e.a0.u;
import com.ubix.ssp.ad.e.q;
import com.ubix.ssp.open.AdError;
import com.ubix.ssp.open.nativee.UBiXVideoInteractionListener;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class f extends FrameLayout implements View.OnClickListener, View.OnTouchListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.ubix.ssp.ad.e.b0.d f8609a;
    private com.ubix.ssp.ad.e.t.a.e b;
    private ImageView c;
    private ImageView d;
    private long e;
    private long f;
    private com.ubix.ssp.ad.g.k.g g;
    private boolean h;
    private UBiXVideoInteractionListener i;
    private boolean j;
    private double k;
    private boolean l;
    private boolean m;
    private int n;
    private int o;
    private String p;
    private com.ubix.ssp.ad.g.k.g q;
    private boolean r;
    private volatile boolean s;
    private Rect t;
    private Rect u;
    volatile boolean v;
    long w;
    private HashMap<String, String> x;

    class a implements com.ubix.ssp.ad.g.k.j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ AtomicBoolean f8610a;
        final /* synthetic */ AtomicBoolean b;
        final /* synthetic */ AtomicBoolean c;
        final /* synthetic */ com.ubix.ssp.ad.g.k.g d;

        a(AtomicBoolean atomicBoolean, AtomicBoolean atomicBoolean2, AtomicBoolean atomicBoolean3, com.ubix.ssp.ad.g.k.g gVar) {
            this.f8610a = atomicBoolean;
            this.b = atomicBoolean2;
            this.c = atomicBoolean3;
            this.d = gVar;
        }

        @Override // com.ubix.ssp.ad.g.k.b
        public void a(int i) {
        }

        @Override // com.ubix.ssp.ad.g.k.j
        public void a(int i, int i2) {
            if (this.f8610a.get()) {
                return;
            }
            AdError adErrorH = com.ubix.ssp.ad.e.a0.a0.a.h(3, "缓冲超时");
            com.ubix.ssp.ad.g.k.g gVar = this.d;
            if (gVar != null) {
                gVar.a(i, adErrorH);
            }
            if (f.this.i != null) {
                f.this.i.onVideoError(adErrorH);
            }
        }

        @Override // com.ubix.ssp.ad.g.k.j
        public void a(int i, long j, long j2) {
            if (f.this.f8609a != null) {
                u.e("onVideoProgressUpdate videoView.playable()=" + f.this.f8609a.a() + ";" + this.b.get());
            }
            f.this.e = j2;
            f.this.f = j;
            if (f.this.h && this.b.get()) {
                com.ubix.ssp.ad.g.k.g gVar = this.d;
                if (gVar != null) {
                    gVar.a(i, j, j2);
                }
                if (f.this.i != null) {
                    f.this.i.onVideoProgressUpdate(j, j2);
                }
            }
        }

        @Override // com.ubix.ssp.ad.g.k.b
        public void a(int i, Bundle bundle) {
        }

        @Override // com.ubix.ssp.ad.g.k.b
        public void a(int i, View view) {
        }

        @Override // com.ubix.ssp.ad.g.k.b
        public void b(int i) {
        }

        @Override // com.ubix.ssp.ad.g.k.j
        public void b(int i, int i2) {
        }

        @Override // com.ubix.ssp.ad.g.k.b
        public void b(int i, View view, HashMap<String, String> map) {
            u.b("view=" + view);
            com.ubix.ssp.ad.g.k.g gVar = this.d;
            if (gVar != null) {
                gVar.b(i, f.this, map);
            }
        }

        @Override // com.ubix.ssp.ad.g.k.j
        public void c(int i) {
            this.f8610a.set(true);
            RelativeLayout relativeLayout = (RelativeLayout) f.this.findViewById(2020001);
            if (relativeLayout != null) {
                relativeLayout.setVisibility(0);
            }
            if (f.this.b != null) {
                f.this.b.setVisibility(0);
            }
            View viewFindViewById = f.this.findViewById(200019);
            if (viewFindViewById != null) {
                viewFindViewById.setVisibility(8);
            }
            f.this.s = true;
            com.ubix.ssp.ad.g.k.g gVar = this.d;
            if (gVar != null) {
                gVar.c(i);
            }
            if (f.this.i != null) {
                f.this.i.onVideoComplete();
            }
        }

        @Override // com.ubix.ssp.ad.g.k.b
        public void e(int i) {
        }

        @Override // com.ubix.ssp.ad.g.k.b
        public void f(int i) {
        }

        @Override // com.ubix.ssp.ad.g.k.j
        public void g(int i) {
            if (f.this.f8609a != null) {
                u.e("onVideoPlayPause videoView.playable()=" + f.this.f8609a.a() + ";" + f.this.h);
            }
            if (f.this.h && !this.f8610a.get() && this.b.get()) {
                this.b.set(false);
                com.ubix.ssp.ad.g.k.g gVar = this.d;
                if (gVar != null) {
                    gVar.g(i);
                }
                if (f.this.i != null) {
                    f.this.i.onVideoPause();
                }
            }
        }

        @Override // com.ubix.ssp.ad.g.k.j
        public void h(int i) {
            View viewFindViewById;
            if (f.this.f8609a != null) {
                u.e("onVideoPlayStarted videoView.playable()=" + f.this.f8609a.a() + ";" + f.this.w);
            }
            if (this.f8610a.get()) {
                return;
            }
            f fVar = f.this;
            if (fVar.w > 0) {
                return;
            }
            if (fVar.c != null) {
                f.this.c.setVisibility(8);
            }
            if (f.this.b != null && f.this.f8609a != null && f.this.f8609a.e) {
                f.this.b.setVisibility(4);
            }
            try {
                if (f.this.f8609a != null && (viewFindViewById = f.this.findViewById(2020001)) != null) {
                    ViewGroup.LayoutParams layoutParams = viewFindViewById.getLayoutParams();
                    if (layoutParams == null) {
                        viewFindViewById.setLayoutParams(new FrameLayout.LayoutParams(f.this.f8609a.getWidth(), f.this.f8609a.getHeight()));
                    } else if (layoutParams.width != f.this.f8609a.getWidth() && layoutParams.height != f.this.f8609a.getHeight()) {
                        layoutParams.width = f.this.f8609a.getWidth();
                        layoutParams.height = f.this.f8609a.getHeight();
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
            if (f.this.d != null) {
                f.this.d.setVisibility(0);
            }
            if (f.this.m) {
                f.this.m = false;
                f fVar2 = f.this;
                fVar2.setVideoMute(fVar2.l);
            }
            f.this.h = true;
            if (f.this.f8609a == null || !f.this.f8609a.a()) {
                return;
            }
            this.b.set(true);
            this.c.set(true);
            com.ubix.ssp.ad.g.k.g gVar = this.d;
            if (gVar != null) {
                gVar.h(i);
            }
            if (f.this.i != null) {
                f.this.i.onVideoStart();
            }
        }

        @Override // com.ubix.ssp.ad.g.k.b
        public void i(int i) {
        }

        @Override // com.ubix.ssp.ad.g.k.j
        public void j(int i) {
            if (f.this.f8609a != null) {
                u.e("onVideoPlayResume videoView.playable()=" + f.this.f8609a.a() + ";" + this.c.get() + ";hasPlay.get()=" + this.b.get());
                if (f.this.h && !this.f8610a.get() && f.this.f8609a.a()) {
                    this.b.set(true);
                    if (this.c.get()) {
                        com.ubix.ssp.ad.g.k.g gVar = this.d;
                        if (gVar != null) {
                            gVar.j(i);
                        }
                        if (f.this.i == null) {
                            return;
                        }
                    } else {
                        if (f.this.w <= 0) {
                            this.c.set(true);
                            com.ubix.ssp.ad.g.k.g gVar2 = this.d;
                            if (gVar2 != null) {
                                gVar2.h(i);
                            }
                            if (f.this.i != null) {
                                f.this.i.onVideoStart();
                                return;
                            }
                            return;
                        }
                        this.c.set(true);
                        com.ubix.ssp.ad.g.k.g gVar3 = this.d;
                        if (gVar3 != null) {
                            gVar3.j(i);
                        }
                        if (f.this.i == null) {
                            return;
                        }
                    }
                    f.this.i.onVideoResume();
                }
            }
        }
    }

    public f(Context context, Bundle bundle) {
        super(context);
        this.e = 0L;
        this.f = 0L;
        this.h = false;
        this.j = true;
        this.k = 4.0d;
        this.l = true;
        this.m = true;
        this.n = 2;
        this.p = "";
        this.r = true;
        this.s = false;
        this.t = new Rect();
        this.u = new Rect();
        this.v = false;
        this.w = 0L;
        this.x = new HashMap<>();
        this.k = r.a().a(context);
        this.n = bundle.getInt("AUTO_PLAY", 2);
        this.j = bundle.getBoolean("DO_NOT_RESTRICT_SIZE", false);
        this.o = bundle.getInt("VIDEO_RENDER_TYPE", 0);
        this.d = new ImageView(context);
        this.b = new com.ubix.ssp.ad.e.t.a.e(context);
        this.c = new ImageView(context);
        this.b.setScaleType(ImageView.ScaleType.FIT_XY);
        this.b.setId(200024);
        this.c.setId(2000017);
        this.d.setId(200019);
        this.c.setBackground(q.a("ubix/ic_auto_play.webp"));
        boolean z = !bundle.getBoolean("AUTO_MUTE", true);
        this.l = z;
        this.r = z;
        this.d.setOnClickListener(this);
        this.d.setVisibility(4);
        addView(this.b);
        addView(this.c);
        addView(this.d);
        String string = bundle.getString("BUTTON_TEXT", bundle.getBoolean("IS_DOWNLOAD", false) ? "立即下载" : "查看详情");
        addView(a(TextUtils.isEmpty(string) ? "查看详情" : string, bundle.getInt("TEXT_SIZE", 10)));
        setOnTouchListener(this);
        setOnClickListener(this);
    }

    protected RelativeLayout a(String str, int i) {
        double dA = r.a().a(getContext());
        RelativeLayout relativeLayout = new RelativeLayout(getContext());
        relativeLayout.setId(2020001);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        TextView textView = new TextView(getContext());
        textView.setId(2000016);
        textView.setGravity(17);
        textView.setTextSize(i);
        textView.setSingleLine();
        textView.setEllipsize(TextUtils.TruncateAt.END);
        textView.setTextColor(-1);
        textView.setText(str);
        int i2 = (int) (dA * 6.0d);
        textView.setPadding(i2, i2, i2, i2);
        textView.setBackgroundColor(-12542209);
        layoutParams.addRule(13);
        relativeLayout.addView(textView, layoutParams);
        relativeLayout.setBackgroundColor(Color.parseColor("#99000000"));
        relativeLayout.setVisibility(8);
        return relativeLayout;
    }

    public void a() {
        removeAllViews();
        com.ubix.ssp.ad.e.b0.d dVar = this.f8609a;
        if (dVar != null) {
            dVar.p();
        }
    }

    protected void a(MotionEvent motionEvent) {
        HashMap<String, String> map;
        String str;
        String str2;
        try {
            if (motionEvent.getAction() == 0) {
                this.x.put(com.hihonor.adsdk.base.g.j.e.c.hnadsc, motionEvent.getX() + "");
                this.x.put(com.hihonor.adsdk.base.g.j.e.c.hnadsd, motionEvent.getY() + "");
                this.x.put("__RAW_DOWN_X__", motionEvent.getRawX() + "");
                map = this.x;
                str = motionEvent.getRawY() + "";
                str2 = "__RAW_DOWN_Y__";
            } else {
                if (motionEvent.getAction() != 1) {
                    return;
                }
                this.x.put(com.hihonor.adsdk.base.g.j.e.c.hnadse, motionEvent.getX() + "");
                this.x.put(com.hihonor.adsdk.base.g.j.e.c.hnadsf, motionEvent.getY() + "");
                this.x.put(com.hihonor.adsdk.base.g.j.e.c.hnadsb, getWidth() + "");
                this.x.put(com.hihonor.adsdk.base.g.j.e.c.hnadsa, getHeight() + "");
                this.x.put("__RAW_UP_X__", motionEvent.getRawX() + "");
                this.x.put("__RAW_UP_Y__", motionEvent.getRawY() + "");
                map = this.x;
                str = motionEvent.getX() + "_" + motionEvent.getY();
                str2 = "__CLICK_XY__";
            }
            map.put(str2, str);
        } catch (Exception unused) {
        }
    }

    public void a(String str, com.ubix.ssp.ad.g.k.g gVar) {
        this.p = str;
        this.q = gVar;
        if (this.f8609a != null) {
            b(str, gVar);
            this.v = true;
        }
    }

    public void b() {
        if (this.f8609a != null) {
            setAutoPlay(true);
            this.f8609a.a(1);
            this.f8609a.j();
        }
    }

    public void b(String str, com.ubix.ssp.ad.g.k.g gVar) {
        this.g = gVar;
        AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        AtomicBoolean atomicBoolean2 = new AtomicBoolean(false);
        AtomicBoolean atomicBoolean3 = new AtomicBoolean(false);
        com.ubix.ssp.ad.e.b0.d dVar = this.f8609a;
        if (dVar != null) {
            dVar.a(str, "", 1);
            this.f8609a.setVideoImageDisplayType(4);
            this.e = this.f8609a.getDuration();
            this.f8609a.setVideoViewListener(new a(atomicBoolean, atomicBoolean2, atomicBoolean3, gVar));
        }
    }

    public ImageView getCoverImage() {
        return this.b;
    }

    public long getCurrentDuration() {
        return this.f;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.s) {
            return;
        }
        Context context = getContext();
        int i = this.n;
        int i2 = 2;
        boolean z = i != 3 && (i != 2 ? i == 1 : com.ubix.ssp.ad.e.a0.c.i(StubApp.getOrigApplicationContext(getContext().getApplicationContext())));
        int i3 = this.o;
        if (i3 != 0) {
            i2 = i3;
        } else if (!b.f8605a.isUseTextureView()) {
            i2 = 1;
        }
        com.ubix.ssp.ad.e.b0.d dVar = new com.ubix.ssp.ad.e.b0.d(context, z, i2, this.w);
        this.f8609a = dVar;
        dVar.setId(200015);
        this.f8609a.setMute(this.r);
        addView(this.f8609a, 0);
        if (this.v) {
            return;
        }
        b(this.p, this.q);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() != 200019) {
            com.ubix.ssp.ad.g.k.g gVar = this.g;
            if (gVar != null) {
                gVar.b(0, this, this.x);
                return;
            }
            return;
        }
        com.ubix.ssp.ad.e.b0.d dVar = this.f8609a;
        if (dVar != null) {
            this.d.setImageDrawable(q.a(!dVar.t ? "ubix/ic_volume_off.webp" : "ubix/ic_volume_on.webp"));
            boolean z = !this.f8609a.t;
            this.r = z;
            setVideoMute(z);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        com.ubix.ssp.ad.e.b0.d dVar = this.f8609a;
        if (dVar != null) {
            long currentPositionWhenPlaying = 0 == dVar.getCurrentPositionWhenPlaying() ? this.w : this.f8609a.getCurrentPositionWhenPlaying();
            this.w = currentPositionWhenPlaying;
            this.w = currentPositionWhenPlaying >= 0 ? currentPositionWhenPlaying : 0L;
            removeView(this.f8609a);
            this.f8609a.p();
            this.f8609a = null;
            this.v = false;
        }
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int measuredHeight;
        int height = 0;
        for (int i5 = 0; i5 < getChildCount(); i5++) {
            View childAt = getChildAt(i5);
            switch (childAt.getId()) {
                case DoorLockCommandUtil.DELECTUSERIDCODE /* 200001 */:
                    measuredHeight = childAt.getMeasuredHeight();
                    break;
                case 200015:
                case 200024:
                case 2020001:
                    childAt.layout(i, i2, i3, i4);
                    continue;
                    break;
                case 200019:
                    int iMin = Math.min(i3 - i, i4 - i2);
                    View viewFindViewById = findViewById(2030001);
                    View viewFindViewById2 = findViewById(200025);
                    int iMax = (int) Math.max(i3 / 14, this.k * 24.0d);
                    if (viewFindViewById != null) {
                        if (viewFindViewById2 != null) {
                            height = viewFindViewById2.getHeight();
                        }
                        int i6 = i3 - (iMin / 16);
                        childAt.layout(i6 - iMax, viewFindViewById.getTop() - height, i6, viewFindViewById.getBottom() - height);
                        continue;
                    } else {
                        int i7 = iMin / 16;
                        int i8 = i3 - i7;
                        int i9 = (i4 - i7) - (iMin / 28);
                        childAt.layout(i8 - iMax, i9 - iMax, i8, i9);
                    }
                    break;
                case 200025:
                    measuredHeight = r.b(8.0f);
                    break;
                case 2000017:
                    int iMin2 = Math.min(i3 - i, i4 - i2) / 5;
                    childAt.layout((i3 - iMin2) / 2, (i4 - iMin2) / 2, (i3 + iMin2) / 2, (iMin2 + i4) / 2);
                    continue;
                    break;
                case 2050001:
                    View viewFindViewById3 = findViewById(DoorLockCommandUtil.DELECTUSERIDCODE);
                    View viewFindViewById4 = findViewById(200025);
                    if (viewFindViewById3 != null) {
                        childAt.layout(i, viewFindViewById3.getTop() - childAt.getMeasuredHeight(), i3, viewFindViewById3.getTop());
                        continue;
                    } else {
                        if (viewFindViewById4 != null) {
                            height = viewFindViewById4.getHeight();
                        }
                        childAt.layout(i, (i4 - childAt.getMeasuredHeight()) - height, i3, i4 - height);
                    }
                    break;
                default:
                    continue;
                    break;
            }
            childAt.layout(i, i4 - measuredHeight, i3, i4);
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.j) {
            return;
        }
        u.e("onMeasure MeasureSpec=" + View.MeasureSpec.getMode(i2));
        if (View.MeasureSpec.getMode(i2) == 0) {
            setMeasuredDimension(View.MeasureSpec.getSize(i), (View.MeasureSpec.getSize(i) * 9) / 16);
            com.ubix.ssp.ad.e.b0.d dVar = this.f8609a;
            if (dVar == null || dVar.getLayoutParams() == null) {
                return;
            }
            this.f8609a.getLayoutParams().width = -1;
            this.f8609a.getLayoutParams().height = (View.MeasureSpec.getSize(i) * 9) / 16;
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        a(motionEvent);
        return false;
    }

    public void setAutoPlay(boolean z) {
        com.ubix.ssp.ad.e.b0.d dVar = this.f8609a;
        if (dVar != null) {
            dVar.setAutoPlay(z);
            if (z) {
                this.f8609a.j();
            }
        }
    }

    public void setListener(UBiXVideoInteractionListener uBiXVideoInteractionListener) {
        this.i = uBiXVideoInteractionListener;
    }

    public void setVideoMute(boolean z) {
        this.r = z;
        com.ubix.ssp.ad.e.b0.d dVar = this.f8609a;
        if (dVar != null) {
            dVar.setMute(z);
        }
        ImageView imageView = this.d;
        if (imageView != null) {
            imageView.setImageDrawable(q.a(z ? "ubix/ic_volume_off.webp" : "ubix/ic_volume_on.webp"));
        }
    }
}
