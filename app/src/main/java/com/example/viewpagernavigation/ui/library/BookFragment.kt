package com.example.viewpagernavigation.ui.library

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import com.example.viewpagernavigation.R
import kotlinx.android.synthetic.main.fragment_book.*

class BookFragment : Fragment(R.layout.fragment_book) {

    private lateinit var bookTitle: String
    private lateinit var bookPublishDate: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.apply {
            bookTitle = getString(KEY_TITLE, "")
            bookPublishDate = getString(KEY_DATE, "")
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        book_title.text = bookTitle
        book_publish_date.text = bookPublishDate
    }

    companion object {

        const val KEY_TITLE = "title"
        const val KEY_DATE = "date"

    }
}
