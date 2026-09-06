package com.baidu.mobads.sdk.internal;

import android.widget.RelativeLayout;
import com.baidu.mobads.sdk.api.IOAdEvent;
import com.baidu.mobads.sdk.api.IOAdEventListener;
import com.baidu.mobads.sdk.api.ShakeViewContainer;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
public class al implements ShakeViewContainer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private RelativeLayout f1720a;
    private IOAdEventListener b;

    @Override // com.baidu.mobads.sdk.api.ShakeViewContainer
    public RelativeLayout getContainer() {
        return this.f1720a;
    }

    public al(RelativeLayout relativeLayout, IOAdEventListener iOAdEventListener) {
        this.f1720a = relativeLayout;
        this.b = iOAdEventListener;
    }

    @Override // com.baidu.mobads.sdk.api.ShakeViewContainer
    public void resume() {
        IOAdEventListener iOAdEventListener = this.b;
        if (iOAdEventListener != null) {
            iOAdEventListener.run(new a(com.huawei.openalliance.ad.constant.ba.ag));
        }
    }

    @Override // com.baidu.mobads.sdk.api.ShakeViewContainer
    public void pause() {
        IOAdEventListener iOAdEventListener = this.b;
        if (iOAdEventListener != null) {
            iOAdEventListener.run(new a("pause"));
        }
    }

    @Override // com.baidu.mobads.sdk.api.ShakeViewContainer
    public void destroy() {
        IOAdEventListener iOAdEventListener = this.b;
        if (iOAdEventListener != null) {
            iOAdEventListener.run(new a("destroy"));
        }
        this.b = null;
        this.f1720a = null;
    }

    private static class a implements IOAdEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f1721a;

        @Override // com.baidu.mobads.sdk.api.IOAdEvent
        public int getCode() {
            return 0;
        }

        @Override // com.baidu.mobads.sdk.api.IOAdEvent
        public Map<String, Object> getData() {
            return null;
        }

        @Override // com.baidu.mobads.sdk.api.IOAdEvent
        public String getMessage() {
            return this.f1721a;
        }

        @Override // com.baidu.mobads.sdk.api.IOAdEvent
        public Object getTarget() {
            return null;
        }

        @Override // com.baidu.mobads.sdk.api.IOAdEvent
        public String getType() {
            return "native_shake";
        }

        @Override // com.baidu.mobads.sdk.api.IOAdEvent
        public void setTarget(Object obj) {
        }

        a(String str) {
            this.f1721a = str;
        }
    }
}
