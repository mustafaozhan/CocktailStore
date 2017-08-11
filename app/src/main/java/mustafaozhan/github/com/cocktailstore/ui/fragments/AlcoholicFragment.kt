package mustafaozhan.github.com.cocktailstore.ui.fragments

import android.support.v4.app.Fragment
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import kotlinx.android.synthetic.main.fragment_alcoholic.*
import mustafaozhan.github.com.cocktailstore.R
import mustafaozhan.github.com.cocktailstore.model.Drink
import mustafaozhan.github.com.cocktailstore.model.ResponseModel
import mustafaozhan.github.com.cocktailstore.rest.ApiClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import mustafaozhan.github.com.cocktailstore.rest.ApiInterface
import mustafaozhan.github.com.cocktailstore.ui.adapters.MyCocktailAdapter
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

/**
 * Created by Mustafa Ozhan on 8/11/17 at 2:33 PM on Arch Linux.
 */
class AlcoholicFragment : Fragment() {


    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val fragmentView = inflater!!.inflate(R.layout.fragment_alcoholic, container, false)
//        bindViews(fragmentView)
        return fragmentView
    }

//    private fun bindViews(view: View) {}

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)



        mProgressBarAlcoholic.progress


        val apiService = ApiClient.get().create(ApiInterface::class.java)

        val myCall = apiService.getAlcoholic()
        myCall.enqueue(object : Callback<ResponseModel> {

            override fun onResponse(call: Call<ResponseModel>?, response: Response<ResponseModel>?) {
                myRecyclerViewAlcoholic.layoutManager = LinearLayoutManager(context, LinearLayout.VERTICAL, false)
                val adapter = MyCocktailAdapter(response!!.body()!!.drinks!!)
                myRecyclerViewAlcoholic.adapter = adapter
                mProgressBarAlcoholic.visibility = View.GONE

            }

            override fun onFailure(call: Call<ResponseModel>?, t: Throwable?) {

            }
        })


    }


}
