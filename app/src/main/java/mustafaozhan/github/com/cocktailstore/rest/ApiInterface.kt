package mustafaozhan.github.com.cocktailstore.rest

import mustafaozhan.github.com.cocktailstore.model.ResponseModel
import retrofit2.Call
import retrofit2.http.GET

/**
 * Created by Mustafa Ozhan on 8/11/17 at 10:39 PM on Arch Linux.
 */
interface ApiInterface {
    @GET("filter.php?a=Alcoholic")
    fun getAlcoholic(): Call<ResponseModel>
    @GET("filter.php?a=Non_Alcoholic")
    fun getNonAlcoholic(): Call<ResponseModel>

}