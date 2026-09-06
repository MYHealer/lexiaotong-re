package com.squareup.picasso;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public interface Callback {

    public static class EmptyCallback implements Callback {
        @Override // com.squareup.picasso.Callback
        public void onError() {
        }

        @Override // com.squareup.picasso.Callback
        public void onSuccess() {
        }
    }

    void onError();

    void onSuccess();
}
