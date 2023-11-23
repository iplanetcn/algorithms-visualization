/**
 * PaintData
 *
 * @author john
 * @since 2023-11-23
 */
interface PaintableData {
    fun getValue(): Int

    fun compareTo(other: PaintableData): Boolean {
        return getValue() >= other.getValue()
    }
}