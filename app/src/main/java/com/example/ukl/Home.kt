package com.example.ukl

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class Home : AppCompatActivity() {
    private lateinit var txtEmail: TextView
    private var email: String? = null
    private val KEY_EMAIL = "EA"
    private lateinit var rvTim: RecyclerView
    private val list = ArrayList<Tim>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        txtEmail = findViewById(R.id.tampilEmail)

        val extras = intent.extras
        email = extras?.getString(KEY_EMAIL)
        txtEmail.text = "Selamat datang  $email"

        rvTim = findViewById(R.id.rv_tim)
        rvTim.setHasFixedSize(true)

        list.addAll(DataTim.listData)
        showRecyclerList()
    }

    private fun showRecyclerList() {
        rvTim.layoutManager = LinearLayoutManager(this)
        val listTimAdapter = ListTimAdapter(list)
        rvTim.adapter = listTimAdapter

        listTimAdapter.setOnItemClickCallback(object :ListTimAdapter.OnItemClickCallback{
            override fun onItemClicked(data: Tim) {
                showSelectedHero(data)
            }
        })
    }

        private fun showRecyclerCardView() {
        rvTim.layoutManager = LinearLayoutManager(this)
        val cardViewTimAdapterAdapter = CardViewTimAdapter(list)
        rvTim.adapter = cardViewTimAdapterAdapter
    }

        override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_list -> {
                showRecyclerList()
            }

            R.id.action_card -> {
                showRecyclerCardView()
            }
        }
        return super.onOptionsItemSelected(item)
    }

    private fun showSelectedHero(tim: Tim) {
        Toast.makeText(this, "Kamu memilih " + tim.name, Toast.LENGTH_SHORT).show()
    }

}
