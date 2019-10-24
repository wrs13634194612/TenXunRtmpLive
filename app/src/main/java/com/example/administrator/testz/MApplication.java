package com.example.administrator.testz;

import android.app.Application;
import android.util.Log;

import com.tencent.rtmp.TXLiveBase;

/**
 * Created by wrs on 24/10/2019,下午 6:40
 * projectName: Testz
 * packageName: com.example.administrator.testz
 */

public class MApplication extends Application {


    @Override
    public void onCreate() {
        super.onCreate();
        String licenceURL = 请输入你的licenceURL; // 获取到的 licence url
        String licenceKey = 请输入你的licenceKey; // 获取到的 licence key
        TXLiveBase.getInstance().setLicence(this, licenceURL, licenceKey);
        TXLiveBase.getInstance().getLicenceInfo(this);

    }
}