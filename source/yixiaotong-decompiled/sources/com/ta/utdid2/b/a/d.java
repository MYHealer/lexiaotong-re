package com.ta.utdid2.b.a;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.WeakHashMap;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class d {
    private static final Object b = new Object();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private File f8533a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private final Object f950a = new Object();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private HashMap<File, a> f951a = new HashMap<>();

    public d(String str) {
        if (str != null && str.length() > 0) {
            this.f8533a = new File(str);
            return;
        }
        throw new RuntimeException("Directory can not be empty");
    }

    private File a(File file, String str) {
        if (str.indexOf(File.separatorChar) < 0) {
            return new File(file, str);
        }
        throw new IllegalArgumentException("File " + str + " contains a path separator");
    }

    private File a() {
        File file;
        synchronized (this.f950a) {
            file = this.f8533a;
        }
        return file;
    }

    private File b(String str) {
        return a(a(), str + ".xml");
    }

    /* JADX WARN: Code duplicated, block: B:51:0x0089 A[Catch: all -> 0x005a, TRY_ENTER, TRY_LEAVE, TryCatch #16 {all -> 0x005a, blocks: (B:30:0x0057, B:51:0x0089), top: B:86:0x0035 }] */
    /* JADX WARN: Code duplicated, block: B:56:0x0092 A[Catch: all -> 0x00ad, TRY_ENTER, TryCatch #7 {all -> 0x00ad, blocks: (B:56:0x0092, B:60:0x00ab, B:57:0x0096, B:59:0x00a1), top: B:81:0x0090 }] */
    /* JADX WARN: Code duplicated, block: B:57:0x0096 A[Catch: all -> 0x00ad, TryCatch #7 {all -> 0x00ad, blocks: (B:56:0x0092, B:60:0x00ab, B:57:0x0096, B:59:0x00a1), top: B:81:0x0090 }] */
    /* JADX WARN: Code duplicated, block: B:59:0x00a1 A[Catch: all -> 0x00ad, TryCatch #7 {all -> 0x00ad, blocks: (B:56:0x0092, B:60:0x00ab, B:57:0x0096, B:59:0x00a1), top: B:81:0x0090 }] */
    /* JADX WARN: Code duplicated, block: B:81:0x0090 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v11 */
    /* JADX WARN: Type inference failed for: r0v12 */
    /* JADX WARN: Type inference failed for: r0v14 */
    /* JADX WARN: Type inference failed for: r0v15 */
    /* JADX WARN: Type inference failed for: r0v16 */
    /* JADX WARN: Type inference failed for: r0v17 */
    /* JADX WARN: Type inference failed for: r0v5, types: [boolean] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r0v9 */
    /* JADX WARN: Type inference failed for: r1v10 */
    /* JADX WARN: Type inference failed for: r1v2, types: [com.ta.utdid2.b.a.b, com.ta.utdid2.b.a.d$a] */
    /* JADX WARN: Type inference failed for: r1v6, types: [com.ta.utdid2.b.a.b] */
    /* JADX WARN: Type inference failed for: r1v8 */
    /* JADX WARN: Type inference failed for: r1v9 */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v14 */
    /* JADX WARN: Type inference failed for: r2v16 */
    /* JADX WARN: Type inference failed for: r2v18, types: [java.util.HashMap] */
    /* JADX WARN: Type inference failed for: r2v2, types: [java.util.Map] */
    /* JADX WARN: Type inference failed for: r2v21 */
    /* JADX WARN: Type inference failed for: r2v24 */
    /* JADX WARN: Type inference failed for: r2v25 */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r4v0 */
    /* JADX WARN: Type inference failed for: r4v1 */
    public b a(String str, int i) throws Throwable {
        a aVar;
        ?? r1;
        FileInputStream fileInputStream;
        File fileB = b(str);
        synchronized (b) {
            a aVar2 = this.f951a.get(fileB);
            if (aVar2 != 0 && !aVar2.d()) {
                return aVar2;
            }
            File fileA = a(fileB);
            if (fileA.exists()) {
                fileB.delete();
                fileA.renameTo(fileB);
            }
            ?? A = 0;
            A = 0;
            A = 0;
            FileInputStream fileInputStream2 = null;
            FileInputStream fileInputStream3 = null;
            A = 0;
            FileInputStream fileInputStream4 = null;
            if (fileB.exists()) {
                ?? CanRead = fileB.canRead();
                try {
                    try {
                        if (CanRead != 0) {
                            try {
                                FileInputStream fileInputStream5 = new FileInputStream(fileB);
                                try {
                                    A = e.a(fileInputStream5);
                                    fileInputStream5.close();
                                    try {
                                        fileInputStream5.close();
                                    } catch (Throwable unused) {
                                    }
                                } catch (XmlPullParserException unused2) {
                                    ?? r4 = A;
                                    fileInputStream2 = fileInputStream5;
                                    CanRead = r4;
                                    try {
                                        fileInputStream = new FileInputStream(fileB);
                                        try {
                                            fileInputStream.read(new byte[fileInputStream.available()]);
                                            try {
                                                fileInputStream.close();
                                            } catch (Throwable unused3) {
                                            }
                                        } catch (Exception unused4) {
                                            fileInputStream2 = fileInputStream;
                                            if (fileInputStream2 != null) {
                                                try {
                                                    fileInputStream2.close();
                                                } catch (Throwable unused5) {
                                                }
                                            }
                                            fileInputStream = fileInputStream2;
                                            if (fileInputStream != null) {
                                                fileInputStream.close();
                                                CanRead = CanRead;
                                            }
                                            A = CanRead;
                                            synchronized (b) {
                                                try {
                                                    if (aVar2 != 0) {
                                                        aVar2.a((Map) A);
                                                        r1 = aVar2;
                                                    } else {
                                                        aVar = this.f951a.get(fileB);
                                                        if (aVar == null) {
                                                            r1 = aVar;
                                                            a aVar3 = new a(fileB, i, A);
                                                            this.f951a.put(fileB, aVar3);
                                                            r1 = aVar3;
                                                        }
                                                    }
                                                    return r1;
                                                } catch (Throwable th) {
                                                    throw th;
                                                }
                                            }
                                        } catch (Throwable th2) {
                                            th = th2;
                                            fileInputStream2 = fileInputStream;
                                            if (fileInputStream2 != null) {
                                                try {
                                                    fileInputStream2.close();
                                                } catch (Throwable unused6) {
                                                }
                                            }
                                            throw th;
                                        }
                                    } catch (Exception unused7) {
                                    } catch (Throwable th3) {
                                        th = th3;
                                    }
                                    if (fileInputStream != null) {
                                        fileInputStream.close();
                                        CanRead = CanRead;
                                    }
                                    A = CanRead;
                                } catch (Exception unused8) {
                                    ?? r5 = A;
                                    fileInputStream3 = fileInputStream5;
                                    CanRead = r5;
                                    if (fileInputStream3 != null) {
                                        fileInputStream3.close();
                                        CanRead = CanRead;
                                    }
                                    A = CanRead;
                                } catch (Throwable th4) {
                                    th = th4;
                                    fileInputStream4 = fileInputStream5;
                                    if (fileInputStream4 != null) {
                                        try {
                                            fileInputStream4.close();
                                        } catch (Throwable unused9) {
                                        }
                                    }
                                    throw th;
                                }
                            } catch (XmlPullParserException unused10) {
                                CanRead = 0;
                            } catch (Exception unused11) {
                                CanRead = 0;
                            }
                        }
                    } catch (Throwable th5) {
                        th = th5;
                    }
                } catch (Throwable unused12) {
                }
            }
            synchronized (b) {
                if (aVar2 != 0) {
                    aVar2.a((Map) A);
                    r1 = aVar2;
                } else {
                    aVar = this.f951a.get(fileB);
                    if (aVar == null) {
                        r1 = aVar;
                        a aVar4 = new a(fileB, i, A);
                        this.f951a.put(fileB, aVar4);
                        r1 = aVar4;
                    }
                }
            }
            return r1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static File a(File file) {
        return new File(file.getPath() + ".bak");
    }

    private static final class a implements b {
        private static final Object c = new Object();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Map f8534a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        private WeakHashMap<b.InterfaceC1052b, Object> f952a;
        private final File b;

        /* JADX INFO: renamed from: c, reason: collision with other field name */
        private final int f953c;

        /* JADX INFO: renamed from: c, reason: collision with other field name */
        private final File f954c;
        private boolean j = false;

        a(File file, int i, Map map) {
            this.b = file;
            this.f954c = d.a(file);
            this.f953c = i;
            this.f8534a = map == null ? new HashMap() : map;
            this.f952a = new WeakHashMap<>();
        }

        @Override // com.ta.utdid2.b.a.b
        public boolean b() {
            return this.b != null && new File(this.b.getAbsolutePath()).exists();
        }

        public void a(boolean z) {
            synchronized (this) {
                this.j = z;
            }
        }

        public boolean d() {
            boolean z;
            synchronized (this) {
                z = this.j;
            }
            return z;
        }

        public void a(Map map) {
            if (map != null) {
                synchronized (this) {
                    this.f8534a = map;
                }
            }
        }

        @Override // com.ta.utdid2.b.a.b
        public Map<String, ?> getAll() {
            HashMap map;
            synchronized (this) {
                map = new HashMap(this.f8534a);
            }
            return map;
        }

        @Override // com.ta.utdid2.b.a.b
        public String getString(String str, String str2) {
            synchronized (this) {
                String str3 = (String) this.f8534a.get(str);
                if (str3 != null) {
                    str2 = str3;
                }
            }
            return str2;
        }

        @Override // com.ta.utdid2.b.a.b
        public long getLong(String str, long j) {
            synchronized (this) {
                Long l = (Long) this.f8534a.get(str);
                if (l != null) {
                    j = l.longValue();
                }
            }
            return j;
        }

        /* JADX INFO: renamed from: com.ta.utdid2.b.a.d$a$a, reason: collision with other inner class name */
        public final class C1053a implements b.a {
            private final Map<String, Object> b = new HashMap();
            private boolean k = false;

            public C1053a() {
            }

            @Override // com.ta.utdid2.b.a.b.a
            public b.a a(String str, String str2) {
                synchronized (this) {
                    this.b.put(str, str2);
                }
                return this;
            }

            @Override // com.ta.utdid2.b.a.b.a
            public b.a a(String str, int i) {
                synchronized (this) {
                    this.b.put(str, Integer.valueOf(i));
                }
                return this;
            }

            @Override // com.ta.utdid2.b.a.b.a
            public b.a a(String str, long j) {
                synchronized (this) {
                    this.b.put(str, Long.valueOf(j));
                }
                return this;
            }

            @Override // com.ta.utdid2.b.a.b.a
            public b.a a(String str, float f) {
                synchronized (this) {
                    this.b.put(str, Float.valueOf(f));
                }
                return this;
            }

            @Override // com.ta.utdid2.b.a.b.a
            public b.a a(String str, boolean z) {
                synchronized (this) {
                    this.b.put(str, Boolean.valueOf(z));
                }
                return this;
            }

            @Override // com.ta.utdid2.b.a.b.a
            public b.a a(String str) {
                synchronized (this) {
                    this.b.put(str, this);
                }
                return this;
            }

            @Override // com.ta.utdid2.b.a.b.a
            public b.a b() {
                synchronized (this) {
                    this.k = true;
                }
                return this;
            }

            @Override // com.ta.utdid2.b.a.b.a
            public boolean commit() {
                boolean z;
                ArrayList arrayList;
                HashSet<b.InterfaceC1052b> hashSet;
                boolean zE;
                synchronized (d.b) {
                    z = a.this.f952a.size() > 0;
                    if (z) {
                        arrayList = new ArrayList();
                        hashSet = new HashSet(a.this.f952a.keySet());
                    } else {
                        arrayList = null;
                        hashSet = null;
                    }
                    synchronized (this) {
                        if (this.k) {
                            a.this.f8534a.clear();
                            this.k = false;
                        }
                        for (Map.Entry<String, Object> entry : this.b.entrySet()) {
                            String key = entry.getKey();
                            Object value = entry.getValue();
                            if (value == this) {
                                a.this.f8534a.remove(key);
                            } else {
                                a.this.f8534a.put(key, value);
                            }
                            if (z) {
                                arrayList.add(key);
                            }
                        }
                        this.b.clear();
                    }
                    zE = a.this.e();
                    if (zE) {
                        a.this.a(true);
                    }
                }
                if (z) {
                    for (int size = arrayList.size() - 1; size >= 0; size--) {
                        String str = (String) arrayList.get(size);
                        for (b.InterfaceC1052b interfaceC1052b : hashSet) {
                            if (interfaceC1052b != null) {
                                interfaceC1052b.a(a.this, str);
                            }
                        }
                    }
                }
                return zE;
            }
        }

        @Override // com.ta.utdid2.b.a.b
        public b.a a() {
            return new C1053a();
        }

        private FileOutputStream a(File file) {
            try {
                return new FileOutputStream(file);
            } catch (FileNotFoundException unused) {
                if (!file.getParentFile().mkdir()) {
                    return null;
                }
                try {
                    return new FileOutputStream(file);
                } catch (FileNotFoundException unused2) {
                    return null;
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean e() {
            if (this.b.exists()) {
                if (!this.f954c.exists()) {
                    if (!this.b.renameTo(this.f954c)) {
                        return false;
                    }
                } else {
                    this.b.delete();
                }
            }
            try {
                FileOutputStream fileOutputStreamA = a(this.b);
                if (fileOutputStreamA == null) {
                    return false;
                }
                e.a(this.f8534a, fileOutputStreamA);
                fileOutputStreamA.close();
                this.f954c.delete();
                return true;
            } catch (Exception unused) {
                if (this.b.exists()) {
                    this.b.delete();
                }
                return false;
            }
        }
    }
}
