package com.ubix.ssp.ad.e.v;

import com.ubix.ssp.ad.e.a0.u;
import java.io.File;
import java.io.InputStream;
import java.io.RandomAccessFile;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
class d implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f8878a;
    private File b;
    private int c;
    private boolean d;
    private b e;

    public d(String str, File file, b bVar) {
        this.f8878a = str;
        this.b = file;
        this.e = bVar;
    }

    public int a() {
        return this.c;
    }

    /* JADX WARN: Code duplicated, block: B:101:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:59:0x00e6 A[Catch: all -> 0x0109, TRY_LEAVE, TryCatch #5 {all -> 0x0109, blocks: (B:7:0x0021, B:8:0x0028, B:10:0x0030, B:12:0x0034, B:18:0x0054, B:19:0x0058, B:21:0x007b, B:23:0x0082, B:24:0x008c, B:26:0x0094, B:27:0x0099, B:29:0x009f, B:48:0x00c9, B:57:0x00e0, B:59:0x00e6, B:56:0x00dd, B:49:0x00cc, B:51:0x00d0, B:53:0x00d6), top: B:86:0x000a, inners: #8 }] */
    /* JADX WARN: Code duplicated, block: B:61:0x00f1 A[Catch: Exception -> 0x00f5, TRY_ENTER, TryCatch #6 {Exception -> 0x00f5, blocks: (B:30:0x00a8, B:61:0x00f1, B:65:0x00f9, B:67:0x00fe), top: B:87:0x000a }] */
    /* JADX WARN: Code duplicated, block: B:65:0x00f9 A[Catch: Exception -> 0x00f5, TryCatch #6 {Exception -> 0x00f5, blocks: (B:30:0x00a8, B:61:0x00f1, B:65:0x00f9, B:67:0x00fe), top: B:87:0x000a }] */
    /* JADX WARN: Code duplicated, block: B:67:0x00fe A[Catch: Exception -> 0x00f5, TRY_LEAVE, TryCatch #6 {Exception -> 0x00f5, blocks: (B:30:0x00a8, B:61:0x00f1, B:65:0x00f9, B:67:0x00fe), top: B:87:0x000a }] */
    /* JADX WARN: Code duplicated, block: B:77:0x0113 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:78:0x0115 A[Catch: Exception -> 0x0111, TryCatch #11 {Exception -> 0x0111, blocks: (B:74:0x010d, B:78:0x0115, B:80:0x011a), top: B:91:0x010d }] */
    /* JADX WARN: Code duplicated, block: B:80:0x011a A[Catch: Exception -> 0x0111, TRY_LEAVE, TryCatch #11 {Exception -> 0x0111, blocks: (B:74:0x010d, B:78:0x0115, B:80:0x011a), top: B:91:0x010d }] */
    /* JADX WARN: Code duplicated, block: B:91:0x010d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v10, types: [java.net.HttpURLConnection] */
    /* JADX WARN: Type inference failed for: r3v12, types: [java.net.HttpURLConnection] */
    /* JADX WARN: Type inference failed for: r3v13 */
    /* JADX WARN: Type inference failed for: r3v14 */
    /* JADX WARN: Type inference failed for: r3v15 */
    /* JADX WARN: Type inference failed for: r3v3 */
    /* JADX WARN: Type inference failed for: r3v4 */
    /* JADX WARN: Type inference failed for: r3v5 */
    /* JADX WARN: Type inference failed for: r3v6 */
    /* JADX WARN: Type inference failed for: r3v7, types: [java.net.HttpURLConnection] */
    /* JADX WARN: Type inference failed for: r3v9 */
    @Override // java.lang.Runnable
    public void run() throws Throwable {
        Exception e;
        InputStream inputStream;
        RandomAccessFile randomAccessFile;
        ?? r3;
        b bVar;
        File file;
        ?? A = 1;
        RandomAccessFile randomAccessFile2 = null;
        try {
            try {
                try {
                    this.c = 1;
                    A = com.ubix.ssp.ad.e.x.c.a(this.f8878a);
                    try {
                        randomAccessFile = new RandomAccessFile(this.b, "rwd");
                        try {
                            inputStream = A.getInputStream();
                            try {
                                byte[] bArr = new byte[8192];
                                randomAccessFile.seek(0L);
                                while (true) {
                                    int i = inputStream.read(bArr);
                                    if (i == -1) {
                                        File file2 = new File(this.b.getPath().substring(0, this.b.getPath().lastIndexOf(".")));
                                        if (this.b.renameTo(file2)) {
                                            this.c = 2;
                                            b bVar2 = this.e;
                                            if (bVar2 != null) {
                                                bVar2.a(this.f8878a, file2.getPath());
                                            }
                                        } else {
                                            if (this.b.exists()) {
                                                this.b.delete();
                                            }
                                            this.c = 3;
                                            b bVar3 = this.e;
                                            if (bVar3 != null) {
                                                bVar3.a(this.f8878a, com.ubix.ssp.ad.e.a0.a0.a.h(5, "资源下载错误"), null);
                                            }
                                        }
                                        randomAccessFile.close();
                                        inputStream.close();
                                        A.disconnect();
                                        return;
                                    }
                                    if (this.d) {
                                        u.b("ResourceDownloadManager", "下载过程 设置了 暂停");
                                        A.disconnect();
                                        randomAccessFile.close();
                                        inputStream.close();
                                        try {
                                            randomAccessFile.close();
                                            inputStream.close();
                                            A.disconnect();
                                            return;
                                        } catch (Exception e2) {
                                            u.d("ResourceDownloadManager", "关闭文件过程中 发生异常");
                                            e2.printStackTrace();
                                            return;
                                        }
                                    }
                                    randomAccessFile.write(bArr, 0, i);
                                }
                            } catch (Exception e3) {
                                e = e3;
                                e.printStackTrace();
                                try {
                                    file = this.b;
                                    if (file != null && file.exists()) {
                                        this.b.delete();
                                    }
                                } catch (Throwable th) {
                                    th.printStackTrace();
                                }
                                this.c = 3;
                                bVar = this.e;
                                if (bVar != null) {
                                    bVar.a(this.f8878a, com.ubix.ssp.ad.e.a0.a0.a.h(5, "资源下载错误"), null);
                                }
                                if (randomAccessFile != null) {
                                    randomAccessFile.close();
                                }
                                if (inputStream != null) {
                                    inputStream.close();
                                }
                                if (A != 0) {
                                    A.disconnect();
                                }
                            }
                        } catch (Exception e4) {
                            e = e4;
                            inputStream = null;
                        } catch (Throwable th2) {
                            th = th2;
                            inputStream = null;
                            randomAccessFile2 = randomAccessFile;
                            r3 = A;
                            if (randomAccessFile2 != null) {
                                try {
                                    randomAccessFile2.close();
                                    if (inputStream != null) {
                                        inputStream.close();
                                    }
                                    if (r3 != 0) {
                                        r3.disconnect();
                                    }
                                } catch (Exception e5) {
                                    u.d("ResourceDownloadManager", "关闭文件过程中 发生异常");
                                    e5.printStackTrace();
                                    throw th;
                                }
                            } else {
                                if (inputStream != null) {
                                    inputStream.close();
                                }
                                if (r3 != 0) {
                                    r3.disconnect();
                                }
                            }
                            throw th;
                        }
                    } catch (Exception e6) {
                        e = e6;
                        A = A;
                        randomAccessFile = null;
                        inputStream = null;
                        e.printStackTrace();
                        file = this.b;
                        if (file != null) {
                            this.b.delete();
                        }
                        this.c = 3;
                        bVar = this.e;
                        if (bVar != null) {
                            bVar.a(this.f8878a, com.ubix.ssp.ad.e.a0.a0.a.h(5, "资源下载错误"), null);
                        }
                        if (randomAccessFile != null) {
                            randomAccessFile.close();
                        }
                        if (inputStream != null) {
                            inputStream.close();
                        }
                        if (A != 0) {
                            A.disconnect();
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        inputStream = null;
                        r3 = A;
                        if (randomAccessFile2 != null) {
                            randomAccessFile2.close();
                            if (inputStream != null) {
                                inputStream.close();
                            }
                            if (r3 != 0) {
                                r3.disconnect();
                            }
                        } else {
                            if (inputStream != null) {
                                inputStream.close();
                            }
                            if (r3 != 0) {
                                r3.disconnect();
                            }
                        }
                        throw th;
                    }
                } catch (Throwable th4) {
                    th = th4;
                }
            } catch (Exception e7) {
                e = e7;
                A = 0;
            } catch (Throwable th5) {
                th = th5;
                A = 0;
            }
        } catch (Exception e8) {
            u.d("ResourceDownloadManager", "关闭文件过程中 发生异常");
            e8.printStackTrace();
        }
    }
}
