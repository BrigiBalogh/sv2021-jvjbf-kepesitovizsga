package training360.guinessapp;

import org.zalando.problem.AbstractThrowableProblem;
import org.zalando.problem.Status;

import java.net.URI;

public class WrongValueException extends AbstractThrowableProblem {

    public WrongValueException(Double newRecordValue, Double value) {

        super(URI.create("world-record/wrong-value"),
                "Can not beat",
                Status.BAD_REQUEST,
                String.format("Can not beat if value '%f' larger than new record value '%f'",
                        newRecordValue, value));
    }
}
