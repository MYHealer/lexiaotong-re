package client.android.yixiaotong.sdk.qrcode.utils;

import android.graphics.Rect;
import android.os.Bundle;
import android.os.Handler;
import client.android.yixiaotong.sdk.qrcode.camera.CameraManager;
import com.google.zxing.Result;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6847780.dex */
public interface IActivityHandler {
    CameraManager getCameraManager();

    Rect getCropRect();

    Handler getHandler();

    void handleDecode(Result result, Bundle bundle);
}
