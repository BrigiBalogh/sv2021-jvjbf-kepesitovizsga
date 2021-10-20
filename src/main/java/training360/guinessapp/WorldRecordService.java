package training360.guinessapp;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import training360.guinessapp.dto.BeatWorldRecordCommand;
import training360.guinessapp.dto.BeatWorldRecordDto;
import training360.guinessapp.dto.WorldRecordCreateCommand;
import training360.guinessapp.dto.WorldRecordDto;

@Service
@AllArgsConstructor
public class WorldRecordService {

    private final ModelMapper mapper;
    private final WorldRecordRepository worldRecordRepository;
    private final RecorderService recorderService;


    public WorldRecordDto saveWorldRecord(WorldRecordCreateCommand command) {
        Recorder recorder = recorderService.findById(command.getRecorderId());
        WorldRecord worldRecord =worldRecordRepository.save(
                new WorldRecord(command.getDescription(), command.getValue(),
                command.getUnitOfMeasure(), command.getDateOfRecord(),recorder));
        return mapper.map(worldRecord, WorldRecordDto.class);
    }

    @Transactional
    public BeatWorldRecordDto beatWorldRecord(Long id, BeatWorldRecordCommand command) {
        Recorder newRecorder = recorderService.findById(command.getNewRecorderId());
        WorldRecord oldWorldRecord = findById(id);

        if(command.getNewRecordValue() < oldWorldRecord.getValue()){
            throw new WrongValueException(command.getNewRecordValue(), oldWorldRecord.getValue());
        }

        Double difference =command.getNewRecordValue() - oldWorldRecord.getValue();
        BeatWorldRecordDto beatWorldRecordDto = new BeatWorldRecordDto(
                oldWorldRecord.getDescription(), oldWorldRecord.getUnitOfMeasure(),
                oldWorldRecord.getRecorder().getName(), oldWorldRecord.getValue(),
                newRecorder.getName(), command.getNewRecordValue(),difference );
        return beatWorldRecordDto;
    }

    private WorldRecord findById(Long id) {
        return worldRecordRepository.findById(id)
                .orElseThrow(() -> new WorldRecordNotFoundException(id));
    }

}
