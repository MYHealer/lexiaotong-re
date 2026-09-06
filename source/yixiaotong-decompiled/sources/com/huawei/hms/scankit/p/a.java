package com.huawei.hms.scankit.p;

/* JADX INFO: compiled from: AIScanException.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class a extends Exception {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected static final boolean f4209a;
    protected static final StackTraceElement[] b;
    private static final a c;

    static {
        f4209a = System.getProperty("surefire.test.class.path") != null;
        StackTraceElement[] stackTraceElementArr = new StackTraceElement[0];
        b = stackTraceElementArr;
        a aVar = new a();
        c = aVar;
        aVar.setStackTrace(stackTraceElementArr);
    }

    private a() {
    }

    public static a a() {
        return f4209a ? new a() : c;
    }

    private a(String str) {
        super(str);
    }

    public static a a(String str) {
        return new a(str);
    }
}
