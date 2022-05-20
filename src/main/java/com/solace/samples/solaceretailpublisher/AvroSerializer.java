package com.solace.samples.solaceretailpublisher;

import com.solace.sample.Order;
import org.apache.avro.io.DatumWriter;
import org.apache.avro.io.Encoder;
import org.apache.avro.io.EncoderFactory;
import org.apache.avro.specific.SpecificDatumWriter;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class AvroSerializer {
    public byte[] serializeAvroOrderJSON(
            Order request) {

        DatumWriter<Order> writer = new SpecificDatumWriter<>(
                Order.class);
        byte[] data = new byte[0];
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        Encoder jsonEncoder = null;
        try {
            jsonEncoder = EncoderFactory.get().jsonEncoder(
                    Order.getClassSchema(), stream);
            writer.write(request, jsonEncoder);
            jsonEncoder.flush();
            data = stream.toByteArray();
        } catch (IOException e) {
            System.out.println("Serialization error:" + e.getMessage());
        }
        return data;
    }

    public byte[] serializeAvroOrderBinary(Order request) {
        DatumWriter<Order> writer = new SpecificDatumWriter<>(Order.class);
        byte[] data = new byte[0];
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        Encoder jsonEncoder = EncoderFactory.get()
                .binaryEncoder(stream, null);
        try {
            writer.write(request, jsonEncoder);
            jsonEncoder.flush();
            data = stream.toByteArray();
        } catch (IOException e) {
            System.out.println("Serialization error " + e.getMessage());
        }

        return data;
    }
}
