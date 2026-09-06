package com.huawei.hms.mlplugin.card.bcr.dynamic;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import com.huawei.hms.common.Preconditions;
import com.huawei.hms.ml.common.card.bcr.BcrDetectorFrameParcel;
import com.huawei.hms.ml.common.card.bcr.BcrDetectorOptionsParcel;
import com.huawei.hms.ml.common.card.bcr.BcrDetectorParcel;
import com.huawei.hms.ml.common.utils.SmartLog;
import com.huawei.hms.mlkit.bcr.BcrDecoderHelper;
import com.huawei.hms.mlsdk.common.MLFrame;
import com.huawei.hms.mlsdk.internal.client.adapter.AvailableAdapterManager;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class RemoteBcrDecoder {
    private static final String TAG = "RemoteBcrDecoder";
    private boolean initialed;

    /* JADX INFO: renamed from: com.huawei.hms.mlplugin.card.bcr.dynamic.RemoteBcrDecoder$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private void setInitialed(boolean z) {
        this.initialed = z;
    }

    /* synthetic */ RemoteBcrDecoder(AnonymousClass1 anonymousClass1) {
        this();
    }

    private static final class Holder {
        static final RemoteBcrDecoder INSTANCE = new RemoteBcrDecoder(null);

        private Holder() {
        }
    }

    private RemoteBcrDecoder() {
        this.initialed = false;
    }

    public static RemoteBcrDecoder getInstance() {
        return Holder.INSTANCE;
    }

    public synchronized void prepare(Context context) {
    }

    public synchronized int initial(Context context, BcrDetectorOptionsParcel bcrDetectorOptionsParcel) {
        SmartLog.i(TAG, "initial IS_REMOVED_DYNAMIC is true");
        try {
            int iInitial = BcrDecoderHelper.getInstance().initial(context, bcrDetectorOptionsParcel);
            if (iInitial == 0) {
                this.initialed = true;
            }
            return iInitial;
        } catch (Exception e) {
            SmartLog.d(TAG, "initial Exception e: " + e);
            return -1;
        } catch (Throwable th) {
            SmartLog.d(TAG, "initial Throwable e: " + th);
            return -1;
        }
    }

    public synchronized BcrDetectorParcel detect(Context context, Bundle bundle, MLFrame mLFrame, BcrDetectorOptionsParcel bcrDetectorOptionsParcel) {
        if (!this.initialed && initial(context, bcrDetectorOptionsParcel) >= 0) {
            setInitialed(true);
        }
        if (!this.initialed) {
            return null;
        }
        SmartLog.i(TAG, "detect IS_REMOVED_DYNAMIC is true");
        try {
            return BcrDecoderHelper.getInstance().detect(bundle, convert(mLFrame, bcrDetectorOptionsParcel), bcrDetectorOptionsParcel);
        } catch (Exception e) {
            SmartLog.d(TAG, "detect Exception  e: " + e);
            return null;
        }
    }

    public synchronized int destroy(Context context) {
        SmartLog.i(TAG, "destroy IS_REMOVED_DYNAMIC is true");
        try {
            try {
                return BcrDecoderHelper.getInstance().destroy();
            } catch (Exception e) {
                SmartLog.d(TAG, "destroy Exception e: " + e);
                return -1;
            }
        } catch (Throwable th) {
            SmartLog.d(TAG, "destroy Throwable e: " + th);
            return -1;
        }
    }

    private boolean isAvailable(Context context) {
        return AvailableAdapterManager.getInstance().isAvailable(context, InitializerFactory.getRemoteBcrInitializer());
    }

    private void notifyDownloadIfNeeded(Context context) {
        AvailableAdapterManager.getInstance().notifyDownloadIfNeeded(context, InitializerFactory.getRemoteBcrInitializer());
    }

    public synchronized void release(Context context) {
        if (this.initialed) {
            destroy(context);
            setInitialed(false);
        }
    }

    private static BcrDetectorFrameParcel convert(MLFrame mLFrame, BcrDetectorOptionsParcel bcrDetectorOptionsParcel) {
        Bitmap bitmap = mLFrame.readBitmap();
        ByteBuffer byteBuffer = mLFrame.getByteBuffer();
        Preconditions.checkState((bitmap == null && byteBuffer == null) ? false : true, "bitmap and byteBuffer can't be empty at the same time");
        MLFrame.Property propertyAcquireProperty = mLFrame.acquireProperty();
        return new BcrDetectorFrameParcel.Builder().setBytes(byteBuffer == null ? null : byteBuffer.array()).setBitmap(bitmap).setWidth(propertyAcquireProperty.getWidth()).setHeight(propertyAcquireProperty.getHeight()).setRotation(propertyAcquireProperty.getQuadrant()).setFormat(propertyAcquireProperty.getFormatType()).build();
    }
}
