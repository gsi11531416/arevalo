package mx.edu.utng.primefaceslfar.juego2;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;

import mx.edu.utng.primefaceslfar.R;

public class Game extends ActionBarActivity {

    private GameView gameView;
    private boolean isPlayMusica;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        gameView = new GameView(this);
        gameView.setPadre(this);
        setContentView(gameView);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("Main", "onPause()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("Main", "onResume()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("Main", "onDestroy()");
        if (gameView.gameLoopThread.isAlive())
            gameView.gameLoopThread.stopThread();
    }

    @Override
    protected void onStart() {
        super.onStart();
        SharedPreferences pref = getSharedPreferences(
                "eprod.game.killtheall_preferences", Context.MODE_PRIVATE);
        isPlayMusica = pref.getBoolean("musica", false);
        if (isPlayMusica) {
            startService(new Intent(Game.this, ServicioMusicaFondo.class));
        } else {
            stopService(new Intent(Game.this, ServicioMusicaFondo.class));
        }
    }

    @Override
    protected void onStop() {
        super.onStop();

        Log.i("MainActivity", "onStop");
        stopService(new Intent(Game.this, ServicioMusicaFondo.class));
    }
}
