package mustafaozhan.github.com.cocktailstore.ui.activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.View
import android.widget.LinearLayout
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_detail.*
import kotlinx.android.synthetic.main.fragment_alcoholic.*

import mustafaozhan.github.com.cocktailstore.R
import mustafaozhan.github.com.cocktailstore.model.DetailedResponseModel
import mustafaozhan.github.com.cocktailstore.model.Drink
import mustafaozhan.github.com.cocktailstore.model.Recipe
import mustafaozhan.github.com.cocktailstore.rest.ApiClient
import mustafaozhan.github.com.cocktailstore.rest.ApiInterface
import mustafaozhan.github.com.cocktailstore.ui.adapters.MyCocktailAdapter
import mustafaozhan.github.com.recipestore.ui.adapters.MyRecipeAdapter
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

                val recipeList = ArrayList<Recipe>()

                recipeList.add(Recipe(myCoctail.strIngredient1!!, myCoctail.strMeasure1!!))
                recipeList.add(Recipe(myCoctail.strIngredient2!!, myCoctail.strMeasure2!!))
                recipeList.add(Recipe(myCoctail.strIngredient3!!, myCoctail.strMeasure3!!))
                recipeList.add(Recipe(myCoctail.strIngredient4!!, myCoctail.strMeasure4!!))
                recipeList.add(Recipe(myCoctail.strIngredient5!!, myCoctail.strMeasure5!!))
                recipeList.add(Recipe(myCoctail.strIngredient6!!, myCoctail.strMeasure6!!))
                recipeList.add(Recipe(myCoctail.strIngredient7!!, myCoctail.strMeasure7!!))
                recipeList.add(Recipe(myCoctail.strIngredient8!!, myCoctail.strMeasure8!!))
                recipeList.add(Recipe(myCoctail.strIngredient9!!, myCoctail.strMeasure9!!))
                recipeList.add(Recipe(myCoctail.strIngredient10!!, myCoctail.strMeasure10!!))
                recipeList.add(Recipe(myCoctail.strIngredient11!!, myCoctail.strMeasure11!!))
                recipeList.add(Recipe(myCoctail.strIngredient12!!, myCoctail.strMeasure12!!))
                recipeList.add(Recipe(myCoctail.strIngredient13!!, myCoctail.strMeasure13!!))
                recipeList.add(Recipe(myCoctail.strIngredient14!!, myCoctail.strMeasure14!!))
                recipeList.add(Recipe(myCoctail.strIngredient15!!, myCoctail.strMeasure15!!))

                var size = recipeList.size
                var i = 0
                while (true) {
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
                // mProgressBarAlcoholic.visibility = View.GONE


            }

            override fun onFailure(call: Call<DetailedResponseModel>?, t: Throwable?) {


            }
        })


    }

    override fun onBackPressed() {
        finish()
    }
}
