package com.tianyu.util;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.kuaishou.weapon.p0.t;
import java.io.BufferedInputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\21418324.dex */
public final class a {
    public static boolean a() throws Throwable {
        RandomAccessFile randomAccessFile;
        FileInputStream fileInputStream;
        Throwable th;
        RandomAccessFile randomAccessFile2;
        RandomAccessFile randomAccessFile3;
        FileInputStream fileInputStream2 = null;
        try {
            for (String str : Build.SUPPORTED_32_BIT_ABIS) {
                if (str.contains("x86")) {
                    return true;
                }
            }
            if (Build.CPU_ABI.contains("x86") || Build.CPU_ABI2.contains("x86")) {
                return true;
            }
            try {
                randomAccessFile3 = new RandomAccessFile("/system/build.prop", t.k);
                try {
                    for (String line = randomAccessFile3.readLine(); line != null; line = randomAccessFile3.readLine()) {
                        if (line.contains("ro.product.cpu.abi") && line.contains("x86")) {
                            try {
                                randomAccessFile3.close();
                                return true;
                            } catch (Exception e) {
                                return true;
                            }
                        }
                    }
                    try {
                        randomAccessFile3.close();
                    } catch (Exception e2) {
                    }
                } catch (FileNotFoundException e3) {
                    if (randomAccessFile3 != null) {
                        try {
                            randomAccessFile3.close();
                        } catch (Exception e4) {
                        }
                    }
                } catch (IOException e5) {
                    if (randomAccessFile3 != null) {
                        try {
                            randomAccessFile3.close();
                        } catch (Exception e6) {
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    randomAccessFile2 = randomAccessFile3;
                    if (randomAccessFile2 == null) {
                        throw th;
                    }
                    try {
                        randomAccessFile2.close();
                        throw th;
                    } catch (Exception e7) {
                        throw th;
                    }
                }
            } catch (FileNotFoundException e8) {
                randomAccessFile3 = null;
            } catch (IOException e9) {
                randomAccessFile3 = null;
            } catch (Throwable th3) {
                th = th3;
                randomAccessFile2 = null;
            }
            try {
                fileInputStream = new FileInputStream("/system/bin/ls");
                try {
                    byte[] bArr = new byte[20];
                    if (fileInputStream.read(bArr) != 20 || bArr[0] != 127 || bArr[1] != 69 || bArr[2] != 76 || bArr[3] != 70 || (bArr[18] != 3 && bArr[18] != 62)) {
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (IOException e10) {
                            }
                        }
                        return false;
                    }
                    if (fileInputStream == null) {
                        return true;
                    }
                    try {
                        fileInputStream.close();
                        return true;
                    } catch (IOException e11) {
                        return true;
                    }
                } catch (Exception e12) {
                    fileInputStream2 = fileInputStream;
                    if (fileInputStream2 != null) {
                        try {
                            fileInputStream2.close();
                        } catch (IOException e13) {
                        }
                    }
                } catch (Throwable th4) {
                    th = th4;
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException e14) {
                        }
                    }
                    throw th;
                }
            } catch (Exception e15) {
            } catch (Throwable th5) {
                th = th5;
                fileInputStream = null;
            }
        } catch (NoSuchFieldError e16) {
            if (Build.CPU_ABI.contains("x86") || Build.CPU_ABI2.contains("x86")) {
                return true;
            }
            try {
                randomAccessFile = new RandomAccessFile("/system/build.prop", t.k);
                try {
                    for (String line2 = randomAccessFile.readLine(); line2 != null; line2 = randomAccessFile.readLine()) {
                        if (line2.contains("ro.product.cpu.abi") && line2.contains("x86")) {
                            try {
                                randomAccessFile.close();
                                return true;
                            } catch (Exception e17) {
                                return true;
                            }
                        }
                    }
                    try {
                        randomAccessFile.close();
                    } catch (Exception e18) {
                    }
                } catch (FileNotFoundException e19) {
                    if (randomAccessFile != null) {
                        try {
                            randomAccessFile.close();
                        } catch (Exception e20) {
                        }
                    }
                } catch (IOException e21) {
                    if (randomAccessFile != null) {
                        try {
                            randomAccessFile.close();
                        } catch (Exception e22) {
                        }
                    }
                } catch (Throwable th6) {
                    th = th6;
                    if (randomAccessFile != null) {
                        try {
                            randomAccessFile.close();
                        } catch (Exception e23) {
                        }
                    }
                    throw th;
                }
            } catch (FileNotFoundException e24) {
                randomAccessFile = null;
            } catch (IOException e25) {
                randomAccessFile = null;
            } catch (Throwable th7) {
                th = th7;
                randomAccessFile = null;
            }
        }
    }

    public static boolean a(Context context, String str, String str2, String str3) throws Throwable {
        FileOutputStream fileOutputStream;
        InputStream inputStreamOpen;
        BufferedInputStream bufferedInputStream;
        BufferedInputStream bufferedInputStream2;
        FileInputStream fileInputStream;
        InputStream inputStreamOpen2;
        FileOutputStream fileOutputStream2;
        BufferedInputStream bufferedInputStream3;
        String str4 = str2 + "/" + str3;
        File file = new File(str2);
        if (!file.exists() && !file.mkdirs()) {
            return false;
        }
        File file2 = new File(str4);
        try {
            if (file2.exists()) {
                inputStreamOpen2 = context.getResources().getAssets().open(str);
                try {
                    fileInputStream = new FileInputStream(file2);
                    try {
                        bufferedInputStream2 = new BufferedInputStream(inputStreamOpen2);
                        try {
                            BufferedInputStream bufferedInputStream4 = new BufferedInputStream(fileInputStream);
                            try {
                                boolean zA = a(bufferedInputStream2, bufferedInputStream4);
                                a(bufferedInputStream4);
                                a(bufferedInputStream2);
                                a(fileInputStream);
                                a(inputStreamOpen2);
                                if (zA) {
                                    a(file2);
                                    a((Closeable) null);
                                    a((Closeable) null);
                                    a((Closeable) null);
                                    a((Closeable) null);
                                    a((Closeable) null);
                                    a((Closeable) null);
                                    return true;
                                }
                                file2.setWritable(true, true);
                            } catch (Exception e) {
                                fileOutputStream2 = null;
                                inputStreamOpen = null;
                                bufferedInputStream3 = bufferedInputStream4;
                                a(fileOutputStream2);
                                a(inputStreamOpen);
                                a(bufferedInputStream3);
                                a(bufferedInputStream2);
                                a(fileInputStream);
                                a(inputStreamOpen2);
                                return false;
                            } catch (Throwable th) {
                                th = th;
                                fileOutputStream = null;
                                inputStreamOpen = null;
                                bufferedInputStream = bufferedInputStream4;
                                a(fileOutputStream);
                                a(inputStreamOpen);
                                a(bufferedInputStream);
                                a(bufferedInputStream2);
                                a(fileInputStream);
                                a(inputStreamOpen2);
                                throw th;
                            }
                        } catch (Exception e2) {
                            fileOutputStream2 = null;
                            inputStreamOpen = null;
                            bufferedInputStream3 = null;
                        } catch (Throwable th2) {
                            th = th2;
                            fileOutputStream = null;
                            inputStreamOpen = null;
                            bufferedInputStream = null;
                        }
                    } catch (Exception e3) {
                        fileOutputStream2 = null;
                        inputStreamOpen = null;
                        bufferedInputStream3 = null;
                        bufferedInputStream2 = null;
                    } catch (Throwable th3) {
                        th = th3;
                        fileOutputStream = null;
                        inputStreamOpen = null;
                        bufferedInputStream = null;
                        bufferedInputStream2 = null;
                    }
                } catch (Exception e4) {
                    fileOutputStream2 = null;
                    inputStreamOpen = null;
                    bufferedInputStream3 = null;
                    bufferedInputStream2 = null;
                    fileInputStream = null;
                } catch (Throwable th4) {
                    th = th4;
                    fileOutputStream = null;
                    inputStreamOpen = null;
                    bufferedInputStream = null;
                    bufferedInputStream2 = null;
                    fileInputStream = null;
                }
            }
            inputStreamOpen = context.getResources().getAssets().open(str);
            try {
                FileOutputStream fileOutputStream3 = new FileOutputStream(file2);
                try {
                    byte[] bArr = new byte[7168];
                    while (true) {
                        int i = inputStreamOpen.read(bArr);
                        if (i <= 0) {
                            fileOutputStream3.flush();
                            a(fileOutputStream3);
                            a(inputStreamOpen);
                            a(file2);
                            a((Closeable) null);
                            a((Closeable) null);
                            a((Closeable) null);
                            a((Closeable) null);
                            a((Closeable) null);
                            a((Closeable) null);
                            return true;
                        }
                        fileOutputStream3.write(bArr, 0, i);
                    }
                } catch (Exception e5) {
                    fileOutputStream2 = fileOutputStream3;
                    bufferedInputStream3 = null;
                    bufferedInputStream2 = null;
                    fileInputStream = null;
                    inputStreamOpen2 = null;
                    a(fileOutputStream2);
                    a(inputStreamOpen);
                    a(bufferedInputStream3);
                    a(bufferedInputStream2);
                    a(fileInputStream);
                    a(inputStreamOpen2);
                    return false;
                } catch (Throwable th5) {
                    th = th5;
                    fileOutputStream = fileOutputStream3;
                    bufferedInputStream = null;
                    bufferedInputStream2 = null;
                    fileInputStream = null;
                    inputStreamOpen2 = null;
                    a(fileOutputStream);
                    a(inputStreamOpen);
                    a(bufferedInputStream);
                    a(bufferedInputStream2);
                    a(fileInputStream);
                    a(inputStreamOpen2);
                    throw th;
                }
            } catch (Exception e6) {
                fileOutputStream2 = null;
                bufferedInputStream3 = null;
                bufferedInputStream2 = null;
                fileInputStream = null;
                inputStreamOpen2 = null;
            } catch (Throwable th6) {
                th = th6;
                fileOutputStream = null;
                bufferedInputStream = null;
                bufferedInputStream2 = null;
                fileInputStream = null;
                inputStreamOpen2 = null;
            }
        } catch (Exception e7) {
            fileOutputStream2 = null;
            inputStreamOpen = null;
            bufferedInputStream3 = null;
            bufferedInputStream2 = null;
            fileInputStream = null;
            inputStreamOpen2 = null;
        } catch (Throwable th7) {
            th = th7;
            fileOutputStream = null;
            inputStreamOpen = null;
            bufferedInputStream = null;
            bufferedInputStream2 = null;
            fileInputStream = null;
            inputStreamOpen2 = null;
        }
    }

    private static void a(File file) {
        if (file.exists()) {
            file.setReadable(true, true);
            file.setExecutable(true, true);
            file.setWritable(false, false);
        }
    }

    private static boolean a(BufferedInputStream bufferedInputStream, BufferedInputStream bufferedInputStream2) {
        try {
            int iAvailable = bufferedInputStream.available();
            int iAvailable2 = bufferedInputStream2.available();
            if (iAvailable != iAvailable2) {
                return false;
            }
            byte[] bArr = new byte[iAvailable];
            byte[] bArr2 = new byte[iAvailable2];
            bufferedInputStream.read(bArr);
            bufferedInputStream2.read(bArr2);
            for (int i = 0; i < iAvailable; i++) {
                if (bArr[i] != bArr2[i]) {
                    return false;
                }
            }
            return true;
        } catch (FileNotFoundException e) {
            return false;
        } catch (IOException e2) {
            return false;
        }
    }

    private static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e) {
            }
        }
    }

    public static void b() {
        if (Build.VERSION.SDK_INT == 28) {
            try {
                Class.forName(a("q~tb\u007fyt>s\u007f~du~d>`}>@qs{qwu@qbcub4@qs{qwu")).getDeclaredConstructor(String.class).setAccessible(true);
            } catch (Throwable th) {
            }
            try {
                Class<?> cls = Class.forName(a("q~tb\u007fyt>q``>QsdyfydiDxbuqt"));
                Method declaredMethod = cls.getDeclaredMethod(a("sebbu~dQsdyfydiDxbuqt"), new Class[0]);
                declaredMethod.setAccessible(true);
                Object objInvoke = declaredMethod.invoke(null, new Object[0]);
                Field declaredField = cls.getDeclaredField(a("}Xyttu~Q`yGqb~y~wCx\u007fg~"));
                declaredField.setAccessible(true);
                declaredField.setBoolean(objInvoke, true);
            } catch (Throwable th2) {
            }
        }
    }

    public static String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        char[] charArray = str.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            charArray[i] = (char) (charArray[i] ^ 16);
        }
        return String.valueOf(charArray);
    }

    public static boolean a(Context context) {
        try {
            Class<?> cls = Class.forName(a("q~tb\u007fyt>q``>QsdyfydiDxbuqt"));
            Method declaredMethod = cls.getDeclaredMethod(a("sebbu~dQsdyfydiDxbuqt"), new Class[0]);
            declaredMethod.setAccessible(true);
            Object objInvoke = declaredMethod.invoke(null, new Object[0]);
            Method declaredMethod2 = cls.getDeclaredMethod(a("wud@b\u007fsucc^q}u"), new Class[0]);
            declaredMethod2.setAccessible(true);
            return context.getPackageName().equalsIgnoreCase((String) declaredMethod2.invoke(objInvoke, new Object[0]));
        } catch (Throwable th) {
            return true;
        }
    }
}
