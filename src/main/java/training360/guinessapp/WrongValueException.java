package training360.guinessapp;

import org.zalando.problem.AbstractThrowableProblem;
import org.zalando.problem.Status;


import java.net.URI;

public class WrongValueException extends AbstractThrowableProblem {


    public WrongValueException(Double value, Double newRecordValue) {


        super(URI.create("world-record/wrong-value"),
                "Can not beat",
                Status.BAD_REQUEST,
                String.format("Can not beat if value larger than new record value ", value, newRecordValue));

    }
}
