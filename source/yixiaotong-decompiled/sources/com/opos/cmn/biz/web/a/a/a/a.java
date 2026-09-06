package com.opos.cmn.biz.web.a.a.a;

import android.content.Context;
import android.text.TextUtils;
import com.opos.cmn.an.b.c;
import com.opos.cmn.func.dl.base.DownloadConfig;
import com.opos.cmn.func.dl.base.DownloadRequest;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile a f6031a = null;
    private static String b = "";
    private volatile com.opos.cmn.func.dl.a c;
    private long d;
    private Context e;
    private volatile long f;

    /* JADX INFO: renamed from: com.opos.cmn.biz.web.a.a.a.a$a, reason: collision with other inner class name */
    class RunnableC0881a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ List f6032a;

        RunnableC0881a(List list) {
            this.f6032a = list;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                a.this.c();
                int i = 0;
                for (com.opos.cmn.biz.web.a.b.a aVar : this.f6032a) {
                    if (aVar != null && !TextUtils.isEmpty(aVar.f6036a)) {
                        a aVar2 = a.this;
                        if (!aVar2.a(aVar2.e, aVar)) {
                            a.this.c.a(new DownloadRequest.a(aVar.f6036a).a(true).b(a.a(a.this.e)).c(a.b(aVar.f6036a)).b(false).c(false).a(aVar.b).a(a.this.e));
                            i++;
                        }
                    }
                    if (i >= 30) {
                        break;
                    }
                }
                a.this.b();
            } catch (Throwable th) {
                com.opos.cmn.an.f.a.c("MatMgr", "downloadResource", th);
            }
        }
    }

    class b implements Comparator<File> {
        b(a aVar) {
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(File file, File file2) {
            return file.lastModified() - file2.lastModified() > 0 ? 1 : -1;
        }
    }

    private a() {
    }

    public static a a() {
        if (f6031a == null) {
            synchronized (a.class) {
                if (f6031a == null) {
                    f6031a = new a();
                }
            }
        }
        return f6031a;
    }

    public static String a(Context context) {
        if (TextUtils.isEmpty(b)) {
            try {
                b = context.getExternalFilesDir("") + File.separator + ".opos_ad_webview_cache";
            } catch (Exception e) {
                com.opos.cmn.an.f.a.c("MatMgr", "getMatSaveFolder fail", e);
            }
        }
        return b;
    }

    public static String a(Context context, String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                return a(context) + File.separator + b(str);
            }
        } catch (Exception e) {
            com.opos.cmn.an.f.a.c("MatMgr", "getMatSavePath fail", e);
        }
        return "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(Context context, com.opos.cmn.biz.web.a.b.a aVar) {
        File file = new File(a(context, aVar.f6036a));
        boolean z = file.exists() && (TextUtils.isEmpty(aVar.b) || aVar.b.contentEquals(c.a(file)));
        if (z) {
            file.setLastModified(System.currentTimeMillis());
        }
        com.opos.cmn.an.f.a.b("MatMgr", "checkMatExitAndValid url:" + aVar.f6036a + " result:" + z);
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String b(String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                return c.a(str) + ".adweb";
            }
        } catch (Exception e) {
            com.opos.cmn.an.f.a.c("MatMgr", "getMatName fail", e);
        }
        return "";
    }

    private static List<File> b(Context context) {
        File[] fileArrListFiles;
        ArrayList arrayList = new ArrayList();
        try {
            String strA = a(context);
            if (com.opos.cmn.an.e.b.a.b(strA) && (fileArrListFiles = new File(strA).listFiles()) != null && fileArrListFiles.length > 0) {
                for (File file : fileArrListFiles) {
                    if (file != null && !TextUtils.isEmpty(file.getName())) {
                        arrayList.add(file);
                    }
                }
            }
        } catch (Exception e) {
            com.opos.cmn.an.f.a.c("MatMgr", "", e);
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void b() {
        try {
            long jCurrentTimeMillis = System.currentTimeMillis();
            if (jCurrentTimeMillis - this.f > 600000) {
                com.opos.cmn.an.f.a.b("MatMgr", "tryRecycleCache");
                this.f = jCurrentTimeMillis;
                List<File> listB = b(this.e);
                if (listB != null && listB.size() > 0) {
                    ArrayList<File> arrayList = new ArrayList();
                    long length = 0;
                    for (File file : listB) {
                        if (file.lastModified() <= System.currentTimeMillis() - 604800000) {
                            String name = file.getName();
                            if (com.opos.cmn.an.e.b.a.e(file)) {
                                com.opos.cmn.an.f.a.b("MatMgr", "delete mat file success.file path=" + name);
                            } else {
                                com.opos.cmn.an.f.a.c("MatMgr", "delete mat file  fail.file path=" + name);
                            }
                        } else {
                            arrayList.add(file);
                            length += file.length();
                        }
                    }
                    if (length > this.d) {
                        Collections.sort(arrayList, new b(this));
                        for (File file2 : arrayList) {
                            String name2 = file2.getName();
                            long length2 = file2.length();
                            if (com.opos.cmn.an.e.b.a.e(file2)) {
                                length -= length2;
                                com.opos.cmn.an.f.a.b("MatMgr", "delete mat file success.file path=" + name2);
                            } else {
                                com.opos.cmn.an.f.a.c("MatMgr", "delete mat file  fail.file path=" + name2);
                            }
                            if (length <= this.d * 0.8d) {
                                break;
                            }
                        }
                    }
                    com.opos.cmn.an.f.a.b("MatMgr", "tryRecycleCache nowCachedSize:" + (length / 1048576.0f) + "M maxCacheSize:" + (this.d / 1048576.0f) + "M");
                }
            }
        } catch (Exception e) {
            com.opos.cmn.an.f.a.c("MatMgr", "tryRecycleCache", e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void c() {
        if (this.c == null) {
            this.c = new com.opos.cmn.func.dl.a(this.e);
            DownloadConfig downloadConfig = new DownloadConfig();
            downloadConfig.b(1);
            downloadConfig.a(1);
            downloadConfig.a(false);
            this.c.a(downloadConfig);
        }
    }

    public void a(Context context, long j) {
        this.e = context;
        this.d = j;
        this.f = 0L;
    }

    public void a(List<com.opos.cmn.biz.web.a.b.a> list) {
        try {
            com.opos.cmn.an.j.b.d(new RunnableC0881a(list));
        } catch (Throwable th) {
            com.opos.cmn.an.f.a.c("MatMgr", "downloadResource", th);
        }
    }
}
