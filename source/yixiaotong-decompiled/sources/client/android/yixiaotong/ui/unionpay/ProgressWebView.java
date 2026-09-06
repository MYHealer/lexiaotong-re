package client.android.yixiaotong.ui.unionpay;

import android.R;
import android.content.Context;
import android.util.AttributeSet;
import android.webkit.WebView;
import android.widget.AbsoluteLayout;
import android.widget.ProgressBar;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class ProgressWebView extends WebView {
    private ProgressBar progressbar;

    public ProgressWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        ProgressBar progressBar = new ProgressBar(context, null, R.attr.progressBarStyleHorizontal);
        this.progressbar = progressBar;
        progressBar.setLayoutParams(new AbsoluteLayout.LayoutParams(-1, 5, 0, 0));
        this.progressbar.setProgressDrawable(getResources().getDrawable(client.android.yixiaotong.R.drawable.webview_progressbar));
        addView(this.progressbar);
        setWebChromeClient(new WebChromeClient());
    }

    public class WebChromeClient extends android.webkit.WebChromeClient {
        public WebChromeClient() {
        }

        @Override // android.webkit.WebChromeClient
        public void onProgressChanged(WebView webView, int i) {
            if (i == 100) {
                ProgressWebView.this.progressbar.setVisibility(8);
            } else {
                if (ProgressWebView.this.progressbar.getVisibility() == 8) {
                    ProgressWebView.this.progressbar.setVisibility(0);
                }
                ProgressWebView.this.progressbar.setProgress(i);
            }
            super.onProgressChanged(webView, i);
        }
    }

    @Override // android.webkit.WebView, android.view.View
    protected void onScrollChanged(int i, int i2, int i3, int i4) {
        AbsoluteLayout.LayoutParams layoutParams = (AbsoluteLayout.LayoutParams) this.progressbar.getLayoutParams();
        layoutParams.x = i;
        layoutParams.y = i2;
        this.progressbar.setLayoutParams(layoutParams);
        super.onScrollChanged(i, i2, i3, i4);
    }
}
