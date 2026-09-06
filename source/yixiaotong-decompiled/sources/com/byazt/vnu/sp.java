package com.byazt.vnu;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.io.IOException;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
@com.byazt.zqa.c(c = {0, 1, 699, MediaPlayer.MEDIA_PLAYER_OPTION_MEDIA_CODEC_AUTO_RECOVERY})
public class sp extends a {
    public sp(i iVar) {
        super(iVar);
    }

    public int[] c(int i) throws IOException {
        int[] iArr = new int[i];
        for (int i2 = 0; i2 < i; i2++) {
            iArr[i2] = readInt();
        }
        return iArr;
    }

    public void c() throws IOException {
        skipBytes(4);
    }

    public void c(int i, int i2) throws IOException {
        int i3 = readInt();
        if (i3 != i && i3 != i2) {
            throw new IOException(String.format("Expected: 0x%08x or 0x%08x, got: 0x%08x", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)));
        }
    }

    public void c(short s) throws IOException {
        short s2 = readShort();
        if (s2 != s) {
            throw new IOException(String.format("Expected: 0x%08x, got: 0x%08x", Short.valueOf(s), Short.valueOf(s2)));
        }
    }

    public void c(byte b) throws IOException {
        byte b2 = readByte();
        if (b2 != b) {
            throw new IOException(String.format("Expected: 0x%08x, got: 0x%08x", Byte.valueOf(b), Byte.valueOf(b2)));
        }
    }

    public void tt(int i, int i2) throws IOException {
        int i3 = readInt();
        if (i3 == i2 || i3 < i) {
            tt(i, -1);
        } else if (i3 != i) {
            throw new IOException(String.format("Expected: 0x%08x, got: 0x%08x", Integer.valueOf(i), Integer.valueOf(i3)));
        }
    }

    @Override // com.byazt.vnu.a, java.io.DataInput
    public final int skipBytes(int i) throws IOException {
        int i2 = 0;
        while (i2 < i) {
            int iSkipBytes = super.skipBytes(i - i2);
            if (iSkipBytes <= 0) {
                break;
            }
            i2 += iSkipBytes;
        }
        return i2;
    }
}
