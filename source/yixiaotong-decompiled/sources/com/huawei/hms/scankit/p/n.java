package com.huawei.hms.scankit.p;

import androidx.core.view.InputDeviceCompat;
import com.alibaba.fastjson.asm.Opcodes;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: compiled from: Base256Encoder.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
final class n implements l2 {
    n() {
    }

    public int a() {
        return 5;
    }

    @Override // com.huawei.hms.scankit.p.l2
    public void a(o2 o2Var) {
        StringBuilder sb = new StringBuilder();
        sb.append((char) 0);
        while (o2Var.i()) {
            sb.append(o2Var.c());
            o2Var.f++;
            if (m3.a(o2Var.d(), o2Var.f, a()) != a()) {
                o2Var.b(0);
                break;
            }
        }
        int length = sb.length() - 1;
        int iA = o2Var.a() + length + 1;
        o2Var.c(iA);
        boolean z = o2Var.g().a() - iA > 0;
        if (o2Var.i() || z) {
            if (length <= 249) {
                sb.setCharAt(0, (char) length);
            } else {
                if (length > 1555) {
                    throw new IllegalStateException("Message length not in valid ranges: " + length);
                }
                sb.setCharAt(0, (char) ((length / 250) + MediaPlayer.MEDIA_PLAYER_OPTION_TT_HLS_DRM_TOKEN));
                sb.insert(1, (char) (length % 250));
            }
        }
        int length2 = sb.length();
        for (int i = 0; i < length2; i++) {
            o2Var.a(a(sb.charAt(i), o2Var.a() + 1));
        }
    }

    private static char a(char c, int i) {
        int i2 = c + ((i * Opcodes.FCMPL) % 255) + 1;
        return i2 <= 255 ? (char) i2 : (char) (i2 + InputDeviceCompat.SOURCE_ANY);
    }
}
