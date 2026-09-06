package com.byazt.au;

import android.content.Context;
import com.byazt.fk.da;
import com.byazt.fk.u;
import com.byazt.lt.tt;
import com.bykv.vk.component.ttvideo.DataLoaderHelper;
import com.bykv.vk.component.ttvideo.IPreLoaderItemCallBackListener;
import com.bykv.vk.component.ttvideo.PreLoaderItemCallBackInfo;
import com.bykv.vk.component.ttvideo.PreloaderURLItem;
import com.bykv.vk.component.ttvideo.TTVideoEngine;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_NOTIFY_ALL_SEI_THRESHOLD, 20})
public class c implements da {
    public static volatile int c;
    public static Object n = new Object();
    public static volatile int tt;
    public static volatile int uj;
    public static volatile int ve;

    /* JADX WARN: Code duplicated, block: B:10:0x0022 A[PHI: r1
  0x0022: PHI (r1v3 long) = (r1v2 long), (r1v9 long) binds: [B:6:0x0015, B:8:0x001e] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0065, code lost:
    
        r6 = 1;
     */
    @Override // com.byazt.fk.da
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void execVideoPreload(Context context, final u uVar, final da.c cVar) {
        long j;
        long preloadSize = uVar.getPreloadSize();
        if (uVar.isPreloadAll()) {
            preloadSize = 2147483647L;
        }
        int pitayaCacheSize = uVar.getPitayaCacheSize();
        if (pitayaCacheSize > 0) {
            preloadSize = pitayaCacheSize;
            if (preloadSize >= uVar.getVideoSize()) {
                j = 2147483647L;
            } else {
                j = preloadSize;
            }
        } else {
            j = preloadSize;
        }
        DataLoaderHelper.DataLoaderCacheInfo cacheInfoByFilePath = TTVideoEngine.getCacheInfoByFilePath(uVar.getFileNameKey(), uVar.getCacheParentDir());
        int i = 0;
        tt.c("TTVideoPreloadImp", "TTMediaPlayer execVideoPreload: sourceType = ", 0, " preloadSize = ", Long.valueOf(j));
        if (cacheInfoByFilePath != null) {
            if (j == 2147483647L) {
            }
            tt.c("TTVideoPreloadImp", "TTMediaPlayer execVideoPreload: cacheInfo.mCacheSizeFromZero = ", Long.valueOf(cacheInfoByFilePath.mCacheSizeFromZero), " cacheInfo.mMediaSize = ", Long.valueOf(cacheInfoByFilePath.mMediaSize), " sourceType = ", Integer.valueOf(i));
        }
        uVar.setSourceType(i);
        PreloaderURLItem preloaderURLItem = new PreloaderURLItem(uVar.getFileNameKey(), null, j, new String[]{uVar.getUrl()}, uVar.getCacheParentDir());
        preloaderURLItem.setCallBackListener(new IPreLoaderItemCallBackListener() { // from class: com.byazt.au.c.1
            @Override // com.bykv.vk.component.ttvideo.IPreLoaderItemCallBackListener
            public void preloadItemInfo(PreLoaderItemCallBackInfo preLoaderItemCallBackInfo) {
                synchronized (c.n) {
                    try {
                        if (preLoaderItemCallBackInfo == null) {
                            return;
                        }
                        int key = preLoaderItemCallBackInfo.getKey();
                        tt.c("TTVideoPreloadImp", "TTMediaPlayer execVideoPreload: callback key =", Integer.valueOf(key), "  fileHash =", uVar.getFileNameKey());
                        if (key == 2) {
                            da.c cVar2 = cVar;
                            if (cVar2 != null) {
                                cVar2.onVideoPreloadSuccess(uVar, preLoaderItemCallBackInfo.getKey());
                            }
                            c.tt++;
                        } else if (key == 3) {
                            da.c cVar3 = cVar;
                            if (cVar3 != null) {
                                cVar3.onVideoPreloadFail(uVar, preLoaderItemCallBackInfo.getKey(), "error");
                            }
                            c.ve++;
                        } else if (key == 5) {
                            da.c cVar4 = cVar;
                            if (cVar4 != null) {
                                cVar4.cancel(uVar, preLoaderItemCallBackInfo.getKey());
                            }
                            c.uj++;
                        }
                        tt.c("TTVideoPreloadImp", "preloadItemInfo:  preTime = ", Integer.valueOf(c.c), "  callback =", Integer.valueOf(c.tt + c.ve + c.uj), "  callback2 =", Integer.valueOf(c.tt), "  callback3=", Integer.valueOf(c.ve), "  callback5 =", Integer.valueOf(c.uj));
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
        });
        tt.c("TTVideoPreloadImp", "TTMediaPlayer execVideoPreload start: fileName = ", uVar.getFileNameKey(), " url =", uVar.getUrl(), " isH265=", Boolean.valueOf(uVar.isH265()), " presize=", Integer.valueOf(uVar.getPreloadSize()), " path=", uVar.getCacheParentDir());
        synchronized (n) {
            c++;
        }
        TTVideoEngine.addTask(preloaderURLItem);
        tt.c("TTVideoPreloadImp", "TTMediaPlayer execVideoPreload end: fileName = ", uVar.getFileNameKey());
    }
}
