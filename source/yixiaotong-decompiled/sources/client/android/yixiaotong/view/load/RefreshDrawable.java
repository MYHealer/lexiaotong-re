package client.android.yixiaotong.view.load;

import android.content.Context;
import android.graphics.ColorFilter;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public abstract class RefreshDrawable extends Drawable implements Drawable.Callback, Animatable {
    private PullRefreshLayout mRefreshLayout;

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    public PullRefreshLayout getRefreshLayout() {
        return this.mRefreshLayout;
    }

    public abstract void offsetTopAndBottom(int i);

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
    }

    public abstract void setColorSchemeColors(int[] iArr);

    public abstract void setPercent(float f);

    public RefreshDrawable(Context context, PullRefreshLayout pullRefreshLayout) {
        this.mRefreshLayout = pullRefreshLayout;
    }

    public Context getContext() {
        PullRefreshLayout pullRefreshLayout = this.mRefreshLayout;
        if (pullRefreshLayout != null) {
            return pullRefreshLayout.getContext();
        }
        return null;
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(Drawable drawable) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.invalidateDrawable(this);
        }
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.scheduleDrawable(this, runnable, j);
        }
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.unscheduleDrawable(this, runnable);
        }
    }
}
