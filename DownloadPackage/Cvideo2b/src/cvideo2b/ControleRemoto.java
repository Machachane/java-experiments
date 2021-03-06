
package cvideo2b;

public class ControleRemoto implements Controlador {
    
    //--------------------------------------------------- ATRIBUTES 
    
    private int volume;
    private boolean ligado;
    private boolean tocando;
    
    //------------------------------------------------------ CONSTRUCTOR
    
    public ControleRemoto(){
        
        this.volume = 50;
        this.tocando = false;
        this.ligado = false;
    }
    
    //--------------------------------------- GETTERS AND SETTERS
    
    private int getVolume(){
        return this.volume;
    }
    
    private void setVolume(int v){
        this.volume = v;
    }
    
    private boolean getLigado(){
        return this.ligado;
    }
    
    private void setLigado(boolean l){
        this.ligado = l;
    }
    
    private boolean getTocando(){
        return this.tocando;
    }
    
    private void setTocando(boolean t){
        this.tocando = t;
    }
    
    //------------------------------------------------------ METHODS

    @Override
    public void ligar() {
        this.setLigado(true);
    }

    @Override
    public void desligar() {
        this.setLigado(false);
    }

    @Override
    public void abrirMenu() {
        System.out.println("-------- MENU --------");
        System.out.println("Esta ligado? " + this.getLigado());
        System.out.println("Esta tocando? " + this.getTocando());
        System.out.print("Volume: " + this.getVolume());
        for(int i = 0; i<this.getVolume(); i+=10){
            System.out.print(" |");
        }
        System.out.println("");
    }

    @Override
    public void fecharMenu() {
        System.out.println("Fechando Mennu...");
    }

    @Override
    public void maisVolume() {
        if(this.getLigado() == true){
            this.setVolume(this.getVolume() + 5);
        }
        else{
            System.out.println("ERRO - Impossivel aumentar volume");
        }
    }

    @Override
    public void menosVolume() {
        if(this.getLigado() == true){
            this.setVolume(this.getVolume() - 5);
        }
        else{
            System.out.println("ERRO - Impossivel diminuir volume");
        }
    }

    @Override
    public void ligarMudo() {
        if(this.getLigado() && this.getVolume() > 0){
            this.setVolume(0);
        }
    }

    @Override
    public void desligarMucdo() {
        if(this.getLigado() && this.getVolume() == 0){
            this.setVolume(50);
        }
    }

    @Override
    public void play() {
        if(this.getLigado() && !(this.getTocando())){
            this.setTocando(true);
        }
        else{
            System.out.println("ERRO - Impossivel reproduzir");
        }
    }

    @Override
    public void pause() {
        if(this.getLigado() && this.getTocando()){
            this.setTocando(false);
        }
        else{
            System.out.println("ERRO - Impossivel pausar");
        }
    }
    
    
}
