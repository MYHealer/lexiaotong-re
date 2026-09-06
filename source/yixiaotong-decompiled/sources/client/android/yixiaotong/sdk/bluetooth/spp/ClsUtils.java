package client.android.yixiaotong.sdk.bluetooth.spp;

import android.bluetooth.BluetoothDevice;
import android.util.Log;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6847780.dex */
public class ClsUtils {
    public static boolean createBond(Class cls, BluetoothDevice bluetoothDevice) throws Exception {
        return ((Boolean) cls.getMethod("createBond", new Class[0]).invoke(bluetoothDevice, new Object[0])).booleanValue();
    }

    public static boolean removeBond(Class<?> cls, BluetoothDevice bluetoothDevice) throws Exception {
        return ((Boolean) cls.getMethod("removeBond", new Class[0]).invoke(bluetoothDevice, new Object[0])).booleanValue();
    }

    public static boolean setPin(Class<? extends BluetoothDevice> cls, BluetoothDevice bluetoothDevice, String str) throws Exception {
        try {
            Log.e("returnValue", "" + ((Boolean) cls.getDeclaredMethod("setPin", byte[].class).invoke(bluetoothDevice, str.getBytes())));
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (SecurityException e2) {
            e2.printStackTrace();
        } catch (Exception e3) {
            e3.printStackTrace();
        }
        return true;
    }

    public static boolean cancelPairingUserInput(Class<?> cls, BluetoothDevice bluetoothDevice) throws Exception {
        return ((Boolean) cls.getMethod("cancelPairingUserInput", new Class[0]).invoke(bluetoothDevice, new Object[0])).booleanValue();
    }

    public static boolean cancelBondProcess(Class<?> cls, BluetoothDevice bluetoothDevice) throws Exception {
        return ((Boolean) cls.getMethod("cancelBondProcess", new Class[0]).invoke(bluetoothDevice, new Object[0])).booleanValue();
    }

    public static void setPairingConfirmation(Class<?> cls, BluetoothDevice bluetoothDevice, boolean z) throws Exception {
        cls.getDeclaredMethod("setPairingConfirmation", Boolean.TYPE).invoke(bluetoothDevice, Boolean.valueOf(z));
    }

    public static void printAllInform(Class cls) {
        try {
            Method[] methods = cls.getMethods();
            for (int i = 0; i < methods.length; i++) {
                Log.e("method name", methods[i].getName() + ";and the i is:" + i);
            }
            for (Field field : cls.getFields()) {
                Log.e("Field name", field.getName());
            }
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (SecurityException e2) {
            e2.printStackTrace();
        } catch (Exception e3) {
            e3.printStackTrace();
        }
    }
}
