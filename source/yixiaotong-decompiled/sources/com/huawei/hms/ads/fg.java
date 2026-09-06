package com.huawei.hms.ads;

import android.text.TextUtils;
import android.util.Log;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public final class fg extends ff {
    private static final long I = 4194304;
    private static final String V = "FileLogNode";
    private File Z;

    private fg() {
    }

    public static fm Code() {
        return new fk(new fg());
    }

    private static void Code(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
                Log.w(V, "Exception when closing the closeable.");
            }
        }
    }

    private void Code(String str) throws Throwable {
        if (str == null || this.Z == null) {
            return;
        }
        String str2 = str + '\n';
        if (V(str2)) {
            I(str2);
        }
    }

    private void I(String str) throws Throwable {
        FileOutputStream fileOutputStream;
        BufferedOutputStream bufferedOutputStream;
        OutputStreamWriter outputStreamWriter = null;
        try {
            try {
                fileOutputStream = new FileOutputStream(this.Z, true);
                try {
                    bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
                    try {
                        OutputStreamWriter outputStreamWriter2 = new OutputStreamWriter(bufferedOutputStream, "UTF-8");
                        try {
                            outputStreamWriter2.write(str);
                            outputStreamWriter2.flush();
                            Code(outputStreamWriter2);
                        } catch (FileNotFoundException unused) {
                            outputStreamWriter = outputStreamWriter2;
                            Log.w(V, "Exception when writing the log file.");
                            Code(outputStreamWriter);
                        } catch (IOException unused2) {
                            outputStreamWriter = outputStreamWriter2;
                            Log.w(V, "Exception when writing the log file.");
                            Code(outputStreamWriter);
                        } catch (Throwable th) {
                            th = th;
                            outputStreamWriter = outputStreamWriter2;
                            Code(outputStreamWriter);
                            Code(bufferedOutputStream);
                            Code(fileOutputStream);
                            throw th;
                        }
                    } catch (FileNotFoundException | IOException unused3) {
                    }
                } catch (FileNotFoundException unused4) {
                    bufferedOutputStream = null;
                } catch (IOException unused5) {
                    bufferedOutputStream = null;
                } catch (Throwable th2) {
                    th = th2;
                    bufferedOutputStream = null;
                }
            } catch (Throwable th3) {
                th = th3;
            }
        } catch (FileNotFoundException unused6) {
            fileOutputStream = null;
            bufferedOutputStream = null;
        } catch (IOException unused7) {
            fileOutputStream = null;
            bufferedOutputStream = null;
        } catch (Throwable th4) {
            th = th4;
            fileOutputStream = null;
            bufferedOutputStream = null;
        }
        Code(bufferedOutputStream);
        Code(fileOutputStream);
    }

    private boolean V(String str) {
        String str2;
        if (this.Z.length() + ((long) str.length()) <= I) {
            return true;
        }
        File file = new File(this.Z.getPath() + ".bak");
        if (file.exists() && !file.delete()) {
            str2 = "Cannot rename log file to bak.";
        } else {
            if (this.Z.renameTo(file)) {
                return true;
            }
            str2 = "Failed to backup the log file.";
        }
        Log.w(V, str2);
        return false;
    }

    @Override // com.huawei.hms.ads.fm
    public fm Code(String str, String str2) {
        String str3;
        if (str2 == null || str2.isEmpty()) {
            Log.e(V, "Failed to initialize the file logger, parameter error.");
            return this;
        }
        if (this.Z == null) {
            try {
                if (!TextUtils.isEmpty(str)) {
                    File canonicalFile = new File(str, "Log").getCanonicalFile();
                    if (canonicalFile.isDirectory() || com.huawei.openalliance.ad.utils.u.Code(canonicalFile)) {
                        File file = new File(canonicalFile, str2 + ".log");
                        this.Z = file;
                        file.setReadable(true);
                        this.Z.setWritable(true);
                        this.Z.setExecutable(false, false);
                        return this;
                    }
                }
            } catch (IOException unused) {
                str3 = "file path error. ioex";
                Log.e(V, str3);
            } catch (Throwable th) {
                str3 = "file path error. " + th.getClass().getSimpleName();
                Log.e(V, str3);
            }
        }
        Log.w(V, "the file logger has been created already.");
        return this;
    }

    @Override // com.huawei.hms.ads.fm
    public void Code(fo foVar, int i, String str) throws Throwable {
        if (foVar == null) {
            return;
        }
        Code(foVar.Code() + foVar.V());
        if (this.Code != null) {
            this.Code.Code(foVar, i, str);
        }
    }
}
