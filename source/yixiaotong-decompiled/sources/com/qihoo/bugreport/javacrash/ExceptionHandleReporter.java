package com.qihoo.bugreport.javacrash;

import android.content.Context;
import android.content.SharedPreferences;
import com.qihoo.jiagu.b;
import com.qihoo.jiagu.c;
import com.qihoo.jiagu.e;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.EnumMap;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\93504.dex */
public class ExceptionHandleReporter implements Thread.UncaughtExceptionHandler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static ExceptionHandleReporter f8450a;
    private final Thread.UncaughtExceptionHandler b = Thread.getDefaultUncaughtExceptionHandler();
    private final Context c;
    private final CrashReportDataFactory d;
    private final Thread.UncaughtExceptionHandler e;

    private ExceptionHandleReporter(Context context, Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
        this.c = context;
        this.e = uncaughtExceptionHandler;
        this.d = new CrashReportDataFactory(this.c, new GregorianCalendar());
        Thread.setDefaultUncaughtExceptionHandler(this);
    }

    public static synchronized ExceptionHandleReporter a(Context context, Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
        if (f8450a == null) {
            f8450a = new ExceptionHandleReporter(context, uncaughtExceptionHandler);
        }
        return f8450a;
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
        uncaughtException(thread, th, false, 0);
    }

    public void uncaughtException(Thread thread, Throwable th, boolean z) {
        uncaughtException(thread, th, z, 2);
    }

    public void uncaughtException(Thread thread, Throwable th, boolean z, int i) {
        boolean z2 = false;
        try {
            String[] strArr = b.f8453a;
            Context context = this.c;
            int length = strArr.length;
            int i2 = 0;
            while (true) {
                if (i2 < length) {
                    if (!c.a(context, strArr[i2])) {
                        break;
                    } else {
                        i2++;
                    }
                } else {
                    z2 = true;
                    break;
                }
            }
            if (!z2) {
                a(thread, th, z);
                return;
            }
            CrashReportDataFactory crashReportDataFactory = this.d;
            EnumMap enumMap = new EnumMap(ReportField.class);
            enumMap.put(ReportField.t, "1");
            enumMap.put(ReportField.cpv, "3");
            enumMap.put(ReportField.st, CrashReportDataFactory.a(crashReportDataFactory.f8449a));
            enumMap.put(ReportField.ct, CrashReportDataFactory.a(new GregorianCalendar()));
            String name = th.getClass().getName();
            enumMap.put(ReportField.et, name);
            String message = th.getMessage();
            enumMap.put(ReportField.ec, message);
            enumMap.put(ReportField.jc, String.valueOf(i));
            ArrayList<String> arrayListA = CrashReportDataFactory.a(th);
            String strA = crashReportDataFactory.a(name, message, arrayListA);
            if (strA != null) {
                enumMap.put(ReportField.me, strA);
            }
            StringWriter stringWriter = new StringWriter();
            PrintWriter printWriter = new PrintWriter(stringWriter);
            th.printStackTrace(printWriter);
            String string = stringWriter.toString();
            printWriter.close();
            String strA2 = CrashReportDataFactory.a(string);
            if (strA2 == null) {
                enumMap.put(ReportField.crd, "null");
            } else {
                enumMap.put(ReportField.crd, strA2);
            }
            String strA3 = CrashReportDataFactory.a(string, arrayListA);
            if (strA3 != null) {
                enumMap.put(ReportField.em, strA3);
            }
            String strC = CrashReportDataFactory.c();
            if (strC != null) {
                enumMap.put(ReportField.ep, strC);
            }
            HashMap<String, String> mapA = CrashReportDataFactory.a();
            if (mapA.get("ed") != null) {
                enumMap.put(ReportField.ed, mapA.get("ed"));
            }
            if (mapA.get("epd") != null) {
                enumMap.put(ReportField.epd, mapA.get("epd"));
            }
            JSONObject jSONObjectA = c.a((EnumMap<ReportField, String>) enumMap, crashReportDataFactory.b());
            if (jSONObjectA == null) {
                a(thread, th, z);
                return;
            }
            jSONObjectA.toString();
            synchronized (ExceptionHandleReporter.class) {
                if (a(jSONObjectA, th)) {
                    a(thread, th, z);
                } else {
                    e eVar = new e(this, z, jSONObjectA);
                    eVar.start();
                    eVar.join(4000L);
                    a(thread, th, z);
                }
            }
        } catch (Throwable th2) {
            a(thread, th, z);
        }
    }

    private synchronized boolean a(JSONObject jSONObject, Throwable th) {
        boolean z;
        long time;
        if (!jSONObject.has(ReportField.me.name()) || !jSONObject.has(ReportField.ct.name())) {
            z = true;
        } else {
            SharedPreferences sharedPreferences = this.c.getSharedPreferences("qihoo_jiagu_crash_report", 0);
            SharedPreferences.Editor editorEdit = sharedPreferences.edit();
            String string = sharedPreferences.getString("last_report_me", "");
            String string2 = sharedPreferences.getString("last_report_time", "0000/00/00 00:00:00");
            String string3 = sharedPreferences.getString("last_exception_info", "");
            String string4 = Integer.toString(th.hashCode());
            try {
                String string5 = jSONObject.getString(ReportField.me.name());
                String string6 = jSONObject.getString(ReportField.ct.name());
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss", Locale.ENGLISH);
                Date date = simpleDateFormat.parse(string6);
                Date date2 = simpleDateFormat.parse(string2);
                if (date.getTime() - date2.getTime() < 0) {
                    editorEdit.putString("last_report_time", jSONObject.getString(ReportField.ct.name()));
                    editorEdit.commit();
                    z = true;
                } else {
                    if (string.equals(string5) || string4.equals(string3)) {
                        time = (date.getTime() - date2.getTime()) - 600000;
                    } else {
                        time = (date.getTime() - date2.getTime()) - 120000;
                    }
                    if (time < 0) {
                        z = true;
                    } else {
                        editorEdit.putString("last_report_me", jSONObject.getString(ReportField.me.name()));
                        editorEdit.putString("last_report_time", jSONObject.getString(ReportField.ct.name()));
                        editorEdit.putString("last_exception_info", string4);
                        editorEdit.commit();
                        z = false;
                    }
                }
            } catch (ParseException e) {
                z = true;
            } catch (JSONException e2) {
                z = true;
            }
        }
        return z;
    }

    private void a(Thread thread, Throwable th, boolean z) {
        if (!z) {
            try {
                if (this.b != null) {
                    this.b.uncaughtException(thread, th);
                } else {
                    b(thread, th, z);
                }
            } catch (Throwable th2) {
                b(thread, th, z);
            }
        }
    }

    private void b(Thread thread, Throwable th, boolean z) {
        if (!z) {
            try {
                if (this.e != null) {
                    this.e.uncaughtException(thread, th);
                }
            } catch (Throwable th2) {
            }
        }
    }
}
