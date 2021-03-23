package com.GRTeamA.types;


public abstract class TransactionPayload {

    abstract public void serialize(com.GRTeamA.novi.serde.Serializer serializer) throws com.GRTeamA.novi.serde.SerializationError;

    public static TransactionPayload deserialize(com.GRTeamA.novi.serde.Deserializer deserializer) throws com.GRTeamA.novi.serde.DeserializationError {
        int index = deserializer.deserialize_variant_index();
        switch (index) {
            case 1: return Script.load(deserializer);
            default: throw new com.GRTeamA.novi.serde.DeserializationError("Unknown variant index for TransactionPayload: " + index);
        }
    }

    public byte[] bcsSerialize() throws com.GRTeamA.novi.serde.SerializationError {
        com.GRTeamA.novi.serde.Serializer serializer = new com.GRTeamA.novi.bcs.BcsSerializer();
        serialize(serializer);
        return serializer.get_bytes();
    }

    public static TransactionPayload bcsDeserialize(byte[] input) throws com.GRTeamA.novi.serde.DeserializationError {
        if (input == null) {
             throw new com.GRTeamA.novi.serde.DeserializationError("Cannot deserialize null array");
        }
        com.GRTeamA.novi.serde.Deserializer deserializer = new com.GRTeamA.novi.bcs.BcsDeserializer(input);
        TransactionPayload value = deserialize(deserializer);
        if (deserializer.get_buffer_offset() < input.length) {
             throw new com.GRTeamA.novi.serde.DeserializationError("Some input bytes were not read");
        }
        return value;
    }

    public static final class Script extends TransactionPayload {
        public final com.GRTeamA.types.Script value;

        public Script(com.GRTeamA.types.Script value) {
            java.util.Objects.requireNonNull(value, "value must not be null");
            this.value = value;
        }

        public void serialize(com.GRTeamA.novi.serde.Serializer serializer) throws com.GRTeamA.novi.serde.SerializationError {
            serializer.increase_container_depth();
            serializer.serialize_variant_index(1);
            value.serialize(serializer);
            serializer.decrease_container_depth();
        }

        static Script load(com.GRTeamA.novi.serde.Deserializer deserializer) throws com.GRTeamA.novi.serde.DeserializationError {
            deserializer.increase_container_depth();
            Builder builder = new Builder();
            builder.value = com.GRTeamA.types.Script.deserialize(deserializer);
            deserializer.decrease_container_depth();
            return builder.build();
        }

        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null) return false;
            if (getClass() != obj.getClass()) return false;
            Script other = (Script) obj;
            if (!java.util.Objects.equals(this.value, other.value)) { return false; }
            return true;
        }

        public int hashCode() {
            int value = 7;
            value = 31 * value + (this.value != null ? this.value.hashCode() : 0);
            return value;
        }

        public static final class Builder {
            public com.GRTeamA.types.Script value;

            public Script build() {
                return new Script(
                    value
                );
            }
        }
    }
}

