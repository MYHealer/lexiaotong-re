package cz.msebera.android.httpclient.impl.client.cache;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
enum RequestProtocolError {
    UNKNOWN,
    BODY_BUT_NO_LENGTH_ERROR,
    WEAK_ETAG_ON_PUTDELETE_METHOD_ERROR,
    WEAK_ETAG_AND_RANGE_ERROR,
    NO_CACHE_DIRECTIVE_WITH_FIELD_NAME
}
