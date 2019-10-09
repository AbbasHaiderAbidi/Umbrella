package indigo.lion.umbrella;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.wifi.p2p.WifiP2pDeviceList;
import android.net.wifi.p2p.WifiP2pManager;
import android.net.wifi.p2p.WifiP2pManager.Channel;

public class wifiP2PBR extends BroadcastReceiver {

	private WifiP2pManager wm;
	private Channel ch;
	private p2pAct pact;

	public wifiP2PBR(WifiP2pManager wp2pm, Channel c, p2pAct pa) {
		super();
		this.wm = wp2pm;
		this.ch = c;
		this.pact = pa;
	}
	

	@Override
	public void onReceive(Context context, Intent intent) {
		String action = intent.getAction();
		int stat = intent.getIntExtra(WifiP2pManager.EXTRA_WIFI_STATE, -1);
		if (WifiP2pManager.WIFI_P2P_STATE_CHANGED_ACTION.equals(action)) {
			if (stat == WifiP2pManager.WIFI_P2P_STATE_ENABLED) {
				pact.stwfienabled(true);
			} else {
				pact.stwfienabled(false);
				//pact.resetdat();

			}
		} else if (WifiP2pManager.WIFI_P2P_PEERS_CHANGED_ACTION.equals(action)) {
		
			

		} else if (WifiP2pManager.WIFI_P2P_CONNECTION_CHANGED_ACTION
				.equals(action)) {

		} else if (WifiP2pManager.WIFI_P2P_THIS_DEVICE_CHANGED_ACTION
				.equals(action)) {

		}

	}

	
}
