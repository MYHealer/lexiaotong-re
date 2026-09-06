package com.jd.ad.sdk.jad_it;

import android.util.Log;
import com.jd.ad.sdk.logger.Logger;
import com.meishu.sdk.core.view.gif.GifHeaderParser;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class jad_dq {
    public ByteBuffer jad_bo;
    public jad_cp jad_cp;
    public final byte[] jad_an = new byte[256];
    public int jad_dq = 0;

    public final boolean jad_an() {
        return this.jad_cp.jad_bo != 0;
    }

    public final int[] jad_an(int i) {
        byte[] bArr = new byte[i * 3];
        int[] iArr = null;
        try {
            this.jad_bo.get(bArr);
            iArr = new int[256];
            int i2 = 0;
            int i3 = 0;
            while (i2 < i) {
                int i4 = bArr[i3] & 255;
                int i5 = i3 + 2;
                int i6 = bArr[i3 + 1] & 255;
                i3 += 3;
                int i7 = i2 + 1;
                iArr[i2] = (i6 << 8) | (i4 << 16) | (-16777216) | (bArr[i5] & 255);
                i2 = i7;
            }
        } catch (BufferUnderflowException e) {
            if (Log.isLoggable(GifHeaderParser.TAG, 3)) {
                Logger.d(GifHeaderParser.TAG, "Format Error Reading Color Table", e);
            }
            this.jad_cp.jad_bo = 1;
        }
        return iArr;
    }

    public jad_cp jad_bo() {
        if (this.jad_bo == null) {
            throw new IllegalStateException("You must call setData() before parseHeader()");
        }
        if (jad_an()) {
            return this.jad_cp;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 6; i++) {
            sb.append((char) jad_cp());
        }
        if (sb.toString().startsWith("GIF")) {
            this.jad_cp.jad_fs = this.jad_bo.getShort();
            this.jad_cp.jad_jt = this.jad_bo.getShort();
            int iJad_cp = jad_cp();
            jad_cp jad_cpVar = this.jad_cp;
            jad_cpVar.jad_hu = (iJad_cp & 128) != 0;
            jad_cpVar.jad_iv = (int) Math.pow(2.0d, (iJad_cp & 7) + 1);
            this.jad_cp.jad_jw = jad_cp();
            jad_cp jad_cpVar2 = this.jad_cp;
            jad_cp();
            jad_cpVar2.getClass();
            if (this.jad_cp.jad_hu && !jad_an()) {
                jad_cp jad_cpVar3 = this.jad_cp;
                jad_cpVar3.jad_an = jad_an(jad_cpVar3.jad_iv);
                jad_cp jad_cpVar4 = this.jad_cp;
                jad_cpVar4.jad_kx = jad_cpVar4.jad_an[jad_cpVar4.jad_jw];
            }
        } else {
            this.jad_cp.jad_bo = 1;
        }
        if (!jad_an()) {
            boolean z = false;
            while (!z && !jad_an() && this.jad_cp.jad_cp <= Integer.MAX_VALUE) {
                int iJad_cp2 = jad_cp();
                if (iJad_cp2 == 33) {
                    int iJad_cp3 = jad_cp();
                    if (iJad_cp3 != 1) {
                        if (iJad_cp3 == 249) {
                            this.jad_cp.jad_dq = new jad_bo();
                            jad_cp();
                            int iJad_cp4 = jad_cp();
                            jad_bo jad_boVar = this.jad_cp.jad_dq;
                            int i2 = (iJad_cp4 & 28) >> 2;
                            jad_boVar.jad_jt = i2;
                            if (i2 == 0) {
                                jad_boVar.jad_jt = 1;
                            }
                            jad_boVar.jad_fs = (iJad_cp4 & 1) != 0;
                            short s = this.jad_bo.getShort();
                            if (s < 2) {
                                s = 10;
                            }
                            jad_bo jad_boVar2 = this.jad_cp.jad_dq;
                            jad_boVar2.jad_iv = s * 10;
                            jad_boVar2.jad_hu = jad_cp();
                            jad_cp();
                        } else if (iJad_cp3 != 254 && iJad_cp3 == 255) {
                            jad_dq();
                            StringBuilder sb2 = new StringBuilder();
                            for (int i3 = 0; i3 < 11; i3++) {
                                sb2.append((char) this.jad_an[i3]);
                            }
                            if (sb2.toString().equals("NETSCAPE2.0")) {
                                do {
                                    jad_dq();
                                    byte[] bArr = this.jad_an;
                                    if (bArr[0] == 1) {
                                        byte b = bArr[1];
                                        byte b2 = bArr[2];
                                        this.jad_cp.getClass();
                                    }
                                    if (this.jad_dq <= 0) {
                                        break;
                                    }
                                } while (!jad_an());
                            }
                        }
                    }
                    jad_er();
                } else if (iJad_cp2 == 44) {
                    jad_cp jad_cpVar5 = this.jad_cp;
                    if (jad_cpVar5.jad_dq == null) {
                        jad_cpVar5.jad_dq = new jad_bo();
                    }
                    jad_cpVar5.jad_dq.jad_an = this.jad_bo.getShort();
                    this.jad_cp.jad_dq.jad_bo = this.jad_bo.getShort();
                    this.jad_cp.jad_dq.jad_cp = this.jad_bo.getShort();
                    this.jad_cp.jad_dq.jad_dq = this.jad_bo.getShort();
                    int iJad_cp5 = jad_cp();
                    boolean z2 = (iJad_cp5 & 128) != 0;
                    int iPow = (int) Math.pow(2.0d, (iJad_cp5 & 7) + 1);
                    jad_bo jad_boVar3 = this.jad_cp.jad_dq;
                    jad_boVar3.jad_er = (iJad_cp5 & 64) != 0;
                    if (z2) {
                        jad_boVar3.jad_kx = jad_an(iPow);
                    } else {
                        jad_boVar3.jad_kx = null;
                    }
                    this.jad_cp.jad_dq.jad_jw = this.jad_bo.position();
                    jad_cp();
                    jad_er();
                    if (!jad_an()) {
                        jad_cp jad_cpVar6 = this.jad_cp;
                        jad_cpVar6.jad_cp++;
                        jad_cpVar6.jad_er.add(jad_cpVar6.jad_dq);
                    }
                } else if (iJad_cp2 != 59) {
                    this.jad_cp.jad_bo = 1;
                } else {
                    z = true;
                }
            }
            jad_cp jad_cpVar7 = this.jad_cp;
            if (jad_cpVar7.jad_cp < 0) {
                jad_cpVar7.jad_bo = 1;
            }
        }
        return this.jad_cp;
    }

    public final int jad_cp() {
        try {
            return this.jad_bo.get() & 255;
        } catch (Exception unused) {
            this.jad_cp.jad_bo = 1;
            return 0;
        }
    }

    public final void jad_dq() {
        int iJad_cp = jad_cp();
        this.jad_dq = iJad_cp;
        if (iJad_cp <= 0) {
            return;
        }
        int i = 0;
        int i2 = 0;
        while (true) {
            try {
                int i3 = this.jad_dq;
                if (i >= i3) {
                    return;
                }
                i2 = i3 - i;
                this.jad_bo.get(this.jad_an, i, i2);
                i += i2;
            } catch (Exception e) {
                if (Log.isLoggable(GifHeaderParser.TAG, 3)) {
                    Logger.d(GifHeaderParser.TAG, "Error Reading Block n: " + i + " count: " + i2 + " blockSize: " + this.jad_dq, e);
                }
                this.jad_cp.jad_bo = 1;
                return;
            }
        }
    }

    public final void jad_er() {
        int iJad_cp;
        do {
            iJad_cp = jad_cp();
            this.jad_bo.position(Math.min(this.jad_bo.position() + iJad_cp, this.jad_bo.limit()));
        } while (iJad_cp > 0);
    }
}
