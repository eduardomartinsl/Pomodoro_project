package com.ufmt.net.pomo.ui.configuracoes

import android.app.AlertDialog
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SeekBar
import android.widget.Toast
import com.ufmt.net.pomo.R
import kotlinx.android.synthetic.main.fragment_configuracoes.*

class ConfiguracoesFragment: Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.fragment_configuracoes, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        seekBarPomodoro.max = 50
        seekBarPomodoro.progress = 25
        textViewTempoPomodoro.text = seekBarPomodoro.progress.toString()

        seekBarDescanso.max = 10
        seekBarDescanso.progress = 5
        textViewDescanso.text = seekBarDescanso.progress.toString()

        seekBarPomodoro.setOnSeekBarChangeListener(
                object: SeekBar.OnSeekBarChangeListener{
                    override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                        textViewTempoPomodoro.text = progress.toString()
                    }

                    override fun onStartTrackingTouch(seekBar: SeekBar?) {
                    }

                    override fun onStopTrackingTouch(seekBar: SeekBar?) {
                    }
                }
        )

        seekBarDescanso.setOnSeekBarChangeListener(
                object: SeekBar.OnSeekBarChangeListener{
                    override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                        textViewDescanso.text = progress.toString()
                    }

                    override fun onStartTrackingTouch(seekBar: SeekBar?) {
                    }

                    override fun onStopTrackingTouch(seekBar: SeekBar?) {
                    }

                }
        )

        buttonRestaurarPadroes.setOnClickListener {

            val alert = AlertDialog.Builder(context)

            alert.setTitle("Restaurar padrões")

            alert.setMessage("Deseja definir os padrões de sistema?")

            alert.setPositiveButton("Sim"){ _, _ ->
                Toast.makeText(context, "Padrões restaurados",Toast.LENGTH_SHORT).show()
                seekBarPomodoro.progress = 25
                seekBarDescanso.progress = 5

                checkBoxDesabilitaNotificacao.isChecked = false
                checkBoxSomRelogio.isChecked = false
                checkBoxSom.isChecked = false
            }

            alert.setNegativeButton("Não") { _, _ ->
                return@setNegativeButton
            }

            val dialog: AlertDialog = alert.create()

            dialog.show()

        }


    }

}