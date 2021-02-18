package com.yao.module_bookshelf_export.data

/**
 * 书籍基本信息
 */
data class BookEntity(
    var id: Int,
    var name: String,
    var authorId: Int,
    var authorName: String
)
