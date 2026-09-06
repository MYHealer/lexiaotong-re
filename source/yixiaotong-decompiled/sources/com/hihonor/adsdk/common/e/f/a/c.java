package com.hihonor.adsdk.common.e.f.a;

import android.content.res.Resources;
import android.graphics.drawable.shapes.OvalShape;
import android.graphics.drawable.shapes.RoundRectShape;
import android.graphics.drawable.shapes.Shape;
import androidx.constraintlayout.core.motion.utils.TypedValues;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class c {
    d hnadsa = new d();

    private static boolean hnadsc() {
        return true;
    }

    public c hnadsa(Shape shape) {
        this.hnadsa.hnadsa(shape);
        return this;
    }

    public c hnadsb(int[] iArr) {
        this.hnadsa.hnadsb(iArr);
        return this;
    }

    public c hnadsc(Resources resources) {
        this.hnadsa.hnadsa(resources);
        return this;
    }

    public static boolean hnadsb(Resources resources) {
        return hnadsa(resources) && hnadsc();
    }

    public c hnadsa(int i) {
        this.hnadsa.hnadsa(i);
        return this;
    }

    private void hnadsb() {
        boolean z;
        if (this.hnadsa.hnadsf() != null) {
            if (!e.hnadsc(this.hnadsa.hnadsa())) {
                z = false;
            } else {
                if (this.hnadsa.hnadsb() == null || this.hnadsa.hnadsb().length < 1) {
                    throw new IllegalArgumentException("shaow colors not correct");
                }
                z = true;
            }
            if (e.hnadsa(this.hnadsa.hnadsa())) {
                if (this.hnadsa.hnadsb() == null || this.hnadsa.hnadsb().length < 2) {
                    throw new IllegalArgumentException("gradient colors not correct");
                }
                z = true;
            }
            if (e.hnadsb(this.hnadsa.hnadsa())) {
                if (this.hnadsa.hnadsd() == null || this.hnadsa.hnadsd().length < 1) {
                    throw new IllegalArgumentException("light colors not correct");
                }
            } else if (!z) {
                throw new IllegalArgumentException("effect not correct");
            }
            if (!(this.hnadsa.hnadsf() instanceof RoundRectShape) && !(this.hnadsa.hnadsf() instanceof OvalShape)) {
                throw new IllegalArgumentException("support RoundRect or circle only");
            }
            if ((this.hnadsa.hnadsf() instanceof OvalShape) && this.hnadsa.hnadsf().getWidth() != this.hnadsa.hnadsf().getHeight()) {
                throw new IllegalArgumentException("support circle only");
            }
            return;
        }
        throw new IllegalArgumentException("shape is null");
    }

    public c hnadsa(int[] iArr) {
        this.hnadsa.hnadsa(iArr);
        return this;
    }

    public c hnadsa(float[] fArr) {
        this.hnadsa.hnadsa(fArr);
        return this;
    }

    public i hnadsa() {
        if (this.hnadsa.hnadsa() == 0) {
            return new f(this.hnadsa);
        }
        hnadsb();
        if (this.hnadsa.hnadsf() instanceof OvalShape) {
            return new b(this.hnadsa);
        }
        return this.hnadsa.hnadsf() instanceof RoundRectShape ? new g(this.hnadsa) : new f(this.hnadsa);
    }

    private static boolean hnadsa(Resources resources) {
        if (resources == null) {
            return false;
        }
        int identifier = resources.getIdentifier("hn_mage_2d_visual_effect", TypedValues.Custom.S_INT, "androidhnext");
        return identifier <= 0 || resources.getInteger(identifier) > 0;
    }
}
