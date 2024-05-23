package com.erikzhou.melodystream.viewModels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.erikzhou.melodystream.models.CategoryModel
import com.google.firebase.firestore.FirebaseFirestore

class CategoryViewModel: ViewModel() {
    var categories by mutableStateOf<List<CategoryModel>>(emptyList())

    init {
        fetchCategories()
    }

    private fun fetchCategories() {
        FirebaseFirestore.getInstance().collection("category")
            .get()
            .addOnSuccessListener {
                result -> categories = result.toObjects(CategoryModel::class.java)
            }
            .addOnFailureListener{
                result -> run {
                    println(result.cause)
                    println(result.message)
                }
            }
    }
}