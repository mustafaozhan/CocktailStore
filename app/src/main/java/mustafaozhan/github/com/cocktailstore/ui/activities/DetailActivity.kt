package mustafaozhan.github.com.cocktailstore.ui.activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle

import mustafaozhan.github.com.cocktailstore.R
import mustafaozhan.github.com.cocktailstore.model.Drink

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)


        val cocktail = intent.getParcelableExtra<Drink>("cocktail")



    }

    override fun onBackPressed() {
        finish()
    }
}
