package com.adprof.sdk;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import com.facebook.common.util.UriUtil;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public abstract class j9 {
    /* JADX WARN: Code duplicated, block: B:26:0x004d A[Catch: all -> 0x0071, TryCatch #1 {all -> 0x0071, blocks: (B:24:0x0047, B:26:0x004d, B:27:0x0050), top: B:49:0x0047 }] */
    /* JADX WARN: Code duplicated, block: B:27:0x0050 A[Catch: all -> 0x0071, TRY_LEAVE, TryCatch #1 {all -> 0x0071, blocks: (B:24:0x0047, B:26:0x004d, B:27:0x0050), top: B:49:0x0047 }] */
    /* JADX WARN: Code duplicated, block: B:32:0x005d A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:33:0x005f A[Catch: all -> 0x005b, DONT_GENERATE, TRY_LEAVE, TryCatch #6 {all -> 0x005b, blocks: (B:29:0x0057, B:33:0x005f), top: B:59:0x0057 }] */
    /* JADX WARN: Code duplicated, block: B:43:0x007c A[Catch: all -> 0x0078, FINALLY_INSNS, TRY_LEAVE, TryCatch #5 {all -> 0x0078, blocks: (B:39:0x0074, B:43:0x007c), top: B:57:0x0074 }] */
    /* JADX WARN: Code duplicated, block: B:49:0x0047 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:59:0x0057 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    public static Object a(String str) {
        Throwable th;
        FileInputStream fileInputStream;
        File file;
        ObjectInputStream objectInputStream;
        String str2;
        Object object = null;
        try {
            file = new File(str);
            try {
                if (!file.exists()) {
                    return null;
                }
                fileInputStream = new FileInputStream(file);
                try {
                    objectInputStream = new ObjectInputStream(fileInputStream);
                    try {
                        object = objectInputStream.readObject();
                        try {
                            fileInputStream.close();
                            objectInputStream.close();
                        } catch (Throwable th2) {
                            str2 = String.format("close error: %s", th2.getMessage());
                            pk.b(str2);
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        if (file != null) {
                            try {
                                if (file.exists()) {
                                    file.delete();
                                }
                                pk.b("readFromCache error: ", th);
                                if (fileInputStream != null) {
                                    try {
                                        fileInputStream.close();
                                        if (objectInputStream != null) {
                                        }
                                    } catch (Throwable th4) {
                                        str2 = String.format("close error: %s", th4.getMessage());
                                        pk.b(str2);
                                    }
                                } else if (objectInputStream != null) {
                                }
                            } finally {
                                if (fileInputStream != null) {
                                    try {
                                        fileInputStream.close();
                                        if (objectInputStream != null) {
                                            objectInputStream.close();
                                        }
                                    } catch (Throwable th5) {
                                        pk.b(String.format("close error: %s", th5.getMessage()));
                                    }
                                } else if (objectInputStream != null) {
                                    objectInputStream.close();
                                }
                            }
                        } else {
                            pk.b("readFromCache error: ", th);
                            if (fileInputStream != null) {
                                fileInputStream.close();
                                if (objectInputStream != null) {
                                }
                            } else if (objectInputStream != null) {
                            }
                        }
                    }
                } catch (Throwable th6) {
                    th = th6;
                    objectInputStream = null;
                }
                return object;
            } catch (Throwable th7) {
                th = th7;
                fileInputStream = null;
                objectInputStream = null;
            }
        } catch (Throwable th8) {
            th = th8;
            fileInputStream = null;
            file = null;
            objectInputStream = null;
        }
        if (file != null) {
            if (file.exists()) {
                file.delete();
            }
            pk.b("readFromCache error: ", th);
            if (fileInputStream != null) {
                fileInputStream.close();
                if (objectInputStream != null) {
                }
            } else if (objectInputStream != null) {
            }
        } else {
            pk.b("readFromCache error: ", th);
            if (fileInputStream != null) {
                fileInputStream.close();
                if (objectInputStream != null) {
                }
            } else if (objectInputStream != null) {
            }
        }
        return object;
    }

    public static String a(Context context, Uri uri) {
        Cursor cursorQuery;
        int columnIndex;
        String string = null;
        if (uri == null) {
            return null;
        }
        String scheme = uri.getScheme();
        if (scheme == null || UriUtil.LOCAL_FILE_SCHEME.equals(scheme)) {
            return uri.getPath();
        }
        if (!"content".equals(scheme) || (cursorQuery = context.getContentResolver().query(uri, new String[]{"_data"}, null, null, null)) == null) {
            return null;
        }
        if (cursorQuery.moveToFirst() && (columnIndex = cursorQuery.getColumnIndex("_data")) > -1) {
            string = cursorQuery.getString(columnIndex);
        }
        cursorQuery.close();
        return string;
    }

    /* JADX WARN: Code duplicated, block: B:27:0x0068 A[Catch: all -> 0x0064, DONT_GENERATE, TRY_LEAVE, TryCatch #4 {all -> 0x0064, blocks: (B:23:0x0060, B:27:0x0068), top: B:49:0x0060 }] */
    /* JADX WARN: Code duplicated, block: B:37:0x0087 A[Catch: all -> 0x0083, FINALLY_INSNS, TRY_LEAVE, TryCatch #2 {all -> 0x0083, blocks: (B:33:0x007f, B:37:0x0087), top: B:45:0x007f }] */
    public static boolean a(Object obj, String str) {
        ObjectOutputStream objectOutputStream;
        FileOutputStream fileOutputStream = null;
        try {
            File file = new File(str);
            if (!file.getParentFile().exists()) {
                file.getParentFile().mkdirs();
            }
            FileOutputStream fileOutputStream2 = new FileOutputStream(file);
            try {
                objectOutputStream = new ObjectOutputStream(fileOutputStream2);
                try {
                    objectOutputStream.writeObject(obj);
                    pk.a(String.format("writeCache: %s", file.getName()));
                    try {
                        fileOutputStream2.close();
                        objectOutputStream.close();
                    } catch (Throwable th) {
                        pk.b(String.format("close error: %s", th.getMessage()));
                    }
                    return true;
                } catch (Throwable th2) {
                    th = th2;
                    fileOutputStream = fileOutputStream2;
                    try {
                        pk.b("writeToCache2 error: ", th);
                        if (fileOutputStream != null) {
                            try {
                            } catch (Throwable th3) {
                                return false;
                            }
                        }
                        return false;
                    } finally {
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                                if (objectOutputStream != null) {
                                    objectOutputStream.close();
                                }
                            } catch (Throwable th4) {
                                pk.b(String.format("close error: %s", th4.getMessage()));
                            }
                        } else if (objectOutputStream != null) {
                            objectOutputStream.close();
                        }
                    }
                }
            } catch (Throwable th5) {
                th = th5;
                objectOutputStream = null;
            }
        } catch (Throwable th6) {
            th = th6;
            objectOutputStream = null;
        }
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static boolean m658a(String str) {
        try {
            new SecurityManager().checkDelete(str);
            File file = new File(str);
            if (!file.exists() || !file.isFile()) {
                pk.a(String.format("删除单个文件失败：%s不存在！", str));
                return false;
            }
            if (file.delete()) {
                pk.a(String.format("删除单个文件%s成功！", str));
                return true;
            }
            pk.a(String.format("删除单个文件%s失败！", str));
            return false;
        } catch (Throwable th) {
            pk.b("deleteFile error: ", th);
            return false;
        }
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static File[] m659a(String str) {
        File[] fileArrListFiles = new File(str).listFiles();
        if (fileArrListFiles != null) {
            Arrays.sort(fileArrListFiles, new i9());
        }
        return fileArrListFiles;
    }

    public static File[] a(File[] fileArr, int i) {
        if (fileArr == null || fileArr.length == 0) {
            return null;
        }
        pk.a("clearCacheFileByCount files: " + fileArr.length + " c: " + i);
        ArrayList arrayList = new ArrayList(Arrays.asList(fileArr));
        for (int i2 = 0; i2 < fileArr.length && arrayList.size() > i; i2++) {
            File file = fileArr[i2];
            if (file.exists()) {
                file.delete();
                arrayList.remove(file);
                pk.a("file delete " + file.getName());
            }
        }
        return (File[]) arrayList.toArray(new File[0]);
    }
}
