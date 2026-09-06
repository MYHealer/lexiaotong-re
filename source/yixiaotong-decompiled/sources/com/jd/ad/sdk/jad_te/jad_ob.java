package com.jd.ad.sdk.jad_te;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.ParcelFileDescriptor;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public interface jad_ob {

    public static final class jad_an implements jad_ob {
        public final ByteBuffer jad_an;
        public final List<com.jd.ad.sdk.jad_ju.jad_fs> jad_bo;
        public final com.jd.ad.sdk.jad_ny.jad_bo jad_cp;

        public jad_an(ByteBuffer byteBuffer, List<com.jd.ad.sdk.jad_ju.jad_fs> list, com.jd.ad.sdk.jad_ny.jad_bo jad_boVar) {
            this.jad_an = byteBuffer;
            this.jad_bo = list;
            this.jad_cp = jad_boVar;
        }

        @Override // com.jd.ad.sdk.jad_te.jad_ob
        public Bitmap jad_an(BitmapFactory.Options options) {
            return BitmapFactory.decodeStream(new com.jd.ad.sdk.jad_ir.jad_an.C0554jad_an(com.jd.ad.sdk.jad_ir.jad_an.jad_an(this.jad_an)), null, options);
        }

        @Override // com.jd.ad.sdk.jad_te.jad_ob
        public com.jd.ad.sdk.jad_ju.jad_fs.jad_bo jad_an() {
            return com.jd.ad.sdk.jad_ju.jad_jt.jad_an(this.jad_bo, com.jd.ad.sdk.jad_ir.jad_an.jad_an(this.jad_an));
        }

        @Override // com.jd.ad.sdk.jad_te.jad_ob
        public void jad_bo() {
        }

        @Override // com.jd.ad.sdk.jad_te.jad_ob
        public int jad_cp() {
            List<com.jd.ad.sdk.jad_ju.jad_fs> list = this.jad_bo;
            ByteBuffer byteBufferJad_an = com.jd.ad.sdk.jad_ir.jad_an.jad_an(this.jad_an);
            com.jd.ad.sdk.jad_ny.jad_bo jad_boVar = this.jad_cp;
            if (byteBufferJad_an == null) {
                return -1;
            }
            int size = list.size();
            for (int i = 0; i < size; i++) {
                int iJad_an = list.get(i).jad_an(byteBufferJad_an, jad_boVar);
                if (iJad_an != -1) {
                    return iJad_an;
                }
            }
            return -1;
        }
    }

    public static final class jad_bo implements jad_ob {
        public final com.jd.ad.sdk.jad_kv.jad_kx jad_an;
        public final com.jd.ad.sdk.jad_ny.jad_bo jad_bo;
        public final List<com.jd.ad.sdk.jad_ju.jad_fs> jad_cp;

        public jad_bo(InputStream inputStream, List<com.jd.ad.sdk.jad_ju.jad_fs> list, com.jd.ad.sdk.jad_ny.jad_bo jad_boVar) {
            this.jad_bo = (com.jd.ad.sdk.jad_ny.jad_bo) com.jd.ad.sdk.jad_ir.jad_kx.jad_an(jad_boVar);
            this.jad_cp = (List) com.jd.ad.sdk.jad_ir.jad_kx.jad_an(list);
            this.jad_an = new com.jd.ad.sdk.jad_kv.jad_kx(inputStream, jad_boVar);
        }

        @Override // com.jd.ad.sdk.jad_te.jad_ob
        public Bitmap jad_an(BitmapFactory.Options options) {
            return BitmapFactory.decodeStream(this.jad_an.jad_an(), null, options);
        }

        @Override // com.jd.ad.sdk.jad_te.jad_ob
        public com.jd.ad.sdk.jad_ju.jad_fs.jad_bo jad_an() {
            return com.jd.ad.sdk.jad_ju.jad_jt.jad_bo(this.jad_cp, this.jad_an.jad_an(), this.jad_bo);
        }

        @Override // com.jd.ad.sdk.jad_te.jad_ob
        public void jad_bo() {
            jad_sf jad_sfVar = this.jad_an.jad_an;
            synchronized (jad_sfVar) {
                jad_sfVar.jad_cp = jad_sfVar.jad_an.length;
            }
        }

        @Override // com.jd.ad.sdk.jad_te.jad_ob
        public int jad_cp() {
            return com.jd.ad.sdk.jad_ju.jad_jt.jad_an(this.jad_cp, this.jad_an.jad_an(), this.jad_bo);
        }
    }

    Bitmap jad_an(BitmapFactory.Options options);

    com.jd.ad.sdk.jad_ju.jad_fs.jad_bo jad_an();

    void jad_bo();

    int jad_cp();

    public static final class jad_cp implements jad_ob {
        public final com.jd.ad.sdk.jad_ny.jad_bo jad_an;
        public final List<com.jd.ad.sdk.jad_ju.jad_fs> jad_bo;
        public final com.jd.ad.sdk.jad_kv.jad_mz jad_cp;

        public jad_cp(ParcelFileDescriptor parcelFileDescriptor, List<com.jd.ad.sdk.jad_ju.jad_fs> list, com.jd.ad.sdk.jad_ny.jad_bo jad_boVar) {
            this.jad_an = (com.jd.ad.sdk.jad_ny.jad_bo) com.jd.ad.sdk.jad_ir.jad_kx.jad_an(jad_boVar);
            this.jad_bo = (List) com.jd.ad.sdk.jad_ir.jad_kx.jad_an(list);
            this.jad_cp = new com.jd.ad.sdk.jad_kv.jad_mz(parcelFileDescriptor);
        }

        @Override // com.jd.ad.sdk.jad_te.jad_ob
        public Bitmap jad_an(BitmapFactory.Options options) {
            return BitmapFactory.decodeFileDescriptor(this.jad_cp.jad_an.jad_an().getFileDescriptor(), null, options);
        }

        @Override // com.jd.ad.sdk.jad_te.jad_ob
        public void jad_bo() {
        }

        @Override // com.jd.ad.sdk.jad_te.jad_ob
        public int jad_cp() throws Throwable {
            jad_sf jad_sfVar;
            List<com.jd.ad.sdk.jad_ju.jad_fs> list = this.jad_bo;
            com.jd.ad.sdk.jad_kv.jad_mz jad_mzVar = this.jad_cp;
            com.jd.ad.sdk.jad_ny.jad_bo jad_boVar = this.jad_an;
            int size = list.size();
            for (int i = 0; i < size; i++) {
                com.jd.ad.sdk.jad_ju.jad_fs jad_fsVar = list.get(i);
                try {
                    jad_sfVar = new jad_sf(new FileInputStream(jad_mzVar.jad_an.jad_an().getFileDescriptor()), jad_boVar, 65536);
                    try {
                        int iJad_an = jad_fsVar.jad_an(jad_sfVar, jad_boVar);
                        try {
                            jad_sfVar.close();
                        } catch (IOException unused) {
                        }
                        jad_mzVar.jad_an.jad_an();
                        if (iJad_an != -1) {
                            return iJad_an;
                        }
                    } catch (Throwable th) {
                        th = th;
                        if (jad_sfVar != null) {
                            try {
                                jad_sfVar.close();
                            } catch (IOException unused2) {
                            }
                        }
                        jad_mzVar.jad_an.jad_an();
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    jad_sfVar = null;
                }
            }
            return -1;
        }

        @Override // com.jd.ad.sdk.jad_te.jad_ob
        public com.jd.ad.sdk.jad_ju.jad_fs.jad_bo jad_an() throws Throwable {
            jad_sf jad_sfVar;
            List<com.jd.ad.sdk.jad_ju.jad_fs> list = this.jad_bo;
            com.jd.ad.sdk.jad_kv.jad_mz jad_mzVar = this.jad_cp;
            com.jd.ad.sdk.jad_ny.jad_bo jad_boVar = this.jad_an;
            int size = list.size();
            for (int i = 0; i < size; i++) {
                com.jd.ad.sdk.jad_ju.jad_fs jad_fsVar = list.get(i);
                try {
                    jad_sfVar = new jad_sf(new FileInputStream(jad_mzVar.jad_an.jad_an().getFileDescriptor()), jad_boVar, 65536);
                    try {
                        com.jd.ad.sdk.jad_ju.jad_fs.jad_bo jad_boVarJad_an = jad_fsVar.jad_an(jad_sfVar);
                        try {
                            jad_sfVar.close();
                        } catch (IOException unused) {
                        }
                        jad_mzVar.jad_an.jad_an();
                        if (jad_boVarJad_an != com.jd.ad.sdk.jad_ju.jad_fs.jad_bo.UNKNOWN) {
                            return jad_boVarJad_an;
                        }
                    } catch (Throwable th) {
                        th = th;
                        if (jad_sfVar != null) {
                            try {
                                jad_sfVar.close();
                            } catch (IOException unused2) {
                            }
                        }
                        jad_mzVar.jad_an.jad_an();
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    jad_sfVar = null;
                }
            }
            return com.jd.ad.sdk.jad_ju.jad_fs.jad_bo.UNKNOWN;
        }
    }
}
