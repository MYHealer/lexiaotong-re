package com.opos.mobad;

import android.content.Context;
import android.os.Build;
import com.stub.StubApp;
import java.io.File;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import org.apache.commons.io.FileUtils;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f7123a;

    private static class a implements com.opos.mobad.ui.c.b.a {
        private a() {
        }

        @Override // com.opos.mobad.ui.c.b.a
        public void a(int i, int i2) {
            int i3 = 3;
            if (i2 != 2) {
                if (i2 != 3) {
                    i3 = 4;
                    if (i2 != 4) {
                        i3 = 5;
                        if (i2 != 5) {
                            i3 = 1;
                        }
                    }
                } else {
                    i3 = 2;
                }
            }
            com.opos.mobad.c.b.f().d().a(i, i3);
        }
    }

    private void a(Context context) {
        com.opos.cmn.an.c.a.a(context, Build.BRAND != null ? Build.BRAND : "");
        com.opos.mobad.cmn.service.b.a.a().a(context);
        com.opos.mobad.f.e.a().a(context);
        com.opos.mobad.model.b.a(context).a();
        com.opos.mobad.cmn.service.a.a().a(context, new a());
    }

    private void a(File file, long j, int i) {
        File[] fileArrListFiles;
        StringBuilder sbAppend;
        String str;
        if (!file.exists() || !file.isDirectory()) {
            com.opos.cmn.an.f.a.b("InterMobAdManager", "folder not exist");
            return;
        }
        long jE = com.opos.cmn.an.e.b.a.e(file.getAbsolutePath());
        int iB = com.opos.mobad.cmn.func.b.g.b(file.getAbsolutePath());
        if (jE < j && iB < i) {
            com.opos.cmn.an.f.a.b("InterMobAdManager", "video cache size not over max size or over max count,don't need clear video cache.");
            return;
        }
        com.opos.cmn.an.f.a.b("InterMobAdManager", "video cache size over max size or over max count,start clear video cache.");
        if (!file.exists() || !file.isDirectory() || (fileArrListFiles = file.listFiles()) == null || fileArrListFiles.length <= 0) {
            return;
        }
        Arrays.sort(fileArrListFiles, new Comparator<File>() { // from class: com.opos.mobad.m.3
            @Override // java.util.Comparator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public int compare(File file2, File file3) {
                long jLastModified = file2.lastModified() - file3.lastModified();
                if (jLastModified > 0) {
                    return 1;
                }
                return jLastModified == 0 ? 0 : -1;
            }

            @Override // java.util.Comparator
            public boolean equals(Object obj) {
                return true;
            }
        });
        for (int i2 = 0; i2 < fileArrListFiles.length / 2; i2++) {
            File file2 = fileArrListFiles[i2];
            if (file2 != null && file2.exists() && file2.isFile()) {
                com.opos.cmn.an.f.a.b("InterMobAdManager", "file.lastModified()=" + file2.lastModified() + ",System.currentTimeMillis()=" + com.opos.cmn.b.a.a.b());
                if (file2.delete()) {
                    sbAppend = new StringBuilder("file.lastModified()=").append(file2.lastModified()).append(",System.currentTimeMillis()=").append(com.opos.cmn.b.a.a.b());
                    str = ",need delete file=";
                } else {
                    sbAppend = new StringBuilder("file.lastModified()=").append(file2.lastModified()).append(",System.currentTimeMillis()=").append(com.opos.cmn.b.a.a.b());
                    str = ",don't need delete file=";
                }
                com.opos.cmn.an.f.a.b("InterMobAdManager", sbAppend.append(str).append(file2.getName()).toString());
            }
        }
    }

    private void b(Context context) {
        Context origApplicationContext = StubApp.getOrigApplicationContext(context.getApplicationContext());
        com.opos.mobad.cmn.service.pkginstall.c.a(origApplicationContext).a();
        com.opos.mobad.cmn.service.b.a.a().b(context);
        com.opos.mobad.cmn.service.a.a.a(origApplicationContext).a();
        com.opos.mobad.model.b.a(this.f7123a).b();
    }

    private void c() {
        com.opos.cmn.an.j.b.a(new Runnable() { // from class: com.opos.mobad.m.2
            @Override // java.lang.Runnable
            public void run() {
                m.this.d();
                m.this.e();
                m.this.h();
                m.this.f();
                m.this.g();
            }
        });
    }

    private void c(final Context context) {
        com.opos.cmn.an.j.b.a(new Runnable() { // from class: com.opos.mobad.m.1
            @Override // java.lang.Runnable
            public void run() {
                File[] fileArrListFiles;
                try {
                    File file = new File(com.opos.cmn.d.c.a(context));
                    if (!file.exists() || !file.isDirectory() || (fileArrListFiles = file.listFiles()) == null || fileArrListFiles.length <= 0) {
                        return;
                    }
                    for (File file2 : fileArrListFiles) {
                        if (file2 != null && file2.exists() && file2.isFile()) {
                            com.opos.cmn.an.f.a.b("InterMobAdManager", "file.lastModified()=" + file2.lastModified() + ",System.currentTimeMillis()=" + com.opos.cmn.b.a.a.b());
                            com.opos.cmn.an.f.a.b("InterMobAdManager", (file2.lastModified() + 432000000 >= System.currentTimeMillis() || !file2.delete()) ? "file.lastModified()=" + file2.lastModified() + ",System.currentTimeMillis()=" + com.opos.cmn.b.a.a.b() + ",don't need delete file=" + file2.getName() : "file.lastModified()=" + file2.lastModified() + ",System.currentTimeMillis()=" + com.opos.cmn.b.a.a.b() + ",need delete file=" + file2.getName());
                        }
                    }
                } catch (Exception e) {
                    com.opos.cmn.an.f.a.a("InterMobAdManager", "", (Throwable) e);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        try {
            if (!com.opos.mobad.service.e.b.n().i()) {
                com.opos.cmn.an.f.a.b("InterMobAdManager", "clearPublicVideoCache but not allow");
                return;
            }
            com.opos.cmn.an.f.a.b("InterMobAdManager", "clearPublicVideoCache");
            if (com.opos.cmn.d.d.a(this.f7123a)) {
                a(new File(com.opos.cmn.d.d.a()), FileUtils.ONE_GB, 50);
            }
        } catch (Exception e) {
            com.opos.cmn.an.f.a.a("InterMobAdManager", "", (Throwable) e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        com.opos.cmn.an.f.a.b("InterMobAdManager", "clearPrivateVideoCache");
        try {
            a(new File(com.opos.cmn.d.d.b(this.f7123a)), 536870912L, 25);
        } catch (Exception e) {
            com.opos.cmn.an.f.a.a("InterMobAdManager", "", (Throwable) e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        try {
            if (!com.opos.mobad.service.e.b.n().i()) {
                com.opos.cmn.an.f.a.b("InterMobAdManager", "clearPublicDownloadApkCache but not allow");
                return;
            }
            com.opos.cmn.an.f.a.b("InterMobAdManager", "clearPublicDownloadApkCache");
            if (com.opos.cmn.d.a.a(this.f7123a)) {
                a(new File(com.opos.cmn.d.a.a()), FileUtils.ONE_GB, 50);
            }
        } catch (Exception e) {
            com.opos.cmn.an.f.a.a("InterMobAdManager", "", (Throwable) e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        com.opos.cmn.an.f.a.b("InterMobAdManager", "clearPrivateDownloadApkCache");
        try {
            a(new File(com.opos.cmn.d.a.c(this.f7123a)), 536870912L, 25);
        } catch (Exception e) {
            com.opos.cmn.an.f.a.a("InterMobAdManager", "", (Throwable) e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        com.opos.cmn.an.f.a.b("InterMobAdManager", "clearDynamicUnzipDir");
        try {
            com.opos.mobad.service.b.b.a().b(this.f7123a);
        } catch (Exception e) {
            com.opos.cmn.an.f.a.a("InterMobAdManager", "", (Throwable) e);
        }
    }

    public void a() {
        Context context;
        if (com.opos.mobad.cmn.func.b.g.c()) {
            try {
                if (!com.opos.mobad.cmn.func.b.g.b() || (context = this.f7123a) == null) {
                    return;
                }
                b(context);
            } catch (Exception e) {
                com.opos.cmn.an.f.a.a("InterMobAdManager", "", (Throwable) e);
            }
        }
    }

    public void a(Context context, String str) {
        try {
            this.f7123a = StubApp.getOrigApplicationContext(context.getApplicationContext());
            com.opos.mobad.cmn.func.b.g.a(str);
            com.opos.cmn.an.f.a.b("InterMobAdManager", "init sdk success.");
            a(this.f7123a);
            com.opos.mobad.cmn.func.b.g.a();
            c(this.f7123a);
            c();
            b();
        } catch (Exception e) {
            com.opos.cmn.an.f.a.c("InterMobAdManager", "init", e);
        }
    }

    public void b() {
        com.opos.cmn.an.j.b.a(new Runnable() { // from class: com.opos.mobad.m.4
            @Override // java.lang.Runnable
            public void run() {
                com.opos.cmn.an.f.a.b("InterMobAdManager", "startClearRewardSP");
                Map<String, Long> mapB = com.opos.mobad.cmn.func.b.g.b(m.this.f7123a);
                if (mapB == null || mapB.size() <= 0) {
                    return;
                }
                for (Map.Entry<String, Long> entry : mapB.entrySet()) {
                    if (entry.getValue().longValue() + 259200000 < com.opos.cmn.b.a.a.c()) {
                        com.opos.cmn.an.f.a.b("InterMobAdManager", "remove pkgName=" + entry.getKey() + ",timestamp=" + entry.getValue());
                        com.opos.mobad.cmn.func.b.g.e(m.this.f7123a, entry.getKey());
                    }
                }
            }
        });
    }
}
