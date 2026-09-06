package com.baidu.oauth.sdkbqt.a;

import com.baidu.oauth.sdkbqt.dto.BdOauthDTO;
import java.util.LinkedHashMap;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f1858a = "2.0.6.10";
    public static final String b = "YmFpZHUuaW50ZW50LmFjdGlvbi5hY2NvdW50Lk9BVVRIX0FDVElWSVRZ";
    public static final String c = "YmFpZHUuaW50ZW50LmFjdGlvbi5hY2NvdW50Lk9BVVRIX1NJTEVOVF9BQ1RJVklUWQ==";
    public static LinkedHashMap<String, String> d = null;
    public static LinkedHashMap<String, String> e = new LinkedHashMap<>(2);
    public static final String f = "aHR0cHM6Ly9vcGVuYXBpLmJhaWR1LmNvbS9vYXV0aC8yLjAvdG9rZW4=";
    public static final String g = "L29hdXRoLzIuMC9hdXRob3JpemU=";
    public static final String h = "L29hdXRoLzIuMC9zc29nZXRxcmNvZGU=";
    public static final String i = "L2NoYW5uZWwvdW5pY2FzdA==";

    static {
        d = new LinkedHashMap<>(6);
        d.put("Y29tLmJhaWR1LnNhcGkyLiguKik=", "ZGUzMDhkNzk3M2I1MTcxODgzMzMzYTk3MjUzMzI3ZTQ=");
        d.put(BdOauthDTO.APP_SEARCHBOX, "YzJiMGI0OTdkMDM4OWU2ZGUxNTA1ZTdmZDhmNGQ1Mzk=");
        d.put(BdOauthDTO.APP_BAIDUMAP, "YzJiMGI0OTdkMDM4OWU2ZGUxNTA1ZTdmZDhmNGQ1Mzk=");
        d.put(BdOauthDTO.APP_NETDISK, "YWU1ODIxNDQwZmFiNWUxYTYxYTAyNWYwMTRiZDg5NzI=");
        d.put(BdOauthDTO.APP_TIEBA, "NjczMDA0Y2YyZjZlZmRlYzIzODVjODExNmMxZThjMTQ=");
        d.put(BdOauthDTO.APP_HAOKAN, "N2ZkMzcyNzg1MmQyOWViNmY0MjgzOTg4ZGMwZDYxNTA=");
        LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>(6);
        for (String str : d.keySet()) {
            linkedHashMap.put(h.b(str), h.b(d.get(str)));
        }
        d = linkedHashMap;
        Object[] array = linkedHashMap.keySet().toArray();
        e.put(array[0].toString(), d.get(array[0]));
        e.put(array[1].toString(), d.get(array[1]));
    }
}
