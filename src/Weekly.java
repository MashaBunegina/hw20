import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.TemporalAdjusters;

public class Weekly extends Task implements Repeatable {
    public Weekly(String descriptionTask, String header, boolean dateOfCreation, LocalDateTime tipeTask) {
        super(descriptionTask, header, tipeTask, dateOfCreation);
    }

    LocalTime timeOfRepeat = LocalTime.of(getDateOfCreation().getHour(), getDateOfCreation().getMinute());
    DayOfWeek dayOfWeek = getDateOfCreation().getDayOfWeek();

    @Override
    public String getDescriptionTask() {
        return super.getDescriptionTask();
    }

    @Override
    public void setDescriptionTask(String descriptionTask) {
        super.setDescriptionTask(descriptionTask);
    }

    @Override
    public int getTaskId() {
        return super.getTaskId();
    }

    @Override
    public String getHeader() {
        return super.getHeader();
    }

    @Override
    public void setHeader(String header) {
        super.setHeader(header);
    }

    @Override
    public boolean isTipeTask() {
        return super.isTipeTask();
    }

    @Override
    public void setTipeTask(boolean tipeTask) {
        super.setTipeTask(tipeTask);
    }

    @Override
    public LocalDateTime getDateOfCreation() {
        return super.getDateOfCreation();
    }

    @Override
    public void setDateOfCreation(LocalDateTime dateOfCreation) {
        super.setDateOfCreation(dateOfCreation);
    }

    public Weekly(String descriptionTask, String header, LocalDateTime data, boolean tipeTask) {
        super(descriptionTask, header, data, tipeTask);
    }

    public LocalDateTime getTime() {
        if (getDateOfCreation().isAfter(LocalDateTime.now())) {
            return getDateOfCreation();
        }
        if (dayOfWeek.equals(LocalDate.now().getDayOfWeek()) && timeOfRepeat.isAfter(LocalTime.now())) {
            return LocalDateTime.of(LocalDate.now(), timeOfRepeat);
        }
        return LocalDateTime.of(LocalDate.now().with(TemporalAdjusters.next(dayOfWeek)), timeOfRepeat);
    }

    @Override
    public boolean checkTask(LocalDateTime data) {
        if (getDateOfCreation().isAfter(data)) {
            return false;
        }
        return data.getDayOfWeek().equals(dayOfWeek);
    }

}