package mustafaozhan.github.com.cocktailstore.ui.fragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.Toast
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_cocktails_detail.*
import kotlinx.android.synthetic.main.fragment_alcoholic.*
import kotlinx.android.synthetic.main.fragment_random_cocktail.*
import kotlinx.android.synthetic.main.fragment_search_by.*
import mustafaozhan.github.com.cocktailstore.R
import mustafaozhan.github.com.cocktailstore.model.*
import mustafaozhan.github.com.cocktailstore.rest.ApiClient
import mustafaozhan.github.com.cocktailstore.rest.ApiInterface
import mustafaozhan.github.com.cocktailstore.ui.adapters.MyCocktailAdapter
import mustafaozhan.github.com.cocktailstore.ui.adapters.MyDetailedCocktailAdapter
import mustafaozhan.github.com.recipestore.ui.adapters.MyRecipeAdapter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * Created by Mustafa Ozhan on 8/13/17 at 1:27 PM on Arch Linux.
 */
class RandomCocktailFragment : Fragment() {


    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val fragmentView = inflater!!.inflate(R.layout.fragment_random_cocktail, container, false)
//        bindViews(fragmentView)
        return fragmentView
    }

//    private fun bindViews(view: View) {}

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)


        getRandomCocktail()

        mImgCocktailRandomDetails.setOnClickListener { getRandomCocktail() }


    }

    private fun getRandomCocktail() {
        val apiServiceForRandom = ApiClient.get().create(ApiInterface::class.java)

        val myCallRandom = apiServiceForRandom.getRandomCocktail()
        myCallRandom.enqueue(object : Callback<DetailedResponseModel> {

            override fun onResponse(call: Call<DetailedResponseModel>?, response: Response<DetailedResponseModel>?) {
                var cocktail=DetailedCocktail()
               try {

                    cocktail = response!!.body()!!.drinks!![0]


                mTxtRandomCocktailName.text = cocktail.strDrink.toString()


                if (cocktail.strDrinkThumb != null)
                    Glide
                            .with(context)
                            .load(cocktail.strDrinkThumb)
                            .thumbnail(Glide
                                    .with(context)
                                    .load(cocktail.strDrinkThumb)
                            )
                            .into(mImgCocktailRandomDetails)
                else
                    mImgCocktailRandomDetails.setImageResource(R.drawable.no_image)

                mTxtRandomInformation.text = cocktail.strInstructions

                val recipeList = ArrayList<Recipe>()

                recipeList.add(Recipe(cocktail.strIngredient1!!, cocktail.strMeasure1!!))
                recipeList.add(Recipe(cocktail.strIngredient2!!, cocktail.strMeasure2!!))
                recipeList.add(Recipe(cocktail.strIngredient3!!, cocktail.strMeasure3!!))
                recipeList.add(Recipe(cocktail.strIngredient4!!, cocktail.strMeasure4!!))
                recipeList.add(Recipe(cocktail.strIngredient5!!, cocktail.strMeasure5!!))
                recipeList.add(Recipe(cocktail.strIngredient6!!, cocktail.strMeasure6!!))
                recipeList.add(Recipe(cocktail.strIngredient7!!, cocktail.strMeasure7!!))
                recipeList.add(Recipe(cocktail.strIngredient8!!, cocktail.strMeasure8!!))
                recipeList.add(Recipe(cocktail.strIngredient9!!, cocktail.strMeasure9!!))
                recipeList.add(Recipe(cocktail.strIngredient10!!, cocktail.strMeasure10!!))
                recipeList.add(Recipe(cocktail.strIngredient11!!, cocktail.strMeasure11!!))
                recipeList.add(Recipe(cocktail.strIngredient12!!, cocktail.strMeasure12!!))
                recipeList.add(Recipe(cocktail.strIngredient13!!, cocktail.strMeasure13!!))
                recipeList.add(Recipe(cocktail.strIngredient14!!, cocktail.strMeasure14!!))
                recipeList.add(Recipe(cocktail.strIngredient15!!, cocktail.strMeasure15!!))

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



                myRecyclerViewRandomRecipes.layoutManager = LinearLayoutManager(context, LinearLayout.VERTICAL, false)as RecyclerView.LayoutManager
                val adapter = MyRecipeAdapter(recipeList)
                myRecyclerViewRandomRecipes.adapter = adapter
                // mProgressBarAlcoholic.visibility = View.GONE
               }catch (e:Exception){
                   Log.w("Warning:","Random return null")
                   getRandomCocktail()
               }

            }

            override fun onFailure(call: Call<DetailedResponseModel>?, t: Throwable?) {

            }
        })

        Toast.makeText(context,"Click Cocktail image to get new Random cocktail",Toast.LENGTH_SHORT)

    }


}
