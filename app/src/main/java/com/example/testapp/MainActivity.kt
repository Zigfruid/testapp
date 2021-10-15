package com.example.testapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.testapp.core.onClick
import com.example.testapp.databinding.ActivityMainBinding
import com.example.testapp.dialogs.GiveSizeDialog

class MainActivity : AppCompatActivity() {
    private var firstSize = 0
    private var secondSize = 0
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val  view = binding.root
        setContentView(view)
        binding.btnSize.onClick {
            val dialog = GiveSizeDialog(this)
            dialog.setSize { from, to ->
                firstSize = from
                secondSize = to
            }
            dialog.show()
        }
    }

}