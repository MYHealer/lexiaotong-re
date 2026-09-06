package com.yfanads.android.libs.utils;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.Process;
import android.text.TextUtils;
import android.util.Base64;
import com.byazt.hv.TTDownloadField;
import com.huawei.openalliance.ad.constant.x;
import com.stub.StubApp;
import com.yfanads.android.libs.thirdpart.gson.Gson;
import com.yfanads.android.libs.thirdpart.gson.GsonBuilder;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.ref.SoftReference;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.security.KeyFactory;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;
import java.util.Arrays;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.zip.Deflater;
import java.util.zip.Inflater;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public class Util {
    private static final String AES_MODE = "AES/CBC/PKCS7Padding";
    private static final String ALGORITHM = "AES/CBC/PKCS5Padding";
    public static final String ALGORITHM7 = "AES/ECB/PKCS5Padding";
    public static final String APP_HASH_KEY = "appHash1";
    public static final String APP_SOURCE_KEY = "appSource";
    private static final String CHARSET = "UTF-8";
    private static final String CIPHER = "AES";
    private static final int CORE_POOL_SIZE;
    private static final String ENCODING = "UTF-8";
    public static final ThreadPoolExecutor EXECUTOR;
    private static final int KEEP_ALIVE_TIME = 30;
    private static final int MAXIMUM_POOL_SIZE;
    public static final String TAG = "YFAds";
    private static final Map<Integer, String> VERSION;
    private static String appHash;
    private static String appSource;
    private static String packageName;
    public static final Handler MAIN_HANDLER = new Handler(Looper.getMainLooper());
    public static final Gson GSON = new GsonBuilder().disableHtmlEscaping().excludeFieldsWithoutExposeAnnotation().create();

    static {
        int iAvailableProcessors = Runtime.getRuntime().availableProcessors();
        int i = iAvailableProcessors * 10;
        CORE_POOL_SIZE = i;
        int i2 = iAvailableProcessors * 20;
        MAXIMUM_POOL_SIZE = i2;
        EXECUTOR = new ThreadPoolExecutor(i, i2, 30L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new NamedThreadFactory("util"), new RejectedExeHandler("util"));
        VERSION = new ConcurrentHashMap();
    }

    public static boolean checkSelfPermission(Context context, String str, int i) {
        return context.checkPermission(str, Process.myPid(), Process.myUid()) == i;
    }

    public static void closeIO(Closeable... closeableArr) {
        if (closeableArr == null) {
            return;
        }
        for (Closeable closeable : closeableArr) {
            if (closeable != null) {
                try {
                    closeable.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void closeIOQuietly(Closeable... closeableArr) {
        if (closeableArr == null) {
            return;
        }
        for (Closeable closeable : closeableArr) {
            if (closeable != null) {
                try {
                    closeable.close();
                } catch (IOException unused) {
                }
            }
        }
    }

    public static String decryptAES7(String str, String str2) {
        try {
            byte[] bArrDecode = Base64.decode(str, 0);
            SecretKeySpec secretKeySpec = new SecretKeySpec(str2.getBytes(StandardCharsets.UTF_8), CIPHER);
            Cipher cipher = Cipher.getInstance(ALGORITHM7);
            cipher.init(2, secretKeySpec);
            return new String(cipher.doFinal(bArrDecode), StandardCharsets.UTF_8);
        } catch (Exception e) {
            e.printStackTrace();
            return str;
        }
    }

    public static String decryptAES7ByShort(String str, String str2) {
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec(str2.getBytes(StandardCharsets.UTF_8), CIPHER);
            Cipher cipher = Cipher.getInstance(ALGORITHM7);
            cipher.init(2, secretKeySpec);
            byte[] bArrDoFinal = cipher.doFinal(Base64.decode(str, 2));
            Inflater inflater = new Inflater();
            inflater.setInput(bArrDoFinal, 0, bArrDoFinal.length);
            byte[] bArr = new byte[1024];
            int iInflate = inflater.inflate(bArr);
            inflater.end();
            return new String(bArr, 0, iInflate, StandardCharsets.UTF_8);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String encrypt(String str, String str2, String str3) {
        try {
            Cipher cipher = Cipher.getInstance(ALGORITHM);
            cipher.init(1, new SecretKeySpec(str2.getBytes(), CIPHER), new IvParameterSpec(str3.getBytes()));
            return Base64.encodeToString(cipher.doFinal(str.getBytes("UTF-8")), 2);
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public static String encryptAES(String str, String str2) {
        try {
            if (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) {
                return "";
            }
            Cipher cipher = Cipher.getInstance(ALGORITHM);
            cipher.init(1, new SecretKeySpec(str2.getBytes(), ""));
            return Base64.encodeToString(cipher.doFinal(str.getBytes("UTF-8")), 0);
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public static String encryptAES(String str, String str2, String str3) {
        try {
            Cipher cipher = Cipher.getInstance(ALGORITHM);
            cipher.init(1, new SecretKeySpec(str2.getBytes(), CIPHER), new IvParameterSpec(str3.getBytes()));
            return Base64.encodeToString(cipher.doFinal(str.getBytes("UTF-8")), 0);
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public static String encryptAES7(String str, String str2) {
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec(str2.getBytes(StandardCharsets.UTF_8), CIPHER);
            Cipher cipher = Cipher.getInstance(ALGORITHM7);
            cipher.init(1, secretKeySpec);
            return Base64.encodeToString(cipher.doFinal(str.getBytes(StandardCharsets.UTF_8)), 0);
        } catch (Exception e) {
            e.printStackTrace();
            return str;
        }
    }

    public static String encryptAES7ByShort(String str, String str2) {
        try {
            byte[] bytes = str.getBytes(StandardCharsets.UTF_8);
            Deflater deflater = new Deflater();
            deflater.setInput(bytes);
            deflater.finish();
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bArr = new byte[1024];
            while (!deflater.finished()) {
                byteArrayOutputStream.write(bArr, 0, deflater.deflate(bArr));
            }
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            deflater.end();
            byteArrayOutputStream.close();
            SecretKeySpec secretKeySpec = new SecretKeySpec(str2.getBytes(StandardCharsets.UTF_8), CIPHER);
            Cipher cipher = Cipher.getInstance(ALGORITHM7);
            cipher.init(1, secretKeySpec);
            return Base64.encodeToString(cipher.doFinal(byteArray), 2);
        } catch (Exception e) {
            e.printStackTrace();
            return str;
        }
    }

    public static String encryptRSA(String str, String str2) {
        try {
            PublicKey publicKey = getPublicKey(str2);
            Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
            cipher.init(1, publicKey);
            byte[] bytes = str.getBytes(StandardCharsets.UTF_8);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            for (int i = 0; i < bytes.length; i += 245) {
                byteArrayOutputStream.write(cipher.doFinal(Arrays.copyOfRange(bytes, i, Math.min(245, bytes.length - i) + i)));
            }
            return Base64.encodeToString(byteArrayOutputStream.toByteArray(), 0);
        } catch (Exception e) {
            e.printStackTrace();
            return str;
        }
    }

    public static synchronized String getAppHash() {
        return appHash;
    }

    public static String getAppPackageName(Context context) {
        if (!TextUtils.isEmpty(packageName)) {
            return packageName;
        }
        try {
            String str = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).packageName;
            packageName = str;
            return str;
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public static synchronized String getAppSource() {
        return appSource;
    }

    public static String getCurrentProcessName(Context context) {
        try {
            int iMyPid = Process.myPid();
            String str = "";
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : ((ActivityManager) StubApp.getOrigApplicationContext(context.getApplicationContext()).getSystemService(TTDownloadField.TT_ACTIVITY)).getRunningAppProcesses()) {
                if (iMyPid == runningAppProcessInfo.pid) {
                    str = runningAppProcessInfo.processName;
                }
            }
            return str;
        } catch (Throwable th) {
            th.printStackTrace();
            return "";
        }
    }

    public static long getCurrentTime() {
        return System.currentTimeMillis();
    }

    public static String getFileNameWithoutExtension(File file) {
        String name = file.getName();
        return name.substring(0, name.lastIndexOf("."));
    }

    private static PublicKey getPublicKey(String str) {
        return KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(Base64.decode(str, 2)));
    }

    public static String getRandomUuid() {
        return UUID.randomUUID().toString().replace(x.A, "");
    }

    public static String getSdkVersion(Integer num) {
        return num == null ? "" : VERSION.get(num);
    }

    public static Map<Integer, String> getVersion() {
        return VERSION;
    }

    public static boolean isActivityDestroyed(Activity activity) {
        if (activity == null) {
            return true;
        }
        try {
            return activity.isDestroyed() || activity.isFinishing();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean isActivityDestroyed(SoftReference<Activity> softReference) {
        if (softReference != null) {
            try {
                return softReference.get() == null || softReference.get().isDestroyed() || softReference.get().isFinishing();
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        }
        return true;
    }

    public static boolean isMainProcess(Context context) {
        try {
            return context.getPackageName().equals(getCurrentProcessName(context));
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    public static boolean isStrEquals(String str, String str2) {
        return !TextUtils.isEmpty(str) && str.equals(str2);
    }

    public static String md5(String str) {
        try {
            byte[] bArrDigest = MessageDigest.getInstance("MD5").digest(str.getBytes("UTF-8"));
            StringBuilder sb = new StringBuilder(bArrDigest.length * 2);
            for (byte b : bArrDigest) {
                int i = b & 255;
                if (i < 16) {
                    sb.append("0");
                }
                sb.append(Integer.toHexString(i));
            }
            return sb.toString();
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("Huh, UTF-8 should be supported?", e);
        } catch (NoSuchAlgorithmException e2) {
            throw new RuntimeException("Huh, MD5 should be supported?", e2);
        }
    }

    public static void openLink(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
            intent.addFlags(268435456);
            context.startActivity(intent);
        } catch (Exception unused) {
        }
    }

    public static synchronized void setAppHash(String str, String str2) {
        appSource = str;
        appHash = str2;
    }

    public static int toInt(String str, int i) {
        if (str != null && !str.equals("")) {
            try {
                return Integer.parseInt(str);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return i;
    }

    private static void zipFiles(String str, String str2, ZipOutputStream zipOutputStream) throws IOException {
        if (zipOutputStream == null) {
            return;
        }
        File file = new File(str + str2);
        if (!file.isFile()) {
            String[] list = file.list();
            if (list.length <= 0) {
                zipOutputStream.putNextEntry(new ZipEntry(str2 + File.separator));
                zipOutputStream.closeEntry();
            }
            for (String str3 : list) {
                zipFiles(str + str2 + "/", str3, zipOutputStream);
            }
            return;
        }
        ZipEntry zipEntry = new ZipEntry(str2);
        FileInputStream fileInputStream = new FileInputStream(file);
        zipOutputStream.putNextEntry(zipEntry);
        byte[] bArr = new byte[2048];
        while (true) {
            int i = fileInputStream.read(bArr);
            if (i == -1) {
                zipOutputStream.closeEntry();
                return;
            }
            zipOutputStream.write(bArr, 0, i);
        }
    }

    public static void zipFolder(String str, String str2) throws Throwable {
        ZipOutputStream zipOutputStream = null;
        try {
            try {
                ZipOutputStream zipOutputStream2 = new ZipOutputStream(Files.newOutputStream(new File(str2).toPath(), new OpenOption[0]));
                try {
                    File file = new File(str);
                    zipFiles(file.getParent() + File.separator, file.getName(), zipOutputStream2);
                    zipOutputStream2.finish();
                    closeIO(zipOutputStream2);
                } catch (Exception e) {
                    e = e;
                    zipOutputStream = zipOutputStream2;
                    e.printStackTrace();
                    closeIO(zipOutputStream);
                } catch (Throwable th) {
                    th = th;
                    zipOutputStream = zipOutputStream2;
                    closeIO(zipOutputStream);
                    throw th;
                }
            } catch (Exception e2) {
                e = e2;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }
}
