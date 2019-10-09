package indigo.lion.umbrella;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class Email extends Fragment implements View.OnClickListener {

	EditText sbjct, cntnt, emailadd;
	ImageView send;
	CheckBox dev;
	String subject, content, myemail = "abbashaider2131995@gmail.com";

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		return inflater.inflate(R.layout.email_layout, container, false);
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onActivityCreated(savedInstanceState);
		chandler();

		send.setOnTouchListener(new View.OnTouchListener() {

			@Override
			public boolean onTouch(View v, MotionEvent event) {
				// TODO Auto-generated method stub

				send.setImageResource(R.drawable.sendaftr);

				return false;
			}
		});
		send.setOnClickListener(this);
		dev.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			
			@Override
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
				// TODO Auto-generated method stub
				if(dev.isChecked()){
					emailadd.setText(myemail);
					emailadd.setFocusable(false);
				}
				else{
					emailadd.setText("");
					emailadd.setFocusable(true);
					emailadd.setKeepScreenOn(true);
				}
			}
		});
	}

	private void chandler() {
		dev=(CheckBox) getActivity().findViewById(R.id.dev);
		emailadd = (EditText) getActivity().findViewById(R.id.emailadd);
		sbjct = (EditText) getActivity().findViewById(R.id.sbjct);
		cntnt = (EditText) getActivity().findViewById(R.id.cntnt);
		send = (ImageView) getActivity().findViewById(R.id.send);
		
	}

	@Override
	public void onClick(View v) {
		if(emailadd.getText().toString().contains("@")&&(sbjct.getText().toString().isEmpty()==false)){
		String[] addrss = { emailadd.getText().toString() };
		send.setImageResource(R.drawable.sendbfr);
		
		Intent ei = new Intent(android.content.Intent.ACTION_SEND);
		ei.putExtra(android.content.Intent.EXTRA_EMAIL, addrss);
		ei.putExtra(android.content.Intent.EXTRA_SUBJECT, sbjct.getText().toString());
		ei.setType("plain/text");
		ei.putExtra(android.content.Intent.EXTRA_TEXT, cntnt.getText().toString());
		startActivity(ei);
		}
		else{
			Toast.makeText(getActivity(), "Enter a valid Email and a Subject to the Email", Toast.LENGTH_LONG).show();
		}
	}
	/*
	 * @Override public void startActivity(Intent intent, Bundle options) { //
	 * TODO Auto-generated method stub super.startActivity(intent, options);
	 * overridePendingTransition
	 * (android.R.anim.accelerate_interpolator,android.R
	 * .anim.accelerate_interpolator); }
	 */

}
