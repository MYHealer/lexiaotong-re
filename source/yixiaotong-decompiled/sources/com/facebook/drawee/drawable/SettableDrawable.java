package com.facebook.drawee.drawable;

import android.graphics.drawable.Drawable;
import com.facebook.common.internal.Preconditions;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
public class SettableDrawable extends ForwardingDrawable {
    public SettableDrawable(Drawable drawable) {
        super((Drawable) Preconditions.checkNotNull(drawable));
    }

    public void setDrawable(Drawable drawable) {
        Preconditions.checkNotNull(drawable);
        setCurrent(drawable);
    }

    public Drawable getDrawable() {
        return getCurrent();
    }
}
