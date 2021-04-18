package com.miqdad71.myhero

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.PopupMenu
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ismaeldivita.chipnavigation.ChipNavigationBar
import com.miqdad71.myhero.Adapter.CardViewHeroAdapter
import com.miqdad71.myhero.Adapter.GridHeroAdapter
import com.miqdad71.myhero.Adapter.ListHeroAdapter
import com.miqdad71.myhero.Data.Hero
import com.miqdad71.myhero.Data.HeroesData

class MainActivity : AppCompatActivity() {
    private lateinit var rvHeroes: RecyclerView
    private var list: ArrayList<Hero> = arrayListOf()

    companion object {
        const val INTENT_PARCELABLE = "OBJECT_INTENT"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()

        rvHeroes = findViewById(R.id.rv_main)
        rvHeroes.setHasFixedSize(true)

        list.addAll(HeroesData.listData)
        showRecyclerList()

//Navigation Bottom
        val bottomNavigation: ChipNavigationBar = findViewById(R.id.bottom_nav_test)
        bottomNavigation.setItemSelected(R.id.iHero)
        bottomNavigation.setOnItemSelectedListener {
            when (it) {
                R.id.iAboutMe -> {
                    val intent = Intent(this, AboutMeActivity::class.java)
                    startActivity(intent)
                    finishAffinity()
                }
                R.id.iHero -> {
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                    finishAffinity()
                }
            }
        }
//Navigation Bottom


//Custom Option List Menu
        val iconList = findViewById<ImageView>(R.id.icon_list)
        iconList.setOnClickListener {
            val popupMenu = PopupMenu(this, iconList)
            popupMenu.menuInflater.inflate(R.menu.menu_main, popupMenu.menu)
            popupMenu.setOnMenuItemClickListener { v ->
                when (v.itemId) {
                    R.id.action_list -> {
                        showRecyclerList()
                    }

                    R.id.action_grid -> {
                        showRecyclerGrid()
                    }

                    R.id.action_cardview -> {
                        showRecyclerCardView()
                    }
                }
                true
            }
            popupMenu.show()
        }
//Custom Option List Menu

    }

    //Adapter Function
    private fun showRecyclerList() {
        rvHeroes.layoutManager = LinearLayoutManager(this)
        val listHeroAdapter = ListHeroAdapter(list)
        rvHeroes.adapter = listHeroAdapter

        listHeroAdapter.setOnItemClickCallback(object : ListHeroAdapter.OnItemClickCallback {
            override fun onItemClicked(data: Hero) {
                showSelectedHero(data)
            }
        })
    }

    private fun showRecyclerGrid() {
        rvHeroes.layoutManager = GridLayoutManager(this, 2)
        val gridHeroAdapter = GridHeroAdapter(list)
        rvHeroes.adapter = gridHeroAdapter

        gridHeroAdapter.setOnItemClickCallback(object : GridHeroAdapter.OnItemClickCallback {
            override fun onItemClicked(data: Hero) {
                showSelectedHero(data)
            }
        })
    }

    private fun showRecyclerCardView() {
        rvHeroes.layoutManager = LinearLayoutManager(this)
        val cardViewHeroAdapter = CardViewHeroAdapter(list)
        rvHeroes.adapter = cardViewHeroAdapter

        cardViewHeroAdapter.setOnItemClickCallback(object :
            CardViewHeroAdapter.OnItemClickCallback {
            override fun onItemClicked(data: Hero) {
                showSelectedHero(data)
            }
        })
    }
//Adapter Function

    //Intent Data
    private fun showSelectedHero(hero: Hero) {
        Toast.makeText(this, "Kamu memilih " + hero.name, Toast.LENGTH_SHORT).show()

        val detailPage = Intent(
            this@MainActivity,
            DetailActivity::class.java
        )
        detailPage.putExtra(INTENT_PARCELABLE, hero)
        startActivity(detailPage)
    }
//Intent Data

}