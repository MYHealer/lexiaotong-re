package com.bykv.vk.component.ttvideo.player;

import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
public interface FrameMetadataListener {
    void frameDTSNotify(int i, long j, long j2);

    void onFrameAboutToBeRendered(int i, long j, long j2, Map<Integer, String> map);

    void updateFrameTerminatedDTS(int i, long j, long j2);
}
