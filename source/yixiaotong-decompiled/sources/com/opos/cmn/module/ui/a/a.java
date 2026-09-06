package com.opos.cmn.module.ui.a;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.view.View;
import android.widget.TextView;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class a extends TextView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f6187a;
    private Drawable b;
    private Drawable c;

    public a(Context context, int i) {
        super(context);
        this.b = com.opos.cmn.module.ui.d.a.a(context, i);
        this.c = com.opos.cmn.module.ui.d.a.a(context, i);
        com.opos.cmn.module.ui.d.a.a(this, a());
    }

    public a(Context context, String str, String str2) {
        super(context);
        this.f6187a = context;
        if (com.opos.cmn.an.d.a.a(str) || com.opos.cmn.an.d.a.a(str2)) {
            return;
        }
        this.b = com.opos.cmn.an.e.a.a.c(this.f6187a, str);
        this.c = com.opos.cmn.an.e.a.a.c(this.f6187a, str2);
        com.opos.cmn.module.ui.d.a.a(this, a());
    }

    private StateListDrawable a() {
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(View.PRESSED_ENABLED_STATE_SET, this.c);
        stateListDrawable.addState(View.ENABLED_FOCUSED_STATE_SET, this.c);
        stateListDrawable.addState(View.ENABLED_STATE_SET, this.b);
        stateListDrawable.addState(View.FOCUSED_STATE_SET, this.c);
        stateListDrawable.addState(View.EMPTY_STATE_SET, this.b);
        return stateListDrawable;
    }
}
