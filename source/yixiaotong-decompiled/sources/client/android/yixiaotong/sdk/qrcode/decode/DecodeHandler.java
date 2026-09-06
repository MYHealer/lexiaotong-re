package client.android.yixiaotong.sdk.qrcode.decode;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.hardware.Camera;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import client.android.yixiaotong.sdk.R;
import client.android.yixiaotong.sdk.qrcode.utils.IActivityHandler;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.DecodeHintType;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.PlanarYUVLuminanceSource;
import com.google.zxing.ReaderException;
import com.google.zxing.Result;
import com.google.zxing.common.HybridBinarizer;
import java.io.ByteArrayOutputStream;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6847780.dex */
public class DecodeHandler extends Handler {
    private final IActivityHandler activityHandler;
    private final MultiFormatReader multiFormatReader;
    private boolean running = true;

    public DecodeHandler(IActivityHandler iActivityHandler, Map<DecodeHintType, Object> map) {
        MultiFormatReader multiFormatReader = new MultiFormatReader();
        this.multiFormatReader = multiFormatReader;
        multiFormatReader.setHints(map);
        this.activityHandler = iActivityHandler;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        if (this.running) {
            if (message.what == R.id.decode) {
                decode((byte[]) message.obj);
            } else if (message.what == R.id.quit) {
                this.running = false;
                Looper.myLooper().quit();
            }
        }
    }

    private void decode(byte[] bArr) {
        Result resultDecodeWithState;
        Camera.Size previewSize = this.activityHandler.getCameraManager().getPreviewSize();
        if (previewSize == null) {
            return;
        }
        byte[] bArr2 = new byte[bArr.length];
        for (int i = 0; i < previewSize.height; i++) {
            for (int i2 = 0; i2 < previewSize.width; i2++) {
                bArr2[(((previewSize.height * i2) + previewSize.height) - i) - 1] = bArr[(previewSize.width * i) + i2];
            }
        }
        int i3 = previewSize.width;
        previewSize.width = previewSize.height;
        previewSize.height = i3;
        PlanarYUVLuminanceSource planarYUVLuminanceSourceBuildLuminanceSource = buildLuminanceSource(bArr2, previewSize.width, previewSize.height);
        if (planarYUVLuminanceSourceBuildLuminanceSource != null) {
            try {
                resultDecodeWithState = this.multiFormatReader.decodeWithState(new BinaryBitmap(new HybridBinarizer(planarYUVLuminanceSourceBuildLuminanceSource)));
                this.multiFormatReader.reset();
            } catch (ReaderException unused) {
                this.multiFormatReader.reset();
                resultDecodeWithState = null;
            } catch (Throwable th) {
                this.multiFormatReader.reset();
                throw th;
            }
        } else {
            resultDecodeWithState = null;
        }
        Handler handler = this.activityHandler.getHandler();
        if (resultDecodeWithState == null) {
            if (handler != null) {
                Message.obtain(handler, R.id.decode_failed).sendToTarget();
            }
        } else if (handler != null) {
            Message messageObtain = Message.obtain(handler, R.id.decode_succeeded, resultDecodeWithState);
            Bundle bundle = new Bundle();
            bundleThumbnail(planarYUVLuminanceSourceBuildLuminanceSource, bundle);
            messageObtain.setData(bundle);
            messageObtain.sendToTarget();
        }
    }

    private static void bundleThumbnail(PlanarYUVLuminanceSource planarYUVLuminanceSource, Bundle bundle) {
        int[] iArrRenderThumbnail = planarYUVLuminanceSource.renderThumbnail();
        int thumbnailWidth = planarYUVLuminanceSource.getThumbnailWidth();
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(iArrRenderThumbnail, 0, thumbnailWidth, thumbnailWidth, planarYUVLuminanceSource.getThumbnailHeight(), Bitmap.Config.ARGB_8888);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmapCreateBitmap.compress(Bitmap.CompressFormat.JPEG, 50, byteArrayOutputStream);
        bundle.putByteArray(DecodeThread.BARCODE_BITMAP, byteArrayOutputStream.toByteArray());
    }

    public PlanarYUVLuminanceSource buildLuminanceSource(byte[] bArr, int i, int i2) {
        Rect cropRect = this.activityHandler.getCropRect();
        if (cropRect == null) {
            return null;
        }
        return new PlanarYUVLuminanceSource(bArr, i, i2, cropRect.left, cropRect.top, cropRect.width(), cropRect.height(), false);
    }
}
