package mustafaozhan.github.com.cocktailstore.rest

import mustafaozhan.github.com.cocktailstore.model.DetailedCocktail
import mustafaozhan.github.com.cocktailstore.model.DetailedResponseModel
import mustafaozhan.github.com.cocktailstore.model.ResponseIngredinets
import mustafaozhan.github.com.cocktailstore.model.ResponseModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

/**
 * Created by Mustafa Ozhan on 8/11/17 at 10:39 PM on Arch Linux.
 */
interface ApiInterface {
    @GET("filter.php?a=Alcoholic")
    fun getAlcoholic(): Call<ResponseModel>

    @GET("filter.php?a=Non_Alcoholic")
    fun getNonAlcoholic(): Call<ResponseModel>

    @GET("lookup.php")
    fun getById(@Query("i") id: String): Call<DetailedResponseModel>

    @GET("search.php")
    fun getInCocktailsByName(@Query("s") name: String): Call<DetailedResponseModel>

    @GET("filter.php")
    fun getCocktailsByIngredient(@Query("i") name: String): Call<ResponseModel>

    @GET("search.php")
    fun getIngredientByName(@Query("i") name: String): Call<ResponseIngredinets>

    @GET("random.php")
    fun getRandomCocktail(): Call<DetailedResponseModel>
}