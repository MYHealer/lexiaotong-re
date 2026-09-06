package com.jd.ad.sdk.jad_yj;

import com.jd.ad.sdk.jad_ju.jad_jw;
import com.jd.ad.sdk.jad_mx.jad_xk;
import java.nio.ByteBuffer;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class jad_dq implements jad_er<com.jd.ad.sdk.jad_xi.jad_cp, byte[]> {
    @Override // com.jd.ad.sdk.jad_yj.jad_er
    public jad_xk<byte[]> jad_an(jad_xk<com.jd.ad.sdk.jad_xi.jad_cp> jad_xkVar, jad_jw jad_jwVar) {
        byte[] bArrArray;
        ByteBuffer byteBufferAsReadOnlyBuffer = jad_xkVar.get().jad_an.jad_an.jad_an.jad_er().asReadOnlyBuffer();
        AtomicReference<byte[]> atomicReference = com.jd.ad.sdk.jad_ir.jad_an.jad_an;
        com.jd.ad.sdk.jad_ir.jad_an.jad_bo jad_boVar = (byteBufferAsReadOnlyBuffer.isReadOnly() || !byteBufferAsReadOnlyBuffer.hasArray()) ? null : new com.jd.ad.sdk.jad_ir.jad_an.jad_bo(byteBufferAsReadOnlyBuffer.array(), byteBufferAsReadOnlyBuffer.arrayOffset(), byteBufferAsReadOnlyBuffer.limit());
        if (jad_boVar != null && jad_boVar.jad_an == 0 && jad_boVar.jad_bo == jad_boVar.jad_cp.length) {
            bArrArray = byteBufferAsReadOnlyBuffer.array();
        } else {
            ByteBuffer byteBufferAsReadOnlyBuffer2 = byteBufferAsReadOnlyBuffer.asReadOnlyBuffer();
            byte[] bArr = new byte[byteBufferAsReadOnlyBuffer2.limit()];
            byteBufferAsReadOnlyBuffer2.get(bArr);
            bArrArray = bArr;
        }
        return new com.jd.ad.sdk.jad_uf.jad_bo(bArrArray);
    }
}
