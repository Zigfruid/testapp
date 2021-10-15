package com.example.testapp.dialogs

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.widget.Toast
import com.example.testapp.R
import com.example.testapp.core.onClick
import com.example.testapp.databinding.DialogSizeBinding

class GiveSizeDialog(context: Context): Dialog(context) {

    private lateinit var binding:DialogSizeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DialogSizeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnPickSize.onClick {
            binding.apply {
                if (etFrom.text.toString().isNotEmpty() && etTo.text.toString().isNotEmpty()){
                    val firstSize = etFrom.text.toString()
                    val secondSize = etTo.text.toString()
                    sendSize.invoke(firstSize.toInt(), secondSize.toInt())
                    dismiss()
                }else{
                    Toast.makeText(context, context.getString(R.string.fill_fields), Toast.LENGTH_SHORT).show()
                }
            }
        }
        binding.btnCancel.onClick {
            dismiss()
        }
    }


    private var sendSize: (from:Int, to:Int) -> Unit = { _:Int, _: Int -> }
    fun setSize(sendSize: (from:Int, to:Int) -> Unit) {
        this.sendSize = sendSize
    }


}