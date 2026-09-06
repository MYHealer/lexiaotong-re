package com.baidu.mobads.sdk.api;

import android.view.View;
import com.baidu.mobads.sdk.internal.az;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.huawei.hms.ads.jsb.constant.Constant;
import com.huawei.openalliance.ad.constant.dd;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class NativeBookmarkView {
    private View bookmarkView;
    private IOAdEventListener controller;
    private final NativeResponse nativeResponse;
    private final JSONObject params = new JSONObject();

    public NativeResponse getNativeResponse() {
        return this.nativeResponse;
    }

    public View getView() {
        return this.bookmarkView;
    }

    public enum EnterDirection {
        TOP_TO_BOTTOM(Constant.MAP_KEY_TOP),
        RIGHT_TO_LEFT(TtmlNode.RIGHT);

        private final String value;

        EnterDirection(String str) {
            this.value = str;
        }
    }

    public enum BookmarkColor {
        BROWN("#CCBE99", "#BFA360"),
        PINK("#D9B8B8", "#996B6B"),
        GREEN("#A8C4A7", "#6D996B"),
        BLUE("#B8C8D9", "#608FBF"),
        DARK("#333333", "#605230");

        private final String buttonColor;
        private final String cardColor;

        BookmarkColor(String str, String str2) {
            this.cardColor = str;
            this.buttonColor = str2;
        }
    }

    public NativeBookmarkView(NativeResponse nativeResponse, int i, int i2) {
        this.nativeResponse = nativeResponse;
        putValue("type", "template");
        putValue(IAdInterListener.AdReqParam.WIDTH, Integer.valueOf(i));
        putValue(IAdInterListener.AdReqParam.HEIGHT, Integer.valueOf(i2));
    }

    public NativeBookmarkView regionClick(boolean z) {
        putValue("region_click", Boolean.valueOf(z));
        return this;
    }

    @Deprecated
    public NativeBookmarkView bottomCardColor(String str) {
        putValue("bottom_card_color", str);
        return this;
    }

    public NativeBookmarkView mute(boolean z) {
        putValue(dd.C, Boolean.valueOf(z));
        return this;
    }

    public NativeBookmarkView hideAdLogo(boolean z) {
        putValue("hide_ad_logo", Boolean.valueOf(z));
        return this;
    }

    public NativeBookmarkView hideMuteButton(boolean z) {
        putValue("hide_mute", Boolean.valueOf(z));
        return this;
    }

    public NativeBookmarkView hideDislike(boolean z) {
        putValue("hide_dislike", Boolean.valueOf(z));
        return this;
    }

    public NativeBookmarkView dislikeListener(NativeResponse.AdDislikeListener adDislikeListener) {
        NativeResponse nativeResponse = this.nativeResponse;
        if (nativeResponse instanceof XAdNativeResponse) {
            ((XAdNativeResponse) nativeResponse).setAdDislikeListener(adDislikeListener);
        }
        return this;
    }

    public NativeBookmarkView closeListener(NativeResponse.AdCloseListener adCloseListener) {
        NativeResponse nativeResponse = this.nativeResponse;
        if (nativeResponse instanceof XAdNativeResponse) {
            ((XAdNativeResponse) nativeResponse).setAdCloseListener(adCloseListener);
        }
        return this;
    }

    public View render() {
        if (!(this.nativeResponse instanceof XAdNativeResponse)) {
            return null;
        }
        HashMap map = new HashMap();
        ((XAdNativeResponse) this.nativeResponse).renderNativeView("bookmark", this.params, map);
        Object obj = map.get("bookmark");
        Object obj2 = map.get("controller");
        if (obj2 instanceof IOAdEventListener) {
            this.controller = (IOAdEventListener) obj2;
        }
        if (!(obj instanceof View)) {
            return null;
        }
        View view = (View) obj;
        this.bookmarkView = view;
        return view;
    }

    public void startAnim(EnterDirection enterDirection) {
        IOAdEventListener iOAdEventListener = this.controller;
        if (iOAdEventListener == null || enterDirection == null) {
            return;
        }
        iOAdEventListener.run(new NativeEvent("startAnimation", enterDirection.value));
    }

    public void setBookmarkColor(BookmarkColor bookmarkColor) {
        IOAdEventListener iOAdEventListener = this.controller;
        if (iOAdEventListener == null || bookmarkColor == null) {
            return;
        }
        iOAdEventListener.run(new NativeEvent("setBookmarkColor", bookmarkColor.cardColor + "," + bookmarkColor.buttonColor));
    }

    private void putValue(String str, Object obj) {
        try {
            this.params.put(str, obj);
        } catch (JSONException e) {
            az.b(e);
        }
    }

    private static class NativeEvent implements IOAdEvent {
        private String action;
        private String what;

        @Override // com.baidu.mobads.sdk.api.IOAdEvent
        public int getCode() {
            return 0;
        }

        @Override // com.baidu.mobads.sdk.api.IOAdEvent
        public String getMessage() {
            return this.what;
        }

        @Override // com.baidu.mobads.sdk.api.IOAdEvent
        public Object getTarget() {
            return null;
        }

        @Override // com.baidu.mobads.sdk.api.IOAdEvent
        public String getType() {
            return this.action;
        }

        @Override // com.baidu.mobads.sdk.api.IOAdEvent
        public void setTarget(Object obj) {
        }

        public NativeEvent(String str, String str2) {
            this.action = str;
            this.what = str2;
        }

        @Override // com.baidu.mobads.sdk.api.IOAdEvent
        public Map<String, Object> getData() {
            return Collections.emptyMap();
        }
    }
}
