package com.david.practica8

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.david.practica8.data.Modulos
import com.david.practica8.databinding.FragmentItemBinding

class ModulosListAdapter(): ListAdapter<Modulos, ModulosListAdapter.ViewHolder>(DiffUtilModulos) {

    private companion object{
        private val DiffUtilModulos = object: DiffUtil.ItemCallback<Modulos>(){
            override fun areItemsTheSame(oldItem: Modulos, newItem: Modulos): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: Modulos, newItem: Modulos): Boolean {
                return oldItem == newItem
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        return ViewHolder(
            FragmentItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindData(getItem(position))
    }

    inner class ViewHolder(val binding: FragmentItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bindData(item: Modulos) {
            binding.itemId.text = item.id.toString()
            binding.itemModulo.text = item.nombre.toString()
            binding.itemCreditos.text = item.creditos.toString()
        }
    }

}