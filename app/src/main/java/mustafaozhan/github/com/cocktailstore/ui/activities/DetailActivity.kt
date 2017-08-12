package mustafaozhan.github.com.cocktailstore.ui.activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_detail.*

import mustafaozhan.github.com.cocktailstore.R
import mustafaozhan.github.com.cocktailstore.model.DetailedResponseModel
import mustafaozhan.github.com.cocktailstore.model.Drink
import mustafaozhan.github.com.cocktailstore.rest.ApiClient
import mustafaozhan.github.com.cocktailstore.rest.ApiInterface
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response



class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)


        val cocktail = intent.getParcelableExtra<Drink>("cocktail")

        mToolbarDetailActivity.title = "Cocktail Details"
        mTxtCocktailName.text = cocktail.strDrink


        val apiService = ApiClient.get().create(ApiInterface::class.java)

        val myCall = apiService.getById(cocktail.idDrink!!)
        myCall.enqueue(object : Callback<DetailedResponseModel> {
            override fun onResponse(call: Call<DetailedResponseModel>?, response: Response<DetailedResponseModel>?) {
                val myCoctail = response!!.body()!!.drinks!![0]

                if (cocktail.strDrinkThumb != null)
                    Glide
                            .with(applicationContext)
                            .load(cocktail.strDrinkThumb)
                            .thumbnail(Glide
                                    .with(applicationContext)
                                    .load(cocktail.strDrinkThumb)
                            )
                            .into(mImgCocktailDetails)
                else
                    mImgCocktailDetails.setImageResource(R.drawable.no_image)

                mTxtInstructions.text = myCoctail.strInstructions







            }

            override fun onFailure(call: Call<DetailedResponseModel>?, t: Throwable?) {


            }
        })


    }

    override fun onBackPressed() {
        finish()
    }
}
