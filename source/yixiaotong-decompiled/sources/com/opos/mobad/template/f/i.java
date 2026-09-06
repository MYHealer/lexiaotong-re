package com.opos.mobad.template.f;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.core.graphics.ColorUtils;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.opos.mobad.template.cmn.baseview.BaseImageView;
import com.stub.StubApp;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class i extends RelativeLayout implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private BaseImageView f7637a;
    private BaseImageView b;
    private h c;
    private Context d;

    public i(Context context) {
        super(context);
        if (context == null) {
            return;
        }
        this.d = StubApp.getOrigApplicationContext(context.getApplicationContext());
        setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        setBackgroundColor(ColorUtils.setAlphaComponent(-16777216, 51));
        BaseImageView baseImageViewB = b(context);
        this.f7637a = baseImageViewB;
        addView(baseImageViewB);
        addView(a(context));
        BaseImageView baseImageView = new BaseImageView(context);
        this.b = baseImageView;
        baseImageView.setScaleType(ImageView.ScaleType.FIT_XY);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(context, 145.0f), -1);
        this.b.setLayoutParams(layoutParams);
        layoutParams.addRule(14);
        addView(this.b);
        h hVar = new h(context, 0);
        this.c = hVar;
        addView(hVar);
    }

    private View a(Context context) {
        View view = new View(context);
        view.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        view.setBackgroundColor(ColorUtils.setAlphaComponent(-16777216, MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_CODEC_ID));
        return view;
    }

    private BaseImageView b(Context context) {
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
        if (this.d != null) {
            BaseImageView baseImageView = this.b;
            if (baseImageView != null) {
                baseImageView.setImageBitmap(bitmap);
            }
            BaseImageView baseImageView2 = this.f7637a;
            if (baseImageView2 != null) {
                baseImageView2.setImageBitmap(com.opos.mobad.template.cmn.f.a(this.d, bitmap, 75, 0.25f, 60.0f));
            }
        }
    }

    @Override // com.opos.mobad.template.f.d
    public void a(com.opos.mobad.template.a.InterfaceC1003a interfaceC1003a) {
        h hVar = this.c;
        if (hVar != null) {
            hVar.a(interfaceC1003a);
        }
    }

    @Override // com.opos.mobad.template.f.d
    public void a(com.opos.mobad.template.cmn.baseview.f fVar) {
        BaseImageView baseImageView = this.f7637a;
        if (baseImageView != null) {
            baseImageView.a(fVar);
        }
    }

    @Override // com.opos.mobad.template.f.d
    public void a(com.opos.mobad.template.cmn.p pVar) {
        BaseImageView baseImageView = this.f7637a;
        if (baseImageView != null) {
            baseImageView.setOnClickListener(pVar);
            this.f7637a.setOnTouchListener(pVar);
        }
        BaseImageView baseImageView2 = this.b;
        if (baseImageView2 != null) {
            baseImageView2.setOnClickListener(pVar);
            this.b.setOnTouchListener(pVar);
        }
    }

    @Override // com.opos.mobad.template.f.d
    public void a(com.opos.mobad.template.d.b bVar, Bitmap bitmap) {
        h hVar = this.c;
        if (hVar != null) {
            hVar.a(bVar, bitmap);
        }
    }
}
