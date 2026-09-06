package com.hihonor.adsdk.common.e.b.a;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Path;
import android.graphics.RectF;
import androidx.constraintlayout.core.motion.utils.TypedValues;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class a {
    public static final int hnadsa = 1;
    private static int hnadsb = 0;
    private static final int hnadsc = 0;
    private static final int hnadsd = 1;
    private static final int hnadse = 2;
    private static final int hnadsf = 3;
    private static final int hnadsg = 4;
    private static final int hnadsh = 5;
    private static final int hnadsi = 6;
    private static final int hnadsj = 7;
    private static final float hnadsk = 2.0f;
    private static final float hnadsl = 1.16f;
    private static final float hnadsm = 0.836f;
    private static final float hnadsn = 0.674f;
    private static final float hnadso = 0.046f;
    private static final float hnadsp = 0.511f;
    private static final float hnadsq = 0.133f;
    private static final float hnadsr = 0.348f;
    private static final float hnadss = 0.22f;

    private a() {
    }

    @Deprecated
    public static Path hnadsa(Resources resources, RectF rectF, float f) {
        if (rectF == null || rectF.isEmpty()) {
            return new Path();
        }
        hnadsa(resources);
        return hnadsa(resources, rectF.left, rectF.top, rectF.right, rectF.bottom, f);
    }

    @Deprecated
    public static Path hnadsa(Resources resources, float f, float f2, float f3, float f4, float f5) {
        hnadsa(resources);
        return hnadsa(null, 1, f, f2, f3, f4, f5);
    }

    public static Path hnadsa(Context context, Path path, int i, RectF rectF, float f) {
        if (rectF != null && !rectF.isEmpty()) {
            hnadsa(context);
            return hnadsa(path, i, rectF.left, rectF.top, rectF.right, rectF.bottom, f);
        }
        return new Path();
    }

    private static Path hnadsa(Path path, int i, float f, float f2, float f3, float f4, float f5) {
        Path path2;
        int i2 = (int) (f3 - f);
        int i3 = (int) (f4 - f2);
        if (path == null) {
            path2 = new Path();
        } else {
            path.reset();
            path2 = path;
        }
        if (Float.compare(f5, 0.0f) <= 0) {
            path2.addRect(f, f2, f3, f4, Path.Direction.CW);
            return path2;
        }
        float f6 = f5 * 2.0f;
        float f7 = i2;
        float f8 = f7 / 2.0f;
        float f9 = i3;
        float f10 = f9 / 2.0f;
        if (hnadsb != 1 || i != 1 || (i2 == i3 && Float.compare(f6, f7) >= 0)) {
            path2.addRoundRect(f, f2, f3, f4, f5, f5, Path.Direction.CW);
            return path2;
        }
        hnadsa(hnadsa((f6 > f7 || f6 > f9) ? Math.min(f8, f10) : f5, f7, f9, f6), f7, f9, path2);
        if (f > 0.0f || f2 > 0.0f) {
            path2.offset(f, f2);
        }
        return path2;
    }

    private static void hnadsa(float[] fArr, float f, float f2, Path path) {
        path.moveTo(0.0f, fArr[0]);
        path.cubicTo(0.0f, fArr[1], fArr[3], fArr[2], fArr[5], fArr[4]);
        float f3 = fArr[7];
        float f4 = fArr[6];
        path.cubicTo(f3, f4, f4, f3, fArr[4], fArr[5]);
        path.cubicTo(fArr[2], fArr[3], fArr[1], 0.0f, fArr[0], 0.0f);
        float f5 = fArr[0];
        if (f5 < f - f5) {
            path.lineTo(f - f5, 0.0f);
        }
        path.cubicTo(f - fArr[1], 0.0f, f - fArr[2], fArr[3], f - fArr[4], fArr[5]);
        float f6 = fArr[6];
        float f7 = fArr[7];
        path.cubicTo(f - f6, f7, f - f7, f6, f - fArr[5], fArr[4]);
        path.cubicTo(f - fArr[3], fArr[2], f, fArr[1], f, fArr[0]);
        float f8 = fArr[0];
        if (f8 < f2 - f8) {
            path.lineTo(f, f2 - f8);
        }
        path.cubicTo(f, f2 - fArr[1], f - fArr[3], f2 - fArr[2], f - fArr[5], f2 - fArr[4]);
        float f9 = fArr[7];
        float f10 = fArr[6];
        path.cubicTo(f - f9, f2 - f10, f - f10, f2 - f9, f - fArr[4], f2 - fArr[5]);
        path.cubicTo(f - fArr[2], f2 - fArr[3], f - fArr[1], f2, f - fArr[0], f2);
        float f11 = fArr[0];
        if (f - f11 > f11) {
            path.lineTo(f11, f2);
        }
        path.cubicTo(fArr[1], f2, fArr[2], f2 - fArr[3], fArr[4], f2 - fArr[5]);
        float f12 = fArr[6];
        float f13 = fArr[7];
        path.cubicTo(f12, f2 - f13, f13, f2 - f12, fArr[5], f2 - fArr[4]);
        path.cubicTo(fArr[3], f2 - fArr[2], 0.0f, f2 - fArr[1], 0.0f, f2 - fArr[0]);
        path.close();
    }

    private static float[] hnadsa(float f, float f2) {
        if (f2 >= hnadsl) {
            f2 = 1.16f;
        }
        if (f2 < 1.0f) {
            f2 = 1.0f;
        }
        float[] fArr = new float[8];
        fArr[0] = f2;
        fArr[1] = 0.836f;
        fArr[2] = 0.674f;
        fArr[3] = 0.046f;
        fArr[4] = 0.511f;
        fArr[5] = 0.133f;
        fArr[6] = 0.348f;
        fArr[7] = 0.22f;
        for (int i = 0; i < 8; i++) {
            fArr[i] = fArr[i] * f;
        }
        return fArr;
    }

    private static float[] hnadsa(float f, float f2, float f3, float f4) {
        return hnadsa(f, Math.min(f3 / f4, f2 / f4));
    }

    private static void hnadsa(Context context) {
        if (context != null && hnadsb == 0) {
            hnadsa(context.getResources());
        }
    }

    private static void hnadsa(Resources resources) {
        if (resources != null && hnadsb == 0) {
            int identifier = resources.getIdentifier("hn_uikit_round_type", TypedValues.Custom.S_INT, "androidhnext");
            if (identifier > 0) {
                hnadsb = resources.getInteger(identifier);
            } else {
                hnadsb = 1;
            }
        }
    }
}
