package com.yfanads.android.adx.components.base;

import android.content.Context;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.yfanads.android.libs.utils.Util;

/* JADX INFO: compiled from: BaseViewHolder.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public final class g extends ClickableSpan {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Context f9570a;
    public final /* synthetic */ com.yfanads.android.adx.components.model.b b;

    public g(Context context, com.yfanads.android.adx.components.model.b bVar) {
        this.f9570a = context;
        this.b = bVar;
    }

    @Override // android.text.style.ClickableSpan
    public final void onClick(View view) {
        Util.openLink(this.f9570a, this.b.b);
    }

    @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
    public final void updateDrawState(TextPaint textPaint) {
        textPaint.setUnderlineText(false);
    }
}
