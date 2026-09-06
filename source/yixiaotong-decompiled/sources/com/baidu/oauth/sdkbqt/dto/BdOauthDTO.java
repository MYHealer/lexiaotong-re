package com.baidu.oauth.sdkbqt.dto;

import com.baidu.oauth.sdkbqt.a.e;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
public class BdOauthDTO implements e {
    public static final String APP_BAIDUMAP = "Y29tLmJhaWR1LkJhaWR1TWFw";
    public static final String APP_HAOKAN = "Y29tLmJhaWR1Lmhhb2thbg==";
    public static final String APP_NETDISK = "Y29tLmJhaWR1Lm5ldGRpc2s=";
    public static final String APP_SEARCHBOX = "Y29tLmJhaWR1LnNlYXJjaGJveA==";
    public static final String APP_TIEBA = "Y29tLmJhaWR1LnRpZWJh";
    public static final char OAUTH_TYPE_BOTH = 0;
    public static final char OAUTH_TYPE_BOTH_V2 = 3;
    public static final char OAUTH_TYPE_SSO = 1;
    public static final char OAUTH_TYPE_WEB = 2;
    public List<String> authorizedPkgs;
    public String state;
    public char oauthType = 0;
    public boolean isSilent = false;
}
