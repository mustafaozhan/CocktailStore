package mustafaozhan.github.com.cocktailstore.ui.fragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import mustafaozhan.github.com.cocktailstore.R
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.search_by_fragment.*
import mustafaozhan.github.com.cocktailstore.rest.ApiClient
import mustafaozhan.github.com.cocktailstore.rest.ApiInterface
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.widget.LinearLayout
import android.widget.Toast
import mustafaozhan.github.com.cocktailstore.model.Drink
import mustafaozhan.github.com.cocktailstore.model.ResponseModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import mustafaozhan.github.com.cocktailstore.ui.adapters.MyCocktailAdapter


/**
 * Created by Mustafa Ozhan on 8/12/17 at 9:01 PM on Arch Linux.
 */
class SearchByFragment : Fragment() {


    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val fragmentView = inflater!!.inflate(R.layout.search_by_fragment, container, false)
//        bindViews(fragmentView)
        return fragmentView
    }

//    private fun bindViews(view: View) {}

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        mProgressBarSearchBy.visibility = View.GONE
        val by = ArrayList<String>()
        by.add("By Name")
        by.add("By Ingredient")
        val dataAdapterBy = ArrayAdapter(activity, android.R.layout.simple_spinner_item, by)
        dataAdapterBy.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        mSpinner.adapter = dataAdapterBy
        val apiService = ApiClient.get().create(ApiInterface::class.java)



        mBtnSearch.setOnClickListener {


            mProgressBarSearchBy.progress

            when (mSpinner.selectedItem) {
                "By Name" -> {
                    val myCall = apiService.getByName(mETxtSearch.text.toString())
                    myCall.enqueue(object : Callback<ResponseModel> {
                        override fun onResponse(call: Call<ResponseModel>?, response: Response<ResponseModel>?) {
                            myRecyclerViewSearchBy.layoutManager = LinearLayoutManager(context, LinearLayout.VERTICAL, false)
                            try {

                                val mCocktailAdapter = MyCocktailAdapter(response!!.body()!!.drinks!!)
                                myRecyclerViewSearchBy.adapter = mCocktailAdapter
                            } catch (e: Exception) {
                                Log.w("Warning", "No Cocktail founded")
                                Toast.makeText(context, "No Cocktail founded", Toast.LENGTH_SHORT).show()
                                val emptyList=ArrayList<Drink>()
                                val mCocktailAdapter = MyCocktailAdapter(emptyList)
                                myRecyclerViewSearchBy.adapter = mCocktailAdapter
                            }
                            mProgressBarSearchBy.visibility = View.GONE
                        }

                        override fun onFailure(call: Call<ResponseModel>?, t: Throwable?) {
                        }
                    })

                }
                "By Ingredient" -> {


                    val myCall = apiService.getByIngredient(mETxtSearch.text.toString())
                    myCall.enqueue(object : Callback<ResponseModel> {
                        override fun onResponse(call: Call<ResponseModel>?, response: Response<ResponseModel>?) {
                            myRecyclerViewSearchBy.layoutManager = LinearLayoutManager(context, LinearLayout.VERTICAL, false)
                            try {

                                val mCocktailAdapter = MyCocktailAdapter(response!!.body()!!.drinks!!)
                                myRecyclerViewSearchBy.adapter = mCocktailAdapter
                            } catch (e: Exception) {
                                Log.w("Warning", "No Cocktail founded")
                                Toast.makeText(context, "No Cocktail founded", Toast.LENGTH_SHORT).show()
                                val emptyList=ArrayList<Drink>()
                                val mCocktailAdapter = MyCocktailAdapter(emptyList)
                                myRecyclerViewSearchBy.adapter = mCocktailAdapter
                            }
                            mProgressBarSearchBy.visibility = View.GONE
                        }

                        override fun onFailure(call: Call<ResponseModel>?, t: Throwable?) {
                        }
                    })


                }
            }
        }


    }


}
