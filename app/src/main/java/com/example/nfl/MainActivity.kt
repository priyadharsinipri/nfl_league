package com.example.nfl

import android.os.Bundle
import android.util.Log
import android.widget.GridView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.nfl.model.TeamList
import com.example.nfl.repository.Repository
import com.example.nfl.repository.teamRepository
import kotlin.math.log

class MainActivity : AppCompatActivity() {
    private lateinit var  viewModel : mainViewModel
    private lateinit var teamDBViewModel :teamViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
//            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
//            insets
//        }
        val repository = Repository()
        val viewModelFactory = ViewModelFactory(repository)
        teamDBViewModel = ViewModelProvider(this,ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication())).get(teamViewModel::class.java)
        viewModel = ViewModelProvider(this,viewModelFactory).get(mainViewModel::class.java)
        viewModel.getTeams()
        val gridView = findViewById<GridView>(R.id.grid_view)

        viewModel.myResponse.observe(this, Observer { response ->
             var teamList = response.body()?.sports?.get(0)?.leagues?.get(0)?.teamList
             val adapter = teamAdapter(context = applicationContext,teamList!!)
             gridView.adapter = adapter
            Log.e("response", response.body()?.sports?.get(0)?.leagues?.get(0)?.teamList.toString())
            for(i in 0..(teamList!!.size-1)) {
                teamDBViewModel.addTeam(
                    response.body()?.sports?.get(0)?.leagues?.get(0)!!.teamList.get(
                        i
                    ).team
                )
            }
        })

    }
}