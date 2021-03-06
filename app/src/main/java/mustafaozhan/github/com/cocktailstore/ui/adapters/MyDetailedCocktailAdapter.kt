package mustafaozhan.github.com.cocktailstore.ui.adapters

import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.item_row.view.*
import mustafaozhan.github.com.cocktailstore.R
import mustafaozhan.github.com.cocktailstore.extensions.setBackgroundFromUrl
import mustafaozhan.github.com.cocktailstore.model.DetailedCocktail
import mustafaozhan.github.com.cocktailstore.model.Drink
import mustafaozhan.github.com.cocktailstore.ui.activities.CocktailsDetailActivity

/**
 * Created by Mustafa Ozhan on 8/11/17 at 11:15 PM on Arch Linux.
 */
class MyDetailedCocktailAdapter(private var cocktailList: List<DetailedCocktail>?) :
        RecyclerView.Adapter<MyDetailedCocktailAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_row, parent, false)
        return ViewHolder(view)

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindCocktail(cocktailList!![position])

    }

    override fun getItemCount() = cocktailList!!.size

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        fun bindCocktail(cocktail: DetailedCocktail) {

            itemView.mTxtName.text = cocktail.strDrink

            if (cocktail.strDrinkThumb != null)
                itemView.mImgCocktail.setBackgroundFromUrl(cocktail.strDrinkThumb.toString())
            else
                itemView.mImgCocktail.setImageResource(R.drawable.no_image)

            itemView.setOnClickListener {
                val intent = Intent(itemView.context, CocktailsDetailActivity::class.java)

                intent.putExtra("cocktail", cocktail as Drink)//bec cocktail details waiting for a drink object
                itemView.context.startActivity(intent)
            }
        }

    }
}