package com.yfanads.android.adx.download.dialog;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import com.yfanads.android.adx.R;

/* JADX INFO: compiled from: DownloadViewHolder.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f9601a;
    public final ImageView b;
    public final ImageView c;
    public final TextView d;
    public final TextView e;
    public final TextView f;
    public final TextView g;
    public final TextView h;
    public final TextView i;
    public final LinearLayout j;
    public final TextView k;
    public final TextView l;
    public final TextView m;
    public final TextView n;
    public final TextView o;
    public final TextView p;
    public final ProgressBar q;
    public final ScrollView r;
    public final TextView s;
    public final RelativeLayout t;

    public c(View view) {
        this.f9601a = view;
        this.r = (ScrollView) view.findViewById(R.id.tv_app_info_area);
        this.b = (ImageView) view.findViewById(R.id.im_close);
        this.c = (ImageView) view.findViewById(R.id.im_iocn);
        this.d = (TextView) view.findViewById(R.id.tv_title);
        this.e = (TextView) view.findViewById(R.id.tv_subtitle);
        this.f = (TextView) view.findViewById(R.id.tv_author);
        this.g = (TextView) view.findViewById(R.id.tv_score);
        this.j = (LinearLayout) view.findViewById(R.id.ll_star);
        this.i = (TextView) view.findViewById(R.id.tv_introduce);
        this.k = (TextView) view.findViewById(R.id.tv_version);
        this.l = (TextView) view.findViewById(R.id.tv_privacy);
        this.m = (TextView) view.findViewById(R.id.tv_authority);
        this.n = (TextView) view.findViewById(R.id.tv_function);
        this.o = (TextView) view.findViewById(R.id.btn_dwonload);
        this.p = (TextView) view.findViewById(R.id.btn_del);
        this.q = (ProgressBar) view.findViewById(R.id.progressbar_dwonload);
        this.h = (TextView) view.findViewById(R.id.tv_application_size);
        this.s = (TextView) view.findViewById(R.id.tv_introduce_title);
        this.t = (RelativeLayout) view.findViewById(R.id.download_area);
    }

    public final void a(com.yfanads.android.adx.model.a aVar) {
        this.f9601a.setPadding(0, 0, 0, aVar.c);
        ((LinearLayout.LayoutParams) this.r.getLayoutParams()).height = aVar.g;
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.c.getLayoutParams();
        int i = aVar.f;
        layoutParams.width = i;
        layoutParams.height = i;
        ((LinearLayout.LayoutParams) this.t.getLayoutParams()).height = aVar.h;
        this.d.setTextSize(aVar.i);
        this.e.setTextSize(aVar.j);
        this.f.setTextSize(aVar.k);
        this.s.setTextSize(aVar.l);
        this.i.setTextSize(aVar.m);
        this.k.setTextSize(aVar.n);
        this.l.setTextSize(aVar.o);
        this.m.setTextSize(aVar.o);
        this.n.setTextSize(aVar.o);
        this.o.setTextSize(aVar.p);
    }
}
