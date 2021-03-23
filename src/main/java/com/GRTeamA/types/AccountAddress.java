package com.GRTeamA.types;


import com.GRTeamA.novi.serde.SerializationError;
import com.GRTeamA.novi.serde.Serializer;

public final class AccountAddress {
    public final java.util.@com.GRTeamA.novi.serde.ArrayLen(length=16) List<@com.GRTeamA.novi.serde.Unsigned Byte> value;

    public AccountAddress(java.util.@com.GRTeamA.novi.serde.ArrayLen(length=16) List<@com.GRTeamA.novi.serde.Unsigned Byte> value) {
        java.util.Objects.requireNonNull(value, "value must not be null");
        this.value = value;
    }

    public void serialize(Serializer serializer) throws SerializationError {
        serializer.increase_container_depth();
        TraitHelpers.serialize_array16_u8_array(value, serializer);
        serializer.decrease_container_depth();
    }

    public byte[] bcsSerialize() throws SerializationError {
        Serializer serializer = new com.GRTeamA.novi.bcs.BcsSerializer();
        serialize(serializer);
        return serializer.get_bytes();
    }

    public static AccountAddress deserialize(com.GRTeamA.novi.serde.Deserializer deserializer) throws com.GRTeamA.novi.serde.DeserializationError {
        deserializer.increase_container_depth();
        Builder builder = new Builder();
        builder.value = TraitHelpers.deserialize_array16_u8_array(deserializer);
        deserializer.decrease_container_depth();
        return builder.build();
    }

    public static AccountAddress bcsDeserialize(byte[] input) throws com.GRTeamA.novi.serde.DeserializationError {
        if (input == null) {
             throw new com.GRTeamA.novi.serde.DeserializationError("Cannot deserialize null array");
        }
        com.GRTeamA.novi.serde.Deserializer deserializer = new com.GRTeamA.novi.bcs.BcsDeserializer(input);
        AccountAddress value = deserialize(deserializer);
        if (deserializer.get_buffer_offset() < input.length) {
             throw new com.GRTeamA.novi.serde.DeserializationError("Some input bytes were not read");
        }
        return value;
    }

    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        AccountAddress other = (AccountAddress) obj;
        if (!java.util.Objects.equals(this.value, other.value)) { return false; }
        return true;
    }

    public int hashCode() {
        int value = 7;
        value = 31 * value + (this.value != null ? this.value.hashCode() : 0);
        return value;
    }

    public static final class Builder {
        public java.util.@com.GRTeamA.novi.serde.ArrayLen(length=16) List<@com.GRTeamA.novi.serde.Unsigned Byte> value;

        public AccountAddress build() {
            return new AccountAddress(
                value
            );
        }
    }
}
