package sort

import shape.Sortable

class HeapSort(delay: Long, doAfterEachStep: ()->Unit) : BaseSort(delay, doAfterEachStep)  {
    override fun <T : Sortable> sort(data: Array<T>) {
        TODO("Not yet implemented")
    }
}