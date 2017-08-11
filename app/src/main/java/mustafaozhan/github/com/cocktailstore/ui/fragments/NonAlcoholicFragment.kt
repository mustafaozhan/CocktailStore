package mustafaozhan.github.com.cocktailstore.ui.fragments

import android.support.v4.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import mustafaozhan.github.com.cocktailstore.R

/**
 * Created by Mustafa Ozhan on 8/11/17 at 2:33 PM on Arch Linux.
 */
class NonAlcoholicFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val fragmentView = inflater!!.inflate(R.layout.fragment_non_alcoholic, container, false)
//        bindViews(fragmentView)
        return fragmentView
    }

//    private fun bindViews(view: View) {}

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)






    }
}