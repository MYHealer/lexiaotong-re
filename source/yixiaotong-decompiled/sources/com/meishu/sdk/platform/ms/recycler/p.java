package com.meishu.sdk.platform.ms.recycler;

import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

/* JADX INFO: compiled from: SlideClickGroupWrapper.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final FrameLayout f5228a;
    public final View b;
    public volatile boolean c = false;

    public p(FrameLayout frameLayout, View view) {
        this.f5228a = frameLayout;
        this.b = view;
    }

    /* JADX INFO: compiled from: SlideClickGroupWrapper.java */
    public class b extends r {
        public final /* synthetic */ q n;
        public final /* synthetic */ ViewGroup o;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(View view, int i, q qVar, ViewGroup viewGroup) {
            super(view, i);
            this.n = qVar;
            this.o = viewGroup;
        }

        @Override // com.meishu.sdk.platform.ms.recycler.r
        public void a(MotionEvent motionEvent) {
            p.this.c = false;
        }

        @Override // com.meishu.sdk.platform.ms.recycler.r
        public void a(float f, float f2, long j, float f3, float f4, int i) {
            if (this.n == null || p.this.c) {
                return;
            }
            p.this.c = true;
            this.n.a(this.o, f, f2, j, f3, f4, i);
        }
    }

    public void a(ViewGroup viewGroup, int i, q qVar) {
        r[] rVarArr = new r[1];
        try {
            if (this.f5228a != null) {
                this.f5228a.setOnTouchListener(new a(viewGroup.getChildAt(0), i, rVarArr, qVar, viewGroup));
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        try {
            if (this.b != null) {
                rVarArr[0] = new b(viewGroup.getChildAt(0), i, qVar, viewGroup);
                rVarArr[0].c = false;
                rVarArr[0].d = true;
                this.b.setOnTouchListener(rVarArr[0]);
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    /* JADX INFO: compiled from: SlideClickGroupWrapper.java */
    public class a extends r {
        public final /* synthetic */ r[] n;
        public final /* synthetic */ q o;
        public final /* synthetic */ ViewGroup p;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(View view, int i, r[] rVarArr, q qVar, ViewGroup viewGroup) {
            super(view, i);
            this.n = rVarArr;
            this.o = qVar;
            this.p = viewGroup;
        }

        @Override // com.meishu.sdk.platform.ms.recycler.r
        public void a(MotionEvent motionEvent) {
            p.this.c = false;
            try {
                r rVar = this.n[0];
                if (rVar != null) {
                    rVar.b(motionEvent);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        @Override // com.meishu.sdk.platform.ms.recycler.r
        public void a(float f, float f2, long j, float f3, float f4, int i) {
            if (this.o == null || p.this.c) {
                return;
            }
            p.this.c = true;
            this.o.a(this.p, f, f2, j, f3, f4, i);
        }
    }
}
