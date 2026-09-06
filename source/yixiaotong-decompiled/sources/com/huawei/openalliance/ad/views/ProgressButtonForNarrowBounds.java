package com.huawei.openalliance.ad.views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.util.AttributeSet;
import com.huawei.hms.ads.fh;
import com.huawei.openalliance.ad.utils.bg;
import com.huawei.openalliance.ad.utils.z;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class ProgressButtonForNarrowBounds extends ProgressButton {
    public ProgressButtonForNarrowBounds(Context context) {
        super(context);
    }

    public ProgressButtonForNarrowBounds(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public ProgressButtonForNarrowBounds(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @Override // com.huawei.openalliance.ad.views.ProgressButton
    protected void Code(int i, int i2) {
        int width;
        int width2;
        synchronized (this.D) {
            if (this.e) {
                width = (getWidth() / 2) - this.Code.centerX();
                if (this.d && width < this.f4499a) {
                    width = getTextStart();
                }
                width2 = this.Code.width() + width;
            } else {
                width = (getWidth() - this.Code.width()) - z.V(getContext(), 1.0f);
                if (this.d && width < this.f4499a) {
                    width = getTextStart();
                }
                width2 = getWidth();
            }
            if (this.F != null) {
                this.F.setBounds(width, 0, width2, i2);
            }
        }
    }

    @Override // com.huawei.openalliance.ad.views.ProgressButton
    protected void Code(Canvas canvas) {
        int width;
        int height;
        Rect rect;
        synchronized (this.D) {
            if (this.I != null && this.I.length() > 0) {
                String strIntern = this.I.toString().intern();
                if (this.e) {
                    width = (getWidth() / 2) - this.Code.centerX();
                    if (this.d && width < this.f4499a) {
                        width = getTextStart();
                    }
                    height = getHeight() / 2;
                    rect = this.Code;
                } else {
                    width = (getWidth() - this.Code.width()) - z.V(getContext(), 1.0f);
                    if (this.d && width < this.f4499a) {
                        width = getTextStart();
                    }
                    height = getHeight() / 2;
                    rect = this.Code;
                }
                canvas.drawText((CharSequence) strIntern, 0, strIntern.length(), width, height - rect.centerY(), this.V);
                Code(getWidth(), getHeight());
            }
        }
    }

    @Override // com.huawei.openalliance.ad.views.ProgressButton
    protected int getTextStart() {
        if (bg.C()) {
            return this.c;
        }
        int width = ((getWidth() - this.Code.width()) - this.f) - z.V(getContext(), 8.0f);
        if (width < this.b) {
            width = this.b;
        }
        fh.V("ProgressButtonNew", "safeTextStart: %s", Integer.valueOf(width));
        return width;
    }
}
