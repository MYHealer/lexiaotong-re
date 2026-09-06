package com.opos.mobad.template.g;

import android.content.Context;
import android.text.TextUtils;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.heytap.msp.mobad.api.R;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class aa extends RelativeLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private TextView f7771a;
    private ab b;
    private com.opos.mobad.d.a c;

    public aa(Context context, com.opos.mobad.d.a aVar) {
        super(context);
        this.c = aVar;
        a(context);
    }

    public static aa a(Context context, com.opos.mobad.d.a aVar) {
        return new aa(context, aVar);
    }

    private void a(Context context) {
        TextView textView = new TextView(getContext());
        this.f7771a = textView;
        textView.setTextColor(getResources().getColor(R.color.opos_mobad_small_top_title_color));
        this.f7771a.setTextSize(1, 17.0f);
        this.f7771a.setEllipsize(TextUtils.TruncateAt.valueOf("END"));
        this.f7771a.setMaxLines(2);
        addView(this.f7771a, new RelativeLayout.LayoutParams(-1, -2));
        this.b = ab.a(context, this.c);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(12);
        addView(this.b, layoutParams);
    }

    public void a(com.opos.mobad.template.a.InterfaceC1003a interfaceC1003a) {
        com.opos.cmn.an.f.a.b("BlockSmallLeftAreaView", "setListener " + interfaceC1003a);
        this.b.a(interfaceC1003a);
    }

    public void a(com.opos.mobad.template.d.b bVar) {
        if (bVar == null) {
            return;
        }
        String str = bVar.f7534a;
        if (!TextUtils.isEmpty(str)) {
            this.f7771a.setText(str);
        }
        this.b.a(bVar.p, bVar.q, bVar.e, bVar.f, bVar.i, bVar.A, bVar.b);
    }
}
