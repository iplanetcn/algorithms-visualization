import sort.SortType
import java.awt.FlowLayout
import java.awt.event.ActionListener
import javax.swing.ButtonGroup
import javax.swing.JButton
import javax.swing.JPanel
import javax.swing.JRadioButton

class ActionPanel(listener: ActionsListener): JPanel(FlowLayout()) {

    init {
        val buttonGroup = ButtonGroup()
        val actionListener = ActionListener { e -> listener.onSortTypeChanged(SortType.valueOf(e.actionCommand)) }
        SortType.entries.toTypedArray().forEach { sort ->
            val radioButton = JRadioButton(sort.name)
            radioButton.addActionListener(actionListener)
            buttonGroup.add(radioButton)
            add(radioButton)
            if (sort == SortType.Bubble) {
                radioButton.isSelected = true
            }
        }

        val runButton = JButton("Run")
        val pauseButton = JButton("Pause")
        runButton.addActionListener { listener.onStateChanged(State.Run) }
        pauseButton.addActionListener { listener.onStateChanged(State.Pause) }
        add(runButton)
        add(pauseButton)
    }

}

interface ActionsListener {
    fun onSortTypeChanged(sortType: SortType)
    fun onStateChanged(state: State)
}