package art.com.retrofit

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.leanback.widget.DiffCallback
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import art.com.databinding.GridViewItemBinding


class PhotoGridAdapter : ListAdapter<MarsProperty,
                        PhotoGridAdapter.MarsPropertyViewHolder>(DiffCallback) {


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): PhotoGridAdapter.MarsPropertyViewHolder {
       return MarsPropertyViewHolder(GridViewItemBinding.inflate(
           LayoutInflater.from(parent.context)
       ))
    }



    override fun onBindViewHolder(holder: PhotoGridAdapter.MarsPropertyViewHolder, position: Int) {
        val marsProperty = getItem(position)
        holder.bind(marsProperty)
    }

    companion object DiffCallback : DiffUtil.ItemCallback<MarsProperty>() {
        override fun areItemsTheSame(oldItem: MarsProperty, newItem: MarsProperty): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: MarsProperty, newItem: MarsProperty): Boolean {
            return oldItem.id == newItem.id
        }
    }

    class MarsPropertyViewHolder(private var binding: GridViewItemBinding) :
                                                RecyclerView.ViewHolder(binding.root) {
        fun bind(marsProperty: MarsProperty) {
            binding.property= marsProperty
            binding.executePendingBindings()
        }
    }

}

