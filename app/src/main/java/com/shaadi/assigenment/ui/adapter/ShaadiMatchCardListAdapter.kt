package com.shaadi.assigenment.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.Nullable
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.shaadi.assigenment.R
import com.shaadi.assigenment.data.model.ResultsItem
import com.shaadi.assigenment.databinding.ListItemMatcherCardBinding
import com.shaadi.assigenment.ui.viewModel.MatchCardViewModel

class ShaadiMatchCardListAdapter constructor(
    var viewModel: MatchCardViewModel
) :
    RecyclerView.Adapter<ShaadiMatchCardListAdapter.ViewHolder>() {
    private var mItems = ArrayList<ResultsItem>()


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ShaadiMatchCardListAdapter.ViewHolder {
        val binding: ListItemMatcherCardBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.list_item_matcher_card,
            parent,
            false
        )
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return mItems.size
    }


    fun updateData(items: List<ResultsItem>) {
        val diffResult = DiffUtil.calculateDiff(MyDiffCallback(items, mItems))
        mItems.clear()
        mItems.addAll(items)
        diffResult.dispatchUpdatesTo(this)
    }

    override fun onBindViewHolder(holder: ShaadiMatchCardListAdapter.ViewHolder, position: Int) {
        val item: ResultsItem = mItems[position]
        holder.binding.item = item
        holder.binding.viewModel = viewModel
    }


    inner class ViewHolder(
        val binding: ListItemMatcherCardBinding
    ) : RecyclerView.ViewHolder(binding.root)


    class MyDiffCallback(
        private var newList: List<ResultsItem>,
        private var oldList: List<ResultsItem>
    ) :
        DiffUtil.Callback() {
        override fun getOldListSize(): Int {
            return oldList.size
        }

        override fun getNewListSize(): Int {
            return newList.size
        }

        override fun areItemsTheSame(
            oldItemPosition: Int,
            newItemPosition: Int
        ): Boolean {
            return oldList[oldItemPosition].email == newList[newItemPosition].email
        }

        override fun areContentsTheSame(
            oldItemPosition: Int,
            newItemPosition: Int
        ): Boolean {
            return oldList[oldItemPosition].isActionTaken == newList[newItemPosition].isActionTaken
        }

        @Nullable
        override fun getChangePayload(
            oldItemPosition: Int,
            newItemPosition: Int
        ): Any? {
            return super.getChangePayload(oldItemPosition, newItemPosition)
        }

    }

}