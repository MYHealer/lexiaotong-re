package com.ubix.ssp.ad.e.w;

import com.ubixnow.ooooo.o0OO000o;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public enum j {
    LaunchStart("launch_start", o0OO000o.OooO0O0),
    LaunchLocalSuccess("launch_local_succ", o0OO000o.OooO0Oo),
    LaunchLocalFail("launch_local_fail", "1", 2),
    LaunchNetFail("launch_net_fail", "1", 2),
    DetectSuccess("ask_succ", o0OO000o.o000, 4),
    RequestStart("request_start", o0OO000o.OooOOO0),
    RequestSuccess("request_succ", "200200"),
    RequestFail("request_fail", "2", 2),
    ResponseSuccess("response_succ", "201200"),
    ResponseFail("response_fail", "2", 2),
    RenderStart("render_start", "300000"),
    RenderSuccess("render_succ", o0OO000o.OooOoo),
    RenderFail("render_fail", "3", 2),
    FilledSuccess("filled_succ", "202200"),
    FilledFail("filled_fail", "2", 2),
    ShowStart("show_start", "400000"),
    ShowSuccess("show_succ", "400200"),
    ShowFail("show_fail", "4", 2),
    ShowRepeat("show_repeat", "400200"),
    ClickSuccess("click_succ", o0OO000o.o0ooOO0),
    ClickRepeat("click_repeat", o0OO000o.o0ooOO0),
    ClickTarget("click_target", "500300"),
    ClickDelayStart("delay_start", "500100"),
    ClickDelaySuccess("delay_succ", o0OO000o.o0ooOO0),
    Crash("crash_msg", o0OO000o.o000OoOo, 8),
    Monitor("monitor_msg", "9", 16),
    Feedback("feedback", "6", 32),
    AppList("fetch_applist", "601200", 4),
    AppListException("applist_error", "601100", 4),
    RewardStart("reward_start", "9", 16),
    RewardSucc("reward_succ", "9", 16),
    RewardFail("reward_fail", "9", 16),
    RewardOffline("reward_offline", "9", 16);

    private String I;
    private String J;
    private int K;

    j(String str, String str2) {
        this(str, str2, 1);
    }

    j(String str, String str2, int i) {
        this.I = str;
        this.J = str2;
        this.K = i;
    }

    public String a() {
        return this.J;
    }

    public String b() {
        return this.I;
    }

    public int c() {
        return this.K;
    }

    public boolean d() {
        return name().equals(LaunchLocalSuccess.name()) || name().equals(ResponseSuccess.name()) || name().equals(FilledSuccess.name()) || name().equals(ShowSuccess.name()) || name().equals(ClickSuccess.name()) || name().equals(ClickRepeat.name()) || name().equals(ClickDelayStart.name()) || name().equals(ClickDelaySuccess.name()) || name().equals(Monitor.name()) || name().equals(AppList.name()) || name().equals(RewardSucc.name()) || name().equals(RewardFail.name());
    }
}
