package com.implementation.model.abstractions;

import java.time.LocalDate;

public interface Expirable{
    public boolean  isExpired();
    public void setExpirationDate(LocalDate exDate);
    public LocalDate getExpirationDate();
}
