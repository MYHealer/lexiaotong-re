package com.ubix.ssp.ad.h.c;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.ubix.ssp.ad.e.a0.k;
import com.ubix.ssp.ad.e.a0.r;
import com.ubix.ssp.ad.e.q;
import com.ubix.ssp.ad.g.k.j;
import java.io.File;
import java.util.HashMap;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public abstract class b extends RelativeLayout implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected int f8969a;
    protected int b;
    protected int c;
    protected int d;
    protected int e;
    protected int f;
    protected int g;
    private int h;
    protected HashMap<String, Integer> i;
    protected int j;
    protected int k;
    protected HashMap<String, String> l;
    protected int m;
    protected String n;
    protected double o;
    private boolean p;
    protected com.ubix.ssp.ad.g.k.e q;
    protected int r;
    protected boolean s;
    protected int t;
    protected int u;

    class a implements j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f8970a;
        final /* synthetic */ com.ubix.ssp.ad.e.b0.g b;

        a(String str, com.ubix.ssp.ad.e.b0.g gVar) {
            this.f8970a = str;
            this.b = gVar;
        }

        @Override // com.ubix.ssp.ad.g.k.b
        public void a(int i) {
        }

        @Override // com.ubix.ssp.ad.g.k.j
        public void a(int i, int i2) {
        }

        @Override // com.ubix.ssp.ad.g.k.j
        public void a(int i, long j, long j2) {
            com.ubix.ssp.ad.g.k.e eVar = b.this.q;
            if (eVar != null) {
                eVar.a(i, j, j2);
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
            b bVar = b.this;
            com.ubix.ssp.ad.g.k.e eVar = bVar.q;
            if (eVar != null) {
                eVar.b(i, view, bVar.l);
            }
        }

        @Override // com.ubix.ssp.ad.g.k.j
        public void c(int i) {
            if (this.f8970a == null || b.this.findViewById(400004) == null) {
                return;
            }
            try {
                if (b.this.findViewById(400009) != null) {
                    b.this.findViewById(400009).setVisibility(4);
                }
                this.b.setVisibility(4);
                b.this.findViewById(400007).setVisibility(8);
                b.this.findViewById(400004).setVisibility(0);
            } catch (Exception unused) {
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
        }

        @Override // com.ubix.ssp.ad.g.k.j
        public void h(int i) {
            com.ubix.ssp.ad.e.b0.g gVar;
            if (this.f8970a == null || b.this.findViewById(400004) == null || (gVar = this.b) == null || !gVar.e) {
                return;
            }
            try {
                b bVar = b.this;
                if (bVar.m == 6014 && bVar.findViewById(400009) != null) {
                    b.this.findViewById(400009).setBackgroundColor(-16777216);
                }
                b.this.findViewById(400007).setVisibility(0);
                b.this.findViewById(400004).setVisibility(8);
            } catch (Exception unused) {
            }
        }

        @Override // com.ubix.ssp.ad.g.k.b
        public void i(int i) {
        }

        @Override // com.ubix.ssp.ad.g.k.j
        public void j(int i) {
        }
    }

    public b(Context context, Bundle bundle) {
        super(context);
        this.f = 0;
        this.h = 0;
        this.j = 4;
        this.k = 0;
        this.n = "";
        this.r = 0;
        this.s = false;
        this.t = 0;
        this.u = 5;
        this.r = bundle.getInt("RENDER_MODE", 0);
        this.o = r.a().a(context);
        this.m = bundle.getInt("TEMPLATE_ID");
        this.j = (int) (this.j * r.a().a(context));
        this.k = bundle.getInt("AD_INDEX");
        this.n = bundle.getString("AD_SOURCE");
        this.i = (HashMap) bundle.getSerializable("SIZE_MAP");
        this.l = (HashMap) bundle.getSerializable("CLICK_MAP");
        this.s = bundle.getBoolean("SUPPORT_FEED_BACK");
        this.f8969a = this.i.get("instlWidth").intValue();
        this.b = this.i.get("instlHeight").intValue();
        this.c = this.i.get("drawingWidth").intValue();
        this.d = this.i.get("drawingHeight").intValue();
        this.t = bundle.getInt("SKIP_VIEW_STYLE", 0);
        this.u = bundle.getInt("SKIP_COUNT_TIME", 5);
        a(bundle.getBoolean("IS_DOWNLOAD"), bundle.getInt("VIDEO_RENDER_TYPE", 0));
    }

    public static b a(Context context, Bundle bundle) {
        int i = bundle.getInt("TEMPLATE_ID");
        switch (i) {
            case 6001:
            case 6002:
                return new com.ubix.ssp.ad.h.c.a(context, bundle);
            case 6003:
                return bundle.getInt("AD_WIDTH") >= bundle.getInt("AD_HEIGHT") ? new e(context, bundle) : new com.ubix.ssp.ad.h.c.a(context, bundle);
            case 6004:
                return new c(context, bundle);
            default:
                switch (i) {
                    case 6012:
                        return new g(context, bundle);
                    case 6013:
                        return bundle.getInt("AD_WIDTH") >= bundle.getInt("AD_HEIGHT") ? new f(context, bundle) : new g(context, bundle);
                    case 6014:
                        return new d(context, bundle);
                    default:
                        return null;
                }
        }
    }

    /* JADX WARN: Code duplicated, block: B:40:0x0156  */
    /* JADX WARN: Code duplicated, block: B:42:0x015e  */
    /* JADX WARN: Code duplicated, block: B:44:0x0166  */
    /* JADX WARN: Code duplicated, block: B:45:0x0168  */
    /* JADX WARN: Code duplicated, block: B:46:0x016a  */
    /* JADX WARN: Code duplicated, block: B:49:0x0172 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:57:0x0194  */
    /* JADX WARN: Code duplicated, block: B:63:0x01b6  */
    /* JADX WARN: Code duplicated, block: B:66:0x01d4  */
    /* JADX WARN: Code duplicated, block: B:69:0x01e2 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:70:0x01e4  */
    /* JADX WARN: Code duplicated, block: B:71:0x01e8  */
    /* JADX WARN: Code duplicated, block: B:74:0x01f3  */
    /* JADX WARN: Code duplicated, block: B:77:0x020f  */
    /* JADX WARN: Code duplicated, block: B:80:? A[RETURN, SYNTHETIC] */
    private void a(boolean z, int i) {
        ViewGroup.LayoutParams layoutParams;
        View view;
        RelativeLayout relativeLayout;
        RelativeLayout.LayoutParams layoutParams2;
        int i2;
        com.ubix.ssp.ad.e.b0.g gVar;
        int i3;
        View imageView;
        removeAllViews();
        TextView textView = new TextView(getContext());
        ImageView imageView2 = new ImageView(getContext());
        ImageView imageView3 = new ImageView(getContext());
        FrameLayout frameLayout = new FrameLayout(getContext());
        frameLayout.setId(400005);
        com.ubix.ssp.ad.e.t.a.e eVar = new com.ubix.ssp.ad.e.t.a.e(getContext());
        eVar.setScaleType(ImageView.ScaleType.FIT_XY);
        int i4 = this.r;
        if (i4 != 1 && i4 == 2) {
            eVar.setScaleType(ImageView.ScaleType.CENTER_CROP);
        }
        eVar.setId(400004);
        int i5 = this.m;
        if (i5 == 6012 || i5 == 6013 || i5 == 6014) {
            eVar.setSupportRound(false);
        } else {
            eVar.setSupportRound(true);
        }
        eVar.setOnClickListener(this);
        eVar.setBackgroundColor(0);
        try {
            int i6 = this.m;
            if (i6 == 6004 || i6 == 6014) {
                int i7 = this.t;
                if (i7 == 1) {
                    imageView = null;
                } else if (i7 == 2) {
                    com.ubix.ssp.ad.e.g gVar2 = new com.ubix.ssp.ad.e.g(getContext());
                    gVar2.setTextSize(r.a(4.0f));
                    gVar2.setTextColor(-1);
                    gVar2.setText("跳过");
                    layoutParams = new RelativeLayout.LayoutParams(r.b(24.0f), r.b(24.0f));
                    view = gVar2;
                } else if (i7 == 3 || i7 == 4) {
                    TextView textView2 = new TextView(getContext());
                    textView2.setBackground(com.ubix.ssp.ad.e.a0.c.a(getContext(), Integer.MIN_VALUE, 72));
                    textView2.setTextColor(-1);
                    textView2.setGravity(17);
                    layoutParams = new RelativeLayout.LayoutParams(r.b(40.0f), r.b(16.0f));
                    view = textView2;
                } else {
                    View imageView4 = new ImageView(getContext());
                    layoutParams = new RelativeLayout.LayoutParams(r.b(24.0f), r.b(24.0f));
                    view = imageView4;
                }
                RelativeLayout relativeLayout2 = new RelativeLayout(getContext());
                relativeLayout2.setId(400009);
                addView(relativeLayout2, new ViewGroup.LayoutParams(-1, -1));
                relativeLayout = new RelativeLayout(getContext());
                layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
                layoutParams2.addRule(13);
                relativeLayout.setId(400008);
                i2 = this.m;
                if (i2 != 6012 || i2 == 6013 || i2 == 6014) {
                    Context context = getContext();
                    if (i != 0) {
                        i3 = i;
                    } else if (com.ubix.ssp.ad.d.b.f8605a.isUseTextureView()) {
                        i3 = 2;
                    } else {
                        i3 = 1;
                    }
                    gVar = new com.ubix.ssp.ad.e.b0.g(context, i3);
                    if (this.m == 6014 && (i != 0 ? i == 2 : com.ubix.ssp.ad.d.b.f8605a.isUseTextureView())) {
                        gVar.setBackgroundColor(0);
                    }
                    gVar.setId(400006);
                    relativeLayout.setVisibility(4);
                    gVar.setVideoImageDisplayType(4);
                    if (this.m == 6014 && this.r != 1) {
                        gVar.setVideoImageDisplayType(1);
                    }
                    imageView3.setOnClickListener(this);
                    relativeLayout.addView(gVar, layoutParams2);
                    addView(relativeLayout, new ViewGroup.LayoutParams(this.f8969a, this.b));
                }
                addView(eVar);
                addView(frameLayout);
                if (view != null) {
                    view.setId(400001);
                }
                imageView2.setId(400002);
                textView.setId(400003);
                imageView3.setId(400007);
                imageView3.setVisibility(4);
                if (z) {
                    b();
                }
                addView(imageView2);
                addView(textView);
                addView(imageView3);
                if (view != null) {
                    if (layoutParams != null) {
                        addView(view, layoutParams);
                    } else {
                        addView(view);
                    }
                }
                if (!TextUtils.isEmpty(this.n)) {
                    textView.setShadowLayer(4.0f, 0.0f, 1.0f, 1711276032);
                    textView.setTextColor(-1);
                    textView.setTextSize(6.0f);
                    textView.setText(this.n);
                }
                if (this.s) {
                    RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(r.b(20.0f), r.b(12.0f));
                    TextView textView3 = new TextView(getContext());
                    textView3.setGravity(17);
                    textView3.setBackground(com.ubix.ssp.ad.e.a0.c.a(getContext(), Integer.MIN_VALUE, 72));
                    textView3.setTextColor(-1);
                    textView3.setTextSize(11.0f);
                    textView3.setText("反馈");
                    textView3.setId(920301);
                    textView3.setLayoutParams(layoutParams3);
                    addView(textView3);
                    textView3.setOnClickListener(this);
                }
            }
            imageView = new ImageView(getContext());
        } catch (Throwable th) {
            th.printStackTrace();
            imageView = new ImageView(getContext());
        }
        layoutParams = null;
        view = imageView;
        RelativeLayout relativeLayout3 = new RelativeLayout(getContext());
        relativeLayout3.setId(400009);
        addView(relativeLayout3, new ViewGroup.LayoutParams(-1, -1));
        relativeLayout = new RelativeLayout(getContext());
        layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(13);
        relativeLayout.setId(400008);
        i2 = this.m;
        if (i2 != 6012) {
            Context context2 = getContext();
            if (i != 0) {
                i3 = i;
            } else if (com.ubix.ssp.ad.d.b.f8605a.isUseTextureView()) {
                i3 = 2;
            } else {
                i3 = 1;
            }
            gVar = new com.ubix.ssp.ad.e.b0.g(context2, i3);
            if (this.m == 6014) {
                gVar.setBackgroundColor(0);
            }
            gVar.setId(400006);
            relativeLayout.setVisibility(4);
            gVar.setVideoImageDisplayType(4);
            if (this.m == 6014) {
                gVar.setVideoImageDisplayType(1);
            }
            imageView3.setOnClickListener(this);
            relativeLayout.addView(gVar, layoutParams2);
            addView(relativeLayout, new ViewGroup.LayoutParams(this.f8969a, this.b));
        } else {
            Context context3 = getContext();
            if (i != 0) {
                i3 = i;
            } else if (com.ubix.ssp.ad.d.b.f8605a.isUseTextureView()) {
                i3 = 2;
            } else {
                i3 = 1;
            }
            gVar = new com.ubix.ssp.ad.e.b0.g(context3, i3);
            if (this.m == 6014) {
                gVar.setBackgroundColor(0);
            }
            gVar.setId(400006);
            relativeLayout.setVisibility(4);
            gVar.setVideoImageDisplayType(4);
            if (this.m == 6014) {
                gVar.setVideoImageDisplayType(1);
            }
            imageView3.setOnClickListener(this);
            relativeLayout.addView(gVar, layoutParams2);
            addView(relativeLayout, new ViewGroup.LayoutParams(this.f8969a, this.b));
        }
        addView(eVar);
        addView(frameLayout);
        if (view != null) {
            view.setId(400001);
        }
        imageView2.setId(400002);
        textView.setId(400003);
        imageView3.setId(400007);
        imageView3.setVisibility(4);
        if (z) {
            b();
        }
        addView(imageView2);
        addView(textView);
        addView(imageView3);
        if (view != null) {
            if (layoutParams != null) {
                addView(view, layoutParams);
            } else {
                addView(view);
            }
        }
        if (!TextUtils.isEmpty(this.n)) {
            textView.setShadowLayer(4.0f, 0.0f, 1.0f, 1711276032);
            textView.setTextColor(-1);
            textView.setTextSize(6.0f);
            textView.setText(this.n);
        }
        if (this.s) {
            RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(r.b(20.0f), r.b(12.0f));
            TextView textView4 = new TextView(getContext());
            textView4.setGravity(17);
            textView4.setBackground(com.ubix.ssp.ad.e.a0.c.a(getContext(), Integer.MIN_VALUE, 72));
            textView4.setTextColor(-1);
            textView4.setTextSize(11.0f);
            textView4.setText("反馈");
            textView4.setId(920301);
            textView4.setLayoutParams(layoutParams4);
            addView(textView4);
            textView4.setOnClickListener(this);
        }
    }

    private void b() {
        addView(com.ubix.ssp.ad.e.f.a(getContext()));
    }

    public void a() {
        try {
            com.ubix.ssp.ad.e.b0.g gVar = (com.ubix.ssp.ad.e.b0.g) findViewById(400006);
            if (gVar != null) {
                gVar.p();
            }
            View viewFindViewById = findViewById(400001);
            if (viewFindViewById == null || !(viewFindViewById instanceof com.ubix.ssp.ad.e.g)) {
                return;
            }
            ((com.ubix.ssp.ad.e.g) viewFindViewById).c();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void a(String str, String str2) {
        try {
            com.ubix.ssp.ad.e.v.e.b().b(str2, (ImageView) findViewById(400004));
        } catch (Exception e) {
            e.printStackTrace();
        }
        com.ubix.ssp.ad.e.b0.g gVar = (com.ubix.ssp.ad.e.b0.g) findViewById(400006);
        String str3 = k.f(getContext()).getPath() + "/" + str.hashCode();
        File fileA = com.ubix.ssp.ad.e.v.e.c().a(str);
        if (fileA != null && fileA.exists()) {
            str = str3;
        }
        gVar.a(str, (String) null);
        gVar.setVideoViewListener(new a(str2, gVar));
        setMuted(this.p);
    }

    public void a(String str, String str2, String str3, String str4, String str5, String str6, long j) {
        boolean z;
        String strA;
        TextView textView = (TextView) findViewById(920101);
        if (textView == null) {
            return;
        }
        if (j > 0) {
            strA = k.a(j);
            z = true;
        } else {
            z = false;
            strA = "";
        }
        Object[] objArr = new Object[6];
        objArr[0] = str;
        objArr[1] = str2;
        objArr[2] = str3;
        objArr[3] = TextUtils.isEmpty(str5) ? "" : "丨备案号:" + str5;
        objArr[4] = TextUtils.isEmpty(str6) ? "" : "丨适用年龄:" + str6;
        objArr[5] = z ? "丨应用大小:" + strA : "";
        textView.setText(new com.ubix.ssp.ad.e.f(String.format("应用名称:%s丨应用版本:%s丨开发者:%s%s%s%s丨权限丨隐私丨功能介绍", objArr)).a(this.q));
    }

    public void a(HashMap<String, Integer> map) {
        this.i = map;
        this.f8969a = map.get("instlWidth").intValue();
        this.b = map.get("instlHeight").intValue();
        this.c = map.get("drawingWidth").intValue();
        this.d = map.get("drawingHeight").intValue();
    }

    public boolean a(int i) {
        return false;
    }

    public boolean a(Bundle bundle) {
        Bitmap bitmapB;
        try {
            this.p = !bundle.getBoolean("AUTO_MUTE", true);
            int i = this.m;
            if (i == 6013 || i == 6012 || i == 6014) {
                a(bundle.getString("VIDEO_URL"), bundle.getStringArray("IMAGE_URL")[0]);
            } else {
                com.ubix.ssp.ad.e.v.e.b().b(bundle.getStringArray("IMAGE_URL")[0], (ImageView) findViewById(400004));
            }
            setAdLogo(bundle.getBoolean("IS_UNNAMED"));
            c();
            int i2 = this.m;
            if ((i2 == 6014 || i2 == 6004) && this.r == 1 && (bitmapB = com.ubix.ssp.ad.e.a0.c.b(bundle.getStringArray("IMAGE_URL")[0])) != null) {
                setBackground(new BitmapDrawable(bitmapB));
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    protected void c() {
        View viewFindViewById = findViewById(400001);
        if (viewFindViewById != null) {
            if (viewFindViewById instanceof ImageView) {
                ((ImageView) viewFindViewById).setImageDrawable(q.a("ubix/ic_close_gray.webp"));
            }
            viewFindViewById.setOnClickListener(this);
        }
    }

    protected int getAppInfoTop() {
        int iC;
        int i;
        View viewFindViewById = findViewById(920101);
        if (viewFindViewById == null || viewFindViewById.getVisibility() == 8) {
            iC = (getRealTemplateId() == 6003 || getRealTemplateId() == 6013) ? ((r.a().c(getContext()) - com.ubix.ssp.ad.e.a0.c.e(getContext())) + this.d) / 2 : findViewById(400004).getBottom();
            i = this.j * 3;
        } else {
            iC = viewFindViewById.getTop();
            i = this.j * 2;
        }
        return iC - i;
    }

    public abstract int getRealTemplateId();

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.ubix.ssp.ad.g.k.e eVar;
        int id = view.getId();
        if (id == 400001) {
            com.ubix.ssp.ad.g.k.e eVar2 = this.q;
            if (eVar2 != null) {
                eVar2.e(this.k);
            }
            a();
            return;
        }
        if (id == 400004) {
            this.l.put("__CLICK_TRIGGER__", "");
            com.ubix.ssp.ad.g.k.e eVar3 = this.q;
            if (eVar3 != null) {
                eVar3.b(this.k, this, this.l);
                return;
            }
            return;
        }
        if (id == 400007) {
            setMuted(!this.p);
        } else if (id == 920301 && (eVar = this.q) != null) {
            eVar.a(this.k);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        a();
    }

    @Override // android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        setMeasuredDimension(r.a().h(getContext()), r.a().c(getContext()));
        this.f = this.f8969a / 2;
        if (getResources().getConfiguration().orientation == 2) {
            this.f = (int) (((double) this.f8969a) * 0.75d);
        }
        int i3 = this.g;
        int i4 = this.f;
        if (i3 > i4) {
            this.g = i4;
        }
        this.e = this.g + (this.h * 2);
    }

    protected void setAdLogo(boolean z) {
        try {
            ((ImageView) findViewById(400002)).setImageDrawable(q.a("ubix/ic_logo.png", z));
        } catch (Throwable unused) {
        }
    }

    public void setInnerListener(com.ubix.ssp.ad.g.k.b bVar) {
        this.q = (com.ubix.ssp.ad.g.k.e) bVar;
    }

    protected void setMuted(boolean z) {
        try {
            ImageView imageView = (ImageView) findViewById(400007);
            if (imageView != null) {
                imageView.setImageDrawable(q.a(z ? "ubix/ic_volume_off.webp" : "ubix/ic_volume_on.webp"));
                imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            }
            com.ubix.ssp.ad.e.b0.g gVar = (com.ubix.ssp.ad.e.b0.g) findViewById(400006);
            if (gVar != null) {
                gVar.setMute(z);
            }
            this.p = z;
        } catch (Throwable unused) {
        }
    }
}
