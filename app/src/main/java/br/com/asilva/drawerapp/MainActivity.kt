package br.com.asilva.drawerapp

import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.design.widget.Snackbar
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.view.MenuItem
import android.support.v4.widget.DrawerLayout
import android.support.design.widget.NavigationView
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.view.Menu
import android.widget.Toast
import br.com.asilva.drawerapp.fragments.*
import br.com.asilva.drawerapp.models.User

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    private var user: User? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        val fab: FloatingActionButton = findViewById(R.id.fab)
        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }
        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        val navView: NavigationView = findViewById(R.id.nav_view)
        val toggle = ActionBarDrawerToggle(
            this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close
        )
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        navView.setNavigationItemSelectedListener(this)

        user = User("Usuario Teste",
            30,
            "15/05/1989",
            "Casado",
            "(21)97372-7121",
            "Ensino Superior",
            "Empresa XYZ Ltda",
            "Eng. Software",
            "Aplicando DDD")
    }

    override fun onBackPressed() {
        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
    lateinit var newFragment: Fragment
    private fun userInfofragBuilder(newFragment: Fragment){
        val fragTransaction = supportFragmentManager.beginTransaction()
        fragTransaction.replace(R.id.content_id, newFragment)
        fragTransaction.commit()
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        // Handle navigation view item clicks here.
        when (item.itemId) {
            R.id.nav_info_user -> {

                if (user != null){
                    userInfofragBuilder(UserInfoFragment.newInstance(user!!))
                }
            }
            R.id.nav_formation -> {

                if (user != null){
                    userInfofragBuilder(FormationFragment.newInstance(user!!))
                }

            }
            R.id.nav_exp_professional -> {

                if (user != null){
                    userInfofragBuilder(ExperienceFragment.newInstance(user!!))
                }

            }
            R.id.nav_courses -> {

                if (user != null){
                    userInfofragBuilder(CourseFragment.newInstance(user!!))
                }

            }
            R.id.nav_publication -> {

                if (user != null){
                    userInfofragBuilder(PublicationFragment.newInstance(user!!))
                }

            }
            R.id.nav_share -> {

                Toast.makeText(this, "Mensagem compartilhada!", Toast.LENGTH_LONG).show()
            }
            R.id.nav_send -> {

                Toast.makeText(this, "Mensagem enviada!", Toast.LENGTH_LONG).show()

            }
        }
        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        drawerLayout.closeDrawer(GravityCompat.START)
        return true
    }
}
