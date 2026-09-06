package com.byazt.umr;

import client.android.yixiaotong.v3.comman.AppTypeIdUtil;
import com.byazt.mk.my;
import com.byazt.mk.rh;
import com.byazt.mk.t;
import com.huawei.openalliance.ad.views.PPSLabelView;
import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.Flushable;
import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.concurrent.Executor;
import java.util.regex.Pattern;
import org.apache.commons.io.FilenameUtils;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
@com.byazt.zqa.c(c = {0, 1, 1046, 15})
public final class uj implements Closeable, Flushable {
    public static final Pattern c = Pattern.compile("[a-z0-9_-]{1,120}");
    public static final /* synthetic */ boolean u = true;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinkedHashMap<String, tt> f2781a;
    public boolean da;
    public long gt;
    public boolean i;
    public final File m;
    public long my;
    public com.byazt.mk.uj n;
    public final int nu;
    public final Runnable qy;
    public long rh;
    public final Executor rl;
    public boolean sl;
    public int sp;
    public boolean t;
    public final com.byazt.hia.c tt;
    public final int uj;
    public final File ve;
    public boolean x;
    public final File yp;
    public final File z;

    public synchronized void c() throws IOException {
        if (!u && !Thread.holdsLock(this)) {
            throw new AssertionError();
        }
        if (this.i) {
            return;
        }
        if (this.tt.uj(this.m)) {
            if (this.tt.uj(this.yp)) {
                this.tt.delete(this.m);
            } else {
                this.tt.c(this.m, this.yp);
            }
        }
        if (this.tt.uj(this.yp)) {
            try {
                a();
                x();
                this.i = true;
                return;
            } catch (IOException e) {
                com.byazt.xb.n.tt().c(5, "DiskLruCache " + this.ve + " is corrupt: " + e.getMessage() + ", removing", e);
                try {
                    delete();
                    this.da = false;
                    tt();
                    this.i = true;
                } catch (Throwable th) {
                    this.da = false;
                    throw th;
                }
            }
        }
        tt();
        this.i = true;
    }

    private void a() throws IOException {
        com.byazt.mk.n nVarC = t.c(this.tt.c(this.yp));
        try {
            String strM = nVarC.m();
            String strM2 = nVarC.m();
            String strM3 = nVarC.m();
            String strM4 = nVarC.m();
            String strM5 = nVarC.m();
            if (!"libcore.io.DiskLruCache".equals(strM) || !"1".equals(strM2) || !Integer.toString(this.nu).equals(strM3) || !Integer.toString(this.uj).equals(strM4) || !"".equals(strM5)) {
                throw new IOException("unexpected journal header: [" + strM + ", " + strM2 + ", " + strM4 + ", " + strM5 + "]");
            }
            int i = 0;
            while (true) {
                try {
                    c(nVarC.m());
                    i++;
                } catch (EOFException unused) {
                    this.sp = i - this.f2781a.size();
                    if (!nVarC.n()) {
                        tt();
                    } else {
                        this.n = sp();
                    }
                    com.byazt.kh.ve.c(nVarC);
                    return;
                }
            }
        } catch (Throwable th) {
            com.byazt.kh.ve.c(nVarC);
            throw th;
        }
    }

    private com.byazt.mk.uj sp() throws FileNotFoundException {
        return t.c(new n(this.tt.ve(this.yp)) { // from class: com.byazt.umr.uj.1
            public static final /* synthetic */ boolean c = true;

            @Override // com.byazt.umr.n
            public void c(IOException iOException) {
                if (!c && !Thread.holdsLock(uj.this)) {
                    throw new AssertionError();
                }
                uj.this.x = true;
            }
        });
    }

    private void c(String str) throws IOException {
        String strSubstring;
        int iIndexOf = str.indexOf(32);
        if (iIndexOf == -1) {
            throw new IOException("unexpected journal line: ".concat(String.valueOf(str)));
        }
        int i = iIndexOf + 1;
        int iIndexOf2 = str.indexOf(32, i);
        if (iIndexOf2 == -1) {
            strSubstring = str.substring(i);
            if (iIndexOf == 6 && str.startsWith("REMOVE")) {
                this.f2781a.remove(strSubstring);
                return;
            }
        } else {
            strSubstring = str.substring(i, iIndexOf2);
        }
        tt ttVar = this.f2781a.get(strSubstring);
        if (ttVar == null) {
            ttVar = new tt(strSubstring);
            this.f2781a.put(strSubstring, ttVar);
        }
        if (iIndexOf2 != -1 && iIndexOf == 5 && str.startsWith("CLEAN")) {
            String[] strArrSplit = str.substring(iIndexOf2 + 1).split(PPSLabelView.Code);
            ttVar.n = true;
            ttVar.f2782a = null;
            ttVar.c(strArrSplit);
            return;
        }
        if (iIndexOf2 == -1 && iIndexOf == 5 && str.startsWith("DIRTY")) {
            ttVar.f2782a = new c(ttVar);
        } else if (iIndexOf2 != -1 || iIndexOf != 4 || !str.startsWith("READ")) {
            throw new IOException("unexpected journal line: ".concat(String.valueOf(str)));
        }
    }

    private void x() throws IOException {
        this.tt.delete(this.z);
        Iterator<tt> it = this.f2781a.values().iterator();
        while (it.hasNext()) {
            tt next = it.next();
            int i = 0;
            if (next.f2782a == null) {
                while (i < this.uj) {
                    this.my += next.tt[i];
                    i++;
                }
            } else {
                next.f2782a = null;
                while (i < this.uj) {
                    this.tt.delete(next.ve[i]);
                    this.tt.delete(next.uj[i]);
                    i++;
                }
                it.remove();
            }
        }
    }

    public synchronized void tt() throws IOException {
        com.byazt.mk.uj ujVar = this.n;
        if (ujVar != null) {
            ujVar.close();
        }
        com.byazt.mk.uj ujVarC = t.c(this.tt.tt(this.z));
        try {
            ujVarC.tt("libcore.io.DiskLruCache").i(10);
            ujVarC.tt("1").i(10);
            ujVarC.t(this.nu).i(10);
            ujVarC.t(this.uj).i(10);
            ujVarC.i(10);
            for (tt ttVar : this.f2781a.values()) {
                if (ttVar.f2782a != null) {
                    ujVarC.tt("DIRTY").i(32);
                    ujVarC.tt(ttVar.c);
                    ujVarC.i(10);
                } else {
                    ujVarC.tt("CLEAN").i(32);
                    ujVarC.tt(ttVar.c);
                    ttVar.c(ujVarC);
                    ujVarC.i(10);
                }
            }
            ujVarC.close();
            if (this.tt.uj(this.yp)) {
                this.tt.c(this.yp, this.m);
            }
            this.tt.c(this.z, this.yp);
            this.tt.delete(this.m);
            this.n = sp();
            this.x = false;
            this.t = false;
        } catch (Throwable th) {
            ujVarC.close();
            throw th;
        }
    }

    public synchronized c c(String str, long j) throws IOException {
        c();
        i();
        tt(str);
        tt ttVar = this.f2781a.get(str);
        if (j != -1 && (ttVar == null || ttVar.sp != j)) {
            return null;
        }
        if (ttVar != null && ttVar.f2782a != null) {
            return null;
        }
        if (!this.sl && !this.t) {
            this.n.tt("DIRTY").i(32).tt(str).i(10);
            this.n.flush();
            if (this.x) {
                return null;
            }
            if (ttVar == null) {
                ttVar = new tt(str);
                this.f2781a.put(str, ttVar);
            }
            c cVar = new c(ttVar);
            ttVar.f2782a = cVar;
            return cVar;
        }
        this.rl.execute(this.qy);
        return null;
    }

    public synchronized void c(c cVar, boolean z) throws IOException {
        tt ttVar = cVar.c;
        if (ttVar.f2782a != cVar) {
            throw new IllegalStateException();
        }
        if (z && !ttVar.n) {
            for (int i = 0; i < this.uj; i++) {
                if (!cVar.tt[i]) {
                    cVar.ve();
                    throw new IllegalStateException("Newly created entry didn't create value for index ".concat(String.valueOf(i)));
                }
                if (!this.tt.uj(ttVar.uj[i])) {
                    cVar.ve();
                    return;
                }
            }
        }
        for (int i2 = 0; i2 < this.uj; i2++) {
            File file = ttVar.uj[i2];
            if (z) {
                if (this.tt.uj(file)) {
                    File file2 = ttVar.ve[i2];
                    this.tt.c(file, file2);
                    long j = ttVar.tt[i2];
                    long jN = this.tt.n(file2);
                    ttVar.tt[i2] = jN;
                    this.my = (this.my - j) + jN;
                }
            } else {
                this.tt.delete(file);
            }
        }
        this.sp++;
        ttVar.f2782a = null;
        if (ttVar.n | z) {
            ttVar.n = true;
            this.n.tt("CLEAN").i(32);
            this.n.tt(ttVar.c);
            ttVar.c(this.n);
            this.n.i(10);
            if (z) {
                long j2 = this.gt;
                this.gt = 1 + j2;
                ttVar.sp = j2;
            }
        } else {
            this.f2781a.remove(ttVar.c);
            this.n.tt("REMOVE").i(32);
            this.n.tt(ttVar.c);
            this.n.i(10);
        }
        this.n.flush();
        if (this.my > this.rh || ve()) {
            this.rl.execute(this.qy);
        }
    }

    public boolean ve() {
        int i = this.sp;
        return i >= 2000 && i >= this.f2781a.size();
    }

    public boolean c(tt ttVar) throws IOException {
        if (ttVar.f2782a != null) {
            ttVar.f2782a.c();
        }
        for (int i = 0; i < this.uj; i++) {
            this.tt.delete(ttVar.ve[i]);
            this.my -= ttVar.tt[i];
            ttVar.tt[i] = 0;
        }
        this.sp++;
        this.n.tt("REMOVE").i(32).tt(ttVar.c).i(10);
        this.f2781a.remove(ttVar.c);
        if (ve()) {
            this.rl.execute(this.qy);
        }
        return true;
    }

    public synchronized boolean uj() {
        return this.da;
    }

    private synchronized void i() {
        if (uj()) {
            throw new IllegalStateException("cache is closed");
        }
    }

    @Override // java.io.Flushable
    public synchronized void flush() throws IOException {
        if (this.i) {
            i();
            n();
            this.n.flush();
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() throws IOException {
        if (this.i && !this.da) {
            for (tt ttVar : (tt[]) this.f2781a.values().toArray(new tt[this.f2781a.size()])) {
                if (ttVar.f2782a != null) {
                    ttVar.f2782a.ve();
                }
            }
            n();
            this.n.close();
            this.n = null;
            this.da = true;
            return;
        }
        this.da = true;
    }

    public void n() throws IOException {
        while (this.my > this.rh) {
            c(this.f2781a.values().iterator().next());
        }
        this.sl = false;
    }

    public void delete() throws IOException {
        close();
        this.tt.a(this.ve);
    }

    private void tt(String str) {
        if (!c.matcher(str).matches()) {
            throw new IllegalArgumentException("keys must match regex [a-z0-9_-]{1,120}: \"" + str + "\"");
        }
    }

    @com.byazt.zqa.c(c = {0, 1, 1046, 1694})
    public final class ve implements Closeable {
        public final /* synthetic */ uj c;
        public final String tt;
        public final my[] uj;
        public final long ve;

        public c c() throws IOException {
            return this.c.c(this.tt, this.ve);
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            for (my myVar : this.uj) {
                com.byazt.kh.ve.c(myVar);
            }
        }
    }

    @com.byazt.zqa.c(c = {0, 1, 1046, AppTypeIdUtil.NewDevice4GBathOTA})
    public final class c {
        public final tt c;
        public final boolean[] tt;
        public boolean uj;

        public c(tt ttVar) {
            this.c = ttVar;
            this.tt = ttVar.n ? null : new boolean[uj.this.uj];
        }

        public void c() {
            if (this.c.f2782a == this) {
                for (int i = 0; i < uj.this.uj; i++) {
                    try {
                        uj.this.tt.delete(this.c.uj[i]);
                    } catch (IOException unused) {
                    }
                }
                this.c.f2782a = null;
            }
        }

        public rh c(int i) {
            synchronized (uj.this) {
                if (this.uj) {
                    throw new IllegalStateException();
                }
                if (this.c.f2782a != this) {
                    return t.c();
                }
                if (!this.c.n) {
                    this.tt[i] = true;
                }
                try {
                    return new n(uj.this.tt.tt(this.c.uj[i])) { // from class: com.byazt.umr.uj.c.1
                        @Override // com.byazt.umr.n
                        public void c(IOException iOException) {
                            synchronized (uj.this) {
                                c.this.c();
                            }
                        }
                    };
                } catch (FileNotFoundException unused) {
                    return t.c();
                }
            }
        }

        public void tt() throws IOException {
            synchronized (uj.this) {
                if (this.uj) {
                    throw new IllegalStateException();
                }
                if (this.c.f2782a == this) {
                    uj.this.c(this, true);
                }
                this.uj = true;
            }
        }

        public void ve() throws IOException {
            synchronized (uj.this) {
                if (this.uj) {
                    throw new IllegalStateException();
                }
                if (this.c.f2782a == this) {
                    uj.this.c(this, false);
                }
                this.uj = true;
            }
        }
    }

    @com.byazt.zqa.c(c = {0, 1, 1046, 153})
    private final class tt {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public c f2782a;
        public final String c;
        public boolean n;
        public long sp;
        public final long[] tt;
        public final File[] uj;
        public final File[] ve;

        public tt(String str) {
            this.c = str;
            this.tt = new long[uj.this.uj];
            this.ve = new File[uj.this.uj];
            this.uj = new File[uj.this.uj];
            StringBuilder sbAppend = new StringBuilder(str).append(FilenameUtils.EXTENSION_SEPARATOR);
            int length = sbAppend.length();
            for (int i = 0; i < uj.this.uj; i++) {
                sbAppend.append(i);
                this.ve[i] = new File(uj.this.ve, sbAppend.toString());
                sbAppend.append(".tmp");
                this.uj[i] = new File(uj.this.ve, sbAppend.toString());
                sbAppend.setLength(length);
            }
        }

        public void c(String[] strArr) throws IOException {
            if (strArr.length != uj.this.uj) {
                throw tt(strArr);
            }
            for (int i = 0; i < strArr.length; i++) {
                try {
                    this.tt[i] = Long.parseLong(strArr[i]);
                } catch (NumberFormatException unused) {
                    throw tt(strArr);
                }
            }
        }

        public void c(com.byazt.mk.uj ujVar) throws IOException {
            for (long j : this.tt) {
                ujVar.i(32).t(j);
            }
        }

        private IOException tt(String[] strArr) throws IOException {
            throw new IOException("unexpected journal line: " + Arrays.toString(strArr));
        }
    }
}
