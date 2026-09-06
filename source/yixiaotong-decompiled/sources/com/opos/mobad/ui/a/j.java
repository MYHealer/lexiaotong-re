package com.opos.mobad.ui.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class j extends h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private volatile boolean f8284a;
    private a b;

    private interface a {
        void a(ImageView imageView, Bitmap bitmap);
    }

    public j(Context context, d dVar, FrameLayout frameLayout) {
        super(context, dVar, frameLayout, false);
        this.f8284a = false;
        this.b = new a() { // from class: com.opos.mobad.ui.a.j.4
            @Override // com.opos.mobad.ui.a.j.a
            public void a(final ImageView imageView, final Bitmap bitmap) {
                if (imageView == null || bitmap == null) {
                    return;
                }
                com.opos.mobad.service.c.a(new Runnable() { // from class: com.opos.mobad.ui.a.j.4.1
                    @Override // java.lang.Runnable
                    public void run() {
                        Bitmap bitmap2;
                        ImageView imageView2 = imageView;
                        if (imageView2 == null || (bitmap2 = bitmap) == null) {
                            return;
                        }
                        imageView2.setImageBitmap(bitmap2);
                        com.opos.cmn.an.f.a.b("MediaCreative", "mIImgLoaderResult success");
                    }
                });
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ai() {
        Drawable drawable;
        BitmapDrawable bitmapDrawable;
        if (this.m == null || (drawable = this.m.getDrawable()) == null) {
            return;
        }
        if ((drawable instanceof BitmapDrawable) && (bitmapDrawable = (BitmapDrawable) drawable) != null && bitmapDrawable.getBitmap() != null && !bitmapDrawable.getBitmap().isRecycled()) {
            bitmapDrawable.getBitmap().recycle();
            com.opos.cmn.an.f.a.b("MediaCreative", "recycle bitmap");
        }
        this.m.setImageDrawable(null);
    }

    @Override // com.opos.mobad.ui.a.a
    protected void a() {
        if (this.o != null) {
            this.o.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.opos.mobad.ui.a.j.1
                @Override // android.view.View.OnAttachStateChangeListener
                public void onViewAttachedToWindow(View view) {
                }

                @Override // android.view.View.OnAttachStateChangeListener
                public void onViewDetachedFromWindow(View view) {
                    if (k.a().a(j.this.B)) {
                        com.opos.cmn.an.f.a.b("MediaCreative", "onViewDetachedFromWindow release video");
                        k.a().c();
                    }
                    j.this.ai();
                }
            });
        }
    }

    @Override // com.opos.mobad.ui.a.e
    public void a(View view, int[] iArr) {
        c(view, iArr);
    }

    @Override // com.opos.mobad.ui.a.a
    public void a(View view, int[] iArr, int i) {
        c(view, iArr);
    }

    @Override // com.opos.mobad.ui.a.h
    protected void a(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        com.opos.mobad.f.e.a().b(str, null, com.opos.cmn.an.h.f.a.b(this.c), (com.opos.cmn.an.h.f.a.b(this.c) * 9) / 16, new com.opos.mobad.d.a.InterfaceC0955a() { // from class: com.opos.mobad.ui.a.j.3
            @Override // com.opos.mobad.d.a.InterfaceC0955a
            public void a(int i, Bitmap bitmap) {
                com.opos.cmn.an.f.a.b("MediaCreative", "loadCoverImg code:" + i + " bitmap:" + bitmap);
                if (i != 0 || bitmap == null) {
                    return;
                }
                j.this.b.a(j.this.m, bitmap);
            }
        });
    }

    public void b() {
        com.opos.cmn.an.f.a.b("MediaCreative", "release video and ad");
        this.f8284a = true;
        W();
        S();
        T();
    }

    @Override // com.opos.mobad.ui.a.e
    public void b(View view, int[] iArr) {
        c(view, iArr);
    }

    public void b(com.opos.mobad.ui.a.a.C1028a c1028a) {
        ViewGroup.LayoutParams layoutParams;
        com.opos.cmn.an.f.a.b("MediaCreative", "renderInitCoverUI");
        if (this.m == null) {
            this.m = new ImageView(this.c);
            this.m.setScaleType(ImageView.ScaleType.FIT_XY);
        }
        if (this.m.getParent() == null || this.m.getParent() == this.e) {
            if (this.m.getParent() == null) {
                layoutParams = new ViewGroup.LayoutParams(-1, -1);
            }
            a(c1028a);
            X();
        }
        ((ViewGroup) this.m.getParent()).removeView(this.m);
        layoutParams = new ViewGroup.LayoutParams(-1, -1);
        this.e.addView(this.m, layoutParams);
        a(this.m, 5);
        a(c1028a);
        X();
    }

    protected void c(View view, int[] iArr) {
        if (this.v != null) {
            this.v.a(view, iArr, k.a().e(this.B), com.opos.mobad.cmn.func.b.a.VIDEO);
        }
    }

    public void c(final com.opos.mobad.ui.a.a.C1028a c1028a) {
        com.opos.cmn.an.f.a.b("MediaCreative", "playVideo :" + c1028a);
        if (c1028a != null) {
            this.d = c1028a;
            this.B = c1028a.c;
            com.opos.mobad.service.c.c(new Runnable() { // from class: com.opos.mobad.ui.a.j.2
                @Override // java.lang.Runnable
                public void run() {
                    if (j.this.f8284a) {
                        return;
                    }
                    j jVar = j.this;
                    jVar.a(jVar.m, 5);
                    j jVar2 = j.this;
                    jVar2.a(jVar2.o, 4);
                    k.a().a(j.this.c, c1028a.c, c1028a.d, j.this.o, j.this, false);
                }
            });
        }
    }

    public void d(com.opos.mobad.ui.a.a.C1028a c1028a) {
        com.opos.cmn.an.f.a.b("MediaCreative", "playVideoWithoutCheckPlaying url:" + c1028a);
        if (c1028a != null) {
            this.d = c1028a;
            this.B = c1028a.c;
            a(this.m, 5);
            a(this.o, 4);
            X();
            k.a().b(this.c, c1028a.c, c1028a.d, this.o, this, false);
        }
    }
}
