package me.karun.spikes;

import me.karun.spikes.model.TemperaturePayload;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.integration.annotation.Transformer;

@EnableBinding(Processor.class)
public class TemperatureProcessor {

  @Transformer(inputChannel = Processor.INPUT, outputChannel = Processor.OUTPUT)
  public double convertUnits(final TemperaturePayload payload) {
    System.out.println("payload = " + payload);

    return payload.getUnit().conversion.apply(payload.getValue());
  }
}
