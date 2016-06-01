package huamaisdk.demo;

import android.util.Log;

import com.huamaitel.api.HMCallback.AlarmCallback;
import com.huamaitel.api.HMDefines;
import com.huamaitel.api.HMDefines.AlarmInfo;

/**
 * 报警功能类
 * 
 * @author admin
 * 
 */
public class AlarmPlay {

	public void startAlarm() {
		if (MainApp.mUserId != 0) {
			AlarmCallback alarmCB = new AlarmCallback() {
				@Override
				public void onAlarm(int arg0, AlarmInfo arg1) {
					int errorCode = arg0;
					HMDefines.AlarmInfo alarmInfo = arg1;

					Log.i(MainApp.TAG, "Alarm info - errorCode: " + errorCode);
					Log.i(MainApp.TAG, "Alarm info - deviceName: "
							+ alarmInfo.deviceName);
					Log.i(MainApp.TAG, "Alarm info - sn:  " + alarmInfo.sn);

				}
			};
			MainApp.mAlarmHandle=MainApp.getJni().startAlarm(MainApp.mUserId, alarmCB);
		}
	}


	public void stopAlarm() {
		if (MainApp.mAlarmHandle != 0) {
			MainApp.getJni().stopAlarm(MainApp.mAlarmHandle);
		}
		Log.i(MainApp.TAG, "Alarm stop!!!!");
	}

}
