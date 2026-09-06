package com.gnete.upbc.cashier.c;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Log;
import com.gnete.upbc.cashier.GnetePayChannel;
import com.gnete.upbc.cashier.b.b;
import com.gnete.upbc.cashier.b.e;
import com.gnete.upbc.cashier.b.g;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: CashierCrashHandler.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public class a implements Thread.UncaughtExceptionHandler {
    private static a e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private WeakReference<Context> f3280a;
    private Thread.UncaughtExceptionHandler b;
    private b c;
    private boolean d = false;

    private a() {
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
        Log.e("a", th.getMessage(), th);
        a(th);
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.b;
        if (uncaughtExceptionHandler != null) {
            uncaughtExceptionHandler.uncaughtException(thread, th);
        }
        b();
    }

    public static a a() {
        if (e == null) {
            e = new a();
        }
        return e;
    }

    public void a(Context context, b bVar) {
        this.f3280a = new WeakReference<>(context);
        this.b = Thread.getDefaultUncaughtExceptionHandler();
        Thread.setDefaultUncaughtExceptionHandler(this);
        this.c = bVar;
        this.d = true;
    }

    public void b() {
        if (this.d) {
            Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.b;
            if (uncaughtExceptionHandler != null) {
                Thread.setDefaultUncaughtExceptionHandler(uncaughtExceptionHandler);
            }
            this.b = null;
            this.c = null;
            this.d = false;
        }
    }

    private void a(Throwable th) {
        SharedPreferences sharedPreferencesA = a(this.f3280a.get());
        if (sharedPreferencesA == null) {
            return;
        }
        String strE = new e.a(this.f3280a.get()).a(g.CRASH).a(this.c.f()).a(String.format("崩溃异常[%s]", th.getMessage())).a(th).e();
        SharedPreferences.Editor editorEdit = sharedPreferencesA.edit();
        editorEdit.clear();
        editorEdit.putString("chnlUrl", this.c.c()).putString("payChannel", this.c.f().name()).putString("logInf", strE);
        editorEdit.commit();
    }

    public void b(Context context) {
        SharedPreferences sharedPreferencesA = a(context);
        if (sharedPreferencesA == null || sharedPreferencesA.getAll().isEmpty()) {
            return;
        }
        String string = sharedPreferencesA.getString("chnlUrl", "");
        String string2 = sharedPreferencesA.getString("payChannel", "");
        String string3 = sharedPreferencesA.getString("logInf", "");
        b bVarA = b.a(string);
        if (!TextUtils.isEmpty(string2)) {
            bVarA.a(GnetePayChannel.valueOf(string2));
        }
        bVarA.b(new e.a(string3).a());
        com.gnete.upbc.cashier.a.g.c(bVarA).a(null);
        SharedPreferences.Editor editorEdit = sharedPreferencesA.edit();
        editorEdit.clear();
        editorEdit.apply();
    }

    private SharedPreferences a(Context context) {
        if (context == null) {
            return null;
        }
        return context.getSharedPreferences("GnetePayPluginLog", 0);
    }
}
