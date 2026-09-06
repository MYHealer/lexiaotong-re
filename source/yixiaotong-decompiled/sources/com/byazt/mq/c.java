package com.byazt.mq;

import android.app.Application;
import android.content.Context;
import android.os.Build;
import com.byazt.uq.i;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.pangle.util.FieldUtils;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_LIVE_AVPH_READ_RETRY_COUNT, 20})
public final class c {
    public static final ve c;

    /* JADX INFO: renamed from: com.byazt.mq.c$1, reason: invalid class name */
    @com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_LIVE_AVPH_READ_RETRY_COUNT, 26})
    static /* synthetic */ class AnonymousClass1 {
    }

    private interface ve {
        boolean c(Context context) throws Throwable;
    }

    static {
        AnonymousClass1 anonymousClass1 = null;
        if (Build.VERSION.SDK_INT < 28) {
            c = new n(anonymousClass1);
        } else {
            c = new tt(anonymousClass1);
        }
    }

    public static void c(Application application) {
        if (application != null) {
            try {
                if (i.my()) {
                    c.c(application.getBaseContext());
                }
            } catch (Throwable unused) {
            }
        }
    }

    @com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_LIVE_AVPH_READ_RETRY_COUNT, MediaPlayer.MEDIA_PLAYER_OPTION_ABR_AVERAGE_PLAY_SPEED})
    private static class tt extends n {
        @Override // com.byazt.mq.c.n, com.byazt.mq.c.C0214c, com.byazt.mq.c.ve
        public boolean c(Context context) throws Throwable {
            return false;
        }

        private tt() {
            super(null);
        }

        public /* synthetic */ tt(AnonymousClass1 anonymousClass1) {
            this();
        }
    }

    @com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_LIVE_AVPH_READ_RETRY_COUNT, MediaPlayer.MEDIA_PLAYER_OPTION_LIVE_AVPH_READ_ERROR_EXIT})
    private static class n extends C0214c {
        private n() {
            super(null);
        }

        public /* synthetic */ n(AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // com.byazt.mq.c.C0214c, com.byazt.mq.c.ve
        public boolean c(Context context) throws Throwable {
            Object objC = c(context, "mWhiteListMap");
            if (!(objC instanceof Map)) {
                return false;
            }
            Map map = (Map) objC;
            List arrayList = (List) map.get(0);
            if (arrayList == null) {
                arrayList = new ArrayList();
                map.put(0, arrayList);
            }
            arrayList.add(context.getPackageName());
            return true;
        }
    }

    @com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_LIVE_AVPH_READ_RETRY_COUNT, 187})
    private static class uj extends C0214c {
        private uj() {
            super(null);
        }

        public /* synthetic */ uj(AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // com.byazt.mq.c.C0214c, com.byazt.mq.c.ve
        public boolean c(Context context) throws Throwable {
            Object objC = c(context, "mWhiteList");
            if (!(objC instanceof List)) {
                return false;
            }
            ((List) objC).add(context.getPackageName());
            return true;
        }
    }

    /* JADX INFO: renamed from: com.byazt.mq.c$c, reason: collision with other inner class name */
    @com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_LIVE_AVPH_READ_RETRY_COUNT, 44})
    private static class C0214c implements ve {
        private C0214c() {
        }

        public /* synthetic */ C0214c(AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // com.byazt.mq.c.ve
        public boolean c(Context context) throws Throwable {
            Object objTt = tt(context);
            Object objC = c(objTt, "mWhiteList");
            if (!(objC instanceof String[])) {
                if (objTt == null) {
                    return false;
                }
                FieldUtils.writeField(objTt, "mResourceConfig", (Object) null);
                return false;
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(context.getPackageName());
            Collections.addAll(arrayList, (String[]) objC);
            FieldUtils.writeField(objTt, "mWhiteList", arrayList.toArray(new String[arrayList.size()]));
            return true;
        }

        public Object c(Context context, String str) {
            return c(tt(context), str);
        }

        private Object c(Object obj, String str) {
            if (obj == null) {
                return null;
            }
            try {
                return FieldUtils.readField(obj, str);
            } catch (Throwable unused) {
                return null;
            }
        }

        private Object tt(Context context) {
            Field field;
            Object field2;
            try {
                Field field3 = FieldUtils.getField(Class.forName("android.app.LoadedApk"), "mReceiverResource");
                if (field3 == null || (field = FieldUtils.getField(Class.forName("android.app.ContextImpl"), "mPackageInfo")) == null || (field2 = FieldUtils.readField(field, context)) == null) {
                    return null;
                }
                return FieldUtils.readField(field3, field2);
            } catch (Throwable unused) {
                return null;
            }
        }
    }
}
