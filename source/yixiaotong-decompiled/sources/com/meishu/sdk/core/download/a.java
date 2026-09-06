package com.meishu.sdk.core.download;

import android.os.Environment;
import com.meishu.sdk.core.AdSdk;
import com.meishu.sdk.core.utils.LogUtil;
import com.stub.StubApp;
import java.io.File;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ThreadPoolExecutor;

/* JADX INFO: compiled from: DownloadManager.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ConcurrentHashMap<String, d> f4781a = new ConcurrentHashMap<>();
    public g b = new g();
    public String c = StubApp.getOrigApplicationContext(AdSdk.getContext().getApplicationContext()).getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS).getAbsolutePath() + "/msdownload";

    /* JADX INFO: renamed from: com.meishu.sdk.core.download.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: DownloadManager.java */
    public static class C0793a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f4782a = new a();
    }

    public static a b() {
        return C0793a.f4782a;
    }

    public String a() {
        return this.c;
    }

    public g c() {
        return this.b;
    }

    public void a(String str) {
        d dVar = this.f4781a.get(str);
        if (dVar != null) {
            ThreadPoolExecutor threadPoolExecutor = dVar.c;
            if (threadPoolExecutor != null) {
                threadPoolExecutor.remove(dVar);
            }
            Map<Object, h> map = dVar.e;
            if (map != null) {
                map.remove(dVar.b);
            }
            try {
                File file = new File(dVar.f4785a.c);
                if (file.exists() && file.isFile()) {
                    LogUtil.e("DownloadTask", "file.delete");
                    file.delete();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        this.f4781a.remove(str);
    }

    public d b(String str) {
        return this.f4781a.get(str);
    }
}
