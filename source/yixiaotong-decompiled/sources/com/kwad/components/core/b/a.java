package com.kwad.components.core.b;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.kwad.sdk.R;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public final class a implements View.OnClickListener {
    private TextView OY;
    private ImageView OZ;
    private ImageView Pa;
    private InterfaceC0650a Pb;
    private ViewGroup wT;

    /* JADX INFO: renamed from: com.kwad.components.core.b.a$a, reason: collision with other inner class name */
    public interface InterfaceC0650a {
        void w(View view);

        void x(View view);
    }

    public final void a(InterfaceC0650a interfaceC0650a) {
        this.Pb = interfaceC0650a;
    }

    public final ViewGroup ib() {
        return this.wT;
    }

    public a(ViewGroup viewGroup) {
        if (viewGroup == null) {
            return;
        }
        ViewGroup viewGroup2 = (ViewGroup) viewGroup.findViewById(R.id.ksad_kwad_web_title_bar);
        this.wT = viewGroup2;
        if (viewGroup2 == null) {
            return;
        }
        initView();
    }

    private void initView() {
        this.OY = (TextView) this.wT.findViewById(R.id.ksad_kwad_titlebar_title);
        this.OZ = (ImageView) this.wT.findViewById(R.id.ksad_kwad_web_navi_back);
        ImageView imageView = (ImageView) this.wT.findViewById(R.id.ksad_kwad_web_navi_close);
        this.Pa = imageView;
        imageView.setOnClickListener(this);
        this.OZ.setOnClickListener(this);
    }

    public final void a(b bVar) {
        TextView textView;
        com.kwad.sdk.core.d.c.d("KsTitleBarHelper", "bindView call model: " + bVar.toString());
        if (this.wT == null || bVar == null || (textView = this.OY) == null) {
            return;
        }
        textView.setText(bVar.getTitle());
        int iOG = bVar.oG();
        if (iOG >= 0) {
            this.OY.setTextColor(iOG);
        }
        int iOH = bVar.oH();
        if (iOH >= 0) {
            this.OY.setBackgroundColor(iOH);
        }
    }

    public final void ak(boolean z) {
        ImageView imageView = this.Pa;
        if (imageView != null) {
            imageView.setVisibility(z ? 0 : 8);
        }
    }

    public final void al(boolean z) {
        ImageView imageView = this.OZ;
        if (imageView != null) {
            imageView.setVisibility(8);
        }
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (this.Pb == null) {
            return;
        }
        if (view.equals(this.Pa)) {
            this.Pb.x(view);
        } else if (view.equals(this.OZ)) {
            this.Pb.w(view);
        }
    }
}
