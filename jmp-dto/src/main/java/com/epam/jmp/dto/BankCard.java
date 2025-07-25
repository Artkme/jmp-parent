package com.epam.jmp.dto;

import java.util.Objects;
import java.util.concurrent.ThreadLocalRandom;

public class BankCard {
    private String number;
    private User user;

    public BankCard(String number, User user) {
        this.number = number;
        this.user = user;
    }

    public String getNumber() {
        return number;
    }

    public User getUser() {
        return user;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public static String generateCardNumber() {
        long bound = 10_000_000_000_000_000L;
        ThreadLocalRandom rnd = ThreadLocalRandom.current();
        long raw = rnd.nextLong(bound);
        return String.format("%016d", raw);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BankCard bankCard = (BankCard) o;
        return Objects.equals(number, bankCard.number) && Objects.equals(user, bankCard.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, user);
    }

    @Override
    public String toString() {
        return "BankCard{" +
                "number='" + number + '\'' +
                ", user=" + user +
                '}';
    }
}
