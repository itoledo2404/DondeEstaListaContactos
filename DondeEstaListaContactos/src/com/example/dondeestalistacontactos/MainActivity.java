package com.example.dondeestalistacontactos;


import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {

	//Creo el objeto texto para que sea global
    private EditText txtTexto;
	private static final String TAG = "Main";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		//Creo los objetos boton y texto
		final Button boton1 = (Button)findViewById(R.id.button1);
		final Button boton2 = (Button)findViewById(R.id.button2);
		
		
		//Creo el Listener del Click Boton1
				boton1.setOnClickListener(new Button.OnClickListener(){
				
					@Override
					public void onClick(View v) {
						
						String texto = txtTexto.getText().toString();
						//Uso la clase Intent para llamar al Googlemaps y le paso mi variable texto como direccion
						Intent mapa = new Intent (android.content.Intent.ACTION_VIEW,
								Uri.parse("geo:0,0?q=" + texto));
						startActivity(mapa);
						
					}
				}
				
				
		);
		//Creo el Listener del Click Boton
				boton2.setOnClickListener(new Button.OnClickListener(){

					@Override
					public void onClick(View v) {
						//Con el intent lanzo la segunda ventana
						Intent segunda = new Intent (MainActivity.this,
								ContactosActivity.class);
						startActivityForResult(segunda,1);
						
					}
				}
		);
		//Controlo el create de la aplicacion
		Log.i(TAG, "onCreate");
	}
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		txtTexto = (EditText)findViewById(R.id.editText1);
		
		if (requestCode == 1) {
		if(resultCode == RESULT_OK){
		String resultado=data.getStringExtra("txt");
		txtTexto.setText(resultado);
		}
		if (resultCode == RESULT_CANCELED) {
		}
		}
	}//final onActivityResult

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	//Controlo el ciclo de vida de mi activity
	@Override
	protected void onStart() {
		super.onStart();
		Log.i(TAG, "onStart");
	}
	@Override
	protected void onResume() {
		super.onResume();
		Log.i(TAG, "onResume");
	}
	@Override
	protected void onPause() {
		super.onPause();
		Log.i(TAG, "onPause");
	}
	@Override
	protected void onStop() {
		super.onStop();
		Log.i(TAG, "onStop");
	}
	@Override
	protected void onRestart() {
		super.onRestart();
		Log.i(TAG, "onRestart");
	}
	@Override
	protected void onDestroy() {
		super.onDestroy();
		Log.i(TAG, "onDestroy");
	}
}
