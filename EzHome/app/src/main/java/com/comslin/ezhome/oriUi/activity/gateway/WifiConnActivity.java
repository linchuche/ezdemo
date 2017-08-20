package com.comslin.ezhome.oriUi.activity.gateway;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.comslin.ezhome.R;
import com.comslin.ezhome.oriUi.activity.BaseActivity;
import com.espressif.iot.esptouch.EsptouchTask;
import com.espressif.iot.esptouch.IEsptouchResult;
import com.espressif.iot.esptouch.IEsptouchTask;
import com.espressif.iot.esptouch.demo_activity.EspWifiAdminSimple;
import com.espressif.iot.esptouch.task.__IEsptouchTask;

/**
 * Created by linchaoer@qq.com on 2017/8/18.
 */

public class WifiConnActivity extends BaseActivity implements View.OnClickListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LayoutInflater.from(this).inflate(R.layout.wireless_configure_layout,topContentView);
        setTitle("无线连接");
        mWifiAdmin = new EspWifiAdminSimple(this);
        mTvApSsid = (TextView) findViewById(R.id.wireless_configure_select);
        mEdtApPassword = (EditText) findViewById(R.id.select_net_wireless_password);
        mBtnConfirm = (Button) findViewById(R.id.wireless_configure_start);
        mBtnConfirm.setOnClickListener(this);

    }
    private static final String TAG = "EsptouchDemoActivity";

    private TextView mTvApSsid;

    private EditText mEdtApPassword;

    private Button mBtnConfirm;

    private EspWifiAdminSimple mWifiAdmin;


    @Override
    protected void onResume() {
        super.onResume();
        // display the connected ap's ssid
        String apSsid = mWifiAdmin.getWifiConnectedSsid();
        if (apSsid != null) {
            mTvApSsid.setText(apSsid);
        } else {
            mTvApSsid.setText("");
        }
        // check whether the wifi is connected
        boolean isApSsidEmpty = TextUtils.isEmpty(apSsid);
        mBtnConfirm.setEnabled(!isApSsidEmpty);
    }

    @Override
    public void onClick(View v) {

        if (v == mBtnConfirm) {
            String apSsid = mTvApSsid.getText().toString();
            String apPassword = mEdtApPassword.getText().toString();
            if (__IEsptouchTask.DEBUG) {
                Log.d(TAG, "mBtnConfirm is clicked, mEdtApSsid = " + apSsid
                        + ", " + " mEdtApPassword = " + apPassword);
            }
            new EsptouchAsyncTask2().execute(apSsid, apPassword);
        }
    }


    private class EsptouchAsyncTask extends AsyncTask<String, Void, Boolean> {

        private ProgressDialog mProgressDialog;

        private IEsptouchTask mEsptouchTask;

        @Override
        protected void onPreExecute() {
            mProgressDialog = new ProgressDialog(WifiConnActivity.this);
            mProgressDialog
                    .setMessage("Is configuring, please wait for a moment...");
            mProgressDialog.setCanceledOnTouchOutside(false);
            mProgressDialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
                @Override
                public void onCancel(DialogInterface dialog) {
                    if (__IEsptouchTask.DEBUG) {
                        Log.i(TAG, "progress dialog is canceled");
                    }
                    if (mEsptouchTask != null) {
                        mEsptouchTask.interrupt();
                    }
                }
            });
            mProgressDialog.setButton(DialogInterface.BUTTON_POSITIVE,
                    "Waiting...", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                        }
                    });
            mProgressDialog.show();
            mProgressDialog.getButton(DialogInterface.BUTTON_POSITIVE)
                    .setEnabled(false);
        }

        @Override
        protected Boolean doInBackground(String... params) {
            String apSsid = params[0];
            String apPassword = params[1];
            mEsptouchTask = new EsptouchTask(apSsid, apPassword,
                    WifiConnActivity.this);
            boolean result = mEsptouchTask.execute();
            return result;
        }

        @Override
        protected void onPostExecute(Boolean result) {
            mProgressDialog.getButton(DialogInterface.BUTTON_POSITIVE)
                    .setEnabled(true);
            mProgressDialog.getButton(DialogInterface.BUTTON_POSITIVE).setText(
                    "Confirm");
            // it is unnecessary at the moment, add here just to show how to use isCancelled()
            if (!mEsptouchTask.isCancelled()) {
                if (result) {
                    mProgressDialog.setMessage("Esptouch success");
                } else {
                    mProgressDialog.setMessage("Esptouch fail");
                }
            }
        }
    }

    private class EsptouchAsyncTask2 extends AsyncTask<String, Void, IEsptouchResult> {

        private ProgressDialog mProgressDialog;

        private IEsptouchTask mEsptouchTask;

        @Override
        protected void onPreExecute() {
            mProgressDialog = new ProgressDialog(WifiConnActivity.this);
            mProgressDialog
                    .setMessage("Is configuring, please wait for a moment...");
            mProgressDialog.setCanceledOnTouchOutside(false);
            mProgressDialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
                @Override
                public void onCancel(DialogInterface dialog) {
                    if (__IEsptouchTask.DEBUG) {
                        Log.i(TAG, "progress dialog is canceled");
                    }
                    if (mEsptouchTask != null) {
                        mEsptouchTask.interrupt();
                    }
                }
            });
            mProgressDialog.setButton(DialogInterface.BUTTON_POSITIVE,
                    "Waiting...", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                        }
                    });
            mProgressDialog.show();
            mProgressDialog.getButton(DialogInterface.BUTTON_POSITIVE)
                    .setEnabled(false);
        }

        @Override
        protected IEsptouchResult doInBackground(String... params) {
            String apSsid = params[0];
            String apPassword = params[1];
            mEsptouchTask = new EsptouchTask(apSsid, apPassword,
                    WifiConnActivity.this);
            IEsptouchResult result = mEsptouchTask.executeForResult();
            return result;
        }

        @Override
        protected void onPostExecute(IEsptouchResult result) {
            mProgressDialog.getButton(DialogInterface.BUTTON_POSITIVE)
                    .setEnabled(true);
            mProgressDialog.getButton(DialogInterface.BUTTON_POSITIVE).setText(
                    "Confirm");
            // it is unnecessary at the moment, add here just to show how to use isCancelled()
            if (!result.isCancelled()) {
                if (result.isSuc()) {
                    mProgressDialog.setMessage("success, bssid = "
                            + result.getBssid());
                } else {
                    mProgressDialog.setMessage("fail");
                }
            }
        }
    }

}
