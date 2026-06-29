package Creational_Design_Patterns;

class Computer{
    public String brand;
    public String modelNumber;
    private int RAM;
    private int SSD;
    private boolean hasGPU;
    /*There can be 100 more such components
    * We cannot spend time creating constructor all
    * of these variables
    * */

    private Computer(ComputerBuilder builder){
        this.brand = builder.brand;
        this.modelNumber = builder.modelNumber;
        this.RAM = builder.RAM;
        this.SSD = builder.SSD;
        this.hasGPU = builder.hasGPU;
    }


    public void display() {
        System.out.println("PC specs below: ");
        System.out.println("Brand: " + brand);
        System.out.println("Model Number: " + modelNumber);
        System.out.println("RAM: " + RAM + " GB");
        System.out.println("SSD: " + SSD + " GB");
        System.out.println("Has GPU: " + hasGPU);
    }


    static class ComputerBuilder{
        public String brand;
        public String modelNumber;
        private int RAM= 8; //default
        private int SSD = 256; //default
        private boolean hasGPU;

        public ComputerBuilder(String brand, String modelNumber){
            this.brand = brand;
            this.modelNumber = modelNumber;
        }

        public ComputerBuilder addRAM(int RAM){
            this.RAM = RAM;
            return this;
        }

        public ComputerBuilder addSSD(int SSD){
            this.SSD = SSD;
            return this;
        }

        // Let's say only applicable for gaming pcs
        public ComputerBuilder addGPU(boolean value){
            hasGPU = value;
            return this;
        }

        public Computer build(){
            return new Computer(this);
        }

    }
}


public class builderPattern1 {
    public static void main(String [] args){
        Computer gamingPc = new Computer.ComputerBuilder("HP", "HP2025")
                .addRAM(16)
                .addSSD(1024)
                .addGPU(true)
                .build();

        Computer officePc = new Computer.ComputerBuilder("Lenovo", "L2026")
                .build();

        gamingPc.display();
        System.out.println();
        officePc.display();

    }
}
