
package model;

public class Relacoes {
    Usuario u = new Usuario();
    Grupo g = new Grupo();
    
    public void addUser(String usuario){
        Usuario us = new Usuario(usuario);
        g.usuarios.add(us);
        System.out.println("done");
    }
    
    public void allUsers(){
        System.out.println(g.usuarios);
    }
    
    public void allChats(){
        System.out.println(u.grupos);
    }
    
    public void newChat(String usuario, String grupo){
        if (!u.existeEsteGrupo(grupo)&& g.existeEsteUsuario(usuario)){
            Grupo gru = new Grupo(grupo);
            Usuario user = new Usuario(usuario);
            u.grupos.add(gru);
            gru.usuarios.add(user);
            for(Usuario us: g.usuarios){
                if(us.getUsername().equals(usuario)){
                    us.grupos.add(gru);
                    System.out.println("Grupo "+grupo+" criado");
                    break;
                }
                
            }
        }else{
            System.out.println("Grupo já existente ou usuário não encontrado");
        }
        
    }
    
    
    public void chats(String usuario){
        for (Usuario user: g.usuarios){
            if(user.getUsername().equals(usuario)){
                System.out.println(user.grupos);
                break;
            }else{
                System.out.println("usuario não encontrado");
            }
        }
    }
    
    public void users (String grupo){
        for (Grupo group: u.grupos){
            if(group.getNome().equals(grupo)){
                System.out.println(group.usuarios);
            }else{
                System.out.println("Grupo não encontrado");
            }
        }
    }
    
    public void invite(String usuario,String adicionado, String grupo){
        if (g.existeEsteUsuario(usuario)&&g.existeEsteUsuario(adicionado)&&u.existeEsteGrupo(grupo)){
            for(Grupo gru: u.grupos){
                if(gru.getNome().equals(grupo)&&gru.existeEsteUsuario(usuario)){
                    Usuario user = new Usuario(adicionado);
                    gru.usuarios.add(user);
                    
                    for(Usuario us: g.usuarios){
                        if(us.getUsername().equals(adicionado)){
                            us.grupos.add(gru);
                        }
                    }
                }
            }
        }else{
            System.out.println("usuario, convidado ou grupo não existente");
        }
    }
    
    public void leave(String nome, String grupo){
        Grupo n = null;
        if(g.existeEsteUsuario(nome)&&u.existeEsteGrupo(grupo)){
            for(Grupo gr: u.grupos){
                if(gr.getNome().equals(grupo)){
                    for(Usuario us: gr.usuarios){
                        if (us.getUsername().equals(nome)){
                            gr.usuarios.remove(us);
                            break;
                        }
                    }
                }
            }
            
            for (Usuario usua: g.usuarios){
                if (usua.getUsername().equals(nome)){
                    for(Grupo grup: usua.grupos){
                        if(grup.getNome().equals(grupo)){
                            usua.grupos.remove(grup);
                            break;
                        }
                    }
                }
            }
            System.out.println("removido");
        }else{
            System.out.println("Usuário ou grupo não encontrado");
        }
    }
}
