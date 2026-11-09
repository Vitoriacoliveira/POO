interface Sorvete {
    String getDescricao();
    double getPreco();
}
 

class SorveteSimples implements Sorvete {
    @Override
    public String getDescricao() {
        return "Sorvete de baunilha";
    }
 
    @Override
    public double getPreco() {
        return 5.00;
    }
}

abstract class SorveteDecorator implements Sorvete{
    protected final Sorvete sorvete;
    SorveteDecorator(Sorvete sorvete){
        this.sorvete = sorvete;
    }

    @Override
    public String getDescricao(){
        return  sorvete.getDescricao();
    }

    @Override
    public double getPreco(){
        return sorvete.getPreco();
    }
}

class CoberturaChocolate extends SorveteDecorator{
    public CoberturaChocolate(Sorvete sorvete){
        super(sorvete);
    }

    @Override
    public String getDescricao(){
        return  sorvete.getDescricao() + " + cobertura de chocolate";
    }

    @Override
    public double getPreco(){
        return sorvete.getPreco() +1.50;
    }

}

class CoberturaCaramelo extends SorveteDecorator{
    public CoberturaCaramelo(Sorvete sorvete){
        super(sorvete);
    }

    @Override
    public String getDescricao(){
        return  sorvete.getDescricao() + " + cobertura de caramelo";
    }

    @Override
    public double getPreco(){
        return sorvete.getPreco() +1.20;
    }

}

class GranuladoColorido extends SorveteDecorator{
    public GranuladoColorido(Sorvete sorvete){
        super(sorvete);
    }

    @Override
    public String getDescricao(){
        return  sorvete.getDescricao() + " + granulado colorido";
    }

    @Override
    public double getPreco(){
        return sorvete.getPreco() +0.80;
    }

}




class ChantillyExtra extends SorveteDecorator{
    public ChantillyExtra(Sorvete sorvete){
        super(sorvete);
    }

    @Override
    public String getDescricao(){
        return  sorvete.getDescricao() + " + chantilly extra";
    }

    @Override
    public double getPreco(){
        return sorvete.getPreco() +1.00;
    }

}


public class Main {
 
    private static void imprimir(Sorvete s) {
        System.out.println(s.getDescricao()+ " - R$" + String.format("%.2f", s.getPreco()));
    }
 
    public static void main(String[] args) {
        
        Sorvete pedido1 = new SorveteSimples();
        pedido1 = new CoberturaChocolate(pedido1);
        pedido1 = new GranuladoColorido(pedido1);
        pedido1 = new ChantillyExtra(pedido1);
        imprimir(pedido1);
 
        
        Sorvete pedido2 = new SorveteSimples();
        pedido2 = new ChantillyExtra(pedido2);
        pedido2 = new CoberturaCaramelo(pedido2);
        pedido2 = new CoberturaChocolate(pedido2);
        imprimir(pedido2);
 
    }
}
 