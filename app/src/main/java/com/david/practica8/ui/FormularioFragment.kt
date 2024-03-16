package com.david.practica8.ui

import android.app.AlertDialog
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.david.practica8.R
import com.david.practica8.databinding.FragmentFormularioBinding
import com.david.practica8.viewmodel.ModulosViewModel
import com.david.practica8.viewmodel.ModulosViewModelFactory


class FormularioFragment : Fragment() {
    private var _binding: FragmentFormularioBinding? = null
    private val binding get() = _binding!!

    private val modulosViewModel: ModulosViewModel by activityViewModels{
        ModulosViewModelFactory()
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentFormularioBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val guardarButton: Button = binding.btnGuardar
        guardarButton.setOnClickListener{
            val nombre = binding.txtModulo.text.toString()
            val creditos = binding.txtCreditos.text.toString().toInt()
            modulosViewModel.insertModulos(nombre, creditos)
        }

        binding.btnLimpiar.setOnClickListener(){
            AlertDialog.Builder(context)
                .setTitle(R.string.clear_dialog_title)
                .setMessage(R.string.clear_dialog_message)
                .setNegativeButton(R.string.clear_dialog_cancel){ dialog, _ ->
                    dialog.cancel()
                }
                .setPositiveButton(R.string.clear_dialog_confirm){ _, _ ->
                    modulosViewModel.clearModulos()
                }
                .setCancelable(false)
                .show()
        }
    }

}