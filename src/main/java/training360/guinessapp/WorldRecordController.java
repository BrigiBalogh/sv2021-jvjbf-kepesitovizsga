package training360.guinessapp;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import training360.guinessapp.dto.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/worldrecords")
@Tag(name = "Operations on world records")
@RequiredArgsConstructor
public class WorldRecordController {

    private final WorldRecordService worldRecordService;



    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Creates a world record", description = " New  world record has been created.")
    @ApiResponse(responseCode = "201", description = " world record  is  create")
    @ApiResponse(responseCode = "400", description = " world record  is validation exception ")
    public WorldRecordDto saveWorldRecord(@Valid @RequestBody WorldRecordCreateCommand command) {
        return worldRecordService.saveWorldRecord(command);
    }


    @PutMapping("/{id}/beatrecords}")
    @Operation(summary = "update a world record", description = " New world record  has been update.")
    @ApiResponse(responseCode = "404", description = "world record not found by id")
    @ApiResponse(responseCode = "400", description = "world record  is validation exception ")
    public BeatWorldRecordDto beatWorldRecord(
            @PathVariable("id") Long id,
            @Valid @RequestBody BeatWorldRecordCommand command) {
        return worldRecordService.beatWorldRecord(id, command);
    }

}

