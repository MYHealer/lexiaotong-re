package client.android.yixiaotong.sdk.qrcode;

import android.os.Handler;
import android.os.Message;
import client.android.yixiaotong.sdk.R;
import client.android.yixiaotong.sdk.qrcode.camera.CameraManager;
import client.android.yixiaotong.sdk.qrcode.decode.DecodeThread;
import com.google.zxing.Result;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6847780.dex */
public class CaptureActivityHandler extends Handler {
    private final CaptureActivity activity;
    private final CameraManager cameraManager;
    private final DecodeThread decodeThread;
    private State state;

    private enum State {
        PREVIEW,
        SUCCESS,
        DONE
    }

    public CaptureActivityHandler(CaptureActivity captureActivity, CameraManager cameraManager, int i) {
        this.activity = captureActivity;
        DecodeThread decodeThread = new DecodeThread(captureActivity, i);
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
            this.activity.handleDecode((Result) message.obj, message.getData());
        } else if (message.what == R.id.decode_failed) {
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
