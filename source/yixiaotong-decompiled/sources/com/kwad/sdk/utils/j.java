package com.kwad.sdk.utils;

import android.content.Context;
import android.media.AudioAttributes;
import android.media.AudioFocusRequest;
import android.media.AudioManager;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class j {
    private AudioManager aZy;
    private AudioManager.OnAudioFocusChangeListener bov = new AudioManager.OnAudioFocusChangeListener() { // from class: com.kwad.sdk.utils.j.1
        @Override // android.media.AudioManager.OnAudioFocusChangeListener
        public final void onAudioFocusChange(final int i) {
            if (j.this.kF == null) {
                return;
            }
            by.postOnUiThread(new Runnable() { // from class: com.kwad.sdk.utils.j.1.1
                @Override // java.lang.Runnable
                public final void run() {
                    if (i < 0) {
                        j.this.kF.onAudioBeOccupied();
                    } else {
                        j.this.kF.onAudioBeReleased();
                    }
                }
            });
        }
    };
    private a kF;

    public interface a {
        void onAudioBeOccupied();

        void onAudioBeReleased();
    }

    public final void c(a aVar) {
        this.kF = aVar;
    }

    public j(Context context) {
        this.aZy = (AudioManager) context.getSystemService("audio");
    }

    public final boolean Ut() {
        try {
            return (this.bov == null || this.aZy == null || 1 != this.aZy.requestAudioFocus(Uu())) ? false : true;
        } catch (Throwable unused) {
        }
    }

    private AudioFocusRequest Uu() {
        return new AudioFocusRequest.Builder(2).setAudioAttributes(new AudioAttributes.Builder().setLegacyStreamType(3).setUsage(1).setContentType(2).build()).setAcceptsDelayedFocusGain(false).setOnAudioFocusChangeListener(this.bov).build();
    }
}
