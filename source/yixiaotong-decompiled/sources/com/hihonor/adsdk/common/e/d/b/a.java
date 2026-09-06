package com.hihonor.adsdk.common.e.d.b;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.GradientDrawable;
import android.provider.Settings;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class a extends GradientDrawable {
    private final Context hnadsa;
    private Rect hnadsb;
    private boolean hnadsc;
    private boolean hnadsd = false;

    public a(Context context, float f, int i) {
        this.hnadsa = context;
        setColor(i);
        setCornerRadius(f);
        this.hnadsc = Settings.Global.getInt(context.getContentResolver(), "cursor_animation", 1) == 1;
    }

    @Override // android.graphics.drawable.GradientDrawable, android.graphics.drawable.Drawable
    public int getOpacity() {
        return 0;
    }

    public void hnadsa(Rect rect) {
        this.hnadsb = rect;
    }

    public void hnadsa(boolean z) {
        this.hnadsd = z;
    }

    @Override // android.graphics.drawable.GradientDrawable, android.graphics.drawable.Drawable
    public boolean isStateful() {
        return true;
    }

    @Override // android.graphics.drawable.GradientDrawable, android.graphics.drawable.Drawable
    protected boolean onStateChange(int[] iArr) {
        boolean z = false;
        boolean z2 = false;
        for (int i : iArr) {
            if (i == 16842910) {
                z = true;
            } else if (i == 16843623) {
                z2 = true;
            }
        }
        if (z && z2) {
            this.hnadsc = Settings.Global.getInt(this.hnadsa.getContentResolver(), "cursor_animation", 1) == 1;
        }
        return true;
    }

    @Override // android.graphics.drawable.GradientDrawable, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (!this.hnadsc || this.hnadsd) {
            super.draw(canvas);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setBounds(Rect rect) {
        Rect rect2 = this.hnadsb;
        if (rect2 != null) {
            super.setBounds(rect2);
        } else {
            super.setBounds(rect);
        }
    }
}
