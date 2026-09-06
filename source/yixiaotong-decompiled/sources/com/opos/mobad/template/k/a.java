package com.opos.mobad.template.k;

import android.view.MotionEvent;
import androidx.core.view.InputDeviceCompat;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class a {
    public static boolean a(MotionEvent motionEvent) {
        if (motionEvent == null) {
            return false;
        }
        try {
            b(motionEvent);
        } catch (Exception e) {
            com.opos.cmn.an.f.a.b("isPhysicalClick", e);
        }
        int source = motionEvent.getSource();
        return (source & 257) == 257 || (source & 513) == 513 || (source & 1025) == 1025 || (source & 4098) == 4098 || (source & 8194) == 8194 || (source & InputDeviceCompat.SOURCE_STYLUS) == 16386 || (source & 49154) == 49154 || (source & InputDeviceCompat.SOURCE_TRACKBALL) == 65540 || (source & 131076) == 131076 || (source & InputDeviceCompat.SOURCE_TOUCHPAD) == 1048584 || (source & 2097152) == 2097152 || (source & 4194304) == 4194304 || (source & InputDeviceCompat.SOURCE_JOYSTICK) == 16777232 || (source & InputDeviceCompat.SOURCE_HDMI) == 33554433;
    }

    private static void b(MotionEvent motionEvent) {
        int source = motionEvent.getSource();
        com.opos.cmn.an.f.a.a("DeviceUtils", "Motion event is from sources: " + ((source & 257) != 0 ? "keyboard " : "") + ((source & 513) != 0 ? "dpad " : "") + ((source & 1025) != 0 ? "gamepad " : "") + ((source & 4098) != 0 ? "touchscreen " : "") + ((source & 8194) != 0 ? "mouse " : "") + ((source & InputDeviceCompat.SOURCE_STYLUS) != 0 ? "stylus " : "") + ((49154 & source) != 0 ? "bt_stylus " : "") + ((65540 & source) != 0 ? "trackball " : "") + ((131076 & source) != 0 ? "mouse_relative " : "") + ((1048584 & source) != 0 ? "touchpad " : "") + ((2097152 & source) != 0 ? "touch_navigation " : "") + ((4194304 & source) != 0 ? "rotary_encoder " : "") + ((16777232 & source) != 0 ? "joystick " : "") + ((source & InputDeviceCompat.SOURCE_HDMI) != 0 ? "hdmi" : ""));
    }
}
