package mustafaozhan.github.com.cocktailstore.ui.fragments

import android.content.pm.ActivityInfo
import android.support.v4.app.Fragment
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import kotlinx.android.synthetic.main.fragment_alcoholic.*
import mustafaozhan.github.com.cocktailstore.R
import mustafaozhan.github.com.cocktailstore.model.ResponseModel
import mustafaozhan.github.com.cocktailstore.rest.ApiClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import mustafaozhan.github.com.cocktailstore.rest.ApiInterface
import mustafaozhan.github.com.cocktailstore.ui.adapters.MyCocktailAdapter


/**
 * Created by Mustafa Ozhan on 8/11/17 at 2:33 PM on Arch Linux.
 */
class AlcoholicFragment : Fragment() {


    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val fragmentView = inflater!!.inflate(R.layout.fragment_alcoholic, container, false)
        activity.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT

        return fragmentView
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)



        mProgressBarAlcoholic.progress


        val apiService = ApiClient.get().create(ApiInterface::class.java)

        val myCall = apiService.getAlcoholic()
        myCall.enqueue(object : Callback<ResponseModel> {

            override fun onResponse(call: Call<ResponseModel>?, response: Response<ResponseModel>?) {

                try {


                    myRecyclerViewAlcoholic.layoutManager = LinearLayoutManager(context, LinearLayout.VERTICAL, false) as RecyclerView.LayoutManager
                    val adapter = MyCocktailAdapter(response!!.body()!!.drinks!!)
                    myRecyclerViewAlcoholic.adapter = adapter
                    mProgressBarAlcoholic.visibility = View.GONE
                }catch (e:Exception){
                    Log.e("Error:","java.lang.NullPointerException: Attempt to invoke virtual method 'void android.support.v7.widget.RecyclerView.setLayoutManager(android.support.v7.widget.RecyclerView$/LayoutManager)' on a null object reference")
                    //it is happening only if i switch tabs so quick and at least 20-30 times non-stop when i was testing i realized
                }
            }

            override fun onFailure(call: Call<ResponseModel>?, t: Throwable?) {

            }
        })


    }


}
