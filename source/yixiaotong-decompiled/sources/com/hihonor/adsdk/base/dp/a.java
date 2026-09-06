package com.hihonor.adsdk.base.dp;

import com.hihonor.adsdk.base.bean.DetailPageCtrl;
import com.hihonor.adsdk.base.bean.Style;
import com.hihonor.adsdk.base.bean.TrackUrl;
import com.hihonor.adsdk.base.bean.Video;
import com.hihonor.adsdk.base.j.g;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class a {
    private static final String hnadsa = "BaseAdConverter";

    public static String hnadsa(Video video) {
        return g.hnadsa(video);
    }

    public static String hnadsb(List<String> list) {
        return g.hnadsa(list);
    }

    public static List<String> hnadsc(String str) {
        return g.hnadsc(str, String.class);
    }

    public static Style hnadsd(String str) {
        return (Style) g.hnadsa(str, Style.class);
    }

    public static TrackUrl hnadse(String str) {
        return (TrackUrl) g.hnadsa(str, TrackUrl.class);
    }

    public static Video hnadsf(String str) {
        return (Video) g.hnadsa(str, Video.class);
    }

    public static String hnadsa(TrackUrl trackUrl) {
        return g.hnadsa(trackUrl);
    }

    public static DetailPageCtrl hnadsb(String str) {
        return (DetailPageCtrl) g.hnadsa(str, DetailPageCtrl.class);
    }

    public static List<Integer> hnadsa(String str) {
        return g.hnadsc(str, Integer.class);
    }

    public static String hnadsa(List<Integer> list) {
        return g.hnadsa(list);
    }

    public static String hnadsa(Style style) {
        return g.hnadsa(style);
    }

    public static String hnadsa(DetailPageCtrl detailPageCtrl) {
        return g.hnadsa(detailPageCtrl);
    }
}
