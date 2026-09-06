package com.byazt.hj;

import android.util.SparseArray;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.sdk.openadsdk.TTAdDislike;
import java.util.function.Function;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_FRAME_DROPPING_TERMINATED_DTS, MediaPlayer.MEDIA_PLAYER_OPTION_MEDIA_CODEC_AUTO_RECOVERY})
public class sp implements TTAdDislike {
    public final Function<SparseArray<Object>, Object> c;

    public sp(Function<SparseArray<Object>, Object> function) {
        this.c = function == null ? com.byazt.rl.ve.ve : function;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdDislike
    public void showDislikeDialog() {
        SparseArray<Object> sparseArray = new SparseArray<>();
        sparseArray.put(-99999987, 240101);
        sparseArray.put(-99999985, Void.class);
        this.c.apply(sparseArray);
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdDislike
    public void setDislikeInteractionCallback(TTAdDislike.DislikeInteractionCallback dislikeInteractionCallback) {
        SparseArray<Object> sparseArray = new SparseArray<>();
        sparseArray.put(-99999987, 240102);
        sparseArray.put(-99999985, Void.class);
        sparseArray.put(0, new com.byazt.ebk.c(dislikeInteractionCallback));
        this.c.apply(sparseArray);
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdDislike
    public void setDislikeSource(String str) {
        SparseArray<Object> sparseArray = new SparseArray<>();
        sparseArray.put(-99999987, 240103);
        sparseArray.put(-99999985, Void.class);
        sparseArray.put(0, str);
        this.c.apply(sparseArray);
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdDislike
    public void resetDislikeStatus() {
        SparseArray<Object> sparseArray = new SparseArray<>();
        sparseArray.put(-99999987, 240104);
        sparseArray.put(-99999985, Void.class);
        this.c.apply(sparseArray);
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdDislike
    public boolean isShow() {
        SparseArray<Object> sparseArray = new SparseArray<>();
        sparseArray.put(-99999987, 240105);
        sparseArray.put(-99999985, Boolean.class);
        Boolean bool = (Boolean) this.c.apply(sparseArray);
        if (bool != null) {
            return bool.booleanValue();
        }
        return false;
    }
}
