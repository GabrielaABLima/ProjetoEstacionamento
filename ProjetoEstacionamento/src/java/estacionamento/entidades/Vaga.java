/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package estacionamento.entidades;

/**
 *
 * @author Gabi
 */
public class Vaga {
    private boolean disponivel;
    private int id;
    private AutomovelType tipo;
    

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public AutomovelType getTipo() {
        return tipo;
    }

    public void setTipo(AutomovelType tipo) {
        this.tipo = tipo;
    }
    
    
}
