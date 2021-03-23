package com.GRTeamA.types;


public final class Ed25519PublicKey {
    public final com.GRTeamA.novi.serde.Bytes value;

    public Ed25519PublicKey(com.GRTeamA.novi.serde.Bytes value) {
        java.util.Objects.requireNonNull(value, "value must not be null");
        this.value = value;
    }

    public void serialize(com.GRTeamA.novi.serde.Serializer serializer) throws com.GRTeamA.novi.serde.SerializationError {
        serializer.increase_container_depth();
        serializer.serialize_bytes(value);
        serializer.decrease_container_depth();
    }

    public byte[] bcsSerialize() throws com.GRTeamA.novi.serde.SerializationError {
        com.GRTeamA.novi.serde.Serializer serializer = new com.GRTeamA.novi.bcs.BcsSerializer();
        serialize(serializer);
        return serializer.get_bytes();
    }

    public static Ed25519PublicKey deserialize(com.GRTeamA.novi.serde.Deserializer deserializer) throws com.GRTeamA.novi.serde.DeserializationError {
        deserializer.increase_container_depth();
        Builder builder = new Builder();
        builder.value = deserializer.deserialize_bytes();
        deserializer.decrease_container_depth();
        return builder.build();
    }

    public static Ed25519PublicKey bcsDeserialize(byte[] input) throws com.GRTeamA.novi.serde.DeserializationError {
        if (input == null) {
             throw new com.GRTeamA.novi.serde.DeserializationError("Cannot deserialize null array");
        }
        com.GRTeamA.novi.serde.Deserializer deserializer = new com.GRTeamA.novi.bcs.BcsDeserializer(input);
        Ed25519PublicKey value = deserialize(deserializer);
        if (deserializer.get_buffer_offset() < input.length) {
             throw new com.GRTeamA.novi.serde.DeserializationError("Some input bytes were not read");
        }
        return value;
    }

    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        Ed25519PublicKey other = (Ed25519PublicKey) obj;
        if (!java.util.Objects.equals(this.value, other.value)) { return false; }
        return true;
    }

    public int hashCode() {
        int value = 7;
        value = 31 * value + (this.value != null ? this.value.hashCode() : 0);
        return value;
    }

    public static final class Builder {
        public com.GRTeamA.novi.serde.Bytes value;

        public Ed25519PublicKey build() {
            return new Ed25519PublicKey(
                value
            );
        }
    }
}
