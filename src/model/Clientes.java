
package model;


public class Clientes {
    private int customerNumber;
    private String custormeName;
    private String contactLastName;
    private String contactFistName;
    private String phone;
    private String addressline1;
    private String addressline2;
    private String city;
    private String state;
    private String postalCode;
    private String country;
    private int salesRepEmployeeNumber;
    private double creditLimit;

    public Clientes() {
    }

    public Clientes(int customerNumber, String custormeName, String contactLastName, String contactFistName, String phone, String addressline1, String addressline2, String city, String state, String postalCode, String country, int salesRepEmployeeNumber, double creditLimit) {
        this.customerNumber = customerNumber;
        this.custormeName = custormeName;
        this.contactLastName = contactLastName;
        this.contactFistName = contactFistName;
        this.phone = phone;
        this.addressline1 = addressline1;
        this.addressline2 = addressline2;
        this.city = city;
        this.state = state;
        this.postalCode = postalCode;
        this.country = country;
        this.salesRepEmployeeNumber = salesRepEmployeeNumber;
        this.creditLimit = creditLimit;
    }

    public double getCreditLimit() {
        return creditLimit;
    }

    public void setCreditLimit(double creditLimit) {
        this.creditLimit = creditLimit;
    }

    public int getCustomerNumber() {
        return customerNumber;
    }

    public void setCustomerNumber(int customerNumber) {
        this.customerNumber = customerNumber;
    }

    public String getCustormeName() {
        return custormeName;
    }

    public void setCustormeName(String custormeName) {
        this.custormeName = custormeName;
    }

    public String getContactLastName() {
        return contactLastName;
    }

    public void setContactLastName(String contactLastName) {
        this.contactLastName = contactLastName;
    }

    public String getContactFistName() {
        return contactFistName;
    }

    public void setContactFistName(String contactFistName) {
        this.contactFistName = contactFistName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddressline1() {
        return addressline1;
    }

    public void setAddressline1(String addressline1) {
        this.addressline1 = addressline1;
    }

    public String getAddressline2() {
        return addressline2;
    }

    public void setAddressline2(String addressline2) {
        this.addressline2 = addressline2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getSalesRepEmployeeNumber() {
        return salesRepEmployeeNumber;
    }

    public void setSalesRepEmployeeNumber(int salesRepEmployeeNumber) {
        this.salesRepEmployeeNumber = salesRepEmployeeNumber;
    }

    @Override
    public String toString() {
        return "Clientes{" + "customerNumber=" + customerNumber + ", custormeName=" + custormeName + ", contactLastName=" + contactLastName + ", contactFistName=" + contactFistName + ", phone=" + phone + ", addressline1=" + addressline1 + ", addressline2=" + addressline2 + ", city=" + city + ", state=" + state + ", postalCode=" + postalCode + ", country=" + country + ", salesRepEmployeeNumber=" + salesRepEmployeeNumber + ", creditLimit=" + creditLimit + '}';
    }
            
}
