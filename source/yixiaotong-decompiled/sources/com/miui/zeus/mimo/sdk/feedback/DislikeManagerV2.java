package com.miui.zeus.mimo.sdk.feedback;

import android.content.Context;
import android.content.Intent;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import com.miui.zeus.mimo.sdk.a9;
import com.miui.zeus.mimo.sdk.c9;
import com.miui.zeus.mimo.sdk.m;
import com.miui.zeus.mimo.sdk.x8;
import com.xiaomi.ad.feedback.IAdFeedbackListener;
import com.xiaomi.ad.feedback.IAdFeedbackService;
import ijiami_1011.s.s.s;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class DislikeManagerV2 {
    private static final String TAG = s.d(new byte[]{117, 13, 68, 15, 8, 95, 4, 41, 7, 12, 80, 2, 84, Ascii.SYN, 97, 81}, "1d7ca4");
    private static volatile DislikeManagerV2 sManager;

    public class a extends a9<Void, IAdFeedbackService> {
        public final /* synthetic */ IAdFeedbackListener g;
        public final /* synthetic */ String h;
        public final /* synthetic */ String i;
        public final /* synthetic */ String j;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(DislikeManagerV2 dislikeManagerV2, Context context, Class cls, IAdFeedbackListener iAdFeedbackListener, String str, String str2, String str3) {
            super(context, cls);
            this.g = iAdFeedbackListener;
            this.h = str;
            this.i = str2;
            this.j = str3;
        }
    }

    private DislikeManagerV2() {
    }

    private Intent buildIntent() {
        Intent intent = new Intent(s.d(new byte[]{93, 10, 67, 12, 75, 88, 15, 16, 3, 12, 69, 75, 81, 0, 66, 12, 10, 95, 79, 5, 2, 76, 119, 32, 117, 39, 116, 36, 38, 122, 62, 55, 35, 48, 103, 44, 115, 38}, "0c6ee1"));
        intent.setPackage(s.d(new byte[]{1, 88, 84, 75, 8, 11, Ascii.DC4, 13, 72, 17, 72, Ascii.SYN, Ascii.SYN, 82, 84, 36, 1, 49, 14, 8, 19, Ascii.SYN, 88, 10, 12}, "b79eeb"));
        return intent;
    }

    public static DislikeManagerV2 getInstance() {
        if (sManager == null) {
            synchronized (DislikeManagerV2.class) {
                if (sManager == null) {
                    sManager = new DislikeManagerV2();
                }
            }
        }
        return sManager;
    }

    private boolean isSupported(Context context) {
        if (context == null) {
            return false;
        }
        return !context.getPackageManager().queryIntentServices(buildIntent(), 0).isEmpty();
    }

    public void showDislikeWindow(Context context, IAdFeedbackListener iAdFeedbackListener, String str, String str2, String str3) {
        if (context == null) {
            m.a(TAG, s.d(new byte[]{75, 12, 91, 19, 112, 90, Ascii.DC2, 8, 15, 9, 84, 50, 81, 10, 80, 11, 67, 9, 65, 7, 9, 12, 69, 0, SignedBytes.MAX_POWER_OF_TWO, 16, Ascii.DC4, 13, 71, 19, 15, 17, 10, 14}, "8d4d43"));
            return;
        }
        if (isSupported(context)) {
            a aVar = new a(this, context, IAdFeedbackService.class, iAdFeedbackListener, str, str2, str3);
            Intent intentBuildIntent = buildIntent();
            aVar.e = System.currentTimeMillis();
            x8.i.execute(new c9(aVar, s.d(new byte[]{96, 80, 91, 12, 17, 81, 44, 1, Ascii.DC2, 10, 94, 1, 123, 91, SignedBytes.MAX_POWER_OF_TWO, 12, 14, 81, 19}, "256ce4"), s.d(new byte[]{91, 94, 79, 87, 8, 0, 32, Ascii.ETB, Ascii.US, 12, 82, 69, 87, 72, 90, 93, 19, 17, 8, 11, 8}, "2098ce"), intentBuildIntent));
        }
    }
}
