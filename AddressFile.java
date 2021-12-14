import java.io.RandomAccessFile;
import java.io.IOException;


/********** AddressFile ***********/

class AddressFile extends RandomAccessFile {

    public AddressFile() throws IOException {
        super("address.dat", "rw");
    }
    
    /** Write an address to file */
    public void writeAddress(Address address) {
        try {
            this.seek(this.getFilePointer() - 176L);
            this.writeFixedLengthString(address.getName(), 32);
            this.writeFixedLengthString(address.getStreet(), 32);
            this.writeFixedLengthString(address.getCity(), 20);
            this.writeFixedLengthString(address.getState(), 2);
            this.writeInt(address.getZip());
        }
        catch (IOException var3) {
            System.out.println(var3.getMessage());
        }

    }

    /** Read the address from the file */
    public Address readAddress() {
        try {
            Address address = new Address();
            address.setName(this.readFixedLengthString(32));
            address.setStreet(this.readFixedLengthString(32));
            address.setCity(this.readFixedLengthString(20));
            address.setState(this.readFixedLengthString(2));
            address.setZip(this.readInt());
            return address;
        }
        catch (IOException var2) {
            return null;
        }
    }
    
    // Adding Address
    public void addAddress(Address address) {
        try {
            this.seek(this.length());
            this.writeFixedLengthString(address.getName(), 32);
            this.writeFixedLengthString(address.getStreet(), 32);
            this.writeFixedLengthString(address.getCity(), 20);
            this.writeFixedLengthString(address.getState(), 2);
            this.writeInt(address.getZip());
        }
        catch (IOException var3) {
            System.out.println(var3.getMessage());
        }

    }
    
    /** Read the first address from the file */
    public Address firstAddress() {
        try {
            this.seek(0L);
            return this.readAddress();
        } catch (IOException var2) {
            return null;
        }
    }
    
    /** Read last next Address from the file */
    public Address lastAddress() {
        try {
            this.seek(this.length() - 176L);
            return this.readAddress();
        }
        catch (IOException var2) {
            return null;
        }
    }

    // Reading the input as String
    private String readFixedLengthString(int length) throws IOException {
        char[] chars = new char[length];

        for(int i = 0; i < length; ++i) {
            chars[i] = this.readChar();
        }

        return (new String(chars)).replace('\u0000', ' ').trim();
    }

    private void writeFixedLengthString(String s, int length) throws IOException {
        StringBuffer sb = new StringBuffer(s);
        sb.setLength(length);
        this.writeChars(sb.toString());
    }
}
