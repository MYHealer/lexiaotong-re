package com.miui.zeus.landingpage.sdk;

import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Set<OnAppLaunchListener> f5269a;

    /* JADX INFO: renamed from: com.miui.zeus.landingpage.sdk.a$a, reason: collision with other inner class name */
    public static /* synthetic */ class C0856a {
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f5270a = new a(null);
    }

    public a() {
        this.f5269a = new CopyOnWriteArraySet();
    }

    public /* synthetic */ a(C0856a c0856a) {
        this();
    }

    public static a a() {
        return b.f5270a;
    }

    public void a(OnAppLaunchListener onAppLaunchListener) {
        this.f5269a.add(onAppLaunchListener);
    }

    public Set<OnAppLaunchListener> b() {
        return this.f5269a;
    }

    public void b(OnAppLaunchListener onAppLaunchListener) {
        this.f5269a.remove(onAppLaunchListener);
    }
}
