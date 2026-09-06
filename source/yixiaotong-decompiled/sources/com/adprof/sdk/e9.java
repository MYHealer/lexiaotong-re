package com.adprof.sdk;

import android.text.TextUtils;
import com.loopj.android.http.AsyncHttpClient;
import cz.msebera.android.httpclient.protocol.HTTP;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.zip.GZIPInputStream;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class e9 extends li {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f1145a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public d9 f237a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public q8 f238a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public File f239a;
    public File b;

    public e9(q8 q8Var, d9 d9Var) {
        super(0, q8Var.f672a, null);
        this.f1145a = 0L;
        this.f237a = null;
        File file = new File(q8Var.f674b);
        this.f239a = file;
        if (file.getParentFile() != null && !this.f239a.getParentFile().exists()) {
            this.f239a.getParentFile().mkdirs();
        }
        if (this.f239a.exists()) {
            this.f239a.delete();
        }
        this.f238a = q8Var;
        File file2 = new File(q8Var.f674b + ".tmp");
        this.b = file2;
        if (!q8Var.f673a) {
            file2.delete();
        }
        this.f237a = d9Var;
        a(new q7(10000, 2, 0.0f));
        int i = lp.f1294a;
    }

    @Override // com.adprof.sdk.li
    /* JADX INFO: renamed from: a */
    public ji mo673a() {
        return ji.LOW;
    }

    @Override // com.adprof.sdk.li
    public void a(jp jpVar) {
        this.f238a.f1381a = 0;
        if (this.f239a.exists()) {
            this.f239a.delete();
        }
        if (this.b.exists()) {
            this.b.delete();
        }
        q8 q8Var = this.f238a;
        q8Var.f670a = jpVar;
        this.f237a.a(q8Var);
    }

    @Override // com.adprof.sdk.li
    public void a(Object obj) {
        this.f238a.f1381a = 1;
        this.f237a.b((q8) obj);
    }

    @Override // com.adprof.sdk.li
    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public Map mo610a() {
        HashMap map = new HashMap();
        this.f1145a = this.b.length();
        map.put("Connection", "Keep-Alive");
        map.put("Accept-Encoding", AsyncHttpClient.ENCODING_GZIP);
        map.put("Range", "bytes=" + this.f1145a + com.huawei.openalliance.ad.constant.x.A);
        int i = kp.f1273a;
        return map;
    }

    /* JADX WARN: Code duplicated, block: B:40:0x010f A[Catch: all -> 0x016d, TRY_ENTER, TryCatch #3 {all -> 0x016d, blocks: (B:40:0x010f, B:42:0x0119, B:43:0x011f, B:45:0x0125, B:51:0x015c, B:50:0x0140, B:52:0x015f, B:41:0x0114, B:47:0x0131), top: B:78:0x010d, inners: #4 }] */
    /* JADX WARN: Code duplicated, block: B:41:0x0114 A[Catch: all -> 0x016d, TryCatch #3 {all -> 0x016d, blocks: (B:40:0x010f, B:42:0x0119, B:43:0x011f, B:45:0x0125, B:51:0x015c, B:50:0x0140, B:52:0x015f, B:41:0x0114, B:47:0x0131), top: B:78:0x010d, inners: #4 }] */
    /* JADX WARN: Code duplicated, block: B:45:0x0125 A[Catch: all -> 0x016d, TRY_LEAVE, TryCatch #3 {all -> 0x016d, blocks: (B:40:0x010f, B:42:0x0119, B:43:0x011f, B:45:0x0125, B:51:0x015c, B:50:0x0140, B:52:0x015f, B:41:0x0114, B:47:0x0131), top: B:78:0x010d, inners: #4 }] */
    /* JADX WARN: Code duplicated, block: B:80:0x0131 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:84:0x015f A[EDGE_INSN: B:84:0x015f->B:52:0x015f BREAK  A[LOOP:0: B:43:0x011f->B:51:0x015c], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:86:0x015c A[SYNTHETIC] */
    public byte[] a(ia iaVar) throws IOException {
        long length;
        InputStream inputStream;
        RandomAccessFile randomAccessFile;
        long j;
        byte[] bArr;
        int i;
        d9 d9Var;
        String str;
        TreeMap treeMap = (TreeMap) c9.a(Collections.unmodifiableList(iaVar.f378a));
        boolean z = TextUtils.equals((String) treeMap.get("Accept-Ranges"), "bytes") || ((str = (String) treeMap.get("Content-Range")) != null && str.startsWith("bytes"));
        long j2 = iaVar.b;
        try {
            try {
                try {
                    if (!treeMap.containsKey("Transfer-Encoding") || !((String) treeMap.get("Transfer-Encoding")).equalsIgnoreCase(HTTP.CHUNK_CODING)) {
                        if (j2 < 0 || !treeMap.containsKey("Content-Length")) {
                            length = this.b.length();
                        } else {
                            if (j2 == 0 && this.f239a.exists() && this.f239a.length() == j2) {
                                this.f239a.renameTo(this.b);
                                iaVar.f377a.close();
                                return new byte[0];
                            }
                            if (z) {
                                length = this.b.length();
                                j2 += length;
                                String str2 = (String) treeMap.get("Content-Range");
                                int i2 = lp.f1294a;
                                if (!TextUtils.isEmpty(str2)) {
                                    String str3 = "bytes " + length + com.huawei.openalliance.ad.constant.x.A + (j2 - 1);
                                    if (TextUtils.indexOf(str2, str3) == -1) {
                                        iaVar.f377a.close();
                                        this.b.delete();
                                        throw new IllegalStateException("The Content-Range Header is invalid Assume[" + str3 + "] vs Real[" + str2 + "], has remove the temporary file [" + this.b + "].");
                                    }
                                }
                            }
                        }
                        inputStream = null;
                        randomAccessFile = new RandomAccessFile(this.b, "rw");
                        if (z) {
                            randomAccessFile.seek(length);
                            j = length;
                        } else {
                            j = 0;
                            randomAccessFile.setLength(0L);
                        }
                        inputStream = iaVar.f377a;
                        bArr = new byte[8192];
                        while (true) {
                            i = inputStream.read(bArr);
                            if (i != -1) {
                                break;
                            }
                            m676a();
                            randomAccessFile.write(bArr, 0, i);
                            j += (long) i;
                            d9Var = this.f237a;
                            if (d9Var != null) {
                                try {
                                    d9Var.a(this.f238a, j2, j);
                                } catch (Throwable th) {
                                    lp.m679a("callback downloadProgress  error " + th.getMessage(), new Object[0]);
                                }
                            }
                            int i3 = lp.f1294a;
                            th = th;
                            try {
                                throw th;
                            } catch (Throwable th2) {
                                if (inputStream != null) {
                                    try {
                                        inputStream.close();
                                    } catch (Throwable unused) {
                                        int i4 = lp.f1294a;
                                    }
                                }
                                if (randomAccessFile == null) {
                                    throw th2;
                                }
                                randomAccessFile.close();
                                throw th2;
                            }
                        }
                        int i5 = lp.f1294a;
                        inputStream.close();
                        randomAccessFile.close();
                        return new byte[0];
                    }
                    int i6 = lp.f1294a;
                    inputStream.close();
                } catch (Throwable unused2) {
                    int i7 = lp.f1294a;
                }
                if (z) {
                    randomAccessFile.seek(length);
                    j = length;
                } else {
                    j = 0;
                    randomAccessFile.setLength(0L);
                }
                inputStream = iaVar.f377a;
                bArr = new byte[8192];
                while (true) {
                    i = inputStream.read(bArr);
                    if (i != -1) {
                        break;
                        break;
                    }
                    m676a();
                    randomAccessFile.write(bArr, 0, i);
                    j += (long) i;
                    d9Var = this.f237a;
                    if (d9Var != null) {
                        d9Var.a(this.f238a, j2, j);
                    }
                    int i8 = lp.f1294a;
                    th = th;
                    throw th;
                }
                int i9 = lp.f1294a;
                randomAccessFile.close();
                return new byte[0];
            } catch (Throwable th3) {
                th = th3;
            }
            randomAccessFile = new RandomAccessFile(this.b, "rw");
        } catch (Throwable th4) {
            th = th4;
            randomAccessFile = null;
        }
        length = 0;
        inputStream = null;
    }

    /* JADX WARN: Code duplicated, block: B:100:0x0121 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:115:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:98:0x0131 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // com.adprof.sdk.li
    public ri a(fg fgVar) throws Throwable {
        long length;
        FileOutputStream fileOutputStream;
        this.f238a.b = fgVar.f291a;
        m676a();
        TreeMap treeMap = (TreeMap) c9.a(fgVar.f292a);
        if (treeMap.containsKey("Transfer-Encoding") && ((String) treeMap.get("Transfer-Encoding")).equalsIgnoreCase(HTTP.CHUNK_CODING)) {
            length = this.b.length();
        } else {
            length = treeMap.containsKey("content-length") ? Long.parseLong((String) treeMap.get("content-length")) + this.f1145a : 0L;
        }
        this.f238a.f669a = length;
        if (this.b.canRead() && this.b.length() > 0 && (this.b.length() == length || length == 0)) {
            if (!TextUtils.equals((String) treeMap.get("Content-Encoding"), AsyncHttpClient.ENCODING_GZIP)) {
                if (this.b.renameTo(this.f239a)) {
                    return new ri(this.f238a);
                }
                return new ri(new jp("Can't rename the download temporary file!"));
            }
            GZIPInputStream gZIPInputStream = null;
            boolean z = false;
            try {
                GZIPInputStream gZIPInputStream2 = new GZIPInputStream(new FileInputStream(this.b));
                try {
                    fileOutputStream = new FileOutputStream(this.f239a);
                    try {
                        byte[] bArr = new byte[4096];
                        while (true) {
                            int i = gZIPInputStream2.read(bArr, 0, 4096);
                            if (i != -1) {
                                fileOutputStream.write(bArr, 0, i);
                            } else {
                                try {
                                    break;
                                } catch (IOException e) {
                                    lp.m679a(e.getMessage(), new Object[0]);
                                }
                            }
                        }
                        gZIPInputStream2.close();
                        try {
                            fileOutputStream.close();
                        } catch (IOException e2) {
                            lp.m679a(e2.getMessage(), new Object[0]);
                        }
                        z = true;
                    } catch (IOException e3) {
                        e = e3;
                        gZIPInputStream = gZIPInputStream2;
                        try {
                            lp.m679a(e.getMessage(), new Object[0]);
                            if (gZIPInputStream != null) {
                                try {
                                    gZIPInputStream.close();
                                } catch (IOException e4) {
                                    lp.m679a(e4.getMessage(), new Object[0]);
                                }
                            }
                            if (fileOutputStream != null) {
                                try {
                                    fileOutputStream.close();
                                } catch (IOException e5) {
                                    lp.m679a(e5.getMessage(), new Object[0]);
                                }
                            }
                        } catch (Throwable th) {
                            th = th;
                            if (gZIPInputStream != null) {
                                try {
                                    gZIPInputStream.close();
                                } catch (IOException e6) {
                                    lp.m679a(e6.getMessage(), new Object[0]);
                                }
                            }
                            if (fileOutputStream != null) {
                                throw th;
                            }
                            try {
                                fileOutputStream.close();
                                throw th;
                            } catch (IOException e7) {
                                lp.m679a(e7.getMessage(), new Object[0]);
                                throw th;
                            }
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        gZIPInputStream = gZIPInputStream2;
                        if (gZIPInputStream != null) {
                            gZIPInputStream.close();
                        }
                        if (fileOutputStream != null) {
                            throw th;
                        }
                        fileOutputStream.close();
                        throw th;
                    }
                } catch (IOException e8) {
                    fileOutputStream = null;
                    gZIPInputStream = gZIPInputStream2;
                    e = e8;
                } catch (Throwable th3) {
                    fileOutputStream = null;
                    gZIPInputStream = gZIPInputStream2;
                    th = th3;
                }
            } catch (IOException e9) {
                e = e9;
                fileOutputStream = null;
            } catch (Throwable th4) {
                th = th4;
                fileOutputStream = null;
            }
            this.b.delete();
            if (z) {
                return new ri(this.f238a);
            }
            return new ri(new jp("error gzip unzip the download temporary file!"));
        }
        if (this.f239a.canRead() && this.f239a.length() == length) {
            return new ri(this.f238a);
        }
        return new ri(new jp("Download temporary file was invalid!" + this.b.getAbsolutePath()));
    }
}
