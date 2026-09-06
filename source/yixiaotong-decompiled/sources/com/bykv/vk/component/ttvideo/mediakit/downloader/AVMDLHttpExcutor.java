package com.bykv.vk.component.ttvideo.mediakit.downloader;

import com.byazt.gqp.a;
import com.byazt.gqp.m;
import com.byazt.gqp.t;
import com.byazt.gqp.tt;
import com.byazt.gqp.u;
import com.byazt.gqp.yp;
import com.byazt.gqp.z;
import com.bykv.vk.component.ttvideo.ILivePlayer;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoaderConfigure;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLLog;
import com.huawei.openalliance.ad.constant.x;
import cz.msebera.android.httpclient.protocol.HTTP;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
public class AVMDLHttpExcutor {
    private static final String TAG = "AVMDLHttpExcutor";
    private static t okHttpClient;

    private static synchronized t getOkHttpClient() {
        long j;
        if (okHttpClient == null) {
            AVMDLDataLoaderConfigure config = AVMDLDataLoader.getInstance().getConfig();
            long j2 = ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT;
            if (config != null) {
                long j3 = config.mOpenTimeOut > 0 ? config.mOpenTimeOut * 1000 : 10000L;
                if (config.mRWTimeOut > 0) {
                    j2 = config.mRWTimeOut * 1000;
                }
                long j4 = j2;
                j2 = j3;
                j = j4;
            } else {
                j = 10000;
            }
            t.c cVar = new t.c();
            cVar.c(Collections.singletonList(u.HTTP_1_1));
            cVar.c(j2, TimeUnit.MILLISECONDS).tt(j, TimeUnit.MILLISECONDS).ve(j, TimeUnit.MILLISECONDS);
            okHttpClient = cVar.c();
        }
        return okHttpClient;
    }

    public static AVMDLResponse excute(AVMDLRequest aVMDLRequest, int i) throws Exception {
        yp.c cVar = new yp.c();
        cVar.c(aVMDLRequest.urls[i]);
        cVar.c("GET", (z) null);
        cVar.c(toOkHttpHeaders(aVMDLRequest));
        tt ttVarC = getOkHttpClient().c(cVar.tt());
        try {
            long jCurrentTimeMillis = System.currentTimeMillis();
            m mVarTt = ttVarC.tt();
            long jCurrentTimeMillis2 = System.currentTimeMillis();
            aVMDLRequest.mCurlUrlIndex = i;
            String.format("http open cost time:%d url:%s", Long.valueOf(jCurrentTimeMillis2 - jCurrentTimeMillis), aVMDLRequest.urls[i]);
            return new AVMDLResponse(aVMDLRequest, mVarTt, ttVarC);
        } catch (Exception e) {
            AVMDLLog.e(TAG, "request exception is " + e.getLocalizedMessage());
            throw e;
        }
    }

    private static a toOkHttpHeaders(AVMDLRequest aVMDLRequest) {
        a.c cVar = new a.c();
        if (aVMDLRequest.headers != null) {
            for (Map.Entry<String, String> entry : aVMDLRequest.headers.entrySet()) {
                entry.getKey();
                entry.getValue();
                cVar.tt(entry.getKey(), entry.getValue());
            }
        }
        String strBuildRangeHeader = buildRangeHeader(aVMDLRequest.reqOff, aVMDLRequest.size);
        if (strBuildRangeHeader != null) {
            cVar.tt("Range", strBuildRangeHeader);
        }
        cVar.tt("Accept-Encoding", HTTP.IDENTITY_CODING);
        return cVar.c();
    }

    public static String buildRangeHeader(long j, long j2) {
        String strFormRangeStrBySize = formRangeStrBySize(j, j2);
        if (strFormRangeStrBySize == null) {
            return null;
        }
        return "bytes=".concat(String.valueOf(strFormRangeStrBySize));
    }

    public static String formRangeStrBySize(long j, long j2) {
        return formRangeStrByPos(j, j2 > 0 ? (j2 + j) - 1 : -1L);
    }

    public static String formRangeStrByPos(long j, long j2) {
        if (j >= 0 && j2 > 0) {
            return j + x.A + j2;
        }
        if (j >= 0) {
            return j + x.A;
        }
        if (j >= 0 || j2 <= 0) {
            return null;
        }
        return x.A.concat(String.valueOf(j2));
    }
}
