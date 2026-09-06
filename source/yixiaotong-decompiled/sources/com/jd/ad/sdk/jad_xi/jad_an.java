package com.jd.ad.sdk.jad_xi;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;
import com.jd.ad.sdk.jad_ju.jad_ly;
import com.jd.ad.sdk.jad_mx.jad_xk;
import com.jd.ad.sdk.logger.Logger;
import com.stub.StubApp;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class jad_an implements jad_ly<ByteBuffer, jad_cp> {
    public static final C0587jad_an jad_fs = new C0587jad_an();
    public static final jad_bo jad_jt = new jad_bo();
    public final Context jad_an;
    public final List<com.jd.ad.sdk.jad_ju.jad_fs> jad_bo;
    public final jad_bo jad_cp;
    public final C0587jad_an jad_dq;
    public final com.jd.ad.sdk.jad_xi.jad_bo jad_er;

    /* JADX INFO: renamed from: com.jd.ad.sdk.jad_xi.jad_an$jad_an, reason: collision with other inner class name */
    public static class C0587jad_an {
    }

    public static class jad_bo {
        public final Queue<com.jd.ad.sdk.jad_it.jad_dq> jad_an = com.jd.ad.sdk.jad_ir.jad_ly.jad_an(0);
    }

    public jad_an(Context context, List<com.jd.ad.sdk.jad_ju.jad_fs> list, com.jd.ad.sdk.jad_ny.jad_er jad_erVar, com.jd.ad.sdk.jad_ny.jad_bo jad_boVar) {
        this(context, list, jad_erVar, jad_boVar, jad_jt, jad_fs);
    }

    public jad_an(Context context, List<com.jd.ad.sdk.jad_ju.jad_fs> list, com.jd.ad.sdk.jad_ny.jad_er jad_erVar, com.jd.ad.sdk.jad_ny.jad_bo jad_boVar, jad_bo jad_boVar2, C0587jad_an c0587jad_an) {
        this.jad_an = StubApp.getOrigApplicationContext(context.getApplicationContext());
        this.jad_bo = list;
        this.jad_dq = c0587jad_an;
        this.jad_er = new com.jd.ad.sdk.jad_xi.jad_bo(jad_erVar, jad_boVar);
        this.jad_cp = jad_boVar2;
    }

    @Override // com.jd.ad.sdk.jad_ju.jad_ly
    public jad_xk<jad_cp> jad_an(ByteBuffer byteBuffer, int i, int i2, com.jd.ad.sdk.jad_ju.jad_jw jad_jwVar) {
        com.jd.ad.sdk.jad_it.jad_dq jad_dqVar;
        ByteBuffer byteBuffer2 = byteBuffer;
        jad_bo jad_boVar = this.jad_cp;
        synchronized (jad_boVar) {
            com.jd.ad.sdk.jad_it.jad_dq jad_dqVarPoll = jad_boVar.jad_an.poll();
            if (jad_dqVarPoll == null) {
                jad_dqVarPoll = new com.jd.ad.sdk.jad_it.jad_dq();
            }
            jad_dqVar = jad_dqVarPoll;
            jad_dqVar.jad_bo = null;
            Arrays.fill(jad_dqVar.jad_an, (byte) 0);
            jad_dqVar.jad_cp = new com.jd.ad.sdk.jad_it.jad_cp();
            jad_dqVar.jad_dq = 0;
            ByteBuffer byteBufferAsReadOnlyBuffer = byteBuffer2.asReadOnlyBuffer();
            jad_dqVar.jad_bo = byteBufferAsReadOnlyBuffer;
            byteBufferAsReadOnlyBuffer.position(0);
            jad_dqVar.jad_bo.order(ByteOrder.LITTLE_ENDIAN);
        }
        try {
            jad_er jad_erVarJad_an = jad_an(byteBuffer2, i, i2, jad_dqVar, jad_jwVar);
            jad_bo jad_boVar2 = this.jad_cp;
            synchronized (jad_boVar2) {
                jad_dqVar.jad_bo = null;
                jad_dqVar.jad_cp = null;
                jad_boVar2.jad_an.offer(jad_dqVar);
            }
            return jad_erVarJad_an;
        } catch (Throwable th) {
            jad_bo jad_boVar3 = this.jad_cp;
            synchronized (jad_boVar3) {
                jad_dqVar.jad_bo = null;
                jad_dqVar.jad_cp = null;
                jad_boVar3.jad_an.offer(jad_dqVar);
                throw th;
            }
        }
    }

    public final jad_er jad_an(ByteBuffer byteBuffer, int i, int i2, com.jd.ad.sdk.jad_it.jad_dq jad_dqVar, com.jd.ad.sdk.jad_ju.jad_jw jad_jwVar) throws Throwable {
        Bitmap.Config config;
        long jJad_an = com.jd.ad.sdk.jad_ir.jad_jt.jad_an();
        int i3 = 2;
        try {
            com.jd.ad.sdk.jad_it.jad_cp jad_cpVarJad_bo = jad_dqVar.jad_bo();
            if (jad_cpVarJad_bo.jad_cp > 0 && jad_cpVarJad_bo.jad_bo == 0) {
                if (jad_jwVar.jad_an(jad_iv.jad_an) == com.jd.ad.sdk.jad_ju.jad_bo.PREFER_RGB_565) {
                    try {
                        config = Bitmap.Config.RGB_565;
                    } catch (Throwable th) {
                        th = th;
                    }
                } else {
                    config = Bitmap.Config.ARGB_8888;
                }
                int iJad_an = jad_an(jad_cpVarJad_bo, i, i2);
                C0587jad_an c0587jad_an = this.jad_dq;
                com.jd.ad.sdk.jad_xi.jad_bo jad_boVar = this.jad_er;
                c0587jad_an.getClass();
                com.jd.ad.sdk.jad_it.jad_er jad_erVar = new com.jd.ad.sdk.jad_it.jad_er(jad_boVar);
                jad_erVar.jad_an(jad_cpVarJad_bo, byteBuffer, iJad_an);
                jad_erVar.jad_an(config);
                jad_erVar.jad_kx = (jad_erVar.jad_kx + 1) % jad_erVar.jad_ly.jad_cp;
                Bitmap bitmapJad_fs = jad_erVar.jad_fs();
                if (bitmapJad_fs == null) {
                    if (Log.isLoggable("BufferGifDecoder", 2)) {
                        Logger.v("BufferGifDecoder", com.jd.ad.sdk.jad_gr.jad_ly.jad_an("Decoded GIF from stream in ").append(com.jd.ad.sdk.jad_ir.jad_jt.jad_an(jJad_an)).toString());
                    }
                    return null;
                }
                jad_er jad_erVar2 = new jad_er(new jad_cp(new jad_cp.jad_an(new jad_jt(com.jd.ad.sdk.jad_gr.jad_cp.jad_an(this.jad_an), jad_erVar, i, i2, (com.jd.ad.sdk.jad_sd.jad_bo) com.jd.ad.sdk.jad_sd.jad_bo.jad_bo, bitmapJad_fs))));
                if (Log.isLoggable("BufferGifDecoder", 2)) {
                    Logger.v("BufferGifDecoder", com.jd.ad.sdk.jad_gr.jad_ly.jad_an("Decoded GIF from stream in ").append(com.jd.ad.sdk.jad_ir.jad_jt.jad_an(jJad_an)).toString());
                }
                return jad_erVar2;
                if (Log.isLoggable("BufferGifDecoder", i3)) {
                    Logger.v("BufferGifDecoder", com.jd.ad.sdk.jad_gr.jad_ly.jad_an("Decoded GIF from stream in ").append(com.jd.ad.sdk.jad_ir.jad_jt.jad_an(jJad_an)).toString());
                }
                throw th;
            }
            if (Log.isLoggable("BufferGifDecoder", 2)) {
                Logger.v("BufferGifDecoder", com.jd.ad.sdk.jad_gr.jad_ly.jad_an("Decoded GIF from stream in ").append(com.jd.ad.sdk.jad_ir.jad_jt.jad_an(jJad_an)).toString());
            }
            return null;
        } catch (Throwable th2) {
            th = th2;
            i3 = 2;
        }
    }

    public static int jad_an(com.jd.ad.sdk.jad_it.jad_cp jad_cpVar, int i, int i2) {
        int iMin = Math.min(jad_cpVar.jad_jt / i2, jad_cpVar.jad_fs / i);
        int iMax = Math.max(1, iMin == 0 ? 0 : Integer.highestOneBit(iMin));
        if (Log.isLoggable("BufferGifDecoder", 2) && iMax > 1) {
            Logger.v("BufferGifDecoder", "Downsampling GIF, sampleSize: " + iMax + ", target dimens: [" + i + "x" + i2 + "], actual dimens: [" + jad_cpVar.jad_fs + "x" + jad_cpVar.jad_jt + "]");
        }
        return iMax;
    }

    @Override // com.jd.ad.sdk.jad_ju.jad_ly
    public boolean jad_an(ByteBuffer byteBuffer, com.jd.ad.sdk.jad_ju.jad_jw jad_jwVar) {
        return !((Boolean) jad_jwVar.jad_an(jad_iv.jad_bo)).booleanValue() && com.jd.ad.sdk.jad_ju.jad_jt.jad_an(this.jad_bo, byteBuffer) == com.jd.ad.sdk.jad_ju.jad_fs.jad_bo.GIF;
    }
}
