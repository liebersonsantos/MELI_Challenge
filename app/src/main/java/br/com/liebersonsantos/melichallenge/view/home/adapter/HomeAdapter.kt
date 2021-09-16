package br.com.liebersonsantos.melichallenge.view.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import br.com.liebersonsantos.melichallenge.data.model.Categories
import br.com.liebersonsantos.melichallenge.databinding.ItemCategoryBinding

/**
 * Created by lieberson on 9/13/21.
 * @author lieberson.xsantos@gmail.com
 */
class HomeAdapter(private val clickedItem: ((item: Categories) -> Unit)) :
    ListAdapter<Categories, HomeAdapter.AdapterViewHolder>(DIFF_CALLBACK) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdapterViewHolder {
        val itemBinding = ItemCategoryBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return AdapterViewHolder(itemBinding, clickedItem)
    }

    override fun onBindViewHolder(holder: AdapterViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class AdapterViewHolder(
        private val itemBinding: ItemCategoryBinding,
        private val clickedItem: (item: Categories) -> Unit
    ) : RecyclerView.ViewHolder(itemBinding.root) {

        fun bind(category: Categories) {
            itemBinding.run {
               textDescription.text = category.name

                itemView.setOnClickListener {
                    clickedItem.invoke(category)
                }
            }
        }
    }

    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<Categories>() {
            override fun areItemsTheSame(oldItem: Categories, newItem: Categories): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: Categories, newItem: Categories): Boolean {
                return oldItem == newItem
            }

        }
    }
}