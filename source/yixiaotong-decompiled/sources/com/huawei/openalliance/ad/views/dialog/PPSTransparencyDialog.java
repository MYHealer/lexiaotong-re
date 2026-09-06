package com.huawei.openalliance.ad.views.dialog;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.huawei.hms.ads.fh;
import com.huawei.hms.ads.splash.R;
import com.huawei.openalliance.ad.utils.bg;
import com.huawei.openalliance.ad.utils.z;
import com.huawei.openalliance.ad.views.PPSBaseDialogContentView;
import com.huawei.openalliance.ad.views.PPSLabelView;
import com.huawei.openalliance.ad.views.dsa.DomesticDsaView;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class PPSTransparencyDialog extends PPSBaseDialog {
    private com.huawei.openalliance.ad.views.dsa.a n;

    /* JADX INFO: renamed from: com.huawei.openalliance.ad.views.dialog.PPSTransparencyDialog$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private class a implements com.huawei.openalliance.ad.views.dsa.a {
        private a() {
        }

        /* synthetic */ a(PPSTransparencyDialog pPSTransparencyDialog, AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // com.huawei.openalliance.ad.views.dsa.a
        public void Code() {
            PPSTransparencyDialog.this.V();
            if (PPSTransparencyDialog.this.n != null) {
                PPSTransparencyDialog.this.n.Code();
            }
        }
    }

    public PPSTransparencyDialog(Context context) {
        super(context);
    }

    public PPSTransparencyDialog(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public PPSTransparencyDialog(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public PPSTransparencyDialog(Context context, int[] iArr, int[] iArr2, int i) {
        super(context, iArr, iArr2, i);
    }

    private void F() {
        a aVar = new a(this, null);
        if (this.d instanceof DomesticDsaView) {
            ((DomesticDsaView) this.d).setDsaJumpListener(aVar);
        }
        if (this.c instanceof DomesticDsaView) {
            ((DomesticDsaView) this.c).setDsaJumpListener(aVar);
        }
    }

    @Override // com.huawei.openalliance.ad.views.dialog.PPSBaseDialog
    protected void Code() {
        this.S = (RelativeLayout) findViewById(R.id.haid_transparency_dialog_root);
        this.F = findViewById(R.id.margin_view);
        this.D = findViewById(R.id.anchor_view);
        this.c = (PPSBaseDialogContentView) findViewById(R.id.top_dsa_view);
        this.f = (ImageView) findViewById(R.id.top_dsa_iv);
        this.d = (PPSBaseDialogContentView) findViewById(R.id.bottom_dsa_view);
        this.g = (ImageView) findViewById(R.id.bottom_dsa_iv);
        F();
    }

    public void Code(boolean z, PPSLabelView.d dVar, com.huawei.openalliance.ad.views.dsa.a aVar) {
        if (this.e instanceof DomesticDsaView) {
            ((DomesticDsaView) this.e).Code(z, dVar);
        }
        this.n = aVar;
    }

    @Override // com.huawei.openalliance.ad.views.dialog.PPSBaseDialog
    protected void I() {
        this.b = 16.0f;
        super.I();
    }

    public void S() {
        V();
    }

    @Override // com.huawei.openalliance.ad.views.dialog.PPSBaseDialog
    protected void Z() {
        ImageView imageView;
        float f;
        if (!B()) {
            V();
            return;
        }
        int iV = z.V(this.i, 36.0f);
        int i = this.C;
        int i2 = (this.V - i) - iV;
        int iV2 = ((this.L[0] + this.f4503a[0]) - z.V(this.i, 6.0f)) - (iV / 2);
        if (iV2 >= i) {
            i = iV2;
        }
        if (i <= i2) {
            i2 = i;
        }
        if (bg.I()) {
            imageView = this.h;
            f = -i2;
        } else {
            imageView = this.h;
            f = i2;
        }
        imageView.setX(f);
    }

    @Override // com.huawei.openalliance.ad.views.dialog.PPSBaseDialog
    protected int getLayoutId() {
        return C() ? R.layout.hiad_transparency_dialog_splash : R.layout.hiad_transparency_dialog;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        fh.V("PPSTransparencyDialog", "onDetachedFromWindow");
        V();
    }
}
