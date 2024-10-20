class SmartTV extends ColorTV {
    private String ipAddress;

    public SmartTV(String ipAddress, int size, int colors) {
        super(size, colors);
        this.ipAddress = ipAddress;
    }

    @Override
    public void printProperty() {
        System.out.println("나의 Smart TV는 " + ipAddress + " 주소의 " + getSize() + "인치 " + colors + "컬러");
    }

    public static void main(String[] args) {
        SmartTV smartTV = new SmartTV("192.168.0.5", 77, 20000000);
        smartTV.printProperty();
    }
}
