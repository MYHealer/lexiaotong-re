package com.fancy.adsdk.lib.doodle;

import com.fancy._b0;
import com.fancy._fq;
import com.fancy._p3;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public final class _a {
    public static final byte[] _j = {100, 105, 115, 107};
    public final String _a;
    public final int _b;
    public final long _c;
    public long _d = 0;
    public int _e = 1;
    public FileChannel _f;
    public MappedByteBuffer _g;
    public HashMap _h;
    public int _i;

    /* JADX INFO: renamed from: com.fancy.adsdk.lib.doodle._a$_a, reason: collision with other inner class name */
    public static final class C0372_a {
        public final String _a;
        public final boolean _b;

        public C0372_a(String str, boolean z) {
            this._a = str;
            this._b = z;
        }
    }

    public static class _b implements Comparable<_b> {
        public final _b0 _a;
        public int _b;
        public int _c;
        public int _d;

        public _b(_b0 _b0Var, int i, int i2, int i3) {
            this._a = _b0Var;
            this._b = i;
            this._c = i2;
            this._d = i3;
        }

        @Override // java.lang.Comparable
        public final int compareTo(_b _bVar) {
            return Integer.compare(this._c, _bVar._c);
        }
    }

    public _a(int i, long j, String str) {
        this._a = _p3._b() + str;
        this._b = i;
        this._c = j;
    }

    public final void _a(int i) {
        this._g.position(i);
        int iCapacity = this._g.capacity() - i;
        int i2 = iCapacity >>> 3;
        int i3 = iCapacity & 7;
        for (int i4 = 0; i4 < i2; i4++) {
            this._g.putLong(0L);
        }
        for (int i5 = 0; i5 < i3; i5++) {
            this._g.put((byte) 0);
        }
    }

    public final synchronized void _a(_b0 _b0Var) {
        if (_a()) {
            _b _bVar = (_b) this._h.get(_b0Var);
            if (_bVar != null) {
                this._h.remove(_b0Var);
                try {
                    File file = new File(_c(_b0Var));
                    if (!file.exists() || _p3._a(file)) {
                        this._g.putInt(_bVar._b, 0);
                    }
                } catch (Throwable th) {
                    _fq._a("DiskCache", th);
                }
            }
        }
    }

    public final void _a(_b0 _b0Var, int i, boolean z) {
        int i2 = z ? Integer.MIN_VALUE | i : i;
        int i3 = this._i;
        int iCapacity = this._g.capacity();
        int i4 = i3 + 24;
        if (i4 > iCapacity) {
            this._g = this._f.map(FileChannel.MapMode.READ_WRITE, 0L, (iCapacity < 16384 ? 4096 : 8192) + iCapacity);
            _a(iCapacity);
        }
        this._g.position(i3);
        this._g.putLong(_b0Var._a);
        this._g.putLong(_b0Var._b);
        this._g.putInt(this._e);
        this._g.putInt(i2);
        this._i = i4;
        this._h.put(_b0Var, new _b(_b0Var, i3 + 16, this._e, i2));
        this._d += (long) i;
        this._e++;
    }

    public final synchronized void _a(_b0 _b0Var, File file, boolean z) {
        if (_a()) {
            if (_b0Var._a == 0 && _b0Var._b == 0) {
                return;
            }
            try {
                _b _bVar = (_b) this._h.get(_b0Var);
                if (_bVar != null) {
                    int i = this._e;
                    _bVar._c = i;
                    this._g.putInt(_bVar._b, i);
                    this._e++;
                }
                if (_bVar == null && file.exists()) {
                    long length = file.length();
                    if (length > 0 && length < this._c && length <= 2147483647L) {
                        _a(_b0Var, (int) length, z);
                        _b();
                    }
                }
            } catch (Throwable th) {
                _fq._a("DiskCache", th);
            }
        }
    }

    public final void _a(List<_b> list) {
        this._e = 1;
        this._g.position(8);
        for (_b _bVar : list) {
            this._g.putLong(_bVar._a._a);
            this._g.putLong(_bVar._a._b);
            _bVar._b = this._g.position();
            int i = this._e;
            this._e = i + 1;
            _bVar._c = i;
            this._g.putInt(i);
            this._g.putInt(_bVar._d);
        }
        int iPosition = this._g.position();
        this._i = iPosition;
        _a(iPosition);
    }

    public final boolean _a() {
        if (this._c <= 0 || this._b <= 0) {
            return false;
        }
        if (this._h == null) {
            this._h = new HashMap();
            try {
                _c();
            } catch (Throwable th) {
                _fq._a("DiskCache", th);
            }
        }
        return this._g != null;
    }

    public final void _b() {
        if (this._d > this._c || this._h.size() > this._b) {
            ArrayList arrayList = new ArrayList(this._h.values());
            ArrayList arrayList2 = new ArrayList();
            Collections.sort(arrayList);
            long j = (this._c * 7) / 8;
            int i = (this._b * 7) / 8;
            int size = arrayList.size();
            int i2 = 0;
            while (i2 < size && (this._d > j || this._h.size() > i)) {
                int i3 = i2 + 1;
                _b _bVar = (_b) arrayList.get(i2);
                if (_p3._a(new File(_c(_bVar._a)))) {
                    this._h.remove(_bVar._a);
                    this._d -= (long) (_bVar._d & Integer.MAX_VALUE);
                } else {
                    arrayList2.add(_bVar);
                }
                i2 = i3;
            }
            boolean zIsEmpty = arrayList2.isEmpty();
            List<_b> listSubList = arrayList.subList(i2, size);
            if (zIsEmpty) {
                _a(listSubList);
            } else {
                arrayList2.addAll(listSubList);
                _a(arrayList2);
            }
        }
    }

    public final String _c(_b0 _b0Var) {
        StringBuilder sbAppend = new StringBuilder().append(this._a);
        char[] cArr = new char[32];
        long j = _b0Var._a;
        for (int i = 7; i >= 0; i--) {
            int i2 = i << 1;
            int i3 = (int) (255 & j);
            char[] cArr2 = _b0._c;
            cArr[i2] = cArr2[(i3 >> 4) & 15];
            cArr[i2 + 1] = cArr2[i3 & 15];
            j >>>= 8;
        }
        long j2 = _b0Var._b;
        for (int i4 = 7; i4 >= 0; i4--) {
            int i5 = i4 << 1;
            int i6 = (int) (j2 & 255);
            char[] cArr3 = _b0._c;
            cArr[i5 + 16] = cArr3[(i6 >> 4) & 15];
            cArr[i5 + 17] = cArr3[i6 & 15];
            j2 >>>= 8;
        }
        return sbAppend.append(new String(cArr)).toString();
    }

    public final synchronized C0372_a _b(_b0 _b0Var) {
        C0372_a c0372_a = null;
        if (!_a()) {
            return null;
        }
        _b _bVar = (_b) this._h.get(_b0Var);
        boolean z = true;
        if (_bVar != null) {
            int i = this._e;
            _bVar._c = i;
            this._g.putInt(_bVar._b, i);
            this._e++;
        }
        if (_bVar != null) {
            String str_c = _c(_b0Var);
            if ((_bVar._d & Integer.MIN_VALUE) == 0) {
                z = false;
            }
            c0372_a = new C0372_a(str_c, z);
        }
        return c0372_a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v11, types: [long] */
    /* JADX WARN: Type inference failed for: r12v4, types: [long] */
    /* JADX WARN: Type inference failed for: r22v0 */
    /* JADX WARN: Type inference failed for: r22v1 */
    /* JADX WARN: Type inference failed for: r22v10 */
    /* JADX WARN: Type inference failed for: r22v11 */
    /* JADX WARN: Type inference failed for: r22v12 */
    /* JADX WARN: Type inference failed for: r22v13 */
    /* JADX WARN: Type inference failed for: r22v2 */
    /* JADX WARN: Type inference failed for: r22v3 */
    /* JADX WARN: Type inference failed for: r22v4 */
    /* JADX WARN: Type inference failed for: r22v5 */
    /* JADX WARN: Type inference failed for: r22v6 */
    /* JADX WARN: Type inference failed for: r22v7 */
    /* JADX WARN: Type inference failed for: r22v8 */
    /* JADX WARN: Type inference failed for: r22v9 */
    /* JADX WARN: Type inference failed for: r3v12 */
    /* JADX WARN: Type inference failed for: r3v13 */
    /* JADX WARN: Type inference failed for: r3v14 */
    /* JADX WARN: Type inference failed for: r3v15 */
    /* JADX WARN: Type inference failed for: r3v2, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r3v9 */
    public final void _c() throws IOException {
        ?? r3;
        _b _bVar;
        ?? r22;
        String[] strArr;
        int i;
        ?? r23;
        _b0 _b0Var;
        int i2;
        int i3;
        int i4;
        int i5;
        long j;
        File file;
        String str = "journal";
        File file2 = new File(this._a + "journal");
        if (!file2.isFile()) {
            File parentFile = file2.getParentFile();
            if (parentFile == null) {
                return;
            }
            if ((!parentFile.isDirectory() && !parentFile.mkdirs()) || !file2.createNewFile()) {
                return;
            }
        }
        RandomAccessFile randomAccessFile = new RandomAccessFile(file2, "rw");
        this._f = randomAccessFile.getChannel();
        long length = randomAccessFile.length();
        long j2 = 0;
        int i6 = 8;
        int i7 = 0;
        if (length == 0 || (4095 & length) != 0) {
            MappedByteBuffer map = this._f.map(FileChannel.MapMode.READ_WRITE, 0L, 4096L);
            this._g = map;
            map.position(0);
            this._g.put(_j);
            this._g.putInt(1);
            _a(8);
        } else {
            MappedByteBuffer map2 = this._f.map(FileChannel.MapMode.READ_WRITE, 0L, length);
            this._g = map2;
            byte[] bArr = new byte[4];
            map2.get(bArr);
            byte[] bArr2 = _j;
            if (!Arrays.equals(bArr, bArr2)) {
                this._g.position(0);
                this._g.put(bArr2);
                this._g.putInt(1);
                _a(8);
            }
        }
        this._g.position(8);
        this._i = 8;
        int i8 = 0;
        int i9 = 0;
        while (this._i + 24 <= this._g.capacity()) {
            long j3 = this._g.getLong();
            long j4 = this._g.getLong();
            if (j3 == 0 && j4 == 0) {
                break;
            }
            _b0 _b0Var2 = new _b0(j3, j4);
            int iPosition = this._g.position();
            int i10 = this._g.getInt();
            if (i10 > 0) {
                if (i10 > i9) {
                    i9 = i10;
                }
                _b _bVar2 = new _b(_b0Var2, iPosition, i10, this._g.getInt());
                this._h.put(_b0Var2, _bVar2);
                this._d += (long) (_bVar2._d & Integer.MAX_VALUE);
            } else {
                MappedByteBuffer mappedByteBuffer = this._g;
                mappedByteBuffer.position(mappedByteBuffer.position() + 4);
                i8++;
            }
            this._i = this._g.position();
        }
        this._e = i9 + 1;
        if (i8 * 24 > 4096) {
            ArrayList arrayList = new ArrayList(this._h.values());
            Collections.sort(arrayList);
            _a(arrayList);
        }
        String[] list = new File(this._a).list();
        if (list == null || list.length == 0) {
            return;
        }
        HashSet hashSet = new HashSet(((list.length * 4) / 3) + 1);
        int length2 = list.length;
        int i11 = 0;
        while (i11 < length2) {
            String str2 = list[i11];
            if (r3.equals(str2)) {
                r3 = str;
                j = j2;
                r23 = r3;
                strArr = list;
                i = i6;
            } else {
                byte[] bytes = str2.getBytes();
                if (bytes.length != 32) {
                    r3 = str;
                    r22 = r3;
                    strArr = list;
                    i = i6;
                    _b0Var = null;
                    r23 = r22;
                } else {
                    try {
                        r3 = str;
                        int i12 = i7;
                        while (true) {
                            byte b = 48;
                            if (i12 < i6) {
                                int i13 = i12 << 1;
                                try {
                                    byte b2 = bytes[i13];
                                    if (b2 >= 48 && b2 <= 57) {
                                        i4 = b2 - 48;
                                    } else {
                                        if (b2 < 97 || b2 > 102) {
                                            throw new NumberFormatException("invalid hex number");
                                        }
                                        i4 = b2 - 87;
                                    }
                                    int i14 = i4 << 4;
                                    byte b3 = bytes[i13 + 1];
                                    if (b3 >= 48 && b3 <= 57) {
                                        i5 = b3 - 48;
                                    } else {
                                        if (b3 < 97 || b3 > 102) {
                                            throw new NumberFormatException("invalid hex number");
                                        }
                                        i5 = b3 - 87;
                                    }
                                    j2 = (j2 << 8) | ((long) (i5 | i14));
                                    i12++;
                                    i6 = 8;
                                } catch (Exception unused) {
                                    r22 = r3;
                                    strArr = list;
                                    i = 8;
                                }
                            } else {
                                int i15 = 0;
                                r22 = 0;
                                ?? r4 = r3;
                                while (i15 < i6) {
                                    int i16 = i15 << 1;
                                    byte b4 = bytes[i16 + 16];
                                    if (b4 >= b && b4 <= 57) {
                                        i2 = b4 - 48;
                                    } else {
                                        if (b4 < 97 || b4 > 102) {
                                            throw new NumberFormatException("invalid hex number");
                                        }
                                        i2 = b4 - 87;
                                    }
                                    int i17 = i2 << 4;
                                    byte b5 = bytes[i16 + 17];
                                    if (b5 >= 48 && b5 <= 57) {
                                        i3 = b5 - 48;
                                    } else {
                                        if (b5 < 97 || b5 > 102) {
                                            throw new NumberFormatException("invalid hex number");
                                        }
                                        i3 = b5 - 87;
                                    }
                                    i = 8;
                                    long j5 = r22 << 8;
                                    ?? r24 = r4;
                                    strArr = list;
                                    long j6 = ((long) (i3 | i17)) | j5;
                                    i15++;
                                    _b0 _b0Var3 = _b0Var3;
                                    i6 = 8;
                                    b = 48;
                                    r4 = r24;
                                    list = strArr;
                                    r22 = j6;
                                }
                                try {
                                    i = i6;
                                    ?? r12 = r22;
                                    r23 = r4;
                                    strArr = list;
                                    _b0Var = new _b0(j2, r12);
                                    break;
                                } catch (Exception unused2) {
                                    _b0Var = null;
                                    r23 = r22;
                                }
                            }
                            _b0Var = null;
                            r23 = r22;
                        }
                    } catch (Exception unused3) {
                        r3 = str;
                        r22 = r3;
                        strArr = list;
                        i = i6;
                    }
                }
                if (_b0Var != null) {
                    hashSet.add(_b0Var);
                    if (this._h.containsKey(_b0Var)) {
                        j = 0;
                    } else {
                        file = new File(this._a, str2);
                        long length3 = file.length();
                        j = 0;
                        if (length3 > 0) {
                            if (length3 < this._c && length3 < 2147483647L) {
                                _a(_b0Var, (int) length3, false);
                                _b();
                            }
                        }
                    }
                } else {
                    j = 0;
                    file = new File(this._a, str2);
                }
                _p3._a(file);
            }
            i11++;
            j2 = j;
            i6 = i;
            r3 = r23;
            list = strArr;
            i7 = 0;
        }
        r3 = str;
        HashSet<_b0> hashSet2 = new HashSet(this._h.keySet());
        hashSet2.removeAll(hashSet);
        if (hashSet2.isEmpty()) {
            return;
        }
        for (_b0 _b0Var4 : hashSet2) {
            if (!new File(_c(_b0Var4)).exists() && (_bVar = (_b) this._h.get(_b0Var4)) != null) {
                this._h.remove(_b0Var4);
                this._g.putInt(_bVar._b, 0);
            }
        }
    }
}
