package com.example.demo.Modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;


@Entity
@Table(name = "products")
public class Products {



@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name = "product_id")
private Long productId;
@Column(name = "product_name")
private String productName;
@Column(name = "description")
private String description;
@Column(name = "category")
private String category;
@Column(name = "price")
private double price;
@Column(name = "quantity_available")
private int quantityAvailable;
@Column(name = "status")
private String status;

@Column(name = "image") 
@Lob
private byte[] productImage;


public Long getproductid(){
    return this.productId;
}

public void setproductid(Long productId){
        this.productId=productId;
}

public String getproductName(){
    return this.productName;
}
    
public void setgetproductname(String productName){
    this.productName=productName;        
}

public String getdescription(){
    return this.description;
}

public void setdescription(String description){
    this.description=description;
}

public String getcategory(){
    return this.category;
}

public void setcategory(String category){
    this.category=category;
}

    public double getprice(){
    return this.price;
}

public void setprice(double price){
    this.price=price;
}

    public int getquantityAvailable(){
    return this.quantityAvailable;
}

public void setguantityAvailable(int quantityAvailable){
    this.quantityAvailable=quantityAvailable;
}

    
    public String getstatus(){
    return this.status;
}


    public void setstatus(String status){
    this.status=status;
}
 

public byte[] getProductImage() {
    return this.productImage;
}

public void setProductImage(byte[] productImage) {
    this.productImage = productImage;
}

}
