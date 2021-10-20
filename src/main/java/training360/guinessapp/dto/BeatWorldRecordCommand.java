package training360.guinessapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BeatWorldRecordCommand {

    @NotNull(message = "must not be null")
    private Long newRecorderId;

    @NotNull(message = "must not be null")
    private Double newRecordValue;
}
