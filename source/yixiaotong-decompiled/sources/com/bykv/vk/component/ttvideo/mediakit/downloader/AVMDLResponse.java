package com.bykv.vk.component.ttvideo.mediakit.downloader;

import android.text.TextUtils;
import com.byazt.gqp.m;
import com.byazt.gqp.tt;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLLog;
import java.io.IOException;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
public class AVMDLResponse {
    private static final String TAG = "AVMDLResponse";
    public tt call;
    public long readOff;
    public AVMDLRequest request;
    public m response;
    public long contentlength = -1;
    public int statusCode = -1;
    public boolean isReadErr = false;

    public boolean isOpenSuccessful() {
        int i = this.statusCode;
        return i >= 200 && i < 300;
    }

    public boolean isReadSuccessful() {
        return !this.isReadErr;
    }

    public void reset() {
        this.response = null;
        this.call = null;
        this.contentlength = -1L;
        this.statusCode = -1;
        this.isReadErr = false;
    }

    public AVMDLResponse(AVMDLRequest aVMDLRequest, m mVar, tt ttVar) {
        this.request = aVMDLRequest;
        this.response = mVar;
        this.call = ttVar;
        this.readOff = aVMDLRequest.reqOff;
        parseResponse();
    }

    private void parseResponse() {
        int iLastIndexOf;
        m mVar = this.response;
        if (mVar == null) {
            return;
        }
        int iVe = mVar.ve();
        this.statusCode = iVe;
        if (iVe == 200) {
            this.contentlength = toInt(this.response.c("Content-Length"));
            return;
        }
        if (iVe == 206) {
            String strC = this.response.c("Content-Range");
            if (TextUtils.isEmpty(strC) || (iLastIndexOf = strC.lastIndexOf("/")) < 0 || iLastIndexOf >= strC.length() - 1) {
                return;
            }
            this.contentlength = toInt(strC.substring(iLastIndexOf + 1), -1);
        }
    }

    public int readData(byte[] bArr) {
        if (this.response.a() == null) {
            return 0;
        }
        try {
            int i = this.response.a().ve().read(bArr);
            if (i <= 0) {
                return -1;
            }
            String.format("before read off:%d reqoff:%d req size:%d", Long.valueOf(this.readOff), Long.valueOf(this.request.reqOff), Long.valueOf(this.request.size));
            long j = i;
            this.readOff += j;
            this.request.reqOff += j;
            if (this.request.size > 0) {
                this.request.size -= j;
            }
            String.format("after read,ret:%d off:%d reqoff:%d req size:%d", Integer.valueOf(i), Long.valueOf(this.readOff), Long.valueOf(this.request.reqOff), Long.valueOf(this.request.size));
            return i;
        } catch (IOException e) {
            this.isReadErr = true;
            AVMDLLog.e(TAG, "read data exception:" + e.getLocalizedMessage());
            return -1;
        }
    }

    public void cancel() {
        tt ttVar = this.call;
        if (ttVar != null) {
            ttVar.ve();
        }
    }

    public boolean isFinish() {
        long j = this.request.size >= 0 ? this.request.reqOff + this.request.size : this.contentlength;
        long j2 = this.contentlength;
        if (j > j2) {
            j = j2;
        }
        String.format("check readoff:%d reqoff:%d reqsize:%d contentlen:%d endoff:%d", Long.valueOf(this.readOff), Long.valueOf(this.request.reqOff), Long.valueOf(this.request.size), Long.valueOf(this.contentlength), Long.valueOf(j));
        return this.readOff >= j;
    }

    public static int toInt(String str) {
        return toInt(str, 0);
    }

    public static int toInt(String str, int i) {
        if (TextUtils.isEmpty(str)) {
            return i;
        }
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException unused) {
            return i;
        }
    }
}
