package com.baidu.mobads.sdk.internal.b;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.baidu.mobads.proxy.R;
import com.baidu.mobads.sdk.api.IOAdEvent;
import com.baidu.mobads.sdk.api.IOAdEventListener;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
public class a implements IOAdEventListener {

    /* JADX INFO: renamed from: com.baidu.mobads.sdk.internal.b.a$a, reason: collision with other inner class name */
    public static class C0087a {
        public static final String A = "ic_white_cross";
        public static final String B = "ic_gray_complaints";
        public static final String C = "ic_gray_low_quality";
        public static final String D = "ic_gray_repeat";
        public static final String E = "ic_gray_unlike";
        public static final String F = "ic_white_ad_logo_gray_bg";
        public static final String G = "ic_white_bqt_logo_gray_bg";
        public static final String H = "ic_white_shake_gesture";
        public static final String I = "ic_arrow_up";
        public static final String J = "ic_blue_no_ad";
        public static final String K = "ic_fallback_gray";
        public static final String L = "ic_gift_box";
        public static final String M = "ic_gift_ribbon";
        public static final String N = "ic_gold_star";
        public static final String O = "ic_gray_left_quot";
        public static final String P = "ic_gray_right_quot";
        public static final String Q = "ic_gray_star";
        public static final String R = "ic_half_gold_star";
        public static final String S = "ic_orange_cross";
        public static final String T = "ic_twist_phone";
        public static final String U = "ic_white_answer_error";
        public static final String V = "ic_white_answer_right";
        public static final String W = "ic_white_ad_logo";
        public static final String X = "ic_white_cross_in_circle";
        public static final String Y = "ic_black_arrow_left";
        public static final String Z = "ic_black_three_points";

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final String f1738a = "rsp_big_red_heart";
        public static final String aA = "ic_white_three_points";
        public static final String aB = "ic_white_voice";
        public static final String aC = "ic_white_voice_mute";
        public static final String aD = "ic_white_pause_gray_round";
        public static final String aE = "ic_yellow_dl_black_bg";
        public static final String aF = "ic_yellow_lp_black_bg";
        public static final String aG = "ic_live";
        public static final String aH = "ic_rmb";
        public static final String aI = "ic_highest";
        public static final String aJ = "bg_magnetic_sticker_center";
        public static final String aK = "bg_magnetic_sticker_right";
        public static final String aL = "ic_bookmark_line";
        public static final String aM = "ic_fb_img_splash";
        public static final String aN = "ic_entry_guidance_default_icon";
        public static final String aO = "ic_entry_guidance_arrow";
        public static final String aP = "splash_noti_bg";
        public static final String aQ = "tpl_discount_bg";
        public static final String aa = "ic_gray_ad";
        public static final String ab = "ic_gray_ad_logo";
        public static final String ac = "ic_gray_bqt_logo";
        public static final String ad = "ic_gray_cross_black_round";
        public static final String ae = "ic_gray_cross_white_oval";
        public static final String af = "ic_gray_logo";
        public static final String ag = "ic_slide_arrow_duplicate";
        public static final String ah = "ic_slide_arrow_point";
        public static final String ai = "ic_white_ad_gray_bg";
        public static final String aj = "ic_white_arrow_left";
        public static final String ak = "ic_white_arrow_right";
        public static final String al = "ic_white_bqt_gray_bg";
        public static final String am = "ic_white_bqt_logo";
        public static final String an = "ic_white_comments";
        public static final String ao = "ic_white_cross_circle_shadow";
        public static final String ap = "ic_white_finger_shadow";
        public static final String aq = "ic_white_logo";
        public static final String ar = "ic_white_logo_gray_bg";
        public static final String as = "ic_white_replay";
        public static final String at = "ic_white_replay_gray_round";
        public static final String au = "ic_white_speed075";
        public static final String av = "ic_white_speed100";
        public static final String aw = "ic_white_speed125";
        public static final String ax = "ic_white_speed150";
        public static final String ay = "ic_white_speed175";
        public static final String az = "ic_white_speed200";
        public static final String b = "rsp_small_red_heart";
        public static final String c = "bg_blur_white";
        public static final String d = "bg_app_icon";
        public static final String e = "bg_hot_recommendation";
        public static final String f = "bg_black_round_rectangle";
        public static final String g = "bg_red_rectangle";
        public static final String h = "bg_red_circle";
        public static final String i = "bg_red_ribbon_rectangle";
        public static final String j = "bg_red_ribbon_circle";
        public static final String k = "ic_video_play";
        public static final String l = "ic_stars";
        public static final String m = "ic_fallback";
        public static final String n = "ic_guide_circle";
        public static final String o = "ic_guide_finger";
        public static final String p = "ic_white_play";
        public static final String q = "ic_white_pause";
        public static final String r = "ic_white_apo";
        public static final String s = "ic_white_dl";
        public static final String t = "ic_white_link";
        public static final String u = "ic_white_fullscreen_shrink";
        public static final String v = "ic_white_fullscreen_stretch";
        public static final String w = "ic_black_cross";
        public static final String x = "ic_white_cross_dark_round";
        public static final String y = "ic_gray_cross";
        public static final String z = "ic_light_gray_cross";
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final String f1739a = "layout_bd_oauth_sdk_webview_with_title";
        public static final String b = "layout_bd_oauth_sdk_network_unavailable";
        public static final String c = "layout_bd_oauth_sdk_loading_timeout";
        public static final String d = "oauth_title_back";
        public static final String e = "oauth_webview_container";
        public static final String f = "oauth_title";
        public static final String g = "btn_network_settings";
        public static final String h = "btn_retry";
    }

    private Integer c(String str) {
        return null;
    }

    private Integer d(String str) {
        return null;
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEventListener
    public void run(IOAdEvent iOAdEvent) {
        Integer numD;
        if (iOAdEvent != null) {
            String type = iOAdEvent.getType();
            Map<String, Object> data = iOAdEvent.getData();
            String str = (String) data.get("name");
            if ("drawable".equals(type)) {
                numD = b(str);
            } else if (TtmlNode.TAG_LAYOUT.equals(type)) {
                numD = a(str);
            } else if (TypedValues.Custom.S_STRING.equals(type)) {
                numD = c(str);
            } else {
                numD = "style".equals(type) ? d(str) : null;
            }
            data.put("id", numD);
        }
    }

    private Integer b(String str) {
        if (C0087a.c.equals(str)) {
            return Integer.valueOf(R.drawable.bd_bg_blur_white);
        }
        if (C0087a.d.equals(str)) {
            return Integer.valueOf(R.drawable.bd_bg_app_icon);
        }
        if (C0087a.e.equals(str)) {
            return Integer.valueOf(R.drawable.bd_bg_hot_recommendation);
        }
        if (C0087a.f.equals(str)) {
            return Integer.valueOf(R.drawable.bd_bg_black_round_rectangle);
        }
        if (C0087a.g.equals(str)) {
            return Integer.valueOf(R.drawable.bd_bg_red_rect);
        }
        if (C0087a.h.equals(str)) {
            return Integer.valueOf(R.drawable.bd_bg_red_circle);
        }
        if (C0087a.i.equals(str)) {
            return Integer.valueOf(R.drawable.bd_bg_red_ribbon_rect);
        }
        if (C0087a.j.equals(str)) {
            return Integer.valueOf(R.drawable.bd_bg_red_ribbon_circle);
        }
        if (C0087a.k.equals(str)) {
            return Integer.valueOf(R.drawable.bd_ic_video_play);
        }
        if (C0087a.l.equals(str)) {
            return Integer.valueOf(R.drawable.bd_ic_stars);
        }
        if (C0087a.m.equals(str)) {
            return Integer.valueOf(R.drawable.bd_ic_fallback);
        }
        if (C0087a.n.equals(str)) {
            return Integer.valueOf(R.drawable.bd_ic_guide_circle);
        }
        if (C0087a.o.equals(str)) {
            return Integer.valueOf(R.drawable.bd_ic_guide_finger);
        }
        if (C0087a.p.equals(str)) {
            return Integer.valueOf(R.drawable.bd_ic_white_play);
        }
        if (C0087a.q.equals(str)) {
            return Integer.valueOf(R.drawable.bd_ic_white_pause);
        }
        if (C0087a.r.equals(str)) {
            return Integer.valueOf(R.drawable.bd_ic_white_apo);
        }
        if (C0087a.s.equals(str)) {
            return Integer.valueOf(R.drawable.bd_ic_white_dl);
        }
        if (C0087a.t.equals(str)) {
            return Integer.valueOf(R.drawable.bd_ic_white_link);
        }
        if (C0087a.u.equals(str)) {
            return Integer.valueOf(R.drawable.bd_ic_white_fullscreen_shrink);
        }
        if (C0087a.v.equals(str)) {
            return Integer.valueOf(R.drawable.bd_ic_white_fullscreen_stretch);
        }
        if (C0087a.w.equals(str)) {
            return Integer.valueOf(R.drawable.bd_ic_black_cross);
        }
        if (C0087a.x.equals(str)) {
            return Integer.valueOf(R.drawable.bd_ic_white_cross_dark_round);
        }
        if (C0087a.f1738a.equals(str)) {
            return Integer.valueOf(R.drawable.bd_rsp_big_red_heart);
        }
        if (C0087a.b.equals(str)) {
            return Integer.valueOf(R.drawable.bd_rsp_small_red_heart);
        }
        if (C0087a.y.equals(str)) {
            return Integer.valueOf(R.drawable.bd_ic_gray_cross);
        }
        if (C0087a.z.equals(str)) {
            return Integer.valueOf(R.drawable.bd_ic_light_gray_cross);
        }
        if (C0087a.A.equals(str)) {
            return Integer.valueOf(R.drawable.bd_ic_white_cross);
        }
        if (C0087a.B.equals(str)) {
            return Integer.valueOf(R.drawable.bd_ic_gray_complaints);
        }
        if (C0087a.C.equals(str)) {
            return Integer.valueOf(R.drawable.bd_ic_gray_low_quality);
        }
        if (C0087a.D.equals(str)) {
            return Integer.valueOf(R.drawable.bd_ic_gray_repeat);
        }
        if (C0087a.E.equals(str)) {
            return Integer.valueOf(R.drawable.bd_ic_gray_unlike);
        }
        if (C0087a.F.equals(str)) {
            return Integer.valueOf(R.drawable.bd_ic_white_ad_logo_gray_bg);
        }
        if (C0087a.G.equals(str)) {
            return Integer.valueOf(R.drawable.bd_ic_white_bqt_logo_gray_bg);
        }
        if (C0087a.H.equals(str)) {
            return Integer.valueOf(R.drawable.bd_ic_white_shake_gesture);
        }
        if (C0087a.I.equals(str)) {
            return Integer.valueOf(R.drawable.bd_ic_arrow_up);
        }
        if (C0087a.J.equals(str)) {
            return Integer.valueOf(R.drawable.bd_ic_blue_no_ad);
        }
        if (C0087a.K.equals(str)) {
            return Integer.valueOf(R.drawable.bd_ic_fallback_gray);
        }
        if (C0087a.L.equals(str)) {
            return Integer.valueOf(R.drawable.bd_ic_gift_box);
        }
        if (C0087a.M.equals(str)) {
            return Integer.valueOf(R.drawable.bd_ic_gift_ribbon);
        }
        if (C0087a.N.equals(str)) {
            return Integer.valueOf(R.drawable.bd_ic_gold_star);
        }
        if (C0087a.O.equals(str)) {
            return Integer.valueOf(R.drawable.bd_ic_gray_left_quot);
        }
        if (C0087a.P.equals(str)) {
            return Integer.valueOf(R.drawable.bd_ic_gray_right_quot);
        }
        if (C0087a.Q.equals(str)) {
            return Integer.valueOf(R.drawable.bd_ic_gray_star);
        }
        if (C0087a.R.equals(str)) {
            return Integer.valueOf(R.drawable.bd_ic_half_gold_star);
        }
        if (C0087a.S.equals(str)) {
            return Integer.valueOf(R.drawable.bd_ic_orange_cross);
        }
        if (C0087a.T.equals(str)) {
            return Integer.valueOf(R.drawable.bd_ic_twist_phone);
        }
        if (C0087a.W.equals(str)) {
            return Integer.valueOf(R.drawable.bd_ic_white_ad_logo);
        }
        if (C0087a.U.equals(str)) {
            return Integer.valueOf(R.drawable.bd_ic_white_answer_error);
        }
        if (C0087a.V.equals(str)) {
            return Integer.valueOf(R.drawable.bd_ic_white_answer_right);
        }
        if (C0087a.X.equals(str)) {
            return Integer.valueOf(R.drawable.bd_ic_white_cross_in_circle);
        }
        if (C0087a.Y.equals(str)) {
            return Integer.valueOf(R.drawable.bd_ic_black_arrow_left);
        }
        if (C0087a.Z.equals(str)) {
            return Integer.valueOf(R.drawable.bd_ic_black_three_points);
        }
        if (C0087a.aa.equals(str)) {
            return Integer.valueOf(R.drawable.bd_ic_gray_ad);
        }
        if (C0087a.ab.equals(str)) {
            return Integer.valueOf(R.drawable.bd_ic_gray_ad_logo);
        }
        if (C0087a.ac.equals(str)) {
            return Integer.valueOf(R.drawable.bd_ic_gray_bqt_logo);
        }
        if (C0087a.ad.equals(str)) {
            return Integer.valueOf(R.drawable.bd_ic_gray_cross_black_round);
        }
        if (C0087a.ae.equals(str)) {
            return Integer.valueOf(R.drawable.bd_ic_gray_cross_white_oval);
        }
        if (C0087a.af.equals(str)) {
            return Integer.valueOf(R.drawable.bd_ic_gray_logo);
        }
        if (C0087a.ag.equals(str)) {
            return Integer.valueOf(R.drawable.bd_ic_slide_arrow_duplicate);
        }
        if (C0087a.ah.equals(str)) {
            return Integer.valueOf(R.drawable.bd_ic_slide_arrow_point);
        }
        if (C0087a.ai.equals(str)) {
            return Integer.valueOf(R.drawable.bd_ic_white_ad_gray_bg);
        }
        if (C0087a.aj.equals(str)) {
            return Integer.valueOf(R.drawable.bd_ic_white_arrow_left);
        }
        if (C0087a.ak.equals(str)) {
            return Integer.valueOf(R.drawable.bd_ic_white_arrow_right);
        }
        if (C0087a.al.equals(str)) {
            return Integer.valueOf(R.drawable.bd_ic_white_bqt_gray_bg);
        }
        if (C0087a.am.equals(str)) {
            return Integer.valueOf(R.drawable.bd_ic_white_bqt_logo);
        }
        if (C0087a.an.equals(str)) {
            return Integer.valueOf(R.drawable.bd_ic_white_comments);
        }
        if (C0087a.ao.equals(str)) {
            return Integer.valueOf(R.drawable.bd_ic_white_cross_circle_shadow);
        }
        if (C0087a.ap.equals(str)) {
            return Integer.valueOf(R.drawable.bd_ic_white_finger_shadow);
        }
        if (C0087a.aq.equals(str)) {
            return Integer.valueOf(R.drawable.bd_ic_white_logo);
        }
        if (C0087a.ar.equals(str)) {
            return Integer.valueOf(R.drawable.bd_ic_white_logo_gray_bg);
        }
        if (C0087a.aD.equals(str)) {
            return Integer.valueOf(R.drawable.bd_ic_white_pause_gray_round);
        }
        if (C0087a.as.equals(str)) {
            return Integer.valueOf(R.drawable.bd_ic_white_replay);
        }
        if (C0087a.at.equals(str)) {
            return Integer.valueOf(R.drawable.bd_ic_white_replay_gray_round);
        }
        if (C0087a.au.equals(str)) {
            return Integer.valueOf(R.drawable.bd_ic_white_speed075);
        }
        if (C0087a.av.equals(str)) {
            return Integer.valueOf(R.drawable.bd_ic_white_speed100);
        }
        if (C0087a.aw.equals(str)) {
            return Integer.valueOf(R.drawable.bd_ic_white_speed125);
        }
        if (C0087a.ax.equals(str)) {
            return Integer.valueOf(R.drawable.bd_ic_white_speed150);
        }
        if (C0087a.ay.equals(str)) {
            return Integer.valueOf(R.drawable.bd_ic_white_speed175);
        }
        if (C0087a.az.equals(str)) {
            return Integer.valueOf(R.drawable.bd_ic_white_speed200);
        }
        if (C0087a.aA.equals(str)) {
            return Integer.valueOf(R.drawable.bd_ic_white_three_points);
        }
        if (C0087a.aB.equals(str)) {
            return Integer.valueOf(R.drawable.bd_ic_white_voice);
        }
        if (C0087a.aC.equals(str)) {
            return Integer.valueOf(R.drawable.bd_ic_white_voice_mute);
        }
        if (C0087a.aE.equals(str)) {
            return Integer.valueOf(R.drawable.bd_ic_yellow_dl_black_bg);
        }
        if (C0087a.aF.equals(str)) {
            return Integer.valueOf(R.drawable.bd_ic_yellow_lp_black_bg);
        }
        if (C0087a.aG.equals(str)) {
            return Integer.valueOf(R.drawable.bd_ic_live);
        }
        if (C0087a.aI.equals(str)) {
            return Integer.valueOf(R.drawable.highest);
        }
        if (C0087a.aH.equals(str)) {
            return Integer.valueOf(R.drawable.rmb);
        }
        if (C0087a.aJ.equals(str)) {
            return Integer.valueOf(R.drawable.bd_bg_magnetic_sticker_middle);
        }
        if (C0087a.aK.equals(str)) {
            return Integer.valueOf(R.drawable.bd_bg_magnetic_sticker_right);
        }
        if (C0087a.aL.equals(str)) {
            return Integer.valueOf(R.drawable.bd_mob_ad_bookmark_line);
        }
        if (C0087a.aM.equals(str)) {
            return Integer.valueOf(R.drawable.fb_img);
        }
        if (C0087a.aN.equals(str)) {
            return Integer.valueOf(R.drawable.bd_ic_splash_guide_default_icon);
        }
        if (C0087a.aO.equals(str)) {
            return Integer.valueOf(R.drawable.bd_ic_splash_guide_arrow);
        }
        if (C0087a.aP.equals(str)) {
            return Integer.valueOf(R.drawable.bd_bg_splash_noti_bg);
        }
        if (C0087a.aQ.equals(str)) {
            return Integer.valueOf(R.drawable.bd_mob_tpl_discount_bg);
        }
        return null;
    }

    public static Integer a(String str) {
        if (b.f1739a.equals(str)) {
            return Integer.valueOf(R.layout.layout_bd_oauth_sdk_webview_with_title);
        }
        if (b.b.equals(str)) {
            return Integer.valueOf(R.layout.layout_bd_oauth_sdk_network_unavailable);
        }
        if (b.c.equals(str)) {
            return Integer.valueOf(R.layout.layout_bd_oauth_sdk_loading_timeout);
        }
        if (b.f.equals(str)) {
            return Integer.valueOf(R.id.oauth_title);
        }
        if (b.d.equals(str)) {
            return Integer.valueOf(R.id.oauth_title_back);
        }
        if (b.e.equals(str)) {
            return Integer.valueOf(R.id.oauth_webview_container);
        }
        if (b.g.equals(str)) {
            return Integer.valueOf(R.id.btn_network_settings);
        }
        if (b.h.equals(str)) {
            return Integer.valueOf(R.id.btn_retry);
        }
        return null;
    }
}
