package mustafaozhan.github.com.cocktailstore.extensions

import android.widget.ImageView
import com.bumptech.glide.Glide

/**
 * Created by Mustafa Ozhan on 8/15/17 at 10:39 AM on Arch Linux.
 */
fun ImageView.setBackgroundFromUrl(url: String) {
    Glide
            .with(context)
            .load(url)
            .thumbnail(Glide
                    .with(context)
                    .load(url)
            )
            .into(this)
}