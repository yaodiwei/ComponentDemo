package com.yao.module_bookshelf_export.data

/**
 * 书籍详细信息信息
 */
data class BookDetailEntity(
    var id: Int,
    var name: String,
    var authorId: Int,
    var authorName: String,
    var desc: String
)
