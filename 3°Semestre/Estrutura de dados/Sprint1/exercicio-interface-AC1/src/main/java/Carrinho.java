import java.util.ArrayList;
import java.util.List;

public class Carrinho {
    private List<Vendavel> cart;

    public Carrinho() {
        this.cart = new ArrayList<>();
    }

    public void adicionaVendavel(Vendavel v){
        cart.add(v);
    }

    public Double calculaTotalVenda(){
        double total = 0.0;
        for (Vendavel item: cart){
            total += item.getValorVenda();
        }
        return total;
    }

    public void exibeItensCarrinho(){
        for (Vendavel item: cart){
            System.out.println(item);
        }
    }
}
