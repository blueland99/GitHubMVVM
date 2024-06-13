package com.blueland99.github_mvvm.presentation.view

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.blueland99.github_mvvm.R
import com.blueland99.github_mvvm.presentation.viewmodel.UserViewModel
import com.blueland99.github_mvvm.presentation.adapter.UserAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private val userViewModel: UserViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        userViewModel.users.observe(this, Observer { users ->
            recyclerView.adapter = UserAdapter(users)
        })

        userViewModel.loadUsers()
    }
}
