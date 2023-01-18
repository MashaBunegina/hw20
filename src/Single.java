import java.time.LocalDateTime;

public class Single extends Task implements Repeatable {

    @Override
    public int getTaskId() {
        return super.getTaskId();
    }

    @Override
    public String getHeader() {
        return super.getHeader();
    }

    public Single(String descriptionTask, String header, boolean dateOfCreation, LocalDateTime tipeTask) {
        super(descriptionTask, header, tipeTask, dateOfCreation);

    }

    @Override
    public void setDescriptionTask(String descriptionTask) {
        super.setDescriptionTask(descriptionTask);
    }

    @Override
    public LocalDateTime getDateOfCreation() {
        return super.getDateOfCreation();
    }

    public LocalDateTime getTime() {
        return getDateOfCreation();
    }

    @Override
    public String getDescriptionTask() {
        return super.getDescriptionTask();
    }

    public boolean checkTask(LocalDateTime data) {
        return getDateOfCreation().equals(data);
    }
}