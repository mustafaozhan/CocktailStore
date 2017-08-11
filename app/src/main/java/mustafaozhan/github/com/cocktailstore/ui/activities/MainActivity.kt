package mustafaozhan.github.com.cocktailstore.ui.activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.view.ViewPager
import kotlinx.android.synthetic.main.activity_main.*

import mustafaozhan.github.com.cocktailstore.R
import mustafaozhan.github.com.cocktailstore.ui.adapters.MyViewPagerAdapter
import mustafaozhan.github.com.cocktailstore.ui.fragments.AlcoholicFragment
import mustafaozhan.github.com.cocktailstore.ui.fragments.NonAlcoholicFragment
import android.content.Intent
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem


class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
      init()


    }
    private fun init() {
        setSupportActionBar(myToolbar)
        setupViewPager(myViewpager)
        myTabLayout.setupWithViewPager(myViewpager)
    }

    private fun setupViewPager(viewPager: ViewPager) {
        val adapter = MyViewPagerAdapter(supportFragmentManager)
        adapter.addFrag(AlcoholicFragment(), "Alcoholic")
        adapter.addFrag(NonAlcoholicFragment(), "Non Alcoholic")


        viewPager.adapter = adapter

        viewPager.addOnPageChangeListener(adapter)

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.getItemId()) {
            R.id.settings -> {

            }

            else -> {
            }
        }

        return true
    }



}