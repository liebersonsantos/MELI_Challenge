package br.com.liebersonsantos.melichallenge.view.product.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import br.com.liebersonsantos.melichallenge.common.toCurrency
import br.com.liebersonsantos.melichallenge.data.model.Results
import br.com.liebersonsantos.melichallenge.databinding.ItemProductBinding
import com.bumptech.glide.Glide

/**
 * Created by lieberson on 9/15/21.
 * @author lieberson.xsantos@gmail.com
 */
class ProductAdapter(private val clickedItem: ((item: Results) -> Unit)) :
    ListAdapter<Results, ProductAdapter.AdapterViewHolder>(DIFF_CALLBACK) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdapterViewHolder {
        val itemBinding =
            ItemProductBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return AdapterViewHolder(itemBinding, clickedItem)
    }

    override fun onBindViewHolder(holder: AdapterViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class AdapterViewHolder(
        private val itemBinding: ItemProductBinding,
        private val clickedItem: (item: Results) -> Unit
    ) : RecyclerView.ViewHolder(itemBinding.root) {

        fun bind(results: Results) {
            itemBinding.run {
                Glide.with(itemView)
                    .load(results.thumbnail)
                    .fitCenter()
                    .into(productImage)

                textDescription.text = results.title
                textPrice.text = results.price.toCurrency()

                itemView.setOnClickListener {
                    clickedItem.invoke(results)
                }
            }
        }

    }

    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<Results>() {
            override fun areItemsTheSame(oldItem: Results, newItem: Results): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: Results, newItem: Results): Boolean {
                return oldItem == newItem
            }

        }
    }
}