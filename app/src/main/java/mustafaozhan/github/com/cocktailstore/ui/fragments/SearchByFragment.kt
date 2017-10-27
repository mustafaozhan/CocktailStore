package mustafaozhan.github.com.cocktailstore.ui.fragments

import android.content.pm.ActivityInfo
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import mustafaozhan.github.com.cocktailstore.R
import android.widget.ArrayAdapter
import mustafaozhan.github.com.cocktailstore.rest.ApiClient
import mustafaozhan.github.com.cocktailstore.rest.ApiInterface
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.text.Editable
import android.text.TextWatcher
import rx.Observable
import rx.android.schedulers.AndroidSchedulers
import java.util.concurrent.TimeUnit
import android.widget.LinearLayout
import android.widget.Toast
import kotlinx.android.synthetic.main.fragment_search_by.*
import mustafaozhan.github.com.cocktailstore.model.Drink
import mustafaozhan.github.com.cocktailstore.model.ResponseModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import mustafaozhan.github.com.cocktailstore.ui.adapters.MyCocktailAdapter
import mustafaozhan.github.com.cocktailstore.model.DetailedCocktail
import mustafaozhan.github.com.cocktailstore.model.DetailedResponseModel
import mustafaozhan.github.com.cocktailstore.ui.adapters.MyDetailedCocktailAdapter


/**
 * Created by Mustafa Ozhan on 8/12/17 at 9:01 PM on Arch Linux.
 */
class SearchByFragment : Fragment() {


    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val fragmentView = inflater!!.inflate(R.layout.fragment_search_by, container, false)
        activity.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
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

        search()


    }

    private fun search() {
        val apiService = ApiClient.get().create(ApiInterface::class.java)
        Observable.create(Observable.OnSubscribe<String> { subscriber ->
            mETxtSearch.addTextChangedListener(object : TextWatcher {
                override fun afterTextChanged(s: Editable?) = Unit

                override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) = Unit

                override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int)
                        = subscriber.onNext(s.toString())
            })
        }).debounce(500, TimeUnit.MILLISECONDS)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ text ->


                    try {


                        when (mSpinner.selectedItem) {
                            "By Name" -> {
                                val myCall = apiService.getInCocktailsByName(text)
                                myCall.enqueue(object : Callback<DetailedResponseModel> {
                                    override fun onResponse(call: Call<DetailedResponseModel>?, response: Response<DetailedResponseModel>?) {
                                        try {
                                            mProgressBarSearchBy.progress
                                            myRecyclerViewSearchBy.layoutManager = LinearLayoutManager(context, LinearLayout.VERTICAL, false) as RecyclerView.LayoutManager


                                            val mCocktailAdapter = MyDetailedCocktailAdapter(response!!.body()!!.drinks!!)
                                            myRecyclerViewSearchBy.adapter = mCocktailAdapter
                                        } catch (e: Exception) {
                                            Log.w("Warning", "No Cocktail founded")
                                            Toast.makeText(context, "No Cocktail founded", Toast.LENGTH_SHORT).show()
                                            try {


                                                val emptyList = ArrayList<DetailedCocktail>()
                                                val mCocktailAdapter = MyDetailedCocktailAdapter(emptyList)
                                                myRecyclerViewSearchBy.adapter = mCocktailAdapter
                                                mProgressBarSearchBy.visibility = View.GONE
                                            } catch (e: Exception) {
                                                Log.e("Error:", "java.lang.NullPointerException: Attempt to invoke virtual method 'void android.support.v7.widget.RecyclerView.setLayoutManager(android.support.v7.widget.RecyclerView$/LayoutManager)' on a null object reference")
                                                //it is happening only if i switch tabs so quick and at least 20-30 times non-stop when i was testing i realized
                                            }
                                        }

                                    }

                                    override fun onFailure(call: Call<DetailedResponseModel>?, t: Throwable?) {
                                        Log.w("Warning", "No Cocktail founded")
                                        Toast.makeText(context, "No Cocktail founded", Toast.LENGTH_SHORT).show()
                                        try {
                                            val emptyList = ArrayList<DetailedCocktail>()
                                            val mCocktailAdapter = MyDetailedCocktailAdapter(emptyList)
                                            myRecyclerViewSearchBy.adapter = mCocktailAdapter
                                        } catch (e: Exception) {
                                            Log.e("Error:", "java.lang.NullPointerException: Attempt to invoke virtual method 'void android.support.v7.widget.RecyclerView.setLayoutManager(android.support.v7.widget.RecyclerView$/LayoutManager)' on a null object reference")
                                            //it is happening only if i switch tabs so quick and at least 20-30 times non-stop when i was testing i realized
                                        }
                                    }
                                })

                            }


                            "By Ingredient" -> {
                                val myCall = apiService.getCocktailsByIngredient(text)
                                myCall.enqueue(object : Callback<ResponseModel> {
                                    override fun onResponse(call: Call<ResponseModel>?, response: Response<ResponseModel>?) {
                                        try {
                                            mProgressBarSearchBy.progress
                                            myRecyclerViewSearchBy.layoutManager = LinearLayoutManager(context, LinearLayout.VERTICAL, false)

                                            val mCocktailAdapter = MyCocktailAdapter(response!!.body()!!.drinks!!)
                                            myRecyclerViewSearchBy.adapter = mCocktailAdapter
                                        } catch (e: Exception) {
                                            Log.w("Warning", "No Cocktail founded")
                                            Toast.makeText(context, "No Cocktail founded", Toast.LENGTH_SHORT).show()

                                            try {


                                                val emptyList = ArrayList<Drink>()
                                                val mCocktailAdapter = MyCocktailAdapter(emptyList)
                                                myRecyclerViewSearchBy.adapter = mCocktailAdapter
                                                mProgressBarSearchBy.visibility = View.GONE
                                            } catch (e: Exception) {
                                                Log.e("Error:", "java.lang.NullPointerException: Attempt to invoke virtual method 'void android.support.v7.widget.RecyclerView.setLayoutManager(android.support.v7.widget.RecyclerView$/LayoutManager)' on a null object reference")
                                                //it is happening only if i switch tabs so quick and at least 20-30 times non-stop when i was testing i realized
                                            }
                                        }

                                    }

                                    override fun onFailure(call: Call<ResponseModel>?, t: Throwable?) {

                                        try {


                                            Log.w("Warning", "No Cocktail founded")
                                            Toast.makeText(context, "No Cocktail founded", Toast.LENGTH_SHORT).show()
                                            val emptyList = ArrayList<Drink>()
                                            val mCocktailAdapter = MyCocktailAdapter(emptyList)
                                            myRecyclerViewSearchBy.adapter = mCocktailAdapter
                                        } catch (e: Exception) {
                                            Log.e("Error:", "java.lang.NullPointerException: Attempt to invoke virtual method 'void android.support.v7.widget.RecyclerView.setLayoutManager(android.support.v7.widget.RecyclerView$/LayoutManager)' on a null object reference")
                                            //it is happening only if i switch tabs so quick and at least 20-30 times non-stop when i was testing i realized
                                        }
                                    }
                                })


                            }


                        }
                    } catch (e: Exception) {
                        Log.e("Error", "java.lang.IllegalStateException: Exception thrown on Scheduler.Worker thread. Add `onError` handling.\n" +
                                "                      at rx.android.schedulers.LooperScheduler$/ScheduledAction.run(LooperScheduler.java:112)")
                    }


                })
    }


}
