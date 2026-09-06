package com.yfanads.android.adx.newplayer;

import android.content.Context;
import android.text.TextUtils;
import com.yfanads.android.adx.newplayer.videocache.HttpProxyCacheServer;
import com.yfanads.android.adx.newplayer.videocache.ProxyCacheUtils;
import com.yfanads.android.adx.newplayer.videocache.file.FileNameGenerator;
import com.yfanads.android.utils.YFPlayerLog;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public class VideoMgr {
    private static HttpProxyCacheServer mProxy;

    /* JADX INFO: renamed from: com.yfanads.android.adx.newplayer.VideoMgr$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static class MyFileNameGenerator implements FileNameGenerator {
        private static final int MAX_EXTENSION_LENGTH = 4;

        private MyFileNameGenerator() {
        }

        public /* synthetic */ MyFileNameGenerator(AnonymousClass1 anonymousClass1) {
            this();
        }

        private String getExtension(String str) {
            int iLastIndexOf = str.lastIndexOf(46);
            return (iLastIndexOf == -1 || iLastIndexOf <= str.lastIndexOf(47) || iLastIndexOf + 6 <= str.length()) ? "" : str.substring(iLastIndexOf + 1);
        }

        @Override // com.yfanads.android.adx.newplayer.videocache.file.FileNameGenerator
        public String generate(String str) {
            try {
                String extension = getExtension(str);
                int iLastIndexOf = str.lastIndexOf(46);
                if (str.length() > 18 && iLastIndexOf > 18) {
                    return str.substring(iLastIndexOf - 18);
                }
                String strComputeMD5 = ProxyCacheUtils.computeMD5(str);
                return TextUtils.isEmpty(extension) ? strComputeMD5 : strComputeMD5 + "." + extension;
            } catch (Exception e) {
                e.printStackTrace();
                return str;
            }
        }
    }

    private VideoMgr() {
    }

    public static HttpProxyCacheServer getProxy() {
        return mProxy;
    }

    public static void init(Context context) {
        try {
            if (mProxy != null) {
                return;
            }
            mProxy = new HttpProxyCacheServer.Builder(context).maxCacheSize(536870912L).maxCacheFilesCount(50).fileNameGenerator(new MyFileNameGenerator(null)).build();
        } catch (Exception e) {
            e.printStackTrace();
            YFPlayerLog.error("VideoMgr init error: " + e.getMessage());
        }
    }
}
