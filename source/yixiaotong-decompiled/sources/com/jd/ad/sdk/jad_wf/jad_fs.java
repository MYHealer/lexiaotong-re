package com.jd.ad.sdk.jad_wf;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.huawei.hms.ads.ez;
import com.jd.ad.sdk.jad_hk.jad_ob;
import com.jd.ad.sdk.jad_lu.jad_zm;
import cz.msebera.android.httpclient.message.BasicHeaderValueFormatter;
import java.io.EOFException;
import okio.internal.BufferKt;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public final class jad_fs extends jad_cp {
    public static final com.jd.ad.sdk.jad_hk.jad_cp jad_ly = com.jd.ad.sdk.jad_hk.jad_cp.jad_an("'\\");
    public static final com.jd.ad.sdk.jad_hk.jad_cp jad_mz = com.jd.ad.sdk.jad_hk.jad_cp.jad_an(BasicHeaderValueFormatter.UNSAFE_CHARS);
    public static final com.jd.ad.sdk.jad_hk.jad_cp jad_na = com.jd.ad.sdk.jad_hk.jad_cp.jad_an("{}[]:, \n\t\r\f/\\;#=");
    public static final com.jd.ad.sdk.jad_hk.jad_cp jad_ob = com.jd.ad.sdk.jad_hk.jad_cp.jad_an("\n\r");
    public static final com.jd.ad.sdk.jad_hk.jad_cp jad_pc = com.jd.ad.sdk.jad_hk.jad_cp.jad_an("*/");
    public final com.jd.ad.sdk.jad_hk.jad_bo jad_fs;
    public int jad_hu = 0;
    public long jad_iv;
    public final com.jd.ad.sdk.jad_hk.jad_an jad_jt;
    public int jad_jw;
    public String jad_kx;

    public jad_fs(com.jd.ad.sdk.jad_hk.jad_bo jad_boVar) {
        if (jad_boVar == null) {
            throw new NullPointerException("source == null");
        }
        this.jad_fs = jad_boVar;
        this.jad_jt = jad_boVar.jad_an();
        jad_an(6);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.jad_hu = 0;
        this.jad_bo[0] = 8;
        this.jad_an = 1;
        com.jd.ad.sdk.jad_hk.jad_an jad_anVar = this.jad_jt;
        jad_anVar.getClass();
        try {
            jad_anVar.jad_dq(jad_anVar.jad_bo);
            this.jad_fs.close();
        } catch (EOFException e) {
            throw new AssertionError(e);
        }
    }

    @Override // com.jd.ad.sdk.jad_wf.jad_cp
    public int jad_an(jad_cp.jad_an jad_anVar) throws jad_bo, EOFException {
        int iJad_qd = this.jad_hu;
        if (iJad_qd == 0) {
            iJad_qd = jad_qd();
        }
        if (iJad_qd < 12 || iJad_qd > 15) {
            return -1;
        }
        if (iJad_qd == 15) {
            return jad_an(this.jad_kx, jad_anVar);
        }
        int iJad_an = this.jad_fs.jad_an(jad_anVar.jad_bo);
        if (iJad_an != -1) {
            this.jad_hu = 0;
            this.jad_cp[this.jad_an - 1] = jad_anVar.jad_an[iJad_an];
            return iJad_an;
        }
        String str = this.jad_cp[this.jad_an - 1];
        String strJad_kx = jad_kx();
        int iJad_an2 = jad_an(strJad_kx, jad_anVar);
        if (iJad_an2 == -1) {
            this.jad_hu = 15;
            this.jad_kx = strJad_kx;
            this.jad_cp[this.jad_an - 1] = str;
        }
        return iJad_an2;
    }

    public final int jad_an(String str, jad_cp.jad_an jad_anVar) {
        int length = jad_anVar.jad_an.length;
        for (int i = 0; i < length; i++) {
            if (str.equals(jad_anVar.jad_an[i])) {
                this.jad_hu = 0;
                this.jad_cp[this.jad_an - 1] = str;
                return i;
            }
        }
        return -1;
    }

    public final int jad_an(boolean z) throws jad_bo, EOFException {
        int i = 0;
        while (true) {
            int i2 = i + 1;
            if (!this.jad_fs.jad_an(i2)) {
                if (z) {
                    throw new EOFException("End of input");
                }
                return -1;
            }
            byte bJad_bo = this.jad_jt.jad_bo(i);
            if (bJad_bo != 10 && bJad_bo != 32 && bJad_bo != 13 && bJad_bo != 9) {
                this.jad_jt.jad_dq(i);
                if (bJad_bo == 47) {
                    if (!this.jad_fs.jad_an(2L)) {
                        return bJad_bo;
                    }
                    jad_pc();
                    throw null;
                }
                if (bJad_bo != 35) {
                    return bJad_bo;
                }
                jad_pc();
                throw null;
            }
            i = i2;
        }
    }

    @Override // com.jd.ad.sdk.jad_wf.jad_cp
    public void jad_bo() throws jad_bo, EOFException {
        int iJad_qd = this.jad_hu;
        if (iJad_qd == 0) {
            iJad_qd = jad_qd();
        }
        if (iJad_qd != 3) {
            throw new jad_an(jad_er.jad_an(this, jad_zm.jad_an("Expected BEGIN_ARRAY but was ").append(jad_dq.jad_an(jad_mz())).append(" at path ")));
        }
        jad_an(1);
        this.jad_dq[this.jad_an - 1] = 0;
        this.jad_hu = 0;
    }

    public final boolean jad_bo(int i) throws jad_bo {
        if (i == 9 || i == 10 || i == 12 || i == 13 || i == 32) {
            return false;
        }
        if (i != 35) {
            if (i == 44) {
                return false;
            }
            if (i != 47 && i != 61) {
                if (i == 123 || i == 125 || i == 58) {
                    return false;
                }
                if (i != 59) {
                    switch (i) {
                        case MediaPlayer.MEDIA_PLAYER_OPTION_MEDIA_CODEC_AUTO_RECOVERY /* 91 */:
                        case MediaPlayer.MEDIA_PLAYER_OPTION_DECODER_DROP_FRAME /* 93 */:
                            return false;
                        case MediaPlayer.MEDIA_PLAYER_OPTION_OUTLET_DROP_FRAME_TYPE /* 92 */:
                            break;
                        default:
                            return true;
                    }
                }
            }
        }
        jad_pc();
        throw null;
    }

    @Override // com.jd.ad.sdk.jad_wf.jad_cp
    public void jad_cp() throws jad_bo, EOFException {
        int iJad_qd = this.jad_hu;
        if (iJad_qd == 0) {
            iJad_qd = jad_qd();
        }
        if (iJad_qd != 1) {
            throw new jad_an(jad_er.jad_an(this, jad_zm.jad_an("Expected BEGIN_OBJECT but was ").append(jad_dq.jad_an(jad_mz())).append(" at path ")));
        }
        jad_an(3);
        this.jad_hu = 0;
    }

    public final void jad_cp(com.jd.ad.sdk.jad_hk.jad_cp jad_cpVar) throws jad_bo, EOFException {
        while (true) {
            long jJad_an = this.jad_fs.jad_an(jad_cpVar);
            if (jJad_an == -1) {
                jad_an("Unterminated string");
                throw null;
            }
            if (this.jad_jt.jad_bo(jJad_an) != 92) {
                this.jad_jt.jad_dq(jJad_an + 1);
                return;
            } else {
                this.jad_jt.jad_dq(jJad_an + 1);
                jad_sf();
            }
        }
    }

    @Override // com.jd.ad.sdk.jad_wf.jad_cp
    public void jad_dq() throws jad_bo, EOFException {
        int iJad_qd = this.jad_hu;
        if (iJad_qd == 0) {
            iJad_qd = jad_qd();
        }
        if (iJad_qd != 4) {
            throw new jad_an(jad_er.jad_an(this, jad_zm.jad_an("Expected END_ARRAY but was ").append(jad_dq.jad_an(jad_mz())).append(" at path ")));
        }
        int i = this.jad_an;
        this.jad_an = i - 1;
        int[] iArr = this.jad_dq;
        int i2 = i - 2;
        iArr[i2] = iArr[i2] + 1;
        this.jad_hu = 0;
    }

    @Override // com.jd.ad.sdk.jad_wf.jad_cp
    public void jad_er() throws jad_bo, EOFException {
        int iJad_qd = this.jad_hu;
        if (iJad_qd == 0) {
            iJad_qd = jad_qd();
        }
        if (iJad_qd != 2) {
            throw new jad_an(jad_er.jad_an(this, jad_zm.jad_an("Expected END_OBJECT but was ").append(jad_dq.jad_an(jad_mz())).append(" at path ")));
        }
        int i = this.jad_an;
        int i2 = i - 1;
        this.jad_an = i2;
        this.jad_cp[i2] = null;
        int[] iArr = this.jad_dq;
        int i3 = i - 2;
        iArr[i3] = iArr[i3] + 1;
        this.jad_hu = 0;
    }

    @Override // com.jd.ad.sdk.jad_wf.jad_cp
    public boolean jad_hu() throws jad_bo, EOFException {
        int iJad_qd = this.jad_hu;
        if (iJad_qd == 0) {
            iJad_qd = jad_qd();
        }
        if (iJad_qd == 5) {
            this.jad_hu = 0;
            int[] iArr = this.jad_dq;
            int i = this.jad_an - 1;
            iArr[i] = iArr[i] + 1;
            return true;
        }
        if (iJad_qd != 6) {
            throw new jad_an(jad_er.jad_an(this, jad_zm.jad_an("Expected a boolean but was ").append(jad_dq.jad_an(jad_mz())).append(" at path ")));
        }
        this.jad_hu = 0;
        int[] iArr2 = this.jad_dq;
        int i2 = this.jad_an - 1;
        iArr2[i2] = iArr2[i2] + 1;
        return false;
    }

    @Override // com.jd.ad.sdk.jad_wf.jad_cp
    public double jad_iv() throws jad_bo, EOFException {
        String strJad_re;
        com.jd.ad.sdk.jad_hk.jad_cp jad_cpVar;
        double d;
        int iJad_qd = this.jad_hu;
        if (iJad_qd == 0) {
            iJad_qd = jad_qd();
        }
        if (iJad_qd == 16) {
            this.jad_hu = 0;
            int[] iArr = this.jad_dq;
            int i = this.jad_an - 1;
            iArr[i] = iArr[i] + 1;
            return this.jad_iv;
        }
        try {
            if (iJad_qd == 17) {
                com.jd.ad.sdk.jad_hk.jad_an jad_anVar = this.jad_jt;
                long j = this.jad_jw;
                jad_anVar.getClass();
                strJad_re = jad_anVar.jad_an(j, jad_ob.jad_an);
            } else {
                if (iJad_qd != 9) {
                    if (iJad_qd == 8) {
                        jad_cpVar = jad_ly;
                    } else if (iJad_qd == 10) {
                        strJad_re = jad_re();
                    } else if (iJad_qd != 11) {
                        throw new jad_an(jad_er.jad_an(this, jad_zm.jad_an("Expected a double but was ").append(jad_dq.jad_an(jad_mz())).append(" at path ")));
                    }
                    this.jad_hu = 11;
                    d = Double.parseDouble(this.jad_kx);
                    if (!Double.isNaN(d) || Double.isInfinite(d)) {
                        throw new jad_bo(jad_er.jad_an(this, new StringBuilder().append("JSON forbids NaN and infinities: ").append(d).append(" at path ")));
                    }
                    this.jad_kx = null;
                    this.jad_hu = 0;
                    int[] iArr2 = this.jad_dq;
                    int i2 = this.jad_an - 1;
                    iArr2[i2] = iArr2[i2] + 1;
                    return d;
                }
                jad_cpVar = jad_mz;
                strJad_re = jad_bo(jad_cpVar);
            }
            d = Double.parseDouble(this.jad_kx);
            if (Double.isNaN(d)) {
            }
            throw new jad_bo(jad_er.jad_an(this, new StringBuilder().append("JSON forbids NaN and infinities: ").append(d).append(" at path ")));
        } catch (NumberFormatException unused) {
            throw new jad_an(jad_er.jad_an(this, jad_zm.jad_an("Expected a double but was ").append(this.jad_kx).append(" at path ")));
        }
        this.jad_kx = strJad_re;
        this.jad_hu = 11;
    }

    @Override // com.jd.ad.sdk.jad_wf.jad_cp
    public boolean jad_jt() throws jad_bo, EOFException {
        int iJad_qd = this.jad_hu;
        if (iJad_qd == 0) {
            iJad_qd = jad_qd();
        }
        return (iJad_qd == 2 || iJad_qd == 4 || iJad_qd == 18) ? false : true;
    }

    @Override // com.jd.ad.sdk.jad_wf.jad_cp
    public int jad_jw() throws jad_bo, EOFException {
        int iJad_qd = this.jad_hu;
        if (iJad_qd == 0) {
            iJad_qd = jad_qd();
        }
        if (iJad_qd == 16) {
            long j = this.jad_iv;
            int i = (int) j;
            if (j != i) {
                throw new jad_an(jad_er.jad_an(this, jad_zm.jad_an("Expected an int but was ").append(this.jad_iv).append(" at path ")));
            }
            this.jad_hu = 0;
            int[] iArr = this.jad_dq;
            int i2 = this.jad_an - 1;
            iArr[i2] = iArr[i2] + 1;
            return i;
        }
        if (iJad_qd == 17) {
            com.jd.ad.sdk.jad_hk.jad_an jad_anVar = this.jad_jt;
            long j2 = this.jad_jw;
            jad_anVar.getClass();
            this.jad_kx = jad_anVar.jad_an(j2, jad_ob.jad_an);
        } else if (iJad_qd == 9 || iJad_qd == 8) {
            String strJad_bo = jad_bo(iJad_qd == 9 ? jad_mz : jad_ly);
            this.jad_kx = strJad_bo;
            try {
                int i3 = Integer.parseInt(strJad_bo);
                this.jad_hu = 0;
                int[] iArr2 = this.jad_dq;
                int i4 = this.jad_an - 1;
                iArr2[i4] = iArr2[i4] + 1;
                return i3;
            } catch (NumberFormatException unused) {
            }
        } else if (iJad_qd != 11) {
            throw new jad_an(jad_er.jad_an(this, jad_zm.jad_an("Expected an int but was ").append(jad_dq.jad_an(jad_mz())).append(" at path ")));
        }
        this.jad_hu = 11;
        try {
            double d = Double.parseDouble(this.jad_kx);
            int i5 = (int) d;
            if (i5 != d) {
                throw new jad_an(jad_er.jad_an(this, jad_zm.jad_an("Expected an int but was ").append(this.jad_kx).append(" at path ")));
            }
            this.jad_kx = null;
            this.jad_hu = 0;
            int[] iArr3 = this.jad_dq;
            int i6 = this.jad_an - 1;
            iArr3[i6] = iArr3[i6] + 1;
            return i5;
        } catch (NumberFormatException unused2) {
            throw new jad_an(jad_er.jad_an(this, jad_zm.jad_an("Expected an int but was ").append(this.jad_kx).append(" at path ")));
        }
    }

    @Override // com.jd.ad.sdk.jad_wf.jad_cp
    public String jad_kx() throws jad_bo, EOFException {
        String strJad_bo;
        com.jd.ad.sdk.jad_hk.jad_cp jad_cpVar;
        int iJad_qd = this.jad_hu;
        if (iJad_qd == 0) {
            iJad_qd = jad_qd();
        }
        if (iJad_qd == 14) {
            strJad_bo = jad_re();
        } else {
            if (iJad_qd == 13) {
                jad_cpVar = jad_mz;
            } else if (iJad_qd == 12) {
                jad_cpVar = jad_ly;
            } else {
                if (iJad_qd != 15) {
                    throw new jad_an(jad_er.jad_an(this, jad_zm.jad_an("Expected a name but was ").append(jad_dq.jad_an(jad_mz())).append(" at path ")));
                }
                strJad_bo = this.jad_kx;
            }
            strJad_bo = jad_bo(jad_cpVar);
        }
        this.jad_hu = 0;
        this.jad_cp[this.jad_an - 1] = strJad_bo;
        return strJad_bo;
    }

    @Override // com.jd.ad.sdk.jad_wf.jad_cp
    public String jad_ly() throws jad_bo, EOFException {
        String strJad_an;
        com.jd.ad.sdk.jad_hk.jad_cp jad_cpVar;
        int iJad_qd = this.jad_hu;
        if (iJad_qd == 0) {
            iJad_qd = jad_qd();
        }
        if (iJad_qd == 10) {
            strJad_an = jad_re();
        } else {
            if (iJad_qd == 9) {
                jad_cpVar = jad_mz;
            } else if (iJad_qd == 8) {
                jad_cpVar = jad_ly;
            } else if (iJad_qd == 11) {
                strJad_an = this.jad_kx;
                this.jad_kx = null;
            } else if (iJad_qd == 16) {
                strJad_an = Long.toString(this.jad_iv);
            } else {
                if (iJad_qd != 17) {
                    throw new jad_an(jad_er.jad_an(this, jad_zm.jad_an("Expected a string but was ").append(jad_dq.jad_an(jad_mz())).append(" at path ")));
                }
                com.jd.ad.sdk.jad_hk.jad_an jad_anVar = this.jad_jt;
                long j = this.jad_jw;
                jad_anVar.getClass();
                strJad_an = jad_anVar.jad_an(j, jad_ob.jad_an);
            }
            strJad_an = jad_bo(jad_cpVar);
        }
        this.jad_hu = 0;
        int[] iArr = this.jad_dq;
        int i = this.jad_an - 1;
        iArr[i] = iArr[i] + 1;
        return strJad_an;
    }

    @Override // com.jd.ad.sdk.jad_wf.jad_cp
    public int jad_mz() throws jad_bo, EOFException {
        int iJad_qd = this.jad_hu;
        if (iJad_qd == 0) {
            iJad_qd = jad_qd();
        }
        switch (iJad_qd) {
            case 1:
                return 3;
            case 2:
                return 4;
            case 3:
                return 1;
            case 4:
                return 2;
            case 5:
            case 6:
                return 8;
            case 7:
                return 9;
            case 8:
            case 9:
            case 10:
            case 11:
                return 6;
            case 12:
            case 13:
            case 14:
            case 15:
                return 5;
            case 16:
            case 17:
                return 7;
            case 18:
                return 10;
            default:
                throw new AssertionError();
        }
    }

    @Override // com.jd.ad.sdk.jad_wf.jad_cp
    public void jad_na() throws jad_bo, EOFException {
        com.jd.ad.sdk.jad_hk.jad_cp jad_cpVar;
        int iJad_qd = this.jad_hu;
        if (iJad_qd == 0) {
            iJad_qd = jad_qd();
        }
        if (iJad_qd == 14) {
            jad_tg();
        } else {
            if (iJad_qd == 13) {
                jad_cpVar = jad_mz;
            } else if (iJad_qd == 12) {
                jad_cpVar = jad_ly;
            } else if (iJad_qd != 15) {
                throw new jad_an(jad_er.jad_an(this, jad_zm.jad_an("Expected a name but was ").append(jad_dq.jad_an(jad_mz())).append(" at path ")));
            }
            jad_cp(jad_cpVar);
        }
        this.jad_hu = 0;
        this.jad_cp[this.jad_an - 1] = "null";
    }

    @Override // com.jd.ad.sdk.jad_wf.jad_cp
    public void jad_ob() throws jad_bo, EOFException {
        com.jd.ad.sdk.jad_hk.jad_cp jad_cpVar;
        int i = 0;
        do {
            int iJad_qd = this.jad_hu;
            if (iJad_qd == 0) {
                iJad_qd = jad_qd();
            }
            if (iJad_qd == 3) {
                jad_an(1);
            } else {
                if (iJad_qd == 1) {
                    jad_an(3);
                } else {
                    if (iJad_qd == 4) {
                        i--;
                        if (i < 0) {
                            throw new jad_an(jad_er.jad_an(this, jad_zm.jad_an("Expected a value but was ").append(jad_dq.jad_an(jad_mz())).append(" at path ")));
                        }
                    } else if (iJad_qd == 2) {
                        i--;
                        if (i < 0) {
                            throw new jad_an(jad_er.jad_an(this, jad_zm.jad_an("Expected a value but was ").append(jad_dq.jad_an(jad_mz())).append(" at path ")));
                        }
                    } else if (iJad_qd == 14 || iJad_qd == 10) {
                        jad_tg();
                    } else {
                        if (iJad_qd == 9 || iJad_qd == 13) {
                            jad_cpVar = jad_mz;
                        } else if (iJad_qd == 8 || iJad_qd == 12) {
                            jad_cpVar = jad_ly;
                        } else if (iJad_qd == 17) {
                            this.jad_jt.jad_dq(this.jad_jw);
                        } else if (iJad_qd == 18) {
                            throw new jad_an(jad_er.jad_an(this, jad_zm.jad_an("Expected a value but was ").append(jad_dq.jad_an(jad_mz())).append(" at path ")));
                        }
                        jad_cp(jad_cpVar);
                    }
                    this.jad_an--;
                }
                this.jad_hu = 0;
            }
            i++;
            this.jad_hu = 0;
        } while (i != 0);
        int[] iArr = this.jad_dq;
        int i2 = this.jad_an - 1;
        iArr[i2] = iArr[i2] + 1;
        this.jad_cp[i2] = "null";
    }

    public final void jad_pc() throws jad_bo {
        jad_an("Use JsonReader.setLenient(true) to accept malformed JSON");
        throw null;
    }

    /* JADX WARN: Code duplicated, block: B:143:0x01bb A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:144:0x01bd  */
    /* JADX WARN: Code duplicated, block: B:159:0x01db  */
    /* JADX WARN: Code duplicated, block: B:161:0x01e0  */
    /* JADX WARN: Code duplicated, block: B:164:0x01e5  */
    /* JADX WARN: Code duplicated, block: B:170:0x01f8 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:171:0x01f9  */
    /* JADX WARN: Code duplicated, block: B:173:0x0207  */
    /* JADX WARN: Code duplicated, block: B:175:0x020b  */
    /* JADX WARN: Code duplicated, block: B:231:0x01f5 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:232:0x0198 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:83:0x0116 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:84:0x0117  */
    /* JADX WARN: Code duplicated, block: B:88:0x012b  */
    /* JADX WARN: Code duplicated, block: B:90:0x0136  */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final int jad_qd() throws jad_bo, EOFException {
        int i;
        String str;
        String str2;
        int i2;
        byte bJad_bo;
        boolean z;
        char c;
        int i3;
        int i4;
        boolean z2;
        int i5;
        byte bJad_bo2;
        char c2;
        int[] iArr = this.jad_bo;
        boolean z3 = true;
        int i6 = this.jad_an - 1;
        int i7 = iArr[i6];
        if (i7 == 1) {
            iArr[i6] = 2;
        } else if (i7 == 2) {
            int iJad_an = jad_an(true);
            this.jad_jt.jad_bo();
            if (iJad_an != 44) {
                if (iJad_an != 59) {
                    if (iJad_an == 93) {
                        this.jad_hu = 4;
                        return 4;
                    }
                    jad_an("Unterminated array");
                    throw null;
                }
                jad_pc();
                throw null;
            }
        } else {
            if (i7 == 3 || i7 == 5) {
                iArr[i6] = 4;
                if (i7 == 5) {
                    int iJad_an2 = jad_an(true);
                    this.jad_jt.jad_bo();
                    if (iJad_an2 != 44) {
                        if (iJad_an2 == 59) {
                            jad_pc();
                            throw null;
                        }
                        if (iJad_an2 == 125) {
                            this.jad_hu = 2;
                            return 2;
                        }
                        jad_an("Unterminated object");
                        throw null;
                    }
                }
                int iJad_an3 = jad_an(true);
                if (iJad_an3 == 34) {
                    this.jad_jt.jad_bo();
                    this.jad_hu = 13;
                    return 13;
                }
                if (iJad_an3 == 39) {
                    this.jad_jt.jad_bo();
                    jad_pc();
                    throw null;
                }
                if (iJad_an3 != 125) {
                    jad_pc();
                    throw null;
                }
                if (i7 == 5) {
                    jad_an("Expected name");
                    throw null;
                }
                this.jad_jt.jad_bo();
                this.jad_hu = 2;
                return 2;
            }
            if (i7 == 4) {
                iArr[i6] = 5;
                int iJad_an4 = jad_an(true);
                this.jad_jt.jad_bo();
                if (iJad_an4 != 58) {
                    if (iJad_an4 == 61) {
                        jad_pc();
                        throw null;
                    }
                    jad_an("Expected ':'");
                    throw null;
                }
            } else if (i7 == 6) {
                iArr[i6] = 7;
            } else {
                if (i7 == 7) {
                    if (jad_an(false) == -1) {
                        this.jad_hu = 18;
                        return 18;
                    }
                    jad_pc();
                    throw null;
                }
                if (i7 == 8) {
                    throw new IllegalStateException("JsonReader is closed");
                }
            }
        }
        int iJad_an5 = jad_an(true);
        if (iJad_an5 == 34) {
            this.jad_jt.jad_bo();
            this.jad_hu = 9;
            return 9;
        }
        if (iJad_an5 == 39) {
            jad_pc();
            throw null;
        }
        if (iJad_an5 == 44 || iJad_an5 == 59) {
            i = 1;
        } else {
            if (iJad_an5 == 91) {
                this.jad_jt.jad_bo();
                this.jad_hu = 3;
                return 3;
            }
            if (iJad_an5 != 93) {
                if (iJad_an5 == 123) {
                    this.jad_jt.jad_bo();
                    this.jad_hu = 1;
                    return 1;
                }
                long j = 0;
                byte bJad_bo3 = this.jad_jt.jad_bo(0L);
                if (bJad_bo3 == 116 || bJad_bo3 == 84) {
                    str = ez.Code;
                    str2 = "TRUE";
                    i2 = 5;
                } else {
                    if (bJad_bo3 != 102 && bJad_bo3 != 70) {
                        if (bJad_bo3 != 110 && bJad_bo3 != 78) {
                            i2 = 0;
                            break;
                        }
                        str = "null";
                        str2 = "NULL";
                        i2 = 7;
                        if (i2 != 0) {
                            return i2;
                        }
                        z = true;
                        long j2 = 0;
                        c = 0;
                        i3 = 0;
                        boolean z4 = false;
                        while (true) {
                            i4 = i3 + 1;
                            z2 = z;
                            if (this.jad_fs.jad_an(i4)) {
                                bJad_bo2 = this.jad_jt.jad_bo(i3);
                                if (bJad_bo2 != 43) {
                                    if (bJad_bo2 != 69 || bJad_bo2 == 101) {
                                        c2 = 6;
                                        if (c != 2 || c == 4) {
                                            c = 5;
                                            i3 = i4;
                                            z = z2;
                                            z3 = true;
                                            j = 0;
                                        } else {
                                            i5 = 0;
                                        }
                                    } else if (bJad_bo2 == 45) {
                                        c2 = 6;
                                        if (c == 0) {
                                            c = 1;
                                            z4 = true;
                                        } else {
                                            if (c != 5) {
                                                i5 = 0;
                                            }
                                            c = c2;
                                        }
                                        i3 = i4;
                                        z = z2;
                                        z3 = true;
                                        j = 0;
                                    } else if (bJad_bo2 != 46) {
                                        if (bJad_bo2 >= 48 && bJad_bo2 <= 57) {
                                            if (c == z3 || c == 0) {
                                                c2 = 6;
                                                j2 = -(bJad_bo2 - 48);
                                                c = 2;
                                            } else {
                                                if (c == 2) {
                                                    if (j2 != j) {
                                                        long j3 = (10 * j2) - ((long) (bJad_bo2 - 48));
                                                        z2 &= j2 > BufferKt.OVERFLOW_ZONE || (j2 == BufferKt.OVERFLOW_ZONE && j3 < j2);
                                                        j2 = j3;
                                                    }
                                                } else if (c == 3) {
                                                    c = 4;
                                                } else {
                                                    c2 = 6;
                                                    if (c == 5 || c == 6) {
                                                        c = 7;
                                                    }
                                                }
                                                c2 = 6;
                                            }
                                            i3 = i4;
                                            z = z2;
                                            z3 = true;
                                            j = 0;
                                        } else if (!jad_bo(bJad_bo2)) {
                                        }
                                        i5 = 0;
                                    } else {
                                        c2 = 6;
                                        if (c == 2) {
                                            c = 3;
                                            i3 = i4;
                                            z = z2;
                                            z3 = true;
                                            j = 0;
                                        } else {
                                            i5 = 0;
                                        }
                                    }
                                    if (i5 != 0) {
                                        return i5;
                                    }
                                    if (jad_bo(this.jad_jt.jad_bo(0L))) {
                                        jad_pc();
                                        throw null;
                                    }
                                    jad_an("Expected value");
                                    throw null;
                                }
                                c2 = 6;
                                if (c != 5) {
                                    i5 = 0;
                                    if (i5 != 0) {
                                        return i5;
                                    }
                                    if (jad_bo(this.jad_jt.jad_bo(0L))) {
                                        jad_pc();
                                        throw null;
                                    }
                                    jad_an("Expected value");
                                    throw null;
                                }
                                c = c2;
                                i3 = i4;
                                z = z2;
                                z3 = true;
                                j = 0;
                            }
                            if (c == 2 || !z2 || ((j2 == Long.MIN_VALUE && !z4) || (j2 == 0 && z4))) {
                                if (c != 2 || c == 4 || c == 7) {
                                    this.jad_jw = i3;
                                    i5 = 17;
                                } else {
                                    i5 = 0;
                                }
                                if (i5 != 0) {
                                    return i5;
                                }
                                if (jad_bo(this.jad_jt.jad_bo(0L))) {
                                    jad_pc();
                                    throw null;
                                }
                                jad_an("Expected value");
                                throw null;
                            }
                            if (!z4) {
                                j2 = -j2;
                            }
                            this.jad_iv = j2;
                            this.jad_jt.jad_dq(i3);
                            i5 = 16;
                            this.jad_hu = i5;
                            if (i5 != 0) {
                                return i5;
                            }
                            if (jad_bo(this.jad_jt.jad_bo(0L))) {
                                jad_pc();
                                throw null;
                            }
                            jad_an("Expected value");
                            throw null;
                        }
                    }
                    str = ez.V;
                    str2 = "FALSE";
                    i2 = 6;
                }
                int length = str.length();
                int i8 = 1;
                while (true) {
                    if (i8 >= length) {
                        if (!this.jad_fs.jad_an(length + 1) || !jad_bo(this.jad_jt.jad_bo(length))) {
                            this.jad_jt.jad_dq(length);
                            this.jad_hu = i2;
                            break;
                        }
                    } else {
                        int i9 = i8 + 1;
                        if (this.jad_fs.jad_an(i9) && ((bJad_bo = this.jad_jt.jad_bo(i8)) == str.charAt(i8) || bJad_bo == str2.charAt(i8))) {
                            i8 = i9;
                        }
                    }
                    i2 = 0;
                    break;
                }
                if (i2 != 0) {
                    return i2;
                }
                z = true;
                long j4 = 0;
                c = 0;
                i3 = 0;
                boolean z5 = false;
                while (true) {
                    i4 = i3 + 1;
                    z2 = z;
                    if (this.jad_fs.jad_an(i4)) {
                        bJad_bo2 = this.jad_jt.jad_bo(i3);
                        if (bJad_bo2 != 43) {
                            if (bJad_bo2 != 69) {
                                c2 = 6;
                                if (c != 2) {
                                }
                                c = 5;
                                i3 = i4;
                                z = z2;
                                z3 = true;
                                j = 0;
                            } else {
                                c2 = 6;
                                if (c != 2) {
                                }
                                c = 5;
                                i3 = i4;
                                z = z2;
                                z3 = true;
                                j = 0;
                            }
                            if (i5 != 0) {
                                return i5;
                            }
                            if (jad_bo(this.jad_jt.jad_bo(0L))) {
                                jad_pc();
                                throw null;
                            }
                            jad_an("Expected value");
                            throw null;
                        }
                        c2 = 6;
                        if (c != 5) {
                            i5 = 0;
                            if (i5 != 0) {
                                return i5;
                            }
                            if (jad_bo(this.jad_jt.jad_bo(0L))) {
                                jad_pc();
                                throw null;
                            }
                            jad_an("Expected value");
                            throw null;
                        }
                        c = c2;
                        i3 = i4;
                        z = z2;
                        z3 = true;
                        j = 0;
                    }
                    if (c == 2) {
                        if (c != 2) {
                        }
                        this.jad_jw = i3;
                        i5 = 17;
                    } else {
                        if (c != 2) {
                        }
                        this.jad_jw = i3;
                        i5 = 17;
                    }
                    this.jad_hu = i5;
                    if (i5 != 0) {
                        return i5;
                    }
                    if (jad_bo(this.jad_jt.jad_bo(0L))) {
                        jad_pc();
                        throw null;
                    }
                    jad_an("Expected value");
                    throw null;
                }
            }
            i = 1;
            if (i7 == 1) {
                this.jad_jt.jad_bo();
                this.jad_hu = 4;
                return 4;
            }
        }
        if (i7 == i || i7 == 2) {
            jad_pc();
            throw null;
        }
        jad_an("Unexpected value");
        throw null;
    }

    public final String jad_re() {
        long jJad_an = this.jad_fs.jad_an(jad_na);
        if (jJad_an != -1) {
            com.jd.ad.sdk.jad_hk.jad_an jad_anVar = this.jad_jt;
            jad_anVar.getClass();
            return jad_anVar.jad_an(jJad_an, jad_ob.jad_an);
        }
        com.jd.ad.sdk.jad_hk.jad_an jad_anVar2 = this.jad_jt;
        jad_anVar2.getClass();
        try {
            return jad_anVar2.jad_an(jad_anVar2.jad_bo, jad_ob.jad_an);
        } catch (EOFException e) {
            throw new AssertionError(e);
        }
    }

    public final char jad_sf() throws jad_bo, EOFException {
        int i;
        if (!this.jad_fs.jad_an(1L)) {
            jad_an("Unterminated escape sequence");
            throw null;
        }
        byte bJad_bo = this.jad_jt.jad_bo();
        if (bJad_bo == 10 || bJad_bo == 34 || bJad_bo == 39 || bJad_bo == 47 || bJad_bo == 92) {
            return (char) bJad_bo;
        }
        if (bJad_bo == 98) {
            return '\b';
        }
        if (bJad_bo == 102) {
            return '\f';
        }
        if (bJad_bo == 110) {
            return '\n';
        }
        if (bJad_bo == 114) {
            return '\r';
        }
        if (bJad_bo == 116) {
            return '\t';
        }
        if (bJad_bo != 117) {
            jad_an(jad_zm.jad_an("Invalid escape sequence: \\").append((char) bJad_bo).toString());
            throw null;
        }
        if (!this.jad_fs.jad_an(4L)) {
            throw new EOFException(jad_er.jad_an(this, jad_zm.jad_an("Unterminated escape sequence at path ")));
        }
        char c = 0;
        for (int i2 = 0; i2 < 4; i2++) {
            byte bJad_bo2 = this.jad_jt.jad_bo(i2);
            char c2 = (char) (c << 4);
            if (bJad_bo2 >= 48 && bJad_bo2 <= 57) {
                i = bJad_bo2 - 48;
            } else if (bJad_bo2 >= 97 && bJad_bo2 <= 102) {
                i = bJad_bo2 - 87;
            } else {
                if (bJad_bo2 < 65 || bJad_bo2 > 70) {
                    StringBuilder sbJad_an = jad_zm.jad_an("\\u");
                    com.jd.ad.sdk.jad_hk.jad_an jad_anVar = this.jad_jt;
                    jad_anVar.getClass();
                    jad_an(sbJad_an.append(jad_anVar.jad_an(4L, jad_ob.jad_an)).toString());
                    throw null;
                }
                i = bJad_bo2 - 55;
            }
            c = (char) (i + c2);
        }
        this.jad_jt.jad_dq(4L);
        return c;
    }

    public final void jad_tg() throws EOFException {
        long jJad_an = this.jad_fs.jad_an(jad_na);
        com.jd.ad.sdk.jad_hk.jad_an jad_anVar = this.jad_jt;
        if (jJad_an == -1) {
            jJad_an = jad_anVar.jad_bo;
        }
        jad_anVar.jad_dq(jJad_an);
    }

    public String toString() {
        return jad_zm.jad_an("JsonReader(").append(this.jad_fs).append(")").toString();
    }

    public final String jad_bo(com.jd.ad.sdk.jad_hk.jad_cp jad_cpVar) throws jad_bo {
        StringBuilder sb = null;
        while (true) {
            long jJad_an = this.jad_fs.jad_an(jad_cpVar);
            if (jJad_an == -1) {
                jad_an("Unterminated string");
                throw null;
            }
            if (this.jad_jt.jad_bo(jJad_an) != 92) {
                if (sb == null) {
                    com.jd.ad.sdk.jad_hk.jad_an jad_anVar = this.jad_jt;
                    jad_anVar.getClass();
                    String strJad_an = jad_anVar.jad_an(jJad_an, jad_ob.jad_an);
                    this.jad_jt.jad_bo();
                    return strJad_an;
                }
                com.jd.ad.sdk.jad_hk.jad_an jad_anVar2 = this.jad_jt;
                jad_anVar2.getClass();
                sb.append(jad_anVar2.jad_an(jJad_an, jad_ob.jad_an));
                this.jad_jt.jad_bo();
                return sb.toString();
            }
            if (sb == null) {
                sb = new StringBuilder();
            }
            com.jd.ad.sdk.jad_hk.jad_an jad_anVar3 = this.jad_jt;
            jad_anVar3.getClass();
            sb.append(jad_anVar3.jad_an(jJad_an, jad_ob.jad_an));
            this.jad_jt.jad_bo();
            sb.append(jad_sf());
        }
    }
}
