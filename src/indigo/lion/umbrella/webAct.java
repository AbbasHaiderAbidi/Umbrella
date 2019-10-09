package indigo.lion.umbrella;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;;

public class webAct extends Activity {
	
	WebView wbv;
	String str="http://google.com";
	
	
	@SuppressWarnings("deprecation")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		setContentView(R.layout.web_layout);
		wbv=(WebView) findViewById(R.id.web_lay);
		wbv.setWebViewClient(new brwse());
		wbv.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
		wbv.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
		wbv.getSettings().enableSmoothTransition();
		wbv.loadUrl(str);
		
		
		
		
		super.onCreate(savedInstanceState);
	}

	
	private class brwse extends WebViewClient{
		
		@Override
		public boolean shouldOverrideUrlLoading(WebView view, String url) {
			// TODO Auto-generated method stub
			view.loadUrl(str);
			return true;
		}
	}
}
