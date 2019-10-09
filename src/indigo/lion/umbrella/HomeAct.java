package indigo.lion.umbrella;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class HomeAct extends Fragment {
	ImageView bluetooth, email, wifi;

	Animation anim1;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		return inflater.inflate(R.layout.home_layout, container, false);
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		

		bluetooth = (ImageView) getActivity().findViewById(R.id.blue);
		email = (ImageView) getActivity().findViewById(R.id.email);
		wifi = (ImageView) getActivity().findViewById(R.id.wifi);
		anim1 = AnimationUtils.loadAnimation(getActivity(), R.anim.homeanim);
		bluetooth.setOnTouchListener(new View.OnTouchListener() {

			@Override
			public boolean onTouch(View v, MotionEvent event) {
				// TODO Auto-generated method stub
				bluetooth.setBackgroundResource(R.drawable.bluetooth2);
				
				return false;
			}
		});
		bluetooth.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				bluetooth.setBackgroundResource(R.drawable.bluetooth);
				bluetooth.startAnimation(anim1);

			}
		});
		email.setOnTouchListener(new View.OnTouchListener() {

			@Override
			public boolean onTouch(View v, MotionEvent event) {
				// TODO Auto-generated method stub
				email.setBackgroundResource(R.drawable.email2);
				return false;
			}
		});
		email.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				email.setBackgroundResource(R.drawable.email);
				email.startAnimation(anim1);

			}
		});
		wifi.setOnTouchListener(new View.OnTouchListener() {

			@Override
			public boolean onTouch(View v, MotionEvent event) {
				// TODO Auto-generated method stub
				wifi.setBackgroundResource(R.drawable.wifi2);
				return false;
			}
		});
		wifi.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				wifi.setBackgroundResource(R.drawable.wifi);
				wifi.startAnimation(anim1);

			}
		});
		super.onActivityCreated(savedInstanceState);
	}

}
