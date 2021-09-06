package training360.guinessapp;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import training360.guinessapp.dto.RecorderDto;
import training360.guinessapp.dto.WorldRecordCreateCommand;
import training360.guinessapp.dto.WorldRecordDto;

@Service
@AllArgsConstructor
public class WorldRecordService {

    private final ModelMapper mapper;

    private final WorldRecordRepository worldRecordRepository;

    public WorldRecordDto createWorldRecord(WorldRecordCreateCommand command) {

        WorldRecord worldRecord = new WorldRecord(command.getDescription(), command.getValue(),
                command.getUnitOfMeasure(), command.getRecorderName());
        worldRecordRepository.save(worldRecord);
        return mapper.map(worldRecord, WorldRecord.class);
    }

