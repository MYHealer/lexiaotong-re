package com.opos.exoplayer.core.f;

import android.graphics.Typeface;
import android.view.accessibility.CaptioningManager;
import com.opos.exoplayer.core.i.y;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f6412a = new a(-1, -16777216, 0, 0, -1, null);
    public final int b;
    public final int c;
    public final int d;
    public final int e;
    public final int f;
    public final Typeface g;

    public a(int i, int i2, int i3, int i4, int i5, Typeface typeface) {
        this.b = i;
        this.c = i2;
        this.d = i3;
        this.e = i4;
        this.f = i5;
        this.g = typeface;
    }

    public static a a(CaptioningManager.CaptionStyle captionStyle) {
        return y.f6517a >= 21 ? c(captionStyle) : b(captionStyle);
    }

    private static a b(CaptioningManager.CaptionStyle captionStyle) {
        return new a(captionStyle.foregroundColor, captionStyle.backgroundColor, 0, captionStyle.edgeType, captionStyle.edgeColor, captionStyle.getTypeface());
    }

    private static a c(CaptioningManager.CaptionStyle captionStyle) {
        return new a(captionStyle.hasForegroundColor() ? captionStyle.foregroundColor : f6412a.b, captionStyle.hasBackgroundColor() ? captionStyle.backgroundColor : f6412a.c, captionStyle.hasWindowColor() ? captionStyle.windowColor : f6412a.d, captionStyle.hasEdgeType() ? captionStyle.edgeType : f6412a.e, captionStyle.hasEdgeColor() ? captionStyle.edgeColor : f6412a.f, captionStyle.getTypeface());
    }
}
