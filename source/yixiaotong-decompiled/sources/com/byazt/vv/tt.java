package com.byazt.vv;

import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.HashMap;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
@com.byazt.zqa.c(c = {0, 1, 685, 13})
public final class tt {

    /* JADX INFO: renamed from: com.byazt.vv.tt$tt, reason: collision with other inner class name */
    public interface InterfaceC0307tt {
        void c(Bitmap bitmap);
    }

    public static void c(long j, String str, InterfaceC0307tt interfaceC0307tt) {
        new c(interfaceC0307tt, j).c((Object[]) new String[]{str});
    }

    @com.byazt.zqa.c(c = {0, 1, 685, MediaPlayer.MEDIA_PLAYER_OPTION_JX_CODEC_LOW_LATENCY})
    public static class c extends com.byazt.jtc.tt<String, Integer, Bitmap> {
        public InterfaceC0307tt c;
        public long tt;

        public c(InterfaceC0307tt interfaceC0307tt, long j) {
            this.c = interfaceC0307tt;
            this.tt = j;
        }

        @Override // android.os.AsyncTask
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public Bitmap doInBackground(String... strArr) {
            Bitmap frameAtTime = null;
            try {
                MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
                String str = strArr[0];
                if (str.startsWith("http")) {
                    mediaMetadataRetriever.setDataSource(str, new HashMap());
                } else {
                    mediaMetadataRetriever.setDataSource(str);
                }
                frameAtTime = mediaMetadataRetriever.getFrameAtTime(this.tt * 1000, 3);
                mediaMetadataRetriever.release();
                return frameAtTime;
            } catch (Throwable th) {
                com.byazt.lt.tt.ve("MediaUtils", "MediaUtils doInBackground : ", th);
                return frameAtTime;
            }
        }

        @Override // android.os.AsyncTask
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(Bitmap bitmap) {
            super.onPostExecute(bitmap);
            InterfaceC0307tt interfaceC0307tt = this.c;
            if (interfaceC0307tt != null) {
                interfaceC0307tt.c(bitmap);
            }
        }
    }
}
