package training360.guinessapp;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import training360.guinessapp.dto.RecorderCreateCommand;
import training360.guinessapp.dto.RecorderDto;


@Service
@AllArgsConstructor
public class RecorderService {


    private final ModelMapper mapper;

    private final RecorderRepository recorderRepository;

    public RecorderDto createRecorder(RecorderCreateCommand command) {

        Recorder recorder = new Recorder(command.getName(), command.getDateOfBirth());
        recorderRepository.save(recorder);
        return mapper.map(recorder, RecorderDto.class);
    }
}
