package com.david.practica8.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.david.practica8.ModulosListAdapter
import com.david.practica8.databinding.FragmentItemListBinding
import com.david.practica8.viewmodel.ModulosViewModel
import com.david.practica8.viewmodel.ModulosViewModelFactory

/**
 * A fragment representing a list of Items.
 */
class ListFragment : Fragment() {

    private var columnCount = 1
    private var _binding: FragmentItemListBinding? = null
    private val binding get() = _binding!!
    private val viewModel: ModulosViewModel by activityViewModels{ ModulosViewModelFactory() }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentItemListBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Set the adapter
        val view: RecyclerView = binding.list
        val modulosAdapter = ModulosListAdapter()
        with(view) {
            layoutManager = when {
                columnCount <= 1 -> LinearLayoutManager(context)
                else -> GridLayoutManager(context, columnCount)
            }
            adapter = modulosAdapter
        }
        viewModel.allModulos.observe(viewLifecycleOwner){
            modulosAdapter.submitList(it){
                binding.list.scrollToPosition(0)
            }
        }
    }

}