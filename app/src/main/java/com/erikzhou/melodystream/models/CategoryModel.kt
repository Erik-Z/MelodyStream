package com.erikzhou.melodystream.models

data class CategoryModel(
    val name: String,
    val coverUrl: String
) {
    constructor() : this("", "")
}
