package com.kwad.components.core.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;
import com.kwad.components.core.t.m;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class KsStyledTextButton extends TextView implements d {
    public KsStyledTextButton(Context context) {
        super(context);
    }

    public KsStyledTextButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public KsStyledTextButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public KsStyledTextButton(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
    }

    @Override // com.kwad.components.core.widget.d
    public final void a(e eVar) {
        m.b(eVar, getBackground());
    }
}
