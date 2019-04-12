package com.numerica98.laboratorio5_pdm_00041517

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import kotlinx.android.synthetic.main.fragment_basic.view.*
import java.lang.Exception

const val ARG_TEXT1 = "texto1"
const val ARG_TEXT2 = "texto2"

class FragmentBasic:Fragment() {

    var texto1:String?= null
    var texto2:String?= null
    var toolBox:ListenerToolBox?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.apply {
            getString(ARG_TEXT1,"")
            getString(ARG_TEXT2,"")
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
         return inflater.inflate(R.layout.fragment_basic, container, false).apply {
             tv_texto1.text=texto1
             tv_texto2.text=texto2
             bt_boton.setOnClickListener{
                 toolBox?.clickListenerHandler(tv_texto1)
             }
         }
    }

    companion object {
        fun newInstance(texto1:String, texto2:String)= FragmentBasic().apply {
            arguments=Bundle().apply {
                putString(ARG_TEXT1,texto1)
                putString(ARG_TEXT2,texto2)
            }
        }
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)//Padre que me mando a llamar, el que me creo como fragmento. EN este caso es Main
        if (context is ListenerToolBox){ //pregunta si es del tipo a usar
            toolBox= context
        }else{
            throw Exception("Se necesita implementar la interfaz ToolBoxListener")
        }
    }

    override fun onDetach() {
        super.onDetach()
    }

    interface ListenerToolBox{//puede ser un archivo aparte
        fun clickListenerHandler(view: TextView)

    }
}