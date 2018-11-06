
package model;

import java.util.ArrayList;
import java.util.List;

public class Grupo {
    private String nome;
    public List <Usuario> usuarios = new ArrayList<>();
    
    public Grupo(String nome){
        this.nome = nome;
    }
    
    public Grupo(){    
    }
    
    public String getNome(){
        return this.nome;
    }
    
    public void setNome(String nome){
        this.nome = nome;
    }
    
    public String toString(){
        return this.nome;
    }
    
    public boolean existeEsteUsuario(String user){
        boolean i = false;
        for (Usuario u: usuarios){
            if (u.getUsername().equals(user)){
                i = true;
            }
        }
        return i;
    }
}
