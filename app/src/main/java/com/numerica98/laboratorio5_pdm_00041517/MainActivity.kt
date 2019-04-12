package com.numerica98.laboratorio5_pdm_00041517

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MainActivity : AppCompatActivity(), FragmentBasic.ListenerToolBox {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val fragmentBasic=FragmentBasic.newInstance("Soy texto1", "soy texto2")
        supportFragmentManager
                .beginTransaction()
                .add(R.id.activity_content, fragmentBasic)
                .commit()
        //if(resources.configuration.orientation==Configuration.ORIENTATION_LANDSCAPE){toast.maketext}
    }

    override fun clickListenerHandler(view: TextView) {
        view.text="bbcitha bhrr"
    }
}
