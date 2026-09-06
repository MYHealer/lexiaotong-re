package com.ubixnow.ooooo;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Objects;
import kotlin.io.encoding.Base64;
import org.apache.commons.io.IOUtils;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class oO0Oo0o0 {

    public static class OooO {
        private static final int OooO0OO = 76;
        private static final byte[] OooO0Oo;
        public static final OooO OooO0oO;
        private final int OooO;
        private final byte[] OooO0oo;
        private final boolean OooOO0;
        private final boolean OooOO0O;
        private static final char[] OooO00o = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '+', IOUtils.DIR_SEPARATOR_UNIX};
        private static final char[] OooO0O0 = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '-', '_'};
        public static final OooO OooO0o0 = new OooO(false, null, -1, true);
        public static final OooO OooO0o = new OooO(true, null, -1, true);

        static {
            byte[] bArr = {13, 10};
            OooO0Oo = bArr;
            OooO0oO = new OooO(false, bArr, 76, true);
        }

        private OooO(boolean z, byte[] bArr, int i, boolean z2) {
            this.OooOO0 = z;
            this.OooO0oo = bArr;
            this.OooO = i;
            this.OooOO0O = z2;
        }

        public /* synthetic */ OooO(boolean z, byte[] bArr, int i, boolean z2, OooO00o oooO00o) {
            this(z, bArr, i, z2);
        }

        private final int OooO00o(int i) {
            int i2;
            if (this.OooOO0O) {
                i2 = ((i + 2) / 3) * 4;
            } else {
                int i3 = i % 3;
                i2 = ((i / 3) * 4) + (i3 == 0 ? 0 : i3 + 1);
            }
            int i4 = this.OooO;
            return i4 > 0 ? i2 + (((i2 - 1) / i4) * this.OooO0oo.length) : i2;
        }

        private int OooO00o(byte[] bArr, int i, int i2, byte[] bArr2) {
            int i3;
            char[] cArr = this.OooOO0 ? OooO0O0 : OooO00o;
            int i4 = ((i2 - i) / 3) * 3;
            int i5 = i + i4;
            int i6 = this.OooO;
            if (i6 > 0 && i4 > (i3 = (i6 / 4) * 3)) {
                i4 = i3;
            }
            int i7 = i;
            int i8 = 0;
            while (i7 < i5) {
                int iMin = Math.min(i7 + i4, i5);
                int i9 = i7;
                int i10 = i8;
                while (i9 < iMin) {
                    int i11 = i9 + 2;
                    int i12 = ((bArr[i9 + 1] & 255) << 8) | ((bArr[i9] & 255) << 16);
                    i9 += 3;
                    int i13 = i12 | (bArr[i11] & 255);
                    bArr2[i10] = (byte) cArr[(i13 >>> 18) & 63];
                    bArr2[i10 + 1] = (byte) cArr[(i13 >>> 12) & 63];
                    int i14 = i10 + 3;
                    bArr2[i10 + 2] = (byte) cArr[(i13 >>> 6) & 63];
                    i10 += 4;
                    bArr2[i14] = (byte) cArr[i13 & 63];
                }
                int i15 = ((iMin - i7) / 3) * 4;
                i8 += i15;
                if (i15 == this.OooO && iMin < i2) {
                    byte[] bArr3 = this.OooO0oo;
                    int length = bArr3.length;
                    int i16 = 0;
                    while (i16 < length) {
                        bArr2[i8] = bArr3[i16];
                        i16++;
                        i8++;
                    }
                }
                i7 = iMin;
            }
            if (i7 >= i2) {
                return i8;
            }
            int i17 = i7 + 1;
            int i18 = bArr[i7] & 255;
            int i19 = i8 + 1;
            bArr2[i8] = (byte) cArr[i18 >> 2];
            if (i17 == i2) {
                int i20 = i8 + 2;
                bArr2[i19] = (byte) cArr[(i18 << 4) & 63];
                if (!this.OooOO0O) {
                    return i20;
                }
                int i21 = i8 + 3;
                bArr2[i20] = Base64.padSymbol;
                int i22 = i8 + 4;
                bArr2[i21] = Base64.padSymbol;
                return i22;
            }
            int i23 = bArr[i17] & 255;
            bArr2[i19] = (byte) cArr[((i18 << 4) & 63) | (i23 >> 4)];
            int i24 = i8 + 3;
            bArr2[i8 + 2] = (byte) cArr[(i23 << 2) & 63];
            if (!this.OooOO0O) {
                return i24;
            }
            int i25 = i8 + 4;
            bArr2[i24] = Base64.padSymbol;
            return i25;
        }

        public int OooO00o(byte[] bArr, byte[] bArr2) {
            if (bArr2.length >= OooO00o(bArr.length)) {
                return OooO00o(bArr, 0, bArr.length, bArr2);
            }
            throw new IllegalArgumentException("Output byte array is too small for encoding all input bytes");
        }

        public OutputStream OooO00o(OutputStream outputStream) {
            Objects.requireNonNull(outputStream);
            return new OooO0o(outputStream, this.OooOO0 ? OooO0O0 : OooO00o, this.OooO0oo, this.OooO, this.OooOO0O);
        }

        public ByteBuffer OooO00o(ByteBuffer byteBuffer) {
            int iOooO00o;
            int iOooO00o2 = OooO00o(byteBuffer.remaining());
            byte[] bArrCopyOf = new byte[iOooO00o2];
            if (byteBuffer.hasArray()) {
                iOooO00o = OooO00o(byteBuffer.array(), byteBuffer.arrayOffset() + byteBuffer.position(), byteBuffer.arrayOffset() + byteBuffer.limit(), bArrCopyOf);
                byteBuffer.position(byteBuffer.limit());
            } else {
                int iRemaining = byteBuffer.remaining();
                byte[] bArr = new byte[iRemaining];
                byteBuffer.get(bArr);
                iOooO00o = OooO00o(bArr, 0, iRemaining, bArrCopyOf);
            }
            if (iOooO00o != iOooO00o2) {
                bArrCopyOf = Arrays.copyOf(bArrCopyOf, iOooO00o);
            }
            return ByteBuffer.wrap(bArrCopyOf);
        }

        public byte[] OooO00o(byte[] bArr) {
            int iOooO00o = OooO00o(bArr.length);
            byte[] bArr2 = new byte[iOooO00o];
            int iOooO00o2 = OooO00o(bArr, 0, bArr.length, bArr2);
            return iOooO00o2 != iOooO00o ? Arrays.copyOf(bArr2, iOooO00o2) : bArr2;
        }

        public String OooO0O0(byte[] bArr) {
            byte[] bArrOooO00o = OooO00o(bArr);
            return new String(bArrOooO00o, 0, 0, bArrOooO00o.length);
        }

        public OooO OooO0OO() {
            return !this.OooOO0O ? this : new OooO(this.OooOO0, this.OooO0oo, this.OooO, false);
        }
    }

    public static /* synthetic */ class OooO00o {
    }

    public static class OooO0O0 extends InputStream {
        private final InputStream OooO00o;
        private final boolean OooO0O0;
        private final int[] OooO0OO;
        private int OooO0Oo = 0;
        private int OooO0o0 = 18;
        private int OooO0o = -8;
        private boolean OooO0oO = false;
        private boolean OooO0oo = false;
        private byte[] OooO = new byte[1];

        public OooO0O0(InputStream inputStream, int[] iArr, boolean z) {
            this.OooO00o = inputStream;
            this.OooO0OO = iArr;
            this.OooO0O0 = z;
        }

        @Override // java.io.InputStream
        public int available() throws IOException {
            if (this.OooO0oo) {
                throw new IOException("Stream is closed");
            }
            return this.OooO00o.available();
        }

        @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            if (this.OooO0oo) {
                return;
            }
            this.OooO0oo = true;
            this.OooO00o.close();
        }

        @Override // java.io.InputStream
        public int read() throws IOException {
            if (read(this.OooO, 0, 1) == -1) {
                return -1;
            }
            return this.OooO[0] & 255;
        }

        /* JADX WARN: Code duplicated, block: B:101:0x011d A[ADDED_TO_REGION, REMOVE, SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:72:0x0109  */
        /* JADX WARN: Code duplicated, block: B:74:0x0119 A[ADDED_TO_REGION] */
        /* JADX WARN: Code duplicated, block: B:99:0x011f A[EDGE_INSN: B:99:0x011f->B:78:0x011f BREAK  A[LOOP:1: B:24:0x003d->B:95:0x003d], SYNTHETIC] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:71:0x0107 -> B:78:0x011f). Please report as a decompilation issue!!! */
        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:72:0x0109
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        @Override // java.io.InputStream
        public int read(byte[] r10, int r11, int r12) throws java.io.IOException {
            /*
                Method dump skipped, instruction units count: 313
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.ubixnow.ooooo.oO0Oo0o0.OooO0O0.read(byte[], int, int):int");
        }
    }

    public static class OooO0OO {
        private static final int[] OooO00o;
        private static final int[] OooO0O0;
        public static final OooO0OO OooO0OO;
        public static final OooO0OO OooO0Oo;
        public static final OooO0OO OooO0o0;
        private final boolean OooO0o;
        private final boolean OooO0oO;

        static {
            int[] iArr = new int[256];
            OooO00o = iArr;
            Arrays.fill(iArr, -1);
            for (int i = 0; i < OooO.OooO00o.length; i++) {
                OooO00o[OooO.OooO00o[i]] = i;
            }
            OooO00o[61] = -2;
            int[] iArr2 = new int[256];
            OooO0O0 = iArr2;
            Arrays.fill(iArr2, -1);
            for (int i2 = 0; i2 < OooO.OooO0O0.length; i2++) {
                OooO0O0[OooO.OooO0O0[i2]] = i2;
            }
            OooO0O0[61] = -2;
            OooO0OO = new OooO0OO(false, false);
            OooO0Oo = new OooO0OO(true, false);
            OooO0o0 = new OooO0OO(false, true);
        }

        private OooO0OO(boolean z, boolean z2) {
            this.OooO0o = z;
            this.OooO0oO = z2;
        }

        private int OooO00o(byte[] bArr, int i, int i2) {
            int i3;
            int[] iArr = this.OooO0o ? OooO0O0 : OooO00o;
            int i4 = i2 - i;
            int i5 = 0;
            if (i4 == 0) {
                return 0;
            }
            if (i4 < 2) {
                if (this.OooO0oO && iArr[0] == -1) {
                    return 0;
                }
                throw new IllegalArgumentException("Input byte[] should at least have 2 bytes for base64 bytes");
            }
            if (this.OooO0oO) {
                int i6 = 0;
                while (i < i2) {
                    int i7 = i + 1;
                    int i8 = bArr[i] & 255;
                    if (i8 == 61) {
                        i4 -= (i2 - i7) + 1;
                        break;
                    }
                    if (iArr[i8] == -1) {
                        i6++;
                    }
                    i = i7;
                }
                i4 -= i6;
            } else if (bArr[i2 - 1] == 61) {
                i5 = bArr[i2 - 2] == 61 ? 2 : 1;
            }
            if (i5 == 0 && (i3 = i4 & 3) != 0) {
                i5 = 4 - i3;
            }
            return (((i4 + 3) / 4) * 3) - i5;
        }

        /* JADX WARN: Code restructure failed: missing block: B:19:0x002f, code lost:
        
            if (r4 != 18) goto L32;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        private int OooO00o(byte[] bArr, int i, int i2, byte[] bArr2) {
            int[] iArr = this.OooO0o ? OooO0O0 : OooO00o;
            int i3 = 18;
            int i4 = 0;
            int i5 = 0;
            while (i < i2) {
                int i6 = i + 1;
                int i7 = iArr[bArr[i] & 255];
                if (i7 >= 0) {
                    i4 |= i7 << i3;
                    i3 -= 6;
                    if (i3 < 0) {
                        bArr2[i5] = (byte) (i4 >> 16);
                        int i8 = i5 + 2;
                        bArr2[i5 + 1] = (byte) (i4 >> 8);
                        i5 += 3;
                        bArr2[i8] = (byte) i4;
                        i3 = 18;
                        i4 = 0;
                    }
                } else if (i7 == -2) {
                    if (i3 == 6) {
                        if (i6 != i2) {
                            i += 2;
                            if (bArr[i6] == 61) {
                                break;
                            }
                        }
                        throw new IllegalArgumentException("Input byte array has wrong 4-byte ending unit");
                    }
                    i = i6;
                } else if (!this.OooO0oO) {
                    throw new IllegalArgumentException("Illegal base64 character " + Integer.toString(bArr[i], 16));
                }
                i = i6;
            }
            if (i3 == 6) {
                bArr2[i5] = (byte) (i4 >> 16);
                i5++;
            } else if (i3 == 0) {
                int i9 = i5 + 1;
                bArr2[i5] = (byte) (i4 >> 16);
                i5 += 2;
                bArr2[i9] = (byte) (i4 >> 8);
            } else if (i3 == 12) {
                throw new IllegalArgumentException("Last unit does not have enough valid bits");
            }
            while (i < i2) {
                if (this.OooO0oO) {
                    int i10 = i + 1;
                    if (iArr[bArr[i]] < 0) {
                        i = i10;
                    } else {
                        i = i10;
                    }
                }
                throw new IllegalArgumentException("Input byte array has incorrect ending byte at " + i);
            }
            return i5;
        }

        public int OooO00o(byte[] bArr, byte[] bArr2) {
            if (bArr2.length >= OooO00o(bArr, 0, bArr.length)) {
                return OooO00o(bArr, 0, bArr.length, bArr2);
            }
            throw new IllegalArgumentException("Output byte array is too small for decoding all input bytes");
        }

        public InputStream OooO00o(InputStream inputStream) {
            Objects.requireNonNull(inputStream);
            return new OooO0O0(inputStream, this.OooO0o ? OooO0O0 : OooO00o, this.OooO0oO);
        }

        public ByteBuffer OooO00o(ByteBuffer byteBuffer) {
            int iRemaining;
            byte[] bArrArray;
            int iArrayOffset;
            int iPosition = byteBuffer.position();
            try {
                if (byteBuffer.hasArray()) {
                    bArrArray = byteBuffer.array();
                    iArrayOffset = byteBuffer.arrayOffset() + byteBuffer.position();
                    iRemaining = byteBuffer.arrayOffset() + byteBuffer.limit();
                    byteBuffer.position(byteBuffer.limit());
                } else {
                    iRemaining = byteBuffer.remaining();
                    bArrArray = new byte[iRemaining];
                    byteBuffer.get(bArrArray);
                    iArrayOffset = 0;
                }
                byte[] bArr = new byte[OooO00o(bArrArray, iArrayOffset, iRemaining)];
                return ByteBuffer.wrap(bArr, 0, OooO00o(bArrArray, iArrayOffset, iRemaining, bArr));
            } catch (IllegalArgumentException e) {
                byteBuffer.position(iPosition);
                throw e;
            }
        }

        public byte[] OooO00o(String str) {
            return OooO00o(str.getBytes(Charset.forName("ISO-8859-1")));
        }

        public byte[] OooO00o(byte[] bArr) {
            int iOooO00o = OooO00o(bArr, 0, bArr.length);
            byte[] bArr2 = new byte[iOooO00o];
            int iOooO00o2 = OooO00o(bArr, 0, bArr.length, bArr2);
            return iOooO00o2 != iOooO00o ? Arrays.copyOf(bArr2, iOooO00o2) : bArr2;
        }
    }

    public static class OooO0o extends FilterOutputStream {
        private final boolean OooO;
        private int OooO00o;
        private int OooO0O0;
        private int OooO0OO;
        private int OooO0Oo;
        private final char[] OooO0o;
        private boolean OooO0o0;
        private final byte[] OooO0oO;
        private final int OooO0oo;
        private int OooOO0;

        public OooO0o(OutputStream outputStream, char[] cArr, byte[] bArr, int i, boolean z) {
            super(outputStream);
            this.OooO00o = 0;
            this.OooO0o0 = false;
            this.OooOO0 = 0;
            this.OooO0o = cArr;
            this.OooO0oO = bArr;
            this.OooO0oo = i;
            this.OooO = z;
        }

        private void OooO00o() throws IOException {
            if (this.OooOO0 == this.OooO0oo) {
                ((FilterOutputStream) this).out.write(this.OooO0oO);
                this.OooOO0 = 0;
            }
        }

        @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            if (this.OooO0o0) {
                return;
            }
            this.OooO0o0 = true;
            int i = this.OooO00o;
            if (i == 1) {
                OooO00o();
                ((FilterOutputStream) this).out.write(this.OooO0o[this.OooO0O0 >> 2]);
                ((FilterOutputStream) this).out.write(this.OooO0o[(this.OooO0O0 << 4) & 63]);
                if (this.OooO) {
                    ((FilterOutputStream) this).out.write(61);
                    ((FilterOutputStream) this).out.write(61);
                }
            } else if (i == 2) {
                OooO00o();
                ((FilterOutputStream) this).out.write(this.OooO0o[this.OooO0O0 >> 2]);
                ((FilterOutputStream) this).out.write(this.OooO0o[((this.OooO0O0 << 4) & 63) | (this.OooO0OO >> 4)]);
                ((FilterOutputStream) this).out.write(this.OooO0o[(this.OooO0OO << 2) & 63]);
                if (this.OooO) {
                    ((FilterOutputStream) this).out.write(61);
                }
            }
            this.OooO00o = 0;
            ((FilterOutputStream) this).out.close();
        }

        @Override // java.io.FilterOutputStream, java.io.OutputStream
        public void write(int i) throws IOException {
            write(new byte[]{(byte) (i & 255)}, 0, 1);
        }

        @Override // java.io.FilterOutputStream, java.io.OutputStream
        public void write(byte[] bArr, int i, int i2) throws IOException {
            if (this.OooO0o0) {
                throw new IOException("Stream is closed");
            }
            if (i < 0 || i2 < 0 || i2 > bArr.length - i) {
                throw new ArrayIndexOutOfBoundsException();
            }
            if (i2 == 0) {
                return;
            }
            int i3 = this.OooO00o;
            if (i3 != 0) {
                if (i3 == 1) {
                    int i4 = i + 1;
                    this.OooO0OO = bArr[i] & 255;
                    i2--;
                    if (i2 == 0) {
                        this.OooO00o = i3 + 1;
                        return;
                    }
                    i = i4;
                }
                this.OooO0Oo = bArr[i] & 255;
                i2--;
                OooO00o();
                ((FilterOutputStream) this).out.write(this.OooO0o[this.OooO0O0 >> 2]);
                ((FilterOutputStream) this).out.write(this.OooO0o[((this.OooO0O0 << 4) & 63) | (this.OooO0OO >> 4)]);
                ((FilterOutputStream) this).out.write(this.OooO0o[((this.OooO0OO << 2) & 63) | (this.OooO0Oo >> 6)]);
                ((FilterOutputStream) this).out.write(this.OooO0o[this.OooO0Oo & 63]);
                this.OooOO0 += 4;
                i++;
            }
            int i5 = i2 / 3;
            this.OooO00o = i2 - (i5 * 3);
            while (true) {
                int i6 = i5 - 1;
                if (i5 <= 0) {
                    break;
                }
                OooO00o();
                int i7 = i + 2;
                int i8 = ((bArr[i + 1] & 255) << 8) | ((bArr[i] & 255) << 16);
                i += 3;
                int i9 = i8 | (bArr[i7] & 255);
                ((FilterOutputStream) this).out.write(this.OooO0o[(i9 >>> 18) & 63]);
                ((FilterOutputStream) this).out.write(this.OooO0o[(i9 >>> 12) & 63]);
                ((FilterOutputStream) this).out.write(this.OooO0o[(i9 >>> 6) & 63]);
                ((FilterOutputStream) this).out.write(this.OooO0o[i9 & 63]);
                this.OooOO0 += 4;
                i5 = i6;
            }
            int i10 = this.OooO00o;
            if (i10 == 1) {
                this.OooO0O0 = bArr[i] & 255;
            } else if (i10 == 2) {
                this.OooO0O0 = bArr[i] & 255;
                this.OooO0OO = bArr[i + 1] & 255;
            }
        }
    }

    private oO0Oo0o0() {
    }

    public static OooO0OO OooO00o() {
        return OooO0OO.OooO0OO;
    }

    public static OooO OooO00o(int i, byte[] bArr) {
        Objects.requireNonNull(bArr);
        int[] iArr = OooO0OO.OooO00o;
        for (byte b : bArr) {
            if (iArr[b & 255] != -1) {
                throw new IllegalArgumentException("Illegal base64 line separator character 0x" + Integer.toString(b, 16));
            }
        }
        if (i <= 0) {
            return OooO.OooO0o0;
        }
        return new OooO(false, bArr, (i >> 2) << 2, true, null);
    }

    public static OooO OooO0O0() {
        return OooO.OooO0o0;
    }

    public static OooO0OO OooO0OO() {
        return OooO0OO.OooO0o0;
    }

    public static OooO OooO0Oo() {
        return OooO.OooO0oO;
    }

    public static OooO OooO0o() {
        return OooO.OooO0o;
    }

    public static OooO0OO OooO0o0() {
        return OooO0OO.OooO0Oo;
    }
}
