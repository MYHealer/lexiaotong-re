package com.ta.utdid2.b.a;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Environment;
import com.ta.utdid2.a.a.g;
import java.io.File;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private SharedPreferences f946a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private b f948a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private d f949a;
    private String b;
    private String c;
    private boolean f;
    private boolean g;
    private boolean h;
    private boolean i;
    private Context mContext;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private SharedPreferences.Editor f8532a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private b.a f947a = null;

    /* JADX WARN: Code duplicated, block: B:60:0x0138  */
    public c(Context context, String str, String str2, boolean z, boolean z2) throws Throwable {
        long j;
        long j2;
        this.g = false;
        this.h = false;
        String externalStorageState = null;
        this.f946a = null;
        this.f948a = null;
        this.f949a = null;
        this.f = z;
        this.i = z2;
        this.b = str2;
        this.c = str;
        this.mContext = context;
        if (context != null) {
            SharedPreferences sharedPreferences = context.getSharedPreferences(str2, 0);
            this.f946a = sharedPreferences;
            j = sharedPreferences.getLong("t", 0L);
        } else {
            j = 0;
        }
        try {
            externalStorageState = Environment.getExternalStorageState();
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (g.m1003a(externalStorageState)) {
            this.h = false;
            this.g = false;
        } else if (externalStorageState.equals("mounted")) {
            this.h = true;
            this.g = true;
        } else if (externalStorageState.equals("mounted_ro")) {
            this.g = true;
            this.h = false;
        } else {
            this.h = false;
            this.g = false;
        }
        if ((!this.g && !this.h) || context == null || g.m1003a(str)) {
            j2 = 0;
        } else {
            d dVarA = a(str);
            this.f949a = dVarA;
            if (dVarA != null) {
                try {
                    b bVarA = dVarA.a(str2, 0);
                    this.f948a = bVarA;
                    j2 = bVarA.getLong("t", 0L);
                    try {
                        if (z2) {
                            long j3 = this.f946a.getLong(com.hihonor.adsdk.base.g.j.e.a.b0, 0L);
                            try {
                                j2 = this.f948a.getLong(com.hihonor.adsdk.base.g.j.e.a.b0, 0L);
                                if (j3 < j2 && j3 > 0) {
                                    a(this.f946a, this.f948a);
                                    this.f948a = this.f949a.a(str2, 0);
                                } else if (j3 > j2 && j2 > 0) {
                                    a(this.f948a, this.f946a);
                                    this.f946a = context.getSharedPreferences(str2, 0);
                                } else if (j3 == 0 && j2 > 0) {
                                    a(this.f948a, this.f946a);
                                    this.f946a = context.getSharedPreferences(str2, 0);
                                } else if ((j2 == 0 && j3 > 0) || j3 == j2) {
                                    a(this.f946a, this.f948a);
                                    this.f948a = this.f949a.a(str2, 0);
                                }
                            } catch (Exception unused) {
                            }
                            j = j3;
                        } else if (j > j2) {
                            a(this.f946a, this.f948a);
                            this.f948a = this.f949a.a(str2, 0);
                        } else if (j < j2) {
                            a(this.f948a, this.f946a);
                            this.f946a = context.getSharedPreferences(str2, 0);
                        } else if (j == j2) {
                            a(this.f946a, this.f948a);
                            this.f948a = this.f949a.a(str2, 0);
                        }
                    } catch (Exception unused2) {
                    }
                } catch (Exception unused3) {
                    j2 = 0;
                }
            } else {
                j2 = 0;
            }
        }
        if (j != j2 || (j == 0 && j2 == 0)) {
            long jCurrentTimeMillis = System.currentTimeMillis();
            boolean z3 = this.i;
            if (!z3 || (z3 && j == 0 && j2 == 0)) {
                SharedPreferences sharedPreferences2 = this.f946a;
                if (sharedPreferences2 != null) {
                    SharedPreferences.Editor editorEdit = sharedPreferences2.edit();
                    editorEdit.putLong(com.hihonor.adsdk.base.g.j.e.a.b0, jCurrentTimeMillis);
                    editorEdit.commit();
                }
                try {
                    b bVar = this.f948a;
                    if (bVar != null) {
                        b.a aVarA = bVar.a();
                        aVarA.a(com.hihonor.adsdk.base.g.j.e.a.b0, jCurrentTimeMillis);
                        aVarA.commit();
                    }
                } catch (Exception unused4) {
                }
            }
        }
    }

    private d a(String str) {
        File fileM1004a = m1004a(str);
        if (fileM1004a == null) {
            return null;
        }
        d dVar = new d(fileM1004a.getAbsolutePath());
        this.f949a = dVar;
        return dVar;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    private File m1004a(String str) {
        File externalStorageDirectory = Environment.getExternalStorageDirectory();
        if (externalStorageDirectory == null) {
            return null;
        }
        File file = new File(String.format("%s%s%s", externalStorageDirectory.getAbsolutePath(), File.separator, str));
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    private void a(SharedPreferences sharedPreferences, b bVar) {
        b.a aVarA;
        if (sharedPreferences == null || bVar == null || (aVarA = bVar.a()) == null) {
            return;
        }
        aVarA.b();
        for (Map.Entry<String, ?> entry : sharedPreferences.getAll().entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            if (value instanceof String) {
                aVarA.a(key, (String) value);
            } else if (value instanceof Integer) {
                aVarA.a(key, ((Integer) value).intValue());
            } else if (value instanceof Long) {
                aVarA.a(key, ((Long) value).longValue());
            } else if (value instanceof Float) {
                aVarA.a(key, ((Float) value).floatValue());
            } else if (value instanceof Boolean) {
                aVarA.a(key, ((Boolean) value).booleanValue());
            }
        }
        try {
            aVarA.commit();
        } catch (Exception unused) {
        }
    }

    private void a(b bVar, SharedPreferences sharedPreferences) {
        SharedPreferences.Editor editorEdit;
        if (bVar == null || sharedPreferences == null || (editorEdit = sharedPreferences.edit()) == null) {
            return;
        }
        editorEdit.clear();
        for (Map.Entry<String, ?> entry : bVar.getAll().entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            if (value instanceof String) {
                editorEdit.putString(key, (String) value);
            } else if (value instanceof Integer) {
                editorEdit.putInt(key, ((Integer) value).intValue());
            } else if (value instanceof Long) {
                editorEdit.putLong(key, ((Long) value).longValue());
            } else if (value instanceof Float) {
                editorEdit.putFloat(key, ((Float) value).floatValue());
            } else if (value instanceof Boolean) {
                editorEdit.putBoolean(key, ((Boolean) value).booleanValue());
            }
        }
        editorEdit.commit();
    }

    private boolean c() throws Throwable {
        b bVar = this.f948a;
        if (bVar == null) {
            return false;
        }
        boolean zB = bVar.b();
        if (!zB) {
            commit();
        }
        return zB;
    }

    private void b() throws Throwable {
        b bVar;
        SharedPreferences sharedPreferences;
        if (this.f8532a == null && (sharedPreferences = this.f946a) != null) {
            this.f8532a = sharedPreferences.edit();
        }
        if (this.h && this.f947a == null && (bVar = this.f948a) != null) {
            this.f947a = bVar.a();
        }
        c();
    }

    public void putString(String str, String str2) throws Throwable {
        if (g.m1003a(str) || str.equals("t")) {
            return;
        }
        b();
        SharedPreferences.Editor editor = this.f8532a;
        if (editor != null) {
            editor.putString(str, str2);
        }
        b.a aVar = this.f947a;
        if (aVar != null) {
            aVar.a(str, str2);
        }
    }

    public void remove(String str) throws Throwable {
        if (g.m1003a(str) || str.equals("t")) {
            return;
        }
        b();
        SharedPreferences.Editor editor = this.f8532a;
        if (editor != null) {
            editor.remove(str);
        }
        b.a aVar = this.f947a;
        if (aVar != null) {
            aVar.a(str);
        }
    }

    /* JADX WARN: Code duplicated, block: B:12:0x0020  */
    public boolean commit() throws Throwable {
        boolean z;
        String externalStorageState;
        Context context;
        long jCurrentTimeMillis = System.currentTimeMillis();
        SharedPreferences.Editor editor = this.f8532a;
        if (editor == null) {
            z = true;
        } else {
            if (!this.i && this.f946a != null) {
                editor.putLong("t", jCurrentTimeMillis);
            }
            if (this.f8532a.commit()) {
                z = true;
            } else {
                z = false;
            }
        }
        if (this.f946a != null && (context = this.mContext) != null) {
            this.f946a = context.getSharedPreferences(this.b, 0);
        }
        try {
            externalStorageState = Environment.getExternalStorageState();
        } catch (Exception e) {
            e.printStackTrace();
            externalStorageState = null;
        }
        if (!g.m1003a(externalStorageState)) {
            if (externalStorageState.equals("mounted")) {
                if (this.f948a == null) {
                    d dVarA = a(this.c);
                    if (dVarA != null) {
                        b bVarA = dVarA.a(this.b, 0);
                        this.f948a = bVarA;
                        if (!this.i) {
                            a(this.f946a, bVarA);
                        } else {
                            a(bVarA, this.f946a);
                        }
                        this.f947a = this.f948a.a();
                    }
                } else {
                    try {
                        b.a aVar = this.f947a;
                        if (aVar != null && !aVar.commit()) {
                            z = false;
                        }
                    } catch (Exception unused) {
                    }
                }
            }
            if (externalStorageState.equals("mounted") || (externalStorageState.equals("mounted_ro") && this.f948a != null)) {
                try {
                    d dVar = this.f949a;
                    if (dVar != null) {
                        this.f948a = dVar.a(this.b, 0);
                    }
                } catch (Exception unused2) {
                }
            }
        }
        return z;
    }

    public String getString(String str) throws Throwable {
        c();
        SharedPreferences sharedPreferences = this.f946a;
        if (sharedPreferences != null) {
            String string = sharedPreferences.getString(str, "");
            if (!g.m1003a(string)) {
                return string;
            }
        }
        b bVar = this.f948a;
        return bVar != null ? bVar.getString(str, "") : "";
    }
}
