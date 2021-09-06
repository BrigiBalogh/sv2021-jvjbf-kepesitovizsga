package training360.guinessapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BeatWorldRecordCommand {

    @NotNull(message = "Recorder not found")
    private Long newRecorderId;

    @NotNull(message = "World record not found")
    private Double newRecordValue;


}
