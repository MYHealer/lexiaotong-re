package com.byazt.xyr;

import android.content.Context;
import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_FIND_STREAM_INFO_PROBE_DURATION, 54})
public class ve extends com.byazt.ji.tt {
    public String sl;

    public ve(Context context) {
        super(context);
    }

    /* JADX WARN: Code duplicated, block: B:13:0x001d  */
    /* JADX WARN: Code duplicated, block: B:7:0x000f  */
    @Override // com.byazt.ji.tt
    public boolean c(Object... objArr) {
        String str;
        String str2;
        if (objArr.length > 0) {
            Object obj = objArr[0];
            if (obj instanceof String) {
                str = (String) obj;
            } else {
                str = "";
            }
        } else {
            str = "";
        }
        if (objArr.length > 1) {
            Object obj2 = objArr[1];
            if (obj2 instanceof String) {
                str2 = (String) obj2;
            } else {
                str2 = "";
            }
        } else {
            str2 = "";
        }
        if (this.n != null && this.n.size() > 0) {
            Object obj3 = this.n.get("id");
            String strValueOf = obj3 != null ? String.valueOf(obj3) : "";
            Object obj4 = this.n.get("state");
            this.sl = obj4 != null ? String.valueOf(obj4) : "";
            if (!TextUtils.isEmpty(strValueOf) && this.tt.tt(this.tt) != null && TextUtils.equals(str, strValueOf) && TextUtils.equals(str2, this.sl)) {
                if (this.c != null) {
                    this.c.c(this.tt, this.f2381a, this.ve.tt(), this.ve);
                }
                return true;
            }
        }
        return false;
    }
}
