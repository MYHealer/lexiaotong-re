package client.android.yixiaotong.v4.util;

import android.content.Context;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import java.io.IOException;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class ChannelUtils {
    private static final String CHANNEL_KEY = "channel";
    private static final String DEFAULT_CHANNEL = "default";
    private static String sChannel;

    public static String getChannel(Context context) throws Throwable {
        if (sChannel == null) {
            String channelFromCache = getChannelFromCache(context);
            sChannel = channelFromCache;
            if (!TextUtils.isEmpty(channelFromCache)) {
                return sChannel;
            }
            String channelFromMetaData = getChannelFromMetaData(context);
            sChannel = channelFromMetaData;
            if (!TextUtils.isEmpty(channelFromMetaData)) {
                saveChannelToCache(context, sChannel);
                return sChannel;
            }
            String channelFromApk = getChannelFromApk(context, "META-INF/channel_");
            sChannel = channelFromApk;
            if (!TextUtils.isEmpty(channelFromApk)) {
                saveChannelToCache(context, sChannel);
                return sChannel;
            }
            sChannel = DEFAULT_CHANNEL;
            saveChannelToCache(context, DEFAULT_CHANNEL);
        }
        return sChannel;
    }

    private static String getChannelFromCache(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context).getString("channel", "");
    }

    private static void saveChannelToCache(Context context, String str) {
        PreferenceManager.getDefaultSharedPreferences(context).edit().putString("channel", str).apply();
    }

    private static String getChannelFromMetaData(Context context) {
        try {
            return context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData.getString("CHANNEL");
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0 */
    /* JADX WARN: Type inference failed for: r0v1 */
    /* JADX WARN: Type inference failed for: r0v12 */
    /* JADX WARN: Type inference failed for: r0v13 */
    /* JADX WARN: Type inference failed for: r0v2, types: [java.util.zip.ZipFile] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    private static String getChannelFromApk(Context context, String str) throws Throwable {
        ?? r0 = 0;
        ZipFile zipFile = null;
        try {
            try {
                try {
                    ZipFile zipFile2 = new ZipFile(context.getApplicationInfo().sourceDir);
                    try {
                        Enumeration<? extends ZipEntry> enumerationEntries = zipFile2.entries();
                        while (true) {
                            boolean zHasMoreElements = enumerationEntries.hasMoreElements();
                            if (!zHasMoreElements) {
                                zipFile2.close();
                                r0 = zHasMoreElements;
                                break;
                            }
                            String name = enumerationEntries.nextElement().getName();
                            if (name.startsWith(str)) {
                                String strSubstring = name.substring(str.length());
                                try {
                                    zipFile2.close();
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                                return strSubstring;
                            }
                        }
                    } catch (IOException e2) {
                        e = e2;
                        zipFile = zipFile2;
                        e.printStackTrace();
                        if (zipFile == null) {
                            return "";
                        }
                        zipFile.close();
                        r0 = zipFile;
                    } catch (Throwable th) {
                        th = th;
                        r0 = zipFile2;
                        if (r0 != 0) {
                            try {
                                r0.close();
                            } catch (IOException e3) {
                                e3.printStackTrace();
                            }
                        }
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (IOException e4) {
                e = e4;
            }
            return "";
        } catch (IOException e5) {
            e5.printStackTrace();
            return "";
        }
    }
}
