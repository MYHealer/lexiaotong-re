package com.adprof.sdk;

import android.content.Context;
import android.widget.RelativeLayout;
import android.widget.TextView;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public abstract class pe extends RelativeLayout {
    public pe(Context context) {
        super(context);
    }

    public abstract void a();

    public abstract void b();

    public abstract void c();

    public void setTextHint(String str) {
        TextView textView = new TextView(getContext());
        textView.setText(str);
        textView.setTextColor(-2236963);
        textView.setBackgroundColor(1426063360);
        textView.setTextSize(2, 12.0f);
        post(new oe(this, textView));
    }
}
