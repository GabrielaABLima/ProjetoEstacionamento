/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package estacionamento.entidades;

/**
 *
 * @author Gabi
 */
public class Cliente extends Usuario{
    
    private int id;
    private String nome;
    private int cartaMotorista;

    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCartaMotorista() {
        return cartaMotorista;
    }

    public void setCartaMotorista(int cartaMotorista) {
        this.cartaMotorista = cartaMotorista;
    }
    
    
}
