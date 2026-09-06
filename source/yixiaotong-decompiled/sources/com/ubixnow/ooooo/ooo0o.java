package com.ubixnow.ooooo;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import androidx.core.view.InputDeviceCompat;
import com.ubixnow.utils.BaseUtils;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import org.apache.commons.io.IOUtils;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class ooo0o {
    public static String OooO00o(File file) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            FileInputStream fileInputStream = new FileInputStream(file);
            byte[] bArr = new byte[8192];
            while (true) {
                try {
                    try {
                        int i = fileInputStream.read(bArr);
                        if (i <= 0) {
                            break;
                        }
                        messageDigest.update(bArr, 0, i);
                    } catch (Throwable th) {
                        try {
                            fileInputStream.close();
                        } catch (Exception unused) {
                        }
                        throw th;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    try {
                        fileInputStream.close();
                    } catch (Exception unused2) {
                    }
                    return null;
                }
            }
            String strReplace = String.format("%32s", new BigInteger(1, messageDigest.digest()).toString(16)).replace(' ', '0');
            try {
                fileInputStream.close();
            } catch (Exception unused3) {
            }
            return strReplace;
        } catch (NoSuchAlgorithmException | Exception unused4) {
            return null;
        }
    }

    public static String OooO00o(String str) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        byte[] bArrDigest = MessageDigest.getInstance("MD5").digest(str.getBytes("UTF-8"));
        StringBuilder sb = new StringBuilder();
        for (byte b : bArrDigest) {
            sb.append(Integer.toHexString((b & 255) | InputDeviceCompat.SOURCE_ANY).substring(6));
        }
        return sb.toString();
    }

    public static String OooO00o(String str, Context context) throws IOException {
        InputStream inputStreamOpen;
        try {
            inputStreamOpen = context.getAssets().open(str);
            if (inputStreamOpen == null) {
                if (inputStreamOpen != null) {
                    inputStreamOpen.close();
                }
                return "";
            }
            try {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStreamOpen, "UTF-8"));
                StringBuilder sb = new StringBuilder();
                while (true) {
                    String line = bufferedReader.readLine();
                    if (line == null) {
                        String string = sb.toString();
                        inputStreamOpen.close();
                        return string;
                    }
                    sb.append(line).append(IOUtils.LINE_SEPARATOR_UNIX);
                }
            } catch (Throwable th) {
                th = th;
                try {
                    ooooO000.OooO00o(th);
                    return "";
                } finally {
                    if (inputStreamOpen != null) {
                        inputStreamOpen.close();
                    }
                }
            }
        } catch (Throwable th2) {
            th = th2;
            inputStreamOpen = null;
        }
    }

    public static void OooO00o(Cursor cursor) {
        if (cursor != null) {
            try {
                cursor.close();
            } catch (Exception e) {
                ooooO000.OooO00o(e);
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:33:0x009a A[Catch: IOException -> 0x009d, TRY_LEAVE, TryCatch #10 {IOException -> 0x009d, blocks: (B:31:0x0095, B:33:0x009a), top: B:52:0x0095 }] */
    public static void OooO00o(String str, String str2, Object obj) throws Throwable {
        ObjectOutputStream objectOutputStream;
        FileOutputStream fileOutputStream = null;
        try {
            try {
                if (!new File(str).exists()) {
                    new File(str).mkdirs();
                }
                StringBuilder sbAppend = new StringBuilder().append(str);
                String str3 = File.separator;
                String string = sbAppend.append(str3).append(str2).append(".tmp").toString();
                FileOutputStream fileOutputStream2 = new FileOutputStream(string);
                try {
                    objectOutputStream = new ObjectOutputStream(fileOutputStream2);
                    try {
                        objectOutputStream.writeObject(obj);
                        File file = new File(string);
                        long size = fileOutputStream2.getChannel().size();
                        if (file.exists() && size > 0) {
                            file.renameTo(new File(str + str3 + str2));
                        } else if (file.exists()) {
                            file.delete();
                        }
                        fileOutputStream2.close();
                    } catch (FileNotFoundException unused) {
                        fileOutputStream = fileOutputStream2;
                        if (fileOutputStream != null) {
                            fileOutputStream.close();
                        }
                        if (objectOutputStream == null) {
                            return;
                        }
                    } catch (Exception unused2) {
                        fileOutputStream = fileOutputStream2;
                        if (fileOutputStream != null) {
                            fileOutputStream.close();
                        }
                        if (objectOutputStream == null) {
                            return;
                        }
                    } catch (Throwable th) {
                        th = th;
                        fileOutputStream = fileOutputStream2;
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                                if (objectOutputStream != null) {
                                    objectOutputStream.close();
                                }
                            } catch (IOException unused3) {
                                throw th;
                            }
                        } else if (objectOutputStream != null) {
                            objectOutputStream.close();
                        }
                        throw th;
                    }
                } catch (FileNotFoundException unused4) {
                    objectOutputStream = null;
                } catch (Exception unused5) {
                    objectOutputStream = null;
                } catch (Throwable th2) {
                    th = th2;
                    objectOutputStream = null;
                }
            } catch (IOException unused6) {
                return;
            }
        } catch (FileNotFoundException unused7) {
            objectOutputStream = null;
        } catch (Exception unused8) {
            objectOutputStream = null;
        } catch (Throwable th3) {
            th = th3;
            objectOutputStream = null;
        }
        objectOutputStream.close();
    }

    public static void OooO00o(Closeable... closeableArr) {
        for (Closeable closeable : closeableArr) {
            if (closeable != null) {
                try {
                    closeable.close();
                } catch (IOException e) {
                    ooooO000.OooO00o(e);
                }
            }
        }
    }

    public static String OooO0O0(String str) throws Throwable {
        BufferedReader bufferedReader = null;
        try {
            try {
                File file = new File(BaseUtils.getExternalDir().getPath() + "/" + str);
                StringBuffer stringBuffer = new StringBuffer();
                BufferedReader bufferedReader2 = new BufferedReader(new FileReader(file));
                while (true) {
                    try {
                        String line = bufferedReader2.readLine();
                        if (line == null) {
                            break;
                        }
                        stringBuffer.append(line).append(System.getProperty("line.separator"));
                    } catch (Exception e) {
                        e = e;
                        bufferedReader = bufferedReader2;
                        ooooO000.OooO00o(e);
                        if (bufferedReader == null) {
                            return "";
                        }
                        try {
                            bufferedReader.close();
                            return "";
                        } catch (Throwable th) {
                            ooooO000.OooO00o(th);
                            return "";
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        bufferedReader = bufferedReader2;
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (Throwable th3) {
                                ooooO000.OooO00o(th3);
                            }
                        }
                        throw th;
                    }
                }
                String string = stringBuffer.toString();
                try {
                    bufferedReader2.close();
                } catch (Throwable th4) {
                    ooooO000.OooO00o(th4);
                }
                return string;
            } catch (Exception e2) {
                e = e2;
            }
        } catch (Throwable th5) {
            th = th5;
        }
    }

    public static boolean OooO0OO(String str) {
        try {
            return new File(str).exists();
        } catch (Exception unused) {
            return false;
        }
    }

    public static Object OooO0Oo(String str) throws Throwable {
        Throwable th;
        ObjectInputStream objectInputStream;
        FileInputStream fileInputStream;
        FileInputStream fileInputStream2 = null;
        try {
            try {
                fileInputStream = new FileInputStream(str);
                try {
                    objectInputStream = new ObjectInputStream(fileInputStream);
                    try {
                        Object object = objectInputStream.readObject();
                        try {
                            fileInputStream.close();
                            objectInputStream.close();
                        } catch (IOException unused) {
                        }
                        return object;
                    } catch (FileNotFoundException unused2) {
                        if (fileInputStream != null) {
                            fileInputStream.close();
                        }
                        if (objectInputStream != null) {
                            objectInputStream.close();
                        }
                        return null;
                    } catch (IOException unused3) {
                        if (fileInputStream != null) {
                            fileInputStream.close();
                        }
                        if (objectInputStream != null) {
                            objectInputStream.close();
                        }
                        return null;
                    } catch (Exception unused4) {
                        if (fileInputStream != null) {
                            fileInputStream.close();
                        }
                        if (objectInputStream != null) {
                            objectInputStream.close();
                        }
                        return null;
                    } catch (Throwable th2) {
                        th = th2;
                        fileInputStream2 = fileInputStream;
                        if (fileInputStream2 != null) {
                            try {
                                fileInputStream2.close();
                            } catch (IOException unused5) {
                                throw th;
                            }
                        }
                        if (objectInputStream == null) {
                            throw th;
                        }
                        objectInputStream.close();
                        throw th;
                    }
                } catch (FileNotFoundException unused6) {
                    objectInputStream = null;
                } catch (IOException unused7) {
                    objectInputStream = null;
                } catch (Exception unused8) {
                    objectInputStream = null;
                } catch (Throwable th3) {
                    th = th3;
                    objectInputStream = null;
                }
            } catch (IOException unused9) {
                return null;
            }
        } catch (FileNotFoundException unused10) {
            objectInputStream = null;
            fileInputStream = null;
        } catch (IOException unused11) {
            objectInputStream = null;
            fileInputStream = null;
        } catch (Exception unused12) {
            objectInputStream = null;
            fileInputStream = null;
        } catch (Throwable th4) {
            th = th4;
            objectInputStream = null;
        }
    }

    public synchronized void OooO00o(SQLiteDatabase sQLiteDatabase) {
        if (sQLiteDatabase != null) {
            sQLiteDatabase.close();
        }
    }
}
