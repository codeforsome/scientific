package com.example.scientificResearch.model;

import java.math.BigInteger;

public class Collect {
    private BigInteger id;
    private BigInteger thesisId;
    private BigInteger collectUsreId;

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

    public BigInteger getCollectUsreId() {
        return collectUsreId;
    }

    public void setCollectUsreId(BigInteger collectUsreId) {
        this.collectUsreId = collectUsreId;
    }
}
