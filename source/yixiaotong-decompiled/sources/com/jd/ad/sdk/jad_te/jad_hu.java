package com.jd.ad.sdk.jad_te;

import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.jd.ad.sdk.logger.Logger;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public final class jad_hu implements com.jd.ad.sdk.jad_ju.jad_fs {
    public static final byte[] jad_an = "Exif\u0000\u0000".getBytes(Charset.forName("UTF-8"));
    public static final int[] jad_bo = {0, 1, 1, 2, 4, 8, 1, 1, 2, 4, 8, 4, 8};

    public static final class jad_an implements jad_cp {
        public final ByteBuffer jad_an;

        public jad_an(ByteBuffer byteBuffer) {
            this.jad_an = byteBuffer;
            byteBuffer.order(ByteOrder.BIG_ENDIAN);
        }

        @Override // com.jd.ad.sdk.jad_te.jad_hu.jad_cp
        public int jad_an(byte[] bArr, int i) {
            int iMin = Math.min(i, this.jad_an.remaining());
            if (iMin == 0) {
                return -1;
            }
            this.jad_an.get(bArr, 0, iMin);
            return iMin;
        }

        @Override // com.jd.ad.sdk.jad_te.jad_hu.jad_cp
        public long jad_an(long j) {
            int iMin = (int) Math.min(this.jad_an.remaining(), j);
            ByteBuffer byteBuffer = this.jad_an;
            byteBuffer.position(byteBuffer.position() + iMin);
            return iMin;
        }

        @Override // com.jd.ad.sdk.jad_te.jad_hu.jad_cp
        public short jad_an() throws jad_cp.jad_an {
            if (this.jad_an.remaining() >= 1) {
                return (short) (this.jad_an.get() & 255);
            }
            throw new jad_cp.jad_an();
        }

        @Override // com.jd.ad.sdk.jad_te.jad_hu.jad_cp
        public int jad_bo() {
            return (jad_an() << 8) | jad_an();
        }
    }

    public static final class jad_bo {
        public final ByteBuffer jad_an;

        public jad_bo(byte[] bArr, int i) {
            this.jad_an = (ByteBuffer) ByteBuffer.wrap(bArr).order(ByteOrder.BIG_ENDIAN).limit(i);
        }

        public short jad_an(int i) {
            if (this.jad_an.remaining() - i >= 2) {
                return this.jad_an.getShort(i);
            }
            return (short) -1;
        }

        public int jad_bo(int i) {
            if (this.jad_an.remaining() - i >= 4) {
                return this.jad_an.getInt(i);
            }
            return -1;
        }
    }

    public interface jad_cp {

        public static final class jad_an extends IOException {
            public jad_an() {
                super("Unexpectedly reached end of a file");
            }
        }

        int jad_an(byte[] bArr, int i);

        long jad_an(long j);

        short jad_an();

        int jad_bo();
    }

    public static final class jad_dq implements jad_cp {
        public final InputStream jad_an;

        public jad_dq(InputStream inputStream) {
            this.jad_an = inputStream;
        }

        @Override // com.jd.ad.sdk.jad_te.jad_hu.jad_cp
        public int jad_an(byte[] bArr, int i) throws jad_cp.jad_an {
            int i2 = 0;
            int i3 = 0;
            while (i2 < i && (i3 = this.jad_an.read(bArr, i2, i - i2)) != -1) {
                i2 += i3;
            }
            if (i2 == 0 && i3 == -1) {
                throw new jad_cp.jad_an();
            }
            return i2;
        }

        @Override // com.jd.ad.sdk.jad_te.jad_hu.jad_cp
        public long jad_an(long j) throws IOException {
            if (j < 0) {
                return 0L;
            }
            long j2 = j;
            while (j2 > 0) {
                long jSkip = this.jad_an.skip(j2);
                if (jSkip <= 0) {
                    if (this.jad_an.read() == -1) {
                        break;
                    }
                    jSkip = 1;
                }
                j2 -= jSkip;
            }
            return j - j2;
        }

        @Override // com.jd.ad.sdk.jad_te.jad_hu.jad_cp
        public short jad_an() throws IOException {
            int i = this.jad_an.read();
            if (i != -1) {
                return (short) i;
            }
            throw new jad_cp.jad_an();
        }

        @Override // com.jd.ad.sdk.jad_te.jad_hu.jad_cp
        public int jad_bo() {
            return (jad_an() << 8) | jad_an();
        }
    }

    public final int jad_an(jad_cp jad_cpVar, com.jd.ad.sdk.jad_ny.jad_bo jad_boVar) {
        try {
            int iJad_bo = jad_cpVar.jad_bo();
            if ((iJad_bo & 65496) != 65496 && iJad_bo != 19789 && iJad_bo != 18761) {
                if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                    Logger.d("DfltImageHeaderParser", "Parser doesn't handle magic number: " + iJad_bo);
                }
                return -1;
            }
            int iJad_bo2 = jad_bo(jad_cpVar);
            if (iJad_bo2 == -1) {
                if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                    Logger.d("DfltImageHeaderParser", "Failed to parse exif segment length, or exif segment not found");
                }
                return -1;
            }
            byte[] bArr = (byte[]) jad_boVar.jad_an(iJad_bo2, byte[].class);
            try {
                return jad_an(jad_cpVar, bArr, iJad_bo2);
            } finally {
                jad_boVar.jad_an(bArr);
            }
        } catch (jad_cp.jad_an unused) {
            return -1;
        }
    }

    public final boolean jad_an(byte[] bArr, int i) {
        boolean z = bArr != null && i > jad_an.length;
        if (z) {
            int i2 = 0;
            while (true) {
                byte[] bArr2 = jad_an;
                if (i2 >= bArr2.length) {
                    break;
                }
                if (bArr[i2] != bArr2[i2]) {
                    return false;
                }
                i2++;
            }
        }
        return z;
    }

    public final int jad_bo(jad_cp jad_cpVar) {
        short sJad_an;
        int iJad_bo;
        long j;
        long jJad_an;
        do {
            short sJad_an2 = jad_cpVar.jad_an();
            if (sJad_an2 != 255) {
                if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                    Logger.d("DfltImageHeaderParser", "Unknown segmentId=" + ((int) sJad_an2));
                }
                return -1;
            }
            sJad_an = jad_cpVar.jad_an();
            if (sJad_an == 218) {
                return -1;
            }
            if (sJad_an == 217) {
                if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                    Logger.d("DfltImageHeaderParser", "Found MARKER_EOI in exif segment");
                }
                return -1;
            }
            iJad_bo = jad_cpVar.jad_bo() - 2;
            if (sJad_an == 225) {
                return iJad_bo;
            }
            j = iJad_bo;
            jJad_an = jad_cpVar.jad_an(j);
        } while (jJad_an == j);
        if (Log.isLoggable("DfltImageHeaderParser", 3)) {
            Logger.d("DfltImageHeaderParser", "Unable to skip enough data, type: " + ((int) sJad_an) + ", wanted to skip: " + iJad_bo + ", but actually skipped: " + jJad_an);
        }
        return -1;
    }

    @Override // com.jd.ad.sdk.jad_ju.jad_fs
    public int jad_an(InputStream inputStream, com.jd.ad.sdk.jad_ny.jad_bo jad_boVar) {
        if (inputStream == null) {
            throw new NullPointerException("Argument must not be null");
        }
        jad_dq jad_dqVar = new jad_dq(inputStream);
        if (jad_boVar != null) {
            return jad_an(jad_dqVar, jad_boVar);
        }
        throw new NullPointerException("Argument must not be null");
    }

    @Override // com.jd.ad.sdk.jad_ju.jad_fs
    public int jad_an(ByteBuffer byteBuffer, com.jd.ad.sdk.jad_ny.jad_bo jad_boVar) {
        if (byteBuffer == null) {
            throw new NullPointerException("Argument must not be null");
        }
        jad_an jad_anVar = new jad_an(byteBuffer);
        if (jad_boVar != null) {
            return jad_an(jad_anVar, jad_boVar);
        }
        throw new NullPointerException("Argument must not be null");
    }

    public final com.jd.ad.sdk.jad_ju.jad_fs.jad_bo jad_an(jad_cp jad_cpVar) {
        try {
            int iJad_bo = jad_cpVar.jad_bo();
            if (iJad_bo == 65496) {
                return com.jd.ad.sdk.jad_ju.jad_fs.jad_bo.JPEG;
            }
            int iJad_an = (iJad_bo << 8) | jad_cpVar.jad_an();
            if (iJad_an == 4671814) {
                return com.jd.ad.sdk.jad_ju.jad_fs.jad_bo.GIF;
            }
            int iJad_an2 = (iJad_an << 8) | jad_cpVar.jad_an();
            if (iJad_an2 == -1991225785) {
                jad_cpVar.jad_an(21L);
                try {
                    return jad_cpVar.jad_an() >= 3 ? com.jd.ad.sdk.jad_ju.jad_fs.jad_bo.PNG_A : com.jd.ad.sdk.jad_ju.jad_fs.jad_bo.PNG;
                } catch (jad_cp.jad_an unused) {
                    return com.jd.ad.sdk.jad_ju.jad_fs.jad_bo.PNG;
                }
            }
            if (iJad_an2 != 1380533830) {
                if (((jad_cpVar.jad_bo() << 16) | jad_cpVar.jad_bo()) == 1718909296) {
                    int iJad_bo2 = (jad_cpVar.jad_bo() << 16) | jad_cpVar.jad_bo();
                    if (iJad_bo2 != 1635150182 && iJad_bo2 != 1635150195) {
                        jad_cpVar.jad_an(4L);
                        int i = iJad_an2 - 16;
                        if (i % 4 == 0) {
                            int i2 = 0;
                            while (i2 < 5 && i > 0) {
                                int iJad_bo3 = (jad_cpVar.jad_bo() << 16) | jad_cpVar.jad_bo();
                                if (iJad_bo3 != 1635150182 && iJad_bo3 != 1635150195) {
                                    i2++;
                                    i -= 4;
                                }
                            }
                        }
                    }
                    return com.jd.ad.sdk.jad_ju.jad_fs.jad_bo.AVIF;
                }
                return com.jd.ad.sdk.jad_ju.jad_fs.jad_bo.UNKNOWN;
            }
            jad_cpVar.jad_an(4L);
            if (((jad_cpVar.jad_bo() << 16) | jad_cpVar.jad_bo()) != 1464156752) {
                return com.jd.ad.sdk.jad_ju.jad_fs.jad_bo.UNKNOWN;
            }
            int iJad_bo4 = (jad_cpVar.jad_bo() << 16) | jad_cpVar.jad_bo();
            if ((iJad_bo4 & InputDeviceCompat.SOURCE_ANY) != 1448097792) {
                return com.jd.ad.sdk.jad_ju.jad_fs.jad_bo.UNKNOWN;
            }
            int i3 = iJad_bo4 & 255;
            if (i3 != 88) {
                if (i3 != 76) {
                    return com.jd.ad.sdk.jad_ju.jad_fs.jad_bo.WEBP;
                }
                jad_cpVar.jad_an(4L);
                return (jad_cpVar.jad_an() & 8) != 0 ? com.jd.ad.sdk.jad_ju.jad_fs.jad_bo.WEBP_A : com.jd.ad.sdk.jad_ju.jad_fs.jad_bo.WEBP;
            }
            jad_cpVar.jad_an(4L);
            short sJad_an = jad_cpVar.jad_an();
            if ((sJad_an & 2) != 0) {
                return com.jd.ad.sdk.jad_ju.jad_fs.jad_bo.ANIMATED_WEBP;
            }
            return (sJad_an & 16) != 0 ? com.jd.ad.sdk.jad_ju.jad_fs.jad_bo.WEBP_A : com.jd.ad.sdk.jad_ju.jad_fs.jad_bo.WEBP;
        } catch (jad_cp.jad_an unused2) {
            return com.jd.ad.sdk.jad_ju.jad_fs.jad_bo.UNKNOWN;
        }
    }

    @Override // com.jd.ad.sdk.jad_ju.jad_fs
    public com.jd.ad.sdk.jad_ju.jad_fs.jad_bo jad_an(InputStream inputStream) {
        if (inputStream != null) {
            return jad_an(new jad_dq(inputStream));
        }
        throw new NullPointerException("Argument must not be null");
    }

    @Override // com.jd.ad.sdk.jad_ju.jad_fs
    public com.jd.ad.sdk.jad_ju.jad_fs.jad_bo jad_an(ByteBuffer byteBuffer) {
        if (byteBuffer != null) {
            return jad_an(new jad_an(byteBuffer));
        }
        throw new NullPointerException("Argument must not be null");
    }

    public final int jad_an(jad_cp jad_cpVar, byte[] bArr, int i) {
        ByteOrder byteOrder;
        int iJad_an = jad_cpVar.jad_an(bArr, i);
        if (iJad_an != i) {
            if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                Logger.d("DfltImageHeaderParser", "Unable to read exif segment data, length: " + i + ", actually read: " + iJad_an);
            }
            return -1;
        }
        if (jad_an(bArr, i)) {
            jad_bo jad_boVar = new jad_bo(bArr, i);
            short sJad_an = jad_boVar.jad_an(6);
            if (sJad_an != 18761) {
                if (sJad_an != 19789 && Log.isLoggable("DfltImageHeaderParser", 3)) {
                    Logger.d("DfltImageHeaderParser", "Unknown endianness = " + ((int) sJad_an));
                }
                byteOrder = ByteOrder.BIG_ENDIAN;
            } else {
                byteOrder = ByteOrder.LITTLE_ENDIAN;
            }
            jad_boVar.jad_an.order(byteOrder);
            int iJad_bo = jad_boVar.jad_bo(10);
            short sJad_an2 = jad_boVar.jad_an(iJad_bo + 6);
            for (int i2 = 0; i2 < sJad_an2; i2++) {
                int i3 = (i2 * 12) + iJad_bo + 8;
                short sJad_an3 = jad_boVar.jad_an(i3);
                if (sJad_an3 == 274) {
                    short sJad_an4 = jad_boVar.jad_an(i3 + 2);
                    if (sJad_an4 >= 1 && sJad_an4 <= 12) {
                        int iJad_bo2 = jad_boVar.jad_bo(i3 + 4);
                        if (iJad_bo2 >= 0) {
                            if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                                Logger.d("DfltImageHeaderParser", "Got tagIndex=" + i2 + " tagType=" + ((int) sJad_an3) + " formatCode=" + ((int) sJad_an4) + " componentCount=" + iJad_bo2);
                            }
                            int i4 = iJad_bo2 + jad_bo[sJad_an4];
                            if (i4 <= 4) {
                                int i5 = i3 + 8;
                                if (i5 >= 0 && i5 <= jad_boVar.jad_an.remaining()) {
                                    if (i4 >= 0 && i4 + i5 <= jad_boVar.jad_an.remaining()) {
                                        return jad_boVar.jad_an(i5);
                                    }
                                    if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                                        Logger.d("DfltImageHeaderParser", "Illegal number of bytes for TI tag data tagType=" + ((int) sJad_an3));
                                    }
                                } else if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                                    Logger.d("DfltImageHeaderParser", "Illegal tagValueOffset=" + i5 + " tagType=" + ((int) sJad_an3));
                                }
                            } else if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                                Logger.d("DfltImageHeaderParser", "Got byte count > 4, not orientation, continuing, formatCode=" + ((int) sJad_an4));
                            }
                        } else if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                            Logger.d("DfltImageHeaderParser", "Negative tiff component count");
                        }
                    } else if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                        Logger.d("DfltImageHeaderParser", "Got invalid format code = " + ((int) sJad_an4));
                    }
                }
            }
            return -1;
        }
        if (Log.isLoggable("DfltImageHeaderParser", 3)) {
            Logger.d("DfltImageHeaderParser", "Missing jpeg exif preamble");
        }
        return -1;
    }
}
