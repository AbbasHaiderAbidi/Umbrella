package indigo.lion.umbrella;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class simpleSplash extends Activity {
	SharedPreferences sp1;
	ImageView im, imt;
	boolean chk=false;
	TextView loadtxt;
	Intent in1;
	
	Animation anim;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.simple_splash);
		
		sp1 = getprefs(sp1);
		imt = (ImageView) findViewById(R.id.loadt);
		loadtxt = (TextView) findViewById(R.id.loadtxt);
		//sp1 = getSharedPreferences("LoginDATA", MODE_PRIVATE);
		im = (ImageView) findViewById(R.id.Load);
		anim=AnimationUtils.loadAnimation(simpleSplash.this, R.anim.loadanim);
		
		imt.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				gotoact();
			}
		});
	}
	public SharedPreferences getprefs(SharedPreferences sp){
		sp=getSharedPreferences("LoginDATA", MODE_PRIVATE);
		return sp;
	}
	public void logout(){
		sp1=getSharedPreferences("LoginDATA", MODE_PRIVATE);
		Editor ed=sp1.edit();
		ed.putBoolean("isOK", false);
		ed.commit();
		gotoact();
	}
	public void ext(){
		System.exit(0);
	}

	public void gotoact() {
		loadtxt.setVisibility(View.VISIBLE);
		//im.setBackgroundResource(R.anim.loadanim);
		
		if (sp1.getBoolean("isOK", false)) {
			in1 = new Intent(simpleSplash.this, indigo.lion.umbrella.UmbrellaAct.class);
			chk=true;
		} else {
			in1 = new Intent(simpleSplash.this, UmbrellaLogin.class);
		}
	
		loadtxt.postDelayed(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				if(chk){
				NotificationManager nm=(NotificationManager) getSystemService(NOTIFICATION_SERVICE);
				Notification n=new Notification(R.drawable.drwer,"User Login",System.currentTimeMillis());
				PendingIntent pi=PendingIntent.getActivity(simpleSplash.this,0,in1,0);
					n.setLatestEventInfo(getApplication(), "Valid User login. ", "User: "+sp1.getString("user", ""), pi);
					
					nm.notify(0, n);
					
				}
			
				finish();
				startActivity(in1);
				
			}
		}, 5000);
		
		im.startAnimation(anim);
		
	}
}
