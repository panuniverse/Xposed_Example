package com.example.spt_test.modifiyinformation;

import android.telephony.TelephonyManager;
import android.util.Log;

import de.robv.android.xposed.IXposedHookLoadPackage;
import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XposedBridge;
import de.robv.android.xposed.XposedHelpers;
import de.robv.android.xposed.callbacks.XC_LoadPackage;

public class HookFunction implements IXposedHookLoadPackage {

    public void handleLoadPackage(XC_LoadPackage.LoadPackageParam loadPackageParam) throws Throwable {
        //XposedBridge.log("Start load"+"asdsd");
        HookMethod(TelephonyManager.class, "getDeviceId", "123456789");
        //Class clazz = loadPackageParam.classLoader.loadClass("com.example.spt_test.modifiyinformation.MainActivity");
        //HookMethod(clazz, "testMethond", "我被劫持456");

        //Log.i("HookData","sss");
    }

    private void HookMethod(final Class clazz, final String method, final String result){
        try{
            XposedHelpers.findAndHookMethod(clazz, method, new Object[] { new XC_MethodHook() {
                protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                    param.setResult(result);
                }
            } });
        } catch (Throwable e){
            e.printStackTrace();
        }
    }
}
