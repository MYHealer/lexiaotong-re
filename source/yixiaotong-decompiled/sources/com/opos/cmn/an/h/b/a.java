package com.opos.cmn.an.h.b;

import android.content.Context;
import android.media.AudioManager;
import com.stub.StubApp;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static AudioManager f5931a;

    public static AudioManager a(Context context) {
        if (f5931a == null && context != null) {
            f5931a = (AudioManager) StubApp.getOrigApplicationContext(context.getApplicationContext()).getSystemService("audio");
        }
        return f5931a;
    }

    public static int b(Context context) {
        try {
            AudioManager audioManagerA = a(context);
            if (audioManagerA != null) {
                return audioManagerA.getStreamVolume(3);
            }
            return 0;
        } catch (Exception e) {
            com.opos.cmn.an.f.a.c("AudioMgrTool", "", e);
            return 0;
        }
    }
}
