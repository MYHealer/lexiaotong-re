package client.android.yixiaotong.controller.core;

import client.android.yixiaotong.BaseInterface;
import client.android.yixiaotong.exception.ClientException;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6847780.dex */
public class PostListener<R> extends Listener<R> {
    private BaseInterface mBase;

    public PostListener(BaseInterface baseInterface) {
        this.mBase = baseInterface;
    }

    @Override // client.android.yixiaotong.controller.core.Listener
    public void onStart(Controller controller) {
        super.onStart(controller);
        BaseInterface baseInterface = this.mBase;
        if (baseInterface != null) {
            baseInterface.onWaitStart("处理中,请稍候...");
        }
    }

    @Override // client.android.yixiaotong.controller.core.Listener
    public void onComplete(Controller controller, R r, Object... objArr) {
        super.onComplete(controller, r, objArr);
        BaseInterface baseInterface = this.mBase;
        if (baseInterface != null) {
            baseInterface.onWaitEnd();
        }
    }

    @Override // client.android.yixiaotong.controller.core.Listener
    public void onFail(Controller controller, ClientException clientException) {
        super.onFail(controller, clientException);
        BaseInterface baseInterface = this.mBase;
        if (baseInterface != null) {
            baseInterface.onWaitEnd();
            this.mBase.handlerException(clientException);
        }
    }
}
