package by.chekun.bean

class PageWrapperBean<T>(
    val objects: List<T>,
    val totalPages: Int,
    val totalElements: Long,
    val page: Int,
    val elementsCount: Int
) {

    override fun toString(): String {
        return "PageWrapper{" +
                ", totalPages=" + totalPages +
                ", totalElements=" + totalElements +
                ", page=" + page +
                ", elementsCount=" + elementsCount +
                '}'
    }

    companion object {
        fun <T> of(
            objects: List<T>,
            totalPages: Int,
            totalElements: Long,
            page: Int,
            elementsCount: Int
        ): PageWrapperBean<T> {
            return PageWrapperBean(objects, totalPages, totalElements, page, elementsCount)
        }
    }

}