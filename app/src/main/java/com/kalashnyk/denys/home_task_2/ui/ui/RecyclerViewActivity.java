package com.kalashnyk.denys.home_task_2.ui.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

import com.kalashnyk.denys.home_task_2.R;
import com.kalashnyk.denys.home_task_2.ui.ui.adapters.AdapterRecyclerView;
import com.kalashnyk.denys.home_task_2.ui.utils.Constants;

import java.util.ArrayList;

/**
 * Created by User on 21.06.2016.
 */
public class RecyclerViewActivity extends AppCompatActivity {

//    public static final int ATTR_LAYOUT_LIN = 1;
//    public static final int ATTR_LAYOUT_GRID = 2;

    private ArrayList mData;
    private RecyclerView mRecyclerView;
    private RecyclerView.LayoutManager mLayoutManager;
    private AdapterRecyclerView mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler);


        initialise();
    }
    private void initialise(){
        setTitle(R.string.text_activity_recycler_title);
        Constants data = new Constants();
        mData = data.getBooksData();

		//инициализация mRecyclerView существующим ресурсом rcView_recycler
        mRecyclerView = (RecyclerView) findViewById(R.id.rcView_recycler);
        mRecyclerView.setHasFixedSize(true);
		
		//создание вертикального LayoutManager
        mLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        mRecyclerView.setLayoutManager(mLayoutManager);

        mAdapter = new AdapterRecyclerView(this, mData, Constants.ATTR_LAYOUT_LIN);
        mRecyclerView.setAdapter(mAdapter);
    }
    @Override
	//Создание меню настроек
    public boolean onCreateOptionsMenu(Menu menu) {
		//преобразование из XML в графический объект
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
	//обработка нажатия на пункт меню)
    public boolean onOptionsItemSelected(MenuItem item) {
		//Переключение между Layout (Lin, Grid -- линейный или сетка)
        switch (item.getItemId()) {
            case R.id.rec_menu_lin:
                mLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
                mRecyclerView.setLayoutManager(mLayoutManager);
                mAdapter = new AdapterRecyclerView(this, mData, Constants.ATTR_LAYOUT_LIN);
                mRecyclerView.setAdapter(mAdapter);
                break;
            case R.id.rec_menu_grid:
                mLayoutManager = new GridLayoutManager(this, 2);
                mRecyclerView.setLayoutManager(mLayoutManager);
                mAdapter = new AdapterRecyclerView(this, mData, Constants.ATTR_LAYOUT_GRID);
                mRecyclerView.setAdapter(mAdapter);
        }
        return super.onOptionsItemSelected(item);
    }
}
