/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

public class InforProduct extends Product{
    public String maker, CPU, RAM, storage, cardGraphic;

    public InforProduct(String maker, String CPU, String RAM, String storage, String cardGraphic, String id, String name, long cost, int quantidy) {
        super(id, name, cost, quantidy);
        this.maker = maker;
        this.CPU = CPU;
        this.RAM = RAM;
        this.storage = storage;
        this.cardGraphic = cardGraphic;
    }
    
    
}
