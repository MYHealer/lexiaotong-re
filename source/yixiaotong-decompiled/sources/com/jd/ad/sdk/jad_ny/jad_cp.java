package com.jd.ad.sdk.jad_ny;

import android.graphics.Bitmap;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class jad_cp implements jad_ly {
    public final jad_bo jad_an = new jad_bo();
    public final jad_hu<jad_an, Bitmap> jad_bo = new jad_hu<>();

    public static class jad_an implements jad_mz {
        public final jad_bo jad_an;
        public int jad_bo;
        public int jad_cp;
        public Bitmap.Config jad_dq;

        public jad_an(jad_bo jad_boVar) {
            this.jad_an = jad_boVar;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof jad_an)) {
                return false;
            }
            jad_an jad_anVar = (jad_an) obj;
            return this.jad_bo == jad_anVar.jad_bo && this.jad_cp == jad_anVar.jad_cp && this.jad_dq == jad_anVar.jad_dq;
        }

        public int hashCode() {
            int i = ((this.jad_bo * 31) + this.jad_cp) * 31;
            Bitmap.Config config = this.jad_dq;
            return i + (config != null ? config.hashCode() : 0);
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        /*  JADX ERROR: JadxRuntimeException in pass: ModVisitor
            jadx.core.utils.exceptions.JadxRuntimeException: Can't change immutable type java.lang.Object to com.jd.ad.sdk.jad_ny.jad_cp$jad_an for r3v1 'this'  java.lang.Object
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
                com.jd.ad.sdk.jad_ny.jad_cp$jad_bo r0 = r3.jad_an
                java.util.Queue<T extends com.jd.ad.sdk.jad_ny.jad_mz> r1 = r0.jad_an
                int r1 = r1.size()
                r2 = 20
                if (r1 >= r2) goto L11
                java.util.Queue<T extends com.jd.ad.sdk.jad_ny.jad_mz> r0 = r0.jad_an
                r0.offer(r3)
            L11:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.jd.ad.sdk.jad_ny.jad_cp.jad_an.jad_an():void");
        }

        public String toString() {
            return jad_cp.jad_cp(this.jad_bo, this.jad_cp, this.jad_dq);
        }
    }

    public static class jad_bo extends jad_dq<jad_an> {
        @Override // com.jd.ad.sdk.jad_ny.jad_dq
        public jad_mz jad_an() {
            return new jad_an(this);
        }
    }

    public static String jad_cp(int i, int i2, Bitmap.Config config) {
        return "[" + i + "x" + i2 + "], " + config;
    }

    @Override // com.jd.ad.sdk.jad_ny.jad_ly
    public Bitmap jad_an() {
        return this.jad_bo.jad_an();
    }

    @Override // com.jd.ad.sdk.jad_ny.jad_ly
    public Bitmap jad_an(int i, int i2, Bitmap.Config config) {
        jad_an jad_anVarJad_bo = this.jad_an.jad_bo();
        jad_anVarJad_bo.jad_bo = i;
        jad_anVarJad_bo.jad_cp = i2;
        jad_anVarJad_bo.jad_dq = config;
        return this.jad_bo.jad_an(jad_anVarJad_bo);
    }

    @Override // com.jd.ad.sdk.jad_ny.jad_ly
    public String jad_bo(int i, int i2, Bitmap.Config config) {
        return jad_cp(i, i2, config);
    }

    @Override // com.jd.ad.sdk.jad_ny.jad_ly
    public String jad_bo(Bitmap bitmap) {
        return jad_cp(bitmap.getWidth(), bitmap.getHeight(), bitmap.getConfig());
    }

    @Override // com.jd.ad.sdk.jad_ny.jad_ly
    public int jad_cp(Bitmap bitmap) {
        return com.jd.ad.sdk.jad_ir.jad_ly.jad_an(bitmap);
    }

    public String toString() {
        return com.jd.ad.sdk.jad_gr.jad_ly.jad_an("AttributeStrategy:\n  ").append(this.jad_bo).toString();
    }

    @Override // com.jd.ad.sdk.jad_ny.jad_ly
    public void jad_an(Bitmap bitmap) {
        jad_bo jad_boVar = this.jad_an;
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        Bitmap.Config config = bitmap.getConfig();
        jad_an jad_anVarJad_bo = jad_boVar.jad_bo();
        jad_anVarJad_bo.jad_bo = width;
        jad_anVarJad_bo.jad_cp = height;
        jad_anVarJad_bo.jad_dq = config;
        this.jad_bo.jad_an(jad_anVarJad_bo, bitmap);
    }
}
