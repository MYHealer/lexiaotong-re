package cz.msebera.android.httpclient.conn;

import com.huawei.openalliance.ad.views.PPSLabelView;
import cz.msebera.android.httpclient.HttpHost;
import java.io.IOException;
import java.net.ConnectException;
import java.net.InetAddress;
import java.util.Arrays;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public class HttpHostConnectException extends ConnectException {
    private static final long serialVersionUID = -3194482710275220224L;
    private final HttpHost host;

    public HttpHost getHost() {
        return this.host;
    }

    @Deprecated
    public HttpHostConnectException(HttpHost httpHost, ConnectException connectException) {
        this(connectException, httpHost, null);
    }

    public HttpHostConnectException(IOException iOException, HttpHost httpHost, InetAddress... inetAddressArr) {
        super("Connect to " + (httpHost != null ? httpHost.toHostString() : "remote host") + ((inetAddressArr == null || inetAddressArr.length <= 0) ? "" : PPSLabelView.Code + Arrays.asList(inetAddressArr)) + ((iOException == null || iOException.getMessage() == null) ? " refused" : " failed: " + iOException.getMessage()));
        this.host = httpHost;
        initCause(iOException);
    }
}
