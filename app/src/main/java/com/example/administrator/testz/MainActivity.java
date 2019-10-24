package com.example.administrator.testz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.tencent.rtmp.TXLiveBase;
import com.tencent.rtmp.TXLivePushConfig;
import com.tencent.rtmp.TXLivePusher;
import com.tencent.rtmp.ui.TXCloudVideoView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private TXLiveBase mTXLiveBase;
    private TXLivePusher mLivePusher;
 

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        String sdkver = TXLiveBase.getSDKVersionStr();
        Log.e("TAG", "MainActivity: " + sdkver);

        TXLivePushConfig mLivePushConfig = new TXLivePushConfig();
        mLivePusher = new TXLivePusher(this);

        // 一般情况下不需要修改 config 的默认配置
        mLivePusher.setConfig(mLivePushConfig);
        TXCloudVideoView mPusherView = (TXCloudVideoView) findViewById(R.id.pusher_tx_cloud_view);
        mLivePusher.startCameraPreview(mPusherView);

    }



    //adds popmenu to toolbar
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int menu_id = item.getItemId();
        switch (menu_id) {
            case R.id.item1_id:
                //启动本地摄像头预览

                break;
            case R.id.item2_id:
               String mUrl = 请输入你的推流地址; //此处填写您的 rtmp 推流地址
                int ret = mLivePusher.startPusher(mUrl);
                /// 0: 启动成功；-1: 启动失败；-5：license 校验失败  查看日志，0表示推流成功，
                Log.e("TAG", "cf_btn_start_live: " + ret);
                break;
            case R.id.item3_id:
                mLivePusher.stopCameraPreview(true);
                break;
            case R.id.item4_id:
                mLivePusher.stopPusher();
                break;
            default:
                break;

        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {

    }
}
