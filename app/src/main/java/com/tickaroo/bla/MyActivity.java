package com.tickaroo.bla;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AbsListView;
import android.widget.ListView;
import com.tickaroo.bla.model.CardOneModel;
import com.tickaroo.bla.model.CardThreeModel;
import com.tickaroo.bla.model.CardTwoModel;
import com.tickaroo.bla.model.Model;
import java.util.ArrayList;
import java.util.List;

public class MyActivity extends Activity {

  private ListView list;
  private CardListAdapter adapter;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_my);

    list = (ListView) findViewById(R.id.list);
    adapter = new CardListAdapter(getBaseContext());
    list.setAdapter(adapter);

    List<Model> itemList = loadData();
    adapter.setItems(itemList);
    adapter.notifyDataSetChanged();

    list.setOnScrollListener(new AbsListView.OnScrollListener() {
      @Override public void onScrollStateChanged(AbsListView view, int scrollState) {

      }

      @Override public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount,
          int totalItemCount) {
        Log.d("TAG", "scroll changed -> hightlight first visible item");
      }
    });
  }

  private List<Model> loadData() {
    List<Model> list = new ArrayList<Model>();
    for (int i = 0; i < 20; i++) {
      if (i % 3 == 0) {
        list.add(new CardThreeModel());
      } else if (i % 5 == 0) {
        list.add(new CardTwoModel());
      } else {
        list.add(new CardOneModel());
      }
    }
    return list;
  }

  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    // Inflate the menu; this adds items to the action bar if it is present.
    getMenuInflater().inflate(R.menu.my, menu);
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
}
