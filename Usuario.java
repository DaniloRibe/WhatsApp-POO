
package model;

import java.util.ArrayList;
import java.util.List;

public class Usuario {
    private String username;
    List <Grupo> grupos = new ArrayList<>();
    
    public Usuario(String username){
        this.username = username;
    }
    
    public Usuario(){    
    }
    
    public String getUsername(){
        return this.username;
    }
    
    public void setUsername(String username){
        this.username = username;
    }
    
    public String toString(){
        return this.username;
    }
    
    public boolean existeEsteGrupo(String nome){
        boolean a = false;
        for (Grupo g: grupos){
            if (g.getNome().equals(nome)){
                a=true;
            }
        }
        return a;
    }
    
}
