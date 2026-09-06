package com.bykv.vk.component.ttvideo.net;

import com.byazt.nr.m;
import com.bykv.vk.component.ttvideo.player.AVThreadPool;
import java.net.InetAddress;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
public class AVResolver {
    public static int HOST_MAX_CACHE_TIME = 600000;
    private static final int MAX_CACHED = 128;
    private static final String TAG = "ttmj";
    private static final Hashtable<String, HostInfo> mCacheHosts = new Hashtable<>();
    private String mError;
    private HostInfo mHostInfo;
    private String mHostName;
    private String[] mIPStr;
    private boolean mRet = false;
    private Thread mThread = null;

    public void getAddressInfo(String str) {
        this.mHostName = str;
        if (str == null || str.length() <= 0 || "".equals(str)) {
            this.mRet = true;
            return;
        }
        if (isIP(this.mHostName)) {
            this.mIPStr = new String[]{this.mHostName};
            this.mRet = true;
            return;
        }
        Hashtable<String, HostInfo> hashtable = mCacheHosts;
        HostInfo hostInfo = hashtable.get(str);
        this.mHostInfo = hostInfo;
        if (hostInfo != null) {
            if (hostInfo.ip != null && System.currentTimeMillis() - this.mHostInfo.time < HOST_MAX_CACHE_TIME) {
                this.mIPStr = new String[]{this.mHostInfo.ip};
                this.mRet = true;
                return;
            } else {
                hashtable.remove(str);
                this.mHostInfo = null;
            }
        }
        try {
            AVThreadPool.addTask(new ParserHost(this, this.mHostName));
        } catch (Exception e) {
            this.mRet = true;
            this.mError = e.getMessage();
        }
    }

    public int isSuccess() {
        if (!this.mRet) {
            return 0;
        }
        String[] strArr = this.mIPStr;
        return (strArr == null || strArr[0] == null) ? -1 : 1;
    }

    public String getAddress() {
        String[] strArr;
        String str;
        return (!this.mRet || (strArr = this.mIPStr) == null || (str = strArr[0]) == null) ? "parser host name: " + this.mHostName + " error.err msg:" + this.mError : str;
    }

    public void freeAddress() {
        Thread thread = this.mThread;
        if (thread != null) {
            try {
                thread.interrupt();
            } catch (Exception e) {
                m.c(e);
            }
        }
    }

    static class HostInfo {
        public String ip;
        public long time;

        HostInfo() {
        }
    }

    static class ParserHost implements Runnable {
        String mHostName;
        AVResolver mResolver;

        public ParserHost(AVResolver aVResolver, String str) {
            this.mResolver = aVResolver;
            this.mHostName = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            InetAddress byName;
            m.c(AVResolver.TAG, "start ParserHost task");
            String hostAddress = null;
            try {
                byName = InetAddress.getByName(this.mHostName);
                try {
                    hostAddress = byName.getHostAddress();
                } catch (Throwable th) {
                    th = th;
                    m.c(th);
                    this.mResolver.mError = th.getMessage();
                }
            } catch (Throwable th2) {
                th = th2;
                byName = null;
            }
            this.mResolver.mRet = true;
            if (byName == null || hostAddress == null) {
                return;
            }
            this.mResolver.mIPStr = new String[1];
            this.mResolver.mIPStr[0] = hostAddress;
            HostInfo hostInfo = new HostInfo();
            hostInfo.time = System.currentTimeMillis();
            hostInfo.ip = hostAddress;
            AVResolver.putHostInfo(this.mHostName, hostInfo);
            hostInfo.time = System.currentTimeMillis();
        }
    }

    static synchronized void putHostInfo(String str, HostInfo hostInfo) {
        Object obj;
        long jCurrentTimeMillis = System.currentTimeMillis();
        Hashtable<String, HostInfo> hashtable = mCacheHosts;
        Object obj2 = null;
        if (hashtable.size() > 128) {
            Iterator<Map.Entry<String, HostInfo>> it = hashtable.entrySet().iterator();
            Object obj3 = null;
            while (it.hasNext()) {
                HostInfo value = it.next().getValue();
                obj2 = (String) it.next().getKey();
                if (value != null && value.time < jCurrentTimeMillis) {
                    jCurrentTimeMillis = value.time;
                    obj3 = value;
                }
            }
            obj = obj2;
            obj2 = obj3;
        } else {
            obj = null;
        }
        if (obj2 != null && obj != null) {
            mCacheHosts.remove(obj);
        }
        mCacheHosts.put(str, hostInfo);
    }

    public static final boolean isIP(String str) {
        if (str.length() < 7 || str.length() > 15) {
            return str.charAt(0) == '[' && str.charAt(str.length() - 1) == ']';
        }
        return Pattern.compile("([1-9]|[1-9]\\d|1\\d{2}|2[0-4]\\d|25[0-5])(\\.(\\d|[1-9]\\d|1\\d{2}|2[0-4]\\d|25[0-5])){3}").matcher(str).find();
    }
}
