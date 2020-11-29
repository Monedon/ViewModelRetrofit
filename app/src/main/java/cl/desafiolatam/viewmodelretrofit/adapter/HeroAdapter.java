package cl.desafiolatam.viewmodelretrofit.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

import cl.desafiolatam.viewmodelretrofit.R;
import cl.desafiolatam.viewmodelretrofit.model.Hero;


public class HeroAdapter extends RecyclerView.Adapter<HeroAdapter.HeroAdapterVH> {

    Context context;
    private List<Hero> heroList;
    private Hero hero;

    public HeroAdapter(Context context, List<Hero> heroList)  {
        this.context = context;
        this.heroList = heroList;
    }

    @NonNull
    @Override
    public HeroAdapterVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_layout, parent, false);
        return new HeroAdapterVH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HeroAdapterVH holder, int position) {
        hero = heroList.get(position);

        Glide.with(context)
                .load(hero.getImageurl())
                .into(holder.imgHero);

        holder.tvHero.setText(hero.getName());
    }

    @Override
    public int getItemCount() {
        return heroList.size();
    }


    class HeroAdapterVH extends RecyclerView.ViewHolder {

        ImageView imgHero;
        TextView tvHero;

        public HeroAdapterVH (@NonNull View itemView) {
            super(itemView);

            imgHero = itemView.findViewById(R.id.imgHero);
            tvHero = itemView.findViewById(R.id.tvHero);
        }
    }
}
