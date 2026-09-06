package com.opos.mobad.template.f;

import android.content.Context;
import android.graphics.Bitmap;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.opos.mobad.template.cmn.baseview.BaseImageView;
import com.stub.StubApp;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class k extends RelativeLayout implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private BaseImageView f7651a;
    private h b;
    private com.opos.mobad.template.a.InterfaceC1003a c;
    private Context d;

    public k(Context context) {
        super(context);
        if (context == null) {
            return;
        }
        this.d = StubApp.getOrigApplicationContext(context.getApplicationContext());
        setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        BaseImageView baseImageViewA = a(context);
        this.f7651a = baseImageViewA;
        addView(baseImageViewA);
        h hVar = new h(context, 1);
        this.b = hVar;
        addView(hVar);
    }

    private BaseImageView a(Context context) {
        BaseImageView baseImageView = new BaseImageView(context);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        baseImageView.setScaleType(ImageView.ScaleType.FIT_XY);
        baseImageView.setLayoutParams(layoutParams);
        return baseImageView;
    }

    @Override // com.opos.mobad.template.f.d
    public RelativeLayout a() {
        return this;
    }

    @Override // com.opos.mobad.template.f.d
    public void a(Bitmap bitmap) {
        BaseImageView baseImageView;
        if (this.d == null || (baseImageView = this.f7651a) == null) {
            return;
        }
        baseImageView.setImageBitmap(bitmap);
    }

    @Override // com.opos.mobad.template.f.d
    public void a(com.opos.mobad.template.a.InterfaceC1003a interfaceC1003a) {
        this.c = interfaceC1003a;
        h hVar = this.b;
        if (hVar != null) {
            hVar.a(interfaceC1003a);
        }
    }

    @Override // com.opos.mobad.template.f.d
    public void a(com.opos.mobad.template.cmn.baseview.f fVar) {
        BaseImageView baseImageView = this.f7651a;
        if (baseImageView != null) {
            baseImageView.a(fVar);
        }
    }

    @Override // com.opos.mobad.template.f.d
    public void a(com.opos.mobad.template.cmn.p pVar) {
        BaseImageView baseImageView = this.f7651a;
        if (baseImageView != null) {
            baseImageView.setOnClickListener(pVar);
            this.f7651a.setOnTouchListener(pVar);
        }
    }

    @Override // com.opos.mobad.template.f.d
    public void a(com.opos.mobad.template.d.b bVar, Bitmap bitmap) {
        h hVar = this.b;
        if (hVar != null) {
            hVar.a(bVar, bitmap);
        }
    }
}
