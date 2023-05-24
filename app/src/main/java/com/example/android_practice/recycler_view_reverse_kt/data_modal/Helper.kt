package com.example.android_practice.recycler_view_reverse_kt.data_modal

import android.content.Context
import androidx.appcompat.content.res.AppCompatResources
import com.example.android_practice.R

object Helper {
    private lateinit var getMultiViewType: ArrayList<MultiViewType>

    fun getData(context: Context): ArrayList<MultiViewType> {
        getMultiViewType = arrayListOf()
        getMultiViewType.add(
            MultiViewType.SimpleItem(
                AppCompatResources.getDrawable(
                    context,
                    R.drawable.user5
                ), "Parth"
            )
        )
        getMultiViewType.add(
            MultiViewType.SimpleItem(
                AppCompatResources.getDrawable(
                    context,
                    R.drawable.user1
                ), "Tosif"
            )
        )
        getMultiViewType.add(
            MultiViewType.HorizontalItem(
                arrayListOf(
                    PostModel(AppCompatResources.getDrawable(context, R.drawable.user1)),
                    PostModel(AppCompatResources.getDrawable(context, R.drawable.user8)),
                    PostModel(AppCompatResources.getDrawable(context, R.drawable.user5))
                )
            )
        )
        getMultiViewType.add(
            MultiViewType.DropdownItem(
                AppCompatResources.getDrawable(
                    context,
                    R.drawable.user5
                ),
                "Parth",
                arrayListOf(CommentDataModal("I hope we will be best friends until we die. Then, we stay ghost pals to take such beautiful pictures."))
            )
        )
        getMultiViewType.add(
            MultiViewType.SimpleItem(
                AppCompatResources.getDrawable(
                    context,
                    R.drawable.user5
                ), "Parth"
            )
        )
        getMultiViewType.add(
            MultiViewType.SimpleItem(
                AppCompatResources.getDrawable(
                    context,
                    R.drawable.user1
                ), "Tosif"
            )
        )
        getMultiViewType.add(
            MultiViewType.HorizontalItem(
                arrayListOf(
                    PostModel(AppCompatResources.getDrawable(context, R.drawable.user1)),
                    PostModel(AppCompatResources.getDrawable(context, R.drawable.user8)),
                    PostModel(AppCompatResources.getDrawable(context, R.drawable.user5))
                )
            )
        )
        getMultiViewType.add(
            MultiViewType.DropdownItem(
                AppCompatResources.getDrawable(
                    context,
                    R.drawable.user8
                ), "Parth", arrayListOf(CommentDataModal("This is a best Song"))
            )
        )
        getMultiViewType.add(
            MultiViewType.SimpleItem(
                AppCompatResources.getDrawable(
                    context,
                    R.drawable.user5
                ), "Parth"
            )
        )
        getMultiViewType.add(
            MultiViewType.SimpleItem(
                AppCompatResources.getDrawable(
                    context,
                    R.drawable.user1
                ), "Tosif"
            )
        )
        getMultiViewType.add(
            MultiViewType.HorizontalItem(
                arrayListOf(
                    PostModel(AppCompatResources.getDrawable(context, R.drawable.user1)),
                    PostModel(AppCompatResources.getDrawable(context, R.drawable.user8)),
                    PostModel(AppCompatResources.getDrawable(context, R.drawable.user5))
                )
            )
        )
        getMultiViewType.add(
            MultiViewType.DropdownItem(
                AppCompatResources.getDrawable(
                    context,
                    R.drawable.user5
                ),
                "Parth",
                arrayListOf(
                    CommentDataModal("This is a best Song"),
                    CommentDataModal("This is a best Song"),
                    CommentDataModal("This is a best Song")
                )
            )
        )
        getMultiViewType.add(
            MultiViewType.SimpleItem(
                AppCompatResources.getDrawable(
                    context,
                    R.drawable.user5
                ), "Parth"
            )
        )

        return getMultiViewType
    }
}