package mustafaozhan.github.com.cocktailstore.model

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName



/**
 * Created by Mustafa Ozhan on 8/11/17 at 10:42 PM on Arch Linux.
 */
class Drink() :Parcelable {

    @SerializedName("strDrink")
    @Expose
    var strDrink: String? = null
    @SerializedName("strDrinkThumb")
    @Expose
    var strDrinkThumb: String? = null
    @SerializedName("idDrink")
    @Expose
    var idDrink: String? = null

    constructor(parcel: Parcel) : this() {
        strDrink = parcel.readString()
        strDrinkThumb = parcel.readString()
        idDrink = parcel.readString()
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(strDrink)
        parcel.writeString(strDrinkThumb)
        parcel.writeString(idDrink)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Drink> {
        override fun createFromParcel(parcel: Parcel): Drink {
            return Drink(parcel)
        }

        override fun newArray(size: Int): Array<Drink?> {
            return arrayOfNulls(size)
        }
    }

}