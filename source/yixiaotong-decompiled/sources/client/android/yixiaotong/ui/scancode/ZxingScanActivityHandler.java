package client.android.yixiaotong.ui.scancode;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import client.android.yixiaotong.sdk.R;
import client.android.yixiaotong.sdk.qrcode.camera.CameraManager;
import client.android.yixiaotong.sdk.qrcode.decode.DecodeThread;
import client.android.yixiaotong.v3.ui.scan.ZxingScanV3Activity;
import com.google.zxing.Result;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class ZxingScanActivityHandler extends Handler {
    private ZxingScanActivity activity;
    private ZxingScanV3Activity activityv3;
    private final CameraManager cameraManager;
    private final DecodeThread decodeThread;
    private int mState = 0;
    private State state;

    private enum State {
        PREVIEW,
        SUCCESS,
        DONE
    }

    public ZxingScanActivityHandler(ZxingScanActivity zxingScanActivity, CameraManager cameraManager, int i) {
        this.activity = zxingScanActivity;
        DecodeThread decodeThread = new DecodeThread(zxingScanActivity, i);
        this.decodeThread = decodeThread;
        decodeThread.start();
        this.state = State.SUCCESS;
        this.cameraManager = cameraManager;
        cameraManager.startPreview();
        restartPreviewAndDecode();
    }

    public ZxingScanActivityHandler(ZxingScanV3Activity zxingScanV3Activity, CameraManager cameraManager, int i) {
        this.activityv3 = zxingScanV3Activity;
        DecodeThread decodeThread = new DecodeThread(zxingScanV3Activity, i);
        this.decodeThread = decodeThread;
        decodeThread.start();
        this.state = State.SUCCESS;
        this.cameraManager = cameraManager;
        cameraManager.startPreview();
        restartPreviewAndDecode();
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        if (message.what == R.id.restart_preview) {
            restartPreviewAndDecode();
            return;
        }
        if (message.what == R.id.decode_succeeded) {
            this.state = State.SUCCESS;
            Bundle data = message.getData();
            if (this.mState == 1) {
                this.activityv3.handleDecode((Result) message.obj, data);
                return;
            } else {
                this.activity.handleDecode((Result) message.obj, data);
                return;
            }
        }
        if (message.what == R.id.decode_failed) {
            this.state = State.PREVIEW;
            this.cameraManager.requestPreviewFrame(this.decodeThread.getHandler(), R.id.decode);
        }
    }

    public void quitSynchronously() {
        this.state = State.DONE;
        this.cameraManager.stopPreview();
        Message.obtain(this.decodeThread.getHandler(), R.id.quit).sendToTarget();
        try {
            this.decodeThread.join(500L);
        } catch (InterruptedException unused) {
        }
        removeMessages(R.id.decode_succeeded);
        removeMessages(R.id.decode_failed);
    }

    private void restartPreviewAndDecode() {
        if (this.state == State.SUCCESS) {
            this.state = State.PREVIEW;
            this.cameraManager.requestPreviewFrame(this.decodeThread.getHandler(), R.id.decode);
        }
    }
}
