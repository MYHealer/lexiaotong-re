package com.meishu.sdk.core.utils;

import com.meishu.sdk.core.AdSdk;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import org.json.JSONObject;

/* JADX INFO: compiled from: FilePreferences.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class q {
    public static volatile q d;
    public static long e;
    public static long f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public File f4932a;
    public final ConcurrentHashMap<String, Object> b = new ConcurrentHashMap<>();
    public final n1 c = new n1();

    /* JADX INFO: compiled from: FilePreferences.java */
    public class a extends com.meishu.sdk.core.safe.l {
        public a() {
        }

        @Override // com.meishu.sdk.core.safe.l
        public void safeRun() {
            q.this.b();
        }
    }

    public q() {
        try {
            e = System.currentTimeMillis();
            this.f4932a = new File(AdSdk.getContext().getFilesDir(), "file_preferences.json");
            c();
            f = System.currentTimeMillis();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final synchronized void b() {
        try {
            FileWriter fileWriter = new FileWriter(this.f4932a);
            try {
                JSONObject jSONObject = new JSONObject();
                for (Map.Entry<String, Object> entry : this.b.entrySet()) {
                    jSONObject.put(entry.getKey(), entry.getValue());
                }
                fileWriter.write(jSONObject.toString());
                fileWriter.close();
            } catch (Throwable th) {
                try {
                    fileWriter.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        } catch (Throwable th3) {
            th3.printStackTrace();
        }
    }

    public final synchronized void c() {
        try {
            if (!this.f4932a.exists()) {
                try {
                    this.f4932a.createNewFile();
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
                return;
            }
            StringBuilder sb = new StringBuilder();
            try {
                BufferedReader bufferedReader = new BufferedReader(new FileReader(this.f4932a));
                while (true) {
                    try {
                        String line = bufferedReader.readLine();
                        if (line == null) {
                            break;
                        } else {
                            sb.append(line);
                        }
                    } catch (Throwable th) {
                        try {
                            bufferedReader.close();
                        } catch (Throwable th2) {
                            th.addSuppressed(th2);
                        }
                        throw th;
                    }
                }
                bufferedReader.close();
                if (sb.length() > 0) {
                    try {
                        JSONObject jSONObject = new JSONObject(sb.toString());
                        Iterator<String> itKeys = jSONObject.keys();
                        while (itKeys.hasNext()) {
                            String next = itKeys.next();
                            this.b.put(next, jSONObject.get(next));
                        }
                    } catch (Exception e3) {
                        e3.printStackTrace();
                    }
                }
            } catch (Exception e4) {
                e4.printStackTrace();
                return;
            }
        } catch (Throwable th3) {
            th3.printStackTrace();
        }
        th3.printStackTrace();
    }

    public final void d() {
        int size;
        if (q0.r != 0) {
            b();
            return;
        }
        n1 n1Var = this.c;
        a aVar = new a();
        n1Var.getClass();
        try {
            size = n1Var.f4924a.size();
        } catch (Exception unused) {
            size = 0;
        }
        if (size >= n1Var.c) {
            return;
        }
        n1Var.f4924a.add(aVar);
        if (n1Var.d) {
            return;
        }
        n1Var.d = true;
        ExecutorService executorService = g0.f4905a;
        if (g0.b.f4906a.a(new m1(n1Var))) {
            return;
        }
        n1Var.d = false;
        n1Var.a();
    }

    public static q a() {
        if (d == null) {
            synchronized (q.class) {
                if (d == null) {
                    AdSdk.getContext();
                    d = new q();
                }
            }
        }
        return d;
    }

    public String a(String str, String str2) {
        try {
            Object obj = this.b.get(str);
            return obj instanceof String ? (String) obj : str2;
        } catch (Exception e2) {
            e2.printStackTrace();
            return str2;
        }
    }

    public int a(String str, int i) {
        try {
            Object obj = this.b.get(str);
            if (obj instanceof Number) {
                return ((Number) obj).intValue();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return i;
    }

    public void b(String str, String str2) {
        try {
            this.b.put(str, str2);
            d();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public long a(String str, long j) {
        try {
            Object obj = this.b.get(str);
            if (obj instanceof Number) {
                return ((Number) obj).longValue();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return j;
    }

    public void b(String str, int i) {
        try {
            this.b.put(str, Integer.valueOf(i));
            d();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void b(String str, long j) {
        try {
            this.b.put(str, Long.valueOf(j));
            d();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public boolean a(String str) {
        try {
            return this.b.containsKey(str);
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }
}
