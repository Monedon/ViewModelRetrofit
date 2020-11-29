package cl.desafiolatam.viewmodelretrofit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.List;

import cl.desafiolatam.viewmodelretrofit.adapter.HeroAdapter;
import cl.desafiolatam.viewmodelretrofit.model.Hero;
import cl.desafiolatam.viewmodelretrofit.viewmodel.HeroViewModel;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private HeroAdapter heroAdapter;
    private List<Hero> heroList;
    private HeroViewModel viewmodel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerview);
        recyclerView .setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

         viewmodel = new ViewModelProvider(this).get(HeroViewModel.class);

         viewmodel.getHeroes().observe(this, new Observer<List<Hero>>() {
             @Override
             public void onChanged(List<Hero> heroList) {
                 heroAdapter = new HeroAdapter(MainActivity.this, heroList);
                 recyclerView.setAdapter(heroAdapter);
             }
         });
    }
}