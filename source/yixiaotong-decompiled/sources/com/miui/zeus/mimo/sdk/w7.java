package com.miui.zeus.mimo.sdk;

import android.graphics.Canvas;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.exoplayer2.ExoPlayer;
import com.miui.zeus.mimo.sdk.ad.reward.recycler.RewardRecyclerItemView;
import com.miui.zeus.mimo.sdk.view.MimoPagerIndicatorView;
import com.miui.zeus.mimo.sdk.view.card.CardLayoutManager;
import java.lang.ref.WeakReference;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class w7<T> extends ItemTouchHelper.Callback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RecyclerView.Adapter f5728a;
    public final List<T> b;
    public y7 c;
    public v7 d;
    public int e;
    public int f = -1;
    public boolean g = true;
    public final a<T> h = new a<>(this);

    public static class a<T> extends Handler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final WeakReference<w7<T>> f5729a;

        public a(w7<T> w7Var) {
            super(Looper.getMainLooper());
            this.f5729a = new WeakReference<>(w7Var);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            w7<T> w7Var;
            WeakReference<w7<T>> weakReference = this.f5729a;
            if (weakReference == null || (w7Var = weakReference.get()) == null || message.what != 10007) {
                return;
            }
            x7.a.f5742a.f5741a = false;
            y7 y7Var = w7Var.c;
            if (y7Var != null) {
                v2 v2Var = ((r2) y7Var).f5581a;
                RecyclerView recyclerView = v2Var.s;
                y6 y6Var = new y6();
                v2Var.v = y6Var;
                y6Var.a(ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS, ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS, new s2(v2Var, recyclerView));
            }
            w7Var.g = true;
        }
    }

    public w7(RecyclerView.Adapter adapter, List<T> list, v7 v7Var) {
        this.e = -1;
        this.f5728a = adapter;
        this.b = list;
        this.e = list.size();
        this.d = v7Var;
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public void clearView(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
        super.clearView(recyclerView, viewHolder);
        viewHolder.itemView.setRotation(0.0f);
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public int getMovementFlags(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
        int i;
        if (recyclerView.getLayoutManager() instanceof CardLayoutManager) {
            i = 1;
            if (this.d.c == 1) {
                i = 4;
            }
        } else {
            i = 0;
        }
        return ItemTouchHelper.Callback.makeMovementFlags(0, i);
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public boolean isItemViewSwipeEnabled() {
        return false;
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public void onChildDraw(Canvas canvas, RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, float f, float f2, int i, boolean z) {
        v2 v2Var;
        y6 y6Var;
        super.onChildDraw(canvas, recyclerView, viewHolder, f, f2, i, z);
        View view = viewHolder.itemView;
        if (i == 1) {
            if (this.g && x7.a.f5742a.a()) {
                this.g = false;
                y7 y7Var = this.c;
                if (y7Var != null && (y6Var = (v2Var = ((r2) y7Var).f5581a).v) != null) {
                    y6Var.a();
                    v2Var.v = null;
                }
            }
            float height = (this.d.c == 0 ? recyclerView.getHeight() : recyclerView.getWidth()) * getSwipeThreshold(viewHolder);
            if (height <= 0.0f) {
                return;
            }
            v7 v7Var = this.d;
            float f3 = v7Var.c == 0 ? f2 / height : f / height;
            if (f3 > 1.0f) {
                f3 = 1.0f;
            } else if (f3 < -1.0f) {
                f3 = -1.0f;
            }
            v7Var.getClass();
            view.setRotation(0.0f * f3);
            int childCount = recyclerView.getChildCount();
            if (childCount > this.d.f5645a) {
                for (int i2 = 1; i2 < childCount - 1; i2++) {
                    View childAt = recyclerView.getChildAt(i2);
                    float f4 = (childCount - i2) - 1;
                    this.d.getClass();
                    float fAbs = Math.abs(f3);
                    this.d.getClass();
                    float f5 = (1.0f - (f4 * 0.13f)) + (fAbs * 0.13f);
                    if (Float.isNaN(f5)) {
                        f5 = 1.0f;
                    }
                    childAt.setScaleX(f5);
                    childAt.setScaleY(f5);
                    if (this.d.c == 0) {
                        float fAbs2 = (f4 - Math.abs(f3)) * view.getMeasuredHeight();
                        this.d.getClass();
                        childAt.setTranslationY(fAbs2 / 7);
                    } else {
                        float fAbs3 = (f4 - Math.abs(f3)) * view.getMeasuredHeight();
                        this.d.getClass();
                        childAt.setTranslationX(fAbs3 / 7);
                    }
                    if (i2 == this.d.f5645a - 1 && (childAt instanceof RewardRecyclerItemView)) {
                        ((RewardRecyclerItemView) childAt).getAvatarBgView().setVisibility(8);
                    }
                }
            } else {
                for (int i3 = 0; i3 < childCount - 1; i3++) {
                    View childAt2 = recyclerView.getChildAt(i3);
                    float f6 = (childCount - i3) - 1;
                    this.d.getClass();
                    float fAbs4 = Math.abs(f3);
                    this.d.getClass();
                    float f7 = (1.0f - (f6 * 0.13f)) + (fAbs4 * 0.13f);
                    if (Float.isNaN(f7)) {
                        f7 = 1.0f;
                    }
                    childAt2.setScaleX(f7);
                    childAt2.setScaleY(f7);
                    if (this.d.c == 1) {
                        float fAbs5 = (f6 - Math.abs(f3)) * view.getMeasuredHeight();
                        this.d.getClass();
                        childAt2.setTranslationX(fAbs5 / 7);
                    } else {
                        float fAbs6 = (f6 - Math.abs(f3)) * view.getMeasuredHeight();
                        this.d.getClass();
                        childAt2.setTranslationY(fAbs6 / 7);
                    }
                    if (i3 == this.d.f5645a - 1 && (childAt2 instanceof RewardRecyclerItemView)) {
                        ((RewardRecyclerItemView) childAt2).getAvatarBgView().setVisibility(8);
                    }
                }
            }
            y7 y7Var2 = this.c;
            if (y7Var2 != null) {
                ((r2) y7Var2).getClass();
            }
            if (x7.a.f5742a.a()) {
                this.h.removeMessages(10007);
                this.h.sendEmptyMessageDelayed(10007, 0L);
            }
        }
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder viewHolder2) {
        return false;
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public void onSwiped(RecyclerView.ViewHolder viewHolder, int i) {
        if (this.e < 0) {
            this.e = this.b.size();
        }
        if (this.f < 0) {
            this.f = 0;
        }
        this.f++;
        viewHolder.itemView.setOnTouchListener(null);
        T tRemove = this.b.remove(viewHolder.getLayoutPosition());
        this.f5728a.notifyDataSetChanged();
        y7 y7Var = this.c;
        if (y7Var != null) {
            ((r2) y7Var).getClass();
            y7 y7Var2 = this.c;
            int i2 = this.f % this.e;
            MimoPagerIndicatorView mimoPagerIndicatorView = ((r2) y7Var2).f5581a.t;
            if (mimoPagerIndicatorView != null) {
                mimoPagerIndicatorView.setCurrentPosition(i2);
            }
        }
        this.b.add(tRemove);
    }
}
