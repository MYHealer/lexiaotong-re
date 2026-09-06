package com.kwad.components.core.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.kwad.components.core.t.m;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class KsStyledImageView extends ImageView implements d {
    public KsStyledImageView(Context context) {
        super(context);
    }

    public KsStyledImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public KsStyledImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public KsStyledImageView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
    }

    @Override // com.kwad.components.core.widget.d
    public final void a(e eVar) {
        m.b(eVar, getBackground());
    }
}
