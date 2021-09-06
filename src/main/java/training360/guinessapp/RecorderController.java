package training360.guinessapp;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import training360.guinessapp.dto.RecorderCreateCommand;
import training360.guinessapp.dto.RecorderDto;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/recorders")
@Tag(name = "Operations on recorder")
@RequiredArgsConstructor
public class RecorderController {

    private final RecorderService recorderService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Creates a recorder", description = " New recorder has been created.")
    @ApiResponse(responseCode = "201", description = "recorder  is  create")
    @ApiResponse(responseCode = "400", description = "recorder  is validation exception ")
    public RecorderDto createRecorder(@Valid @RequestBody RecorderCreateCommand command) {
        return recorderService.createRecorder(command);
    }



}
