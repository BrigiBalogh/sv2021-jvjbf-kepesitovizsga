package training360.guinessapp;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import training360.guinessapp.dto.RecorderCreateCommand;
import training360.guinessapp.dto.RecorderDto;
import training360.guinessapp.dto.RecorderShortDto;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/recorders")
@RequiredArgsConstructor
@Tag(name = "Operations on recorders")
public class RecorderController {

    private final RecorderService recorderService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public RecorderDto saveRecorder(@Valid @RequestBody RecorderCreateCommand command) {
        return recorderService.saveRecorder(command);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<RecorderShortDto> listCertainRecorders() {
        return recorderService.listCertainRecorders();
    }
}
