package com.jd.ad.sdk.jad_ny;

import android.graphics.Bitmap;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class jad_na implements jad_ly {
    public static final Bitmap.Config[] jad_dq;
    public static final Bitmap.Config[] jad_er;
    public static final Bitmap.Config[] jad_fs;
    public static final Bitmap.Config[] jad_hu;
    public static final Bitmap.Config[] jad_jt;
    public final jad_cp jad_an = new jad_cp();
    public final jad_hu<jad_bo, Bitmap> jad_bo = new jad_hu<>();
    public final Map<Bitmap.Config, NavigableMap<Integer, Integer>> jad_cp = new HashMap();

    public static /* synthetic */ class jad_an {
        public static final /* synthetic */ int[] jad_an;

        static {
            int[] iArr = new int[Bitmap.Config.values().length];
            jad_an = iArr;
            try {
                iArr[Bitmap.Config.ARGB_8888.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                jad_an[Bitmap.Config.RGB_565.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                jad_an[Bitmap.Config.ARGB_4444.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                jad_an[Bitmap.Config.ALPHA_8.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public static final class jad_bo implements jad_mz {
        public final jad_cp jad_an;
        public int jad_bo;
        public Bitmap.Config jad_cp;

        public jad_bo(jad_cp jad_cpVar) {
            this.jad_an = jad_cpVar;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof jad_bo)) {
                return false;
            }
            jad_bo jad_boVar = (jad_bo) obj;
            return this.jad_bo == jad_boVar.jad_bo && com.jd.ad.sdk.jad_ir.jad_ly.jad_an(this.jad_cp, jad_boVar.jad_cp);
        }

        public int hashCode() {
            int i = this.jad_bo * 31;
            Bitmap.Config config = this.jad_cp;
            return i + (config != null ? config.hashCode() : 0);
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        /*  JADX ERROR: JadxRuntimeException in pass: ModVisitor
            jadx.core.utils.exceptions.JadxRuntimeException: Can't change immutable type java.lang.Object to com.jd.ad.sdk.jad_ny.jad_na$jad_bo for r3v1 'this'  java.lang.Object
            	at jadx.core.dex.instructions.args.SSAVar.setType(SSAVar.java:114)
            	at jadx.core.dex.instructions.args.RegisterArg.setType(RegisterArg.java:52)
            	at jadx.core.dex.visitors.ModVisitor.removeCheckCast(ModVisitor.java:417)
            	at jadx.core.dex.visitors.ModVisitor.replaceStep(ModVisitor.java:152)
            	at jadx.core.dex.visitors.ModVisitor.visit(ModVisitor.java:96)
            */
        @Override // com.jd.ad.sdk.jad_ny.jad_mz
        public void jad_an() {
            /*
                r3 = this;
                com.jd.ad.sdk.jad_ny.jad_na$jad_cp r0 = r3.jad_an
                java.util.Queue<T extends com.jd.ad.sdk.jad_ny.jad_mz> r1 = r0.jad_an
                int r1 = r1.size()
                r2 = 20
                if (r1 >= r2) goto L11
                java.util.Queue<T extends com.jd.ad.sdk.jad_ny.jad_mz> r0 = r0.jad_an
                r0.offer(r3)
            L11:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.jd.ad.sdk.jad_ny.jad_na.jad_bo.jad_an():void");
        }

        public String toString() {
            return jad_na.jad_an(this.jad_bo, this.jad_cp);
        }
    }

    public static class jad_cp extends jad_dq<jad_bo> {
        @Override // com.jd.ad.sdk.jad_ny.jad_dq
        public jad_mz jad_an() {
            return new jad_bo(this);
        }

        public jad_bo jad_an(int i, Bitmap.Config config) {
            jad_bo jad_boVarJad_bo = jad_bo();
            jad_boVarJad_bo.jad_bo = i;
            jad_boVarJad_bo.jad_cp = config;
            return jad_boVarJad_bo;
        }
    }

    static {
        Bitmap.Config[] configArr = (Bitmap.Config[]) Arrays.copyOf(new Bitmap.Config[]{Bitmap.Config.ARGB_8888, null}, 3);
        configArr[configArr.length - 1] = Bitmap.Config.RGBA_F16;
        jad_dq = configArr;
        jad_er = configArr;
        jad_fs = new Bitmap.Config[]{Bitmap.Config.RGB_565};
        jad_jt = new Bitmap.Config[]{Bitmap.Config.ARGB_4444};
        jad_hu = new Bitmap.Config[]{Bitmap.Config.ALPHA_8};
    }

    public static String jad_an(int i, Bitmap.Config config) {
        return "[" + i + "](" + config + ")";
    }

    public static Bitmap.Config[] jad_an(Bitmap.Config config) {
        if (Bitmap.Config.RGBA_F16.equals(config)) {
            return jad_er;
        }
        int i = jad_an.jad_an[config.ordinal()];
        if (i == 1) {
            return jad_dq;
        }
        if (i == 2) {
            return jad_fs;
        }
        if (i != 3) {
            return i != 4 ? new Bitmap.Config[]{config} : jad_hu;
        }
        return jad_jt;
    }

    @Override // com.jd.ad.sdk.jad_ny.jad_ly
    public Bitmap jad_an() {
        Bitmap bitmapJad_an = this.jad_bo.jad_an();
        if (bitmapJad_an != null) {
            jad_an(Integer.valueOf(com.jd.ad.sdk.jad_ir.jad_ly.jad_an(bitmapJad_an)), bitmapJad_an);
        }
        return bitmapJad_an;
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    @Override // com.jd.ad.sdk.jad_ny.jad_ly
    public Bitmap jad_an(int i, int i2, Bitmap.Config config) {
        int iJad_an = com.jd.ad.sdk.jad_ir.jad_ly.jad_an(config) * i * i2;
        jad_bo jad_boVarJad_bo = this.jad_an.jad_bo();
        jad_boVarJad_bo.jad_bo = iJad_an;
        jad_boVarJad_bo.jad_cp = config;
        for (Bitmap.Config config2 : jad_an(config)) {
            Integer numCeilingKey = jad_bo(config2).ceilingKey(Integer.valueOf(iJad_an));
            if (numCeilingKey != null && numCeilingKey.intValue() <= iJad_an * 8) {
                if (numCeilingKey.intValue() == iJad_an && (config2 != null ? config2.equals(config) : config == null)) {
                    break;
                    break;
                }
                jad_cp jad_cpVar = this.jad_an;
                if (jad_cpVar.jad_an.size() < 20) {
                    jad_cpVar.jad_an.offer(jad_boVarJad_bo);
                }
                jad_boVarJad_bo = this.jad_an.jad_an(numCeilingKey.intValue(), config2);
                break;
            }
        }
        Bitmap bitmapJad_an = this.jad_bo.jad_an(jad_boVarJad_bo);
        if (bitmapJad_an != null) {
            jad_an(Integer.valueOf(jad_boVarJad_bo.jad_bo), bitmapJad_an);
            bitmapJad_an.reconfigure(i, i2, config);
        }
        return bitmapJad_an;
    }

    @Override // com.jd.ad.sdk.jad_ny.jad_ly
    public void jad_an(Bitmap bitmap) {
        jad_bo jad_boVarJad_an = this.jad_an.jad_an(com.jd.ad.sdk.jad_ir.jad_ly.jad_an(bitmap), bitmap.getConfig());
        this.jad_bo.jad_an(jad_boVarJad_an, bitmap);
        NavigableMap<Integer, Integer> navigableMapJad_bo = jad_bo(bitmap.getConfig());
        Integer num = (Integer) navigableMapJad_bo.get(Integer.valueOf(jad_boVarJad_an.jad_bo));
        navigableMapJad_bo.put(Integer.valueOf(jad_boVarJad_an.jad_bo), Integer.valueOf(num != null ? 1 + num.intValue() : 1));
    }

    public final void jad_an(Integer num, Bitmap bitmap) {
        NavigableMap<Integer, Integer> navigableMapJad_bo = jad_bo(bitmap.getConfig());
        Integer num2 = (Integer) navigableMapJad_bo.get(num);
        if (num2 == null) {
            throw new NullPointerException("Tried to decrement empty size, size: " + num + ", removed: " + jad_bo(bitmap) + ", this: " + this);
        }
        if (num2.intValue() == 1) {
            navigableMapJad_bo.remove(num);
        } else {
            navigableMapJad_bo.put(num, Integer.valueOf(num2.intValue() - 1));
        }
    }

    @Override // com.jd.ad.sdk.jad_ny.jad_ly
    public String jad_bo(int i, int i2, Bitmap.Config config) {
        return jad_an(com.jd.ad.sdk.jad_ir.jad_ly.jad_an(config) * i * i2, config);
    }

    @Override // com.jd.ad.sdk.jad_ny.jad_ly
    public String jad_bo(Bitmap bitmap) {
        return jad_an(com.jd.ad.sdk.jad_ir.jad_ly.jad_an(bitmap), bitmap.getConfig());
    }

    public final NavigableMap<Integer, Integer> jad_bo(Bitmap.Config config) {
        NavigableMap<Integer, Integer> navigableMap = this.jad_cp.get(config);
        if (navigableMap != null) {
            return navigableMap;
        }
        TreeMap treeMap = new TreeMap();
        this.jad_cp.put(config, treeMap);
        return treeMap;
    }

    @Override // com.jd.ad.sdk.jad_ny.jad_ly
    public int jad_cp(Bitmap bitmap) {
        return com.jd.ad.sdk.jad_ir.jad_ly.jad_an(bitmap);
    }

    public String toString() {
        StringBuilder sbAppend = com.jd.ad.sdk.jad_gr.jad_ly.jad_an("SizeConfigStrategy{groupedMap=").append(this.jad_bo).append(", sortedSizes=(");
        for (Map.Entry<Bitmap.Config, NavigableMap<Integer, Integer>> entry : this.jad_cp.entrySet()) {
            sbAppend.append(entry.getKey()).append('[').append(entry.getValue()).append("], ");
        }
        if (!this.jad_cp.isEmpty()) {
            sbAppend.replace(sbAppend.length() - 2, sbAppend.length(), "");
        }
        return sbAppend.append(")}").toString();
    }
}
