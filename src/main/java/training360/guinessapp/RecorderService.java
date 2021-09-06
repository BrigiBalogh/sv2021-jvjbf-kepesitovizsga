package training360.guinessapp;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import training360.guinessapp.dto.RecorderCreateCommand;
import training360.guinessapp.dto.RecorderDto;
import training360.guinessapp.dto.RecorderShortDto;

import java.util.List;


@Service
@AllArgsConstructor
public class RecorderService {


    private final ModelMapper mapper;

    private final RecorderRepository recorderRepository;

    public RecorderDto saveRecorder(RecorderCreateCommand command) {

        Recorder recorder = new Recorder(command.getName(), command.getDateOfBirth());
        recorderRepository.save(recorder);
        return mapper.map(recorder, RecorderDto.class);
    }

    public Recorder findById(Long id) {
        return recorderRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(id));

    }

    public List<RecorderShortDto> getRecorders() {
        List<Recorder> recorders = recorderRepository.getFilteredRecorders();
        return recorders.stream().map(recorder -> mapper.map(recorder, RecorderShortDto.class))
                .toList();
    }
}
