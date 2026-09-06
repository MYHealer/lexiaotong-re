package com.meishu.sdk.core.utils;

import com.meishu.sdk.core.AdSdk;
import com.meishu.sdk.core.domain.HttpResponse;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class VideoLoadManager {
    public static VideoLoadManager b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, d> f4876a = new HashMap();

    public enum LoadState {
        IDLE,
        LOADING,
        SUCCESS,
        FAILED
    }

    public class a implements x {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f4877a;

        public a(String str) {
            this.f4877a = str;
        }

        @Override // com.meishu.sdk.core.utils.x
        public void onFailure(IOException iOException) {
            VideoLoadManager.this.a(this.f4877a, -1, com.meishu.sdk.activity.a.a("load video error: ").append(iOException.getMessage()).toString());
        }

        @Override // com.meishu.sdk.core.utils.x
        public void onResponse(HttpResponse<byte[]> httpResponse) throws IOException {
            if (httpResponse != null) {
                try {
                    if (httpResponse.isSuccessful()) {
                        byte[] responseBody = httpResponse.getResponseBody();
                        if (responseBody == null || responseBody.length <= 0) {
                            VideoLoadManager.this.a(this.f4877a, -1, "load video error: empty response");
                            return;
                        }
                        String str = this.f4877a;
                        try {
                            File fileA = com.meishu.sdk.core.bquery.g.a(str, (String) null);
                            com.meishu.sdk.core.bquery.g.a(fileA, responseBody);
                            if (fileA == null || !fileA.exists() || fileA.length() <= 0) {
                                VideoLoadManager.this.a(this.f4877a, -1, "load file error");
                                return;
                            }
                            VideoLoadManager videoLoadManager = VideoLoadManager.this;
                            synchronized (videoLoadManager) {
                                d dVar = videoLoadManager.f4876a.get(str);
                                if (dVar != null) {
                                    dVar.f4880a = LoadState.SUCCESS;
                                    dVar.b = fileA;
                                    videoLoadManager.a(str, fileA, false);
                                }
                            }
                            return;
                        } catch (Throwable th) {
                            th.printStackTrace();
                            VideoLoadManager.this.a(this.f4877a, -1, "load file error");
                            return;
                        }
                    }
                } catch (Throwable th2) {
                    VideoLoadManager.this.a(this.f4877a, -1, com.meishu.sdk.activity.a.a("load video error: ").append(th2.getMessage()).toString());
                    th2.printStackTrace();
                    return;
                }
            }
            VideoLoadManager.this.a(this.f4877a, -1, "load video error: unsuccessful response");
        }
    }

    public class b extends com.meishu.sdk.core.safe.l {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ List f4878a;
        public final /* synthetic */ String b;
        public final /* synthetic */ File c;
        public final /* synthetic */ boolean d;

        public b(VideoLoadManager videoLoadManager, List list, String str, File file, boolean z) {
            this.f4878a = list;
            this.b = str;
            this.c = file;
            this.d = z;
        }

        @Override // com.meishu.sdk.core.safe.l
        public void safeRun() {
            for (com.meishu.sdk.core.bquery.h hVar : this.f4878a) {
                if (hVar != null) {
                    hVar.a(this.b, this.c, this.d);
                }
            }
        }
    }

    public static /* synthetic */ class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f4879a;

        static {
            int[] iArr = new int[LoadState.values().length];
            f4879a = iArr;
            try {
                iArr[LoadState.SUCCESS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f4879a[LoadState.FAILED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f4879a[LoadState.LOADING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f4879a[LoadState.IDLE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public static class d {
        public File b;
        public int c;
        public String d;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public LoadState f4880a = LoadState.IDLE;
        public List<com.meishu.sdk.core.bquery.h<File>> e = new ArrayList();
    }

    public final synchronized void a(String str, int i, boolean z, com.meishu.sdk.core.bquery.h<File> hVar, boolean z2) {
        try {
            d dVar = this.f4876a.get(str);
            if (dVar == null) {
                dVar = new d();
                this.f4876a.put(str, dVar);
            }
            int i2 = c.f4879a[dVar.f4880a.ordinal()];
            if (i2 == 1) {
                File file = dVar.b;
                if (file == null || !file.exists()) {
                    dVar.f4880a = LoadState.IDLE;
                } else {
                    long jCurrentTimeMillis = System.currentTimeMillis() - dVar.b.lastModified();
                    if (dVar.b.length() > 0 && jCurrentTimeMillis < i) {
                        File file2 = dVar.b;
                        if (hVar != null) {
                            SdkHandler.getInstance().runOnUiThread(new q1(this, hVar, str, file2, true));
                        }
                        return;
                    }
                    dVar.b.delete();
                    dVar.f4880a = LoadState.IDLE;
                }
            } else if (i2 == 2) {
                if (!z2 && hVar != null) {
                    SdkHandler.runOnMainThread(new r1(this, hVar, dVar.c, dVar.d));
                }
                dVar.f4880a = LoadState.IDLE;
                dVar.e.clear();
            } else if (i2 == 3) {
                if (hVar != null) {
                    dVar.e.add(hVar);
                }
                return;
            }
            if (hVar != null) {
                dVar.e.add(hVar);
            }
            if (z) {
                com.meishu.sdk.core.bquery.g.a(AdSdk.getContext());
            }
            File file3 = null;
            File fileA = com.meishu.sdk.core.bquery.g.a(com.meishu.sdk.core.bquery.g.b(AdSdk.getContext()), str, null);
            if (fileA != null && fileA.exists()) {
                file3 = fileA;
            }
            if (file3 != null && file3.exists()) {
                long jCurrentTimeMillis2 = System.currentTimeMillis() - file3.lastModified();
                if (file3.length() > 0 && jCurrentTimeMillis2 < i) {
                    dVar.f4880a = LoadState.SUCCESS;
                    dVar.b = file3;
                    a(str, file3, true);
                    return;
                }
                file3.delete();
            }
            dVar.f4880a = LoadState.LOADING;
            z.a(str, (x) new a(str), false);
        } catch (Throwable th) {
            a(str, -1, com.meishu.sdk.activity.a.a("load video error: ").append(th.getMessage()).toString());
        }
    }

    public final synchronized void a(String str, int i, String str2) {
        d dVar = this.f4876a.get(str);
        if (dVar != null) {
            dVar.f4880a = LoadState.FAILED;
            dVar.c = i;
            dVar.d = str2;
            d dVar2 = this.f4876a.get(str);
            if (dVar2 != null && !dVar2.e.isEmpty()) {
                ArrayList arrayList = new ArrayList(dVar2.e);
                dVar2.e.clear();
                SdkHandler.runOnMainThread(new p1(this, arrayList, i, str2));
            }
        }
    }

    public final void a(String str, File file, boolean z) {
        d dVar = this.f4876a.get(str);
        if (dVar == null || dVar.e.isEmpty()) {
            return;
        }
        ArrayList arrayList = new ArrayList(dVar.e);
        dVar.e.clear();
        SdkHandler.getInstance().runOnUiThread(new b(this, arrayList, str, file, z));
    }
}
