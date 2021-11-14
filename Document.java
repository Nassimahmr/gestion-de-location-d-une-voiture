package location;


public class Document {



    public Document(int numDoc,int numC ,  String type) {
        super();
        this.numDoc = numeroDoc;
        this.type = type;
        this.numC = numeroC ;
    }


    private int numeroDoc;
    private int numeroC;
    private String type;

    public int getNumeroDoc() {
        return numeroDoc;
    }

    public void setNumeroDoc(int numDoc) {
        this.numDoc = numeroDoc;
    }
    public int getNumeroC() {
        return numeroC;
    }
    public void setNumeroC(int numC) {
        this.numC = numeroC;
    }
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }



}
