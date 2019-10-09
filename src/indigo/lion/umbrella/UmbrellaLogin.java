package indigo.lion.umbrella;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class UmbrellaLogin extends Activity {
	ImageView log;
	CheckBox cb;
	TextView msg;
	EditText email1, pass;
	String email, passcode;
	Intent in;
	SharedPreferences sp;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.umbrella_login);
		log = (ImageView) findViewById(R.id.login);
		cb = (CheckBox) findViewById(R.id.stayLoggedIn);
		email1 = (EditText) findViewById(R.id.email1);
		pass = (EditText) findViewById(R.id.Passcode);
		msg = (TextView) findViewById(R.id.msg);
		in = new Intent(UmbrellaLogin.this,
				simpleSplash.class);
		sp=getSharedPreferences("LoginDATA", MODE_PRIVATE);
		if(sp.getBoolean("isOK", false))
		{
			startActivity(in);
			finish();
		}
		
		log.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {

				log.setImageResource(R.drawable.logoshad);

				email = email1.getText().toString();
				passcode = pass.getText().toString();
				if (android.util.Patterns.EMAIL_ADDRESS.matcher(email)
						.matches()) {
					if (passcode.equals("")) {
						Toast.makeText(getApplicationContext(),
								"Enter the passcode", Toast.LENGTH_LONG).show();
					} else {
						
						if (chkiftrue(email,passcode)) {

							if (cb.isChecked()) {
								//Toast.makeText(getApplicationContext(), "true:Checked", 4000).show();
								StayLogged(email,passcode);
							} else {
								
								finish();
								in=new Intent(UmbrellaLogin.this,UmbrellaAct.class);
								startActivity(in);
								Toast.makeText(
										getApplicationContext(),
										"Logged ID :"
												+ email.substring(0,
														email.indexOf("@")),
										Toast.LENGTH_LONG).show();
							}
						} else {
							msg.setTextColor(Color.RED);
							msg.setText("Please Enter the Correct Passcode for the E-Mail: \n"
									+ email);
						}
					}

				} else {
					Toast.makeText(getApplicationContext(),
							"Enter valid Email", Toast.LENGTH_LONG).show();
				}
			}
		});

		log.setOnTouchListener(new View.OnTouchListener() {

			@Override
			public boolean onTouch(View v, MotionEvent event) {
				// TODO Auto-generated method stub

				log.setImageResource(R.drawable.logoflt);

				return false;
			}
		});

	}

	public void StayLogged(String em1,String pas1){
		
		Editor edt=sp.edit();
		edt.putBoolean("isOK", chkiftrue(em1,pas1));
		edt.putString("user",em1);
		edt.putString("pass", pas1);
		edt.commit();
		startActivity(in);
	}
	public boolean chkiftrue(String email,String pass){
		if(email.trim().equals("abbas@gmail.com")&&(pass.trim().equals("abbas")))			
			return true;
		
		return false;
		
	}
	/*@Override
	public void startActivity(Intent intent, Bundle options) {
		// TODO Auto-generated method stub
		super.startActivity(intent, options);
		overridePendingTransition(android.R.anim.slide_in_left,
				android.R.anim.slide_out_right);
	}*/
}
