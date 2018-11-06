
package exec;

import java.util.Scanner;
import model.Relacoes;

public class Principal {

    public static Scanner in = new Scanner(System.in);

    public static void main(String args[]) {

        
        Relacoes r = new Relacoes();
        
        String help = "===========================HELP================================= \n"+
                      "addUser: cria um usuário \n"+
                      "allUsers: mostra todos os usuários \n"+
                      "newChat: cria um novo grupo, repassando o criador e nome do grupo \n"+
                      "chats: mostra todos os grupos de um determinado usuário \n"+
                      "users: mostra todos os usuários de um determinado grupo \n"+
                      "invite: adiciona um usuário existente a um grupo \n"+
                      "leave: sai de um determinado grupo \n"+
                      "================================================================ \n";
                      

        while (true) {
            System.out.println("Digite um comando (help para mostrar os comandos): ");
            String comando = in.nextLine();
            if (comando.equals("sair")){
                break;
            }
            switch (comando) {
                case "help":
                    System.out.println(help);
                    break;
                case "addUser":
                    System.out.print("Digite o nome do usuario: ");
                    String nome = in.nextLine();
                    r.addUser(nome);
                    break;
                case "allUsers":
                    r.allUsers();
                    break;
                case "newChat":
                    System.out.print("Digite o nome do usuario: ");
                    String user = in.nextLine();
                    System.out.print("Digite o nome do grupo: ");
                    String grupo = in.nextLine();
                    r.newChat(user, grupo);
                   
                    break;
                case "allChats":
                    r.allChats();
                    break;
                case "chats":
                    System.out.print("Digite o nome do usuario: ");
                    String usu = in.nextLine();
                    r.chats(usu);
                    break;
                case "users":
                    System.out.print("Digite o nome do grupo: ");
                    String gru = in.nextLine();
                    r.users(gru);
                    break;
                case "invite":
                    System.out.print("Nome do usuario para adicionar: ");
                    String name = in.nextLine();
                    System.out.print("Nome do convidado para adicionar: ");
                    String guest = in.nextLine();
                    System.out.print("Nome do grupo para adicionar: ");
                    String group = in.nextLine();
                    r.invite(name, guest, group);
                    break;
                case "leave":
                    System.out.print("nome do usuario para remover: ");
                    String re = in.nextLine();
                    System.out.print("nome do grupo: ");
                    String gr = in.nextLine();
                    r.leave(re, gr);
                    break;
                default:
                    System.out.println("Comando invalido");
            }
        }
    }
}
