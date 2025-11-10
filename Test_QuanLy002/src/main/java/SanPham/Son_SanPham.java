package SanPham;

public class Son_SanPham extends Father_SanPham{
    private String maker, CPU, RAM, storage, cardGraphic;

    public Son_SanPham(String maker, String CPU, long giaSP, int sluong, String RAM, String storage, String cardGraphic, String id, String tenSP) {
        super(id, tenSP, giaSP, sluong);
        this.maker = maker;
        this.CPU = CPU;
        this.RAM = RAM;
        this.storage = storage;
        this.cardGraphic = cardGraphic;
    }

    public String getMaker() {return maker;}
    public String getCPU() {return CPU;}
    public String getRAM() {return RAM;}
    public String getStorage() {return storage;}
    public String getCardGraphic() {return cardGraphic;}

    public void setMaker(String maker) {this.maker = maker;}
    public void setCPU(String CPU) {this.CPU = CPU;}
    public void setRAM(String RAM) {this.RAM = RAM;}
    public void setStorage(String storage) {this.storage = storage;}
    public void setCardGraphic(String cardGraphic) {this.cardGraphic = cardGraphic;}

    @Override
    public String toString() {
        return "Son_SanPham{" + 
               "ThongTinCha=" + super.toString() +
               ", maker=" + maker + 
               ", CPU=" + CPU + 
               ", RAM=" + RAM + 
               ", storage=" + storage + 
               ", cardGraphic=" + cardGraphic + 
               '}';
    } 
}
