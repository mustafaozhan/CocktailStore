package mustafaozhan.github.com.cocktailstore.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName



/**
 * Created by Mustafa Ozhan on 8/11/17 at 10:42 PM on Arch Linux.
 */
class Drink {

    @SerializedName("strDrink")
    @Expose
    var strDrink: String? = null
    @SerializedName("strDrinkThumb")
    @Expose
    var strDrinkThumb: String? = null
    @SerializedName("idDrink")
    @Expose
    var idDrink: String? = null

}