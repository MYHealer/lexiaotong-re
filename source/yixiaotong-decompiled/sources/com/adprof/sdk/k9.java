package com.adprof.sdk;

import android.view.View;
import android.widget.FrameLayout;
import com.google.android.material.badge.BadgeDrawable;
import java.util.Random;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public final class k9 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final FrameLayout f1263a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public k6 f423a;

    public k9(FrameLayout frameLayout) {
        this.f1263a = frameLayout;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(xc xcVar) {
        try {
            this.f1263a.removeView(xcVar);
        } catch (Throwable unused) {
        }
    }

    public void a() {
        try {
            k6 k6Var = this.f423a;
            if (k6Var != null) {
                for (View view : k6Var.a()) {
                    if (view != null) {
                        hp.m656a(view);
                    }
                }
                this.f423a = null;
            }
        } catch (Throwable unused) {
        }
    }

    public void a(d dVar, final Runnable runnable) {
        try {
            a();
            if (dVar == null) {
                return;
            }
            int iB = h8.b();
            int iM641a = h8.m641a();
            if (iB > 0 && iM641a > 0) {
                int iA = h8.a(64.0f);
                int iA2 = h8.a(10.0f);
                int i = iB / 3;
                int iMax = Math.max(1, iM641a - iA) / 2;
                int iMin = Math.min(h8.a(80.0f), Math.max(h8.a(58.0f), (Math.min(i, iMax) - (iA2 * 2)) - h8.a(4.0f)));
                int iMax2 = Math.max(0, (iM641a - iMin) - iA);
                int iA3 = h8.a(8.0f);
                k6 k6Var = new k6(this.f1263a);
                this.f423a = k6Var;
                k6Var.f1261a = iB;
                k6Var.b = iMin;
                k6Var.c = iMax2;
                k6Var.d = iA3;
                Random random = k6Var.f419a;
                for (int i2 = 0; i2 < 6; i2++) {
                    int i3 = (i2 % 3) * i;
                    int i4 = i3 + iA2;
                    int i5 = (i2 / 3) * iMax;
                    int i6 = i5 + iA2;
                    int i7 = ((i3 + i) - iMin) - iA2;
                    int i8 = ((i5 + iMax) - iMin) - iA2;
                    if (i7 < i4) {
                        i7 = i4;
                    }
                    if (i8 < i6) {
                        i8 = i6;
                    }
                    float fNextInt = i4 + (i7 > i4 ? random.nextInt((i7 - i4) + 1) : 0);
                    float fNextInt2 = i6 + (i8 > i6 ? random.nextInt((i8 - i6) + 1) : 0);
                    random.nextInt(6);
                    final xc xcVar = new xc(this.f1263a.getContext(), iMin);
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(iMin, iMin);
                    layoutParams.setMargins(0, 0, 0, 0);
                    layoutParams.gravity = BadgeDrawable.TOP_START;
                    k6 k6Var2 = this.f423a;
                    final j6 j6Var = new j6(xcVar, fNextInt, fNextInt2, k6Var2.f419a);
                    k6Var2.f418a.add(j6Var);
                    xcVar.setOnClickListener(new View.OnClickListener() { // from class: com.adprof.sdk.k9$$ExternalSyntheticLambda0
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            this.f$0.a(j6Var, xcVar, runnable, view);
                        }
                    });
                    this.f1263a.addView(xcVar, layoutParams);
                }
                this.f423a.m668a();
            }
        } catch (Throwable th) {
            pk.a(th);
            oh.b(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(j6 j6Var, final xc xcVar, Runnable runnable, View view) {
        try {
            k6 k6Var = this.f423a;
            if (k6Var != null && j6Var != null) {
                k6Var.f418a.remove(j6Var);
                if (k6Var.f418a.isEmpty()) {
                    k6Var.f420a = false;
                    k6Var.f416a.removeCallbacks(k6Var.f417a);
                }
            }
            xcVar.animate().scaleX(0.1f).scaleY(0.1f).alpha(0.0f).setDuration(180L).setListener(new wc(xcVar, new Runnable() { // from class: com.adprof.sdk.k9$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.a(xcVar);
                }
            })).start();
            if (runnable != null) {
                try {
                    runnable.run();
                } catch (Throwable th) {
                    oh.b(th);
                }
            }
        } catch (Throwable th2) {
            pk.a(th2);
        }
    }
}
