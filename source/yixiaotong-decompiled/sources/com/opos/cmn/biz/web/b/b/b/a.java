package com.opos.cmn.biz.web.b.b.b;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.view.View;
import android.widget.TextView;
import com.stub.StubApp;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class a extends TextView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f6044a;
    private Drawable b;
    private Drawable c;

    public a(Context context, String str, String str2) {
        super(context);
        this.f6044a = context;
        if (com.opos.cmn.an.d.a.a(str) || com.opos.cmn.an.d.a.a(str2)) {
            return;
        }
        this.b = com.opos.cmn.an.e.a.a.c(StubApp.getOrigApplicationContext(this.f6044a.getApplicationContext()), str);
        this.c = com.opos.cmn.an.e.a.a.c(StubApp.getOrigApplicationContext(this.f6044a.getApplicationContext()), str2);
        com.opos.cmn.biz.web.b.b.a.a.a(this, a());
    }

    private Drawable a() {
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(View.PRESSED_ENABLED_STATE_SET, this.c);
        stateListDrawable.addState(View.ENABLED_FOCUSED_STATE_SET, this.c);
        stateListDrawable.addState(View.ENABLED_STATE_SET, this.b);
        stateListDrawable.addState(View.FOCUSED_STATE_SET, this.c);
        stateListDrawable.addState(View.EMPTY_STATE_SET, this.b);
        return stateListDrawable;
    }
}
