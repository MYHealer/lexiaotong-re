package com.jd.ad.sdk.jad_bo;

import android.content.res.AssetManager;
import android.media.MediaDataSource;
import android.media.MediaMetadataRetriever;
import android.system.Os;
import android.system.OsConstants;
import android.util.Log;
import androidx.exifinterface.media.ExifInterface;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.DataInput;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TimeZone;
import java.util.regex.Pattern;
import java.util.zip.CRC32;
import org.apache.commons.io.IOUtils;

/* JADX INFO: compiled from: ExifInterface.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class jad_an {
    public static final byte[] jad_cn;
    public static final byte[] jad_do;
    public static final byte[] jad_ep;
    public static final String[] jad_fq;
    public static final int[] jad_gr;
    public static final byte[] jad_hs;
    public static final jad_dq jad_it;
    public static final jad_dq[][] jad_ju;
    public static final jad_dq[] jad_kv;
    public static final HashMap<Integer, jad_dq>[] jad_lw;
    public static final HashMap<String, jad_dq>[] jad_mx;
    public static final boolean jad_na = Log.isLoggable("ExifInterface", 3);
    public static final HashSet<String> jad_ny;
    public static final int[] jad_ob;
    public static final HashMap<Integer, Integer> jad_oz;
    public static final Charset jad_pa;
    public static final int[] jad_pc;
    public static final byte[] jad_qb;
    public static final byte[] jad_qd;
    public static final byte[] jad_rc;
    public static final byte[] jad_re;
    public static final byte[] jad_sf;
    public static final byte[] jad_tg;
    public static final byte[] jad_uh;
    public static final byte[] jad_vi;
    public static final byte[] jad_wj;
    public static final byte[] jad_xk;
    public static final byte[] jad_yl;
    public static final byte[] jad_zm;
    public FileDescriptor jad_an;
    public AssetManager.AssetInputStream jad_bo;
    public int jad_cp;
    public boolean jad_dq;
    public final HashMap<String, jad_cp>[] jad_er;
    public Set<Integer> jad_fs;
    public boolean jad_hu;
    public int jad_iv;
    public ByteOrder jad_jt;
    public int jad_jw;
    public int jad_kx;
    public int jad_ly;
    public int jad_mz;

    /* JADX INFO: compiled from: ExifInterface.java */
    public static class jad_bo extends InputStream implements DataInput {
        public static final ByteOrder jad_er = ByteOrder.LITTLE_ENDIAN;
        public static final ByteOrder jad_fs = ByteOrder.BIG_ENDIAN;
        public DataInputStream jad_an;
        public ByteOrder jad_bo;
        public final int jad_cp;
        public int jad_dq;

        public jad_bo(InputStream inputStream) {
            this(inputStream, ByteOrder.BIG_ENDIAN);
        }

        @Override // java.io.InputStream
        public int available() {
            return this.jad_an.available();
        }

        @Override // java.io.DataInput
        public double readDouble() {
            return Double.longBitsToDouble(readLong());
        }

        @Override // java.io.DataInput
        public float readFloat() {
            return Float.intBitsToFloat(readInt());
        }

        @Override // java.io.DataInput
        public String readLine() {
            Log.d("ExifInterface", "Currently unsupported");
            return null;
        }

        @Override // java.io.DataInput
        public int skipBytes(int i) {
            int iMin = Math.min(i, this.jad_cp - this.jad_dq);
            int iSkipBytes = 0;
            while (iSkipBytes < iMin) {
                iSkipBytes += this.jad_an.skipBytes(iMin - iSkipBytes);
            }
            this.jad_dq += iSkipBytes;
            return iSkipBytes;
        }

        public jad_bo(InputStream inputStream, ByteOrder byteOrder) {
            this.jad_bo = ByteOrder.BIG_ENDIAN;
            DataInputStream dataInputStream = new DataInputStream(inputStream);
            this.jad_an = dataInputStream;
            int iAvailable = dataInputStream.available();
            this.jad_cp = iAvailable;
            this.jad_dq = 0;
            this.jad_an.mark(iAvailable);
            this.jad_bo = byteOrder;
        }

        @Override // java.io.InputStream
        public int read() {
            this.jad_dq++;
            return this.jad_an.read();
        }

        @Override // java.io.DataInput
        public boolean readBoolean() {
            this.jad_dq++;
            return this.jad_an.readBoolean();
        }

        @Override // java.io.DataInput
        public char readChar() {
            this.jad_dq += 2;
            return this.jad_an.readChar();
        }

        @Override // java.io.DataInput
        public String readUTF() {
            this.jad_dq += 2;
            return this.jad_an.readUTF();
        }

        @Override // java.io.DataInput
        public int readUnsignedByte() {
            this.jad_dq++;
            return this.jad_an.readUnsignedByte();
        }

        public void jad_bo(long j) throws IOException {
            long j2 = this.jad_dq;
            if (j2 > j) {
                this.jad_dq = 0;
                this.jad_an.reset();
                this.jad_an.mark(this.jad_cp);
            } else {
                j -= j2;
            }
            int i = (int) j;
            if (skipBytes(i) != i) {
                throw new IOException("Couldn't seek up to the byteCount");
            }
        }

        @Override // java.io.InputStream
        public int read(byte[] bArr, int i, int i2) throws IOException {
            int i3 = this.jad_an.read(bArr, i, i2);
            this.jad_dq += i3;
            return i3;
        }

        @Override // java.io.DataInput
        public byte readByte() throws EOFException {
            int i = this.jad_dq + 1;
            this.jad_dq = i;
            if (i <= this.jad_cp) {
                int i2 = this.jad_an.read();
                if (i2 >= 0) {
                    return (byte) i2;
                }
                throw new EOFException();
            }
            throw new EOFException();
        }

        @Override // java.io.DataInput
        public void readFully(byte[] bArr, int i, int i2) throws IOException {
            int i3 = this.jad_dq + i2;
            this.jad_dq = i3;
            if (i3 <= this.jad_cp) {
                if (this.jad_an.read(bArr, i, i2) != i2) {
                    throw new IOException("Couldn't read up to the length of buffer");
                }
                return;
            }
            throw new EOFException();
        }

        @Override // java.io.DataInput
        public int readInt() throws IOException {
            int i = this.jad_dq + 4;
            this.jad_dq = i;
            if (i <= this.jad_cp) {
                int i2 = this.jad_an.read();
                int i3 = this.jad_an.read();
                int i4 = this.jad_an.read();
                int i5 = this.jad_an.read();
                if ((i2 | i3 | i4 | i5) < 0) {
                    throw new EOFException();
                }
                ByteOrder byteOrder = this.jad_bo;
                if (byteOrder == jad_er) {
                    return (i5 << 24) + (i4 << 16) + (i3 << 8) + i2;
                }
                if (byteOrder == jad_fs) {
                    return (i2 << 24) + (i3 << 16) + (i4 << 8) + i5;
                }
                throw new IOException(com.jd.ad.sdk.jad_bo.jad_bo.jad_an("Invalid byte order: ").append(this.jad_bo).toString());
            }
            throw new EOFException();
        }

        @Override // java.io.DataInput
        public long readLong() throws IOException {
            int i = this.jad_dq + 8;
            this.jad_dq = i;
            if (i <= this.jad_cp) {
                int i2 = this.jad_an.read();
                int i3 = this.jad_an.read();
                int i4 = this.jad_an.read();
                int i5 = this.jad_an.read();
                int i6 = this.jad_an.read();
                int i7 = this.jad_an.read();
                int i8 = this.jad_an.read();
                int i9 = this.jad_an.read();
                if ((i2 | i3 | i4 | i5 | i6 | i7 | i8 | i9) < 0) {
                    throw new EOFException();
                }
                ByteOrder byteOrder = this.jad_bo;
                if (byteOrder == jad_er) {
                    return (((long) i9) << 56) + (((long) i8) << 48) + (((long) i7) << 40) + (((long) i6) << 32) + (((long) i5) << 24) + (((long) i4) << 16) + (((long) i3) << 8) + ((long) i2);
                }
                if (byteOrder == jad_fs) {
                    return (((long) i2) << 56) + (((long) i3) << 48) + (((long) i4) << 40) + (((long) i5) << 32) + (((long) i6) << 24) + (((long) i7) << 16) + (((long) i8) << 8) + ((long) i9);
                }
                throw new IOException(com.jd.ad.sdk.jad_bo.jad_bo.jad_an("Invalid byte order: ").append(this.jad_bo).toString());
            }
            throw new EOFException();
        }

        @Override // java.io.DataInput
        public short readShort() throws IOException {
            int i = this.jad_dq + 2;
            this.jad_dq = i;
            if (i <= this.jad_cp) {
                int i2 = this.jad_an.read();
                int i3 = this.jad_an.read();
                if ((i2 | i3) < 0) {
                    throw new EOFException();
                }
                ByteOrder byteOrder = this.jad_bo;
                if (byteOrder == jad_er) {
                    return (short) ((i3 << 8) + i2);
                }
                if (byteOrder == jad_fs) {
                    return (short) ((i2 << 8) + i3);
                }
                throw new IOException(com.jd.ad.sdk.jad_bo.jad_bo.jad_an("Invalid byte order: ").append(this.jad_bo).toString());
            }
            throw new EOFException();
        }

        @Override // java.io.DataInput
        public int readUnsignedShort() throws IOException {
            int i = this.jad_dq + 2;
            this.jad_dq = i;
            if (i <= this.jad_cp) {
                int i2 = this.jad_an.read();
                int i3 = this.jad_an.read();
                if ((i2 | i3) < 0) {
                    throw new EOFException();
                }
                ByteOrder byteOrder = this.jad_bo;
                if (byteOrder == jad_er) {
                    return (i3 << 8) + i2;
                }
                if (byteOrder == jad_fs) {
                    return (i2 << 8) + i3;
                }
                throw new IOException(com.jd.ad.sdk.jad_bo.jad_bo.jad_an("Invalid byte order: ").append(this.jad_bo).toString());
            }
            throw new EOFException();
        }

        @Override // java.io.DataInput
        public void readFully(byte[] bArr) throws IOException {
            int length = this.jad_dq + bArr.length;
            this.jad_dq = length;
            if (length <= this.jad_cp) {
                if (this.jad_an.read(bArr, 0, bArr.length) != bArr.length) {
                    throw new IOException("Couldn't read up to the length of buffer");
                }
                return;
            }
            throw new EOFException();
        }

        public long jad_bo() {
            return ((long) readInt()) & 4294967295L;
        }

        public jad_bo(byte[] bArr) {
            this(new ByteArrayInputStream(bArr));
        }
    }

    /* JADX INFO: compiled from: ExifInterface.java */
    public static class jad_cp {
        public final int jad_an;
        public final int jad_bo;
        public final byte[] jad_cp;

        public jad_cp(int i, int i2, long j, byte[] bArr) {
            this.jad_an = i;
            this.jad_bo = i2;
            this.jad_cp = bArr;
        }

        public int jad_bo(ByteOrder byteOrder) throws Throwable {
            Object objJad_dq = jad_dq(byteOrder);
            if (objJad_dq == null) {
                throw new NumberFormatException("NULL can't be converted to a integer value");
            }
            if (objJad_dq instanceof String) {
                return Integer.parseInt((String) objJad_dq);
            }
            if (objJad_dq instanceof long[]) {
                long[] jArr = (long[]) objJad_dq;
                if (jArr.length == 1) {
                    return (int) jArr[0];
                }
                throw new NumberFormatException("There are more than one component");
            }
            if (!(objJad_dq instanceof int[])) {
                throw new NumberFormatException("Couldn't find a integer value");
            }
            int[] iArr = (int[]) objJad_dq;
            if (iArr.length == 1) {
                return iArr[0];
            }
            throw new NumberFormatException("There are more than one component");
        }

        public String jad_cp(ByteOrder byteOrder) throws Throwable {
            Object objJad_dq = jad_dq(byteOrder);
            if (objJad_dq == null) {
                return null;
            }
            if (objJad_dq instanceof String) {
                return (String) objJad_dq;
            }
            StringBuilder sb = new StringBuilder();
            int i = 0;
            if (objJad_dq instanceof long[]) {
                long[] jArr = (long[]) objJad_dq;
                while (i < jArr.length) {
                    sb.append(jArr[i]);
                    i++;
                    if (i != jArr.length) {
                        sb.append(",");
                    }
                }
                return sb.toString();
            }
            if (objJad_dq instanceof int[]) {
                int[] iArr = (int[]) objJad_dq;
                while (i < iArr.length) {
                    sb.append(iArr[i]);
                    i++;
                    if (i != iArr.length) {
                        sb.append(",");
                    }
                }
                return sb.toString();
            }
            if (objJad_dq instanceof double[]) {
                double[] dArr = (double[]) objJad_dq;
                while (i < dArr.length) {
                    sb.append(dArr[i]);
                    i++;
                    if (i != dArr.length) {
                        sb.append(",");
                    }
                }
                return sb.toString();
            }
            if (!(objJad_dq instanceof jad_er[])) {
                return null;
            }
            jad_er[] jad_erVarArr = (jad_er[]) objJad_dq;
            while (i < jad_erVarArr.length) {
                sb.append(jad_erVarArr[i].jad_an);
                sb.append(IOUtils.DIR_SEPARATOR_UNIX);
                sb.append(jad_erVarArr[i].jad_bo);
                i++;
                if (i != jad_erVarArr.length) {
                    sb.append(",");
                }
            }
            return sb.toString();
        }

        /* JADX WARN: Code duplicated, block: B:178:0x01a3 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        public Object jad_dq(ByteOrder byteOrder) throws Throwable {
            jad_bo jad_boVar;
            byte b;
            byte b2;
            jad_bo jad_boVar2 = null;
            try {
                jad_boVar = new jad_bo(this.jad_cp);
                try {
                    jad_boVar.jad_bo = byteOrder;
                    int length = 0;
                    switch (this.jad_an) {
                        case 1:
                        case 6:
                            byte[] bArr = this.jad_cp;
                            if (bArr.length != 1 || (b = bArr[0]) < 0 || b > 1) {
                                String str = new String(bArr, jad_an.jad_pa);
                                try {
                                    jad_boVar.close();
                                    break;
                                } catch (IOException e) {
                                    Log.e("ExifInterface", "IOException occurred while closing InputStream", e);
                                }
                                return str;
                            }
                            String str2 = new String(new char[]{(char) (bArr[0] + 48)});
                            try {
                                jad_boVar.close();
                                break;
                            } catch (IOException e2) {
                                Log.e("ExifInterface", "IOException occurred while closing InputStream", e2);
                            }
                            return str2;
                        case 2:
                        case 7:
                            if (this.jad_bo >= jad_an.jad_hs.length) {
                                int i = 0;
                                while (true) {
                                    byte[] bArr2 = jad_an.jad_hs;
                                    if (i >= bArr2.length) {
                                        length = bArr2.length;
                                    } else if (this.jad_cp[i] == bArr2[i]) {
                                        i++;
                                    }
                                }
                            }
                            StringBuilder sb = new StringBuilder();
                            while (length < this.jad_bo && (b2 = this.jad_cp[length]) != 0) {
                                if (b2 >= 32) {
                                    sb.append((char) b2);
                                } else {
                                    sb.append('?');
                                }
                                length++;
                            }
                            String string = sb.toString();
                            try {
                                jad_boVar.close();
                                break;
                            } catch (IOException e3) {
                                Log.e("ExifInterface", "IOException occurred while closing InputStream", e3);
                            }
                            return string;
                        case 3:
                            int[] iArr = new int[this.jad_bo];
                            while (length < this.jad_bo) {
                                iArr[length] = jad_boVar.readUnsignedShort();
                                length++;
                            }
                            try {
                                jad_boVar.close();
                                break;
                            } catch (IOException e4) {
                                Log.e("ExifInterface", "IOException occurred while closing InputStream", e4);
                            }
                            return iArr;
                        case 4:
                            long[] jArr = new long[this.jad_bo];
                            while (length < this.jad_bo) {
                                jArr[length] = jad_boVar.jad_bo();
                                length++;
                            }
                            try {
                                jad_boVar.close();
                                break;
                            } catch (IOException e5) {
                                Log.e("ExifInterface", "IOException occurred while closing InputStream", e5);
                            }
                            return jArr;
                        case 5:
                            jad_er[] jad_erVarArr = new jad_er[this.jad_bo];
                            while (length < this.jad_bo) {
                                jad_erVarArr[length] = new jad_er(jad_boVar.jad_bo(), jad_boVar.jad_bo());
                                length++;
                            }
                            try {
                                jad_boVar.close();
                                break;
                            } catch (IOException e6) {
                                Log.e("ExifInterface", "IOException occurred while closing InputStream", e6);
                            }
                            return jad_erVarArr;
                        case 8:
                            int[] iArr2 = new int[this.jad_bo];
                            while (length < this.jad_bo) {
                                iArr2[length] = jad_boVar.readShort();
                                length++;
                            }
                            try {
                                jad_boVar.close();
                                break;
                            } catch (IOException e7) {
                                Log.e("ExifInterface", "IOException occurred while closing InputStream", e7);
                            }
                            return iArr2;
                        case 9:
                            int[] iArr3 = new int[this.jad_bo];
                            while (length < this.jad_bo) {
                                iArr3[length] = jad_boVar.readInt();
                                length++;
                            }
                            try {
                                jad_boVar.close();
                                break;
                            } catch (IOException e8) {
                                Log.e("ExifInterface", "IOException occurred while closing InputStream", e8);
                            }
                            return iArr3;
                        case 10:
                            jad_er[] jad_erVarArr2 = new jad_er[this.jad_bo];
                            while (length < this.jad_bo) {
                                jad_erVarArr2[length] = new jad_er(jad_boVar.readInt(), jad_boVar.readInt());
                                length++;
                            }
                            try {
                                jad_boVar.close();
                                break;
                            } catch (IOException e9) {
                                Log.e("ExifInterface", "IOException occurred while closing InputStream", e9);
                            }
                            return jad_erVarArr2;
                        case 11:
                            double[] dArr = new double[this.jad_bo];
                            while (length < this.jad_bo) {
                                dArr[length] = Float.intBitsToFloat(jad_boVar.readInt());
                                length++;
                            }
                            try {
                                jad_boVar.close();
                                break;
                            } catch (IOException e10) {
                                Log.e("ExifInterface", "IOException occurred while closing InputStream", e10);
                            }
                            return dArr;
                        case 12:
                            double[] dArr2 = new double[this.jad_bo];
                            while (length < this.jad_bo) {
                                dArr2[length] = Double.longBitsToDouble(jad_boVar.readLong());
                                length++;
                            }
                            try {
                                jad_boVar.close();
                                break;
                            } catch (IOException e11) {
                                Log.e("ExifInterface", "IOException occurred while closing InputStream", e11);
                            }
                            return dArr2;
                        default:
                            try {
                                jad_boVar.close();
                                break;
                            } catch (IOException e12) {
                                Log.e("ExifInterface", "IOException occurred while closing InputStream", e12);
                            }
                            return null;
                    }
                } catch (IOException e13) {
                    e = e13;
                    try {
                        Log.w("ExifInterface", "IOException occurred during reading a value", e);
                        if (jad_boVar != null) {
                            try {
                                jad_boVar.close();
                            } catch (IOException e14) {
                                Log.e("ExifInterface", "IOException occurred while closing InputStream", e14);
                            }
                        }
                        return null;
                    } catch (Throwable th) {
                        th = th;
                        jad_boVar2 = jad_boVar;
                        jad_boVar = jad_boVar2;
                        if (jad_boVar != null) {
                            try {
                                jad_boVar.close();
                            } catch (IOException e15) {
                                Log.e("ExifInterface", "IOException occurred while closing InputStream", e15);
                            }
                        }
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (jad_boVar != null) {
                        jad_boVar.close();
                    }
                    throw th;
                }
            } catch (IOException e16) {
                e = e16;
                jad_boVar = null;
            } catch (Throwable th3) {
                th = th3;
                jad_boVar = jad_boVar2;
                if (jad_boVar != null) {
                    jad_boVar.close();
                }
                throw th;
            }
        }

        public String toString() {
            return com.jd.ad.sdk.jad_bo.jad_bo.jad_an("(").append(jad_an.jad_fq[this.jad_an]).append(", data length:").append(this.jad_cp.length).append(")").toString();
        }

        public static jad_cp jad_an(int i, ByteOrder byteOrder) {
            ByteBuffer byteBufferWrap = ByteBuffer.wrap(new byte[jad_an.jad_gr[3]]);
            byteBufferWrap.order(byteOrder);
            byteBufferWrap.putShort((short) new int[]{i}[0]);
            return new jad_cp(3, 1, -1L, byteBufferWrap.array());
        }

        public static jad_cp jad_an(long j, ByteOrder byteOrder) {
            long[] jArr = {j};
            ByteBuffer byteBufferWrap = ByteBuffer.wrap(new byte[jad_an.jad_gr[4]]);
            byteBufferWrap.order(byteOrder);
            byteBufferWrap.putInt((int) jArr[0]);
            return new jad_cp(4, 1, -1L, byteBufferWrap.array());
        }

        public static jad_cp jad_an(String str) {
            byte[] bytes = (str + (char) 0).getBytes(jad_an.jad_pa);
            return new jad_cp(2, bytes.length, -1L, bytes);
        }

        public static jad_cp jad_an(jad_er jad_erVar, ByteOrder byteOrder) {
            jad_er[] jad_erVarArr = {jad_erVar};
            ByteBuffer byteBufferWrap = ByteBuffer.wrap(new byte[jad_an.jad_gr[5]]);
            byteBufferWrap.order(byteOrder);
            jad_er jad_erVar2 = jad_erVarArr[0];
            byteBufferWrap.putInt((int) jad_erVar2.jad_an);
            byteBufferWrap.putInt((int) jad_erVar2.jad_bo);
            return new jad_cp(5, 1, -1L, byteBufferWrap.array());
        }

        public double jad_an(ByteOrder byteOrder) throws Throwable {
            Object objJad_dq = jad_dq(byteOrder);
            if (objJad_dq != null) {
                if (objJad_dq instanceof String) {
                    return Double.parseDouble((String) objJad_dq);
                }
                if (objJad_dq instanceof long[]) {
                    long[] jArr = (long[]) objJad_dq;
                    if (jArr.length == 1) {
                        return jArr[0];
                    }
                    throw new NumberFormatException("There are more than one component");
                }
                if (objJad_dq instanceof int[]) {
                    int[] iArr = (int[]) objJad_dq;
                    if (iArr.length == 1) {
                        return iArr[0];
                    }
                    throw new NumberFormatException("There are more than one component");
                }
                if (objJad_dq instanceof double[]) {
                    double[] dArr = (double[]) objJad_dq;
                    if (dArr.length == 1) {
                        return dArr[0];
                    }
                    throw new NumberFormatException("There are more than one component");
                }
                if (objJad_dq instanceof jad_er[]) {
                    jad_er[] jad_erVarArr = (jad_er[]) objJad_dq;
                    if (jad_erVarArr.length == 1) {
                        jad_er jad_erVar = jad_erVarArr[0];
                        return jad_erVar.jad_an / jad_erVar.jad_bo;
                    }
                    throw new NumberFormatException("There are more than one component");
                }
                throw new NumberFormatException("Couldn't find a double value");
            }
            throw new NumberFormatException("NULL can't be converted to a double value");
        }
    }

    /* JADX INFO: compiled from: ExifInterface.java */
    public static class jad_er {
        public final long jad_an;
        public final long jad_bo;

        public jad_er(long j, long j2) {
            if (j2 == 0) {
                this.jad_an = 0L;
                this.jad_bo = 1L;
            } else {
                this.jad_an = j;
                this.jad_bo = j2;
            }
        }

        public String toString() {
            return this.jad_an + "/" + this.jad_bo;
        }
    }

    /* JADX WARN: Code duplicated, block: B:19:0x005f  */
    public jad_an(InputStream inputStream, boolean z) {
        jad_dq[][] jad_dqVarArr = jad_ju;
        this.jad_er = new HashMap[jad_dqVarArr.length];
        this.jad_fs = new HashSet(jad_dqVarArr.length);
        this.jad_jt = ByteOrder.BIG_ENDIAN;
        if (inputStream == null) {
            throw new NullPointerException("inputStream cannot be null");
        }
        if (z) {
            BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream, 5000);
            if (!jad_bo(bufferedInputStream)) {
                Log.w("ExifInterface", "Given data does not follow the structure of an Exif-only data.");
                return;
            }
            this.jad_dq = true;
            this.jad_bo = null;
            this.jad_an = null;
            inputStream = bufferedInputStream;
        } else if (inputStream instanceof AssetManager.AssetInputStream) {
            this.jad_bo = (AssetManager.AssetInputStream) inputStream;
            this.jad_an = null;
        } else if (inputStream instanceof FileInputStream) {
            FileInputStream fileInputStream = (FileInputStream) inputStream;
            if (jad_an(fileInputStream.getFD())) {
                this.jad_bo = null;
                this.jad_an = fileInputStream.getFD();
            } else {
                this.jad_bo = null;
                this.jad_an = null;
            }
        } else {
            this.jad_bo = null;
            this.jad_an = null;
        }
        jad_an(inputStream);
    }

    public String jad_an(String str) {
        jad_cp jad_cpVarJad_bo = jad_bo(str);
        if (jad_cpVarJad_bo != null) {
            if (!jad_ny.contains(str)) {
                return jad_cpVarJad_bo.jad_cp(this.jad_jt);
            }
            if (str.equals(ExifInterface.TAG_GPS_TIMESTAMP)) {
                int i = jad_cpVarJad_bo.jad_an;
                if (i != 5 && i != 10) {
                    Log.w("ExifInterface", com.jd.ad.sdk.jad_bo.jad_bo.jad_an("GPS Timestamp format is not rational. format=").append(jad_cpVarJad_bo.jad_an).toString());
                    return null;
                }
                jad_er[] jad_erVarArr = (jad_er[]) jad_cpVarJad_bo.jad_dq(this.jad_jt);
                if (jad_erVarArr != null && jad_erVarArr.length == 3) {
                    return String.format("%02d:%02d:%02d", Integer.valueOf((int) (jad_erVarArr[0].jad_an / jad_erVarArr[0].jad_bo)), Integer.valueOf((int) (jad_erVarArr[1].jad_an / jad_erVarArr[1].jad_bo)), Integer.valueOf((int) (jad_erVarArr[2].jad_an / jad_erVarArr[2].jad_bo)));
                }
                Log.w("ExifInterface", com.jd.ad.sdk.jad_bo.jad_bo.jad_an("Invalid GPS Timestamp array. array=").append(Arrays.toString(jad_erVarArr)).toString());
                return null;
            }
            try {
                return Double.toString(jad_cpVarJad_bo.jad_an(this.jad_jt));
            } catch (NumberFormatException unused) {
            }
        }
        return null;
    }

    public final jad_cp jad_bo(String str) {
        if (str == null) {
            throw new NullPointerException("tag shouldn't be null");
        }
        if (ExifInterface.TAG_ISO_SPEED_RATINGS.equals(str)) {
            if (jad_na) {
                Log.d("ExifInterface", "getExifAttribute: Replacing TAG_ISO_SPEED_RATINGS with TAG_PHOTOGRAPHIC_SENSITIVITY.");
            }
            str = ExifInterface.TAG_PHOTOGRAPHIC_SENSITIVITY;
        }
        for (int i = 0; i < jad_ju.length; i++) {
            jad_cp jad_cpVar = this.jad_er[i].get(str);
            if (jad_cpVar != null) {
                return jad_cpVar;
            }
        }
        return null;
    }

    public final boolean jad_cp(byte[] bArr) throws Throwable {
        jad_bo jad_boVar = null;
        try {
            jad_bo jad_boVar2 = new jad_bo(bArr);
            try {
                ByteOrder byteOrderJad_iv = jad_iv(jad_boVar2);
                this.jad_jt = byteOrderJad_iv;
                jad_boVar2.jad_bo = byteOrderJad_iv;
                boolean z = jad_boVar2.readShort() == 85;
                jad_boVar2.close();
                return z;
            } catch (Exception unused) {
                jad_boVar = jad_boVar2;
                if (jad_boVar != null) {
                    jad_boVar.close();
                }
                return false;
            } catch (Throwable th) {
                th = th;
                jad_boVar = jad_boVar2;
                if (jad_boVar != null) {
                    jad_boVar.close();
                }
                throw th;
            }
        } catch (Exception unused2) {
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public final void jad_dq(jad_bo jad_boVar) throws IOException {
        jad_boVar.skipBytes(84);
        byte[] bArr = new byte[4];
        byte[] bArr2 = new byte[4];
        jad_boVar.read(bArr);
        jad_boVar.skipBytes(4);
        jad_boVar.read(bArr2);
        int i = ByteBuffer.wrap(bArr).getInt();
        int i2 = ByteBuffer.wrap(bArr2).getInt();
        jad_an(jad_boVar, i, 5);
        jad_boVar.jad_bo(i2);
        jad_boVar.jad_bo = ByteOrder.BIG_ENDIAN;
        int i3 = jad_boVar.readInt();
        if (jad_na) {
            Log.d("ExifInterface", "numberOfDirectoryEntry: " + i3);
        }
        for (int i4 = 0; i4 < i3; i4++) {
            int unsignedShort = jad_boVar.readUnsignedShort();
            int unsignedShort2 = jad_boVar.readUnsignedShort();
            if (unsignedShort == jad_it.jad_an) {
                short s = jad_boVar.readShort();
                short s2 = jad_boVar.readShort();
                jad_cp jad_cpVarJad_an = jad_cp.jad_an((int) s, this.jad_jt);
                jad_cp jad_cpVarJad_an2 = jad_cp.jad_an((int) s2, this.jad_jt);
                this.jad_er[0].put(ExifInterface.TAG_IMAGE_LENGTH, jad_cpVarJad_an);
                this.jad_er[0].put(ExifInterface.TAG_IMAGE_WIDTH, jad_cpVarJad_an2);
                if (jad_na) {
                    Log.d("ExifInterface", "Updated to length: " + ((int) s) + ", width: " + ((int) s2));
                    return;
                }
                return;
            }
            jad_boVar.skipBytes(unsignedShort2);
        }
    }

    public final void jad_er(jad_bo jad_boVar) throws Throwable {
        jad_cp jad_cpVar;
        jad_an(jad_boVar, jad_boVar.jad_an.available());
        jad_bo(jad_boVar, 0);
        jad_dq(jad_boVar, 0);
        jad_dq(jad_boVar, 5);
        jad_dq(jad_boVar, 4);
        jad_cp();
        if (this.jad_cp != 8 || (jad_cpVar = this.jad_er[1].get(ExifInterface.TAG_MAKER_NOTE)) == null) {
            return;
        }
        jad_bo jad_boVar2 = new jad_bo(jad_cpVar.jad_cp);
        jad_boVar2.jad_bo = this.jad_jt;
        jad_boVar2.jad_bo(6L);
        jad_bo(jad_boVar2, 9);
        jad_cp jad_cpVar2 = this.jad_er[9].get(ExifInterface.TAG_COLOR_SPACE);
        if (jad_cpVar2 != null) {
            this.jad_er[1].put(ExifInterface.TAG_COLOR_SPACE, jad_cpVar2);
        }
    }

    public final void jad_fs(jad_bo jad_boVar) throws Throwable {
        jad_er(jad_boVar);
        if (this.jad_er[0].get(ExifInterface.TAG_RW2_JPG_FROM_RAW) != null) {
            jad_an(jad_boVar, this.jad_mz, 5);
        }
        jad_cp jad_cpVar = this.jad_er[0].get(ExifInterface.TAG_RW2_ISO);
        jad_cp jad_cpVar2 = this.jad_er[1].get(ExifInterface.TAG_PHOTOGRAPHIC_SENSITIVITY);
        if (jad_cpVar == null || jad_cpVar2 != null) {
            return;
        }
        this.jad_er[1].put(ExifInterface.TAG_PHOTOGRAPHIC_SENSITIVITY, jad_cpVar);
    }

    public final ByteOrder jad_iv(jad_bo jad_boVar) throws IOException {
        short s = jad_boVar.readShort();
        if (s == 18761) {
            if (jad_na) {
                Log.d("ExifInterface", "readExifSegment: Byte Align II");
            }
            return ByteOrder.LITTLE_ENDIAN;
        }
        if (s != 19789) {
            throw new IOException(com.jd.ad.sdk.jad_bo.jad_bo.jad_an("Invalid byte order: ").append(Integer.toHexString(s)).toString());
        }
        if (jad_na) {
            Log.d("ExifInterface", "readExifSegment: Byte Align MM");
        }
        return ByteOrder.BIG_ENDIAN;
    }

    public final void jad_jt(jad_bo jad_boVar) throws IOException {
        byte[] bArr = jad_qb;
        jad_boVar.skipBytes(bArr.length);
        byte[] bArr2 = new byte[jad_boVar.jad_an.available()];
        jad_boVar.readFully(bArr2);
        this.jad_iv = bArr.length;
        jad_an(bArr2, 0);
    }

    public final void jad_jw(jad_bo jad_boVar) throws Throwable {
        jad_cp jad_cpVar;
        int iJad_bo;
        HashMap<String, jad_cp> map = this.jad_er[4];
        jad_cp jad_cpVar2 = map.get(ExifInterface.TAG_COMPRESSION);
        if (jad_cpVar2 == null) {
            jad_an(jad_boVar, map);
            return;
        }
        int iJad_bo2 = jad_cpVar2.jad_bo(this.jad_jt);
        if (iJad_bo2 != 1) {
            if (iJad_bo2 == 6) {
                jad_an(jad_boVar, map);
                return;
            } else if (iJad_bo2 != 7) {
                return;
            }
        }
        jad_cp jad_cpVar3 = map.get(ExifInterface.TAG_BITS_PER_SAMPLE);
        if (jad_cpVar3 != null) {
            int[] iArr = (int[]) jad_cpVar3.jad_dq(this.jad_jt);
            int[] iArr2 = jad_ob;
            if (Arrays.equals(iArr2, iArr) || (this.jad_cp == 3 && (jad_cpVar = map.get(ExifInterface.TAG_PHOTOMETRIC_INTERPRETATION)) != null && (((iJad_bo = jad_cpVar.jad_bo(this.jad_jt)) == 1 && Arrays.equals(iArr, jad_pc)) || (iJad_bo == 6 && Arrays.equals(iArr, iArr2))))) {
                jad_cp jad_cpVar4 = map.get(ExifInterface.TAG_STRIP_OFFSETS);
                jad_cp jad_cpVar5 = map.get(ExifInterface.TAG_STRIP_BYTE_COUNTS);
                if (jad_cpVar4 == null || jad_cpVar5 == null) {
                    return;
                }
                long[] jArrJad_an = jad_an(jad_cpVar4.jad_dq(this.jad_jt));
                long[] jArrJad_an2 = jad_an(jad_cpVar5.jad_dq(this.jad_jt));
                if (jArrJad_an == null || jArrJad_an.length == 0) {
                    Log.w("ExifInterface", "stripOffsets should not be null or have zero length.");
                    return;
                }
                if (jArrJad_an2 == null || jArrJad_an2.length == 0) {
                    Log.w("ExifInterface", "stripByteCounts should not be null or have zero length.");
                    return;
                }
                if (jArrJad_an.length != jArrJad_an2.length) {
                    Log.w("ExifInterface", "stripOffsets and stripByteCounts should have same length.");
                    return;
                }
                long j = 0;
                for (long j2 : jArrJad_an2) {
                    j += j2;
                }
                byte[] bArr = new byte[(int) j];
                this.jad_hu = true;
                int i = 0;
                int i2 = 0;
                for (int i3 = 0; i3 < jArrJad_an.length; i3++) {
                    int i4 = (int) jArrJad_an[i3];
                    int i5 = (int) jArrJad_an2[i3];
                    if (i3 < jArrJad_an.length - 1 && i4 + i5 != jArrJad_an[i3 + 1]) {
                        this.jad_hu = false;
                    }
                    int i6 = i4 - i;
                    if (i6 < 0) {
                        Log.d("ExifInterface", "Invalid strip offset value");
                    }
                    jad_boVar.jad_bo(i6);
                    int i7 = i + i6;
                    byte[] bArr2 = new byte[i5];
                    jad_boVar.read(bArr2);
                    i = i7 + i5;
                    System.arraycopy(bArr2, 0, bArr, i2, i5);
                    i2 += i5;
                }
                if (this.jad_hu) {
                    long j3 = jArrJad_an[0];
                    return;
                }
                return;
            }
        }
        if (jad_na) {
            Log.d("ExifInterface", "Unsupported data type value");
        }
    }

    public final void jad_hu(jad_bo jad_boVar) throws IOException {
        if (jad_na) {
            Log.d("ExifInterface", "getWebpAttributes starting with: " + jad_boVar);
        }
        jad_boVar.jad_bo = ByteOrder.LITTLE_ENDIAN;
        jad_boVar.skipBytes(jad_cn.length);
        int i = jad_boVar.readInt() + 8;
        int iSkipBytes = jad_boVar.skipBytes(jad_do.length) + 8;
        while (true) {
            try {
                byte[] bArr = new byte[4];
                if (jad_boVar.read(bArr) != 4) {
                    throw new IOException("Encountered invalid length while parsing WebP chunktype");
                }
                int i2 = jad_boVar.readInt();
                int i3 = iSkipBytes + 8;
                if (Arrays.equals(jad_ep, bArr)) {
                    byte[] bArr2 = new byte[i2];
                    if (jad_boVar.read(bArr2) != i2) {
                        throw new IOException("Failed to read given length for given PNG chunk type: " + jad_an(bArr));
                    }
                    this.jad_iv = i3;
                    jad_an(bArr2, 0);
                    this.jad_iv = i3;
                    return;
                }
                if (i2 % 2 == 1) {
                    i2++;
                }
                int i4 = i3 + i2;
                if (i4 == i) {
                    return;
                }
                if (i4 > i) {
                    throw new IOException("Encountered WebP file with invalid chunk size");
                }
                int iSkipBytes2 = jad_boVar.skipBytes(i2);
                if (iSkipBytes2 != i2) {
                    throw new IOException("Encountered WebP file with invalid chunk size");
                }
                iSkipBytes = i3 + iSkipBytes2;
            } catch (EOFException unused) {
                throw new IOException("Encountered corrupt WebP file.");
            }
        }
    }

    /* JADX INFO: compiled from: ExifInterface.java */
    public static class jad_dq {
        public final int jad_an;
        public final String jad_bo;
        public final int jad_cp;
        public final int jad_dq;

        public jad_dq(String str, int i, int i2) {
            this.jad_bo = str;
            this.jad_an = i;
            this.jad_cp = i2;
            this.jad_dq = -1;
        }

        public jad_dq(String str, int i, int i2, int i3) {
            this.jad_bo = str;
            this.jad_an = i;
            this.jad_cp = i2;
            this.jad_dq = i3;
        }
    }

    /* JADX INFO: renamed from: com.jd.ad.sdk.jad_bo.jad_an$jad_an, reason: collision with other inner class name */
    /* JADX INFO: compiled from: ExifInterface.java */
    public class C0550jad_an extends MediaDataSource {
        public long jad_an;
        public final /* synthetic */ jad_bo jad_bo;

        public C0550jad_an(jad_an jad_anVar, jad_bo jad_boVar) {
            this.jad_bo = jad_boVar;
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
        }

        @Override // android.media.MediaDataSource
        public long getSize() {
            return -1L;
        }

        @Override // android.media.MediaDataSource
        public int readAt(long j, byte[] bArr, int i, int i2) {
            if (i2 == 0) {
                return 0;
            }
            if (j < 0) {
                return -1;
            }
            try {
                long j2 = this.jad_an;
                if (j2 != j) {
                    if (j2 >= 0 && j >= j2 + ((long) this.jad_bo.jad_an.available())) {
                        return -1;
                    }
                    this.jad_bo.jad_bo(j);
                    this.jad_an = j;
                }
                if (i2 > this.jad_bo.jad_an.available()) {
                    i2 = this.jad_bo.jad_an.available();
                }
                jad_bo jad_boVar = this.jad_bo;
                int i3 = jad_boVar.jad_an.read(bArr, i, i2);
                jad_boVar.jad_dq += i3;
                if (i3 >= 0) {
                    this.jad_an += (long) i3;
                    return i3;
                }
            } catch (IOException unused) {
            }
            this.jad_an = -1L;
            return -1;
        }
    }

    public final void jad_bo() {
        for (int i = 0; i < this.jad_er.length; i++) {
            Log.d("ExifInterface", "The size of tag group[" + i + "]: " + this.jad_er[i].size());
            for (Map.Entry<String, jad_cp> entry : this.jad_er[i].entrySet()) {
                jad_cp value = entry.getValue();
                Log.d("ExifInterface", com.jd.ad.sdk.jad_bo.jad_bo.jad_an("tagName: ").append(entry.getKey()).append(", tagType: ").append(value.toString()).append(", tagValue: '").append(value.jad_cp(this.jad_jt)).append("'").toString());
            }
        }
    }

    public final void jad_cp(jad_bo jad_boVar) throws Throwable {
        if (jad_na) {
            Log.d("ExifInterface", "getPngAttributes starting with: " + jad_boVar);
        }
        jad_boVar.jad_bo = ByteOrder.BIG_ENDIAN;
        byte[] bArr = jad_wj;
        jad_boVar.skipBytes(bArr.length);
        int length = bArr.length;
        while (true) {
            try {
                int i = jad_boVar.readInt();
                byte[] bArr2 = new byte[4];
                if (jad_boVar.read(bArr2) == 4) {
                    int i2 = length + 8;
                    if (i2 == 16 && !Arrays.equals(bArr2, jad_yl)) {
                        throw new IOException("Encountered invalid PNG file--IHDR chunk should appearas the first chunk");
                    }
                    if (Arrays.equals(bArr2, jad_zm)) {
                        return;
                    }
                    if (Arrays.equals(bArr2, jad_xk)) {
                        byte[] bArr3 = new byte[i];
                        if (jad_boVar.read(bArr3) == i) {
                            int i3 = jad_boVar.readInt();
                            CRC32 crc32 = new CRC32();
                            crc32.update(bArr2);
                            crc32.update(bArr3);
                            if (((int) crc32.getValue()) == i3) {
                                this.jad_iv = i2;
                                jad_an(bArr3, 0);
                                jad_cp();
                                return;
                            }
                            throw new IOException("Encountered invalid CRC value for PNG-EXIF chunk.\n recorded CRC value: " + i3 + ", calculated CRC value: " + crc32.getValue());
                        }
                        throw new IOException("Failed to read given length for given PNG chunk type: " + jad_an(bArr2));
                    }
                    int i4 = i + 4;
                    jad_boVar.skipBytes(i4);
                    length = i2 + i4;
                } else {
                    throw new IOException("Encountered invalid length while parsing PNG chunktype");
                }
            } catch (EOFException unused) {
                throw new IOException("Encountered corrupt PNG file.");
            }
        }
    }

    public final boolean jad_bo(byte[] bArr) throws Throwable {
        jad_bo jad_boVar = null;
        try {
            jad_bo jad_boVar2 = new jad_bo(bArr);
            try {
                ByteOrder byteOrderJad_iv = jad_iv(jad_boVar2);
                this.jad_jt = byteOrderJad_iv;
                jad_boVar2.jad_bo = byteOrderJad_iv;
                short s = jad_boVar2.readShort();
                boolean z = s == 20306 || s == 21330;
                jad_boVar2.close();
                return z;
            } catch (Exception unused) {
                jad_boVar = jad_boVar2;
                if (jad_boVar != null) {
                    jad_boVar.close();
                }
                return false;
            } catch (Throwable th) {
                th = th;
                jad_boVar = jad_boVar2;
                if (jad_boVar != null) {
                    jad_boVar.close();
                }
                throw th;
            }
        } catch (Exception unused2) {
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public final void jad_an(InputStream inputStream) {
        if (inputStream != null) {
            for (int i = 0; i < jad_ju.length; i++) {
                try {
                    try {
                        this.jad_er[i] = new HashMap<>();
                    } catch (IOException e) {
                        boolean z = jad_na;
                        if (z) {
                            Log.w("ExifInterface", "Invalid image: ExifInterface got an unsupported image format file(ExifInterface supports JPEG and some RAW image formats only) or a corrupted JPEG file to ExifInterface.", e);
                        }
                        jad_an();
                        if (!z) {
                            return;
                        }
                    }
                } catch (Throwable th) {
                    jad_an();
                    if (jad_na) {
                        jad_bo();
                    }
                    throw th;
                }
            }
            if (!this.jad_dq) {
                BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream, 5000);
                this.jad_cp = jad_an(bufferedInputStream);
                inputStream = bufferedInputStream;
            }
            jad_bo jad_boVar = new jad_bo(inputStream, ByteOrder.BIG_ENDIAN);
            if (!this.jad_dq) {
                switch (this.jad_cp) {
                    case 0:
                    case 1:
                    case 2:
                    case 3:
                    case 5:
                    case 6:
                    case 8:
                    case 11:
                        jad_er(jad_boVar);
                        break;
                    case 4:
                        jad_an(jad_boVar, 0, 0);
                        break;
                    case 7:
                        jad_bo(jad_boVar);
                        break;
                    case 9:
                        jad_dq(jad_boVar);
                        break;
                    case 10:
                        jad_fs(jad_boVar);
                        break;
                    case 12:
                        jad_an(jad_boVar);
                        break;
                    case 13:
                        jad_cp(jad_boVar);
                        break;
                    case 14:
                        jad_hu(jad_boVar);
                        break;
                }
            } else {
                jad_jt(jad_boVar);
            }
            jad_jw(jad_boVar);
            jad_an();
            if (!jad_na) {
                return;
            }
            jad_bo();
            return;
        }
        throw new NullPointerException("inputstream shouldn't be null");
    }

    public static boolean jad_bo(BufferedInputStream bufferedInputStream) throws IOException {
        byte[] bArr = jad_qb;
        bufferedInputStream.mark(bArr.length);
        byte[] bArr2 = new byte[bArr.length];
        bufferedInputStream.read(bArr2);
        bufferedInputStream.reset();
        int i = 0;
        while (true) {
            byte[] bArr3 = jad_qb;
            if (i >= bArr3.length) {
                return true;
            }
            if (bArr2[i] != bArr3[i]) {
                return false;
            }
            i++;
        }
    }

    public final void jad_bo(jad_bo jad_boVar) throws Throwable {
        int i;
        int i2;
        jad_er(jad_boVar);
        jad_cp jad_cpVar = this.jad_er[1].get(ExifInterface.TAG_MAKER_NOTE);
        if (jad_cpVar != null) {
            jad_bo jad_boVar2 = new jad_bo(jad_cpVar.jad_cp);
            jad_boVar2.jad_bo = this.jad_jt;
            byte[] bArr = jad_uh;
            byte[] bArr2 = new byte[bArr.length];
            jad_boVar2.readFully(bArr2);
            jad_boVar2.jad_bo(0L);
            byte[] bArr3 = jad_vi;
            byte[] bArr4 = new byte[bArr3.length];
            jad_boVar2.readFully(bArr4);
            if (Arrays.equals(bArr2, bArr)) {
                jad_boVar2.jad_bo(8L);
            } else if (Arrays.equals(bArr4, bArr3)) {
                jad_boVar2.jad_bo(12L);
            }
            jad_bo(jad_boVar2, 6);
            jad_cp jad_cpVar2 = this.jad_er[7].get(ExifInterface.TAG_ORF_PREVIEW_IMAGE_START);
            jad_cp jad_cpVar3 = this.jad_er[7].get(ExifInterface.TAG_ORF_PREVIEW_IMAGE_LENGTH);
            if (jad_cpVar2 != null && jad_cpVar3 != null) {
                this.jad_er[5].put(ExifInterface.TAG_JPEG_INTERCHANGE_FORMAT, jad_cpVar2);
                this.jad_er[5].put(ExifInterface.TAG_JPEG_INTERCHANGE_FORMAT_LENGTH, jad_cpVar3);
            }
            jad_cp jad_cpVar4 = this.jad_er[8].get(ExifInterface.TAG_ORF_ASPECT_FRAME);
            if (jad_cpVar4 != null) {
                int[] iArr = (int[]) jad_cpVar4.jad_dq(this.jad_jt);
                if (iArr != null && iArr.length == 4) {
                    int i3 = iArr[2];
                    int i4 = iArr[0];
                    if (i3 <= i4 || (i = iArr[3]) <= (i2 = iArr[1])) {
                        return;
                    }
                    int i5 = (i3 - i4) + 1;
                    int i6 = (i - i2) + 1;
                    if (i5 < i6) {
                        int i7 = i5 + i6;
                        i6 = i7 - i6;
                        i5 = i7 - i6;
                    }
                    jad_cp jad_cpVarJad_an = jad_cp.jad_an(i5, this.jad_jt);
                    jad_cp jad_cpVarJad_an2 = jad_cp.jad_an(i6, this.jad_jt);
                    this.jad_er[0].put(ExifInterface.TAG_IMAGE_WIDTH, jad_cpVarJad_an);
                    this.jad_er[0].put(ExifInterface.TAG_IMAGE_LENGTH, jad_cpVarJad_an2);
                    return;
                }
                Log.w("ExifInterface", com.jd.ad.sdk.jad_bo.jad_bo.jad_an("Invalid aspect frame values. frame=").append(Arrays.toString(iArr)).toString());
            }
        }
    }

    public final void jad_dq(jad_bo jad_boVar, int i) throws Throwable {
        jad_cp jad_cpVarJad_an;
        jad_cp jad_cpVarJad_an2;
        jad_cp jad_cpVar = this.jad_er[i].get(ExifInterface.TAG_DEFAULT_CROP_SIZE);
        jad_cp jad_cpVar2 = this.jad_er[i].get(ExifInterface.TAG_RW2_SENSOR_TOP_BORDER);
        jad_cp jad_cpVar3 = this.jad_er[i].get(ExifInterface.TAG_RW2_SENSOR_LEFT_BORDER);
        jad_cp jad_cpVar4 = this.jad_er[i].get(ExifInterface.TAG_RW2_SENSOR_BOTTOM_BORDER);
        jad_cp jad_cpVar5 = this.jad_er[i].get(ExifInterface.TAG_RW2_SENSOR_RIGHT_BORDER);
        if (jad_cpVar != null) {
            if (jad_cpVar.jad_an == 5) {
                jad_er[] jad_erVarArr = (jad_er[]) jad_cpVar.jad_dq(this.jad_jt);
                if (jad_erVarArr != null && jad_erVarArr.length == 2) {
                    jad_cpVarJad_an = jad_cp.jad_an(jad_erVarArr[0], this.jad_jt);
                    jad_cpVarJad_an2 = jad_cp.jad_an(jad_erVarArr[1], this.jad_jt);
                } else {
                    Log.w("ExifInterface", com.jd.ad.sdk.jad_bo.jad_bo.jad_an("Invalid crop size values. cropSize=").append(Arrays.toString(jad_erVarArr)).toString());
                    return;
                }
            } else {
                int[] iArr = (int[]) jad_cpVar.jad_dq(this.jad_jt);
                if (iArr != null && iArr.length == 2) {
                    jad_cpVarJad_an = jad_cp.jad_an(iArr[0], this.jad_jt);
                    jad_cpVarJad_an2 = jad_cp.jad_an(iArr[1], this.jad_jt);
                } else {
                    Log.w("ExifInterface", com.jd.ad.sdk.jad_bo.jad_bo.jad_an("Invalid crop size values. cropSize=").append(Arrays.toString(iArr)).toString());
                    return;
                }
            }
            this.jad_er[i].put(ExifInterface.TAG_IMAGE_WIDTH, jad_cpVarJad_an);
            this.jad_er[i].put(ExifInterface.TAG_IMAGE_LENGTH, jad_cpVarJad_an2);
            return;
        }
        if (jad_cpVar2 != null && jad_cpVar3 != null && jad_cpVar4 != null && jad_cpVar5 != null) {
            int iJad_bo = jad_cpVar2.jad_bo(this.jad_jt);
            int iJad_bo2 = jad_cpVar4.jad_bo(this.jad_jt);
            int iJad_bo3 = jad_cpVar5.jad_bo(this.jad_jt);
            int iJad_bo4 = jad_cpVar3.jad_bo(this.jad_jt);
            if (iJad_bo2 <= iJad_bo || iJad_bo3 <= iJad_bo4) {
                return;
            }
            jad_cp jad_cpVarJad_an3 = jad_cp.jad_an(iJad_bo2 - iJad_bo, this.jad_jt);
            jad_cp jad_cpVarJad_an4 = jad_cp.jad_an(iJad_bo3 - iJad_bo4, this.jad_jt);
            this.jad_er[i].put(ExifInterface.TAG_IMAGE_LENGTH, jad_cpVarJad_an3);
            this.jad_er[i].put(ExifInterface.TAG_IMAGE_WIDTH, jad_cpVarJad_an4);
            return;
        }
        jad_cp(jad_boVar, i);
    }

    /* JADX WARN: Code duplicated, block: B:101:0x0216  */
    /* JADX WARN: Code duplicated, block: B:102:0x021c A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:103:0x021e  */
    /* JADX WARN: Code duplicated, block: B:105:0x0237  */
    /* JADX WARN: Code duplicated, block: B:108:0x024d  */
    /* JADX WARN: Code duplicated, block: B:110:0x026b  */
    /* JADX WARN: Code duplicated, block: B:112:0x0270  */
    /* JADX WARN: Code duplicated, block: B:114:0x0273  */
    /* JADX WARN: Code duplicated, block: B:116:0x0277  */
    /* JADX WARN: Code duplicated, block: B:118:0x027b  */
    /* JADX WARN: Code duplicated, block: B:122:0x0287  */
    /* JADX WARN: Code duplicated, block: B:123:0x028c  */
    /* JADX WARN: Code duplicated, block: B:124:0x0291  */
    /* JADX WARN: Code duplicated, block: B:127:0x0298  */
    /* JADX WARN: Code duplicated, block: B:130:0x02b1  */
    /* JADX WARN: Code duplicated, block: B:137:0x02f5 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:138:0x02f7  */
    /* JADX WARN: Code duplicated, block: B:140:0x030e  */
    /* JADX WARN: Code duplicated, block: B:142:0x033e  */
    /* JADX WARN: Code duplicated, block: B:145:0x034b  */
    /* JADX WARN: Code duplicated, block: B:147:0x0355  */
    /* JADX WARN: Code duplicated, block: B:156:0x0381  */
    /* JADX WARN: Code duplicated, block: B:185:0x0384 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:76:0x0166  */
    /* JADX WARN: Code duplicated, block: B:77:0x016d  */
    /* JADX WARN: Code duplicated, block: B:79:0x0173  */
    /* JADX WARN: Code duplicated, block: B:81:0x017b  */
    /* JADX WARN: Code duplicated, block: B:82:0x0190  */
    /* JADX WARN: Code duplicated, block: B:85:0x0197  */
    /* JADX WARN: Code duplicated, block: B:87:0x01a1  */
    /* JADX WARN: Code duplicated, block: B:88:0x01a4  */
    /* JADX WARN: Code duplicated, block: B:90:0x01a7  */
    /* JADX WARN: Code duplicated, block: B:94:0x01f6  */
    /* JADX WARN: Code duplicated, block: B:96:0x0200  */
    public final void jad_bo(jad_bo jad_boVar, int i) throws IOException {
        char c;
        short s;
        short s2;
        int i2;
        long j;
        short s3;
        int i3;
        int i4;
        Integer num;
        int i5;
        int unsignedShort;
        long jJad_bo;
        int i6;
        int i7;
        long j2;
        long j3;
        this.jad_fs.add(Integer.valueOf(jad_boVar.jad_dq));
        if (jad_boVar.jad_dq + 2 > jad_boVar.jad_cp) {
            return;
        }
        short s4 = jad_boVar.readShort();
        if (jad_na) {
            Log.d("ExifInterface", "numberOfDirectoryEntry: " + ((int) s4));
        }
        if ((s4 * 12) + jad_boVar.jad_dq > jad_boVar.jad_cp || s4 <= 0) {
            return;
        }
        char c2 = 0;
        short s5 = 0;
        while (s5 < s4) {
            int unsignedShort2 = jad_boVar.readUnsignedShort();
            int unsignedShort3 = jad_boVar.readUnsignedShort();
            int i8 = jad_boVar.readInt();
            long j4 = ((long) jad_boVar.jad_dq) + 4;
            jad_dq jad_dqVar = jad_lw[i].get(Integer.valueOf(unsignedShort2));
            boolean z = jad_na;
            boolean z2 = true;
            if (z) {
                Object[] objArr = new Object[5];
                objArr[c2] = Integer.valueOf(i);
                objArr[1] = Integer.valueOf(unsignedShort2);
                c = 2;
                objArr[2] = jad_dqVar != null ? jad_dqVar.jad_bo : null;
                objArr[3] = Integer.valueOf(unsignedShort3);
                objArr[4] = Integer.valueOf(i8);
                Log.d("ExifInterface", String.format("ifdType: %d, tagNumber: %d, tagName: %s, dataFormat: %d, numberOfComponents: %d", objArr));
            } else {
                c = 2;
            }
            if (jad_dqVar == null) {
                if (z) {
                    Log.d("ExifInterface", "Skip the tag entry since tag number is not defined: " + unsignedShort2);
                }
                s = s4;
            } else {
                if (unsignedShort3 > 0) {
                    int[] iArr = jad_gr;
                    if (unsignedShort3 < iArr.length) {
                        int i9 = jad_dqVar.jad_cp;
                        if (i9 == 7 || unsignedShort3 == 7 || i9 == unsignedShort3) {
                            s = s4;
                            i2 = 7;
                        } else {
                            int i10 = jad_dqVar.jad_dq;
                            s = s4;
                            if (i10 == unsignedShort3 || (((i9 == 4 || i10 == 4) && unsignedShort3 == 3) || (((i9 == 9 || i10 == 9) && unsignedShort3 == 8) || ((i9 == 12 || i10 == 12) && unsignedShort3 == 11)))) {
                                i2 = 7;
                            } else if (z) {
                                Log.d("ExifInterface", com.jd.ad.sdk.jad_bo.jad_bo.jad_an("Skip the tag entry since data format (").append(jad_fq[unsignedShort3]).append(") is unexpected for tag: ").append(jad_dqVar.jad_bo).toString());
                            }
                        }
                        if (unsignedShort3 == i2) {
                            unsignedShort3 = i9;
                        }
                        s2 = s5;
                        j = ((long) iArr[unsignedShort3]) * ((long) i8);
                        if (j < 0 || j > 2147483647L) {
                            if (z) {
                                Log.d("ExifInterface", "Skip the tag entry since the number of components is invalid: " + i8);
                            }
                            z2 = false;
                        }
                    }
                    if (!z2) {
                        jad_boVar.jad_bo(j4);
                        s3 = s2;
                    } else {
                        if (j > 4) {
                            i6 = jad_boVar.readInt();
                            s3 = s2;
                            if (z) {
                                Log.d("ExifInterface", "seek to data offset: " + i6);
                            }
                            i7 = this.jad_cp;
                            if (i7 == 7) {
                                if (ExifInterface.TAG_MAKER_NOTE.equals(jad_dqVar.jad_bo)) {
                                    this.jad_jw = i6;
                                } else if (i != 6 && ExifInterface.TAG_ORF_THUMBNAIL_IMAGE.equals(jad_dqVar.jad_bo)) {
                                    this.jad_kx = i6;
                                    this.jad_ly = i8;
                                    jad_cp jad_cpVarJad_an = jad_cp.jad_an(6, this.jad_jt);
                                    i3 = unsignedShort2;
                                    i4 = i8;
                                    jad_cp jad_cpVarJad_an2 = jad_cp.jad_an(this.jad_kx, this.jad_jt);
                                    j2 = j4;
                                    jad_cp jad_cpVarJad_an3 = jad_cp.jad_an(this.jad_ly, this.jad_jt);
                                    this.jad_er[4].put(ExifInterface.TAG_COMPRESSION, jad_cpVarJad_an);
                                    this.jad_er[4].put(ExifInterface.TAG_JPEG_INTERCHANGE_FORMAT, jad_cpVarJad_an2);
                                    this.jad_er[4].put(ExifInterface.TAG_JPEG_INTERCHANGE_FORMAT_LENGTH, jad_cpVarJad_an3);
                                }
                                j2 = j4;
                                i3 = unsignedShort2;
                                i4 = i8;
                            } else {
                                j2 = j4;
                                i3 = unsignedShort2;
                                i4 = i8;
                                if (i7 == 10 && ExifInterface.TAG_RW2_JPG_FROM_RAW.equals(jad_dqVar.jad_bo)) {
                                    this.jad_mz = i6;
                                }
                            }
                            j3 = i6;
                            if (j3 + j <= jad_boVar.jad_cp) {
                                jad_boVar.jad_bo(j3);
                                j4 = j2;
                            } else {
                                if (z) {
                                    Log.d("ExifInterface", "Skip the tag entry since data offset is invalid: " + i6);
                                }
                                jad_boVar.jad_bo(j2);
                            }
                        } else {
                            s3 = s2;
                            i3 = unsignedShort2;
                            unsignedShort3 = unsignedShort3;
                            i4 = i8;
                        }
                        num = jad_oz.get(Integer.valueOf(i3));
                        if (z) {
                            Log.d("ExifInterface", "nextIfdType: " + num + " byteCount: " + j);
                        }
                        if (num != null) {
                            i5 = unsignedShort3;
                            if (i5 == 3) {
                                unsignedShort = jad_boVar.readUnsignedShort();
                            } else {
                                if (i5 == 4) {
                                    jJad_bo = jad_boVar.jad_bo();
                                } else if (i5 == 8) {
                                    unsignedShort = jad_boVar.readShort();
                                } else if (i5 != 9 || i5 == 13) {
                                    unsignedShort = jad_boVar.readInt();
                                } else {
                                    jJad_bo = -1;
                                }
                                if (z) {
                                    Log.d("ExifInterface", String.format("Offset: %d, tagName: %s", Long.valueOf(jJad_bo), jad_dqVar.jad_bo));
                                }
                                if (jJad_bo > 0 || jJad_bo >= jad_boVar.jad_cp) {
                                    if (z) {
                                        Log.d("ExifInterface", "Skip jump into the IFD since its offset is invalid: " + jJad_bo);
                                    }
                                } else if (!this.jad_fs.contains(Integer.valueOf((int) jJad_bo))) {
                                    jad_boVar.jad_bo(jJad_bo);
                                    jad_bo(jad_boVar, num.intValue());
                                } else if (z) {
                                    Log.d("ExifInterface", "Skip jump into the IFD since it has already been read: IfdType " + num + " (at " + jJad_bo + ")");
                                }
                                jad_boVar.jad_bo(j4);
                            }
                            jJad_bo = unsignedShort;
                            if (z) {
                                Log.d("ExifInterface", String.format("Offset: %d, tagName: %s", Long.valueOf(jJad_bo), jad_dqVar.jad_bo));
                            }
                            if (jJad_bo > 0) {
                                if (z) {
                                    Log.d("ExifInterface", "Skip jump into the IFD since its offset is invalid: " + jJad_bo);
                                }
                            } else if (z) {
                                Log.d("ExifInterface", "Skip jump into the IFD since its offset is invalid: " + jJad_bo);
                            }
                            jad_boVar.jad_bo(j4);
                        } else {
                            int i11 = jad_boVar.jad_dq + this.jad_iv;
                            byte[] bArr = new byte[(int) j];
                            jad_boVar.readFully(bArr);
                            jad_cp jad_cpVar = new jad_cp(unsignedShort3, i4, i11, bArr);
                            this.jad_er[i].put(jad_dqVar.jad_bo, jad_cpVar);
                            if (ExifInterface.TAG_DNG_VERSION.equals(jad_dqVar.jad_bo)) {
                                this.jad_cp = 3;
                            }
                            if (((!ExifInterface.TAG_MAKE.equals(jad_dqVar.jad_bo) || ExifInterface.TAG_MODEL.equals(jad_dqVar.jad_bo)) && jad_cpVar.jad_cp(this.jad_jt).contains("PENTAX")) || (ExifInterface.TAG_COMPRESSION.equals(jad_dqVar.jad_bo) && jad_cpVar.jad_bo(this.jad_jt) == 65535)) {
                                this.jad_cp = 8;
                            }
                            if (jad_boVar.jad_dq != j4) {
                                jad_boVar.jad_bo(j4);
                            }
                        }
                    }
                    s5 = (short) (s3 + 1);
                    s4 = s;
                    c2 = 0;
                }
                s = s4;
                s2 = s5;
                if (z) {
                    Log.d("ExifInterface", "Skip the tag entry since data format is invalid: " + unsignedShort3);
                }
                j = 0;
                z2 = false;
                if (!z2) {
                    jad_boVar.jad_bo(j4);
                    s3 = s2;
                } else {
                    if (j > 4) {
                        i6 = jad_boVar.readInt();
                        s3 = s2;
                        if (z) {
                            Log.d("ExifInterface", "seek to data offset: " + i6);
                        }
                        i7 = this.jad_cp;
                        if (i7 == 7) {
                            if (ExifInterface.TAG_MAKER_NOTE.equals(jad_dqVar.jad_bo)) {
                                this.jad_jw = i6;
                            } else if (i != 6) {
                            }
                            j2 = j4;
                            i3 = unsignedShort2;
                            i4 = i8;
                        } else {
                            j2 = j4;
                            i3 = unsignedShort2;
                            i4 = i8;
                            if (i7 == 10) {
                                this.jad_mz = i6;
                            }
                        }
                        j3 = i6;
                        if (j3 + j <= jad_boVar.jad_cp) {
                            jad_boVar.jad_bo(j3);
                            j4 = j2;
                        } else {
                            if (z) {
                                Log.d("ExifInterface", "Skip the tag entry since data offset is invalid: " + i6);
                            }
                            jad_boVar.jad_bo(j2);
                        }
                    } else {
                        s3 = s2;
                        i3 = unsignedShort2;
                        unsignedShort3 = unsignedShort3;
                        i4 = i8;
                    }
                    num = jad_oz.get(Integer.valueOf(i3));
                    if (z) {
                        Log.d("ExifInterface", "nextIfdType: " + num + " byteCount: " + j);
                    }
                    if (num != null) {
                        i5 = unsignedShort3;
                        if (i5 == 3) {
                            unsignedShort = jad_boVar.readUnsignedShort();
                        } else {
                            if (i5 == 4) {
                                jJad_bo = jad_boVar.jad_bo();
                            } else if (i5 == 8) {
                                if (i5 != 9) {
                                }
                                unsignedShort = jad_boVar.readInt();
                            } else {
                                unsignedShort = jad_boVar.readShort();
                            }
                            if (z) {
                                Log.d("ExifInterface", String.format("Offset: %d, tagName: %s", Long.valueOf(jJad_bo), jad_dqVar.jad_bo));
                            }
                            if (jJad_bo > 0) {
                                if (z) {
                                    Log.d("ExifInterface", "Skip jump into the IFD since its offset is invalid: " + jJad_bo);
                                }
                            } else if (z) {
                                Log.d("ExifInterface", "Skip jump into the IFD since its offset is invalid: " + jJad_bo);
                            }
                            jad_boVar.jad_bo(j4);
                        }
                        jJad_bo = unsignedShort;
                        if (z) {
                            Log.d("ExifInterface", String.format("Offset: %d, tagName: %s", Long.valueOf(jJad_bo), jad_dqVar.jad_bo));
                        }
                        if (jJad_bo > 0) {
                            if (z) {
                                Log.d("ExifInterface", "Skip jump into the IFD since its offset is invalid: " + jJad_bo);
                            }
                        } else if (z) {
                            Log.d("ExifInterface", "Skip jump into the IFD since its offset is invalid: " + jJad_bo);
                        }
                        jad_boVar.jad_bo(j4);
                    } else {
                        int i12 = jad_boVar.jad_dq + this.jad_iv;
                        byte[] bArr2 = new byte[(int) j];
                        jad_boVar.readFully(bArr2);
                        jad_cp jad_cpVar2 = new jad_cp(unsignedShort3, i4, i12, bArr2);
                        this.jad_er[i].put(jad_dqVar.jad_bo, jad_cpVar2);
                        if (ExifInterface.TAG_DNG_VERSION.equals(jad_dqVar.jad_bo)) {
                            this.jad_cp = 3;
                        }
                        if (!ExifInterface.TAG_MAKE.equals(jad_dqVar.jad_bo)) {
                        }
                        this.jad_cp = 8;
                        if (jad_boVar.jad_dq != j4) {
                            jad_boVar.jad_bo(j4);
                        }
                    }
                }
                s5 = (short) (s3 + 1);
                s4 = s;
                c2 = 0;
            }
            s2 = s5;
            j = 0;
            z2 = false;
            if (!z2) {
                jad_boVar.jad_bo(j4);
                s3 = s2;
            } else {
                if (j > 4) {
                    i6 = jad_boVar.readInt();
                    s3 = s2;
                    if (z) {
                        Log.d("ExifInterface", "seek to data offset: " + i6);
                    }
                    i7 = this.jad_cp;
                    if (i7 == 7) {
                        if (ExifInterface.TAG_MAKER_NOTE.equals(jad_dqVar.jad_bo)) {
                            this.jad_jw = i6;
                        } else if (i != 6) {
                        }
                        j2 = j4;
                        i3 = unsignedShort2;
                        i4 = i8;
                    } else {
                        j2 = j4;
                        i3 = unsignedShort2;
                        i4 = i8;
                        if (i7 == 10) {
                            this.jad_mz = i6;
                        }
                    }
                    j3 = i6;
                    if (j3 + j <= jad_boVar.jad_cp) {
                        jad_boVar.jad_bo(j3);
                        j4 = j2;
                    } else {
                        if (z) {
                            Log.d("ExifInterface", "Skip the tag entry since data offset is invalid: " + i6);
                        }
                        jad_boVar.jad_bo(j2);
                    }
                } else {
                    s3 = s2;
                    i3 = unsignedShort2;
                    unsignedShort3 = unsignedShort3;
                    i4 = i8;
                }
                num = jad_oz.get(Integer.valueOf(i3));
                if (z) {
                    Log.d("ExifInterface", "nextIfdType: " + num + " byteCount: " + j);
                }
                if (num != null) {
                    i5 = unsignedShort3;
                    if (i5 == 3) {
                        unsignedShort = jad_boVar.readUnsignedShort();
                    } else {
                        if (i5 == 4) {
                            jJad_bo = jad_boVar.jad_bo();
                        } else if (i5 == 8) {
                            if (i5 != 9) {
                            }
                            unsignedShort = jad_boVar.readInt();
                        } else {
                            unsignedShort = jad_boVar.readShort();
                        }
                        if (z) {
                            Log.d("ExifInterface", String.format("Offset: %d, tagName: %s", Long.valueOf(jJad_bo), jad_dqVar.jad_bo));
                        }
                        if (jJad_bo > 0) {
                            if (z) {
                                Log.d("ExifInterface", "Skip jump into the IFD since its offset is invalid: " + jJad_bo);
                            }
                        } else if (z) {
                            Log.d("ExifInterface", "Skip jump into the IFD since its offset is invalid: " + jJad_bo);
                        }
                        jad_boVar.jad_bo(j4);
                    }
                    jJad_bo = unsignedShort;
                    if (z) {
                        Log.d("ExifInterface", String.format("Offset: %d, tagName: %s", Long.valueOf(jJad_bo), jad_dqVar.jad_bo));
                    }
                    if (jJad_bo > 0) {
                        if (z) {
                            Log.d("ExifInterface", "Skip jump into the IFD since its offset is invalid: " + jJad_bo);
                        }
                    } else if (z) {
                        Log.d("ExifInterface", "Skip jump into the IFD since its offset is invalid: " + jJad_bo);
                    }
                    jad_boVar.jad_bo(j4);
                } else {
                    int i13 = jad_boVar.jad_dq + this.jad_iv;
                    byte[] bArr3 = new byte[(int) j];
                    jad_boVar.readFully(bArr3);
                    jad_cp jad_cpVar3 = new jad_cp(unsignedShort3, i4, i13, bArr3);
                    this.jad_er[i].put(jad_dqVar.jad_bo, jad_cpVar3);
                    if (ExifInterface.TAG_DNG_VERSION.equals(jad_dqVar.jad_bo)) {
                        this.jad_cp = 3;
                    }
                    if (!ExifInterface.TAG_MAKE.equals(jad_dqVar.jad_bo)) {
                    }
                    this.jad_cp = 8;
                    if (jad_boVar.jad_dq != j4) {
                        jad_boVar.jad_bo(j4);
                    }
                }
            }
            s5 = (short) (s3 + 1);
            s4 = s;
            c2 = 0;
        }
        if (jad_boVar.jad_dq + 4 <= jad_boVar.jad_cp) {
            int i14 = jad_boVar.readInt();
            boolean z3 = jad_na;
            if (z3) {
                Log.d("ExifInterface", String.format("nextIfdOffset: %d", Integer.valueOf(i14)));
            }
            long j5 = i14;
            if (j5 <= 0 || i14 >= jad_boVar.jad_cp) {
                if (z3) {
                    Log.d("ExifInterface", "Stop reading file since a wrong offset may cause an infinite loop: " + i14);
                }
            } else {
                if (this.jad_fs.contains(Integer.valueOf(i14))) {
                    if (z3) {
                        Log.d("ExifInterface", "Stop reading file since re-reading an IFD may cause an infinite loop: " + i14);
                        return;
                    }
                    return;
                }
                jad_boVar.jad_bo(j5);
                if (this.jad_er[4].isEmpty()) {
                    jad_bo(jad_boVar, 4);
                } else if (this.jad_er[5].isEmpty()) {
                    jad_bo(jad_boVar, 5);
                }
            }
        }
    }

    public final void jad_cp(jad_bo jad_boVar, int i) throws IOException {
        jad_cp jad_cpVar;
        jad_cp jad_cpVar2 = this.jad_er[i].get(ExifInterface.TAG_IMAGE_LENGTH);
        jad_cp jad_cpVar3 = this.jad_er[i].get(ExifInterface.TAG_IMAGE_WIDTH);
        if ((jad_cpVar2 == null || jad_cpVar3 == null) && (jad_cpVar = this.jad_er[i].get(ExifInterface.TAG_JPEG_INTERCHANGE_FORMAT)) != null) {
            jad_an(jad_boVar, jad_cpVar.jad_bo(this.jad_jt), i);
        }
    }

    public static boolean jad_an(FileDescriptor fileDescriptor) {
        try {
            Os.lseek(fileDescriptor, 0L, OsConstants.SEEK_CUR);
            return true;
        } catch (Exception unused) {
            if (!jad_na) {
                return false;
            }
            Log.d("ExifInterface", "The file descriptor for the given input is not seekable");
            return false;
        }
    }

    public final void jad_cp() throws Throwable {
        jad_an(0, 5);
        jad_an(0, 4);
        jad_an(5, 4);
        jad_cp jad_cpVar = this.jad_er[1].get(ExifInterface.TAG_PIXEL_X_DIMENSION);
        jad_cp jad_cpVar2 = this.jad_er[1].get(ExifInterface.TAG_PIXEL_Y_DIMENSION);
        if (jad_cpVar != null && jad_cpVar2 != null) {
            this.jad_er[0].put(ExifInterface.TAG_IMAGE_WIDTH, jad_cpVar);
            this.jad_er[0].put(ExifInterface.TAG_IMAGE_LENGTH, jad_cpVar2);
        }
        if (this.jad_er[4].isEmpty() && jad_an((HashMap) this.jad_er[5])) {
            HashMap<String, jad_cp>[] mapArr = this.jad_er;
            mapArr[4] = mapArr[5];
            mapArr[5] = new HashMap<>();
        }
        if (jad_an((HashMap) this.jad_er[4])) {
            return;
        }
        Log.d("ExifInterface", "No image meets the size requirements of a thumbnail image.");
    }

    /* JADX WARN: Code duplicated, block: B:112:0x0111 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:113:0x00e2 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:114:0x00f3 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:115:0x00ee A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:116:0x010a A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:117:0x00ee A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:64:0x00cb A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:66:0x00cd  */
    /* JADX WARN: Code duplicated, block: B:68:0x00d3 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:70:0x00d6  */
    /* JADX WARN: Code duplicated, block: B:73:0x00dc  */
    /* JADX WARN: Code duplicated, block: B:78:0x00e8  */
    /* JADX WARN: Code duplicated, block: B:81:0x00f0 A[LOOP:3: B:76:0x00e3->B:81:0x00f0, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:85:0x00f9  */
    /* JADX WARN: Code duplicated, block: B:89:0x0106 A[LOOP:4: B:83:0x00f4->B:89:0x0106, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:92:0x010d A[LOOP:2: B:71:0x00d7->B:92:0x010d, LOOP_END] */
    public final int jad_an(BufferedInputStream bufferedInputStream) throws Throwable {
        jad_bo jad_boVar;
        int i;
        byte[] bArr;
        int i2;
        byte[] bArr2;
        int i3;
        byte[] bArr3;
        long j;
        bufferedInputStream.mark(5000);
        byte[] bArr4 = new byte[5000];
        bufferedInputStream.read(bArr4);
        bufferedInputStream.reset();
        int i4 = 0;
        while (true) {
            byte[] bArr5 = jad_qd;
            if (i4 >= bArr5.length) {
                return 4;
            }
            if (bArr4[i4] != bArr5[i4]) {
                byte[] bytes = "FUJIFILMCCD-RAW".getBytes(Charset.defaultCharset());
                for (int i5 = 0; i5 < bytes.length; i5++) {
                    if (bArr4[i5] != bytes[i5]) {
                        jad_bo jad_boVar2 = null;
                        try {
                            try {
                                jad_boVar = new jad_bo(bArr4);
                                try {
                                    long j2 = jad_boVar.readInt();
                                    byte[] bArr6 = new byte[4];
                                    jad_boVar.read(bArr6);
                                    if (Arrays.equals(bArr6, jad_re)) {
                                        if (j2 == 1) {
                                            j2 = jad_boVar.readLong();
                                            j = 16;
                                            if (j2 < 16) {
                                            }
                                        } else {
                                            j = 8;
                                        }
                                        long j3 = 5000;
                                        if (j2 > j3) {
                                            j2 = j3;
                                        }
                                        long j4 = j2 - j;
                                        if (j4 >= 8) {
                                            byte[] bArr7 = new byte[4];
                                            long j5 = 0;
                                            boolean z = false;
                                            boolean z2 = false;
                                            while (true) {
                                                if (j5 >= j4 / 4) {
                                                    jad_boVar.close();
                                                    break;
                                                }
                                                if (jad_boVar.read(bArr7) == 4) {
                                                    if (j5 != 1) {
                                                        if (Arrays.equals(bArr7, jad_sf)) {
                                                            z = true;
                                                        } else if (Arrays.equals(bArr7, jad_tg)) {
                                                            z2 = true;
                                                        }
                                                        if (z && z2) {
                                                            jad_boVar.close();
                                                            return 12;
                                                        }
                                                    }
                                                    j5++;
                                                }
                                            }
                                            if (jad_bo(bArr4)) {
                                                return 7;
                                            }
                                            if (jad_cp(bArr4)) {
                                                return 10;
                                            }
                                            i = 0;
                                            while (true) {
                                                bArr = jad_wj;
                                                if (i < bArr.length) {
                                                    return 13;
                                                }
                                                if (bArr4[i] != bArr[i]) {
                                                    i2 = 0;
                                                    while (true) {
                                                        bArr2 = jad_cn;
                                                        if (i2 < bArr2.length) {
                                                            i3 = 0;
                                                            while (true) {
                                                                bArr3 = jad_do;
                                                                if (i3 < bArr3.length) {
                                                                    return 14;
                                                                }
                                                                if (bArr4[jad_cn.length + i3 + 4] != bArr3[i3]) {
                                                                    return 0;
                                                                }
                                                                i3++;
                                                            }
                                                        } else {
                                                            if (bArr4[i2] != bArr2[i2]) {
                                                                return 0;
                                                            }
                                                            i2++;
                                                        }
                                                    }
                                                } else {
                                                    i++;
                                                }
                                            }
                                        }
                                    }
                                    jad_boVar.close();
                                    break;
                                } catch (Exception e) {
                                    e = e;
                                    jad_boVar2 = jad_boVar;
                                    if (jad_na) {
                                        Log.d("ExifInterface", "Exception parsing HEIF file type box.", e);
                                    }
                                    if (jad_boVar2 != null) {
                                        jad_boVar2.close();
                                    }
                                } catch (Throwable th) {
                                    th = th;
                                    if (jad_boVar != null) {
                                        jad_boVar.close();
                                    }
                                    throw th;
                                }
                            } catch (Throwable th2) {
                                th = th2;
                                jad_boVar = null;
                            }
                        } catch (Exception e2) {
                            e = e2;
                        }
                        if (jad_bo(bArr4)) {
                            return 7;
                        }
                        if (jad_cp(bArr4)) {
                            return 10;
                        }
                        i = 0;
                        while (true) {
                            bArr = jad_wj;
                            if (i < bArr.length) {
                                return 13;
                            }
                            if (bArr4[i] != bArr[i]) {
                                i2 = 0;
                                while (true) {
                                    bArr2 = jad_cn;
                                    if (i2 < bArr2.length) {
                                        i3 = 0;
                                        while (true) {
                                            bArr3 = jad_do;
                                            if (i3 < bArr3.length) {
                                                return 14;
                                            }
                                            if (bArr4[jad_cn.length + i3 + 4] != bArr3[i3]) {
                                                return 0;
                                            }
                                            i3++;
                                        }
                                    } else {
                                        if (bArr4[i2] != bArr2[i2]) {
                                            return 0;
                                        }
                                        i2++;
                                    }
                                }
                            } else {
                                i++;
                            }
                        }
                    }
                }
                return 9;
            }
            i4++;
        }
    }

    /* JADX WARN: Code duplicated, block: B:34:0x00b6 A[FALL_THROUGH] */
    /* JADX WARN: Code duplicated, block: B:36:0x00bc  */
    /* JADX WARN: Code duplicated, block: B:57:0x016b  */
    /* JADX WARN: Code duplicated, block: B:59:0x0171 A[LOOP:0: B:10:0x003b->B:59:0x0171, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:78:0x00e8 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:80:0x017c A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:81:0x0174 A[SYNTHETIC] */
    /*  JADX ERROR: UnsupportedOperationException in pass: RegionMakerVisitor
        java.lang.UnsupportedOperationException
        	at java.base/java.util.Collections$UnmodifiableCollection.add(Collections.java:1068)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker$1.leaveRegion(SwitchRegionMaker.java:419)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:91)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverse(DepthRegionTraversal.java:31)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker.insertBreaksForCase(SwitchRegionMaker.java:399)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker.insertBreaks(SwitchRegionMaker.java:89)
        	at jadx.core.dex.visitors.regions.PostProcessRegions.leaveRegion(PostProcessRegions.java:31)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:91)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverse(DepthRegionTraversal.java:27)
        	at jadx.core.dex.visitors.regions.PostProcessRegions.process(PostProcessRegions.java:21)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:31)
        */
    public final void jad_an(com.jd.ad.sdk.jad_bo.jad_an.jad_bo r19, int r20, int r21) throws java.io.IOException {
        /*
            Method dump skipped, instruction units count: 514
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jd.ad.sdk.jad_bo.jad_an.jad_an(com.jd.ad.sdk.jad_bo.jad_an$jad_bo, int, int):void");
    }

    public final void jad_an(jad_bo jad_boVar) throws IOException {
        String strExtractMetadata;
        String strExtractMetadata2;
        String strExtractMetadata3;
        int i;
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        try {
            mediaMetadataRetriever.setDataSource(new C0550jad_an(this, jad_boVar));
            String strExtractMetadata4 = mediaMetadataRetriever.extractMetadata(33);
            String strExtractMetadata5 = mediaMetadataRetriever.extractMetadata(34);
            String strExtractMetadata6 = mediaMetadataRetriever.extractMetadata(26);
            String strExtractMetadata7 = mediaMetadataRetriever.extractMetadata(17);
            if ("yes".equals(strExtractMetadata6)) {
                strExtractMetadata = mediaMetadataRetriever.extractMetadata(29);
                strExtractMetadata2 = mediaMetadataRetriever.extractMetadata(30);
                strExtractMetadata3 = mediaMetadataRetriever.extractMetadata(31);
            } else if ("yes".equals(strExtractMetadata7)) {
                strExtractMetadata = mediaMetadataRetriever.extractMetadata(18);
                strExtractMetadata2 = mediaMetadataRetriever.extractMetadata(19);
                strExtractMetadata3 = mediaMetadataRetriever.extractMetadata(24);
            } else {
                strExtractMetadata = null;
                strExtractMetadata2 = null;
                strExtractMetadata3 = null;
            }
            if (strExtractMetadata != null) {
                this.jad_er[0].put(ExifInterface.TAG_IMAGE_WIDTH, jad_cp.jad_an(Integer.parseInt(strExtractMetadata), this.jad_jt));
            }
            if (strExtractMetadata2 != null) {
                this.jad_er[0].put(ExifInterface.TAG_IMAGE_LENGTH, jad_cp.jad_an(Integer.parseInt(strExtractMetadata2), this.jad_jt));
            }
            if (strExtractMetadata3 != null) {
                int i2 = Integer.parseInt(strExtractMetadata3);
                if (i2 == 90) {
                    i = 6;
                } else if (i2 != 180) {
                    i = i2 != 270 ? 1 : 8;
                } else {
                    i = 3;
                }
                this.jad_er[0].put(ExifInterface.TAG_ORIENTATION, jad_cp.jad_an(i, this.jad_jt));
            }
            if (strExtractMetadata4 != null && strExtractMetadata5 != null) {
                int i3 = Integer.parseInt(strExtractMetadata4);
                int i4 = Integer.parseInt(strExtractMetadata5);
                if (i4 > 6) {
                    jad_boVar.jad_bo(i3);
                    byte[] bArr = new byte[6];
                    if (jad_boVar.read(bArr) == 6) {
                        int i5 = i3 + 6;
                        int i6 = i4 - 6;
                        if (Arrays.equals(bArr, jad_qb)) {
                            byte[] bArr2 = new byte[i6];
                            if (jad_boVar.read(bArr2) == i6) {
                                this.jad_iv = i5;
                                jad_an(bArr2, 0);
                            } else {
                                throw new IOException("Can't read exif");
                            }
                        } else {
                            throw new IOException("Invalid identifier");
                        }
                    } else {
                        throw new IOException("Can't read identifier");
                    }
                } else {
                    throw new IOException("Invalid exif length");
                }
            }
            if (jad_na) {
                Log.d("ExifInterface", "Heif meta: " + strExtractMetadata + "x" + strExtractMetadata2 + ", rotation " + strExtractMetadata3);
            }
            mediaMetadataRetriever.release();
        } catch (Throwable th) {
            mediaMetadataRetriever.release();
            throw th;
        }
    }

    public final void jad_an(byte[] bArr, int i) throws IOException {
        jad_bo jad_boVar = new jad_bo(bArr);
        jad_an(jad_boVar, bArr.length);
        jad_bo(jad_boVar, i);
    }

    public final void jad_an() {
        String strJad_an = jad_an(ExifInterface.TAG_DATETIME_ORIGINAL);
        if (strJad_an != null && jad_an(ExifInterface.TAG_DATETIME) == null) {
            this.jad_er[0].put(ExifInterface.TAG_DATETIME, jad_cp.jad_an(strJad_an));
        }
        if (jad_an(ExifInterface.TAG_IMAGE_WIDTH) == null) {
            this.jad_er[0].put(ExifInterface.TAG_IMAGE_WIDTH, jad_cp.jad_an(0L, this.jad_jt));
        }
        if (jad_an(ExifInterface.TAG_IMAGE_LENGTH) == null) {
            this.jad_er[0].put(ExifInterface.TAG_IMAGE_LENGTH, jad_cp.jad_an(0L, this.jad_jt));
        }
        if (jad_an(ExifInterface.TAG_ORIENTATION) == null) {
            this.jad_er[0].put(ExifInterface.TAG_ORIENTATION, jad_cp.jad_an(0L, this.jad_jt));
        }
        if (jad_an(ExifInterface.TAG_LIGHT_SOURCE) == null) {
            this.jad_er[1].put(ExifInterface.TAG_LIGHT_SOURCE, jad_cp.jad_an(0L, this.jad_jt));
        }
    }

    public final void jad_an(jad_bo jad_boVar, int i) throws IOException {
        ByteOrder byteOrderJad_iv = jad_iv(jad_boVar);
        this.jad_jt = byteOrderJad_iv;
        jad_boVar.jad_bo = byteOrderJad_iv;
        int unsignedShort = jad_boVar.readUnsignedShort();
        int i2 = this.jad_cp;
        if (i2 != 7 && i2 != 10 && unsignedShort != 42) {
            throw new IOException(com.jd.ad.sdk.jad_bo.jad_bo.jad_an("Invalid start code: ").append(Integer.toHexString(unsignedShort)).toString());
        }
        int i3 = jad_boVar.readInt();
        if (i3 >= 8 && i3 < i) {
            int i4 = i3 - 8;
            if (i4 > 0 && jad_boVar.skipBytes(i4) != i4) {
                throw new IOException("Couldn't jump to first Ifd: " + i4);
            }
            return;
        }
        throw new IOException("Invalid first Ifd offset: " + i3);
    }

    public final void jad_an(jad_bo jad_boVar, HashMap map) throws Throwable {
        jad_cp jad_cpVar = (jad_cp) map.get(ExifInterface.TAG_JPEG_INTERCHANGE_FORMAT);
        jad_cp jad_cpVar2 = (jad_cp) map.get(ExifInterface.TAG_JPEG_INTERCHANGE_FORMAT_LENGTH);
        if (jad_cpVar == null || jad_cpVar2 == null) {
            return;
        }
        int iJad_bo = jad_cpVar.jad_bo(this.jad_jt);
        int iJad_bo2 = jad_cpVar2.jad_bo(this.jad_jt);
        if (this.jad_cp == 7) {
            iJad_bo += this.jad_jw;
        }
        int iMin = Math.min(iJad_bo2, jad_boVar.jad_cp - iJad_bo);
        if (iJad_bo > 0 && iMin > 0) {
            int i = this.jad_iv + iJad_bo;
            if (this.jad_bo == null && this.jad_an == null) {
                jad_boVar.jad_bo(i);
                jad_boVar.readFully(new byte[iMin]);
            }
        }
        if (jad_na) {
            Log.d("ExifInterface", "Setting thumbnail attributes with offset: " + iJad_bo + ", length: " + iMin);
        }
    }

    public final boolean jad_an(HashMap map) {
        jad_cp jad_cpVar = (jad_cp) map.get(ExifInterface.TAG_IMAGE_LENGTH);
        jad_cp jad_cpVar2 = (jad_cp) map.get(ExifInterface.TAG_IMAGE_WIDTH);
        if (jad_cpVar == null || jad_cpVar2 == null) {
            return false;
        }
        return jad_cpVar.jad_bo(this.jad_jt) <= 512 && jad_cpVar2.jad_bo(this.jad_jt) <= 512;
    }

    public final void jad_an(int i, int i2) throws Throwable {
        if (this.jad_er[i].isEmpty() || this.jad_er[i2].isEmpty()) {
            if (jad_na) {
                Log.d("ExifInterface", "Cannot perform swap since only one image data exists");
                return;
            }
            return;
        }
        jad_cp jad_cpVar = this.jad_er[i].get(ExifInterface.TAG_IMAGE_LENGTH);
        jad_cp jad_cpVar2 = this.jad_er[i].get(ExifInterface.TAG_IMAGE_WIDTH);
        jad_cp jad_cpVar3 = this.jad_er[i2].get(ExifInterface.TAG_IMAGE_LENGTH);
        jad_cp jad_cpVar4 = this.jad_er[i2].get(ExifInterface.TAG_IMAGE_WIDTH);
        if (jad_cpVar == null || jad_cpVar2 == null) {
            if (jad_na) {
                Log.d("ExifInterface", "First image does not contain valid size information");
                return;
            }
            return;
        }
        if (jad_cpVar3 == null || jad_cpVar4 == null) {
            if (jad_na) {
                Log.d("ExifInterface", "Second image does not contain valid size information");
                return;
            }
            return;
        }
        int iJad_bo = jad_cpVar.jad_bo(this.jad_jt);
        int iJad_bo2 = jad_cpVar2.jad_bo(this.jad_jt);
        int iJad_bo3 = jad_cpVar3.jad_bo(this.jad_jt);
        int iJad_bo4 = jad_cpVar4.jad_bo(this.jad_jt);
        if (iJad_bo >= iJad_bo3 || iJad_bo2 >= iJad_bo4) {
            return;
        }
        HashMap<String, jad_cp>[] mapArr = this.jad_er;
        HashMap<String, jad_cp> map = mapArr[i];
        mapArr[i] = mapArr[i2];
        mapArr[i2] = map;
    }

    public static long[] jad_an(Object obj) {
        if (obj instanceof int[]) {
            int[] iArr = (int[]) obj;
            long[] jArr = new long[iArr.length];
            for (int i = 0; i < iArr.length; i++) {
                jArr[i] = iArr[i];
            }
            return jArr;
        }
        if (obj instanceof long[]) {
            return (long[]) obj;
        }
        return null;
    }

    public static boolean jad_an(byte[] bArr, byte[] bArr2) {
        if (bArr2 == null || bArr.length < bArr2.length) {
            return false;
        }
        for (int i = 0; i < bArr2.length; i++) {
            if (bArr[i] != bArr2[i]) {
                return false;
            }
        }
        return true;
    }

    public static String jad_an(byte[] bArr) {
        StringBuilder sb = new StringBuilder(bArr.length * 2);
        for (byte b : bArr) {
            sb.append(String.format("%02x", Byte.valueOf(b)));
        }
        return sb.toString();
    }

    static {
        Arrays.asList(1, 6, 3, 8);
        Arrays.asList(2, 7, 4, 5);
        jad_ob = new int[]{8, 8, 8};
        jad_pc = new int[]{8};
        jad_qd = new byte[]{-1, -40, -1};
        jad_re = new byte[]{102, 116, 121, 112};
        jad_sf = new byte[]{109, 105, 102, 49};
        jad_tg = new byte[]{104, 101, 105, 99};
        jad_uh = new byte[]{79, 76, 89, 77, 80, 0};
        jad_vi = new byte[]{79, 76, 89, 77, 80, 85, 83, 0, 73, 73};
        jad_wj = new byte[]{-119, 80, 78, 71, 13, 10, 26, 10};
        jad_xk = new byte[]{101, 88, 73, 102};
        jad_yl = new byte[]{73, 72, 68, 82};
        jad_zm = new byte[]{73, 69, 78, 68};
        jad_cn = new byte[]{82, 73, 70, 70};
        jad_do = new byte[]{87, 69, 66, 80};
        jad_ep = new byte[]{69, 88, 73, 70};
        "VP8X".getBytes(Charset.defaultCharset());
        "VP8L".getBytes(Charset.defaultCharset());
        "VP8 ".getBytes(Charset.defaultCharset());
        "ANIM".getBytes(Charset.defaultCharset());
        "ANMF".getBytes(Charset.defaultCharset());
        "XMP ".getBytes(Charset.defaultCharset());
        jad_fq = new String[]{"", "BYTE", "STRING", "USHORT", "ULONG", "URATIONAL", "SBYTE", "UNDEFINED", "SSHORT", "SLONG", "SRATIONAL", "SINGLE", "DOUBLE", "IFD"};
        jad_gr = new int[]{0, 1, 1, 2, 4, 8, 1, 1, 2, 4, 8, 4, 8, 1};
        jad_hs = new byte[]{65, 83, 67, 73, 73, 0, 0, 0};
        jad_dq[] jad_dqVarArr = {new jad_dq(ExifInterface.TAG_NEW_SUBFILE_TYPE, MediaPlayer.MEDIA_PLAYER_ADAPTIVE_WORK_AROUND_MODE, 4), new jad_dq(ExifInterface.TAG_SUBFILE_TYPE, 255, 4), new jad_dq(ExifInterface.TAG_IMAGE_WIDTH, 256, 3, 4), new jad_dq(ExifInterface.TAG_IMAGE_LENGTH, 257, 3, 4), new jad_dq(ExifInterface.TAG_BITS_PER_SAMPLE, 258, 3), new jad_dq(ExifInterface.TAG_COMPRESSION, 259, 3), new jad_dq(ExifInterface.TAG_PHOTOMETRIC_INTERPRETATION, 262, 3), new jad_dq(ExifInterface.TAG_IMAGE_DESCRIPTION, 270, 2), new jad_dq(ExifInterface.TAG_MAKE, MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_SWITCH_CACHE_TIME, 2), new jad_dq(ExifInterface.TAG_MODEL, MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_HTTP_REQ_FINSIH_TIME, 2), new jad_dq(ExifInterface.TAG_STRIP_OFFSETS, 273, 3, 4), new jad_dq(ExifInterface.TAG_ORIENTATION, 274, 3), new jad_dq(ExifInterface.TAG_SAMPLES_PER_PIXEL, 277, 3), new jad_dq(ExifInterface.TAG_ROWS_PER_STRIP, 278, 3, 4), new jad_dq(ExifInterface.TAG_STRIP_BYTE_COUNTS, MediaPlayer.MEDIA_PLAYER_OPTION_DISABLE_HWDEC_SEAMLESS, 3, 4), new jad_dq(ExifInterface.TAG_X_RESOLUTION, MediaPlayer.MEDIA_PLAYER_OPTION_GET_LOW_UI_FPS, 5), new jad_dq(ExifInterface.TAG_Y_RESOLUTION, MediaPlayer.MEDIA_PLAYER_OPTION_GET_CUR_UI_FPS, 5), new jad_dq(ExifInterface.TAG_PLANAR_CONFIGURATION, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_VSYNC_HELPER, 3), new jad_dq(ExifInterface.TAG_RESOLUTION_UNIT, 296, 3), new jad_dq(ExifInterface.TAG_TRANSFER_FUNCTION, 301, 3), new jad_dq(ExifInterface.TAG_SOFTWARE, 305, 2), new jad_dq(ExifInterface.TAG_DATETIME, 306, 2), new jad_dq(ExifInterface.TAG_ARTIST, 315, 2), new jad_dq(ExifInterface.TAG_WHITE_POINT, 318, 5), new jad_dq(ExifInterface.TAG_PRIMARY_CHROMATICITIES, MediaPlayer.MEDIA_PLAYER_OPTION_LAST_AUDIO_RENDER_TIME, 5), new jad_dq("SubIFDPointer", MediaPlayer.MEDIA_PLAYER_OPTION_SET_AVPH_OPEN_VIDEO_FIRST, 4), new jad_dq(ExifInterface.TAG_JPEG_INTERCHANGE_FORMAT, 513, 4), new jad_dq(ExifInterface.TAG_JPEG_INTERCHANGE_FORMAT_LENGTH, 514, 4), new jad_dq(ExifInterface.TAG_Y_CB_CR_COEFFICIENTS, 529, 5), new jad_dq(ExifInterface.TAG_Y_CB_CR_SUB_SAMPLING, MediaPlayer.MEDIA_PLAYER_OPTION_DEMUXER_VIDEO_STACK_SIZE, 3), new jad_dq(ExifInterface.TAG_Y_CB_CR_POSITIONING, MediaPlayer.MEDIA_PLAYER_OPTION_FORMATER_AUDIO_QUEUE_SIZE, 3), new jad_dq(ExifInterface.TAG_REFERENCE_BLACK_WHITE, MediaPlayer.MEDIA_PLAYER_OPTION_SET_LLASH_FAST_OPEN, 5), new jad_dq(ExifInterface.TAG_COPYRIGHT, 33432, 2), new jad_dq("ExifIFDPointer", 34665, 4), new jad_dq("GPSInfoIFDPointer", 34853, 4), new jad_dq(ExifInterface.TAG_RW2_SENSOR_TOP_BORDER, 4, 4), new jad_dq(ExifInterface.TAG_RW2_SENSOR_LEFT_BORDER, 5, 4), new jad_dq(ExifInterface.TAG_RW2_SENSOR_BOTTOM_BORDER, 6, 4), new jad_dq(ExifInterface.TAG_RW2_SENSOR_RIGHT_BORDER, 7, 4), new jad_dq(ExifInterface.TAG_RW2_ISO, 23, 3), new jad_dq(ExifInterface.TAG_RW2_JPG_FROM_RAW, 46, 7), new jad_dq(ExifInterface.TAG_XMP, 700, 1)};
        jad_dq[] jad_dqVarArr2 = {new jad_dq(ExifInterface.TAG_EXPOSURE_TIME, 33434, 5), new jad_dq(ExifInterface.TAG_F_NUMBER, 33437, 5), new jad_dq(ExifInterface.TAG_EXPOSURE_PROGRAM, 34850, 3), new jad_dq(ExifInterface.TAG_SPECTRAL_SENSITIVITY, 34852, 2), new jad_dq(ExifInterface.TAG_PHOTOGRAPHIC_SENSITIVITY, 34855, 3), new jad_dq(ExifInterface.TAG_OECF, 34856, 7), new jad_dq(ExifInterface.TAG_SENSITIVITY_TYPE, 34864, 3), new jad_dq(ExifInterface.TAG_STANDARD_OUTPUT_SENSITIVITY, 34865, 4), new jad_dq(ExifInterface.TAG_RECOMMENDED_EXPOSURE_INDEX, 34866, 4), new jad_dq(ExifInterface.TAG_ISO_SPEED, 34867, 4), new jad_dq(ExifInterface.TAG_ISO_SPEED_LATITUDE_YYY, 34868, 4), new jad_dq(ExifInterface.TAG_ISO_SPEED_LATITUDE_ZZZ, 34869, 4), new jad_dq(ExifInterface.TAG_EXIF_VERSION, 36864, 2), new jad_dq(ExifInterface.TAG_DATETIME_ORIGINAL, 36867, 2), new jad_dq(ExifInterface.TAG_DATETIME_DIGITIZED, 36868, 2), new jad_dq(ExifInterface.TAG_OFFSET_TIME, 36880, 2), new jad_dq(ExifInterface.TAG_OFFSET_TIME_ORIGINAL, 36881, 2), new jad_dq(ExifInterface.TAG_OFFSET_TIME_DIGITIZED, 36882, 2), new jad_dq(ExifInterface.TAG_COMPONENTS_CONFIGURATION, 37121, 7), new jad_dq(ExifInterface.TAG_COMPRESSED_BITS_PER_PIXEL, 37122, 5), new jad_dq(ExifInterface.TAG_SHUTTER_SPEED_VALUE, 37377, 10), new jad_dq(ExifInterface.TAG_APERTURE_VALUE, 37378, 5), new jad_dq(ExifInterface.TAG_BRIGHTNESS_VALUE, 37379, 10), new jad_dq(ExifInterface.TAG_EXPOSURE_BIAS_VALUE, 37380, 10), new jad_dq(ExifInterface.TAG_MAX_APERTURE_VALUE, 37381, 5), new jad_dq(ExifInterface.TAG_SUBJECT_DISTANCE, 37382, 5), new jad_dq(ExifInterface.TAG_METERING_MODE, 37383, 3), new jad_dq(ExifInterface.TAG_LIGHT_SOURCE, 37384, 3), new jad_dq(ExifInterface.TAG_FLASH, 37385, 3), new jad_dq(ExifInterface.TAG_FOCAL_LENGTH, 37386, 5), new jad_dq(ExifInterface.TAG_SUBJECT_AREA, 37396, 3), new jad_dq(ExifInterface.TAG_MAKER_NOTE, 37500, 7), new jad_dq(ExifInterface.TAG_USER_COMMENT, 37510, 7), new jad_dq(ExifInterface.TAG_SUBSEC_TIME, 37520, 2), new jad_dq(ExifInterface.TAG_SUBSEC_TIME_ORIGINAL, 37521, 2), new jad_dq(ExifInterface.TAG_SUBSEC_TIME_DIGITIZED, 37522, 2), new jad_dq(ExifInterface.TAG_FLASHPIX_VERSION, 40960, 7), new jad_dq(ExifInterface.TAG_COLOR_SPACE, 40961, 3), new jad_dq(ExifInterface.TAG_PIXEL_X_DIMENSION, 40962, 3, 4), new jad_dq(ExifInterface.TAG_PIXEL_Y_DIMENSION, 40963, 3, 4), new jad_dq(ExifInterface.TAG_RELATED_SOUND_FILE, 40964, 2), new jad_dq("InteroperabilityIFDPointer", 40965, 4), new jad_dq(ExifInterface.TAG_FLASH_ENERGY, 41483, 5), new jad_dq(ExifInterface.TAG_SPATIAL_FREQUENCY_RESPONSE, 41484, 7), new jad_dq(ExifInterface.TAG_FOCAL_PLANE_X_RESOLUTION, 41486, 5), new jad_dq(ExifInterface.TAG_FOCAL_PLANE_Y_RESOLUTION, 41487, 5), new jad_dq(ExifInterface.TAG_FOCAL_PLANE_RESOLUTION_UNIT, 41488, 3), new jad_dq(ExifInterface.TAG_SUBJECT_LOCATION, 41492, 3), new jad_dq(ExifInterface.TAG_EXPOSURE_INDEX, 41493, 5), new jad_dq(ExifInterface.TAG_SENSING_METHOD, 41495, 3), new jad_dq(ExifInterface.TAG_FILE_SOURCE, 41728, 7), new jad_dq(ExifInterface.TAG_SCENE_TYPE, 41729, 7), new jad_dq(ExifInterface.TAG_CFA_PATTERN, 41730, 7), new jad_dq(ExifInterface.TAG_CUSTOM_RENDERED, 41985, 3), new jad_dq(ExifInterface.TAG_EXPOSURE_MODE, 41986, 3), new jad_dq(ExifInterface.TAG_WHITE_BALANCE, 41987, 3), new jad_dq(ExifInterface.TAG_DIGITAL_ZOOM_RATIO, 41988, 5), new jad_dq(ExifInterface.TAG_FOCAL_LENGTH_IN_35MM_FILM, 41989, 3), new jad_dq(ExifInterface.TAG_SCENE_CAPTURE_TYPE, 41990, 3), new jad_dq(ExifInterface.TAG_GAIN_CONTROL, 41991, 3), new jad_dq(ExifInterface.TAG_CONTRAST, 41992, 3), new jad_dq(ExifInterface.TAG_SATURATION, 41993, 3), new jad_dq(ExifInterface.TAG_SHARPNESS, 41994, 3), new jad_dq(ExifInterface.TAG_DEVICE_SETTING_DESCRIPTION, 41995, 7), new jad_dq(ExifInterface.TAG_SUBJECT_DISTANCE_RANGE, 41996, 3), new jad_dq(ExifInterface.TAG_IMAGE_UNIQUE_ID, 42016, 2), new jad_dq("CameraOwnerName", 42032, 2), new jad_dq(ExifInterface.TAG_BODY_SERIAL_NUMBER, 42033, 2), new jad_dq(ExifInterface.TAG_LENS_SPECIFICATION, 42034, 5), new jad_dq(ExifInterface.TAG_LENS_MAKE, 42035, 2), new jad_dq(ExifInterface.TAG_LENS_MODEL, 42036, 2), new jad_dq(ExifInterface.TAG_GAMMA, 42240, 5), new jad_dq(ExifInterface.TAG_DNG_VERSION, 50706, 1), new jad_dq(ExifInterface.TAG_DEFAULT_CROP_SIZE, 50720, 3, 4)};
        jad_dq[] jad_dqVarArr3 = {new jad_dq(ExifInterface.TAG_GPS_VERSION_ID, 0, 1), new jad_dq(ExifInterface.TAG_GPS_LATITUDE_REF, 1, 2), new jad_dq(ExifInterface.TAG_GPS_LATITUDE, 2, 5), new jad_dq(ExifInterface.TAG_GPS_LONGITUDE_REF, 3, 2), new jad_dq(ExifInterface.TAG_GPS_LONGITUDE, 4, 5), new jad_dq(ExifInterface.TAG_GPS_ALTITUDE_REF, 5, 1), new jad_dq(ExifInterface.TAG_GPS_ALTITUDE, 6, 5), new jad_dq(ExifInterface.TAG_GPS_TIMESTAMP, 7, 5), new jad_dq(ExifInterface.TAG_GPS_SATELLITES, 8, 2), new jad_dq(ExifInterface.TAG_GPS_STATUS, 9, 2), new jad_dq(ExifInterface.TAG_GPS_MEASURE_MODE, 10, 2), new jad_dq(ExifInterface.TAG_GPS_DOP, 11, 5), new jad_dq(ExifInterface.TAG_GPS_SPEED_REF, 12, 2), new jad_dq(ExifInterface.TAG_GPS_SPEED, 13, 5), new jad_dq(ExifInterface.TAG_GPS_TRACK_REF, 14, 2), new jad_dq(ExifInterface.TAG_GPS_TRACK, 15, 5), new jad_dq(ExifInterface.TAG_GPS_IMG_DIRECTION_REF, 16, 2), new jad_dq(ExifInterface.TAG_GPS_IMG_DIRECTION, 17, 5), new jad_dq(ExifInterface.TAG_GPS_MAP_DATUM, 18, 2), new jad_dq(ExifInterface.TAG_GPS_DEST_LATITUDE_REF, 19, 2), new jad_dq(ExifInterface.TAG_GPS_DEST_LATITUDE, 20, 5), new jad_dq(ExifInterface.TAG_GPS_DEST_LONGITUDE_REF, 21, 2), new jad_dq(ExifInterface.TAG_GPS_DEST_LONGITUDE, 22, 5), new jad_dq(ExifInterface.TAG_GPS_DEST_BEARING_REF, 23, 2), new jad_dq(ExifInterface.TAG_GPS_DEST_BEARING, 24, 5), new jad_dq(ExifInterface.TAG_GPS_DEST_DISTANCE_REF, 25, 2), new jad_dq(ExifInterface.TAG_GPS_DEST_DISTANCE, 26, 5), new jad_dq(ExifInterface.TAG_GPS_PROCESSING_METHOD, 27, 7), new jad_dq(ExifInterface.TAG_GPS_AREA_INFORMATION, 28, 7), new jad_dq(ExifInterface.TAG_GPS_DATESTAMP, 29, 2), new jad_dq(ExifInterface.TAG_GPS_DIFFERENTIAL, 30, 3), new jad_dq(ExifInterface.TAG_GPS_H_POSITIONING_ERROR, 31, 5)};
        jad_dq[] jad_dqVarArr4 = {new jad_dq(ExifInterface.TAG_INTEROPERABILITY_INDEX, 1, 2)};
        jad_dq[] jad_dqVarArr5 = {new jad_dq(ExifInterface.TAG_NEW_SUBFILE_TYPE, MediaPlayer.MEDIA_PLAYER_ADAPTIVE_WORK_AROUND_MODE, 4), new jad_dq(ExifInterface.TAG_SUBFILE_TYPE, 255, 4), new jad_dq(ExifInterface.TAG_THUMBNAIL_IMAGE_WIDTH, 256, 3, 4), new jad_dq(ExifInterface.TAG_THUMBNAIL_IMAGE_LENGTH, 257, 3, 4), new jad_dq(ExifInterface.TAG_BITS_PER_SAMPLE, 258, 3), new jad_dq(ExifInterface.TAG_COMPRESSION, 259, 3), new jad_dq(ExifInterface.TAG_PHOTOMETRIC_INTERPRETATION, 262, 3), new jad_dq(ExifInterface.TAG_IMAGE_DESCRIPTION, 270, 2), new jad_dq(ExifInterface.TAG_MAKE, MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_SWITCH_CACHE_TIME, 2), new jad_dq(ExifInterface.TAG_MODEL, MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_HTTP_REQ_FINSIH_TIME, 2), new jad_dq(ExifInterface.TAG_STRIP_OFFSETS, 273, 3, 4), new jad_dq(ExifInterface.TAG_THUMBNAIL_ORIENTATION, 274, 3), new jad_dq(ExifInterface.TAG_SAMPLES_PER_PIXEL, 277, 3), new jad_dq(ExifInterface.TAG_ROWS_PER_STRIP, 278, 3, 4), new jad_dq(ExifInterface.TAG_STRIP_BYTE_COUNTS, MediaPlayer.MEDIA_PLAYER_OPTION_DISABLE_HWDEC_SEAMLESS, 3, 4), new jad_dq(ExifInterface.TAG_X_RESOLUTION, MediaPlayer.MEDIA_PLAYER_OPTION_GET_LOW_UI_FPS, 5), new jad_dq(ExifInterface.TAG_Y_RESOLUTION, MediaPlayer.MEDIA_PLAYER_OPTION_GET_CUR_UI_FPS, 5), new jad_dq(ExifInterface.TAG_PLANAR_CONFIGURATION, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_VSYNC_HELPER, 3), new jad_dq(ExifInterface.TAG_RESOLUTION_UNIT, 296, 3), new jad_dq(ExifInterface.TAG_TRANSFER_FUNCTION, 301, 3), new jad_dq(ExifInterface.TAG_SOFTWARE, 305, 2), new jad_dq(ExifInterface.TAG_DATETIME, 306, 2), new jad_dq(ExifInterface.TAG_ARTIST, 315, 2), new jad_dq(ExifInterface.TAG_WHITE_POINT, 318, 5), new jad_dq(ExifInterface.TAG_PRIMARY_CHROMATICITIES, MediaPlayer.MEDIA_PLAYER_OPTION_LAST_AUDIO_RENDER_TIME, 5), new jad_dq("SubIFDPointer", MediaPlayer.MEDIA_PLAYER_OPTION_SET_AVPH_OPEN_VIDEO_FIRST, 4), new jad_dq(ExifInterface.TAG_JPEG_INTERCHANGE_FORMAT, 513, 4), new jad_dq(ExifInterface.TAG_JPEG_INTERCHANGE_FORMAT_LENGTH, 514, 4), new jad_dq(ExifInterface.TAG_Y_CB_CR_COEFFICIENTS, 529, 5), new jad_dq(ExifInterface.TAG_Y_CB_CR_SUB_SAMPLING, MediaPlayer.MEDIA_PLAYER_OPTION_DEMUXER_VIDEO_STACK_SIZE, 3), new jad_dq(ExifInterface.TAG_Y_CB_CR_POSITIONING, MediaPlayer.MEDIA_PLAYER_OPTION_FORMATER_AUDIO_QUEUE_SIZE, 3), new jad_dq(ExifInterface.TAG_REFERENCE_BLACK_WHITE, MediaPlayer.MEDIA_PLAYER_OPTION_SET_LLASH_FAST_OPEN, 5), new jad_dq(ExifInterface.TAG_COPYRIGHT, 33432, 2), new jad_dq("ExifIFDPointer", 34665, 4), new jad_dq("GPSInfoIFDPointer", 34853, 4), new jad_dq(ExifInterface.TAG_DNG_VERSION, 50706, 1), new jad_dq(ExifInterface.TAG_DEFAULT_CROP_SIZE, 50720, 3, 4)};
        jad_it = new jad_dq(ExifInterface.TAG_STRIP_OFFSETS, 273, 3);
        jad_ju = new jad_dq[][]{jad_dqVarArr, jad_dqVarArr2, jad_dqVarArr3, jad_dqVarArr4, jad_dqVarArr5, jad_dqVarArr, new jad_dq[]{new jad_dq(ExifInterface.TAG_ORF_THUMBNAIL_IMAGE, 256, 7), new jad_dq("CameraSettingsIFDPointer", 8224, 4), new jad_dq("ImageProcessingIFDPointer", 8256, 4)}, new jad_dq[]{new jad_dq(ExifInterface.TAG_ORF_PREVIEW_IMAGE_START, 257, 4), new jad_dq(ExifInterface.TAG_ORF_PREVIEW_IMAGE_LENGTH, 258, 4)}, new jad_dq[]{new jad_dq(ExifInterface.TAG_ORF_ASPECT_FRAME, 4371, 3)}, new jad_dq[]{new jad_dq(ExifInterface.TAG_COLOR_SPACE, 55, 3)}};
        jad_kv = new jad_dq[]{new jad_dq("SubIFDPointer", MediaPlayer.MEDIA_PLAYER_OPTION_SET_AVPH_OPEN_VIDEO_FIRST, 4), new jad_dq("ExifIFDPointer", 34665, 4), new jad_dq("GPSInfoIFDPointer", 34853, 4), new jad_dq("InteroperabilityIFDPointer", 40965, 4), new jad_dq("CameraSettingsIFDPointer", 8224, 1), new jad_dq("ImageProcessingIFDPointer", 8256, 1)};
        jad_lw = new HashMap[10];
        jad_mx = new HashMap[10];
        jad_ny = new HashSet<>(Arrays.asList(ExifInterface.TAG_F_NUMBER, ExifInterface.TAG_DIGITAL_ZOOM_RATIO, ExifInterface.TAG_EXPOSURE_TIME, ExifInterface.TAG_SUBJECT_DISTANCE, ExifInterface.TAG_GPS_TIMESTAMP));
        jad_oz = new HashMap<>();
        Charset charsetForName = Charset.forName("US-ASCII");
        jad_pa = charsetForName;
        jad_qb = "Exif\u0000\u0000".getBytes(charsetForName);
        jad_rc = "http://ns.adobe.com/xap/1.0/\u0000".getBytes(charsetForName);
        new SimpleDateFormat("yyyy:MM:dd HH:mm:ss").setTimeZone(TimeZone.getTimeZone("UTC"));
        int i = 0;
        while (true) {
            jad_dq[][] jad_dqVarArr6 = jad_ju;
            if (i >= jad_dqVarArr6.length) {
                HashMap<Integer, Integer> map = jad_oz;
                jad_dq[] jad_dqVarArr7 = jad_kv;
                map.put(Integer.valueOf(jad_dqVarArr7[0].jad_an), 5);
                map.put(Integer.valueOf(jad_dqVarArr7[1].jad_an), 1);
                map.put(Integer.valueOf(jad_dqVarArr7[2].jad_an), 2);
                map.put(Integer.valueOf(jad_dqVarArr7[3].jad_an), 3);
                map.put(Integer.valueOf(jad_dqVarArr7[4].jad_an), 7);
                map.put(Integer.valueOf(jad_dqVarArr7[5].jad_an), 8);
                Pattern.compile(".*[1-9].*");
                Pattern.compile("^([0-9][0-9]):([0-9][0-9]):([0-9][0-9])$");
                return;
            }
            jad_lw[i] = new HashMap<>();
            jad_mx[i] = new HashMap<>();
            for (jad_dq jad_dqVar : jad_dqVarArr6[i]) {
                jad_lw[i].put(Integer.valueOf(jad_dqVar.jad_an), jad_dqVar);
                jad_mx[i].put(jad_dqVar.jad_bo, jad_dqVar);
            }
            i++;
        }
    }
}
