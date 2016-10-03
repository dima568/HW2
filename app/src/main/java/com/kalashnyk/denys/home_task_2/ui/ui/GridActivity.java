package com.kalashnyk.denys.home_task_2.ui.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;

import com.kalashnyk.denys.home_task_2.R;
import com.kalashnyk.denys.home_task_2.ui.ui.adapters.AdapterGrid;
import com.kalashnyk.denys.home_task_2.ui.utils.Constants;

import java.util.ArrayList;

/**
 * Created by User on 21.06.2016.
 */
public class GridActivity extends AppCompatActivity implements View.OnClickListener {

    private GridView mGridView;
    private ArrayList mData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_view);
        initialise();
    }
    private void initialise(){
        Button followExpandable = (Button) findViewById(R.id.follow_expandable);
        followExpandable.setOnClickListener(this);
		//Присваиваем верхней панели программы текст из ресурсов(жанр)
        setTitle(R.string.text_activity_genre_title);
		
        Constants data = new Constants();
		//записываем в ArrayList массив жанров из data 
        mData = data.getGenreData();

        AdapterGrid adapter = new AdapterGrid(this, mData);
	
        mGridView = (GridView)findViewById(R.id.grid_view);
		//Связывает GridView с адаптером
        mGridView.setAdapter(adapter);
        adjustGridView();
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.follow_expandable:
                Intent intent = new Intent(GridActivity.this, ExpandableActivity.class);
                startActivity(intent);
                break;
            default:
                break;
        }
    }
	//Выставляет количество столбцов в Grid view
    private void adjustGridView() {
        mGridView.setNumColumns(2);
    }
}
