package com.kwad.components.core.webview.jshandler;

import android.os.Handler;
import android.os.Looper;
import java.io.Serializable;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class WebCardVideoPositionHandler implements com.kwad.sdk.core.webview.c.a {
    private a arQ;
    private VideoPosition arP = new VideoPosition();
    private Handler jk = new Handler(Looper.getMainLooper());

    public interface a {
        void a(VideoPosition videoPosition);
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final String getKey() {
        return "videoPosition";
    }

    public WebCardVideoPositionHandler(a aVar) {
        this.arQ = aVar;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, com.kwad.sdk.core.webview.c.c cVar) {
        try {
            this.arP.parseJson(new JSONObject(str));
            if (this.arQ != null) {
                this.jk.post(new com.kwad.sdk.utils.bi() { // from class: com.kwad.components.core.webview.jshandler.WebCardVideoPositionHandler.1
                    @Override // com.kwad.sdk.utils.bi
                    public final void doTask() {
                        WebCardVideoPositionHandler.this.arQ.a(WebCardVideoPositionHandler.this.arP);
                    }
                });
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        cVar.b(null);
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
        this.jk.removeCallbacksAndMessages(null);
    }

    public static final class VideoPosition extends com.kwad.sdk.core.response.a.a implements Serializable {
        private static final long serialVersionUID = -3445790097441569428L;
        public int borderRadius;
        public KSAdJSCornerModel cornerRadius;
        public int height;
        public double heightWidthRation;
        public int leftMargin;
        public double leftMarginRation;
        public int topMargin;
        public double topMarginRation;
        public int width;
        public double widthRation;

        public static class KSAdJSCornerModel extends com.kwad.sdk.core.response.a.a implements Serializable {
            private static final long serialVersionUID = -1503191931449786332L;
            public double bottomLeft;
            public double bottomRight;
            public double topLeft;
            public double topRight;
        }

        @Override // com.kwad.sdk.core.response.a.a
        public final void afterParseJson(JSONObject jSONObject) {
            super.afterParseJson(jSONObject);
            if (jSONObject.has("cornerRadius")) {
                KSAdJSCornerModel kSAdJSCornerModel = new KSAdJSCornerModel();
                this.cornerRadius = kSAdJSCornerModel;
                kSAdJSCornerModel.parseJson(jSONObject.optJSONObject("cornerRadius"));
            }
        }
    }
}
