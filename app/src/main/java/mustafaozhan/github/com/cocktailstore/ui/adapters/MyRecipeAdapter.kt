package mustafaozhan.github.com.recipestore.ui.adapters

import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_row.view.*
import mustafaozhan.github.com.cocktailstore.R
import mustafaozhan.github.com.cocktailstore.model.Recipe
import mustafaozhan.github.com.cocktailstore.ui.activities.CocktailsDetailActivity
import mustafaozhan.github.com.cocktailstore.ui.activities.IngredientDetailActivity
import java.lang.reflect.Array


/**
 * Created by Mustafa Ozhan on 8/11/17 at 11:15 PM on Arch Linux.
 */
class MyRecipeAdapter(val recipeList: ArrayList<Recipe>) :
        RecyclerView.Adapter<MyRecipeAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_row, parent, false)
        return ViewHolder(view)

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
       if(recipeList[position].ingredient!="") {
            holder.bindRecipe(recipeList[position])

        }
    }

    override fun getItemCount() = recipeList.size

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        fun bindRecipe(recipe: Recipe) {

            if (recipe.measure != null)
                itemView.mTxtName.text = recipe.ingredient+"  "+recipe.measure


            if (recipe.ingredient != "")
                Glide
                        .with(itemView.context)
                        .load("http://www.thecocktaildb.com/images/ingredients/${recipe.ingredient}-Small.png")
                        .thumbnail(Glide
                                .with(itemView.context)
                                .load("http://www.thecocktaildb.com/images/ingredients/${recipe.ingredient}-Small.png")
                        )
                        .into(itemView.mImgCocktail)
            else
                itemView.mImgCocktail.setImageResource(R.drawable.no_image)



            itemView.setOnClickListener {
                val intent = Intent(itemView.context, IngredientDetailActivity::class.java)

                intent.putExtra("ingredient",recipe.ingredient)
                itemView.context.startActivity(intent)
            }


        }

    }
}