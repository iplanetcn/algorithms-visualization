import sort.SortType
import java.awt.FlowLayout
import java.awt.event.ActionEvent
import java.awt.event.ActionListener
import javax.swing.ButtonGroup
import javax.swing.JButton
import javax.swing.JPanel
import javax.swing.JRadioButton

class ActionPanel(actionsListener: ActionsListener): JPanel(FlowLayout()) {

    init {
        var buttonGroup = ButtonGroup()
        val actionListener = object: ActionListener {
            override fun actionPerformed(e: ActionEvent) {
                actionsListener.onSortTypeChanged(SortType.valueOf(e.actionCommand))
            }

        }
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
        runButton.addActionListener(object : ActionListener {
            override fun actionPerformed(e: ActionEvent?) {
                actionsListener.onStateChanged(State.Run)
            }
        })

        pauseButton.addActionListener(object : ActionListener {
            override fun actionPerformed(e: ActionEvent?) {
                actionsListener.onStateChanged(State.Pause)
            }
        })
        add(runButton)
    }

}

interface ActionsListener {
    fun onSortTypeChanged(sortType: SortType)
    fun onStateChanged(state: State)
}