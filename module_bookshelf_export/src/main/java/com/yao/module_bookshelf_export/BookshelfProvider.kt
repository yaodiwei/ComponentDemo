@file:Suppress("unused")

package com.yao.module_bookshelf_export

import com.alibaba.android.arouter.facade.template.IProvider
import com.yao.module_bookshelf_export.data.BookEntity

interface BookshelfProvider : IProvider {

    /**
     * 今天有没有点开书架里的作品
     */
    fun hasOpenBookFromBookshelfToday(): Boolean

    /**
     * 获取书架的所有作品列表
     *
     * @return 实体 {@link BookEntity}
     */
    fun getBookShelfList(): List<BookEntity>

    /**
     * 监听今天已完成了一章阅读的回调
     *
     * @param callback {@link FinishOneChapterCallback}
     */
    fun registerFinishOneChapter(callback: FinishOneChapterCallback)

    /**
     * 请求接口，刷新书架信息。比如用户刚增加了一个书进书架
     *
     * @return 返回rxjava观察者，请求成功后回调
     */
    fun requestBookshelfUpdate(): List<BookEntity>




    // ——————————————————————————————
    /**
     * 今天完成一个章节阅读后的回调
     */
    interface FinishOneChapterCallback {
        fun onFinish(bookId: Int, chapterId: Int)
    }
}