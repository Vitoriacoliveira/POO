import java.util.List;
import java.util.ArrayList;

interface ComponenteGUI{
    void renderizar(); 
    void renderizar(String identacao);


}

class Botao implements ComponenteGUI{
    private String rotulo;

    public Botao(String rotulo){
        this.rotulo = rotulo;
    }

    public void renderizar(){
        renderizar("");
    }

    public void renderizar(String identacao){
        System.out.println(identacao+"Botao:"+rotulo);
    }
}

class Texto implements ComponenteGUI{
    private String conteudo;

    public Texto(String conteudo){
        this.conteudo= conteudo;
    }

    public void renderizar(){
        renderizar("");
    }

    public void renderizar(String identacao){
        System.out.println(identacao+"Texto:"+conteudo);
    }
}

class Painel implements ComponenteGUI{
    private List<ComponenteGUI>  filhos = new ArrayList<>();

    public void adicionar(ComponenteGUI componente){
        filhos.add(componente);
    }

    public void renderizar(){
        renderizar("");
    }

    public void renderizar(String identacao){
        System.out.println(identacao+"Painel:");
        for(ComponenteGUI filho : filhos){
            filho.renderizar(identacao+" ");
        }
    }
}

public class Main{
    public static void main(String[] args){
        Painel painelPrincipal = new Painel();
        painelPrincipal.adicionar(new Botao("Salvar"));
        painelPrincipal.adicionar(new Texto("Bem-Vindo"));

        Painel painelInterno= new Painel();
        painelInterno.adicionar(new Botao("Cancelar"));
        painelInterno.adicionar(new Texto("Mensagem interna"));
        painelPrincipal.adicionar(painelInterno);

        painelPrincipal.renderizar();
    }
}