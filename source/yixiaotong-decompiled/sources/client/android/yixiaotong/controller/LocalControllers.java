package client.android.yixiaotong.controller;

import client.android.yixiaotong.account.Account;
import client.android.yixiaotong.controller.bean.local.LocalCountDownBean;
import client.android.yixiaotong.controller.core.BaseControllers;
import client.android.yixiaotong.controller.core.Controller;
import client.android.yixiaotong.controller.core.Listener;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6847780.dex */
public class LocalControllers extends BaseControllers {
    private LocalControllers() {
    }

    private static class SingletonHolder {
        public static final LocalControllers INSTANCE = new LocalControllers();

        private SingletonHolder() {
        }
    }

    public static LocalControllers getInstance() {
        return SingletonHolder.INSTANCE;
    }

    public void timeCountDown(Account account, Listener<LocalCountDownBean> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.controller.LocalControllers.1
            @Override // java.lang.Runnable
            public void run() {
                int i = 60;
                while (i > 0) {
                    i--;
                    LocalCountDownBean localCountDownBean = new LocalCountDownBean();
                    localCountDownBean.time = i;
                    if (i == 0) {
                        localCountDownBean.complete = true;
                    } else {
                        localCountDownBean.complete = false;
                    }
                    LocalControllers.this.callComplete(controller, localCountDownBean, new Object[0]);
                    try {
                        Thread.sleep(1000L);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }

    public void timeCountDown(Account account, final long j, Listener<LocalCountDownBean> listener) {
        final Controller controller = new Controller(account, listener, new Object[0]);
        runToAsyncThread(new Runnable() { // from class: client.android.yixiaotong.controller.LocalControllers.2
            @Override // java.lang.Runnable
            public void run() {
                long j2 = j;
                while (j2 > 0) {
                    j2--;
                    LocalCountDownBean localCountDownBean = new LocalCountDownBean();
                    localCountDownBean.time = j2;
                    if (j2 == 0) {
                        localCountDownBean.complete = true;
                    } else {
                        localCountDownBean.complete = false;
                    }
                    LocalControllers.this.callComplete(controller, localCountDownBean, new Object[0]);
                    try {
                        Thread.sleep(1000L);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }

    public void cancelTime(Controller controller) {
        if (controller != null) {
            controller.cancelController();
        }
    }
}
