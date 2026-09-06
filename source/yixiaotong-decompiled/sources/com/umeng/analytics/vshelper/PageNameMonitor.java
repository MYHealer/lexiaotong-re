package com.umeng.analytics.vshelper;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class PageNameMonitor implements com.umeng.analytics.vshelper.a {
    private static String currentActivity;
    private static String currentCustomPage;
    private static Object lock = new Object();

    /* JADX INFO: renamed from: com.umeng.analytics.vshelper.PageNameMonitor$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    /* synthetic */ PageNameMonitor(AnonymousClass1 anonymousClass1) {
        this();
    }

    private PageNameMonitor() {
    }

    private static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final PageNameMonitor f9197a = new PageNameMonitor(null);

        private a() {
        }
    }

    public static PageNameMonitor getInstance() {
        return a.f9197a;
    }

    @Override // com.umeng.analytics.vshelper.a
    public void activityResume(String str) {
        synchronized (lock) {
            currentActivity = str;
        }
    }

    @Override // com.umeng.analytics.vshelper.a
    public void activityPause(String str) {
        synchronized (lock) {
            currentActivity = null;
        }
    }

    @Override // com.umeng.analytics.vshelper.a
    public void customPageBegin(String str) {
        synchronized (lock) {
            currentCustomPage = str;
        }
    }

    @Override // com.umeng.analytics.vshelper.a
    public void customPageEnd(String str) {
        synchronized (lock) {
            currentCustomPage = null;
        }
    }

    public String getCurrenPageName() {
        synchronized (lock) {
            String str = currentCustomPage;
            if (str != null) {
                return str;
            }
            String str2 = currentActivity;
            if (str2 != null) {
                return str2;
            }
            return null;
        }
    }
}
