package com.example.wikipedia

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.content.ContextCompat
import androidx.core.view.GravityCompat
import androidx.fragment.app.Fragment
import cn.pedant.SweetAlert.SweetAlertDialog
import com.example.wikipedia.databinding.ActivityMainBinding
import com.example.wikipedia.fragments.FragmentExplore
import com.example.wikipedia.fragments.FragmentProfile
import com.example.wikipedia.fragments.FragmentTrend
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolBarMain)

        val actionBarDrawerToggle = ActionBarDrawerToggle(
            this,
            binding.drawerLayoutMain,
            binding.toolBarMain,
            R.string.open_drawer,
            R.string.close_drawer
        )
        actionBarDrawerToggle.syncState()

        firstRun()

        binding.drawerLayoutMain.addDrawerListener(actionBarDrawerToggle)

        binding.navigationDrawerMain.setNavigationItemSelectedListener {
            when (it.itemId) {

                R.id.menu_writer -> {
                    binding.drawerLayoutMain.closeDrawer(GravityCompat.START)
                    val dialog = SweetAlertDialog(this , SweetAlertDialog.WARNING_TYPE)
                    dialog.titleText = "Alert!"
                    dialog.confirmText = "confirm"
                    dialog.cancelText = "cancel"
                    dialog.contentText = "open wikimedia"
                    dialog.setOnCancelListener{
                        dialog.dismiss()
                    }
                    dialog.setConfirmClickListener {
                        dialog.dismiss()
                    }
                    dialog.show()
                }
                R.id.menu_photographer -> {
                    binding.drawerLayoutMain.closeDrawer(GravityCompat.START)
                    val dialog = SweetAlertDialog(this , SweetAlertDialog.SUCCESS_TYPE)
                    dialog.titleText = "Alert!"
                    dialog.confirmText = "confirm"
                    dialog.cancelText = "cancel"
                    dialog.contentText = "open wikimedia"
                    dialog.setOnCancelListener{
                        dialog.dismiss()
                    }
                    dialog.setConfirmClickListener {
                        dialog.dismiss()
                    }
                    dialog.show()
                }
                R.id.menu_videoMaker -> {
                    binding.drawerLayoutMain.closeDrawer(GravityCompat.START)
                    val dialog = SweetAlertDialog(this , SweetAlertDialog.PROGRESS_TYPE)
                    dialog.titleText = "Alert!"
                    dialog.confirmText = "confirm"
                    dialog.cancelText = "cancel"
                    dialog.contentText = "open wikimedia"
                    dialog.setOnCancelListener{
                        dialog.dismiss()
                    }
                    dialog.setConfirmClickListener {
                        dialog.dismiss()
                    }
                    dialog.show()
                }
                R.id.menu_translator -> {
                    binding.drawerLayoutMain.closeDrawer(GravityCompat.START)
                    val dialog = SweetAlertDialog(this , SweetAlertDialog.ERROR_TYPE)
                    dialog.titleText = "Alert!"
                    dialog.confirmText = "confirm"
                    dialog.cancelText = "cancel"
                    dialog.contentText = "open wikimedia"
                    dialog.setOnCancelListener{
                        dialog.dismiss()
                    }
                    dialog.setConfirmClickListener {
                        dialog.dismiss()
                    }
                    dialog.show()

                }
                R.id.menu_visitWikimedia -> {
                    binding.drawerLayoutMain.closeDrawer(GravityCompat.START)
                    val dialog = SweetAlertDialog(this , SweetAlertDialog.NORMAL_TYPE)
                    dialog.titleText = "Alert!"
                    dialog.confirmText = "confirm"
                    dialog.cancelText = "cancel"
                    dialog.contentText = "open wikipedia"
                    dialog.setOnCancelListener{
                        dialog.dismiss()
                    }
                    dialog.setConfirmClickListener {
                        dialog.dismiss()
                        val intent = Intent(Intent.ACTION_VIEW , Uri.parse("https://www.wikimedia.org/"))
                        startActivity(intent)
                    }
                    dialog.show()

                }
                R.id.menu_visitWikipedia -> {
                    binding.drawerLayoutMain.closeDrawer(GravityCompat.START)
                    Snackbar.make(binding.root , "open wikipedia wep " , Snackbar.LENGTH_LONG)
                        .setAction("open"){
                            val intent = Intent(Intent.ACTION_VIEW , Uri.parse("https://en.wikipedia.org/wiki/Main_Page"))
                            startActivity(intent)
                        }
                        .setTextColor(ContextCompat.getColor(this , R.color.white))
                        .setActionTextColor(ContextCompat.getColor(this , R.color.white))
                        .setBackgroundTint(ContextCompat.getColor(this,R.color.blue))
                        .show()

                }

            }
            true
        }

        binding.bottomNavigation.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.menu_explore -> {
                    replaceFragment(FragmentExplore())
                }

                R.id.menu_trend -> {
                    replaceFragment(FragmentTrend())
                }

                R.id.menu_profile -> {
                    replaceFragment(FragmentProfile())
                }
            }

            true
        }
        binding.bottomNavigation.setOnItemReselectedListener {}


    }

    private fun replaceFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.frame_main_container, fragment)
        transaction.commit()
    }

    private fun firstRun() {

        replaceFragment(FragmentExplore())
        binding.bottomNavigation.selectedItemId = R.id.menu_explore

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main , menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.menu_exit->{
                onBackPressed()
            }
        }
        return true
    }
}