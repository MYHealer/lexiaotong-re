package client.android.yixiaotong.v3.ui.announcement;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;
import client.android.yixiaotong.BaseActivity;
import client.android.yixiaotong.R;
import client.android.yixiaotong.controller.bean.gonggaolan.Detail;
import client.android.yixiaotong.controller.core.Controller;
import client.android.yixiaotong.controller.core.Listener;
import client.android.yixiaotong.exception.ClientException;
import client.android.yixiaotong.ui.dialog.SystemErrorTip;
import client.android.yixiaotong.ui.widget.TitleBar;
import client.android.yixiaotong.util.ToastUtils;
import client.android.yixiaotong.v3.http.V3BusinessControllers;
import client.android.yixiaotong.view.load.MultiStateView;
import client.android.yixiaotong.view.load.PullRefreshLayout;
import com.stub.StubApp;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class AnnouncementDetailActivity extends BaseActivity {
    private static final String EXTRA_ID = "extra_id";
    private long ID;
    private MultiStateView mMultiStateView;
    private PullRefreshLayout mSwipeRefreshLayout;
    private TitleBar mTitleBar;
    private TextView mTvErrorTip;
    private WebView mWebView;

    static {
        StubApp.interface11(8991);
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected native void onCreate(Bundle bundle);

    private void initViewNew() {
        this.mTitleBar = (TitleBar) findViewById(R.id.titleBar);
        this.mWebView = (WebView) findViewById(R.id.web_view);
        this.mMultiStateView = (MultiStateView) findViewById(R.id.multiStateView);
        this.mSwipeRefreshLayout = (PullRefreshLayout) findViewById(R.id.swipeRefreshLayout);
    }

    public static void launch(Activity activity, long j) {
        if (activity != null) {
            Intent intent = new Intent(activity, (Class<?>) AnnouncementDetailActivity.class);
            intent.putExtra("extra_id", j);
            activity.startActivity(intent);
        }
    }

    private void initData() {
        this.ID = getIntent().getLongExtra("extra_id", 0L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initWebView(String str) {
        this.mWebView.getSettings().setJavaScriptEnabled(true);
        this.mWebView.getSettings().setCacheMode(1);
        this.mWebView.getSettings().setRenderPriority(WebSettings.RenderPriority.HIGH);
        this.mWebView.getSettings().setSupportMultipleWindows(true);
        this.mWebView.getSettings().setDomStorageEnabled(true);
        onLoad(str);
    }

    public void onLoad(String str) {
        try {
            this.mWebView.setWebViewClient(new WebViewClient() { // from class: client.android.yixiaotong.v3.ui.announcement.AnnouncementDetailActivity.1
                @Override // android.webkit.WebViewClient
                public void onLoadResource(WebView webView, String str2) {
                    Log.e("tag", "onLoadResource url=" + str2);
                    super.onLoadResource(webView, str2);
                }

                @Override // android.webkit.WebViewClient
                public boolean shouldOverrideUrlLoading(WebView webView, String str2) {
                    Log.e("tag", "intercept url=" + str2);
                    webView.loadUrl(str2);
                    return true;
                }

                @Override // android.webkit.WebViewClient
                public void onPageFinished(WebView webView, String str2) {
                    Log.e("tag", "onPageFinished WebView title=" + webView.getTitle());
                }

                @Override // android.webkit.WebViewClient
                public void onReceivedError(WebView webView, int i, String str2, String str3) {
                    ToastUtils.show(AnnouncementDetailActivity.this.getContext(), "加载错误");
                }
            });
            this.mWebView.loadUrl(str);
        } catch (Exception unused) {
        }
    }

    private void initTitleBar() {
        this.mTitleBar.setTitleView(getString(R.string.announcementinformation));
        this.mTitleBar.setLeftView(R.mipmap.back);
        this.mTitleBar.setLeftViewOnClickBack(getActivity());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getGGLDetail() {
        V3BusinessControllers.getInstance().getAnnouncementDetailNewV3(getLoginAccount(), this.ID, new Listener<Detail>() { // from class: client.android.yixiaotong.v3.ui.announcement.AnnouncementDetailActivity.2
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onStart(Controller controller) {
                AnnouncementDetailActivity.this.mSwipeRefreshLayout.setRefreshing(true);
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, Detail detail, Object... objArr) {
                AnnouncementDetailActivity.this.mSwipeRefreshLayout.setRefreshing(false);
                AnnouncementDetailActivity.this.mMultiStateView.setViewState(0);
                AnnouncementDetailActivity.this.initWebView(detail.comment);
                if (detail == null) {
                    AnnouncementDetailActivity.this.mMultiStateView.setViewState(2);
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                AnnouncementDetailActivity.this.mSwipeRefreshLayout.setRefreshing(false);
                AnnouncementDetailActivity.this.mMultiStateView.setViewState(1);
                AnnouncementDetailActivity.this.mTvErrorTip.setText(clientException.getDetail());
                SystemErrorTip.getInstance().showTipDialog(AnnouncementDetailActivity.this.getActivity(), clientException.getDetail());
            }
        });
    }

    private void initListener() {
        this.mTvErrorTip = (TextView) this.mMultiStateView.getView(1).findViewById(R.id.tv_errortip);
        this.mMultiStateView.getView(1).findViewById(R.id.btn_reload).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v3.ui.announcement.AnnouncementDetailActivity.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AnnouncementDetailActivity.this.mMultiStateView.setViewState(3);
                AnnouncementDetailActivity.this.getGGLDetail();
            }
        });
        this.mSwipeRefreshLayout.setOnRefreshListener(new PullRefreshLayout.OnRefreshListener() { // from class: client.android.yixiaotong.v3.ui.announcement.AnnouncementDetailActivity.4
            @Override // client.android.yixiaotong.view.load.PullRefreshLayout.OnRefreshListener
            public void onRefresh() {
                AnnouncementDetailActivity.this.getGGLDetail();
            }
        });
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        this.mWebView.removeAllViews();
        this.mWebView.destroy();
    }
}
