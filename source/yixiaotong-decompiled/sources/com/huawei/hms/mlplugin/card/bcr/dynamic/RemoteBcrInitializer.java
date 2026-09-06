package com.huawei.hms.mlplugin.card.bcr.dynamic;

import android.os.IBinder;
import android.os.IInterface;
import com.huawei.hms.ml.common.card.bcr.IRemoteBcrCreator;
import com.huawei.hms.ml.common.utils.SmartLog;
import com.huawei.hms.mlsdk.dynamic.AbstractInitializer;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class RemoteBcrInitializer extends AbstractInitializer {
    private static final String CREATOR_CLASS = "com.huawei.hms.mlkit.bcr.Creator";
    private static final String MODULE_NAME = "huawei_module_mlkit_bcr";
    private static final String TAG = "RemoteBcrInitializer";

    /* JADX INFO: renamed from: com.huawei.hms.mlplugin.card.bcr.dynamic.RemoteBcrInitializer$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    public String getCreatorClass() {
        return CREATOR_CLASS;
    }

    protected int getMinApkVersion() {
        return 10000300;
    }

    protected String getModuleName() {
        return "huawei_module_mlkit_bcr";
    }

    /* synthetic */ RemoteBcrInitializer(AnonymousClass1 anonymousClass1) {
        this();
    }

    private static final class Holder {
        static final RemoteBcrInitializer INSTANCE = new RemoteBcrInitializer(null);

        private Holder() {
        }
    }

    private RemoteBcrInitializer() {
    }

    public static RemoteBcrInitializer getInstance() {
        return Holder.INSTANCE;
    }

    public synchronized IInterface getDynamicDelegate() {
        return super.getDynamicDelegate();
    }

    public void release() {
        SmartLog.d(TAG, "BCR excute release method");
    }

    protected IInterface generateDynamicDelegateBridge(IBinder iBinder) throws Exception {
        return IRemoteBcrCreator.Stub.asInterface(iBinder).newRemoteBcrDecoderDelegate();
    }
}
