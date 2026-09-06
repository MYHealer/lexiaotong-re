package com.gnete.upbc.cashier.f;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.gnete.upbc.cashier.R;
import com.gnete.upbc.cashier.b.d;

/* JADX INFO: compiled from: OptionalItemLayout.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public class c<T extends d> extends RelativeLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final T f3300a;
    private final ImageView b;
    private final TextView c;
    private final ImageView d;

    public c(Context context, T t) {
        super(context);
        this.f3300a = t;
        LayoutInflater.from(context).inflate(R.layout.gnete_layout_optional, (ViewGroup) this, true);
        this.b = (ImageView) findViewById(R.id.gnete_image_icon);
        this.c = (TextView) findViewById(R.id.gnete_text_label);
        this.d = (ImageView) findViewById(R.id.gnete_image_selected);
        a();
    }

    private void a() {
        this.b.setImageResource(this.f3300a.a());
        this.c.setText(this.f3300a.b());
    }

    public void setChecked(d dVar) {
        if (this.f3300a.equals(dVar)) {
            this.d.setVisibility(0);
        } else {
            this.d.setVisibility(8);
        }
    }
}
