package com.example.project_impl;

public class model {
    String Amount;
    String Description;
    String Location;
    String Receipt;

    String debt_Amount;
    String debt_Description;
    String Date;
    String debt_Receipt;


    String Username;
    String User_name;
    String Email;
    String Address;
    String Phone_number;
    String Priority;
    String Type;

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    public model(String type) {
        Type = type;
    }

    public String getPriority() {
        return Priority;
    }

    public void setPriority(String priority) {
        Priority = priority;
    }

    public String getRecurring_Status() {
        return Recurring_Status;
    }

    public void setRecurring_Status(String recurring_Status) {
        Recurring_Status = recurring_Status;
    }

    public model(String priority, String recurring_Status) {
        Priority = priority;
        Recurring_Status = recurring_Status;
    }

    String Recurring_Status;

    public String getDebt_Amount() {
        return debt_Amount;
    }

    public void setDebt_Amount(String debt_Amount) {
        this.debt_Amount = debt_Amount;
    }

    public String getDebt_Description() {
        return debt_Description;
    }

    public void setDebt_Description(String debt_Description) {
        this.debt_Description = debt_Description;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public String getDebt_Receipt() {
        return debt_Receipt;
    }

    public void setDebt_Receipt(String debt_Receipt) {
        this.debt_Receipt = debt_Receipt;
    }



    public model(String debt_Amount, String debt_Description, String date, String debt_Receipt) {
        this.debt_Amount = debt_Amount;
        this.debt_Description = debt_Description;
        Date = date;
        this.debt_Receipt = debt_Receipt;
    }

    public model(String amount, String description, String location, String receipt, String username, String user_name, String email, String address, String phone_number, String amountid) {
        Amount = amount;
        Description = description;
        Location = location;
        Receipt = receipt;
        Username = username;
        User_name=user_name;
        Email = email;
        Address = address;
        Phone_number = phone_number;
        Amountid = amountid;
    }

    public String getAmount() {
        return Amount;
    }

    public void setAmount(String amount) {
        Amount = amount;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getLocation() {
        return Location;
    }

    public void setLocation(String location) {
        Location = location;
    }

    public String getUser_name() {
        return User_name;
    }

    public void setUser_name(String user_name) {
        User_name = user_name;
    }

    public String getReceipt() {
        return Receipt;
    }

    public void setReceipt(String receipt) {
        Receipt = receipt;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getPhone_number() {
        return Phone_number;
    }

    public void setPhone_number(String phone_number) {
        Phone_number = phone_number;
    }

    public String getAmountid() {
        return Amountid;
    }

    public void setAmountid(String amountid) {
        Amountid = amountid;
    }



    public model(){

    }


    String Amountid;
}

