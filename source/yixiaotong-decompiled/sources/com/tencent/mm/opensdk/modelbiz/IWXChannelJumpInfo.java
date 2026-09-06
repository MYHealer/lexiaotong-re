package com.tencent.mm.opensdk.modelbiz;

import android.os.Bundle;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public interface IWXChannelJumpInfo {
    public static final int WX_CHANNEL_JUMP_TYPE_MINI_PROGRAM = 1;
    public static final int WX_CHANNEL_JUMP_TYPE_UNKNOWN = 0;
    public static final int WX_CHANNEL_JUMP_TYPE_URL = 2;

    boolean checkArgs();

    void serialize(Bundle bundle);

    int type();

    void unserialize(Bundle bundle);
}
