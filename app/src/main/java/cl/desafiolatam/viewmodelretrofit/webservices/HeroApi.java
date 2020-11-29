package cl.desafiolatam.viewmodelretrofit.webservices;

import java.util.List;

import cl.desafiolatam.viewmodelretrofit.model.Hero;
import retrofit2.Call;
import retrofit2.http.GET;

public interface HeroApi {

    String BASE_URL = "https://simplifiedcoding.net/demos/"; //marvel
    @GET("marvel")
    Call<List<Hero>> getHeroes();
}
