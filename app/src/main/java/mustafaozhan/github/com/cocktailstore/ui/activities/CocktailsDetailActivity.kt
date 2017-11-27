package mustafaozhan.github.com.cocktailstore.ui.activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.widget.LinearLayout
import kotlinx.android.synthetic.main.activity_cocktails_detail.*

import mustafaozhan.github.com.cocktailstore.R
import mustafaozhan.github.com.cocktailstore.extensions.setBackgroundFromUrl
import mustafaozhan.github.com.cocktailstore.model.DetailedResponseModel
import mustafaozhan.github.com.cocktailstore.model.Drink
import mustafaozhan.github.com.cocktailstore.model.Recipe
import mustafaozhan.github.com.cocktailstore.rest.ApiClient
import mustafaozhan.github.com.cocktailstore.rest.ApiInterface
import mustafaozhan.github.com.cocktailstore.ui.adapters.MyRecipeAdapter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class CocktailsDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cocktails_detail)


        val cocktail = intent.getParcelableExtra<Drink>("cocktail")

        mToolbarDetailActivity.title = "Cocktail Details"
        mTxtCocktailName.text = cocktail.strDrink


        val apiService = ApiClient.get().create(ApiInterface::class.java)

        val myCall = apiService.getById(cocktail.idDrink!!)
        myCall.enqueue(object : Callback<DetailedResponseModel> {
            override fun onResponse(call: Call<DetailedResponseModel>?, response: Response<DetailedResponseModel>?) {
                val myCocktail = response!!.body()!!.drinks!![0]

                if (cocktail.strDrinkThumb != null)
                    mImgCocktailDetails.setBackgroundFromUrl(cocktail.strDrinkThumb.toString())
                else
                    mImgCocktailDetails.setImageResource(R.drawable.no_image)

                mTxtInformation.text = myCocktail.strInstructions

                val recipeList = ArrayList<Recipe>()

                recipeList.add(Recipe(myCocktail.strIngredient1!!, myCocktail.strMeasure1!!))
                recipeList.add(Recipe(myCocktail.strIngredient2!!, myCocktail.strMeasure2!!))
                recipeList.add(Recipe(myCocktail.strIngredient3!!, myCocktail.strMeasure3!!))
                recipeList.add(Recipe(myCocktail.strIngredient4!!, myCocktail.strMeasure4!!))
                recipeList.add(Recipe(myCocktail.strIngredient5!!, myCocktail.strMeasure5!!))
                recipeList.add(Recipe(myCocktail.strIngredient6!!, myCocktail.strMeasure6!!))
                recipeList.add(Recipe(myCocktail.strIngredient7!!, myCocktail.strMeasure7!!))
                recipeList.add(Recipe(myCocktail.strIngredient8!!, myCocktail.strMeasure8!!))
                recipeList.add(Recipe(myCocktail.strIngredient9!!, myCocktail.strMeasure9!!))
                recipeList.add(Recipe(myCocktail.strIngredient10!!, myCocktail.strMeasure10!!))
                recipeList.add(Recipe(myCocktail.strIngredient11!!, myCocktail.strMeasure11!!))
                recipeList.add(Recipe(myCocktail.strIngredient12!!, myCocktail.strMeasure12!!))
                recipeList.add(Recipe(myCocktail.strIngredient13!!, myCocktail.strMeasure13!!))
                recipeList.add(Recipe(myCocktail.strIngredient14!!, myCocktail.strMeasure14!!))
                recipeList.add(Recipe(myCocktail.strIngredient15!!, myCocktail.strMeasure15!!))

                var size = recipeList.size
                var i = 0
                while (true) {//deleting empty ingredients and measures inside list
                    if (recipeList[i].ingredient == "") {
                        recipeList.removeAt(i)
                        i--
                        size--
                    } else
                        i++

                    if (i == size)
                        break
                }



                myRecyclerViewRecipes.layoutManager = LinearLayoutManager(applicationContext, LinearLayout.VERTICAL, false)
                val adapter = MyRecipeAdapter(recipeList)
                myRecyclerViewRecipes.adapter = adapter


            }

            override fun onFailure(call: Call<DetailedResponseModel>?, t: Throwable?) {


            }
        })


    }

    override fun onBackPressed() {
        finish()
    }
}
