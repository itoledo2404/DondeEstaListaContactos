package com.example.dondeestalistacontactos;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class ContactosActivity extends Activity {
	private static final String TAG = "Contactos";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_contactos);
		//Preparamos los botones de vuelta
		final Button boton1 = (Button) findViewById(R.id.button1);
		// Un objeto de la clase interna reponderá al click.
		boton1.setOnClickListener(new devolverlugar());
		final Button boton2 = (Button) findViewById(R.id.button2);
			// Un objeto de la clase interna reponderá al click.
		boton2.setOnClickListener(new devolverlugar());
	    final Button boton3 = (Button) findViewById(R.id.button3);
		// Un objeto de la clase interna reponderá al click.
		boton3.setOnClickListener(new devolverlugar());
		final Button boton4 = (Button) findViewById(R.id.button4);
		// Un objeto de la clase interna reponderá al click.
		boton4.setOnClickListener(new devolverlugar());
		final Button boton5 = (Button) findViewById(R.id.button5);
		// Un objeto de la clase interna reponderá al click.
		boton5.setOnClickListener(new devolverlugar());
		final Button boton6 = (Button) findViewById(R.id.button6);
		// Un objeto de la clase interna reponderá al click.
		boton6.setOnClickListener(new devolverlugar());
		//Controlo el create de la aplicacion
		Log.i(TAG, "onCreate");
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.contactos, menu);
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
	//Gestionamos los eventos de los botones
	class devolverlugar implements Button.OnClickListener{
		@Override
		public void onClick(View v) {
			
			String text = "";
			//Verifico el boton que estamos pulsando
			if (v.getId()==R.id.button1){
				text = "Bilbao";
			}else if (v.getId()==R.id.button2){
				text = "Valencia";
			}else if (v.getId()==R.id.button3){
				text = "Barcelona";
			}else if (v.getId()==R.id.button4){
				text = "Madrid";
			}else if (v.getId()==R.id.button5){
				text = "Sevilla";
			}else if (v.getId()==R.id.button6){
				text = "Valladolid";
			}
			Intent devolucion = new Intent();
			//En el Intent enviamos la información de la primera ventana
			devolucion.putExtra("txt", text);
			setResult(RESULT_OK,devolucion);
			finish();
			
			}
	
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
