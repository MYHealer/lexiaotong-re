package com.miui.zeus.mimo.sdk;

import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import com.huawei.openalliance.ad.views.PPSLabelView;
import java.io.BufferedInputStream;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.Writer;
import java.lang.reflect.Array;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import kotlin.io.encoding.Base64;
import org.apache.commons.io.IOUtils;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class u4 implements Closeable {
    public File c;
    public File d;
    public File e;
    public int f;
    public int g;
    public int h;
    public long i;
    public Writer l;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinkedHashMap<String, c> f5628a = new LinkedHashMap<>(0, 0.75f, true);
    public final ExecutorService b = new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue());
    public long j = 0;
    public long k = 0;
    public final Callable<Void> m = new a();

    public class a implements Callable<Void> {
        public a() {
        }

        @Override // java.util.concurrent.Callable
        public Void call() {
            synchronized (u4.this) {
                u4 u4Var = u4.this;
                if (u4Var.l != null) {
                    u4Var.f();
                    if (u4.this.b()) {
                        u4.this.e();
                        u4.this.h = 0;
                    }
                }
            }
            return null;
        }
    }

    public final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public c f5630a;

        public b(c cVar) {
            this.f5630a = cVar;
        }

        public void a() {
            u4.a(u4.this, this, false);
        }
    }

    public final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f5631a;
        public final long[] b;
        public boolean c;
        public b d;
        public long e;

        public c(String str) {
            this.f5631a = str;
            this.b = new long[u4.this.g];
        }

        public File a(int i) {
            return new File(u4.this.c, this.f5631a + ijiami_1011.s.s.s.d(new byte[]{75}, "eff844") + i);
        }

        public String a() {
            StringBuilder sb = new StringBuilder();
            for (long j : this.b) {
                sb.append(' ').append(j);
            }
            return sb.toString();
        }

        public File b(int i) {
            return new File(u4.this.c, this.f5631a + ijiami_1011.s.s.s.d(new byte[]{75}, "e52f29") + i + ijiami_1011.s.s.s.d(new byte[]{Ascii.ETB, 17, 12, 68}, "9ea44b"));
        }
    }

    public final class d implements Closeable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final InputStream[] f5632a;
        public final String[] b;

        public d(u4 u4Var, String str, long j, InputStream[] inputStreamArr, String[] strArr) {
            this.f5632a = inputStreamArr;
            this.b = strArr;
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            for (InputStream inputStream : this.f5632a) {
                u4.a((Closeable) inputStream);
            }
        }
    }

    static {
        Charset.forName(ijiami_1011.s.s.s.d(new byte[]{96, 99, 115, 79, 12}, "575b4d"));
    }

    public u4(File file, int i, int i2, long j) {
        this.c = file;
        this.f = i;
        this.d = new File(file, ijiami_1011.s.s.s.d(new byte[]{94, 93, 16, 71, 91, 86, 13}, "42e557"));
        this.e = new File(file, ijiami_1011.s.s.s.d(new byte[]{8, 87, SignedBytes.MAX_POWER_OF_TWO, 71, 90, 89, 13, 74, Ascii.DC2, 15, 65}, "b85548"));
        this.g = i2;
        this.i = j;
    }

    public static String a(InputStream inputStream) throws IOException {
        StringBuilder sb = new StringBuilder(80);
        while (true) {
            int i = inputStream.read();
            if (i == -1) {
                throw new EOFException();
            }
            if (i == 10) {
                int length = sb.length();
                if (length > 0) {
                    int i2 = length - 1;
                    if (sb.charAt(i2) == '\r') {
                        sb.setLength(i2);
                    }
                }
                return sb.toString();
            }
            sb.append((char) i);
        }
    }

    public static void a(u4 u4Var, b bVar, boolean z) {
        synchronized (u4Var) {
            c cVar = bVar.f5630a;
            if (cVar.d != bVar) {
                throw new IllegalStateException();
            }
            if (z && !cVar.c) {
                for (int i = 0; i < u4Var.g; i++) {
                    if (!cVar.b(i).exists()) {
                        bVar.a();
                        throw new IllegalStateException(ijiami_1011.s.s.s.d(new byte[]{92, 80, 93, 65, Ascii.EM, 92, 8, 0, 8, 69, 69, 69, 90, 70, 81, 84, 77, 93, 65, 2, 15, 14, 84, 69}, "944598") + i);
                    }
                }
            }
            for (int i2 = 0; i2 < u4Var.g; i2++) {
                File fileB = cVar.b(i2);
                if (!z) {
                    b(fileB);
                } else if (fileB.exists()) {
                    File fileA = cVar.a(i2);
                    fileB.renameTo(fileA);
                    long j = cVar.b[i2];
                    long length = fileA.length();
                    cVar.b[i2] = length;
                    u4Var.j = (u4Var.j - j) + length;
                }
            }
            u4Var.h++;
            cVar.d = null;
            if (cVar.c || z) {
                cVar.c = true;
                u4Var.l.write(ijiami_1011.s.s.s.d(new byte[]{116, 117, 115, 112, 43, 16}, "7961e0") + cVar.f5631a + cVar.a() + '\n');
                if (z) {
                    long j2 = u4Var.k;
                    u4Var.k = 1 + j2;
                    cVar.e = j2;
                }
            } else {
                u4Var.f5628a.remove(cVar.f5631a);
                u4Var.l.write(ijiami_1011.s.s.s.d(new byte[]{99, 33, 127, 127, 96, 33, 65}, "1d206d") + cVar.f5631a + '\n');
            }
            if (u4Var.j > u4Var.i || u4Var.b()) {
                u4Var.b.submit(u4Var.m);
            }
        }
    }

    public static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (RuntimeException e) {
                throw e;
            } catch (Exception unused) {
            }
        }
    }

    public static void a(File file) throws IOException {
        File[] fileArrListFiles = file.listFiles();
        if (fileArrListFiles == null) {
            throw new IllegalArgumentException(ijiami_1011.s.s.s.d(new byte[]{11, 93, 17, Ascii.SYN, 5, 19, 5, 13, Ascii.DC4, 7, 82, 17, 10, SignedBytes.MAX_POWER_OF_TWO, Ascii.FS, 12, 68}, "e2e6d3") + file);
        }
        for (File file2 : fileArrListFiles) {
            if (file2.isDirectory()) {
                a(file2);
            }
            if (!file2.delete()) {
                throw new IOException(ijiami_1011.s.s.s.d(new byte[]{84, 86, 8, 93, 87, 6, 65, 16, 9, 66, 85, 0, 94, 82, Ascii.NAK, 84, Ascii.DC2, 4, 8, 8, 3, 88, 17}, "27a12b") + file2);
            }
        }
    }

    public static void b(File file) throws IOException {
        if (file.exists() && !file.delete()) {
            throw new IOException();
        }
    }

    public final void a() {
        if (this.l == null) {
            throw new IllegalStateException(ijiami_1011.s.s.s.d(new byte[]{81, 4, 1, 90, 7, 70, 8, Ascii.ETB, 70, 1, 93, 10, 65, 0, 6}, "2eb2bf"));
        }
    }

    public synchronized d b(String str) {
        a();
        e(str);
        c cVar = this.f5628a.get(str);
        if (cVar != null && cVar.c) {
            int i = this.g;
            InputStream[] inputStreamArr = new InputStream[i];
            String[] strArr = new String[i];
            for (int i2 = 0; i2 < this.g; i2++) {
                try {
                    strArr[i2] = cVar.a(i2).getAbsolutePath();
                    inputStreamArr[i2] = new FileInputStream(cVar.a(i2));
                } catch (FileNotFoundException unused) {
                    return null;
                }
            }
            this.h++;
            this.l.append((CharSequence) (ijiami_1011.s.s.s.d(new byte[]{101, 116, 37, 117, Ascii.SYN}, "71d169") + str + '\n'));
            if (b()) {
                this.b.submit(this.m);
            }
            return new d(this, str, cVar.e, inputStreamArr, strArr);
        }
        return null;
    }

    public final boolean b() {
        int i = this.h;
        return i >= 2000 && i >= this.f5628a.size();
    }

    public final void c() throws IOException {
        b(this.e);
        Iterator<c> it = this.f5628a.values().iterator();
        while (it.hasNext()) {
            c next = it.next();
            int i = 0;
            if (next.d == null) {
                while (i < this.g) {
                    this.j += next.b[i];
                    i++;
                }
            } else {
                next.d = null;
                while (i < this.g) {
                    b(next.a(i));
                    b(next.b(i));
                    i++;
                }
                it.remove();
            }
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() {
        if (this.l == null) {
            return;
        }
        Iterator it = new ArrayList(this.f5628a.values()).iterator();
        while (it.hasNext()) {
            b bVar = ((c) it.next()).d;
            if (bVar != null) {
                bVar.a();
            }
        }
        f();
        this.l.close();
        this.l = null;
    }

    public final void d() {
        BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(this.d), 8192);
        try {
            String strA = a((InputStream) bufferedInputStream);
            String strA2 = a((InputStream) bufferedInputStream);
            String strA3 = a((InputStream) bufferedInputStream);
            String strA4 = a((InputStream) bufferedInputStream);
            String strA5 = a((InputStream) bufferedInputStream);
            if (!ijiami_1011.s.s.s.d(new byte[]{85, 92, 85, 7, 12, SignedBytes.MAX_POWER_OF_TWO, 4, 74, 15, 13, Ascii.US, 33, 80, 70, 92, 40, 17, 71, 34, 5, 5, 10, 84}, "957dc2").equals(strA) || !ijiami_1011.s.s.s.d(new byte[]{7}, "6fdb91").equals(strA2) || !Integer.toString(this.f).equals(strA3) || !Integer.toString(this.g).equals(strA4) || !"".equals(strA5)) {
                throw new IOException(ijiami_1011.s.s.s.d(new byte[]{Ascii.ETB, 88, 82, 73, 65, 1, 2, 16, 3, 6, 17, 15, 13, 67, 69, 95, 80, 8, 65, 12, 3, 3, 85, 0, 16, 12, Ascii.ETB, 106}, "b6711d") + strA + ijiami_1011.s.s.s.d(new byte[]{Ascii.FS, 65}, "0a3f9a") + strA2 + ijiami_1011.s.s.s.d(new byte[]{Ascii.EM, Ascii.NAK}, "55c007") + strA4 + ijiami_1011.s.s.s.d(new byte[]{78, Ascii.CAN}, "b8f6f3") + strA5 + ijiami_1011.s.s.s.d(new byte[]{59}, "f80995"));
            }
            while (true) {
                try {
                    c(a((InputStream) bufferedInputStream));
                } catch (EOFException unused) {
                    a((Closeable) bufferedInputStream);
                    return;
                }
            }
        } catch (Throwable th) {
            a((Closeable) bufferedInputStream);
            throw th;
        }
    }

    public synchronized boolean d(String str) {
        a();
        e(str);
        c cVar = this.f5628a.get(str);
        if (cVar != null && cVar.d == null) {
            for (int i = 0; i < this.g; i++) {
                File fileA = cVar.a(i);
                if (!fileA.delete()) {
                    throw new IOException(ijiami_1011.s.s.s.d(new byte[]{83, 85, 95, 13, 92, 86, 65, 16, 9, 66, 85, 0, 89, 81, 66, 4, Ascii.EM}, "546a92") + fileA);
                }
                long j = this.j;
                long[] jArr = cVar.b;
                this.j = j - jArr[i];
                jArr[i] = 0;
            }
            this.h++;
            this.l.append((CharSequence) (ijiami_1011.s.s.s.d(new byte[]{103, 118, 40, 124, 97, 39, 65}, "53e37b") + str + '\n'));
            this.f5628a.remove(str);
            if (b()) {
                this.b.submit(this.m);
            }
            return true;
        }
        return false;
    }

    public final synchronized void e() {
        Writer writer = this.l;
        if (writer != null) {
            writer.close();
        }
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(this.e), 8192);
        bufferedWriter.write(ijiami_1011.s.s.s.d(new byte[]{93, 8, 7, 82, 90, 68, 4, 74, 15, 13, Ascii.US, 33, 88, Ascii.DC2, 14, 125, 71, 67, 34, 5, 5, 10, 84}, "1ae156"));
        bufferedWriter.write(IOUtils.LINE_SEPARATOR_UNIX);
        bufferedWriter.write(ijiami_1011.s.s.s.d(new byte[]{85}, "ddfce0"));
        bufferedWriter.write(IOUtils.LINE_SEPARATOR_UNIX);
        bufferedWriter.write(Integer.toString(this.f));
        bufferedWriter.write(IOUtils.LINE_SEPARATOR_UNIX);
        bufferedWriter.write(Integer.toString(this.g));
        bufferedWriter.write(IOUtils.LINE_SEPARATOR_UNIX);
        bufferedWriter.write(IOUtils.LINE_SEPARATOR_UNIX);
        for (c cVar : this.f5628a.values()) {
            if (cVar.d != null) {
                bufferedWriter.write(ijiami_1011.s.s.s.d(new byte[]{39, 44, 107, 99, 58, Ascii.DC2}, "ce97c2") + cVar.f5631a + '\n');
            } else {
                bufferedWriter.write(ijiami_1011.s.s.s.d(new byte[]{39, 120, 38, 114, 118, 16}, "d4c380") + cVar.f5631a + cVar.a() + '\n');
            }
        }
        bufferedWriter.close();
        this.e.renameTo(this.d);
        this.l = new BufferedWriter(new FileWriter(this.d, true), 8192);
    }

    public final void e(String str) {
        if (str.contains(PPSLabelView.Code) || str.contains(IOUtils.LINE_SEPARATOR_UNIX) || str.contains("\r")) {
            throw new IllegalArgumentException(ijiami_1011.s.s.s.d(new byte[]{14, 6, 75, Ascii.SYN, Ascii.DC4, 95, Ascii.DC4, Ascii.ETB, Ascii.DC2, 66, 95, 10, 17, 67, 81, 10, 90, 70, 0, 13, 8, 66, 66, Ascii.NAK, 4, 0, 87, Ascii.SYN, Ascii.DC4, 93, 19, 68, 8, 7, 70, 9, 12, 13, 87, Ascii.SYN, 14, Ascii.DC2, 67}, "ec2e42") + str + ijiami_1011.s.s.s.d(new byte[]{Ascii.NAK}, "7184a4"));
        }
    }

    public final void f() {
        while (this.j > this.i) {
            d(this.f5628a.entrySet().iterator().next().getKey());
        }
    }

    public final void c(String str) throws IOException {
        String[] strArrSplit = str.split(PPSLabelView.Code);
        if (strArrSplit.length < 2) {
            throw new IOException(ijiami_1011.s.s.s.d(new byte[]{68, 8, 81, 72, Ascii.SYN, 84, 2, 16, 3, 6, 17, 15, 94, 19, 70, 94, 7, 93, 65, 8, 15, 12, 84, 95, 17}, "1f40f1") + str);
        }
        String str2 = strArrSplit[1];
        if (strArrSplit[0].equals(ijiami_1011.s.s.s.d(new byte[]{101, 124, 44, 122, 51, 33}, "79a5ed")) && strArrSplit.length == 2) {
            this.f5628a.remove(str2);
            return;
        }
        c cVar = this.f5628a.get(str2);
        if (cVar == null) {
            cVar = new c(str2);
            this.f5628a.put(str2, cVar);
        }
        if (strArrSplit[0].equals(ijiami_1011.s.s.s.d(new byte[]{34, 116, 112, 34, 42}, "a85cd0")) && strArrSplit.length == this.g + 2) {
            cVar.c = true;
            cVar.d = null;
            int length = strArrSplit.length;
            int length2 = strArrSplit.length;
            if (2 > length) {
                throw new IllegalArgumentException();
            }
            if (2 <= length2) {
                int i = length - 2;
                int iMin = Math.min(i, length2 - 2);
                Object[] objArr = (Object[]) Array.newInstance(strArrSplit.getClass().getComponentType(), i);
                System.arraycopy(strArrSplit, 2, objArr, 0, iMin);
                String[] strArr = (String[]) objArr;
                if (strArr.length != u4.this.g) {
                    throw new IOException(ijiami_1011.s.s.s.d(new byte[]{16, 86, 86, 26, Ascii.SYN, 3, 2, 16, 3, 6, 17, 15, 10, 77, 65, 12, 7, 10, 65, 8, 15, 12, 84, 95, 69}, "e83bff") + Arrays.toString(strArr));
                }
                for (int i2 = 0; i2 < strArr.length; i2++) {
                    try {
                        cVar.b[i2] = Long.parseLong(strArr[i2]);
                    } catch (NumberFormatException unused) {
                        throw new IOException(ijiami_1011.s.s.s.d(new byte[]{69, 87, 1, 79, 72, 82, 2, 16, 3, 6, 17, 15, 95, 76, Ascii.SYN, 89, 89, 91, 65, 8, 15, 12, 84, 95, 16}, "09d787") + Arrays.toString(strArr));
                    }
                }
                return;
            }
            throw new ArrayIndexOutOfBoundsException();
        }
        if (strArrSplit[0].equals(ijiami_1011.s.s.s.d(new byte[]{33, 40, 98, 48, 56}, "ea0da6")) && strArrSplit.length == 2) {
            cVar.d = new b(cVar);
        } else if (!strArrSplit[0].equals(ijiami_1011.s.s.s.d(new byte[]{102, 115, 114, 33}, "463e2a")) || strArrSplit.length != 2) {
            throw new IOException(ijiami_1011.s.s.s.d(new byte[]{SignedBytes.MAX_POWER_OF_TWO, 94, 4, 74, 69, 80, 2, 16, 3, 6, 17, 15, 90, 69, 19, 92, 84, 89, 65, 8, 15, 12, 84, 95, Ascii.NAK}, "50a255") + str);
        }
    }

    public b a(String str) {
        synchronized (this) {
            a();
            e(str);
            c cVar = this.f5628a.get(str);
            if (cVar == null) {
                cVar = new c(str);
                this.f5628a.put(str, cVar);
            } else if (cVar.d != null) {
                return null;
            }
            b bVar = new b(cVar);
            cVar.d = bVar;
            this.l.write(ijiami_1011.s.s.s.d(new byte[]{124, 121, 96, 53, Base64.padSymbol, 19}, "802ad3") + str + '\n');
            this.l.flush();
            return bVar;
        }
    }

    public static u4 a(File file, int i, int i2, long j) {
        if (j <= 0) {
            throw new IllegalArgumentException(ijiami_1011.s.s.s.d(new byte[]{12, 0, Ascii.FS, 103, 80, Ascii.EM, 4, 68, 90, 95, 17, 85}, "aad49c"));
        }
        if (i2 <= 0) {
            throw new IllegalArgumentException(ijiami_1011.s.s.s.d(new byte[]{19, 88, 92, SignedBytes.MAX_POWER_OF_TWO, 82, 119, 14, 17, 8, Ascii.SYN, 17, 89, 88, Ascii.EM, 0}, "e90574"));
        }
        u4 u4Var = new u4(file, i, i2, j);
        if (u4Var.d.exists()) {
            try {
                try {
                    u4Var.d();
                    u4Var.c();
                    u4Var.l = new BufferedWriter(new FileWriter(u4Var.d, true), 8192);
                    return u4Var;
                } catch (IOException | IllegalArgumentException unused) {
                }
            } catch (Exception unused2) {
                u4Var.close();
                a(u4Var.c);
                file.mkdirs();
                u4 u4Var2 = new u4(file, i, i2, j);
                u4Var2.e();
                return u4Var2;
            }
        }
        file.mkdirs();
        u4 u4Var3 = new u4(file, i, i2, j);
        u4Var3.e();
        return u4Var3;
    }
}
