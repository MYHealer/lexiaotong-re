package com.jd.ad.sdk.jad_hk;

import android.support.v4.media.session.PlaybackStateCompat;
import java.io.EOFException;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public final class jad_iv implements jad_bo {
    public final jad_an jad_an = new jad_an();
    public final jad_mz jad_bo;
    public boolean jad_cp;

    public jad_iv(jad_mz jad_mzVar) {
        if (jad_mzVar == null) {
            throw new NullPointerException("source == null");
        }
        this.jad_bo = jad_mzVar;
    }

    @Override // com.jd.ad.sdk.jad_hk.jad_mz, java.io.Closeable, java.lang.AutoCloseable, java.nio.channels.Channel
    public void close() {
        if (this.jad_cp) {
            return;
        }
        this.jad_cp = true;
        this.jad_bo.close();
        jad_an jad_anVar = this.jad_an;
        jad_anVar.getClass();
        try {
            jad_anVar.jad_dq(jad_anVar.jad_bo);
        } catch (EOFException e) {
            throw new AssertionError(e);
        }
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        return !this.jad_cp;
    }

    @Override // com.jd.ad.sdk.jad_hk.jad_bo
    public int jad_an(jad_fs jad_fsVar) throws EOFException {
        if (this.jad_cp) {
            throw new IllegalStateException("closed");
        }
        do {
            int iJad_an = this.jad_an.jad_an(jad_fsVar, true);
            if (iJad_an == -1) {
                return -1;
            }
            if (iJad_an != -2) {
                this.jad_an.jad_dq(jad_fsVar.jad_an[iJad_an].jad_cp());
                return iJad_an;
            }
        } while (this.jad_bo.jad_an(this.jad_an, PlaybackStateCompat.ACTION_PLAY_FROM_URI) != -1);
        return -1;
    }

    @Override // com.jd.ad.sdk.jad_hk.jad_mz
    public long jad_an(jad_an jad_anVar, long j) {
        if (jad_anVar == null) {
            throw new IllegalArgumentException("sink == null");
        }
        if (j < 0) {
            throw new IllegalArgumentException("byteCount < 0: " + j);
        }
        if (this.jad_cp) {
            throw new IllegalStateException("closed");
        }
        jad_an jad_anVar2 = this.jad_an;
        if (jad_anVar2.jad_bo == 0 && this.jad_bo.jad_an(jad_anVar2, PlaybackStateCompat.ACTION_PLAY_FROM_URI) == -1) {
            return -1L;
        }
        return this.jad_an.jad_an(jad_anVar, Math.min(j, this.jad_an.jad_bo));
    }

    @Override // com.jd.ad.sdk.jad_hk.jad_bo
    public long jad_an(jad_cp jad_cpVar) {
        if (this.jad_cp) {
            throw new IllegalStateException("closed");
        }
        long jMax = 0;
        while (true) {
            long jJad_an = this.jad_an.jad_an(jad_cpVar, jMax);
            if (jJad_an != -1) {
                return jJad_an;
            }
            jad_an jad_anVar = this.jad_an;
            long j = jad_anVar.jad_bo;
            if (this.jad_bo.jad_an(jad_anVar, PlaybackStateCompat.ACTION_PLAY_FROM_URI) == -1) {
                return -1L;
            }
            jMax = Math.max(jMax, j);
        }
    }

    @Override // com.jd.ad.sdk.jad_hk.jad_bo
    public jad_an jad_an() {
        return this.jad_an;
    }

    @Override // com.jd.ad.sdk.jad_hk.jad_bo
    public boolean jad_an(long j) {
        jad_an jad_anVar;
        if (j < 0) {
            throw new IllegalArgumentException("byteCount < 0: " + j);
        }
        if (this.jad_cp) {
            throw new IllegalStateException("closed");
        }
        do {
            jad_anVar = this.jad_an;
            if (jad_anVar.jad_bo >= j) {
                return true;
            }
        } while (this.jad_bo.jad_an(jad_anVar, PlaybackStateCompat.ACTION_PLAY_FROM_URI) != -1);
        return false;
    }

    public jad_bo jad_bo() {
        return new jad_iv(new jad_jt(this));
    }

    public byte jad_cp() throws EOFException {
        if (jad_an(1L)) {
            return this.jad_an.jad_bo();
        }
        throw new EOFException();
    }

    @Override // java.nio.channels.ReadableByteChannel
    public int read(ByteBuffer byteBuffer) {
        jad_an jad_anVar = this.jad_an;
        if (jad_anVar.jad_bo == 0 && this.jad_bo.jad_an(jad_anVar, PlaybackStateCompat.ACTION_PLAY_FROM_URI) == -1) {
            return -1;
        }
        return this.jad_an.read(byteBuffer);
    }

    public String toString() {
        return jad_pc.jad_an("buffer(").append(this.jad_bo).append(")").toString();
    }
}
