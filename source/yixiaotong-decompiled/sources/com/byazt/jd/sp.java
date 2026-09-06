package com.byazt.jd;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import com.byazt.nr.m;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.stub.StubApp;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, 1500, MediaPlayer.MEDIA_PLAYER_OPTION_MEDIA_CODEC_AUTO_RECOVERY})
public class sp {
    public static final Object ve = new Object();
    public c c;
    public Context tt;

    public c c() {
        return this.c;
    }

    public sp(Context context) {
        try {
            this.tt = context == null ? com.byazt.bp.tt.getContext() : StubApp.getOrigApplicationContext(context.getApplicationContext());
            if (this.c == null) {
                this.c = new c();
            }
        } catch (Throwable th) {
            m.c(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Context getContext() {
        Context context = this.tt;
        return context == null ? com.byazt.bp.tt.getContext() : context;
    }

    @com.byazt.zqa.c(c = {0, 1, 1500, 180})
    public class c {
        public SQLiteDatabase tt = null;

        public c() {
        }

        private void tt() {
            try {
                synchronized (sp.ve) {
                    SQLiteDatabase sQLiteDatabase = this.tt;
                    if (sQLiteDatabase == null || !sQLiteDatabase.isOpen()) {
                        SQLiteDatabase writableDatabase = new x(sp.this.getContext(), "tt_mediation_open_sdk.db", 4).getWritableDatabase();
                        this.tt = writableDatabase;
                        writableDatabase.setLockingEnabled(false);
                    }
                }
            } catch (Throwable th) {
                m.c(th);
                ve();
            }
        }

        public SQLiteDatabase c() {
            tt();
            return this.tt;
        }

        private boolean ve() {
            SQLiteDatabase sQLiteDatabase = this.tt;
            return sQLiteDatabase != null && sQLiteDatabase.isOpen() && sQLiteDatabase.inTransaction();
        }
    }
}
