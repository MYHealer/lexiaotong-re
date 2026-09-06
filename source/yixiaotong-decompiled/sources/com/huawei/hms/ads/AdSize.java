package com.huawei.hms.ads;

import android.content.Context;
import com.huawei.openalliance.ad.utils.d;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class AdSize {
    public static final AdSize AD_SIZE_SMART = new AdSize(-1, -2);
    protected static final int B = -5;
    protected static final int Code = -1;
    private static final int D = -1;
    protected static final int I = -4;
    private static final float L = 10.0f;
    protected static final int V = -3;
    protected static final int Z = -2;
    protected final int C;
    protected int F = 0;
    protected final int S;

    protected interface a {
        public static final int Code = 0;
        public static final int V = 1;
    }

    public AdSize(int i, int i2) {
        if (Code(i) && V(i2)) {
            this.C = i;
            this.S = i2;
        } else {
            this.C = 0;
            this.S = 0;
        }
    }

    static boolean Code(int i) {
        return i > 0 || i == -1 || i == -3;
    }

    private boolean I(Context context) {
        if (this.F == 1) {
            int widthPx = getWidthPx(context);
            int heightPx = getHeightPx(context);
            if (heightPx != 0 && widthPx / heightPx > L) {
                return true;
            }
        }
        return false;
    }

    static boolean V(int i) {
        return i > 0 || i == -2 || i == -4 || i == -5;
    }

    public int Code(Context context) {
        return !I(context) ? getHeightPx(context) : d.Code(context, getWidthPx(context));
    }

    public int V(Context context) {
        return !I(context) ? getWidthPx(context) : d.V(context, getWidthPx(context));
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof AdSize)) {
            return false;
        }
        AdSize adSize = (AdSize) obj;
        return this.C == adSize.C && this.S == adSize.S && this.F == adSize.F;
    }

    public int getHeight() {
        return this.S;
    }

    public int getHeightPx(Context context) {
        if (!V(this.S)) {
            return -1;
        }
        int i = this.S;
        if (i == -2) {
            return d.S(context);
        }
        return i == -5 ? d.F(context) : d.I(context, i);
    }

    public int getWidth() {
        return this.C;
    }

    public int getWidthPx(Context context) {
        if (!Code(this.C)) {
            return -1;
        }
        int i = this.C;
        return i == -1 ? d.V(context) : d.I(context, i);
    }

    public int hashCode() {
        int iHashCode = Code(this.C) ? Integer.valueOf(this.C).hashCode() : -1;
        int iHashCode2 = V(this.S) ? Integer.valueOf(this.S).hashCode() : -1;
        int i = this.F;
        return iHashCode & super.hashCode() & iHashCode2 & ((i == 0 || i == 1) ? Integer.valueOf(i).hashCode() : -1);
    }
}
