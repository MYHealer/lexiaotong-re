package com.opos.mobad.service.tasks;

import android.app.ActivityManager;
import android.content.Context;
import android.os.StatFs;
import android.provider.Settings;
import com.omes.scorpion.OmasStub;
import com.opos.mobad.provider.record.CookieData;
import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static CookieData f7390a = null;
    private static String b = "";
    private static final FileFilter c = new FileFilter() { // from class: com.opos.mobad.service.tasks.a.1
        @Override // java.io.FileFilter
        public boolean accept(File file) {
            return OmasStub.omasBoolean(2, new Object[]{this, file});
        }
    };

    /* JADX INFO: renamed from: com.opos.mobad.service.tasks.a$a, reason: collision with other inner class name */
    public interface InterfaceC0997a {
        boolean a();

        boolean b();

        boolean c();

        boolean d();

        boolean e();

        String f();
    }

    public static final ActivityManager.MemoryInfo a(Context context) {
        return (ActivityManager.MemoryInfo) OmasStub.omasObject(7, new Object[]{context});
    }

    public static final StatFs a() {
        return (StatFs) OmasStub.omasObject(8, new Object[0]);
    }

    private static CookieData a(Context context, InterfaceC0997a interfaceC0997a) {
        return (CookieData) OmasStub.omasObject(9, new Object[]{context, interfaceC0997a});
    }

    public static final String a(float[][] fArr) {
        return (String) OmasStub.omasObject(10, new Object[]{fArr});
    }

    public static HashMap<String, String> a(Context context, boolean z, int i, InterfaceC0997a interfaceC0997a) {
        return (HashMap) OmasStub.omasObject(11, new Object[]{context, Boolean.valueOf(z), Integer.valueOf(i), interfaceC0997a});
    }

    public static final void a(Context context, HashMap<String, String> map) {
        OmasStub.omasVoid(12, new Object[]{context, map});
    }

    public static final void a(Context context, Map<String, String> map, InterfaceC0997a interfaceC0997a) {
        OmasStub.omasVoid(13, new Object[]{context, map, interfaceC0997a});
    }

    private static final boolean a(String str) {
        return OmasStub.omasBoolean(14, new Object[]{str});
    }

    public static final int b(Context context) {
        return OmasStub.omasInt(15, new Object[]{context});
    }

    public static final long b() {
        return OmasStub.omasLong(16, new Object[0]);
    }

    private static CookieData b(Context context, InterfaceC0997a interfaceC0997a) throws NoSuchAlgorithmException {
        return (CookieData) OmasStub.omasObject(17, new Object[]{context, interfaceC0997a});
    }

    public static final int c() {
        return OmasStub.omasInt(18, new Object[0]);
    }

    public static final String c(Context context) {
        return (String) OmasStub.omasObject(19, new Object[]{context});
    }

    private static String c(Context context, InterfaceC0997a interfaceC0997a) {
        return (String) OmasStub.omasObject(20, new Object[]{context, interfaceC0997a});
    }

    private static final boolean d() throws IOException {
        return OmasStub.omasBoolean(21, new Object[0]);
    }

    private static final boolean d(Context context) {
        return OmasStub.omasBoolean(22, new Object[]{context});
    }

    private static final boolean e(Context context) {
        return OmasStub.omasBoolean(23, new Object[]{context});
    }

    private static final boolean f(Context context) {
        return OmasStub.omasBoolean(24, new Object[]{context});
    }

    private static String g(Context context) {
        return (String) OmasStub.omasObject(25, new Object[]{context});
    }

    private static String h(Context context) {
        return (String) OmasStub.omasObject(26, new Object[]{context});
    }

    private static String i(Context context) {
        return (String) OmasStub.omasObject(27, new Object[]{context});
    }

    private static final int j(Context context) throws Settings.SettingNotFoundException {
        return OmasStub.omasInt(28, new Object[]{context});
    }
}
