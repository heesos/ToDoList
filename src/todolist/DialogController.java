package todolist;

import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import todolist.datamodel.TodoData;
import todolist.datamodel.TodoItem;

import java.time.LocalDate;

public class DialogController {

    @FXML
    private TextField shortDescriptionField;
    @FXML
    private TextArea detailsArea;
    @FXML
    private DatePicker deadline;

    public TodoItem processResults() {
        String shortDescription = shortDescriptionField.getText().trim();
        String details = detailsArea.getText().trim();
        LocalDate deadlineValue = deadline.getValue();

        TodoItem newItem = new TodoItem(shortDescription,details,deadlineValue);
        TodoData.getInstance().setTodoItem(newItem);
        return newItem;
    }

    public void setEditItem(TodoItem item) {
        shortDescriptionField.setText(item.getShortDescription());
        detailsArea.setText(item.getDetails());
        deadline.setValue(item.getDeadLine());
    }

    public void editItem(TodoItem item) {
        TodoItem newItem = new TodoItem(shortDescriptionField.getText(),
                                        detailsArea.getText(),
                                        deadline.getValue());
        TodoData.getInstance().setTodoItem(TodoData.getInstance().getTodoItemIndex(item),newItem);
    }
}
