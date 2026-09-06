package com.kwad.sdk.core.network.idc;

import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.util.regex.Pattern;
import org.apache.http.conn.ConnectTimeoutException;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class DomainException extends Exception {
    private final Pattern CONNECT_ERR_PATTERN;
    private final int httpCode;

    public int getHttpCode() {
        return this.httpCode;
    }

    public DomainException(int i) {
        this(i, null);
    }

    public DomainException(Throwable th) {
        this(-1, th);
    }

    public DomainException(int i, Throwable th) {
        super(th);
        this.CONNECT_ERR_PATTERN = Pattern.compile(".*(ECONN(RESET|REFUSED|ABORTED)|ETIMEDOUT|ENETUNREACH|EHOSTUNREACH).*", 2);
        this.httpCode = i;
    }

    private Exception getInternal() {
        Throwable cause = getCause();
        if (cause instanceof Exception) {
            return (Exception) cause;
        }
        return null;
    }

    boolean isConnectException() {
        String message;
        Exception internal = getInternal();
        if (internal == null) {
            return false;
        }
        if ((internal instanceof SocketTimeoutException) || (internal instanceof ConnectTimeoutException) || (internal instanceof SocketException) || (internal instanceof UnknownHostException)) {
            return true;
        }
        if (!internal.getClass().getSimpleName().equalsIgnoreCase("ErrnoException") || (message = internal.getMessage()) == null) {
            return false;
        }
        return this.CONNECT_ERR_PATTERN.matcher(message).find();
    }
}
