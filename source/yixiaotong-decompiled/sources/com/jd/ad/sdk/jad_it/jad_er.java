package com.jd.ad.sdk.jad_it;

import android.graphics.Bitmap;
import android.util.Log;
import com.jd.ad.sdk.jad_gr.jad_ly;
import com.jd.ad.sdk.logger.Logger;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;
import java.util.Iterator;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class jad_er implements jad_an {
    public int[] jad_an;
    public final jad_an.InterfaceC0555jad_an jad_cp;
    public ByteBuffer jad_dq;
    public byte[] jad_er;
    public short[] jad_fs;
    public byte[] jad_hu;
    public byte[] jad_iv;
    public byte[] jad_jt;
    public int[] jad_jw;
    public int jad_kx;
    public Bitmap jad_mz;
    public boolean jad_na;
    public int jad_ob;
    public int jad_pc;
    public int jad_qd;
    public int jad_re;
    public Boolean jad_sf;
    public final int[] jad_bo = new int[256];
    public Bitmap.Config jad_tg = Bitmap.Config.ARGB_8888;
    public jad_cp jad_ly = new jad_cp();

    public jad_er(jad_an.InterfaceC0555jad_an interfaceC0555jad_an) {
        this.jad_cp = interfaceC0555jad_an;
    }

    @Override // com.jd.ad.sdk.jad_it.jad_an
    public void clear() {
        com.jd.ad.sdk.jad_ny.jad_bo jad_boVar;
        com.jd.ad.sdk.jad_ny.jad_bo jad_boVar2;
        com.jd.ad.sdk.jad_ny.jad_bo jad_boVar3;
        this.jad_ly = null;
        byte[] bArr = this.jad_iv;
        if (bArr != null && (jad_boVar3 = ((com.jd.ad.sdk.jad_xi.jad_bo) this.jad_cp).jad_bo) != null) {
            jad_boVar3.jad_an(bArr);
        }
        int[] iArr = this.jad_jw;
        if (iArr != null && (jad_boVar2 = ((com.jd.ad.sdk.jad_xi.jad_bo) this.jad_cp).jad_bo) != null) {
            jad_boVar2.jad_an(iArr);
        }
        Bitmap bitmap = this.jad_mz;
        if (bitmap != null) {
            ((com.jd.ad.sdk.jad_xi.jad_bo) this.jad_cp).jad_an.jad_an(bitmap);
        }
        this.jad_mz = null;
        this.jad_dq = null;
        this.jad_sf = null;
        byte[] bArr2 = this.jad_er;
        if (bArr2 == null || (jad_boVar = ((com.jd.ad.sdk.jad_xi.jad_bo) this.jad_cp).jad_bo) == null) {
            return;
        }
        jad_boVar.jad_an(bArr2);
    }

    @Override // com.jd.ad.sdk.jad_it.jad_an
    public int jad_an() {
        return this.jad_kx;
    }

    public void jad_an(Bitmap.Config config) {
        if (config != Bitmap.Config.ARGB_8888 && config != Bitmap.Config.RGB_565) {
            throw new IllegalArgumentException("Unsupported format: " + config + ", must be one of " + Bitmap.Config.ARGB_8888 + " or " + Bitmap.Config.RGB_565);
        }
        this.jad_tg = config;
    }

    public synchronized void jad_an(jad_cp jad_cpVar, ByteBuffer byteBuffer, int i) {
        try {
            if (i <= 0) {
                throw new IllegalArgumentException("Sample size must be >=0, not: " + i);
            }
            int iHighestOneBit = Integer.highestOneBit(i);
            this.jad_ob = 0;
            this.jad_ly = jad_cpVar;
            this.jad_kx = -1;
            ByteBuffer byteBufferAsReadOnlyBuffer = byteBuffer.asReadOnlyBuffer();
            this.jad_dq = byteBufferAsReadOnlyBuffer;
            byteBufferAsReadOnlyBuffer.position(0);
            this.jad_dq.order(ByteOrder.LITTLE_ENDIAN);
            this.jad_na = false;
            Iterator<jad_bo> it = jad_cpVar.jad_er.iterator();
            while (it.hasNext()) {
                if (it.next().jad_jt == 3) {
                    this.jad_na = true;
                    break;
                }
            }
            this.jad_pc = iHighestOneBit;
            int i2 = jad_cpVar.jad_fs;
            this.jad_re = i2 / iHighestOneBit;
            int i3 = jad_cpVar.jad_jt;
            this.jad_qd = i3 / iHighestOneBit;
            this.jad_iv = ((com.jd.ad.sdk.jad_xi.jad_bo) this.jad_cp).jad_an(i2 * i3);
            jad_an.InterfaceC0555jad_an interfaceC0555jad_an = this.jad_cp;
            int i4 = this.jad_re * this.jad_qd;
            com.jd.ad.sdk.jad_ny.jad_bo jad_boVar = ((com.jd.ad.sdk.jad_xi.jad_bo) interfaceC0555jad_an).jad_bo;
            this.jad_jw = jad_boVar == null ? new int[i4] : (int[]) jad_boVar.jad_an(i4, int[].class);
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // com.jd.ad.sdk.jad_it.jad_an
    public int jad_bo() {
        return this.jad_ly.jad_cp;
    }

    @Override // com.jd.ad.sdk.jad_it.jad_an
    public int jad_cp() {
        return (this.jad_jw.length * 4) + this.jad_dq.limit() + this.jad_iv.length;
    }

    @Override // com.jd.ad.sdk.jad_it.jad_an
    public int jad_dq() {
        int i;
        jad_cp jad_cpVar = this.jad_ly;
        int i2 = jad_cpVar.jad_cp;
        if (i2 <= 0 || (i = this.jad_kx) < 0) {
            return 0;
        }
        if (i < 0 || i >= i2) {
            return -1;
        }
        return jad_cpVar.jad_er.get(i).jad_iv;
    }

    @Override // com.jd.ad.sdk.jad_it.jad_an
    public ByteBuffer jad_er() {
        return this.jad_dq;
    }

    /* JADX WARN: Code duplicated, block: B:65:0x0103  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r14v21 */
    /* JADX WARN: Type inference failed for: r14v22 */
    /* JADX WARN: Type inference failed for: r14v23 */
    /* JADX WARN: Type inference failed for: r14v26, types: [short] */
    /* JADX WARN: Type inference failed for: r14v28 */
    @Override // com.jd.ad.sdk.jad_it.jad_an
    public synchronized Bitmap jad_fs() {
        byte b;
        int[] iArr;
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        byte[] bArr;
        int i7;
        int i8;
        short s;
        int i9;
        Bitmap bitmap;
        int i10;
        byte b2 = 0;
        if (this.jad_ly.jad_cp <= 0 || this.jad_kx < 0) {
            if (Log.isLoggable("StandardGifDecoder", 3)) {
                Logger.d("StandardGifDecoder", jad_ly.jad_an("Unable to decode frame, frameCount=").append(this.jad_ly.jad_cp).append(", framePointer=").append(this.jad_kx).toString());
            }
            this.jad_ob = 1;
        }
        int i11 = this.jad_ob;
        if (i11 != 1 && i11 != 2) {
            this.jad_ob = 0;
            byte b3 = 255;
            if (this.jad_er == null) {
                this.jad_er = ((com.jd.ad.sdk.jad_xi.jad_bo) this.jad_cp).jad_an(255);
            }
            jad_bo jad_boVar = this.jad_ly.jad_er.get(this.jad_kx);
            int i12 = this.jad_kx - 1;
            jad_bo jad_boVar2 = i12 >= 0 ? this.jad_ly.jad_er.get(i12) : null;
            int[] iArr2 = jad_boVar.jad_kx;
            if (iArr2 == null) {
                iArr2 = this.jad_ly.jad_an;
            }
            this.jad_an = iArr2;
            if (iArr2 == null) {
                if (Log.isLoggable("StandardGifDecoder", 3)) {
                    Logger.d("StandardGifDecoder", jad_ly.jad_an("No valid color table found for frame #").append(this.jad_kx).toString());
                }
                this.jad_ob = 1;
                return null;
            }
            if (jad_boVar.jad_fs) {
                System.arraycopy(iArr2, 0, this.jad_bo, 0, iArr2.length);
                int[] iArr3 = this.jad_bo;
                this.jad_an = iArr3;
                iArr3[jad_boVar.jad_hu] = 0;
                if (jad_boVar.jad_jt == 2 && this.jad_kx == 0) {
                    this.jad_sf = Boolean.TRUE;
                }
            }
            int[] iArr4 = this.jad_jw;
            if (jad_boVar2 == null) {
                Bitmap bitmap2 = this.jad_mz;
                if (bitmap2 != null) {
                    ((com.jd.ad.sdk.jad_xi.jad_bo) this.jad_cp).jad_an.jad_an(bitmap2);
                }
                this.jad_mz = null;
                Arrays.fill(iArr4, 0);
            }
            if (jad_boVar2 != null && jad_boVar2.jad_jt == 3 && this.jad_mz == null) {
                Arrays.fill(iArr4, 0);
            }
            if (jad_boVar2 != null && (i9 = jad_boVar2.jad_jt) > 0) {
                if (i9 == 2) {
                    if (jad_boVar.jad_fs) {
                        i10 = 0;
                    } else {
                        jad_cp jad_cpVar = this.jad_ly;
                        i10 = jad_cpVar.jad_kx;
                        if (jad_boVar.jad_kx != null && jad_cpVar.jad_jw == jad_boVar.jad_hu) {
                            i10 = 0;
                        }
                    }
                    int i13 = jad_boVar2.jad_dq;
                    int i14 = this.jad_pc;
                    int i15 = i13 / i14;
                    int i16 = jad_boVar2.jad_bo / i14;
                    int i17 = jad_boVar2.jad_cp / i14;
                    int i18 = jad_boVar2.jad_an / i14;
                    int i19 = this.jad_re;
                    int i20 = (i16 * i19) + i18;
                    int i21 = (i15 * i19) + i20;
                    while (i20 < i21) {
                        int i22 = i20 + i17;
                        for (int i23 = i20; i23 < i22; i23++) {
                            iArr4[i23] = i10;
                        }
                        i20 += this.jad_re;
                    }
                } else if (i9 == 3 && (bitmap = this.jad_mz) != null) {
                    int i24 = this.jad_re;
                    bitmap.getPixels(iArr4, 0, i24, 0, 0, i24, this.jad_qd);
                }
            }
            this.jad_dq.position(jad_boVar.jad_jw);
            int i25 = jad_boVar.jad_cp * jad_boVar.jad_dq;
            byte[] bArr2 = this.jad_iv;
            if (bArr2 == null || bArr2.length < i25) {
                this.jad_iv = ((com.jd.ad.sdk.jad_xi.jad_bo) this.jad_cp).jad_an(i25);
            }
            byte[] bArr3 = this.jad_iv;
            if (this.jad_fs == null) {
                this.jad_fs = new short[4096];
            }
            short[] sArr = this.jad_fs;
            if (this.jad_jt == null) {
                this.jad_jt = new byte[4096];
            }
            byte[] bArr4 = this.jad_jt;
            if (this.jad_hu == null) {
                this.jad_hu = new byte[4097];
            }
            byte[] bArr5 = this.jad_hu;
            int i26 = this.jad_dq.get() & 255;
            int i27 = 1 << i26;
            int i28 = i27 + 1;
            int i29 = i27 + 2;
            int i30 = i26 + 1;
            int i31 = (1 << i30) - 1;
            for (int i32 = 0; i32 < i27; i32++) {
                sArr[i32] = 0;
                bArr4[i32] = (byte) i32;
            }
            byte[] bArr6 = this.jad_er;
            int i33 = 0;
            int i34 = 0;
            int i35 = 0;
            int i36 = 0;
            int i37 = 0;
            int i38 = 0;
            int i39 = 0;
            int i40 = 0;
            int i41 = i30;
            int i42 = i29;
            int i43 = i31;
            int i44 = -1;
            while (true) {
                if (i33 >= i25) {
                    b = b2;
                    break;
                }
                if (i34 == 0) {
                    int i45 = this.jad_dq.get() & b3;
                    if (i45 > 0) {
                        ByteBuffer byteBuffer = this.jad_dq;
                        byteBuffer.get(this.jad_er, 0, Math.min(i45, byteBuffer.remaining()));
                    }
                    if (i45 <= 0) {
                        this.jad_ob = 3;
                        b = 0;
                        break;
                    }
                    i34 = i45;
                    i36 = 0;
                } else {
                    i33 = i33;
                    i30 = i30;
                }
                i35 += (bArr6[i36] & 255) << i37;
                i36++;
                i34--;
                i44 = i44;
                int i46 = i37 + 8;
                i39 = i39;
                int i47 = i42;
                i41 = i41;
                i33 = i33;
                while (true) {
                    if (i46 < i41) {
                        int i48 = i46;
                        i42 = i47;
                        i28 = i28;
                        b2 = 0;
                        b3 = 255;
                        i37 = i48;
                        break;
                    }
                    bArr6 = bArr6;
                    int i49 = i35 & i43;
                    i35 >>= i41;
                    i46 -= i41;
                    if (i49 == i27) {
                        i47 = i29;
                        i43 = i31;
                        i41 = i30;
                        i44 = -1;
                    } else {
                        if (i49 == i28) {
                            i37 = i46;
                            bArr6 = bArr6;
                            i42 = i47;
                            b3 = 255;
                            b2 = 0;
                            break;
                        }
                        int i50 = i28;
                        if (i44 == -1) {
                            bArr3[i38] = bArr4[i49];
                            i38++;
                            i33++;
                            i44 = i49;
                            i39 = i44;
                            i28 = i50;
                        } else {
                            int i51 = i47;
                            if (i49 >= i51) {
                                bArr5[i40] = (byte) i39;
                                i40++;
                                s = i44;
                            } else {
                                s = i49;
                            }
                            while (s >= i27) {
                                bArr5[i40] = bArr4[s];
                                i40++;
                                s = sArr[s];
                            }
                            i39 = bArr4[s] & 255;
                            byte b4 = (byte) i39;
                            bArr3[i38] = b4;
                            while (true) {
                                i38++;
                                i33++;
                                if (i40 <= 0) {
                                    break;
                                }
                                i40--;
                                bArr3[i38] = bArr5[i40];
                            }
                            if (i51 < 4096) {
                                sArr[i51] = (short) i44;
                                bArr4[i51] = b4;
                                int i52 = i51 + 1;
                                if ((i52 & i43) == 0 && i52 < 4096) {
                                    i41++;
                                    i43 += i52;
                                }
                                i47 = i52;
                            } else {
                                i47 = i51;
                            }
                            i46 = i46;
                            i28 = i50;
                            i44 = i49;
                        }
                    }
                }
            }
            Arrays.fill(bArr3, i38, i25, b);
            if (jad_boVar.jad_er || this.jad_pc != 1) {
                int[] iArr5 = this.jad_jw;
                int i53 = jad_boVar.jad_dq;
                int i54 = this.jad_pc;
                int i55 = i53 / i54;
                int i56 = jad_boVar.jad_bo / i54;
                int i57 = jad_boVar.jad_cp / i54;
                int i58 = jad_boVar.jad_an / i54;
                boolean z = this.jad_kx == 0;
                int i59 = this.jad_re;
                int i60 = this.jad_qd;
                byte[] bArr7 = this.jad_iv;
                int[] iArr6 = this.jad_an;
                iArr = iArr4;
                Boolean bool = this.jad_sf;
                int i61 = 8;
                int i62 = 0;
                int i63 = 0;
                int i64 = 1;
                while (i63 < i55) {
                    Boolean bool2 = bool;
                    if (jad_boVar.jad_er) {
                        if (i62 >= i55) {
                            int i65 = i64 + 1;
                            i = i55;
                            if (i65 == 2) {
                                i62 = 4;
                                i64 = i65;
                            } else if (i65 != 3) {
                                i64 = i65;
                                if (i65 == 4) {
                                    i62 = 1;
                                    i61 = 2;
                                }
                            } else {
                                i61 = 4;
                                i64 = i65;
                                i62 = 2;
                            }
                        } else {
                            i = i55;
                        }
                        i2 = i62 + i61;
                    } else {
                        i = i55;
                        i2 = i62;
                        i62 = i63;
                    }
                    int i66 = i62 + i56;
                    boolean z2 = i54 == 1;
                    if (i66 < i60) {
                        int i67 = i66 * i59;
                        int i68 = i67 + i58;
                        int i69 = i68 + i57;
                        int i70 = i67 + i59;
                        if (i70 < i69) {
                            i69 = i70;
                        }
                        int i71 = i63 * i54 * jad_boVar.jad_cp;
                        if (z2) {
                            bool = bool2;
                            int i72 = i68;
                            while (i72 < i69) {
                                int i73 = i57;
                                int i74 = i58;
                                int i75 = iArr6[bArr7[i71] & 255];
                                if (i75 != 0) {
                                    iArr5[i72] = i75;
                                } else if (z && bool == null) {
                                    bool = Boolean.TRUE;
                                }
                                i71 += i54;
                                i72++;
                                i57 = i73;
                                i58 = i74;
                            }
                            i3 = i57;
                            i4 = i58;
                        } else {
                            i3 = i57;
                            i4 = i58;
                            int i76 = ((i69 - i68) * i54) + i71;
                            bool = bool2;
                            int i77 = i68;
                            while (i77 < i69) {
                                int i78 = jad_boVar.jad_cp;
                                int i79 = i69;
                                int i80 = i71;
                                int i81 = i59;
                                int i82 = 0;
                                int i83 = 0;
                                int i84 = 0;
                                int i85 = 0;
                                int i86 = 0;
                                while (true) {
                                    if (i80 >= this.jad_pc + i71) {
                                        i7 = i60;
                                        break;
                                    }
                                    byte[] bArr8 = this.jad_iv;
                                    i7 = i60;
                                    if (i80 >= bArr8.length || i80 >= i76) {
                                        break;
                                    }
                                    int i87 = this.jad_an[bArr8[i80] & 255];
                                    if (i87 != 0) {
                                        i85 += (i87 >> 24) & 255;
                                        i84 += (i87 >> 16) & 255;
                                        i83 += (i87 >> 8) & 255;
                                        i82 += i87 & 255;
                                        i86++;
                                    }
                                    i80++;
                                    i60 = i7;
                                    bArr7 = bArr7;
                                }
                                byte[] bArr9 = bArr7;
                                int i88 = i78 + i71;
                                for (int i89 = i88; i89 < this.jad_pc + i88; i89++) {
                                    byte[] bArr10 = this.jad_iv;
                                    if (i89 >= bArr10.length || i89 >= i76) {
                                        break;
                                    }
                                    int i90 = this.jad_an[bArr10[i89] & 255];
                                    if (i90 != 0) {
                                        i85 += (i90 >> 24) & 255;
                                        i84 += (i90 >> 16) & 255;
                                        i83 += (i90 >> 8) & 255;
                                        i82 += i90 & 255;
                                        i86++;
                                    }
                                }
                                int i91 = i86 == 0 ? 0 : ((i85 / i86) << 24) | ((i84 / i86) << 16) | ((i83 / i86) << 8) | (i82 / i86);
                                if (i91 != 0) {
                                    iArr5[i77] = i91;
                                } else if (z && bool == null) {
                                    bool = Boolean.TRUE;
                                }
                                i71 += i54;
                                i77++;
                                i69 = i79;
                                i59 = i81;
                                i60 = i7;
                                bArr7 = bArr9;
                            }
                        }
                        i5 = i59;
                        i6 = i60;
                        bArr = bArr7;
                    } else {
                        i3 = i57;
                        i4 = i58;
                        i5 = i59;
                        i6 = i60;
                        bArr = bArr7;
                        bool = bool2;
                    }
                    i63++;
                    i55 = i;
                    i62 = i2;
                    i56 = i56;
                    i57 = i3;
                    i58 = i4;
                    i59 = i5;
                    i60 = i6;
                    bArr7 = bArr;
                }
                Boolean bool3 = bool;
                if (this.jad_sf == null) {
                    this.jad_sf = Boolean.valueOf(bool3 == null ? false : bool3.booleanValue());
                }
            } else {
                int[] iArr7 = this.jad_jw;
                int i92 = jad_boVar.jad_dq;
                int i93 = jad_boVar.jad_bo;
                int i94 = jad_boVar.jad_cp;
                int i95 = jad_boVar.jad_an;
                boolean z3 = this.jad_kx == 0;
                int i96 = this.jad_re;
                byte[] bArr11 = this.jad_iv;
                int[] iArr8 = this.jad_an;
                byte b5 = -1;
                int i97 = 0;
                while (i97 < i92) {
                    int i98 = (i97 + i93) * i96;
                    int i99 = i98 + i95;
                    int i100 = i92;
                    int i101 = i99 + i94;
                    int i102 = i98 + i96;
                    if (i102 < i101) {
                        i101 = i102;
                    }
                    int i103 = jad_boVar.jad_cp * i97;
                    while (i99 < i101) {
                        int i104 = i101;
                        byte b6 = bArr11[i103];
                        int i105 = i93;
                        int i106 = b6 & 255;
                        if (i106 != b5) {
                            int i107 = iArr8[i106];
                            if (i107 != 0) {
                                iArr7[i99] = i107;
                            } else {
                                b5 = b6;
                            }
                        }
                        i103++;
                        i99++;
                        i101 = i104;
                        i93 = i105;
                    }
                    i97++;
                    i92 = i100;
                }
                Boolean bool4 = this.jad_sf;
                this.jad_sf = Boolean.valueOf((bool4 != null && bool4.booleanValue()) || (this.jad_sf == null && z3 && b5 != -1));
                iArr = iArr4;
            }
            if (this.jad_na && ((i8 = jad_boVar.jad_jt) == 0 || i8 == 1)) {
                if (this.jad_mz == null) {
                    this.jad_mz = jad_hu();
                }
                Bitmap bitmap3 = this.jad_mz;
                int i108 = this.jad_re;
                bitmap3.setPixels(iArr, 0, i108, 0, 0, i108, this.jad_qd);
            }
            Bitmap bitmapJad_hu = jad_hu();
            int i109 = this.jad_re;
            bitmapJad_hu.setPixels(iArr, 0, i109, 0, 0, i109, this.jad_qd);
            return bitmapJad_hu;
        }
        if (Log.isLoggable("StandardGifDecoder", 3)) {
            Logger.d("StandardGifDecoder", jad_ly.jad_an("Unable to decode frame, status=").append(this.jad_ob).toString());
        }
        return null;
    }

    public final Bitmap jad_hu() {
        Boolean bool = this.jad_sf;
        Bitmap.Config config = (bool == null || bool.booleanValue()) ? Bitmap.Config.ARGB_8888 : this.jad_tg;
        Bitmap bitmapJad_bo = ((com.jd.ad.sdk.jad_xi.jad_bo) this.jad_cp).jad_an.jad_bo(this.jad_re, this.jad_qd, config);
        bitmapJad_bo.setHasAlpha(true);
        return bitmapJad_bo;
    }

    @Override // com.jd.ad.sdk.jad_it.jad_an
    public void jad_jt() {
        this.jad_kx = (this.jad_kx + 1) % this.jad_ly.jad_cp;
    }
}
