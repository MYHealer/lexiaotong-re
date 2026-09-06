package com.heytap.msp.mobad.api.listener;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public interface IInitListener {
    public static final IInitListener NONE = new IInitListener() { // from class: com.heytap.msp.mobad.api.listener.IInitListener.1
        @Override // com.heytap.msp.mobad.api.listener.IInitListener
        public void onFailed(String str) {
        }

        @Override // com.heytap.msp.mobad.api.listener.IInitListener
        public void onSuccess() {
        }
    };

    void onFailed(String str);

    void onSuccess();
}
