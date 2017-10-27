package mustafaozhan.github.com.cocktailstore.ui.activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.view.ViewPager
import kotlinx.android.synthetic.main.activity_main.*

import mustafaozhan.github.com.cocktailstore.R
import mustafaozhan.github.com.cocktailstore.ui.adapters.MyViewPagerAdapter
import mustafaozhan.github.com.cocktailstore.ui.fragments.AlcoholicFragment
import mustafaozhan.github.com.cocktailstore.ui.fragments.NonAlcoholicFragment
import mustafaozhan.github.com.cocktailstore.ui.fragments.RandomCocktailFragment
import mustafaozhan.github.com.cocktailstore.ui.fragments.SearchByFragment


class MainActivity : AppCompatActivity() {


    private val tabIcons = intArrayOf(R.drawable.random, R.drawable.alcohol, R.drawable.non_alcohol, R.drawable.search)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()


        myViewpager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrollStateChanged(state: Int) {
            }

            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {
            }

            override fun onPageSelected(position: Int) {
                when (position) {
                    0 -> toolbar_title.text = "Random Cocktails"
                    1 -> toolbar_title.text = "Alcoholic Cocktails"
                    2 -> toolbar_title.text = "Non Alcoholic Cocktails"
                    3 -> toolbar_title.text = "Search Cocktails"
                }
            }

        })


    }

    private fun init() {
        setupViewPager(myViewpager)
        myTabLayout.setupWithViewPager(myViewpager)
        setupTabIcons()
    }

    private fun setupTabIcons() {
        myTabLayout.getTabAt(0)?.setIcon(tabIcons[0])
        myTabLayout.getTabAt(1)?.setIcon(tabIcons[1])
        myTabLayout.getTabAt(2)?.setIcon(tabIcons[2])
        myTabLayout.getTabAt(3)?.setIcon(tabIcons[3])

    }

    private fun setupViewPager(viewPager: ViewPager) {
        val adapter = MyViewPagerAdapter(supportFragmentManager)
        adapter.addFrag(RandomCocktailFragment(), "")
        adapter.addFrag(AlcoholicFragment(), "")
        adapter.addFrag(NonAlcoholicFragment(), "")
        adapter.addFrag(SearchByFragment(), "")

        viewPager.adapter = adapter


    }


}