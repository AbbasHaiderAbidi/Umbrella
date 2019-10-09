package indigo.lion.umbrella;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.app.FragmentManager;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.support.v4.widget.DrawerLayout;

public class UmbrellaAct extends ActionBarActivity implements
		NavigationDrawerFragment.NavigationDrawerCallbacks {

	/**
	 * Fragment managing the behaviors, interactions and presentation of the
	 * navigation drawer.
	 */
	private NavigationDrawerFragment mNavigationDrawerFragment;

	/**
	 * Used to store the last screen title. For use in
	 * {@link #restoreActionBar()}.
	 */
	private CharSequence mTitle;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_umbrella);

		mNavigationDrawerFragment = (NavigationDrawerFragment) getSupportFragmentManager()
				.findFragmentById(R.id.navigation_drawer);
		mTitle = getTitle();

		// Set up the drawer.
		mNavigationDrawerFragment.setUp(R.id.navigation_drawer,
				(DrawerLayout) findViewById(R.id.drawer_layout));
	}

	@Override
	public void onNavigationDrawerItemSelected(int position) {
		// update the main content by replacing fragments
		FragmentManager fm = getFragmentManager();
		
		if(position==3){
		
			fm.beginTransaction().replace(R.id.container, new Email()).commit();
		}
		else if(position==4){
			System.exit(0);
			new simpleSplash().ext();
		
		}
		
		else{
			fm.beginTransaction().replace(R.id.container, new HomeAct()).commit();
		}
	
		/*Fragment fr;
		if(position==1){
			fr=new HomeAct();
		}*/
		
	
	}

	public void onSectionAttached(int number) {
		switch (number) {
		case 1:
			mTitle = getString(R.string.title_section1);
			break;
		case 2:
			mTitle = getString(R.string.title_section2);
			break;
		case 3:
			mTitle = getString(R.string.title_section3);
			break;
		case 4:
			mTitle = getString(R.string.contct);
			break;
		case 5:
			mTitle = getString(R.string.exit);
			break;
		}
	}

	public void restoreActionBar() {
		ActionBar actionBar = getSupportActionBar();
		actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_STANDARD);
		actionBar.setDisplayShowTitleEnabled(true);
		actionBar.setTitle(mTitle);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		if (!mNavigationDrawerFragment.isDrawerOpen()) {
			// Only show items in the action bar relevant to this screen
			// if the drawer is not showing. Otherwise, let the drawer
			// decide what to show in the action bar.
			getMenuInflater().inflate(R.menu.umbrella, menu);
			restoreActionBar();
			return true;
		}
		return super.onCreateOptionsMenu(menu);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		 if (id == R.id.action_example){
			 SharedPreferences sp1=getSharedPreferences("LoginDATA", MODE_PRIVATE);
				Editor ed=sp1.edit();
				ed.putBoolean("isOK", false);
				ed.commit();
				startActivity(new Intent(UmbrellaAct.this,UmbrellaLogin.class));
				finish();
		 
		 }
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

/*	
	public static class PlaceholderFragment extends Fragment {
		
		private static final String ARG_SECTION_NUMBER = "section_number";

		
		public PlaceholderFragment newInstance(int sectionNumber) {
			PlaceholderFragment fragment;
			
			if(sectionNumber==1){
				fragment = new HomeAct();
			}
			else if(sectionNumber==4){
				fragment= new Email();
			}
			else if(sectionNumber==5){
				simpleSplash ss=new simpleSplash();				
				System.exit(0);
				ss.ext();
			}
			else if(sectionNumber==2){
				startActivity(new Intent(ua,simpleSplash.class));
			}
			fragment = new HomeAct();
			Bundle args = new Bundle();
			args.putInt(ARG_SECTION_NUMBER, sectionNumber);
			fragment.setArguments(args);
			return fragment;
		}

		public PlaceholderFragment() {
			
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.email_layout,
					container, false);
			return rootView;
		}

		@Override
		public void onAttach(Activity activity) {
			super.onAttach(activity);
			((UmbrellaAct) activity).onSectionAttached(getArguments().getInt(
					ARG_SECTION_NUMBER));
		}
	}*/

}
