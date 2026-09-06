package com.opos.mobad.template.f;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.core.view.animation.PathInterpolatorCompat;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class n extends com.opos.mobad.template.cmn.baseview.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    w f7685a;
    ImageView b;
    private int c;
    private com.opos.mobad.template.a.InterfaceC1003a d;

    public n(Context context, int i) {
        super(context);
        setVisibility(4);
        setBackgroundColor(0);
        this.c = i;
        b();
        com.opos.mobad.template.cmn.p pVar = new com.opos.mobad.template.cmn.p() { // from class: com.opos.mobad.template.f.n.1
            @Override // com.opos.mobad.template.cmn.p
            public void b(View view, int[] iArr) {
                if (n.this.d != null) {
                    n.this.d.i(view, iArr);
                }
            }
        };
        setOnClickListener(pVar);
        setOnTouchListener(pVar);
        a(new com.opos.mobad.template.cmn.baseview.f() { // from class: com.opos.mobad.template.f.n.2
            @Override // com.opos.mobad.template.cmn.baseview.f
            public void a(View view, int i2, boolean z) {
                com.opos.cmn.an.f.a.a("InterstitialEndPage", "onMockEventIntercepted->clickMockEvent:" + i2 + ";disAllowClick:" + z + ";view:" + view.getClass().getName());
                if (n.this.d != null) {
                    n.this.d.a(view, i2, z);
                }
            }
        });
    }

    public static n a(Context context) {
        return new n(context, 2);
    }

    public static n b(Context context) {
        return new n(context, 3);
    }

    private void b() {
        ImageView imageView = new ImageView(getContext());
        this.b = imageView;
        imageView.setId(View.generateViewId());
        this.b.setScaleType(ImageView.ScaleType.FIT_XY);
        c();
        d();
    }

    public static n c(Context context) {
        return new n(context, 0);
    }

    private void c() {
        w wVar;
        int i = this.c;
        if (i == 0) {
            w.a aVar = new w.a(60, 14, 12, 1, w.a.l, true);
            aVar.a(com.opos.mobad.template.f.a.a.EnumC1008a.FINGER);
            wVar = new w(getContext(), aVar);
        } else if (i == 1) {
            w.a aVar2 = new w.a(60, 14, 12, 1, w.a.m, true);
            aVar2.a(com.opos.mobad.template.f.a.a.EnumC1008a.FINGER);
            wVar = new w(getContext(), aVar2);
        } else if (i == 2) {
            w.a aVar3 = new w.a(60, 14, 12, 1, w.a.l, false);
            aVar3.a(com.opos.mobad.template.f.a.a.EnumC1008a.FINGER);
            wVar = new w(getContext(), aVar3);
        } else if (i != 3) {
            w.a aVar4 = new w.a(64, 18, 14, 1, w.a.l, true);
            aVar4.a(com.opos.mobad.template.f.a.a.EnumC1008a.FINGER);
            wVar = new w(getContext(), aVar4);
        } else {
            w.a aVar5 = new w.a(60, 14, 12, 1, w.a.m, false);
            aVar5.a(com.opos.mobad.template.f.a.a.EnumC1008a.FINGER);
            wVar = new w(getContext(), aVar5);
        }
        this.f7685a = wVar;
        com.opos.mobad.template.cmn.p pVar = new com.opos.mobad.template.cmn.p() { // from class: com.opos.mobad.template.f.n.3
            @Override // com.opos.mobad.template.cmn.p
            public void b(View view, int[] iArr) {
                if (n.this.d != null) {
                    n.this.d.j(view, iArr);
                }
            }
        };
        this.f7685a.f().setOnClickListener(pVar);
        this.f7685a.f().setOnTouchListener(pVar);
        this.f7685a.f().a(new com.opos.mobad.template.cmn.baseview.f() { // from class: com.opos.mobad.template.f.n.4
            @Override // com.opos.mobad.template.cmn.baseview.f
            public void a(View view, int i2, boolean z) {
                com.opos.cmn.an.f.a.a("InterstitialEndPage", "onMockEventIntercepted->clickMockEvent:" + i2 + ";disAllowClick:" + z + ";view:" + view.getClass().getName());
                if (n.this.d != null) {
                    n.this.d.a(view, i2, z);
                }
            }
        });
    }

    public static n d(Context context) {
        return new n(context, 1);
    }

    private void d() {
        int i = this.c;
        if (i != 0) {
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        if (i != 4 && i != 5) {
                            return;
                        }
                    }
                }
            }
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, com.opos.cmn.an.h.f.a.a(getContext(), 145.0f));
            layoutParams.addRule(10);
            addView(this.b, layoutParams);
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -1);
            layoutParams2.addRule(3, this.b.getId());
            addView(this.f7685a, layoutParams2);
            return;
        }
        addView(this.b, new RelativeLayout.LayoutParams(-1, -1));
        addView(this.f7685a, new RelativeLayout.LayoutParams(-1, -1));
    }

    public static n e(Context context) {
        return new n(context, 4);
    }

    private void e() {
        final ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this, "alpha", 0.0f, 1.0f);
        objectAnimatorOfFloat.setDuration(180L);
        objectAnimatorOfFloat.setInterpolator(PathInterpolatorCompat.create(0.33f, 0.0f, 0.67f, 1.0f));
        com.opos.mobad.d.c.c.a(new Runnable() { // from class: com.opos.mobad.template.f.n.5
            @Override // java.lang.Runnable
            public void run() {
                n.this.setVisibility(0);
                objectAnimatorOfFloat.start();
            }
        });
    }

    public static n f(Context context) {
        return new n(context, 5);
    }

    public void a() {
        w wVar = this.f7685a;
        if (wVar != null) {
            wVar.e();
        }
    }

    public void a(Bitmap bitmap) {
        if (bitmap == null) {
            this.f7685a.e();
        } else {
            this.f7685a.a(bitmap);
        }
    }

    public void a(com.opos.mobad.template.a.InterfaceC1003a interfaceC1003a) {
        this.d = interfaceC1003a;
    }

    public void a(String str, String str2, String str3) {
        this.f7685a.a(str, str2, str3, 0);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        e();
    }
}
