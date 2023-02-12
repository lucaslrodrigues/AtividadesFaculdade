package lucas.dia3;

/**
 *
 * @author Lucas
 */
public class DoubleKey {
    private String key1, key2;
    
    // Construtor sem argumentos
    public DoubleKey(){
        key1 = "123";
        key2 = "456";
    }
    
    // Construtor com argumentos
    public DoubleKey (String key1, String key2){
        this.key1 = key1;
        this.key2 = key2;
    }
    
    // Acessor
    public String getKey1(){
        return key1;
    }
    
    // Mutante
    public void setKey1 (String key1){
        this.key1 = key1;
    }
    
    // acessor
    public String getKey2(){
        return key2;
    }
    
    // mutante
    public void setKey2 (String key2){
        this.key2 = key2;
    }
}
