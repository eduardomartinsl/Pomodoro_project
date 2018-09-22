package com.ufmt.net.pomo.ui

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import com.ufmt.net.pomo.R
import com.ufmt.net.pomo.ui.configuracoes.ConfiguracoesFragment
import com.ufmt.net.pomo.ui.historico.BlankFragment
import com.ufmt.net.pomo.ui.historico.HistoricoHojeFragment
import com.ufmt.net.pomo.ui.pomodoro.PomodoroFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val PREFS_FILENAME = "com.pomo.prefs"

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_historico -> {
                val historicoHojeFragment = HistoricoHojeFragment()
                openFragment(historicoHojeFragment)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_pomodoro -> {
                val pomodoroFragment = PomodoroFragment()
                openFragment(pomodoroFragment)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_projetos -> {
                val a = BlankFragment.newInstance("","")
                openFragment(a)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_configuracoes ->{
                var configuracoesFragment = ConfiguracoesFragment()
                openFragment(configuracoesFragment)
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val prefs = this.getSharedPreferences(PREFS_FILENAME, 0)

        setContentView(R.layout.activity_main)
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
        navigation.selectedItemId = R.id.navigation_pomodoro
    }

    private fun openFragment(fragment: Fragment){
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fragmentContainer, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }
}
