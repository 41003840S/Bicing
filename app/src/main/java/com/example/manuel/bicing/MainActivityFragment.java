package com.example.manuel.bicing;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v4.content.CursorLoader;
import android.support.v4.content.Loader;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.manuel.bicing.provider.bicing.BicingColumns;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment implements android.support.v4.app.LoaderManager.LoaderCallbacks<Cursor> {

    ListView listaEstaciones;
    AdaptadorEstaciones adapter;
    SharedPreferences preferences;
    Intent intent;

    public MainActivityFragment() {
    }

    @Override
    public void onStart() {
        super.onStart();
        preferences = PreferenceManager.getDefaultSharedPreferences(getContext());

        //Si es la primera vez que arranca hace la llamada y lo guarda en la BD
        boolean primer_arranque = preferences.getBoolean(getString(R.string.primer_arranque), true);

        if (primer_arranque) {
            SharedPreferences.Editor editor = preferences.edit();
            editor.putBoolean("", false);
            editor.apply();

            refrescar();
            Toast.makeText(getActivity(), "Descargando estaciones", Toast.LENGTH_SHORT).show();
        }
        //.......................................

        /*if (preferences.getBoolean("switch_refresh", true)){
            // Your switch is on
            refrescar();
            Toast.makeText(getActivity(), "Descargando estaciones", Toast.LENGTH_SHORT).show();
        } else {
            // Your switch is off
        }*/
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View fragmentMain = inflater.inflate(R.layout.fragment_main, container, false);

        listaEstaciones = (ListView) fragmentMain.findViewById(R.id.listaEstaciones);

        //Inicializamos el Loader
        getLoaderManager().initLoader(0, null, this);

        //Enlazamos con el adaptador personalizado los datos con el ListView
        adapter = new AdaptadorEstaciones(getContext(),
                R.layout.station_row,
                null,
                new String[]{},
                new int[]{},
                0);

        //Seteamos el adaptador con el listview
        listaEstaciones.setAdapter(adapter);

        //Crea un Listener para que con pulsacion abra la estacion en un mapa
        listaEstaciones.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                intent = new Intent(getContext(), MapsActivity.class);
                intent.putExtra("id", id);
                Log.e("ENVIO ID", id + "---------------------------");
                startActivity(intent);
            }
        });

        return fragmentMain;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.menu_fragment, menu);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        } else if (id == R.id.action_estaciones) {
            intent = new Intent(getContext(), MapsActivity.class);
            startActivity(intent);
        }else if (id == R.id.action_refresh) {
            refrescar();
            Toast.makeText(getActivity(), "Descargando estaciones", Toast.LENGTH_SHORT).show();
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public Loader<Cursor> onCreateLoader(int id, Bundle args) {
        return new CursorLoader(getContext(),
                BicingColumns.CONTENT_URI,
                null,
                null,
                null,
                null);
    }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor data) {
        adapter.swapCursor(data);
    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader) {
        adapter.swapCursor(null);
    }


    public void refrescar() {
        RetroFit llamada = new RetroFit();
        llamada.downloadStations(getContext());
    }
}