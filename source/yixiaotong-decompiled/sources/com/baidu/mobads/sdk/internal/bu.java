package com.baidu.mobads.sdk.internal;

import android.content.Context;
import android.util.Base64;
import com.stub.StubApp;
import java.io.File;
import java.io.FileInputStream;
import java.io.FilenameFilter;
import java.security.DigestInputStream;
import java.security.KeyFactory;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.Cipher;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
public class bu extends File {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f1756a = "LocalApkFile";
    private static final long b = 6916965592955692235L;
    private static ClassLoader h;
    private bz c;
    private Class<?> d;
    private Context e;
    private PublicKey f;
    private bv g;

    public bu(String str, Context context) {
        this(str, context, null);
    }

    public bu(String str, Context context, bz bzVar) {
        super(str);
        this.d = null;
        this.e = null;
        this.g = bv.a();
        this.e = context;
        this.c = bzVar;
        if (bzVar != null) {
            try {
                this.f = c("MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDBcp8gg3O7bjdnz+pSxg+JH/mbcKfm7dEjcRqVNAFwG7bTpLwDQh40bZJzrcBKQWbD6kArR6TPuQUCMQ09/y55Vk1P2Kq7vJGGisFpjlqv2qlg8drLdhXkLQUt/SeZVJgT+CNxVbuzxAF61EEf8M0MHi1I2dm6n6lOA6fomiCD9wIDAQAB");
            } catch (Exception unused) {
                this.f = null;
            }
        }
    }

    protected void a() throws Throwable {
        if (this.c != null) {
            String strA = a(new File(getAbsolutePath()));
            String strB = b(this.c.d());
            if (!strA.equalsIgnoreCase(strB)) {
                throw new cb.a("doCheckApkIntegrity failed, md5sum: " + strA + ", checksum in json info: " + strB);
            }
            return;
        }
        this.g.a(f1756a, "built-in apk, no need to check");
    }

    protected Class<?> b() throws cb.a {
        if (this.d == null) {
            File file = new File(getAbsolutePath());
            try {
                this.d = b(file);
            } catch (Exception unused) {
                file.delete();
            }
        }
        return this.d;
    }

    protected void a(String str) {
        renameTo(new File(str));
    }

    protected double c() {
        bz bzVar = this.c;
        if (bzVar == null) {
            return 0.0d;
        }
        return bzVar.b();
    }

    private String b(String str) {
        if (this.f == null) {
            return null;
        }
        byte[] bArrDecode = Base64.decode(str, 0);
        try {
            Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
            cipher.init(2, this.f);
            return new String(cipher.doFinal(bArrDecode), "UTF-8").trim();
        } catch (Exception e) {
            this.g.c("ErrorWhileVerifySigNature", e);
            return null;
        }
    }

    private static PublicKey c(String str) throws Exception {
        try {
            return KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(Base64.decode(str, 0)));
        } catch (NullPointerException unused) {
            throw new Exception("NullPointerException");
        } catch (NoSuchAlgorithmException unused2) {
            throw new Exception("NoSuchAlgorithmException");
        } catch (InvalidKeySpecException unused3) {
            throw new Exception("InvalidKeySpecException");
        }
    }

    /* JADX WARN: Code duplicated, block: B:49:0x009d A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:50:0x009f A[Catch: Exception -> 0x009b, TRY_LEAVE, TryCatch #2 {Exception -> 0x009b, blocks: (B:46:0x0097, B:50:0x009f), top: B:56:0x0097 }] */
    /* JADX WARN: Code duplicated, block: B:56:0x0097 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    private String a(File file) throws Throwable {
        DigestInputStream digestInputStream;
        FileInputStream fileInputStream = null;
        try {
            FileInputStream fileInputStream2 = new FileInputStream(file);
            try {
                MessageDigest messageDigest = MessageDigest.getInstance("MD5");
                digestInputStream = new DigestInputStream(fileInputStream2, messageDigest);
                try {
                    while (digestInputStream.read(new byte[4096]) != -1) {
                    }
                    String str = "";
                    for (byte b2 : messageDigest.digest()) {
                        str = str + Integer.toString((b2 & 255) + 256, 16).substring(1);
                    }
                    try {
                        fileInputStream2.close();
                        digestInputStream.close();
                    } catch (Exception e) {
                        this.g.a(f1756a, e.getMessage());
                    }
                    return str;
                } catch (Exception e2) {
                    e = e2;
                    fileInputStream = fileInputStream2;
                    try {
                        this.g.a(f1756a, e.getMessage());
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (Exception e3) {
                                this.g.a(f1756a, e3.getMessage());
                                return "";
                            }
                        }
                        if (digestInputStream == null) {
                            return "";
                        }
                        digestInputStream.close();
                        return "";
                    } catch (Throwable th) {
                        th = th;
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                                if (digestInputStream != null) {
                                    digestInputStream.close();
                                }
                            } catch (Exception e4) {
                                this.g.a(f1756a, e4.getMessage());
                                throw th;
                            }
                        } else if (digestInputStream != null) {
                            digestInputStream.close();
                        }
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    fileInputStream = fileInputStream2;
                    if (fileInputStream != null) {
                        fileInputStream.close();
                        if (digestInputStream != null) {
                            digestInputStream.close();
                        }
                    } else if (digestInputStream != null) {
                        digestInputStream.close();
                    }
                    throw th;
                }
            } catch (Exception e5) {
                e = e5;
                digestInputStream = null;
            } catch (Throwable th3) {
                th = th3;
                digestInputStream = null;
            }
        } catch (Exception e6) {
            e = e6;
            digestInputStream = null;
        } catch (Throwable th4) {
            th = th4;
            digestInputStream = null;
        }
    }

    private void d() {
        File[] fileArrListFiles = this.e.getFilesDir().listFiles(new a());
        for (int i = 0; fileArrListFiles != null && i < fileArrListFiles.length; i++) {
            if (fileArrListFiles[i].getAbsolutePath().contains("__xadsdk__remote__final__")) {
                this.g.a(f1756a, "clearDexCacheFiles-->" + i + "--" + fileArrListFiles[i].getAbsolutePath());
                fileArrListFiles[i].delete();
            }
        }
    }

    private Class<?> b(File file) throws cb.a {
        Class<?> cls;
        this.g.a(f1756a, "Android version:" + bn.a(this.e).c());
        Class<?> cls2 = null;
        try {
            synchronized (cb.class) {
                String absolutePath = file.getAbsolutePath();
                ClassLoader classLoader = getClass().getClassLoader();
                String absolutePath2 = this.e.getFilesDir().getAbsolutePath();
                String str = z.aQ;
                ClassLoader classLoaderA = ao.a(absolutePath, absolutePath2, (String) null, classLoader);
                h = classLoaderA;
                cls = Class.forName(str, true, classLoaderA);
                this.g.a(f1756a, "dexPath=" + absolutePath + ", cl=" + classLoader + ", dir=" + absolutePath2 + ", len=" + file.length() + ", list=" + file.list() + ", class=" + cls);
            }
            cls2 = cls;
        } catch (Exception e) {
            this.g.a(f1756a, e.getMessage());
        }
        this.g.a(f1756a, "jar.path=" + file.getAbsolutePath() + ", clz=" + cls2);
        return cls2;
    }

    public static ClassLoader a(Context context) {
        ClassLoader classLoader = h;
        return classLoader != null ? classLoader : av.a(StubApp.getOrigApplicationContext(context.getApplicationContext()));
    }

    class a implements FilenameFilter {
        @Override // java.io.FilenameFilter
        public boolean accept(File file, String str) {
            return true;
        }

        a() {
        }
    }
}
