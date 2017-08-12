package mustafaozhan.github.com.cocktailstore.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName



/**
 * Created by Mustafa Ozhan on 8/13/17 at 12:55 AM on Arch Linux.
 */
class Ingredient {

    @SerializedName("idIngredient")
    @Expose
    var idIngredient: String? = null
    @SerializedName("strIngredient")
    @Expose
    var strIngredient: String? = null
    @SerializedName("strDescription")
    @Expose
    var strDescription: String? = null
    @SerializedName("strType")
    @Expose
    var strType: String? = null

}