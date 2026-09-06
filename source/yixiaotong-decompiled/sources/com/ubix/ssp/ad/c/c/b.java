package com.ubix.ssp.ad.c.c;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.hihonor.adsdk.base.ErrorCode;
import com.stub.StubApp;
import com.ubix.ssp.ad.e.b0.g;
import com.ubix.ssp.ad.e.q;
import com.ubix.ssp.ad.e.v.e;
import com.ubix.ssp.ad.g.k.j;
import java.util.HashMap;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class b extends c {
    private boolean k;
    private boolean l;

    class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ g f8584a;
        final /* synthetic */ Bundle b;

        /* JADX INFO: renamed from: com.ubix.ssp.ad.c.c.b$a$a, reason: collision with other inner class name */
        class C1060a implements j {
            C1060a() {
            }

            @Override // com.ubix.ssp.ad.g.k.b
            public void a(int i) {
            }

            @Override // com.ubix.ssp.ad.g.k.j
            public void a(int i, int i2) {
            }

            @Override // com.ubix.ssp.ad.g.k.j
            public void a(int i, long j, long j2) {
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
            }

            @Override // com.ubix.ssp.ad.g.k.j
            public void c(int i) {
                View viewFindViewById = b.this.findViewById(100010);
                if (viewFindViewById != null) {
                    viewFindViewById.setVisibility(0);
                }
                try {
                    g gVar = a.this.f8584a;
                    if (gVar != null) {
                        gVar.setVisibility(8);
                        e.b().b(a.this.b.getStringArray("IMAGE_URL")[0], (ImageView) b.this.findViewById(100010));
                        a.this.f8584a.p();
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
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
                View viewFindViewById = b.this.findViewById(100011);
                if (viewFindViewById != null) {
                    viewFindViewById.setVisibility(4);
                }
                View viewFindViewById2 = b.this.findViewById(100010);
                if (viewFindViewById2 != null) {
                    viewFindViewById2.setVisibility(4);
                }
            }

            @Override // com.ubix.ssp.ad.g.k.b
            public void i(int i) {
            }

            @Override // com.ubix.ssp.ad.g.k.j
            public void j(int i) {
            }
        }

        a(g gVar, Bundle bundle) {
            this.f8584a = gVar;
            this.b = bundle;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f8584a.a(this.b.getString("VIDEO_URL"), "");
            this.f8584a.setVideoViewListener(new C1060a());
        }
    }

    public b(Context context, Bundle bundle) {
        super(context, bundle);
        boolean z = false;
        this.k = false;
        this.l = false;
        this.k = bundle.getBoolean("IS_DOWNLOAD");
        int i = bundle.getInt("AUTO_PLAY", 2);
        if (i != 3 && (i != 2 ? i == 1 : com.ubix.ssp.ad.e.a0.c.i(StubApp.getOrigApplicationContext(getContext().getApplicationContext())))) {
            z = true;
        }
        this.l = z;
        ImageView imageView = new ImageView(context);
        imageView.setId(100011);
        imageView.setImageDrawable(q.a("ubix/ic_auto_play.webp"));
        addView(imageView);
    }

    @Override // com.ubix.ssp.ad.c.c.c
    public boolean a(Bundle bundle) {
        try {
            ImageView imageView = (ImageView) findViewById(100010);
            if (imageView != null) {
                imageView.setBackgroundDrawable(new BitmapDrawable(com.ubix.ssp.ad.e.a0.c.b(bundle.getStringArray("IMAGE_URL")[0])));
                e.b().b(bundle.getStringArray("IMAGE_URL")[0], imageView);
            }
            g gVar = (g) findViewById(ErrorCode.d.hnadsj);
            if (gVar != null) {
                if (this.l) {
                    post(new a(gVar, bundle));
                } else {
                    gVar.setVisibility(4);
                }
            }
            ImageView imageView2 = (ImageView) findViewById(100008);
            if (imageView2 != null) {
                imageView2.setBackground(q.a("ubix/ic_logo_dark_bg.webp", this.j));
            }
            ImageView imageView3 = (ImageView) findViewById(ErrorCode.d.hnadsk);
            if (imageView3 != null) {
                imageView3.setBackground(q.a("ubix/ic_close_gray.webp"));
            }
            TextView textView = (TextView) findViewById(100009);
            if (textView != null && !TextUtils.isEmpty(bundle.getString("AD_SOURCE", ""))) {
                textView.setShadowLayer(4.0f, 0.0f, 1.0f, 1711276032);
                textView.setText(bundle.getString("AD_SOURCE", ""));
            }
            TextView textView2 = (TextView) findViewById(ErrorCode.d.hnadsc);
            if (textView2 != null) {
                textView2.setText(bundle.getString("TITLE"));
            }
            TextView textView3 = (TextView) findViewById(ErrorCode.d.hnadsg);
            if (textView3 == null) {
                return true;
            }
            String string = bundle.getString("BUTTON_TEXT");
            if (TextUtils.isEmpty(string)) {
                string = this.k ? "立即下载" : "查看详情";
            }
            textView3.setText(string);
            textView3.setBackground(com.ubix.ssp.ad.e.a0.c.a(getContext(), Color.parseColor("#FA800F"), 120));
            return true;
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        ViewGroup.LayoutParams layoutParams;
        int i5;
        ViewGroup.LayoutParams layoutParams2;
        int left;
        int i6;
        super.onLayout(z, i, i2, i3, i4);
        this.e.put(com.hihonor.adsdk.base.g.j.e.c.hnadsb, getWidth() + "");
        this.e.put(com.hihonor.adsdk.base.g.j.e.c.hnadsa, getHeight() + "");
        this.e.put("__IMP_AREA__", getLeft() + "_" + getTop() + "_" + getRight() + "_" + getBottom());
        this.e.put("adLeft", getLeft() + "");
        this.e.put("adRight", getRight() + "");
        this.e.put("adTop", getTop() + "");
        this.e.put("adBottom", getBottom() + "");
        for (int i7 = 0; i7 < getChildCount(); i7++) {
            View childAt = getChildAt(i7);
            int id = childAt.getId();
            if (id != 100002) {
                if (id != 100004) {
                    if (id != 920101) {
                        switch (id) {
                            case ErrorCode.d.hnadsj /* 100006 */:
                                childAt.layout(0, 0, this.b / 4, this.c + i2);
                                layoutParams = childAt.getLayoutParams();
                                i5 = this.b / 4;
                                break;
                            case ErrorCode.d.hnadsk /* 100007 */:
                                double d = i3;
                                int i8 = this.f8586a;
                                double d2 = ((double) i8) * 0.2d;
                                double d3 = ((double) (i8 * 4)) + d2;
                                childAt.layout((int) (d - d3), (int) d2, (int) (d - d2), (int) d3);
                                continue;
                            case 100008:
                                int i9 = this.f8586a;
                                int i10 = this.c;
                                childAt.layout(i3 - (i9 * 7), i10 - (i9 * 3), i3, i10);
                                continue;
                            case 100009:
                                View viewFindViewById = findViewById(100008);
                                childAt.layout(viewFindViewById.getLeft() - childAt.getMeasuredWidth(), viewFindViewById.getTop(), viewFindViewById.getLeft(), viewFindViewById.getBottom());
                                continue;
                            case 100010:
                                childAt.layout(0, 0, this.b / 4, this.c + i2);
                                continue;
                            case 100011:
                                int iMin = Math.min(this.b / 4, this.c);
                                int i11 = this.b / 4;
                                int i12 = iMin / 2;
                                int i13 = this.c;
                                childAt.layout((i11 - i12) / 2, (i13 - i12) / 2, (i11 + i12) / 2, (i13 + i12) / 2);
                                continue;
                            default:
                                continue;
                        }
                    } else {
                        View viewFindViewById2 = findViewById(100008);
                        childAt.layout(0, i4 - childAt.getMeasuredHeight(), viewFindViewById2.getLeft() - this.f8586a, i4);
                        layoutParams2 = childAt.getLayoutParams();
                        left = viewFindViewById2.getLeft();
                        i6 = this.f8586a;
                    }
                } else {
                    int i14 = this.b;
                    childAt.layout((i14 - (i14 / 4)) + (this.f8586a * 2), (i4 - childAt.getMeasuredHeight()) / 2, this.b - (this.f8586a * 2), (childAt.getMeasuredHeight() + i4) / 2);
                    layoutParams2 = childAt.getLayoutParams();
                    left = this.b / 4;
                    i6 = this.f8586a * 4;
                }
                layoutParams2.width = left - i6;
            } else {
                int i15 = this.b / 4;
                childAt.layout(i15, 0, i15 * 3, this.c);
                childAt.setBackgroundColor(0);
                layoutParams = childAt.getLayoutParams();
                i5 = this.b / 2;
            }
            layoutParams.width = i5;
            childAt.getLayoutParams().height = this.c;
        }
    }
}
