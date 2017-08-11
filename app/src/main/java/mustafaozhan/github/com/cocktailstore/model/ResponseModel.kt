package mustafaozhan.github.com.cocktailstore.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName



/**
 * Created by Mustafa Ozhan on 8/11/17 at 10:42 PM on Arch Linux.
 */
class ResponseModel {

    @SerializedName("drinks")
    @Expose
    var drinks: List<Drink>? = null

}