package com.ubix.ssp.ad.e.s.i;

import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import com.huawei.openalliance.ad.constant.x;
import com.stub.StubApp;
import com.ubix.ssp.ad.e.a0.m;
import com.ubix.ssp.ad.e.a0.u;
import com.ubix.ssp.ad.e.x.c;
import com.yfanads.android.adx.thirdpart.filedownload.model.FileDownloadModel;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f8859a;
    private com.ubix.ssp.ad.e.s.g.a b;
    private com.ubix.ssp.ad.e.s.g.b c;
    private com.ubix.ssp.ad.e.s.h.a d;
    private boolean e;
    private boolean f;

    public b(Context context, com.ubix.ssp.ad.e.s.g.a aVar, com.ubix.ssp.ad.e.s.h.a aVar2) {
        this(context, aVar, aVar2, true);
    }

    public b(Context context, com.ubix.ssp.ad.e.s.g.a aVar, com.ubix.ssp.ad.e.s.h.a aVar2, boolean z) {
        long jG;
        long jA;
        this.f8859a = context;
        this.b = aVar;
        this.d = aVar2;
        this.c = aVar.b();
        this.f = z;
        u.b("DownloadTask", "构造函数 -> 初始化 mFileInfo=" + this.c);
        com.ubix.ssp.ad.e.s.g.b bVarB = aVar2.b(aVar.f() + "");
        long j = 0;
        if (bVarB != null) {
            jA = bVarB.a();
            jG = bVarB.g();
            if (jA == 0) {
                if (aVar.a().exists()) {
                    j = jA;
                    aVar.a().delete();
                    jA = j;
                }
            } else if (!aVar.a().exists()) {
                Log.i("DownloadTask", "数据库记录表明我们下载过该文件, 但是现在该文件不存在,所以从头开始");
                aVar2.a(aVar.f() + "");
                jA = 0;
            }
            j = jG;
        } else if (aVar.a().exists()) {
            jG = 0;
            aVar.a().delete();
            jA = j;
            j = jG;
        } else {
            jA = 0;
        }
        this.c.b(j);
        this.c.a(jA);
        u.b("DownloadTask", "构造函数() -> 初始化完毕  mFileInfo=" + this.c);
    }

    private String a(String str) {
        try {
            Matcher matcher = Pattern.compile("filename=\"(.*?)\"").matcher(str);
            return matcher.find() ? matcher.group(1) : "";
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    /* JADX WARN: Code duplicated, block: B:104:0x02d8 A[Catch: Exception -> 0x02d4, TryCatch #7 {Exception -> 0x02d4, blocks: (B:100:0x02d0, B:104:0x02d8, B:106:0x02dd), top: B:116:0x02d0 }] */
    /* JADX WARN: Code duplicated, block: B:106:0x02dd A[Catch: Exception -> 0x02d4, TRY_LEAVE, TryCatch #7 {Exception -> 0x02d4, blocks: (B:100:0x02d0, B:104:0x02d8, B:106:0x02dd), top: B:116:0x02d0 }] */
    /* JADX WARN: Code duplicated, block: B:116:0x02d0 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:137:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:140:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:86:0x02ae A[Catch: Exception -> 0x02b2, TRY_ENTER, TryCatch #9 {Exception -> 0x02b2, blocks: (B:86:0x02ae, B:90:0x02b6, B:92:0x02bb, B:53:0x021f), top: B:118:0x006d }] */
    /* JADX WARN: Code duplicated, block: B:90:0x02b6 A[Catch: Exception -> 0x02b2, TryCatch #9 {Exception -> 0x02b2, blocks: (B:86:0x02ae, B:90:0x02b6, B:92:0x02bb, B:53:0x021f), top: B:118:0x006d }] */
    /* JADX WARN: Code duplicated, block: B:92:0x02bb A[Catch: Exception -> 0x02b2, TRY_LEAVE, TryCatch #9 {Exception -> 0x02b2, blocks: (B:86:0x02ae, B:90:0x02b6, B:92:0x02bb, B:53:0x021f), top: B:118:0x006d }] */
    private void a() throws Throwable {
        HttpURLConnection httpURLConnectionA;
        Throwable th;
        RandomAccessFile randomAccessFile;
        InputStream inputStream;
        InputStream inputStream2;
        InputStream inputStream3;
        HttpURLConnection httpURLConnection;
        Throwable th2;
        InputStream inputStream4;
        String strD;
        String str = "";
        String str2 = "ACTION_FAIL";
        String str3 = "资源下载错误";
        this.c.b(43);
        u.b("DownloadTask", "准备开始下载" + b().f() + " ; " + b().d());
        Intent intent = new Intent();
        intent.setAction("ACTION_PREPARE");
        intent.putExtra("service_intent_unique_id", b().f());
        intent.putExtra("service_intent_notify_id", b().d());
        a(intent);
        try {
            try {
                httpURLConnectionA = c.a(this.b.g());
                try {
                    URL url = httpURLConnectionA.getURL();
                    long contentLength = httpURLConnectionA.getContentLength();
                    httpURLConnectionA.disconnect();
                    if (contentLength <= 0) {
                        if (this.b.a().exists()) {
                            this.b.a().delete();
                        }
                        u.b("DownloadTask", "文件大小 = " + contentLength + "\t, 终止下载过程");
                        this.c.b(47);
                        intent.putExtra("error", com.ubix.ssp.ad.e.a0.a0.a.h(5, "资源下载错误"));
                        intent.setAction("ACTION_FAIL");
                        this.d.a(this.b.f() + "");
                        a(intent);
                        try {
                            httpURLConnectionA.disconnect();
                            return;
                        } catch (Exception e) {
                            u.d("DownloadTask", "关闭文件过程中 发生异常");
                            e.printStackTrace();
                            return;
                        }
                    }
                    u.b("DownloadTask", "文件大小 = " + contentLength);
                    this.c.b(contentLength);
                    RandomAccessFile randomAccessFile2 = new RandomAccessFile(this.b.a(), "rwd");
                    try {
                        httpURLConnection = (HttpURLConnection) url.openConnection();
                        try {
                            httpURLConnection.setRequestProperty("Range", "bytes=" + this.c.a() + x.A);
                            inputStream3 = httpURLConnection.getInputStream();
                            try {
                                try {
                                    byte[] bArr = new byte[8192];
                                    randomAccessFile2.seek(this.c.a());
                                    String headerField = httpURLConnection.getHeaderField("content-disposition");
                                    if (headerField != null) {
                                        strD = a(headerField);
                                        if (!TextUtils.isEmpty(strD)) {
                                            intent.setAction("ACTION_NEW_NAME");
                                            intent.putExtra(FileDownloadModel.FILENAME, strD);
                                            a(intent);
                                        }
                                    } else {
                                        strD = this.c.d();
                                        if (!TextUtils.isEmpty(strD)) {
                                            intent.setAction("ACTION_NEW_NAME");
                                            intent.putExtra(FileDownloadModel.FILENAME, strD);
                                            a(intent);
                                        }
                                    }
                                    long jUptimeMillis = SystemClock.uptimeMillis();
                                    while (true) {
                                        int i = inputStream3.read(bArr);
                                        try {
                                            if (i == -1) {
                                                str = str;
                                                str2 = str2;
                                                str3 = str3;
                                                this.c.b(46);
                                                intent.setAction("ACTION_COMPLETE");
                                                this.d.a(this.c);
                                                a(intent);
                                                randomAccessFile2.close();
                                                inputStream3.close();
                                                httpURLConnection.disconnect();
                                                return;
                                            }
                                            str = str;
                                            if (this.e) {
                                                u.b("DownloadTask", "下载过程 设置了 暂停");
                                                this.c.b(45);
                                                this.e = false;
                                                this.d.a(this.c);
                                                intent.setAction("ACTION_PAUSE");
                                                a(intent);
                                                httpURLConnection.disconnect();
                                                randomAccessFile2.close();
                                                inputStream3.close();
                                                try {
                                                    randomAccessFile2.close();
                                                    inputStream3.close();
                                                    httpURLConnection.disconnect();
                                                    return;
                                                } catch (Exception e2) {
                                                    u.d("DownloadTask", "关闭文件过程中 发生异常");
                                                    e2.printStackTrace();
                                                    return;
                                                }
                                            }
                                            try {
                                                randomAccessFile2.write(bArr, 0, i);
                                                com.ubix.ssp.ad.e.s.g.b bVar = this.c;
                                                str2 = str2;
                                                str3 = str3;
                                                try {
                                                    bVar.a(bVar.a() + ((long) i));
                                                    this.c.b(44);
                                                    intent.setAction("ACTION_LOADING");
                                                    if (SystemClock.uptimeMillis() - jUptimeMillis >= 1000) {
                                                        jUptimeMillis = SystemClock.uptimeMillis();
                                                        this.d.a(this.c);
                                                        a(intent);
                                                    }
                                                    str2 = str2;
                                                    str = str;
                                                    str3 = str3;
                                                } catch (Exception e3) {
                                                    e = e3;
                                                }
                                            } catch (Exception e4) {
                                                e = e4;
                                            }
                                            e = e4;
                                            str2 = str2;
                                            str3 = str3;
                                            httpURLConnectionA = httpURLConnection;
                                            inputStream4 = inputStream3;
                                            inputStream2 = inputStream4;
                                            randomAccessFile = randomAccessFile2;
                                            e.printStackTrace();
                                            this.c.b(47);
                                            intent.putExtra("error", com.ubix.ssp.ad.e.a0.a0.a.h(5, str3));
                                            intent.setAction(str2);
                                            this.d.a(this.b.f() + str);
                                            a(intent);
                                            if (randomAccessFile != null) {
                                                randomAccessFile.close();
                                            }
                                            if (inputStream2 != null) {
                                                inputStream2.close();
                                            }
                                            if (httpURLConnectionA != null) {
                                                httpURLConnectionA.disconnect();
                                                return;
                                            }
                                            return;
                                            e.printStackTrace();
                                            this.c.b(47);
                                            intent.putExtra("error", com.ubix.ssp.ad.e.a0.a0.a.h(5, str3));
                                            intent.setAction(str2);
                                            this.d.a(this.b.f() + str);
                                            a(intent);
                                            if (randomAccessFile != null) {
                                                randomAccessFile.close();
                                            }
                                            if (inputStream2 != null) {
                                                inputStream2.close();
                                            }
                                            if (httpURLConnectionA != null) {
                                                httpURLConnectionA.disconnect();
                                                return;
                                            }
                                            return;
                                        } catch (Throwable th3) {
                                            th2 = th3;
                                            httpURLConnection = httpURLConnectionA;
                                            inputStream3 = inputStream2;
                                            inputStream = inputStream3;
                                            httpURLConnectionA = httpURLConnection;
                                            th = th2;
                                            if (randomAccessFile != null) {
                                                try {
                                                    randomAccessFile.close();
                                                } catch (Exception e5) {
                                                    u.d("DownloadTask", "关闭文件过程中 发生异常");
                                                    e5.printStackTrace();
                                                    throw th;
                                                }
                                            }
                                            if (inputStream != null) {
                                                inputStream.close();
                                            }
                                            if (httpURLConnectionA == null) {
                                                throw th;
                                            }
                                            httpURLConnectionA.disconnect();
                                            throw th;
                                        }
                                        e = e3;
                                        httpURLConnectionA = httpURLConnection;
                                        inputStream4 = inputStream3;
                                        inputStream2 = inputStream4;
                                        randomAccessFile = randomAccessFile2;
                                    }
                                } catch (Exception e6) {
                                    e = e6;
                                    str = str;
                                }
                            } catch (Throwable th4) {
                                th2 = th4;
                                randomAccessFile = randomAccessFile2;
                                inputStream = inputStream3;
                                httpURLConnectionA = httpURLConnection;
                                th = th2;
                                if (randomAccessFile != null) {
                                    randomAccessFile.close();
                                }
                                if (inputStream != null) {
                                    inputStream.close();
                                }
                                if (httpURLConnectionA == null) {
                                    throw th;
                                }
                                httpURLConnectionA.disconnect();
                                throw th;
                            }
                        } catch (Exception e7) {
                            e = e7;
                            httpURLConnectionA = httpURLConnection;
                            inputStream4 = null;
                        } catch (Throwable th5) {
                            th2 = th5;
                            inputStream3 = null;
                        }
                    } catch (Exception e8) {
                        e = e8;
                    } catch (Throwable th6) {
                        th2 = th6;
                        randomAccessFile = randomAccessFile2;
                        httpURLConnection = httpURLConnectionA;
                        inputStream3 = null;
                    }
                } catch (Exception e9) {
                    e = e9;
                    randomAccessFile = null;
                    inputStream2 = null;
                } catch (Throwable th7) {
                    th = th7;
                    th = th;
                    randomAccessFile = null;
                    inputStream = null;
                    if (randomAccessFile != null) {
                        randomAccessFile.close();
                    }
                    if (inputStream != null) {
                        inputStream.close();
                    }
                    if (httpURLConnectionA == null) {
                        throw th;
                    }
                    httpURLConnectionA.disconnect();
                    throw th;
                }
            } catch (Exception e10) {
                u.d("DownloadTask", "关闭文件过程中 发生异常");
                e10.printStackTrace();
            }
        } catch (Exception e11) {
            e = e11;
            httpURLConnectionA = null;
        } catch (Throwable th8) {
            th = th8;
            httpURLConnectionA = null;
        }
    }

    public void a(int i) {
        this.c.b(i);
    }

    public void a(Intent intent) {
        m.a(StubApp.getOrigApplicationContext(this.f8859a.getApplicationContext())).b(intent);
    }

    public com.ubix.ssp.ad.e.s.g.a b() {
        return this.b;
    }

    public com.ubix.ssp.ad.e.s.g.b c() {
        return this.c;
    }

    public int d() {
        com.ubix.ssp.ad.e.s.g.b bVar = this.c;
        if (bVar != null) {
            return bVar.b();
        }
        return 47;
    }

    public boolean e() {
        return this.f;
    }

    public synchronized void f() {
        this.e = true;
    }

    public synchronized void g() {
        this.e = false;
    }

    @Override // java.lang.Runnable
    public void run() throws Throwable {
        a();
    }
}
