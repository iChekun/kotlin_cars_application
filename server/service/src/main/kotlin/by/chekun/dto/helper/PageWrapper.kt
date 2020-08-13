package by.chekun.dto.helper

class PageWrapper<T>(
    var objects: List<T>,
    var totalPages: Int,
    var totalElements: Long,
    var page: Int,
    var elementsCount: Int
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
        ): PageWrapper<T> {
            return PageWrapper(objects, totalPages, totalElements, page, elementsCount)
        }
    }

}