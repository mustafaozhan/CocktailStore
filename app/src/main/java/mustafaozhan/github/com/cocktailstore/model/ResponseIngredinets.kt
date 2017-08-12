package mustafaozhan.github.com.cocktailstore.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * Created by Mustafa Ozhan on 8/13/17 at 12:55 AM on Arch Linux.
 */

class ResponseIngredinets {

    @SerializedName("ingredients")
    @Expose
    var ingredients: List<Ingredient>? = null

}