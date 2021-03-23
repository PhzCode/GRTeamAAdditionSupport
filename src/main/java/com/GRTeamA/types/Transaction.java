package com.GRTeamA.types;


public abstract class Transaction {

    abstract public void serialize(com.GRTeamA.novi.serde.Serializer serializer) throws com.GRTeamA.novi.serde.SerializationError;

    public byte[] bcsSerialize() throws com.GRTeamA.novi.serde.SerializationError {
        com.GRTeamA.novi.serde.Serializer serializer = new com.GRTeamA.novi.bcs.BcsSerializer();
        serialize(serializer);
        return serializer.get_bytes();
    }
}

