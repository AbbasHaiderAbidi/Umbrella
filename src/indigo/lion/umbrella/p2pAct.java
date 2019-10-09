package indigo.lion.umbrella;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.IntentFilter;
import android.net.wifi.p2p.WifiP2pManager;
import android.net.wifi.p2p.WifiP2pManager.Channel;
import android.os.Bundle;

public class p2pAct extends Activity {
	WifiP2pManager wp2pm;
	Channel ch;
	BroadcastReceiver br;
	IntentFilter infil;
	boolean wifienbld=false;

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		wp2pm = (WifiP2pManager) getSystemService(WIFI_P2P_SERVICE);
		
		ch = wp2pm.initialize(getApplicationContext(), getMainLooper(), null);
		br = new wifiP2PBR(wp2pm, ch, this);
		infil = new IntentFilter();
		infil.addAction(WifiP2pManager.WIFI_P2P_STATE_CHANGED_ACTION);
		infil.addAction(WifiP2pManager.WIFI_P2P_PEERS_CHANGED_ACTION);
		infil.addAction(WifiP2pManager.WIFI_P2P_CONNECTION_CHANGED_ACTION);
		infil.addAction(WifiP2pManager.WIFI_P2P_THIS_DEVICE_CHANGED_ACTION);
	}

	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		registerReceiver(br, infil);
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		unregisterReceiver(br);
	}
	public void stwfienabled(boolean f){
		this.wifienbld=f;
	}

	
	
}
