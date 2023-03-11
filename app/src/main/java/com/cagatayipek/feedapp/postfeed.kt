package com.cagatayipek.feedapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import androidx.recyclerview.widget.RecyclerView.Recycler
import kotlinx.android.synthetic.main.fragment_postfeed.*
import kotlinx.coroutines.*
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class postfeed : Fragment() {
    private var BASE_URL="https://raw.githubusercontent.com/"
    private var foodModels:ArrayList<FoodModel>?=null
    private var job:Job?=null
    private var recyclerViewAdapter:RecyclerViewAdapter?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)




    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_postfeed, container, false)


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val layoutManager:RecyclerView.LayoutManager=LinearLayoutManager(context)
        recyclervieww.layoutManager=layoutManager
        loadData()
    }

    fun loadData(){
        val retrofit=Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(FoodAPI::class.java)
        job = CoroutineScope(Dispatchers.IO).launch {
            val response=retrofit.getData()
            withContext(Dispatchers.Main){
                if(response.isSuccessful){
                    response.body()?.let {
                        foodModels=ArrayList(it)

                        recyclerViewAdapter= RecyclerViewAdapter(foodModels!!)
                            recyclervieww.adapter=recyclerViewAdapter


                    }
                }
            }
        }
    }




}