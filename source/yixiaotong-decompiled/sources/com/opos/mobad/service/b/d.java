package com.opos.mobad.service.b;

import android.content.Context;
import android.text.TextUtils;
import com.opos.mobad.j;
import com.opos.mobad.s;
import com.stub.StubApp;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f7332a;
    private f b;
    private com.opos.cmn.i.a c = new com.opos.cmn.i.a(new AnonymousClass1(), Integer.MAX_VALUE, 10000);
    private volatile List<com.opos.mobad.d.a.a.b> d;
    private volatile Map<Integer, com.opos.mobad.d.a.a.b> e;
    private a f;

    /* JADX INFO: renamed from: com.opos.mobad.service.b.d$1, reason: invalid class name */
    class AnonymousClass1 implements com.opos.cmn.i.a.b {
        AnonymousClass1() {
        }

        @Override // com.opos.cmn.i.a.b
        public void a(final com.opos.cmn.i.a.InterfaceC0895a interfaceC0895a) {
            final List list = d.this.d;
            final Map map = d.this.e;
            if (list != null && list.size() > 0) {
                com.opos.cmn.an.f.a.b("Dynamic-Loader", "start to load action");
                com.opos.cmn.an.j.b.c(new Runnable() { // from class: com.opos.mobad.service.b.d.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            com.opos.mobad.f.e.a().a(list, new com.opos.mobad.d.a.a.InterfaceC0956a() { // from class: com.opos.mobad.service.b.d.1.1.1
                                @Override // com.opos.mobad.d.a.a.InterfaceC0956a
                                public void a() throws Throwable {
                                    com.opos.cmn.an.f.a.b("Dynamic-Loader", "FileLoader onComplete");
                                    d.this.b((Map<Integer, com.opos.mobad.d.a.a.b>) map);
                                    if (interfaceC0895a != null) {
                                        interfaceC0895a.a();
                                    }
                                }

                                @Override // com.opos.mobad.d.a.a.InterfaceC0956a
                                public void a(String str) {
                                }

                                @Override // com.opos.mobad.d.a.a.InterfaceC0956a
                                public void a(String str, int i) {
                                    com.opos.cmn.an.f.a.b("Dynamic-Loader", "FileLoader info =", Integer.valueOf(i), str);
                                }
                            }, j.a(f.a(d.this.f7332a)));
                        } catch (Exception e) {
                            com.opos.cmn.an.f.a.d("Dynamic-Loader", "", e);
                        }
                    }
                });
            } else {
                com.opos.cmn.an.f.a.b("Dynamic-Loader", "load action but empty load info");
                if (interfaceC0895a != null) {
                    interfaceC0895a.b();
                }
            }
        }
    }

    public interface a {
        void a(String str, int i);
    }

    public d(Context context) {
        this.f7332a = StubApp.getOrigApplicationContext(context.getApplicationContext());
        this.b = new f(this.f7332a);
    }

    /* JADX WARN: Code duplicated, block: B:30:? A[RETURN, SYNTHETIC] */
    public static void a(Context context) {
        try {
            String strA = f.a(context);
            j jVarA = j.a(strA);
            if (jVarA != null) {
                try {
                    if (s.a(jVarA, 6, 70)) {
                        c.a(new File(strA), j.b(strA));
                        File file = new File(f.b(context));
                        c.a(file);
                        c.a(file, 268435456L, 20);
                    }
                } catch (Exception e) {
                    com.opos.cmn.an.f.a.a("Dynamic-Loader", "", (Throwable) e);
                } finally {
                    if (jVarA != null) {
                        jVarA.b();
                    }
                }
            }
        } catch (Exception e2) {
            com.opos.cmn.an.f.a.a("Dynamic-Loader", "", (Throwable) e2);
        }
    }

    private void b(int i, String str) {
        com.opos.cmn.an.f.a.c("Dynamic-Loader", i + " onSetZipPath:" + str);
        if (TextUtils.isEmpty(str)) {
            return;
        }
        b.a().b(i, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(Map<Integer, com.opos.mobad.d.a.a.b> map) throws Throwable {
        String str;
        a aVar;
        for (final Integer num : map.keySet()) {
            com.opos.mobad.d.a.a.b bVar = map.get(num);
            com.opos.cmn.an.f.a.c("Dynamic-Loader", "unzip url:" + bVar.f6861a);
            if (bVar != null && !TextUtils.isEmpty(bVar.f6861a)) {
                String strB = this.b.b(bVar.f6861a);
                com.opos.cmn.an.f.a.c("Dynamic-Loader", "filePath:" + strB);
                if (TextUtils.isEmpty(strB)) {
                    str = "prepare failed!zipPath or destPath is empty!";
                } else {
                    File file = new File(strB);
                    if (file.exists()) {
                        com.opos.cmn.an.f.a.c("Dynamic-Loader", "unzipFile:" + strB);
                        b(num.intValue(), strB);
                        int iA = e.a(this.f7332a, strB, new com.opos.mobad.service.i.a<String>() { // from class: com.opos.mobad.service.b.d.2
                            @Override // com.opos.mobad.service.i.a
                            public void a(String str2) {
                                com.opos.cmn.an.f.a.c("Dynamic-Loader", "unzipFileSync callback:" + str2);
                                d.this.c(num.intValue(), str2);
                            }
                        });
                        com.opos.cmn.an.f.a.c("Dynamic-Loader", "unzipFileSync:" + iA);
                        if (iA != 0 && (aVar = this.f) != null) {
                            aVar.a(bVar.f6861a, iA);
                        }
                        if (file.exists()) {
                            try {
                                file.delete();
                            } catch (Exception e) {
                                com.opos.cmn.an.f.a.a("Dynamic-Loader", "", (Throwable) e);
                            }
                        }
                    } else {
                        str = "prepare failed!zipPath not exist";
                    }
                }
                com.opos.cmn.an.f.a.c("Dynamic-Loader", str);
            }
        }
    }

    private Map<Integer, com.opos.mobad.d.a.a.b> c(Map<Integer, String> map) {
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        if (map != null && !map.isEmpty()) {
            Iterator<Integer> it = map.keySet().iterator();
            int i = 0;
            while (it.hasNext()) {
                int iIntValue = it.next().intValue();
                if (i >= 10) {
                    break;
                }
                String str = map.get(Integer.valueOf(iIntValue));
                if (!TextUtils.isEmpty(str)) {
                    if (a(str)) {
                        File fileA = f.a(this.f7332a, this.b.b(str));
                        if (fileA != null) {
                            c(iIntValue, fileA.getAbsolutePath());
                        }
                    } else {
                        concurrentHashMap.put(Integer.valueOf(iIntValue), new com.opos.mobad.d.a.a.b(str, "", ".dynamic"));
                        i++;
                    }
                }
            }
            com.opos.cmn.an.f.a.a("Dynamic-Loader", "load info list =", concurrentHashMap);
        }
        return concurrentHashMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(int i, String str) {
        com.opos.cmn.an.f.a.c("Dynamic-Loader", i + " onSetUnZipPath:" + str);
        if (TextUtils.isEmpty(str)) {
            return;
        }
        b.a().a(i, str);
    }

    public void a(int i, String str) {
        if (TextUtils.isEmpty(str)) {
            com.opos.cmn.an.f.a.b("Dynamic-Loader", "no need load template empty url = " + str);
            return;
        }
        if (a(str)) {
            return;
        }
        com.opos.cmn.an.f.a.b("Dynamic-Loader", "loadMaterial url = " + str);
        ArrayList arrayList = new ArrayList();
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        com.opos.mobad.d.a.a.b bVar = new com.opos.mobad.d.a.a.b(str, "", ".dynamic");
        arrayList.add(bVar);
        concurrentHashMap.put(Integer.valueOf(i), bVar);
        this.d = arrayList;
        this.e = concurrentHashMap;
        this.c.a();
    }

    public void a(a aVar) {
        this.f = aVar;
    }

    public void a(Map<Integer, String> map) {
        if (map == null || map.isEmpty()) {
            com.opos.cmn.an.f.a.b("Dynamic-Loader", "loadMaterialList fail ");
            return;
        }
        this.e = c(map);
        this.d = new ArrayList();
        Iterator<com.opos.mobad.d.a.a.b> it = this.e.values().iterator();
        while (it.hasNext()) {
            this.d.add(it.next());
        }
        if (this.d == null || this.d.size() < 0) {
            return;
        }
        this.c.a();
    }

    public boolean a(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        File fileA = f.a(this.f7332a, this.b.b(str));
        if (fileA == null) {
            com.opos.cmn.an.f.a.a("Dynamic-Loader", "check file exit but not exit: " + str);
            return false;
        }
        if (fileA.exists()) {
            com.opos.cmn.an.f.a.b("Dynamic-Loader", "check file exit: ", str, fileA.getAbsolutePath());
            return true;
        }
        com.opos.cmn.an.f.a.b("Dynamic-Loader", "check file exit but not exit: " + str + ", file =" + fileA.getAbsolutePath());
        return false;
    }
}
