package com.jd.ad.sdk.jad_te;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.ColorSpace;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.os.Build;
import android.util.DisplayMetrics;
import android.util.Log;
import com.jd.ad.sdk.logger.Logger;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.locks.Lock;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public final class jad_jw {
    public static final com.jd.ad.sdk.jad_ju.jad_iv<Boolean> jad_hu;
    public static final com.jd.ad.sdk.jad_ju.jad_iv<Boolean> jad_iv;
    public static final Set<String> jad_jw;
    public static final jad_bo jad_kx;
    public static final Set<com.jd.ad.sdk.jad_ju.jad_fs.jad_bo> jad_ly;
    public static final Queue<BitmapFactory.Options> jad_mz;
    public final com.jd.ad.sdk.jad_ny.jad_er jad_an;
    public final DisplayMetrics jad_bo;
    public final com.jd.ad.sdk.jad_ny.jad_bo jad_cp;
    public final List<com.jd.ad.sdk.jad_ju.jad_fs> jad_dq;
    public final jad_na jad_er = jad_na.jad_an();
    public static final com.jd.ad.sdk.jad_ju.jad_iv<com.jd.ad.sdk.jad_ju.jad_bo> jad_fs = com.jd.ad.sdk.jad_ju.jad_iv.jad_an("com.jd.ad.sdk.glide.load.resource.bitmap.Downsampler.DecodeFormat", com.jd.ad.sdk.jad_ju.jad_bo.PREFER_ARGB_8888);
    public static final com.jd.ad.sdk.jad_ju.jad_iv<com.jd.ad.sdk.jad_ju.jad_kx> jad_jt = new com.jd.ad.sdk.jad_ju.jad_iv<>("com.jd.ad.sdk.glide.load.resource.bitmap.Downsampler.PreferredColorSpace", null, com.jd.ad.sdk.jad_ju.jad_iv.jad_er);

    public class jad_an implements jad_bo {
        @Override // com.jd.ad.sdk.jad_te.jad_jw.jad_bo
        public void jad_an() {
        }

        @Override // com.jd.ad.sdk.jad_te.jad_jw.jad_bo
        public void jad_an(com.jd.ad.sdk.jad_ny.jad_er jad_erVar, Bitmap bitmap) {
        }
    }

    public interface jad_bo {
        void jad_an();

        void jad_an(com.jd.ad.sdk.jad_ny.jad_er jad_erVar, Bitmap bitmap);
    }

    static {
        com.jd.ad.sdk.jad_ju.jad_iv<jad_iv> jad_ivVar = jad_iv.jad_dq;
        Boolean bool = Boolean.FALSE;
        jad_hu = com.jd.ad.sdk.jad_ju.jad_iv.jad_an("com.jd.ad.sdk.glide.load.resource.bitmap.Downsampler.FixBitmapSize", bool);
        jad_iv = com.jd.ad.sdk.jad_ju.jad_iv.jad_an("com.jd.ad.sdk.glide.load.resource.bitmap.Downsampler.AllowHardwareDecode", bool);
        jad_jw = Collections.unmodifiableSet(new HashSet(Arrays.asList("image/vnd.wap.wbmp", "image/x-ico")));
        jad_kx = new jad_an();
        jad_ly = Collections.unmodifiableSet(EnumSet.of(com.jd.ad.sdk.jad_ju.jad_fs.jad_bo.JPEG, com.jd.ad.sdk.jad_ju.jad_fs.jad_bo.PNG_A, com.jd.ad.sdk.jad_ju.jad_fs.jad_bo.PNG));
        char[] cArr = com.jd.ad.sdk.jad_ir.jad_ly.jad_an;
        jad_mz = new ArrayDeque(0);
    }

    public jad_jw(List<com.jd.ad.sdk.jad_ju.jad_fs> list, DisplayMetrics displayMetrics, com.jd.ad.sdk.jad_ny.jad_er jad_erVar, com.jd.ad.sdk.jad_ny.jad_bo jad_boVar) {
        this.jad_dq = list;
        this.jad_bo = (DisplayMetrics) com.jd.ad.sdk.jad_ir.jad_kx.jad_an(displayMetrics);
        this.jad_an = (com.jd.ad.sdk.jad_ny.jad_er) com.jd.ad.sdk.jad_ir.jad_kx.jad_an(jad_erVar);
        this.jad_cp = (com.jd.ad.sdk.jad_ny.jad_bo) com.jd.ad.sdk.jad_ir.jad_kx.jad_an(jad_boVar);
    }

    public static int jad_an(double d) {
        if (d > 1.0d) {
            d = 1.0d / d;
        }
        return (int) Math.round(d * 2.147483647E9d);
    }

    public static String jad_an(Bitmap bitmap) {
        if (bitmap == null) {
            return null;
        }
        return com.jd.ad.sdk.jad_gr.jad_ly.jad_an("[").append(bitmap.getWidth()).append("x").append(bitmap.getHeight()).append("] ").append(bitmap.getConfig()).append(com.jd.ad.sdk.jad_gr.jad_ly.jad_an(" (").append(bitmap.getAllocationByteCount()).append(")").toString()).toString();
    }

    public static void jad_an(BitmapFactory.Options options) {
        options.inTempStorage = null;
        options.inDither = false;
        options.inScaled = false;
        options.inSampleSize = 1;
        options.inPreferredConfig = null;
        options.inJustDecodeBounds = false;
        options.inDensity = 0;
        options.inTargetDensity = 0;
        options.inPreferredColorSpace = null;
        options.outColorSpace = null;
        options.outConfig = null;
        options.outWidth = 0;
        options.outHeight = 0;
        options.outMimeType = null;
        options.inBitmap = null;
        options.inMutable = true;
    }

    public static boolean jad_an(int i) {
        return i == 90 || i == 270;
    }

    public static int jad_bo(double d) {
        return (int) (d + 0.5d);
    }

    public static int[] jad_bo(jad_ob jad_obVar, BitmapFactory.Options options, jad_bo jad_boVar, com.jd.ad.sdk.jad_ny.jad_er jad_erVar) {
        options.inJustDecodeBounds = true;
        jad_an(jad_obVar, options, jad_boVar, jad_erVar);
        options.inJustDecodeBounds = false;
        return new int[]{options.outWidth, options.outHeight};
    }

    public final com.jd.ad.sdk.jad_mx.jad_xk<Bitmap> jad_an(jad_ob jad_obVar, int i, int i2, com.jd.ad.sdk.jad_ju.jad_jw jad_jwVar, jad_bo jad_boVar) {
        Queue<BitmapFactory.Options> queue;
        BitmapFactory.Options options;
        BitmapFactory.Options options2;
        byte[] bArr = (byte[]) this.jad_cp.jad_an(65536, byte[].class);
        synchronized (jad_jw.class) {
            queue = jad_mz;
            synchronized (queue) {
                options = (BitmapFactory.Options) ((ArrayDeque) queue).poll();
            }
            if (options == null) {
                options = new BitmapFactory.Options();
                jad_an(options);
            }
            options2 = options;
        }
        options2.inTempStorage = bArr;
        com.jd.ad.sdk.jad_ju.jad_bo jad_boVar2 = (com.jd.ad.sdk.jad_ju.jad_bo) jad_jwVar.jad_an(jad_fs);
        com.jd.ad.sdk.jad_ju.jad_kx jad_kxVar = (com.jd.ad.sdk.jad_ju.jad_kx) jad_jwVar.jad_an(jad_jt);
        jad_iv jad_ivVar = (jad_iv) jad_jwVar.jad_an(jad_iv.jad_dq);
        boolean zBooleanValue = ((Boolean) jad_jwVar.jad_an(jad_hu)).booleanValue();
        com.jd.ad.sdk.jad_ju.jad_iv<Boolean> jad_ivVar2 = jad_iv;
        try {
            jad_er jad_erVarJad_an = jad_er.jad_an(jad_an(jad_obVar, options2, jad_ivVar, jad_boVar2, jad_kxVar, jad_jwVar.jad_an(jad_ivVar2) != null && ((Boolean) jad_jwVar.jad_an(jad_ivVar2)).booleanValue(), i, i2, zBooleanValue, jad_boVar), this.jad_an);
            jad_an(options2);
            synchronized (queue) {
                ((ArrayDeque) queue).offer(options2);
            }
            return jad_erVarJad_an;
        } finally {
            jad_an(options2);
            Queue<BitmapFactory.Options> queue2 = jad_mz;
            synchronized (queue2) {
                ((ArrayDeque) queue2).offer(options2);
                this.jad_cp.jad_an(bArr);
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:103:0x0307  */
    /* JADX WARN: Code duplicated, block: B:108:0x0328  */
    /* JADX WARN: Code duplicated, block: B:111:0x0330  */
    /* JADX WARN: Code duplicated, block: B:112:0x0333  */
    /* JADX WARN: Code duplicated, block: B:118:0x0347  */
    /* JADX WARN: Code duplicated, block: B:120:0x034b  */
    /* JADX WARN: Code duplicated, block: B:124:0x0358  */
    /* JADX WARN: Code duplicated, block: B:127:0x0381  */
    /* JADX WARN: Code duplicated, block: B:134:0x03e9  */
    /* JADX WARN: Code duplicated, block: B:136:0x03ed  */
    /* JADX WARN: Code duplicated, block: B:140:0x03f9  */
    /* JADX WARN: Code duplicated, block: B:149:0x040e  */
    /* JADX WARN: Code duplicated, block: B:153:0x042a  */
    /* JADX WARN: Code duplicated, block: B:156:0x04cc  */
    /* JADX WARN: Code duplicated, block: B:158:0x04d8  */
    /* JADX WARN: Code duplicated, block: B:159:0x04db  */
    /* JADX WARN: Code duplicated, block: B:162:0x04ec  */
    /* JADX WARN: Code duplicated, block: B:163:0x04f0  */
    /* JADX WARN: Code duplicated, block: B:164:0x04f6  */
    /* JADX WARN: Code duplicated, block: B:165:0x04fa  */
    /* JADX WARN: Code duplicated, block: B:166:0x0500  */
    /* JADX WARN: Code duplicated, block: B:168:0x0509  */
    /* JADX WARN: Code duplicated, block: B:169:0x050d  */
    /* JADX WARN: Code duplicated, block: B:172:0x053b  */
    /* JADX WARN: Code duplicated, block: B:173:0x0540  */
    /* JADX WARN: Code duplicated, block: B:182:0x057a  */
    /* JADX WARN: Code duplicated, block: B:184:0x02ff A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:98:0x02f4  */
    /* JADX WARN: Code duplicated, block: B:99:0x02f7  */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final Bitmap jad_an(jad_ob jad_obVar, BitmapFactory.Options options, jad_iv jad_ivVar, com.jd.ad.sdk.jad_ju.jad_bo jad_boVar, com.jd.ad.sdk.jad_ju.jad_kx jad_kxVar, boolean z, int i, int i2, boolean z2, jad_bo jad_boVar2) {
        int i3;
        boolean z3;
        String str;
        int i4;
        boolean z4;
        int i5;
        String str2;
        int i6;
        String str3;
        String str4;
        Bitmap.Config config;
        int i7;
        int i8;
        float f;
        int i9;
        int iRound;
        int iRound2;
        int i10;
        int i11;
        Bitmap bitmapJad_an;
        Bitmap bitmap;
        com.jd.ad.sdk.jad_ny.jad_er jad_erVar;
        Matrix matrix;
        Bitmap.Config config2;
        Bitmap bitmap2;
        float f2;
        boolean zEquals;
        ColorSpace.Named named;
        ColorSpace colorSpace;
        com.jd.ad.sdk.jad_ny.jad_er jad_erVar2;
        Bitmap.Config config3;
        int i12;
        int i13;
        int iFloor;
        int iFloor2;
        int i14;
        long jJad_an = com.jd.ad.sdk.jad_ir.jad_jt.jad_an();
        int[] iArrJad_bo = jad_bo(jad_obVar, options, jad_boVar2, this.jad_an);
        int i15 = iArrJad_bo[0];
        int i16 = iArrJad_bo[1];
        String str5 = options.outMimeType;
        boolean z5 = (i15 == -1 || i16 == -1) ? false : z;
        int iJad_cp = jad_obVar.jad_cp();
        switch (iJad_cp) {
            case 3:
            case 4:
                i3 = 180;
                break;
            case 5:
            case 6:
                i3 = 90;
                break;
            case 7:
            case 8:
                i3 = 270;
                break;
            default:
                i3 = 0;
                break;
        }
        switch (iJad_cp) {
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
                z3 = true;
                break;
            default:
                z3 = false;
                break;
        }
        int i17 = i == Integer.MIN_VALUE ? jad_an(i3) ? i16 : i15 : i;
        if (i2 == Integer.MIN_VALUE) {
            str = str5;
            i4 = jad_an(i3) ? i15 : i16;
        } else {
            str = str5;
            i4 = i2;
        }
        com.jd.ad.sdk.jad_ju.jad_fs.jad_bo jad_boVarJad_an = jad_obVar.jad_an();
        com.jd.ad.sdk.jad_ny.jad_er jad_erVar3 = this.jad_an;
        String str6 = ", target density: ";
        String str7 = ", density: ";
        String str8 = "x";
        String str9 = "Downsampler";
        if (i15 > 0) {
            if (i16 <= 0) {
                i5 = 3;
                z4 = false;
            } else {
                if (jad_an(i3)) {
                    i13 = i16;
                    i12 = i15;
                } else {
                    i12 = i16;
                    i13 = i15;
                }
                float fJad_bo = jad_ivVar.jad_bo(i13, i12, i17, i4);
                z4 = false;
                if (fJad_bo <= 0.0f) {
                    throw new IllegalArgumentException("Cannot scale with factor: " + fJad_bo + " from: " + jad_ivVar + ", source: [" + i15 + "x" + i16 + "], target: [" + i17 + "x" + i4 + "]");
                }
                int i18 = i3;
                int iJad_an = jad_ivVar.jad_an(i13, i12, i17, i4);
                if (iJad_an == 0) {
                    throw new IllegalArgumentException("Cannot round with null rounding");
                }
                float f3 = i13;
                float f4 = i12;
                int i19 = i17;
                int iJad_bo = i13 / jad_bo(fJad_bo * f3);
                int iJad_bo2 = i12 / jad_bo(fJad_bo * f4);
                int iMax = Math.max(1, Integer.highestOneBit(iJad_an == 1 ? Math.max(iJad_bo, iJad_bo2) : Math.min(iJad_bo, iJad_bo2)));
                if (iJad_an == 1 && iMax < 1.0f / fJad_bo) {
                    iMax <<= 1;
                }
                options.inSampleSize = iMax;
                if (jad_boVarJad_an == com.jd.ad.sdk.jad_ju.jad_fs.jad_bo.JPEG) {
                    float fMin = Math.min(iMax, 8);
                    iFloor = (int) Math.ceil(f3 / fMin);
                    iFloor2 = (int) Math.ceil(f4 / fMin);
                    int i20 = iMax / 8;
                    if (i20 > 0) {
                        iFloor /= i20;
                        iFloor2 /= i20;
                    }
                } else if (jad_boVarJad_an == com.jd.ad.sdk.jad_ju.jad_fs.jad_bo.PNG || jad_boVarJad_an == com.jd.ad.sdk.jad_ju.jad_fs.jad_bo.PNG_A) {
                    float f5 = iMax;
                    iFloor = (int) Math.floor(f3 / f5);
                    iFloor2 = (int) Math.floor(f4 / f5);
                } else {
                    jad_boVarJad_an.getClass();
                    int i21 = com.jd.ad.sdk.jad_ju.jad_fs.jad_an.jad_an[jad_boVarJad_an.ordinal()];
                    if (i21 == 1 || i21 == 2 || i21 == 3) {
                        float f6 = iMax;
                        iFloor = Math.round(f3 / f6);
                        iFloor2 = Math.round(f4 / f6);
                    } else if (i13 % iMax == 0 && i12 % iMax == 0) {
                        iFloor = i13 / iMax;
                        iFloor2 = i12 / iMax;
                    } else {
                        int[] iArrJad_bo2 = jad_bo(jad_obVar, options, jad_boVar2, jad_erVar3);
                        iFloor = iArrJad_bo2[0];
                        iFloor2 = iArrJad_bo2[1];
                    }
                }
                i17 = i19;
                double dJad_bo = jad_ivVar.jad_bo(iFloor, iFloor2, i17, i4);
                int iJad_an2 = jad_an(dJad_bo);
                int iJad_bo3 = jad_bo(((double) iJad_an2) * dJad_bo);
                options.inTargetDensity = jad_bo((dJad_bo / ((double) (iJad_bo3 / iJad_an2))) * ((double) iJad_bo3));
                options.inDensity = jad_an(dJad_bo);
                int i22 = options.inTargetDensity;
                if (i22 <= 0 || (i14 = options.inDensity) <= 0 || i22 == i14) {
                    options.inTargetDensity = 0;
                    options.inDensity = 0;
                } else {
                    options.inScaled = true;
                }
                str9 = "Downsampler";
                if (Log.isLoggable(str9, 2)) {
                    i15 = i15;
                    str8 = "x";
                    i16 = i16;
                    StringBuilder sbAppend = new StringBuilder("Calculate scaling, source: [").append(i15).append(str8).append(i16).append("], degreesToRotate: ").append(i18).append(", target: [").append(i17).append(str8).append(i4).append("], power of two scaled: [").append(iFloor).append(str8).append(iFloor2).append("], exact scale factor: ").append(fJad_bo).append(", power of 2 sample size: ").append(iMax).append(", adjusted scale factor: ").append(dJad_bo);
                    str6 = ", target density: ";
                    str7 = ", density: ";
                    Logger.v(str9, sbAppend.append(str6).append(options.inTargetDensity).append(str7).append(options.inDensity).toString());
                } else {
                    str7 = ", density: ";
                    str6 = str6;
                    i16 = i16;
                    str8 = "x";
                    i15 = i15;
                }
            }
            str2 = str9;
            i6 = i4;
            str3 = str;
            str4 = str6;
            int i23 = i17;
            if (!this.jad_er.jad_an(i17, i6, options, z5, z3)) {
                if (jad_boVar != com.jd.ad.sdk.jad_ju.jad_bo.PREFER_ARGB_8888) {
                    try {
                        if (jad_obVar.jad_an().jad_an) {
                            config = Bitmap.Config.ARGB_8888;
                        } else {
                            config = Bitmap.Config.RGB_565;
                        }
                    } catch (IOException e) {
                        if (Log.isLoggable(str2, 3)) {
                            Logger.d(str2, "Cannot determine whether the image has alpha or not from header, format " + jad_boVar, e);
                        }
                    }
                    options.inPreferredConfig = config;
                    if (config == Bitmap.Config.RGB_565) {
                        options.inDither = true;
                    }
                } else {
                    options.inPreferredConfig = Bitmap.Config.ARGB_8888;
                }
            }
            i7 = Build.VERSION.SDK_INT;
            int i24 = options.inSampleSize;
            if (i15 >= 0 || i16 < 0 || !z2) {
                i8 = options.inTargetDensity;
                if (i8 > 0 || (i11 = options.inDensity) <= 0 || i8 == i11) {
                    f = 1.0f;
                } else {
                    f = i8 / options.inDensity;
                }
                i9 = options.inSampleSize;
                float f7 = i9;
                int iCeil = (int) Math.ceil(i15 / f7);
                int iCeil2 = (int) Math.ceil(i16 / f7);
                iRound = Math.round(iCeil * f);
                iRound2 = Math.round(iCeil2 * f);
                if (Log.isLoggable(str2, 2)) {
                    Logger.v(str2, "Calculated target [" + iRound + str8 + iRound2 + "] for source [" + i15 + str8 + i16 + "], sampleSize: " + i9 + ", targetDensity: " + options.inTargetDensity + str7 + options.inDensity + ", density multiplier: " + f);
                }
                i10 = iRound;
            } else {
                iRound2 = i6;
                i10 = i23;
            }
            if (i10 > 0 && iRound2 > 0) {
                jad_erVar2 = this.jad_an;
                if (options.inPreferredConfig != Bitmap.Config.HARDWARE) {
                    config3 = options.outConfig;
                    if (config3 == null) {
                        config3 = options.inPreferredConfig;
                    }
                    options.inBitmap = jad_erVar2.jad_bo(i10, iRound2, config3);
                }
            }
            if (jad_kxVar != null) {
                if (i7 >= 28 || jad_kxVar != com.jd.ad.sdk.jad_ju.jad_kx.DISPLAY_P3 || (colorSpace = options.outColorSpace) == null || !colorSpace.isWideGamut()) {
                    named = ColorSpace.Named.SRGB;
                } else {
                    named = ColorSpace.Named.DISPLAY_P3;
                }
                options.inPreferredColorSpace = ColorSpace.get(named);
            }
            bitmapJad_an = jad_an(jad_obVar, options, jad_boVar2, this.jad_an);
            jad_boVar2.jad_an(this.jad_an, bitmapJad_an);
            if (Log.isLoggable(str2, 2)) {
                Logger.v(str2, com.jd.ad.sdk.jad_gr.jad_ly.jad_an("Decoded ").append(jad_an(bitmapJad_an)).append(" from [").append(i15).append(str8).append(i16).append("] ").append(str3).append(" with inBitmap ").append(jad_an(options.inBitmap)).append(" for [").append(i).append(str8).append(i2).append("], sample size: ").append(options.inSampleSize).append(str7).append(options.inDensity).append(str4).append(options.inTargetDensity).append(", thread: ").append(Thread.currentThread().getName()).append(", duration: ").append(com.jd.ad.sdk.jad_ir.jad_jt.jad_an(jJad_an)).toString());
            }
            bitmap = null;
            if (bitmapJad_an != null) {
                bitmapJad_an.setDensity(this.jad_bo.densityDpi);
                jad_erVar = this.jad_an;
                switch (iJad_cp) {
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                    case 6:
                    case 7:
                    case 8:
                        matrix = new Matrix();
                        switch (iJad_cp) {
                            case 2:
                                matrix.setScale(-1.0f, 1.0f);
                                break;
                            case 3:
                                matrix.setRotate(180.0f);
                                break;
                            case 4:
                                f2 = 1.0f;
                                matrix.setRotate(180.0f);
                                matrix.postScale(-1.0f, f2);
                                break;
                            case 5:
                                f2 = 1.0f;
                                matrix.setRotate(90.0f);
                                matrix.postScale(-1.0f, f2);
                                break;
                            case 6:
                                matrix.setRotate(90.0f);
                                break;
                            case 7:
                                matrix.setRotate(-90.0f);
                                f2 = 1.0f;
                                matrix.postScale(-1.0f, f2);
                                break;
                            case 8:
                                matrix.setRotate(-90.0f);
                                break;
                        }
                        RectF rectF = new RectF(0.0f, 0.0f, bitmapJad_an.getWidth(), bitmapJad_an.getHeight());
                        matrix.mapRect(rectF);
                        int iRound3 = Math.round(rectF.width());
                        int iRound4 = Math.round(rectF.height());
                        if (bitmapJad_an.getConfig() != null) {
                            config2 = bitmapJad_an.getConfig();
                        } else {
                            config2 = Bitmap.Config.ARGB_8888;
                        }
                        Bitmap bitmapJad_an2 = jad_erVar.jad_an(iRound3, iRound4, config2);
                        matrix.postTranslate(-rectF.left, -rectF.top);
                        bitmapJad_an2.setHasAlpha(bitmapJad_an.hasAlpha());
                        Lock lock = jad_vi.jad_bo;
                        lock.lock();
                        try {
                            Canvas canvas = new Canvas(bitmapJad_an2);
                            canvas.drawBitmap(bitmapJad_an, matrix, jad_vi.jad_an);
                            canvas.setBitmap(null);
                            lock.unlock();
                            bitmap2 = bitmapJad_an2;
                        } catch (Throwable th) {
                            jad_vi.jad_bo.unlock();
                            throw th;
                        }
                        break;
                    default:
                        bitmap2 = bitmapJad_an;
                        break;
                }
                zEquals = bitmapJad_an.equals(bitmap2);
                bitmap = bitmap2;
                if (!zEquals) {
                    this.jad_an.jad_an(bitmapJad_an);
                    bitmap = bitmap2;
                }
            }
            return bitmap;
        }
        z4 = false;
        i5 = 3;
        if (Log.isLoggable(str9, i5)) {
            Logger.d(str9, "Unable to determine dimensions for: " + jad_boVarJad_an + " with target [" + i17 + str8 + i4 + "]");
        }
        str2 = str9;
        i6 = i4;
        str3 = str;
        str4 = str6;
        int i25 = i17;
        if (!this.jad_er.jad_an(i17, i6, options, z5, z3)) {
            if (jad_boVar != com.jd.ad.sdk.jad_ju.jad_bo.PREFER_ARGB_8888) {
                if (jad_obVar.jad_an().jad_an) {
                    config = Bitmap.Config.ARGB_8888;
                } else {
                    config = Bitmap.Config.RGB_565;
                }
                options.inPreferredConfig = config;
                if (config == Bitmap.Config.RGB_565) {
                    options.inDither = true;
                }
            } else {
                options.inPreferredConfig = Bitmap.Config.ARGB_8888;
            }
        }
        i7 = Build.VERSION.SDK_INT;
        int i26 = options.inSampleSize;
        if (i15 >= 0) {
            i8 = options.inTargetDensity;
            if (i8 > 0) {
                f = 1.0f;
            } else {
                f = 1.0f;
            }
            i9 = options.inSampleSize;
            float f8 = i9;
            int iCeil3 = (int) Math.ceil(i15 / f8);
            int iCeil4 = (int) Math.ceil(i16 / f8);
            iRound = Math.round(iCeil3 * f);
            iRound2 = Math.round(iCeil4 * f);
            if (Log.isLoggable(str2, 2)) {
                Logger.v(str2, "Calculated target [" + iRound + str8 + iRound2 + "] for source [" + i15 + str8 + i16 + "], sampleSize: " + i9 + ", targetDensity: " + options.inTargetDensity + str7 + options.inDensity + ", density multiplier: " + f);
            }
            i10 = iRound;
        } else {
            i8 = options.inTargetDensity;
            if (i8 > 0) {
                f = 1.0f;
            } else {
                f = 1.0f;
            }
            i9 = options.inSampleSize;
            float f9 = i9;
            int iCeil5 = (int) Math.ceil(i15 / f9);
            int iCeil6 = (int) Math.ceil(i16 / f9);
            iRound = Math.round(iCeil5 * f);
            iRound2 = Math.round(iCeil6 * f);
            if (Log.isLoggable(str2, 2)) {
                Logger.v(str2, "Calculated target [" + iRound + str8 + iRound2 + "] for source [" + i15 + str8 + i16 + "], sampleSize: " + i9 + ", targetDensity: " + options.inTargetDensity + str7 + options.inDensity + ", density multiplier: " + f);
            }
            i10 = iRound;
        }
        if (i10 > 0) {
            jad_erVar2 = this.jad_an;
            if (options.inPreferredConfig != Bitmap.Config.HARDWARE) {
                config3 = options.outConfig;
                if (config3 == null) {
                    config3 = options.inPreferredConfig;
                }
                options.inBitmap = jad_erVar2.jad_bo(i10, iRound2, config3);
            }
        }
        if (jad_kxVar != null) {
            if (i7 >= 28) {
                named = ColorSpace.Named.SRGB;
            } else {
                named = ColorSpace.Named.SRGB;
            }
            options.inPreferredColorSpace = ColorSpace.get(named);
        }
        bitmapJad_an = jad_an(jad_obVar, options, jad_boVar2, this.jad_an);
        jad_boVar2.jad_an(this.jad_an, bitmapJad_an);
        if (Log.isLoggable(str2, 2)) {
            Logger.v(str2, com.jd.ad.sdk.jad_gr.jad_ly.jad_an("Decoded ").append(jad_an(bitmapJad_an)).append(" from [").append(i15).append(str8).append(i16).append("] ").append(str3).append(" with inBitmap ").append(jad_an(options.inBitmap)).append(" for [").append(i).append(str8).append(i2).append("], sample size: ").append(options.inSampleSize).append(str7).append(options.inDensity).append(str4).append(options.inTargetDensity).append(", thread: ").append(Thread.currentThread().getName()).append(", duration: ").append(com.jd.ad.sdk.jad_ir.jad_jt.jad_an(jJad_an)).toString());
        }
        bitmap = null;
        if (bitmapJad_an != null) {
            bitmapJad_an.setDensity(this.jad_bo.densityDpi);
            jad_erVar = this.jad_an;
            switch (iJad_cp) {
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                case 7:
                case 8:
                    matrix = new Matrix();
                    switch (iJad_cp) {
                        case 2:
                            matrix.setScale(-1.0f, 1.0f);
                            break;
                        case 3:
                            matrix.setRotate(180.0f);
                            break;
                        case 4:
                            f2 = 1.0f;
                            matrix.setRotate(180.0f);
                            matrix.postScale(-1.0f, f2);
                            break;
                        case 5:
                            f2 = 1.0f;
                            matrix.setRotate(90.0f);
                            matrix.postScale(-1.0f, f2);
                            break;
                        case 6:
                            matrix.setRotate(90.0f);
                            break;
                        case 7:
                            matrix.setRotate(-90.0f);
                            f2 = 1.0f;
                            matrix.postScale(-1.0f, f2);
                            break;
                        case 8:
                            matrix.setRotate(-90.0f);
                            break;
                    }
                    RectF rectF2 = new RectF(0.0f, 0.0f, bitmapJad_an.getWidth(), bitmapJad_an.getHeight());
                    matrix.mapRect(rectF2);
                    int iRound5 = Math.round(rectF2.width());
                    int iRound6 = Math.round(rectF2.height());
                    if (bitmapJad_an.getConfig() != null) {
                        config2 = bitmapJad_an.getConfig();
                    } else {
                        config2 = Bitmap.Config.ARGB_8888;
                    }
                    Bitmap bitmapJad_an3 = jad_erVar.jad_an(iRound5, iRound6, config2);
                    matrix.postTranslate(-rectF2.left, -rectF2.top);
                    bitmapJad_an3.setHasAlpha(bitmapJad_an.hasAlpha());
                    Lock lock2 = jad_vi.jad_bo;
                    lock2.lock();
                    Canvas canvas2 = new Canvas(bitmapJad_an3);
                    canvas2.drawBitmap(bitmapJad_an, matrix, jad_vi.jad_an);
                    canvas2.setBitmap(null);
                    lock2.unlock();
                    bitmap2 = bitmapJad_an3;
                    break;
                default:
                    bitmap2 = bitmapJad_an;
                    break;
            }
            zEquals = bitmapJad_an.equals(bitmap2);
            bitmap = bitmap2;
            if (!zEquals) {
                this.jad_an.jad_an(bitmapJad_an);
                bitmap = bitmap2;
            }
        }
        return bitmap;
    }

    public static Bitmap jad_an(jad_ob jad_obVar, BitmapFactory.Options options, jad_bo jad_boVar, com.jd.ad.sdk.jad_ny.jad_er jad_erVar) {
        if (!options.inJustDecodeBounds) {
            jad_boVar.jad_an();
            jad_obVar.jad_bo();
        }
        int i = options.outWidth;
        int i2 = options.outHeight;
        String str = options.outMimeType;
        Lock lock = jad_vi.jad_bo;
        lock.lock();
        try {
            try {
                Bitmap bitmapJad_an = jad_obVar.jad_an(options);
                lock.unlock();
                return bitmapJad_an;
            } catch (IllegalArgumentException e) {
                IOException iOExceptionJad_an = jad_an(e, i, i2, str, options);
                if (Log.isLoggable("Downsampler", 3)) {
                    Logger.d("Downsampler", "Failed to decode with inBitmap, trying again without Bitmap re-use", iOExceptionJad_an);
                }
                Bitmap bitmap = options.inBitmap;
                if (bitmap == null) {
                    throw iOExceptionJad_an;
                }
                try {
                    jad_erVar.jad_an(bitmap);
                    options.inBitmap = null;
                    Bitmap bitmapJad_an2 = jad_an(jad_obVar, options, jad_boVar, jad_erVar);
                    jad_vi.jad_bo.unlock();
                    return bitmapJad_an2;
                } catch (IOException unused) {
                    throw iOExceptionJad_an;
                }
            }
        } catch (Throwable th) {
            jad_vi.jad_bo.unlock();
            throw th;
        }
    }

    public static IOException jad_an(IllegalArgumentException illegalArgumentException, int i, int i2, String str, BitmapFactory.Options options) {
        return new IOException("Exception decoding bitmap, outWidth: " + i + ", outHeight: " + i2 + ", outMimeType: " + str + ", inBitmap: " + jad_an(options.inBitmap), illegalArgumentException);
    }
}
