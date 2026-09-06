package com.ubix.ssp.ad.c.c;

import android.animation.AnimatorSet;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.hihonor.adsdk.base.ErrorCode;
import com.ubix.ssp.ad.e.a0.r;
import com.ubix.ssp.ad.e.b0.g;
import com.ubix.ssp.ad.e.f;
import java.util.HashMap;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public abstract class c extends RelativeLayout implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected int f8586a;
    protected int b;
    protected int c;
    private double d;
    protected HashMap<String, String> e;
    private boolean f;
    private boolean g;
    private com.ubix.ssp.ad.g.k.a h;
    protected AnimatorSet i;
    protected boolean j;

    public c(Context context, Bundle bundle) {
        super(context);
        this.f8586a = 4;
        this.d = 3.0d;
        this.e = new HashMap<>();
        this.f = true;
        this.g = false;
        this.i = new AnimatorSet();
        this.j = false;
        int i = bundle.getInt("AD_WIDTH");
        int i2 = bundle.getInt("AD_HEIGHT");
        boolean z = bundle.getBoolean("IS_DOWNLOAD", false);
        int i3 = bundle.getInt("VIDEO_RENDER_TYPE", 0);
        double dA = r.a().a(context);
        this.d = dA;
        this.b = (int) (((double) i) * dA);
        this.c = (int) (((double) i2) * dA);
        this.f8586a = (int) (((double) this.f8586a) * dA);
        this.e = (HashMap) bundle.getSerializable("CLICK_MAP");
        this.j = bundle.getBoolean("IS_UNNAMED");
        a(bundle.getInt("TEMPLATE_ID"), z, i3);
    }

    public static c a(Context context, Bundle bundle) {
        int i = bundle.getInt("TEMPLATE_ID");
        if (i == 4003) {
            return new a(context, bundle);
        }
        if (i == 4004) {
            return new b(context, bundle);
        }
        if (i != 99001) {
            return null;
        }
        return new d(context, bundle);
    }

    private void a(int i, boolean z, int i2) {
        g gVar;
        int i3;
        removeAllViews();
        ImageView imageView = new ImageView(getContext());
        TextView textView = new TextView(getContext());
        ImageView imageView2 = new ImageView(getContext());
        ImageView imageView3 = new ImageView(getContext());
        TextView textView2 = new TextView(getContext());
        TextView textView3 = new TextView(getContext());
        TextView textView4 = new TextView(getContext());
        if (i != 99001) {
            if (i == 4004) {
                Context context = getContext();
                if (i2 == 0) {
                    i3 = com.ubix.ssp.ad.d.b.f8605a.isUseTextureView() ? 2 : 1;
                } else {
                    i3 = i2;
                }
                gVar = new g(context, i3);
                gVar.setId(ErrorCode.d.hnadsj);
                gVar.setMute(true);
                gVar.setVideoImageDisplayType(4);
                gVar.setOnClickListener(this);
            } else {
                gVar = null;
            }
            imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
            imageView.setId(100010);
            textView3.setId(ErrorCode.d.hnadsc);
            imageView3.setId(ErrorCode.d.hnadsk);
            imageView2.setId(100008);
            textView.setId(100009);
            textView2.setId(ErrorCode.d.hnadsg);
            textView.setTextSize(7.0f);
            textView.setTextColor(-1);
            textView.setShadowLayer(4.0f, 0.0f, 1.0f, 1711276032);
            textView.setPadding(0, 0, 4, 0);
            textView2.setTextSize(10.0f);
            textView2.setPadding(4, 10, 4, 10);
            textView2.setTextColor(-1);
            textView2.setGravity(17);
            textView3.setTextColor(-16777216);
            textView3.setGravity(17);
            textView3.setMaxLines(2);
            textView3.setEllipsize(TextUtils.TruncateAt.END);
            imageView.setOnClickListener(this);
            if (gVar != null) {
                addView(gVar);
            }
            addView(imageView);
            addView(textView3);
            addView(imageView2);
            addView(textView2);
            addView(textView);
            addView(imageView3);
        } else {
            imageView.setId(500101);
            textView2.setId(500104);
            textView3.setId(500102);
            textView4.setId(500103);
            textView3.setGravity(16);
            textView4.setGravity(16);
            textView2.setGravity(17);
            textView3.setTextColor(-1);
            textView4.setTextColor(-1);
            textView2.setSingleLine();
            textView2.setEllipsize(TextUtils.TruncateAt.END);
            textView3.setTextSize(TypedValue.applyDimension(0, 15.0f, getContext().getResources().getDisplayMetrics()));
            textView4.setTextSize(TypedValue.applyDimension(0, 14.0f, getContext().getResources().getDisplayMetrics()));
            textView2.setTextSize(TypedValue.applyDimension(0, 13.0f, getContext().getResources().getDisplayMetrics()));
            textView3.setSingleLine();
            textView4.setSingleLine();
            textView3.setEllipsize(TextUtils.TruncateAt.END);
            textView4.setEllipsize(TextUtils.TruncateAt.END);
            textView2.setTextColor(-1);
            textView2.setBackground(com.ubix.ssp.ad.e.a0.c.a(getContext(), -12542209, 6));
            textView2.setZ(this.f8586a);
            setZ(this.f8586a);
            addView(imageView);
            int i4 = this.b;
            int i5 = this.c;
            int i6 = this.f8586a;
            addView(textView3, new RelativeLayout.LayoutParams((i4 - (i5 * 2)) - (i6 * 2), (i5 / 2) - (i6 * 3)));
            int i7 = this.b;
            int i8 = this.c;
            int i9 = this.f8586a;
            addView(textView4, new RelativeLayout.LayoutParams((i7 - (i8 * 2)) - (i9 * 2), (i8 / 2) - (i9 * 3)));
            int i10 = this.c;
            addView(textView2, new RelativeLayout.LayoutParams(i10, i10 - (this.f8586a * 16)));
        }
        if (z) {
            addView(f.a(getContext(), 2), new RelativeLayout.LayoutParams(-2, -2));
        }
        setOnClickListener(this);
        imageView.setOnClickListener(this);
        imageView3.setOnClickListener(this);
        textView3.setOnClickListener(this);
        textView4.setOnClickListener(this);
        textView2.setOnClickListener(this);
    }

    public abstract boolean a(Bundle bundle);

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() != 100007) {
            com.ubix.ssp.ad.g.k.a aVar = this.h;
            if (aVar != null) {
                aVar.b(0, view, this.e);
                return;
            }
            return;
        }
        com.ubix.ssp.ad.g.k.a aVar2 = this.h;
        if (aVar2 != null) {
            aVar2.e(0);
        }
    }

    @Override // android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.b <= 0) {
            this.b = (int) (this.d * 320.0d);
        }
        if (this.c <= 0) {
            this.c = (int) (((double) this.b) / 6.4d);
        }
        setMeasuredDimension(this.b, this.c);
    }

    public void setInnerListener(com.ubix.ssp.ad.g.k.b bVar) {
        this.h = (com.ubix.ssp.ad.g.k.a) bVar;
    }
}
