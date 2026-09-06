package com.hihonor.adsdk.common.uikit.hweffect.engine;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.ArrayMap;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class c {
    private static final String hnadsa = "HnShadowUtils";
    private static final int hnadsb = 40;
    private static final int hnadsc = 2;
    private static ArrayMap<C0461c, WeakReference<Bitmap>> hnadsd = new ArrayMap<>();

    static /* synthetic */ class a {
        static final /* synthetic */ int[] hnadsa;

        static {
            b.values();
            int[] iArr = new int[8];
            hnadsa = iArr;
            try {
                b bVar = b.LEFT;
                iArr[0] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                int[] iArr2 = hnadsa;
                b bVar2 = b.TOP;
                iArr2[1] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                int[] iArr3 = hnadsa;
                b bVar3 = b.RIGHT;
                iArr3[2] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                int[] iArr4 = hnadsa;
                b bVar4 = b.BOTTOM;
                iArr4[3] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                int[] iArr5 = hnadsa;
                b bVar5 = b.LEFT_TOP;
                iArr5[4] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                int[] iArr6 = hnadsa;
                b bVar6 = b.LEFT_BOTTOM;
                iArr6[5] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                int[] iArr7 = hnadsa;
                b bVar7 = b.RIGHT_TOP;
                iArr7[6] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                int[] iArr8 = hnadsa;
                b bVar8 = b.RIGHT_BOTTOM;
                iArr8[7] = 8;
            } catch (NoSuchFieldError unused8) {
            }
        }
    }

    public enum b {
        LEFT,
        TOP,
        RIGHT,
        BOTTOM,
        LEFT_TOP,
        LEFT_BOTTOM,
        RIGHT_TOP,
        RIGHT_BOTTOM
    }

    /* JADX INFO: renamed from: com.hihonor.adsdk.common.uikit.hweffect.engine.c$c, reason: collision with other inner class name */
    static class C0461c {
        float hnadsa;
        float hnadsb;
        float hnadsc;
        float hnadsd;
        boolean hnadse;
        b hnadsf;
        int hnadsg;

        C0461c(float f, float f2, float f3, float f4, boolean z, b bVar, int i) {
            this.hnadsa = f;
            this.hnadsb = f2;
            this.hnadsc = f3;
            this.hnadsd = f4;
            this.hnadse = z;
            this.hnadsf = bVar;
            this.hnadsg = i;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof C0461c)) {
                return false;
            }
            C0461c c0461c = (C0461c) obj;
            return Float.compare(c0461c.hnadsa, this.hnadsa) == 0 && Float.compare(c0461c.hnadsb, this.hnadsb) == 0 && Float.compare(c0461c.hnadsc, this.hnadsc) == 0 && Float.compare(c0461c.hnadsd, this.hnadsd) == 0 && this.hnadse == c0461c.hnadse && this.hnadsf == c0461c.hnadsf && this.hnadsg == c0461c.hnadsg;
        }

        public int hashCode() {
            return ((((((((((((Objects.hashCode(Float.valueOf(this.hnadsa)) + 527) * 31) + Objects.hashCode(Float.valueOf(this.hnadsb))) * 31) + Objects.hashCode(Float.valueOf(this.hnadsc))) * 31) + Objects.hashCode(Float.valueOf(this.hnadsd))) * 31) + Objects.hashCode(Boolean.valueOf(this.hnadse))) * 31) + Objects.hashCode(this.hnadsf)) * 31) + Objects.hashCode(Integer.valueOf(this.hnadsg));
        }
    }

    private c() {
    }

    public static Bitmap[] hnadsa(Context context, float f, float f2, float f3, boolean z, int i, Paint paint, Paint paint2, List<b> list) {
        int i2;
        int height;
        int width;
        int i3;
        if (list == null || list.size() == 0) {
            com.hihonor.adsdk.common.b.b.hnadsb(hnadsa, "Positions empty!", new Object[0]);
            return null;
        }
        int size = list.size();
        Bitmap[] bitmapArr = new Bitmap[size];
        float f4 = f + f2;
        Bitmap bitmapHnadsa = null;
        int i4 = 0;
        while (i4 < size) {
            int i5 = i4;
            C0461c c0461c = new C0461c(f, f3, 0.0f, f2, z, list.get(i4), i);
            Bitmap bitmapHnadsa2 = hnadsa(c0461c);
            if (bitmapHnadsa2 != null) {
                bitmapArr[i5] = bitmapHnadsa2;
            } else {
                if (bitmapHnadsa == null) {
                    bitmapHnadsa = hnadsa(context, f3, z, paint, paint2, f, f4, f, f4);
                }
                int i6 = 40;
                switch (list.get(i5)) {
                    case LEFT:
                        i2 = (int) f;
                        height = (int) (f4 + f3);
                        width = 0;
                        i6 = i2;
                        i3 = 40;
                        break;
                    case TOP:
                        i3 = (int) f4;
                        width = (int) (f + f3);
                        height = 0;
                        break;
                    case RIGHT:
                        i2 = (int) f;
                        width = (int) (bitmapHnadsa.getWidth() - f);
                        height = (int) (f4 + f3);
                        i6 = i2;
                        i3 = 40;
                        break;
                    case BOTTOM:
                        i3 = (int) f4;
                        width = (int) (f + f3);
                        height = (int) (bitmapHnadsa.getHeight() - f4);
                        break;
                    case LEFT_TOP:
                        i6 = (int) (f + f3);
                        i3 = (int) (f4 + f3);
                        width = 0;
                        height = 0;
                        break;
                    case LEFT_BOTTOM:
                        i6 = (int) (f + f3);
                        i3 = (int) (f4 + f3);
                        height = bitmapHnadsa.getHeight() - i3;
                        width = 0;
                        break;
                    case RIGHT_TOP:
                        i6 = (int) (f + f3);
                        i3 = (int) (f4 + f3);
                        width = bitmapHnadsa.getWidth() - i6;
                        height = 0;
                        break;
                    default:
                        i6 = (int) (f + f3);
                        i3 = (int) (f4 + f3);
                        width = bitmapHnadsa.getWidth() - i6;
                        height = bitmapHnadsa.getHeight() - i3;
                        break;
                }
                if (i6 <= 0 || i3 <= 0 || width < 0 || height < 0 || width + i6 > bitmapHnadsa.getWidth() || height + i3 > bitmapHnadsa.getHeight()) {
                    com.hihonor.adsdk.common.b.b.hnadsb(hnadsa, "Invalid width or height!", new Object[0]);
                } else {
                    Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmapHnadsa, width, height, i6, i3);
                    bitmapArr[i5] = bitmapCreateBitmap;
                    hnadsd.put(c0461c, new WeakReference<>(bitmapCreateBitmap));
                }
                i4 = i5 + 1;
            }
            i4 = i5 + 1;
        }
        return bitmapArr;
    }

    private static Bitmap hnadsa(C0461c c0461c) {
        if (hnadsd.containsKey(c0461c)) {
            WeakReference<Bitmap> weakReference = hnadsd.get(c0461c);
            if (weakReference != null && weakReference.get() != null) {
                return weakReference.get();
            }
            hnadsd.remove(c0461c);
            com.hihonor.adsdk.common.b.b.hnadsc(hnadsa, "bitmap recycled", new Object[0]);
        }
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsa, "notInCache", new Object[0]);
        return null;
    }

    private static Bitmap hnadsa(Context context, float f, boolean z, Paint paint, Paint paint2, float f2, float f3, float f4, float f5) {
        Canvas canvas = new Canvas();
        float f6 = (2.0f * f) + 40.0f;
        RectF rectF = new RectF(0.0f, 0.0f, f6, f6);
        Path path = new Path();
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap((int) (rectF.width() + f2 + f4), (int) (rectF.height() + f3 + f5), Bitmap.Config.ARGB_4444);
        canvas.setBitmap(bitmapCreateBitmap);
        rectF.offset(f2, f3);
        com.hihonor.adsdk.common.e.b.a.a.hnadsa(context, path, z ? 1 : 0, rectF, f);
        canvas.drawPath(path, paint);
        canvas.drawPath(path, paint2);
        return bitmapCreateBitmap;
    }
}
