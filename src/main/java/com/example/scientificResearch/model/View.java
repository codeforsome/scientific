package com.example.scientificResearch.model;

import java.math.BigInteger;

public class View {
    private BigInteger id;
    private BigInteger thesisId;
    private BigInteger readUserId;

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public BigInteger getThesisId() {
        return thesisId;
    }

    public void setThesisId(BigInteger thesisId) {
        this.thesisId = thesisId;
    }

    public BigInteger getReadUserId() {
        return readUserId;
    }

    public void setReadUserId(BigInteger readUserId) {
        this.readUserId = readUserId;
    }
}
