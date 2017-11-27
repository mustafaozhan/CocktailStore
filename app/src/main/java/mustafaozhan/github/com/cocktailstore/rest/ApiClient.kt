package mustafaozhan.github.com.cocktailstore.rest

import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by Mustafa Ozhan on 8/11/17 at 10:34 PM on Arch Linux.
 */
class ApiClient {

    companion object {
        fun get(): Retrofit {
            return Retrofit.Builder()
                    .addCallAdapterFactory(
                            RxJava2CallAdapterFactory.create())
                    .addConverterFactory(
                            GsonConverterFactory.create())
                    .baseUrl("http://www.thecocktaildb.com/api/json/v1/1/")
                    .build()
        }
    }
}