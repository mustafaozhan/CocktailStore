package mustafaozhan.github.com.cocktailstore.ui.activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_ingredient_detail.*

import mustafaozhan.github.com.cocktailstore.R
import mustafaozhan.github.com.cocktailstore.extensions.setBackgroundFromUrl
import mustafaozhan.github.com.cocktailstore.model.ResponseIngredinets
import mustafaozhan.github.com.cocktailstore.rest.ApiClient
import mustafaozhan.github.com.cocktailstore.rest.ApiInterface
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class IngredientDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ingredient_detail)


        val ingredient = intent.getStringExtra("ingredient")

        mToolbarIngredientDetailActivity.title = "Ingredient Details"
        mTxtIngredientName.text = ingredient.toString()

        if (ingredient != null)
            mImgIngredientDetails.setBackgroundFromUrl("http://www.thecocktaildb.com/images/ingredients/$ingredient-Medium.png")
        else
            mImgIngredientDetails.setImageResource(R.drawable.no_image)

        val apiService = ApiClient.get().create(ApiInterface::class.java)

        val myCall = apiService.getIngredientByName(ingredient)
        myCall.enqueue(object : Callback<ResponseIngredinets> {
            override fun onResponse(call: Call<ResponseIngredinets>?, response: Response<ResponseIngredinets>?) {

                val info = response!!.body()!!.ingredients?.get(0)?.strDescription

                if (info == "null" || info == null)
                    mTxtIngredientInformation.text = "No information specified"
                else
                    mTxtIngredientInformation.text = info

            }

            override fun onFailure(call: Call<ResponseIngredinets>?, t: Throwable?) {


            }
        })


    }

    override fun onBackPressed() {
        finish()
    }
}
