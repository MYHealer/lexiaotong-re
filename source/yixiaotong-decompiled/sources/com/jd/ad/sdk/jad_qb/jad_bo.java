package com.jd.ad.sdk.jad_qb;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Collections;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class jad_bo<Data> implements jad_na<byte[], Data> {
    public final InterfaceC0578jad_bo<Data> jad_an;

    public static class jad_an implements jad_ob<byte[], ByteBuffer> {

        /* JADX INFO: renamed from: com.jd.ad.sdk.jad_qb.jad_bo$jad_an$jad_an, reason: collision with other inner class name */
        public class C0577jad_an implements InterfaceC0578jad_bo<ByteBuffer> {
            public C0577jad_an(jad_an jad_anVar) {
            }

            @Override // com.jd.ad.sdk.jad_qb.jad_bo.InterfaceC0578jad_bo
            public Class<ByteBuffer> jad_an() {
                return ByteBuffer.class;
            }

            @Override // com.jd.ad.sdk.jad_qb.jad_bo.InterfaceC0578jad_bo
            public ByteBuffer jad_an(byte[] bArr) {
                return ByteBuffer.wrap(bArr);
            }
        }

        @Override // com.jd.ad.sdk.jad_qb.jad_ob
        public jad_na<byte[], ByteBuffer> jad_an(jad_re jad_reVar) {
            return new jad_bo(new C0577jad_an(this));
        }
    }

    /* JADX INFO: renamed from: com.jd.ad.sdk.jad_qb.jad_bo$jad_bo, reason: collision with other inner class name */
    public interface InterfaceC0578jad_bo<Data> {
        Class<Data> jad_an();

        Data jad_an(byte[] bArr);
    }

    public static class jad_cp<Data> implements com.jd.ad.sdk.jad_kv.jad_dq<Data> {
        public final byte[] jad_an;
        public final InterfaceC0578jad_bo<Data> jad_bo;

        public jad_cp(byte[] bArr, InterfaceC0578jad_bo<Data> interfaceC0578jad_bo) {
            this.jad_an = bArr;
            this.jad_bo = interfaceC0578jad_bo;
        }

        @Override // com.jd.ad.sdk.jad_kv.jad_dq
        public Class<Data> jad_an() {
            return this.jad_bo.jad_an();
        }

        @Override // com.jd.ad.sdk.jad_kv.jad_dq
        public void jad_an(com.jd.ad.sdk.jad_gr.jad_jt jad_jtVar, com.jd.ad.sdk.jad_kv.jad_dq.jad_an<? super Data> jad_anVar) {
            jad_anVar.jad_an(this.jad_bo.jad_an(this.jad_an));
        }

        @Override // com.jd.ad.sdk.jad_kv.jad_dq
        public void jad_bo() {
        }

        @Override // com.jd.ad.sdk.jad_kv.jad_dq
        public void jad_cp() {
        }

        @Override // com.jd.ad.sdk.jad_kv.jad_dq
        public com.jd.ad.sdk.jad_ju.jad_an jad_dq() {
            return com.jd.ad.sdk.jad_ju.jad_an.LOCAL;
        }
    }

    public static class jad_dq implements jad_ob<byte[], InputStream> {

        public class jad_an implements InterfaceC0578jad_bo<InputStream> {
            public jad_an(jad_dq jad_dqVar) {
            }

            @Override // com.jd.ad.sdk.jad_qb.jad_bo.InterfaceC0578jad_bo
            public Class<InputStream> jad_an() {
                return InputStream.class;
            }

            @Override // com.jd.ad.sdk.jad_qb.jad_bo.InterfaceC0578jad_bo
            public InputStream jad_an(byte[] bArr) {
                return new ByteArrayInputStream(bArr);
            }
        }

        @Override // com.jd.ad.sdk.jad_qb.jad_ob
        public jad_na<byte[], InputStream> jad_an(jad_re jad_reVar) {
            return new jad_bo(new jad_an(this));
        }
    }

    public jad_bo(InterfaceC0578jad_bo<Data> interfaceC0578jad_bo) {
        this.jad_an = interfaceC0578jad_bo;
    }

    @Override // com.jd.ad.sdk.jad_qb.jad_na
    public jad_na.jad_an jad_an(byte[] bArr, int i, int i2, com.jd.ad.sdk.jad_ju.jad_jw jad_jwVar) {
        byte[] bArr2 = bArr;
        return new jad_na.jad_an(new com.jd.ad.sdk.jad_hq.jad_bo(bArr2), Collections.emptyList(), new jad_cp(bArr2, this.jad_an));
    }

    @Override // com.jd.ad.sdk.jad_qb.jad_na
    public /* bridge */ /* synthetic */ boolean jad_an(byte[] bArr) {
        return true;
    }
}
