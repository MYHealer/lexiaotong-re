package com.ubixnow.ooooo;

import android.net.Uri;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class oOOOoo00 {
    public static final String OooO = "app_start_time";
    public static final String OooO00o = "events";
    public static final String OooO0O0 = "t_channel";
    public static final int OooO0OO = -2;
    public static final String OooO0Oo = "event_name";
    public static final String OooO0o = "ubixnow";
    public static final String OooO0o0 = "result";
    public static final int OooO0oO = 1;
    public static final String OooO0oo = "activity_started_count";
    public static final String OooOO0 = "app_end_time";
    public static final String OooOO0O = "app_end_data";
    public static final String OooOO0o = "sub_process_flush_data";
    public static final String OooOOO = "session_interval_time";
    public static final String OooOOO0 = "first_process_start";
    public static final String OooOOOO = "data_collect";
    public static final String OooOOOo = "enable_SDK";
    public static final String OooOOo = "remote_config";
    public static final String OooOOo0 = "disable_SDK";
    public static final String OooOOoo = "events_login_id";
    public static final String OooOo = "1";
    public static final String OooOo0 = "created_at";
    public static final String OooOo00 = "data";
    public static final int OooOo0O = -1;
    public static final String OooOo0o = "value";
    public static final String OooOoO = "DB_DELETE_ALL";
    public static final String OooOoO0 = "9";
    private static oOOOoo00 OooOoOO;
    private final Uri OooOoo;
    private final Uri OooOoo0;
    private final Uri OooOooO;
    private final Uri OooOooo;
    private final Uri Oooo0;
    private final Uri Oooo000;
    private final Uri Oooo00O;
    private final Uri Oooo00o;
    private final Uri Oooo0O0;
    private final Uri Oooo0OO;
    private final Uri Oooo0o;
    private final Uri Oooo0o0;
    private final Uri Oooo0oO;
    private final Uri Oooo0oo;

    private oOOOoo00(String str) {
        this.OooOoo0 = Uri.parse("content://" + str + ".UbixDataContentProvider/events");
        this.OooOoo = Uri.parse("content://" + str + ".UbixDataContentProvider/activity_started_count");
        this.OooOooO = Uri.parse("content://" + str + ".UbixDataContentProvider/app_start_time");
        this.Oooo00O = Uri.parse("content://" + str + ".UbixDataContentProvider/app_end_data");
        this.OooOooo = Uri.parse("content://" + str + ".UbixDataContentProvider/app_end_time");
        this.Oooo00o = Uri.parse("content://" + str + ".UbixDataContentProvider/session_interval_time");
        this.Oooo0 = Uri.parse("content://" + str + ".UbixDataContentProvider/events_login_id");
        this.Oooo0O0 = Uri.parse("content://" + str + ".UbixDataContentProvider/t_channel");
        this.Oooo0OO = Uri.parse("content://" + str + ".UbixDataContentProvider/sub_process_flush_data");
        this.Oooo0o0 = Uri.parse("content://" + str + ".UbixDataContentProvider/first_process_start");
        this.Oooo000 = Uri.parse("content://" + str + ".UbixDataContentProvider/data_collect");
        this.Oooo0o = Uri.parse("content://" + str + ".UbixDataContentProvider/enable_SDK");
        this.Oooo0oO = Uri.parse("content://" + str + ".UbixDataContentProvider/disable_SDK");
        this.Oooo0oo = Uri.parse("content://" + str + ".UbixDataContentProvider/remote_config");
    }

    public static oOOOoo00 OooO00o(String str) {
        if (OooOoOO == null) {
            OooOoOO = new oOOOoo00(str);
        }
        return OooOoOO;
    }

    public static oOOOoo00 OooOO0O() {
        oOOOoo00 oooooo00 = OooOoOO;
        if (oooooo00 != null) {
            return oooooo00;
        }
        throw new IllegalStateException("The static method getInstance(String packageName) should be called before calling getInstance()");
    }

    public Uri OooO() {
        return this.OooOoo0;
    }

    public Uri OooO00o() {
        return this.OooOoo;
    }

    public Uri OooO0O0() {
        return this.Oooo00O;
    }

    public Uri OooO0OO() {
        return this.OooOooo;
    }

    public Uri OooO0Oo() {
        return this.OooOooO;
    }

    public Uri OooO0o() {
        return this.Oooo000;
    }

    public Uri OooO0o0() {
        return this.Oooo0O0;
    }

    public Uri OooO0oO() {
        return this.Oooo0oO;
    }

    public Uri OooO0oo() {
        return this.Oooo0o;
    }

    public Uri OooOO0() {
        return this.Oooo0o0;
    }

    public Uri OooOO0o() {
        return this.Oooo0;
    }

    public Uri OooOOO() {
        return this.Oooo00o;
    }

    public Uri OooOOO0() {
        return this.Oooo0oo;
    }

    public Uri OooOOOO() {
        return this.Oooo0OO;
    }
}
