package com.bytedance.pangle.transform;

import androidx.fragment.app.FragmentActivity;
import com.byazt.zqa.c;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
public class HostPartUtils {
    public Class fragmentActivityClazz;

    @c(c = {0, 80, 295, 2395, 2396})
    private static class SingletonHolder {
        public static final HostPartUtils INSTANCE = new HostPartUtils();

        private SingletonHolder() {
        }
    }

    public HostPartUtils() {
        try {
            this.fragmentActivityClazz = FragmentActivity.class;
        } catch (Throwable unused) {
        }
    }

    public static final Class getFragmentActivityClass() {
        return SingletonHolder.INSTANCE.fragmentActivityClazz;
    }

    public static FragmentActivity getFragmentActivity(Object obj, String str) {
        return (FragmentActivity) ZeusTransformUtils._getActivity(obj, str);
    }
}
