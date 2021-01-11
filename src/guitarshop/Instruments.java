package guitarshop;

public class Instruments {
    
    private String Instrument;
    private String type;
    private String manufacturer;
    private String colour;
    private int numberOfStringsKeysEtc;
    private int stock;
    private double cost;
    private String ProductCode;
    private int reserves;

    public Instruments(String Instrument) {
        this(Instrument, "Unknown", "Unknown", "Unknown", 0, 0, 0, "0",0);
    }
    

    public Instruments(String Instrument, String type, String manufacturer, String colour, int numberOfStringsKeysEtc, int stock, double cost, String code, int reserves) {
        this.Instrument = Instrument;
        this.type = type;
        this.manufacturer = manufacturer;
        this.colour = colour;
        this.numberOfStringsKeysEtc = numberOfStringsKeysEtc;
        this.stock = stock;
        this.cost = cost;
        this.ProductCode = code;
        this.reserves = reserves;
    }

    public int getReserves() {
        return reserves;
    }

    public void setReserves(int reserves) {
        this.reserves = reserves;
    }

    public String getProductCode() {
        return ProductCode;
    }

    public void setProductCode(String ProductCode) {
        this.ProductCode = ProductCode;
    }

    public String getInstrument() {
        return Instrument;
    }

    public void setInstrument(String Instrument) {
        this.Instrument = Instrument;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public int getNumberOfStringsKeysEtc() {
        return numberOfStringsKeysEtc;
    }

    public void setNumberOfStringsKeysEtc(int numberOfStringsKeysEtc) {
        this.numberOfStringsKeysEtc = numberOfStringsKeysEtc;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "Instrument = " + Instrument + ", Type = " + type + ", Manufacturer = " + manufacturer + ", Colour = " + colour + ", No. Of Strings/Keys = " + numberOfStringsKeysEtc + ", Stock = " + stock + ", Reservations = " + reserves+", Cost = £" + cost + ", Product Code = " + ProductCode;
    } 
}
