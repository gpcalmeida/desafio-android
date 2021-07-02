package com.picpay.desafio.android.presentation

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.picpay.desafio.android.R
import com.picpay.desafio.android.data.room.UserDatabase
import com.picpay.desafio.android.databinding.ActivityMainBinding
import com.picpay.desafio.android.domain.model.User
import com.picpay.desafio.android.domain.model.result.MainResult
import com.picpay.desafio.android.presentation.adapters.UserListAdapter
import com.picpay.desafio.android.injection.MainInjection.injectMainViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var adapter: UserListAdapter

    private val viewModel by lazy {
        injectMainViewModel()
    }

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        adapter = UserListAdapter()

        with(binding) {
            recyclerView.adapter = adapter
            recyclerView.layoutManager = LinearLayoutManager(this@MainActivity)

            userListProgressBar.visibility = View.VISIBLE
        }

        setupObservers()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putParcelableArrayList(USER_KEY, ArrayList(adapter.users))
        super.onSaveInstanceState(outState)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        val savedUsers = savedInstanceState.getParcelableArrayList<User>(USER_KEY)
        adapter.users = savedUsers ?: emptyList()
        super.onRestoreInstanceState(savedInstanceState)
    }

    override fun onResume() {
        super.onResume()

        viewModel.getUsers()
        UserDatabase.getDatabase()
    }

    private fun setupObservers() {
        viewModel.mainState.observe(this, {
            handleMainResult(it)
        })
    }

    private fun handleMainResult(result: MainResult) {
        with(binding) {
            when (result) {
                is MainResult.Success -> {
                    adapter.users = result.users
                    userListProgressBar.visibility = View.GONE
                }
                is MainResult.Failure -> {
                    userListProgressBar.visibility = View.GONE
                    recyclerView.visibility = View.GONE

                    val message = getString(R.string.error)
                    Toast.makeText(this@MainActivity, message, Toast.LENGTH_SHORT).show()
                }
                is MainResult.Loading -> {
                    userListProgressBar.visibility = View.VISIBLE
                }
            }
        }
    }

    companion object {
        private const val USER_KEY = "USER_KEY"
    }
}
