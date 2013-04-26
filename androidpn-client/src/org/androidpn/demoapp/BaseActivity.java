package org.androidpn.demoapp;

import org.androidpn.client.NotificationService;
import org.androidpn.client.NotificationSettingsActivity;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class BaseActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
	}
	
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// TODO Auto-generated method stub
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}



	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		switch(item.getItemId()){
		case R.id.action_settings:
			Intent intent = new Intent().setClass(this,
		                NotificationSettingsActivity.class);
		        startActivity(intent);
			break;
		case R.id.action_exit:
			AlertDialog.Builder exitBuilder = new AlertDialog.Builder(this);
			exitBuilder.setTitle(R.string.exit_doult_title);
			exitBuilder.setMessage(R.string.exit_doult_message);
			exitBuilder.setPositiveButton(R.string.cancel, null);
			exitBuilder.setNegativeButton(R.string.exit, new OnClickListener(){
				@Override
				public void onClick(DialogInterface dialog, int which) {
					// TODO Auto-generated method stub
					stopService(NotificationService.getIntent());
					finish();
				}
			});
			exitBuilder.show();
			break;
		}
		return true;
	}
	
	

}
