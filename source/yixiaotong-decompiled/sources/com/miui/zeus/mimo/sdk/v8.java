package com.miui.zeus.mimo.sdk;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.exoplayer2.C;
import com.miui.zeus.mimo.sdk.click.ClickAreaType;
import com.miui.zeus.mimo.sdk.view.MimoPagerIndicatorView;
import com.miui.zeus.mimo.sdk.view.recycler.MimoCardStyleLayoutManager;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class v8 extends RelativeLayout implements h8 {
    public static final int i = f9.a(y8.f5752a, 3.5f);
    public static int j = 1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f5646a;
    public RecyclerView b;
    public List<String> c;
    public w8 d;
    public MimoPagerIndicatorView e;
    public boolean f;
    public final Runnable g;
    public RecyclerView.OnScrollListener h;

    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            RecyclerView recyclerView = v8.this.b;
            if (recyclerView == null) {
                return;
            }
            int iFindFirstVisibleItemPosition = ((LinearLayoutManager) recyclerView.getLayoutManager()).findFirstVisibleItemPosition() + 1;
            if (iFindFirstVisibleItemPosition > 2147483646) {
                v8.this.b.scrollToPosition(0);
                iFindFirstVisibleItemPosition = 0;
            }
            v8.this.b.smoothScrollToPosition(iFindFirstVisibleItemPosition);
            v8.this.b.postDelayed(this, C.DEFAULT_MAX_SEEK_TO_PREVIOUS_POSITION_MS);
        }
    }

    public class b extends RecyclerView.OnScrollListener {
        public b() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            super.onScrollStateChanged(recyclerView, i);
            if (i == 0) {
                int firstVisibleItemPosition = v8.this.getFirstVisibleItemPosition();
                v8 v8Var = v8.this;
                v8Var.setIndicatorPosition(firstVisibleItemPosition % v8Var.c.size());
                v8.this.setDraggingStatus(false);
                for (int i2 = firstVisibleItemPosition; i2 <= v8.this.getLastVisibleItemPosition(); i2++) {
                    w8.a aVarB = v8.b(v8.this, i2);
                    if (aVarB != null) {
                        if (i2 == firstVisibleItemPosition) {
                            aVarB.b.setVisibility(0);
                            aVarB.c.setVisibility(8);
                        } else {
                            aVarB.c.setVisibility(0);
                        }
                    }
                }
                return;
            }
            if (1 == i || 2 == i) {
                v8 v8Var2 = v8.this;
                if (v8Var2.f) {
                    return;
                }
                v8Var2.setDraggingStatus(true);
                int firstVisibleItemPosition2 = v8.this.getFirstVisibleItemPosition();
                w8.a aVarB2 = v8.b(v8.this, firstVisibleItemPosition2);
                if (aVarB2 != null) {
                    aVarB2.b.setVisibility(8);
                    aVarB2.c.setVisibility(0);
                }
                w8.a aVarB3 = v8.b(v8.this, firstVisibleItemPosition2 + 1);
                if (aVarB3 != null) {
                    aVarB3.b.setVisibility(0);
                    aVarB3.c.setVisibility(8);
                }
            }
        }
    }

    public v8(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f = false;
        this.g = new a();
        this.h = new b();
    }

    public static w8.a b(v8 v8Var, int i2) {
        RecyclerView recyclerView = v8Var.b;
        if (recyclerView == null) {
            return null;
        }
        return (w8.a) recyclerView.findViewHolderForAdapterPosition(i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getFirstVisibleItemPosition() {
        RecyclerView recyclerView = this.b;
        if (recyclerView == null || recyclerView.getLayoutManager() == null) {
            return -1;
        }
        return ((LinearLayoutManager) this.b.getLayoutManager()).findFirstVisibleItemPosition();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getLastVisibleItemPosition() {
        RecyclerView recyclerView = this.b;
        if (recyclerView == null || recyclerView.getLayoutManager() == null) {
            return -1;
        }
        return ((LinearLayoutManager) this.b.getLayoutManager()).findLastVisibleItemPosition();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDraggingStatus(boolean z) {
        this.f = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setIndicatorPosition(int i2) {
        MimoPagerIndicatorView mimoPagerIndicatorView = this.e;
        if (mimoPagerIndicatorView == null) {
            return;
        }
        mimoPagerIndicatorView.setCurrentPosition(i2);
    }

    public final void a() {
        MimoPagerIndicatorView mimoPagerIndicatorView = new MimoPagerIndicatorView(getContext());
        this.e = mimoPagerIndicatorView;
        mimoPagerIndicatorView.setVisibility(0);
        this.e.a(this.c.size(), 0);
        this.e.a(15.2f, 6.5f);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(14);
        layoutParams.addRule(3, this.b.getId());
        layoutParams.topMargin = f9.a(y8.f5752a, 17.0f);
        addView(this.e, layoutParams);
    }

    public void b() {
        RecyclerView recyclerView = this.b;
        if (recyclerView != null) {
            recyclerView.removeCallbacks(this.g);
        }
    }

    public ClickAreaType getClickAreaType() {
        return ClickAreaType.TYPE_PICTURE;
    }

    public void setOrientation(int i2) {
        this.f5646a = i2;
    }

    public void a(List<String> list, int i2) {
        RelativeLayout.LayoutParams layoutParams;
        RecyclerView recyclerView;
        MimoCardStyleLayoutManager mimoCardStyleLayoutManager;
        RelativeLayout.LayoutParams layoutParams2;
        if (list.isEmpty()) {
            b();
            return;
        }
        this.c = list;
        this.b = new RecyclerView(getContext());
        this.d = new w8(getContext(), this.c);
        this.b.setId(View.generateViewId());
        if (this.f5646a == j) {
            int iD = f9.d(getContext());
            int iC = f9.c(getContext());
            if (iD < iC) {
                iC = iD;
                iD = iC;
            }
            if (i2 == 1) {
                float f = iD;
                int i3 = (int) (0.045299146f * f);
                int i4 = (int) ((iC - (((((f * 0.59f) - (i3 * 2)) - (i * 2)) / 1066.0f) * 600.0f)) / 2.0f);
                layoutParams = new RelativeLayout.LayoutParams(-1, -1);
                layoutParams.setMargins(i3, 0, i3, 0);
                this.b.setPadding(0, i4, 0, i4);
                this.b.setClipToPadding(false);
                recyclerView = this.b;
                mimoCardStyleLayoutManager = new MimoCardStyleLayoutManager(recyclerView, 1);
            } else {
                float f2 = iC;
                int i5 = (int) (0.10462963f * f2);
                float f3 = iD;
                int i6 = (int) (0.0982906f * f3);
                int i7 = (int) (0.054700855f * f3);
                int i8 = ((int) (((((f3 * 0.59f) - i6) - i7) - (((f2 - (i5 * 2.0f)) / 853.0f) * 480.0f)) - (i * 2))) / 2;
                layoutParams = new RelativeLayout.LayoutParams(-1, -1);
                layoutParams.addRule(14);
                layoutParams.setMargins(i6, i5, i7, i5);
                this.b.setClipToPadding(false);
                this.b.setPadding(i8, 0, i8, 0);
                recyclerView = this.b;
                mimoCardStyleLayoutManager = new MimoCardStyleLayoutManager(recyclerView, 0);
            }
            recyclerView.setLayoutManager(mimoCardStyleLayoutManager);
            addView(this.b, layoutParams);
            MimoPagerIndicatorView mimoPagerIndicatorView = new MimoPagerIndicatorView(getContext());
            this.e = mimoPagerIndicatorView;
            mimoPagerIndicatorView.setVisibility(0);
            this.e.a(this.c.size(), 0);
            this.e.a(15.2f, 6.5f);
            if (i2 == 1) {
                this.e.setOrientation(false);
                layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
                layoutParams2.addRule(15);
                layoutParams2.addRule(21);
                layoutParams2.leftMargin = f9.a(y8.f5752a, 21.8f);
                layoutParams2.rightMargin = f9.a(y8.f5752a, 10.1f);
            } else {
                layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
                layoutParams2.addRule(14);
                layoutParams2.addRule(12);
                layoutParams2.bottomMargin = f9.a(y8.f5752a, 17.0f);
            }
            addView(this.e, layoutParams2);
        } else {
            int iD2 = f9.d(getContext());
            int iC2 = f9.c(getContext());
            if (iD2 < iC2) {
                iC2 = iD2;
                iD2 = iC2;
            }
            int iA = f9.a(y8.f5752a, 55.0f);
            float f4 = iD2;
            if (f4 / iC2 < 1.9f) {
                iA = f9.a(y8.f5752a, 75.0f);
            }
            int i9 = i;
            int i10 = (int) ((((iC2 - (iA * 2)) - (i9 * 2)) / 736.0f) * 1308.0f);
            int i11 = (int) (0.16239317f * f4);
            if (i2 == 1) {
                iA = f9.a(y8.f5752a, 41.0f);
                i10 = (int) ((((iC2 - (iA * 2)) - (i9 * 2.0f)) / 853.0f) * 480.0f);
                i11 = (int) (f4 * 0.274359f);
            }
            RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(iC2, i10);
            layoutParams3.addRule(14);
            layoutParams3.setMargins(0, i11, 0, 0);
            this.b.setPadding(iA, 0, iA, 0);
            addView(this.b, layoutParams3);
            this.b.setClipToPadding(false);
            RecyclerView recyclerView2 = this.b;
            recyclerView2.setLayoutManager(new MimoCardStyleLayoutManager(recyclerView2, 0));
            a();
        }
        this.b.addOnScrollListener(this.h);
        this.b.setAdapter(this.d);
        new PagerSnapHelper().attachToRecyclerView(this.b);
        this.b.postDelayed(this.g, C.DEFAULT_MAX_SEEK_TO_PREVIOUS_POSITION_MS);
    }
}
