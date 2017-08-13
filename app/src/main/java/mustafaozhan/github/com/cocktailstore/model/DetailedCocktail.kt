package mustafaozhan.github.com.cocktailstore.model

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName



/**
 * Created by Mustafa Ozhan on 8/12/17 at 2:22 PM on Arch Linux.
 */
class DetailedCocktail() : Drink(), Parcelable {



    @SerializedName("strCategory")
    @Expose
    var strCategory: String? = null
    @SerializedName("strAlcoholic")
    @Expose
    var strAlcoholic: String? = null
    @SerializedName("strGlass")
    @Expose
    var strGlass: String? = null
    @SerializedName("strInstructions")
    @Expose
    var strInstructions: String? = null

    @SerializedName("strIngredient1")
    @Expose
    var strIngredient1: String? = null
    @SerializedName("strIngredient2")
    @Expose
    var strIngredient2: String? = null
    @SerializedName("strIngredient3")
    @Expose
    var strIngredient3: String? = null
    @SerializedName("strIngredient4")
    @Expose
    var strIngredient4: String? = null
    @SerializedName("strIngredient5")
    @Expose
    var strIngredient5: String? = null
    @SerializedName("strIngredient6")
    @Expose
    var strIngredient6: String? = null
    @SerializedName("strIngredient7")
    @Expose
    var strIngredient7: String? = null
    @SerializedName("strIngredient8")
    @Expose
    var strIngredient8: String? = null
    @SerializedName("strIngredient9")
    @Expose
    var strIngredient9: String? = null
    @SerializedName("strIngredient10")
    @Expose
    var strIngredient10: String? = null
    @SerializedName("strIngredient11")
    @Expose
    var strIngredient11: String? = null
    @SerializedName("strIngredient12")
    @Expose
    var strIngredient12: String? = null
    @SerializedName("strIngredient13")
    @Expose
    var strIngredient13: String? = null
    @SerializedName("strIngredient14")
    @Expose
    var strIngredient14: String? = null
    @SerializedName("strIngredient15")
    @Expose
    var strIngredient15: String? = null
    @SerializedName("strMeasure1")
    @Expose
    var strMeasure1: String? = null
    @SerializedName("strMeasure2")
    @Expose
    var strMeasure2: String? = null
    @SerializedName("strMeasure3")
    @Expose
    var strMeasure3: String? = null
    @SerializedName("strMeasure4")
    @Expose
    var strMeasure4: String? = null
    @SerializedName("strMeasure5")
    @Expose
    var strMeasure5: String? = null
    @SerializedName("strMeasure6")
    @Expose
    var strMeasure6: String? = null
    @SerializedName("strMeasure7")
    @Expose
    var strMeasure7: String? = null
    @SerializedName("strMeasure8")
    @Expose
    var strMeasure8: String? = null
    @SerializedName("strMeasure9")
    @Expose
    var strMeasure9: String? = null
    @SerializedName("strMeasure10")
    @Expose
    var strMeasure10: String? = null
    @SerializedName("strMeasure11")
    @Expose
    var strMeasure11: String? = null
    @SerializedName("strMeasure12")
    @Expose
    var strMeasure12: String? = null
    @SerializedName("strMeasure13")
    @Expose
    var strMeasure13: String? = null
    @SerializedName("strMeasure14")
    @Expose
    var strMeasure14: String? = null
    @SerializedName("strMeasure15")
    @Expose
    var strMeasure15: String? = null
    @SerializedName("dateModified")
    @Expose
    var dateModified: Any? = null

    constructor(parcel: Parcel) : this() {
        idDrink = parcel.readString()
        strDrink = parcel.readString()
        strCategory = parcel.readString()
        strAlcoholic = parcel.readString()
        strGlass = parcel.readString()
        strInstructions = parcel.readString()
        strIngredient1 = parcel.readString()
        strIngredient2 = parcel.readString()
        strIngredient3 = parcel.readString()
        strIngredient4 = parcel.readString()
        strIngredient5 = parcel.readString()
        strIngredient6 = parcel.readString()
        strIngredient7 = parcel.readString()
        strIngredient8 = parcel.readString()
        strIngredient9 = parcel.readString()
        strIngredient10 = parcel.readString()
        strIngredient11 = parcel.readString()
        strIngredient12 = parcel.readString()
        strIngredient13 = parcel.readString()
        strIngredient14 = parcel.readString()
        strIngredient15 = parcel.readString()
        strMeasure1 = parcel.readString()
        strMeasure2 = parcel.readString()
        strMeasure3 = parcel.readString()
        strMeasure4 = parcel.readString()
        strMeasure5 = parcel.readString()
        strMeasure6 = parcel.readString()
        strMeasure7 = parcel.readString()
        strMeasure8 = parcel.readString()
        strMeasure9 = parcel.readString()
        strMeasure10 = parcel.readString()
        strMeasure11 = parcel.readString()
        strMeasure12 = parcel.readString()
        strMeasure13 = parcel.readString()
        strMeasure14 = parcel.readString()
        strMeasure15 = parcel.readString()
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(idDrink)
        parcel.writeString(strDrink)
        parcel.writeString(strCategory)
        parcel.writeString(strAlcoholic)
        parcel.writeString(strGlass)
        parcel.writeString(strInstructions)
        parcel.writeString(strIngredient1)
        parcel.writeString(strIngredient2)
        parcel.writeString(strIngredient3)
        parcel.writeString(strIngredient4)
        parcel.writeString(strIngredient5)
        parcel.writeString(strIngredient6)
        parcel.writeString(strIngredient7)
        parcel.writeString(strIngredient8)
        parcel.writeString(strIngredient9)
        parcel.writeString(strIngredient10)
        parcel.writeString(strIngredient11)
        parcel.writeString(strIngredient12)
        parcel.writeString(strIngredient13)
        parcel.writeString(strIngredient14)
        parcel.writeString(strIngredient15)
        parcel.writeString(strMeasure1)
        parcel.writeString(strMeasure2)
        parcel.writeString(strMeasure3)
        parcel.writeString(strMeasure4)
        parcel.writeString(strMeasure5)
        parcel.writeString(strMeasure6)
        parcel.writeString(strMeasure7)
        parcel.writeString(strMeasure8)
        parcel.writeString(strMeasure9)
        parcel.writeString(strMeasure10)
        parcel.writeString(strMeasure11)
        parcel.writeString(strMeasure12)
        parcel.writeString(strMeasure13)
        parcel.writeString(strMeasure14)
        parcel.writeString(strMeasure15)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<DetailedCocktail> {
        override fun createFromParcel(parcel: Parcel): DetailedCocktail {
            return DetailedCocktail(parcel)
        }

        override fun newArray(size: Int): Array<DetailedCocktail?> {
            return arrayOfNulls(size)
        }
    }

}