package com.GRTeamA.types;



final class TraitHelpers {
    static void serialize_array16_u8_array(java.util.@com.GRTeamA.novi.serde.ArrayLen(length=16) List<@com.GRTeamA.novi.serde.Unsigned Byte> value, com.GRTeamA.novi.serde.Serializer serializer) throws com.GRTeamA.novi.serde.SerializationError {
        if (value.size() != 16) {
            throw new IllegalArgumentException("Invalid length for fixed-size array: " + value.size() + " instead of "+ 16);
        }
        for (@com.GRTeamA.novi.serde.Unsigned Byte item : value) {
            serializer.serialize_u8(item);
        }
    }

    static java.util.@com.GRTeamA.novi.serde.ArrayLen(length=16) List<@com.GRTeamA.novi.serde.Unsigned Byte> deserialize_array16_u8_array(com.GRTeamA.novi.serde.Deserializer deserializer) throws com.GRTeamA.novi.serde.DeserializationError {
        java.util.List<@com.GRTeamA.novi.serde.Unsigned Byte> obj = new java.util.ArrayList<@com.GRTeamA.novi.serde.Unsigned Byte>(16);
        for (long i = 0; i < 16; i++) {
            obj.add(deserializer.deserialize_u8());
        }
        return obj;
    }

    static void serialize_vector_TypeTag(java.util.List<TypeTag> value, com.GRTeamA.novi.serde.Serializer serializer) throws com.GRTeamA.novi.serde.SerializationError {
        serializer.serialize_len(value.size());
        for (TypeTag item : value) {
            item.serialize(serializer);
        }
    }

    static java.util.List<TypeTag> deserialize_vector_TypeTag(com.GRTeamA.novi.serde.Deserializer deserializer) throws com.GRTeamA.novi.serde.DeserializationError {
        long length = deserializer.deserialize_len();
        java.util.List<TypeTag> obj = new java.util.ArrayList<TypeTag>((int) length);
        for (long i = 0; i < length; i++) {
            obj.add(TypeTag.deserialize(deserializer));
        }
        return obj;
    }

    static void serialize_vector_TransactionArgument(java.util.List<TransactionArgument> value, com.GRTeamA.novi.serde.Serializer serializer) throws com.GRTeamA.novi.serde.SerializationError {
        serializer.serialize_len(value.size());
        for (TransactionArgument item : value) {
            item.serialize(serializer);
        }
    }

    static java.util.List<TransactionArgument> deserialize_vector_TransactionArgument(com.GRTeamA.novi.serde.Deserializer deserializer) throws com.GRTeamA.novi.serde.DeserializationError {
        long length = deserializer.deserialize_len();
        java.util.List<TransactionArgument> obj = new java.util.ArrayList<TransactionArgument>((int) length);
        for (long i = 0; i < length; i++) {
            obj.add(TransactionArgument.deserialize(deserializer));
        }
        return obj;
    }
}

