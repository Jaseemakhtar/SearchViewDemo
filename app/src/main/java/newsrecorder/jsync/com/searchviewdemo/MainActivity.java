package newsrecorder.jsync.com.searchviewdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements SearchView.OnQueryTextListener {
    SearchView searchView;
    ArrayList<String> animals = new ArrayList<>();
    ListViewAdapter adapter;
    ListView listView;
    Animation animation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        animation = AnimationUtils.loadAnimation(this,R.anim.expand);

        searchView = findViewById(R.id.searchView);
        searchView.setOnQueryTextListener(this);
        listView = findViewById(R.id.listView);


        animals.add("Lion");
        animals.add("Tiger");
        animals.add("Panther");
        animals.add("Giraffe");
        animals.add("Cat");
        animals.add("Horse");
        animals.add("Monkey");
        animals.add("Zebra");
        animals.add("Dog");

        adapter = new ListViewAdapter(this,animals);
        listView.setAdapter(adapter);
        listView.setAnimation(animation);
        listView.animate();

    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        Log.i("Search","Submitted: " + query);

        return true;
    }

    @Override
    public boolean onQueryTextChange(String newText) {


        Log.i("Search",newText);
        if (newText.length() != 0) {
            ArrayList<String> newList = new ArrayList<>();
            for (String str : animals) {
                if (str.contains(newText)) {
                    newList.add(str);
                }
            }
            adapter.filter(newList);
        }

        return true;
    }
}
