package com.adprof.sdk;

import android.graphics.Bitmap;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;
import java.util.Iterator;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class p9 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f1360a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Bitmap f555a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public s9 f557a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final tl f558a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public ByteBuffer f559a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f560a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public byte[] f561a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public int[] f562a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public short[] f563a;
    public int b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public boolean f564b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public byte[] f565b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public int[] f566b;
    public int c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public byte[] f567c;
    public int d;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    public byte[] f569d;
    public int e;

    /* JADX INFO: renamed from: e, reason: collision with other field name */
    public byte[] f570e;
    public int f;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public final int[] f568c = new int[256];
    public int g = 0;
    public int h = 0;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public r9 f556a = new r9();

    public p9(tl tlVar) {
        this.f558a = tlVar;
    }

    public final int a() {
        try {
            m701a();
            byte[] bArr = this.f570e;
            int i = this.g;
            this.g = i + 1;
            return bArr[i] & 255;
        } catch (Throwable unused) {
            this.f = 1;
            return 0;
        }
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public final Bitmap m700a() {
        Bitmap.Config config = this.f560a ? Bitmap.Config.ARGB_8888 : Bitmap.Config.RGB_565;
        tl tlVar = this.f558a;
        int i = this.b;
        int i2 = this.f1360a;
        tlVar.getClass();
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(i, i2, config);
        bitmapCreateBitmap.setHasAlpha(true);
        return bitmapCreateBitmap;
    }

    public final void a(int[] iArr, q9 q9Var, int i) {
        int i2 = q9Var.g;
        int i3 = this.e;
        int i4 = i2 / i3;
        int i5 = q9Var.e / i3;
        int i6 = q9Var.f / i3;
        int i7 = q9Var.d / i3;
        int i8 = this.b;
        int i9 = (i5 * i8) + i7;
        int i10 = (i4 * i8) + i9;
        while (i9 < i10) {
            int i11 = i9 + i6;
            for (int i12 = i9; i12 < i11; i12++) {
                iArr[i12] = i;
            }
            i9 += this.b;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v28 */
    /* JADX WARN: Type inference failed for: r5v29 */
    /* JADX WARN: Type inference failed for: r5v30 */
    /* JADX WARN: Type inference failed for: r5v34, types: [short] */
    /* JADX WARN: Type inference failed for: r5v36 */
    public synchronized Bitmap b() {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        short s;
        int i8;
        int i9;
        int i10;
        try {
            int i11 = 1;
            if (this.f556a.c <= 0 || this.c < 0) {
                pk.a("unable to decode frame, frameCount=" + this.f556a.c + " framePointer=" + this.c);
                this.f = 1;
            }
            int i12 = this.f;
            if (i12 != 1 && i12 != 2) {
                int i13 = 0;
                this.f = 0;
                q9 q9Var = (q9) this.f556a.f700a.get(this.c);
                int i14 = this.c - 1;
                q9 q9Var2 = i14 >= 0 ? (q9) this.f556a.f700a.get(i14) : null;
                int[] iArr = q9Var.f676a;
                if (iArr == null) {
                    iArr = this.f556a.f702a;
                }
                this.f562a = iArr;
                if (iArr == null) {
                    pk.a("No Valid Color Table for frame #" + this.c);
                    this.f = 1;
                    return null;
                }
                if (q9Var.f677b) {
                    System.arraycopy(iArr, 0, this.f568c, 0, iArr.length);
                    int[] iArr2 = this.f568c;
                    this.f562a = iArr2;
                    iArr2[q9Var.h] = 0;
                }
                int[] iArr3 = this.f566b;
                if (q9Var2 == null) {
                    Arrays.fill(iArr3, 0);
                }
                if (q9Var2 != null && (i9 = q9Var2.c) > 0) {
                    if (i9 == 2) {
                        if (!q9Var.f677b) {
                            r9 r9Var = this.f556a;
                            i10 = r9Var.f1399a;
                            if (q9Var.f676a != null && r9Var.b == q9Var.h) {
                            }
                            a(iArr3, q9Var2, i10);
                        } else if (this.c == 0) {
                            this.f560a = true;
                        }
                        i10 = 0;
                        a(iArr3, q9Var2, i10);
                    } else if (i9 == 3) {
                        Bitmap bitmap = this.f555a;
                        if (bitmap == null) {
                            a(iArr3, q9Var2, 0);
                        } else {
                            int i15 = q9Var2.g;
                            int i16 = this.e;
                            int i17 = q9Var2.e / i16;
                            int i18 = q9Var2.f / i16;
                            int i19 = q9Var2.d / i16;
                            int i20 = this.b;
                            bitmap.getPixels(iArr3, (i17 * i20) + i19, i20, i19, i17, i18, i15 / i16);
                        }
                    }
                }
                this.h = 0;
                this.g = 0;
                this.f559a.position(q9Var.f1382a);
                int i21 = q9Var.g * q9Var.f;
                byte[] bArr = this.f565b;
                if (bArr == null || bArr.length < i21) {
                    this.f558a.getClass();
                    this.f565b = new byte[i21];
                }
                if (this.f563a == null) {
                    this.f563a = new short[4096];
                }
                if (this.f569d == null) {
                    this.f569d = new byte[4096];
                }
                if (this.f567c == null) {
                    this.f567c = new byte[4097];
                }
                int iA = a();
                int i22 = 1 << iA;
                int i23 = i22 + 1;
                int i24 = i22 + 2;
                int i25 = iA + 1;
                int i26 = (1 << i25) - 1;
                for (int i27 = 0; i27 < i22; i27++) {
                    this.f563a[i27] = 0;
                    this.f569d[i27] = (byte) i27;
                }
                int i28 = 0;
                int i29 = 0;
                int i30 = 0;
                int i31 = 0;
                int i32 = 0;
                int i33 = 0;
                int i34 = 0;
                int i35 = 0;
                int i36 = i24;
                int i37 = i25;
                int i38 = i26;
                int i39 = -1;
                while (i29 < i21) {
                    if (i28 == 0) {
                        int iA2 = a();
                        if (iA2 > 0) {
                            try {
                                if (this.f561a == null) {
                                    this.f558a.getClass();
                                    this.f561a = new byte[255];
                                }
                                int i40 = this.h;
                                int i41 = this.g;
                                int i42 = i40 - i41;
                                if (i42 >= iA2) {
                                    System.arraycopy(this.f570e, i41, this.f561a, i13, iA2);
                                    i8 = this.g + iA2;
                                } else if (this.f559a.remaining() + i42 >= iA2) {
                                    System.arraycopy(this.f570e, this.g, this.f561a, i13, i42);
                                    this.g = this.h;
                                    m701a();
                                    int i43 = iA2 - i42;
                                    System.arraycopy(this.f570e, i13, this.f561a, i42, i43);
                                    i8 = this.g + i43;
                                } else {
                                    this.f = i11;
                                }
                                this.g = i8;
                            } catch (Throwable th) {
                                pk.a("Error Reading Block", th);
                                this.f = 1;
                            }
                        }
                        if (iA2 <= 0) {
                            this.f = 3;
                            break;
                        }
                        i30 = i13;
                        i28 = iA2;
                    }
                    i32 += (this.f561a[i30] & 255) << i31;
                    i30++;
                    i28--;
                    int i44 = i31 + 8;
                    i39 = i39;
                    i34 = i34;
                    i36 = i36;
                    i37 = i37;
                    while (true) {
                        i28 = i28;
                        if (i44 < i37) {
                            i31 = i44;
                            i13 = 0;
                            i11 = 1;
                            break;
                        }
                        int i45 = i32 & i38;
                        i32 >>= i37;
                        i44 -= i37;
                        if (i45 != i22) {
                            if (i45 > i36) {
                                i7 = i44;
                                this.f = 3;
                            } else {
                                i7 = i44;
                                if (i45 != i23) {
                                    if (i39 == -1) {
                                        this.f567c[i35] = this.f569d[i45];
                                        i39 = i45;
                                        i35++;
                                        i44 = i7;
                                        i34 = i39;
                                    } else {
                                        if (i45 >= i36) {
                                            this.f567c[i35] = (byte) i34;
                                            s = i39;
                                            i35++;
                                        } else {
                                            s = i45;
                                        }
                                        while (s >= i22) {
                                            this.f567c[i35] = this.f569d[s];
                                            s = this.f563a[s];
                                            i35++;
                                            i45 = i45;
                                        }
                                        int i46 = i45;
                                        byte[] bArr2 = this.f569d;
                                        int i47 = bArr2[s] & 255;
                                        int i48 = i35 + 1;
                                        int i49 = i22;
                                        byte b = (byte) i47;
                                        this.f567c[i35] = b;
                                        if (i36 < 4096) {
                                            this.f563a[i36] = (short) i39;
                                            bArr2[i36] = b;
                                            i36++;
                                            if ((i36 & i38) == 0 && i36 < 4096) {
                                                i37++;
                                                i38 += i36;
                                            }
                                        }
                                        i35 = i48;
                                        while (i35 > 0) {
                                            i35--;
                                            this.f565b[i33] = this.f567c[i35];
                                            i29++;
                                            i33++;
                                        }
                                        i34 = i47;
                                        i44 = i7;
                                        i39 = i46;
                                        i22 = i49;
                                    }
                                }
                            }
                            i28 = i28;
                            i31 = i7;
                            i13 = 0;
                            i11 = 1;
                            break;
                        }
                        i36 = i24;
                        i37 = i25;
                        i38 = i26;
                        i39 = -1;
                    }
                }
                for (int i50 = i33; i50 < i21; i50++) {
                    this.f565b[i50] = 0;
                }
                int i51 = q9Var.g;
                int i52 = this.e;
                int i53 = i51 / i52;
                int i54 = q9Var.e / i52;
                int i55 = q9Var.f / i52;
                int i56 = q9Var.d / i52;
                boolean z = this.c == 0;
                int i57 = 0;
                int i58 = 0;
                int i59 = 8;
                int i60 = 1;
                while (i58 < i53) {
                    if (q9Var.f675a) {
                        if (i57 >= i53) {
                            i60++;
                            if (i60 == 2) {
                                i57 = 4;
                            } else if (i60 == 3) {
                                i59 = 4;
                                i57 = 2;
                            } else if (i60 == 4) {
                                i59 = 2;
                                i57 = 1;
                            }
                        }
                        i2 = i57 + i59;
                    } else {
                        i2 = i57;
                        i57 = i58;
                    }
                    int i61 = i57 + i54;
                    if (i61 < this.f1360a) {
                        int i62 = this.b;
                        int i63 = i61 * i62;
                        int i64 = i63 + i56;
                        int i65 = i64 + i55;
                        int i66 = i63 + i62;
                        if (i66 < i65) {
                            i65 = i66;
                        }
                        int i67 = this.e;
                        int i68 = i58 * i67 * q9Var.f;
                        int i69 = ((i65 - i64) * i67) + i68;
                        int i70 = i64;
                        while (i70 < i65) {
                            int i71 = i53;
                            int i72 = i54;
                            if (this.e == 1) {
                                i6 = this.f562a[this.f565b[i68] & 255];
                                i3 = i55;
                                i4 = i56;
                                i5 = i60;
                            } else {
                                int i73 = q9Var.f;
                                i3 = i55;
                                int i74 = i68;
                                int i75 = 0;
                                int i76 = 0;
                                int i77 = 0;
                                int i78 = 0;
                                int i79 = 0;
                                while (true) {
                                    if (i74 >= this.e + i68) {
                                        i4 = i56;
                                        break;
                                    }
                                    byte[] bArr3 = this.f565b;
                                    i4 = i56;
                                    if (i74 >= bArr3.length || i74 >= i69) {
                                        break;
                                    }
                                    int i80 = this.f562a[bArr3[i74] & 255];
                                    if (i80 != 0) {
                                        i78 += (i80 >> 24) & 255;
                                        i77 += (i80 >> 16) & 255;
                                        i76 += (i80 >> 8) & 255;
                                        i75 += i80 & 255;
                                        i79++;
                                    }
                                    i74++;
                                    i56 = i4;
                                    i60 = i60;
                                }
                                i5 = i60;
                                int i81 = i73 + i68;
                                for (int i82 = i81; i82 < this.e + i81; i82++) {
                                    byte[] bArr4 = this.f565b;
                                    if (i82 >= bArr4.length || i82 >= i69) {
                                        break;
                                    }
                                    int i83 = this.f562a[bArr4[i82] & 255];
                                    if (i83 != 0) {
                                        i78 += (i83 >> 24) & 255;
                                        i77 += (i83 >> 16) & 255;
                                        i76 += (i83 >> 8) & 255;
                                        i75 += i83 & 255;
                                        i79++;
                                    }
                                }
                                i6 = i79 == 0 ? 0 : ((i78 / i79) << 24) | ((i77 / i79) << 16) | ((i76 / i79) << 8) | (i75 / i79);
                            }
                            if (i6 != 0) {
                                iArr3[i70] = i6;
                            } else if (!this.f560a && z) {
                                this.f560a = true;
                            }
                            i68 += this.e;
                            i70++;
                            i53 = i71;
                            i54 = i72;
                            i55 = i3;
                            i56 = i4;
                            i60 = i5;
                        }
                    }
                    i58++;
                    i57 = i2;
                    i53 = i53;
                    i54 = i54;
                    i55 = i55;
                    i56 = i56;
                    i60 = i60;
                }
                if (this.f564b && ((i = q9Var.c) == 0 || i == 1)) {
                    if (this.f555a == null) {
                        this.f555a = m700a();
                    }
                    Bitmap bitmap2 = this.f555a;
                    int i84 = this.b;
                    bitmap2.setPixels(iArr3, 0, i84, 0, 0, i84, this.f1360a);
                }
                Bitmap bitmapM700a = m700a();
                int i85 = this.b;
                bitmapM700a.setPixels(iArr3, 0, i85, 0, 0, i85, this.f1360a);
                return bitmapM700a;
            }
            pk.a("Unable to decode frame, status=" + this.f);
            return null;
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public synchronized int a(byte[] bArr) {
        if (this.f557a == null) {
            this.f557a = new s9();
        }
        s9 s9Var = this.f557a;
        s9Var.getClass();
        if (bArr != null) {
            ByteBuffer byteBufferWrap = ByteBuffer.wrap(bArr);
            s9Var.f719a = null;
            Arrays.fill(s9Var.f720a, (byte) 0);
            s9Var.f718a = new r9();
            s9Var.f1416a = 0;
            ByteBuffer byteBufferAsReadOnlyBuffer = byteBufferWrap.asReadOnlyBuffer();
            s9Var.f719a = byteBufferAsReadOnlyBuffer;
            byteBufferAsReadOnlyBuffer.position(0);
            s9Var.f719a.order(ByteOrder.LITTLE_ENDIAN);
        } else {
            s9Var.f719a = null;
            s9Var.f718a.g = 2;
        }
        if (s9Var.f719a != null) {
            if (!s9Var.m717a()) {
                String str = "";
                for (int i = 0; i < 6; i++) {
                    str = str + ((char) s9Var.a());
                }
                if (str.startsWith("GIF")) {
                    s9Var.f718a.h = s9Var.f719a.getShort();
                    s9Var.f718a.e = s9Var.f719a.getShort();
                    int iA = s9Var.a();
                    r9 r9Var = s9Var.f718a;
                    r9Var.f701a = (iA & 128) != 0;
                    r9Var.d = 2 << (iA & 7);
                    r9Var.b = s9Var.a();
                    r9 r9Var2 = s9Var.f718a;
                    s9Var.a();
                    r9Var2.getClass();
                    if (s9Var.f718a.f701a && !s9Var.m717a()) {
                        r9 r9Var3 = s9Var.f718a;
                        r9Var3.f702a = s9Var.a(r9Var3.d);
                        r9 r9Var4 = s9Var.f718a;
                        r9Var4.f1399a = r9Var4.f702a[r9Var4.b];
                    }
                } else {
                    s9Var.f718a.g = 1;
                }
                if (!s9Var.m717a()) {
                    boolean z = false;
                    while (!z && !s9Var.m717a() && s9Var.f718a.c <= Integer.MAX_VALUE) {
                        int iA2 = s9Var.a();
                        if (iA2 == 33) {
                            int iA3 = s9Var.a();
                            if (iA3 != 1) {
                                if (iA3 == 249) {
                                    s9Var.f718a.f699a = new q9();
                                    s9Var.a();
                                    int iA4 = s9Var.a();
                                    q9 q9Var = s9Var.f718a.f699a;
                                    int i2 = (iA4 & 28) >> 2;
                                    q9Var.c = i2;
                                    if (i2 == 0) {
                                        q9Var.c = 1;
                                    }
                                    q9Var.f677b = (iA4 & 1) != 0;
                                    short s = s9Var.f719a.getShort();
                                    if (s < 2) {
                                        s = 10;
                                    }
                                    q9 q9Var2 = s9Var.f718a.f699a;
                                    q9Var2.b = s * 10;
                                    q9Var2.h = s9Var.a();
                                    s9Var.a();
                                } else if (iA3 != 254 && iA3 == 255) {
                                    s9Var.b();
                                    String str2 = "";
                                    for (int i3 = 0; i3 < 11; i3++) {
                                        str2 = str2 + ((char) s9Var.f720a[i3]);
                                    }
                                    if (str2.equals("NETSCAPE2.0")) {
                                        do {
                                            s9Var.b();
                                            byte[] bArr2 = s9Var.f720a;
                                            if (bArr2[0] == 1) {
                                                int i4 = bArr2[1] & 255;
                                                int i5 = bArr2[2] & 255;
                                                r9 r9Var5 = s9Var.f718a;
                                                int i6 = (i5 << 8) | i4;
                                                r9Var5.f = i6;
                                                if (i6 == 0) {
                                                    r9Var5.f = -1;
                                                }
                                            }
                                            if (s9Var.f1416a <= 0) {
                                                break;
                                            }
                                        } while (!s9Var.m717a());
                                    }
                                }
                            }
                            s9Var.m716a();
                        } else if (iA2 == 44) {
                            r9 r9Var6 = s9Var.f718a;
                            if (r9Var6.f699a == null) {
                                r9Var6.f699a = new q9();
                            }
                            r9Var6.f699a.d = s9Var.f719a.getShort();
                            s9Var.f718a.f699a.e = s9Var.f719a.getShort();
                            s9Var.f718a.f699a.f = s9Var.f719a.getShort();
                            s9Var.f718a.f699a.g = s9Var.f719a.getShort();
                            int iA5 = s9Var.a();
                            boolean z2 = (iA5 & 128) != 0;
                            int iPow = (int) Math.pow(2.0d, (iA5 & 7) + 1);
                            q9 q9Var3 = s9Var.f718a.f699a;
                            q9Var3.f675a = (iA5 & 64) != 0;
                            if (z2) {
                                q9Var3.f676a = s9Var.a(iPow);
                            } else {
                                q9Var3.f676a = null;
                            }
                            s9Var.f718a.f699a.f1382a = s9Var.f719a.position();
                            s9Var.a();
                            s9Var.m716a();
                            if (!s9Var.m717a()) {
                                r9 r9Var7 = s9Var.f718a;
                                r9Var7.c++;
                                r9Var7.f700a.add(r9Var7.f699a);
                            }
                        } else if (iA2 != 59) {
                            s9Var.f718a.g = 1;
                        } else {
                            z = true;
                        }
                    }
                    r9 r9Var8 = s9Var.f718a;
                    if (r9Var8.c < 0) {
                        r9Var8.g = 1;
                    }
                }
            }
            r9 r9Var9 = s9Var.f718a;
            this.f556a = r9Var9;
            if (bArr != null) {
                synchronized (this) {
                    ByteBuffer byteBufferWrap2 = ByteBuffer.wrap(bArr);
                    synchronized (this) {
                        synchronized (this) {
                            int iHighestOneBit = Integer.highestOneBit(1);
                            this.f = 0;
                            this.f556a = r9Var9;
                            this.f560a = false;
                            this.c = -1;
                            this.d = 0;
                            ByteBuffer byteBufferAsReadOnlyBuffer2 = byteBufferWrap2.asReadOnlyBuffer();
                            this.f559a = byteBufferAsReadOnlyBuffer2;
                            byteBufferAsReadOnlyBuffer2.position(0);
                            this.f559a.order(ByteOrder.LITTLE_ENDIAN);
                            this.f564b = false;
                            Iterator it = r9Var9.f700a.iterator();
                            while (it.hasNext()) {
                                if (((q9) it.next()).c == 3) {
                                    this.f564b = true;
                                    break;
                                }
                            }
                            this.e = iHighestOneBit;
                            int i7 = r9Var9.h;
                            this.b = i7 / iHighestOneBit;
                            int i8 = r9Var9.e;
                            this.f1360a = i8 / iHighestOneBit;
                            this.f558a.getClass();
                            this.f565b = new byte[i7 * i8];
                            tl tlVar = this.f558a;
                            int i9 = this.b * this.f1360a;
                            tlVar.getClass();
                            this.f566b = new int[i9];
                        }
                    }
                }
            }
        } else {
            throw new IllegalStateException("You must call setData() before parseHeader()");
        }
        return this.f;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public final void m701a() {
        if (this.h > this.g) {
            return;
        }
        if (this.f570e == null) {
            this.f558a.getClass();
            this.f570e = new byte[16384];
        }
        this.g = 0;
        int iMin = Math.min(this.f559a.remaining(), 16384);
        this.h = iMin;
        this.f559a.get(this.f570e, 0, iMin);
    }
}
