package training360.guinessapp;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import training360.guinessapp.dto.BeatWorldRecordCommand;
import training360.guinessapp.dto.BeatWorldRecordDto;
import training360.guinessapp.dto.WorldRecordCreateCommand;
import training360.guinessapp.dto.WorldRecordDto;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/worldrecords")
@Tag(name = "Operations on world records")
@RequiredArgsConstructor
public class WorldRecordController {

    private final WorldRecordService worldRecordService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public WorldRecordDto saveWorldRecord(@Valid @RequestBody WorldRecordCreateCommand command) {
        return worldRecordService.saveWorldRecord(command);
    }

    @PutMapping("/{id}/beatrecords")
    @ResponseStatus(HttpStatus.OK)
    public BeatWorldRecordDto beatWorldRecord(
            @PathVariable("id")Long id, @Valid @RequestBody BeatWorldRecordCommand command){
        return worldRecordService.beatWorldRecord(id,command);

    }
}
