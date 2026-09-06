package com.huawei.openalliance.ad.views;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.huawei.hms.ads.fh;
import com.huawei.hms.ads.im;
import com.huawei.hms.ads.iz;
import com.huawei.hms.ads.lw;
import com.huawei.openalliance.ad.inter.data.p;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class PlacementImageView extends PlacementMediaView implements lw {
    private ImageView D;
    private p L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private iz f4497a;
    private com.huawei.openalliance.ad.media.listener.f b;

    public PlacementImageView(Context context) {
        super(context);
        Code(context);
    }

    public PlacementImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Code(context);
    }

    public PlacementImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Code(context);
    }

    private void Code(Context context) {
        this.f4497a = new im(getContext(), this);
        this.D = new ImageView(context);
        addView(this.D, new RelativeLayout.LayoutParams(-1, -1));
        this.D.setScaleType(ImageView.ScaleType.CENTER_CROP);
    }

    @Override // com.huawei.openalliance.ad.views.PlacementMediaView
    public void B() {
        com.huawei.openalliance.ad.media.listener.f fVar = this.b;
        if (fVar != null) {
            fVar.V();
        }
    }

    @Override // com.huawei.openalliance.ad.views.PlacementMediaView
    void Code() {
        this.D.setImageDrawable(null);
    }

    @Override // com.huawei.openalliance.ad.views.PlacementMediaView
    void Code(int i) {
        this.D.setImageDrawable(null);
    }

    @Override // com.huawei.hms.ads.lw
    public void Code(p pVar, Drawable drawable) {
        this.B = true;
        if (pVar == null || drawable == null) {
            this.C = false;
        } else if (this.L != null && TextUtils.equals(pVar.Z(), this.L.Z())) {
            this.C = true;
            this.D.setImageDrawable(drawable);
        }
        if (this.S) {
            Code(true, true);
        }
    }

    @Override // com.huawei.openalliance.ad.views.PlacementMediaView
    public void Code(com.huawei.openalliance.ad.media.listener.f fVar) {
        this.b = fVar;
    }

    @Override // com.huawei.openalliance.ad.views.PlacementMediaView
    public void I() {
        com.huawei.openalliance.ad.media.listener.f fVar = this.b;
        if (fVar != null) {
            fVar.Code();
        }
    }

    @Override // com.huawei.openalliance.ad.views.PlacementMediaView
    void V() {
    }

    @Override // com.huawei.openalliance.ad.views.PlacementMediaView
    public void V(com.huawei.openalliance.ad.media.listener.f fVar) {
        this.b = null;
    }

    @Override // com.huawei.openalliance.ad.views.PlacementMediaView, com.huawei.hms.ads.me
    public void destroyView() {
        this.D.setImageDrawable(null);
        super.destroyView();
    }

    @Override // com.huawei.openalliance.ad.views.PlacementMediaView
    ImageView getLastFrame() {
        return this.D;
    }

    @Override // com.huawei.openalliance.ad.views.PlacementMediaView
    com.huawei.openalliance.ad.media.b getMediaState() {
        return null;
    }

    @Override // com.huawei.openalliance.ad.views.PlacementMediaView
    void setMediaPlayerReleaseListener(com.huawei.openalliance.ad.media.listener.e eVar) {
    }

    @Override // com.huawei.openalliance.ad.views.PlacementMediaView
    public void setPlacementAd(com.huawei.openalliance.ad.inter.data.h hVar) {
        super.setPlacementAd(hVar);
        fh.Code("PlacementImageView", "setPlacementAd");
        if (this.Code != null) {
            p pVarS = this.Code.S();
            this.L = pVarS;
            if (pVarS.V()) {
                return;
            }
            this.f4497a.Code(this.Code);
            this.V = this.L.e();
        }
    }
}
