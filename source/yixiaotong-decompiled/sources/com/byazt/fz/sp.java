package com.byazt.fz;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.math.BigDecimal;
import java.math.RoundingMode;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, 1022, MediaPlayer.MEDIA_PLAYER_OPTION_MEDIA_CODEC_AUTO_RECOVERY})
public class sp implements sl {
    @Override // com.byazt.fz.sl
    /* JADX INFO: renamed from: tt, reason: merged with bridge method [inline-methods] */
    public Number c(JSONObject jSONObject, Object[] objArr) {
        if (objArr == null || objArr.length < 3) {
            return null;
        }
        Number numberC = c(objArr[0]);
        int iC = c(objArr[1], 0);
        boolean zC = c(objArr[2], false);
        if (numberC == null) {
            return null;
        }
        return c(numberC, iC, zC);
    }

    public Number c(Number number, int i, boolean z) {
        BigDecimal scale;
        if (number == null) {
            return null;
        }
        int iMax = Math.max(i, 0);
        BigDecimal bigDecimalValueOf = BigDecimal.valueOf(number.doubleValue());
        if (z) {
            scale = bigDecimalValueOf.setScale(iMax, RoundingMode.HALF_UP);
        } else {
            scale = bigDecimalValueOf.setScale(iMax, RoundingMode.DOWN);
        }
        if (iMax == 0 || scale.stripTrailingZeros().scale() <= 0) {
            return Long.valueOf(scale.longValue());
        }
        return Double.valueOf(scale.doubleValue());
    }

    private Number c(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof Number) {
            return (Number) obj;
        }
        if (obj instanceof String) {
            try {
                return Double.valueOf(Double.parseDouble((String) obj));
            } catch (NumberFormatException unused) {
            }
        }
        return null;
    }

    private int c(Object obj, int i) {
        if (obj instanceof Number) {
            return ((Number) obj).intValue();
        }
        if (obj instanceof String) {
            try {
                return Integer.parseInt((String) obj);
            } catch (NumberFormatException unused) {
            }
        }
        return i;
    }

    private boolean c(Object obj, boolean z) {
        if (obj instanceof Boolean) {
            return ((Boolean) obj).booleanValue();
        }
        return obj instanceof String ? Boolean.parseBoolean((String) obj) : z;
    }
}
