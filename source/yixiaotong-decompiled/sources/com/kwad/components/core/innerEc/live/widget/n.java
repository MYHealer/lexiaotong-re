package com.kwad.components.core.innerEc.live.widget;

import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.TextView;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public final class n extends ClickableSpan {
    private final View.OnClickListener gh;

    public n(View.OnClickListener onClickListener) {
        this.gh = onClickListener;
    }

    @Override // android.text.style.ClickableSpan
    public final void onClick(View view) {
        if (view instanceof TextView) {
            ((TextView) view).setHighlightColor(0);
        }
        View.OnClickListener onClickListener = this.gh;
        if (onClickListener != null) {
            onClickListener.onClick(view);
        }
    }

    @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
    public final void updateDrawState(TextPaint textPaint) {
        textPaint.setUnderlineText(false);
    }
}
