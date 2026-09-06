package com.byazt.nys;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.SharedPreferences;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, 430, 20})
public class c extends ContextWrapper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public File f2539a;
    public final Object c;
    public File n;
    public File sp;
    public File tt;
    public File uj;
    public File ve;
    public File x;

    public String c() {
        return "pangle_com.byted.pangle";
    }

    public c(Context context) {
        super(context);
        this.c = new Object();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public File getDataDir() {
        File fileC;
        if (c() == null) {
            return super.getDataDir();
        }
        synchronized (this.c) {
            if (this.tt == null) {
                this.tt = new File(tt(), c());
            }
            fileC = c(this.tt);
        }
        return fileC;
    }

    public File tt() {
        return super.getFilesDir().getParentFile();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public File getFilesDir() {
        File fileC;
        if (c() == null) {
            return super.getFilesDir();
        }
        synchronized (this.c) {
            if (this.ve == null) {
                this.ve = new File(super.getFilesDir(), c());
            }
            fileC = c(this.ve);
        }
        return fileC;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public FileInputStream openFileInput(String str) throws FileNotFoundException {
        if (c() == null) {
            return super.openFileInput(str);
        }
        return new FileInputStream(c(getFilesDir(), str));
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public FileOutputStream openFileOutput(String str, int i) throws FileNotFoundException {
        if (i != 0 || c() == null) {
            return super.openFileOutput(str, i);
        }
        return new FileOutputStream(c(getFilesDir(), str), false);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public boolean deleteFile(String str) {
        return c(getFilesDir(), str).delete();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public File getNoBackupFilesDir() {
        File fileC;
        if (c() == null) {
            return super.getNoBackupFilesDir();
        }
        synchronized (this.c) {
            if (this.uj == null) {
                this.uj = new File(super.getNoBackupFilesDir(), c());
            }
            fileC = c(this.uj);
        }
        return fileC;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public File getExternalFilesDir(String str) {
        if (c() == null) {
            return super.getExternalFilesDir(str);
        }
        return c(new File(super.getExternalFilesDir(str), c()));
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public File[] getExternalFilesDirs(String str) {
        if (c() == null) {
            return super.getExternalFilesDirs(str);
        }
        File[] externalFilesDirs = super.getExternalFilesDirs(str);
        File[] fileArr = new File[externalFilesDirs.length];
        for (int i = 0; i < externalFilesDirs.length; i++) {
            fileArr[i] = c(new File(externalFilesDirs[i], c()));
        }
        return fileArr;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public File getObbDir() {
        File fileC;
        if (c() == null) {
            return super.getObbDir();
        }
        synchronized (this.c) {
            if (this.n == null) {
                this.n = new File(super.getObbDir(), c());
            }
            fileC = c(this.n);
        }
        return fileC;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public File[] getObbDirs() {
        if (c() == null) {
            return super.getObbDirs();
        }
        File[] obbDirs = super.getObbDirs();
        File[] fileArr = new File[obbDirs.length];
        for (int i = 0; i < obbDirs.length; i++) {
            fileArr[i] = c(new File(obbDirs[i], c()));
        }
        return fileArr;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public File getCacheDir() {
        File fileC;
        if (c() == null) {
            return super.getCacheDir();
        }
        synchronized (this.c) {
            if (this.f2539a == null) {
                this.f2539a = new File(super.getCacheDir(), c());
            }
            fileC = c(this.f2539a);
        }
        return fileC;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public File getCodeCacheDir() {
        File fileC;
        if (c() == null) {
            return super.getCodeCacheDir();
        }
        synchronized (this.c) {
            if (this.sp == null) {
                this.sp = new File(super.getCodeCacheDir(), c());
            }
            fileC = c(this.sp);
        }
        return fileC;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public File getExternalCacheDir() {
        File fileC;
        if (c() == null) {
            return super.getExternalCacheDir();
        }
        synchronized (this.c) {
            if (this.x == null) {
                this.x = new File(super.getExternalCacheDir(), c());
            }
            fileC = c(this.x);
        }
        return fileC;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public File[] getExternalCacheDirs() {
        if (c() == null) {
            return super.getExternalCacheDirs();
        }
        File[] externalCacheDirs = super.getExternalCacheDirs();
        File[] fileArr = new File[externalCacheDirs.length];
        for (int i = 0; i < externalCacheDirs.length; i++) {
            fileArr[i] = c(new File(externalCacheDirs[i], c()));
        }
        return fileArr;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public File[] getExternalMediaDirs() {
        if (c() == null) {
            return super.getExternalMediaDirs();
        }
        File[] externalMediaDirs = super.getExternalMediaDirs();
        File[] fileArr = new File[externalMediaDirs.length];
        for (int i = 0; i < externalMediaDirs.length; i++) {
            fileArr[i] = c(new File(externalMediaDirs[i], c()));
        }
        return fileArr;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public File getDir(String str, int i) {
        if (i != 0 || c() == null) {
            return super.getDir(str, i);
        }
        return c(new File(super.getDir(str, i), c()));
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public SharedPreferences getSharedPreferences(String str, int i) {
        if (i != 0 || c() == null) {
            return super.getSharedPreferences(str, i);
        }
        return super.getSharedPreferences(c(str), i);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public boolean deleteSharedPreferences(String str) {
        if (c() == null) {
            return super.deleteSharedPreferences(str);
        }
        return super.deleteSharedPreferences(c(str));
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public SQLiteDatabase openOrCreateDatabase(String str, int i, SQLiteDatabase.CursorFactory cursorFactory) {
        if (i != 0 || c() == null) {
            return super.openOrCreateDatabase(str, i, cursorFactory);
        }
        return super.openOrCreateDatabase(c(str), i, cursorFactory);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public SQLiteDatabase openOrCreateDatabase(String str, int i, SQLiteDatabase.CursorFactory cursorFactory, DatabaseErrorHandler databaseErrorHandler) {
        if (i != 0 || c() == null) {
            return super.openOrCreateDatabase(str, i, cursorFactory, databaseErrorHandler);
        }
        return super.openOrCreateDatabase(c(str), i, cursorFactory, databaseErrorHandler);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public boolean moveDatabaseFrom(Context context, String str) {
        if (c() == null) {
            return super.moveDatabaseFrom(context, str);
        }
        throw new UnsupportedOperationException("Calling moveDatabaseFrom in plugins is not supported.");
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public boolean deleteDatabase(String str) {
        if (c() == null) {
            return super.deleteDatabase(str);
        }
        return super.deleteDatabase(c(str));
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public File getDatabasePath(String str) {
        if (c() == null) {
            return super.getDatabasePath(str);
        }
        return super.getDatabasePath(c(str));
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public String[] databaseList() {
        if (c() == null) {
            return super.databaseList();
        }
        String[] strArrDatabaseList = super.databaseList();
        int length = strArrDatabaseList.length;
        boolean[] zArr = new boolean[length];
        int i = 0;
        for (int i2 = 0; i2 < strArrDatabaseList.length; i2++) {
            if (strArrDatabaseList[i2].startsWith(c())) {
                zArr[i2] = true;
                i++;
            } else {
                zArr[i2] = false;
            }
        }
        String[] strArr = new String[i];
        int i3 = 0;
        for (int i4 = 0; i4 < length; i4++) {
            if (zArr[i4]) {
                strArr[i3] = strArrDatabaseList[i4];
                i3++;
            }
        }
        return strArr;
    }

    private String c(String str) {
        return c() + "_" + str;
    }

    private static File c(File file) {
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    private static File c(File file, String str) {
        if (str.indexOf(File.separatorChar) < 0) {
            return new File(file, str);
        }
        throw new IllegalArgumentException("File " + str + " contains a path separator");
    }
}
