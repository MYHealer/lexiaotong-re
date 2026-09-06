package com.jd.ad.sdk.jad_hs;

import android.os.StrictMode;
import com.huawei.openalliance.ad.views.PPSLabelView;
import com.jd.ad.sdk.jad_gr.jad_ly;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.concurrent.Callable;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOUtils;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public final class jad_an implements Closeable {
    public final File jad_an;
    public final File jad_bo;
    public final File jad_cp;
    public final File jad_dq;
    public final int jad_er;
    public long jad_fs;
    public Writer jad_iv;
    public final int jad_jt;
    public int jad_kx;
    public long jad_hu = 0;
    public final LinkedHashMap<String, jad_dq> jad_jw = new LinkedHashMap<>(0, 0.75f, true);
    public long jad_ly = 0;
    public final ThreadPoolExecutor jad_mz = new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(), new jad_bo(null));
    public final Callable<Void> jad_na = new CallableC0553jad_an();

    /* JADX INFO: renamed from: com.jd.ad.sdk.jad_hs.jad_an$jad_an, reason: collision with other inner class name */
    public class CallableC0553jad_an implements Callable<Void> {
        public CallableC0553jad_an() {
        }

        @Override // java.util.concurrent.Callable
        public Void call() {
            synchronized (jad_an.this) {
                jad_an jad_anVar = jad_an.this;
                if (jad_anVar.jad_iv != null) {
                    jad_anVar.jad_jt();
                    if (jad_an.this.jad_cp()) {
                        jad_an.this.jad_fs();
                        jad_an.this.jad_kx = 0;
                    }
                }
            }
            return null;
        }
    }

    public static final class jad_bo implements ThreadFactory {
        public jad_bo() {
        }

        public /* synthetic */ jad_bo(CallableC0553jad_an callableC0553jad_an) {
            this();
        }

        @Override // java.util.concurrent.ThreadFactory
        public synchronized Thread newThread(Runnable runnable) {
            Thread thread;
            thread = new Thread(runnable, "glide-disk-lru-cache-thread");
            thread.setPriority(1);
            return thread;
        }
    }

    public final class jad_cp {
        public final jad_dq jad_an;
        public final boolean[] jad_bo;
        public boolean jad_cp;

        public jad_cp(jad_dq jad_dqVar) {
            this.jad_an = jad_dqVar;
            this.jad_bo = jad_dqVar.jad_er ? null : new boolean[jad_an.this.jad_jt];
        }

        public File jad_an(int i) {
            File fileJad_bo;
            synchronized (jad_an.this) {
                jad_dq jad_dqVar = this.jad_an;
                if (jad_dqVar.jad_fs != this) {
                    throw new IllegalStateException();
                }
                if (!jad_dqVar.jad_er) {
                    this.jad_bo[i] = true;
                }
                fileJad_bo = jad_dqVar.jad_bo(i);
                jad_an.this.jad_an.mkdirs();
            }
            return fileJad_bo;
        }

        public void jad_an() {
            jad_an.jad_an(jad_an.this, this, false);
        }
    }

    public final class jad_dq {
        public final String jad_an;
        public final long[] jad_bo;
        public File[] jad_cp;
        public File[] jad_dq;
        public boolean jad_er;
        public jad_cp jad_fs;
        public long jad_jt;

        public jad_dq(String str) {
            this.jad_an = str;
            this.jad_bo = new long[jad_an.this.jad_jt];
            this.jad_cp = new File[jad_an.this.jad_jt];
            this.jad_dq = new File[jad_an.this.jad_jt];
            StringBuilder sbAppend = new StringBuilder(str).append(FilenameUtils.EXTENSION_SEPARATOR);
            int length = sbAppend.length();
            for (int i = 0; i < jad_an.this.jad_jt; i++) {
                sbAppend.append(i);
                this.jad_cp[i] = new File(jad_an.this.jad_an, sbAppend.toString());
                sbAppend.append(".tmp");
                this.jad_dq[i] = new File(jad_an.this.jad_an, sbAppend.toString());
                sbAppend.setLength(length);
            }
        }

        public File jad_an(int i) {
            return this.jad_cp[i];
        }

        public String jad_an() {
            StringBuilder sb = new StringBuilder();
            for (long j : this.jad_bo) {
                sb.append(' ').append(j);
            }
            return sb.toString();
        }

        public File jad_bo(int i) {
            return this.jad_dq[i];
        }
    }

    public final class jad_er {
        public final File[] jad_an;

        public jad_er(jad_an jad_anVar, String str, long j, File[] fileArr, long[] jArr) {
            this.jad_an = fileArr;
        }

        public File jad_an(int i) {
            return this.jad_an[i];
        }
    }

    public jad_an(File file, int i, int i2, long j) {
        this.jad_an = file;
        this.jad_er = i;
        this.jad_bo = new File(file, "journal");
        this.jad_cp = new File(file, "journal.tmp");
        this.jad_dq = new File(file, "journal.bkp");
        this.jad_jt = i2;
        this.jad_fs = j;
    }

    public static void jad_an(jad_an jad_anVar, jad_cp jad_cpVar, boolean z) {
        synchronized (jad_anVar) {
            jad_dq jad_dqVar = jad_cpVar.jad_an;
            if (jad_dqVar.jad_fs != jad_cpVar) {
                throw new IllegalStateException();
            }
            if (z && !jad_dqVar.jad_er) {
                for (int i = 0; i < jad_anVar.jad_jt; i++) {
                    if (!jad_cpVar.jad_bo[i]) {
                        jad_cpVar.jad_an();
                        throw new IllegalStateException("Newly created entry didn't create value for index " + i);
                    }
                    if (!jad_dqVar.jad_bo(i).exists()) {
                        jad_cpVar.jad_an();
                        return;
                    }
                }
            }
            for (int i2 = 0; i2 < jad_anVar.jad_jt; i2++) {
                File fileJad_bo = jad_dqVar.jad_bo(i2);
                if (!z) {
                    jad_an(fileJad_bo);
                } else if (fileJad_bo.exists()) {
                    File fileJad_an = jad_dqVar.jad_an(i2);
                    fileJad_bo.renameTo(fileJad_an);
                    long j = jad_dqVar.jad_bo[i2];
                    long length = fileJad_an.length();
                    jad_dqVar.jad_bo[i2] = length;
                    jad_anVar.jad_hu = (jad_anVar.jad_hu - j) + length;
                }
            }
            jad_anVar.jad_kx++;
            jad_dqVar.jad_fs = null;
            if (jad_dqVar.jad_er || z) {
                jad_dqVar.jad_er = true;
                jad_anVar.jad_iv.append((CharSequence) "CLEAN");
                jad_anVar.jad_iv.append(' ');
                jad_anVar.jad_iv.append((CharSequence) jad_dqVar.jad_an);
                jad_anVar.jad_iv.append((CharSequence) jad_dqVar.jad_an());
                jad_anVar.jad_iv.append('\n');
                if (z) {
                    long j2 = jad_anVar.jad_ly;
                    jad_anVar.jad_ly = 1 + j2;
                    jad_dqVar.jad_jt = j2;
                }
            } else {
                jad_anVar.jad_jw.remove(jad_dqVar.jad_an);
                jad_anVar.jad_iv.append((CharSequence) "REMOVE");
                jad_anVar.jad_iv.append(' ');
                jad_anVar.jad_iv.append((CharSequence) jad_dqVar.jad_an);
                jad_anVar.jad_iv.append('\n');
            }
            jad_bo(jad_anVar.jad_iv);
            if (jad_anVar.jad_hu > jad_anVar.jad_fs || jad_anVar.jad_cp()) {
                jad_anVar.jad_mz.submit(jad_anVar.jad_na);
            }
        }
    }

    public static void jad_an(File file) throws IOException {
        if (file.exists() && !file.delete()) {
            throw new IOException();
        }
    }

    public static void jad_an(File file, File file2, boolean z) throws IOException {
        if (z) {
            jad_an(file2);
        }
        if (!file.renameTo(file2)) {
            throw new IOException();
        }
    }

    public static void jad_an(Writer writer) {
        StrictMode.ThreadPolicy threadPolicy = StrictMode.getThreadPolicy();
        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder(threadPolicy).permitUnbufferedIo().build());
        try {
            writer.close();
        } finally {
            StrictMode.setThreadPolicy(threadPolicy);
        }
    }

    public static void jad_bo(Writer writer) {
        StrictMode.ThreadPolicy threadPolicy = StrictMode.getThreadPolicy();
        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder(threadPolicy).permitUnbufferedIo().build());
        try {
            writer.flush();
        } finally {
            StrictMode.setThreadPolicy(threadPolicy);
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() {
        if (this.jad_iv == null) {
            return;
        }
        Iterator it = new ArrayList(this.jad_jw.values()).iterator();
        while (it.hasNext()) {
            jad_cp jad_cpVar = ((jad_dq) it.next()).jad_fs;
            if (jad_cpVar != null) {
                jad_cpVar.jad_an();
            }
        }
        jad_jt();
        jad_an(this.jad_iv);
        this.jad_iv = null;
    }

    public synchronized jad_er jad_bo(String str) {
        jad_bo();
        jad_dq jad_dqVar = this.jad_jw.get(str);
        if (jad_dqVar == null) {
            return null;
        }
        if (!jad_dqVar.jad_er) {
            return null;
        }
        for (File file : jad_dqVar.jad_cp) {
            if (!file.exists()) {
                return null;
            }
        }
        this.jad_kx++;
        this.jad_iv.append((CharSequence) "READ");
        this.jad_iv.append(' ');
        this.jad_iv.append((CharSequence) str);
        this.jad_iv.append('\n');
        if (jad_cp()) {
            this.jad_mz.submit(this.jad_na);
        }
        return new jad_er(this, str, jad_dqVar.jad_jt, jad_dqVar.jad_cp, jad_dqVar.jad_bo);
    }

    public final void jad_bo() {
        if (this.jad_iv == null) {
            throw new IllegalStateException("cache is closed");
        }
    }

    public final void jad_cp(String str) throws IOException {
        String strSubstring;
        int iIndexOf = str.indexOf(32);
        if (iIndexOf == -1) {
            throw new IOException("unexpected journal line: " + str);
        }
        int i = iIndexOf + 1;
        int iIndexOf2 = str.indexOf(32, i);
        if (iIndexOf2 == -1) {
            strSubstring = str.substring(i);
            if (iIndexOf == 6 && str.startsWith("REMOVE")) {
                this.jad_jw.remove(strSubstring);
                return;
            }
        } else {
            strSubstring = str.substring(i, iIndexOf2);
        }
        jad_dq jad_dqVar = this.jad_jw.get(strSubstring);
        if (jad_dqVar == null) {
            jad_dqVar = new jad_dq(strSubstring);
            this.jad_jw.put(strSubstring, jad_dqVar);
        }
        if (iIndexOf2 == -1 || iIndexOf != 5 || !str.startsWith("CLEAN")) {
            if (iIndexOf2 == -1 && iIndexOf == 5 && str.startsWith("DIRTY")) {
                jad_dqVar.jad_fs = new jad_cp(jad_dqVar);
                return;
            } else {
                if (iIndexOf2 != -1 || iIndexOf != 4 || !str.startsWith("READ")) {
                    throw new IOException("unexpected journal line: " + str);
                }
                return;
            }
        }
        String[] strArrSplit = str.substring(iIndexOf2 + 1).split(PPSLabelView.Code);
        jad_dqVar.jad_er = true;
        jad_dqVar.jad_fs = null;
        if (strArrSplit.length != jad_an.this.jad_jt) {
            throw new IOException(jad_ly.jad_an("unexpected journal line: ").append(Arrays.toString(strArrSplit)).toString());
        }
        for (int i2 = 0; i2 < strArrSplit.length; i2++) {
            try {
                jad_dqVar.jad_bo[i2] = Long.parseLong(strArrSplit[i2]);
            } catch (NumberFormatException unused) {
                throw new IOException(jad_ly.jad_an("unexpected journal line: ").append(Arrays.toString(strArrSplit)).toString());
            }
        }
    }

    public final boolean jad_cp() {
        int i = this.jad_kx;
        return i >= 2000 && i >= this.jad_jw.size();
    }

    public final void jad_dq() throws IOException {
        jad_an(this.jad_cp);
        Iterator<jad_dq> it = this.jad_jw.values().iterator();
        while (it.hasNext()) {
            jad_dq next = it.next();
            int i = 0;
            if (next.jad_fs == null) {
                while (i < this.jad_jt) {
                    this.jad_hu += next.jad_bo[i];
                    i++;
                }
            } else {
                next.jad_fs = null;
                while (i < this.jad_jt) {
                    jad_an(next.jad_an(i));
                    jad_an(next.jad_bo(i));
                    i++;
                }
                it.remove();
            }
        }
    }

    public final void jad_er() {
        com.jd.ad.sdk.jad_hs.jad_bo jad_boVar = new com.jd.ad.sdk.jad_hs.jad_bo(new FileInputStream(this.jad_bo), 8192, com.jd.ad.sdk.jad_hs.jad_cp.jad_an);
        try {
            String strJad_cp = jad_boVar.jad_cp();
            String strJad_cp2 = jad_boVar.jad_cp();
            String strJad_cp3 = jad_boVar.jad_cp();
            String strJad_cp4 = jad_boVar.jad_cp();
            String strJad_cp5 = jad_boVar.jad_cp();
            if (!"libcore.io.DiskLruCache".equals(strJad_cp) || !"1".equals(strJad_cp2) || !Integer.toString(this.jad_er).equals(strJad_cp3) || !Integer.toString(this.jad_jt).equals(strJad_cp4) || !"".equals(strJad_cp5)) {
                throw new IOException("unexpected journal header: [" + strJad_cp + ", " + strJad_cp2 + ", " + strJad_cp4 + ", " + strJad_cp5 + "]");
            }
            int i = 0;
            while (true) {
                try {
                    jad_cp(jad_boVar.jad_cp());
                    i++;
                } catch (EOFException unused) {
                    this.jad_kx = i - this.jad_jw.size();
                    if (jad_boVar.jad_er == -1) {
                        jad_fs();
                    } else {
                        this.jad_iv = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.jad_bo, true), com.jd.ad.sdk.jad_hs.jad_cp.jad_an));
                    }
                    try {
                        jad_boVar.close();
                        return;
                    } catch (RuntimeException e) {
                        throw e;
                    } catch (Exception unused2) {
                        return;
                    }
                }
            }
        } catch (Throwable th) {
            try {
                jad_boVar.close();
            } catch (RuntimeException e2) {
                throw e2;
            } catch (Exception unused3) {
            }
            throw th;
        }
    }

    public final synchronized void jad_fs() {
        Writer writer = this.jad_iv;
        if (writer != null) {
            jad_an(writer);
        }
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.jad_cp), com.jd.ad.sdk.jad_hs.jad_cp.jad_an));
        try {
            bufferedWriter.write("libcore.io.DiskLruCache");
            bufferedWriter.write(IOUtils.LINE_SEPARATOR_UNIX);
            bufferedWriter.write("1");
            bufferedWriter.write(IOUtils.LINE_SEPARATOR_UNIX);
            bufferedWriter.write(Integer.toString(this.jad_er));
            bufferedWriter.write(IOUtils.LINE_SEPARATOR_UNIX);
            bufferedWriter.write(Integer.toString(this.jad_jt));
            bufferedWriter.write(IOUtils.LINE_SEPARATOR_UNIX);
            bufferedWriter.write(IOUtils.LINE_SEPARATOR_UNIX);
            for (jad_dq jad_dqVar : this.jad_jw.values()) {
                bufferedWriter.write((jad_dqVar.jad_fs != null ? new StringBuilder().append("DIRTY ").append(jad_dqVar.jad_an).append('\n') : new StringBuilder().append("CLEAN ").append(jad_dqVar.jad_an).append(jad_dqVar.jad_an()).append('\n')).toString());
            }
            jad_an(bufferedWriter);
            if (this.jad_bo.exists()) {
                jad_an(this.jad_bo, this.jad_dq, true);
            }
            jad_an(this.jad_cp, this.jad_bo, false);
            this.jad_dq.delete();
            this.jad_iv = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.jad_bo, true), com.jd.ad.sdk.jad_hs.jad_cp.jad_an));
        } catch (Throwable th) {
            jad_an(bufferedWriter);
            throw th;
        }
    }

    public final void jad_jt() {
        while (this.jad_hu > this.jad_fs) {
            String key = this.jad_jw.entrySet().iterator().next().getKey();
            synchronized (this) {
                jad_bo();
                jad_dq jad_dqVar = this.jad_jw.get(key);
                if (jad_dqVar != null && jad_dqVar.jad_fs == null) {
                    for (int i = 0; i < this.jad_jt; i++) {
                        File fileJad_an = jad_dqVar.jad_an(i);
                        if (fileJad_an.exists() && !fileJad_an.delete()) {
                            throw new IOException("failed to delete " + fileJad_an);
                        }
                        long j = this.jad_hu;
                        long[] jArr = jad_dqVar.jad_bo;
                        this.jad_hu = j - jArr[i];
                        jArr[i] = 0;
                    }
                    this.jad_kx++;
                    this.jad_iv.append((CharSequence) "REMOVE");
                    this.jad_iv.append(' ');
                    this.jad_iv.append((CharSequence) key);
                    this.jad_iv.append('\n');
                    this.jad_jw.remove(key);
                    if (jad_cp()) {
                        this.jad_mz.submit(this.jad_na);
                    }
                }
            }
        }
    }

    public jad_cp jad_an(String str) {
        synchronized (this) {
            jad_bo();
            jad_dq jad_dqVar = this.jad_jw.get(str);
            if (jad_dqVar == null) {
                jad_dqVar = new jad_dq(str);
                this.jad_jw.put(str, jad_dqVar);
            } else if (jad_dqVar.jad_fs != null) {
                return null;
            }
            jad_cp jad_cpVar = new jad_cp(jad_dqVar);
            jad_dqVar.jad_fs = jad_cpVar;
            this.jad_iv.append((CharSequence) "DIRTY");
            this.jad_iv.append(' ');
            this.jad_iv.append((CharSequence) str);
            this.jad_iv.append('\n');
            jad_bo(this.jad_iv);
            return jad_cpVar;
        }
    }
}
